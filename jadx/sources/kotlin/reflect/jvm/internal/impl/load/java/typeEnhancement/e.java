package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f13436e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final e f13437f = new e(null, null, false, false, 8, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f13438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f f13439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f13440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f13441d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }

        public final e a() {
            return e.f13437f;
        }
    }

    public e(h hVar, f fVar, boolean z10, boolean z11) {
        this.f13438a = hVar;
        this.f13439b = fVar;
        this.f13440c = z10;
        this.f13441d = z11;
    }

    public final boolean b() {
        return this.f13440c;
    }

    public final f c() {
        return this.f13439b;
    }

    public final h d() {
        return this.f13438a;
    }

    public final boolean e() {
        return this.f13441d;
    }

    public /* synthetic */ e(h hVar, f fVar, boolean z10, boolean z11, int i10, kotlin.jvm.internal.g gVar) {
        this(hVar, fVar, z10, (i10 & 8) != 0 ? false : z11);
    }
}
