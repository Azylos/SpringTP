package com.dreams.azyl.tp1.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class TachePrive extends Tache{
    @Column(nullable = false)
    private boolean rappel;
    private Date dateRappel;

    public boolean isRappel() {
        return rappel;
    }

    public void setRappel(boolean rappel) {
        this.rappel = rappel;
    }

    public Date getDateRappel() {
        return dateRappel;
    }

    public void setDateRappel(Date dateRappel) {
        this.dateRappel = dateRappel;
    }
}
