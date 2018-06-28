package com.formation;

//Exercices 1 :
//
//	Écrire une méthode sum qui prend comme paramètre un tableau d'entiers int d'une dimension et qui renvoie la somme des entiers contenus dans le tableau.
//	Voici la signature de la méthode :
//		public static int sum (int[] tab);
//
//Par exemple, l'appel sum (new int[] {1, 2, 3, 4, 5}); renvoie 15.

//Exercices 2 :
//
//	Écrire une méthode min qui prend comme paramètre un tableau de flottants double d'une dimension et qui renvoie le plus petit élément du tableau (celui qui a la valeur la plus petite).
//	Voici la signature de la méthode :
//		public static double min (double[] tab);
//
//	Par exemple, l'appel min(new double[] {-9.5, 1, -98.21, 218.2}); renvoie -98.21.

//Exercices 3 :
//
//	Écrire une méthode merge qui prend comme paramètre deux tableaux d'entiers int d'une dimension (tab1 et tab2) de longueurs quelconques. La méthode doit renvoyer un nouveau tableau d'entiers int qui contient les éléments des deux tableaux reçus en paramètre intercalés. Soit s1, s2, s3, ..., sm les éléments du premier tableau et t1, t2, t3, ..., tn les éléments du second tableau. Les éléments du tableau renvoyé sont s1, t1, s2, t2, s3, t3, .... Faites bien attention que les deux tableaux n'ont pas forcément la même longueur.
//
//Par exemple, l'appel merge (new int[] {1, 2, 3, 4}, new int[] {5, 6}); renvoie le tableau [1, 5, 2, 6, 3, 4].

public class TPJeudi28Juin {
    public static void main(String[] args) {
        Integer[] tab = {9,10,-9,50,-800};
        //Somme
        System.out.println(sum(tab));
        Double[] tab2 = {9.5,-20.7, 100.71, 26.87};
        System.out.println(min(tab2));
        affichage(merge(new Integer[]{1,2,3,4}, new Integer[]{5,6}));

    }


    public static int sum(Integer[] tab){
        int somme = 0;
        for (int i = 0; i < tab.length; i++) {
            somme += tab[i];
        }
        return somme;
    }

    public static Double min(Double[] tab){
        Double min = tab[0];
        for (int i = 0; i < tab.length; i++) {
            if (min > tab[i]) {
                min = tab[i];
            }
        }
        return min;
    }
    public static int max(Integer[] tab){
        int somme = 0;
        for (int i = 0; i < tab.length; i++) {
            somme += tab[i];
        }
        return somme;
    }

    public static Integer[] merge(Integer[] tab1,Integer[] tab2){
        Integer[] tab3 = new Integer[tab1.length + tab2.length];
        int global = 0;
        int iteTab = 0;

        while(global< tab3.length){
            if (iteTab < tab1.length){
                tab3[global++] = tab1[iteTab];
                //tab3[global] = tab1[iteTab];
                //global++;
            }
            if (iteTab < tab2.length){
                tab3[global++] = tab2[iteTab];
                //tab3[global] = tab2[iteTab];
                //global++;
            }
            iteTab++;
        }

        return tab3;
    }



    public static void affichage(Number[] tab){
        for (int i = 0; i < tab.length; i++) {
            System.out.println(tab[i]);
        }
    }

}
