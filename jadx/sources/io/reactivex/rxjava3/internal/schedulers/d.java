package io.reactivex.rxjava3.internal.schedulers;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d extends g8.h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final g f11434e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final g f11435f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final c f11438i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static boolean f11439j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final a f11440k;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ThreadFactory f11441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final AtomicReference<a> f11442d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final TimeUnit f11437h = TimeUnit.SECONDS;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final long f11436g = Long.getLong("rx3.io-keep-alive-time", 60).longValue();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f11443a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ConcurrentLinkedQueue<c> f11444b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final h8.a f11445c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ScheduledExecutorService f11446d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Future<?> f11447e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ThreadFactory f11448f;

        c b() {
            if (this.f11445c.f()) {
                return d.f11438i;
            }
            while (!this.f11444b.isEmpty()) {
                c cVarPoll = this.f11444b.poll();
                if (cVarPoll != null) {
                    return cVarPoll;
                }
            }
            c cVar = new c(this.f11448f);
            this.f11445c.b(cVar);
            return cVar;
        }

        void e() {
            this.f11445c.dispose();
            Future<?> future = this.f11447e;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f11446d;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a(this.f11444b, this.f11445c);
        }

        a(long j10, TimeUnit timeUnit, ThreadFactory threadFactory) {
            long nanos;
            a aVar;
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool;
            ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay;
            if (timeUnit != null) {
                nanos = timeUnit.toNanos(j10);
            } else {
                nanos = 0;
            }
            long j11 = nanos;
            this.f11443a = j11;
            this.f11444b = new ConcurrentLinkedQueue<>();
            this.f11445c = new h8.a();
            this.f11448f = threadFactory;
            if (timeUnit != null) {
                scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, d.f11435f);
                aVar = this;
                scheduledFutureScheduleWithFixedDelay = scheduledExecutorServiceNewScheduledThreadPool.scheduleWithFixedDelay(aVar, j11, j11, TimeUnit.NANOSECONDS);
            } else {
                aVar = this;
                scheduledExecutorServiceNewScheduledThreadPool = null;
                scheduledFutureScheduleWithFixedDelay = null;
            }
            aVar.f11446d = scheduledExecutorServiceNewScheduledThreadPool;
            aVar.f11447e = scheduledFutureScheduleWithFixedDelay;
        }

        static void a(ConcurrentLinkedQueue<c> concurrentLinkedQueue, h8.a aVar) {
            if (!concurrentLinkedQueue.isEmpty()) {
                long jC = c();
                for (c cVar : concurrentLinkedQueue) {
                    if (cVar.k() <= jC) {
                        if (concurrentLinkedQueue.remove(cVar)) {
                            aVar.a(cVar);
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        static long c() {
            return System.nanoTime();
        }

        void d(c cVar) {
            cVar.m(c() + this.f11443a);
            this.f11444b.offer(cVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends g8.h.c implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a f11450b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final c f11451c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicBoolean f11452d = new AtomicBoolean();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final h8.a f11449a = new h8.a();

        @Override // g8.h.c
        public h8.c c(Runnable runnable, long j10, TimeUnit timeUnit) {
            return this.f11449a.f() ? k8.b.INSTANCE : this.f11451c.e(runnable, j10, timeUnit, this.f11449a);
        }

        @Override // h8.c
        public void dispose() {
            if (this.f11452d.compareAndSet(false, true)) {
                this.f11449a.dispose();
                if (d.f11439j) {
                    this.f11451c.e(this, 0L, TimeUnit.NANOSECONDS, null);
                } else {
                    this.f11450b.d(this.f11451c);
                }
            }
        }

        @Override // h8.c
        public boolean f() {
            return this.f11452d.get();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11450b.d(this.f11451c);
        }

        b(a aVar) {
            this.f11450b = aVar;
            this.f11451c = aVar.b();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f11453c;

        public long k() {
            return this.f11453c;
        }

        public void m(long j10) {
            this.f11453c = j10;
        }

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.f11453c = 0L;
        }
    }

    public d() {
        this(f11434e);
    }

    static {
        c cVar = new c(new g("RxCachedThreadSchedulerShutdown"));
        f11438i = cVar;
        cVar.dispose();
        int iMax = Math.max(1, Math.min(10, Integer.getInteger("rx3.io-priority", 5).intValue()));
        g gVar = new g("RxCachedThreadScheduler", iMax);
        f11434e = gVar;
        f11435f = new g("RxCachedWorkerPoolEvictor", iMax);
        f11439j = Boolean.getBoolean("rx3.io-scheduled-release");
        a aVar = new a(0L, null, gVar);
        f11440k = aVar;
        aVar.e();
    }

    public d(ThreadFactory threadFactory) {
        this.f11441c = threadFactory;
        this.f11442d = new AtomicReference<>(f11440k);
        g();
    }

    @Override // g8.h
    public g8.h.c c() {
        return new b(this.f11442d.get());
    }

    public void g() {
        a aVar = new a(f11436g, f11437h, this.f11441c);
        if (androidx.p000lifecycle.h.a(this.f11442d, f11440k, aVar)) {
            return;
        }
        aVar.e();
    }
}
