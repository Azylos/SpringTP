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

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/taches")
public class TacheController {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private TacheRepository tacheRepository;
    @Autowired
    private ConsultationTacheRepository consultationTacheRepository;

    @PostMapping
    @RequestMapping("/creer")
    public ResponseEntity<?> creerTache(@RequestBody Tache tache) {
        Utilisateur utilisateur = tache.getUtilisateur();

        if (utilisateur == null || utilisateur.getId() == null) {
            return ResponseEntity.badRequest().body("Utilisateur manquant");
        }

        Utilisateur inscrit = utilisateurRepository.findById(utilisateur.getId())
                .filter(Utilisateur::isInscrit)
                .orElse(null);

        if (inscrit == null) {
            return ResponseEntity.badRequest().body("Utilisateur non inscrit ou inexistant");
        }

        tache.setUtilisateur(inscrit);
        Tache savedTache = tacheRepository.save(tache);

        ConsultationTache consultation = new ConsultationTache(
                inscrit,
                savedTache,
                1,
                LocalDateTime.now()
        );

        consultationTacheRepository.save(consultation);

        return ResponseEntity.ok(savedTache);
    }

    @GetMapping("/list/utilisateur/{id}")
    public ResponseEntity<?> getTachesUtilisateur(@PathVariable Long id) {
        Utilisateur utilisateur = utilisateurRepository.findById(id).orElse(null);
        if (utilisateur == null) {
            return ResponseEntity.notFound().build();
        }
        Set<Tache> taches = utilisateur.getTaches().stream()
                .filter(t -> "EN_COURS".equals(t.getStatut()) || "VALIDER".equals(t.getStatut()))
                .collect(Collectors.toSet());
        return ResponseEntity.ok(taches);
    }
}
