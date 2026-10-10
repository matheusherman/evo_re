package s;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f18184a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f18185b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final n f18186c = new e();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final n f18187d = new c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final n f18188e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final n f18189f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final n f18190g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final j.h<n> f18191h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final boolean f18192i;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class a extends n {
        @Override // s.n
        public float b(int i10, int i11, int i12, int i13) {
            int iMin = Math.min(i11 / i13, i10 / i12);
            if (iMin == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(iMin);
        }

        @Override // s.n
        public g a(int i10, int i11, int i12, int i13) {
            return g.QUALITY;
        }

        a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class b extends n {
        @Override // s.n
        public float b(int i10, int i11, int i12, int i13) {
            int iCeil = (int) Math.ceil(Math.max(i11 / i13, i10 / i12));
            int iMax = Math.max(1, Integer.highestOneBit(iCeil));
            return 1.0f / (iMax << (iMax >= iCeil ? 0 : 1));
        }

        @Override // s.n
        public g a(int i10, int i11, int i12, int i13) {
            return g.MEMORY;
        }

        b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class c extends n {
        @Override // s.n
        public float b(int i10, int i11, int i12, int i13) {
            return Math.min(1.0f, n.f18186c.b(i10, i11, i12, i13));
        }

        c() {
        }

        @Override // s.n
        public g a(int i10, int i11, int i12, int i13) {
            if (b(i10, i11, i12, i13) == 1.0f) {
                return g.QUALITY;
            }
            return n.f18186c.a(i10, i11, i12, i13);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class d extends n {
        @Override // s.n
        public float b(int i10, int i11, int i12, int i13) {
            return Math.max(i12 / i10, i13 / i11);
        }

        @Override // s.n
        public g a(int i10, int i11, int i12, int i13) {
            return g.QUALITY;
        }

        d() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class e extends n {
        @Override // s.n
        public g a(int i10, int i11, int i12, int i13) {
            return n.f18192i ? g.QUALITY : g.MEMORY;
        }

        @Override // s.n
        public float b(int i10, int i11, int i12, int i13) {
            if (n.f18192i) {
                return Math.min(i12 / i10, i13 / i11);
            }
            int iMax = Math.max(i11 / i13, i10 / i12);
            if (iMax == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(iMax);
        }

        e() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class f extends n {
        @Override // s.n
        public g a(int i10, int i11, int i12, int i13) {
            return g.QUALITY;
        }

        @Override // s.n
        public float b(int i10, int i11, int i12, int i13) {
            return 1.0f;
        }

        f() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum g {
        MEMORY,
        QUALITY
    }

    public abstract g a(int i10, int i11, int i12, int i13);

    public abstract float b(int i10, int i11, int i12, int i13);

    static {
        d dVar = new d();
        f18188e = dVar;
        f18189f = new f();
        f18190g = dVar;
        f18191h = j.h.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", dVar);
        f18192i = true;
    }
}
