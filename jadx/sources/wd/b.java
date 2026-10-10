package wd;

import fc.d0;
import fc.h1;
import fc.p;
import fc.q1;
import fc.u1;
import fd.g;
import fd.j;
import fd.k;
import fd.l;
import fd.o;
import java.io.IOException;
import nd.h;
import re.f;
import td.m;
import xd.a0;
import xd.s;
import xd.y;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class b {
    public static pc.b a(xc.a aVar, d0 d0Var) throws IOException {
        if (aVar instanceof le.a) {
            le.a aVar2 = (le.a) aVar;
            return new pc.b(e.x(aVar2.b()), new q1(aVar2.a()), d0Var);
        }
        if (aVar instanceof ud.b) {
            ud.b bVar = (ud.b) aVar;
            return new pc.b(new rc.a(g.f10294r, new j(e.F(bVar.a()))), new q1(bVar.b()));
        }
        if (aVar instanceof od.a) {
            rc.a aVar3 = new rc.a(g.f10298v);
            short[] sArrA = ((od.a) aVar).a();
            byte[] bArr = new byte[sArrA.length * 2];
            for (int i10 = 0; i10 != sArrA.length; i10++) {
                f.m(sArrA[i10], bArr, i10 * 2);
            }
            return new pc.b(aVar3, new q1(bArr));
        }
        if (aVar instanceof h) {
            h hVar = (h) aVar;
            byte[] bArrB = nd.a.f().i(1).c(hVar).b();
            return new pc.b(new rc.a(pc.a.J0), new q1(bArrB), d0Var, nd.a.f().i(1).c(hVar.i()).b());
        }
        if (aVar instanceof nd.c) {
            nd.c cVar = (nd.c) aVar;
            byte[] bArrB2 = nd.a.f().i(cVar.c()).c(cVar).b();
            return new pc.b(new rc.a(pc.a.J0), new q1(bArrB2), d0Var, nd.a.f().i(cVar.c()).c(cVar.d().c()).b());
        }
        if (aVar instanceof vd.f) {
            vd.f fVar = (vd.f) aVar;
            byte[] encoded = fVar.getEncoded();
            return new pc.b(new rc.a(e.H(fVar.a())), new q1(encoded), d0Var, fVar.b());
        }
        if (aVar instanceof rd.c) {
            rd.c cVar2 = (rd.c) aVar;
            return new pc.b(new rc.a(e.v(cVar2.a())), new q1(cVar2.getEncoded()), d0Var);
        }
        if (aVar instanceof hd.g) {
            hd.g gVar = (hd.g) aVar;
            gVar.getEncoded();
            return new pc.b(new rc.a(e.p(gVar.a())), new fd.a(0, gVar.d(), gVar.c(), gVar.e(), gVar.b(), gVar.f(), new fd.b(gVar.g())), d0Var);
        }
        if (aVar instanceof y) {
            y yVar = (y) aVar;
            return new pc.b(new rc.a(g.f10299w, new k(yVar.b().b(), e.I(yVar.a()))), b(yVar), d0Var);
        }
        if (aVar instanceof s) {
            s sVar = (s) aVar;
            return new pc.b(new rc.a(g.F, new l(sVar.b().a(), sVar.b().b(), e.I(sVar.a()))), c(sVar), d0Var);
        }
        if (aVar instanceof ke.b) {
            ke.b bVar2 = (ke.b) aVar;
            return new pc.b(new rc.a(g.f10290n), new fd.c(bVar2.f(), bVar2.e(), bVar2.b(), bVar2.c(), bVar2.g(), e.i(bVar2.a())));
        }
        if (aVar instanceof ld.e) {
            ld.e eVar = (ld.e) aVar;
            return new pc.b(new rc.a(e.g(eVar.a())), new q1(eVar.getEncoded()), d0Var);
        }
        if (aVar instanceof sd.e) {
            sd.e eVar2 = (sd.e) aVar;
            return new pc.b(new rc.a(e.z(eVar2.a())), new q1(eVar2.getEncoded()), d0Var);
        }
        if (aVar instanceof m) {
            m mVar = (m) aVar;
            return new pc.b(new rc.a(e.B(mVar.a())), new q1(mVar.getEncoded()), d0Var);
        }
        if (aVar instanceof pd.c) {
            pd.c cVar3 = (pd.c) aVar;
            return new pc.b(new rc.a(e.r(cVar3.a())), new q1(cVar3.getEncoded()), d0Var);
        }
        if (aVar instanceof kd.c) {
            kd.c cVar4 = (kd.c) aVar;
            fc.g gVar2 = new fc.g();
            gVar2.a(new p(1L));
            gVar2.a(new q1(cVar4.e()));
            gVar2.a(new q1(cVar4.b()));
            gVar2.a(new q1(cVar4.d()));
            return new pc.b(new rc.a(e.e(cVar4.a())), new u1(gVar2), d0Var, cVar4.c());
        }
        if (aVar instanceof jd.c) {
            jd.c cVar5 = (jd.c) aVar;
            fc.g gVar3 = new fc.g();
            gVar3.a(new p(0L));
            gVar3.a(new q1(cVar5.e()));
            gVar3.a(new q1(cVar5.b()));
            gVar3.a(new q1(cVar5.c()));
            rc.a aVar4 = new rc.a(e.n(cVar5.a()));
            fc.g gVar4 = new fc.g();
            gVar4.a(new q1(cVar5.f()));
            gVar4.a(new q1(cVar5.d()));
            return new pc.b(aVar4, new u1(gVar3), d0Var, new u1(gVar4).getEncoded());
        }
        if (aVar instanceof qd.c) {
            qd.c cVar6 = (qd.c) aVar;
            fc.g gVar5 = new fc.g();
            gVar5.a(new q1(cVar6.b()));
            gVar5.a(new q1(cVar6.d()));
            gVar5.a(new q1(cVar6.e()));
            gVar5.a(new q1(cVar6.c()));
            return new pc.b(new rc.a(e.t(cVar6.a())), new u1(gVar5), d0Var);
        }
        if (aVar instanceof qd.g) {
            qd.g gVar6 = (qd.g) aVar;
            fc.g gVar7 = new fc.g();
            gVar7.a(new q1(gVar6.b()));
            gVar7.a(new q1(gVar6.c()));
            gVar7.a(new q1(gVar6.e()));
            gVar7.a(new q1(gVar6.f()));
            gVar7.a(new q1(gVar6.d()));
            return new pc.b(new rc.a(e.D(gVar6.a())), new u1(gVar7), d0Var);
        }
        if (!(aVar instanceof id.c)) {
            if (aVar instanceof gd.d) {
                gd.d dVar = (gd.d) aVar;
                return new pc.b(new rc.a(e.a(dVar.a())), new q1(dVar.getEncoded()), d0Var);
            }
            if (!(aVar instanceof md.d)) {
                throw new IOException("key parameters not recognized");
            }
            md.d dVar2 = (md.d) aVar;
            return new pc.b(new rc.a(e.l(dVar2.a())), new q1(dVar2.b()), d0Var);
        }
        id.c cVar7 = (id.c) aVar;
        fc.g gVar8 = new fc.g();
        gVar8.a(new p(0L));
        gVar8.a(new h1(cVar7.c()));
        gVar8.a(new h1(cVar7.b()));
        gVar8.a(new h1(cVar7.h()));
        gVar8.a(new h1(cVar7.d()));
        gVar8.a(new h1(cVar7.e()));
        gVar8.a(new h1(cVar7.f()));
        rc.a aVar5 = new rc.a(e.c(cVar7.a()));
        fc.g gVar9 = new fc.g();
        gVar9.a(new q1(cVar7.c()));
        gVar9.a(new q1(cVar7.g()));
        return new pc.b(aVar5, new u1(gVar8), d0Var, new u1(gVar9).getEncoded());
    }

    private static o b(y yVar) throws IOException {
        byte[] encoded = yVar.getEncoded();
        int iH = yVar.b().h();
        int iB = yVar.b().b();
        int iA = (int) a0.a(encoded, 0, 4);
        if (a0.l(iB, iA)) {
            byte[] bArrG = a0.g(encoded, 4, iH);
            int i10 = 4 + iH;
            byte[] bArrG2 = a0.g(encoded, i10, iH);
            int i11 = i10 + iH;
            byte[] bArrG3 = a0.g(encoded, i11, iH);
            int i12 = i11 + iH;
            byte[] bArrG4 = a0.g(encoded, i12, iH);
            int i13 = i12 + iH;
            byte[] bArrG5 = a0.g(encoded, i13, encoded.length - i13);
            try {
                xd.a aVar = (xd.a) a0.f(bArrG5, xd.a.class);
                if (aVar.c() != (1 << iB) - 1) {
                    return new o(iA, bArrG, bArrG2, bArrG3, bArrG4, bArrG5, aVar.c());
                }
                return new o(iA, bArrG, bArrG2, bArrG3, bArrG4, bArrG5);
            } catch (ClassNotFoundException e10) {
                throw new IOException("cannot parse BDS: " + e10.getMessage());
            }
        }
        throw new IllegalArgumentException("index out of bounds");
    }

    private static fd.m c(s sVar) throws IOException {
        byte[] encoded = sVar.getEncoded();
        int iF = sVar.b().f();
        int iA = sVar.b().a();
        int i10 = (iA + 7) / 8;
        long jA = (int) a0.a(encoded, 0, i10);
        if (a0.l(iA, jA)) {
            byte[] bArrG = a0.g(encoded, i10, iF);
            int i11 = i10 + iF;
            byte[] bArrG2 = a0.g(encoded, i11, iF);
            int i12 = i11 + iF;
            byte[] bArrG3 = a0.g(encoded, i12, iF);
            int i13 = i12 + iF;
            byte[] bArrG4 = a0.g(encoded, i13, iF);
            int i14 = i13 + iF;
            byte[] bArrG5 = a0.g(encoded, i14, encoded.length - i14);
            try {
                xd.b bVar = (xd.b) a0.f(bArrG5, xd.b.class);
                if (bVar.b() != (1 << iA) - 1) {
                    return new fd.m(jA, bArrG, bArrG2, bArrG3, bArrG4, bArrG5, bVar.b());
                }
                return new fd.m(jA, bArrG, bArrG2, bArrG3, bArrG4, bArrG5);
            } catch (ClassNotFoundException e10) {
                throw new IOException("cannot parse BDSStateMap: " + e10.getMessage());
            }
        }
        throw new IllegalArgumentException("index out of bounds");
    }
}
