package fc;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class s2 extends c0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f10222c;

    private synchronized void J() {
        if (this.f10222c != null) {
            o oVar = new o(this.f10222c, true);
            try {
                g gVarO = oVar.o();
                oVar.close();
                this.f10121a = gVarO.g();
                this.f10222c = null;
            } catch (IOException e10) {
                throw new y("malformed ASN.1: " + e10, e10);
            }
        }
    }

    private synchronized byte[] K() {
        return this.f10222c;
    }

    s2(byte[] bArr) {
        if (bArr != null) {
            this.f10222c = bArr;
            return;
        }
        throw new NullPointerException("'encoded' cannot be null");
    }

    @Override // fc.c0
    public f A(int i10) {
        J();
        return super.A(i10);
    }

    @Override // fc.c0
    public Enumeration B() {
        byte[] bArrK = K();
        if (bArrK != null) {
            return new r2(bArrK);
        }
        return super.B();
    }

    @Override // fc.c0
    c C() {
        return ((c0) w()).C();
    }

    @Override // fc.c0
    j D() {
        return ((c0) w()).D();
    }

    @Override // fc.c0
    v E() {
        return ((c0) w()).E();
    }

    @Override // fc.c0
    d0 H() {
        return ((c0) w()).H();
    }

    @Override // fc.c0, fc.z, fc.s
    public int hashCode() {
        J();
        return super.hashCode();
    }

    @Override // fc.c0, java.lang.Iterable
    public Iterator<f> iterator() {
        J();
        return super.iterator();
    }

    @Override // fc.z
    void n(x xVar, boolean z10) {
        byte[] bArrK = K();
        if (bArrK != null) {
            xVar.o(z10, 48, bArrK);
        } else {
            super.w().n(xVar, z10);
        }
    }

    @Override // fc.z
    int s(boolean z10) {
        byte[] bArrK = K();
        if (bArrK != null) {
            return x.g(z10, bArrK.length);
        }
        return super.w().s(z10);
    }

    @Override // fc.c0
    public int size() {
        J();
        return super.size();
    }

    @Override // fc.c0, fc.z
    z v() {
        J();
        return super.v();
    }

    @Override // fc.c0, fc.z
    z w() {
        J();
        return super.w();
    }
}
