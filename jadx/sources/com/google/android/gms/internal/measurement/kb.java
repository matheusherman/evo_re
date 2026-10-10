package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class kb implements hb {
    @Override // com.google.android.gms.internal.measurement.hb
    public final Object h(Object obj) {
        ((ib) obj).h();
        return obj;
    }

    @Override // com.google.android.gms.internal.measurement.hb
    public final fb<?, ?> a(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.hb
    public final Map<?, ?> c(Object obj) {
        return (ib) obj;
    }

    @Override // com.google.android.gms.internal.measurement.hb
    public final Map<?, ?> d(Object obj) {
        return (ib) obj;
    }

    @Override // com.google.android.gms.internal.measurement.hb
    public final Object f(Object obj, Object obj2) {
        ib ibVarE = (ib) obj;
        ib ibVar = (ib) obj2;
        if (!ibVar.isEmpty()) {
            if (!ibVarE.i()) {
                ibVarE = ibVarE.e();
            }
            ibVarE.d(ibVar);
        }
        return ibVarE;
    }

    @Override // com.google.android.gms.internal.measurement.hb
    public final boolean g(Object obj) {
        return !((ib) obj).i();
    }

    @Override // com.google.android.gms.internal.measurement.hb
    public final int i(int i10, Object obj, Object obj2) {
        ib ibVar = (ib) obj;
        if (ibVar.isEmpty()) {
            return 0;
        }
        Iterator it = ibVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    kb() {
    }

    @Override // com.google.android.gms.internal.measurement.hb
    public final Object e(Object obj) {
        return ib.c().e();
    }
}
