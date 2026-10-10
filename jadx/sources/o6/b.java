package o6;

import androidx.p000lifecycle.CoroutineLiveDataKt;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static q6.b f16473a = q6.c.d(b.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static i f16474b = new i();

    public static void a(String str, long j10, long j11, e eVar) {
        f16474b.e(str, j10, j11, eVar);
    }

    public static void c(String str, e eVar) {
        b(str, CoroutineLiveDataKt.DEFAULT_TIMEOUT, eVar);
    }

    public static void b(String str, long j10, e eVar) {
        a(str, j10, 300000L, eVar);
    }
}
