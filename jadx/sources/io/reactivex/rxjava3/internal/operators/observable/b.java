package io.reactivex.rxjava3.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class b<T> extends g8.c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final g8.e<T> f11374a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a<T> extends AtomicReference<h8.c> implements g8.d<T>, h8.c {
        private static final long serialVersionUID = -3434801548987643227L;
        final g8.g<? super T> observer;

        @Override // g8.a
        public void a(T t10) {
            if (t10 == null) {
                b(io.reactivex.rxjava3.internal.util.b.a("onNext called with a null value."));
            } else {
                if (f()) {
                    return;
                }
                this.observer.a(t10);
            }
        }

        public boolean c(Throwable th) {
            if (th == null) {
                th = io.reactivex.rxjava3.internal.util.b.a("onError called with a null Throwable.");
            }
            if (f()) {
                return false;
            }
            try {
                this.observer.onError(th);
                return true;
            } finally {
                dispose();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", a.class.getSimpleName(), super.toString());
        }

        a(g8.g<? super T> gVar) {
            this.observer = gVar;
        }

        public void b(Throwable th) {
            if (!c(th)) {
                p8.a.l(th);
            }
        }

        @Override // h8.c
        public void dispose() {
            k8.a.a(this);
        }

        @Override // h8.c
        public boolean f() {
            return k8.a.i(get());
        }
    }

    @Override // g8.c
    protected void u(g8.g<? super T> gVar) {
        a aVar = new a(gVar);
        gVar.d(aVar);
        try {
            this.f11374a.a(aVar);
        } catch (Throwable th) {
            i8.b.b(th);
            aVar.b(th);
        }
    }

    public b(g8.e<T> eVar) {
        this.f11374a = eVar;
    }
}
