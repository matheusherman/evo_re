package io.reactivex.rxjava3.subjects;

import g8.g;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class b<T> extends c<T> implements io.reactivex.rxjava3.internal.util.a.InterfaceC0195a<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final c<T> f11501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f11502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    io.reactivex.rxjava3.internal.util.a<Object> f11503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    volatile boolean f11504d;

    void y() {
        io.reactivex.rxjava3.internal.util.a<Object> aVar;
        while (true) {
            synchronized (this) {
                try {
                    aVar = this.f11503c;
                    if (aVar == null) {
                        this.f11502b = false;
                        return;
                    }
                    this.f11503c = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
            aVar.c(this);
        }
    }

    @Override // g8.g
    public void a(T t10) {
        if (this.f11504d) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f11504d) {
                    return;
                }
                if (!this.f11502b) {
                    this.f11502b = true;
                    this.f11501a.a(t10);
                    y();
                } else {
                    io.reactivex.rxjava3.internal.util.a<Object> aVar = this.f11503c;
                    if (aVar == null) {
                        aVar = new io.reactivex.rxjava3.internal.util.a<>(4);
                        this.f11503c = aVar;
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
        if (this.f11504d) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f11504d) {
                    return;
                }
                this.f11504d = true;
                if (!this.f11502b) {
                    this.f11502b = true;
                    this.f11501a.b();
                    return;
                }
                io.reactivex.rxjava3.internal.util.a<Object> aVar = this.f11503c;
                if (aVar == null) {
                    aVar = new io.reactivex.rxjava3.internal.util.a<>(4);
                    this.f11503c = aVar;
                }
                aVar.b(io.reactivex.rxjava3.internal.util.c.f());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // g8.g
    public void d(h8.c cVar) {
        boolean z10 = true;
        if (!this.f11504d) {
            synchronized (this) {
                try {
                    if (!this.f11504d) {
                        if (this.f11502b) {
                            io.reactivex.rxjava3.internal.util.a<Object> aVar = this.f11503c;
                            if (aVar == null) {
                                aVar = new io.reactivex.rxjava3.internal.util.a<>(4);
                                this.f11503c = aVar;
                            }
                            aVar.b(io.reactivex.rxjava3.internal.util.c.i(cVar));
                            return;
                        }
                        this.f11502b = true;
                        z10 = false;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (z10) {
            cVar.dispose();
        } else {
            this.f11501a.d(cVar);
            y();
        }
    }

    @Override // g8.g
    public void onError(Throwable th) {
        if (this.f11504d) {
            p8.a.l(th);
            return;
        }
        synchronized (this) {
            try {
                boolean z10 = true;
                if (!this.f11504d) {
                    this.f11504d = true;
                    if (this.f11502b) {
                        io.reactivex.rxjava3.internal.util.a<Object> aVar = this.f11503c;
                        if (aVar == null) {
                            aVar = new io.reactivex.rxjava3.internal.util.a<>(4);
                            this.f11503c = aVar;
                        }
                        aVar.d(io.reactivex.rxjava3.internal.util.c.j(th));
                        return;
                    }
                    this.f11502b = true;
                    z10 = false;
                }
                if (z10) {
                    p8.a.l(th);
                } else {
                    this.f11501a.onError(th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // io.reactivex.rxjava3.internal.util.a.InterfaceC0195a, j8.f
    public boolean test(Object obj) {
        return io.reactivex.rxjava3.internal.util.c.a(obj, this.f11501a);
    }

    @Override // g8.c
    protected void u(g<? super T> gVar) {
        this.f11501a.c(gVar);
    }

    b(c<T> cVar) {
        this.f11501a = cVar;
    }
}
