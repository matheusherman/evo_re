package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class r<K, V> extends e<K, V> implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final transient q<K, ? extends o<V>> f4674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final transient int f4675b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map<K, Collection<V>> f4676a = h0.c();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Comparator<? super K> f4677b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Comparator<? super V> f4678c;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final m0.b<r> f4679a = m0.a(r.class, "map");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final m0.b<r> f4680b = m0.a(r.class, "size");
    }

    @Override // com.google.common.collect.d
    public boolean b(Object obj) {
        return obj != null && super.b(obj);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.a0
    /* JADX INFO: renamed from: c */
    public q<K, Collection<V>> a() {
        return this.f4674a;
    }

    r(q<K, ? extends o<V>> qVar, int i10) {
        this.f4674a = qVar;
        this.f4675b = i10;
    }

    @Override // com.google.common.collect.d
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.d
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.d
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
