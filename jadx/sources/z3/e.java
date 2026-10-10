package z3;

import h3.m;
import h3.q;
import h3.r;
import h3.s;
import h3.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class e extends a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int[] f22663i = {1, 10, 34, 70, 126};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int[] f22664j = {4, 20, 48, 81};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int[] f22665k = {0, 161, 961, 2015, 2715};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int[] f22666l = {0, 336, 1036, 1516};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int[] f22667m = {8, 6, 4, 3, 1};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int[] f22668n = {2, 4, 6, 8};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int[][] f22669o = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<d> f22670g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<d> f22671h = new ArrayList();

    private d w(p3.a aVar, boolean z10, int i10, Map<h3.e, ?> map) {
        try {
            c cVarY = y(aVar, i10, z10, x(aVar, z10));
            t tVar = map == null ? null : (t) map.get(h3.e.NEED_RESULT_POINT_CALLBACK);
            if (tVar != null) {
                int[] iArrB = cVarY.b();
                float fM = ((iArrB[0] + iArrB[1]) - 1) / 2.0f;
                if (z10) {
                    fM = (aVar.m() - 1) - fM;
                }
                tVar.a(new s(fM, i10));
            }
            b bVarV = v(aVar, cVarY, true);
            b bVarV2 = v(aVar, cVarY, false);
            return new d((bVarV.b() * 1597) + bVarV2.b(), bVarV.a() + (bVarV2.a() * 4), cVarY);
        } catch (m unused) {
            return null;
        }
    }

    private c y(p3.a aVar, int i10, boolean z10, int[] iArr) throws m {
        int i11;
        boolean zI = aVar.i(iArr[0]);
        int i12 = iArr[0] - 1;
        while (i12 >= 0 && zI != aVar.i(i12)) {
            i12--;
        }
        int i13 = i12 + 1;
        int i14 = iArr[0] - i13;
        int[] iArrJ = j();
        System.arraycopy(iArrJ, 0, iArrJ, 1, iArrJ.length - 1);
        iArrJ[0] = i14;
        int iQ = a.q(iArrJ, f22669o);
        int iM = iArr[1];
        if (z10) {
            int iM2 = (aVar.m() - 1) - i13;
            iM = (aVar.m() - 1) - iM;
            i11 = iM2;
        } else {
            i11 = i13;
        }
        return new c(iQ, new int[]{i13, iArr[1]}, i11, iM, i10);
    }

    @Override // y3.r
    public q c(int i10, p3.a aVar, Map<h3.e, ?> map) throws m {
        r(this.f22670g, w(aVar, false, i10, map));
        aVar.q();
        r(this.f22671h, w(aVar, true, i10, map));
        aVar.q();
        for (d dVar : this.f22670g) {
            if (dVar.c() > 1) {
                for (d dVar2 : this.f22671h) {
                    if (dVar2.c() > 1 && t(dVar, dVar2)) {
                        return u(dVar, dVar2);
                    }
                }
            }
        }
        throw m.a();
    }

    private static void r(Collection<d> collection, d dVar) {
        if (dVar == null) {
            return;
        }
        for (d dVar2 : collection) {
            if (dVar2.b() == dVar.b()) {
                dVar2.e();
                return;
            }
        }
        collection.add(dVar);
    }

    @Override // y3.r, h3.o
    public void reset() {
        this.f22670g.clear();
        this.f22671h.clear();
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0025 A[PHI: r6 r7
      0x0025: PHI (r6v9 boolean) = (r6v3 boolean), (r6v13 boolean) binds: [B:26:0x0040, B:11:0x0023] A[DONT_GENERATE, DONT_INLINE]
      0x0025: PHI (r7v9 boolean) = (r7v1 boolean), (r7v11 boolean) binds: [B:26:0x0040, B:11:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:14:0x002a A[PHI: r6 r7
      0x002a: PHI (r6v7 boolean) = (r6v3 boolean), (r6v13 boolean) binds: [B:28:0x0043, B:13:0x0028] A[DONT_GENERATE, DONT_INLINE]
      0x002a: PHI (r7v5 boolean) = (r7v1 boolean), (r7v11 boolean) binds: [B:28:0x0043, B:13:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:16:0x002d A[PHI: r6 r7
      0x002d: PHI (r6v5 boolean) = (r6v3 boolean), (r6v13 boolean) binds: [B:28:0x0043, B:13:0x0028] A[DONT_GENERATE, DONT_INLINE]
      0x002d: PHI (r7v3 boolean) = (r7v1 boolean), (r7v11 boolean) binds: [B:28:0x0043, B:13:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    private void s(boolean z10, int i10) throws m {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        int iD = q3.a.d(m());
        int iD2 = q3.a.d(k());
        boolean z15 = true;
        boolean z16 = false;
        if (z10) {
            if (iD > 12) {
                z15 = false;
                z11 = true;
            } else {
                if (iD < 4) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                z11 = false;
            }
            if (iD2 > 12) {
                z12 = false;
                z13 = true;
            } else {
                if (iD2 < 4) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                z13 = false;
            }
        } else {
            if (iD > 11) {
                z15 = false;
                z11 = true;
            } else {
                if (iD < 5) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                z11 = false;
            }
            if (iD2 > 10) {
                z12 = false;
                z13 = true;
            } else {
                if (iD2 < 4) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                z13 = false;
            }
        }
        int i11 = (iD + iD2) - i10;
        if ((iD & 1) == z10) {
            z14 = true;
        } else {
            z14 = false;
        }
        if ((iD2 & 1) == 1) {
            z16 = true;
        }
        if (i11 != -1) {
            if (i11 != 0) {
                if (i11 == 1) {
                    if (z14) {
                        if (!z16) {
                            z11 = true;
                        } else {
                            throw m.a();
                        }
                    } else if (z16) {
                        z15 = z15;
                        z13 = true;
                    } else {
                        throw m.a();
                    }
                } else {
                    throw m.a();
                }
            } else if (z14) {
                if (z16) {
                    if (iD < iD2) {
                        z13 = true;
                    } else {
                        z12 = true;
                        z11 = true;
                    }
                } else {
                    throw m.a();
                }
            } else if (!z16) {
                z15 = z15;
            } else {
                throw m.a();
            }
        } else if (z14) {
            if (z16) {
                throw m.a();
            }
        } else if (z16) {
            z15 = z15;
            z12 = true;
        } else {
            throw m.a();
        }
        if (z15) {
            if (!z11) {
                a.o(m(), n());
            } else {
                throw m.a();
            }
        }
        if (z11) {
            a.h(m(), n());
        }
        if (z12) {
            if (!z13) {
                a.o(k(), n());
            } else {
                throw m.a();
            }
        }
        if (z13) {
            a.h(k(), l());
        }
    }

    private static boolean t(d dVar, d dVar2) {
        int iA = (dVar.a() + (dVar2.a() * 16)) % 79;
        int iC = (dVar.d().c() * 9) + dVar2.d().c();
        if (iC > 72) {
            iC--;
        }
        if (iC > 8) {
            iC--;
        }
        if (iA == iC) {
            return true;
        }
        return false;
    }

    private static q u(d dVar, d dVar2) {
        String strValueOf = String.valueOf((((long) dVar.b()) * 4537077) + ((long) dVar2.b()));
        StringBuilder sb2 = new StringBuilder(14);
        for (int length = 13 - strValueOf.length(); length > 0; length--) {
            sb2.append('0');
        }
        sb2.append(strValueOf);
        int i10 = 0;
        for (int i11 = 0; i11 < 13; i11++) {
            int iCharAt = sb2.charAt(i11) - '0';
            if ((i11 & 1) == 0) {
                iCharAt *= 3;
            }
            i10 += iCharAt;
        }
        int i12 = 10 - (i10 % 10);
        if (i12 == 10) {
            i12 = 0;
        }
        sb2.append(i12);
        s[] sVarArrA = dVar.d().a();
        s[] sVarArrA2 = dVar2.d().a();
        q qVar = new q(sb2.toString(), null, new s[]{sVarArrA[0], sVarArrA[1], sVarArrA2[0], sVarArrA2[1]}, h3.a.RSS_14);
        qVar.h(r.SYMBOLOGY_IDENTIFIER, "]e0");
        return qVar;
    }

    private b v(p3.a aVar, c cVar, boolean z10) throws m {
        int i10;
        int[] iArrI = i();
        Arrays.fill(iArrI, 0);
        if (z10) {
            y3.r.g(aVar, cVar.b()[0], iArrI);
        } else {
            y3.r.f(aVar, cVar.b()[1], iArrI);
            int i11 = 0;
            for (int length = iArrI.length - 1; i11 < length; length--) {
                int i12 = iArrI[i11];
                iArrI[i11] = iArrI[length];
                iArrI[length] = i12;
                i11++;
            }
        }
        if (z10) {
            i10 = 16;
        } else {
            i10 = 15;
        }
        float fD = q3.a.d(iArrI) / i10;
        int[] iArrM = m();
        int[] iArrK = k();
        float[] fArrN = n();
        float[] fArrL = l();
        for (int i13 = 0; i13 < iArrI.length; i13++) {
            float f10 = iArrI[i13] / fD;
            int i14 = (int) (0.5f + f10);
            if (i14 < 1) {
                i14 = 1;
            } else if (i14 > 8) {
                i14 = 8;
            }
            int i15 = i13 / 2;
            if ((i13 & 1) == 0) {
                iArrM[i15] = i14;
                fArrN[i15] = f10 - i14;
            } else {
                iArrK[i15] = i14;
                fArrL[i15] = f10 - i14;
            }
        }
        s(z10, i10);
        int i16 = 0;
        int i17 = 0;
        for (int length2 = iArrM.length - 1; length2 >= 0; length2--) {
            int i18 = iArrM[length2];
            i16 = (i16 * 9) + i18;
            i17 += i18;
        }
        int i19 = 0;
        int i20 = 0;
        for (int length3 = iArrK.length - 1; length3 >= 0; length3--) {
            int i21 = iArrK[length3];
            i19 = (i19 * 9) + i21;
            i20 += i21;
        }
        int i22 = i16 + (i19 * 3);
        if (z10) {
            if ((i17 & 1) == 0 && i17 <= 12 && i17 >= 4) {
                int i23 = (12 - i17) / 2;
                int i24 = f22667m[i23];
                int i25 = 9 - i24;
                return new b((f.b(iArrM, i24, false) * f22663i[i23]) + f.b(iArrK, i25, true) + f22665k[i23], i22);
            }
            throw m.a();
        }
        if ((i20 & 1) == 0 && i20 <= 10 && i20 >= 4) {
            int i26 = (10 - i20) / 2;
            int i27 = f22668n[i26];
            return new b((f.b(iArrK, 9 - i27, false) * f22664j[i26]) + f.b(iArrM, i27, true) + f22666l[i26], i22);
        }
        throw m.a();
    }

    private int[] x(p3.a aVar, boolean z10) throws m {
        int[] iArrJ = j();
        iArrJ[0] = 0;
        iArrJ[1] = 0;
        iArrJ[2] = 0;
        iArrJ[3] = 0;
        int iM = aVar.m();
        int i10 = 0;
        boolean z11 = false;
        while (i10 < iM) {
            z11 = !aVar.i(i10);
            if (z10 == z11) {
                break;
            }
            i10++;
        }
        int i11 = i10;
        int i12 = 0;
        while (i10 < iM) {
            if (aVar.i(i10) != z11) {
                iArrJ[i12] = iArrJ[i12] + 1;
            } else {
                if (i12 == 3) {
                    if (a.p(iArrJ)) {
                        return new int[]{i11, i10};
                    }
                    i11 += iArrJ[0] + iArrJ[1];
                    iArrJ[0] = iArrJ[2];
                    iArrJ[1] = iArrJ[3];
                    iArrJ[2] = 0;
                    iArrJ[3] = 0;
                    i12--;
                } else {
                    i12++;
                }
                iArrJ[i12] = 1;
                z11 = !z11;
            }
            i10++;
        }
        throw m.a();
    }
}
