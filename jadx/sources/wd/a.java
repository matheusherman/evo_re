package wd;

import fc.c0;
import fc.p;
import fc.u;
import fc.v;
import fd.j;
import fd.k;
import fd.l;
import fd.o;
import hd.g;
import java.io.IOException;
import nd.h;
import re.f;
import td.m;
import xd.a0;
import xd.r;
import xd.s;
import xd.x;
import xd.y;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class a {
    private static short[] a(byte[] bArr) {
        int length = bArr.length / 2;
        short[] sArr = new short[length];
        for (int i10 = 0; i10 != length; i10++) {
            sArr[i10] = f.h(bArr, i10 * 2);
        }
        return sArr;
    }

    public static xc.a b(pc.b bVar) throws IOException {
        u uVarM = bVar.o().m();
        if (uVarM.H(gc.a.W)) {
            return new le.a(e.y(bVar.o()), v.z(bVar.s()).A());
        }
        if (uVarM.t(gc.a.f10634s)) {
            return new ud.b(v.z(bVar.s()).A(), e.G(j.m(bVar.o().o())));
        }
        if (uVarM.t(gc.a.M0)) {
            return new od.a(a(v.z(bVar.s()).A()));
        }
        if (uVarM.t(pc.a.J0)) {
            byte[] bArrA = v.z(bVar.s()).A();
            fc.c cVarQ = bVar.q();
            if (f.a(bArrA, 0) != 1) {
                if (cVarQ != null) {
                    return nd.c.b(re.a.i(bArrA, 4, bArrA.length), cVarQ.B());
                }
                return nd.c.a(re.a.i(bArrA, 4, bArrA.length));
            }
            if (cVarQ == null) {
                return h.e(re.a.i(bArrA, 4, bArrA.length));
            }
            byte[] bArrB = cVarQ.B();
            return h.f(re.a.i(bArrA, 4, bArrA.length), re.a.i(bArrB, 4, bArrB.length));
        }
        if (uVarM.H(gc.a.f10586e0)) {
            byte[] bArrA2 = v.z(bVar.s()).A();
            return new vd.f(vd.e.c(re.d.a(f.a(bArrA2, 0))), re.a.i(bArrA2, 4, bArrA2.length));
        }
        if (uVarM.H(gc.a.f10606j0)) {
            return new rd.c(e.w(bVar.o().m()), v.z(bVar.s()).A());
        }
        if (uVarM.H(gc.a.R0)) {
            fd.a aVarR = fd.a.r(bVar.s());
            return new g(e.q(bVar.o().m()), aVarR.o(), aVarR.n(), aVarR.q(), aVarR.m(), aVarR.s());
        }
        if (uVarM.H(gc.a.f10579c1)) {
            return new ld.e(e.h(bVar.o().m()), v.z(bVar.s()).A());
        }
        if (uVarM.H(gc.a.f10607j1)) {
            return new sd.e(e.A(bVar.o().m()), v.z(bVar.s()).A());
        }
        if (uVarM.H(gc.a.f10639t1)) {
            return new m(e.C(bVar.o().m()), v.z(bVar.s()).A());
        }
        if (uVarM.H(gc.a.C1)) {
            return new pd.c(e.s(bVar.o().m()), v.z(bVar.s()).A());
        }
        if (uVarM.H(gc.a.H1)) {
            c0 c0VarZ = c0.z(bVar.s());
            jd.b bVarO = e.o(bVar.o().m());
            int iD = p.z(c0VarZ.A(0)).D();
            if (iD == 0) {
                if (bVar.q() == null) {
                    return new jd.c(bVarO, v.z(c0VarZ.A(1)).A(), v.z(c0VarZ.A(2)).A(), v.z(c0VarZ.A(3)).A(), null, null);
                }
                c0 c0VarZ2 = c0.z(bVar.q().B());
                return new jd.c(bVarO, v.z(c0VarZ.A(1)).A(), v.z(c0VarZ.A(2)).A(), v.z(c0VarZ.A(3)).A(), v.z(c0VarZ2.A(0)).A(), v.z(c0VarZ2.A(1)).A());
            }
            throw new IOException("unknown private key version: " + iD);
        }
        if (uVarM.H(gc.a.P1)) {
            c0 c0VarZ3 = c0.z(bVar.s());
            return new qd.c(e.u(bVar.o().m()), v.z(c0VarZ3.A(0)).A(), v.z(c0VarZ3.A(1)).A(), v.z(c0VarZ3.A(2)).A(), v.z(c0VarZ3.A(3)).A());
        }
        if (uVarM.H(gc.a.W1)) {
            c0 c0VarZ4 = c0.z(bVar.s());
            return new qd.g(e.E(bVar.o().m()), v.z(c0VarZ4.A(0)).A(), v.z(c0VarZ4.A(1)).A(), v.z(c0VarZ4.A(2)).A(), v.z(c0VarZ4.A(3)).A(), v.z(c0VarZ4.A(4)).A());
        }
        if (uVarM.t(gc.a.F0) || uVarM.t(gc.a.G0) || uVarM.t(gc.a.H0) || uVarM.t(gc.a.I0) || uVarM.t(gc.a.J0) || uVarM.t(gc.a.K0)) {
            c0 c0VarZ5 = c0.z(bVar.s());
            id.b bVarD = e.d(bVar.o().m());
            int iD2 = p.z(c0VarZ5.A(0)).D();
            if (iD2 == 0) {
                if (bVar.q() != null) {
                    return new id.c(bVarD, fc.c.A(c0VarZ5.A(1)).B(), fc.c.A(c0VarZ5.A(2)).B(), fc.c.A(c0VarZ5.A(3)).B(), fc.c.A(c0VarZ5.A(4)).B(), fc.c.A(c0VarZ5.A(5)).B(), fc.c.A(c0VarZ5.A(6)).B(), v.z(c0.z(bVar.q().B()).A(1)).A());
                }
                return new id.c(bVarD, fc.c.A(c0VarZ5.A(1)).B(), fc.c.A(c0VarZ5.A(2)).B(), fc.c.A(c0VarZ5.A(3)).B(), fc.c.A(c0VarZ5.A(4)).B(), fc.c.A(c0VarZ5.A(5)).B(), fc.c.A(c0VarZ5.A(6)).B(), null);
            }
            throw new IOException("unknown private key version: " + iD2);
        }
        if (uVarM.t(gc.a.C0) || uVarM.t(gc.a.D0)) {
            c0 c0VarZ6 = c0.z(bVar.s());
            kd.b bVarF = e.f(bVar.o().m());
            fc.c cVarQ2 = bVar.q();
            int iD3 = p.z(c0VarZ6.A(0)).D();
            if (iD3 == 1) {
                return bVar.q() != null ? new kd.c(bVarF, v.z(c0VarZ6.A(1)).A(), v.z(c0VarZ6.A(2)).A(), v.z(c0VarZ6.A(3)).A(), cVarQ2.B()) : new kd.c(bVarF, v.z(c0VarZ6.A(1)).A(), v.z(c0VarZ6.A(2)).A(), v.z(c0VarZ6.A(3)).A(), null);
            }
            throw new IOException("unknown private key version: " + iD3);
        }
        if (uVarM.H(gc.a.f10584d2)) {
            byte[] bArrA3 = v.z(bVar.s()).A();
            gd.c cVarB = e.b(bVar.o().m());
            return new gd.d(cVarB, re.a.i(bArrA3, 0, cVarB.a()), re.a.i(bArrA3, cVarB.a(), cVarB.a() * 2), re.a.i(bArrA3, cVarB.a() * 2, bArrA3.length));
        }
        if (uVarM.H(gc.a.f10600h2)) {
            return new md.d(e.m(bVar.o().m()), v.z(bVar.s()).A());
        }
        if (uVarM.t(gc.a.f10646w)) {
            k kVarN = k.n(bVar.o().o());
            u uVarM2 = kVarN.o().m();
            o oVarO = o.o(bVar.s());
            try {
                y.b bVarO2 = new y.b(new x(kVarN.m(), e.j(uVarM2))).l(oVarO.n()).q(oVarO.u()).p(oVarO.t()).n(oVarO.r()).o(oVarO.s());
                if (oVarO.v() != 0) {
                    bVarO2.m(oVarO.q());
                }
                if (oVarO.m() != null) {
                    bVarO2.k(((xd.a) a0.f(oVarO.m(), xd.a.class)).h(uVarM2));
                }
                return bVarO2.j();
            } catch (ClassNotFoundException e10) {
                throw new IOException("ClassNotFoundException processing BDS state: " + e10.getMessage());
            }
        }
        if (!uVarM.t(fd.g.F)) {
            if (!uVarM.t(fd.g.f10290n)) {
                throw new RuntimeException("algorithm identifier in private key not recognised");
            }
            fd.c cVarQ3 = fd.c.q(bVar.s());
            return new ke.b(cVarQ3.s(), cVarQ3.r(), cVarQ3.n(), cVarQ3.o(), cVarQ3.t(), e.k(cVarQ3.m().m()));
        }
        l lVarN = l.n(bVar.o().o());
        u uVarM3 = lVarN.q().m();
        try {
            fd.m mVarO = fd.m.o(bVar.s());
            s.b bVarP = new s.b(new r(lVarN.m(), lVarN.o(), e.j(uVarM3))).m(mVarO.n()).r(mVarO.u()).q(mVarO.t()).o(mVarO.r()).p(mVarO.s());
            if (mVarO.v() != 0) {
                bVarP.n(mVarO.q());
            }
            if (mVarO.m() != null) {
                bVarP.l(((xd.b) a0.f(mVarO.m(), xd.b.class)).f(uVarM3));
            }
            return bVarP.k();
        } catch (ClassNotFoundException e11) {
            throw new IOException("ClassNotFoundException processing BDS state: " + e11.getMessage());
        }
    }
}
