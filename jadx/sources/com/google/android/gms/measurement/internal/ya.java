package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class ya implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ b2.g f4239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ xa f4240b;

    ya(xa xaVar, b2.g gVar) {
        this.f4239a = gVar;
        this.f4240b = xaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f4240b) {
            try {
                this.f4240b.f4207a = false;
                if (!this.f4240b.f4209c.l0()) {
                    this.f4240b.f4209c.l().G().a("Connected to remote service");
                    this.f4240b.f4209c.F(this.f4239a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
