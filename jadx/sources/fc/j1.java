package fc;

import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class j1 implements f, p2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e0 f10176a;

    static f2 a(e0 e0Var) throws i {
        try {
            return new f2(e0Var.h());
        } catch (IllegalArgumentException e10) {
            throw new i(e10.getMessage(), e10);
        }
    }

    @Override // fc.f
    public z f() {
        try {
            return i();
        } catch (IOException e10) {
            throw new y("unable to get DER object", e10);
        } catch (IllegalArgumentException e11) {
            throw new y("unable to get DER object", e11);
        }
    }

    @Override // fc.p2
    public z i() {
        return a(this.f10176a);
    }

    public j1(e0 e0Var) {
        this.f10176a = e0Var;
    }
}
