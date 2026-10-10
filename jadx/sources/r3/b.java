package r3;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f17807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f17808b;

    int c(int i10) {
        if (i10 == 0) {
            return d(0);
        }
        if (i10 == 1) {
            int iA = 0;
            for (int i11 : this.f17808b) {
                iA = a.a(iA, i11);
            }
            return iA;
        }
        int[] iArr = this.f17808b;
        int iA2 = iArr[0];
        int length = iArr.length;
        for (int i12 = 1; i12 < length; i12++) {
            iA2 = a.a(this.f17807a.j(i10, iA2), this.f17808b[i12]);
        }
        return iA2;
    }

    b a(b bVar) {
        if (!this.f17807a.equals(bVar.f17807a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (g()) {
            return bVar;
        }
        if (bVar.g()) {
            return this;
        }
        int[] iArr = this.f17808b;
        int[] iArr2 = bVar.f17808b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i10 = length; i10 < iArr.length; i10++) {
            iArr3[i10] = a.a(iArr2[i10 - length], iArr[i10]);
        }
        return new b(this.f17807a, iArr3);
    }

    b[] b(b bVar) {
        if (!this.f17807a.equals(bVar.f17807a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (bVar.g()) {
            throw new IllegalArgumentException("Divide by 0");
        }
        b bVarG = this.f17807a.g();
        int iH = this.f17807a.h(bVar.d(bVar.f()));
        b bVarA = this;
        while (bVarA.f() >= bVar.f() && !bVarA.g()) {
            int iF = bVarA.f() - bVar.f();
            int iJ = this.f17807a.j(bVarA.d(bVarA.f()), iH);
            b bVarJ = bVar.j(iF, iJ);
            bVarG = bVarG.a(this.f17807a.b(iF, iJ));
            bVarA = bVarA.a(bVarJ);
        }
        return new b[]{bVarG, bVarA};
    }

    int d(int i10) {
        int[] iArr = this.f17808b;
        return iArr[(iArr.length - 1) - i10];
    }

    int[] e() {
        return this.f17808b;
    }

    int f() {
        return this.f17808b.length - 1;
    }

    boolean g() {
        return this.f17808b[0] == 0;
    }

    b h(int i10) {
        if (i10 == 0) {
            return this.f17807a.g();
        }
        if (i10 == 1) {
            return this;
        }
        int length = this.f17808b.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = this.f17807a.j(this.f17808b[i11], i10);
        }
        return new b(this.f17807a, iArr);
    }

    b i(b bVar) {
        if (!this.f17807a.equals(bVar.f17807a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (g() || bVar.g()) {
            return this.f17807a.g();
        }
        int[] iArr = this.f17808b;
        int length = iArr.length;
        int[] iArr2 = bVar.f17808b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = iArr[i10];
            for (int i12 = 0; i12 < length2; i12++) {
                int i13 = i10 + i12;
                iArr3[i13] = a.a(iArr3[i13], this.f17807a.j(i11, iArr2[i12]));
            }
        }
        return new b(this.f17807a, iArr3);
    }

    b j(int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException();
        }
        if (i11 == 0) {
            return this.f17807a.g();
        }
        int length = this.f17808b.length;
        int[] iArr = new int[i10 + length];
        for (int i12 = 0; i12 < length; i12++) {
            iArr[i12] = this.f17807a.j(this.f17808b[i12], i11);
        }
        return new b(this.f17807a, iArr);
    }

    b(a aVar, int[] iArr) {
        if (iArr.length != 0) {
            this.f17807a = aVar;
            int length = iArr.length;
            int i10 = 1;
            if (length > 1 && iArr[0] == 0) {
                while (i10 < length && iArr[i10] == 0) {
                    i10++;
                }
                if (i10 == length) {
                    this.f17808b = new int[]{0};
                    return;
                }
                int[] iArr2 = new int[length - i10];
                this.f17808b = iArr2;
                System.arraycopy(iArr, i10, iArr2, 0, iArr2.length);
                return;
            }
            this.f17808b = iArr;
            return;
        }
        throw new IllegalArgumentException();
    }

    public String toString() {
        if (g()) {
            return "0";
        }
        StringBuilder sb2 = new StringBuilder(f() * 8);
        for (int iF = f(); iF >= 0; iF--) {
            int iD = d(iF);
            if (iD != 0) {
                if (iD < 0) {
                    if (iF == f()) {
                        sb2.append("-");
                    } else {
                        sb2.append(" - ");
                    }
                    iD = -iD;
                } else if (sb2.length() > 0) {
                    sb2.append(" + ");
                }
                if (iF == 0 || iD != 1) {
                    int i10 = this.f17807a.i(iD);
                    if (i10 == 0) {
                        sb2.append('1');
                    } else if (i10 == 1) {
                        sb2.append('a');
                    } else {
                        sb2.append("a^");
                        sb2.append(i10);
                    }
                }
                if (iF != 0) {
                    if (iF == 1) {
                        sb2.append('x');
                    } else {
                        sb2.append("x^");
                        sb2.append(iF);
                    }
                }
            }
        }
        return sb2.toString();
    }
}
