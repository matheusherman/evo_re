package x5;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f21839h = new a(1033, 1024, 1);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f21840i = new a(4201, 4096, 1);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f21841j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f21842k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f21843l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f21844m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f21845n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f21846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f21847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f21848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f21849d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f21850e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f21851f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f21852g;

    static int b(int i10, int i11) {
        return i10 ^ i11;
    }

    static {
        a aVar = new a(67, 64, 1);
        f21841j = aVar;
        f21842k = new a(19, 16, 1);
        f21843l = new a(301, 256, 1);
        f21844m = aVar;
        f21845n = new a(285, 256, 0);
    }

    public int a() {
        return this.f21852g;
    }

    public int c(int i10) {
        return this.f21846a[i10];
    }

    public b d() {
        return this.f21848c;
    }

    public b e(int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException();
        }
        if (i11 == 0) {
            return this.f21848c;
        }
        int[] iArr = new int[i10 + 1];
        iArr[0] = i11;
        return new b(this, iArr);
    }

    public int f(int i10) {
        if (i10 != 0) {
            return this.f21847b[i10];
        }
        throw new IllegalArgumentException();
    }

    public int g(int i10) {
        if (i10 != 0) {
            return this.f21846a[(this.f21850e - this.f21847b[i10]) - 1];
        }
        throw new ArithmeticException();
    }

    public int h(int i10, int i11) {
        if (i10 == 0 || i11 == 0) {
            return 0;
        }
        int[] iArr = this.f21846a;
        int[] iArr2 = this.f21847b;
        return iArr[(iArr2[i10] + iArr2[i11]) % (this.f21850e - 1)];
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f21851f) + ',' + this.f21850e + ')';
    }

    public a(int i10, int i11, int i12) {
        this.f21851f = i10;
        this.f21850e = i11;
        this.f21852g = i12;
        this.f21846a = new int[i11];
        this.f21847b = new int[i11];
        int i13 = 1;
        for (int i14 = 0; i14 < i11; i14++) {
            this.f21846a[i14] = i13;
            i13 *= 2;
            if (i13 >= i11) {
                i13 = (i13 ^ i10) & (i11 - 1);
            }
        }
        for (int i15 = 0; i15 < i11 - 1; i15++) {
            this.f21847b[this.f21846a[i15]] = i15;
        }
        this.f21848c = new b(this, new int[]{0});
        this.f21849d = new b(this, new int[]{1});
    }
}
