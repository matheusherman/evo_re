package xd;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
final class g extends o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f22080e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f22081f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f22082g;

    static /* synthetic */ class a {
    }

    protected static class b extends o.a<b> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f22083e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f22084f;

        protected b() {
            super(2);
            this.f22083e = 0;
            this.f22084f = 0;
        }

        protected o k() {
            return new g(this, null);
        }

        protected b m(int i10) {
            this.f22083e = i10;
            return this;
        }

        protected b n(int i10) {
            this.f22084f = i10;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // xd.o.a
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public b e() {
            return this;
        }
    }

    private g(b bVar) {
        super(bVar);
        this.f22080e = 0;
        this.f22081f = bVar.f22083e;
        this.f22082g = bVar.f22084f;
    }

    /* synthetic */ g(b bVar, a aVar) {
        this(bVar);
    }

    protected int e() {
        return this.f22081f;
    }

    protected int f() {
        return this.f22082g;
    }

    @Override // xd.o
    protected byte[] d() {
        byte[] bArrD = super.d();
        re.f.c(this.f22080e, bArrD, 16);
        re.f.c(this.f22081f, bArrD, 20);
        re.f.c(this.f22082g, bArrD, 24);
        return bArrD;
    }
}
