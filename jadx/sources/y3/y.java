package y3;

import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class y extends r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int[] f22389d = {1, 1, 1};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int[] f22390e = {1, 1, 1, 1, 1};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int[] f22391f = {1, 1, 1, 1, 1, 1};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final int[][] f22392g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final int[][] f22393h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StringBuilder f22394a = new StringBuilder(20);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final x f22395b = new x();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final m f22396c = new m();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        f22392g = iArr;
        int[][] iArr2 = new int[20][];
        f22393h = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i10 = 10; i10 < 20; i10++) {
            int[] iArr3 = f22392g[i10 - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i11 = 0; i11 < iArr3.length; i11++) {
                iArr4[i11] = iArr3[(iArr3.length - i11) - 1];
            }
            f22393h[i10] = iArr4;
        }
    }

    static int[] n(p3.a aVar, int i10, boolean z10, int[] iArr) {
        return o(aVar, i10, z10, iArr, new int[iArr.length]);
    }

    int[] k(p3.a aVar, int i10) {
        return n(aVar, i10, false, f22389d);
    }

    protected abstract int l(p3.a aVar, int[] iArr, StringBuilder sb2);

    public h3.q m(int i10, p3.a aVar, int[] iArr, Map<h3.e, ?> map) throws h3.d, h3.h, h3.m {
        int length;
        String strC;
        h3.t tVar = map == null ? null : (h3.t) map.get(h3.e.NEED_RESULT_POINT_CALLBACK);
        if (tVar != null) {
            tVar.a(new h3.s((iArr[0] + iArr[1]) / 2.0f, i10));
        }
        StringBuilder sb2 = this.f22394a;
        sb2.setLength(0);
        int iL = l(aVar, iArr, sb2);
        if (tVar != null) {
            tVar.a(new h3.s(iL, i10));
        }
        int[] iArrK = k(aVar, iL);
        if (tVar != null) {
            tVar.a(new h3.s((iArrK[0] + iArrK[1]) / 2.0f, i10));
        }
        int i11 = iArrK[1];
        int i12 = (i11 - iArrK[0]) + i11;
        if (i12 >= aVar.m() || !aVar.o(i11, i12, false)) {
            throw h3.m.a();
        }
        String string = sb2.toString();
        if (string.length() < 8) {
            throw h3.h.a();
        }
        if (!h(string)) {
            throw h3.d.a();
        }
        float f10 = (iArr[1] + iArr[0]) / 2.0f;
        float f11 = (iArrK[1] + iArrK[0]) / 2.0f;
        h3.a aVarQ = q();
        float f12 = i10;
        h3.q qVar = new h3.q(string, null, new h3.s[]{new h3.s(f10, f12), new h3.s(f11, f12)}, aVarQ);
        try {
            h3.q qVarA = this.f22395b.a(i10, aVar, iArrK[1]);
            qVar.h(h3.r.UPC_EAN_EXTENSION, qVarA.f());
            qVar.g(qVarA.d());
            qVar.a(qVarA.e());
            length = qVarA.f().length();
        } catch (h3.p unused) {
            length = 0;
        }
        int[] iArr2 = map != null ? (int[]) map.get(h3.e.ALLOWED_EAN_EXTENSIONS) : null;
        if (iArr2 != null) {
            int length2 = iArr2.length;
            int i13 = 0;
            while (true) {
                if (i13 >= length2) {
                    throw h3.m.a();
                }
                if (length == iArr2[i13]) {
                    break;
                }
                i13++;
            }
        }
        if ((aVarQ == h3.a.EAN_13 || aVarQ == h3.a.UPC_A) && (strC = this.f22396c.c(string)) != null) {
            qVar.h(h3.r.POSSIBLE_COUNTRY, strC);
        }
        int i14 = aVarQ == h3.a.EAN_8 ? 4 : 0;
        qVar.h(h3.r.SYMBOLOGY_IDENTIFIER, "]E" + i14);
        return qVar;
    }

    abstract h3.a q();

    static int[] p(p3.a aVar) throws h3.m {
        int[] iArr = new int[f22389d.length];
        int[] iArrO = null;
        boolean zO = false;
        int i10 = 0;
        while (!zO) {
            int[] iArr2 = f22389d;
            Arrays.fill(iArr, 0, iArr2.length, 0);
            iArrO = o(aVar, i10, false, iArr2, iArr);
            int i11 = iArrO[0];
            int i12 = iArrO[1];
            int i13 = i11 - (i12 - i11);
            if (i13 >= 0) {
                zO = aVar.o(i13, i11, false);
            }
            i10 = i12;
        }
        return iArrO;
    }

    protected y() {
    }

    static boolean i(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i10 = length - 1;
        if (r(charSequence.subSequence(0, i10)) != Character.digit(charSequence.charAt(i10), 10)) {
            return false;
        }
        return true;
    }

    static int j(p3.a aVar, int[] iArr, int i10, int[][] iArr2) throws h3.m {
        r.f(aVar, i10, iArr);
        int length = iArr2.length;
        float f10 = 0.48f;
        int i11 = -1;
        for (int i12 = 0; i12 < length; i12++) {
            float fE = r.e(iArr, iArr2[i12], 0.7f);
            if (fE < f10) {
                i11 = i12;
                f10 = fE;
            }
        }
        if (i11 >= 0) {
            return i11;
        }
        throw h3.m.a();
    }

    private static int[] o(p3.a aVar, int i10, boolean z10, int[] iArr, int[] iArr2) throws h3.m {
        int iK;
        int iM = aVar.m();
        if (z10) {
            iK = aVar.l(i10);
        } else {
            iK = aVar.k(i10);
        }
        int length = iArr.length;
        boolean z11 = z10;
        int i11 = 0;
        int i12 = iK;
        while (iK < iM) {
            if (aVar.i(iK) != z11) {
                iArr2[i11] = iArr2[i11] + 1;
            } else {
                if (i11 == length - 1) {
                    if (r.e(iArr2, iArr, 0.7f) < 0.48f) {
                        return new int[]{i12, iK};
                    }
                    i12 += iArr2[0] + iArr2[1];
                    int i13 = i11 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i13);
                    iArr2[i13] = 0;
                    iArr2[i11] = 0;
                    i11--;
                } else {
                    i11++;
                }
                iArr2[i11] = 1;
                z11 = !z11;
            }
            iK++;
        }
        throw h3.m.a();
    }

    static int r(CharSequence charSequence) throws h3.h {
        int length = charSequence.length();
        int i10 = 0;
        for (int i11 = length - 1; i11 >= 0; i11 -= 2) {
            int iCharAt = charSequence.charAt(i11) - '0';
            if (iCharAt >= 0 && iCharAt <= 9) {
                i10 += iCharAt;
            } else {
                throw h3.h.a();
            }
        }
        int i12 = i10 * 3;
        for (int i13 = length - 2; i13 >= 0; i13 -= 2) {
            int iCharAt2 = charSequence.charAt(i13) - '0';
            if (iCharAt2 >= 0 && iCharAt2 <= 9) {
                i12 += iCharAt2;
            } else {
                throw h3.h.a();
            }
        }
        return (1000 - i12) % 10;
    }

    @Override // y3.r
    public h3.q c(int i10, p3.a aVar, Map<h3.e, ?> map) {
        return m(i10, aVar, p(aVar), map);
    }

    boolean h(String str) {
        return i(str);
    }
}
