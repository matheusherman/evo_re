package io.reactivex.rxjava3.internal.observers;

import g8.g;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class a<T, R> implements g<T>, o8.a<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final g<? super R> f11368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected h8.c f11369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected o8.a<T> f11370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected boolean f11371d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f11372e;

    protected boolean e() {
        return true;
    }

    @Override // g8.g
    public void b() {
        if (this.f11371d) {
            return;
        }
        this.f11371d = true;
        this.f11368a.b();
    }

    @Override // o8.c
    public void clear() {
        this.f11370c.clear();
    }

    @Override // g8.g
    public final void d(h8.c cVar) {
        if (k8.a.m(this.f11369b, cVar)) {
            this.f11369b = cVar;
            if (cVar instanceof o8.a) {
                this.f11370c = (o8.a) cVar;
            }
            if (e()) {
                this.f11368a.d(this);
                c();
            }
        }
    }

    @Override // h8.c
    public void dispose() {
        this.f11369b.dispose();
    }

    @Override // h8.c
    public boolean f() {
        return this.f11369b.f();
    }

    protected final int h(int i10) {
        o8.a<T> aVar = this.f11370c;
        if (aVar == null || (i10 & 4) != 0) {
            return 0;
        }
        int iJ = aVar.j(i10);
        if (iJ != 0) {
            this.f11372e = iJ;
        }
        return iJ;
    }

    @Override // o8.c
    public boolean isEmpty() {
        return this.f11370c.isEmpty();
    }

    @Override // o8.c
    public final boolean offer(R r10) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // g8.g
    public void onError(Throwable th) {
        if (this.f11371d) {
            p8.a.l(th);
        } else {
            this.f11371d = true;
            this.f11368a.onError(th);
        }
    }

    public a(g<? super R> gVar) {
        this.f11368a = gVar;
    }

    protected final void g(Throwable th) {
        i8.b.b(th);
        this.f11369b.dispose();
        onError(th);
    }

    protected void c() {
    }
}
