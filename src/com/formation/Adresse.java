package com.formation;

public class Adresse {
    private String nomDeRue;
    private Integer numRue;
    private String nomVille;

    public Adresse(String nomDeRue, Integer numRue, String nomVille) {
        this.nomDeRue = nomDeRue;
        this.numRue = numRue;
        this.nomVille = nomVille;
    }

    public Adresse() {
    }

    public String getNomDeRue() {
        return nomDeRue;
    }

    public void setNomDeRue(String nomDeRue) {
        this.nomDeRue = nomDeRue;
    }

    public Integer getNumRue() {
        return numRue;
    }

    public void setNumRue(Integer numRue) {
        this.numRue = numRue;
    }

    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "nomDeRue='" + nomDeRue + '\'' +
                ", numRue=" + numRue +
                ", nomVille='" + nomVille + '\'' +
                '}';
    }
}
