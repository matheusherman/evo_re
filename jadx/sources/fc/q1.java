package fc;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class q1 extends v {
    public q1(f fVar) {
        super(fVar.f().k("DER"));
    }

    static void B(x xVar, boolean z10, byte[] bArr, int i10, int i11) {
        xVar.p(z10, 4, bArr, i10, i11);
    }

    @Override // fc.z
    void n(x xVar, boolean z10) {
        xVar.o(z10, 4, this.f10242a);
    }

    @Override // fc.z
    boolean o() {
        return false;
    }

    public q1(byte[] bArr) {
        super(bArr);
    }

    @Override // fc.z
    int s(boolean z10) {
        return x.g(z10, this.f10242a.length);
    }

    static int C(boolean z10, int i10) {
        return x.g(z10, i10);
    }

    @Override // fc.v, fc.z
    z v() {
        return this;
    }

    @Override // fc.v, fc.z
    z w() {
        return this;
    }
}
