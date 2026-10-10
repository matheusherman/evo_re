package d4;

import h3.s;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class h extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f9633c;

    private void l(d[] dVarArr, a aVar) {
        for (int i10 = 0; i10 < dVarArr.length; i10++) {
            d dVar = dVarArr[i10];
            if (dVar != null) {
                int iE = dVar.e() % 30;
                int iC = dVar.c();
                if (iC > aVar.c()) {
                    dVarArr[i10] = null;
                } else {
                    if (!this.f9633c) {
                        iC += 2;
                    }
                    int i11 = iC % 3;
                    if (i11 != 0) {
                        if (i11 != 1) {
                            if (i11 == 2 && iE + 1 != aVar.a()) {
                                dVarArr[i10] = null;
                            }
                        } else if (iE / 3 != aVar.b() || iE % 3 != aVar.d()) {
                            dVarArr[i10] = null;
                        }
                    } else if ((iE * 3) + 1 != aVar.e()) {
                        dVarArr[i10] = null;
                    }
                }
            }
        }
    }

    boolean k() {
        return this.f9633c;
    }

    @Override // d4.g
    public String toString() {
        return "IsLeft: " + this.f9633c + '\n' + super.toString();
    }

    h(c cVar, boolean z10) {
        super(cVar);
        this.f9633c = z10;
    }

    private void h(a aVar) {
        s sVarI;
        s sVarC;
        c cVarA = a();
        if (this.f9633c) {
            sVarI = cVarA.h();
        } else {
            sVarI = cVarA.i();
        }
        if (this.f9633c) {
            sVarC = cVarA.b();
        } else {
            sVarC = cVarA.c();
        }
        int iE = e((int) sVarC.d());
        d[] dVarArrD = d();
        int iC = -1;
        int i10 = 0;
        int iMax = 1;
        for (int iE2 = e((int) sVarI.d()); iE2 < iE; iE2++) {
            d dVar = dVarArrD[iE2];
            if (dVar != null) {
                dVar.j();
                int iC2 = dVar.c() - iC;
                if (iC2 == 0) {
                    i10++;
                } else {
                    if (iC2 == 1) {
                        iMax = Math.max(iMax, i10);
                        iC = dVar.c();
                    } else if (dVar.c() >= aVar.c()) {
                        dVarArrD[iE2] = null;
                    } else {
                        iC = dVar.c();
                    }
                    i10 = 1;
                }
            }
        }
    }

    private void m() {
        for (d dVar : d()) {
            if (dVar != null) {
                dVar.j();
            }
        }
    }

    void g(a aVar) {
        s sVarI;
        s sVarC;
        boolean z10;
        d[] dVarArrD = d();
        m();
        l(dVarArrD, aVar);
        c cVarA = a();
        if (this.f9633c) {
            sVarI = cVarA.h();
        } else {
            sVarI = cVarA.i();
        }
        if (this.f9633c) {
            sVarC = cVarA.b();
        } else {
            sVarC = cVarA.c();
        }
        int iE = e((int) sVarC.d());
        int iC = -1;
        int i10 = 0;
        int iMax = 1;
        for (int iE2 = e((int) sVarI.d()); iE2 < iE; iE2++) {
            d dVar = dVarArrD[iE2];
            if (dVar != null) {
                int iC2 = dVar.c() - iC;
                if (iC2 == 0) {
                    i10++;
                } else {
                    if (iC2 == 1) {
                        iMax = Math.max(iMax, i10);
                        iC = dVar.c();
                    } else if (iC2 >= 0 && dVar.c() < aVar.c() && iC2 <= iE2) {
                        if (iMax > 2) {
                            iC2 *= iMax - 2;
                        }
                        if (iC2 >= iE2) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        for (int i11 = 1; i11 <= iC2 && !z10; i11++) {
                            if (dVarArrD[iE2 - i11] != null) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                        }
                        if (z10) {
                            dVarArrD[iE2] = null;
                        } else {
                            iC = dVar.c();
                        }
                    } else {
                        dVarArrD[iE2] = null;
                    }
                    i10 = 1;
                }
            }
        }
    }

    a i() {
        d[] dVarArrD = d();
        b bVar = new b();
        b bVar2 = new b();
        b bVar3 = new b();
        b bVar4 = new b();
        for (d dVar : dVarArrD) {
            if (dVar != null) {
                dVar.j();
                int iE = dVar.e() % 30;
                int iC = dVar.c();
                if (!this.f9633c) {
                    iC += 2;
                }
                int i10 = iC % 3;
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 == 2) {
                            bVar.b(iE + 1);
                        }
                    } else {
                        bVar4.b(iE / 3);
                        bVar3.b(iE % 3);
                    }
                } else {
                    bVar2.b((iE * 3) + 1);
                }
            }
        }
        if (bVar.a().length != 0 && bVar2.a().length != 0 && bVar3.a().length != 0 && bVar4.a().length != 0 && bVar.a()[0] >= 1 && bVar2.a()[0] + bVar3.a()[0] >= 3 && bVar2.a()[0] + bVar3.a()[0] <= 90) {
            a aVar = new a(bVar.a()[0], bVar2.a()[0], bVar3.a()[0], bVar4.a()[0]);
            l(dVarArrD, aVar);
            return aVar;
        }
        return null;
    }

    int[] j() {
        int iC;
        a aVarI = i();
        if (aVarI == null) {
            return null;
        }
        h(aVarI);
        int iC2 = aVarI.c();
        int[] iArr = new int[iC2];
        for (d dVar : d()) {
            if (dVar != null && (iC = dVar.c()) < iC2) {
                iArr[iC] = iArr[iC] + 1;
            }
        }
        return iArr;
    }
}
