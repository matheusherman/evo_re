package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public enum mg {
    DEBUG(3),
    ERROR(6),
    INFO(4),
    VERBOSE(2),
    WARN(5);

    public static mg a(int i10) {
        if (i10 == 2) {
            return VERBOSE;
        }
        if (i10 == 3) {
            return DEBUG;
        }
        if (i10 != 5) {
            return i10 != 6 ? INFO : ERROR;
        }
        return WARN;
    }

    mg(int i10) {
    }
}
