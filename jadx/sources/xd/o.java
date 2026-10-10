package xd;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f22114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f22115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f22116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f22117d;

    protected static abstract class a<T extends a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f22118a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f22119b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f22120c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f22121d = 0;

        protected abstract T e();

        protected T f(int i10) {
            this.f22121d = i10;
            return (T) e();
        }

        protected T g(int i10) {
            this.f22119b = i10;
            return (T) e();
        }

        protected T h(long j10) {
            this.f22120c = j10;
            return (T) e();
        }

        protected a(int i10) {
            this.f22118a = i10;
        }
    }

    public final int a() {
        return this.f22117d;
    }

    protected final int b() {
        return this.f22114a;
    }

    protected final long c() {
        return this.f22115b;
    }

    protected byte[] d() {
        byte[] bArr = new byte[32];
        re.f.c(this.f22114a, bArr, 0);
        re.f.i(this.f22115b, bArr, 4);
        re.f.c(this.f22116c, bArr, 12);
        re.f.c(this.f22117d, bArr, 28);
        return bArr;
    }

    protected o(a aVar) {
        this.f22114a = aVar.f22119b;
        this.f22115b = aVar.f22120c;
        this.f22116c = aVar.f22118a;
        this.f22117d = aVar.f22121d;
    }
}
