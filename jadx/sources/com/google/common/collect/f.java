package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class f<F, T> extends g0<F> implements Serializable {
    private static final long serialVersionUID = 0;
    final com.google.common.base.f<F, ? extends T> function;
    final g0<T> ordering;

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.function.equals(fVar.function) && this.ordering.equals(fVar.ordering)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.g0, java.util.Comparator
    public int compare(F f10, F f11) {
        return this.ordering.compare(this.function.apply(f10), this.function.apply(f11));
    }

    public int hashCode() {
        return com.google.common.base.k.b(this.function, this.ordering);
    }

    public String toString() {
        return this.ordering + ".onResultOf(" + this.function + ")";
    }

    f(com.google.common.base.f<F, ? extends T> fVar, g0<T> g0Var) {
        this.function = (com.google.common.base.f) com.google.common.base.m.i(fVar);
        this.ordering = (g0) com.google.common.base.m.i(g0Var);
    }
}
