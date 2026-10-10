package kotlin.reflect.jvm.internal.impl.load.kotlin;

import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.PointerIconCompat;
import kotlin.reflect.jvm.internal.impl.types.w1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c0 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f13532k = new a(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final c0 f13533l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final c0 f13534m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final c0 f13535n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final c0 f13536o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final c0 f13537p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final c0 f13538q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final c0 f13539r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final c0 f13540s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final c0 f13541t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f13542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f13543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f13544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f13545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f13546e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c0 f13547f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f13548g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final c0 f13549h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final c0 f13550i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f13551j;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }
    }

    public c0(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, c0 c0Var, boolean z15, c0 c0Var2, c0 c0Var3, boolean z16) {
        this.f13542a = z10;
        this.f13543b = z11;
        this.f13544c = z12;
        this.f13545d = z13;
        this.f13546e = z14;
        this.f13547f = c0Var;
        this.f13548g = z15;
        this.f13549h = c0Var2;
        this.f13550i = c0Var3;
        this.f13551j = z16;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13552a;

        static {
            int[] iArr = new int[w1.values().length];
            try {
                iArr[w1.IN_VARIANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[w1.INVARIANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f13552a = iArr;
        }
    }

    static {
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        c0 c0Var = new c0(z10, z11, z12, z13, z14, null, false, null, null, z15, 1023, null);
        f13533l = c0Var;
        c0 c0Var2 = new c0(false, false, z15, false, false, null, false, null, null, true, FrameMetricsAggregator.EVERY_DURATION, null);
        f13534m = c0Var2;
        f13535n = new c0(false, true, false, false, false, null, false, null, null, false, PointerIconCompat.TYPE_GRABBING, null);
        f13536o = new c0(z10, z11, z12, z13, z14, c0Var, false, null, null, z15, 988, null);
        f13537p = new c0(false, false, z15, false, false, c0Var2, false, null, null, true, 476, null);
        kotlin.jvm.internal.g gVar = null;
        boolean z16 = false;
        c0 c0Var3 = null;
        c0 c0Var4 = null;
        f13538q = new c0(z10, true, z12, z13, z14, c0Var, z16, c0Var3, c0Var4, z15, 988, gVar);
        boolean z17 = false;
        boolean z18 = true;
        f13539r = new c0(z10, z17, z12, z18, z14, c0Var, z16, c0Var3, c0Var4, z15, 983, gVar);
        f13540s = new c0(z10, z17, z12, z18, z14, c0Var, z16, c0Var3, c0Var4, z15, 919, gVar);
        f13541t = new c0(z10, z17, true, false, z14, c0Var, z16, c0Var3, c0Var4, z15, 984, gVar);
    }

    public final boolean a() {
        return this.f13548g;
    }

    public final boolean b() {
        return this.f13551j;
    }

    public final boolean c() {
        return this.f13543b;
    }

    public final boolean d() {
        return this.f13542a;
    }

    public final boolean e() {
        return this.f13544c;
    }

    public final c0 f(w1 effectiveVariance, boolean z10) {
        kotlin.jvm.internal.m.f(effectiveVariance, "effectiveVariance");
        if (!z10 || !this.f13544c) {
            int i10 = b.f13552a[effectiveVariance.ordinal()];
            if (i10 == 1) {
                c0 c0Var = this.f13549h;
                if (c0Var != null) {
                    return c0Var;
                }
            } else if (i10 != 2) {
                c0 c0Var2 = this.f13547f;
                if (c0Var2 != null) {
                    return c0Var2;
                }
            } else {
                c0 c0Var3 = this.f13550i;
                if (c0Var3 != null) {
                    return c0Var3;
                }
            }
        }
        return this;
    }

    public final c0 g() {
        return new c0(this.f13542a, true, this.f13544c, this.f13545d, this.f13546e, this.f13547f, this.f13548g, this.f13549h, this.f13550i, false, 512, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ c0(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, c0 c0Var, boolean z15, c0 c0Var2, c0 c0Var3, boolean z16, int i10, kotlin.jvm.internal.g gVar) {
        z10 = (i10 & 1) != 0 ? true : z10;
        z11 = (i10 & 2) != 0 ? true : z11;
        z12 = (i10 & 4) != 0 ? false : z12;
        z13 = (i10 & 8) != 0 ? false : z13;
        z14 = (i10 & 16) != 0 ? false : z14;
        c0Var = (i10 & 32) != 0 ? null : c0Var;
        this(z10, z11, z12, z13, z14, c0Var, (i10 & 64) != 0 ? true : z15, (i10 & 128) != 0 ? c0Var : c0Var2, (i10 & 256) != 0 ? c0Var : c0Var3, (i10 & 512) != 0 ? false : z16);
    }
}
