package j4;

import h3.h;
import h3.m;
import h3.s;
import h3.t;
import i4.j;
import java.util.Map;
import p3.g;
import p3.l;
import p3.o;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p3.b f11596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private t f11597b;

    private static o d(s sVar, s sVar2, s sVar3, s sVar4, int i10) {
        float fC;
        float fD;
        float f10;
        float f11 = i10 - 3.5f;
        if (sVar4 != null) {
            fC = sVar4.c();
            fD = sVar4.d();
            f10 = f11 - 3.0f;
        } else {
            fC = (sVar2.c() - sVar.c()) + sVar3.c();
            fD = (sVar2.d() - sVar.d()) + sVar3.d();
            f10 = f11;
        }
        return o.b(3.5f, 3.5f, f11, 3.5f, f10, f10, 3.5f, f11, sVar.c(), sVar.d(), sVar2.c(), sVar2.d(), fC, fD, sVar3.c(), sVar3.d());
    }

    private float i(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        int i17;
        int i18 = 1;
        boolean z10 = Math.abs(i13 - i11) > Math.abs(i12 - i10);
        if (z10) {
            i15 = i10;
            i14 = i11;
            i17 = i12;
            i16 = i13;
        } else {
            i14 = i10;
            i15 = i11;
            i16 = i12;
            i17 = i13;
        }
        int iAbs = Math.abs(i16 - i14);
        int iAbs2 = Math.abs(i17 - i15);
        int i19 = (-iAbs) / 2;
        int i20 = i14 < i16 ? 1 : -1;
        int i21 = i15 < i17 ? 1 : -1;
        int i22 = i16 + i20;
        int i23 = i14;
        int i24 = i15;
        int i25 = 0;
        while (i23 != i22) {
            boolean z11 = z10;
            int i26 = iAbs;
            if ((i25 == i18) == this.f11596a.h(z10 ? i24 : i23, z10 ? i23 : i24)) {
                if (i25 == 2) {
                    return q3.a.b(i23, i24, i14, i15);
                }
                i25++;
            }
            i19 += iAbs2;
            if (i19 > 0) {
                if (i24 == i17) {
                    break;
                }
                i24 += i21;
                i19 -= i26;
            }
            i23 += i20;
            iAbs = i26;
            z10 = z11;
            i18 = 1;
        }
        if (i25 == 2) {
            return q3.a.b(i22, i17, i14, i15);
        }
        return Float.NaN;
    }

    public final g e(Map<h3.e, ?> map) {
        this.f11597b = map == null ? null : (t) map.get(h3.e.NEED_RESULT_POINT_CALLBACK);
        return g(new e(this.f11596a, this.f11597b).g(map));
    }

    protected final a f(float f10, int i10, int i11, float f11) throws m {
        int i12 = (int) (f11 * f10);
        int iMax = Math.max(0, i10 - i12);
        int iMin = Math.min(this.f11596a.n() - 1, i10 + i12) - iMax;
        float f12 = 3.0f * f10;
        if (iMin < f12) {
            throw m.a();
        }
        int iMax2 = Math.max(0, i11 - i12);
        int iMin2 = Math.min(this.f11596a.k() - 1, i11 + i12) - iMax2;
        if (iMin2 >= f12) {
            return new b(this.f11596a, iMax, iMax2, iMin, iMin2, f10, this.f11597b).c();
        }
        throw m.a();
    }

    public c(p3.b bVar) {
        this.f11596a = bVar;
    }

    private float b(s sVar, s sVar2) {
        float fJ = j((int) sVar.c(), (int) sVar.d(), (int) sVar2.c(), (int) sVar2.d());
        float fJ2 = j((int) sVar2.c(), (int) sVar2.d(), (int) sVar.c(), (int) sVar.d());
        if (Float.isNaN(fJ)) {
            return fJ2 / 7.0f;
        }
        if (Float.isNaN(fJ2)) {
            return fJ / 7.0f;
        }
        return (fJ + fJ2) / 14.0f;
    }

    private static int c(s sVar, s sVar2, s sVar3, float f10) {
        int iC = (q3.a.c(s.b(sVar, sVar2) / f10) + q3.a.c(s.b(sVar, sVar3) / f10)) / 2;
        int i10 = iC + 7;
        int i11 = i10 & 3;
        if (i11 != 0) {
            if (i11 != 2) {
                if (i11 != 3) {
                    return i10;
                }
                return iC + 5;
            }
            return iC + 6;
        }
        return iC + 8;
    }

    private static p3.b h(p3.b bVar, o oVar, int i10) {
        return l.b().d(bVar, i10, i10, oVar);
    }

    private float j(int i10, int i11, int i12, int i13) {
        float fN;
        float fK;
        float fI = i(i10, i11, i12, i13);
        int iN = i10 - (i12 - i10);
        int iK = 0;
        if (iN < 0) {
            fN = i10 / (i10 - iN);
            iN = 0;
        } else if (iN >= this.f11596a.n()) {
            fN = ((this.f11596a.n() - 1) - i10) / (iN - i10);
            iN = this.f11596a.n() - 1;
        } else {
            fN = 1.0f;
        }
        float f10 = i11;
        int i14 = (int) (f10 - ((i13 - i11) * fN));
        if (i14 < 0) {
            fK = f10 / (i11 - i14);
        } else if (i14 >= this.f11596a.k()) {
            fK = ((this.f11596a.k() - 1) - i11) / (i14 - i11);
            iK = this.f11596a.k() - 1;
        } else {
            iK = i14;
            fK = 1.0f;
        }
        return (fI + i(i10, i11, (int) (i10 + ((iN - i10) * fK)), iK)) - 1.0f;
    }

    protected final float a(s sVar, s sVar2, s sVar3) {
        return (b(sVar, sVar2) + b(sVar, sVar3)) / 2.0f;
    }

    protected final g g(f fVar) throws h, m {
        a aVarF;
        s[] sVarArr;
        d dVarB = fVar.b();
        d dVarC = fVar.c();
        d dVarA = fVar.a();
        float fA = a(dVarB, dVarC, dVarA);
        if (fA >= 1.0f) {
            int iC = c(dVarB, dVarC, dVarA, fA);
            j jVarG = j.g(iC);
            int iE = jVarG.e() - 7;
            if (jVarG.d().length > 0) {
                float fC = (dVarC.c() - dVarB.c()) + dVarA.c();
                float fD = (dVarC.d() - dVarB.d()) + dVarA.d();
                float f10 = 1.0f - (3.0f / iE);
                int iC2 = (int) (dVarB.c() + ((fC - dVarB.c()) * f10));
                int iD = (int) (dVarB.d() + (f10 * (fD - dVarB.d())));
                int i10 = 4;
                while (true) {
                    if (i10 <= 16) {
                        try {
                            aVarF = f(fA, iC2, iD, i10);
                            break;
                        } catch (m unused) {
                            i10 <<= 1;
                        }
                    } else {
                        aVarF = null;
                        break;
                    }
                }
            } else {
                aVarF = null;
                break;
            }
            p3.b bVarH = h(this.f11596a, d(dVarB, dVarC, dVarA, aVarF, iC), iC);
            if (aVarF == null) {
                sVarArr = new s[]{dVarA, dVarB, dVarC};
            } else {
                sVarArr = new s[]{dVarA, dVarB, dVarC, aVarF};
            }
            return new g(bVarH, sVarArr);
        }
        throw m.a();
    }
}
