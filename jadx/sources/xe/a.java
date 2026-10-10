package xe;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class a implements Runnable, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f22186a = new k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f22187b;

    @Override // java.lang.Runnable
    public void run() {
        j jVarB = this.f22186a.b();
        if (jVarB == null) {
            throw new IllegalStateException("No pending post available");
        }
        this.f22187b.g(jVarB);
    }

    a(c cVar) {
        this.f22187b = cVar;
    }

    @Override // xe.l
    public void a(q qVar, Object obj) {
        this.f22186a.a(j.a(qVar, obj));
        this.f22187b.d().execute(this);
    }
}
