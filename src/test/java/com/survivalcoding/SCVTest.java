package com.survivalcoding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SCVTest {
    @Test
    @DisplayName("메딕이 SCV를 치료해도 최대 체력 60 을 넘지 않는다")
    void medicHealsScvUpToMaxHp() {
        Medic medic = new Medic();
        SCV scv = SCV.create();
        medic.treat(scv);
        assertEquals(60, scv.getHp());
    }

    @Test
    @DisplayName("SCV가 다른 SCV를 수리해도 최대 체력 60 을 넘지 않는다")
    void scvRepairsAnotherScvUpToMaxHp() {
        SCV repairer = SCV.create();
        SCV target = SCV.create();
        repairer.repairTarget(target);
        assertEquals(60, target.getHp());
    }

    @Test
    @DisplayName("SCV가 시즈 탱크를 수리해도 최대 체력 150 을 넘지 않는다")
    void scvRepairsSiegeTankUpToMaxHp() {
        SCV scv = SCV.create();
        SiegeTank tank = new SiegeTank();
        scv.repairTarget(tank);
        assertEquals(150, tank.getHp());
    }

    @Test
    @DisplayName("체력 1인 SCV를 10 수리하면 11이 된다")
    void repairFromCriticalState() {
//        SCV damaged = new SCV(new Health(1, 60)); // 체력 1로 만들 방법이 없다
        SCV damaged = SCV.ofDamaged(1);
        damaged.repair(10);
        assertEquals(11, damaged.getHp());
    }

    @Test
    @DisplayName("create로 만든 SCV는 체력 60에서 시작한다")
    void createStartsAtMaxHp() {
        SCV scv = SCV.create();
        assertEquals(60, scv.getHp());
    }

    @Test
    @DisplayName("ofDamaged(61)은 최대 체력을 넘으므로 만들 수 없다")
    void ofDamagedRejectsOverMaxHp() {
        assertThrows(IllegalArgumentException.class, () -> SCV.ofDamaged(61));
    }

    @Test
    @DisplayName("집결지를 공유한 SCV 하나를 옮겨도 다른 SCV는 그대로다")
    void movingOneScvKeepsOtherAtRally() {
        Position rally = new Position(10, 20);
        SCV scv1 = SCV.at(rally);
        SCV scv2 = SCV.at(rally);
        scv1.moveBy(89, 0);
        assertEquals(99, scv1.getPosition().getX());
        assertEquals(10, scv2.getPosition().getX());
    }

    @Test
    @DisplayName("이동 명령에 쓴 좌표로 다음 좌표를 만들어도 SCV는 그대로다")
    void reusingTargetDoesNotMoveScv() {
        Position target = new Position(30, 40);
        SCV scv = SCV.create();
        scv.moveTo(target);
        Position next = target.move(69, 0);
        assertEquals(99, next.getX());
        assertEquals(30, scv.getPosition().getX());
    }
}