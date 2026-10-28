package com.survivalcoding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VultureTest {
    @Test
    @DisplayName("벌처는 수리 대상이다")
    void vultureIsRepairable() {
        Vulture vulture = new Vulture();
        assertTrue(vulture instanceof Repairable);
    }

    @Test
    void repairDoesNotExceedMaxHp() {
        Vulture vulture = new Vulture();
        vulture.repair(SCV.REPAIR_AMOUNT);
        assertEquals(80, vulture.getHp());
    }
}