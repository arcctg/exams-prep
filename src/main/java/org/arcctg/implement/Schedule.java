package org.arcctg.implement;

import java.util.function.Consumer;

public class Schedule {
    public static void schedule(Consumer<Integer> func, int n, long interval) throws InterruptedException {
        if (interval < 0) return;

        for (int i = 0; i < n; i++) {
            func.accept(i);
            Thread.sleep(interval);
        }
    }
}
