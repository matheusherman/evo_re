package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class cb implements ec {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final lb f2593b = new bb();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final lb f2594a;

    public cb() {
        this(new db(fa.c(), f2593b));
    }

    @Override // com.google.android.gms.internal.measurement.ec
    public final <T> fc<T> a(Class<T> cls) {
        s9<?> s9VarA;
        hc.o(cls);
        mb mbVarA = this.f2594a.a(cls);
        if (mbVarA.d()) {
            return tb.j(hc.f(), t9.a(), mbVarA.b());
        }
        vb vbVarA = yb.a();
        ya yaVarA = ab.a();
        vc<?, ?> vcVarF = hc.f();
        if (eb.f2642a[mbVarA.c().ordinal()] != 1) {
            s9VarA = t9.a();
        } else {
            s9VarA = null;
        }
        return rb.n(cls, mbVarA, vbVarA, yaVarA, vcVarF, s9VarA, jb.a());
    }

    private cb(lb lbVar) {
        this.f2594a = (lb) ga.f(lbVar, "messageInfoFactory");
    }
}
