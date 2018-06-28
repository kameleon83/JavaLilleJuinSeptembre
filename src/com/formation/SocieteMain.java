package com.formation;

public class SocieteMain {
    public static void main(String[] args) {
        Societe sc1 = new Societe();
        sc1.setNom("OlProG");
        Adresse ad1 = new Adresse("aguesseau", 18, "Lille");
        sc1.setAdresse(ad1);

        Societe sc2 = new Societe();
        sc2.setNom("jdejhhdfkrz");
        sc2.setAdresse(ad1);

        sc1.affiche();
        sc2.affiche();
    }
}
