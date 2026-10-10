package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.r;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class j {
    public static final Set<ba.f> a(Iterable<? extends h> iterable) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        HashSet hashSet = new HashSet();
        Iterator<? extends h> it = iterable.iterator();
        while (it.hasNext()) {
            Set<ba.f> setF = it.next().f();
            if (setF == null) {
                return null;
            }
            r.C(hashSet, setF);
        }
        return hashSet;
    }
}
