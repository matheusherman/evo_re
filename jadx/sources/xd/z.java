package xd;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class z extends p implements re.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final x f22178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f22179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final byte[] f22180e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final byte[] f22181f;

    static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final x f22182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private byte[] f22183b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private byte[] f22184c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private byte[] f22185d = null;

        public z e() {
            return new z(this, null);
        }

        public b(x xVar) {
            this.f22182a = xVar;
        }

        public b f(byte[] bArr) {
            this.f22185d = a0.c(bArr);
            return this;
        }

        public b g(byte[] bArr) {
            this.f22184c = a0.c(bArr);
            return this;
        }

        public b h(byte[] bArr) {
            this.f22183b = a0.c(bArr);
            return this;
        }
    }

    private z(b bVar) {
        super(false, bVar.f22182a.f());
        x xVar = bVar.f22182a;
        this.f22178c = xVar;
        if (xVar == null) {
            throw new NullPointerException("params == null");
        }
        int iH = xVar.h();
        byte[] bArr = bVar.f22185d;
        if (bArr != null) {
            if (bArr.length == iH + iH) {
                this.f22179d = 0;
                this.f22180e = a0.g(bArr, 0, iH);
                this.f22181f = a0.g(bArr, iH, iH);
                return;
            } else {
                if (bArr.length != iH + 4 + iH) {
                    throw new IllegalArgumentException("public key has wrong size");
                }
                this.f22179d = re.f.a(bArr, 0);
                this.f22180e = a0.g(bArr, 4, iH);
                this.f22181f = a0.g(bArr, 4 + iH, iH);
                return;
            }
        }
        if (xVar.e() != null) {
            this.f22179d = xVar.e().a();
        } else {
            this.f22179d = 0;
        }
        byte[] bArr2 = bVar.f22183b;
        if (bArr2 == null) {
            this.f22180e = new byte[iH];
        } else {
            if (bArr2.length != iH) {
                throw new IllegalArgumentException("length of root must be equal to length of digest");
            }
            this.f22180e = bArr2;
        }
        byte[] bArr3 = bVar.f22184c;
        if (bArr3 == null) {
            this.f22181f = new byte[iH];
        } else {
            if (bArr3.length != iH) {
                throw new IllegalArgumentException("length of publicSeed must be equal to length of digest");
            }
            this.f22181f = bArr3;
        }
    }

    /* synthetic */ z(b bVar, a aVar) {
        this(bVar);
    }

    public x b() {
        return this.f22178c;
    }

    public byte[] c() {
        return a0.c(this.f22181f);
    }

    public byte[] d() {
        return a0.c(this.f22180e);
    }

    public byte[] e() {
        byte[] bArr;
        int iH = this.f22178c.h();
        int i10 = this.f22179d;
        int i11 = 0;
        if (i10 != 0) {
            bArr = new byte[iH + 4 + iH];
            re.f.c(i10, bArr, 0);
            i11 = 4;
        } else {
            bArr = new byte[iH + iH];
        }
        a0.e(bArr, this.f22180e, i11);
        a0.e(bArr, this.f22181f, i11 + iH);
        return bArr;
    }

    @Override // re.c
    public byte[] getEncoded() {
        return e();
    }
}
