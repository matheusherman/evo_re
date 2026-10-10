package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u001f\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u001d\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\b\u001a-\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a/\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0007¢\u0006\u0004\b\b\u0010\t\u001a%\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a-\u0010\r\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\r\u0010\u0006\u001a1\u0010\u0011\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0004\b\u0011\u0010\u0012\u001a1\u0010\u0013\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0004\b\u0013\u0010\u0012\u001a;\u0010\u0015\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u000f2\u0006\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001f\u0010\u0018\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001f\u0010\u001a\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0007¢\u0006\u0004\b\u001a\u0010\u0019\u001a1\u0010\u001b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00172\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0004\b\u001b\u0010\u001c\u001a;\u0010\u001d\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00172\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u000f2\u0006\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "", "elements", "", "C", "(Ljava/util/Collection;Ljava/lang/Iterable;)Z", "", "D", "(Ljava/util/Collection;[Ljava/lang/Object;)Z", "", ExifInterface.LONGITUDE_EAST, "(Ljava/lang/Iterable;)Ljava/util/Collection;", "M", "", "Lkotlin/Function1;", "predicate", "H", "(Ljava/lang/Iterable;Lc9/l;)Z", "L", "predicateResultToRemove", "F", "(Ljava/lang/Iterable;Lc9/l;Z)Z", "", "J", "(Ljava/util/List;)Ljava/lang/Object;", "K", "I", "(Ljava/util/List;Lc9/l;)Z", "G", "(Ljava/util/List;Lc9/l;Z)Z", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
public class y extends x {
    public static <T> boolean C(Collection<? super T> collection, Iterable<? extends T> elements) {
        kotlin.jvm.internal.m.f(collection, "<this>");
        kotlin.jvm.internal.m.f(elements, "elements");
        if (elements instanceof Collection) {
            return collection.addAll((Collection) elements);
        }
        Iterator<? extends T> it = elements.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z10 = true;
            }
        }
        return z10;
    }

    public static <T> boolean D(Collection<? super T> collection, T[] elements) {
        kotlin.jvm.internal.m.f(collection, "<this>");
        kotlin.jvm.internal.m.f(elements, "elements");
        return collection.addAll(m.d(elements));
    }

    public static final <T> Collection<T> E(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        return iterable instanceof Collection ? (Collection) iterable : c0.O0(iterable);
    }

    private static final <T> boolean G(List<T> list, c9.l<? super T, Boolean> lVar, boolean z10) {
        int i10;
        if (!(list instanceof RandomAccess)) {
            kotlin.jvm.internal.m.d(list, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T of kotlin.collections.CollectionsKt__MutableCollectionsKt.filterInPlace>");
            return F(kotlin.jvm.internal.h0.b(list), lVar, z10);
        }
        int iN = t.n(list);
        if (iN >= 0) {
            int i11 = 0;
            i10 = 0;
            while (true) {
                T t10 = list.get(i11);
                if (lVar.invoke(t10).booleanValue() != z10) {
                    if (i10 != i11) {
                        list.set(i10, t10);
                    }
                    i10++;
                }
                if (i11 == iN) {
                    break;
                }
                i11++;
            }
        } else {
            i10 = 0;
        }
        if (i10 >= list.size()) {
            return false;
        }
        int iN2 = t.n(list);
        if (i10 > iN2) {
            return true;
        }
        while (true) {
            list.remove(iN2);
            if (iN2 == i10) {
                return true;
            }
            iN2--;
        }
    }

    public static <T> boolean H(Iterable<? extends T> iterable, c9.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        kotlin.jvm.internal.m.f(predicate, "predicate");
        return F(iterable, predicate, true);
    }

    public static <T> boolean I(List<T> list, c9.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.m.f(list, "<this>");
        kotlin.jvm.internal.m.f(predicate, "predicate");
        return G(list, predicate, true);
    }

    public static <T> T J(List<T> list) {
        kotlin.jvm.internal.m.f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(0);
    }

    public static <T> T K(List<T> list) {
        kotlin.jvm.internal.m.f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(t.n(list));
    }

    public static <T> boolean L(Iterable<? extends T> iterable, c9.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        kotlin.jvm.internal.m.f(predicate, "predicate");
        return F(iterable, predicate, false);
    }

    public static final <T> boolean M(Collection<? super T> collection, Iterable<? extends T> elements) {
        kotlin.jvm.internal.m.f(collection, "<this>");
        kotlin.jvm.internal.m.f(elements, "elements");
        return collection.retainAll(E(elements));
    }

    private static final <T> boolean F(Iterable<? extends T> iterable, c9.l<? super T, Boolean> lVar, boolean z10) {
        Iterator<? extends T> it = iterable.iterator();
        boolean z11 = false;
        while (it.hasNext()) {
            if (lVar.invoke(it.next()).booleanValue() == z10) {
                it.remove();
                z11 = true;
            }
        }
        return z11;
    }
}
