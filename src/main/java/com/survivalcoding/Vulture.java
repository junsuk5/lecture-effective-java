package com.survivalcoding;

public class Vulture implements Repairable {
    private static final int MAX_HP = 80;
    private Health health = new Health(MAX_HP);

    @Override
    public void repair(int amount) {
        health = health.restore(amount);
    }

    public int getHp() {
        return health.getHp();
    }
}