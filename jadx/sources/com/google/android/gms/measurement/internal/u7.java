package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
abstract class u7 extends r7 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f4091b;

    protected abstract boolean u();

    public final void r() {
        if (this.f4091b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (u()) {
            return;
        }
        this.f3965a.p();
        this.f4091b = true;
    }

    public final void s() {
        if (this.f4091b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        o();
        this.f3965a.p();
        this.f4091b = true;
    }

    final boolean t() {
        return this.f4091b;
    }

    u7(s6 s6Var) {
        super(s6Var);
        this.f3965a.q();
    }

    protected final void q() {
        if (t()) {
        } else {
            throw new IllegalStateException("Not initialized");
        }
    }

    protected void o() {
    }
}
