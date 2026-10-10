package com.google.common.base;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class l<T> implements Serializable {
    private static final long serialVersionUID = 0;

    public abstract T b();

    public abstract boolean c();

    public static <T> l<T> d(T t10) {
        return new o(m.i(t10));
    }

    l() {
    }

    public static <T> l<T> a() {
        return a.e();
    }
}
