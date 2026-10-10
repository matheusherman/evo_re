package sc;

import fc.g;
import fc.h1;
import fc.s;
import fc.u;
import fc.u1;
import fc.z;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class a extends s implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f18544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private u f18545b = null;

    private void m() {
        u uVar;
        if (ed.a.b(null)) {
            uVar = e.f18566o0;
        } else {
            if (!ed.a.a(null)) {
                throw new IllegalArgumentException("This type of ECCurve is not implemented");
            }
            uVar = e.f18568p0;
        }
        this.f18545b = uVar;
    }

    @Override // fc.s, fc.f
    public z f() {
        g gVar = new g(3);
        if (this.f18545b.t(e.f18566o0)) {
            throw null;
        }
        if (this.f18545b.t(e.f18568p0)) {
            throw null;
        }
        if (this.f18544a != null) {
            gVar.a(new h1(this.f18544a));
        }
        return new u1(gVar);
    }

    public a(ed.b bVar, byte[] bArr) {
        this.f18544a = re.a.d(bArr);
        m();
    }
}
