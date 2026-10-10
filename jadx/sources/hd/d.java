package hd;

import androidx.core.location.LocationRequestCompat;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f10953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10954d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f10955e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f10956f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f10957g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f10958h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f10959i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f10960j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int[] f10961k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f10962l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private k f10963m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private c f10964n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f10965o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f10966p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f10967q;

    private static int a(long j10) {
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < 64; i12++) {
            int i13 = (int) ((j10 >> i12) & 1);
            i11 |= i13;
            i10 += (i11 ^ 1) & (i13 ^ 1);
        }
        return i10;
    }

    private void g(short[] sArr, short[] sArr2, short[] sArr3) {
        for (int i10 = 0; i10 < this.f10951a; i10++) {
            sArr[i10] = b(sArr2, sArr3[i10]);
        }
    }

    private static long h(short s10, short s11) {
        return -((((long) (s10 ^ s11)) - 1) >>> 63);
    }

    private short b(short[] sArr, short s10) {
        int i10 = this.f10952b;
        short sA = sArr[i10];
        for (int i11 = i10 - 1; i11 >= 0; i11--) {
            sA = this.f10963m.a(this.f10963m.c(sA, s10), sArr[i11]);
        }
        return sA;
    }

    private int e(byte[][] bArr, short[] sArr, long[] jArr) {
        byte[] bArr2;
        long jC;
        int i10 = 64;
        long[] jArr2 = new long[64];
        int i11 = 32;
        long[] jArr3 = new long[32];
        byte[] bArr3 = new byte[9];
        int i12 = this.f10956f - 32;
        int i13 = i12 / 8;
        int i14 = i12 % 8;
        if (this.f10965o) {
            for (int i15 = 0; i15 < 32; i15++) {
                for (int i16 = 0; i16 < 9; i16++) {
                    bArr3[i16] = bArr[i12 + i15][i13 + i16];
                }
                int i17 = 0;
                while (i17 < 8) {
                    int i18 = i17 + 1;
                    bArr3[i17] = (byte) (((bArr3[i17] & 255) >> i14) | (bArr3[i18] << (8 - i14)));
                    i17 = i18;
                }
                jArr2[i15] = l.c(bArr3, 0);
            }
        } else {
            for (int i19 = 0; i19 < 32; i19++) {
                jArr2[i19] = l.c(bArr[i12 + i19], i13);
            }
        }
        long j10 = 0;
        jArr[0] = 0;
        int i20 = 0;
        while (i20 < 32) {
            long j11 = jArr2[i20];
            int i21 = i20 + 1;
            long j12 = j10;
            for (int i22 = i21; i22 < 32; i22++) {
                j11 |= jArr2[i22];
            }
            if (j11 == j12) {
                return -1;
            }
            int iA = a(j11);
            long j13 = iA;
            jArr3[i20] = j13;
            jArr[0] = jArr[0] | (1 << ((int) j13));
            for (int i23 = i21; i23 < 32; i23++) {
                long j14 = jArr2[i20];
                jArr2[i20] = j14 ^ (jArr2[i23] & (((j14 >> iA) & 1) - 1));
            }
            int i24 = i21;
            while (i24 < 32) {
                long j15 = jArr2[i24];
                jArr2[i24] = j15 ^ (jArr2[i20] & (-((j15 >> iA) & 1)));
                i24++;
                bArr3 = bArr3;
            }
            i20 = i21;
            j10 = j12;
        }
        byte[] bArr4 = bArr3;
        int i25 = 0;
        int i26 = 0;
        while (i26 < 32) {
            int i27 = i26 + 1;
            int i28 = i27;
            while (i28 < i10) {
                int i29 = i12 + i26;
                int i30 = i12 + i28;
                int i31 = i26;
                long jH = ((long) (sArr[i29] ^ sArr[i30])) & h((short) i28, (short) jArr3[i31]);
                sArr[i29] = (short) (((long) sArr[i29]) ^ jH);
                sArr[i30] = (short) (jH ^ ((long) sArr[i30]));
                i28++;
                i26 = i31;
                i10 = 64;
            }
            i26 = i27;
        }
        int i32 = 0;
        while (i32 < this.f10956f) {
            if (this.f10965o) {
                for (int i33 = 0; i33 < 9; i33++) {
                    bArr4[i33] = bArr[i32][i13 + i33];
                }
                int i34 = 0;
                while (i34 < 8) {
                    int i35 = i34 + 1;
                    bArr4[i34] = (byte) (((bArr4[i34] & 255) >> i14) | (bArr4[i35] << (8 - i14)));
                    i34 = i35;
                }
                bArr2 = bArr4;
                jC = l.c(bArr2, i25);
            } else {
                bArr2 = bArr4;
                jC = l.c(bArr[i32], i13);
            }
            int i36 = 0;
            while (i36 < i11) {
                long[] jArr4 = jArr3;
                long j16 = jArr4[i36];
                long j17 = ((jC >> i36) ^ (jC >> ((int) j16))) & 1;
                long j18 = ((j17 << ((int) j16)) ^ jC) ^ (j17 << i36);
                i36++;
                jC = j18;
                jArr3 = jArr4;
                i11 = 32;
            }
            long[] jArr5 = jArr3;
            if (this.f10965o) {
                l.e(bArr2, 0, jC);
                byte[] bArr5 = bArr[i32];
                int i37 = i13 + 8;
                int i38 = 8 - i14;
                bArr5[i37] = (byte) ((((bArr5[i37] & 255) >>> i14) << i14) | ((bArr2[7] & 255) >>> i38));
                bArr5[i13] = (byte) (((bArr2[0] & 255) << i14) | (((bArr5[i13] & 255) << i38) >>> i38));
                for (int i39 = 7; i39 >= 1; i39--) {
                    bArr[i32][i13 + i39] = (byte) (((bArr2[i39] & 255) << i14) | ((bArr2[i39 - 1] & 255) >>> i38));
                }
            } else {
                l.e(bArr[i32], i13, jC);
            }
            i32++;
            bArr4 = bArr2;
            jArr3 = jArr5;
            i11 = 32;
            i25 = 0;
        }
        return i25;
    }

    private int f(byte[] bArr, byte[] bArr2, int[] iArr, short[] sArr, long[] jArr) {
        int i10;
        int i11;
        int i12 = this.f10952b;
        short[] sArr2 = new short[i12 + 1];
        sArr2[i12] = 1;
        for (int i13 = 0; i13 < this.f10952b; i13++) {
            sArr2[i13] = l.d(bArr2, (i13 * 2) + 40, this.f10960j);
        }
        int i14 = 1 << this.f10953c;
        long[] jArr2 = new long[i14];
        for (int i15 = 0; i15 < (1 << this.f10953c); i15++) {
            long j10 = iArr[i15];
            jArr2[i15] = j10;
            long j11 = j10 << 31;
            jArr2[i15] = j11;
            long j12 = j11 | ((long) i15);
            jArr2[i15] = j12;
            jArr2[i15] = j12 & LocationRequestCompat.PASSIVE_INTERVAL;
        }
        i(jArr2, 0, i14);
        for (int i16 = 1; i16 < (1 << this.f10953c); i16++) {
            if ((jArr2[i16 - 1] >> 31) == (jArr2[i16] >> 31)) {
                return -1;
            }
        }
        short[] sArr3 = new short[this.f10951a];
        for (int i17 = 0; i17 < (1 << this.f10953c); i17++) {
            sArr[i17] = (short) (jArr2[i17] & ((long) this.f10960j));
        }
        int i18 = 0;
        while (true) {
            i10 = this.f10951a;
            if (i18 >= i10) {
                break;
            }
            sArr3[i18] = l.a(sArr[i18], this.f10953c);
            i18++;
        }
        short[] sArr4 = new short[i10];
        g(sArr4, sArr2, sArr3);
        int i19 = 0;
        while (true) {
            i11 = this.f10951a;
            if (i19 >= i11) {
                break;
            }
            sArr4[i19] = this.f10963m.b(sArr4[i19]);
            i19++;
        }
        byte[][] bArr3 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, this.f10956f, i11 / 8);
        for (int i20 = 0; i20 < this.f10956f; i20++) {
            for (int i21 = 0; i21 < this.f10951a / 8; i21++) {
                bArr3[i20][i21] = 0;
            }
        }
        for (int i22 = 0; i22 < this.f10952b; i22++) {
            for (int i23 = 0; i23 < this.f10951a; i23 += 8) {
                int i24 = 0;
                while (true) {
                    int i25 = this.f10953c;
                    if (i24 < i25) {
                        bArr3[(i25 * i22) + i24][i23 / 8] = (byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) ((sArr4[i23 + 7] >>> i24) & 1)) << 1)) | ((sArr4[i23 + 6] >>> i24) & 1))) << 1)) | ((sArr4[i23 + 5] >>> i24) & 1))) << 1)) | ((sArr4[i23 + 4] >>> i24) & 1))) << 1)) | ((sArr4[i23 + 3] >>> i24) & 1))) << 1)) | ((sArr4[i23 + 2] >>> i24) & 1))) << 1)) | ((sArr4[i23 + 1] >>> i24) & 1))) << 1)) | ((sArr4[i23] >>> i24) & 1));
                        i24++;
                    }
                }
            }
            for (int i26 = 0; i26 < this.f10951a; i26++) {
                sArr4[i26] = this.f10963m.c(sArr4[i26], sArr3[i26]);
            }
        }
        int i27 = 0;
        while (true) {
            int i28 = this.f10956f;
            if (i27 >= (i28 + 7) / 8) {
                if (bArr != null) {
                    if (this.f10965o) {
                        int i29 = i28 % 8;
                        int i30 = 0;
                        int i31 = 0;
                        while (true) {
                            int i32 = this.f10956f;
                            if (i30 >= i32) {
                                break;
                            }
                            int i33 = (i32 - 1) / 8;
                            while (i33 < (this.f10951a / 8) - 1) {
                                byte[] bArr4 = bArr3[i30];
                                int i34 = (bArr4[i33] & 255) >>> i29;
                                i33++;
                                bArr[i31] = (byte) ((bArr4[i33] << (8 - i29)) | i34);
                                i31++;
                            }
                            bArr[i31] = (byte) ((bArr3[i30][i33] & 255) >>> i29);
                            i30++;
                            i31++;
                        }
                    } else {
                        for (int i35 = 0; i35 < this.f10956f; i35++) {
                            int i36 = 0;
                            int i37 = 0;
                            while (true) {
                                int i38 = this.f10951a;
                                int i39 = this.f10956f;
                                if (i36 < ((i38 - i39) + 7) / 8) {
                                    bArr[((((i38 - i39) + 7) / 8) * i35) + i37] = bArr3[i35][(i39 / 8) + i36];
                                    i37++;
                                    i36++;
                                }
                            }
                        }
                    }
                }
                return 0;
            }
            for (int i40 = 0; i40 < 8; i40++) {
                int i41 = (i27 * 8) + i40;
                int i42 = this.f10956f;
                if (i41 >= i42) {
                    break;
                }
                if (this.f10967q && i41 == i42 - 32) {
                    if (e(bArr3, sArr, jArr) != 0) {
                        return -1;
                    }
                }
                for (int i43 = i41 + 1; i43 < this.f10956f; i43++) {
                    byte b10 = (byte) (-((byte) (((byte) (((byte) (bArr3[i41][i27] ^ bArr3[i43][i27])) >> i40)) & 1)));
                    for (int i44 = 0; i44 < this.f10951a / 8; i44++) {
                        byte[] bArr5 = bArr3[i41];
                        bArr5[i44] = (byte) (bArr5[i44] ^ (bArr3[i43][i44] & b10));
                    }
                }
                if (((bArr3[i41][i27] >> i40) & 1) == 0) {
                    return -1;
                }
                for (int i45 = 0; i45 < this.f10956f; i45++) {
                    if (i45 != i41) {
                        byte b11 = (byte) (-((byte) (((byte) (bArr3[i45][i27] >> i40)) & 1)));
                        for (int i46 = 0; i46 < this.f10951a / 8; i46++) {
                            byte[] bArr6 = bArr3[i45];
                            bArr6[i46] = (byte) (bArr6[i46] ^ (bArr3[i41][i46] & b11));
                        }
                    }
                }
            }
            i27++;
        }
    }

    private static void i(long[] jArr, int i10, int i11) {
        int i12 = i11 - i10;
        if (i12 < 2) {
            return;
        }
        int i13 = 1;
        while (i13 < i12 - i13) {
            i13 += i13;
        }
        for (int i14 = i13; i14 > 0; i14 >>>= 1) {
            int i15 = 0;
            for (int i16 = 0; i16 < i12 - i14; i16++) {
                if ((i16 & i14) == 0) {
                    int i17 = i10 + i16;
                    int i18 = i17 + i14;
                    long j10 = jArr[i18];
                    long j11 = jArr[i17];
                    long j12 = (j10 ^ j11) & (-((j10 - j11) >>> 63));
                    jArr[i17] = j11 ^ j12;
                    jArr[i18] = jArr[i18] ^ j12;
                }
            }
            for (int i19 = i13; i19 > i14; i19 >>>= 1) {
                while (i15 < i12 - i19) {
                    if ((i15 & i14) == 0) {
                        int i20 = i10 + i15;
                        int i21 = i20 + i14;
                        long j13 = jArr[i21];
                        for (int i22 = i19; i22 > i14; i22 >>>= 1) {
                            int i23 = i20 + i22;
                            long j14 = jArr[i23];
                            long j15 = (-((j14 - j13) >>> 63)) & (j13 ^ j14);
                            j13 ^= j15;
                            jArr[i23] = j14 ^ j15;
                        }
                        jArr[i21] = j13;
                    }
                    i15++;
                }
            }
        }
    }

    public int d() {
        if (!this.f10965o) {
            return (this.f10956f * this.f10957g) / 8;
        }
        int i10 = this.f10956f;
        return i10 * ((this.f10951a / 8) - ((i10 - 1) / 8));
    }

    public d(int i10, int i11, int i12, int[] iArr, boolean z10, int i13) {
        c bVar;
        boolean z11;
        this.f10967q = z10;
        this.f10951a = i11;
        this.f10952b = i12;
        this.f10953c = i10;
        this.f10961k = iArr;
        this.f10962l = i13;
        this.f10954d = i12 * 2;
        this.f10955e = (1 << (i10 - 4)) * ((i10 * 2) - 1);
        int i14 = i12 * i10;
        this.f10956f = i14;
        int i15 = i11 - i14;
        this.f10957g = i15;
        this.f10958h = (i15 + 7) / 8;
        this.f10959i = (i14 + 7) / 8;
        this.f10960j = (1 << i10) - 1;
        if (i10 == 12) {
            this.f10963m = new i(i10);
            bVar = new a(this.f10951a, this.f10952b, this.f10953c);
        } else {
            this.f10963m = new j(i10);
            bVar = new b(this.f10951a, this.f10952b, this.f10953c);
        }
        this.f10964n = bVar;
        if (this.f10952b % 8 != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.f10965o = z11;
        this.f10966p = (1 << this.f10953c) > this.f10951a;
    }

    public byte[] c(byte[] bArr) {
        byte[] bArr2 = new byte[d()];
        int i10 = this.f10953c;
        short[] sArr = new short[1 << i10];
        long[] jArr = {0};
        int[] iArr = new int[1 << i10];
        int i11 = (this.f10951a / 8) + ((1 << i10) * 4);
        byte[] bArr3 = new byte[i11];
        int i12 = ((i11 - 32) - this.f10954d) - ((1 << i10) * 4);
        vc.k kVar = new vc.k(256);
        kVar.c((byte) 64);
        kVar.update(bArr, 0, 32);
        kVar.d(bArr3, 0, i11);
        for (int i13 = 0; i13 < (1 << this.f10953c); i13++) {
            iArr[i13] = l.b(bArr3, (i13 * 4) + i12);
        }
        f(bArr2, bArr, iArr, sArr, jArr);
        return bArr2;
    }
}
