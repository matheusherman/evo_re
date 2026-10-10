package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class br extends m {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static byte[] f9018i = {0};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static Map<String, String> f9019j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte f9020a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9021b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f9022c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f9023d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f9024e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f9025f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f9026g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<String, String> f9027h = null;

    static {
        HashMap map = new HashMap();
        f9019j = map;
        map.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f9020a, 0);
        lVar.a(this.f9021b, 1);
        byte[] bArr = this.f9022c;
        if (bArr != null) {
            lVar.a(bArr, 2);
        }
        String str = this.f9023d;
        if (str != null) {
            lVar.a(str, 3);
        }
        lVar.a(this.f9024e, 4);
        String str2 = this.f9025f;
        if (str2 != null) {
            lVar.a(str2, 5);
        }
        String str3 = this.f9026g;
        if (str3 != null) {
            lVar.a(str3, 6);
        }
        Map<String, String> map = this.f9027h;
        if (map != null) {
            lVar.a((Map) map, 7);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f9020a = kVar.a(this.f9020a, 0, true);
        this.f9021b = kVar.a(this.f9021b, 1, true);
        this.f9022c = kVar.c(2, false);
        this.f9023d = kVar.b(3, false);
        this.f9024e = kVar.a(this.f9024e, 4, false);
        this.f9025f = kVar.b(5, false);
        this.f9026g = kVar.b(6, false);
        this.f9027h = (Map) kVar.a(f9019j, 7, false);
    }
}
