package rc;

import fc.c;
import fc.c0;
import fc.f;
import fc.g;
import fc.h1;
import fc.s;
import fc.u1;
import fc.z;
import java.util.Enumeration;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class b extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f17907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f17908b;

    public b(c0 c0Var) {
        if (c0Var.size() == 2) {
            Enumeration enumerationB = c0Var.B();
            this.f17907a = a.n(enumerationB.nextElement());
            this.f17908b = h1.I(enumerationB.nextElement());
        } else {
            throw new IllegalArgumentException("Bad sequence size: " + c0Var.size());
        }
    }

    public b(a aVar, f fVar) {
        this.f17908b = new h1(fVar);
        this.f17907a = aVar;
    }

    public static b n(Object obj) {
        if (obj instanceof b) {
            return (b) obj;
        }
        if (obj != null) {
            return new b(c0.z(obj));
        }
        return null;
    }

    @Override // fc.s, fc.f
    public z f() {
        g gVar = new g(2);
        gVar.a(this.f17907a);
        gVar.a(this.f17908b);
        return new u1(gVar);
    }

    public a m() {
        return this.f17907a;
    }

    public c o() {
        return this.f17908b;
    }

    public z q() {
        return z.u(this.f17908b.B());
    }

    public b(a aVar, byte[] bArr) {
        this.f17908b = new h1(bArr);
        this.f17907a = aVar;
    }
}
