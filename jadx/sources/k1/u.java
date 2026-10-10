package k1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class u implements c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f12077a;

    u(e eVar) {
        this.f12077a = eVar;
    }

    @Override // k1.c.a
    public final void a(boolean z10) {
        e eVar = this.f12077a;
        eVar.f12021n.sendMessage(eVar.f12021n.obtainMessage(1, Boolean.valueOf(z10)));
    }
}
