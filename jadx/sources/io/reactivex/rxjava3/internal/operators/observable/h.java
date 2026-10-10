package io.reactivex.rxjava3.internal.operators.observable;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class h<T> extends m8.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final g8.f<T> f11399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference<b<T>> f11400b = new AtomicReference<>();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b<T> extends AtomicReference<a<T>[]> implements g8.g<T>, h8.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final a[] f11401a = new a[0];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final a[] f11402b = new a[0];
        private static final long serialVersionUID = -3251430252873581268L;
        final AtomicReference<b<T>> current;
        Throwable error;
        final AtomicBoolean connect = new AtomicBoolean();
        final AtomicReference<h8.c> upstream = new AtomicReference<>();

        @Override // g8.g
        public void b() {
            this.upstream.lazySet(k8.a.DISPOSED);
            for (a<T> aVar : getAndSet(f11402b)) {
                aVar.downstream.b();
            }
        }

        @Override // g8.g
        public void d(h8.c cVar) {
            k8.a.l(this.upstream, cVar);
        }

        @Override // h8.c
        public void dispose() {
            getAndSet(f11402b);
            androidx.p000lifecycle.h.a(this.current, this, null);
            k8.a.a(this.upstream);
        }

        @Override // g8.g
        public void onError(Throwable th) {
            h8.c cVar = this.upstream.get();
            k8.a aVar = k8.a.DISPOSED;
            if (cVar == aVar) {
                p8.a.l(th);
                return;
            }
            this.error = th;
            this.upstream.lazySet(aVar);
            for (a<T> aVar2 : getAndSet(f11402b)) {
                aVar2.downstream.onError(th);
            }
        }

        b(AtomicReference<b<T>> atomicReference) {
            this.current = atomicReference;
            lazySet(f11401a);
        }

        @Override // g8.g
        public void a(T t10) {
            for (a<T> aVar : get()) {
                aVar.downstream.a(t10);
            }
        }

        public boolean c(a<T> aVar) {
            a<T>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = get();
                if (aVarArr == f11402b) {
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!compareAndSet(aVarArr, aVarArr2));
            return true;
        }

        public void e(a<T> aVar) {
            a<T>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = get();
                int length = aVarArr.length;
                if (length != 0) {
                    int i10 = 0;
                    while (true) {
                        if (i10 < length) {
                            if (aVarArr[i10] == aVar) {
                                break;
                            } else {
                                i10++;
                            }
                        } else {
                            i10 = -1;
                            break;
                        }
                    }
                    if (i10 >= 0) {
                        aVarArr2 = f11401a;
                        if (length != 1) {
                            aVarArr2 = new a[length - 1];
                            System.arraycopy(aVarArr, 0, aVarArr2, 0, i10);
                            System.arraycopy(aVarArr, i10 + 1, aVarArr2, i10, (length - i10) - 1);
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(aVarArr, aVarArr2));
        }

        @Override // h8.c
        public boolean f() {
            if (get() == f11402b) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a<T> extends AtomicReference<b<T>> implements h8.c {
        private static final long serialVersionUID = 7463222674719692880L;
        final g8.g<? super T> downstream;

        @Override // h8.c
        public void dispose() {
            b<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.e(this);
            }
        }

        a(g8.g<? super T> gVar, b<T> bVar) {
            this.downstream = gVar;
            lazySet(bVar);
        }

        @Override // h8.c
        public boolean f() {
            if (get() == null) {
                return true;
            }
            return false;
        }
    }

    @Override // g8.c
    protected void u(g8.g<? super T> gVar) {
        b<T> bVar;
        while (true) {
            bVar = this.f11400b.get();
            if (bVar != null) {
                break;
            }
            b<T> bVar2 = new b<>(this.f11400b);
            if (androidx.p000lifecycle.h.a(this.f11400b, bVar, bVar2)) {
                bVar = bVar2;
                break;
            }
        }
        a<T> aVar = new a<>(gVar, bVar);
        gVar.d(aVar);
        if (bVar.c(aVar)) {
            if (aVar.f()) {
                bVar.e(aVar);
            }
        } else {
            Throwable th = bVar.error;
            if (th != null) {
                gVar.onError(th);
            } else {
                gVar.b();
            }
        }
    }

    @Override // m8.a
    public void x(j8.c<? super h8.c> cVar) {
        b<T> bVar;
        while (true) {
            bVar = this.f11400b.get();
            if (bVar != null && !bVar.f()) {
                break;
            }
            b<T> bVar2 = new b<>(this.f11400b);
            if (androidx.p000lifecycle.h.a(this.f11400b, bVar, bVar2)) {
                bVar = bVar2;
                break;
            }
        }
        boolean z10 = false;
        if (!bVar.connect.get() && bVar.connect.compareAndSet(false, true)) {
            z10 = true;
        }
        try {
            cVar.accept(bVar);
            if (z10) {
                this.f11399a.c(bVar);
            }
        } catch (Throwable th) {
            i8.b.b(th);
            throw io.reactivex.rxjava3.internal.util.b.d(th);
        }
    }

    @Override // m8.a
    public void z() {
        b<T> bVar = this.f11400b.get();
        if (bVar == null || !bVar.f()) {
            return;
        }
        androidx.p000lifecycle.h.a(this.f11400b, bVar, null);
    }

    public h(g8.f<T> fVar) {
        this.f11399a = fVar;
    }
}
