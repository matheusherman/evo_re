package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class r8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile int f2984a = 100;

    static int b(int i10, byte[] bArr, int i11, int i12, u8 u8Var) {
        if ((i10 >>> 3) == 0) {
            throw ma.b();
        }
        int i13 = i10 & 7;
        if (i13 == 0) {
            return t(bArr, i11, u8Var);
        }
        if (i13 == 1) {
            return i11 + 8;
        }
        if (i13 == 2) {
            return s(bArr, i11, u8Var) + u8Var.f3101a;
        }
        if (i13 != 3) {
            if (i13 == 5) {
                return i11 + 4;
            }
            throw ma.b();
        }
        int i14 = (i10 & (-8)) | 4;
        int i15 = 0;
        while (i11 < i12) {
            i11 = s(bArr, i11, u8Var);
            i15 = u8Var.f3101a;
            if (i15 == i14) {
                break;
            }
            i11 = b(i15, bArr, i11, i12, u8Var);
        }
        if (i11 > i12 || i15 != i14) {
            throw ma.e();
        }
        return i11;
    }

    static int c(int i10, byte[] bArr, int i11, int i12, na<?> naVar, u8 u8Var) {
        ha haVar = (ha) naVar;
        int iS = s(bArr, i11, u8Var);
        haVar.h(u8Var.f3101a);
        while (iS < i12) {
            int iS2 = s(bArr, iS, u8Var);
            if (i10 != u8Var.f3101a) {
                break;
            }
            iS = s(bArr, iS2, u8Var);
            haVar.h(u8Var.f3101a);
        }
        return iS;
    }

    static int d(int i10, byte[] bArr, int i11, int i12, uc ucVar, u8 u8Var) {
        if ((i10 >>> 3) == 0) {
            throw ma.b();
        }
        int i13 = i10 & 7;
        if (i13 == 0) {
            int iT = t(bArr, i11, u8Var);
            ucVar.e(i10, Long.valueOf(u8Var.f3102b));
            return iT;
        }
        if (i13 == 1) {
            ucVar.e(i10, Long.valueOf(u(bArr, i11)));
            return i11 + 8;
        }
        if (i13 == 2) {
            int iS = s(bArr, i11, u8Var);
            int i14 = u8Var.f3101a;
            if (i14 < 0) {
                throw ma.d();
            }
            if (i14 > bArr.length - iS) {
                throw ma.g();
            }
            if (i14 == 0) {
                ucVar.e(i10, v8.f3170a);
            } else {
                ucVar.e(i10, v8.n(bArr, iS, i14));
            }
            return iS + i14;
        }
        if (i13 != 3) {
            if (i13 != 5) {
                throw ma.b();
            }
            ucVar.e(i10, Integer.valueOf(r(bArr, i11)));
            return i11 + 4;
        }
        uc ucVarL = uc.l();
        int i15 = (i10 & (-8)) | 4;
        int i16 = u8Var.f3105e + 1;
        u8Var.f3105e = i16;
        n(i16);
        int i17 = 0;
        while (i11 < i12) {
            int iS2 = s(bArr, i11, u8Var);
            i17 = u8Var.f3101a;
            if (i17 == i15) {
                i11 = iS2;
                break;
            }
            i11 = d(i17, bArr, iS2, i12, ucVarL, u8Var);
        }
        u8Var.f3105e--;
        if (i11 > i12 || i17 != i15) {
            throw ma.e();
        }
        ucVar.e(i10, ucVarL);
        return i11;
    }

    static int e(int i10, byte[] bArr, int i11, int i12, Object obj, ob obVar, vc<uc, uc> vcVar, u8 u8Var) {
        if (u8Var.f3104d.b(obVar, i10 >>> 3) == null) {
            return d(i10, bArr, i11, i12, rb.I(obj), u8Var);
        }
        ea.d dVar = (ea.d) obj;
        dVar.K();
        x9<ea.c> x9Var = dVar.zzc;
        throw new NoSuchMethodError();
    }

    static int f(int i10, byte[] bArr, int i11, u8 u8Var) {
        int i12 = i10 & 127;
        int i13 = i11 + 1;
        byte b10 = bArr[i11];
        if (b10 >= 0) {
            u8Var.f3101a = i12 | (b10 << 7);
            return i13;
        }
        int i14 = i12 | ((b10 & 127) << 7);
        int i15 = i11 + 2;
        byte b11 = bArr[i13];
        if (b11 >= 0) {
            u8Var.f3101a = i14 | (b11 << 14);
            return i15;
        }
        int i16 = i14 | ((b11 & 127) << 14);
        int i17 = i11 + 3;
        byte b12 = bArr[i15];
        if (b12 >= 0) {
            u8Var.f3101a = i16 | (b12 << 21);
            return i17;
        }
        int i18 = i16 | ((b12 & 127) << 21);
        int i19 = i11 + 4;
        byte b13 = bArr[i17];
        if (b13 >= 0) {
            u8Var.f3101a = i18 | (b13 << 28);
            return i19;
        }
        int i20 = i18 | ((b13 & 127) << 28);
        while (true) {
            int i21 = i19 + 1;
            if (bArr[i19] >= 0) {
                u8Var.f3101a = i20;
                return i21;
            }
            i19 = i21;
        }
    }

    static int g(fc<?> fcVar, int i10, byte[] bArr, int i11, int i12, na<Object> naVar, u8 u8Var) {
        int i13 = (i10 & (-8)) | 4;
        int iH = h(fcVar, bArr, i11, i12, i13, u8Var);
        naVar.add(u8Var.f3103c);
        while (iH < i12) {
            int iS = s(bArr, iH, u8Var);
            if (i10 != u8Var.f3101a) {
                break;
            }
            iH = h(fcVar, bArr, iS, i12, i13, u8Var);
            naVar.add(u8Var.f3103c);
        }
        return iH;
    }

    static <T> int j(Object obj, fc<T> fcVar, byte[] bArr, int i10, int i11, int i12, u8 u8Var) {
        int i13 = u8Var.f3105e + 1;
        u8Var.f3105e = i13;
        n(i13);
        int iM = ((rb) fcVar).m(obj, bArr, i10, i11, i12, u8Var);
        u8Var.f3105e--;
        u8Var.f3103c = obj;
        return iM;
    }

    static <T> int k(Object obj, fc<T> fcVar, byte[] bArr, int i10, int i11, u8 u8Var) {
        int iF = i10 + 1;
        int i12 = bArr[i10];
        if (i12 < 0) {
            iF = f(i12, bArr, iF, u8Var);
            i12 = u8Var.f3101a;
        }
        int i13 = iF;
        if (i12 < 0 || i12 > i11 - i13) {
            throw ma.g();
        }
        int i14 = u8Var.f3105e + 1;
        u8Var.f3105e = i14;
        n(i14);
        int i15 = i13 + i12;
        fcVar.h(obj, bArr, i13, i15, u8Var);
        u8Var.f3105e--;
        u8Var.f3103c = obj;
        return i15;
    }

    static int m(byte[] bArr, int i10, na<?> naVar, u8 u8Var) {
        ha haVar = (ha) naVar;
        int iS = s(bArr, i10, u8Var);
        int i11 = u8Var.f3101a + iS;
        while (iS < i11) {
            iS = s(bArr, iS, u8Var);
            haVar.h(u8Var.f3101a);
        }
        if (iS == i11) {
            return iS;
        }
        throw ma.g();
    }

    private static void n(int i10) throws ma {
        if (i10 >= f2984a) {
            throw ma.f();
        }
    }

    static int r(byte[] bArr, int i10) {
        return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
    }

    static int s(byte[] bArr, int i10, u8 u8Var) {
        int i11 = i10 + 1;
        byte b10 = bArr[i10];
        if (b10 < 0) {
            return f(b10, bArr, i11, u8Var);
        }
        u8Var.f3101a = b10;
        return i11;
    }

    static int t(byte[] bArr, int i10, u8 u8Var) {
        int i11 = i10 + 1;
        long j10 = bArr[i10];
        if (j10 >= 0) {
            u8Var.f3102b = j10;
            return i11;
        }
        int i12 = i10 + 2;
        byte b10 = bArr[i11];
        long j11 = (j10 & 127) | (((long) (b10 & 127)) << 7);
        int i13 = 7;
        while (b10 < 0) {
            int i14 = i12 + 1;
            byte b11 = bArr[i12];
            i13 += 7;
            j11 |= ((long) (b11 & 127)) << i13;
            b10 = b11;
            i12 = i14;
        }
        u8Var.f3102b = j11;
        return i12;
    }

    static long u(byte[] bArr, int i10) {
        return ((((long) bArr[i10 + 7]) & 255) << 56) | (((long) bArr[i10]) & 255) | ((((long) bArr[i10 + 1]) & 255) << 8) | ((((long) bArr[i10 + 2]) & 255) << 16) | ((((long) bArr[i10 + 3]) & 255) << 24) | ((((long) bArr[i10 + 4]) & 255) << 32) | ((((long) bArr[i10 + 5]) & 255) << 40) | ((((long) bArr[i10 + 6]) & 255) << 48);
    }

    static double a(byte[] bArr, int i10) {
        return Double.longBitsToDouble(u(bArr, i10));
    }

    private static <T> int h(fc<T> fcVar, byte[] bArr, int i10, int i11, int i12, u8 u8Var) {
        T tB = fcVar.b();
        int iJ = j(tB, fcVar, bArr, i10, i11, i12, u8Var);
        fcVar.d(tB);
        u8Var.f3103c = tB;
        return iJ;
    }

    static <T> int i(fc<T> fcVar, byte[] bArr, int i10, int i11, u8 u8Var) {
        T tB = fcVar.b();
        int iK = k(tB, fcVar, bArr, i10, i11, u8Var);
        fcVar.d(tB);
        u8Var.f3103c = tB;
        return iK;
    }

    static int l(byte[] bArr, int i10, u8 u8Var) {
        int iS = s(bArr, i10, u8Var);
        int i11 = u8Var.f3101a;
        if (i11 >= 0) {
            if (i11 <= bArr.length - iS) {
                if (i11 == 0) {
                    u8Var.f3103c = v8.f3170a;
                    return iS;
                }
                u8Var.f3103c = v8.n(bArr, iS, i11);
                return iS + i11;
            }
            throw ma.g();
        }
        throw ma.d();
    }

    static float o(byte[] bArr, int i10) {
        return Float.intBitsToFloat(r(bArr, i10));
    }

    static int p(fc<?> fcVar, int i10, byte[] bArr, int i11, int i12, na<?> naVar, u8 u8Var) {
        int i13 = i(fcVar, bArr, i11, i12, u8Var);
        naVar.add(u8Var.f3103c);
        while (i13 < i12) {
            int iS = s(bArr, i13, u8Var);
            if (i10 != u8Var.f3101a) {
                break;
            }
            i13 = i(fcVar, bArr, iS, i12, u8Var);
            naVar.add(u8Var.f3103c);
        }
        return i13;
    }

    static int q(byte[] bArr, int i10, u8 u8Var) {
        int iS = s(bArr, i10, u8Var);
        int i11 = u8Var.f3101a;
        if (i11 >= 0) {
            if (i11 == 0) {
                u8Var.f3103c = "";
                return iS;
            }
            u8Var.f3103c = bd.d(bArr, iS, i11);
            return iS + i11;
        }
        throw ma.d();
    }
}
