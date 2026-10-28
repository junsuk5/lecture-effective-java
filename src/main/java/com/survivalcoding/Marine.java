package com.survivalcoding;

public class Marine implements Healable {
    private static final int MAX_HP = 40;
    private final Health health;

    Marine(Health health) {
        if (health == null) {
            throw new NullPointerException("Health 는 Null 일 수 없다");
        }
        this.health = health;
    }

    public static Marine create() {
        return new Marine(new Health(MAX_HP));
    }

    public static Marine ofDamaged(int currentHp) {
        return new Marine(new Health(currentHp, MAX_HP));
    }

    @Override
    public void heal(int amount) {
        health.restore(amount);
    }

    public int getHp() {
        return health.getHp();
    }
}