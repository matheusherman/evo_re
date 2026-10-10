package sd;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f18590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f18591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f18592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f18593d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f18594e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final b f18595f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final g f18596g;

    public a(b bVar) {
        this.f18595f = bVar;
        this.f18594e = bVar.d();
        int iE = bVar.e();
        this.f18593d = iE;
        this.f18590a = iE << 1;
        int i10 = iE >> 2;
        this.f18591b = i10;
        this.f18592c = (i10 * 2) - 1;
        this.f18596g = bVar.g();
    }
}
