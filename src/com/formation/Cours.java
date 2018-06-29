package com.formation;

import java.util.List;

public class Cours {
    private String nom;
    private Short heure;
    private Byte annee;



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Short getHeure() {
        return heure;
    }

    public void setHeure(Short heure) {
        this.heure = heure;
    }

    public Byte getAnnee() {
        return annee;
    }

    public void setAnnee(Byte annee) {
        this.annee = annee;
    }
}
