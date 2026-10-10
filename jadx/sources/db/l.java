package db;

import java.nio.ByteBuffer;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private short f9706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Locale f9707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private cb.c f9708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ByteBuffer f9709e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long[] f9710f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private cb.c f9711g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f9712h;

    private f e() {
        long jPosition = this.f9709e.position();
        f fVar = new f();
        fVar.g(fb.a.g(this.f9709e));
        fVar.e(fb.a.g(this.f9709e));
        fVar.f(this.f9708d.a(this.f9709e.getInt()));
        if ((fVar.a() & 1) == 0) {
            fb.a.b(this.f9709e, jPosition + ((long) fVar.c()));
            fVar.h(fb.e.d(this.f9709e, this.f9711g));
            return fVar;
        }
        g gVar = new g(fVar);
        gVar.l(fb.a.f(this.f9709e));
        gVar.k(fb.a.f(this.f9709e));
        fb.a.b(this.f9709e, jPosition + ((long) fVar.c()));
        k[] kVarArr = new k[(int) gVar.j()];
        for (int i10 = 0; i10 < gVar.j(); i10++) {
            kVarArr[i10] = f();
        }
        gVar.m(kVarArr);
        return gVar;
    }

    private k f() {
        k kVar = new k();
        kVar.b(fb.a.f(this.f9709e));
        kVar.c(fb.e.d(this.f9709e, this.f9711g));
        if ((kVar.a() & 33554432) != 0) {
            return kVar;
        }
        kVar.a();
        return kVar;
    }

    public int a() {
        return this.f9712h;
    }

    public short b() {
        return this.f9706b;
    }

    public Locale c() {
        return this.f9707c;
    }

    public f d(int i10) {
        long[] jArr = this.f9710f;
        if (i10 >= jArr.length) {
            return null;
        }
        long j10 = jArr[i10];
        if (j10 == 4294967295L) {
            return null;
        }
        fb.a.b(this.f9709e, j10);
        return e();
    }

    public void g(ByteBuffer byteBuffer) {
        this.f9709e = byteBuffer;
    }

    public void h(cb.c cVar) {
        this.f9708d = cVar;
    }

    public void i(String str) {
        this.f9705a = str;
    }

    public void j(long[] jArr) {
        this.f9710f = jArr;
    }

    public void k(cb.c cVar) {
        this.f9711g = cVar;
    }

    public String toString() {
        return "Type{name='" + this.f9705a + "', id=" + ((int) this.f9706b) + ", locale=" + this.f9707c + '}';
    }

    public l(m mVar) {
        this.f9706b = mVar.g();
        e eVarD = mVar.d();
        this.f9707c = new Locale(eVarD.c(), eVarD.a());
        this.f9712h = eVarD.b();
    }
}
