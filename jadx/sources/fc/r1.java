package fc;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class r1 implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private o2 f10217a;

    @Override // fc.w
    public InputStream e() {
        return this.f10217a;
    }

    @Override // fc.p2
    public z i() {
        return new q1(this.f10217a.f());
    }

    r1(o2 o2Var) {
        this.f10217a = o2Var;
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
