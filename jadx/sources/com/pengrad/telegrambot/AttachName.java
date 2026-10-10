package com.pengrad.telegrambot;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class AttachName {
    private static final AtomicInteger counter = new AtomicInteger();

    public static String next() {
        return "attach" + counter.incrementAndGet();
    }

    public static void reset() {
        counter.set(0);
    }

    private AttachName() {
    }
}
