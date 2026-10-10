package com.google.android.gms.internal.measurement;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class w3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e0 f3177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final v6 f3178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final v6 f3179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final wa f3180d;

    public final s a(v6 v6Var, j6... j6VarArr) {
        s sVarA = s.f3010a0;
        for (j6 j6Var : j6VarArr) {
            sVarA = w8.a(j6Var);
            c5.b(this.f3179c);
            if ((sVarA instanceof v) || (sVarA instanceof t)) {
                sVarA = this.f3177a.a(v6Var, sVarA);
            }
        }
        return sVarA;
    }

    public final void b(String str, Callable<? extends n> callable) {
        this.f3180d.b(str, callable);
    }

    public w3() {
        e0 e0Var = new e0();
        this.f3177a = e0Var;
        v6 v6Var = new v6(null, e0Var);
        this.f3179c = v6Var;
        this.f3178b = v6Var.d();
        wa waVar = new wa();
        this.f3180d = waVar;
        v6Var.h("require", new tg(waVar));
        waVar.b("internal.platform", new Callable() { // from class: com.google.android.gms.internal.measurement.c3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new sg();
            }
        });
        v6Var.h("runtime.counter", new k(Double.valueOf(0.0d)));
    }
}
