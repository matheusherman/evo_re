package m4;

import android.graphics.Rect;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f15646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f15648c;

    public static byte[] e(byte[] bArr, int i10, int i11) {
        int i12 = i10 * i11;
        byte[] bArr2 = new byte[i12];
        int i13 = i12 - 1;
        for (int i14 = 0; i14 < i12; i14++) {
            bArr2[i13] = bArr[i14];
            i13--;
        }
        return bArr2;
    }

    public static byte[] f(byte[] bArr, int i10, int i11) {
        int i12 = i10 * i11;
        byte[] bArr2 = new byte[i12];
        int i13 = i12 - 1;
        for (int i14 = 0; i14 < i10; i14++) {
            for (int i15 = i11 - 1; i15 >= 0; i15--) {
                bArr2[i13] = bArr[(i15 * i10) + i14];
                i13--;
            }
        }
        return bArr2;
    }

    public static byte[] g(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[i10 * i11];
        int i12 = 0;
        for (int i13 = 0; i13 < i10; i13++) {
            for (int i14 = i11 - 1; i14 >= 0; i14--) {
                bArr2[i12] = bArr[(i14 * i10) + i13];
                i12++;
            }
        }
        return bArr2;
    }

    public byte[] b() {
        return this.f15646a;
    }

    public int c() {
        return this.f15648c;
    }

    public int d() {
        return this.f15647b;
    }

    public m h(int i10) {
        if (i10 == 90) {
            return new m(g(this.f15646a, this.f15647b, this.f15648c), this.f15648c, this.f15647b);
        }
        if (i10 != 180) {
            return i10 != 270 ? this : new m(f(this.f15646a, this.f15647b, this.f15648c), this.f15648c, this.f15647b);
        }
        return new m(e(this.f15646a, this.f15647b, this.f15648c), this.f15647b, this.f15648c);
    }

    public m(byte[] bArr, int i10, int i11) {
        this.f15646a = bArr;
        this.f15647b = i10;
        this.f15648c = i11;
    }

    public m a(Rect rect, int i10) {
        int iWidth = rect.width() / i10;
        int iHeight = rect.height() / i10;
        int i11 = rect.top;
        byte[] bArr = new byte[iWidth * iHeight];
        if (i10 == 1) {
            int i12 = (i11 * this.f15647b) + rect.left;
            for (int i13 = 0; i13 < iHeight; i13++) {
                System.arraycopy(this.f15646a, i12, bArr, i13 * iWidth, iWidth);
                i12 += this.f15647b;
            }
        } else {
            int i14 = (i11 * this.f15647b) + rect.left;
            for (int i15 = 0; i15 < iHeight; i15++) {
                int i16 = i15 * iWidth;
                int i17 = i14;
                for (int i18 = 0; i18 < iWidth; i18++) {
                    bArr[i16] = this.f15646a[i17];
                    i17 += i10;
                    i16++;
                }
                i14 += this.f15647b * i10;
            }
        }
        return new m(bArr, iWidth, iHeight);
    }
}
