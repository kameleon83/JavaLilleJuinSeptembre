package com.formation.tpHeritagePoly;

public class Exercice1{

}

class Personne {
    private String nom;
    Personne(String nom){
        this.nom = nom;
    }
    public void affiche(){
        System.out.printf("Mon nom est : %s%n", this.nom);
    }
}

class Menuisier extends Personne{
    Menuisier(String nom){
        super(nom);
    }
}

class Plombier extends Personne{
    Plombier(String nom){
        super(nom);
    }
}

class TestMetiers {
    public static void main(String[] argv) {
        Personne[] personnes = new Personne[3];
        personnes[0] = new Menuisier("Samuel");
        personnes[1] = new Plombier("Julien");
        personnes[2] = new Menuisier("Suzy");
        for (int i = 0; i < personnes.length; i++)
            personnes[i].affiche();
    }
}

