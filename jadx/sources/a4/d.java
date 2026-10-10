package a4;

import b4.j;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.pengrad.telegrambot.passport.decrypt.RsaOaep;
import com.taobao.sophix.PatchStatus;
import h3.e;
import h3.m;
import h3.q;
import h3.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.log4j.net.SyslogAppender;
import y3.r;
import z3.f;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class d extends z3.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int[] f106k = {7, 5, 4, 3, 1};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int[] f107l = {4, 20, 52, 104, 204};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int[] f108m = {0, 348, 1388, 2948, 3988};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int[][] f109n = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int[][] f110o = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, ModuleDescriptor.MODULE_VERSION, 209, 205}, new int[]{193, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, PatchStatus.CODE_LOAD_LIB_CPUABIS}, new int[]{185, PatchStatus.CODE_LOAD_LIB_JSON, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, 138, 203, 187, 139, 206, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, 129, SyslogAppender.LOG_LOCAL6, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, PatchStatus.CODE_LOAD_LIB_NS, 200, 178, 112, 125, 164}, new int[]{70, 210, 208, 202, SyslogAppender.LOG_LOCAL7, 130, 179, 115}, new int[]{PatchStatus.CODE_LOAD_LIB_LOST, 191, 151, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, RsaOaep.DerParser.PRIVATE, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, 175}, new int[]{103, 98, 83, 38, 114, PatchStatus.CODE_LOAD_LIB_UNDEFINED, 182, 124}, new int[]{161, 61, 183, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, PatchStatus.CODE_LOAD_LIB_UNZIP, 194, SyslogAppender.LOG_LOCAL4, 58, 174, 100, 89}};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int[][] f111p = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<b> f112g = new ArrayList(11);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<c> f113h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int[] f114i = new int[2];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f115j;

    private z3.c E(p3.a aVar, int i10, boolean z10, List<b> list) {
        int iL;
        int i11;
        int i12;
        if (z10) {
            int i13 = this.f114i[0] - 1;
            while (i13 >= 0 && !aVar.i(i13)) {
                i13--;
            }
            int i14 = i13 + 1;
            int[] iArr = this.f114i;
            i12 = iArr[0] - i14;
            iL = iArr[1];
            i11 = i14;
        } else {
            int[] iArr2 = this.f114i;
            int i15 = iArr2[0];
            iL = aVar.l(iArr2[1] + 1);
            i11 = i15;
            i12 = iL - this.f114i[1];
        }
        int i16 = iL;
        int[] iArrJ = j();
        System.arraycopy(iArrJ, 0, iArrJ, 1, iArrJ.length - 1);
        iArrJ[0] = i12;
        try {
            int iQ = z3.a.q(iArrJ, f109n);
            if (!D(list, iQ)) {
                return null;
            }
            if (!list.isEmpty()) {
                b bVar = list.get(list.size() - 1);
                int i17 = bVar.a().b()[0];
                int i18 = bVar.a().b()[1];
                float f10 = ((i18 - i17) / 15.0f) * 17.0f;
                float f11 = i18;
                float f12 = f10 * 2.0f;
                float f13 = (0.9f * f12) + f11;
                float f14 = f11 + (f12 * 1.1f);
                float f15 = i11;
                if (f15 < f13 || f15 > f14) {
                    return null;
                }
            }
            return new z3.c(iQ, new int[]{i11, i16}, i11, i16, i10);
        } catch (m unused) {
            return null;
        }
    }

    private static void H(int[] iArr) {
        int length = iArr.length;
        for (int i10 = 0; i10 < length / 2; i10++) {
            int i11 = iArr[i10];
            int i12 = (length - i10) - 1;
            iArr[i10] = iArr[i12];
            iArr[i12] = i11;
        }
    }

    private void I(int i10) {
        boolean zC = false;
        int i11 = 0;
        boolean zC2 = false;
        while (i11 < this.f113h.size()) {
            c cVar = this.f113h.get(i11);
            if (cVar.b() > i10) {
                zC = cVar.c(this.f112g);
                break;
            } else {
                zC2 = cVar.c(this.f112g);
                i11++;
            }
        }
        if (zC || zC2 || B(this.f112g, this.f113h)) {
            return;
        }
        this.f113h.add(i11, new c(this.f112g, i10));
        F(this.f112g, this.f113h);
    }

    @Override // y3.r
    public q c(int i10, p3.a aVar, Map<e, ?> map) {
        this.f115j = false;
        try {
            return v(x(i10, aVar));
        } catch (m unused) {
            this.f115j = true;
            return v(x(i10, aVar));
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001c  */
    /* JADX WARN: Code duplicated, block: B:15:0x002f A[LOOP:1: B:10:0x0016->B:15:0x002f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:24:0x0034 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:9:0x0015  */
    private static boolean C(List<b> list, boolean z10) {
        int i10;
        for (int[] iArr : f111p) {
            int size = list.size();
            int length = iArr.length;
            if (z10) {
                if (size == length) {
                    for (i10 = 0; i10 < list.size(); i10++) {
                        if (list.get(i10).a().c() != iArr[i10]) {
                        }
                    }
                    return true;
                }
                continue;
            } else {
                if (size <= length) {
                    while (i10 < list.size()) {
                        if (list.get(i10).a().c() != iArr[i10]) {
                        }
                    }
                    return true;
                }
                continue;
            }
        }
        return false;
    }

    private boolean s() {
        b bVar = this.f112g.get(0);
        z3.b bVarB = bVar.b();
        z3.b bVarC = bVar.c();
        if (bVarC == null) {
            return false;
        }
        int iA = bVarC.a();
        int i10 = 2;
        for (int i11 = 1; i11 < this.f112g.size(); i11++) {
            b bVar2 = this.f112g.get(i11);
            iA += bVar2.b().a();
            int i12 = i10 + 1;
            z3.b bVarC2 = bVar2.c();
            if (bVarC2 != null) {
                iA += bVarC2.a();
                i10 += 2;
            } else {
                i10 = i12;
            }
        }
        return ((i10 + (-4)) * 211) + (iA % 211) == bVarB.b();
    }

    private List<b> t(List<c> list, int i10) throws m {
        while (i10 < this.f113h.size()) {
            c cVar = this.f113h.get(i10);
            this.f112g.addAll(cVar.a());
            int size = cVar.a().size();
            if (!C(this.f112g, false)) {
                List<b> list2 = this.f112g;
                list2.subList(list2.size() - size, this.f112g.size()).clear();
            } else {
                if (s()) {
                    return this.f112g;
                }
                list.add(cVar);
                try {
                    return t(list, i10 + 1);
                } catch (m unused) {
                    list.remove(list.size() - 1);
                    this.f112g.subList(this.f112g.size() - size, this.f112g.size()).clear();
                }
            }
            i10++;
        }
        throw m.a();
    }

    private List<b> u(boolean z10) {
        List<b> listT = null;
        if (this.f113h.size() > 25) {
            this.f113h.clear();
            return null;
        }
        this.f112g.clear();
        if (z10) {
            Collections.reverse(this.f113h);
        }
        try {
            listT = t(new ArrayList(), 0);
        } catch (m unused) {
        }
        if (z10) {
            Collections.reverse(this.f113h);
        }
        return listT;
    }

    @Override // y3.r, h3.o
    public void reset() {
        this.f112g.clear();
        this.f113h.clear();
    }

    z3.b w(p3.a aVar, z3.c cVar, boolean z10, boolean z11) throws m {
        int[] iArrI = i();
        Arrays.fill(iArrI, 0);
        if (z11) {
            r.g(aVar, cVar.b()[0], iArrI);
        } else {
            r.f(aVar, cVar.b()[1], iArrI);
            int i10 = 0;
            for (int length = iArrI.length - 1; i10 < length; length--) {
                int i11 = iArrI[i10];
                iArrI[i10] = iArrI[length];
                iArrI[length] = i11;
                i10++;
            }
        }
        float fD = q3.a.d(iArrI) / 17;
        float f10 = (cVar.b()[1] - cVar.b()[0]) / 15.0f;
        if (Math.abs(fD - f10) / f10 > 0.3f) {
            throw m.a();
        }
        int[] iArrM = m();
        int[] iArrK = k();
        float[] fArrN = n();
        float[] fArrL = l();
        for (int i12 = 0; i12 < iArrI.length; i12++) {
            float f11 = (iArrI[i12] * 1.0f) / fD;
            int i13 = (int) (0.5f + f11);
            if (i13 < 1) {
                if (f11 < 0.3f) {
                    throw m.a();
                }
                i13 = 1;
            } else if (i13 > 8) {
                if (f11 > 8.7f) {
                    throw m.a();
                }
                i13 = 8;
            }
            int i14 = i12 / 2;
            if ((i12 & 1) == 0) {
                iArrM[i14] = i13;
                fArrN[i14] = f11 - i13;
            } else {
                iArrK[i14] = i13;
                fArrL[i14] = f11 - i13;
            }
        }
        r(17);
        int iC = (((cVar.c() * 4) + (z10 ? 0 : 2)) + (!z11 ? 1 : 0)) - 1;
        int i15 = 0;
        int i16 = 0;
        for (int length2 = iArrM.length - 1; length2 >= 0; length2--) {
            if (A(cVar, z10, z11)) {
                i15 += iArrM[length2] * f110o[iC][length2 * 2];
            }
            i16 += iArrM[length2];
        }
        int i17 = 0;
        for (int length3 = iArrK.length - 1; length3 >= 0; length3--) {
            if (A(cVar, z10, z11)) {
                i17 += iArrK[length3] * f110o[iC][(length3 * 2) + 1];
            }
        }
        int i18 = i15 + i17;
        if ((i16 & 1) != 0 || i16 > 13 || i16 < 4) {
            throw m.a();
        }
        int i19 = (13 - i16) / 2;
        int i20 = f106k[i19];
        return new z3.b((f.b(iArrM, i20, true) * f107l[i19]) + f.b(iArrK, 9 - i20, false) + f108m[i19], i18);
    }

    List<b> x(int i10, p3.a aVar) throws m {
        this.f112g.clear();
        boolean z10 = false;
        while (!z10) {
            try {
                List<b> list = this.f112g;
                list.add(G(aVar, list, i10));
            } catch (m e10) {
                if (this.f112g.isEmpty()) {
                    throw e10;
                }
                z10 = true;
            }
        }
        if (s() && C(this.f112g, true)) {
            return this.f112g;
        }
        boolean zIsEmpty = this.f113h.isEmpty();
        I(i10);
        if (!zIsEmpty) {
            List<b> listU = u(false);
            if (listU != null) {
                return listU;
            }
            List<b> listU2 = u(true);
            if (listU2 != null) {
                return listU2;
            }
        }
        throw m.a();
    }

    private static boolean A(z3.c cVar, boolean z10, boolean z11) {
        if (cVar.c() == 0 && z10 && z11) {
            return false;
        }
        return true;
    }

    private static boolean B(Iterable<b> iterable, Iterable<c> iterable2) {
        for (c cVar : iterable2) {
            for (b bVar : iterable) {
                Iterator<b> it = cVar.a().iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (bVar.equals(it.next())) {
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    private static boolean D(List<b> list, int i10) {
        if (list.isEmpty()) {
            return true;
        }
        for (int[] iArr : f111p) {
            if (list.size() + 1 <= iArr.length) {
                for (int size = list.size(); size < iArr.length; size++) {
                    if (iArr[size] == i10) {
                        for (int i11 = 0; i11 < list.size(); i11++) {
                            if (iArr[(size - i11) - 1] == list.get((list.size() - i11) - 1).a().c()) {
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void F(Collection<b> collection, Collection<c> collection2) {
        Iterator<c> it = collection2.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.a().size() != collection.size()) {
                Iterator<b> it2 = next.a().iterator();
                do {
                    if (!it2.hasNext()) {
                        it.remove();
                        break;
                    }
                } while (collection.contains(it2.next()));
            }
        }
    }

    private void r(int i10) throws m {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        int iD = q3.a.d(m());
        int iD2 = q3.a.d(k());
        boolean z14 = true;
        boolean z15 = false;
        if (iD > 13) {
            z14 = false;
            z10 = true;
        } else {
            if (iD < 4) {
                z14 = true;
            } else {
                z14 = false;
            }
            z10 = false;
        }
        if (iD2 > 13) {
            z11 = false;
            z12 = true;
        } else {
            if (iD2 < 4) {
                z11 = true;
            } else {
                z11 = false;
            }
            z12 = false;
        }
        int i11 = (iD + iD2) - i10;
        if ((iD & 1) == 1) {
            z13 = true;
        } else {
            z13 = false;
        }
        if ((iD2 & 1) == 0) {
            z15 = true;
        }
        if (i11 != -1) {
            if (i11 != 0) {
                if (i11 == 1) {
                    if (z13) {
                        if (!z15) {
                            z10 = true;
                        } else {
                            throw m.a();
                        }
                    } else if (z15) {
                        z14 = z14;
                        z12 = true;
                    } else {
                        throw m.a();
                    }
                } else {
                    throw m.a();
                }
            } else if (z13) {
                if (z15) {
                    if (iD < iD2) {
                        z12 = true;
                    } else {
                        z11 = true;
                        z10 = true;
                    }
                } else {
                    throw m.a();
                }
            } else if (!z15) {
                z14 = z14;
            } else {
                throw m.a();
            }
        } else if (z13) {
            if (z15) {
                throw m.a();
            }
        } else if (z15) {
            z14 = z14;
            z11 = true;
        } else {
            throw m.a();
        }
        if (z14) {
            if (!z10) {
                z3.a.o(m(), n());
            } else {
                throw m.a();
            }
        }
        if (z10) {
            z3.a.h(m(), n());
        }
        if (z11) {
            if (!z12) {
                z3.a.o(k(), n());
            } else {
                throw m.a();
            }
        }
        if (z12) {
            z3.a.h(k(), l());
        }
    }

    static q v(List<b> list) {
        String strD = j.a(a.a(list)).d();
        s[] sVarArrA = list.get(0).a().a();
        s[] sVarArrA2 = list.get(list.size() - 1).a().a();
        q qVar = new q(strD, null, new s[]{sVarArrA[0], sVarArrA[1], sVarArrA2[0], sVarArrA2[1]}, h3.a.RSS_EXPANDED);
        qVar.h(h3.r.SYMBOLOGY_IDENTIFIER, "]e0");
        return qVar;
    }

    private void y(p3.a aVar, List<b> list, int i10) throws m {
        boolean z10;
        int[] iArrJ = j();
        iArrJ[0] = 0;
        iArrJ[1] = 0;
        iArrJ[2] = 0;
        iArrJ[3] = 0;
        int iM = aVar.m();
        if (i10 < 0) {
            if (list.isEmpty()) {
                i10 = 0;
            } else {
                i10 = list.get(list.size() - 1).a().b()[1];
            }
        }
        if (list.size() % 2 != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f115j) {
            z10 = !z10;
        }
        boolean z11 = false;
        while (i10 < iM) {
            boolean zI = aVar.i(i10);
            boolean z12 = !zI;
            if (zI) {
                z11 = z12;
                break;
            } else {
                i10++;
                z11 = z12;
            }
        }
        boolean z13 = z11;
        int i11 = 0;
        int i12 = i10;
        while (i10 < iM) {
            if (aVar.i(i10) != z13) {
                iArrJ[i11] = iArrJ[i11] + 1;
            } else {
                if (i11 == 3) {
                    if (z10) {
                        H(iArrJ);
                    }
                    if (z3.a.p(iArrJ)) {
                        int[] iArr = this.f114i;
                        iArr[0] = i12;
                        iArr[1] = i10;
                        return;
                    }
                    if (z10) {
                        H(iArrJ);
                    }
                    i12 += iArrJ[0] + iArrJ[1];
                    iArrJ[0] = iArrJ[2];
                    iArrJ[1] = iArrJ[3];
                    iArrJ[2] = 0;
                    iArrJ[3] = 0;
                    i11--;
                } else {
                    i11++;
                }
                iArrJ[i11] = 1;
                z13 = !z13;
            }
            i10++;
        }
        throw m.a();
    }

    private static int z(p3.a aVar, int i10) {
        if (aVar.i(i10)) {
            return aVar.k(aVar.l(i10));
        }
        return aVar.l(aVar.k(i10));
    }

    b G(p3.a aVar, List<b> list, int i10) throws m {
        boolean z10;
        z3.c cVarE;
        if (list.size() % 2 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f115j) {
            z10 = !z10;
        }
        z3.b bVarW = null;
        int iZ = -1;
        z3.b bVarW2 = null;
        boolean z11 = true;
        do {
            y(aVar, list, iZ);
            cVarE = E(aVar, i10, z10, list);
            if (cVarE == null) {
                iZ = z(aVar, this.f114i[0]);
            } else {
                try {
                    bVarW2 = w(aVar, cVarE, z10, true);
                    z11 = false;
                } catch (m unused) {
                    iZ = z(aVar, this.f114i[0]);
                }
            }
        } while (z11);
        if (!list.isEmpty() && list.get(list.size() - 1).d()) {
            throw m.a();
        }
        try {
            bVarW = w(aVar, cVarE, z10, false);
        } catch (m unused2) {
        }
        return new b(bVarW2, bVarW, cVarE);
    }
}
