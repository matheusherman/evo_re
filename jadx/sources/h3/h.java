package h3;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class h extends p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final h f10801c;

    private h() {
    }

    static {
        h hVar = new h();
        f10801c = hVar;
        hVar.setStackTrace(p.f10816b);
    }

    private h(Throwable th) {
        super(th);
    }

    public static h a() {
        return p.f10815a ? new h() : f10801c;
    }

    public static h b(Throwable th) {
        return p.f10815a ? new h(th) : f10801c;
    }
}
