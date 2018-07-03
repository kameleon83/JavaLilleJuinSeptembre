package com.formation;

import java.util.ArrayList;
import java.util.List;

public class Ecole {
    private List<Eleve> eleveList;
    private List<Cours> coursList;
    private String name;

    public Ecole(){
        coursList = new ArrayList<>();
        eleveList = new ArrayList<>();
    }

    public void eleves() {
        for (Eleve eleve : this.eleveList) {
            for (Cours cours : this.coursList) {
                if (eleve.getAnnee().equals(cours.getAnnee())) {
                    System.out.printf("Pour le cours de %s : nous avons l'élève :%n",cours.getNom());
                    System.out.println("    - " + eleve.getNom());
                }
            }
        }
    }

    public List<Eleve> getEleveList() {
        return eleveList;
    }

    public void setEleveList(List<Eleve> eleveList) {
        this.eleveList = eleveList;
    }

    public List<Cours> getCoursList() {
        return coursList;
    }

    public void setCoursList(List<Cours> coursList) {
        this.coursList = coursList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
