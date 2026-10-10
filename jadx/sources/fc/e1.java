package fc;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class e1 extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e0 f10143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f10144b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private InputStream f10145c;

    @Override // java.io.InputStream
    public int read() throws IOException {
        w wVarA;
        if (this.f10145c == null) {
            if (!this.f10144b || (wVarA = a()) == null) {
                return -1;
            }
            this.f10144b = false;
            this.f10145c = wVarA.e();
        }
        while (true) {
            int i10 = this.f10145c.read();
            if (i10 >= 0) {
                return i10;
            }
            w wVarA2 = a();
            if (wVarA2 == null) {
                this.f10145c = null;
                return -1;
            }
            this.f10145c = wVarA2.e();
        }
    }

    private w a() throws IOException {
        f fVarG = this.f10143a.g();
        if (fVarG == null) {
            return null;
        }
        if (fVarG instanceof w) {
            return (w) fVarG;
        }
        throw new IOException("unknown object encountered: " + fVarG.getClass());
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        w wVarA;
        int i12 = 0;
        if (this.f10145c == null) {
            if (!this.f10144b || (wVarA = a()) == null) {
                return -1;
            }
            this.f10144b = false;
            this.f10145c = wVarA.e();
        }
        while (true) {
            int i13 = this.f10145c.read(bArr, i10 + i12, i11 - i12);
            if (i13 >= 0) {
                i12 += i13;
                if (i12 == i11) {
                    return i12;
                }
            } else {
                w wVarA2 = a();
                if (wVarA2 == null) {
                    this.f10145c = null;
                    if (i12 < 1) {
                        return -1;
                    }
                    return i12;
                }
                this.f10145c = wVarA2.e();
            }
        }
    }

    e1(e0 e0Var) {
        this.f10143a = e0Var;
    }
}
