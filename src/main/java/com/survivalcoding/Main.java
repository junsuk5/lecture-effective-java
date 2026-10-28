package com.survivalcoding;

public class Main {
    public static void main(String[] args) {
        SCV scv = new SCV();
        SCV scv2 = new SCV();

        Medic medic = new Medic();
        medic.treat(scv);
        scv.repairTarget(scv2);
    }
}