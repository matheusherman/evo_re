package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class w {
    public static final ba.b a(y9.c cVar, int i10) {
        kotlin.jvm.internal.m.f(cVar, "<this>");
        ba.b bVarF = ba.b.f(cVar.a(i10), cVar.b(i10));
        kotlin.jvm.internal.m.e(bVarF, "fromString(getQualifiedC… isLocalClassName(index))");
        return bVarF;
    }

    public static final ba.f b(y9.c cVar, int i10) {
        kotlin.jvm.internal.m.f(cVar, "<this>");
        ba.f fVarK = ba.f.k(cVar.getString(i10));
        kotlin.jvm.internal.m.e(fVarK, "guessByFirstCharacter(getString(index))");
        return fVarK;
    }
}
