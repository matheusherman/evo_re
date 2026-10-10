package com.google.android.gms.measurement.internal;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class i9 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f3711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Uri f3712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ String f3713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ String f3714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ h9 f3715e;

    i9(h9 h9Var, boolean z10, Uri uri, String str, String str2) {
        this.f3711a = z10;
        this.f3712b = uri;
        this.f3713c = str;
        this.f3714d = str2;
        this.f3715e = h9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h9.f(this.f3715e, this.f3711a, this.f3712b, this.f3713c, this.f3714d);
    }
}
