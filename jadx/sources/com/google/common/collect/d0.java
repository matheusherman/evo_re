package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class d0 extends g0<Comparable<?>> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final d0 f4592a = new d0();
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return f4592a;
    }

    public String toString() {
        return "Ordering.natural()";
    }

    private d0() {
    }

    @Override // com.google.common.collect.g0, java.util.Comparator
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable<?> comparable, Comparable<?> comparable2) {
        com.google.common.base.m.i(comparable);
        com.google.common.base.m.i(comparable2);
        return comparable.compareTo(comparable2);
    }
}
