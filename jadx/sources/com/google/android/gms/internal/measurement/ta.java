package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class ta<K> implements Iterator<Map.Entry<K, Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Iterator<Map.Entry<K, Object>> f3081a;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3081a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.f3081a.next();
        return next.getValue() instanceof ra ? new qa(next, null) : next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f3081a.remove();
    }

    public ta(Iterator<Map.Entry<K, Object>> it) {
        this.f3081a = it;
    }
}
