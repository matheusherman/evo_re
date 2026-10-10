package w5;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class b implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f20059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f20060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f20061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int[] f20062d;

    public b(int i10, int i11) {
        if (i10 < 1 || i11 < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f20059a = i10;
        this.f20060b = i11;
        int i12 = (i10 + 31) / 32;
        this.f20061c = i12;
        this.f20062d = new int[i12 * i11];
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b clone() {
        return new b(this.f20059a, this.f20060b, this.f20061c, (int[]) this.f20062d.clone());
    }

    public boolean c(int i10, int i11) {
        return ((this.f20062d[(this.f20061c * i11) + (i10 / 32)] >>> (i10 & 31)) & 1) != 0;
    }

    public void d(int i10, int i11, int i12, int i13) {
        if (i11 < 0 || i10 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i13 < 1 || i12 < 1) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i14 = i12 + i10;
        int i15 = i13 + i11;
        if (i15 > this.f20060b || i14 > this.f20059a) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i11 < i15) {
            int i16 = this.f20061c * i11;
            for (int i17 = i10; i17 < i14; i17++) {
                int[] iArr = this.f20062d;
                int i18 = (i17 / 32) + i16;
                iArr[i18] = iArr[i18] | (1 << (i17 & 31));
            }
            i11++;
        }
    }

    public String e(String str, String str2) {
        return g(str, str2, "\n");
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f20059a == bVar.f20059a && this.f20060b == bVar.f20060b && this.f20061c == bVar.f20061c && Arrays.equals(this.f20062d, bVar.f20062d)) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public String g(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder(this.f20060b * (this.f20059a + 1));
        for (int i10 = 0; i10 < this.f20060b; i10++) {
            for (int i11 = 0; i11 < this.f20059a; i11++) {
                sb2.append(c(i11, i10) ? str : str2);
            }
            sb2.append(str3);
        }
        return sb2.toString();
    }

    public int hashCode() {
        int i10 = this.f20059a;
        return (((((((i10 * 31) + i10) * 31) + this.f20060b) * 31) + this.f20061c) * 31) + Arrays.hashCode(this.f20062d);
    }

    public String toString() {
        return e("X ", "  ");
    }

    private b(int i10, int i11, int i12, int[] iArr) {
        this.f20059a = i10;
        this.f20060b = i11;
        this.f20061c = i12;
        this.f20062d = iArr;
    }
}
