package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class t extends n implements m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<String> f3046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<s> f3047d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private v6 f3048e;

    private t(t tVar) {
        super(tVar.f2886a);
        ArrayList arrayList = new ArrayList(tVar.f3046c.size());
        this.f3046c = arrayList;
        arrayList.addAll(tVar.f3046c);
        ArrayList arrayList2 = new ArrayList(tVar.f3047d.size());
        this.f3047d = arrayList2;
        arrayList2.addAll(tVar.f3047d);
        this.f3048e = tVar.f3048e;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final s a(v6 v6Var, List<s> list) {
        v6 v6VarD = this.f3048e.d();
        for (int i10 = 0; i10 < this.f3046c.size(); i10++) {
            if (i10 < list.size()) {
                v6VarD.e(this.f3046c.get(i10), v6Var.b(list.get(i10)));
            } else {
                v6VarD.e(this.f3046c.get(i10), s.f3010a0);
            }
        }
        for (s sVar : this.f3047d) {
            s sVarB = v6VarD.b(sVar);
            if (sVarB instanceof v) {
                sVarB = v6VarD.b(sVar);
            }
            if (sVarB instanceof l) {
                return ((l) sVarB).a();
            }
        }
        return s.f3010a0;
    }

    @Override // com.google.android.gms.internal.measurement.n, com.google.android.gms.internal.measurement.s
    public final s d() {
        return new t(this);
    }

    public t(String str, List<s> list, List<s> list2, v6 v6Var) {
        super(str);
        this.f3046c = new ArrayList();
        this.f3048e = v6Var;
        if (!list.isEmpty()) {
            Iterator<s> it = list.iterator();
            while (it.hasNext()) {
                this.f3046c.add(it.next().f());
            }
        }
        this.f3047d = new ArrayList(list2);
    }
}
