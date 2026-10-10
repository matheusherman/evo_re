package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final g0<p<x>> f14238a = new g0<>("KotlinTypeRefiner");

    public static final g0<p<x>> a() {
        return f14238a;
    }

    public static final List<kotlin.reflect.jvm.internal.impl.types.g0> b(g gVar, Iterable<? extends kotlin.reflect.jvm.internal.impl.types.g0> types) {
        kotlin.jvm.internal.m.f(gVar, "<this>");
        kotlin.jvm.internal.m.f(types, "types");
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(types, 10));
        Iterator<? extends kotlin.reflect.jvm.internal.impl.types.g0> it = types.iterator();
        while (it.hasNext()) {
            arrayList.add(gVar.a(it.next()));
        }
        return arrayList;
    }
}
