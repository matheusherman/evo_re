package fc;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class q2 extends t2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f10211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f10213e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f10214f;

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (c()) {
            return -1;
        }
        int i10 = this.f10227a.read();
        if (i10 < 0) {
            throw new EOFException();
        }
        int i11 = this.f10211c;
        this.f10211c = this.f10212d;
        this.f10212d = i10;
        return i11;
    }

    private boolean c() {
        if (!this.f10213e && this.f10214f && this.f10211c == 0 && this.f10212d == 0) {
            this.f10213e = true;
            b(true);
        }
        return this.f10213e;
    }

    void d(boolean z10) {
        this.f10214f = z10;
        c();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        if (this.f10214f || i11 < 3) {
            return super.read(bArr, i10, i11);
        }
        if (this.f10213e) {
            return -1;
        }
        int i12 = this.f10227a.read(bArr, i10 + 2, i11 - 2);
        if (i12 < 0) {
            throw new EOFException();
        }
        bArr[i10] = (byte) this.f10211c;
        bArr[i10 + 1] = (byte) this.f10212d;
        this.f10211c = this.f10227a.read();
        int i13 = this.f10227a.read();
        this.f10212d = i13;
        if (i13 >= 0) {
            return i12 + 2;
        }
        throw new EOFException();
    }

    q2(InputStream inputStream, int i10) throws IOException {
        super(inputStream, i10);
        this.f10213e = false;
        this.f10214f = true;
        this.f10211c = inputStream.read();
        int i11 = inputStream.read();
        this.f10212d = i11;
        if (i11 >= 0) {
            c();
            return;
        }
        throw new EOFException();
    }
}
