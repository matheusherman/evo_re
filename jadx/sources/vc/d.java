package vc;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class d extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f19795e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f19796f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f19797g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f19798h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int[] f19799i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f19800j;

    public d() {
        this(tc.d.ANY);
    }

    private int k(int i10, int i11, int i12) {
        return ((~i10) & i12) | (i11 & i10);
    }

    private int l(int i10, int i11, int i12) {
        return (i10 & i12) | (i11 & (~i12));
    }

    private int m(int i10, int i11, int i12) {
        return (i10 ^ i11) ^ i12;
    }

    private int n(int i10, int i11, int i12) {
        return (i10 | (~i12)) ^ i11;
    }

    @Override // vc.a
    protected void g() {
        int i10 = this.f19795e;
        int i11 = this.f19796f;
        int i12 = this.f19797g;
        int i13 = this.f19798h;
        int iO = o(((i10 + k(i11, i12, i13)) + this.f19799i[0]) - 680876936, 7) + i11;
        int iO2 = o(((i13 + k(iO, i11, i12)) + this.f19799i[1]) - 389564586, 12) + iO;
        int iO3 = o(i12 + k(iO2, iO, i11) + this.f19799i[2] + 606105819, 17) + iO2;
        int iO4 = o(((i11 + k(iO3, iO2, iO)) + this.f19799i[3]) - 1044525330, 22) + iO3;
        int iO5 = o(((iO + k(iO4, iO3, iO2)) + this.f19799i[4]) - 176418897, 7) + iO4;
        int iO6 = o(iO2 + k(iO5, iO4, iO3) + this.f19799i[5] + 1200080426, 12) + iO5;
        int iO7 = o(((iO3 + k(iO6, iO5, iO4)) + this.f19799i[6]) - 1473231341, 17) + iO6;
        int iO8 = o(((iO4 + k(iO7, iO6, iO5)) + this.f19799i[7]) - 45705983, 22) + iO7;
        int iO9 = o(iO5 + k(iO8, iO7, iO6) + this.f19799i[8] + 1770035416, 7) + iO8;
        int iO10 = o(((iO6 + k(iO9, iO8, iO7)) + this.f19799i[9]) - 1958414417, 12) + iO9;
        int iO11 = o(((iO7 + k(iO10, iO9, iO8)) + this.f19799i[10]) - 42063, 17) + iO10;
        int iO12 = o(((iO8 + k(iO11, iO10, iO9)) + this.f19799i[11]) - 1990404162, 22) + iO11;
        int iO13 = o(iO9 + k(iO12, iO11, iO10) + this.f19799i[12] + 1804603682, 7) + iO12;
        int iO14 = o(((iO10 + k(iO13, iO12, iO11)) + this.f19799i[13]) - 40341101, 12) + iO13;
        int iO15 = o(((iO11 + k(iO14, iO13, iO12)) + this.f19799i[14]) - 1502002290, 17) + iO14;
        int iO16 = o(iO12 + k(iO15, iO14, iO13) + this.f19799i[15] + 1236535329, 22) + iO15;
        int iO17 = o(((iO13 + l(iO16, iO15, iO14)) + this.f19799i[1]) - 165796510, 5) + iO16;
        int iO18 = o(((iO14 + l(iO17, iO16, iO15)) + this.f19799i[6]) - 1069501632, 9) + iO17;
        int iO19 = o(iO15 + l(iO18, iO17, iO16) + this.f19799i[11] + 643717713, 14) + iO18;
        int iO20 = o(((iO16 + l(iO19, iO18, iO17)) + this.f19799i[0]) - 373897302, 20) + iO19;
        int iO21 = o(((iO17 + l(iO20, iO19, iO18)) + this.f19799i[5]) - 701558691, 5) + iO20;
        int iO22 = o(iO18 + l(iO21, iO20, iO19) + this.f19799i[10] + 38016083, 9) + iO21;
        int iO23 = o(((iO19 + l(iO22, iO21, iO20)) + this.f19799i[15]) - 660478335, 14) + iO22;
        int iO24 = o(((iO20 + l(iO23, iO22, iO21)) + this.f19799i[4]) - 405537848, 20) + iO23;
        int iO25 = o(iO21 + l(iO24, iO23, iO22) + this.f19799i[9] + 568446438, 5) + iO24;
        int iO26 = o(((iO22 + l(iO25, iO24, iO23)) + this.f19799i[14]) - 1019803690, 9) + iO25;
        int iO27 = o(((iO23 + l(iO26, iO25, iO24)) + this.f19799i[3]) - 187363961, 14) + iO26;
        int iO28 = o(iO24 + l(iO27, iO26, iO25) + this.f19799i[8] + 1163531501, 20) + iO27;
        int iO29 = o(((iO25 + l(iO28, iO27, iO26)) + this.f19799i[13]) - 1444681467, 5) + iO28;
        int iO30 = o(((iO26 + l(iO29, iO28, iO27)) + this.f19799i[2]) - 51403784, 9) + iO29;
        int iO31 = o(iO27 + l(iO30, iO29, iO28) + this.f19799i[7] + 1735328473, 14) + iO30;
        int iO32 = o(((iO28 + l(iO31, iO30, iO29)) + this.f19799i[12]) - 1926607734, 20) + iO31;
        int iO33 = o(((iO29 + m(iO32, iO31, iO30)) + this.f19799i[5]) - 378558, 4) + iO32;
        int iO34 = o(((iO30 + m(iO33, iO32, iO31)) + this.f19799i[8]) - 2022574463, 11) + iO33;
        int iO35 = o(iO31 + m(iO34, iO33, iO32) + this.f19799i[11] + 1839030562, 16) + iO34;
        int iO36 = o(((iO32 + m(iO35, iO34, iO33)) + this.f19799i[14]) - 35309556, 23) + iO35;
        int iO37 = o(((iO33 + m(iO36, iO35, iO34)) + this.f19799i[1]) - 1530992060, 4) + iO36;
        int iO38 = o(iO34 + m(iO37, iO36, iO35) + this.f19799i[4] + 1272893353, 11) + iO37;
        int iO39 = o(((iO35 + m(iO38, iO37, iO36)) + this.f19799i[7]) - 155497632, 16) + iO38;
        int iO40 = o(((iO36 + m(iO39, iO38, iO37)) + this.f19799i[10]) - 1094730640, 23) + iO39;
        int iO41 = o(iO37 + m(iO40, iO39, iO38) + this.f19799i[13] + 681279174, 4) + iO40;
        int iO42 = o(((iO38 + m(iO41, iO40, iO39)) + this.f19799i[0]) - 358537222, 11) + iO41;
        int iO43 = o(((iO39 + m(iO42, iO41, iO40)) + this.f19799i[3]) - 722521979, 16) + iO42;
        int iO44 = o(iO40 + m(iO43, iO42, iO41) + this.f19799i[6] + 76029189, 23) + iO43;
        int iO45 = o(((iO41 + m(iO44, iO43, iO42)) + this.f19799i[9]) - 640364487, 4) + iO44;
        int iO46 = o(((iO42 + m(iO45, iO44, iO43)) + this.f19799i[12]) - 421815835, 11) + iO45;
        int iO47 = o(iO43 + m(iO46, iO45, iO44) + this.f19799i[15] + 530742520, 16) + iO46;
        int iO48 = o(((iO44 + m(iO47, iO46, iO45)) + this.f19799i[2]) - 995338651, 23) + iO47;
        int iO49 = o(((iO45 + n(iO48, iO47, iO46)) + this.f19799i[0]) - 198630844, 6) + iO48;
        int iO50 = o(iO46 + n(iO49, iO48, iO47) + this.f19799i[7] + 1126891415, 10) + iO49;
        int iO51 = o(((iO47 + n(iO50, iO49, iO48)) + this.f19799i[14]) - 1416354905, 15) + iO50;
        int iO52 = o(((iO48 + n(iO51, iO50, iO49)) + this.f19799i[5]) - 57434055, 21) + iO51;
        int iO53 = o(iO49 + n(iO52, iO51, iO50) + this.f19799i[12] + 1700485571, 6) + iO52;
        int iO54 = o(((iO50 + n(iO53, iO52, iO51)) + this.f19799i[3]) - 1894986606, 10) + iO53;
        int iO55 = o(((iO51 + n(iO54, iO53, iO52)) + this.f19799i[10]) - 1051523, 15) + iO54;
        int iO56 = o(((iO52 + n(iO55, iO54, iO53)) + this.f19799i[1]) - 2054922799, 21) + iO55;
        int iO57 = o(iO53 + n(iO56, iO55, iO54) + this.f19799i[8] + 1873313359, 6) + iO56;
        int iO58 = o(((iO54 + n(iO57, iO56, iO55)) + this.f19799i[15]) - 30611744, 10) + iO57;
        int iO59 = o(((iO55 + n(iO58, iO57, iO56)) + this.f19799i[6]) - 1560198380, 15) + iO58;
        int iO60 = o(iO56 + n(iO59, iO58, iO57) + this.f19799i[13] + 1309151649, 21) + iO59;
        int iO61 = o(((iO57 + n(iO60, iO59, iO58)) + this.f19799i[4]) - 145523070, 6) + iO60;
        int iO62 = o(((iO58 + n(iO61, iO60, iO59)) + this.f19799i[11]) - 1120210379, 10) + iO61;
        int iO63 = o(iO59 + n(iO62, iO61, iO60) + this.f19799i[2] + 718787259, 15) + iO62;
        int iO64 = o(((iO60 + n(iO63, iO62, iO61)) + this.f19799i[9]) - 343485551, 21) + iO63;
        this.f19795e += iO61;
        this.f19796f += iO64;
        this.f19797g += iO63;
        this.f19798h += iO62;
        this.f19800j = 0;
        int i14 = 0;
        while (true) {
            int[] iArr = this.f19799i;
            if (i14 == iArr.length) {
                return;
            }
            iArr[i14] = 0;
            i14++;
        }
    }

    public d(tc.d dVar) {
        super(dVar);
        this.f19799i = new int[16];
        tc.g.a(l.a(this, 64, dVar));
        j();
    }

    private int o(int i10, int i11) {
        return (i10 >>> (32 - i11)) | (i10 << i11);
    }

    @Override // tc.i
    public String a() {
        return "MD5";
    }

    @Override // tc.i
    public int e() {
        return 16;
    }

    @Override // vc.a
    protected void h(long j10) {
        if (this.f19800j > 14) {
            g();
        }
        int[] iArr = this.f19799i;
        iArr[14] = (int) j10;
        iArr[15] = (int) (j10 >>> 32);
    }

    @Override // vc.a
    protected void i(byte[] bArr, int i10) {
        int[] iArr = this.f19799i;
        int i11 = this.f19800j;
        this.f19800j = i11 + 1;
        iArr[i11] = re.f.f(bArr, i10);
        if (this.f19800j == 16) {
            g();
        }
    }

    @Override // tc.i
    public int b(byte[] bArr, int i10) {
        f();
        re.f.e(this.f19795e, bArr, i10);
        re.f.e(this.f19796f, bArr, i10 + 4);
        re.f.e(this.f19797g, bArr, i10 + 8);
        re.f.e(this.f19798h, bArr, i10 + 12);
        j();
        return 16;
    }

    @Override // vc.a
    public void j() {
        super.j();
        this.f19795e = 1732584193;
        this.f19796f = -271733879;
        this.f19797g = -1732584194;
        this.f19798h = 271733878;
        this.f19800j = 0;
        int i10 = 0;
        while (true) {
            int[] iArr = this.f19799i;
            if (i10 != iArr.length) {
                iArr[i10] = 0;
                i10++;
            } else {
                return;
            }
        }
    }
}
