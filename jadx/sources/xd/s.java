package xd;

import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class s extends q implements re.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final r f22129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f22130d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final byte[] f22131e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final byte[] f22132f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final byte[] f22133g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile long f22134h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile xd.b f22135i;

    static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final r f22136a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f22137b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f22138c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private byte[] f22139d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private byte[] f22140e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private byte[] f22141f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private byte[] f22142g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private xd.b f22143h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private byte[] f22144i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private x f22145j = null;

        public s k() {
            return new s(this, null);
        }

        public b m(long j10) {
            this.f22137b = j10;
            return this;
        }

        public b n(long j10) {
            this.f22138c = j10;
            return this;
        }

        public b(r rVar) {
            this.f22136a = rVar;
        }

        public b l(xd.b bVar) {
            if (bVar.b() == 0) {
                this.f22143h = new xd.b(bVar, (1 << this.f22136a.a()) - 1);
                return this;
            }
            this.f22143h = bVar;
            return this;
        }

        public b o(byte[] bArr) {
            this.f22141f = a0.c(bArr);
            return this;
        }

        public b p(byte[] bArr) {
            this.f22142g = a0.c(bArr);
            return this;
        }

        public b q(byte[] bArr) {
            this.f22140e = a0.c(bArr);
            return this;
        }

        public b r(byte[] bArr) {
            this.f22139d = a0.c(bArr);
            return this;
        }
    }

    private s(b bVar) {
        super(true, bVar.f22136a.e());
        r rVar = bVar.f22136a;
        this.f22129c = rVar;
        if (rVar == null) {
            throw new NullPointerException("params == null");
        }
        int iF = rVar.f();
        byte[] bArr = bVar.f22144i;
        if (bArr != null) {
            if (bVar.f22145j == null) {
                throw new NullPointerException("xmss == null");
            }
            int iA = rVar.a();
            int i10 = (iA + 7) / 8;
            this.f22134h = a0.a(bArr, 0, i10);
            if (!a0.l(iA, this.f22134h)) {
                throw new IllegalArgumentException("index out of bounds");
            }
            this.f22130d = a0.g(bArr, i10, iF);
            int i11 = i10 + iF;
            this.f22131e = a0.g(bArr, i11, iF);
            int i12 = i11 + iF;
            this.f22132f = a0.g(bArr, i12, iF);
            int i13 = i12 + iF;
            this.f22133g = a0.g(bArr, i13, iF);
            int i14 = i13 + iF;
            try {
                this.f22135i = ((xd.b) a0.f(a0.g(bArr, i14, bArr.length - i14), xd.b.class)).f(bVar.f22145j.g());
                return;
            } catch (IOException e10) {
                throw new IllegalArgumentException(e10.getMessage(), e10);
            } catch (ClassNotFoundException e11) {
                throw new IllegalArgumentException(e11.getMessage(), e11);
            }
        }
        this.f22134h = bVar.f22137b;
        byte[] bArr2 = bVar.f22139d;
        if (bArr2 == null) {
            this.f22130d = new byte[iF];
        } else {
            if (bArr2.length != iF) {
                throw new IllegalArgumentException("size of secretKeySeed needs to be equal size of digest");
            }
            this.f22130d = bArr2;
        }
        byte[] bArr3 = bVar.f22140e;
        if (bArr3 == null) {
            this.f22131e = new byte[iF];
        } else {
            if (bArr3.length != iF) {
                throw new IllegalArgumentException("size of secretKeyPRF needs to be equal size of digest");
            }
            this.f22131e = bArr3;
        }
        byte[] bArr4 = bVar.f22141f;
        if (bArr4 == null) {
            this.f22132f = new byte[iF];
        } else {
            if (bArr4.length != iF) {
                throw new IllegalArgumentException("size of publicSeed needs to be equal size of digest");
            }
            this.f22132f = bArr4;
        }
        byte[] bArr5 = bVar.f22142g;
        if (bArr5 == null) {
            this.f22133g = new byte[iF];
        } else {
            if (bArr5.length != iF) {
                throw new IllegalArgumentException("size of root needs to be equal size of digest");
            }
            this.f22133g = bArr5;
        }
        xd.b bVar2 = bVar.f22143h;
        if (bVar2 != null) {
            this.f22135i = bVar2;
        } else {
            if (!a0.l(rVar.a(), bVar.f22137b) || bArr4 == null || bArr2 == null) {
                bVar2 = new xd.b(bVar.f22138c + 1);
                this.f22135i = bVar2;
            } else {
                this.f22135i = new xd.b(rVar, bVar.f22137b, bArr4, bArr2);
            }
        }
        if (bVar.f22138c >= 0 && bVar.f22138c != this.f22135i.b()) {
            throw new IllegalArgumentException("maxIndex set but not reflected in state");
        }
    }

    public byte[] c() {
        byte[] bArrF;
        synchronized (this) {
            try {
                int iF = this.f22129c.f();
                int iA = (this.f22129c.a() + 7) / 8;
                byte[] bArr = new byte[iA + iF + iF + iF + iF];
                a0.e(bArr, a0.q(this.f22134h, iA), 0);
                a0.e(bArr, this.f22130d, iA);
                int i10 = iA + iF;
                a0.e(bArr, this.f22131e, i10);
                int i11 = i10 + iF;
                a0.e(bArr, this.f22132f, i11);
                a0.e(bArr, this.f22133g, i11 + iF);
                try {
                    bArrF = re.a.f(bArr, a0.p(this.f22135i));
                } catch (IOException e10) {
                    throw new IllegalStateException("error serializing bds state: " + e10.getMessage(), e10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArrF;
    }

    @Override // re.c
    public byte[] getEncoded() {
        byte[] bArrC;
        synchronized (this) {
            bArrC = c();
        }
        return bArrC;
    }

    /* synthetic */ s(b bVar, a aVar) {
        this(bVar);
    }

    public r b() {
        return this.f22129c;
    }
}
