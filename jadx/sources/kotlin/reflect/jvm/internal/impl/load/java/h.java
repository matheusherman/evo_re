package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class h {
    /* JADX INFO: Access modifiers changed from: private */
    public static final ba.c c(ba.c cVar, String str) {
        ba.c cVarC = cVar.c(ba.f.l(str));
        kotlin.jvm.internal.m.e(cVarC, "child(Name.identifier(name))");
        return cVarC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ba.c d(ba.d dVar, String str) {
        ba.c cVarL = dVar.c(ba.f.l(str)).l();
        kotlin.jvm.internal.m.e(cVarL, "child(Name.identifier(name)).toSafe()");
        return cVarL;
    }
}
