package xd;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class t extends q implements re.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final r f22146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f22147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final byte[] f22148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final byte[] f22149f;

    static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final r f22150a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private byte[] f22151b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private byte[] f22152c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private byte[] f22153d = null;

        public t e() {
            return new t(this, null);
        }

        public b(r rVar) {
            this.f22150a = rVar;
        }

        public b f(byte[] bArr) {
            this.f22153d = a0.c(bArr);
            return this;
        }

        public b g(byte[] bArr) {
            this.f22152c = a0.c(bArr);
            return this;
        }

        public b h(byte[] bArr) {
            this.f22151b = a0.c(bArr);
            return this;
        }
    }

    private t(b bVar) {
        super(false, bVar.f22150a.e());
        r rVar = bVar.f22150a;
        this.f22146c = rVar;
        if (rVar == null) {
            throw new NullPointerException("params == null");
        }
        int iF = rVar.f();
        byte[] bArr = bVar.f22153d;
        if (bArr != null) {
            if (bArr.length == iF + iF) {
                this.f22147d = 0;
                this.f22148e = a0.g(bArr, 0, iF);
                this.f22149f = a0.g(bArr, iF, iF);
                return;
            } else {
                if (bArr.length != iF + 4 + iF) {
                    throw new IllegalArgumentException("public key has wrong size");
                }
                this.f22147d = re.f.a(bArr, 0);
                this.f22148e = a0.g(bArr, 4, iF);
                this.f22149f = a0.g(bArr, 4 + iF, iF);
                return;
            }
        }
        if (rVar.d() != null) {
            this.f22147d = rVar.d().a();
        } else {
            this.f22147d = 0;
        }
        byte[] bArr2 = bVar.f22151b;
        if (bArr2 == null) {
            this.f22148e = new byte[iF];
        } else {
            if (bArr2.length != iF) {
                throw new IllegalArgumentException("length of root must be equal to length of digest");
            }
            this.f22148e = bArr2;
        }
        byte[] bArr3 = bVar.f22152c;
        if (bArr3 == null) {
            this.f22149f = new byte[iF];
        } else {
            if (bArr3.length != iF) {
                throw new IllegalArgumentException("length of publicSeed must be equal to length of digest");
            }
            this.f22149f = bArr3;
        }
    }

    /* synthetic */ t(b bVar, a aVar) {
        this(bVar);
    }

    public r b() {
        return this.f22146c;
    }

    public byte[] c() {
        return a0.c(this.f22149f);
    }

    public byte[] d() {
        return a0.c(this.f22148e);
    }

    public byte[] e() {
        byte[] bArr;
        int iF = this.f22146c.f();
        int i10 = this.f22147d;
        int i11 = 0;
        if (i10 != 0) {
            bArr = new byte[iF + 4 + iF];
            re.f.c(i10, bArr, 0);
            i11 = 4;
        } else {
            bArr = new byte[iF + iF];
        }
        a0.e(bArr, this.f22148e, i11);
        a0.e(bArr, this.f22149f, i11 + iF);
        return bArr;
    }

    @Override // re.c
    public byte[] getEncoded() {
        return e();
    }
}
