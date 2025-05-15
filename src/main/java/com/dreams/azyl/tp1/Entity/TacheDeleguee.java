package com.dreams.azyl.tp1.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class TacheDeleguee extends Tache{
    @OneToOne
    @JoinColumn(name = "utilisateur_deleguee_id")
    private Utilisateur utilisateurDeleguee;

    public Utilisateur getUtilisateurDeleguee() {
        return utilisateurDeleguee;
    }

    public void setUtilisateurDeleguee(Utilisateur utilisateurDeleguee) {
        this.utilisateurDeleguee = utilisateurDeleguee;
    }
}
