package bb;

import eb.j;
import eb.k;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Set<String> f1024h = new HashSet(Arrays.asList("screenOrientation", "configChanges", "windowSoftInputMode", "launchMode", "installLocation", "protectionLevel"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private cb.c f1026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String[] f1027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ByteBuffer f1028d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private h f1029e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final db.i f1030f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ByteOrder f1025a = ByteOrder.LITTLE_ENDIAN;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Locale f1031g = fb.c.f10104a;

    private eb.a c() {
        String[] strArr;
        int i10 = this.f1028d.getInt();
        int i11 = this.f1028d.getInt();
        eb.a aVar = new eb.a();
        if (i10 > 0) {
            aVar.f(this.f1026b.a(i10));
        }
        aVar.e(this.f1026b.a(i11));
        if (aVar.a().isEmpty() && (strArr = this.f1027c) != null && i11 < strArr.length) {
            aVar.e(strArr[i11]);
        }
        int i12 = this.f1028d.getInt();
        if (i12 > 0) {
            aVar.g(this.f1026b.a(i12));
        }
        aVar.h(fb.e.d(this.f1028d, this.f1026b));
        return aVar;
    }

    private cb.a d() {
        if (!this.f1028d.hasRemaining()) {
            return null;
        }
        long jPosition = this.f1028d.position();
        int iG = fb.a.g(this.f1028d);
        int iG2 = fb.a.g(this.f1028d);
        long jF = fb.a.f(this.f1028d);
        if (iG == 0) {
            return new eb.c(iG, iG2, jF);
        }
        if (iG == 1) {
            cb.d dVar = new cb.d(iG2, jF);
            dVar.i(fb.a.f(this.f1028d));
            dVar.k(fb.a.f(this.f1028d));
            dVar.h(fb.a.f(this.f1028d));
            dVar.j(fb.a.f(this.f1028d));
            dVar.l(fb.a.f(this.f1028d));
            fb.a.b(this.f1028d, jPosition + ((long) iG2));
            return dVar;
        }
        if (iG == 3) {
            return new eb.e(iG, iG2, jF);
        }
        if (iG == 384) {
            fb.a.b(this.f1028d, jPosition + ((long) iG2));
            return new k(iG, iG2, jF);
        }
        switch (iG) {
            case 256:
            case 257:
            case 258:
            case 259:
            case 260:
                eb.i iVar = new eb.i(iG, iG2, jF);
                iVar.e((int) fb.a.f(this.f1028d));
                iVar.d((int) fb.a.f(this.f1028d));
                fb.a.b(this.f1028d, jPosition + ((long) iG2));
                return iVar;
            default:
                throw new ab.a("Unexpected chunk type:" + iG);
        }
    }

    private eb.d e() {
        eb.d dVar = new eb.d();
        int i10 = this.f1028d.getInt();
        if (i10 > 0) {
            dVar.a(this.f1026b.a(i10));
        }
        dVar.b(fb.e.d(this.f1028d, this.f1026b));
        return dVar;
    }

    private eb.f f() {
        int i10 = this.f1028d.getInt();
        int i11 = this.f1028d.getInt();
        eb.f fVar = new eb.f();
        if (i10 > 0) {
            fVar.c(this.f1026b.a(i10));
        }
        if (i11 > 0) {
            fVar.d(this.f1026b.a(i11));
        }
        return fVar;
    }

    private eb.g g() {
        int i10 = this.f1028d.getInt();
        int i11 = this.f1028d.getInt();
        eb.g gVar = new eb.g();
        if (i10 > 0) {
            gVar.c(this.f1026b.a(i10));
        }
        if (i11 > 0) {
            gVar.d(this.f1026b.a(i11));
        }
        return gVar;
    }

    private eb.h h() {
        eb.h hVar = new eb.h();
        int i10 = this.f1028d.getInt();
        int i11 = this.f1028d.getInt();
        if (i10 > 0) {
            hVar.d(this.f1026b.a(i10));
        }
        hVar.c(this.f1026b.a(i11));
        h hVar2 = this.f1029e;
        if (hVar2 != null) {
            hVar2.d(hVar);
        }
        return hVar;
    }

    private j i() {
        int i10 = this.f1028d.getInt();
        int i11 = this.f1028d.getInt();
        j jVar = new j();
        if (i10 > 0) {
            jVar.f(this.f1026b.a(i10));
        }
        jVar.e(this.f1026b.a(i11));
        fb.a.g(this.f1028d);
        fb.a.g(this.f1028d);
        int iG = fb.a.g(this.f1028d);
        fb.a.g(this.f1028d);
        fb.a.g(this.f1028d);
        fb.a.g(this.f1028d);
        eb.b bVar = new eb.b(iG);
        for (int i12 = 0; i12 < iG; i12++) {
            eb.a aVarC = c();
            if (this.f1029e != null) {
                String strJ = aVarC.j(this.f1030f, this.f1031g);
                if (f1024h.contains(aVarC.a()) && fb.g.b(strJ)) {
                    try {
                        strJ = a(aVarC.a(), strJ);
                    } catch (Exception unused) {
                    }
                }
                aVarC.i(strJ);
                bVar.f(i12, aVarC);
            }
        }
        jVar.d(bVar);
        h hVar = this.f1029e;
        if (hVar != null) {
            hVar.b(jVar);
        }
        return jVar;
    }

    public void k(Locale locale) {
        if (locale != null) {
            this.f1031g = locale;
        }
    }

    public void l(h hVar) {
        this.f1029e = hVar;
    }

    public c(ByteBuffer byteBuffer, db.i iVar) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        this.f1028d = byteBufferDuplicate;
        byteBufferDuplicate.order(this.f1025a);
        this.f1030f = iVar;
    }

    private String a(String str, String str2) {
        int i10 = Integer.parseInt(str2);
        str.getClass();
        switch (str) {
            case "windowSoftInputMode":
                return b.f(i10);
            case "installLocation":
                return b.b(i10);
            case "configChanges":
                return b.a(i10);
            case "screenOrientation":
                return b.e(i10);
            case "launchMode":
                return b.c(i10);
            case "protectionLevel":
                return b.d(i10);
            default:
                return str2;
        }
    }

    private long[] j(k kVar) {
        int iA = kVar.a() / 4;
        long[] jArr = new long[iA];
        for (int i10 = 0; i10 < iA; i10++) {
            jArr[i10] = fb.a.f(this.f1028d);
        }
        return jArr;
    }

    public void b() {
        cb.a aVarD = d();
        if (aVarD != null) {
            aVarD.b();
            cb.a aVarD2 = d();
            if (aVarD2 != null) {
                fb.e.a(1, aVarD2.b());
                this.f1026b = fb.e.f(this.f1028d, (cb.d) aVarD2);
                cb.a aVarD3 = d();
                if (aVarD3 != null) {
                    if (aVarD3.b() == 384) {
                        long[] jArrJ = j((k) aVarD3);
                        this.f1027c = new String[jArrJ.length];
                        for (int i10 = 0; i10 < jArrJ.length; i10++) {
                            this.f1027c[i10] = eb.a.C0177a.a(jArrJ[i10]);
                        }
                        aVarD3 = d();
                    }
                    while (aVarD3 != null) {
                        long jPosition = this.f1028d.position();
                        switch (aVarD3.b()) {
                            case 256:
                                this.f1029e.c(g());
                                break;
                            case 257:
                                this.f1029e.a(f());
                                break;
                            case 258:
                                i();
                                break;
                            case 259:
                                h();
                                break;
                            case 260:
                                e();
                                break;
                            default:
                                if (aVarD3.b() >= 256 && aVarD3.b() <= 383) {
                                    fb.a.i(this.f1028d, aVarD3.a());
                                } else {
                                    throw new ab.a("Unexpected chunk type:" + aVarD3.b());
                                }
                                break;
                        }
                        fb.a.b(this.f1028d, jPosition + ((long) aVarD3.a()));
                        aVarD3 = d();
                    }
                }
            }
        }
    }
}
