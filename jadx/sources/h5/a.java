package h5;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.live.evo.util.x1;
import i5.u;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.d0;
import okhttp3.e;
import okhttp3.j;
import okhttp3.r;
import okhttp3.t;
import okhttp3.v;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a extends r {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final r.c f10843f = new C0187a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final u f10844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f10845d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f10846e;

    /* JADX INFO: renamed from: h5.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class C0187a implements r.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicLong f10847a = new AtomicLong(1);

        @Override // okhttp3.r.c
        public r a(e eVar) {
            return new a(this.f10847a.getAndIncrement(), eVar.getOriginalRequest().getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String(), System.nanoTime());
        }

        C0187a() {
        }
    }

    public a(long j10, v vVar, long j11) {
        u uVar = new u();
        this.f10844c = uVar;
        this.f10845d = 0L;
        uVar.f(j10);
        uVar.B(vVar.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String());
    }

    @Override // okhttp3.r
    public void A(e eVar, @Nullable t tVar) {
        super.A(eVar, tVar);
        this.f10844c.y(SystemClock.elapsedRealtime());
    }

    @Override // okhttp3.r
    public void B(e eVar) {
        super.B(eVar);
        this.f10844c.z(SystemClock.elapsedRealtime());
    }

    /* JADX WARN: Code duplicated, block: B:8:0x002e  */
    @Override // okhttp3.r
    public void c(e eVar) {
        long j10;
        super.c(eVar);
        this.f10844c.d(SystemClock.elapsedRealtime());
        long jA = this.f10844c.a() - this.f10844c.c();
        u uVar = this.f10844c;
        long j11 = 0;
        if (jA > 0) {
            long j12 = this.f10845d;
            if (j12 > 0) {
                j10 = (j12 * 1000) / jA;
            } else {
                j10 = 0;
            }
        } else {
            j10 = 0;
        }
        uVar.x(j10);
        u uVar2 = this.f10844c;
        if (jA > 0) {
            long j13 = this.f10846e;
            if (j13 > 0) {
                j11 = (j13 * 1000) / jA;
            }
        }
        uVar2.A(j11);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x002e  */
    @Override // okhttp3.r
    public void d(e eVar, IOException iOException) {
        long j10;
        String string;
        super.d(eVar, iOException);
        this.f10844c.e(SystemClock.elapsedRealtime());
        long jB = this.f10844c.b() - this.f10844c.c();
        u uVar = this.f10844c;
        long j11 = 0;
        if (jB > 0) {
            long j12 = this.f10845d;
            if (j12 > 0) {
                j10 = (j12 * 1000) / jB;
            } else {
                j10 = 0;
            }
        } else {
            j10 = 0;
        }
        uVar.x(j10);
        u uVar2 = this.f10844c;
        if (jB > 0) {
            long j13 = this.f10846e;
            if (j13 > 0) {
                j11 = (j13 * 1000) / jB;
            }
        }
        uVar2.A(j11);
        u uVar3 = this.f10844c;
        if (iOException == null) {
            string = "unknown";
        } else {
            string = iOException.toString();
        }
        uVar3.o(string);
    }

    @Override // okhttp3.r
    public void e(e eVar) {
        super.e(eVar);
        this.f10844c.g(SystemClock.elapsedRealtime());
        this.f10845d = x1.i();
    }

    @Override // okhttp3.r
    public void g(e eVar, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable a0 a0Var) {
        super.g(eVar, inetSocketAddress, proxy, a0Var);
        this.f10844c.h(SystemClock.elapsedRealtime());
    }

    @Override // okhttp3.r
    public void h(e eVar, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable a0 a0Var, IOException iOException) {
        super.h(eVar, inetSocketAddress, proxy, a0Var, iOException);
        this.f10844c.i(SystemClock.elapsedRealtime());
    }

    @Override // okhttp3.r
    public void i(e eVar, InetSocketAddress inetSocketAddress, Proxy proxy) {
        super.i(eVar, inetSocketAddress, proxy);
        this.f10844c.j(SystemClock.elapsedRealtime());
    }

    @Override // okhttp3.r
    public void j(e eVar, j jVar) {
        super.j(eVar, jVar);
        this.f10844c.k(SystemClock.elapsedRealtime());
    }

    @Override // okhttp3.r
    public void k(e eVar, j jVar) {
        super.k(eVar, jVar);
        this.f10844c.l(SystemClock.elapsedRealtime());
    }

    @Override // okhttp3.r
    public void l(e eVar, String str, List<InetAddress> list) {
        super.l(eVar, str, list);
        this.f10844c.m(SystemClock.elapsedRealtime());
    }

    @Override // okhttp3.r
    public void m(e eVar, String str) {
        super.m(eVar, str);
        this.f10844c.n(SystemClock.elapsedRealtime());
    }

    @Override // okhttp3.r
    public void p(e eVar, long j10) {
        super.p(eVar, j10);
        this.f10846e = j10;
        this.f10844c.p(SystemClock.elapsedRealtime());
    }

    @Override // okhttp3.r
    public void q(e eVar) {
        super.q(eVar);
        this.f10844c.q(SystemClock.elapsedRealtime());
    }

    @Override // okhttp3.r
    public void s(e eVar, b0 b0Var) {
        super.s(eVar, b0Var);
        this.f10844c.r(SystemClock.elapsedRealtime());
    }

    @Override // okhttp3.r
    public void t(e eVar) {
        super.t(eVar);
        this.f10844c.s(SystemClock.elapsedRealtime());
    }

    @Override // okhttp3.r
    public void u(e eVar, long j10) {
        super.u(eVar, j10);
        this.f10845d = j10;
        this.f10844c.t(SystemClock.elapsedRealtime());
    }

    @Override // okhttp3.r
    public void v(e eVar) {
        super.v(eVar);
        this.f10844c.u(SystemClock.elapsedRealtime());
    }

    @Override // okhttp3.r
    public void x(e eVar, d0 d0Var) {
        super.x(eVar, d0Var);
        this.f10844c.v(SystemClock.elapsedRealtime());
    }

    @Override // okhttp3.r
    public void y(e eVar) {
        super.y(eVar);
        this.f10844c.w(SystemClock.elapsedRealtime());
    }
}
