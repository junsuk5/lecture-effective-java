package com.survivalcoding;

import java.util.Objects;

public class SCV implements Healable, Repairable {
    private static final int MAX_HP = 60;
    static final int REPAIR_AMOUNT = 10;
    private Health health;
    private Position position;

    // private package : test
    SCV(Health health, Position position) {
        if (health == null) {
            throw new NullPointerException("Health는 필수입니다.");
        }
        if (position == null) {
            throw new NullPointerException("Position는 필수입니다.");
        }

        this.health = health;
        this.position = position;
    }

    public static SCV create() {
        return new SCV(new Health(MAX_HP), new Position(0, 0));
    }

    public static SCV ofDamaged(int currentHp) {
        return new SCV(new Health(currentHp, MAX_HP), new Position(0, 0));
    }

    public static SCV at(Position position) {
        return new SCV(new Health(MAX_HP), position);
    }

    @Override
    public void heal(int amount) {
        health = health.restore(amount);
    }

    @Override
    public void repair(int amount) {
        health = health.restore(amount);
    }

    public void repairTarget(Repairable target) {
        target.repair(REPAIR_AMOUNT);
    }

    public int getHp() {
        return health.getHp();
    }

    public Position getPosition() {
        return position;
    }

    public Health getHealth() {
        return health;
    }

    public void moveTo(Position target) {
        this.position = Objects.requireNonNull(target);
    }

    public void moveBy(int dx, int dy) {
        this.position = position.move(dx, dy);
    }
}