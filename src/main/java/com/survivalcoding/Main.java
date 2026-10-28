package com.survivalcoding;

public class Main {
    public static void main(String[] args) {
        boolean a = Boolean.valueOf(true) == Boolean.valueOf(true);
        boolean b = new Boolean(true) == new Boolean(true);
        System.out.println(b);
    }
}