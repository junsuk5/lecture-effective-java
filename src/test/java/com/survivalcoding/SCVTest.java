package com.survivalcoding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SCVTest {
    @Test
    @DisplayName("메딕이 SCV를 치료해도 최대 체력 60 을 넘지 않는다")
    void medicHealsScvUpToMaxHp() {
        Medic medic = new Medic();
        SCV scv = new SCV();
        medic.treat(scv);
        assertEquals(60, scv.getHp());
    }

    @Test
    @DisplayName("SCV가 다른 SCV를 수리해도 최대 체력 60 을 넘지 않는다")
    void scvRepairsAnotherScvUpToMaxHp() {
        SCV repairer = new SCV();
        SCV target = new SCV();
        repairer.repairTarget(target);
        assertEquals(60, target.getHp());
    }

    @Test
    @DisplayName("SCV가 시즈 탱크를 수리해도 최대 체력 150 을 넘지 않는다")
    void scvRepairsSiegeTankUpToMaxHp() {
        SCV scv = new SCV();
        SiegeTank tank = new SiegeTank();
        scv.repairTarget(tank);
        assertEquals(150, tank.getHp());
    }
}