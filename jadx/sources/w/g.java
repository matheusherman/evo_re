package w;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.k;
import com.bumptech.glide.l;
import j.m;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h.a f20020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f20021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<b> f20022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final l f20023d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final m.d f20024e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f20025f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f20026g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f20027h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private k<Bitmap> f20028i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private a f20029j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f20030k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private a f20031l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Bitmap f20032m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private m<Bitmap> f20033n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private a f20034o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f20035p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f20036q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f20037r;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @VisibleForTesting
    static class a extends b0.c<Bitmap> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Handler f20038d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final int f20039e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final long f20040f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Bitmap f20041g;

        @Override // b0.i
        public void n(@Nullable Drawable drawable) {
            this.f20041g = null;
        }

        Bitmap c() {
            return this.f20041g;
        }

        @Override // b0.i
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(@NonNull Bitmap bitmap, @Nullable c0.b<? super Bitmap> bVar) {
            this.f20041g = bitmap;
            this.f20038d.sendMessageAtTime(this.f20038d.obtainMessage(1, this), this.f20040f);
        }

        a(Handler handler, int i10, long j10) {
            this.f20038d = handler;
            this.f20039e = i10;
            this.f20040f = j10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface b {
        void a();
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class c implements Handler.Callback {
        c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                g.this.m((a) message.obj);
                return true;
            }
            if (i10 != 2) {
                return false;
            }
            g.this.f20023d.o((a) message.obj);
            return false;
        }
    }

    g(com.bumptech.glide.c cVar, h.a aVar, int i10, int i11, m<Bitmap> mVar, Bitmap bitmap) {
        this(cVar.f(), com.bumptech.glide.c.t(cVar.h()), aVar, null, i(com.bumptech.glide.c.t(cVar.h()), i10, i11), mVar, bitmap);
    }

    private void q() {
        this.f20025f = false;
    }

    @VisibleForTesting
    void m(a aVar) {
        this.f20026g = false;
        if (this.f20030k) {
            this.f20021b.obtainMessage(2, aVar).sendToTarget();
            return;
        }
        if (!this.f20025f) {
            if (this.f20027h) {
                this.f20021b.obtainMessage(2, aVar).sendToTarget();
                return;
            } else {
                this.f20034o = aVar;
                return;
            }
        }
        if (aVar.c() != null) {
            n();
            a aVar2 = this.f20029j;
            this.f20029j = aVar;
            for (int size = this.f20022c.size() - 1; size >= 0; size--) {
                this.f20022c.get(size).a();
            }
            if (aVar2 != null) {
                this.f20021b.obtainMessage(2, aVar2).sendToTarget();
            }
        }
        l();
    }

    private static j.f g() {
        return new d0.d(Double.valueOf(Math.random()));
    }

    private void l() {
        if (!this.f20025f || this.f20026g) {
            return;
        }
        if (this.f20027h) {
            e0.k.a(this.f20034o == null, "Pending target must be null when starting from the first frame");
            this.f20020a.f();
            this.f20027h = false;
        }
        a aVar = this.f20034o;
        if (aVar != null) {
            this.f20034o = null;
            m(aVar);
            return;
        }
        this.f20026g = true;
        long jUptimeMillis = SystemClock.uptimeMillis() + ((long) this.f20020a.d());
        this.f20020a.b();
        this.f20031l = new a(this.f20021b, this.f20020a.g(), jUptimeMillis);
        this.f20028i.a(a0.i.u0(g())).I0(this.f20020a).B0(this.f20031l);
    }

    private void n() {
        Bitmap bitmap = this.f20032m;
        if (bitmap != null) {
            this.f20024e.c(bitmap);
            this.f20032m = null;
        }
    }

    private void p() {
        if (this.f20025f) {
            return;
        }
        this.f20025f = true;
        this.f20030k = false;
        l();
    }

    void a() {
        this.f20022c.clear();
        n();
        q();
        a aVar = this.f20029j;
        if (aVar != null) {
            this.f20023d.o(aVar);
            this.f20029j = null;
        }
        a aVar2 = this.f20031l;
        if (aVar2 != null) {
            this.f20023d.o(aVar2);
            this.f20031l = null;
        }
        a aVar3 = this.f20034o;
        if (aVar3 != null) {
            this.f20023d.o(aVar3);
            this.f20034o = null;
        }
        this.f20020a.clear();
        this.f20030k = true;
    }

    ByteBuffer b() {
        return this.f20020a.getData().asReadOnlyBuffer();
    }

    Bitmap c() {
        a aVar = this.f20029j;
        return aVar != null ? aVar.c() : this.f20032m;
    }

    int d() {
        a aVar = this.f20029j;
        if (aVar != null) {
            return aVar.f20039e;
        }
        return -1;
    }

    Bitmap e() {
        return this.f20032m;
    }

    int f() {
        return this.f20020a.c();
    }

    int h() {
        return this.f20037r;
    }

    int j() {
        return this.f20020a.h() + this.f20035p;
    }

    int k() {
        return this.f20036q;
    }

    void r(b bVar) {
        if (this.f20030k) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (this.f20022c.contains(bVar)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean zIsEmpty = this.f20022c.isEmpty();
        this.f20022c.add(bVar);
        if (zIsEmpty) {
            p();
        }
    }

    void s(b bVar) {
        this.f20022c.remove(bVar);
        if (this.f20022c.isEmpty()) {
            q();
        }
    }

    private static k<Bitmap> i(l lVar, int i10, int i11) {
        return lVar.e().a(a0.i.t0(l.j.f15049b).r0(true).k0(true).a0(i10, i11));
    }

    void o(m<Bitmap> mVar, Bitmap bitmap) {
        this.f20033n = (m) e0.k.d(mVar);
        this.f20032m = (Bitmap) e0.k.d(bitmap);
        this.f20028i = this.f20028i.a(new a0.i().m0(mVar));
        this.f20035p = e0.l.h(bitmap);
        this.f20036q = bitmap.getWidth();
        this.f20037r = bitmap.getHeight();
    }

    g(m.d dVar, l lVar, h.a aVar, Handler handler, k<Bitmap> kVar, m<Bitmap> mVar, Bitmap bitmap) {
        this.f20022c = new ArrayList();
        this.f20023d = lVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f20024e = dVar;
        this.f20021b = handler;
        this.f20028i = kVar;
        this.f20020a = aVar;
        o(mVar, bitmap);
    }
}
