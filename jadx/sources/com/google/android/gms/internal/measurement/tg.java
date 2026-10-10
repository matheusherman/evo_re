package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class tg extends n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final wa f3089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<String, n> f3090d;

    public tg(wa waVar) {
        super("require");
        this.f3090d = new HashMap();
        this.f3089c = waVar;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final s a(v6 v6Var, List<s> list) {
        c5.g("require", 1, list);
        String strF = v6Var.b(list.get(0)).f();
        if (this.f3090d.containsKey(strF)) {
            return this.f3090d.get(strF);
        }
        s sVarA = this.f3089c.a(strF);
        if (sVarA instanceof n) {
            this.f3090d.put(strF, (n) sVarA);
        }
        return sVarA;
    }
}
