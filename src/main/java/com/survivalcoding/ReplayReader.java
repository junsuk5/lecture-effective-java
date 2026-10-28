package com.survivalcoding;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

class ReplayReader implements AutoCloseable {
    private final String name;
    private final List<String> lines =
            Arrays.asList("00:01 SCV 생산", "00:12 Marine 생산", "00:30 공격 시작");
    private int next = 0;
    private boolean closed = false;

    ReplayReader(String name) {
        this.name = name;
        System.out.println(name + " 열기");
    }

    String readLine() throws IOException {
        return next < lines.size() ? lines.get(next++) : null;
    }

    boolean isClosed() {
        return closed;
    }

    @Override
    public void close() throws IOException {
        closed = true;
        System.out.println(name + " 닫기");
    }
}