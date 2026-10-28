package com.survivalcoding;

public class Medic implements Healable {
    static final int HEAL_AMOUNT = 10;
    private static final int MAX_HP = 40;


    public void treat(Healable target) {
        target.heal(HEAL_AMOUNT);
    }

    @Override
    public void heal(int amount) {
    }
}