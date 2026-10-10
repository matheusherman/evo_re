package com.koushikdutta.async;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class q extends o implements n, o4.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private n f5127d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f5128e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f5129f;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements o4.a {
        a() {
        }

        @Override // o4.a
        public void c(Exception exc) {
            q.this.w(exc);
        }
    }

    @Override // com.koushikdutta.async.n
    public void close() {
        this.f5129f = true;
        n nVar = this.f5127d;
        if (nVar != null) {
            nVar.close();
        }
    }

    @Override // com.koushikdutta.async.n, com.koushikdutta.async.p
    public f a() {
        return this.f5127d.a();
    }

    @Override // com.koushikdutta.async.n
    public String h() {
        n nVar = this.f5127d;
        if (nVar == null) {
            return null;
        }
        return nVar.h();
    }

    @Override // o4.b
    public void i(n nVar, l lVar) {
        if (this.f5129f) {
            lVar.z();
            return;
        }
        if (lVar != null) {
            this.f5128e += lVar.A();
        }
        y.a(this, lVar);
        if (lVar != null) {
            this.f5128e -= lVar.A();
        }
    }

    @Override // com.koushikdutta.async.n
    public boolean t() {
        return this.f5127d.t();
    }

    public void x(n nVar) {
        n nVar2 = this.f5127d;
        if (nVar2 != null) {
            nVar2.e(null);
        }
        this.f5127d = nVar;
        nVar.e(this);
        this.f5127d.k(new a());
    }
}
