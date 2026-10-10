package fc;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class o2 extends t2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final byte[] f10202e = new byte[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f10203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10204d;

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f10204d == 0) {
            return -1;
        }
        int i10 = this.f10227a.read();
        if (i10 >= 0) {
            int i11 = this.f10204d - 1;
            this.f10204d = i11;
            if (i11 == 0) {
                b(true);
            }
            return i10;
        }
        throw new EOFException("DEF length " + this.f10203c + " object truncated by " + this.f10204d);
    }

    int c() {
        return this.f10204d;
    }

    void d(byte[] bArr) throws IOException {
        int i10 = this.f10204d;
        if (i10 != bArr.length) {
            throw new IllegalArgumentException("buffer length not right for data");
        }
        if (i10 == 0) {
            return;
        }
        int iA = a();
        int i11 = this.f10204d;
        if (i11 >= iA) {
            throw new IOException("corrupted stream - out of bounds length found: " + this.f10204d + " >= " + iA);
        }
        int iD = i11 - te.a.d(this.f10227a, bArr, 0, bArr.length);
        this.f10204d = iD;
        if (iD == 0) {
            b(true);
            return;
        }
        throw new EOFException("DEF length " + this.f10203c + " object truncated by " + this.f10204d);
    }

    byte[] f() throws IOException {
        if (this.f10204d == 0) {
            return f10202e;
        }
        int iA = a();
        int i10 = this.f10204d;
        if (i10 >= iA) {
            throw new IOException("corrupted stream - out of bounds length found: " + this.f10204d + " >= " + iA);
        }
        byte[] bArr = new byte[i10];
        int iD = i10 - te.a.d(this.f10227a, bArr, 0, i10);
        this.f10204d = iD;
        if (iD == 0) {
            b(true);
            return bArr;
        }
        throw new EOFException("DEF length " + this.f10203c + " object truncated by " + this.f10204d);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = this.f10204d;
        if (i12 == 0) {
            return -1;
        }
        int i13 = this.f10227a.read(bArr, i10, Math.min(i11, i12));
        if (i13 >= 0) {
            int i14 = this.f10204d - i13;
            this.f10204d = i14;
            if (i14 == 0) {
                b(true);
            }
            return i13;
        }
        throw new EOFException("DEF length " + this.f10203c + " object truncated by " + this.f10204d);
    }

    o2(InputStream inputStream, int i10, int i11) {
        super(inputStream, i11);
        if (i10 <= 0) {
            if (i10 >= 0) {
                b(true);
            } else {
                throw new IllegalArgumentException("negative lengths not allowed");
            }
        }
        this.f10203c = i10;
        this.f10204d = i10;
    }
}
