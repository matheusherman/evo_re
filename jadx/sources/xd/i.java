package xd;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
final class i extends o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f22087e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f22088f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f22089g;

    static /* synthetic */ class a {
    }

    protected static class b extends o.a<b> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f22090e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f22091f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f22092g;

        protected b() {
            super(1);
            this.f22090e = 0;
            this.f22091f = 0;
            this.f22092g = 0;
        }

        protected o l() {
            return new i(this, null);
        }

        protected b n(int i10) {
            this.f22090e = i10;
            return this;
        }

        protected b o(int i10) {
            this.f22091f = i10;
            return this;
        }

        protected b p(int i10) {
            this.f22092g = i10;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // xd.o.a
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public b e() {
            return this;
        }
    }

    private i(b bVar) {
        super(bVar);
        this.f22087e = bVar.f22090e;
        this.f22088f = bVar.f22091f;
        this.f22089g = bVar.f22092g;
    }

    /* synthetic */ i(b bVar, a aVar) {
        this(bVar);
    }

    protected int e() {
        return this.f22087e;
    }

    protected int f() {
        return this.f22088f;
    }

    protected int g() {
        return this.f22089g;
    }

    @Override // xd.o
    protected byte[] d() {
        byte[] bArrD = super.d();
        re.f.c(this.f22087e, bArrD, 16);
        re.f.c(this.f22088f, bArrD, 20);
        re.f.c(this.f22089g, bArrD, 24);
        return bArrD;
    }
}
