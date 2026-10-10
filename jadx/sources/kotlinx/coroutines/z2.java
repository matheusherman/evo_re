package kotlinx.coroutines;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0001\u001a\u00020\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0003"}, d2 = {"Lr8/z;", "a", "(Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class z2 {
    public static final Object a(v8.f<? super r8.z> fVar) {
        kotlinx.coroutines.internal.j jVar;
        Object objC;
        v8.j context = fVar.getContext();
        y1.h(context);
        v8.f fVarB = kotlin.coroutines.intrinsics.b.b(fVar);
        if (fVarB instanceof kotlinx.coroutines.internal.j) {
            jVar = (kotlinx.coroutines.internal.j) fVarB;
        } else {
            jVar = null;
        }
        if (jVar == null) {
            objC = r8.z.f17874a;
        } else {
            if (jVar.dispatcher.isDispatchNeeded(context)) {
                jVar.n(context, r8.z.f17874a);
            } else {
                y2 y2Var = new y2();
                v8.j jVarPlus = context.plus(y2Var);
                r8.z zVar = r8.z.f17874a;
                jVar.n(jVarPlus, zVar);
                if (!y2Var.dispatcherWasUnconfined || kotlinx.coroutines.internal.k.d(jVar)) {
                    objC = kotlin.coroutines.intrinsics.b.c();
                } else {
                    objC = zVar;
                }
            }
            objC = kotlin.coroutines.intrinsics.b.c();
        }
        if (objC == kotlin.coroutines.intrinsics.b.c()) {
            kotlin.coroutines.jvm.internal.h.c(fVar);
        }
        if (objC == kotlin.coroutines.intrinsics.b.c()) {
            return objC;
        }
        return r8.z.f17874a;
    }
}
