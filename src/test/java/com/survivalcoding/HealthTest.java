package com.survivalcoding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HealthTest {
    @Test
    @DisplayName("체력 30에서 10 회복하면 40이 된다")
    void restoreAddsAmount() {
        Health health = new Health(30, 60);
        Health restored = health.restore(10);
        assertEquals(40, restored.getHp());
        assertEquals(30, health.getHp());
    }

    @Test
    @DisplayName("체력 55에서 10 회복해도 최대 체력 60에서 멈춘다")
    void restoreStopsAtMaxHp() {
        Health health = new Health(55, 60);
        assertEquals(60, health.restore(10).getHp());
    }

    @Test
    @DisplayName("체력 30에서 10 피해를 입으면 20이 된다")
    void damageSubtractsAmount() {
        Health health = new Health(30, 60);
        Health damaged = health.damage(10);
        assertEquals(20, damaged.getHp());
        assertEquals(30, health.getHp());
    }

    @Test
    @DisplayName("체력 5에서 10 피해를 입어도 0 아래로 내려가지 않는다")
    void damageStopsAtZero() {
        Health health = new Health(5, 60);
        assertEquals(0, health.damage(10).getHp());
    }
}