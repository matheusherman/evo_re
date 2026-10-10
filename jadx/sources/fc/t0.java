package fc;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class t0 implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e0 f10225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d1 f10226b;

    static s0 a(e0 e0Var) {
        d1 d1Var = new d1(e0Var, false);
        return new s0(te.a.c(d1Var), d1Var.b());
    }

    @Override // fc.d
    public InputStream g() {
        d1 d1Var = new d1(this.f10225a, false);
        this.f10226b = d1Var;
        return d1Var;
    }

    @Override // fc.d
    public int h() {
        return this.f10226b.b();
    }

    @Override // fc.p2
    public z i() {
        return a(this.f10225a);
    }

    t0(e0 e0Var) {
        this.f10225a = e0Var;
    }

    @Override // fc.f
    public z f() {
        try {
            return i();
        } catch (IOException e10) {
            throw new y("IOException converting stream to byte array: " + e10.getMessage(), e10);
        }
    }
}
