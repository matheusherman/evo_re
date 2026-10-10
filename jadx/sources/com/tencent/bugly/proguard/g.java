package com.tencent.bugly.proguard;

import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class g extends m {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static byte[] f9075k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static Map<String, String> f9076l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final /* synthetic */ boolean f9077m = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f9084g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<String, String> f9086i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map<String, String> f9087j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short f9078a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte f9079b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9080c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9081d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f9082e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f9083f = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f9085h = 0;

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f9078a, 1);
        lVar.a(this.f9079b, 2);
        lVar.a(this.f9080c, 3);
        lVar.a(this.f9081d, 4);
        lVar.a(this.f9082e, 5);
        lVar.a(this.f9083f, 6);
        lVar.a(this.f9084g, 7);
        lVar.a(this.f9085h, 8);
        lVar.a((Map) this.f9086i, 9);
        lVar.a((Map) this.f9087j, 10);
    }

    public final boolean equals(Object obj) {
        g gVar = (g) obj;
        return n.a(1, (int) gVar.f9078a) && n.a(1, (int) gVar.f9079b) && n.a(1, gVar.f9080c) && n.a(1, gVar.f9081d) && n.a((Object) 1, (Object) gVar.f9082e) && n.a((Object) 1, (Object) gVar.f9083f) && n.a((Object) 1, (Object) gVar.f9084g) && n.a(1, gVar.f9085h) && n.a((Object) 1, (Object) gVar.f9086i) && n.a((Object) 1, (Object) gVar.f9087j);
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f9077m) {
                return null;
            }
            throw new AssertionError();
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        try {
            this.f9078a = kVar.a(this.f9078a, 1, true);
            this.f9079b = kVar.a(this.f9079b, 2, true);
            this.f9080c = kVar.a(this.f9080c, 3, true);
            this.f9081d = kVar.a(this.f9081d, 4, true);
            this.f9082e = kVar.b(5, true);
            this.f9083f = kVar.b(6, true);
            if (f9075k == null) {
                f9075k = new byte[]{0};
            }
            this.f9084g = kVar.c(7, true);
            this.f9085h = kVar.a(this.f9085h, 8, true);
            if (f9076l == null) {
                HashMap map = new HashMap();
                f9076l = map;
                map.put("", "");
            }
            this.f9086i = (Map) kVar.a(f9076l, 9, true);
            if (f9076l == null) {
                HashMap map2 = new HashMap();
                f9076l = map2;
                map2.put("", "");
            }
            this.f9087j = (Map) kVar.a(f9076l, 10, true);
        } catch (Exception e10) {
            e10.printStackTrace();
            System.out.println("RequestPacket decode error " + f.a(this.f9084g));
            throw new RuntimeException(e10);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb2, int i10) {
        i iVar = new i(sb2, i10);
        iVar.a(this.f9078a, "iVersion");
        iVar.a(this.f9079b, "cPacketType");
        iVar.a(this.f9080c, "iMessageType");
        iVar.a(this.f9081d, "iRequestId");
        iVar.a(this.f9082e, "sServantName");
        iVar.a(this.f9083f, "sFuncName");
        iVar.a(this.f9084g, "sBuffer");
        iVar.a(this.f9085h, "iTimeout");
        iVar.a((Map) this.f9086i, "context");
        iVar.a((Map) this.f9087j, NotificationCompat.CATEGORY_STATUS);
    }
}
