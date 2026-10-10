package x6;

import androidx.core.view.PointerIconCompat;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import t6.i;
import y6.j;
import y6.o;
import y6.v;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final q6.b f21859q = q6.c.d(c.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e7.a f21860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h7.a f21861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g7.c f21862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c7.c f21863d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private y6.a f21864e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private x6.d f21867h;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f21865f = 16;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f21866g = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f21868i = System.currentTimeMillis();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.google.gson.e f21869j = new com.google.gson.e();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CountDownLatch f21870k = new CountDownLatch(2);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private h7.d f21871l = new a();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private g7.b f21872m = new b();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private c7.d f21873n = new C0471c();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private f7.b f21874o = new d();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private y6.c f21875p = new e();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements h7.d {
        a() {
        }

        @Override // h7.d
        public void a(int i10, String str) {
            c.this.f21867h.a(i10, str);
        }

        @Override // h7.d
        public void b(String str, int i10, String str2) {
            c.this.f21867h.h(str, i10, str2);
        }

        @Override // h7.d
        public void d(int i10, List<i> list) {
            c.k(c.this);
        }

        @Override // h7.d
        public void e(int i10, String str, i iVar) {
            if (c.this.f21863d != null) {
                c.this.f21863d.j();
            }
            c.this.f21862c.f(i10, str, iVar);
            c.f21859q.a("[{}]Refresh connect to PR[{}][{}]", c.this.f21862c.c().a().f(), str, Long.valueOf(iVar.c()));
        }

        @Override // h7.d
        public void f(String str, int i10, String str2) {
            if (c.this.f21861b != null) {
                c.this.f21861b.l();
            }
            if (c.this.f21862c != null) {
                c.this.f21862c.o();
            }
            c.this.f21867h.f(str, i10, str2);
            c.f21859q.a("TR Logout by server.[{}] ", Long.valueOf(c.this.f21868i));
        }

        @Override // h7.d
        public void g(int i10, String str, String str2, String str3) {
            if (c.this.f21863d == null || c.this.f21863d.g() || c.this.f21863d.f() != i10) {
                if (c.this.f21863d != null) {
                    c.this.f21863d.j();
                }
                c.this.f21863d = new c7.c(c.this.f21860a.h(), c.this.f21873n);
                c.this.f21863d.i(i10, str3);
            }
        }

        @Override // h7.d
        public void h() {
            c.this.f21867h.b();
        }

        @Override // h7.d
        public void i(long j10, long j11, long j12) {
            c.this.f21867h.c(j10, j11, j12);
        }

        @Override // h7.d
        public void c(String str, String str2) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements g7.b {
        b() {
        }

        @Override // g7.b
        public void b(String str, int i10, String str2) {
            c.this.f21867h.e(str, i10, str2);
        }

        @Override // g7.b
        public void d(int i10, long j10) {
            c.this.f21865f = i10;
            c.this.f21864e.l(i10, j10);
        }

        @Override // g7.b
        public void e(int i10, String str, boolean z10) {
            if (z10) {
                return;
            }
            e7.b bVarF = c.this.f21862c.c().f();
            c.this.f21867h.g(str);
            c.this.f21861b.j(bVarF.a());
            c.this.f21862c.f(i10, null, null);
        }

        @Override // g7.b
        public void f(int i10, String str) {
            if (c.this.f21863d == null || c.this.f21863d.g()) {
                c.this.f21861b.j(null);
            }
        }

        @Override // g7.b
        public void g(int i10, String str, int i11, String str2) {
            c.this.y();
            c.this.f21867h.i(str, i11, str2);
        }

        @Override // g7.b
        public void h(int i10, String str, int i11, String str2, int i12, int i13, byte[] bArr) {
            c.this.f21864e.a(i10, i11, str2, i12, i13, bArr, false);
        }

        @Override // g7.b
        public void i(int i10, String str, String str2, int i11, int i12, byte[] bArr) {
            c.this.f21864e.e(i10, str2, i11, i12, bArr);
        }

        @Override // g7.b
        public void j(int i10, String str, int i11, String str2, int i12, int i13, byte[] bArr) {
            c.this.f21864e.c(i10, i11, str2, i12, i13, bArr, false);
        }

        @Override // g7.b
        public void k(String str, String str2) {
            c.this.f21860a.t(str2);
            c.this.f21867h.d(c.this.f21860a.o(), str, str2);
        }

        @Override // g7.b
        public void c(String str, String str2) {
        }
    }

    /* JADX INFO: renamed from: x6.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class C0471c implements c7.d {
        C0471c() {
        }

        @Override // c7.d
        public void a(int i10, String str, byte[] bArr) {
            c.this.f21864e.b(i10, str, bArr);
        }

        @Override // c7.d
        public void b(int i10, int i11, String str, byte[] bArr) {
            c.this.f21864e.d(i10, i11, str, bArr);
        }

        @Override // c7.d
        public void c(int i10, String str, byte[] bArr) {
            c.this.f21864e.f(i10, str, bArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class d implements f7.b {
        d() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class e implements y6.c {
        e() {
        }

        @Override // y6.c
        public void a(int i10, String str, byte[] bArr) {
            c.k(c.this);
        }

        @Override // y6.c
        public void b(String str, List<Integer> list) {
            if (c.this.f21862c == null && c.this.f21863d == null) {
                return;
            }
            if (c.this.f21862c != null && c.this.f21862c.d()) {
                c.this.f21862c.i(v6.b.SUBTITLE, 0, str, list);
            } else {
                if (c.this.f21863d == null || c.this.f21863d.g()) {
                    return;
                }
                c.this.f21863d.c(c.this.f21860a.e(), v6.b.SUBTITLE, str);
            }
        }

        @Override // y6.c
        public void d(int i10, String str, List<Integer> list) {
            if (c.this.f21862c == null && c.this.f21863d == null) {
                return;
            }
            if (c.this.f21862c != null && c.this.f21862c.d()) {
                c.this.f21862c.i(v6.b.BLOCK, i10, str, list);
            } else {
                if (c.this.f21863d == null || c.this.f21863d.g()) {
                    return;
                }
                c.this.f21863d.c(c.this.f21860a.e(), v6.b.BLOCK, str);
            }
        }

        @Override // y6.c
        public void e(List<Integer> list) {
            if (c.this.f21862c == null && c.this.f21863d == null) {
                return;
            }
            if (c.this.f21862c != null && c.this.f21862c.d()) {
                c.this.f21862c.i(v6.b.INDEX, 0, "index.m3u8", list);
            } else {
                if (c.this.f21863d == null || c.this.f21863d.g()) {
                    return;
                }
                c.this.f21863d.c(c.this.f21860a.e(), v6.b.INDEX, "index.m3u8");
            }
        }

        @Override // y6.c
        public void c(y6.b bVar, String str, int i10, int i11, int i12, int i13, long j10) {
            int iB = bVar.b();
            c.this.f21862c.a(iB);
            c.this.f21867h.j(str, i10, i11, i12, i13, j10, iB, c.this.f21864e.i());
        }
    }

    public void x() {
        this.f21866g = true;
        try {
            this.f21870k.await();
        } catch (InterruptedException e10) {
            f21859q.error("stop engine[{}] error.", this.f21860a.h().name(), e10);
        }
        h7.a aVar = this.f21861b;
        if (aVar != null) {
            aVar.l();
        }
        g7.c cVar = this.f21862c;
        if (cVar != null) {
            cVar.o();
        }
        y6.a aVar2 = this.f21864e;
        if (aVar2 != null) {
            aVar2.n();
        }
        c7.c cVar2 = this.f21863d;
        if (cVar2 != null) {
            cVar2.j();
        }
        if (this.f21860a.l() != null) {
            this.f21860a.l().e();
        }
        f21859q.a("Stop engine.[{}]", this.f21860a.h().name());
    }

    public c(String str, String str2, String str3, String str4, String str5, v6.a aVar, v6.c cVar, a7.a aVar2, x6.d dVar) {
        this.f21867h = dVar;
        this.f21860a = new e7.a(str, str2, str3, str4, str5, aVar, cVar, new g());
        new Thread(new Runnable() { // from class: x6.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f21857a.u();
            }
        }, "socket-thread").start();
        new Thread(new Runnable() { // from class: x6.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f21858a.o();
            }
        }, "engine-schedule").start();
        if (cVar.equals(v6.c.VOD)) {
            this.f21864e = new v(aVar2, this.f21875p);
        } else if (cVar.equals(v6.c.LIVE)) {
            this.f21864e = new o(aVar2, this.f21875p);
        } else if (cVar.equals(v6.c.CATCHUP)) {
            this.f21864e = new j(aVar2, this.f21875p);
        }
        f21859q.a("Start engine.[{}][{}]", cVar.name(), Long.valueOf(this.f21868i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        while (!this.f21866g) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                h7.a aVar = this.f21861b;
                if (aVar != null) {
                    aVar.d(jCurrentTimeMillis);
                }
                g7.c cVar = this.f21862c;
                if (cVar != null) {
                    cVar.g(jCurrentTimeMillis);
                }
                Thread.sleep(10L);
            } catch (Exception unused) {
                f21859q.error("engine schedule error.", new Object[0]);
            }
        }
        this.f21870k.countDown();
        f21859q.a("engine schedule exit.", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        while (!this.f21866g) {
            try {
                ec.c<InetSocketAddress, ByteBuffer> cVarB = this.f21860a.l().b(10);
                if (cVarB != null && cVarB.f() != null && cVarB.getValue() != null) {
                    ByteBuffer value = cVarB.getValue();
                    s6.a aVarA = x6.e.a(value);
                    if (aVarA == null) {
                        f21859q.warn("Rev illegal msg from [{}]", cVarB.getKey().toString());
                    } else {
                        int iJ = aVarA.j();
                        if (iJ < 20000) {
                            h7.a aVar = this.f21861b;
                            if (aVar != null) {
                                aVar.c(cVarB.getKey(), aVarA, value);
                            }
                        } else if (iJ < 30000) {
                            g7.c cVar = this.f21862c;
                            if (cVar != null) {
                                cVar.e(cVarB.getKey(), aVarA, value);
                            }
                        } else if (iJ >= 40000) {
                            f21859q.error("Unknown msg.[{}]", this.f21869j.w(aVarA));
                        }
                    }
                }
            } catch (Exception e10) {
                f21859q.error("Socket rev error.", e10);
            }
        }
        this.f21870k.countDown();
        f21859q.a("Socket rev exit.", new Object[0]);
    }

    public InputStream p(String str) throws b7.a {
        if (ac.g.d(str, this.f21860a.f())) {
            return this.f21864e.k();
        }
        throw new b7.a(PointerIconCompat.TYPE_CONTEXT_MENU, "Error media id,not matched.");
    }

    public byte[] q(v6.b bVar, String str, String str2) throws b7.a {
        if (!ac.g.d(str, this.f21860a.f())) {
            throw new b7.a(PointerIconCompat.TYPE_CONTEXT_MENU, "Error media id,not matched.");
        }
        if (bVar.equals(v6.b.INDEX)) {
            return this.f21864e.h(this.f21860a.e());
        }
        if (bVar.equals(v6.b.BLOCK)) {
            return this.f21864e.g(this.f21860a.e(), str2, true);
        }
        if (bVar.equals(v6.b.SUBTITLE)) {
            return this.f21864e.j(this.f21860a.e(), str2);
        }
        throw new b7.a(PointerIconCompat.TYPE_HAND, "Error media type.");
    }

    public boolean r() {
        g7.c cVar = this.f21862c;
        if (cVar == null) {
            return false;
        }
        return cVar.d();
    }

    public void s(String str) {
        this.f21860a.u(str);
        h7.a aVar = this.f21861b;
        if (aVar != null) {
            aVar.k(str);
        }
    }

    public void t() {
        g7.c cVar = this.f21862c;
        if (cVar != null) {
            cVar.n();
        }
    }

    public void v(String str, String str2, int i10, String str3) {
        if (this.f21861b.b()) {
            f21859q.error("start [{}] [{}] PR error.TR stopped.", this.f21860a.h(), str);
            this.f21867h.e(str, 4101, "TR stopped");
            return;
        }
        int iHashCode = Arrays.hashCode(xb.a.c(str));
        this.f21864e.m(str, iHashCode);
        this.f21860a.p(iHashCode);
        this.f21860a.r(i10);
        this.f21860a.q(str);
        e7.a aVar = this.f21860a;
        if (ac.g.f(str3)) {
            str3 = "";
        }
        aVar.t(str3);
        g7.d dVar = new g7.d();
        dVar.g(this.f21860a);
        dVar.i(str2);
        dVar.h(this.f21865f);
        this.f21862c = new g7.c(dVar, this.f21872m);
        this.f21861b.j(null);
        f21859q.a("start [{}] [{}] PR.", this.f21860a.h(), str);
    }

    public void w(List<e7.b> list) {
        h7.b bVar = new h7.b();
        bVar.e(this.f21860a);
        bVar.f(list);
        this.f21861b = new h7.a(bVar, this.f21871l, null, this.f21864e);
        f21859q.a("Start [{}] TR.", this.f21860a.h());
    }

    public void y() {
        g7.c cVar = this.f21862c;
        if (cVar != null) {
            cVar.o();
        }
        String strF = this.f21860a.f();
        this.f21864e.o();
        this.f21860a.p(0);
        this.f21860a.r(0);
        this.f21860a.q(null);
        f21859q.a("stop [{}] [{}] PR.", this.f21860a.h(), strF);
    }

    static /* synthetic */ f7.a k(c cVar) {
        cVar.getClass();
        return null;
    }
}
