package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0012\u001a%\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001aQ\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0007\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\b\u0010\t\u001aa\u0010\f\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\nj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0007\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\f\u0010\r\u001a3\u0010\u000f\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u000e\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001aI\u0010\u0013\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\u00112\u001a\u0010\u0007\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005¢\u0006\u0004\b\u0013\u0010\u0014\u001aG\u0010\u0016\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\u00112\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0015¢\u0006\u0004\b\u0016\u0010\u0017\u001a;\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0015¢\u0006\u0004\b\u0018\u0010\u0019\u001aQ\u0010\u001c\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010\u001a*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\u0011*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u00152\u0006\u0010\u001b\u001a\u00028\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001aS\u0010\u001e\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010\u001a*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\u0011*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u00052\u0006\u0010\u001b\u001a\u00028\u0002¢\u0006\u0004\b\u001e\u0010\u001f\u001a9\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0007¢\u0006\u0004\b \u0010!\u001a9\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0007¢\u0006\u0004\b\"\u0010!\u001aP\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0014\u0010#\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0086\u0002¢\u0006\u0004\b$\u0010%\u001a7\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0000¢\u0006\u0004\b&\u0010!¨\u0006'"}, d2 = {"K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "i", "()Ljava/util/Map;", "", "Lr8/p;", "pairs", "l", "([Lr8/p;)Ljava/util/Map;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "k", "([Lr8/p;)Ljava/util/HashMap;", "key", "j", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "", "Lr8/z;", "p", "(Ljava/util/Map;[Lr8/p;)V", "", "o", "(Ljava/util/Map;Ljava/lang/Iterable;)V", "q", "(Ljava/lang/Iterable;)Ljava/util/Map;", "M", "destination", "r", "(Ljava/lang/Iterable;Ljava/util/Map;)Ljava/util/Map;", "t", "([Lr8/p;Ljava/util/Map;)Ljava/util/Map;", "s", "(Ljava/util/Map;)Ljava/util/Map;", "u", "map", "n", "(Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "m", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/collections/MapsKt")
public class q0 extends p0 {
    public static <K, V> Map<K, V> i() {
        f0 f0Var = f0.f12293a;
        kotlin.jvm.internal.m.d(f0Var, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return f0Var;
    }

    public static <K, V> V j(Map<K, ? extends V> map, K k10) {
        kotlin.jvm.internal.m.f(map, "<this>");
        return (V) o0.a(map, k10);
    }

    public static <K, V> HashMap<K, V> k(r8.p<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.m.f(pairs, "pairs");
        HashMap<K, V> map = new HashMap<>(p0.e(pairs.length));
        p(map, pairs);
        return map;
    }

    public static <K, V> Map<K, V> l(r8.p<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.m.f(pairs, "pairs");
        return pairs.length > 0 ? t(pairs, new LinkedHashMap(p0.e(pairs.length))) : i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> m(Map<K, ? extends V> map) {
        kotlin.jvm.internal.m.f(map, "<this>");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? map : p0.g(map);
        }
        return i();
    }

    public static <K, V> Map<K, V> n(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2) {
        kotlin.jvm.internal.m.f(map, "<this>");
        kotlin.jvm.internal.m.f(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    public static final <K, V> void o(Map<? super K, ? super V> map, Iterable<? extends r8.p<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.m.f(map, "<this>");
        kotlin.jvm.internal.m.f(pairs, "pairs");
        for (r8.p<? extends K, ? extends V> pVar : pairs) {
            map.put(pVar.a(), pVar.b());
        }
    }

    public static final <K, V> void p(Map<? super K, ? super V> map, r8.p<? extends K, ? extends V>[] pairs) {
        kotlin.jvm.internal.m.f(map, "<this>");
        kotlin.jvm.internal.m.f(pairs, "pairs");
        for (r8.p<? extends K, ? extends V> pVar : pairs) {
            map.put(pVar.a(), pVar.b());
        }
    }

    public static <K, V> Map<K, V> q(Iterable<? extends r8.p<? extends K, ? extends V>> iterable) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return m(r(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return i();
        }
        if (size != 1) {
            return r(iterable, new LinkedHashMap(p0.e(collection.size())));
        }
        return p0.f((r8.p) (iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next()));
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M r(Iterable<? extends r8.p<? extends K, ? extends V>> iterable, M destination) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        kotlin.jvm.internal.m.f(destination, "destination");
        o(destination, iterable);
        return destination;
    }

    public static <K, V> Map<K, V> s(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.m.f(map, "<this>");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? u(map) : p0.g(map);
        }
        return i();
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M t(r8.p<? extends K, ? extends V>[] pVarArr, M destination) {
        kotlin.jvm.internal.m.f(pVarArr, "<this>");
        kotlin.jvm.internal.m.f(destination, "destination");
        p(destination, pVarArr);
        return destination;
    }

    public static <K, V> Map<K, V> u(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.m.f(map, "<this>");
        return new LinkedHashMap(map);
    }
}
