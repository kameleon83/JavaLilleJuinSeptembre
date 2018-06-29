package com.formation;

import java.util.ArrayList;
import java.util.List;

public class EcoleTest {
    public static void main(String[] args) {

        Eleve eleve = new Eleve();
        eleve.setAge((byte) 36);
        eleve.setAnnee((byte) 1);
        eleve.setNom("Michaux");
        eleve.setPrenom("Samuel");

        Eleve eleve1 = new Eleve();
        eleve1.setAge((byte) 23);
        eleve1.setAnnee((byte) 2);
        eleve1.setNom("Troch");
        eleve1.setPrenom("Joel");

        List<Eleve> eleveList = new ArrayList<>();
        eleveList.add(eleve);
        eleveList.add(eleve1);

        Cours cours = new Cours();
        cours.setAnnee((byte) 1);
        cours.setHeure((short) 399);
        cours.setNom("Java");

        Cours cours1 = new Cours();
        cours1.setAnnee((byte) 2);
        cours1.setHeure((short) 35);
        cours1.setNom("Angular");

        List<Cours> coursList = new ArrayList<>();
        coursList.add(cours);
        coursList.add(cours1);

        Ecole ecole = new Ecole();
        ecole.setName("M2I");
        ecole.setCoursList(coursList);
        ecole.setEleveList(eleveList);

        ecole.eleves();

    }
}
