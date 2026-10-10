package kotlin.reflect.jvm.internal.impl.load.kotlin;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c {
    public static final v a(w9.n proto, y9.c nameResolver, y9.g typeTable, boolean z10, boolean z11, boolean z12) {
        kotlin.jvm.internal.m.f(proto, "proto");
        kotlin.jvm.internal.m.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.m.f(typeTable, "typeTable");
        kotlin.reflect.jvm.internal.impl.protobuf.i.f<w9.n, z9.a.d> propertySignature = z9.a.f23127d;
        kotlin.jvm.internal.m.e(propertySignature, "propertySignature");
        z9.a.d dVar = (z9.a.d) y9.e.a(proto, propertySignature);
        if (dVar == null) {
            return null;
        }
        if (z10) {
            aa.d.a aVarC = aa.i.f190a.c(proto, nameResolver, typeTable, z12);
            if (aVarC == null) {
                return null;
            }
            return v.f13620b.b(aVarC);
        }
        if (!z11 || !dVar.H()) {
            return null;
        }
        v.a aVar = v.f13620b;
        z9.a.c cVarC = dVar.C();
        kotlin.jvm.internal.m.e(cVarC, "signature.syntheticMethod");
        return aVar.c(nameResolver, cVarC);
    }

    public static /* synthetic */ v b(w9.n nVar, y9.c cVar, y9.g gVar, boolean z10, boolean z11, boolean z12, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        if ((i10 & 16) != 0) {
            z11 = false;
        }
        if ((i10 & 32) != 0) {
            z12 = true;
        }
        return a(nVar, cVar, gVar, z10, z11, z12);
    }
}
