package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.schedulers.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class g<T> extends io.reactivex.rxjava3.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final g8.h f11396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f11397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f11398d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a<T> extends io.reactivex.rxjava3.internal.observers.b<T> implements g8.g<T>, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;
        final int bufferSize;
        final boolean delayError;
        volatile boolean disposed;
        volatile boolean done;
        final g8.g<? super T> downstream;
        Throwable error;
        boolean outputFused;
        o8.c<T> queue;
        int sourceMode;
        h8.c upstream;
        final g8.h.c worker;

        void e() {
            int iAddAndGet = 1;
            while (!this.disposed) {
                boolean z10 = this.done;
                Throwable th = this.error;
                if (!this.delayError && z10 && th != null) {
                    this.disposed = true;
                    this.downstream.onError(this.error);
                    this.worker.dispose();
                    return;
                }
                this.downstream.a(null);
                if (z10) {
                    this.disposed = true;
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        this.downstream.onError(th2);
                    } else {
                        this.downstream.b();
                    }
                    this.worker.dispose();
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        @Override // o8.b
        public int j(int i10) {
            if ((i10 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        @Override // g8.g
        public void a(T t10) {
            if (this.done) {
                return;
            }
            if (this.sourceMode != 2) {
                this.queue.offer(t10);
            }
            h();
        }

        @Override // g8.g
        public void b() {
            if (this.done) {
                return;
            }
            this.done = true;
            h();
        }

        boolean c(boolean z10, boolean z11, g8.g<? super T> gVar) {
            if (this.disposed) {
                this.queue.clear();
                return true;
            }
            if (!z10) {
                return false;
            }
            Throwable th = this.error;
            if (this.delayError) {
                if (!z11) {
                    return false;
                }
                this.disposed = true;
                if (th != null) {
                    gVar.onError(th);
                } else {
                    gVar.b();
                }
                this.worker.dispose();
                return true;
            }
            if (th != null) {
                this.disposed = true;
                this.queue.clear();
                gVar.onError(th);
                this.worker.dispose();
                return true;
            }
            if (!z11) {
                return false;
            }
            this.disposed = true;
            gVar.b();
            this.worker.dispose();
            return true;
        }

        @Override // o8.c
        public void clear() {
            this.queue.clear();
        }

        @Override // g8.g
        public void d(h8.c cVar) {
            if (k8.a.m(this.upstream, cVar)) {
                this.upstream = cVar;
                if (cVar instanceof o8.a) {
                    o8.a aVar = (o8.a) cVar;
                    int iJ = aVar.j(7);
                    if (iJ == 1) {
                        this.sourceMode = iJ;
                        this.queue = aVar;
                        this.done = true;
                        this.downstream.d(this);
                        h();
                        return;
                    }
                    if (iJ == 2) {
                        this.sourceMode = iJ;
                        this.queue = aVar;
                        this.downstream.d(this);
                        return;
                    }
                }
                this.queue = new o8.d(this.bufferSize);
                this.downstream.d(this);
            }
        }

        @Override // h8.c
        public void dispose() {
            if (this.disposed) {
                return;
            }
            this.disposed = true;
            this.upstream.dispose();
            this.worker.dispose();
            if (this.outputFused || getAndIncrement() != 0) {
                return;
            }
            this.queue.clear();
        }

        @Override // h8.c
        public boolean f() {
            return this.disposed;
        }

        void g() {
            o8.c<T> cVar = this.queue;
            g8.g<? super T> gVar = this.downstream;
            int iAddAndGet = 1;
            while (!c(this.done, cVar.isEmpty(), gVar)) {
                while (true) {
                    boolean z10 = this.done;
                    try {
                        T tPoll = cVar.poll();
                        boolean z11 = tPoll == null;
                        if (c(z10, z11, gVar)) {
                            return;
                        }
                        if (z11) {
                            break;
                        } else {
                            gVar.a(tPoll);
                        }
                    } catch (Throwable th) {
                        i8.b.b(th);
                        this.disposed = true;
                        this.upstream.dispose();
                        cVar.clear();
                        gVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        @Override // o8.c
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // g8.g
        public void onError(Throwable th) {
            if (this.done) {
                p8.a.l(th);
                return;
            }
            this.error = th;
            this.done = true;
            h();
        }

        @Override // o8.c
        public T poll() {
            return this.queue.poll();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.outputFused) {
                e();
            } else {
                g();
            }
        }

        a(g8.g<? super T> gVar, g8.h.c cVar, boolean z10, int i10) {
            this.downstream = gVar;
            this.worker = cVar;
            this.delayError = z10;
            this.bufferSize = i10;
        }

        void h() {
            if (getAndIncrement() == 0) {
                this.worker.b(this);
            }
        }
    }

    @Override // g8.c
    protected void u(g8.g<? super T> gVar) {
        g8.h hVar = this.f11396b;
        if (hVar instanceof m) {
            this.f11373a.c(gVar);
        } else {
            this.f11373a.c(new a(gVar, hVar.c(), this.f11397c, this.f11398d));
        }
    }

    public g(g8.f<T> fVar, g8.h hVar, boolean z10, int i10) {
        super(fVar);
        this.f11396b = hVar;
        this.f11397c = z10;
        this.f11398d = i10;
    }
}
