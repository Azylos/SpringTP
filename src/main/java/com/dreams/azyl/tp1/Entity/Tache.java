package com.dreams.azyl.tp1.Entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TachePrive.class, name = "prive"),
        @JsonSubTypes.Type(value = TacheDeleguee.class, name = "Deleguee"),
        @JsonSubTypes.Type(value = TacheComplexe.class, name = "complexe")
})
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titre;
    private String description;
    private String dateFin;
    private String statut;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "tache")
    private Set<ConsultationTache> consultations = new LinkedHashSet<>();

    public Tache() {
    }

    public Tache(Long id, String titre, String description, String dateFin, String statut, Utilisateur utilisateur, Set<ConsultationTache> consultations) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.dateFin = dateFin;
        this.statut = statut;
        this.utilisateur = utilisateur;
        this.consultations = consultations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Set<ConsultationTache> getConsultations() {
        return consultations;
    }

    public void setConsultations(Set<ConsultationTache> consultations) {
        this.consultations = consultations;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
