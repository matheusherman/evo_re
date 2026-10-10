package com.google.android.gms.measurement.internal;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.ke;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class bd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.google.android.gms.internal.measurement.v5 f3432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BitSet f3433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private BitSet f3434e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<Integer, Long> f3435f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<Integer, List<Long>> f3436g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zc f3437h;

    /* synthetic */ bd(zc zcVar, String str, b2.a aVar) {
        this(zcVar, str);
    }

    /* synthetic */ bd(zc zcVar, String str, com.google.android.gms.internal.measurement.v5 v5Var, BitSet bitSet, BitSet bitSet2, Map map, Map map2, b2.a aVar) {
        this(zcVar, str, v5Var, bitSet, bitSet2, map, map2);
    }

    private bd(zc zcVar, String str) {
        this.f3437h = zcVar;
        this.f3430a = str;
        this.f3431b = true;
        this.f3433d = new BitSet();
        this.f3434e = new BitSet();
        this.f3435f = new ArrayMap();
        this.f3436g = new ArrayMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.measurement.ea$b, com.google.android.gms.internal.measurement.m5$a] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r8v5, types: [com.google.android.gms.internal.measurement.v5$a] */
    @NonNull
    final com.google.android.gms.internal.measurement.m5 a(int i10) {
        ArrayList arrayList;
        ?? arrayList2;
        ?? N = com.google.android.gms.internal.measurement.m5.N();
        N.v(i10);
        N.z(this.f3431b);
        com.google.android.gms.internal.measurement.v5 v5Var = this.f3432c;
        if (v5Var != null) {
            N.y(v5Var);
        }
        ?? E = com.google.android.gms.internal.measurement.v5.X().z(sc.P(this.f3433d)).E(sc.P(this.f3434e));
        if (this.f3435f == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(this.f3435f.size());
            for (Integer num : this.f3435f.keySet()) {
                int iIntValue = num.intValue();
                Long l10 = this.f3435f.get(num);
                if (l10 != null) {
                    arrayList.add((com.google.android.gms.internal.measurement.n5) ((com.google.android.gms.internal.measurement.ea) com.google.android.gms.internal.measurement.n5.N().v(iIntValue).x(l10.longValue()).w()));
                }
            }
        }
        if (arrayList != null) {
            E.x(arrayList);
        }
        if (this.f3436g == null) {
            arrayList2 = Collections.EMPTY_LIST;
        } else {
            arrayList2 = new ArrayList(this.f3436g.size());
            for (Integer num2 : this.f3436g.keySet()) {
                com.google.android.gms.internal.measurement.w5.a aVarV = com.google.android.gms.internal.measurement.w5.O().v(num2.intValue());
                List<Long> list = this.f3436g.get(num2);
                if (list != null) {
                    Collections.sort(list);
                    aVarV.x(list);
                }
                arrayList2.add((com.google.android.gms.internal.measurement.w5) ((com.google.android.gms.internal.measurement.ea) aVarV.w()));
            }
        }
        E.C(arrayList2);
        N.x(E);
        return (com.google.android.gms.internal.measurement.m5) ((com.google.android.gms.internal.measurement.ea) N.w());
    }

    final void c(@NonNull d dVar) {
        int iA = dVar.a();
        Boolean bool = dVar.f3468c;
        if (bool != null) {
            this.f3434e.set(iA, bool.booleanValue());
        }
        Boolean bool2 = dVar.f3469d;
        if (bool2 != null) {
            this.f3433d.set(iA, bool2.booleanValue());
        }
        if (dVar.f3470e != null) {
            Long l10 = this.f3435f.get(Integer.valueOf(iA));
            long jLongValue = dVar.f3470e.longValue() / 1000;
            if (l10 == null || jLongValue > l10.longValue()) {
                this.f3435f.put(Integer.valueOf(iA), Long.valueOf(jLongValue));
            }
        }
        if (dVar.f3471f != null) {
            List<Long> arrayList = this.f3436g.get(Integer.valueOf(iA));
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f3436g.put(Integer.valueOf(iA), arrayList);
            }
            if (dVar.j()) {
                arrayList.clear();
            }
            if (ke.a() && this.f3437h.d().K(this.f3430a, g0.E0) && dVar.i()) {
                arrayList.clear();
            }
            if (ke.a() && this.f3437h.d().K(this.f3430a, g0.E0)) {
                long jLongValue2 = dVar.f3471f.longValue() / 1000;
                if (!arrayList.contains(Long.valueOf(jLongValue2))) {
                    arrayList.add(Long.valueOf(jLongValue2));
                    return;
                }
                return;
            }
            arrayList.add(Long.valueOf(dVar.f3471f.longValue() / 1000));
        }
    }

    private bd(zc zcVar, String str, com.google.android.gms.internal.measurement.v5 v5Var, BitSet bitSet, BitSet bitSet2, Map<Integer, Long> map, Map<Integer, Long> map2) {
        this.f3437h = zcVar;
        this.f3430a = str;
        this.f3433d = bitSet;
        this.f3434e = bitSet2;
        this.f3435f = map;
        this.f3436g = new ArrayMap();
        if (map2 != null) {
            for (Integer num : map2.keySet()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(map2.get(num));
                this.f3436g.put(num, arrayList);
            }
        }
        this.f3431b = false;
        this.f3432c = v5Var;
    }
}
