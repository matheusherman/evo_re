package i4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f11019a = new a("DATA_MASK_000", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f11020b = new c("DATA_MASK_001", 1) { // from class: i4.c.b
        {
            a aVar = null;
        }

        @Override // i4.c
        boolean f(int i10, int i11) {
            return (i10 & 1) == 0;
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f11021c = new c("DATA_MASK_010", 2) { // from class: i4.c.c
        {
            a aVar = null;
        }

        @Override // i4.c
        boolean f(int i10, int i11) {
            return i11 % 3 == 0;
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f11022d = new c("DATA_MASK_011", 3) { // from class: i4.c.d
        {
            a aVar = null;
        }

        @Override // i4.c
        boolean f(int i10, int i11) {
            return (i10 + i11) % 3 == 0;
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f11023e = new c("DATA_MASK_100", 4) { // from class: i4.c.e
        {
            a aVar = null;
        }

        @Override // i4.c
        boolean f(int i10, int i11) {
            return (((i10 / 2) + (i11 / 3)) & 1) == 0;
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f11024f = new c("DATA_MASK_101", 5) { // from class: i4.c.f
        {
            a aVar = null;
        }

        @Override // i4.c
        boolean f(int i10, int i11) {
            return (i10 * i11) % 6 == 0;
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f11025g = new c("DATA_MASK_110", 6) { // from class: i4.c.g
        {
            a aVar = null;
        }

        @Override // i4.c
        boolean f(int i10, int i11) {
            return (i10 * i11) % 6 < 3;
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f11026h = new c("DATA_MASK_111", 7) { // from class: i4.c.h
        {
            a aVar = null;
        }

        @Override // i4.c
        boolean f(int i10, int i11) {
            return (((i10 + i11) + ((i10 * i11) % 3)) & 1) == 0;
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ c[] f11027i = a();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final enum a extends c {
        a(String str, int i10) {
            super(str, i10, null);
        }

        @Override // i4.c
        boolean f(int i10, int i11) {
            return ((i10 + i11) & 1) == 0;
        }
    }

    private c(String str, int i10) {
        super(str, i10);
    }

    abstract boolean f(int i10, int i11);

    final void i(p3.b bVar, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            for (int i12 = 0; i12 < i10; i12++) {
                if (f(i11, i12)) {
                    bVar.g(i12, i11);
                }
            }
        }
    }

    /* synthetic */ c(String str, int i10, a aVar) {
        this(str, i10);
    }

    private static /* synthetic */ c[] a() {
        return new c[]{f11019a, f11020b, f11021c, f11022d, f11023e, f11024f, f11025g, f11026h};
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f11027i.clone();
    }
}
