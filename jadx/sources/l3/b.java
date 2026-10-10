package l3;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class b extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f15182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f15183d;

    @Override // l3.g
    public void c(p3.a aVar, byte[] bArr) {
        int i10 = this.f15183d;
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 == 0 || (i11 == 31 && i10 <= 62)) {
                aVar.d(31, 5);
                if (i10 > 62) {
                    aVar.d(i10 - 31, 16);
                } else if (i11 == 0) {
                    aVar.d(Math.min(i10, 31), 5);
                } else {
                    aVar.d(i10 - 31, 5);
                }
            }
            aVar.d(bArr[this.f15182c + i11], 8);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<");
        sb2.append(this.f15182c);
        sb2.append("::");
        sb2.append((this.f15182c + this.f15183d) - 1);
        sb2.append('>');
        return sb2.toString();
    }

    b(g gVar, int i10, int i11) {
        super(gVar);
        this.f15182c = i10;
        this.f15183d = i11;
    }
}
