package com.formation.tpHeritagePoly;

public class Exercice2 {
}

class Oeuvre {
    // les attributs
    protected String titre, auteur, proprietaire ;
    protected double prix ;
//le constructeur avec comme paramètre le titre,l'auteur et le prix
    //l'attribut proprietaire est initialisé
    public Oeuvre(String t, String a, double p){
        titre = t ; auteur = a ; prix = p ; proprietaire = "";
    }
    //une oeuvre est neuve si elle n'a pas encore de propriétaire
//d'où l'intérêt de l'initialisation dans le constructeur
    public boolean Est_neuf() {
        if ( proprietaire == "" ) return true ;
        else return false ;
    }
    //affiche les informations sur l'oeuvre
    public void Afficher() {
        System.out.println("Titre : " + titre) ;
        System.out.println("Auteur : " + auteur) ;
        System.out.println("Prix : " + prix) ;
        if (this.Est_neuf())
            System.out.println("Aucun proprietaire" );
        else
            System.out.println("Proprietaire : "+proprietaire);
        System.out.println() ;
    }
    //la méthode acheter donne un nom de propriét. à l'objet
    public void Acheter(String nom) {proprietaire = nom ;}
}
//La classe Film hérite de la classe Oeuvre
class Film extends Oeuvre {
    //un seul attribut supplémentaire:la durée du film en mn
    protected int durée ;
    //le constructeur de cette classe appelle celui de la
//classe supérieure c'est-à-dire de la classe Oeuvre
    public Film(String t, String a, double p, int d){
        super(t,a,p) ;
        durée = d ;
    }
    //la méthode revente modifie simplement le propriétaire et le prix du livre
    public void Revendre(String acheteur,double prix_occas){
        proprietaire = acheteur ;
        prix = prix_occas ;
    }
    public String Proprietaire() {
        return (proprietaire) ;
    }
}

// La classe Livre hérite de la classe Oeuvre
class Livre extends Oeuvre {
    //un seul attribut supplémentaire: nombre pages du livre
    protected int nb_pages ;
//le constructeur de cette classe appelle celui de la
// classe supérieure c'est-à-dire de la classe Oeuvre
public Livre(String t, String a, double p, int nb){
    super(t,a,p) ;
    nb_pages = nb ;
}
    //la méthode revente modifie simplement le
// propriétaire et le prix du livre
    public void Revendre(String acheteur,double prix_occas){
        proprietaire = acheteur ;
        prix = prix_occas ;
    }
    public String Proprietaire() {
        return (proprietaire) ;
    }
}
//La classe BD hérite de la classe Livre
class BD extends Livre {
    // un seul attribut supplémentaire : un booléen qui
// définit si la BD est en couleur ou non
    private boolean encouleur ;
    //Le constructeur qui appelle celui de la classe Livre
//et donc celui de la classe Oeuvre
    public BD(String t,String a,double p,int n,boolean c){
        super(t,a,p,n) ;
        encouleur = c ;
    }
    //La méthode qui échange les noms des propriétaires si
//le prix des BD est identique
    public void Echanger(BD b) {
        if (this.prix==b.prix){
            System.out.println("Prix égaux:échange possible" );
            String ProTmp = this.proprietaire;
            this.proprietaire = b.proprietaire ;
            b.Acheter(ProTmp) ;
        } else // ne pas échanger les BD
            System.out.println("Prix différents:échange impossible");
    }
}

//La classe Album qui hérite de Livre
class Album extends Livre {
    //un seul attribut supplémentaire : un tableau de
//booléen de la taille du nombre de pages
//définit si la page a été lue ou non
    boolean page_coloriee[] ;
    //le constructeur qui appelle celui de Livre
//Notons que la taille du tableau de booléen est
//initialisée dans ce constructeur en fonction des
//paramètres passés au constructeur
    public Album(String t, String a, double p, int nb){
        super(t,a,p, nb) ;
        page_coloriee = new boolean[nb] ;
        int i ;
        for (i=0 ; i<nb ; i++)
            page_coloriee[i] = false ;
    }
    //la méthode qui colorie une page : mettre à vrai la
//valeur du tabelau page_coloriée si ce n'a pas été fait
    public void Colorie(int num_page){
        if ((page_coloriee[num_page] == false) && !Est_neuf())
            page_coloriee[num_page] = true ;
        else {
            System.out.println("page "+num_page+" deja coloriee");
            System.out.println();
        }
    }
}
//la classe principale d'appel
class TestExercice2 {
    public static void main(String[] args) {
        //création de deux variables de type Livre
        Livre l1 = new Livre("Le petit prince","St Exupéry",10.40, 30) ;
                Livre l2 = new Livre("Contes","Grimm",14.40, 250) ;
        //on affiche les caractéristiques de chacun
        l1.Afficher() ;
        l1.Acheter("moi") ;
        l1.Afficher() ;
        l1.prix = 0.0 ;
        l2.Acheter("lui") ;
        l2.Afficher();
        //création de deux variables de type BD
        BD b1 = new BD("Lucky Luke","Morris",10.40, 45, true);
        BD b2 = new BD("Tintin","Herge",200.40, 50, false) ;
        // "moi" achete deux BD b1 et b2
        b1.Acheter("moi");
        b1.Afficher() ;
        b2.Acheter("moi");
        b2.Afficher() ;
        // "moi" revend à "lui" b2
        b2.Revendre("lui",10.4);
        b2.Afficher() ;
        //on teste la fonction d'échange de b1 et b2
        b1.Echanger(b2) ;
        System.out.println("APRES ECHANGE DE "
                +b1.titre+" et "+b2.titre) ;
        b1.Afficher();
        b2.Afficher() ;
        //on teste si la méthode de coloriage d'une page
        //fonctionne
        Album a1 = new Album("Dora","Dora",3.5, 200) ;
        a1.Afficher() ;
        a1.Colorie(23) ;
        a1.Acheter("moi");
        a1.Colorie(23) ;
        // On crée un objet film
        Film f = new Film("Taxi","Besson",20,90);
        f.Afficher();
    }
}