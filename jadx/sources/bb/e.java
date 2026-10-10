package bb;

import androidx.core.view.InputDeviceCompat;
import db.j;
import db.l;
import db.m;
import db.n;
import db.o;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ByteOrder f1033a = ByteOrder.LITTLE_ENDIAN;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private cb.c f1034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ByteBuffer f1035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private db.i f1036d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Set<Locale> f1037e;

    private cb.a d() {
        long jPosition = this.f1035c.position();
        int iG = fb.a.g(this.f1035c);
        int iG2 = fb.a.g(this.f1035c);
        int iF = (int) fb.a.f(this.f1035c);
        if (iG != 0) {
            if (iG == 1) {
                cb.d dVar = new cb.d(iG2, iF);
                dVar.i(fb.a.f(this.f1035c));
                dVar.k(fb.a.f(this.f1035c));
                dVar.h(fb.a.f(this.f1035c));
                dVar.j(fb.a.f(this.f1035c));
                dVar.l(fb.a.f(this.f1035c));
                fb.a.b(this.f1035c, jPosition + ((long) iG2));
                return dVar;
            }
            if (iG == 2) {
                j jVar = new j(iG2, iF);
                jVar.e(fb.a.f(this.f1035c));
                fb.a.b(this.f1035c, jPosition + ((long) iG2));
                return jVar;
            }
            switch (iG) {
                case 512:
                    db.d dVar2 = new db.d(iG2, iF);
                    dVar2.h(fb.a.f(this.f1035c));
                    dVar2.l(fb.e.g(this.f1035c, 128));
                    dVar2.m(fb.a.f(this.f1035c));
                    dVar2.k(fb.a.f(this.f1035c));
                    dVar2.i(fb.a.f(this.f1035c));
                    dVar2.j(fb.a.f(this.f1035c));
                    fb.a.b(this.f1035c, jPosition + ((long) iG2));
                    return dVar2;
                case InputDeviceCompat.SOURCE_DPAD /* 513 */:
                    m mVar = new m(iG2, iF);
                    mVar.k(fb.a.e(this.f1035c));
                    mVar.l(fb.a.e(this.f1035c));
                    mVar.m(fb.a.g(this.f1035c));
                    mVar.j(fb.a.f(this.f1035c));
                    mVar.i(fb.a.f(this.f1035c));
                    mVar.h(f());
                    fb.a.b(this.f1035c, jPosition + ((long) iG2));
                    return mVar;
                case 514:
                    o oVar = new o(iG2, iF);
                    oVar.g(fb.a.e(this.f1035c));
                    oVar.h(fb.a.e(this.f1035c));
                    oVar.i(fb.a.g(this.f1035c));
                    oVar.f(fb.a.f(this.f1035c));
                    fb.a.b(this.f1035c, jPosition + ((long) iG2));
                    return oVar;
                case 515:
                    db.b bVar = new db.b(iG2, iF);
                    bVar.e(fb.a.f(this.f1035c));
                    fb.a.b(this.f1035c, jPosition + ((long) iG2));
                    return bVar;
                case 516:
                    break;
                default:
                    throw new ab.a("Unexpected chunk Type: 0x" + Integer.toHexString(iG));
            }
        }
        fb.a.b(this.f1035c, jPosition + ((long) iG2));
        return new db.c(iG2, iF);
    }

    private fb.d<db.h, db.d> e(db.d dVar) {
        fb.d<db.h, db.d> dVar2 = new fb.d<>();
        db.h hVar = new db.h(dVar);
        dVar2.c(hVar);
        long jPosition = this.f1035c.position();
        if (dVar.g() > 0) {
            fb.a.b(this.f1035c, (((long) dVar.g()) + jPosition) - ((long) dVar.c()));
            hVar.i(fb.e.f(this.f1035c, (cb.d) d()));
        }
        if (dVar.e() > 0) {
            fb.a.b(this.f1035c, (jPosition + ((long) dVar.e())) - ((long) dVar.c()));
            hVar.h(fb.e.f(this.f1035c, (cb.d) d()));
        }
        while (this.f1035c.hasRemaining()) {
            cb.a aVarD = d();
            long jPosition2 = this.f1035c.position();
            int iB = aVarD.b();
            if (iB != 0) {
                int i10 = 0;
                switch (iB) {
                    case 512:
                        dVar2.d((db.d) aVarD);
                        return dVar2;
                    case InputDeviceCompat.SOURCE_DPAD /* 513 */:
                        m mVar = (m) aVarD;
                        long[] jArr = new long[mVar.f()];
                        while (i10 < mVar.f()) {
                            jArr[i10] = fb.a.f(this.f1035c);
                            i10++;
                        }
                        l lVar = new l(mVar);
                        lVar.i(hVar.f().a(mVar.g() - 1));
                        fb.a.b(this.f1035c, (((long) mVar.e()) + jPosition2) - ((long) mVar.c()));
                        ByteBuffer byteBufferSlice = this.f1035c.slice();
                        byteBufferSlice.order(this.f1033a);
                        lVar.g(byteBufferSlice);
                        lVar.h(hVar.d());
                        lVar.j(jArr);
                        lVar.k(this.f1034b);
                        hVar.a(lVar);
                        this.f1037e.add(lVar.c());
                        fb.a.b(this.f1035c, jPosition2 + ((long) mVar.a()));
                        break;
                    case 514:
                        o oVar = (o) aVarD;
                        long[] jArr2 = new long[oVar.d()];
                        while (i10 < oVar.d()) {
                            jArr2[i10] = fb.a.f(this.f1035c);
                            i10++;
                        }
                        n nVar = new n(oVar);
                        nVar.d(jArr2);
                        nVar.e(hVar.f().a(oVar.e() - 1));
                        hVar.b(nVar);
                        fb.a.b(this.f1035c, jPosition2 + ((long) oVar.a()));
                        break;
                    case 515:
                        db.b bVar = (db.b) aVarD;
                        for (long j10 = 0; j10 < bVar.d(); j10++) {
                            new db.a(this.f1035c.getInt(), fb.a.h(this.f1035c, 128));
                        }
                        fb.a.b(this.f1035c, jPosition2 + ((long) aVarD.a()));
                        break;
                    default:
                        throw new ab.a("unexpected chunk type: 0x" + aVarD.b());
                }
            } else {
                ByteBuffer byteBuffer = this.f1035c;
                fb.a.a(byteBuffer, byteBuffer.position() + this.f1035c.remaining());
            }
        }
        return dVar2;
    }

    private db.e f() {
        long jPosition = this.f1035c.position();
        db.e eVar = new db.e();
        long jF = fb.a.f(this.f1035c);
        eVar.g(this.f1035c.getShort());
        eVar.h(this.f1035c.getShort());
        eVar.f(new String(fb.a.c(this.f1035c, 2)).replace("\u0000", ""));
        eVar.d(new String(fb.a.c(this.f1035c, 2)).replace("\u0000", ""));
        eVar.i(fb.a.e(this.f1035c));
        eVar.j(fb.a.e(this.f1035c));
        eVar.e(fb.a.g(this.f1035c));
        fb.a.i(this.f1035c, (int) (jF - (((long) this.f1035c.position()) - jPosition)));
        return eVar;
    }

    public Set<Locale> a() {
        return this.f1037e;
    }

    public db.i b() {
        return this.f1036d;
    }

    public e(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        this.f1035c = byteBufferDuplicate;
        byteBufferDuplicate.order(this.f1033a);
        this.f1037e = new HashSet();
    }

    public void c() {
        j jVar = (j) d();
        this.f1034b = fb.e.f(this.f1035c, (cb.d) d());
        db.i iVar = new db.i();
        this.f1036d = iVar;
        iVar.d(this.f1034b);
        db.d dVarB = (db.d) d();
        for (int i10 = 0; i10 < jVar.d(); i10++) {
            fb.d<db.h, db.d> dVarE = e(dVarB);
            this.f1036d.a(dVarE.a());
            dVarB = dVarE.b();
        }
    }
}
