package com.survivalcoding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ReplayCopierTest {
    @Test
    @DisplayName("정상이면 모든 줄을 복사하고 두 자원을 닫는다")
    void copiesAllLines() throws IOException {
        ReplayReader in = new ReplayReader("game.rep");
        ReplayWriter out = new ReplayWriter("copy.rep");
        ReplayCopier.copy(in, out);
        assertEquals(Arrays.asList("00:01 SCV 생산"
                        , "00:12 Marine 생산"
                        , "00:30 공격 시작"),
                out.getLines());
        assertTrue(in.isClosed());
        assertTrue(out.isClosed());
    }

    @Test
    @DisplayName("기록이 실패해도 두 자원은 모두 닫힌다")
    void closesBothEvenWhenWriteFails() {
        ReplayReader in = new ReplayReader("game.rep");
        ReplayWriter out = new FaultyReplayWriter("copy.rep");
        assertThrows(IOException.class, () -> ReplayCopier.copy(in, out));
        assertTrue(in.isClosed());
        assertTrue(out.isClosed());
    }

    @Test
    @DisplayName("기록중 실패하면 호출부는 '기록 실패' 예외를 받는다")
    void keepsWriteFailure() {
        ReplayReader in = new ReplayReader("game.rep");
        ReplayWriter out = new FaultyReplayWriter("copy.rep");
        IOException thrown = assertThrows(IOException.class, () -> ReplayCopier.copy(in, out));
        assertEquals("기록 실패", thrown.getMessage());
    }

    @Test
    @DisplayName("닫기 실패는 숨은 예외로 함께 남는다")
    void keepsCloseFailureAsSuppressed() {
        ReplayReader in = new ReplayReader("game.rep");
        ReplayWriter out = new FaultyReplayWriter("copy.rep");
        IOException thrown = assertThrows(IOException.class, () -> ReplayCopier.copy(in, out));
        assertEquals("기록 실패", thrown.getMessage());
        assertEquals(1, thrown.getSuppressed().length);
        assertEquals("닫기 실패", thrown.getSuppressed()[0].getMessage());
    }
}