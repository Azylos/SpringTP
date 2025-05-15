package com.dreams.azyl.tp1.Entity;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Utilisateur {
    @OneToMany(mappedBy = "utilisateur")
    private Set<ConsultationTache> consultations = new LinkedHashSet<>();


    @OneToMany(mappedBy = "utilisateur", orphanRemoval = true)
    private Set<Tache> taches = new LinkedHashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String pseudo;
    @Column(nullable = false)
    private boolean inscrit;

    public Set<Tache> getTaches() {
        return taches;
    }

    public void setTaches(Set<Tache> taches) {
        this.taches = taches;
    }

    public Utilisateur() {
    }

    public Utilisateur(Long id, String pseudo, Boolean inscrit) {
        this.id = id;
        this.pseudo = pseudo;
        this.inscrit = inscrit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Boolean isInscrit() {
        return inscrit;
    }

    public void setInscrit(boolean inscrit) {
        this.inscrit = inscrit;
    }

    public Set<ConsultationTache> getConsultations() {
        return consultations;
    }

    public void setConsultations(Set<ConsultationTache> consultations) {
        this.consultations = consultations;
    }
}
