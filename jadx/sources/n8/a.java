package n8;

import g8.g;
import h8.c;
import io.reactivex.rxjava3.internal.util.b;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a<T> implements g<T>, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final g<? super T> f16089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final boolean f16090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    c f16091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f16092d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    io.reactivex.rxjava3.internal.util.a<Object> f16093e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    volatile boolean f16094f;

    public a(g<? super T> gVar) {
        this(gVar, false);
    }

    void c() {
        io.reactivex.rxjava3.internal.util.a<Object> aVar;
        do {
            synchronized (this) {
                try {
                    aVar = this.f16093e;
                    if (aVar == null) {
                        this.f16092d = false;
                        return;
                    }
                    this.f16093e = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } while (!aVar.a(this.f16089a));
    }

    @Override // h8.c
    public void dispose() {
        this.f16094f = true;
        this.f16091c.dispose();
    }

    public a(g<? super T> gVar, boolean z10) {
        this.f16089a = gVar;
        this.f16090b = z10;
    }

    @Override // g8.g
    public void a(T t10) {
        if (this.f16094f) {
            return;
        }
        if (t10 == null) {
            this.f16091c.dispose();
            onError(b.a("onNext called with a null value."));
            return;
        }
        synchronized (this) {
            try {
                if (this.f16094f) {
                    return;
                }
                if (!this.f16092d) {
                    this.f16092d = true;
                    this.f16089a.a(t10);
                    c();
                } else {
                    io.reactivex.rxjava3.internal.util.a<Object> aVar = this.f16093e;
                    if (aVar == null) {
                        aVar = new io.reactivex.rxjava3.internal.util.a<>(4);
                        this.f16093e = aVar;
                    }
                    aVar.b(io.reactivex.rxjava3.internal.util.c.k(t10));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // g8.g
    public void b() {
        if (this.f16094f) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f16094f) {
                    return;
                }
                if (!this.f16092d) {
                    this.f16094f = true;
                    this.f16092d = true;
                    this.f16089a.b();
                } else {
                    io.reactivex.rxjava3.internal.util.a<Object> aVar = this.f16093e;
                    if (aVar == null) {
                        aVar = new io.reactivex.rxjava3.internal.util.a<>(4);
                        this.f16093e = aVar;
                    }
                    aVar.b(io.reactivex.rxjava3.internal.util.c.f());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // g8.g
    public void d(c cVar) {
        if (k8.a.m(this.f16091c, cVar)) {
            this.f16091c = cVar;
            this.f16089a.d(this);
        }
    }

    @Override // h8.c
    public boolean f() {
        return this.f16091c.f();
    }

    @Override // g8.g
    public void onError(Throwable th) {
        if (this.f16094f) {
            p8.a.l(th);
            return;
        }
        synchronized (this) {
            try {
                boolean z10 = true;
                if (!this.f16094f) {
                    if (this.f16092d) {
                        this.f16094f = true;
                        io.reactivex.rxjava3.internal.util.a<Object> aVar = this.f16093e;
                        if (aVar == null) {
                            aVar = new io.reactivex.rxjava3.internal.util.a<>(4);
                            this.f16093e = aVar;
                        }
                        Object objJ = io.reactivex.rxjava3.internal.util.c.j(th);
                        if (this.f16090b) {
                            aVar.b(objJ);
                        } else {
                            aVar.d(objJ);
                        }
                        return;
                    }
                    this.f16094f = true;
                    this.f16092d = true;
                    z10 = false;
                }
                if (z10) {
                    p8.a.l(th);
                } else {
                    this.f16089a.onError(th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
