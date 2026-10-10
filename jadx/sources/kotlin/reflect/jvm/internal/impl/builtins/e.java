package kotlin.reflect.jvm.internal.impl.builtins;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class e extends h {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f12460h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final e f12461i;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }

        public final e a() {
            return e.f12461i;
        }
    }

    public e(boolean z10) {
        super(new ka.f("DefaultBuiltIns"));
        if (z10) {
            f(false);
        }
    }

    static {
        kotlin.jvm.internal.g gVar = null;
        f12460h = new a(gVar);
        f12461i = new e(false, 1, gVar);
    }

    public /* synthetic */ e(boolean z10, int i10, kotlin.jvm.internal.g gVar) {
        this((i10 & 1) != 0 ? true : z10);
    }
}
