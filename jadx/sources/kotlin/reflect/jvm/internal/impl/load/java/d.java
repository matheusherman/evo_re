package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d extends a<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(x javaTypeEnhancementState) {
        super(javaTypeEnhancementState);
        kotlin.jvm.internal.m.f(javaTypeEnhancementState, "javaTypeEnhancementState");
    }

    private final List<String> y(kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> gVar) {
        if (!(gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.b)) {
            return gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.j ? kotlin.collections.r.e(((kotlin.reflect.jvm.internal.impl.resolve.constants.j) gVar).c().j()) : kotlin.collections.r.l();
        }
        List<? extends kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> listB = ((kotlin.reflect.jvm.internal.impl.resolve.constants.b) gVar).b();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listB.iterator();
        while (it.hasNext()) {
            kotlin.collections.r.C(arrayList, y((kotlin.reflect.jvm.internal.impl.resolve.constants.g) it.next()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.a
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Iterable<String> b(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar, boolean z10) {
        kotlin.jvm.internal.m.f(cVar, "<this>");
        Map<ba.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> mapA = cVar.a();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<ba.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> entry : mapA.entrySet()) {
            kotlin.collections.r.C(arrayList, (!z10 || kotlin.jvm.internal.m.a(entry.getKey(), b0.f13111c)) ? y(entry.getValue()) : kotlin.collections.r.l());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.a
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public ba.c i(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        kotlin.jvm.internal.m.f(cVar, "<this>");
        return cVar.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.a
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public Object j(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        kotlin.jvm.internal.m.f(cVar, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarI = ea.c.i(cVar);
        kotlin.jvm.internal.m.c(eVarI);
        return eVarI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.a
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public Iterable<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> k(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations;
        kotlin.jvm.internal.m.f(cVar, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarI = ea.c.i(cVar);
        return (eVarI == null || (annotations = eVarI.getAnnotations()) == null) ? kotlin.collections.r.l() : annotations;
    }
}
