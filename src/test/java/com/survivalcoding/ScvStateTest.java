package com.survivalcoding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class ScvStateTest {
    @Test
    @DisplayName("기록한 ScvState는 이후 수리에 영향받지 않는다")
    void recordedStateIgnoresLaterRepair() {
        SCV scv = SCV.ofDamaged(30);
        ScvState recorded = new ScvState(scv.getPosition(), scv.getHealth(), 50);
        scv.repair(10);
        assertEquals(30, recorded.getHealth().getHp());
    }

    @Test
    @DisplayName("withPosition은 위치만 새것이고 Health는 같은 객체를 공유한다")
    void withPositionSharesHealth() {
        ScvState before = new ScvState(new Position(10, 20), new Health(30, 60), 50);
        ScvState after = before.withPosition(new Position(30, 40));
        assertEquals(30, after.getPosition().getX());
        assertSame(before.getHealth(), after.getHealth());
    }
    @Test
    @DisplayName("withMineral은 미네랄만 바꾸고 원래 상태는 그대로 둔다")
    void withMineralKeepsOriginal() {
        ScvState before = new ScvState(new Position(10, 20), new Health(30, 60), 50);
        ScvState after = before.withMineral(58);
        assertEquals(58, after.getMineral());
        assertEquals(50, before.getMineral());
        assertSame(before.getPosition(), after.getPosition());
    }

    @Test
    @DisplayName("withHealth는 체력만 바뀐 새 상태를 돌려준다")
    void withHealthChangesOnlyHealth() {
        ScvState before = new ScvState(new Position(10, 20), new Health(30, 60), 50);
        ScvState after = before.withHealth(before.getHealth().restore(10));
        assertEquals(40, after.getHealth().getHp());
        assertEquals(30, before.getHealth().getHp());
        assertEquals(50, after.getMineral());
    }
    @Test
    @DisplayName("withHealth 뒤에도 Position은 같은 객체를 공유한다")
    void withHealthSharesPosition() {
        ScvState before = new ScvState(new Position(10, 20), new Health(30, 60), 50);
        ScvState after = before.withHealth(new Health(60, 60));
        assertSame(before.getPosition(), after.getPosition());
    }
}