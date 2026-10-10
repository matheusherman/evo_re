package com.live.evo.util;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static m8.a<Long> f7285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static g8.c<Long> f7286b;

    public static synchronized h8.c b(j8.c<Long> cVar, j8.c<Throwable> cVar2, g8.h hVar) {
        try {
            if (f7285a == null) {
                f7285a = g8.c.k(1L, 1L, TimeUnit.SECONDS).m(new j8.d() { // from class: com.live.evo.util.l1
                    @Override // j8.d
                    public final Object apply(Object obj) {
                        return m1.a((Long) obj);
                    }
                }).q();
            }
            if (f7286b == null) {
                f7286b = f7285a.y();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f7286b.n(hVar).s(cVar, cVar2);
    }

    public static /* synthetic */ Long a(Long l10) {
        return l10;
    }
}
