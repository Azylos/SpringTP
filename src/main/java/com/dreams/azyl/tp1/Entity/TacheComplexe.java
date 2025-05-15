package com.dreams.azyl.tp1.Entity;

import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class TacheComplexe extends Tache {
    private List<String> etapes;
    private Integer progression;
    private String bloquePar;

    public List<String> getEtapes() {
        return etapes;
    }

    public void setEtapes(List<String> etapes) {
        this.etapes = etapes;
    }

    public Integer getProgression() {
        return progression;
    }

    public void setProgression(Integer progression) {
        this.progression = progression;
    }

    public String getBloquePar() {
        return bloquePar;
    }

    public void setBloquePar(String bloquePar) {
        this.bloquePar = bloquePar;
    }
}
