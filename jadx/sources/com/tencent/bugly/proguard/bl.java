package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class bl extends m implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8952a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f8953b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f8954c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f8955d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f8956e = "";

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb2, int i10) {
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f8952a, 0);
        String str = this.f8953b;
        if (str != null) {
            lVar.a(str, 1);
        }
        String str2 = this.f8954c;
        if (str2 != null) {
            lVar.a(str2, 2);
        }
        String str3 = this.f8955d;
        if (str3 != null) {
            lVar.a(str3, 3);
        }
        String str4 = this.f8956e;
        if (str4 != null) {
            lVar.a(str4, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f8952a = kVar.b(0, true);
        this.f8953b = kVar.b(1, false);
        this.f8954c = kVar.b(2, false);
        this.f8955d = kVar.b(3, false);
        this.f8956e = kVar.b(4, false);
    }
}
