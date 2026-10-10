package e2;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ o f9837a;

    n(o oVar) {
        this.f9837a = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f9837a.f9839b) {
            try {
                o oVar = this.f9837a;
                if (oVar.f9840c != null) {
                    oVar.f9840c.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
