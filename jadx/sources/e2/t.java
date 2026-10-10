package e2;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f9851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ u f9852b;

    t(u uVar, g gVar) {
        this.f9852b = uVar;
        this.f9851a = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f9852b.f9854b) {
            try {
                u uVar = this.f9852b;
                if (uVar.f9855c != null) {
                    uVar.f9855c.a(this.f9851a.h());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
