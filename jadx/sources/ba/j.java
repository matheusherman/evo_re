package ba;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.n0;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import r8.p;
import r8.v;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f1012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c f1013b;

    static {
        c cVar = new c("java.lang");
        f1012a = cVar;
        c cVarC = cVar.c(f.l("annotation"));
        m.e(cVarC, "JAVA_LANG_PACKAGE.child(…identifier(\"annotation\"))");
        f1013b = cVarC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b k(String str) {
        return new b(i.f960a.b(), f.l(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b l(String str) {
        return new b(i.f960a.f(), f.l(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b m(String str) {
        return new b(i.f960a.c(), f.l(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b n(String str) {
        return new b(i.f960a.d(), f.l(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b o(String str) {
        return new b(i.f960a.e(), f.l(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b q(f fVar) {
        i iVar = i.f960a;
        return new b(iVar.a().h(), f.l(fVar.j() + iVar.a().j().j()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b r(String str) {
        return new b(i.f960a.g(), f.l(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b s(String str) {
        return new b(i.f960a.h(), f.l(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b t(b bVar) {
        return new b(i.f960a.f(), f.l('U' + bVar.j().j()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<V, K> p(Map<K, ? extends V> map) {
        Set<Map.Entry<K, ? extends V>> setEntrySet = map.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(h9.f.c(n0.e(r.w(setEntrySet, 10)), 16));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            p pVarA = v.a(entry.getValue(), entry.getKey());
            linkedHashMap.put(pVarA.c(), pVarA.d());
        }
        return linkedHashMap;
    }
}
