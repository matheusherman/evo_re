package td;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected b f19187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected c f19188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected a f19189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private h f19190d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private i f19191e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f19192f;

    /* JADX WARN: Code duplicated, block: B:18:0x0040  */
    public j(int i10, boolean z10) {
        b dVar;
        this.f19192f = z10;
        if (i10 != 434) {
            if (i10 != 503) {
                if (i10 != 610) {
                    if (i10 == 751) {
                        dVar = new g(z10);
                    }
                    this.f19189c = new a(this);
                    this.f19188b = new c(this);
                    if (z10) {
                        this.f19191e = new i(this);
                    }
                    this.f19190d = new h(this);
                }
                dVar = new f(z10);
            } else {
                dVar = new e(z10);
            }
        } else {
            dVar = new d(z10);
        }
        this.f19187a = dVar;
        this.f19189c = new a(this);
        this.f19188b = new c(this);
        if (z10) {
            this.f19191e = new i(this);
        }
        this.f19190d = new h(this);
    }
}
