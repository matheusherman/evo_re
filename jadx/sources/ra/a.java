package ra;

import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;
import sa.f;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class a {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Collection<T> a(Collection<? extends T> collection, Collection<? extends T> collection2) {
        m.f(collection2, "collection");
        if (collection2.isEmpty()) {
            return collection;
        }
        if (collection == 0) {
            return collection2;
        }
        if (collection instanceof LinkedHashSet) {
            ((LinkedHashSet) collection).addAll(collection2);
            return collection;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        linkedHashSet.addAll(collection2);
        return linkedHashSet;
    }

    public static final f<h> b(Iterable<? extends h> scopes) {
        m.f(scopes, "scopes");
        f<h> fVar = new f<>();
        for (h hVar : scopes) {
            h hVar2 = hVar;
            if (hVar2 != null && hVar2 != h.b.f14005b) {
                fVar.add(hVar);
            }
        }
        return fVar;
    }
}
