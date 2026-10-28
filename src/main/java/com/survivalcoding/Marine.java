package com.survivalcoding;

public class Marine implements Healable {
    private static final int MAX_HP = 40;
    private int hp = MAX_HP;

    @Override
    public void heal(int amount) {
        hp = Math.min(hp + amount, MAX_HP);
    }

    public int getHp() {
        return hp;
    }
}