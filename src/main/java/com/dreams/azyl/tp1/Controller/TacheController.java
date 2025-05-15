package com.dreams.azyl.tp1.Controller;

import com.dreams.azyl.tp1.Entity.ConsultationTache;
import com.dreams.azyl.tp1.Entity.Tache;
import com.dreams.azyl.tp1.Entity.Utilisateur;
import com.dreams.azyl.tp1.Repository.ConsultationTacheRepository;
import com.dreams.azyl.tp1.Repository.TacheRepository;
import com.dreams.azyl.tp1.Repository.UtilisateurRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/taches")
public class TacheController {
    private final TacheRepository tacheRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final ConsultationTacheRepository consultationTacheRepository;

    public TacheController(TacheRepository tacheRepository, UtilisateurRepository utilisateurRepository, ConsultationTacheRepository consultationTacheRepository) {
        this.tacheRepository = tacheRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.consultationTacheRepository = consultationTacheRepository;
    }

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
                1, // première vue
                LocalDateTime.now()
        );

        consultationTacheRepository.save(consultation);

        return ResponseEntity.ok(savedTache);
    }
}
