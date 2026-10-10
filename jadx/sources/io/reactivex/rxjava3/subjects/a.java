package io.reactivex.rxjava3.subjects;

import androidx.p000lifecycle.h;
import g8.g;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a<T> extends c<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final C0196a[] f11497c = new C0196a[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final C0196a[] f11498d = new C0196a[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final AtomicReference<C0196a<T>[]> f11499a = new AtomicReference<>(f11498d);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Throwable f11500b;

    /* JADX INFO: renamed from: io.reactivex.rxjava3.subjects.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class C0196a<T> extends AtomicBoolean implements h8.c {
        private static final long serialVersionUID = 3562861878281475070L;
        final g<? super T> downstream;
        final a<T> parent;

        @Override // h8.c
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.A(this);
            }
        }

        C0196a(g<? super T> gVar, a<T> aVar) {
            this.downstream = gVar;
            this.parent = aVar;
        }

        public void a() {
            if (!get()) {
                this.downstream.b();
            }
        }

        public void b(Throwable th) {
            if (get()) {
                p8.a.l(th);
            } else {
                this.downstream.onError(th);
            }
        }

        public void c(T t10) {
            if (!get()) {
                this.downstream.a(t10);
            }
        }

        @Override // h8.c
        public boolean f() {
            return get();
        }
    }

    public static <T> a<T> z() {
        return new a<>();
    }

    void A(C0196a<T> c0196a) {
        C0196a<T>[] c0196aArr;
        C0196a[] c0196aArr2;
        do {
            c0196aArr = this.f11499a.get();
            if (c0196aArr == f11497c || c0196aArr == f11498d) {
                return;
            }
            int length = c0196aArr.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    i10 = -1;
                    break;
                } else if (c0196aArr[i10] == c0196a) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 < 0) {
                return;
            }
            if (length == 1) {
                c0196aArr2 = f11498d;
            } else {
                C0196a[] c0196aArr3 = new C0196a[length - 1];
                System.arraycopy(c0196aArr, 0, c0196aArr3, 0, i10);
                System.arraycopy(c0196aArr, i10 + 1, c0196aArr3, i10, (length - i10) - 1);
                c0196aArr2 = c0196aArr3;
            }
        } while (!h.a(this.f11499a, c0196aArr, c0196aArr2));
    }

    @Override // g8.g
    public void a(T t10) {
        io.reactivex.rxjava3.internal.util.b.b(t10, "onNext called with a null value.");
        for (C0196a<T> c0196a : this.f11499a.get()) {
            c0196a.c(t10);
        }
    }

    @Override // g8.g
    public void b() {
        C0196a<T>[] c0196aArr = this.f11499a.get();
        C0196a<T>[] c0196aArr2 = f11497c;
        if (c0196aArr == c0196aArr2) {
            return;
        }
        for (C0196a<T> c0196a : this.f11499a.getAndSet(c0196aArr2)) {
            c0196a.a();
        }
    }

    @Override // g8.g
    public void d(h8.c cVar) {
        if (this.f11499a.get() == f11497c) {
            cVar.dispose();
        }
    }

    @Override // g8.g
    public void onError(Throwable th) {
        io.reactivex.rxjava3.internal.util.b.b(th, "onError called with a null Throwable.");
        C0196a<T>[] c0196aArr = this.f11499a.get();
        C0196a<T>[] c0196aArr2 = f11497c;
        if (c0196aArr == c0196aArr2) {
            p8.a.l(th);
            return;
        }
        this.f11500b = th;
        for (C0196a<T> c0196a : this.f11499a.getAndSet(c0196aArr2)) {
            c0196a.b(th);
        }
    }

    @Override // g8.c
    protected void u(g<? super T> gVar) {
        C0196a<T> c0196a = new C0196a<>(gVar, this);
        gVar.d(c0196a);
        if (y(c0196a)) {
            if (c0196a.f()) {
                A(c0196a);
            }
        } else {
            Throwable th = this.f11500b;
            if (th != null) {
                gVar.onError(th);
            } else {
                gVar.b();
            }
        }
    }

    boolean y(C0196a<T> c0196a) {
        C0196a<T>[] c0196aArr;
        C0196a[] c0196aArr2;
        do {
            c0196aArr = this.f11499a.get();
            if (c0196aArr == f11497c) {
                return false;
            }
            int length = c0196aArr.length;
            c0196aArr2 = new C0196a[length + 1];
            System.arraycopy(c0196aArr, 0, c0196aArr2, 0, length);
            c0196aArr2[length] = c0196a;
        } while (!h.a(this.f11499a, c0196aArr, c0196aArr2));
        return true;
    }

    a() {
    }
}
