package fd;

import fc.q1;
import fc.s;
import fc.u1;
import fc.z;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class n extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f10334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f10335b;

    @Override // fc.s, fc.f
    public z f() {
        fc.g gVar = new fc.g();
        gVar.a(new fc.p(0L));
        gVar.a(new q1(this.f10334a));
        gVar.a(new q1(this.f10335b));
        return new u1(gVar);
    }

    public n(byte[] bArr, byte[] bArr2) {
        this.f10334a = re.a.d(bArr);
        this.f10335b = re.a.d(bArr2);
    }
}
