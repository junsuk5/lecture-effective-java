package com.survivalcoding;

public class CatchFinallyDemo {
    public static void main(String[] args) {
        boolean copied = ReplayCopier.tryCopy(
                new ReplayReader("game.rep"), new FaultyReplayWriter("copy.rep"));
        System.out.println("결과: " + copied);
    }
}