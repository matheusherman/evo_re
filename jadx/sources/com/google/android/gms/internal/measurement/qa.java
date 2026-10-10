package com.google.android.gms.internal.measurement;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class qa<K> implements Map.Entry<K, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map.Entry<K, ra> f2968a;

    /* synthetic */ qa(Map.Entry entry, sa saVar) {
        this(entry);
    }

    private qa(Map.Entry<K, ra> entry) {
        this.f2968a = entry;
    }

    public final ra a() {
        return this.f2968a.getValue();
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.f2968a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f2968a.getValue() == null) {
            return null;
        }
        throw new NoSuchMethodError();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof ob) {
            return this.f2968a.getValue().b((ob) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
