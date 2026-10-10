package w5;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f20057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f20058b;

    public a() {
        this.f20058b = 0;
        this.f20057a = new int[1];
    }

    public void l(int i10, byte[] bArr, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = 0;
            for (int i15 = 0; i15 < 8; i15++) {
                if (g(i10)) {
                    i14 |= 1 << (7 - i15);
                }
                i10++;
            }
            bArr[i11 + i13] = (byte) i14;
        }
    }

    private void j(int i10) {
        if (i10 > this.f20057a.length * 32) {
            int[] iArrK = k(i10);
            int[] iArr = this.f20057a;
            System.arraycopy(iArr, 0, iArrK, 0, iArr.length);
            this.f20057a = iArrK;
        }
    }

    private static int[] k(int i10) {
        return new int[(i10 + 31) / 32];
    }

    public void a(boolean z10) {
        j(this.f20058b + 1);
        if (z10) {
            int[] iArr = this.f20057a;
            int i10 = this.f20058b;
            int i11 = i10 / 32;
            iArr[i11] = (1 << (i10 & 31)) | iArr[i11];
        }
        this.f20058b++;
    }

    public void c(a aVar) {
        int i10 = aVar.f20058b;
        j(this.f20058b + i10);
        for (int i11 = 0; i11 < i10; i11++) {
            a(aVar.g(i11));
        }
    }

    public void d(int i10, int i11) {
        if (i11 < 0 || i11 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        j(this.f20058b + i11);
        while (i11 > 0) {
            i11--;
            boolean z10 = true;
            if (((i10 >> i11) & 1) != 1) {
                z10 = false;
            }
            a(z10);
        }
    }

    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public a clone() {
        return new a((int[]) this.f20057a.clone(), this.f20058b);
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f20058b == aVar.f20058b && Arrays.equals(this.f20057a, aVar.f20057a)) {
                return true;
            }
        }
        return false;
    }

    public boolean g(int i10) {
        return ((1 << (i10 & 31)) & this.f20057a[i10 / 32]) != 0;
    }

    public int h() {
        return this.f20058b;
    }

    public int hashCode() {
        return (this.f20058b * 31) + Arrays.hashCode(this.f20057a);
    }

    public int i() {
        return (this.f20058b + 7) / 8;
    }

    public void m(a aVar) {
        if (this.f20057a.length != aVar.f20057a.length) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i10 = 0;
        while (true) {
            int[] iArr = this.f20057a;
            if (i10 >= iArr.length) {
                return;
            }
            iArr[i10] = iArr[i10] ^ aVar.f20057a[i10];
            i10++;
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(this.f20058b);
        for (int i10 = 0; i10 < this.f20058b; i10++) {
            if ((i10 & 7) == 0) {
                sb2.append(' ');
            }
            sb2.append(g(i10) ? 'X' : '.');
        }
        return sb2.toString();
    }

    a(int[] iArr, int i10) {
        this.f20057a = iArr;
        this.f20058b = i10;
    }
}
