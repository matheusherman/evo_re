package p3;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class b implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f17252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f17253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f17254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int[] f17255d;

    public b(int i10) {
        this(i10, i10);
    }

    public int[] m() {
        int[] iArr;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            iArr = this.f17255d;
            if (i11 >= iArr.length || iArr[i11] != 0) {
                break;
            }
            i11++;
        }
        if (i11 == iArr.length) {
            return null;
        }
        int i12 = this.f17254c;
        int i13 = i11 / i12;
        int i14 = (i11 % i12) * 32;
        while ((iArr[i11] << (31 - i10)) == 0) {
            i10++;
        }
        return new int[]{i14 + i10, i13};
    }

    public b(int i10, int i11) {
        if (i10 < 1 || i11 < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f17252a = i10;
        this.f17253b = i11;
        int i12 = (i10 + 31) / 32;
        this.f17254c = i12;
        this.f17255d = new int[i12 * i11];
    }

    private String a(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder(this.f17253b * (this.f17252a + 1));
        for (int i10 = 0; i10 < this.f17253b; i10++) {
            for (int i11 = 0; i11 < this.f17252a; i11++) {
                sb2.append(h(i11, i10) ? str : str2);
            }
            sb2.append(str3);
        }
        return sb2.toString();
    }

    public void c() {
        int length = this.f17255d.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.f17255d[i10] = 0;
        }
    }

    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public b clone() {
        return new b(this.f17252a, this.f17253b, this.f17254c, (int[]) this.f17255d.clone());
    }

    public void e() {
        int length = this.f17255d.length;
        for (int i10 = 0; i10 < length; i10++) {
            int[] iArr = this.f17255d;
            iArr[i10] = ~iArr[i10];
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f17252a == bVar.f17252a && this.f17253b == bVar.f17253b && this.f17254c == bVar.f17254c && Arrays.equals(this.f17255d, bVar.f17255d);
    }

    public void g(int i10, int i11) {
        int i12 = (i11 * this.f17254c) + (i10 / 32);
        int[] iArr = this.f17255d;
        iArr[i12] = (1 << (i10 & 31)) ^ iArr[i12];
    }

    public boolean h(int i10, int i11) {
        return ((this.f17255d[(i11 * this.f17254c) + (i10 / 32)] >>> (i10 & 31)) & 1) != 0;
    }

    public int hashCode() {
        int i10 = this.f17252a;
        return (((((((i10 * 31) + i10) * 31) + this.f17253b) * 31) + this.f17254c) * 31) + Arrays.hashCode(this.f17255d);
    }

    public int[] i() {
        int length = this.f17255d.length - 1;
        while (length >= 0 && this.f17255d[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i10 = this.f17254c;
        int i11 = length / i10;
        int i12 = (length % i10) * 32;
        int i13 = 31;
        while ((this.f17255d[length] >>> i13) == 0) {
            i13--;
        }
        return new int[]{i12 + i13, i11};
    }

    public int[] j() {
        int i10 = this.f17252a;
        int i11 = this.f17253b;
        int i12 = -1;
        int i13 = -1;
        for (int i14 = 0; i14 < this.f17253b; i14++) {
            int i15 = 0;
            while (true) {
                int i16 = this.f17254c;
                if (i15 < i16) {
                    int i17 = this.f17255d[(i16 * i14) + i15];
                    if (i17 != 0) {
                        if (i14 < i11) {
                            i11 = i14;
                        }
                        if (i14 > i13) {
                            i13 = i14;
                        }
                        int i18 = i15 * 32;
                        if (i18 < i10) {
                            int i19 = 0;
                            while ((i17 << (31 - i19)) == 0) {
                                i19++;
                            }
                            int i20 = i19 + i18;
                            if (i20 < i10) {
                                i10 = i20;
                            }
                        }
                        if (i18 + 31 > i12) {
                            int i21 = 31;
                            while ((i17 >>> i21) == 0) {
                                i21--;
                            }
                            int i22 = i18 + i21;
                            if (i22 > i12) {
                                i12 = i22;
                            }
                        }
                    }
                    i15++;
                }
            }
        }
        if (i12 < i10 || i13 < i11) {
            return null;
        }
        return new int[]{i10, i11, (i12 - i10) + 1, (i13 - i11) + 1};
    }

    public int k() {
        return this.f17253b;
    }

    public a l(int i10, a aVar) {
        if (aVar == null || aVar.m() < this.f17252a) {
            aVar = new a(this.f17252a);
        } else {
            aVar.e();
        }
        int i11 = i10 * this.f17254c;
        for (int i12 = 0; i12 < this.f17254c; i12++) {
            aVar.t(i12 * 32, this.f17255d[i11 + i12]);
        }
        return aVar;
    }

    public int n() {
        return this.f17252a;
    }

    public void o(int i10) {
        int i11 = i10 % 360;
        if (i11 != 0) {
            if (i11 == 90) {
                q();
                return;
            }
            if (i11 == 180) {
                p();
            } else {
                if (i11 != 270) {
                    throw new IllegalArgumentException("degrees must be a multiple of 0, 90, 180, or 270");
                }
                q();
                p();
            }
        }
    }

    public void p() {
        a aVar = new a(this.f17252a);
        a aVar2 = new a(this.f17252a);
        int i10 = (this.f17253b + 1) / 2;
        for (int i11 = 0; i11 < i10; i11++) {
            aVar = l(i11, aVar);
            int i12 = (this.f17253b - 1) - i11;
            aVar2 = l(i12, aVar2);
            aVar.q();
            aVar2.q();
            u(i11, aVar2);
            u(i12, aVar);
        }
    }

    public void q() {
        int i10 = this.f17253b;
        int i11 = this.f17252a;
        int i12 = (i10 + 31) / 32;
        int[] iArr = new int[i12 * i11];
        for (int i13 = 0; i13 < this.f17253b; i13++) {
            for (int i14 = 0; i14 < this.f17252a; i14++) {
                if (((this.f17255d[(this.f17254c * i13) + (i14 / 32)] >>> (i14 & 31)) & 1) != 0) {
                    int i15 = (((i11 - 1) - i14) * i12) + (i13 / 32);
                    iArr[i15] = (1 << (i13 & 31)) | iArr[i15];
                }
            }
        }
        this.f17252a = i10;
        this.f17253b = i11;
        this.f17254c = i12;
        this.f17255d = iArr;
    }

    public void s(int i10, int i11) {
        int i12 = (i11 * this.f17254c) + (i10 / 32);
        int[] iArr = this.f17255d;
        iArr[i12] = (1 << (i10 & 31)) | iArr[i12];
    }

    public void t(int i10, int i11, int i12, int i13) {
        if (i11 < 0 || i10 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i13 < 1 || i12 < 1) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i14 = i12 + i10;
        int i15 = i13 + i11;
        if (i15 > this.f17253b || i14 > this.f17252a) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i11 < i15) {
            int i16 = this.f17254c * i11;
            for (int i17 = i10; i17 < i14; i17++) {
                int[] iArr = this.f17255d;
                int i18 = (i17 / 32) + i16;
                iArr[i18] = iArr[i18] | (1 << (i17 & 31));
            }
            i11++;
        }
    }

    public String toString() {
        return v("X ", "  ");
    }

    public String v(String str, String str2) {
        return a(str, str2, "\n");
    }

    public void u(int i10, a aVar) {
        int[] iArrJ = aVar.j();
        int[] iArr = this.f17255d;
        int i11 = this.f17254c;
        System.arraycopy(iArrJ, 0, iArr, i10 * i11, i11);
    }

    private b(int i10, int i11, int i12, int[] iArr) {
        this.f17252a = i10;
        this.f17253b = i11;
        this.f17254c = i12;
        this.f17255d = iArr;
    }
}
