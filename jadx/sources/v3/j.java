package v3;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class j {
    private static int c(float[] fArr, int[] iArr, int i10, byte[] bArr) {
        for (int i11 = 0; i11 < 6; i11++) {
            int iCeil = (int) Math.ceil(fArr[i11]);
            iArr[i11] = iCeil;
            if (i10 > iCeil) {
                Arrays.fill(bArr, (byte) 0);
                i10 = iCeil;
            }
            if (i10 == iCeil) {
                bArr[i11] = (byte) (bArr[i11] + 1);
            }
        }
        return i10;
    }

    private static int d(byte[] bArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 6; i11++) {
            i10 += bArr[i11];
        }
        return i10;
    }

    private static boolean l(char c10) {
        return false;
    }

    public static String b(String str, m mVar, h3.f fVar, h3.f fVar2, boolean z10) {
        c cVar = new c();
        int iE = 0;
        g[] gVarArr = {new a(), cVar, new n(), new o(), new f(), new b()};
        h hVar = new h(str);
        hVar.n(mVar);
        hVar.l(fVar, fVar2);
        if (str.startsWith("[)>\u001e05\u001d") && str.endsWith("\u001e\u0004")) {
            hVar.r((char) 236);
            hVar.m(2);
            hVar.f19544f += 7;
        } else if (str.startsWith("[)>\u001e06\u001d") && str.endsWith("\u001e\u0004")) {
            hVar.r((char) 237);
            hVar.m(2);
            hVar.f19544f += 7;
        }
        if (z10) {
            cVar.d(hVar);
            iE = hVar.e();
            hVar.j();
        }
        while (hVar.i()) {
            gVarArr[iE].a(hVar);
            if (hVar.e() >= 0) {
                iE = hVar.e();
                hVar.j();
            }
        }
        int iA = hVar.a();
        hVar.p();
        int iA2 = hVar.g().a();
        if (iA < iA2 && iE != 0 && iE != 5 && iE != 4) {
            hVar.r((char) 254);
        }
        StringBuilder sbB = hVar.b();
        if (sbB.length() < iA2) {
            sbB.append((char) 129);
        }
        while (sbB.length() < iA2) {
            sbB.append(r(sbB.length() + 1));
        }
        return hVar.b().toString();
    }

    static boolean f(char c10) {
        return c10 >= '0' && c10 <= '9';
    }

    static boolean g(char c10) {
        return c10 >= 128 && c10 <= 255;
    }

    static boolean h(char c10) {
        if (c10 == ' ') {
            return true;
        }
        if (c10 < '0' || c10 > '9') {
            return c10 >= 'A' && c10 <= 'Z';
        }
        return true;
    }

    static boolean i(char c10) {
        return c10 >= ' ' && c10 <= '^';
    }

    static boolean j(char c10) {
        if (c10 == ' ') {
            return true;
        }
        if (c10 < '0' || c10 > '9') {
            return c10 >= 'a' && c10 <= 'z';
        }
        return true;
    }

    private static boolean m(char c10) {
        return c10 == '\r' || c10 == '*' || c10 == '>';
    }

    static int o(CharSequence charSequence, int i10, int i11) {
        float[] fArr;
        float f10;
        int i12;
        if (i10 >= charSequence.length()) {
            return i11;
        }
        int i13 = 5;
        int i14 = 2;
        if (i11 == 0) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            fArr = new float[6];
            fArr[0] = 1.0f;
            fArr[1] = 2.0f;
            fArr[2] = 2.0f;
            fArr[3] = 2.0f;
            fArr[4] = 2.0f;
            fArr[5] = 2.25f;
            fArr[i11] = 0.0f;
        }
        byte[] bArr = new byte[6];
        int[] iArr = new int[6];
        int i15 = 0;
        while (true) {
            int i16 = i10 + i15;
            if (i16 == charSequence.length()) {
                Arrays.fill(bArr, (byte) 0);
                Arrays.fill(iArr, 0);
                int iC = c(fArr, iArr, Integer.MAX_VALUE, bArr);
                int iD = d(bArr);
                if (iArr[0] == iC) {
                    return 0;
                }
                if (iD == 1) {
                    if (bArr[i13] > 0) {
                        return i13;
                    }
                    if (bArr[4] > 0) {
                        return 4;
                    }
                    if (bArr[i14] > 0) {
                        return i14;
                    }
                    if (bArr[3] > 0) {
                        return 3;
                    }
                }
                return 1;
            }
            char cCharAt = charSequence.charAt(i16);
            i15++;
            if (f(cCharAt)) {
                fArr[0] = fArr[0] + 0.5f;
                f10 = 1.0f;
                i12 = 5;
            } else if (g(cCharAt)) {
                f10 = 1.0f;
                i12 = 5;
                float fCeil = (float) Math.ceil(fArr[0]);
                fArr[0] = fCeil;
                fArr[0] = fCeil + 2.0f;
            } else {
                f10 = 1.0f;
                i12 = 5;
                float fCeil2 = (float) Math.ceil(fArr[0]);
                fArr[0] = fCeil2;
                fArr[0] = fCeil2 + 1.0f;
            }
            if (h(cCharAt)) {
                fArr[1] = fArr[1] + 0.6666667f;
            } else if (g(cCharAt)) {
                fArr[1] = fArr[1] + 2.6666667f;
            } else {
                fArr[1] = fArr[1] + 1.3333334f;
            }
            if (j(cCharAt)) {
                fArr[i14] = fArr[i14] + 0.6666667f;
            } else if (g(cCharAt)) {
                fArr[i14] = fArr[i14] + 2.6666667f;
            } else {
                fArr[i14] = fArr[i14] + 1.3333334f;
            }
            if (k(cCharAt)) {
                fArr[3] = fArr[3] + 0.6666667f;
            } else if (g(cCharAt)) {
                fArr[3] = fArr[3] + 4.3333335f;
            } else {
                fArr[3] = fArr[3] + 3.3333333f;
            }
            if (i(cCharAt)) {
                fArr[4] = fArr[4] + 0.75f;
            } else if (g(cCharAt)) {
                fArr[4] = fArr[4] + 4.25f;
            } else {
                fArr[4] = fArr[4] + 3.25f;
            }
            if (l(cCharAt)) {
                fArr[i12] = fArr[i12] + 4.0f;
            } else {
                fArr[i12] = fArr[i12] + f10;
            }
            if (i15 >= 4) {
                Arrays.fill(bArr, (byte) 0);
                Arrays.fill(iArr, 0);
                c(fArr, iArr, Integer.MAX_VALUE, bArr);
                if (iArr[0] < q(iArr[i12], iArr[1], iArr[i14], iArr[3], iArr[4])) {
                    return 0;
                }
                int i17 = iArr[i12];
                if (i17 < iArr[0] || i17 + 1 < p(iArr[1], iArr[2], iArr[3], iArr[4])) {
                    return i12;
                }
                if (iArr[4] + 1 < q(iArr[i12], iArr[1], iArr[2], iArr[3], iArr[0])) {
                    return 4;
                }
                if (iArr[2] + 1 < q(iArr[i12], iArr[1], iArr[4], iArr[3], iArr[0])) {
                    return 2;
                }
                if (iArr[3] + 1 < q(iArr[i12], iArr[1], iArr[4], iArr[2], iArr[0])) {
                    return 3;
                }
                if (iArr[1] + 1 >= p(iArr[0], iArr[i12], iArr[4], iArr[2])) {
                    continue;
                } else {
                    int i18 = iArr[1];
                    int i19 = iArr[3];
                    if (i18 < i19) {
                        return 1;
                    }
                    if (i18 == i19) {
                        for (int i20 = i10 + i15 + 1; i20 < charSequence.length(); i20++) {
                            char cCharAt2 = charSequence.charAt(i20);
                            if (m(cCharAt2)) {
                                return 3;
                            }
                            if (!k(cCharAt2)) {
                                break;
                            }
                        }
                        return 1;
                    }
                }
            }
            i13 = 5;
            i14 = 2;
        }
    }

    private static char r(int i10) {
        int i11 = (i10 * 149) % 253;
        int i12 = i11 + 130;
        if (i12 > 254) {
            i12 = i11 - 124;
        }
        return (char) i12;
    }

    public static int a(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        int i11 = i10;
        while (i11 < length && f(charSequence.charAt(i11))) {
            i11++;
        }
        return i11 - i10;
    }

    static void e(char c10) {
        String hexString = Integer.toHexString(c10);
        throw new IllegalArgumentException("Illegal character: " + c10 + " (0x" + ("0000".substring(0, 4 - hexString.length()) + hexString) + ')');
    }

    static boolean k(char c10) {
        if (!m(c10) && c10 != ' ') {
            if (c10 < '0' || c10 > '9') {
                if (c10 < 'A' || c10 > 'Z') {
                    return false;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    static int n(CharSequence charSequence, int i10, int i11) {
        int iO = o(charSequence, i10, i11);
        if (i11 == 3 && iO == 3) {
            int iMin = Math.min(i10 + 3, charSequence.length());
            while (i10 < iMin) {
                if (!k(charSequence.charAt(i10))) {
                    return 0;
                }
                i10++;
            }
        } else if (i11 == 4 && iO == 4) {
            int iMin2 = Math.min(i10 + 4, charSequence.length());
            while (i10 < iMin2) {
                if (!i(charSequence.charAt(i10))) {
                    return 0;
                }
                i10++;
            }
        }
        return iO;
    }

    private static int p(int i10, int i11, int i12, int i13) {
        return Math.min(i10, Math.min(i11, Math.min(i12, i13)));
    }

    private static int q(int i10, int i11, int i12, int i13, int i14) {
        return Math.min(p(i10, i11, i12, i13), i14);
    }
}
