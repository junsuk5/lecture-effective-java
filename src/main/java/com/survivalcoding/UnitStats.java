package com.survivalcoding;

public final class UnitStats {
    private final int hp;
    private final int armor;
    private final int sight;
    private final double speed;
    private final int range;
    private final int mineralCost;
    private final int gasCost;

    private UnitStats(Builder builder) {
        this.hp = builder.hp;
        this.armor = builder.armor;
        this.sight = builder.sight;
        this.speed = builder.speed;
        this.range = builder.range;
        this.mineralCost = builder.mineralCost;
        this.gasCost = builder.gasCost;
    }

    public int getHp() {
        return hp;
    }

    public int getArmor() {
        return armor;
    }

    public int getSight() {
        return sight;
    }

    public double getSpeed() {
        return speed;
    }

    public int getRange() {
        return range;
    }

    public int getMineralCost() {
        return mineralCost;
    }

    public int getGasCost() {
        return gasCost;
    }

    public static class Builder {
        private final int hp; // 필수
        private int armor = 0; // 선택: 기본값
        private int sight = 5;
        private double speed = 1.0;
        private int range = 1;
        private int mineralCost = 0;
        private int gasCost = 0;

        public Builder(int hp) {
            if (hp <= 0) {
                throw new IllegalArgumentException("체력은 양수여야 합니다.");
            }
            this.hp = hp;
        }

        public Builder armor(int armor) {
            this.armor = armor;
            return this;
        }

        public Builder sight(int sight) {
            this.sight = sight;
            return this;
        }

        public Builder speed(double speed) {
            this.speed = speed;
            return this;
        }

        public Builder range(int range) {
            this.range = range;
            return this;
        }

        public Builder mineralCost(int mineralCost) {
            this.mineralCost = mineralCost;
            return this;
        }

        public Builder gasCost(int gasCost) {
            this.gasCost = gasCost;
            return this;
        }

        public UnitStats build() {
            if (range > sight) {
                throw new IllegalArgumentException("사거리는 시야보다 길 수 없습니다.");
            }
            if (speed <= 0) {
                throw new IllegalArgumentException("이동 속도는 0보다 커야 합니다.");
            }
            return new UnitStats(this);
        }
    }

}