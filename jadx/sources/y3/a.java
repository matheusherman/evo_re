package y3;

import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a extends r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final char[] f22319d = "0123456789-$:/.+ABCD".toCharArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int[] f22320e = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final char[] f22321f = {'A', 'B', 'C', 'D'};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StringBuilder f22322a = new StringBuilder(20);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f22323b = new int[80];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f22324c = 0;

    static boolean h(char[] cArr, char c10) {
        if (cArr != null) {
            for (char c11 : cArr) {
                if (c11 == c10) {
                    return true;
                }
            }
        }
        return false;
    }

    private int j() throws h3.m {
        for (int i10 = 1; i10 < this.f22324c; i10 += 2) {
            int iL = l(i10);
            if (iL != -1 && h(f22321f, f22319d[iL])) {
                int i11 = 0;
                for (int i12 = i10; i12 < i10 + 7; i12++) {
                    i11 += this.f22323b[i12];
                }
                if (i10 == 1 || this.f22323b[i10 - 1] >= i11 / 2) {
                    return i10;
                }
            }
        }
        throw h3.m.a();
    }

    private void k(p3.a aVar) throws h3.m {
        int i10 = 0;
        this.f22324c = 0;
        int iL = aVar.l(0);
        int iM = aVar.m();
        if (iL >= iM) {
            throw h3.m.a();
        }
        boolean z10 = true;
        while (iL < iM) {
            if (aVar.i(iL) != z10) {
                i10++;
            } else {
                i(i10);
                z10 = !z10;
                i10 = 1;
            }
            iL++;
        }
        i(i10);
    }

    private void i(int i10) {
        int[] iArr = this.f22323b;
        int i11 = this.f22324c;
        iArr[i11] = i10;
        int i12 = i11 + 1;
        this.f22324c = i12;
        if (i12 >= iArr.length) {
            int[] iArr2 = new int[i12 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i12);
            this.f22323b = iArr2;
        }
    }

    private int l(int i10) {
        int i11 = i10 + 7;
        if (i11 >= this.f22324c) {
            return -1;
        }
        int[] iArr = this.f22323b;
        int i12 = Integer.MAX_VALUE;
        int i13 = 0;
        int i14 = Integer.MAX_VALUE;
        int i15 = 0;
        for (int i16 = i10; i16 < i11; i16 += 2) {
            int i17 = iArr[i16];
            if (i17 < i14) {
                i14 = i17;
            }
            if (i17 > i15) {
                i15 = i17;
            }
        }
        int i18 = (i14 + i15) / 2;
        int i19 = 0;
        for (int i20 = i10 + 1; i20 < i11; i20 += 2) {
            int i21 = iArr[i20];
            if (i21 < i12) {
                i12 = i21;
            }
            if (i21 > i19) {
                i19 = i21;
            }
        }
        int i22 = (i12 + i19) / 2;
        int i23 = 128;
        int i24 = 0;
        for (int i25 = 0; i25 < 7; i25++) {
            i23 >>= 1;
            if (iArr[i10 + i25] > ((i25 & 1) == 0 ? i18 : i22)) {
                i24 |= i23;
            }
        }
        while (true) {
            int[] iArr2 = f22320e;
            if (i13 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i13] == i24) {
                return i13;
            }
            i13++;
        }
    }

    private void m(int i10) throws h3.m {
        int[] iArr = new int[4];
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        int[] iArr2 = new int[4];
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int length = this.f22322a.length() - 1;
        int i11 = i10;
        int i12 = 0;
        while (true) {
            if (i12 > length) {
                break;
            }
            int i13 = f22320e[this.f22322a.charAt(i12)];
            for (int i14 = 6; i14 >= 0; i14--) {
                int i15 = (i14 & 1) + ((i13 & 1) * 2);
                iArr[i15] = iArr[i15] + this.f22323b[i11 + i14];
                iArr2[i15] = iArr2[i15] + 1;
                i13 >>= 1;
            }
            i11 += 8;
            i12++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i16 = 0; i16 < 2; i16++) {
            fArr2[i16] = 0.0f;
            int i17 = i16 + 2;
            float f10 = iArr[i16] / iArr2[i16];
            int i18 = iArr[i17];
            int i19 = iArr2[i17];
            float f11 = (f10 + (i18 / i19)) / 2.0f;
            fArr2[i17] = f11;
            fArr[i16] = f11;
            fArr[i17] = ((i18 * 2.0f) + 1.5f) / i19;
        }
        int i20 = i10;
        for (int i21 = 0; i21 <= length; i21++) {
            int i22 = f22320e[this.f22322a.charAt(i21)];
            for (int i23 = 6; i23 >= 0; i23--) {
                int i24 = (i23 & 1) + ((i22 & 1) * 2);
                float f12 = this.f22323b[i20 + i23];
                if (f12 < fArr2[i24] || f12 > fArr[i24]) {
                    throw h3.m.a();
                }
                i22 >>= 1;
            }
            i20 += 8;
        }
    }

    @Override // y3.r
    public h3.q c(int i10, p3.a aVar, Map<h3.e, ?> map) throws h3.m {
        int i11;
        Arrays.fill(this.f22323b, 0);
        k(aVar);
        int iJ = j();
        this.f22322a.setLength(0);
        int i12 = iJ;
        while (true) {
            int iL = l(i12);
            if (iL == -1) {
                throw h3.m.a();
            }
            this.f22322a.append((char) iL);
            i11 = i12 + 8;
            if ((this.f22322a.length() > 1 && h(f22321f, f22319d[iL])) || i11 >= this.f22324c) {
                break;
            }
            i12 = i11;
        }
        int i13 = i12 + 7;
        int i14 = this.f22323b[i13];
        int i15 = 0;
        for (int i16 = -8; i16 < -1; i16++) {
            i15 += this.f22323b[i11 + i16];
        }
        if (i11 < this.f22324c && i14 < i15 / 2) {
            throw h3.m.a();
        }
        m(iJ);
        for (int i17 = 0; i17 < this.f22322a.length(); i17++) {
            StringBuilder sb2 = this.f22322a;
            sb2.setCharAt(i17, f22319d[sb2.charAt(i17)]);
        }
        char cCharAt = this.f22322a.charAt(0);
        char[] cArr = f22321f;
        if (!h(cArr, cCharAt)) {
            throw h3.m.a();
        }
        StringBuilder sb3 = this.f22322a;
        if (!h(cArr, sb3.charAt(sb3.length() - 1))) {
            throw h3.m.a();
        }
        if (this.f22322a.length() <= 3) {
            throw h3.m.a();
        }
        if (map == null || !map.containsKey(h3.e.RETURN_CODABAR_START_END)) {
            StringBuilder sb4 = this.f22322a;
            sb4.deleteCharAt(sb4.length() - 1);
            this.f22322a.deleteCharAt(0);
        }
        int i18 = 0;
        for (int i19 = 0; i19 < iJ; i19++) {
            i18 += this.f22323b[i19];
        }
        float f10 = i18;
        while (iJ < i13) {
            i18 += this.f22323b[iJ];
            iJ++;
        }
        float f11 = i10;
        h3.q qVar = new h3.q(this.f22322a.toString(), null, new h3.s[]{new h3.s(f10, f11), new h3.s(i18, f11)}, h3.a.CODABAR);
        qVar.h(h3.r.SYMBOLOGY_IDENTIFIER, "]F0");
        return qVar;
    }
}
