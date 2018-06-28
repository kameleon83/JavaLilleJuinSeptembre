package com.formation;

public class Societe {
    private String nom;
    private Adresse adresse;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void affiche(){
        System.out.println("Le nom de mon entreprise est " + this.nom + " à l'adresse : "
        + this.adresse.getNumRue() + " " + this.adresse.getNomDeRue() + " dans la ville de : "
                + this.adresse.getNomVille());
    }

    @Override
    public String toString() {
        return "Societe{" +
                "nom='" + nom + '\'' +
                ", adresse=" + adresse.toString() +
                '}';
    }
}
