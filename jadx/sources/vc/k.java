package vc;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class k extends b implements tc.l {
    private static int r(int i10) {
        if (i10 == 128 || i10 == 256) {
            return i10;
        }
        throw new IllegalArgumentException("'bitStrength' " + i10 + " not supported for SHAKE");
    }

    @Override // tc.i
    public String a() {
        return "SHAKE" + this.f19777f;
    }

    @Override // vc.b, tc.i
    public int e() {
        return this.f19777f / 4;
    }

    @Override // vc.b
    protected tc.c l() {
        return l.b(this, this.f19772a);
    }

    public int s(byte[] bArr, int i10, int i11) {
        if (!this.f19778g) {
            k(15, 4);
        }
        q(bArr, i10, ((long) i11) * 8);
        return i11;
    }

    public k(int i10) {
        super(r(i10), tc.d.ANY);
    }

    @Override // vc.b, tc.i
    public int b(byte[] bArr, int i10) {
        return d(bArr, i10, e());
    }

    @Override // tc.l
    public int d(byte[] bArr, int i10, int i11) {
        int iS = s(bArr, i10, i11);
        p();
        return iS;
    }
}
