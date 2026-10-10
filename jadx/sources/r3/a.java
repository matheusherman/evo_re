package r3;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f17792h = new a(4201, 4096, 1);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f17793i = new a(1033, 1024, 1);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f17794j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f17795k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f17796l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f17797m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f17798n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f17799o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f17800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f17801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f17802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f17803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f17804e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f17805f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f17806g;

    static int a(int i10, int i11) {
        return i10 ^ i11;
    }

    static {
        a aVar = new a(67, 64, 1);
        f17794j = aVar;
        f17795k = new a(19, 16, 1);
        f17796l = new a(285, 256, 0);
        a aVar2 = new a(301, 256, 1);
        f17797m = aVar2;
        f17798n = aVar2;
        f17799o = aVar;
    }

    b b(int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException();
        }
        if (i11 == 0) {
            return this.f17802c;
        }
        int[] iArr = new int[i10 + 1];
        iArr[0] = i11;
        return new b(this, iArr);
    }

    int c(int i10) {
        return this.f17800a[i10];
    }

    public int d() {
        return this.f17806g;
    }

    b e() {
        return this.f17803d;
    }

    public int f() {
        return this.f17804e;
    }

    b g() {
        return this.f17802c;
    }

    int h(int i10) {
        if (i10 != 0) {
            return this.f17800a[(this.f17804e - this.f17801b[i10]) - 1];
        }
        throw new ArithmeticException();
    }

    int i(int i10) {
        if (i10 != 0) {
            return this.f17801b[i10];
        }
        throw new IllegalArgumentException();
    }

    int j(int i10, int i11) {
        if (i10 == 0 || i11 == 0) {
            return 0;
        }
        int[] iArr = this.f17800a;
        int[] iArr2 = this.f17801b;
        return iArr[(iArr2[i10] + iArr2[i11]) % (this.f17804e - 1)];
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f17805f) + ',' + this.f17804e + ')';
    }

    public a(int i10, int i11, int i12) {
        this.f17805f = i10;
        this.f17804e = i11;
        this.f17806g = i12;
        this.f17800a = new int[i11];
        this.f17801b = new int[i11];
        int i13 = 1;
        for (int i14 = 0; i14 < i11; i14++) {
            this.f17800a[i14] = i13;
            i13 *= 2;
            if (i13 >= i11) {
                i13 = (i13 ^ i10) & (i11 - 1);
            }
        }
        for (int i15 = 0; i15 < i11 - 1; i15++) {
            this.f17801b[this.f17800a[i15]] = i15;
        }
        this.f17802c = new b(this, new int[]{0});
        this.f17803d = new b(this, new int[]{1});
    }
}
