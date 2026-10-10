package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f2598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private e f2599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<e> f2600c;

    public d() {
        this.f2598a = new e("", 0L, null);
        this.f2599b = new e("", 0L, null);
        this.f2600c = new ArrayList();
    }

    public final e a() {
        return this.f2598a;
    }

    public final void b(e eVar) {
        this.f2598a = eVar;
        this.f2599b = (e) eVar.clone();
        this.f2600c.clear();
    }

    public final void c(String str, long j10, Map<String, Object> map) {
        HashMap map2 = new HashMap();
        for (String str2 : map.keySet()) {
            map2.put(str2, e.c(str2, this.f2598a.b(str2), map.get(str2)));
        }
        this.f2600c.add(new e(str, j10, map2));
    }

    public final /* synthetic */ Object clone() {
        d dVar = new d((e) this.f2598a.clone());
        Iterator<e> it = this.f2600c.iterator();
        while (it.hasNext()) {
            dVar.f2600c.add((e) it.next().clone());
        }
        return dVar;
    }

    public final e d() {
        return this.f2599b;
    }

    public final void e(e eVar) {
        this.f2599b = eVar;
    }

    public final List<e> f() {
        return this.f2600c;
    }

    private d(e eVar) {
        this.f2598a = eVar;
        this.f2599b = (e) eVar.clone();
        this.f2600c = new ArrayList();
    }
}
