package k1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f12085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ z f12086b;

    w(z zVar, int i10) {
        this.f12086b = zVar;
        this.f12085a = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12086b.l(this.f12085a);
    }
}
