package nf;

import x1.f1.lb.util.d1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class x extends n6.a {
    private final long playSession;
    private final v6.c playType;
    private final long time = d1.c();
    private final String videoName;

    public x(String str, v6.c cVar, Long l10) {
        long jLongValue;
        if (l10 == null) {
            jLongValue = 0;
        } else {
            jLongValue = l10.longValue();
        }
        this.playSession = jLongValue;
        this.videoName = str;
        this.playType = cVar;
    }
}
