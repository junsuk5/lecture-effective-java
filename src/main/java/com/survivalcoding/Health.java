package com.survivalcoding;

public class Health {
    private final int maxHp;
    private int currentHp;

    public Health(int maxHp) {
        this(maxHp, maxHp);
    }

    public Health(int currentHp, int maxHp) {
        if (maxHp <= 0 || currentHp < 0 || currentHp > maxHp) {
            throw new IllegalArgumentException("올바르지 않은 체력 값입니다.");
        }
        this.currentHp = currentHp;
        this.maxHp = maxHp;
    }

    public void restore(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("회복량은 0 이상이어야 합니다.");
        }
        currentHp = Math.min(currentHp + amount, maxHp);
    }

    public void damage(int amount) {
        currentHp = Math.max(currentHp - amount, 0);
    }

    public int getHp() {
        return currentHp;
    }

    public int getMaxHp() {
        return maxHp;
    }
}