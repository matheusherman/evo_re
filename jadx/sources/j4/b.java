package j4;

import h3.m;
import h3.t;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p3.b f11587a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f11589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f11590d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f11591e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f11592f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f11593g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final t f11595i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<a> f11588b = new ArrayList(5);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int[] f11594h = new int[3];

    private static float a(int[] iArr, int i10) {
        return (i10 - iArr[2]) - (iArr[1] / 2.0f);
    }

    private a e(int[] iArr, int i10, int i11) {
        int i12 = iArr[0] + iArr[1] + iArr[2];
        float fA = a(iArr, i11);
        float fB = b(i10, (int) fA, iArr[1] * 2, i12);
        if (Float.isNaN(fB)) {
            return null;
        }
        float f10 = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
        for (a aVar : this.f11588b) {
            if (aVar.f(f10, fB, fA)) {
                return aVar.g(fB, fA, f10);
            }
        }
        a aVar2 = new a(fA, fB, f10);
        this.f11588b.add(aVar2);
        t tVar = this.f11595i;
        if (tVar == null) {
            return null;
        }
        tVar.a(aVar2);
        return null;
    }

    private float b(int i10, int i11, int i12, int i13) {
        p3.b bVar = this.f11587a;
        int iK = bVar.k();
        int[] iArr = this.f11594h;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i14 = i10;
        while (i14 >= 0 && bVar.h(i11, i14)) {
            int i15 = iArr[1];
            if (i15 > i12) {
                break;
            }
            iArr[1] = i15 + 1;
            i14--;
        }
        if (i14 >= 0 && iArr[1] <= i12) {
            while (i14 >= 0 && !bVar.h(i11, i14)) {
                int i16 = iArr[0];
                if (i16 > i12) {
                    break;
                }
                iArr[0] = i16 + 1;
                i14--;
            }
            if (iArr[0] > i12) {
                return Float.NaN;
            }
            int i17 = i10 + 1;
            while (i17 < iK && bVar.h(i11, i17)) {
                int i18 = iArr[1];
                if (i18 > i12) {
                    break;
                }
                iArr[1] = i18 + 1;
                i17++;
            }
            if (i17 != iK && iArr[1] <= i12) {
                while (i17 < iK && !bVar.h(i11, i17)) {
                    int i19 = iArr[2];
                    if (i19 > i12) {
                        break;
                    }
                    iArr[2] = i19 + 1;
                    i17++;
                }
                int i20 = iArr[2];
                if (i20 <= i12 && Math.abs(((iArr[0] + iArr[1]) + i20) - i13) * 5 < i13 * 2 && d(iArr)) {
                    return a(iArr, i17);
                }
            }
        }
        return Float.NaN;
    }

    private boolean d(int[] iArr) {
        float f10 = this.f11593g;
        float f11 = f10 / 2.0f;
        for (int i10 = 0; i10 < 3; i10++) {
            if (Math.abs(f10 - iArr[i10]) >= f11) {
                return false;
            }
        }
        return true;
    }

    a c() throws m {
        a aVarE;
        a aVarE2;
        int i10 = this.f11589c;
        int i11 = this.f11592f;
        int i12 = this.f11591e + i10;
        int i13 = this.f11590d + (i11 / 2);
        int[] iArr = new int[3];
        for (int i14 = 0; i14 < i11; i14++) {
            int i15 = ((i14 & 1) == 0 ? (i14 + 1) / 2 : -((i14 + 1) / 2)) + i13;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i16 = i10;
            while (i16 < i12 && !this.f11587a.h(i16, i15)) {
                i16++;
            }
            int i17 = 0;
            while (i16 < i12) {
                if (!this.f11587a.h(i16, i15)) {
                    if (i17 == 1) {
                        i17++;
                    }
                    iArr[i17] = iArr[i17] + 1;
                } else if (i17 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i17 != 2) {
                    i17++;
                    iArr[i17] = iArr[i17] + 1;
                } else {
                    if (d(iArr) && (aVarE2 = e(iArr, i15, i16)) != null) {
                        return aVarE2;
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i17 = 1;
                }
                i16++;
            }
            if (d(iArr) && (aVarE = e(iArr, i15, i12)) != null) {
                return aVarE;
            }
        }
        if (this.f11588b.isEmpty()) {
            throw m.a();
        }
        return this.f11588b.get(0);
    }

    b(p3.b bVar, int i10, int i11, int i12, int i13, float f10, t tVar) {
        this.f11587a = bVar;
        this.f11589c = i10;
        this.f11590d = i11;
        this.f11591e = i12;
        this.f11592f = i13;
        this.f11593g = f10;
        this.f11595i = tVar;
    }
}
