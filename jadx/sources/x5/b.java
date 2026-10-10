package x5;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f21853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f21854b;

    public int a(int i10) {
        int[] iArr = this.f21854b;
        return iArr[(iArr.length - 1) - i10];
    }

    public b b(int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException();
        }
        if (i11 == 0) {
            return this.f21853a.d();
        }
        int length = this.f21854b.length;
        int[] iArr = new int[i10 + length];
        for (int i12 = 0; i12 < length; i12++) {
            iArr[i12] = this.f21853a.h(this.f21854b[i12], i11);
        }
        return new b(this.f21853a, iArr);
    }

    public b c(b bVar) {
        if (!this.f21853a.equals(bVar.f21853a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (g()) {
            return bVar;
        }
        if (bVar.g()) {
            return this;
        }
        int[] iArr = this.f21854b;
        int[] iArr2 = bVar.f21854b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i10 = length; i10 < iArr.length; i10++) {
            iArr3[i10] = a.b(iArr2[i10 - length], iArr[i10]);
        }
        return new b(this.f21853a, iArr3);
    }

    public int[] d() {
        return this.f21854b;
    }

    public int e() {
        return this.f21854b.length - 1;
    }

    public b f(b bVar) {
        if (!this.f21853a.equals(bVar.f21853a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (g() || bVar.g()) {
            return this.f21853a.d();
        }
        int[] iArr = this.f21854b;
        int length = iArr.length;
        int[] iArr2 = bVar.f21854b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = iArr[i10];
            for (int i12 = 0; i12 < length2; i12++) {
                int i13 = i10 + i12;
                iArr3[i13] = a.b(iArr3[i13], this.f21853a.h(i11, iArr2[i12]));
            }
        }
        return new b(this.f21853a, iArr3);
    }

    public boolean g() {
        return this.f21854b[0] == 0;
    }

    public b[] h(b bVar) {
        if (!this.f21853a.equals(bVar.f21853a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (bVar.g()) {
            throw new IllegalArgumentException("Divide by 0");
        }
        b bVarD = this.f21853a.d();
        int iG = this.f21853a.g(bVar.a(bVar.e()));
        b bVarC = this;
        while (bVarC.e() >= bVar.e() && !bVarC.g()) {
            int iE = bVarC.e() - bVar.e();
            int iH = this.f21853a.h(bVarC.a(bVarC.e()), iG);
            b bVarB = bVar.b(iE, iH);
            bVarD = bVarD.c(this.f21853a.e(iE, iH));
            bVarC = bVarC.c(bVarB);
        }
        return new b[]{bVarD, bVarC};
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(e() * 8);
        for (int iE = e(); iE >= 0; iE--) {
            int iA = a(iE);
            if (iA != 0) {
                if (iA < 0) {
                    sb2.append(" - ");
                    iA = -iA;
                } else if (sb2.length() > 0) {
                    sb2.append(" + ");
                }
                if (iE == 0 || iA != 1) {
                    int iF = this.f21853a.f(iA);
                    if (iF == 0) {
                        sb2.append('1');
                    } else if (iF == 1) {
                        sb2.append('a');
                    } else {
                        sb2.append("a^");
                        sb2.append(iF);
                    }
                }
                if (iE != 0) {
                    if (iE == 1) {
                        sb2.append('x');
                    } else {
                        sb2.append("x^");
                        sb2.append(iE);
                    }
                }
            }
        }
        return sb2.toString();
    }

    b(a aVar, int[] iArr) {
        if (iArr.length != 0) {
            this.f21853a = aVar;
            int length = iArr.length;
            int i10 = 1;
            if (length > 1 && iArr[0] == 0) {
                while (i10 < length && iArr[i10] == 0) {
                    i10++;
                }
                if (i10 == length) {
                    this.f21854b = new int[]{0};
                    return;
                }
                int[] iArr2 = new int[length - i10];
                this.f21854b = iArr2;
                System.arraycopy(iArr, i10, iArr2, 0, iArr2.length);
                return;
            }
            this.f21854b = iArr;
            return;
        }
        throw new IllegalArgumentException();
    }
}
