package se;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final byte[] f18639a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final byte[] f18640b = new byte[128];

    public int c(byte[] bArr, int i10, int i11, OutputStream outputStream) throws IOException {
        if (i11 < 0) {
            return 0;
        }
        byte[] bArr2 = new byte[72];
        int i12 = i10;
        int i13 = i11;
        while (i13 > 0) {
            int iMin = Math.min(36, i13);
            byte[] bArr3 = bArr;
            outputStream.write(bArr2, 0, d(bArr3, i12, iMin, bArr2, 0));
            i12 += iMin;
            i13 -= iMin;
            bArr = bArr3;
        }
        return i11 * 2;
    }

    public int d(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        int i13 = i11 + i10;
        int i14 = i12;
        while (i10 < i13) {
            int i15 = i10 + 1;
            byte b10 = bArr[i10];
            int i16 = i14 + 1;
            byte[] bArr3 = this.f18639a;
            bArr2[i14] = bArr3[(b10 & 255) >>> 4];
            i14 += 2;
            bArr2[i16] = bArr3[b10 & 15];
            i10 = i15;
        }
        return i14 - i12;
    }

    protected void f() {
        int i10 = 0;
        int i11 = 0;
        while (true) {
            byte[] bArr = this.f18640b;
            if (i11 >= bArr.length) {
                break;
            }
            bArr[i11] = -1;
            i11++;
        }
        while (true) {
            byte[] bArr2 = this.f18639a;
            if (i10 >= bArr2.length) {
                byte[] bArr3 = this.f18640b;
                bArr3[65] = bArr3[97];
                bArr3[66] = bArr3[98];
                bArr3[67] = bArr3[99];
                bArr3[68] = bArr3[100];
                bArr3[69] = bArr3[101];
                bArr3[70] = bArr3[102];
                return;
            }
            this.f18640b[bArr2[i10]] = (byte) i10;
            i10++;
        }
    }

    private static boolean e(char c10) {
        return c10 == '\n' || c10 == '\r' || c10 == '\t' || c10 == ' ';
    }

    public int a(String str, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[36];
        int length = str.length();
        while (length > 0 && e(str.charAt(length - 1))) {
            length--;
        }
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < length) {
            while (i10 < length && e(str.charAt(i10))) {
                i10++;
            }
            int i13 = i10 + 1;
            byte b10 = this.f18640b[str.charAt(i10)];
            while (i13 < length && e(str.charAt(i13))) {
                i13++;
            }
            int i14 = i13 + 1;
            byte b11 = this.f18640b[str.charAt(i13)];
            if ((b10 | b11) < 0) {
                throw new IOException("invalid characters encountered in Hex string");
            }
            int i15 = i11 + 1;
            bArr[i11] = (byte) ((b10 << 4) | b11);
            if (i15 == 36) {
                outputStream.write(bArr);
                i11 = 0;
            } else {
                i11 = i15;
            }
            i12++;
            i10 = i14;
        }
        if (i11 > 0) {
            outputStream.write(bArr, 0, i11);
        }
        return i12;
    }

    byte[] b(String str, int i10, int i11) throws IOException {
        if (str == null) {
            throw new NullPointerException("'str' cannot be null");
        }
        if (i10 < 0 || i11 < 0 || i10 > str.length() - i11) {
            throw new IndexOutOfBoundsException("invalid offset and/or length specified");
        }
        if ((i11 & 1) != 0) {
            throw new IOException("a hexadecimal encoding must have an even number of characters");
        }
        int i12 = i11 >>> 1;
        byte[] bArr = new byte[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = i10 + 1;
            byte b10 = this.f18640b[str.charAt(i10)];
            i10 += 2;
            int i15 = (b10 << 4) | this.f18640b[str.charAt(i14)];
            if (i15 < 0) {
                throw new IOException("invalid characters encountered in Hex string");
            }
            bArr[i13] = (byte) i15;
        }
        return bArr;
    }

    public d() {
        f();
    }
}
