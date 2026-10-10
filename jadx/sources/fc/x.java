package fc;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OutputStream f10247a;

    void l(f[] fVarArr) {
        for (f fVar : fVarArr) {
            fVar.f().n(this, true);
        }
    }

    void v(z[] zVarArr) {
        for (z zVar : zVarArr) {
            zVar.n(this, true);
        }
    }

    public static x a(OutputStream outputStream) {
        return new x(outputStream);
    }

    public static x b(OutputStream outputStream, String str) {
        if (str.equals("DER")) {
            return new s1(outputStream);
        }
        return str.equals("DL") ? new h2(outputStream) : new x(outputStream);
    }

    static int f(int i10) {
        if (i10 < 128) {
            return 1;
        }
        int i11 = 2;
        while (true) {
            i10 >>>= 8;
            if (i10 == 0) {
                return i11;
            }
            i11++;
        }
    }

    static int h(int i10) {
        if (i10 < 31) {
            return 1;
        }
        int i11 = 2;
        while (true) {
            i10 >>>= 7;
            if (i10 == 0) {
                return i11;
            }
            i11++;
        }
    }

    s1 d() {
        return new s1(this.f10247a);
    }

    h2 e() {
        return new h2(this.f10247a);
    }

    final void i(int i10) throws IOException {
        this.f10247a.write(i10);
    }

    final void j(byte[] bArr, int i10, int i11) throws IOException {
        this.f10247a.write(bArr, i10, i11);
    }

    final void k(int i10) throws IOException {
        if (i10 < 128) {
            i(i10);
            return;
        }
        int i11 = 5;
        byte[] bArr = new byte[5];
        while (true) {
            int i12 = i11 - 1;
            bArr[i12] = (byte) i10;
            i10 >>>= 8;
            if (i10 == 0) {
                int i13 = i11 - 2;
                bArr[i13] = (byte) ((5 - i12) | 128);
                j(bArr, i13, 6 - i12);
                return;
            }
            i11 = i12;
        }
    }

    final void s(boolean z10, int i10) throws IOException {
        if (z10) {
            i(i10);
        }
    }

    final void t(boolean z10, int i10, int i11) throws IOException {
        if (z10) {
            if (i11 < 31) {
                i(i10 | i11);
                return;
            }
            byte[] bArr = new byte[6];
            int i12 = 5;
            bArr[5] = (byte) (i11 & 127);
            while (i11 > 127) {
                i11 >>>= 7;
                i12--;
                bArr[i12] = (byte) ((i11 & 127) | 128);
            }
            int i13 = i12 - 1;
            bArr[i13] = (byte) (31 | i10);
            j(bArr, i13, 6 - i13);
        }
    }

    x(OutputStream outputStream) {
        this.f10247a = outputStream;
    }

    static int g(boolean z10, int i10) {
        return (z10 ? 1 : 0) + f(i10) + i10;
    }

    final void m(boolean z10, int i10, byte b10) throws IOException {
        s(z10, i10);
        k(1);
        i(b10);
    }

    final void n(boolean z10, int i10, byte b10, byte[] bArr, int i11, int i12) throws IOException {
        s(z10, i10);
        k(i12 + 1);
        i(b10);
        j(bArr, i11, i12);
    }

    final void o(boolean z10, int i10, byte[] bArr) {
        s(z10, i10);
        k(bArr.length);
        j(bArr, 0, bArr.length);
    }

    final void p(boolean z10, int i10, byte[] bArr, int i11, int i12) {
        s(z10, i10);
        k(i12);
        j(bArr, i11, i12);
    }

    final void q(boolean z10, int i10, byte[] bArr, int i11, int i12, byte b10) throws IOException {
        s(z10, i10);
        k(i12 + 1);
        j(bArr, i11, i12);
        i(b10);
    }

    final void r(boolean z10, int i10, f[] fVarArr) throws IOException {
        s(z10, i10);
        i(128);
        l(fVarArr);
        i(0);
        i(0);
    }

    void u(z zVar, boolean z10) {
        zVar.n(this, z10);
    }

    void c() {
    }
}
