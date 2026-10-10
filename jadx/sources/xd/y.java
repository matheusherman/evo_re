package xd;

import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class y extends p implements re.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final x f22163c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f22164d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final byte[] f22165e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final byte[] f22166f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final byte[] f22167g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile xd.a f22168h;

    static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final x f22169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f22170b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f22171c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private byte[] f22172d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private byte[] f22173e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private byte[] f22174f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private byte[] f22175g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private xd.a f22176h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private byte[] f22177i = null;

        public y j() {
            return new y(this, null);
        }

        public b k(xd.a aVar) {
            this.f22176h = aVar;
            return this;
        }

        public b l(int i10) {
            this.f22170b = i10;
            return this;
        }

        public b m(int i10) {
            this.f22171c = i10;
            return this;
        }

        public b(x xVar) {
            this.f22169a = xVar;
        }

        public b n(byte[] bArr) {
            this.f22174f = a0.c(bArr);
            return this;
        }

        public b o(byte[] bArr) {
            this.f22175g = a0.c(bArr);
            return this;
        }

        public b p(byte[] bArr) {
            this.f22173e = a0.c(bArr);
            return this;
        }

        public b q(byte[] bArr) {
            this.f22172d = a0.c(bArr);
            return this;
        }
    }

    private y(b bVar) {
        super(true, bVar.f22169a.f());
        x xVar = bVar.f22169a;
        this.f22163c = xVar;
        if (xVar == null) {
            throw new NullPointerException("params == null");
        }
        int iH = xVar.h();
        byte[] bArr = bVar.f22177i;
        if (bArr != null) {
            int iB = xVar.b();
            int iA = re.f.a(bArr, 0);
            if (!a0.l(iB, iA)) {
                throw new IllegalArgumentException("index out of bounds");
            }
            this.f22164d = a0.g(bArr, 4, iH);
            int i10 = 4 + iH;
            this.f22165e = a0.g(bArr, i10, iH);
            int i11 = i10 + iH;
            this.f22166f = a0.g(bArr, i11, iH);
            int i12 = i11 + iH;
            this.f22167g = a0.g(bArr, i12, iH);
            int i13 = i12 + iH;
            try {
                xd.a aVar = (xd.a) a0.f(a0.g(bArr, i13, bArr.length - i13), xd.a.class);
                if (aVar.b() != iA) {
                    throw new IllegalStateException("serialized BDS has wrong index");
                }
                this.f22168h = aVar.h(bVar.f22169a.g());
                return;
            } catch (IOException e10) {
                throw new IllegalArgumentException(e10.getMessage(), e10);
            } catch (ClassNotFoundException e11) {
                throw new IllegalArgumentException(e11.getMessage(), e11);
            }
        }
        byte[] bArr2 = bVar.f22172d;
        if (bArr2 == null) {
            this.f22164d = new byte[iH];
        } else {
            if (bArr2.length != iH) {
                throw new IllegalArgumentException("size of secretKeySeed needs to be equal size of digest");
            }
            this.f22164d = bArr2;
        }
        byte[] bArr3 = bVar.f22173e;
        if (bArr3 == null) {
            this.f22165e = new byte[iH];
        } else {
            if (bArr3.length != iH) {
                throw new IllegalArgumentException("size of secretKeyPRF needs to be equal size of digest");
            }
            this.f22165e = bArr3;
        }
        byte[] bArr4 = bVar.f22174f;
        if (bArr4 == null) {
            this.f22166f = new byte[iH];
        } else {
            if (bArr4.length != iH) {
                throw new IllegalArgumentException("size of publicSeed needs to be equal size of digest");
            }
            this.f22166f = bArr4;
        }
        byte[] bArr5 = bVar.f22175g;
        if (bArr5 == null) {
            this.f22167g = new byte[iH];
        } else {
            if (bArr5.length != iH) {
                throw new IllegalArgumentException("size of root needs to be equal size of digest");
            }
            this.f22167g = bArr5;
        }
        xd.a aVar2 = bVar.f22176h;
        if (aVar2 != null) {
            this.f22168h = aVar2;
        } else if (bVar.f22170b >= (1 << xVar.b()) - 2 || bArr4 == null || bArr2 == null) {
            aVar2 = new xd.a(xVar, (1 << xVar.b()) - 1, bVar.f22170b);
            this.f22168h = aVar2;
        } else {
            this.f22168h = new xd.a(xVar, bArr4, bArr2, (j) new j.b().l(), bVar.f22170b);
        }
        if (bVar.f22171c >= 0 && bVar.f22171c != this.f22168h.c()) {
            throw new IllegalArgumentException("maxIndex set but not reflected in state");
        }
    }

    public byte[] c() {
        byte[] bArrF;
        synchronized (this) {
            try {
                int iH = this.f22163c.h();
                byte[] bArr = new byte[iH + 4 + iH + iH + iH];
                re.f.c(this.f22168h.b(), bArr, 0);
                a0.e(bArr, this.f22164d, 4);
                int i10 = 4 + iH;
                a0.e(bArr, this.f22165e, i10);
                int i11 = i10 + iH;
                a0.e(bArr, this.f22166f, i11);
                a0.e(bArr, this.f22167g, i11 + iH);
                try {
                    bArrF = re.a.f(bArr, a0.p(this.f22168h));
                } catch (IOException e10) {
                    throw new RuntimeException("error serializing bds state: " + e10.getMessage());
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

    /* synthetic */ y(b bVar, a aVar) {
        this(bVar);
    }

    public x b() {
        return this.f22163c;
    }
}
