package com.formation.tpIO;


import java.io.*;
import java.text.*;
import java.util.*;

public class TPReadWriteFile {

    private HashMap<String, User> listMap = new HashMap<>();

    public static void main(String[] args) {
        TPReadWriteFile tpReadWriteFile = new TPReadWriteFile();
        Map<String, User> users = tpReadWriteFile.read("users.csv");
        // Affichage en console
        users.forEach((k, v) -> System.out.print(v));
        // Ecriture dans fichier users.txt
        users.forEach((k, v) -> {
            tpReadWriteFile.writeFile("users.txt", v.toString());
        });
    }

    public HashMap<String, User> read(String nameFile) {
        BufferedReader br = null;
        String ligne = "";
        try {
            br = new BufferedReader(new FileReader(nameFile));
            String str = "";
            int count = 0;
            while ((ligne = br.readLine()) != null) {
                if (count > 0) {
                    User user = createUser(ligne.split(";"));
                    listMap.put(user.getEmail(), user);
                }
                count++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return listMap;
    }

    public User createUser(String[] tab) {
        User user = new User();
        user.setId(new Long(tab[0]));
        user.setCreateAt(dateToStringFormat(textToDate(tab[1])));
        user.setFirstname(capitalize(tab[2]));
        user.setLastname(tab[3].toUpperCase());
        user.setPhone(formatPhoneWithDot(formatPhone(tab[4])));
        user.setEmail(tab[5]);
        return user;
    }

    public String formatPhone(String phone) {
        phone = phone.trim();
        if (phone.contains(" ") && phone.length() == 14) {
            return String.join("", phone.split(" "));
        } else if (phone.length() == 9) {
            return "0" + phone;
        }
        return "0123456789";
    }

    public String formatPhoneWithDot(String phone) {
        return phone.replaceAll("..", "$0.").substring(0, 14);
    }


    public Date textToDate(String date) {
        try {
            SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd H:m:s");
            return d.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }


    public String dateToStringFormat(Date date) {
        SimpleDateFormat d = new SimpleDateFormat("dd MMMM yyyy HH'h'mm'm'ss's'", Locale.FRENCH);
        return d.format(date);
    }


    public String capitalize(String firstname) {
        String string = "";
        for (String s : (firstname).split(" ")) {
            string += s.substring(0, 1).toUpperCase() + s.substring(1) + " ";
        }
        return string.trim();
    }

    public void writeFile(String nameFile, String str) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(nameFile, true));
            bw.write(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
