package com.google.common.collect;

import java.util.Comparator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class g0<T> implements Comparator<T> {
    @Override // java.util.Comparator
    public abstract int compare(T t10, T t11);

    public static <T> g0<T> a(Comparator<T> comparator) {
        return comparator instanceof g0 ? (g0) comparator : new k(comparator);
    }

    public static <C extends Comparable> g0<C> c() {
        return d0.f4592a;
    }

    public <F> g0<F> e(com.google.common.base.f<F, ? extends T> fVar) {
        return new f(fVar, this);
    }

    protected g0() {
    }

    public <E extends T> p<E> b(Iterable<E> iterable) {
        return p.A(this, iterable);
    }

    <T2 extends T> g0<Map.Entry<T2, ?>> d() {
        return (g0<Map.Entry<T2, ?>>) e(z.b());
    }
}
