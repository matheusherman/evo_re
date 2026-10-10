package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class og extends n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f2931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ lg f2932e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public og(lg lgVar, boolean z10, boolean z11) {
        super("log");
        this.f2932e = lgVar;
        this.f2930c = z10;
        this.f2931d = z11;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final s a(v6 v6Var, List<s> list) {
        c5.k("log", 1, list);
        if (list.size() == 1) {
            this.f2932e.f2850c.a(mg.INFO, v6Var.b(list.get(0)).f(), Collections.EMPTY_LIST, this.f2930c, this.f2931d);
            return s.f3010a0;
        }
        mg mgVarA = mg.a(c5.i(v6Var.b(list.get(0)).g().doubleValue()));
        String strF = v6Var.b(list.get(1)).f();
        if (list.size() == 2) {
            this.f2932e.f2850c.a(mgVarA, strF, Collections.EMPTY_LIST, this.f2930c, this.f2931d);
            return s.f3010a0;
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 2; i10 < Math.min(list.size(), 5); i10++) {
            arrayList.add(v6Var.b(list.get(i10)).f());
        }
        this.f2932e.f2850c.a(mgVarA, strF, arrayList, this.f2930c, this.f2931d);
        return s.f3010a0;
    }
}
