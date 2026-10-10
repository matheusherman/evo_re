package w2;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f20054a;

    public static b b() {
        if (f20054a == null) {
            f20054a = new b();
        }
        return f20054a;
    }

    private b() {
    }

    @Override // w2.a
    public long a() {
        return System.currentTimeMillis();
    }
}
