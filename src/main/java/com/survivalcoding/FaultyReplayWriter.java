package com.survivalcoding;

import java.io.IOException;

class FaultyReplayWriter extends ReplayWriter { // 테스트용: 쓰기도 닫기도 실패한다
    FaultyReplayWriter(String name) {
        super(name);
    }

    @Override
    void write(String line) throws IOException {
        throw new IOException("기록 실패");
    }

    @Override
    public void close() throws IOException {
        super.close(); // 닫힘 표시와 출력은 그대로 한 뒤
        throw new IOException("닫기 실패");
    }
}