package io.reactivex.rxjava3.internal.operators.observable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c<T> extends io.reactivex.rxjava3.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f11375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f11376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final g8.h f11377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final j8.c<? super T> f11378e;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a<T> extends AtomicReference<h8.c> implements Runnable, h8.c {
        private static final long serialVersionUID = 6812032969491025141L;
        final long idx;
        final AtomicBoolean once = new AtomicBoolean();
        final b<T> parent;
        final T value;

        @Override // java.lang.Runnable
        public void run() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.c(this.idx, this.value, this);
            }
        }

        a(T t10, long j10, b<T> bVar) {
            this.value = t10;
            this.idx = j10;
            this.parent = bVar;
        }

        public void a(h8.c cVar) {
            k8.a.j(this, cVar);
        }

        @Override // h8.c
        public void dispose() {
            k8.a.a(this);
        }

        @Override // h8.c
        public boolean f() {
            if (get() == k8.a.DISPOSED) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b<T> implements g8.g<T>, h8.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final g8.g<? super T> f11379a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f11380b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final TimeUnit f11381c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final g8.h.c f11382d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final j8.c<? super T> f11383e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        h8.c f11384f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        a<T> f11385g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile long f11386h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f11387i;

        @Override // g8.g
        public void a(T t10) {
            if (this.f11387i) {
                return;
            }
            long j10 = this.f11386h + 1;
            this.f11386h = j10;
            a<T> aVar = this.f11385g;
            if (aVar != null) {
                aVar.dispose();
            }
            j8.c<? super T> cVar = this.f11383e;
            if (cVar != null && aVar != null) {
                try {
                    cVar.accept(this.f11385g.value);
                } catch (Throwable th) {
                    i8.b.b(th);
                    this.f11384f.dispose();
                    this.f11379a.onError(th);
                    this.f11387i = true;
                }
            }
            a<T> aVar2 = new a<>(t10, j10, this);
            this.f11385g = aVar2;
            aVar2.a(this.f11382d.c(aVar2, this.f11380b, this.f11381c));
        }

        @Override // g8.g
        public void b() {
            if (this.f11387i) {
                return;
            }
            this.f11387i = true;
            a<T> aVar = this.f11385g;
            if (aVar != null) {
                aVar.dispose();
            }
            if (aVar != null) {
                aVar.run();
            }
            this.f11379a.b();
            this.f11382d.dispose();
        }

        void c(long j10, T t10, a<T> aVar) {
            if (j10 == this.f11386h) {
                this.f11379a.a(t10);
                aVar.dispose();
            }
        }

        @Override // g8.g
        public void d(h8.c cVar) {
            if (k8.a.m(this.f11384f, cVar)) {
                this.f11384f = cVar;
                this.f11379a.d(this);
            }
        }

        @Override // h8.c
        public void dispose() {
            this.f11384f.dispose();
            this.f11382d.dispose();
        }

        @Override // h8.c
        public boolean f() {
            return this.f11382d.f();
        }

        @Override // g8.g
        public void onError(Throwable th) {
            if (this.f11387i) {
                p8.a.l(th);
                return;
            }
            a<T> aVar = this.f11385g;
            if (aVar != null) {
                aVar.dispose();
            }
            this.f11387i = true;
            this.f11379a.onError(th);
            this.f11382d.dispose();
        }

        b(g8.g<? super T> gVar, long j10, TimeUnit timeUnit, g8.h.c cVar, j8.c<? super T> cVar2) {
            this.f11379a = gVar;
            this.f11380b = j10;
            this.f11381c = timeUnit;
            this.f11382d = cVar;
            this.f11383e = cVar2;
        }
    }

    @Override // g8.c
    public void u(g8.g<? super T> gVar) {
        this.f11373a.c(new b(new n8.a(gVar), this.f11375b, this.f11376c, this.f11377d.c(), this.f11378e));
    }

    public c(g8.f<T> fVar, long j10, TimeUnit timeUnit, g8.h hVar, j8.c<? super T> cVar) {
        super(fVar);
        this.f11375b = j10;
        this.f11376c = timeUnit;
        this.f11377d = hVar;
        this.f11378e = cVar;
    }
}
