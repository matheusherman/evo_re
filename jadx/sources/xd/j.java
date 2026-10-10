package xd;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
final class j extends o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f22093e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f22094f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f22095g;

    static /* synthetic */ class a {
    }

    protected static class b extends o.a<b> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f22096e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f22097f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f22098g;

        protected b() {
            super(0);
            this.f22096e = 0;
            this.f22097f = 0;
            this.f22098g = 0;
        }

        protected o l() {
            return new j(this, null);
        }

        protected b n(int i10) {
            this.f22097f = i10;
            return this;
        }

        protected b o(int i10) {
            this.f22098g = i10;
            return this;
        }

        protected b p(int i10) {
            this.f22096e = i10;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // xd.o.a
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public b e() {
            return this;
        }
    }

    private j(b bVar) {
        super(bVar);
        this.f22093e = bVar.f22096e;
        this.f22094f = bVar.f22097f;
        this.f22095g = bVar.f22098g;
    }

    /* synthetic */ j(b bVar, a aVar) {
        this(bVar);
    }

    protected int e() {
        return this.f22094f;
    }

    protected int f() {
        return this.f22095g;
    }

    protected int g() {
        return this.f22093e;
    }

    @Override // xd.o
    protected byte[] d() {
        byte[] bArrD = super.d();
        re.f.c(this.f22093e, bArrD, 16);
        re.f.c(this.f22094f, bArrD, 20);
        re.f.c(this.f22095g, bArrD, 24);
        return bArrD;
    }
}
