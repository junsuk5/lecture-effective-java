package com.survivalcoding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountingUnitSetTest {
    @Test
    @DisplayName("유닛 이름 세 개를 addAll 하면 추가 횟수는 3이다")
    void addAllCountsEachNameOnce() {
        CountingUnitSet names = new CountingUnitSet();
        names.addAll(Arrays.asList("SCV", "Marine", "SiegeTank"));
        assertEquals(3, names.getAddCount());
    }
}