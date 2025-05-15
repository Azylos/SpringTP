package com.dreams.azyl.tp1.Entity;

import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class TachePrive extends Tache{
    private Boolean rappel;
    private Date dateRappel;
}
