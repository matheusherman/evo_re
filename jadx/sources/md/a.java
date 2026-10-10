package md;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class a {
    private int A;
    private int[] B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f15751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f15752d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f15753e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f15754f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f15755g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f15756h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f15757i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f15758j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f15759k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f15760l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private pe.a f15761m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private pe.c f15762n;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f15767s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f15768t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f15769u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f15770v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f15771w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f15772x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f15773y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f15774z;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f15763o = 40;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private byte f15764p = 3;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private byte f15765q = 4;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private byte f15766r = 5;
    private int C = 64;

    public a(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int[] iArr) {
        this.f15749a = i10;
        this.f15752d = i13;
        this.f15753e = i15;
        this.f15754f = i16;
        this.f15755g = i17;
        this.f15756h = i18;
        this.f15750b = i11;
        this.f15751c = i12;
        int i21 = i11 * i12;
        this.f15768t = i21;
        this.B = iArr;
        this.f15757i = i14;
        this.f15758j = i19;
        this.f15759k = i20;
        this.f15760l = (int) Math.ceil(i12 / 128);
        this.f15767s = f.b(i10);
        this.f15770v = i13;
        this.f15769u = f.a(i10);
        this.f15771w = f.b(i13);
        this.f15772x = f.b(i11);
        this.f15773y = f.a(i21);
        this.f15774z = f.b(i21);
        this.A = f.b(i11);
        pe.a aVar = new pe.a(1);
        this.f15761m = aVar;
        this.f15762n = new pe.c(aVar, i10).b(0);
    }
}
