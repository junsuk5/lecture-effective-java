package com.survivalcoding;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ReplayWriter implements AutoCloseable {
    private final String name;
    private final List<String> lines = new ArrayList<>();
    private boolean closed = false;

    ReplayWriter(String name) {
        this.name = name;
        System.out.println(name + " 열기");
    }

    void write(String line) throws IOException {
        lines.add(line);
    }

    List<String> getLines() {
//        return lines;
        return new ArrayList<>(lines);
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