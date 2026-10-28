package com.survivalcoding;

public class SiegeTank implements Repairable {
    private static final int MAX_HP = 150;
    private int hp = MAX_HP;

    @Override
    public void repair(int amount) {
        hp = Math.min(hp + amount, MAX_HP);
    }

    public int getHp() {
        return hp;
    }
}