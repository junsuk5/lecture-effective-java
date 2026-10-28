package com.survivalcoding;

import java.util.Objects;

public final class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position move(int dx, int dy) { // 규칙 4: 바뀐 값은 새 객체로
        return new Position(x + dx, y + dy);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Position position)) return false;

        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
