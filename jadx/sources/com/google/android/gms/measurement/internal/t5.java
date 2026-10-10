package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class t5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public String f4053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public String f4054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f4055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public Bundle f4056d;

    public static t5 b(zzbj zzbjVar) {
        return new t5(zzbjVar.f4299a, zzbjVar.f4301c, zzbjVar.f4300b.S(), zzbjVar.f4302d);
    }

    public final zzbj a() {
        return new zzbj(this.f4053a, new zzbi(new Bundle(this.f4056d)), this.f4054b, this.f4055c);
    }

    public final String toString() {
        return "origin=" + this.f4054b + ",name=" + this.f4053a + ",params=" + String.valueOf(this.f4056d);
    }

    public t5(@NonNull String str, @NonNull String str2, @Nullable Bundle bundle, long j10) {
        this.f4053a = str;
        this.f4054b = str2;
        this.f4056d = bundle == null ? new Bundle() : bundle;
        this.f4055c = j10;
    }
}
