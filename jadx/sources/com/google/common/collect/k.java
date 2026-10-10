package com.google.common.collect;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class k<T> extends g0<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<T> comparator;

    @Override // com.google.common.collect.g0, java.util.Comparator
    public int compare(T t10, T t11) {
        return this.comparator.compare(t10, t11);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k) {
            return this.comparator.equals(((k) obj).comparator);
        }
        return false;
    }

    public int hashCode() {
        return this.comparator.hashCode();
    }

    public String toString() {
        return this.comparator.toString();
    }

    k(Comparator<T> comparator) {
        this.comparator = (Comparator) com.google.common.base.m.i(comparator);
    }
}
