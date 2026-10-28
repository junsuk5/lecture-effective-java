package com.survivalcoding;

import java.io.IOException;

final class ReplayCopier {
    private ReplayCopier() {
    } // static 메서드만 모아 두는 클래스

    static int countLines(ReplayReader in) throws IOException {
        try {
            int count = 0;
            while (in.readLine() != null) {
                count++;
            }
            return count;
        } finally {
            in.close(); // 읽다가 실패해도 닫는다
        }
    }

    static void copy(ReplayReader in, ReplayWriter out) throws IOException {
        try (ReplayReader r = in; ReplayWriter w = out) {
            String line;
            while ((line = r.readLine()) != null) {
                w.write(line);
            }
        }
    }

    static boolean tryCopy(ReplayReader in, ReplayWriter out) {
        try (ReplayReader r = in; ReplayWriter w = out) {
            String line;
            while ((line = r.readLine()) != null) {
                w.write(line);
            }
            return true;
        } catch (IOException e) {
            System.out.println("복사 실패: " + e.getMessage()
                    + " (숨은 예외 " + e.getSuppressed().length + "개)");
            return false;
        } finally {
            System.out.println("복사 시도 끝");
        }
    }
}