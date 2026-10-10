package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.n0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f13202a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<ba.c, ba.f> f13203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<ba.f, List<ba.f>> f13204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<ba.c> f13205d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Set<ba.f> f13206e;

    static {
        ba.d dVar = kotlin.reflect.jvm.internal.impl.builtins.k.a.f12634s;
        r8.p pVarA = r8.v.a(h.d(dVar, "name"), ba.f.l("name"));
        r8.p pVarA2 = r8.v.a(h.d(dVar, "ordinal"), ba.f.l("ordinal"));
        r8.p pVarA3 = r8.v.a(h.c(kotlin.reflect.jvm.internal.impl.builtins.k.a.V, "size"), ba.f.l("size"));
        ba.c cVar = kotlin.reflect.jvm.internal.impl.builtins.k.a.Z;
        Map<ba.c, ba.f> mapL = n0.l(pVarA, pVarA2, pVarA3, r8.v.a(h.c(cVar, "size"), ba.f.l("size")), r8.v.a(h.d(kotlin.reflect.jvm.internal.impl.builtins.k.a.f12610g, "length"), ba.f.l("length")), r8.v.a(h.c(cVar, "keys"), ba.f.l("keySet")), r8.v.a(h.c(cVar, "values"), ba.f.l("values")), r8.v.a(h.c(cVar, "entries"), ba.f.l("entrySet")));
        f13203b = mapL;
        Set<Map.Entry<ba.c, ba.f>> setEntrySet = mapL.entrySet();
        ArrayList<r8.p> arrayList = new ArrayList(kotlin.collections.r.w(setEntrySet, 10));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            arrayList.add(new r8.p(((ba.c) entry.getKey()).g(), entry.getValue()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (r8.p pVar : arrayList) {
            ba.f fVar = (ba.f) pVar.d();
            Object arrayList2 = linkedHashMap.get(fVar);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(fVar, arrayList2);
            }
            ((List) arrayList2).add((ba.f) pVar.c());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(n0.e(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry2.getKey(), kotlin.collections.r.b0((Iterable) entry2.getValue()));
        }
        f13204c = linkedHashMap2;
        Set<ba.c> setKeySet = f13203b.keySet();
        f13205d = setKeySet;
        ArrayList arrayList3 = new ArrayList(kotlin.collections.r.w(setKeySet, 10));
        Iterator<T> it2 = setKeySet.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((ba.c) it2.next()).g());
        }
        f13206e = kotlin.collections.r.S0(arrayList3);
    }

    public final Map<ba.c, ba.f> a() {
        return f13203b;
    }

    public final List<ba.f> b(ba.f name1) {
        kotlin.jvm.internal.m.f(name1, "name1");
        List<ba.f> list = f13204c.get(name1);
        return list == null ? kotlin.collections.r.l() : list;
    }

    public final Set<ba.c> c() {
        return f13205d;
    }

    public final Set<ba.f> d() {
        return f13206e;
    }

    private g() {
    }
}
