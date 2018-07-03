package com.formation.tpHeritagePoly;

public class Exercice3 {
}

abstract class Emission {
    protected String nom;
    protected int heure_debut, heure_fin;

    public abstract boolean programmer(int heure);

    public Emission() {
        heure_debut = heure_fin = -1;
    }

    public boolean programmee() {
        if (heure_debut != -1)
            return true;
        else
            return false;
    }

    public int Debut() {
        return heure_debut;
    }

    public int Fin() {
        return heure_fin;
    }

    public void Affiche() {
        System.out.println("===============");
        System.out.println("Emission :" + nom);
        if (heure_debut != -1)
            System.out.println(" Emission programmée à " + heure_debut);
    }
}

class Fiction extends Emission {
    private String realisateur;
    private boolean rediffusion;
    private int duree, annee;

    public Fiction(String n, String real, boolean redif, int d) {
        nom = n;
        realisateur = real;
        rediffusion = redif;
        duree = d;
// heure_debut = heure_fin = -1 ;
    }

    public void Affiche() {
        super.Affiche();
        System.out.println("Réalisateur :" + realisateur);
        System.out.println("Duree :" + duree);
        System.out.println("Année de réalisation :" + annee);
        if (rediffusion)
            System.out.println("C'est une rediffusion");
    }

    public boolean programmer(int heure) {
        if (rediffusion || heure == 21) {
            heure_debut = heure;
            heure_fin = heure + duree;
            return true;
        } else
            return false;
    }
}

class Divertissement extends Emission {
    private String animateur ;
    private static final int duree = 2 ;
    public Divertissement(String n, String anim) {
        nom = n ; animateur = anim ;
        // heure_debut = heure_fin = -1 ;
    }
    public void Affiche(){
        super.Affiche() ;
        System.out.println("Animateur :" + animateur) ;
        System.out.println("Durée :" + duree) ;
    }
    public boolean programmer(int heure) {
        if ( heure >= 18 && heure <= 21) {
            heure_debut = heure ;
            heure_fin = heure + duree ;
            return true ;
        } else {
            return false ;
        }
    }
}

class Reportage extends Emission {
    private static final String theme[]
            = {"Information", "Animalier", "Culturel"};
    private int duree, type_theme;

    public Reportage(String n, int t, int d) {
        nom = n;
        type_theme = t;
        duree = d;
    }

    public void Affiche() {
        super.Affiche();
        switch (type_theme) {
            case 1:
                System.out.println("Theme :" + theme[1]);
                break;
            case 2:
                System.out.println("Theme :" + theme[2]);
                break;
            case 3:
                System.out.println("Theme :" + theme[3]);
                break;
        }
        System.out.println("Duree :" + duree);
    }

    public boolean programmer(int heure) {
        if (duree == 1 && ((heure >= 14 && heure <= 18) || (heure >= 0 && heure <= 6))) {
            heure_debut = heure;
            heure_fin = heure + duree;
            return true;
        } else {
            return false;
        }
    }
}

class Test {
    public static void main(String[] args) {
        int i;
        System.out.println("//////////////// ");
        System.out.println(" Question 2 : création et test de variables ");
        System.out.println("//////////////// ");

        System.out.println("emission non programmée");
        Divertissement em1 = new Divertissement("La roue de la fortune", "Foucault");

        if (em1.programmer(20))
            System.out.println("ok emission programmée");
        else
            System.out.println("emission non programmée");

        Fiction em2 = new Fiction("Citizen Kane", "Wells", true, 3);
        if (em2.programmer(17))
            System.out.println("ok emission programmée");
        else
            System.out.println("emission non programmée") ;

        Reportage em3 = new Reportage("Voiture de luxe", 1, 1);
        if (em3.programmer(5))
            System.out.println("ok emission programmée");
        else
            System.out.println("emission non programmée");

        Reportage em4 = new Reportage("Bricolage", 1, 1);
        if (em4.programmer(18))
            System.out.println("ok emission programmée");
        else
            System.out.println("emission non programmée");

        int nb_max = 24; // nbre maximum d émissions dans une journée
        Emission programme[] = new Emission[nb_max];

        programme[0] = em1;
        programme[1] = em2;
        programme[2] = em3;
        programme[3] = em4;
        int nbEmissions = 4;

        System.out.println("//////////////// ");
        System.out.println(" Question 4 a ");
        System.out.println("//////////////// ");
        for (i = 0; i < nbEmissions; i++) {
            if (programme[i].programmee())
                programme[i].Affiche();
        }
        System.out.println("//////////////// ");
        System.out.println(" Question 4 b ");
        System.out.println("//////////////// ");

        //on évite de traiter toutes les paires d'émission en cochant
        //et donc stockant dans un tableau les plages utilisées

        boolean[] plage = new boolean[24];
        /// initialisation du tableau à faux
        for (i = 0; i < 24; i++) plage[i] = false;
        /// parcours de toutes les émissions
        for (i = 0; i < nbEmissions; i++)
            if (programme[i].programmee()) {
                System.out.println("plage : " + programme[i].Debut());
                for (int j = programme[i].Debut(); j < programme[i].Fin(); j++)
                    if (plage[j] == false) plage[j] = true;
                    else System.out.println("attention : superposition sur la plage " + j);
            }
        System.out.println("//////////////// ");
        System.out.println(" Question 4 c ");
        System.out.println("//////////////// ");
        // On suppose aucune superposition
        int[] plage2 = new int[24];
        /// initialisation du tableau à -1
        for (i = 0; i < 24; i++) plage2[i] = -1;
        /// parcours de toutes les émissions
        for (i = 0; i < nbEmissions; i++) {
            if (programme[i].programmee()) {
                System.out.println("plage : " + programme[i].Debut());
                for (int j = programme[i].Debut(); j < programme[i].Fin(); j++)
                    plage2[j] = i;
            }
        }
        // l'affichage des 24 plages
        System.out.println("PLANNING GENERAL");

        for (i = 0; i < 24; i++) {
            System.out.println("Plage :" + i);
            if (plage2[i] != -1)
                programme[plage2[i]].Affiche();
            else
                System.out.println("Aucune émission");
        }
    }
}