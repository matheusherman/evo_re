package kotlin.reflect.jvm.internal.impl.util;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class n<K, V, T extends V> extends a.AbstractC0272a<K, V, T> implements e9.c<a<K, V>, V> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(i9.d<? extends K> key, int i10) {
        super(key, i10);
        kotlin.jvm.internal.m.f(key, "key");
    }

    @Override // e9.c
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public T getValue(a<K, V> thisRef, i9.k<?> property) {
        kotlin.jvm.internal.m.f(thisRef, "thisRef");
        kotlin.jvm.internal.m.f(property, "property");
        return a(thisRef);
    }
}
