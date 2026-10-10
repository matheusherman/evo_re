package fc;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class w0 implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e0 f10246a;

    static v0 a(e0 e0Var) {
        return new v0(te.a.c(new e1(e0Var)));
    }

    @Override // fc.w
    public InputStream e() {
        return new e1(this.f10246a);
    }

    @Override // fc.p2
    public z i() {
        return a(this.f10246a);
    }

    w0(e0 e0Var) {
        this.f10246a = e0Var;
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
