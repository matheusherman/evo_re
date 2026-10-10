package h7;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.HashMap;
import t6.i;
import t6.j;
import t6.k;
import t6.l;
import t6.m;
import t6.n;
import t6.o;
import t6.p;
import t6.q;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import x6.e;
import x6.g;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final q6.b f10854p = q6.c.d(a.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f10855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d f10856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private y6.a f10857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f10858d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private e7.b f10859e;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private c f10868n;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f10860f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f10861g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f10862h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f10863i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f10864j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f10865k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f10866l = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f10867m = "";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f10869o = false;

    private s6.a a(int i10) {
        s6.a aVar = new s6.a();
        aVar.v(this.f10855a.c());
        aVar.s(this.f10855a.b());
        aVar.E(System.currentTimeMillis());
        aVar.y(i10);
        aVar.r(this.f10858d);
        aVar.B(this.f10855a.a().i());
        int i11 = this.f10860f + 1;
        this.f10860f = i11;
        aVar.A(i11);
        aVar.u(0);
        return aVar;
    }

    private void e(ByteBuffer byteBuffer) {
        g gVarL = this.f10855a.a().l();
        gVarL.d(byteBuffer, this.f10859e.b());
        gVarL.d(byteBuffer, this.f10859e.b());
    }

    private void f(long j10) {
        j jVar = new j();
        jVar.e(this.f10855a.a().h().f());
        jVar.d(this.f10855a.a().f());
        jVar.f(this.f10867m);
        jVar.c(0);
        s6.a aVarA = a(IMediaPlayer.MEDIA_INFO_OPEN_INPUT);
        aVarA.w(this.f10855a.a().e());
        ByteBuffer byteBufferB = e.b(aVarA, jVar.b());
        jVar.a(byteBufferB);
        e(byteBufferB);
        this.f10868n.f10884j.getAndIncrement();
        this.f10864j = j10;
    }

    private void h(long j10) {
        HashMap map = new HashMap();
        map.put("UID", this.f10855a.a().o());
        map.put("DID", this.f10855a.a().d());
        map.put("TOKEN", this.f10855a.a().n());
        map.put("VER", this.f10855a.a().b());
        map.put("PT", this.f10855a.a().h().name());
        map.put("EVER", a7.b.f147a);
        map.put("TID", this.f10855a.a().m());
        map.put("DT", Integer.toString(this.f10855a.a().c().f()));
        l lVar = new l();
        lVar.c(map);
        ByteBuffer byteBufferB = e.b(a(10001), lVar.b());
        lVar.a(byteBufferB);
        e(byteBufferB);
        this.f10863i++;
        this.f10864j = j10;
        f10854p.a("[TR]Connecting to [{}]", this.f10859e.c());
    }

    private void i() {
        e(e.b(a(IMediaPlayer.MEDIA_INFO_AUDIO_SEEK_RENDERING_START), 0));
    }

    public boolean b() {
        return this.f10869o;
    }

    public void c(InetSocketAddress inetSocketAddress, s6.a aVar, ByteBuffer byteBuffer) {
        if (this.f10869o) {
            return;
        }
        int iJ = aVar.j();
        if (this.f10866l == aVar.l()) {
            return;
        }
        this.f10866l = aVar.l();
        if (iJ == 10002) {
            this.f10862h = true;
            this.f10855a.a().s(aVar.m());
            this.f10863i = 0;
            this.f10865k = System.currentTimeMillis();
            this.f10860f = aVar.l();
            f10854p.a("[TR]Connected [{}][{}]", this.f10859e.c(), Integer.valueOf(this.f10860f));
            return;
        }
        if (iJ == 10014) {
            if (aVar.h() != this.f10855a.a().e()) {
                return;
            }
            q qVar = new q();
            qVar.f(byteBuffer);
            if (qVar.e() > 0) {
                this.f10868n.f10882h.getAndIncrement();
                this.f10867m = qVar.d();
                this.f10856b.e(aVar.h(), qVar.d(), qVar.c());
            }
            if (qVar.b() > 0) {
                this.f10868n.f10882h.getAndIncrement();
                this.f10867m = qVar.d();
                this.f10856b.g(aVar.h(), this.f10855a.a().f(), qVar.d(), qVar.a());
                return;
            }
            return;
        }
        if (iJ == 10024) {
            if (aVar.h() != this.f10855a.a().e()) {
                return;
            }
            n nVar = new n();
            nVar.c(byteBuffer);
            if (nVar.b() > 0) {
                this.f10868n.f10883i.getAndIncrement();
                this.f10856b.d(aVar.h(), nVar.a());
                return;
            }
            return;
        }
        if (iJ == 10006) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f10865k = jCurrentTimeMillis;
            this.f10868n.a(jCurrentTimeMillis - this.f10864j);
            this.f10856b.i(this.f10864j, aVar.p(), jCurrentTimeMillis);
            this.f10868n.f10885k.getAndIncrement();
            return;
        }
        if (iJ == 10008) {
            k kVar = new k();
            kVar.d(byteBuffer);
            g(kVar.c());
            this.f10868n.f10887m.getAndIncrement();
            return;
        }
        if (iJ == 10007) {
            return;
        }
        if (iJ == 10010) {
            t6.a aVar2 = new t6.a();
            aVar2.d(byteBuffer);
            f10854p.a("[TR]Received logout:[{}][{}].", aVar2.c(), Integer.valueOf(aVar2.b()));
            this.f10856b.f(aVar2.c(), aVar2.b(), aVar2.a());
            return;
        }
        if (iJ == 11002) {
            m mVar = new m();
            mVar.c(byteBuffer);
            this.f10856b.a(mVar.b(), mVar.a());
        } else if (iJ == 11004) {
            t6.a aVar3 = new t6.a();
            aVar3.d(byteBuffer);
            f10854p.a("[TR]Received event:[{}][{}].", aVar3.c(), Integer.valueOf(aVar3.b()));
            this.f10856b.b(aVar3.c(), aVar3.b(), aVar3.a());
        }
    }

    public void d(long j10) {
        if (this.f10869o) {
            return;
        }
        try {
            this.f10868n.b(this.f10855a.a().f(), this.f10862h, j10, this.f10856b);
            if (this.f10862h) {
                if (j10 - this.f10864j > a7.b.f154h) {
                    f(j10);
                }
                if (j10 - this.f10865k > a7.b.f155i) {
                    this.f10862h = false;
                    return;
                }
                return;
            }
            if (this.f10863i > a7.b.f153g) {
                int i10 = this.f10861g + 1;
                this.f10861g = i10;
                if (i10 >= this.f10855a.d().size()) {
                    this.f10861g = 0;
                }
                this.f10856b.h();
                e7.b bVar = this.f10855a.d().get(this.f10861g);
                this.f10859e = bVar;
                this.f10863i = 0;
                f10854p.warn("[TR]Switch to [{}]", bVar.c());
            }
            if (j10 - this.f10864j > a7.b.f152f) {
                h(j10);
                this.f10863i++;
                this.f10864j = System.currentTimeMillis();
            }
        } catch (Exception e10) {
            f10854p.error("[TR]schedule error.", e10);
        }
    }

    public void g(i iVar) {
        k kVar = new k();
        kVar.e(iVar);
        s6.a aVarA = a(10007);
        aVarA.w(this.f10855a.a().e());
        ByteBuffer byteBufferB = e.b(aVarA, kVar.b());
        kVar.a(byteBufferB);
        g gVarL = this.f10855a.a().l();
        gVarL.d(byteBufferB, iVar.e());
        gVarL.d(byteBufferB, iVar.e());
        f10854p.a("[TR]Request for exchange  msg to  peer [{}] directly", iVar.e());
    }

    public void j(Long l10) {
        if (this.f10862h) {
            p pVar = new p();
            pVar.g(this.f10855a.a().h().f());
            pVar.d(this.f10855a.a().f());
            pVar.e(this.f10855a.a().g());
            if (l10 != null) {
                pVar.c(l10);
            }
            pVar.f(this.f10855a.a().k());
            s6.a aVarA = a(10013);
            aVarA.w(this.f10855a.a().e());
            ByteBuffer byteBufferB = e.b(aVarA, pVar.b());
            pVar.a(byteBufferB);
            e(byteBufferB);
            this.f10868n.f10880f.getAndIncrement();
        }
    }

    public void k(String str) {
        HashMap map = new HashMap();
        map.put("TKN", str);
        o oVar = new o();
        oVar.c(map);
        ByteBuffer byteBufferB = e.b(a(IMediaPlayer.MEDIA_INFO_READ_FIRST_AUDIO_FRAME), oVar.b());
        oVar.a(byteBufferB);
        e(byteBufferB);
        f10854p.a("[TR]send refresh request [{}]", map);
    }

    public void l() {
        if (this.f10862h) {
            i();
        }
        this.f10869o = true;
        this.f10862h = false;
    }

    public a(b bVar, d dVar, f7.a aVar, y6.a aVar2) {
        this.f10855a = bVar;
        this.f10856b = dVar;
        this.f10857c = aVar2;
        this.f10858d = bVar.a().j();
        this.f10859e = bVar.d().get(this.f10861g);
        this.f10868n = new c(bVar.a().o(), bVar.a().d());
        h(System.currentTimeMillis());
    }
}
