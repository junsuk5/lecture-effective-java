package com.survivalcoding;

public final class ScvState {
    private final Position position;
    private final Health health;
    private final int mineral;

    public ScvState(Position position, Health health, int mineral) {
        this.position = position;
        this.health = health;
        this.mineral = mineral;
    }

    public Position getPosition() {
        return position;
    }

    public Health getHealth() {
        return health;
    }

    public int getMineral() {
        return mineral;
    }

    public ScvState withPosition(Position newPosition) {
        return new ScvState(newPosition, this.health, this.mineral);
    }
    public ScvState withMineral(int newMineral) {
        return new ScvState(this.position, this.health, newMineral);
    }

    public ScvState withHealth(Health newHealth) {
        return new ScvState(this.position, newHealth, this.mineral);
    }
}