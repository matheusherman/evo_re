package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.measurement.zzdz;
import com.stub.StubApp;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class y7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f4222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    String f4223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    String f4224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    String f4225d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    Boolean f4226e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f4227f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    zzdz f4228g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f4229h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    Long f4230i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    String f4231j;

    public y7(Context context, @Nullable zzdz zzdzVar, @Nullable Long l10) {
        this.f4229h = true;
        m1.g.k(context);
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        m1.g.k(origApplicationContext);
        this.f4222a = origApplicationContext;
        this.f4230i = l10;
        if (zzdzVar != null) {
            this.f4228g = zzdzVar;
            this.f4223b = zzdzVar.f3343f;
            this.f4224c = zzdzVar.f3342e;
            this.f4225d = zzdzVar.f3341d;
            this.f4229h = zzdzVar.f3340c;
            this.f4227f = zzdzVar.f3339b;
            this.f4231j = zzdzVar.f3345h;
            Bundle bundle = zzdzVar.f3344g;
            if (bundle != null) {
                this.f4226e = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
