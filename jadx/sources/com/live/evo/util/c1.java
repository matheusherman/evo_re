package com.live.evo.util;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c1 {
    public static String a(long j10) {
        long j11 = (int) (j10 / 1000);
        long j12 = j11 % 60;
        long j13 = (j11 / 60) % 60;
        long j14 = j11 / 3600;
        return j14 > 0 ? String.format(Locale.ENGLISH, "%02d:%02d:%02d", Long.valueOf(j14), Long.valueOf(j13), Long.valueOf(j12)) : String.format(Locale.ENGLISH, "%02d:%02d", Long.valueOf(j13), Long.valueOf(j12));
    }
}
