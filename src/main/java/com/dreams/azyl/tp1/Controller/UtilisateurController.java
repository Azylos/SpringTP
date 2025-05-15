package com.dreams.azyl.tp1.Controller;

import com.dreams.azyl.tp1.Entity.ConsultationTache;
import com.dreams.azyl.tp1.Entity.Tache;
import com.dreams.azyl.tp1.Entity.Utilisateur;
import com.dreams.azyl.tp1.Repository.ConsultationTacheRepository;
import com.dreams.azyl.tp1.Repository.TacheRepository;
import com.dreams.azyl.tp1.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.stream.StreamSupport;
import java.util.stream.Collectors;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private ConsultationTacheRepository consultationTacheRepository;
    @Autowired
    private TacheRepository tacheRepository;

    @PutMapping("/{id}/inscription")
    private ResponseEntity<String> inscription(@PathVariable Long id) {

        Utilisateur utilisateur = utilisateurRepository.findById(id).orElse(null);

        if (utilisateur == null) {
            return ResponseEntity.status(404).build();
        }

        if (utilisateur.isInscrit() == null) {
            utilisateur.setInscrit(true);
            utilisateurRepository.save(utilisateur);
            return ResponseEntity.ok("Utilisateur inscrit avec succès");
        } else {
            return ResponseEntity.status(400).body("Utilisateur déjà inscrit");
        }
    }

    @GetMapping("/{id}/taches/associees/en-cours")
    public ResponseEntity<?> getTachesAssocieesEnCours(@PathVariable Long id) {
        List<ConsultationTache> consultations = consultationTacheRepository.findByUtilisateurId(id);
        List<Tache> enCours = consultations.stream()
                .map(ConsultationTache::getTache)
                .filter(t -> "EN_COURS".equalsIgnoreCase(t.getStatut()))
                .toList();
        return ResponseEntity.ok(enCours);
    }

    @PutMapping("/{id}/valid/{idTache}")
    private ResponseEntity<String> validTache(@PathVariable Long id, @PathVariable Long idTache) {

        Utilisateur utilisateur = utilisateurRepository.findById(id).orElse(null);
        Tache tache = tacheRepository.findById(idTache).orElse(null);

        if (utilisateur == null) {
            return ResponseEntity.status(404).build();
        }

        if (tache == null || tache.getStatut().equals("VALIDER")) {
            return ResponseEntity.status(404).body("Tache introuvable ou déjà valider");
        }

        if (tache.getUtilisateur().getId().equals(utilisateur.getId())) {
            tache.setStatut("VALIDER");
            tacheRepository.save(tache);
            return ResponseEntity.ok("Tache valider avec succès");
        } else {
            return ResponseEntity.status(400).body("L'utilisateur ne possède pas cette tache");
        }
    }
}
