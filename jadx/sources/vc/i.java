package vc;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class i extends b {
    @Override // vc.b, tc.i
    public int b(byte[] bArr, int i10) {
        k(2, 2);
        return super.b(bArr, i10);
    }

    private static int r(int i10) {
        if (i10 == 224 || i10 == 256 || i10 == 384 || i10 == 512) {
            return i10;
        }
        throw new IllegalArgumentException("'bitLength' " + i10 + " not supported for SHA-3");
    }

    @Override // tc.i
    public String a() {
        return "SHA3-" + this.f19777f;
    }

    public i(int i10) {
        super(r(i10), tc.d.ANY);
    }
}
