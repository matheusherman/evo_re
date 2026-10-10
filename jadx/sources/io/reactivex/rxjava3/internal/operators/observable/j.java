package io.reactivex.rxjava3.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class j<T> extends io.reactivex.rxjava3.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final g8.h f11409b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a<T> extends AtomicReference<h8.c> implements g8.g<T>, h8.c {
        private static final long serialVersionUID = 8094547886072529208L;
        final g8.g<? super T> downstream;
        final AtomicReference<h8.c> upstream = new AtomicReference<>();

        @Override // g8.g
        public void a(T t10) {
            this.downstream.a(t10);
        }

        @Override // g8.g
        public void b() {
            this.downstream.b();
        }

        @Override // g8.g
        public void d(h8.c cVar) {
            k8.a.l(this.upstream, cVar);
        }

        @Override // h8.c
        public void dispose() {
            k8.a.a(this.upstream);
            k8.a.a(this);
        }

        @Override // g8.g
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        a(g8.g<? super T> gVar) {
            this.downstream = gVar;
        }

        void c(h8.c cVar) {
            k8.a.l(this, cVar);
        }

        @Override // h8.c
        public boolean f() {
            return k8.a.i(get());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a<T> f11410a;

        b(a<T> aVar) {
            this.f11410a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.f11373a.c(this.f11410a);
        }
    }

    @Override // g8.c
    public void u(g8.g<? super T> gVar) {
        a aVar = new a(gVar);
        gVar.d(aVar);
        aVar.c(this.f11409b.d(new b(aVar)));
    }

    public j(g8.f<T> fVar, g8.h hVar) {
        super(fVar);
        this.f11409b = hVar;
    }
}
