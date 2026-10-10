package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.f1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a {
    public static final f1 a(boolean z10, boolean z11, b typeSystemContext, f kotlinTypePreparator, g kotlinTypeRefiner) {
        kotlin.jvm.internal.m.f(typeSystemContext, "typeSystemContext");
        kotlin.jvm.internal.m.f(kotlinTypePreparator, "kotlinTypePreparator");
        kotlin.jvm.internal.m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new f1(z10, z11, true, typeSystemContext, kotlinTypePreparator, kotlinTypeRefiner);
    }

    public static /* synthetic */ f1 b(boolean z10, boolean z11, b bVar, f fVar, g gVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z11 = true;
        }
        if ((i10 & 4) != 0) {
            bVar = q.f14258a;
        }
        if ((i10 & 8) != 0) {
            fVar = f.a.f14236a;
        }
        if ((i10 & 16) != 0) {
            gVar = g.a.f14237a;
        }
        return a(z10, z11, bVar, fVar, gVar);
    }
}
