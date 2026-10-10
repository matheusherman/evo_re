package com.live.evo.util;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class j1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile j1 f7247b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final io.reactivex.rxjava3.subjects.c f7248a = io.reactivex.rxjava3.subjects.a.z().x();

    public static j1 a() {
        j1 j1Var;
        j1 j1Var2 = f7247b;
        if (f7247b != null) {
            return j1Var2;
        }
        synchronized (j1.class) {
            try {
                j1Var = f7247b;
                if (f7247b == null) {
                    j1Var = new j1();
                    f7247b = j1Var;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return j1Var;
    }

    public void b(Object obj) {
        this.f7248a.a(obj);
    }

    public <T> g8.c<T> c(Class<T> cls) {
        return (g8.c<T>) this.f7248a.p(cls);
    }
}
