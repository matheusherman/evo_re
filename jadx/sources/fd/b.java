package fd;

import fc.c0;
import fc.q1;
import fc.s;
import fc.u1;
import fc.v;
import fc.z;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f10256a;

    public b(c0 c0Var) {
        this.f10256a = re.a.d(v.z(c0Var.A(0)).A());
    }

    public b(byte[] bArr) {
        this.f10256a = bArr;
    }

    public static b m(Object obj) {
        if (obj instanceof a) {
            return (b) obj;
        }
        if (obj != null) {
            return new b(c0.z(obj));
        }
        return null;
    }

    @Override // fc.s, fc.f
    public z f() {
        fc.g gVar = new fc.g();
        gVar.a(new q1(this.f10256a));
        return new u1(gVar);
    }

    public byte[] n() {
        return re.a.d(this.f10256a);
    }
}
