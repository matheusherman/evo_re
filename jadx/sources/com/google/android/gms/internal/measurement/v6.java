package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class v6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v6 f3166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private e0 f3167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, s> f3168c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, Boolean> f3169d = new HashMap();

    public final s c(String str) {
        v6 v6Var = this;
        while (!v6Var.f3168c.containsKey(str)) {
            v6Var = v6Var.f3166a;
            if (v6Var == null) {
                throw new IllegalArgumentException(String.format("%s is not defined", str));
            }
        }
        return v6Var.f3168c.get(str);
    }

    public final boolean g(String str) {
        v6 v6Var = this;
        while (!v6Var.f3168c.containsKey(str)) {
            v6Var = v6Var.f3166a;
            if (v6Var == null) {
                return false;
            }
        }
        return true;
    }

    public final void h(String str, s sVar) {
        v6 v6Var;
        v6 v6Var2 = this;
        while (!v6Var2.f3168c.containsKey(str) && (v6Var = v6Var2.f3166a) != null && v6Var.g(str)) {
            v6Var2 = v6Var2.f3166a;
        }
        if (v6Var2.f3169d.containsKey(str)) {
            return;
        }
        if (sVar == null) {
            v6Var2.f3168c.remove(str);
        } else {
            v6Var2.f3168c.put(str, sVar);
        }
    }

    public final s a(g gVar) {
        s sVarA = s.f3010a0;
        Iterator<Integer> itY = gVar.y();
        while (itY.hasNext()) {
            sVarA = this.f3167b.a(this, gVar.q(itY.next().intValue()));
            if (sVarA instanceof l) {
                break;
            }
        }
        return sVarA;
    }

    public final s b(s sVar) {
        return this.f3167b.a(this, sVar);
    }

    public final v6 d() {
        return new v6(this, this.f3167b);
    }

    public final void e(String str, s sVar) {
        if (this.f3169d.containsKey(str)) {
            return;
        }
        if (sVar == null) {
            this.f3168c.remove(str);
        } else {
            this.f3168c.put(str, sVar);
        }
    }

    public v6(v6 v6Var, e0 e0Var) {
        this.f3166a = v6Var;
        this.f3167b = e0Var;
    }

    public final void f(String str, s sVar) {
        e(str, sVar);
        this.f3169d.put(str, Boolean.TRUE);
    }
}
