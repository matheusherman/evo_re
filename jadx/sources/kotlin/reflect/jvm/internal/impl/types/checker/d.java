package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.a0;
import kotlin.reflect.jvm.internal.impl.types.d0;
import kotlin.reflect.jvm.internal.impl.types.h0;
import kotlin.reflect.jvm.internal.impl.types.i0;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.v1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d {
    public static final v1 a(List<? extends v1> types) {
        o0 o0VarR0;
        kotlin.jvm.internal.m.f(types, "types");
        int size = types.size();
        if (size == 0) {
            throw new IllegalStateException("Expected some types");
        }
        if (size == 1) {
            return (v1) kotlin.collections.r.F0(types);
        }
        List<? extends v1> list = types;
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list, 10));
        boolean z10 = false;
        boolean z11 = false;
        for (v1 v1Var : list) {
            z10 = z10 || i0.a(v1Var);
            if (v1Var instanceof o0) {
                o0VarR0 = (o0) v1Var;
            } else {
                if (!(v1Var instanceof a0)) {
                    throw new r8.n();
                }
                if (kotlin.reflect.jvm.internal.impl.types.w.a(v1Var)) {
                    return v1Var;
                }
                o0VarR0 = ((a0) v1Var).R0();
                z11 = true;
            }
            arrayList.add(o0VarR0);
        }
        if (z10) {
            return la.k.d(la.j.V1, types.toString());
        }
        if (!z11) {
            return w.f14262a.c(arrayList);
        }
        ArrayList arrayList2 = new ArrayList(kotlin.collections.r.w(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(d0.d((v1) it.next()));
        }
        w wVar = w.f14262a;
        return h0.d(wVar.c(arrayList), wVar.c(arrayList2));
    }
}
