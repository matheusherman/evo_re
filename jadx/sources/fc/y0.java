package fc;

import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class y0 implements f, p2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e0 f10248a;

    static x0 a(e0 e0Var) {
        return new x0(e0Var.h());
    }

    @Override // fc.p2
    public z i() {
        return a(this.f10248a);
    }

    y0(e0 e0Var) {
        this.f10248a = e0Var;
    }

    @Override // fc.f
    public z f() {
        try {
            return i();
        } catch (IOException e10) {
            throw new IllegalStateException(e10.getMessage());
        }
    }
}
