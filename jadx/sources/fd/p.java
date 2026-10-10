package fd;

import fc.c0;
import fc.q1;
import fc.s;
import fc.u1;
import fc.v;
import fc.z;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class p extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f10344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f10345b;

    private p(c0 c0Var) {
        if (!fc.p.z(c0Var.A(0)).B(0)) {
            throw new IllegalArgumentException("unknown version of sequence");
        }
        this.f10344a = re.a.d(v.z(c0Var.A(1)).A());
        this.f10345b = re.a.d(v.z(c0Var.A(2)).A());
    }

    public p(byte[] bArr, byte[] bArr2) {
        this.f10344a = re.a.d(bArr);
        this.f10345b = re.a.d(bArr2);
    }

    public static p m(Object obj) {
        if (obj instanceof p) {
            return (p) obj;
        }
        if (obj != null) {
            return new p(c0.z(obj));
        }
        return null;
    }

    @Override // fc.s, fc.f
    public z f() {
        fc.g gVar = new fc.g();
        gVar.a(new fc.p(0L));
        gVar.a(new q1(this.f10344a));
        gVar.a(new q1(this.f10345b));
        return new u1(gVar);
    }

    public byte[] n() {
        return re.a.d(this.f10344a);
    }

    public byte[] o() {
        return re.a.d(this.f10345b);
    }
}
