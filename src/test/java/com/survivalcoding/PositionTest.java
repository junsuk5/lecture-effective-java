package com.survivalcoding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {
    @Test
    @DisplayName("move는 새 Position을 돌려주고 원래 좌표는 그대로 둔다")
    void moveReturnsNewPosition() {
        Position rally = new Position(10, 20);
        Position moved = rally.move(89, 0);
        assertEquals(99, moved.getX());
        assertEquals(10, rally.getX());
    }
}