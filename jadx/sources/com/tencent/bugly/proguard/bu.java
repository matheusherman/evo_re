package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class bu extends m {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static Map<String, String> f9045i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f9046a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte f9047b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f9048c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f9049d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f9050e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, String> f9051f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f9052g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f9053h = true;

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f9046a, 0);
        lVar.a(this.f9047b, 1);
        String str = this.f9048c;
        if (str != null) {
            lVar.a(str, 2);
        }
        String str2 = this.f9049d;
        if (str2 != null) {
            lVar.a(str2, 3);
        }
        String str3 = this.f9050e;
        if (str3 != null) {
            lVar.a(str3, 4);
        }
        Map<String, String> map = this.f9051f;
        if (map != null) {
            lVar.a((Map) map, 5);
        }
        String str4 = this.f9052g;
        if (str4 != null) {
            lVar.a(str4, 6);
        }
        lVar.a(this.f9053h, 7);
    }

    static {
        HashMap map = new HashMap();
        f9045i = map;
        map.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f9046a = kVar.a(this.f9046a, 0, true);
        this.f9047b = kVar.a(this.f9047b, 1, true);
        this.f9048c = kVar.b(2, false);
        this.f9049d = kVar.b(3, false);
        this.f9050e = kVar.b(4, false);
        this.f9051f = (Map) kVar.a(f9045i, 5, false);
        this.f9052g = kVar.b(6, false);
        this.f9053h = kVar.a(7, false);
    }
}
