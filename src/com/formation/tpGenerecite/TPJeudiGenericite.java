package com.formation.tpGenerecite;

public class TPJeudiGenericite {
    public static void main(String[] args) {
        System.out.println(new MaString<>().capitalize("hello world"));
        System.out.println(new MaString<Integer>().capitalize(33));
    }
}
