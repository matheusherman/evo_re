package com.google.common.collect;

import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class v {
    private static <E> Collection<E> a(Iterable<E> iterable) {
        return iterable instanceof Collection ? (Collection) iterable : x.g(iterable.iterator());
    }

    public static <T> T b(Iterable<? extends T> iterable, T t10) {
        return (T) w.c(iterable.iterator(), t10);
    }

    static Object[] c(Iterable<?> iterable) {
        return a(iterable).toArray();
    }
}
