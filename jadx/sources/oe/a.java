package oe;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class a extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int[][] f16564c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f16565d;

    public a(int i10, int[][] iArr) {
        int[] iArr2 = iArr[0];
        if (iArr2.length != ((i10 + 31) >> 5)) {
            throw new ArithmeticException("Int array does not match given number of columns.");
        }
        this.f16576b = i10;
        this.f16575a = iArr.length;
        this.f16565d = iArr2.length;
        int i11 = i10 & 31;
        int i12 = i11 == 0 ? -1 : (1 << i11) - 1;
        for (int i13 = 0; i13 < this.f16575a; i13++) {
            int[] iArr3 = iArr[i13];
            int i14 = this.f16565d - 1;
            iArr3[i14] = iArr3[i14] & i12;
        }
        this.f16564c = iArr;
    }

    public a(a aVar) {
        this.f16576b = aVar.a();
        this.f16575a = aVar.b();
        this.f16565d = aVar.f16565d;
        this.f16564c = new int[aVar.f16564c.length][];
        int i10 = 0;
        while (true) {
            int[][] iArr = this.f16564c;
            if (i10 >= iArr.length) {
                return;
            }
            iArr[i10] = d.a(aVar.f16564c[i10]);
            i10++;
        }
    }

    public byte[] c() {
        int i10 = (this.f16576b + 7) >>> 3;
        int i11 = this.f16575a;
        int i12 = 8;
        byte[] bArr = new byte[(i10 * i11) + 8];
        f.a(i11, bArr, 0);
        f.a(this.f16576b, bArr, 4);
        int i13 = this.f16576b;
        int i14 = i13 >>> 5;
        int i15 = i13 & 31;
        for (int i16 = 0; i16 < this.f16575a; i16++) {
            int i17 = 0;
            while (i17 < i14) {
                f.a(this.f16564c[i16][i17], bArr, i12);
                i17++;
                i12 += 4;
            }
            int i18 = 0;
            while (i18 < i15) {
                bArr[i12] = (byte) ((this.f16564c[i16][i14] >>> i18) & 255);
                i18 += 8;
                i12++;
            }
        }
        return bArr;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f16575a != aVar.f16575a || this.f16576b != aVar.f16576b || this.f16565d != aVar.f16565d) {
            return false;
        }
        for (int i10 = 0; i10 < this.f16575a; i10++) {
            if (!d.b(this.f16564c[i10], aVar.f16564c[i10])) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int iO = (((this.f16575a * 31) + this.f16576b) * 31) + this.f16565d;
        for (int i10 = 0; i10 < this.f16575a; i10++) {
            iO = (iO * 31) + re.a.o(this.f16564c[i10]);
        }
        return iO;
    }

    public String toString() {
        int i10 = this.f16576b & 31;
        int i11 = this.f16565d;
        if (i10 != 0) {
            i11--;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i12 = 0; i12 < this.f16575a; i12++) {
            stringBuffer.append(i12 + ": ");
            for (int i13 = 0; i13 < i11; i13++) {
                int i14 = this.f16564c[i12][i13];
                for (int i15 = 0; i15 < 32; i15++) {
                    if (((i14 >>> i15) & 1) == 0) {
                        stringBuffer.append('0');
                    } else {
                        stringBuffer.append('1');
                    }
                }
                stringBuffer.append(' ');
            }
            int i16 = this.f16564c[i12][this.f16565d - 1];
            for (int i17 = 0; i17 < i10; i17++) {
                if (((i16 >>> i17) & 1) == 0) {
                    stringBuffer.append('0');
                } else {
                    stringBuffer.append('1');
                }
            }
            stringBuffer.append('\n');
        }
        return stringBuffer.toString();
    }

    public a(byte[] bArr) {
        if (bArr.length < 9) {
            throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
        }
        this.f16575a = f.e(bArr, 0);
        int iE = f.e(bArr, 4);
        this.f16576b = iE;
        int i10 = this.f16575a;
        int i11 = ((iE + 7) >>> 3) * i10;
        if (i10 > 0) {
            int i12 = 8;
            if (i11 == bArr.length - 8) {
                int i13 = (iE + 31) >>> 5;
                this.f16565d = i13;
                this.f16564c = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i10, i13);
                int i14 = this.f16576b;
                int i15 = i14 >> 5;
                int i16 = i14 & 31;
                for (int i17 = 0; i17 < this.f16575a; i17++) {
                    int i18 = 0;
                    while (i18 < i15) {
                        this.f16564c[i17][i18] = f.e(bArr, i12);
                        i18++;
                        i12 += 4;
                    }
                    int i19 = 0;
                    while (i19 < i16) {
                        int[] iArr = this.f16564c[i17];
                        iArr[i15] = ((bArr[i12] & 255) << i19) ^ iArr[i15];
                        i19 += 8;
                        i12++;
                    }
                }
                return;
            }
        }
        throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
    }
}
