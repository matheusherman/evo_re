package q3;

import h3.m;
import h3.s;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p3.b f17629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f17630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f17631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f17632d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f17633e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f17634f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f17635g;

    public b(p3.b bVar) {
        this(bVar, 10, bVar.n() / 2, bVar.k() / 2);
    }

    private boolean b(int i10, int i11, int i12, boolean z10) {
        if (z10) {
            while (i10 <= i11) {
                if (this.f17629a.h(i10, i12)) {
                    return true;
                }
                i10++;
            }
            return false;
        }
        while (i10 <= i11) {
            if (this.f17629a.h(i12, i10)) {
                return true;
            }
            i10++;
        }
        return false;
    }

    public b(p3.b bVar, int i10, int i11, int i12) throws m {
        this.f17629a = bVar;
        int iK = bVar.k();
        this.f17630b = iK;
        int iN = bVar.n();
        this.f17631c = iN;
        int i13 = i10 / 2;
        int i14 = i11 - i13;
        this.f17632d = i14;
        int i15 = i11 + i13;
        this.f17633e = i15;
        int i16 = i12 - i13;
        this.f17635g = i16;
        int i17 = i12 + i13;
        this.f17634f = i17;
        if (i16 < 0 || i14 < 0 || i17 >= iK || i15 >= iN) {
            throw m.a();
        }
    }

    public s[] c() throws m {
        int i10 = this.f17632d;
        int i11 = this.f17633e;
        int i12 = this.f17635g;
        int i13 = this.f17634f;
        boolean z10 = false;
        boolean z11 = true;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        while (z11) {
            boolean zB = true;
            boolean z16 = false;
            while (true) {
                if ((!zB && z12) || i11 >= this.f17631c) {
                    break;
                }
                zB = b(i12, i13, i11, false);
                if (zB) {
                    i11++;
                    z12 = true;
                    z16 = true;
                } else if (!z12) {
                    i11++;
                }
            }
            if (i11 < this.f17631c) {
                boolean zB2 = true;
                while (true) {
                    if ((!zB2 && z13) || i13 >= this.f17630b) {
                        break;
                    }
                    zB2 = b(i10, i11, i13, true);
                    if (zB2) {
                        i13++;
                        z13 = true;
                        z16 = true;
                    } else if (!z13) {
                        i13++;
                    }
                }
                if (i13 < this.f17630b) {
                    boolean zB3 = true;
                    while (true) {
                        if ((!zB3 && z14) || i10 < 0) {
                            break;
                        }
                        zB3 = b(i12, i13, i10, false);
                        if (zB3) {
                            i10--;
                            z14 = true;
                            z16 = true;
                        } else if (!z14) {
                            i10--;
                        }
                    }
                    if (i10 >= 0) {
                        z11 = z16;
                        boolean zB4 = true;
                        while (true) {
                            if ((!zB4 && z15) || i12 < 0) {
                                break;
                            }
                            zB4 = b(i10, i11, i12, true);
                            if (zB4) {
                                i12--;
                                z11 = true;
                                z15 = true;
                            } else if (!z15) {
                                i12--;
                            }
                        }
                        if (i12 < 0) {
                        }
                    }
                }
            }
            z10 = true;
            break;
        }
        if (z10) {
            throw m.a();
        }
        int i14 = i11 - i10;
        s sVarD = null;
        s sVarD2 = null;
        for (int i15 = 1; sVarD2 == null && i15 < i14; i15++) {
            sVarD2 = d(i10, i13 - i15, i10 + i15, i13);
        }
        if (sVarD2 == null) {
            throw m.a();
        }
        s sVarD3 = null;
        for (int i16 = 1; sVarD3 == null && i16 < i14; i16++) {
            sVarD3 = d(i10, i12 + i16, i10 + i16, i12);
        }
        if (sVarD3 == null) {
            throw m.a();
        }
        s sVarD4 = null;
        for (int i17 = 1; sVarD4 == null && i17 < i14; i17++) {
            sVarD4 = d(i11, i12 + i17, i11 - i17, i12);
        }
        if (sVarD4 == null) {
            throw m.a();
        }
        for (int i18 = 1; sVarD == null && i18 < i14; i18++) {
            sVarD = d(i11, i13 - i18, i11 - i18, i13);
        }
        if (sVarD != null) {
            return a(sVarD, sVarD2, sVarD4, sVarD3);
        }
        throw m.a();
    }

    private s[] a(s sVar, s sVar2, s sVar3, s sVar4) {
        float fC = sVar.c();
        float fD = sVar.d();
        float fC2 = sVar2.c();
        float fD2 = sVar2.d();
        float fC3 = sVar3.c();
        float fD3 = sVar3.d();
        float fC4 = sVar4.c();
        float fD4 = sVar4.d();
        if (fC < this.f17631c / 2.0f) {
            return new s[]{new s(fC4 - 1.0f, fD4 + 1.0f), new s(fC2 + 1.0f, fD2 + 1.0f), new s(fC3 - 1.0f, fD3 - 1.0f), new s(fC + 1.0f, fD - 1.0f)};
        }
        return new s[]{new s(fC4 + 1.0f, fD4 + 1.0f), new s(fC2 + 1.0f, fD2 - 1.0f), new s(fC3 - 1.0f, fD3 + 1.0f), new s(fC - 1.0f, fD - 1.0f)};
    }

    private s d(float f10, float f11, float f12, float f13) {
        int iC = a.c(a.a(f10, f11, f12, f13));
        float f14 = iC;
        float f15 = (f12 - f10) / f14;
        float f16 = (f13 - f11) / f14;
        for (int i10 = 0; i10 < iC; i10++) {
            float f17 = i10;
            int iC2 = a.c((f17 * f15) + f10);
            int iC3 = a.c((f17 * f16) + f11);
            if (this.f17629a.h(iC2, iC3)) {
                return new s(iC2, iC3);
            }
        }
        return null;
    }
}
