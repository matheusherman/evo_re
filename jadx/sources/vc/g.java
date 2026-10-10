package vc;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class g extends a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final int[] f19819o = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f19820e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f19821f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f19822g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f19823h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f19824i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f19825j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f19826k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f19827l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int[] f19828m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f19829n;

    public g() {
        this(tc.d.ANY);
    }

    private static int k(int i10, int i11, int i12) {
        return ((~i10) & i12) ^ (i11 & i10);
    }

    public g(tc.d dVar) {
        super(dVar);
        this.f19828m = new int[64];
        tc.g.a(q());
        j();
    }

    private static int l(int i10, int i11, int i12) {
        return ((i10 ^ i11) & i12) | (i10 & i11);
    }

    private static int m(int i10) {
        return ((i10 << 10) | (i10 >>> 22)) ^ (((i10 >>> 2) | (i10 << 30)) ^ ((i10 >>> 13) | (i10 << 19)));
    }

    private static int n(int i10) {
        return ((i10 << 7) | (i10 >>> 25)) ^ (((i10 >>> 6) | (i10 << 26)) ^ ((i10 >>> 11) | (i10 << 21)));
    }

    private static int o(int i10) {
        return (i10 >>> 3) ^ (((i10 >>> 7) | (i10 << 25)) ^ ((i10 >>> 18) | (i10 << 14)));
    }

    private static int p(int i10) {
        return (i10 >>> 10) ^ (((i10 >>> 17) | (i10 << 15)) ^ ((i10 >>> 19) | (i10 << 13)));
    }

    @Override // tc.i
    public String a() {
        return "SHA-256";
    }

    @Override // tc.i
    public int e() {
        return 32;
    }

    @Override // vc.a
    protected void g() {
        for (int i10 = 16; i10 <= 63; i10++) {
            int[] iArr = this.f19828m;
            int iP = p(iArr[i10 - 2]);
            int[] iArr2 = this.f19828m;
            iArr[i10] = iP + iArr2[i10 - 7] + o(iArr2[i10 - 15]) + this.f19828m[i10 - 16];
        }
        int iM = this.f19820e;
        int iM2 = this.f19821f;
        int iM3 = this.f19822g;
        int iM4 = this.f19823h;
        int i11 = this.f19824i;
        int i12 = this.f19825j;
        int i13 = this.f19826k;
        int i14 = this.f19827l;
        int i15 = 0;
        for (int i16 = 0; i16 < 8; i16++) {
            int iN = n(i11) + k(i11, i12, i13);
            int[] iArr3 = f19819o;
            int i17 = i14 + iN + iArr3[i15] + this.f19828m[i15];
            int i18 = iM4 + i17;
            int iM5 = i17 + m(iM) + l(iM, iM2, iM3);
            int i19 = i15 + 1;
            int iN2 = i13 + n(i18) + k(i18, i11, i12) + iArr3[i19] + this.f19828m[i19];
            int i20 = iM3 + iN2;
            int iM6 = iN2 + m(iM5) + l(iM5, iM, iM2);
            int i21 = i15 + 2;
            int iN3 = i12 + n(i20) + k(i20, i18, i11) + iArr3[i21] + this.f19828m[i21];
            int i22 = iM2 + iN3;
            int iM7 = iN3 + m(iM6) + l(iM6, iM5, iM);
            int i23 = i15 + 3;
            int iN4 = i11 + n(i22) + k(i22, i20, i18) + iArr3[i23] + this.f19828m[i23];
            int i24 = iM + iN4;
            int iM8 = iN4 + m(iM7) + l(iM7, iM6, iM5);
            int i25 = i15 + 4;
            int iN5 = i18 + n(i24) + k(i24, i22, i20) + iArr3[i25] + this.f19828m[i25];
            i14 = iM5 + iN5;
            iM4 = iN5 + m(iM8) + l(iM8, iM7, iM6);
            int i26 = i15 + 5;
            int iN6 = i20 + n(i14) + k(i14, i24, i22) + iArr3[i26] + this.f19828m[i26];
            i13 = iM6 + iN6;
            iM3 = iN6 + m(iM4) + l(iM4, iM8, iM7);
            int i27 = i15 + 6;
            int iN7 = i22 + n(i13) + k(i13, i14, i24) + iArr3[i27] + this.f19828m[i27];
            i12 = iM7 + iN7;
            iM2 = iN7 + m(iM3) + l(iM3, iM4, iM8);
            int i28 = i15 + 7;
            int iN8 = i24 + n(i12) + k(i12, i13, i14) + iArr3[i28] + this.f19828m[i28];
            i11 = iM8 + iN8;
            iM = iN8 + m(iM2) + l(iM2, iM3, iM4);
            i15 += 8;
        }
        this.f19820e += iM;
        this.f19821f += iM2;
        this.f19822g += iM3;
        this.f19823h += iM4;
        this.f19824i += i11;
        this.f19825j += i12;
        this.f19826k += i13;
        this.f19827l += i14;
        this.f19829n = 0;
        for (int i29 = 0; i29 < 16; i29++) {
            this.f19828m[i29] = 0;
        }
    }

    @Override // vc.a
    protected void h(long j10) {
        if (this.f19829n > 14) {
            g();
        }
        int[] iArr = this.f19828m;
        iArr[14] = (int) (j10 >>> 32);
        iArr[15] = (int) j10;
    }

    @Override // vc.a
    protected void i(byte[] bArr, int i10) {
        this.f19828m[this.f19829n] = re.f.a(bArr, i10);
        int i11 = this.f19829n + 1;
        this.f19829n = i11;
        if (i11 == 16) {
            g();
        }
    }

    protected tc.c q() {
        return l.a(this, 256, this.f19767a);
    }

    @Override // tc.i
    public int b(byte[] bArr, int i10) {
        f();
        re.f.c(this.f19820e, bArr, i10);
        re.f.c(this.f19821f, bArr, i10 + 4);
        re.f.c(this.f19822g, bArr, i10 + 8);
        re.f.c(this.f19823h, bArr, i10 + 12);
        re.f.c(this.f19824i, bArr, i10 + 16);
        re.f.c(this.f19825j, bArr, i10 + 20);
        re.f.c(this.f19826k, bArr, i10 + 24);
        re.f.c(this.f19827l, bArr, i10 + 28);
        j();
        return 32;
    }

    @Override // vc.a
    public void j() {
        super.j();
        this.f19820e = 1779033703;
        this.f19821f = -1150833019;
        this.f19822g = 1013904242;
        this.f19823h = -1521486534;
        this.f19824i = 1359893119;
        this.f19825j = -1694144372;
        this.f19826k = 528734635;
        this.f19827l = 1541459225;
        this.f19829n = 0;
        int i10 = 0;
        while (true) {
            int[] iArr = this.f19828m;
            if (i10 != iArr.length) {
                iArr[i10] = 0;
                i10++;
            } else {
                return;
            }
        }
    }
}
