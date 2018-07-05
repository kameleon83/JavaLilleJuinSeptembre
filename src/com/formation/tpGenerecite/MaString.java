package com.formation.tpGenerecite;

public class MaString<T> {

    String capitalize(T str) {

        String string = "";
        if ( str instanceof String){
            for (String s : ((String) str).split(" ")) {
                string += s.substring(0, 1).toUpperCase() + s.substring(1) + " ";
            }
            return string.trim();
        }
        return "Tu n'as pas rentré une chaine de caractère";
    }
}
