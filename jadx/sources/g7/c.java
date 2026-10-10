package g7;

import ac.f;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import t6.h;
import t6.i;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import x6.g;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final q6.b f10516p = q6.c.d(c.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f10517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f10518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f10519c;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a f10525i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f10527k;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f10521e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f10522f = System.currentTimeMillis();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f10523g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f10524h = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private AtomicInteger f10528l = new AtomicInteger(0);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f10529m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f10530n = -1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f10531o = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10520d = f.a(0, 10000);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private e f10526j = new e();

    private s6.a b(int i10) {
        s6.a aVar = new s6.a();
        aVar.v(this.f10517a.d());
        aVar.s(this.f10517a.b());
        aVar.E(System.currentTimeMillis());
        aVar.y(i10);
        aVar.r(this.f10517a.a().j());
        aVar.B(this.f10519c);
        int i11 = this.f10520d;
        this.f10520d = i11 + 1;
        aVar.A(i11);
        aVar.w(this.f10517a.a().e());
        aVar.u(0);
        return aVar;
    }

    private void h(ByteBuffer byteBuffer) {
        g gVarL = this.f10517a.a().l();
        gVarL.d(byteBuffer, this.f10517a.f().b());
        gVarL.d(byteBuffer, this.f10517a.f().b());
    }

    private void j(v6.b bVar, int i10, t6.d dVar) {
        if (this.f10521e) {
            s6.a aVarB = b(IjkMediaPlayer.FFP_PROP_INT64_VIDEO_DECODER);
            aVarB.x(bVar.f());
            aVarB.q(i10);
            ByteBuffer byteBufferB = x6.e.b(aVarB, dVar.b());
            dVar.a(byteBufferB);
            h(byteBufferB);
        }
    }

    public void a(int i10) {
        this.f10526j.a(this.f10527k, i10);
    }

    public d c() {
        return this.f10517a;
    }

    public boolean d() {
        return this.f10521e;
    }

    public void e(InetSocketAddress inetSocketAddress, s6.a aVar, ByteBuffer byteBuffer) {
        if (this.f10529m) {
            return;
        }
        int iJ = aVar.j();
        if (aVar.h() == this.f10517a.a().e() && this.f10517a.f() != null) {
            if (iJ == 20002) {
                if (aVar.l() == this.f10520d) {
                    return;
                }
                this.f10519c = aVar.m();
                this.f10521e = true;
                this.f10524h = 0;
                this.f10523g = System.currentTimeMillis();
                this.f10518b.e(this.f10517a.a().e(), this.f10517a.a().f(), this.f10521e);
                this.f10520d = aVar.l();
                h hVar = new h();
                hVar.b(byteBuffer);
                this.f10518b.k(this.f10517a.a().f(), hVar.a());
                f10516p.a("[PR][{}]Connected [{}].", this.f10517a.a().f(), this.f10517a.f().c());
                return;
            }
            if (iJ == 20006) {
                if (aVar.l() == this.f10520d) {
                    return;
                }
                this.f10520d = aVar.l();
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.f10523g = jCurrentTimeMillis;
                this.f10525i.a(jCurrentTimeMillis - this.f10531o);
                this.f10525i.f10515n.getAndIncrement();
                t6.f fVar = new t6.f();
                fVar.b(byteBuffer);
                this.f10518b.k(this.f10517a.a().f(), fVar.a());
                return;
            }
            if (iJ != 20004) {
                if (iJ == 21004) {
                    if (aVar.l() == this.f10520d) {
                        return;
                    }
                    this.f10520d = aVar.l();
                    t6.a aVar2 = new t6.a();
                    aVar2.d(byteBuffer);
                    f10516p.a("[PR]Received event:[{}][{}].", aVar2.c(), Integer.valueOf(aVar2.b()));
                    this.f10518b.b(aVar2.c(), aVar2.b(), aVar2.a());
                    return;
                }
                if (iJ != 20008 || aVar.l() == this.f10520d) {
                    return;
                }
                this.f10520d = aVar.l();
                t6.a aVar3 = new t6.a();
                aVar3.d(byteBuffer);
                f10516p.a("[PR]Received logout:[{}][{}].", aVar3.c(), Integer.valueOf(aVar3.b()));
                this.f10518b.g(this.f10517a.a().e(), this.f10517a.a().f(), aVar3.b(), aVar3.a());
                return;
            }
            if (aVar.e() <= 0) {
                return;
            }
            String str = new String(aVar.d());
            int i10 = byteBuffer.getInt();
            if (i10 > 1500) {
                f10516p.warn("[PR][{}]Receive Invalid slice dataLength [{}][{}][{}][{}].", this.f10517a.a().f(), Integer.valueOf(aVar.a()), Integer.valueOf(aVar.o()), Integer.valueOf(i10));
                return;
            }
            byte[] bArr = new byte[i10];
            byteBuffer.get(bArr);
            v6.b bVarI = v6.b.i(aVar.i());
            if (bVarI == null) {
                f10516p.warn("[PR][{}]Receive slice mediaType is null [{}][{}][{}].", this.f10517a.a().f(), Integer.valueOf(aVar.a()), Integer.valueOf(aVar.o()));
                return;
            }
            if (bVarI.equals(v6.b.INDEX)) {
                this.f10518b.j(aVar.h(), this.f10517a.a().f(), aVar.a(), str, aVar.o(), aVar.n(), bArr);
                this.f10525i.f10509h.getAndIncrement();
                return;
            }
            if (!bVarI.equals(v6.b.BLOCK)) {
                if (bVarI.equals(v6.b.SUBTITLE)) {
                    this.f10518b.i(aVar.h(), this.f10517a.a().f(), str, aVar.o(), aVar.n(), bArr);
                    this.f10525i.f10511j.getAndIncrement();
                    return;
                }
                return;
            }
            if (aVar.n() > 100000) {
                f10516p.warn("[PR][{}]Receive Invalid slice count [{}][{}][{}][{}].", this.f10517a.a().f(), Integer.valueOf(aVar.a()), Integer.valueOf(aVar.o()), Integer.valueOf(aVar.n()));
            } else {
                this.f10518b.h(aVar.h(), this.f10517a.a().f(), aVar.a(), str, aVar.o(), aVar.n(), bArr);
                this.f10525i.f10511j.getAndIncrement();
            }
        }
    }

    public void f(int i10, String str, i iVar) {
        e7.b bVar;
        if (i10 != this.f10517a.a().e()) {
            return;
        }
        if (iVar != null) {
            bVar = new e7.b();
            bVar.f(str);
            bVar.e(iVar.e());
            bVar.d(Long.valueOf(iVar.c()));
        } else {
            bVar = null;
        }
        this.f10517a.j(bVar);
        this.f10521e = false;
        this.f10524h = 0;
    }

    public void g(long j10) {
        if (this.f10529m) {
            return;
        }
        if (this.f10517a.f() == null) {
            if (j10 - this.f10522f > a7.b.f156j) {
                this.f10518b.f(this.f10517a.a().e(), this.f10517a.a().f());
                this.f10522f = j10;
                return;
            }
            return;
        }
        try {
            this.f10525i.b(this.f10518b, this.f10521e, j10);
            if (this.f10521e) {
                if (j10 - this.f10531o > a7.b.f159m) {
                    k(j10);
                }
                if (j10 - this.f10523g > a7.b.f160n) {
                    this.f10521e = false;
                    l(j10);
                }
            } else if (this.f10524h > a7.b.f158l) {
                this.f10518b.e(this.f10517a.a().e(), this.f10517a.a().f(), this.f10521e);
                return;
            } else if (j10 - this.f10530n > a7.b.f157k) {
                l(j10);
            }
            if (j10 - this.f10526j.c() > a7.b.f161o) {
                int iB = this.f10526j.b(this.f10527k);
                this.f10518b.d(iB, this.f10525i.c());
                this.f10526j.e(j10);
                if (iB == this.f10527k) {
                    return;
                }
                this.f10527k = iB;
                f10516p.a("[PR][{}]Adjust speed to [{}],rtt:[{}]", this.f10517a.a().f(), Integer.valueOf(this.f10527k), Long.valueOf(this.f10525i.c()));
            }
        } catch (Exception e10) {
            f10516p.error("PR Engine error.", e10);
        }
    }

    public void i(v6.b bVar, int i10, String str, List<Integer> list) {
        t6.d dVar = new t6.d();
        dVar.d(str.length());
        dVar.c(str.getBytes(StandardCharsets.UTF_8));
        if (ef.a.a(list)) {
            dVar.e(0);
            j(bVar, i10, dVar);
        } else {
            Iterator<List<Integer>> it = u6.g.c(list).iterator();
            while (it.hasNext()) {
                byte[] bArrB = u6.g.b(it.next());
                dVar.e(bArrB.length);
                dVar.f(bArrB);
                j(bVar, i10, dVar);
            }
        }
        if (bVar.f() == v6.b.INDEX.f()) {
            this.f10525i.f10508g.getAndIncrement();
        } else if (bVar.f() == v6.b.BLOCK.f()) {
            this.f10525i.f10510i.getAndIncrement();
        }
    }

    public void k(long j10) {
        t6.e eVar = new t6.e();
        HashMap map = new HashMap();
        map.put("LO", Integer.toString(this.f10526j.d(this.f10527k)));
        map.put("SP", Integer.toString(this.f10527k));
        map.put("BF", Integer.toString(this.f10528l.getAndSet(0)));
        eVar.c(map);
        ByteBuffer byteBufferB = x6.e.b(b(IjkMediaPlayer.FFP_PROP_INT64_VIDEO_CACHED_DURATION), eVar.b());
        eVar.a(byteBufferB);
        h(byteBufferB);
        this.f10531o = j10;
        this.f10525i.f10514m.getAndIncrement();
    }

    public void l(long j10) {
        HashMap map = new HashMap();
        map.put("UID", this.f10517a.a().o());
        map.put("DID", this.f10517a.a().d());
        map.put("TOKEN", this.f10517a.a().n());
        map.put("VER", this.f10517a.a().b());
        map.put("MID", this.f10517a.a().f());
        map.put("RID", this.f10517a.e());
        map.put("IS", Integer.toString(this.f10527k));
        map.put("MODE", Integer.toString(this.f10517a.a().g()));
        map.put("SIGN", this.f10517a.a().k());
        map.put("TID", this.f10517a.a().m());
        map.put("DT", Integer.toString(this.f10517a.a().c().f()));
        t6.g gVar = new t6.g();
        gVar.c(map);
        ByteBuffer byteBufferB = x6.e.b(b(IjkMediaPlayer.FFP_PROP_INT64_SELECTED_VIDEO_STREAM), gVar.b());
        gVar.a(byteBufferB);
        h(byteBufferB);
        this.f10524h++;
        this.f10530n = j10;
        f10516p.a("[PR][{}]Connecting to [{}]", this.f10517a.a().f(), this.f10517a.f().c());
    }

    public void m() {
        h(x6.e.b(b(IjkMediaPlayer.FFP_PROP_INT64_VIDEO_CACHED_BYTES), 0));
    }

    public void n() {
        this.f10528l.set(1);
    }

    public void o() {
        if (this.f10521e) {
            m();
        }
        this.f10529m = true;
        this.f10521e = false;
    }

    public c(d dVar, b bVar) {
        this.f10517a = dVar;
        this.f10518b = bVar;
        this.f10525i = new a(dVar.a().o(), dVar.a().d(), dVar.a().f());
        this.f10527k = dVar.c();
    }
}
