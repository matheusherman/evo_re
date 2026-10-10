package io.reactivex.rxjava3.internal.schedulers;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class m extends g8.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final m f11470c = new m();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Runnable f11471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final c f11472b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f11473c;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f11472b.f11481d) {
                return;
            }
            long jA = this.f11472b.a(TimeUnit.MILLISECONDS);
            long j10 = this.f11473c;
            if (j10 > jA) {
                try {
                    Thread.sleep(j10 - jA);
                } catch (InterruptedException e10) {
                    Thread.currentThread().interrupt();
                    p8.a.l(e10);
                    return;
                }
            }
            if (this.f11472b.f11481d) {
                return;
            }
            this.f11471a.run();
        }

        a(Runnable runnable, c cVar, long j10) {
            this.f11471a = runnable;
            this.f11472b = cVar;
            this.f11473c = j10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b implements Comparable<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Runnable f11474a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f11475b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f11476c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile boolean f11477d;

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            int iCompare = Long.compare(this.f11475b, bVar.f11475b);
            return iCompare == 0 ? Integer.compare(this.f11476c, bVar.f11476c) : iCompare;
        }

        b(Runnable runnable, Long l10, int i10) {
            this.f11474a = runnable;
            this.f11475b = l10.longValue();
            this.f11476c = i10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends g8.h.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final PriorityBlockingQueue<b> f11478a = new PriorityBlockingQueue<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicInteger f11479b = new AtomicInteger();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicInteger f11480c = new AtomicInteger();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile boolean f11481d;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final b f11482a;

            a(b bVar) {
                this.f11482a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f11482a.f11477d = true;
                c.this.f11478a.remove(this.f11482a);
            }
        }

        @Override // h8.c
        public void dispose() {
            this.f11481d = true;
        }

        @Override // g8.h.c
        public h8.c b(Runnable runnable) {
            return e(runnable, a(TimeUnit.MILLISECONDS));
        }

        @Override // g8.h.c
        public h8.c c(Runnable runnable, long j10, TimeUnit timeUnit) {
            long jA = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j10);
            return e(new a(runnable, this, jA), jA);
        }

        h8.c e(Runnable runnable, long j10) {
            if (this.f11481d) {
                return k8.b.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j10), this.f11480c.incrementAndGet());
            this.f11478a.add(bVar);
            if (this.f11479b.getAndIncrement() != 0) {
                return h8.b.b(new a(bVar));
            }
            int iAddAndGet = 1;
            while (!this.f11481d) {
                b bVarPoll = this.f11478a.poll();
                if (bVarPoll == null) {
                    iAddAndGet = this.f11479b.addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return k8.b.INSTANCE;
                    }
                } else if (!bVarPoll.f11477d) {
                    bVarPoll.f11474a.run();
                }
            }
            this.f11478a.clear();
            return k8.b.INSTANCE;
        }

        @Override // h8.c
        public boolean f() {
            return this.f11481d;
        }

        c() {
        }
    }

    public static m g() {
        return f11470c;
    }

    @Override // g8.h
    public g8.h.c c() {
        return new c();
    }

    m() {
    }

    @Override // g8.h
    public h8.c d(Runnable runnable) {
        p8.a.n(runnable).run();
        return k8.b.INSTANCE;
    }

    @Override // g8.h
    public h8.c e(Runnable runnable, long j10, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j10);
            p8.a.n(runnable).run();
        } catch (InterruptedException e10) {
            Thread.currentThread().interrupt();
            p8.a.l(e10);
        }
        return k8.b.INSTANCE;
    }
}
