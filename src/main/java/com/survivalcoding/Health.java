package com.survivalcoding;

public final class Health {
    private final int maxHp;
    private final int currentHp;

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

    public Health restore(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("회복량은 0 이상이어야 합니다.");
        }
        return new Health(Math.min(currentHp + amount, maxHp), maxHp);
    }
    public Health damage(int amount) {
        return new Health(Math.max(currentHp - amount, 0), maxHp);
    }

    public int getHp() {
        return currentHp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Health health)) return false;

        return maxHp == health.maxHp && currentHp == health.currentHp;
    }

    @Override
    public int hashCode() {
        int result = maxHp;
        result = 31 * result + currentHp;
        return result;
    }
}