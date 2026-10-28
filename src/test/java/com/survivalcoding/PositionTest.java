package com.survivalcoding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    @Test
    @DisplayName("move는 새 Position을 돌려주고 원래 좌표는 그대로 둔다")
    void moveReturnsNewPosition() {
        Position rally = new Position(10, 20);
        Position moved = rally.move(89, 0);
        assertEquals(99, moved.getX());
        assertEquals(10, rally.getX());
    }

    @Test
    @DisplayName("지나간 좌표 (10, 20)을 다시 물으면 List에서 찾는다")
    void listContainsSamePosition() {
        List<Position> visited = new ArrayList<>();
        Position position1 = new Position(10, 20);
        Position position2 = new Position(10, 20);
        visited.add(position1);
        boolean found = visited.contains(position2);
        assertTrue(found);
    }

    @Test
    @DisplayName("좌표가 다르면 같지 않고, null과도 같지 않다")
    void differentOrNullIsNotEqual() {
        Position p = new Position(10, 20);
        assertFalse(p.equals(new Position(99, 20)));
        assertFalse(p.equals(null));
    }

    @Test
    @DisplayName("지나간 좌표 (10, 20)을 다시 물으면 HashSet에서 찾는다")
    void hashSetContainsSamePosition() {
        Set<Position> visited = new HashSet<>();
        visited.add(new Position(10, 20));
        boolean found = visited.contains(new Position(10, 20));
        assertTrue(found);
    }

    @Test
    @DisplayName("같은 좌표를 HashSet에 두 번 넣으면 크기 1")
    void hashSetKeepsOneOfSamePosition() {
        Set<Position> visited = new HashSet<>();
        visited.add(new Position(10, 20));
        visited.add(new Position(10, 20));
        assertEquals(1, visited.size());
    }

    @Test
    @DisplayName("같은 좌표로 HashMap에 표시한 이름을 꺼낸다")
    void hashMapFindsBySamePosition() {
        Map<Position, String> marks = new HashMap<>();
        marks.put(new Position(10, 20), "집결지");
        String mark = marks.get(new Position(10, 20));
        assertEquals("집결지", mark);
    }
}