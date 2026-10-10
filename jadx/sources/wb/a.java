package wb;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class a extends b {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final byte[] f20454o = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final byte[] f20455p = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final byte[] f20456q = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final byte[] f20457j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final byte[] f20458k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final byte[] f20459l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f20460m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f20461n;

    public a() {
        this(0);
    }

    public static String u(byte[] bArr) {
        return c.d(s(bArr, false, true));
    }

    public a(boolean z10) {
        this(76, b.f20463i, z10);
    }

    public static byte[] r(String str) {
        return new a().f(str);
    }

    public static byte[] t(byte[] bArr, boolean z10, boolean z11, int i10) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a aVar = z10 ? new a(z11) : new a(0, b.f20463i, z11);
        long jM = aVar.m(bArr);
        if (jM <= i10) {
            return aVar.i(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + jM + ") than the specified maximum size of " + i10);
    }

    @Override // wb.b
    void e(byte[] bArr, int i10, int i11, b.a aVar) {
        byte b10;
        if (aVar.f20476f) {
            return;
        }
        if (i11 < 0) {
            aVar.f20476f = true;
        }
        int i12 = 0;
        while (i12 < i11) {
            byte[] bArrK = k(this.f20460m, aVar);
            int i13 = i10 + 1;
            byte b11 = bArr[i10];
            if (b11 == this.f20465b) {
                aVar.f20476f = true;
                break;
            }
            if (b11 >= 0) {
                byte[] bArr2 = f20456q;
                if (b11 < bArr2.length && (b10 = bArr2[b11]) >= 0) {
                    int i14 = (aVar.f20478h + 1) % 4;
                    aVar.f20478h = i14;
                    int i15 = (aVar.f20471a << 6) + b10;
                    aVar.f20471a = i15;
                    if (i14 == 0) {
                        int i16 = aVar.f20474d;
                        int i17 = i16 + 1;
                        aVar.f20474d = i17;
                        bArrK[i16] = (byte) ((i15 >> 16) & 255);
                        int i18 = i16 + 2;
                        aVar.f20474d = i18;
                        bArrK[i17] = (byte) ((i15 >> 8) & 255);
                        aVar.f20474d = i16 + 3;
                        bArrK[i18] = (byte) (i15 & 255);
                    }
                }
            }
            i12++;
            i10 = i13;
        }
        if (!aVar.f20476f || aVar.f20478h == 0) {
            return;
        }
        byte[] bArrK2 = k(this.f20460m, aVar);
        int i19 = aVar.f20478h;
        if (i19 == 1) {
            w();
            return;
        }
        if (i19 == 2) {
            v(15, aVar);
            int i20 = aVar.f20471a >> 4;
            aVar.f20471a = i20;
            int i21 = aVar.f20474d;
            aVar.f20474d = i21 + 1;
            bArrK2[i21] = (byte) (i20 & 255);
            return;
        }
        if (i19 != 3) {
            throw new IllegalStateException("Impossible modulus " + aVar.f20478h);
        }
        v(3, aVar);
        int i22 = aVar.f20471a;
        int i23 = i22 >> 2;
        aVar.f20471a = i23;
        int i24 = aVar.f20474d;
        int i25 = i24 + 1;
        aVar.f20474d = i25;
        bArrK2[i24] = (byte) ((i22 >> 10) & 255);
        aVar.f20474d = i24 + 2;
        bArrK2[i25] = (byte) (i23 & 255);
    }

    @Override // wb.b
    void h(byte[] bArr, int i10, int i11, b.a aVar) {
        if (aVar.f20476f) {
            return;
        }
        if (i11 >= 0) {
            int i12 = 0;
            while (i12 < i11) {
                byte[] bArrK = k(this.f20461n, aVar);
                int i13 = (aVar.f20478h + 1) % 3;
                aVar.f20478h = i13;
                int i14 = i10 + 1;
                int i15 = bArr[i10];
                if (i15 < 0) {
                    i15 += 256;
                }
                int i16 = (aVar.f20471a << 8) + i15;
                aVar.f20471a = i16;
                if (i13 == 0) {
                    int i17 = aVar.f20474d;
                    int i18 = i17 + 1;
                    aVar.f20474d = i18;
                    byte[] bArr2 = this.f20457j;
                    bArrK[i17] = bArr2[(i16 >> 18) & 63];
                    int i19 = i17 + 2;
                    aVar.f20474d = i19;
                    bArrK[i18] = bArr2[(i16 >> 12) & 63];
                    int i20 = i17 + 3;
                    aVar.f20474d = i20;
                    bArrK[i19] = bArr2[(i16 >> 6) & 63];
                    int i21 = i17 + 4;
                    aVar.f20474d = i21;
                    bArrK[i20] = bArr2[i16 & 63];
                    int i22 = aVar.f20477g + 4;
                    aVar.f20477g = i22;
                    int i23 = this.f20468e;
                    if (i23 > 0 && i23 <= i22) {
                        byte[] bArr3 = this.f20459l;
                        System.arraycopy(bArr3, 0, bArrK, i21, bArr3.length);
                        aVar.f20474d += this.f20459l.length;
                        aVar.f20477g = 0;
                    }
                }
                i12++;
                i10 = i14;
            }
            return;
        }
        aVar.f20476f = true;
        if (aVar.f20478h == 0 && this.f20468e == 0) {
            return;
        }
        byte[] bArrK2 = k(this.f20461n, aVar);
        int i24 = aVar.f20474d;
        int i25 = aVar.f20478h;
        if (i25 != 0) {
            if (i25 == 1) {
                int i26 = i24 + 1;
                aVar.f20474d = i26;
                byte[] bArr4 = this.f20457j;
                int i27 = aVar.f20471a;
                bArrK2[i24] = bArr4[(i27 >> 2) & 63];
                int i28 = i24 + 2;
                aVar.f20474d = i28;
                bArrK2[i26] = bArr4[(i27 << 4) & 63];
                if (bArr4 == f20454o) {
                    int i29 = i24 + 3;
                    aVar.f20474d = i29;
                    byte b10 = this.f20465b;
                    bArrK2[i28] = b10;
                    aVar.f20474d = i24 + 4;
                    bArrK2[i29] = b10;
                }
            } else {
                if (i25 != 2) {
                    throw new IllegalStateException("Impossible modulus " + aVar.f20478h);
                }
                int i30 = i24 + 1;
                aVar.f20474d = i30;
                byte[] bArr5 = this.f20457j;
                int i31 = aVar.f20471a;
                bArrK2[i24] = bArr5[(i31 >> 10) & 63];
                int i32 = i24 + 2;
                aVar.f20474d = i32;
                bArrK2[i30] = bArr5[(i31 >> 4) & 63];
                int i33 = i24 + 3;
                aVar.f20474d = i33;
                bArrK2[i32] = bArr5[(i31 << 2) & 63];
                if (bArr5 == f20454o) {
                    aVar.f20474d = i24 + 4;
                    bArrK2[i33] = this.f20465b;
                }
            }
        }
        int i34 = aVar.f20477g;
        int i35 = aVar.f20474d;
        int i36 = i34 + (i35 - i24);
        aVar.f20477g = i36;
        if (this.f20468e <= 0 || i36 <= 0) {
            return;
        }
        byte[] bArr6 = this.f20459l;
        System.arraycopy(bArr6, 0, bArrK2, i35, bArr6.length);
        aVar.f20474d += this.f20459l.length;
    }

    @Override // wb.b
    protected boolean n(byte b10) {
        if (b10 < 0) {
            return false;
        }
        byte[] bArr = this.f20458k;
        return b10 < bArr.length && bArr[b10] != -1;
    }

    public a(int i10) {
        this(i10, b.f20463i);
    }

    public static byte[] s(byte[] bArr, boolean z10, boolean z11) {
        return t(bArr, z10, z11, Integer.MAX_VALUE);
    }

    private void v(int i10, b.a aVar) {
        if (o() && (i10 & aVar.f20471a) != 0) {
            throw new IllegalArgumentException("Strict decoding: Last encoded character (before the paddings if any) is a valid base 64 alphabet but not a possible encoding. Expected the discarded bits from the character to be zero.");
        }
    }

    private void w() {
        if (!o()) {
        } else {
            throw new IllegalArgumentException("Strict decoding: Last encoded character (before the paddings if any) is a valid base 64 alphabet but not a possible encoding. Decoding requires at least two trailing 6-bit characters to create bytes.");
        }
    }

    public a(int i10, byte[] bArr) {
        this(i10, bArr, false);
    }

    public a(int i10, byte[] bArr, boolean z10) {
        this(i10, bArr, z10, b.f20462h);
    }

    public a(int i10, byte[] bArr, boolean z10, vb.a aVar) {
        super(3, 4, i10, bArr == null ? 0 : bArr.length, (byte) 61, aVar);
        this.f20458k = f20456q;
        if (bArr != null) {
            if (c(bArr)) {
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + c.e(bArr) + "]");
            }
            if (i10 > 0) {
                this.f20461n = bArr.length + 4;
                byte[] bArr2 = new byte[bArr.length];
                this.f20459l = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            } else {
                this.f20461n = 4;
                this.f20459l = null;
            }
        } else {
            this.f20461n = 4;
            this.f20459l = null;
        }
        this.f20460m = this.f20461n - 1;
        this.f20457j = z10 ? f20455p : f20454o;
    }
}
