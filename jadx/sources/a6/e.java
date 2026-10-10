package a6;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class e {
    static int a(b bVar) {
        return b(bVar, true) + b(bVar, false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:16:0x0042 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:17:0x0043 A[RETURN] */
    static boolean c(int i10, int i11, int i12) {
        int i13;
        int i14;
        int i15;
        switch (i10) {
            case 0:
                i12 += i11;
                i13 = i12 & 1;
                if (i13 == 0) {
                    return true;
                }
                return false;
            case 1:
                i13 = i12 & 1;
                if (i13 == 0) {
                    return true;
                }
                return false;
            case 2:
                i13 = i11 % 3;
                if (i13 == 0) {
                    return true;
                }
                return false;
            case 3:
                i13 = (i12 + i11) % 3;
                if (i13 == 0) {
                    return true;
                }
                return false;
            case 4:
                i12 /= 2;
                i11 /= 3;
                i12 += i11;
                i13 = i12 & 1;
                if (i13 == 0) {
                    return true;
                }
                return false;
            case 5:
                int i16 = i12 * i11;
                i13 = (i16 % 3) + (i16 & 1);
                if (i13 == 0) {
                    return true;
                }
                return false;
            case 6:
                i14 = i12 * i11;
                i15 = i14 % 3;
                i13 = (i15 + (i14 & 1)) & 1;
                if (i13 == 0) {
                    return true;
                }
                return false;
            case 7:
                i15 = (i12 * i11) % 3;
                i14 = i12 + i11;
                i13 = (i15 + (i14 & 1)) & 1;
                if (i13 == 0) {
                    return true;
                }
                return false;
            default:
                throw new IllegalArgumentException("Invalid mask pattern: " + i10);
        }
    }

    private static boolean d(byte[] bArr, int i10, int i11) {
        while (i10 < i11) {
            if (i10 >= 0 && i10 < bArr.length && bArr[i10] == 1) {
                return false;
            }
            i10++;
        }
        return true;
    }

    private static boolean e(byte[][] bArr, int i10, int i11, int i12) {
        while (i11 < i12) {
            if (i11 >= 0 && i11 < bArr.length && bArr[i11][i10] == 1) {
                return false;
            }
            i11++;
        }
        return true;
    }

    private static int b(b bVar, boolean z10) {
        int iD = z10 ? bVar.d() : bVar.e();
        int iE = z10 ? bVar.e() : bVar.d();
        byte[][] bArrC = bVar.c();
        int i10 = 0;
        for (int i11 = 0; i11 < iD; i11++) {
            byte b10 = -1;
            int i12 = 0;
            for (int i13 = 0; i13 < iE; i13++) {
                byte b11 = z10 ? bArrC[i11][i13] : bArrC[i13][i11];
                if (b11 == b10) {
                    i12++;
                } else {
                    if (i12 >= 5) {
                        i10 += i12 - 2;
                    }
                    b10 = b11;
                    i12 = 1;
                }
            }
            if (i12 >= 5) {
                i10 += i12 - 2;
            }
        }
        return i10;
    }

    static int f(b bVar) {
        byte[][] bArrC = bVar.c();
        int iE = bVar.e();
        int iD = bVar.d();
        int i10 = 0;
        for (int i11 = 0; i11 < iD - 1; i11++) {
            int i12 = 0;
            while (i12 < iE - 1) {
                byte[] bArr = bArrC[i11];
                byte b10 = bArr[i12];
                int i13 = i12 + 1;
                if (b10 == bArr[i13]) {
                    byte[] bArr2 = bArrC[i11 + 1];
                    if (b10 == bArr2[i12] && b10 == bArr2[i13]) {
                        i10++;
                    }
                }
                i12 = i13;
            }
        }
        return i10 * 3;
    }

    static int g(b bVar) {
        byte[][] bArrC = bVar.c();
        int iE = bVar.e();
        int iD = bVar.d();
        int i10 = 0;
        for (int i11 = 0; i11 < iD; i11++) {
            for (int i12 = 0; i12 < iE; i12++) {
                byte[] bArr = bArrC[i11];
                int i13 = i12 + 6;
                if (i13 < iE && bArr[i12] == 1 && bArr[i12 + 1] == 0 && bArr[i12 + 2] == 1 && bArr[i12 + 3] == 1 && bArr[i12 + 4] == 1 && bArr[i12 + 5] == 0 && bArr[i13] == 1 && (d(bArr, i12 - 4, i12) || d(bArr, i12 + 7, i12 + 11))) {
                    i10++;
                }
                int i14 = i11 + 6;
                if (i14 < iD && bArrC[i11][i12] == 1 && bArrC[i11 + 1][i12] == 0 && bArrC[i11 + 2][i12] == 1 && bArrC[i11 + 3][i12] == 1 && bArrC[i11 + 4][i12] == 1 && bArrC[i11 + 5][i12] == 0 && bArrC[i14][i12] == 1 && (e(bArrC, i12, i11 - 4, i11) || e(bArrC, i12, i11 + 7, i11 + 11))) {
                    i10++;
                }
            }
        }
        return i10 * 40;
    }

    static int h(b bVar) {
        byte[][] bArrC = bVar.c();
        int iE = bVar.e();
        int iD = bVar.d();
        int i10 = 0;
        for (int i11 = 0; i11 < iD; i11++) {
            byte[] bArr = bArrC[i11];
            for (int i12 = 0; i12 < iE; i12++) {
                if (bArr[i12] == 1) {
                    i10++;
                }
            }
        }
        int iD2 = bVar.d() * bVar.e();
        return ((Math.abs((i10 * 2) - iD2) * 10) / iD2) * 10;
    }
}
