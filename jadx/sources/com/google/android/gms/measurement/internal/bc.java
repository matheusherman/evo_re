package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class bc extends yb {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f3429c;

    protected abstract boolean y();

    public final void w() {
        if (this.f3429c) {
            throw new IllegalStateException("Can't initialize twice");
        }
        y();
        this.f4241b.R0();
        this.f3429c = true;
    }

    final boolean x() {
        return this.f3429c;
    }

    bc(gc gcVar) {
        super(gcVar);
        this.f4241b.S0();
    }

    protected final void v() {
        if (x()) {
        } else {
            throw new IllegalStateException("Not initialized");
        }
    }
}
