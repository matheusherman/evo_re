package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class bs extends m implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9028a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f9029b = "";

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb2, int i10) {
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f9028a, 0);
        lVar.a(this.f9029b, 1);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f9028a = kVar.b(0, true);
        this.f9029b = kVar.b(1, true);
    }
}
