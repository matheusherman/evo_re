package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TreeMap<Integer, t> f2546a = new TreeMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TreeMap<Integer, t> f2547b = new TreeMap<>();

    public final void b(v6 v6Var, d dVar) {
        wc wcVar = new wc(dVar);
        for (Integer num : this.f2546a.keySet()) {
            e eVar = (e) dVar.d().clone();
            int iA = a(v6Var, this.f2546a.get(num), wcVar);
            if (iA == 2 || iA == -1) {
                dVar.e(eVar);
            }
        }
        Iterator<Integer> it = this.f2547b.keySet().iterator();
        while (it.hasNext()) {
            a(v6Var, this.f2547b.get(it.next()), wcVar);
        }
    }

    public final void c(String str, int i10, t tVar, String str2) {
        TreeMap<Integer, t> treeMap;
        if ("create".equals(str2)) {
            treeMap = this.f2547b;
        } else {
            if (!"edit".equals(str2)) {
                throw new IllegalStateException("Unknown callback type: " + str2);
            }
            treeMap = this.f2546a;
        }
        if (treeMap.containsKey(Integer.valueOf(i10))) {
            i10 = treeMap.lastKey().intValue() + 1;
        }
        treeMap.put(Integer.valueOf(i10), tVar);
    }

    private static int a(v6 v6Var, t tVar, s sVar) {
        s sVarA = tVar.a(v6Var, Collections.singletonList(sVar));
        if (sVarA instanceof k) {
            return c5.i(sVarA.g().doubleValue());
        }
        return -1;
    }
}
