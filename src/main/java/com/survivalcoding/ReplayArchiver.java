package com.survivalcoding;

import java.io.IOException;
import java.util.List;

final class ReplayArchiver {
    private ReplayArchiver() {
    }

    static void archive(ReplayWriter out, List<String> lines) throws IOException {
        try (ReplayWriter w = out) {
            for (String line : lines) {
                w.write(line);
            }
        }
    }
}