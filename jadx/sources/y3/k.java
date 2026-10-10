package y3;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class k extends y {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int[] f22363i = new int[4];

    @Override // y3.y
    protected int l(p3.a aVar, int[] iArr, StringBuilder sb2) {
        int[] iArr2 = this.f22363i;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iM = aVar.m();
        int i10 = iArr[1];
        for (int i11 = 0; i11 < 4 && i10 < iM; i11++) {
            sb2.append((char) (y.j(aVar, iArr2, i10, y.f22392g) + 48));
            for (int i12 : iArr2) {
                i10 += i12;
            }
        }
        int i13 = y.n(aVar, i10, true, y.f22390e)[1];
        for (int i14 = 0; i14 < 4 && i13 < iM; i14++) {
            sb2.append((char) (y.j(aVar, iArr2, i13, y.f22392g) + 48));
            for (int i15 : iArr2) {
                i13 += i15;
            }
        }
        return i13;
    }

    @Override // y3.y
    h3.a q() {
        return h3.a.EAN_8;
    }
}
