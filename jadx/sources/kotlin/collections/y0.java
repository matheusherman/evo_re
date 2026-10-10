package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\u0006\u001a.\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a4\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0086\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a.\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\t\u0010\u0004\u001a4\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0086\u0002¢\u0006\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "element", "j", "(Ljava/util/Set;Ljava/lang/Object;)Ljava/util/Set;", "", "elements", "i", "(Ljava/util/Set;Ljava/lang/Iterable;)Ljava/util/Set;", "l", "k", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/collections/SetsKt")
public class y0 extends x0 {
    public static <T> Set<T> i(Set<? extends T> set, Iterable<? extends T> elements) {
        kotlin.jvm.internal.m.f(set, "<this>");
        kotlin.jvm.internal.m.f(elements, "elements");
        Collection<?> collectionE = y.E(elements);
        if (collectionE.isEmpty()) {
            return c0.S0(set);
        }
        if (!(collectionE instanceof Set)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(set);
            linkedHashSet.removeAll(collectionE);
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        for (T t10 : set) {
            if (!((Set) collectionE).contains(t10)) {
                linkedHashSet2.add(t10);
            }
        }
        return linkedHashSet2;
    }

    public static <T> Set<T> j(Set<? extends T> set, T t10) {
        kotlin.jvm.internal.m.f(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(p0.e(set.size()));
        boolean z10 = false;
        for (T t11 : set) {
            boolean z11 = true;
            if (!z10 && kotlin.jvm.internal.m.a(t11, t10)) {
                z10 = true;
                z11 = false;
            }
            if (z11) {
                linkedHashSet.add(t11);
            }
        }
        return linkedHashSet;
    }

    public static <T> Set<T> k(Set<? extends T> set, Iterable<? extends T> elements) {
        int size;
        kotlin.jvm.internal.m.f(set, "<this>");
        kotlin.jvm.internal.m.f(elements, "elements");
        Integer numX = u.x(elements);
        if (numX != null) {
            size = set.size() + numX.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(p0.e(size));
        linkedHashSet.addAll(set);
        y.C(linkedHashSet, elements);
        return linkedHashSet;
    }

    public static <T> Set<T> l(Set<? extends T> set, T t10) {
        kotlin.jvm.internal.m.f(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(p0.e(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(t10);
        return linkedHashSet;
    }
}
