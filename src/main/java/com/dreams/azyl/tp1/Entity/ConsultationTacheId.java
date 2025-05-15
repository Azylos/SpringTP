package com.dreams.azyl.tp1.Entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ConsultationTacheId implements Serializable {

    private Long utilisateurId;
    private Long tacheId;

    public ConsultationTacheId() {}

    public ConsultationTacheId(Long utilisateurId, Long tacheId) {
        this.utilisateurId = utilisateurId;
        this.tacheId = tacheId;
    }

    public Long getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public Long getTacheId() {
        return tacheId;
    }

    public void setTacheId(Long tacheId) {
        this.tacheId = tacheId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConsultationTacheId that)) return false;
        return Objects.equals(utilisateurId, that.utilisateurId) &&
                Objects.equals(tacheId, that.tacheId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(utilisateurId, tacheId);
    }
}
