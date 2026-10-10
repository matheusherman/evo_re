package kotlin.jvm.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d0 {
    public i9.d b(Class cls) {
        return new e(cls);
    }

    public i9.f c(Class cls, String str) {
        return new s(cls, str);
    }

    public String g(i iVar) {
        String string = iVar.getClass().getGenericInterfaces()[0].toString();
        if (string.startsWith("kotlin.jvm.functions.")) {
            return string.substring(21);
        }
        return string;
    }

    public String h(o oVar) {
        return g(oVar);
    }

    public i9.g a(j jVar) {
        return jVar;
    }

    public i9.i d(p pVar) {
        return pVar;
    }

    public i9.l e(t tVar) {
        return tVar;
    }

    public i9.m f(v vVar) {
        return vVar;
    }
}
