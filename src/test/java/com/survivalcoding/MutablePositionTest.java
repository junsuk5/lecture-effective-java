package com.survivalcoding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class MutablePositionTest {

    @Test
    @DisplayName("HashSet에 넣은 뒤 좌표를 바꾼 키는 들어 있는데도 찾지 못한다")
    void mutatedKeyIsLost() {
        Set<MutablePosition> visited = new HashSet<>();
        MutablePosition rally = new MutablePosition(10, 20);
        visited.add(rally);
        rally.setX(99);
        assertEquals(1, visited.size());
        assertFalse(visited.contains(rally));
    }
}