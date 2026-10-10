package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, a0> f2624a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private t0 f2625b = new t0();

    private final void b(a0 a0Var) {
        Iterator<y0> it = a0Var.f2523a.iterator();
        while (it.hasNext()) {
            this.f2624a.put(it.next().toString(), a0Var);
        }
    }

    public e0() {
        b(new y());
        b(new d0());
        b(new f0());
        b(new j0());
        b(new l0());
        b(new r0());
        b(new w0());
    }

    public final s a(v6 v6Var, s sVar) {
        a0 a0Var;
        c5.b(v6Var);
        if (sVar instanceof v) {
            v vVar = (v) sVar;
            ArrayList<s> arrayListB = vVar.b();
            String strA = vVar.a();
            if (this.f2624a.containsKey(strA)) {
                a0Var = this.f2624a.get(strA);
            } else {
                a0Var = this.f2625b;
            }
            return a0Var.b(strA, v6Var, arrayListB);
        }
        return sVar;
    }
}
