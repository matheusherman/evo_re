package rc;

import fc.c0;
import fc.f;
import fc.g;
import fc.s;
import fc.u;
import fc.u1;
import fc.z;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class a extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private u f17905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f f17906b;

    public a(u uVar) {
        this.f17905a = uVar;
    }

    public a(u uVar, f fVar) {
        this.f17905a = uVar;
        this.f17906b = fVar;
    }

    public static a n(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj != null) {
            return new a(c0.z(obj));
        }
        return null;
    }

    @Override // fc.s, fc.f
    public z f() {
        g gVar = new g(2);
        gVar.a(this.f17905a);
        f fVar = this.f17906b;
        if (fVar != null) {
            gVar.a(fVar);
        }
        return new u1(gVar);
    }

    public u m() {
        return this.f17905a;
    }

    public f o() {
        return this.f17906b;
    }

    private a(c0 c0Var) {
        if (c0Var.size() >= 1 && c0Var.size() <= 2) {
            this.f17905a = u.C(c0Var.A(0));
            this.f17906b = c0Var.size() == 2 ? c0Var.A(1) : null;
        } else {
            throw new IllegalArgumentException("Bad sequence size: " + c0Var.size());
        }
    }
}
