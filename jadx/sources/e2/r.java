package e2;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f9846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ s f9847b;

    r(s sVar, g gVar) {
        this.f9847b = sVar;
        this.f9846a = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f9847b.f9849b) {
            try {
                s sVar = this.f9847b;
                if (sVar.f9850c != null) {
                    sVar.f9850c.c((Exception) m1.g.k(this.f9846a.g()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
