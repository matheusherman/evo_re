package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class cc {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final cc f2595c = new cc();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentMap<Class<?>, fc<?>> f2597b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ec f2596a = new cb();

    public static cc a() {
        return f2595c;
    }

    public final <T> fc<T> b(Class<T> cls) {
        ga.f(cls, "messageType");
        fc<T> fcVarA = (fc) this.f2597b.get(cls);
        if (fcVarA == null) {
            fcVarA = this.f2596a.a(cls);
            ga.f(cls, "messageType");
            ga.f(fcVarA, "schema");
            fc<T> fcVar = (fc) this.f2597b.putIfAbsent(cls, fcVarA);
            if (fcVar != null) {
                return fcVar;
            }
        }
        return fcVarA;
    }

    private cc() {
    }

    public final <T> fc<T> c(T t10) {
        return b(t10.getClass());
    }
}
