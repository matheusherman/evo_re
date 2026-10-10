package fc;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class d1 extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e0 f10130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f10131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f10132c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10133d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d f10134e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private InputStream f10135f;

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f10135f == null) {
            if (!this.f10132c) {
                return -1;
            }
            d dVarA = a();
            this.f10134e = dVarA;
            if (dVarA == null) {
                return -1;
            }
            this.f10132c = false;
            this.f10135f = dVarA.g();
        }
        while (true) {
            int i10 = this.f10135f.read();
            if (i10 >= 0) {
                return i10;
            }
            this.f10133d = this.f10134e.h();
            d dVarA2 = a();
            this.f10134e = dVarA2;
            if (dVarA2 == null) {
                this.f10135f = null;
                return -1;
            }
            this.f10135f = dVarA2.g();
        }
    }

    private d a() throws IOException {
        f fVarG = this.f10130a.g();
        if (fVarG == null) {
            if (!this.f10131b || this.f10133d == 0) {
                return null;
            }
            throw new IOException("expected octet-aligned bitstring, but found padBits: " + this.f10133d);
        }
        if (fVarG instanceof d) {
            if (this.f10133d == 0) {
                return (d) fVarG;
            }
            throw new IOException("only the last nested bitstring can have padding");
        }
        throw new IOException("unknown object encountered: " + fVarG.getClass());
    }

    int b() {
        return this.f10133d;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = 0;
        if (this.f10135f == null) {
            if (!this.f10132c) {
                return -1;
            }
            d dVarA = a();
            this.f10134e = dVarA;
            if (dVarA == null) {
                return -1;
            }
            this.f10132c = false;
            this.f10135f = dVarA.g();
        }
        while (true) {
            int i13 = this.f10135f.read(bArr, i10 + i12, i11 - i12);
            if (i13 >= 0) {
                i12 += i13;
                if (i12 == i11) {
                    return i12;
                }
            } else {
                this.f10133d = this.f10134e.h();
                d dVarA2 = a();
                this.f10134e = dVarA2;
                if (dVarA2 == null) {
                    this.f10135f = null;
                    if (i12 < 1) {
                        return -1;
                    }
                    return i12;
                }
                this.f10135f = dVarA2.g();
            }
        }
    }

    d1(e0 e0Var, boolean z10) {
        this.f10130a = e0Var;
        this.f10131b = z10;
    }
}
