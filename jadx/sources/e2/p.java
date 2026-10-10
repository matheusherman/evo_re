package e2;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f9841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ q f9842b;

    p(q qVar, g gVar) {
        this.f9842b = qVar;
        this.f9841a = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f9842b.f9844b) {
            try {
                q qVar = this.f9842b;
                if (qVar.f9845c != null) {
                    qVar.f9845c.a(this.f9841a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
