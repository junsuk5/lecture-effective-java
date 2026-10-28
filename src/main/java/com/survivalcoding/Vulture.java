package com.survivalcoding;

public class Vulture implements Repairable {
    private static final int MAX_HP = 80;
    private int hp = MAX_HP;


    public int getHp() {
        return hp;
    }

    @Override
    public void repair(int amount) {
        hp = Math.min(hp + amount, MAX_HP);
    }
}