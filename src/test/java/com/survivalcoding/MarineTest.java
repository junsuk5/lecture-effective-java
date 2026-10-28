package com.survivalcoding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MarineTest {
    @Test
    @DisplayName("메딕이 마린을 치료해도 최대 체력 40을 넘지 않는다")
    void medicHealsMarineUpToMaxHp() {
        Medic medic = new Medic();
        Marine marine = Marine.create();
        medic.treat(marine);
        assertEquals(40, marine.getHp());
    }

    @Test
    @DisplayName("체력 5인 마린을 메딕이 치료하면 15가 된다")
    void medicHealsDamagedMarine() {
        Marine marine = Marine.ofDamaged(5);
        Medic medic = new Medic();
        medic.treat(marine);
        assertEquals(15, marine.getHp());
    }

    @Test
    @DisplayName("체력 41인 마린은 만들 수 없다")
    void rejectsHpOverMaxHp() {
        assertThrows(IllegalArgumentException.class, () -> Marine.ofDamaged(41));
    }
    @Test
    @DisplayName("create로 만든 마린은 체력 40에서 시작한다")
    void createStartsAtMaxHp() {
        Marine marine = Marine.create();
        assertEquals(40, marine.getHp());
    }
}