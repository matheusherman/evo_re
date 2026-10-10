package vc;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class e extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f19801e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f19802f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f19803g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f19804h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f19805i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int[] f19806j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f19807k;

    public e() {
        this(tc.d.ANY);
    }

    private int l(int i10, int i11, int i12) {
        return ((~i10) & i12) | (i11 & i10);
    }

    private int n(int i10, int i11, int i12) {
        return (i10 ^ i11) ^ i12;
    }

    public e(tc.d dVar) {
        super(dVar);
        this.f19806j = new int[80];
        tc.g.a(k());
        j();
    }

    private int m(int i10, int i11, int i12) {
        return (i10 & (i11 | i12)) | (i11 & i12);
    }

    @Override // tc.i
    public String a() {
        return "SHA-1";
    }

    @Override // tc.i
    public int e() {
        return 20;
    }

    @Override // vc.a
    protected void g() {
        for (int i10 = 16; i10 < 80; i10++) {
            int[] iArr = this.f19806j;
            int i11 = ((iArr[i10 - 3] ^ iArr[i10 - 8]) ^ iArr[i10 - 14]) ^ iArr[i10 - 16];
            iArr[i10] = (i11 >>> 31) | (i11 << 1);
        }
        int iN = this.f19801e;
        int iN2 = this.f19802f;
        int i12 = this.f19803g;
        int i13 = this.f19804h;
        int i14 = this.f19805i;
        int i15 = 0;
        for (int i16 = 0; i16 < 4; i16++) {
            int iL = i14 + ((iN << 5) | (iN >>> 27)) + l(iN2, i12, i13) + this.f19806j[i15] + 1518500249;
            int i17 = (iN2 >>> 2) | (iN2 << 30);
            int iL2 = i13 + ((iL << 5) | (iL >>> 27)) + l(iN, i17, i12) + this.f19806j[i15 + 1] + 1518500249;
            int i18 = (iN >>> 2) | (iN << 30);
            int iL3 = i12 + ((iL2 << 5) | (iL2 >>> 27)) + l(iL, i18, i17) + this.f19806j[i15 + 2] + 1518500249;
            i14 = (iL >>> 2) | (iL << 30);
            int i19 = i15 + 4;
            iN2 = i17 + ((iL3 << 5) | (iL3 >>> 27)) + l(iL2, i14, i18) + this.f19806j[i15 + 3] + 1518500249;
            i13 = (iL2 >>> 2) | (iL2 << 30);
            i15 += 5;
            iN = i18 + ((iN2 << 5) | (iN2 >>> 27)) + l(iL3, i13, i14) + this.f19806j[i19] + 1518500249;
            i12 = (iL3 >>> 2) | (iL3 << 30);
        }
        for (int i20 = 0; i20 < 4; i20++) {
            int iN3 = i14 + ((iN << 5) | (iN >>> 27)) + n(iN2, i12, i13) + this.f19806j[i15] + 1859775393;
            int i21 = (iN2 >>> 2) | (iN2 << 30);
            int iN4 = i13 + ((iN3 << 5) | (iN3 >>> 27)) + n(iN, i21, i12) + this.f19806j[i15 + 1] + 1859775393;
            int i22 = (iN >>> 2) | (iN << 30);
            int iN5 = i12 + ((iN4 << 5) | (iN4 >>> 27)) + n(iN3, i22, i21) + this.f19806j[i15 + 2] + 1859775393;
            i14 = (iN3 >>> 2) | (iN3 << 30);
            int i23 = i15 + 4;
            iN2 = i21 + ((iN5 << 5) | (iN5 >>> 27)) + n(iN4, i14, i22) + this.f19806j[i15 + 3] + 1859775393;
            i13 = (iN4 >>> 2) | (iN4 << 30);
            i15 += 5;
            iN = i22 + ((iN2 << 5) | (iN2 >>> 27)) + n(iN5, i13, i14) + this.f19806j[i23] + 1859775393;
            i12 = (iN5 >>> 2) | (iN5 << 30);
        }
        for (int i24 = 0; i24 < 4; i24++) {
            int iM = i14 + (((((iN << 5) | (iN >>> 27)) + m(iN2, i12, i13)) + this.f19806j[i15]) - 1894007588);
            int i25 = (iN2 >>> 2) | (iN2 << 30);
            int iM2 = i13 + (((((iM << 5) | (iM >>> 27)) + m(iN, i25, i12)) + this.f19806j[i15 + 1]) - 1894007588);
            int i26 = (iN >>> 2) | (iN << 30);
            int iM3 = i12 + (((((iM2 << 5) | (iM2 >>> 27)) + m(iM, i26, i25)) + this.f19806j[i15 + 2]) - 1894007588);
            i14 = (iM >>> 2) | (iM << 30);
            int i27 = i15 + 4;
            iN2 = i25 + (((((iM3 << 5) | (iM3 >>> 27)) + m(iM2, i14, i26)) + this.f19806j[i15 + 3]) - 1894007588);
            i13 = (iM2 >>> 2) | (iM2 << 30);
            i15 += 5;
            iN = i26 + (((((iN2 << 5) | (iN2 >>> 27)) + m(iM3, i13, i14)) + this.f19806j[i27]) - 1894007588);
            i12 = (iM3 >>> 2) | (iM3 << 30);
        }
        for (int i28 = 0; i28 <= 3; i28++) {
            int iN6 = i14 + (((((iN << 5) | (iN >>> 27)) + n(iN2, i12, i13)) + this.f19806j[i15]) - 899497514);
            int i29 = (iN2 >>> 2) | (iN2 << 30);
            int iN7 = i13 + (((((iN6 << 5) | (iN6 >>> 27)) + n(iN, i29, i12)) + this.f19806j[i15 + 1]) - 899497514);
            int i30 = (iN >>> 2) | (iN << 30);
            int iN8 = i12 + (((((iN7 << 5) | (iN7 >>> 27)) + n(iN6, i30, i29)) + this.f19806j[i15 + 2]) - 899497514);
            i14 = (iN6 >>> 2) | (iN6 << 30);
            int i31 = i15 + 4;
            iN2 = i29 + (((((iN8 << 5) | (iN8 >>> 27)) + n(iN7, i14, i30)) + this.f19806j[i15 + 3]) - 899497514);
            i13 = (iN7 >>> 2) | (iN7 << 30);
            i15 += 5;
            iN = i30 + (((((iN2 << 5) | (iN2 >>> 27)) + n(iN8, i13, i14)) + this.f19806j[i31]) - 899497514);
            i12 = (iN8 >>> 2) | (iN8 << 30);
        }
        this.f19801e += iN;
        this.f19802f += iN2;
        this.f19803g += i12;
        this.f19804h += i13;
        this.f19805i += i14;
        this.f19807k = 0;
        for (int i32 = 0; i32 < 16; i32++) {
            this.f19806j[i32] = 0;
        }
    }

    @Override // vc.a
    protected void h(long j10) {
        if (this.f19807k > 14) {
            g();
        }
        int[] iArr = this.f19806j;
        iArr[14] = (int) (j10 >>> 32);
        iArr[15] = (int) j10;
    }

    @Override // vc.a
    protected void i(byte[] bArr, int i10) {
        this.f19806j[this.f19807k] = re.f.a(bArr, i10);
        int i11 = this.f19807k + 1;
        this.f19807k = i11;
        if (i11 == 16) {
            g();
        }
    }

    protected tc.c k() {
        return l.a(this, 128, this.f19767a);
    }

    @Override // tc.i
    public int b(byte[] bArr, int i10) {
        f();
        re.f.c(this.f19801e, bArr, i10);
        re.f.c(this.f19802f, bArr, i10 + 4);
        re.f.c(this.f19803g, bArr, i10 + 8);
        re.f.c(this.f19804h, bArr, i10 + 12);
        re.f.c(this.f19805i, bArr, i10 + 16);
        j();
        return 20;
    }

    @Override // vc.a
    public void j() {
        super.j();
        this.f19801e = 1732584193;
        this.f19802f = -271733879;
        this.f19803g = -1732584194;
        this.f19804h = 271733878;
        this.f19805i = -1009589776;
        this.f19807k = 0;
        int i10 = 0;
        while (true) {
            int[] iArr = this.f19806j;
            if (i10 != iArr.length) {
                iArr[i10] = 0;
                i10++;
            } else {
                return;
            }
        }
    }
}
