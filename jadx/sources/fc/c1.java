package fc;

import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c1 implements f, p2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f10124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f10125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final e0 f10126c;

    @Override // fc.p2
    public z i() {
        return this.f10126c.c(this.f10124a, this.f10125b);
    }

    c1(int i10, int i11, e0 e0Var) {
        this.f10124a = i10;
        this.f10125b = i11;
        this.f10126c = e0Var;
    }

    @Override // fc.f
    public z f() {
        try {
            return i();
        } catch (IOException e10) {
            throw new y(e10.getMessage());
        }
    }
}
