package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class hc implements v5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f3696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ List f3697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ gc f3698c;

    hc(gc gcVar, String str, List list) {
        this.f3696a = str;
        this.f3697b = list;
        this.f3698c = gcVar;
    }

    @Override // com.google.android.gms.measurement.internal.v5
    public final void a(String str, int i10, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.f3698c.T(true, i10, th, bArr, this.f3696a, this.f3697b);
    }
}
