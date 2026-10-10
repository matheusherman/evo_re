package com.koushikdutta.async;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class o implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    o4.a f5125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    o4.b f5126c;

    @Override // com.koushikdutta.async.n
    public void e(o4.b bVar) {
        this.f5126c = bVar;
    }

    @Override // com.koushikdutta.async.n
    public final void k(o4.a aVar) {
        this.f5125b = aVar;
    }

    public final o4.a p() {
        return this.f5125b;
    }

    @Override // com.koushikdutta.async.n
    public o4.b u() {
        return this.f5126c;
    }

    protected void w(Exception exc) {
        if (this.f5124a) {
            return;
        }
        this.f5124a = true;
        if (p() != null) {
            p().c(exc);
        }
    }
}
