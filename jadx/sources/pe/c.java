package pe;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f17583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f17584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int[] f17585c;

    public c(a aVar, int i10) {
        this.f17583a = aVar;
        this.f17584b = i10;
        int[] iArr = new int[i10 + 1];
        this.f17585c = iArr;
        iArr[i10] = 1;
    }

    private int[] a(int[] iArr, int[] iArr2) {
        int[] iArr3;
        if (iArr.length < iArr2.length) {
            iArr3 = new int[iArr2.length];
            System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
        } else {
            iArr3 = new int[iArr.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            iArr = iArr2;
        }
        for (int length = iArr.length - 1; length >= 0; length--) {
            iArr3[length] = this.f17583a.a(iArr3[length], iArr[length]);
        }
        return iArr3;
    }

    private static int c(int[] iArr) {
        int length = iArr.length - 1;
        while (length >= 0 && iArr[length] == 0) {
            length--;
        }
        return length;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof c)) {
            c cVar = (c) obj;
            if (this.f17583a.equals(cVar.f17583a) && this.f17584b == cVar.f17584b && e(this.f17585c, cVar.f17585c)) {
                return true;
            }
        }
        return false;
    }

    public c(a aVar, int[] iArr) {
        this.f17583a = aVar;
        this.f17585c = f(iArr);
        d();
    }

    private void d() {
        int length = this.f17585c.length;
        do {
            this.f17584b = length - 1;
            length = this.f17584b;
            if (length < 0) {
                return;
            }
        } while (this.f17585c[length] == 0);
    }

    public c b(int i10) {
        int[] iArr = new int[i10 + 1];
        iArr[i10] = 1;
        return new c(this.f17583a, a(this.f17585c, iArr));
    }

    public int hashCode() {
        int iHashCode = this.f17583a.hashCode();
        int i10 = 0;
        while (true) {
            int[] iArr = this.f17585c;
            if (i10 >= iArr.length) {
                return iHashCode;
            }
            iHashCode = (iHashCode * 31) + iArr[i10];
            i10++;
        }
    }

    public String toString() {
        String str = " Polynomial over " + this.f17583a.toString() + ": \n";
        for (int i10 = 0; i10 < this.f17585c.length; i10++) {
            str = str + this.f17583a.b(this.f17585c[i10]) + "Y^" + i10 + "+";
        }
        return str + ";";
    }

    private static boolean e(int[] iArr, int[] iArr2) {
        int iC = c(iArr);
        if (iC != c(iArr2)) {
            return false;
        }
        for (int i10 = 0; i10 <= iC; i10++) {
            if (iArr[i10] != iArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    private static int[] f(int[] iArr) {
        int iC = c(iArr);
        if (iC == -1) {
            return new int[1];
        }
        int i10 = iC + 1;
        if (iArr.length == i10) {
            return b.a(iArr);
        }
        int[] iArr2 = new int[i10];
        System.arraycopy(iArr, 0, iArr2, 0, i10);
        return iArr2;
    }
}
