package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class bn extends m implements Cloneable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static byte[] f8960d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte f8961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f8962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f8963c;

    public bn() {
        this.f8961a = (byte) 0;
        this.f8962b = "";
        this.f8963c = null;
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb2, int i10) {
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f8961a, 0);
        lVar.a(this.f8962b, 1);
        byte[] bArr = this.f8963c;
        if (bArr != null) {
            lVar.a(bArr, 2);
        }
    }

    public bn(byte b10, String str, byte[] bArr) {
        this.f8961a = b10;
        this.f8962b = str;
        this.f8963c = bArr;
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f8961a = kVar.a(this.f8961a, 0, true);
        this.f8962b = kVar.b(1, true);
        if (f8960d == null) {
            f8960d = new byte[]{0};
        }
        this.f8963c = kVar.c(2, false);
    }
}
