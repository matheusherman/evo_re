package fc;

import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class h1 extends c {
    public h1(f fVar) {
        super(fVar.f().k("DER"), 0);
    }

    @Override // fc.z
    boolean o() {
        return false;
    }

    public h1(byte[] bArr) {
        this(bArr, 0);
    }

    static h1 E(v vVar) {
        return new h1(vVar.A(), true);
    }

    public static h1 I(Object obj) {
        if (obj == null || (obj instanceof h1)) {
            return (h1) obj;
        }
        if (obj instanceof c) {
            return D((c) obj);
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return D((c) z.u((byte[]) obj));
        } catch (Exception e10) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e10.toString());
        }
    }

    @Override // fc.z
    void n(x xVar, boolean z10) throws IOException {
        byte[] bArr = this.f10119a;
        int i10 = bArr[0] & 255;
        int length = bArr.length - 1;
        byte b10 = bArr[length];
        byte b11 = (byte) ((255 << i10) & b10);
        if (b10 == b11) {
            xVar.o(z10, 3, bArr);
        } else {
            xVar.q(z10, 3, bArr, 0, length, b11);
        }
    }

    @Override // fc.z
    int s(boolean z10) {
        return x.g(z10, this.f10119a.length);
    }

    public h1(byte[] bArr, int i10) {
        super(bArr, i10);
    }

    public static h1 D(c cVar) {
        return (h1) cVar.v();
    }

    public static h1 H(h0 h0Var, boolean z10) {
        z zVarE = h0Var.E();
        if (!z10 && !(zVarE instanceof h1)) {
            return E(v.z(zVarE));
        }
        return I(zVarE);
    }

    h1(byte[] bArr, boolean z10) {
        super(bArr, z10);
    }

    @Override // fc.c, fc.z
    z v() {
        return this;
    }

    @Override // fc.c, fc.z
    z w() {
        return this;
    }
}
