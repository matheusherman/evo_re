package y3;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class i extends y {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final int[] f22361j = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int[] f22362i = new int[4];

    private static void s(StringBuilder sb2, int i10) throws h3.m {
        for (int i11 = 0; i11 < 10; i11++) {
            if (i10 == f22361j[i11]) {
                sb2.insert(0, (char) (i11 + 48));
                return;
            }
        }
        throw h3.m.a();
    }

    @Override // y3.y
    protected int l(p3.a aVar, int[] iArr, StringBuilder sb2) throws h3.m {
        int[] iArr2 = this.f22362i;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iM = aVar.m();
        int i10 = iArr[1];
        int i11 = 0;
        for (int i12 = 0; i12 < 6 && i10 < iM; i12++) {
            int iJ = y.j(aVar, iArr2, i10, y.f22393h);
            sb2.append((char) ((iJ % 10) + 48));
            for (int i13 : iArr2) {
                i10 += i13;
            }
            if (iJ >= 10) {
                i11 |= 1 << (5 - i12);
            }
        }
        s(sb2, i11);
        int i14 = y.n(aVar, i10, true, y.f22390e)[1];
        for (int i15 = 0; i15 < 6 && i14 < iM; i15++) {
            sb2.append((char) (y.j(aVar, iArr2, i14, y.f22392g) + 48));
            for (int i16 : iArr2) {
                i14 += i16;
            }
        }
        return i14;
    }

    @Override // y3.y
    h3.a q() {
        return h3.a.EAN_13;
    }
}
