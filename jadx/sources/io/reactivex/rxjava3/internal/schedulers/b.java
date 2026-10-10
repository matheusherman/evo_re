package io.reactivex.rxjava3.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class b extends g8.h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final C0194b f11414e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final g f11415f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final int f11416g = g(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx3.computation-threads", 0).intValue());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final c f11417h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ThreadFactory f11418c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final AtomicReference<C0194b> f11419d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends g8.h.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final k8.c f11420a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final h8.a f11421b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final k8.c f11422c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final c f11423d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        volatile boolean f11424e;

        @Override // g8.h.c
        public h8.c b(Runnable runnable) {
            return this.f11424e ? k8.b.INSTANCE : this.f11423d.e(runnable, 0L, TimeUnit.MILLISECONDS, this.f11420a);
        }

        @Override // g8.h.c
        public h8.c c(Runnable runnable, long j10, TimeUnit timeUnit) {
            return this.f11424e ? k8.b.INSTANCE : this.f11423d.e(runnable, j10, timeUnit, this.f11421b);
        }

        @Override // h8.c
        public void dispose() {
            if (this.f11424e) {
                return;
            }
            this.f11424e = true;
            this.f11422c.dispose();
        }

        @Override // h8.c
        public boolean f() {
            return this.f11424e;
        }

        a(c cVar) {
            this.f11423d = cVar;
            k8.c cVar2 = new k8.c();
            this.f11420a = cVar2;
            h8.a aVar = new h8.a();
            this.f11421b = aVar;
            k8.c cVar3 = new k8.c();
            this.f11422c = cVar3;
            cVar3.b(cVar2);
            cVar3.b(aVar);
        }
    }

    /* JADX INFO: renamed from: io.reactivex.rxjava3.internal.schedulers.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class C0194b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f11425a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final c[] f11426b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f11427c;

        public c a() {
            int i10 = this.f11425a;
            if (i10 == 0) {
                return b.f11417h;
            }
            c[] cVarArr = this.f11426b;
            long j10 = this.f11427c;
            this.f11427c = 1 + j10;
            return cVarArr[(int) (j10 % ((long) i10))];
        }

        public void b() {
            for (c cVar : this.f11426b) {
                cVar.dispose();
            }
        }

        C0194b(int i10, ThreadFactory threadFactory) {
            this.f11425a = i10;
            this.f11426b = new c[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                this.f11426b[i11] = new c(threadFactory);
            }
        }
    }

    public b() {
        this(f11415f);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends f {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    public b(ThreadFactory threadFactory) {
        this.f11418c = threadFactory;
        this.f11419d = new AtomicReference<>(f11414e);
        h();
    }

    static int g(int i10, int i11) {
        return (i11 <= 0 || i11 > i10) ? i10 : i11;
    }

    @Override // g8.h
    public g8.h.c c() {
        return new a(this.f11419d.get().a());
    }

    @Override // g8.h
    public h8.c e(Runnable runnable, long j10, TimeUnit timeUnit) {
        return this.f11419d.get().a().g(runnable, j10, timeUnit);
    }

    @Override // g8.h
    public h8.c f(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        return this.f11419d.get().a().h(runnable, j10, j11, timeUnit);
    }

    public void h() {
        C0194b c0194b = new C0194b(f11416g, this.f11418c);
        if (androidx.p000lifecycle.h.a(this.f11419d, f11414e, c0194b)) {
            return;
        }
        c0194b.b();
    }

    static {
        c cVar = new c(new g("RxComputationShutdown"));
        f11417h = cVar;
        cVar.dispose();
        g gVar = new g("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx3.computation-priority", 5).intValue())), true);
        f11415f = gVar;
        C0194b c0194b = new C0194b(0, gVar);
        f11414e = c0194b;
        c0194b.b();
    }
}
