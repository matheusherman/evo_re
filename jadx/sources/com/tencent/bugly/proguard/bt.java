package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class bt extends m implements Cloneable {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static bs f9030m = new bs();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static Map<String, String> f9031n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final /* synthetic */ boolean f9032o = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9033a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9034b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9035c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f9036d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f9037e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public bs f9038f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<String, String> f9039g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f9040h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f9041i = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f9042j = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f9043k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f9044l = 0;

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f9033a, 0);
        lVar.a(this.f9034b, 1);
        lVar.a(this.f9035c, 2);
        String str = this.f9036d;
        if (str != null) {
            lVar.a(str, 3);
        }
        String str2 = this.f9037e;
        if (str2 != null) {
            lVar.a(str2, 4);
        }
        bs bsVar = this.f9038f;
        if (bsVar != null) {
            lVar.a((m) bsVar, 5);
        }
        Map<String, String> map = this.f9039g;
        if (map != null) {
            lVar.a((Map) map, 6);
        }
        lVar.a(this.f9040h, 7);
        String str3 = this.f9041i;
        if (str3 != null) {
            lVar.a(str3, 8);
        }
        String str4 = this.f9042j;
        if (str4 != null) {
            lVar.a(str4, 9);
        }
        lVar.a(this.f9043k, 10);
        lVar.a(this.f9044l, 11);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        bt btVar = (bt) obj;
        return n.a(this.f9033a, btVar.f9033a) && n.a(this.f9034b, btVar.f9034b) && n.a(this.f9035c, btVar.f9035c) && n.a(this.f9036d, btVar.f9036d) && n.a(this.f9037e, btVar.f9037e) && n.a(this.f9038f, btVar.f9038f) && n.a(this.f9039g, btVar.f9039g) && n.a(this.f9040h, btVar.f9040h) && n.a(this.f9041i, btVar.f9041i) && n.a(this.f9042j, btVar.f9042j) && n.a(this.f9043k, btVar.f9043k) && n.a(this.f9044l, btVar.f9044l);
    }

    static {
        HashMap map = new HashMap();
        f9031n = map;
        map.put("", "");
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f9032o) {
                return null;
            }
            throw new AssertionError();
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f9033a = kVar.a(0, true);
        this.f9034b = kVar.a(1, true);
        this.f9035c = kVar.a(2, true);
        this.f9036d = kVar.b(3, false);
        this.f9037e = kVar.b(4, false);
        this.f9038f = (bs) kVar.a((m) f9030m, 5, false);
        this.f9039g = (Map) kVar.a(f9031n, 6, false);
        this.f9040h = kVar.a(this.f9040h, 7, false);
        this.f9041i = kVar.b(8, false);
        this.f9042j = kVar.b(9, false);
        this.f9043k = kVar.a(this.f9043k, 10, false);
        this.f9044l = kVar.a(this.f9044l, 11, false);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb2, int i10) {
        i iVar = new i(sb2, i10);
        iVar.a(this.f9033a, "enable");
        iVar.a(this.f9034b, "enableUserInfo");
        iVar.a(this.f9035c, "enableQuery");
        iVar.a(this.f9036d, IjkMediaPlayer.OnNativeInvokeListener.ARG_URL);
        iVar.a(this.f9037e, "expUrl");
        iVar.a((m) this.f9038f, "security");
        iVar.a((Map) this.f9039g, "valueMap");
        iVar.a(this.f9040h, "strategylastUpdateTime");
        iVar.a(this.f9041i, "httpsUrl");
        iVar.a(this.f9042j, "httpsExpUrl");
        iVar.a(this.f9043k, "eventRecordCount");
        iVar.a(this.f9044l, "eventTimeInterval");
    }
}
