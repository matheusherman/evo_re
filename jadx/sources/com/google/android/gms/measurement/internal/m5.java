package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
abstract class m5 extends v2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3804b;

    protected abstract boolean y();

    public final void A() {
        if (this.f3804b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (y()) {
            return;
        }
        this.f3965a.p();
        this.f3804b = true;
    }

    public final void B() {
        if (this.f3804b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        C();
        this.f3965a.p();
        this.f3804b = true;
    }

    final boolean x() {
        return this.f3804b;
    }

    m5(s6 s6Var) {
        super(s6Var);
        this.f3965a.q();
    }

    protected final void z() {
        if (x()) {
        } else {
            throw new IllegalStateException("Not initialized");
        }
    }

    @WorkerThread
    protected void C() {
    }
}
