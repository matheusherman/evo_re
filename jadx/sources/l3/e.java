package l3;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class e extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final short f15192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final short f15193d;

    @Override // l3.g
    void c(p3.a aVar, byte[] bArr) {
        aVar.d(this.f15192c, this.f15193d);
    }

    public String toString() {
        short s10 = this.f15192c;
        short s11 = this.f15193d;
        return '<' + Integer.toBinaryString((s10 & ((1 << s11) - 1)) | (1 << s11) | (1 << this.f15193d)).substring(1) + '>';
    }

    e(g gVar, int i10, int i11) {
        super(gVar);
        this.f15192c = (short) i10;
        this.f15193d = (short) i11;
    }
}
