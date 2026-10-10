package k1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ y f12089a;

    x(y yVar) {
        this.f12089a = yVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        z zVar = this.f12089a.f12092a;
        zVar.f12096b.c(zVar.f12096b.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
