package p6;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {

    /* JADX INFO: renamed from: p6.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class C0333a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final byte[] f17352g;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        static final C0333a f17355j;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f17356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f17357b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f17358c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f17359d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final char[] f17350e = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final char[] f17351f = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        static final C0333a f17353h = new C0333a(false, null, -1, true);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        static final C0333a f17354i = new C0333a(true, null, -1, true);

        public byte[] a(byte[] bArr) {
            int iD = d(bArr.length);
            byte[] bArr2 = new byte[iD];
            int iB = b(bArr, 0, bArr.length, bArr2);
            return iB != iD ? Arrays.copyOf(bArr2, iB) : bArr2;
        }

        static {
            byte[] bArr = {13, 10};
            f17352g = bArr;
            f17355j = new C0333a(false, bArr, 76, true);
        }

        private int b(byte[] bArr, int i10, int i11, byte[] bArr2) {
            char[] cArr = this.f17358c ? f17351f : f17350e;
            int i12 = ((i11 - i10) / 3) * 3;
            int i13 = i10 + i12;
            int i14 = this.f17357b;
            if (i14 > 0 && i12 > (i14 / 4) * 3) {
                i12 = (i14 / 4) * 3;
            }
            int i15 = i10;
            int i16 = 0;
            while (i15 < i13) {
                int iMin = Math.min(i15 + i12, i13);
                int i17 = i15;
                int i18 = i16;
                while (i17 < iMin) {
                    int i19 = i17 + 2;
                    int i20 = ((bArr[i17 + 1] & 255) << 8) | ((bArr[i17] & 255) << 16);
                    i17 += 3;
                    int i21 = i20 | (bArr[i19] & 255);
                    bArr2[i18] = (byte) cArr[(i21 >>> 18) & 63];
                    bArr2[i18 + 1] = (byte) cArr[(i21 >>> 12) & 63];
                    int i22 = i18 + 3;
                    bArr2[i18 + 2] = (byte) cArr[(i21 >>> 6) & 63];
                    i18 += 4;
                    bArr2[i22] = (byte) cArr[i21 & 63];
                }
                int i23 = ((iMin - i15) / 3) * 4;
                i16 += i23;
                if (i23 == this.f17357b && iMin < i11) {
                    byte[] bArr3 = this.f17356a;
                    int length = bArr3.length;
                    int i24 = 0;
                    while (i24 < length) {
                        bArr2[i16] = bArr3[i24];
                        i24++;
                        i16++;
                    }
                }
                i15 = iMin;
            }
            if (i15 >= i11) {
                return i16;
            }
            int i25 = i15 + 1;
            int i26 = bArr[i15] & 255;
            int i27 = i16 + 1;
            bArr2[i16] = (byte) cArr[i26 >> 2];
            if (i25 == i11) {
                int i28 = i16 + 2;
                bArr2[i27] = (byte) cArr[(i26 << 4) & 63];
                if (!this.f17359d) {
                    return i28;
                }
                int i29 = i16 + 3;
                bArr2[i28] = 61;
                int i30 = i16 + 4;
                bArr2[i29] = 61;
                return i30;
            }
            int i31 = bArr[i25] & 255;
            bArr2[i27] = (byte) cArr[((i26 << 4) & 63) | (i31 >> 4)];
            int i32 = i16 + 3;
            bArr2[i16 + 2] = (byte) cArr[(i31 << 2) & 63];
            if (!this.f17359d) {
                return i32;
            }
            int i33 = i16 + 4;
            bArr2[i32] = 61;
            return i33;
        }

        private final int d(int i10) {
            int i11;
            if (this.f17359d) {
                i11 = ((i10 + 2) / 3) * 4;
            } else {
                int i12 = i10 % 3;
                i11 = ((i10 / 3) * 4) + (i12 == 0 ? 0 : i12 + 1);
            }
            int i13 = this.f17357b;
            return i13 > 0 ? i11 + (((i11 - 1) / i13) * this.f17356a.length) : i11;
        }

        private C0333a(boolean z10, byte[] bArr, int i10, boolean z11) {
            this.f17358c = z10;
            this.f17356a = bArr;
            this.f17357b = i10;
            this.f17359d = z11;
        }

        public String c(byte[] bArr) {
            byte[] bArrA = a(bArr);
            return new String(bArrA, 0, 0, bArrA.length);
        }
    }

    public static C0333a a() {
        return C0333a.f17353h;
    }
}
