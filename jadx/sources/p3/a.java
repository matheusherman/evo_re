package p3;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a implements Cloneable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f17249c = new int[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f17250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f17251b;

    public a() {
        this.f17251b = 0;
        this.f17250a = f17249c;
    }

    public void u(int i10, byte[] bArr, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = 0;
            for (int i15 = 0; i15 < 8; i15++) {
                if (i(i10)) {
                    i14 |= 1 << (7 - i15);
                }
                i10++;
            }
            bArr[i11 + i13] = (byte) i14;
        }
    }

    private void h(int i10) {
        if (i10 > this.f17250a.length * 32) {
            int[] iArrP = p((int) Math.ceil(i10 / 0.75f));
            int[] iArr = this.f17250a;
            System.arraycopy(iArr, 0, iArrP, 0, iArr.length);
            this.f17250a = iArrP;
        }
    }

    private static int[] p(int i10) {
        return new int[(i10 + 31) / 32];
    }

    public void a(boolean z10) {
        h(this.f17251b + 1);
        if (z10) {
            int[] iArr = this.f17250a;
            int i10 = this.f17251b;
            int i11 = i10 / 32;
            iArr[i11] = (1 << (i10 & 31)) | iArr[i11];
        }
        this.f17251b++;
    }

    public void c(a aVar) {
        int i10 = aVar.f17251b;
        h(this.f17251b + i10);
        for (int i11 = 0; i11 < i10; i11++) {
            a(aVar.i(i11));
        }
    }

    public void d(int i10, int i11) {
        if (i11 < 0 || i11 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        int i12 = this.f17251b;
        h(i12 + i11);
        for (int i13 = i11 - 1; i13 >= 0; i13--) {
            if (((1 << i13) & i10) != 0) {
                int[] iArr = this.f17250a;
                int i14 = i12 / 32;
                iArr[i14] = iArr[i14] | (1 << (i12 & 31));
            }
            i12++;
        }
        this.f17251b = i12;
    }

    public void e() {
        int length = this.f17250a.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.f17250a[i10] = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f17251b == aVar.f17251b && Arrays.equals(this.f17250a, aVar.f17250a);
    }

    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public a clone() {
        return new a((int[]) this.f17250a.clone(), this.f17251b);
    }

    public int hashCode() {
        return (this.f17251b * 31) + Arrays.hashCode(this.f17250a);
    }

    public boolean i(int i10) {
        return ((1 << (i10 & 31)) & this.f17250a[i10 / 32]) != 0;
    }

    public int[] j() {
        return this.f17250a;
    }

    public int k(int i10) {
        int i11 = this.f17251b;
        if (i10 >= i11) {
            return i11;
        }
        int i12 = i10 / 32;
        int i13 = (-(1 << (i10 & 31))) & this.f17250a[i12];
        while (i13 == 0) {
            i12++;
            int[] iArr = this.f17250a;
            if (i12 == iArr.length) {
                return this.f17251b;
            }
            i13 = iArr[i12];
        }
        return Math.min((i12 * 32) + Integer.numberOfTrailingZeros(i13), this.f17251b);
    }

    public int l(int i10) {
        int i11 = this.f17251b;
        if (i10 >= i11) {
            return i11;
        }
        int i12 = i10 / 32;
        int i13 = (-(1 << (i10 & 31))) & (~this.f17250a[i12]);
        while (i13 == 0) {
            i12++;
            int[] iArr = this.f17250a;
            if (i12 == iArr.length) {
                return this.f17251b;
            }
            i13 = ~iArr[i12];
        }
        return Math.min((i12 * 32) + Integer.numberOfTrailingZeros(i13), this.f17251b);
    }

    public int m() {
        return this.f17251b;
    }

    public int n() {
        return (this.f17251b + 7) / 8;
    }

    public boolean o(int i10, int i11, boolean z10) {
        if (i11 < i10 || i10 < 0 || i11 > this.f17251b) {
            throw new IllegalArgumentException();
        }
        if (i11 == i10) {
            return true;
        }
        int i12 = i11 - 1;
        int i13 = i10 / 32;
        int i14 = i12 / 32;
        int i15 = i13;
        while (i15 <= i14) {
            int i16 = (2 << (i15 >= i14 ? 31 & i12 : 31)) - (1 << (i15 > i13 ? 0 : i10 & 31));
            int i17 = this.f17250a[i15] & i16;
            if (!z10) {
                i16 = 0;
            }
            if (i17 != i16) {
                return false;
            }
            i15++;
        }
        return true;
    }

    public void q() {
        int[] iArr = new int[this.f17250a.length];
        int i10 = (this.f17251b - 1) / 32;
        int i11 = i10 + 1;
        for (int i12 = 0; i12 < i11; i12++) {
            iArr[i10 - i12] = Integer.reverse(this.f17250a[i12]);
        }
        int i13 = this.f17251b;
        int i14 = i11 * 32;
        if (i13 != i14) {
            int i15 = i14 - i13;
            int i16 = iArr[0] >>> i15;
            for (int i17 = 1; i17 < i11; i17++) {
                int i18 = iArr[i17];
                iArr[i17 - 1] = i16 | (i18 << (32 - i15));
                i16 = i18 >>> i15;
            }
            iArr[i10] = i16;
        }
        this.f17250a = iArr;
    }

    public void s(int i10) {
        int[] iArr = this.f17250a;
        int i11 = i10 / 32;
        iArr[i11] = (1 << (i10 & 31)) | iArr[i11];
    }

    public void t(int i10, int i11) {
        this.f17250a[i10 / 32] = i11;
    }

    public String toString() {
        int i10 = this.f17251b;
        StringBuilder sb2 = new StringBuilder(i10 + (i10 / 8) + 1);
        for (int i11 = 0; i11 < this.f17251b; i11++) {
            if ((i11 & 7) == 0) {
                sb2.append(' ');
            }
            sb2.append(i(i11) ? 'X' : '.');
        }
        return sb2.toString();
    }

    public void v(a aVar) {
        if (this.f17251b != aVar.f17251b) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i10 = 0;
        while (true) {
            int[] iArr = this.f17250a;
            if (i10 >= iArr.length) {
                return;
            }
            iArr[i10] = iArr[i10] ^ aVar.f17250a[i10];
            i10++;
        }
    }

    public a(int i10) {
        this.f17251b = i10;
        this.f17250a = p(i10);
    }

    a(int[] iArr, int i10) {
        this.f17250a = iArr;
        this.f17251b = i10;
    }
}
