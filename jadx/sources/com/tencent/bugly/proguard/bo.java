package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class bo extends m {
    static ArrayList<bn> A;
    static Map<String, String> B;
    static Map<String, String> C;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    static Map<String, String> f8964v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    static bm f8965w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    static bl f8966x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    static ArrayList<bl> f8967y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    static ArrayList<bl> f8968z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8969a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f8970b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f8971c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f8972d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f8973e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f8974f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f8975g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<String, String> f8976h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f8977i = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public bm f8978j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f8979k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f8980l = "";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f8981m = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public bl f8982n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList<bl> f8983o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList<bl> f8984p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList<bn> f8985q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Map<String, String> f8986r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Map<String, String> f8987s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f8988t = "";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f8989u = true;

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f8969a, 0);
        lVar.a(this.f8970b, 1);
        lVar.a(this.f8971c, 2);
        String str = this.f8972d;
        if (str != null) {
            lVar.a(str, 3);
        }
        String str2 = this.f8973e;
        if (str2 != null) {
            lVar.a(str2, 4);
        }
        String str3 = this.f8974f;
        if (str3 != null) {
            lVar.a(str3, 5);
        }
        String str4 = this.f8975g;
        if (str4 != null) {
            lVar.a(str4, 6);
        }
        Map<String, String> map = this.f8976h;
        if (map != null) {
            lVar.a((Map) map, 7);
        }
        String str5 = this.f8977i;
        if (str5 != null) {
            lVar.a(str5, 8);
        }
        bm bmVar = this.f8978j;
        if (bmVar != null) {
            lVar.a((m) bmVar, 9);
        }
        lVar.a(this.f8979k, 10);
        String str6 = this.f8980l;
        if (str6 != null) {
            lVar.a(str6, 11);
        }
        String str7 = this.f8981m;
        if (str7 != null) {
            lVar.a(str7, 12);
        }
        bl blVar = this.f8982n;
        if (blVar != null) {
            lVar.a((m) blVar, 13);
        }
        ArrayList<bl> arrayList = this.f8983o;
        if (arrayList != null) {
            lVar.a((Collection) arrayList, 14);
        }
        ArrayList<bl> arrayList2 = this.f8984p;
        if (arrayList2 != null) {
            lVar.a((Collection) arrayList2, 15);
        }
        ArrayList<bn> arrayList3 = this.f8985q;
        if (arrayList3 != null) {
            lVar.a((Collection) arrayList3, 16);
        }
        Map<String, String> map2 = this.f8986r;
        if (map2 != null) {
            lVar.a((Map) map2, 17);
        }
        Map<String, String> map3 = this.f8987s;
        if (map3 != null) {
            lVar.a((Map) map3, 18);
        }
        String str8 = this.f8988t;
        if (str8 != null) {
            lVar.a(str8, 19);
        }
        lVar.a(this.f8989u, 20);
    }

    static {
        HashMap map = new HashMap();
        f8964v = map;
        map.put("", "");
        f8965w = new bm();
        f8966x = new bl();
        f8967y = new ArrayList<>();
        f8967y.add(new bl());
        f8968z = new ArrayList<>();
        f8968z.add(new bl());
        A = new ArrayList<>();
        A.add(new bn());
        HashMap map2 = new HashMap();
        B = map2;
        map2.put("", "");
        HashMap map3 = new HashMap();
        C = map3;
        map3.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f8969a = kVar.b(0, true);
        this.f8970b = kVar.a(this.f8970b, 1, true);
        this.f8971c = kVar.b(2, true);
        this.f8972d = kVar.b(3, false);
        this.f8973e = kVar.b(4, false);
        this.f8974f = kVar.b(5, false);
        this.f8975g = kVar.b(6, false);
        this.f8976h = (Map) kVar.a(f8964v, 7, false);
        this.f8977i = kVar.b(8, false);
        this.f8978j = (bm) kVar.a((m) f8965w, 9, false);
        this.f8979k = kVar.a(this.f8979k, 10, false);
        this.f8980l = kVar.b(11, false);
        this.f8981m = kVar.b(12, false);
        this.f8982n = (bl) kVar.a((m) f8966x, 13, false);
        this.f8983o = (ArrayList) kVar.a(f8967y, 14, false);
        this.f8984p = (ArrayList) kVar.a(f8968z, 15, false);
        this.f8985q = (ArrayList) kVar.a(A, 16, false);
        this.f8986r = (Map) kVar.a(B, 17, false);
        this.f8987s = (Map) kVar.a(C, 18, false);
        this.f8988t = kVar.b(19, false);
        this.f8989u = kVar.a(20, false);
    }
}
