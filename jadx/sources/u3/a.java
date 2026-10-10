package u3;

import h3.m;
import h3.s;
import p3.b;
import p3.g;
import p3.l;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f19341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q3.b f19342b;

    private s a(s[] sVarArr) {
        s sVar = sVarArr[0];
        s sVar2 = sVarArr[1];
        s sVar3 = sVarArr[2];
        s sVar4 = sVarArr[3];
        int iJ = j(sVar, sVar4);
        s sVarH = h(sVar, sVar2, (j(sVar2, sVar4) + 1) * 4);
        s sVarH2 = h(sVar3, sVar2, (iJ + 1) * 4);
        int iJ2 = j(sVarH, sVar4);
        int iJ3 = j(sVarH2, sVar4);
        float f10 = iJ2 + 1;
        s sVar5 = new s(sVar4.c() + ((sVar3.c() - sVar2.c()) / f10), sVar4.d() + ((sVar3.d() - sVar2.d()) / f10));
        float f11 = iJ3 + 1;
        s sVar6 = new s(sVar4.c() + ((sVar.c() - sVar2.c()) / f11), sVar4.d() + ((sVar.d() - sVar2.d()) / f11));
        if (e(sVar5)) {
            if (!e(sVar6) || j(sVarH, sVar5) + j(sVarH2, sVar5) > j(sVarH, sVar6) + j(sVarH2, sVar6)) {
                return sVar5;
            }
        } else if (!e(sVar6)) {
            return null;
        }
        return sVar6;
    }

    private s[] c(s[] sVarArr) {
        s sVar = sVarArr[0];
        s sVar2 = sVarArr[1];
        s sVar3 = sVarArr[3];
        s sVar4 = sVarArr[2];
        int iJ = j(sVar, sVar2);
        int iJ2 = j(sVar2, sVar3);
        int iJ3 = j(sVar3, sVar4);
        int iJ4 = j(sVar4, sVar);
        s[] sVarArr2 = {sVar4, sVar, sVar2, sVar3};
        if (iJ > iJ2) {
            sVarArr2[0] = sVar;
            sVarArr2[1] = sVar2;
            sVarArr2[2] = sVar3;
            sVarArr2[3] = sVar4;
            iJ = iJ2;
        }
        if (iJ > iJ3) {
            sVarArr2[0] = sVar2;
            sVarArr2[1] = sVar3;
            sVarArr2[2] = sVar4;
            sVarArr2[3] = sVar;
        } else {
            iJ3 = iJ;
        }
        if (iJ3 > iJ4) {
            sVarArr2[0] = sVar3;
            sVarArr2[1] = sVar4;
            sVarArr2[2] = sVar;
            sVarArr2[3] = sVar2;
        }
        return sVarArr2;
    }

    private s[] d(s[] sVarArr) {
        s sVar = sVarArr[0];
        s sVar2 = sVarArr[1];
        s sVar3 = sVarArr[2];
        s sVar4 = sVarArr[3];
        int iJ = (j(sVar, sVar4) + 1) * 4;
        if (j(h(sVar2, sVar3, iJ), sVar) < j(h(sVar3, sVar2, iJ), sVar4)) {
            sVarArr[0] = sVar;
            sVarArr[1] = sVar2;
            sVarArr[2] = sVar3;
            sVarArr[3] = sVar4;
            return sVarArr;
        }
        sVarArr[0] = sVar2;
        sVarArr[1] = sVar3;
        sVarArr[2] = sVar4;
        sVarArr[3] = sVar;
        return sVarArr;
    }

    private s[] i(s[] sVarArr) {
        s sVar = sVarArr[0];
        s sVar2 = sVarArr[1];
        s sVar3 = sVarArr[2];
        s sVar4 = sVarArr[3];
        int iJ = j(sVar, sVar4) + 1;
        s sVarH = h(sVar, sVar2, (j(sVar3, sVar4) + 1) * 4);
        s sVarH2 = h(sVar3, sVar2, iJ * 4);
        int iJ2 = j(sVarH, sVar4);
        int i10 = iJ2 + 1;
        int iJ3 = j(sVarH2, sVar4);
        int i11 = iJ3 + 1;
        if ((i10 & 1) == 1) {
            i10 = iJ2 + 2;
        }
        if ((i11 & 1) == 1) {
            i11 = iJ3 + 2;
        }
        float fC = (((sVar.c() + sVar2.c()) + sVar3.c()) + sVar4.c()) / 4.0f;
        float fD = (((sVar.d() + sVar2.d()) + sVar3.d()) + sVar4.d()) / 4.0f;
        s sVarF = f(sVar, fC, fD);
        s sVarF2 = f(sVar2, fC, fD);
        s sVarF3 = f(sVar3, fC, fD);
        s sVarF4 = f(sVar4, fC, fD);
        int i12 = i11 * 4;
        int i13 = i10 * 4;
        return new s[]{h(h(sVarF, sVarF2, i12), sVarF4, i13), h(h(sVarF2, sVarF, i12), sVarF3, i13), h(h(sVarF3, sVarF4, i12), sVarF2, i13), h(h(sVarF4, sVarF3, i12), sVarF, i13)};
    }

    private int j(s sVar, s sVar2) {
        int iC = (int) sVar.c();
        int iD = (int) sVar.d();
        int iC2 = (int) sVar2.c();
        int iMin = Math.min(this.f19341a.k() - 1, (int) sVar2.d());
        int i10 = 0;
        boolean z10 = Math.abs(iMin - iD) > Math.abs(iC2 - iC);
        if (z10) {
            iD = iC;
            iC = iD;
            iMin = iC2;
            iC2 = iMin;
        }
        int iAbs = Math.abs(iC2 - iC);
        int iAbs2 = Math.abs(iMin - iD);
        int i11 = (-iAbs) / 2;
        int i12 = iD < iMin ? 1 : -1;
        int i13 = iC >= iC2 ? -1 : 1;
        boolean zH = this.f19341a.h(z10 ? iD : iC, z10 ? iC : iD);
        while (iC != iC2) {
            boolean zH2 = this.f19341a.h(z10 ? iD : iC, z10 ? iC : iD);
            if (zH2 != zH) {
                i10++;
                zH = zH2;
            }
            i11 += iAbs2;
            if (i11 > 0) {
                if (iD == iMin) {
                    return i10;
                }
                iD += i12;
                i11 -= iAbs;
            }
            iC += i13;
        }
        return i10;
    }

    public g b() throws m {
        int iMax;
        s[] sVarArrD = d(c(this.f19342b.c()));
        s sVarA = a(sVarArrD);
        sVarArrD[3] = sVarA;
        if (sVarA == null) {
            throw m.a();
        }
        s[] sVarArrI = i(sVarArrD);
        s sVar = sVarArrI[0];
        s sVar2 = sVarArrI[1];
        s sVar3 = sVarArrI[2];
        s sVar4 = sVarArrI[3];
        int iJ = j(sVar, sVar4);
        int i10 = iJ + 1;
        int iJ2 = j(sVar3, sVar4);
        int i11 = iJ2 + 1;
        if ((i10 & 1) == 1) {
            i10 = iJ + 2;
        }
        if ((i11 & 1) == 1) {
            i11 = iJ2 + 2;
        }
        if (i10 * 4 >= i11 * 6 || i11 * 4 >= i10 * 6) {
            iMax = i10;
        } else {
            iMax = Math.max(i10, i11);
            i11 = iMax;
        }
        return new g(g(this.f19341a, sVar, sVar2, sVar3, sVar4, iMax, i11), new s[]{sVar, sVar2, sVar3, sVar4});
    }

    public a(b bVar) {
        this.f19341a = bVar;
        this.f19342b = new q3.b(bVar);
    }

    private boolean e(s sVar) {
        if (sVar.c() >= 0.0f && sVar.c() <= this.f19341a.n() - 1 && sVar.d() > 0.0f && sVar.d() <= this.f19341a.k() - 1) {
            return true;
        }
        return false;
    }

    private static s f(s sVar, float f10, float f11) {
        float f12;
        float f13;
        float fC = sVar.c();
        float fD = sVar.d();
        if (fC < f10) {
            f12 = fC - 1.0f;
        } else {
            f12 = fC + 1.0f;
        }
        if (fD < f11) {
            f13 = fD - 1.0f;
        } else {
            f13 = fD + 1.0f;
        }
        return new s(f12, f13);
    }

    private static b g(b bVar, s sVar, s sVar2, s sVar3, s sVar4, int i10, int i11) {
        float f10 = i10 - 0.5f;
        float f11 = i11 - 0.5f;
        return l.b().c(bVar, i10, i11, 0.5f, 0.5f, f10, 0.5f, f10, f11, 0.5f, f11, sVar.c(), sVar.d(), sVar4.c(), sVar4.d(), sVar3.c(), sVar3.d(), sVar2.c(), sVar2.d());
    }

    private static s h(s sVar, s sVar2, int i10) {
        float f10 = i10 + 1;
        return new s(sVar.c() + ((sVar2.c() - sVar.c()) / f10), sVar.d() + ((sVar2.d() - sVar.d()) / f10));
    }
}
