package fc;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class z extends s {
    @Override // fc.s
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f) && m(((f) obj).f());
    }

    @Override // fc.s
    public abstract int hashCode();

    abstract boolean m(z zVar);

    abstract void n(x xVar, boolean z10);

    abstract boolean o();

    abstract int s(boolean z10);

    public static z u(byte[] bArr) throws IOException {
        o oVar = new o(bArr);
        try {
            z zVarL = oVar.l();
            if (oVar.available() == 0) {
                return zVarL;
            }
            throw new IOException("Extra data detected in stream");
        } catch (ClassCastException unused) {
            throw new IOException("cannot recognise object in stream");
        }
    }

    public final boolean t(z zVar) {
        return this == zVar || m(zVar);
    }

    z() {
    }

    public void q(OutputStream outputStream) {
        x xVarA = x.a(outputStream);
        xVarA.u(this, true);
        xVarA.c();
    }

    public void r(OutputStream outputStream, String str) {
        x xVarB = x.b(outputStream, str);
        xVarB.u(this, true);
        xVarB.c();
    }

    @Override // fc.s, fc.f
    public final z f() {
        return this;
    }

    z v() {
        return this;
    }

    z w() {
        return this;
    }
}
