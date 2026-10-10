package se;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final short[] f18641a = new short[128];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f18642b;

    public static int b(byte[] bArr, int i10, int i11, char[] cArr) {
        int i12 = i11 + i10;
        int i13 = 0;
        while (i10 < i12) {
            int i14 = i10 + 1;
            byte b10 = bArr[i10];
            if (b10 < 0) {
                short s10 = f18641a[b10 & 127];
                int i15 = s10 >>> 8;
                byte b11 = (byte) s10;
                while (b11 >= 0) {
                    if (i14 >= bArr.length) {
                        return -1;
                    }
                    int i16 = i14 + 1;
                    byte b12 = bArr[i14];
                    i15 = (i15 << 6) | (b12 & 63);
                    b11 = f18642b[b11 + ((b12 & 255) >>> 4)];
                    i14 = i16;
                }
                if (b11 == -2) {
                    return -1;
                }
                if (i15 <= 65535) {
                    if (i13 >= cArr.length) {
                        return -1;
                    }
                    cArr[i13] = (char) i15;
                    i13++;
                } else {
                    if (i13 >= cArr.length - 1) {
                        return -1;
                    }
                    int i17 = i13 + 1;
                    cArr[i13] = (char) ((i15 >>> 10) + 55232);
                    i13 += 2;
                    cArr[i17] = (char) ((i15 & 1023) | 56320);
                }
                i10 = i14;
            } else {
                if (i13 >= cArr.length) {
                    return -1;
                }
                cArr[i13] = (char) b10;
                i10 = i14;
                i13++;
            }
        }
        return i13;
    }

    public static int c(byte[] bArr, char[] cArr) {
        return b(bArr, 0, bArr.length, cArr);
    }

    static {
        byte[] bArr = new byte[112];
        f18642b = bArr;
        byte[] bArr2 = new byte[128];
        a(bArr2, 0, 15, (byte) 1);
        a(bArr2, 16, 31, (byte) 2);
        a(bArr2, 32, 63, (byte) 3);
        a(bArr2, 64, 65, (byte) 0);
        a(bArr2, 66, 95, (byte) 4);
        a(bArr2, 96, 96, (byte) 5);
        a(bArr2, 97, 108, (byte) 6);
        a(bArr2, 109, 109, (byte) 7);
        a(bArr2, 110, 111, (byte) 6);
        a(bArr2, 112, 112, (byte) 8);
        a(bArr2, 113, 115, (byte) 9);
        a(bArr2, 116, 116, (byte) 10);
        a(bArr2, 117, 127, (byte) 0);
        a(bArr, 0, bArr.length - 1, (byte) -2);
        a(bArr, 8, 11, (byte) -1);
        a(bArr, 24, 27, (byte) 0);
        a(bArr, 40, 43, (byte) 16);
        a(bArr, 58, 59, (byte) 0);
        a(bArr, 72, 73, (byte) 0);
        a(bArr, 89, 91, (byte) 16);
        a(bArr, 104, 104, (byte) 16);
        byte[] bArr3 = {0, 0, 0, 0, 31, 15, 15, 15, 7, 7, 7};
        byte[] bArr4 = {-2, -2, -2, -2, 0, 48, 16, 64, 80, 32, 96};
        for (int i10 = 0; i10 < 128; i10++) {
            byte b10 = bArr2[i10];
            f18641a[i10] = (short) (bArr4[b10] | ((bArr3[b10] & i10) << 8));
        }
    }

    private static void a(byte[] bArr, int i10, int i11, byte b10) {
        while (i10 <= i11) {
            bArr[i10] = b10;
            i10++;
        }
    }
}
