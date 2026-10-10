package io.reactivex.rxjava3.internal.operators.observable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class i<T> extends g8.c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final m8.a<T> f11403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f11404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f11405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f11406d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final g8.h f11407e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    a f11408f;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends AtomicReference<h8.c> implements Runnable, j8.c<h8.c> {
        private static final long serialVersionUID = -4552101107598366241L;
        boolean connected;
        boolean disconnectedEarly;
        final i<?> parent;
        long subscriberCount;
        h8.c timer;

        @Override // java.lang.Runnable
        public void run() {
            this.parent.z(this);
        }

        a(i<?> iVar) {
            this.parent = iVar;
        }

        @Override // j8.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(h8.c cVar) {
            k8.a.j(this, cVar);
            synchronized (this.parent) {
                try {
                    if (this.disconnectedEarly) {
                        this.parent.f11403a.z();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b<T> extends AtomicBoolean implements g8.g<T>, h8.c {
        private static final long serialVersionUID = -7419642935409022375L;
        final a connection;
        final g8.g<? super T> downstream;
        final i<T> parent;
        h8.c upstream;

        @Override // g8.g
        public void b() {
            if (compareAndSet(false, true)) {
                this.parent.y(this.connection);
                this.downstream.b();
            }
        }

        @Override // g8.g
        public void onError(Throwable th) {
            if (!compareAndSet(false, true)) {
                p8.a.l(th);
            } else {
                this.parent.y(this.connection);
                this.downstream.onError(th);
            }
        }

        @Override // g8.g
        public void a(T t10) {
            this.downstream.a(t10);
        }

        @Override // g8.g
        public void d(h8.c cVar) {
            if (k8.a.m(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.d(this);
            }
        }

        @Override // h8.c
        public void dispose() {
            this.upstream.dispose();
            if (compareAndSet(false, true)) {
                this.parent.x(this.connection);
            }
        }

        @Override // h8.c
        public boolean f() {
            return this.upstream.f();
        }

        b(g8.g<? super T> gVar, i<T> iVar, a aVar) {
            this.downstream = gVar;
            this.parent = iVar;
            this.connection = aVar;
        }
    }

    public i(m8.a<T> aVar) {
        this(aVar, 1, 0L, TimeUnit.NANOSECONDS, null);
    }

    @Override // g8.c
    protected void u(g8.g<? super T> gVar) {
        a aVar;
        boolean z10;
        h8.c cVar;
        synchronized (this) {
            try {
                aVar = this.f11408f;
                if (aVar == null) {
                    aVar = new a(this);
                    this.f11408f = aVar;
                }
                long j10 = aVar.subscriberCount;
                if (j10 == 0 && (cVar = aVar.timer) != null) {
                    cVar.dispose();
                }
                long j11 = j10 + 1;
                aVar.subscriberCount = j11;
                if (aVar.connected || j11 != this.f11404b) {
                    z10 = false;
                } else {
                    z10 = true;
                    aVar.connected = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f11403a.c(new b(gVar, this, aVar));
        if (z10) {
            this.f11403a.x(aVar);
        }
    }

    void x(a aVar) {
        synchronized (this) {
            try {
                a aVar2 = this.f11408f;
                if (aVar2 != null && aVar2 == aVar) {
                    long j10 = aVar.subscriberCount - 1;
                    aVar.subscriberCount = j10;
                    if (j10 == 0 && aVar.connected) {
                        if (this.f11405c == 0) {
                            z(aVar);
                            return;
                        }
                        k8.d dVar = new k8.d();
                        aVar.timer = dVar;
                        dVar.a(this.f11407e.e(aVar, this.f11405c, this.f11406d));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void y(a aVar) {
        synchronized (this) {
            try {
                if (this.f11408f == aVar) {
                    h8.c cVar = aVar.timer;
                    if (cVar != null) {
                        cVar.dispose();
                        aVar.timer = null;
                    }
                    long j10 = aVar.subscriberCount - 1;
                    aVar.subscriberCount = j10;
                    if (j10 == 0) {
                        this.f11408f = null;
                        this.f11403a.z();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void z(a aVar) {
        synchronized (this) {
            try {
                if (aVar.subscriberCount == 0 && aVar == this.f11408f) {
                    this.f11408f = null;
                    h8.c cVar = aVar.get();
                    k8.a.a(aVar);
                    if (cVar == null) {
                        aVar.disconnectedEarly = true;
                    } else {
                        this.f11403a.z();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public i(m8.a<T> aVar, int i10, long j10, TimeUnit timeUnit, g8.h hVar) {
        this.f11403a = aVar;
        this.f11404b = i10;
        this.f11405c = j10;
        this.f11406d = timeUnit;
        this.f11407e = hVar;
    }
}
