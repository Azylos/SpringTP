package com.dreams.azyl.tp1.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "utilisateur_taches")
public class ConsultationTache {

    @EmbeddedId
    private ConsultationTacheId id;

    @ManyToOne
    @MapsId("utilisateurId")
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @MapsId("tacheId")
    @JoinColumn(name = "taches_id")
    private Tache tache;

    private int nbVue = 0;

    private LocalDateTime derniereVue;

    public ConsultationTache() {}

    public ConsultationTache(Utilisateur utilisateur, Tache tache, int nbVue, LocalDateTime derniereVue) {
        this.id = new ConsultationTacheId(utilisateur.getId(), tache.getId());
        this.utilisateur = utilisateur;
        this.tache = tache;
        this.nbVue = nbVue;
        this.derniereVue = derniereVue;
    }

    public ConsultationTacheId getId() {
        return id;
    }

    public void setId(ConsultationTacheId id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }

    public int getNbVue() {
        return nbVue;
    }

    public void setNbVue(int nbVue) {
        this.nbVue = nbVue;
    }

    public LocalDateTime getDerniereVue() {
        return derniereVue;
    }

    public void setDerniereVue(LocalDateTime derniereVue) {
        this.derniereVue = derniereVue;
    }
}
