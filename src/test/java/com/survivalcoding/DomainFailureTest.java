package com.survivalcoding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DomainFailureTest {
    @Test
    @DisplayName("메딕이 마린을치료해도 최대 체력 40 을 넘지 않는다")
    void medicHealsMarineUpToMaxHp() {
        Marine marine = Marine.create();
        Medic medic = new Medic();
        medic.treat(marine);
        assertEquals(40, marine.getHp());
    }

    @Test
    @DisplayName("체력 1인 SCV를 10 수리 하면 11이 된다")
    void repairFromCriticalState() {
        SCV damaged = SCV.ofDamaged(1);
        damaged.repair(10);
        assertEquals(11, damaged.getHp());
    }
}
