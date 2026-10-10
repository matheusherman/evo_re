package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class o8 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f3862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f3863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ long f3864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ Bundle f3865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ boolean f3866e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ boolean f3867f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ boolean f3868g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ String f3869h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ z7 f3870i;

    o8(z7 z7Var, String str, String str2, long j10, Bundle bundle, boolean z10, boolean z11, boolean z12, String str3) {
        this.f3862a = str;
        this.f3863b = str2;
        this.f3864c = j10;
        this.f3865d = bundle;
        this.f3866e = z10;
        this.f3867f = z11;
        this.f3868g = z12;
        this.f3869h = str3;
        this.f3870i = z7Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3870i.m0(this.f3862a, this.f3863b, this.f3864c, this.f3865d, this.f3866e, this.f3867f, this.f3868g, this.f3869h);
    }
}
