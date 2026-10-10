package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.ke;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class zc extends bc {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f4278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Set<Integer> f4279e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<Integer, bd> f4280f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Long f4281g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Long f4282h;

    /* JADX WARN: Code duplicated, block: B:109:0x02de  */
    @WorkerThread
    final List<com.google.android.gms.internal.measurement.m5> A(String str, List<com.google.android.gms.internal.measurement.o5> list, List<com.google.android.gms.internal.measurement.y5> list2, Long l10, Long l11, boolean z10) {
        boolean z11;
        c0 c0Var;
        HashSet<Integer> hashSet;
        Map<Integer, com.google.android.gms.internal.measurement.v5> map;
        List<com.google.android.gms.internal.measurement.m4> list3;
        HashSet hashSet2;
        m1.g.e(str);
        m1.g.k(list);
        m1.g.k(list2);
        this.f4278d = str;
        this.f4279e = new HashSet();
        this.f4280f = new ArrayMap();
        this.f4281g = l10;
        this.f4282h = l11;
        Iterator<com.google.android.gms.internal.measurement.o5> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z11 = false;
                break;
            }
            if ("_s".equals(it.next().a0())) {
                z11 = true;
                break;
            }
        }
        boolean z12 = ke.a() && d().K(this.f4278d, g0.E0);
        boolean z13 = ke.a() && d().K(this.f4278d, g0.D0);
        if (z11) {
            m mVarR = r();
            String str2 = this.f4278d;
            mVarR.v();
            mVarR.n();
            m1.g.e(str2);
            ContentValues contentValues = new ContentValues();
            contentValues.put("current_session_count", (Integer) 0);
            try {
                mVarR.C().update("events", contentValues, "app_id = ?", new String[]{str2});
            } catch (SQLiteException e10) {
                mVarR.l().H().c("Error resetting session-scoped event counts. appId", p5.w(str2), e10);
            }
        }
        Map<Integer, List<com.google.android.gms.internal.measurement.m4>> mapK1 = Collections.EMPTY_MAP;
        if (z13 && z12) {
            mapK1 = r().k1(this.f4278d);
        }
        Map<Integer, List<com.google.android.gms.internal.measurement.m4>> map2 = mapK1;
        Map<Integer, com.google.android.gms.internal.measurement.v5> mapJ1 = r().j1(this.f4278d);
        if (!mapJ1.isEmpty()) {
            HashSet hashSet3 = new HashSet(mapJ1.keySet());
            if (z11) {
                String str3 = this.f4278d;
                Map<Integer, List<Integer>> mapL1 = r().l1(this.f4278d);
                m1.g.e(str3);
                m1.g.k(mapJ1);
                ArrayMap arrayMap = new ArrayMap();
                if (!mapJ1.isEmpty()) {
                    for (Integer num : mapJ1.keySet()) {
                        num.intValue();
                        com.google.android.gms.internal.measurement.v5 v5Var = mapJ1.get(num);
                        List<Integer> list4 = mapL1.get(num);
                        if (list4 == null || list4.isEmpty()) {
                            hashSet2 = hashSet3;
                            arrayMap.put(num, v5Var);
                        } else {
                            List<Long> listQ = o().Q(v5Var.b0(), list4);
                            if (!listQ.isEmpty()) {
                                com.google.android.gms.internal.measurement.v5.a aVarZ = v5Var.C().y().z(listQ);
                                aVarZ.D().E(o().Q(v5Var.d0(), list4));
                                ArrayList arrayList = new ArrayList();
                                for (com.google.android.gms.internal.measurement.n5 n5Var : v5Var.a0()) {
                                    HashSet hashSet4 = hashSet3;
                                    if (!list4.contains(Integer.valueOf(n5Var.n()))) {
                                        arrayList.add(n5Var);
                                    }
                                    hashSet3 = hashSet4;
                                }
                                hashSet2 = hashSet3;
                                aVarZ.v().x(arrayList);
                                ArrayList arrayList2 = new ArrayList();
                                for (com.google.android.gms.internal.measurement.w5 w5Var : v5Var.c0()) {
                                    if (!list4.contains(Integer.valueOf(w5Var.N()))) {
                                        arrayList2.add(w5Var);
                                    }
                                }
                                aVarZ.A().C(arrayList2);
                                arrayMap.put(num, (com.google.android.gms.internal.measurement.v5) ((com.google.android.gms.internal.measurement.ea) aVarZ.w()));
                            }
                        }
                        hashSet3 = hashSet2;
                    }
                }
                hashSet = hashSet3;
                map = arrayMap;
            } else {
                hashSet = hashSet3;
                map = mapJ1;
            }
            for (Integer num2 : hashSet) {
                num2.intValue();
                com.google.android.gms.internal.measurement.v5 v5Var2 = map.get(num2);
                BitSet bitSet = new BitSet();
                BitSet bitSet2 = new BitSet();
                ArrayMap arrayMap2 = new ArrayMap();
                if (v5Var2 != null && v5Var2.n() != 0) {
                    for (com.google.android.gms.internal.measurement.n5 n5Var2 : v5Var2.a0()) {
                        if (n5Var2.R()) {
                            arrayMap2.put(Integer.valueOf(n5Var2.n()), n5Var2.Q() ? Long.valueOf(n5Var2.M()) : null);
                        }
                    }
                }
                ArrayMap arrayMap3 = new ArrayMap();
                if (v5Var2 != null && v5Var2.Q() != 0) {
                    for (com.google.android.gms.internal.measurement.w5 w5Var2 : v5Var2.c0()) {
                        if (w5Var2.S() && w5Var2.n() > 0) {
                            arrayMap3.put(Integer.valueOf(w5Var2.N()), Long.valueOf(w5Var2.K(w5Var2.n() - 1)));
                        }
                        v5Var2 = v5Var2;
                    }
                }
                com.google.android.gms.internal.measurement.v5 v5Var3 = v5Var2;
                if (v5Var3 != null) {
                    for (int i10 = 0; i10 < (v5Var3.T() << 6); i10++) {
                        if (sc.f0(v5Var3.d0(), i10)) {
                            l().L().c("Filter already evaluated. audience ID, filter ID", num2, Integer.valueOf(i10));
                            bitSet2.set(i10);
                            if (sc.f0(v5Var3.b0(), i10)) {
                                bitSet.set(i10);
                            } else {
                                arrayMap2.remove(Integer.valueOf(i10));
                            }
                        } else {
                            arrayMap2.remove(Integer.valueOf(i10));
                        }
                    }
                }
                com.google.android.gms.internal.measurement.v5 v5Var4 = mapJ1.get(num2);
                if (z13 && z12 && (list3 = map2.get(num2)) != null && this.f4282h != null && this.f4281g != null) {
                    Iterator<com.google.android.gms.internal.measurement.m4> it2 = list3.iterator();
                    while (it2.hasNext()) {
                        com.google.android.gms.internal.measurement.m4 next = it2.next();
                        int iN = next.N();
                        Iterator<com.google.android.gms.internal.measurement.m4> it3 = it2;
                        long jLongValue = this.f4282h.longValue() / 1000;
                        if (next.W()) {
                            jLongValue = this.f4281g.longValue() / 1000;
                        }
                        if (arrayMap2.containsKey(Integer.valueOf(iN))) {
                            arrayMap2.put(Integer.valueOf(iN), Long.valueOf(jLongValue));
                        }
                        if (arrayMap3.containsKey(Integer.valueOf(iN))) {
                            arrayMap3.put(Integer.valueOf(iN), Long.valueOf(jLongValue));
                        }
                        it2 = it3;
                    }
                }
                this.f4280f.put(num2, new bd(this, this.f4278d, v5Var4, bitSet, bitSet2, arrayMap2, arrayMap3, null));
            }
        }
        if (!list.isEmpty()) {
            b bVar = new b(this, null);
            ArrayMap arrayMap4 = new ArrayMap();
            Iterator<com.google.android.gms.internal.measurement.o5> it4 = list.iterator();
            while (it4.hasNext()) {
                com.google.android.gms.internal.measurement.o5 next2 = it4.next();
                com.google.android.gms.internal.measurement.o5 o5VarA = bVar.a(this.f4278d, next2);
                if (o5VarA != null) {
                    m mVarR2 = r();
                    String str4 = this.f4278d;
                    String strA0 = o5VarA.a0();
                    c0 c0VarU0 = mVarR2.U0(str4, next2.a0());
                    if (c0VarU0 == null) {
                        mVarR2.l().M().c("Event aggregate wasn't created during raw event logging. appId, event", p5.w(str4), mVarR2.g().c(strA0));
                        c0Var = new c0(str4, next2.a0(), 1L, 1L, 1L, next2.X(), 0L, null, null, null, null);
                    } else {
                        c0Var = new c0(c0VarU0.f3440a, c0VarU0.f3441b, c0VarU0.f3442c + 1, c0VarU0.f3443d + 1, c0VarU0.f3444e + 1, c0VarU0.f3445f, c0VarU0.f3446g, c0VarU0.f3447h, c0VarU0.f3448i, c0VarU0.f3449j, c0VarU0.f3450k);
                    }
                    r().Z(c0Var);
                    if (!z10) {
                        long j10 = c0Var.f3442c;
                        String strA1 = o5VarA.a0();
                        Map<Integer, List<com.google.android.gms.internal.measurement.m4>> mapZ0 = (Map) arrayMap4.get(strA1);
                        if (mapZ0 == null) {
                            mapZ0 = r().Z0(this.f4278d, strA1);
                            arrayMap4.put(strA1, mapZ0);
                        }
                        for (Integer num3 : mapZ0.keySet()) {
                            int iIntValue = num3.intValue();
                            if (this.f4279e.contains(num3)) {
                                l().L().b("Skipping failed audience ID", num3);
                            } else {
                                boolean z14 = true;
                                for (com.google.android.gms.internal.measurement.m4 m4Var : mapZ0.get(num3)) {
                                    dd ddVar = new dd(this, this.f4278d, iIntValue, m4Var);
                                    boolean zK = ddVar.k(this.f4281g, this.f4282h, o5VarA, j10, c0Var, B(iIntValue, m4Var.N()));
                                    if (!zK) {
                                        this.f4279e.add(num3);
                                        z14 = zK;
                                        break;
                                    }
                                    z(num3).c(ddVar);
                                    z14 = zK;
                                }
                                if (!z14) {
                                    this.f4279e.add(num3);
                                }
                            }
                        }
                    }
                    it4 = it4;
                    bVar = bVar;
                }
            }
        }
        if (z10) {
            return new ArrayList();
        }
        if (!list2.isEmpty()) {
            ArrayMap arrayMap5 = new ArrayMap();
            for (com.google.android.gms.internal.measurement.y5 y5Var : list2) {
                String strA2 = y5Var.a0();
                Map<Integer, List<com.google.android.gms.internal.measurement.p4>> mapB1 = (Map) arrayMap5.get(strA2);
                if (mapB1 == null) {
                    mapB1 = r().b1(this.f4278d, strA2);
                    arrayMap5.put(strA2, mapB1);
                }
                for (Integer num4 : mapB1.keySet()) {
                    int iIntValue2 = num4.intValue();
                    if (this.f4279e.contains(num4)) {
                        l().L().b("Skipping failed audience ID", num4);
                        break;
                    }
                    boolean zK2 = true;
                    for (com.google.android.gms.internal.measurement.p4 p4Var : mapB1.get(num4)) {
                        if (l().D(2)) {
                            l().L().d("Evaluating filter. audience, filter, property", num4, p4Var.T() ? Integer.valueOf(p4Var.n()) : null, g().g(p4Var.O()));
                            l().L().b("Filter definition", o().M(p4Var));
                        }
                        if (!p4Var.T() || p4Var.n() > 256) {
                            l().M().c("Invalid property filter ID. appId, id", p5.w(this.f4278d), String.valueOf(p4Var.T() ? Integer.valueOf(p4Var.n()) : null));
                            zK2 = false;
                            break;
                        }
                        c cVar = new c(this, this.f4278d, iIntValue2, p4Var);
                        zK2 = cVar.k(this.f4281g, this.f4282h, y5Var, B(iIntValue2, p4Var.n()));
                        if (!zK2) {
                            this.f4279e.add(num4);
                            break;
                        }
                        z(num4).c(cVar);
                    }
                    if (!zK2) {
                        this.f4279e.add(num4);
                    }
                }
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Set<Integer> setKeySet = this.f4280f.keySet();
        setKeySet.removeAll(this.f4279e);
        for (Integer num5 : setKeySet) {
            int iIntValue3 = num5.intValue();
            bd bdVar = this.f4280f.get(num5);
            m1.g.k(bdVar);
            com.google.android.gms.internal.measurement.m5 m5VarA = bdVar.a(iIntValue3);
            arrayList3.add(m5VarA);
            m mVarR3 = r();
            String str5 = this.f4278d;
            com.google.android.gms.internal.measurement.v5 v5VarR = m5VarA.R();
            mVarR3.v();
            mVarR3.n();
            m1.g.e(str5);
            m1.g.k(v5VarR);
            byte[] bArrM = v5VarR.m();
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("app_id", str5);
            contentValues2.put("audience_id", num5);
            contentValues2.put("current_results", bArrM);
            try {
                try {
                    if (mVarR3.C().insertWithOnConflict("audience_filter_values", null, contentValues2, 5) == -1) {
                        mVarR3.l().H().b("Failed to insert filter results (got -1). appId", p5.w(str5));
                    }
                } catch (SQLiteException e11) {
                    e = e11;
                    mVarR3.l().H().c("Error storing filter results. appId", p5.w(str5), e);
                }
            } catch (SQLiteException e12) {
                e = e12;
            }
        }
        return arrayList3;
    }

    @Override // com.google.android.gms.measurement.internal.bc
    protected final boolean y() {
        return false;
    }

    private final boolean B(int i10, int i11) {
        bd bdVar = this.f4280f.get(Integer.valueOf(i10));
        if (bdVar == null) {
            return false;
        }
        return bdVar.f3433d.get(i11);
    }

    private final bd z(Integer num) {
        if (this.f4280f.containsKey(num)) {
            return this.f4280f.get(num);
        }
        bd bdVar = new bd(this, this.f4278d, null);
        this.f4280f.put(num, bdVar);
        return bdVar;
    }

    zc(gc gcVar) {
        super(gcVar);
    }
}
