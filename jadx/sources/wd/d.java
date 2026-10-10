package wd;

import fc.q1;
import fc.u1;
import fd.g;
import fd.j;
import fd.k;
import fd.l;
import fd.n;
import fd.p;
import hd.h;
import java.io.IOException;
import ld.f;
import nd.i;
import xd.t;
import xd.z;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class d {
    public static rc.b a(xc.a aVar) throws IOException {
        if (aVar instanceof le.b) {
            le.b bVar = (le.b) aVar;
            return new rc.b(e.x(bVar.b()), bVar.a());
        }
        if (aVar instanceof ud.c) {
            ud.c cVar = (ud.c) aVar;
            return new rc.b(new rc.a(g.f10294r, new j(e.F(cVar.a()))), cVar.b());
        }
        if (aVar instanceof od.b) {
            return new rc.b(new rc.a(g.f10298v), ((od.b) aVar).a());
        }
        if (aVar instanceof i) {
            return new rc.b(new rc.a(pc.a.J0), new q1(nd.a.f().i(1).c((i) aVar).b()));
        }
        if (aVar instanceof nd.d) {
            nd.d dVar = (nd.d) aVar;
            return new rc.b(new rc.a(pc.a.J0), new q1(nd.a.f().i(dVar.b()).c(dVar.c()).b()));
        }
        if (aVar instanceof vd.g) {
            vd.g gVar = (vd.g) aVar;
            return new rc.b(new rc.a(e.H(gVar.a())), new q1(gVar.getEncoded()));
        }
        if (aVar instanceof h) {
            h hVar = (h) aVar;
            return new rc.b(new rc.a(e.p(hVar.a())), new fd.b(hVar.getEncoded()));
        }
        if (aVar instanceof z) {
            z zVar = (z) aVar;
            byte[] bArrC = zVar.c();
            byte[] bArrD = zVar.d();
            byte[] encoded = zVar.getEncoded();
            return encoded.length > bArrC.length + bArrD.length ? new rc.b(new rc.a(kc.a.f12234a), new q1(encoded)) : new rc.b(new rc.a(g.f10299w, new k(zVar.b().b(), e.I(zVar.a()))), new p(bArrC, bArrD));
        }
        if (aVar instanceof t) {
            t tVar = (t) aVar;
            byte[] bArrC2 = tVar.c();
            byte[] bArrD2 = tVar.d();
            byte[] encoded2 = tVar.getEncoded();
            return encoded2.length > bArrC2.length + bArrD2.length ? new rc.b(new rc.a(kc.a.f12235b), new q1(encoded2)) : new rc.b(new rc.a(g.F, new l(tVar.b().a(), tVar.b().b(), e.I(tVar.a()))), new n(tVar.c(), tVar.d()));
        }
        if (aVar instanceof ke.c) {
            ke.c cVar2 = (ke.c) aVar;
            return new rc.b(new rc.a(g.f10290n), new fd.d(cVar2.c(), cVar2.d(), cVar2.b(), e.i(cVar2.a())));
        }
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            return new rc.b(new rc.a(e.g(fVar.a())), new q1(fVar.getEncoded()));
        }
        if (aVar instanceof sd.f) {
            sd.f fVar2 = (sd.f) aVar;
            return new rc.b(new rc.a(e.z(fVar2.a())), new u1(new q1(fVar2.getEncoded())));
        }
        if (aVar instanceof rd.d) {
            rd.d dVar2 = (rd.d) aVar;
            return new rc.b(new rc.a(e.v(dVar2.a())), new q1(dVar2.getEncoded()));
        }
        if (aVar instanceof td.n) {
            td.n nVar = (td.n) aVar;
            return new rc.b(new rc.a(e.B(nVar.a())), new q1(nVar.getEncoded()));
        }
        if (aVar instanceof pd.d) {
            pd.d dVar3 = (pd.d) aVar;
            return new rc.b(new rc.a(e.r(dVar3.a())), new q1(dVar3.getEncoded()));
        }
        if (aVar instanceof kd.d) {
            kd.d dVar4 = (kd.d) aVar;
            return new rc.b(new rc.a(e.e(dVar4.a())), new u1(new q1(dVar4.b())));
        }
        if (aVar instanceof jd.d) {
            jd.d dVar5 = (jd.d) aVar;
            rc.a aVar2 = new rc.a(e.n(dVar5.a()));
            fc.g gVar2 = new fc.g();
            gVar2.a(new q1(dVar5.c()));
            gVar2.a(new q1(dVar5.b()));
            return new rc.b(aVar2, new u1(gVar2));
        }
        if (aVar instanceof qd.d) {
            qd.d dVar6 = (qd.d) aVar;
            return new rc.b(new rc.a(e.t(dVar6.a())), new q1(dVar6.getEncoded()));
        }
        if (aVar instanceof qd.h) {
            qd.h hVar2 = (qd.h) aVar;
            return new rc.b(new rc.a(e.D(hVar2.a())), new q1(hVar2.getEncoded()));
        }
        if (aVar instanceof id.d) {
            id.d dVar7 = (id.d) aVar;
            rc.a aVar3 = new rc.a(e.c(dVar7.a()));
            fc.g gVar3 = new fc.g();
            gVar3.a(new q1(dVar7.b()));
            gVar3.a(new q1(dVar7.c()));
            return new rc.b(aVar3, new u1(gVar3));
        }
        if (aVar instanceof gd.e) {
            gd.e eVar = (gd.e) aVar;
            return new rc.b(new rc.a(e.a(eVar.a())), new q1(eVar.getEncoded()));
        }
        if (!(aVar instanceof md.e)) {
            throw new IOException("key parameters not recognized");
        }
        md.e eVar2 = (md.e) aVar;
        return new rc.b(new rc.a(e.l(eVar2.a())), new q1(eVar2.getEncoded()));
    }
}
