package oe;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f16581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private i f16582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected i[] f16583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected i[] f16584d;

    private void a() {
        int iF;
        int iG = this.f16582b.g();
        i[] iVarArr = new i[iG];
        int i10 = iG - 1;
        for (int i11 = i10; i11 >= 0; i11--) {
            iVarArr[i11] = new i(this.f16583c[i11]);
        }
        this.f16584d = new i[iG];
        while (i10 >= 0) {
            this.f16584d[i10] = new i(this.f16581a, i10);
            i10--;
        }
        for (int i12 = 0; i12 < iG; i12++) {
            if (iVarArr[i12].f(i12) == 0) {
                int i13 = i12 + 1;
                boolean z10 = false;
                while (i13 < iG) {
                    if (iVarArr[i13].f(i12) != 0) {
                        d(iVarArr, i12, i13);
                        d(this.f16584d, i12, i13);
                        i13 = iG;
                        z10 = true;
                    }
                    i13++;
                }
                if (!z10) {
                    throw new ArithmeticException("Squaring matrix is not invertible.");
                }
            }
            int iF2 = this.f16581a.f(iVarArr[i12].f(i12));
            iVarArr[i12].m(iF2);
            this.f16584d[i12].m(iF2);
            for (int i14 = 0; i14 < iG; i14++) {
                if (i14 != i12 && (iF = iVarArr[i14].f(i12)) != 0) {
                    i iVarN = iVarArr[i12].n(iF);
                    i iVarN2 = this.f16584d[i12].n(iF);
                    iVarArr[i14].b(iVarN);
                    this.f16584d[i14].b(iVarN2);
                }
            }
        }
    }

    private void b() {
        int i10;
        int iG = this.f16582b.g();
        this.f16583c = new i[iG];
        int i11 = 0;
        while (true) {
            i10 = iG >> 1;
            if (i11 >= i10) {
                break;
            }
            int i12 = i11 << 1;
            int[] iArr = new int[i12 + 1];
            iArr[i12] = 1;
            this.f16583c[i11] = new i(this.f16581a, iArr);
            i11++;
        }
        while (i10 < iG) {
            int i13 = i10 << 1;
            int[] iArr2 = new int[i13 + 1];
            iArr2[i13] = 1;
            this.f16583c[i10] = new i(this.f16581a, iArr2).k(this.f16582b);
            i10++;
        }
    }

    private static void d(i[] iVarArr, int i10, int i11) {
        i iVar = iVarArr[i10];
        iVarArr[i10] = iVarArr[i11];
        iVarArr[i11] = iVar;
    }

    public i[] c() {
        return this.f16584d;
    }

    public k(b bVar, i iVar) {
        this.f16581a = bVar;
        this.f16582b = iVar;
        b();
        a();
    }
}
