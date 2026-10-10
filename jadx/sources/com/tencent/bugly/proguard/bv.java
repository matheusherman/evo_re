package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class bv extends m implements Cloneable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static ArrayList<bu> f9054f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static Map<String, String> f9055g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte f9056a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f9057b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f9058c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<bu> f9059d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, String> f9060e = null;

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb2, int i10) {
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f9056a, 0);
        String str = this.f9057b;
        if (str != null) {
            lVar.a(str, 1);
        }
        String str2 = this.f9058c;
        if (str2 != null) {
            lVar.a(str2, 2);
        }
        ArrayList<bu> arrayList = this.f9059d;
        if (arrayList != null) {
            lVar.a((Collection) arrayList, 3);
        }
        Map<String, String> map = this.f9060e;
        if (map != null) {
            lVar.a((Map) map, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f9056a = kVar.a(this.f9056a, 0, true);
        this.f9057b = kVar.b(1, false);
        this.f9058c = kVar.b(2, false);
        if (f9054f == null) {
            f9054f = new ArrayList<>();
            f9054f.add(new bu());
        }
        this.f9059d = (ArrayList) kVar.a(f9054f, 3, false);
        if (f9055g == null) {
            HashMap map = new HashMap();
            f9055g = map;
            map.put("", "");
        }
        this.f9060e = (Map) kVar.a(f9055g, 4, false);
    }
}
