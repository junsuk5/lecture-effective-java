package com.survivalcoding;

public class SiegeTank implements Repairable {
    private static final int MAX_HP = 150;
    private final Health health = new Health(MAX_HP);

    @Override
    public void repair(int amount) {
        health.restore(amount);
    }

    public int getHp() {
        return health.getHp();
    }
}