package fc;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d2 extends c {
    static void D(x xVar, boolean z10, byte b10, byte[] bArr, int i10, int i11) {
        xVar.n(z10, 3, b10, bArr, i10, i11);
    }

    static void E(x xVar, boolean z10, byte[] bArr, int i10, int i11) {
        xVar.p(z10, 3, bArr, i10, i11);
    }

    @Override // fc.z
    void n(x xVar, boolean z10) {
        xVar.o(z10, 3, this.f10119a);
    }

    @Override // fc.z
    boolean o() {
        return false;
    }

    @Override // fc.z
    int s(boolean z10) {
        return x.g(z10, this.f10119a.length);
    }

    d2(byte[] bArr, boolean z10) {
        super(bArr, z10);
    }

    static int H(boolean z10, int i10) {
        return x.g(z10, i10);
    }

    @Override // fc.c, fc.z
    z w() {
        return this;
    }
}
