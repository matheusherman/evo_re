package g8;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean f10542a = Boolean.getBoolean("rx3.scheduler.use-nanotime");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final long f10543b = a(Long.getLong("rx3.scheduler.drift-tolerance", 15).longValue(), System.getProperty("rx3.scheduler.drift-tolerance-unit", "minutes"));

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a implements h8.c, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Runnable f10544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final c f10545b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Thread f10546c;

        @Override // h8.c
        public void dispose() {
            if (this.f10546c == Thread.currentThread()) {
                c cVar = this.f10545b;
                if (cVar instanceof io.reactivex.rxjava3.internal.schedulers.f) {
                    ((io.reactivex.rxjava3.internal.schedulers.f) cVar).j();
                    return;
                }
            }
            this.f10545b.dispose();
        }

        @Override // h8.c
        public boolean f() {
            return this.f10545b.f();
        }

        a(Runnable runnable, c cVar) {
            this.f10544a = runnable;
            this.f10545b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10546c = Thread.currentThread();
            try {
                this.f10544a.run();
                dispose();
                this.f10546c = null;
            } catch (Throwable th) {
                try {
                    p8.a.l(th);
                    throw th;
                } catch (Throwable th2) {
                    dispose();
                    this.f10546c = null;
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b implements h8.c, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Runnable f10547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final c f10548b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile boolean f10549c;

        @Override // h8.c
        public void dispose() {
            this.f10549c = true;
            this.f10548b.dispose();
        }

        @Override // h8.c
        public boolean f() {
            return this.f10549c;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f10549c) {
                return;
            }
            try {
                this.f10547a.run();
            } catch (Throwable th) {
                dispose();
                p8.a.l(th);
                throw th;
            }
        }

        b(Runnable runnable, c cVar) {
            this.f10547a = runnable;
            this.f10548b = cVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static abstract class c implements h8.c {

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final Runnable f10550a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final k8.d f10551b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final long f10552c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            long f10553d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            long f10554e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            long f10555f;

            a(long j10, Runnable runnable, long j11, k8.d dVar, long j12) {
                this.f10550a = runnable;
                this.f10551b = dVar;
                this.f10552c = j12;
                this.f10554e = j11;
                this.f10555f = j10;
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0035  */
            @Override // java.lang.Runnable
            public void run() {
                long j10;
                this.f10550a.run();
                if (this.f10551b.f()) {
                    return;
                }
                c cVar = c.this;
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                long jA = cVar.a(timeUnit);
                long j11 = h.f10543b;
                long j12 = jA + j11;
                long j13 = this.f10554e;
                if (j12 >= j13) {
                    long j14 = this.f10552c;
                    if (jA >= j13 + j14 + j11) {
                        long j15 = this.f10552c;
                        long j16 = jA + j15;
                        long j17 = this.f10553d + 1;
                        this.f10553d = j17;
                        this.f10555f = j16 - (j15 * j17);
                        j10 = j16;
                    } else {
                        long j18 = this.f10555f;
                        long j19 = this.f10553d + 1;
                        this.f10553d = j19;
                        j10 = j18 + (j19 * j14);
                    }
                } else {
                    long j110 = this.f10552c;
                    long j111 = jA + j110;
                    long j112 = this.f10553d + 1;
                    this.f10553d = j112;
                    this.f10555f = j111 - (j110 * j112);
                    j10 = j111;
                }
                this.f10554e = jA;
                this.f10551b.a(c.this.c(this, j10 - jA, timeUnit));
            }
        }

        public abstract h8.c c(Runnable runnable, long j10, TimeUnit timeUnit);

        public h8.c b(Runnable runnable) {
            return c(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public h8.c d(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
            k8.d dVar = new k8.d();
            k8.d dVar2 = new k8.d(dVar);
            Runnable runnableN = p8.a.n(runnable);
            long nanos = timeUnit.toNanos(j11);
            long jA = a(TimeUnit.NANOSECONDS);
            h8.c cVarC = c(new a(jA + timeUnit.toNanos(j10), runnableN, jA, dVar2, nanos), j10, timeUnit);
            if (cVarC == k8.b.INSTANCE) {
                return cVarC;
            }
            dVar.a(cVarC);
            return dVar2;
        }

        public long a(TimeUnit timeUnit) {
            return h.b(timeUnit);
        }
    }

    public abstract c c();

    static long a(long j10, String str) {
        if ("seconds".equalsIgnoreCase(str)) {
            return TimeUnit.SECONDS.toNanos(j10);
        }
        return "milliseconds".equalsIgnoreCase(str) ? TimeUnit.MILLISECONDS.toNanos(j10) : TimeUnit.MINUTES.toNanos(j10);
    }

    static long b(TimeUnit timeUnit) {
        return !f10542a ? timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS) : timeUnit.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    public h8.c d(Runnable runnable) {
        return e(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public h8.c e(Runnable runnable, long j10, TimeUnit timeUnit) {
        c cVarC = c();
        a aVar = new a(p8.a.n(runnable), cVarC);
        cVarC.c(aVar, j10, timeUnit);
        return aVar;
    }

    public h8.c f(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        c cVarC = c();
        b bVar = new b(p8.a.n(runnable), cVarC);
        h8.c cVarD = cVarC.d(bVar, j10, j11, timeUnit);
        if (cVarD == k8.b.INSTANCE) {
            return cVarD;
        }
        return bVar;
    }
}
