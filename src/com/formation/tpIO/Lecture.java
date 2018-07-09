package com.formation.tpIO;

import java.io.*;
import java.util.Scanner;

public class Lecture {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean itsOk = true;
        do {
            System.out.println("Que veux-tu faire?");
            System.out.println("    1 - Ecrire automatiquement dans le fichier ouput avec le fichier input.txt");
            System.out.println("    2 - Ou tu veux écrire manuellement dans cette console?");
            System.out.println("    3 - Quitter");
            int response = sc.nextInt();
            switch (response) {
                case 1:
                    readfile("input.txt");
                    System.out.println("c'est fait");
                    break;
                case 2:
                    sc.nextLine();
                    for (; ; ) {
                        System.out.println("Ecrit ce que tu veux :");
                        String str = sc.nextLine();
                        writeFile("clientAdd.txt", str + "\n");
                        System.out.println("veux tu continuer à écrire dans le fichier ?(Y/n)");
                        str = sc.nextLine();
                        if (str.equals("") || str.toLowerCase().equals("y"))
                            continue;
                        else
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Au revoir");
                    itsOk = false;
                    break;
            }
        } while (itsOk);

    }

    public static void readfile(String nameFile) throws IOException {
        BufferedReader br = null;
        String ligne = null;
        try {
            // Instanciation du BufferedReader
            br = new BufferedReader(new FileReader(nameFile));
            // Affectation de la lecture de la ligne suivante dans ligne
            String str = "";
            while ((ligne = br.readLine()) != null) {
//                System.out.println(ligne);
                str += ligne + "\n";
            }
            writeFile("output.txt", str);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            br.close();
        }
    }

    public static void writeFile(String nameFile, String str) throws IOException {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(nameFile, true));
            bw.write(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            bw.close();

        }
    }
}
