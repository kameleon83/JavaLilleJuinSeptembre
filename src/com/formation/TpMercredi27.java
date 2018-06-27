package com.formation;

import java.util.Scanner;

public class TpMercredi27 {
    public static void main(String[] args) {
//        int n = 5;
//        System.out.println("Ligne d'étoiles : ");
//        for (int i = 0; i < n; i++) {
//            System.out.print("*");
//        }
//        System.out.println();
//
//        System.out.println("Carré : ");
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//
//        System.out.println("Triangle Rectangle : ");
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < i+1; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//
//        System.out.println("Rectangle avec 2 valeurs");
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//
//        for (int i = 0; i < a; i++) {
//            for (int j = 0; j < b; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//
//

        String str = "Salut tout le monde!! SALUT World";
        String[] tab = str.split(" ");
        byte count = 0;
        for (int i = 0; i < tab.length; i++) {
            if(tab[i].toLowerCase().equals("salut".toLowerCase())){
                count++;
            }
        }

        for(String s : tab){
            if (s.toLowerCase().equals("salut".toLowerCase())) count++;
        }


        System.out.println(count>0 ? "OK " + count : "Pas gtrouvé");

    }
}
