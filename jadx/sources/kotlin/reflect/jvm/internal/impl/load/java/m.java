package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.n0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f13410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<ba.b, ba.b> f13411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<ba.c, ba.c> f13412c;

    static {
        m mVar = new m();
        f13410a = mVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        f13411b = linkedHashMap;
        ba.i iVar = ba.i.f960a;
        mVar.c(iVar.l(), mVar.a("java.util.ArrayList", "java.util.LinkedList"));
        mVar.c(iVar.n(), mVar.a("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        mVar.c(iVar.m(), mVar.a("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        ba.b bVarM = ba.b.m(new ba.c("java.util.function.Function"));
        kotlin.jvm.internal.m.e(bVarM, "topLevel(FqName(\"java.util.function.Function\"))");
        mVar.c(bVarM, mVar.a("java.util.function.UnaryOperator"));
        ba.b bVarM2 = ba.b.m(new ba.c("java.util.function.BiFunction"));
        kotlin.jvm.internal.m.e(bVarM2, "topLevel(FqName(\"java.util.function.BiFunction\"))");
        mVar.c(bVarM2, mVar.a("java.util.function.BinaryOperator"));
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            arrayList.add(r8.v.a(((ba.b) entry.getKey()).b(), ((ba.b) entry.getValue()).b()));
        }
        f13412c = n0.q(arrayList);
    }

    private final List<ba.b> a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(ba.b.m(new ba.c(str)));
        }
        return arrayList;
    }

    private final void c(ba.b bVar, List<ba.b> list) {
        Map<ba.b, ba.b> map = f13411b;
        for (Object obj : list) {
            map.put((ba.b) obj, bVar);
        }
    }

    public final ba.c b(ba.c classFqName) {
        kotlin.jvm.internal.m.f(classFqName, "classFqName");
        return f13412c.get(classFqName);
    }

    private m() {
    }
}
