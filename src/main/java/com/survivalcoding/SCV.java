package com.survivalcoding;

public class SCV implements Healable, Repairable {
    private static final int MAX_HP = 60;
    static final int REPAIR_AMOUNT = 10;
    private int hp = MAX_HP;

    @Override
    public void heal(int amount) {
        hp = Math.min(hp + amount, MAX_HP);
    }

    @Override
    public void repair(int amount) {
        hp = Math.min(hp + amount, MAX_HP);
    }

    public void repairTarget(Repairable target) {
        target.repair(REPAIR_AMOUNT);
    }

    public int getHp() {
        return hp;
    }
}