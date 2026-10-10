package wd;

import fc.c0;
import fc.z;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import xd.x;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map f20485a;

    static /* synthetic */ class a {
    }

    private static class b extends u {
        private b() {
            super(null);
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        @Override // wd.c.u
        xc.a a(rc.b bVar, Object obj) {
            return new gd.e(wd.e.b(bVar.m().m()), fc.v.z(bVar.q()).A());
        }
    }

    /* JADX INFO: renamed from: wd.c$c, reason: collision with other inner class name */
    private static class C0392c extends u {
        private C0392c() {
            super(null);
        }

        /* synthetic */ C0392c(a aVar) {
            this();
        }

        @Override // wd.c.u
        xc.a a(rc.b bVar, Object obj) {
            return new hd.h(wd.e.q(bVar.m().m()), fd.b.m(bVar.q()).n());
        }
    }

    private static class d extends u {
        private d() {
            super(null);
        }

        /* synthetic */ d(a aVar) {
            this();
        }

        @Override // wd.c.u
        xc.a a(rc.b bVar, Object obj) {
            id.b bVarD = wd.e.d(bVar.m().m());
            z zVarQ = bVar.q();
            if (zVarQ instanceof c0) {
                c0 c0VarZ = c0.z(zVarQ);
                return new id.d(bVarD, fc.v.z(c0VarZ.A(0)).A(), fc.v.z(c0VarZ.A(1)).A());
            }
            return new id.d(bVarD, fc.v.z(zVarQ).A());
        }
    }

    private static class e extends u {
        private e() {
            super(null);
        }

        /* synthetic */ e(a aVar) {
            this();
        }

        @Override // wd.c.u
        xc.a a(rc.b bVar, Object obj) {
            kd.b bVarF = wd.e.f(bVar.m().m());
            z zVarQ = bVar.q();
            if (zVarQ instanceof c0) {
                return new kd.d(bVarF, fc.v.z(c0.z(zVarQ).A(0)).A());
            }
            byte[] bArrA = fc.v.z(zVarQ).A();
            if (bArrA[0] == ((byte) bVarF.a())) {
                return new kd.d(bVarF, re.a.i(bArrA, 1, bArrA.length));
            }
            throw new IllegalArgumentException("byte[] enc of Falcon h value not tagged correctly");
        }
    }

    private static class f extends u {
        private f() {
            super(null);
        }

        /* synthetic */ f(a aVar) {
            this();
        }

        @Override // wd.c.u
        xc.a a(rc.b bVar, Object obj) {
            return new ld.f(wd.e.h(bVar.m().m()), fc.v.z(bVar.q()).A());
        }
    }

    private static class g extends u {
        private g() {
            super(null);
        }

        /* synthetic */ g(a aVar) {
            this();
        }

        @Override // wd.c.u
        xc.a a(rc.b bVar, Object obj) {
            return new md.e(wd.e.m(bVar.m().m()), fc.v.z(bVar.q()).A());
        }
    }

    private static class h extends u {
        private h() {
            super(null);
        }

        /* synthetic */ h(a aVar) {
            this();
        }

        @Override // wd.c.u
        xc.a a(rc.b bVar, Object obj) {
            jd.b bVarO = wd.e.o(bVar.m().m());
            z zVarQ = bVar.q();
            if (zVarQ instanceof c0) {
                c0 c0VarZ = c0.z(zVarQ);
                return new jd.d(bVarO, fc.v.z(c0VarZ.A(0)).A(), fc.v.z(c0VarZ.A(1)).A());
            }
            return new jd.d(bVarO, fc.v.z(zVarQ).A());
        }
    }

    private static class i extends u {
        private i() {
            super(null);
        }

        /* synthetic */ i(a aVar) {
            this();
        }

        @Override // wd.c.u
        xc.a a(rc.b bVar, Object obj) {
            byte[] bArrA = fc.v.z(bVar.q()).A();
            if (re.f.a(bArrA, 0) == 1) {
                return nd.i.a(re.a.i(bArrA, 4, bArrA.length));
            }
            if (bArrA.length == 64) {
                bArrA = re.a.i(bArrA, 4, bArrA.length);
            }
            return nd.d.a(bArrA);
        }
    }

    private static class j extends u {
        private j() {
            super(null);
        }

        /* synthetic */ j(a aVar) {
            this();
        }

        @Override // wd.c.u
        xc.a a(rc.b bVar, Object obj) {
            fd.d dVarO = fd.d.o(bVar.q());
            return new ke.c(dVarO.q(), dVarO.r(), dVarO.n(), wd.e.k(dVarO.m().m()));
        }
    }

    private static class k extends u {
        private k() {
            super(null);
        }

        /* synthetic */ k(a aVar) {
            this();
        }

        @Override // wd.c.u
        xc.a a(rc.b bVar, Object obj) {
            return new od.b(bVar.o().y());
        }
    }

    private static class l extends u {
        private l() {
            super(null);
        }

        /* synthetic */ l(a aVar) {
            this();
        }

        @Override // wd.c.u
        xc.a a(rc.b bVar, Object obj) {
            return new qd.d(wd.e.u(bVar.m().m()), fc.v.z(bVar.q()).A());
        }
    }

    private static class m extends u {
        private m() {
            super(null);
        }

        /* synthetic */ m(a aVar) {
            this();
        }

        @Override // wd.c.u
        xc.a a(rc.b bVar, Object obj) {
            return new pd.d(wd.e.s(bVar.m().m()), fc.v.z(bVar.q()).A());
        }
    }

    private static class n extends u {
        private n() {
            super(null);
        }

        /* synthetic */ n(a aVar) {
            this();
        }

        @Override // wd.c.u
        xc.a a(rc.b bVar, Object obj) {
            return new rd.d(wd.e.w(bVar.m().m()), fc.v.z(bVar.q()).A());
        }
    }

    private static class o extends u {
        private o() {
            super(null);
        }

        /* synthetic */ o(a aVar) {
            this();
        }

        @Override // wd.c.u
        xc.a a(rc.b bVar, Object obj) {
            return new le.b(wd.e.y(bVar.m()), bVar.o().B());
        }
    }

    private static class p extends u {
        private p() {
            super(null);
        }

        /* synthetic */ p(a aVar) {
            this();
        }

        @Override // wd.c.u
        xc.a a(rc.b bVar, Object obj) {
            return new sd.f(wd.e.A(bVar.m().m()), fc.v.z(c0.z(bVar.q()).A(0)).A());
        }
    }

    private static class q extends u {
        private q() {
            super(null);
        }

        /* synthetic */ q(a aVar) {
            this();
        }

        @Override // wd.c.u
        xc.a a(rc.b bVar, Object obj) {
            return new td.n(wd.e.C(bVar.m().m()), fc.v.z(bVar.q()).A());
        }
    }

    private static class r extends u {
        private r() {
            super(null);
        }

        /* synthetic */ r(a aVar) {
            this();
        }

        @Override // wd.c.u
        xc.a a(rc.b bVar, Object obj) {
            return new qd.h(wd.e.E(bVar.m().m()), fc.v.z(bVar.q()).A());
        }
    }

    private static class s extends u {
        private s() {
            super(null);
        }

        /* synthetic */ s(a aVar) {
            this();
        }

        @Override // wd.c.u
        xc.a a(rc.b bVar, Object obj) {
            return new ud.c(bVar.o().y(), wd.e.G(fd.j.m(bVar.m().o())));
        }
    }

    private static class t extends u {
        private t() {
            super(null);
        }

        /* synthetic */ t(a aVar) {
            this();
        }

        @Override // wd.c.u
        xc.a a(rc.b bVar, Object obj) {
            byte[] bArrA = fc.v.z(bVar.q()).A();
            return new vd.g(vd.e.c(re.d.a(re.f.a(bArrA, 0))), re.a.i(bArrA, 4, bArrA.length));
        }
    }

    private static abstract class u {
        private u() {
        }

        abstract xc.a a(rc.b bVar, Object obj);

        /* synthetic */ u(a aVar) {
            this();
        }
    }

    private static class v extends u {
        private v() {
            super(null);
        }

        /* synthetic */ v(a aVar) {
            this();
        }

        @Override // wd.c.u
        xc.a a(rc.b bVar, Object obj) {
            xd.z.b bVarF;
            fd.k kVarN = fd.k.n(bVar.m().o());
            if (kVarN != null) {
                fc.u uVarM = kVarN.o().m();
                fd.p pVarM = fd.p.m(bVar.q());
                bVarF = new xd.z.b(new x(kVarN.m(), wd.e.j(uVarM))).g(pVarM.n()).h(pVarM.o());
            } else {
                byte[] bArrA = fc.v.z(bVar.q()).A();
                bVarF = new xd.z.b(x.k(re.f.a(bArrA, 0))).f(bArrA);
            }
            return bVarF.e();
        }
    }

    private static class w extends u {
        private w() {
            super(null);
        }

        /* synthetic */ w(a aVar) {
            this();
        }

        @Override // wd.c.u
        xc.a a(rc.b bVar, Object obj) {
            xd.t.b bVarF;
            fd.l lVarN = fd.l.n(bVar.m().o());
            if (lVarN != null) {
                fc.u uVarM = lVarN.q().m();
                fd.p pVarM = fd.p.m(bVar.q());
                bVarF = new xd.t.b(new xd.r(lVarN.m(), lVarN.o(), wd.e.j(uVarM))).g(pVarM.n()).h(pVarM.o());
            } else {
                byte[] bArrA = fc.v.z(bVar.q()).A();
                bVarF = new xd.t.b(xd.r.i(re.f.a(bArrA, 0))).f(bArrA);
            }
            return bVarF.e();
        }
    }

    static {
        HashMap map = new HashMap();
        f20485a = map;
        a aVar = null;
        map.put(fd.g.X, new o(aVar));
        f20485a.put(fd.g.Y, new o(aVar));
        f20485a.put(fd.g.f10294r, new s(aVar));
        f20485a.put(fd.g.f10298v, new k(aVar));
        f20485a.put(fd.g.f10299w, new v(aVar));
        f20485a.put(fd.g.F, new w(aVar));
        f20485a.put(kc.a.f12234a, new v(aVar));
        f20485a.put(kc.a.f12235b, new w(aVar));
        f20485a.put(pc.a.J0, new i(aVar));
        f20485a.put(fd.g.f10290n, new j(aVar));
        f20485a.put(gc.a.f10586e0, new t(aVar));
        f20485a.put(gc.a.f10590f0, new t(aVar));
        f20485a.put(gc.a.f10594g0, new t(aVar));
        f20485a.put(gc.a.f10598h0, new t(aVar));
        f20485a.put(gc.a.f10602i0, new t(aVar));
        f20485a.put(gc.a.S0, new C0392c(aVar));
        f20485a.put(gc.a.T0, new C0392c(aVar));
        f20485a.put(gc.a.U0, new C0392c(aVar));
        f20485a.put(gc.a.V0, new C0392c(aVar));
        f20485a.put(gc.a.W0, new C0392c(aVar));
        f20485a.put(gc.a.X0, new C0392c(aVar));
        f20485a.put(gc.a.Y0, new C0392c(aVar));
        f20485a.put(gc.a.Z0, new C0392c(aVar));
        f20485a.put(gc.a.f10571a1, new C0392c(aVar));
        f20485a.put(gc.a.f10575b1, new C0392c(aVar));
        f20485a.put(gc.a.f10583d1, new f(aVar));
        f20485a.put(gc.a.f10587e1, new f(aVar));
        f20485a.put(gc.a.f10591f1, new f(aVar));
        f20485a.put(gc.a.f10595g1, new f(aVar));
        f20485a.put(gc.a.f10599h1, new f(aVar));
        f20485a.put(gc.a.f10603i1, new f(aVar));
        f20485a.put(gc.a.f10611k1, new p(aVar));
        f20485a.put(gc.a.f10615l1, new p(aVar));
        f20485a.put(gc.a.f10618m1, new p(aVar));
        f20485a.put(gc.a.f10621n1, new p(aVar));
        f20485a.put(gc.a.f10624o1, new p(aVar));
        f20485a.put(gc.a.f10627p1, new p(aVar));
        f20485a.put(gc.a.f10630q1, new p(aVar));
        f20485a.put(gc.a.f10633r1, new p(aVar));
        f20485a.put(gc.a.f10636s1, new p(aVar));
        f20485a.put(gc.a.f10614l0, new n(aVar));
        f20485a.put(gc.a.f10617m0, new n(aVar));
        f20485a.put(gc.a.f10620n0, new n(aVar));
        f20485a.put(gc.a.f10623o0, new n(aVar));
        f20485a.put(gc.a.f10626p0, new n(aVar));
        f20485a.put(gc.a.f10629q0, new n(aVar));
        f20485a.put(gc.a.f10632r0, new n(aVar));
        f20485a.put(gc.a.f10635s0, new n(aVar));
        f20485a.put(gc.a.f10638t0, new n(aVar));
        f20485a.put(gc.a.f10641u0, new n(aVar));
        f20485a.put(gc.a.f10644v0, new n(aVar));
        f20485a.put(gc.a.f10647w0, new n(aVar));
        f20485a.put(gc.a.f10642u1, new q(aVar));
        f20485a.put(gc.a.f10645v1, new q(aVar));
        f20485a.put(gc.a.f10648w1, new q(aVar));
        f20485a.put(gc.a.f10651x1, new q(aVar));
        f20485a.put(gc.a.f10654y1, new q(aVar));
        f20485a.put(gc.a.f10657z1, new q(aVar));
        f20485a.put(gc.a.A1, new q(aVar));
        f20485a.put(gc.a.B1, new q(aVar));
        f20485a.put(gc.a.D1, new m(aVar));
        f20485a.put(gc.a.E1, new m(aVar));
        f20485a.put(gc.a.F1, new m(aVar));
        f20485a.put(gc.a.G1, new m(aVar));
        f20485a.put(gc.a.C0, new e(aVar));
        f20485a.put(gc.a.D0, new e(aVar));
        f20485a.put(gc.a.I1, new h(aVar));
        f20485a.put(gc.a.J1, new h(aVar));
        f20485a.put(gc.a.K1, new h(aVar));
        f20485a.put(gc.a.L1, new h(aVar));
        f20485a.put(gc.a.M1, new h(aVar));
        f20485a.put(gc.a.N1, new h(aVar));
        f20485a.put(gc.a.Q1, new l(aVar));
        f20485a.put(gc.a.R1, new l(aVar));
        f20485a.put(gc.a.S1, new l(aVar));
        f20485a.put(gc.a.T1, new l(aVar));
        f20485a.put(gc.a.U1, new l(aVar));
        f20485a.put(gc.a.V1, new l(aVar));
        f20485a.put(gc.a.X1, new r(aVar));
        f20485a.put(gc.a.Y1, new r(aVar));
        f20485a.put(gc.a.Z1, new r(aVar));
        f20485a.put(gc.a.f10572a2, new r(aVar));
        f20485a.put(gc.a.f10576b2, new r(aVar));
        f20485a.put(gc.a.f10580c2, new r(aVar));
        f20485a.put(gc.a.F0, new d(aVar));
        f20485a.put(gc.a.G0, new d(aVar));
        f20485a.put(gc.a.H0, new d(aVar));
        f20485a.put(gc.a.I0, new d(aVar));
        f20485a.put(gc.a.J0, new d(aVar));
        f20485a.put(gc.a.K0, new d(aVar));
        f20485a.put(gc.a.f10588e2, new b(aVar));
        f20485a.put(gc.a.f10592f2, new b(aVar));
        f20485a.put(gc.a.f10596g2, new b(aVar));
        f20485a.put(gc.a.f10604i2, new g(aVar));
        f20485a.put(gc.a.f10608j2, new g(aVar));
        f20485a.put(gc.a.f10612k2, new g(aVar));
    }

    public static xc.a a(rc.b bVar) {
        return b(bVar, null);
    }

    public static xc.a b(rc.b bVar, Object obj) throws IOException {
        rc.a aVarM = bVar.m();
        u uVar = (u) f20485a.get(aVarM.m());
        if (uVar != null) {
            return uVar.a(bVar, obj);
        }
        throw new IOException("algorithm identifier in public key not recognised: " + aVarM.m());
    }
}
