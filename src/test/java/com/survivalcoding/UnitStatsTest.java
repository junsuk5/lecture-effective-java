package com.survivalcoding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UnitStatsTest {

    @Test
    @DisplayName("이름 붙여 정한 값만 바뀌고 나머지는 기본값이다")
    void namedValuesOverrideDefaults() {
        UnitStats scv = new UnitStats.Builder(60)
                .sight(7)
                .speed(2.8)
                .mineralCost(50)
                .build();
        assertEquals(7, scv.getSight());
        assertEquals(1, scv.getRange());
        assertEquals(50, scv.getMineralCost());
    }

    @Test
    @DisplayName("체력만 정하면 나머지는 기본값이다")
    void defaultsWhenOnlyHpIsGiven() {
        UnitStats stats = new UnitStats.Builder(60).build();
        assertEquals(0, stats.getArmor());
        assertEquals(5, stats.getSight());
        assertEquals(1.0, stats.getSpeed());
        assertEquals(1, stats.getRange());
        assertEquals(0, stats.getMineralCost());
        assertEquals(0, stats.getGasCost());
    }

    @Test
    @DisplayName("사거리 10,시야 7이면 IllegalArgumentException이 난다")
    void rangeLongerThanSightIsRejected() {
        UnitStats.Builder builder = new UnitStats.Builder(150).sight(7).range(10);
        IllegalArgumentException e =
                assertThrows(IllegalArgumentException.class, () -> builder.build());
        assertEquals("사거리는 시야보다 길 수 없습니다.", e.getMessage());
    }

    @Test
    @DisplayName("호출 순서와 상관없이 다 모은 뒤에 검사한다")
    void checkAfterAllValuesAreCollected() {
        UnitStats tank = new UnitStats.Builder(150)
                .range(10)
                .sight(12)
                .build();
        assertEquals(10, tank.getRange());
    }

    @Test
    @DisplayName("체력이 0이면 Builder를 만들 때 IllegalArgumentException이 난다")
    void zeroHpIsRejected() {
        IllegalArgumentException e =
                assertThrows(IllegalArgumentException.class, () -> new UnitStats.Builder(0));
        assertEquals("체력은 양수여야 합니다.", e.getMessage());
    }

    @Test
    @DisplayName("이동 속도가0이면 IllegalArgumentException이 난다")
    void zeroSpeedIsRejected() {
        UnitStats.Builder builder = new UnitStats.Builder(60).speed(0);
        IllegalArgumentException e =
                assertThrows(IllegalArgumentException.class, () -> builder.build());
        assertEquals("이동 속도는 0보다 커야 합니다.", e.getMessage());
    }
}
