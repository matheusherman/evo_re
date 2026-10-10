package kotlin.reflect.jvm.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class i0 extends kotlin.jvm.internal.d0 {
    @Override // kotlin.jvm.internal.d0
    public i9.g a(kotlin.jvm.internal.j jVar) {
        return new o(i(jVar), jVar.getName(), jVar.getSignature(), jVar.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.d0
    public i9.i d(kotlin.jvm.internal.p pVar) {
        return new q(i(pVar), pVar.getName(), pVar.getSignature(), pVar.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.d0
    public i9.l e(kotlin.jvm.internal.t tVar) {
        return new v(i(tVar), tVar.getName(), tVar.getSignature(), tVar.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.d0
    public i9.m f(kotlin.jvm.internal.v vVar) {
        return new w(i(vVar), vVar.getName(), vVar.getSignature(), vVar.getBoundReceiver());
    }

    private static n i(kotlin.jvm.internal.c cVar) {
        i9.f owner = cVar.getOwner();
        if (owner instanceof n) {
            return (n) owner;
        }
        return f.f12426d;
    }

    @Override // kotlin.jvm.internal.d0
    public i9.d b(Class cls) {
        return c.a(cls);
    }

    @Override // kotlin.jvm.internal.d0
    public i9.f c(Class cls, String str) {
        return c.b(cls);
    }

    @Override // kotlin.jvm.internal.d0
    public String g(kotlin.jvm.internal.i iVar) {
        o oVarC;
        i9.g gVarA = k9.d.a(iVar);
        if (gVarA != null && (oVarC = n0.c(gVarA)) != null) {
            return j0.f14485a.e(oVarC.w());
        }
        return super.g(iVar);
    }

    @Override // kotlin.jvm.internal.d0
    public String h(kotlin.jvm.internal.o oVar) {
        return g(oVar);
    }
}
