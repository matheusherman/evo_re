package sc;

import fc.g;
import fc.p;
import fc.s;
import fc.u1;
import fc.z;
import java.math.BigInteger;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class b extends s implements e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final BigInteger f18546d = BigInteger.valueOf(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BigInteger f18547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BigInteger f18548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f18549c;

    @Override // fc.s, fc.f
    public z f() {
        g gVar = new g(6);
        gVar.a(new p(f18546d));
        gVar.a(null);
        gVar.a(new a(null, this.f18549c));
        gVar.a(null);
        gVar.a(new p(this.f18547a));
        if (this.f18548b != null) {
            gVar.a(new p(this.f18548b));
        }
        return new u1(gVar);
    }
}
