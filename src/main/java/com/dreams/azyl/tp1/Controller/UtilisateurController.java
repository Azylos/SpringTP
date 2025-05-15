package com.dreams.azyl.tp1.Controller;

import com.dreams.azyl.tp1.Entity.Utilisateur;
import com.dreams.azyl.tp1.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @PutMapping("/{id}/inscription")
    private ResponseEntity<String> inscription(@PathVariable Long id) {

        Utilisateur utilisateur = utilisateurRepository.findById(id).orElse(null);

        if (utilisateur == null) {
            return ResponseEntity.status(404).build();
        }

        if (utilisateur.getInscrit() == null) {
            utilisateur.setInscrit(true);
            utilisateurRepository.save(utilisateur);
            return ResponseEntity.ok("Utilisateur inscrit avec succès");
        } else {
            return ResponseEntity.status(400).body("Utilisateur déjà inscrit");
        }
    }
}
