package com.koushikdutta.async;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class k implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    p f5107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f5108b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    o4.e f5110d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f5112f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final l f5109c = new l();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f5111e = Integer.MAX_VALUE;

    protected void f(l lVar) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        boolean zQ;
        o4.e eVar;
        if (this.f5108b) {
            return;
        }
        synchronized (this.f5109c) {
            this.f5107a.n(this.f5109c);
            zQ = this.f5109c.q();
        }
        if (zQ && this.f5112f) {
            this.f5107a.end();
        }
        if (!zQ || (eVar = this.f5110d) == null) {
            return;
        }
        eVar.a();
    }

    @Override // com.koushikdutta.async.p
    public f a() {
        return this.f5107a.a();
    }

    public boolean e() {
        return this.f5109c.p() || this.f5108b;
    }

    public void g(p pVar) {
        this.f5107a = pVar;
        pVar.p(new o4.e() { // from class: com.koushikdutta.async.j
            @Override // o4.e
            public final void a() {
                this.f5106a.k();
            }
        });
    }

    public void h(int i10) {
        this.f5111e = i10;
    }

    @Override // com.koushikdutta.async.p
    public void i(o4.a aVar) {
        this.f5107a.i(aVar);
    }

    @Override // com.koushikdutta.async.p
    public o4.e l() {
        return this.f5110d;
    }

    @Override // com.koushikdutta.async.p
    public void p(o4.e eVar) {
        this.f5110d = eVar;
    }

    public k(p pVar) {
        g(pVar);
    }

    @Override // com.koushikdutta.async.p
    public void n(l lVar) {
        if (a().f() != Thread.currentThread()) {
            synchronized (this.f5109c) {
                try {
                    if (this.f5109c.A() >= this.f5111e) {
                        return;
                    }
                    f(lVar);
                    lVar.f(this.f5109c);
                    a().n(new Runnable() { // from class: com.koushikdutta.async.i
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f5105a.k();
                        }
                    });
                    return;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        f(lVar);
        if (!e()) {
            this.f5107a.n(lVar);
        }
        synchronized (this.f5109c) {
            lVar.f(this.f5109c);
        }
    }
}
