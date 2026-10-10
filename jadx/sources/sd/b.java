package sd;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f18597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f18598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f18599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f18600d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f18601e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f18602f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f18603g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f18604h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f18605i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f18606j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f18607k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f18608l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f18609m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f18610n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int f18611o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final int f18612p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int f18613q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final g f18614r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final a f18615s;

    public int a() {
        return 10;
    }

    public int b() {
        return this.f18599c;
    }

    public int c() {
        return 32;
    }

    public int d() {
        return this.f18597a;
    }

    public int e() {
        return 256;
    }

    public int f() {
        return this.f18601e;
    }

    public g g() {
        return this.f18614r;
    }

    public b(int i10, int i11) {
        this.f18611o = i11;
        this.f18597a = i10;
        if (i10 == 2) {
            this.f18598b = 10;
            this.f18599c = 3;
        } else if (i10 == 3) {
            this.f18598b = 8;
            this.f18599c = 4;
        } else {
            this.f18598b = 6;
            this.f18599c = 6;
        }
        this.f18600d = (this.f18598b * 256) / 8;
        this.f18601e = TypedValues.CycleType.TYPE_PATH_ROTATE;
        int i12 = i10 * TypedValues.CycleType.TYPE_PATH_ROTATE;
        this.f18602f = i12;
        this.f18603g = 320;
        int i13 = i10 * 320;
        this.f18604h = i13;
        int i14 = this.f18599c;
        int i15 = (i14 * 256) / 8;
        this.f18605i = i15;
        int i16 = i13 + 32;
        this.f18606j = i16;
        this.f18607k = i12;
        this.f18608l = i16;
        this.f18609m = i12 + i16 + 64;
        this.f18610n = i13 + i15;
        this.f18612p = 4;
        this.f18613q = 260 - (1 << (9 - i14));
        this.f18614r = new g(this);
        this.f18615s = new a(this);
    }
}
