package com.survivalcoding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReplayArchiverTest {

    @Test
    @DisplayName("정상이면 모든 줄을 기록하고 닫는다")
    void archivesAllLines() throws IOException {
        ReplayWriter out = new ReplayWriter("archive.rep");
        List<String> lines = Arrays.asList("00:01 SCV 생산"
                , "00:12 Marine 생산");
        ReplayArchiver.archive(out, lines);
        assertEquals(lines, out.getLines());
        assertTrue(out.isClosed());
    }

    @Test
    @DisplayName("기록 실패 예외가 보존되고 닫기 실패는 숨은 예외로 남는다")
    void keepsWriteFailure() {
        ReplayWriter out = new FaultyReplayWriter("archive.rep");
        List<String> lines = Arrays.asList("00:01 SCV 생산");
        IOException thrown = assertThrows(IOException.class, () -> ReplayArchiver.archive(out, lines));
        assertEquals("기록 실패", thrown.getMessage());
        assertEquals(1, thrown.getSuppressed().length);
    }
}