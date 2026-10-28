package com.survivalcoding;

public class SCV implements Healable, Repairable {
    private static final int MAX_HP = 60;
    static final int REPAIR_AMOUNT = 10;
    private final Health health;

    // private package : test
    SCV(Health health) {
        if (health == null) {
            throw new NullPointerException("Health는 필수입니다.");
        }
        this.health = health;
    }

    public static SCV create() {
        return new SCV(new Health(MAX_HP));
    }

    public static SCV ofDamaged(int currentHp) {
        return new SCV(new Health(currentHp, MAX_HP));
    }

    @Override
    public void heal(int amount) {
        health.restore(amount);
    }

    @Override
    public void repair(int amount) {
        health.restore(amount);
    }

    public void repairTarget(Repairable target) {
        target.repair(REPAIR_AMOUNT);
    }

    public int getHp() {
        return health.getHp();
    }
}