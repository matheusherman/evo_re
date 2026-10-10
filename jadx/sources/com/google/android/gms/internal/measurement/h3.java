package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class h3 extends f3.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ String f2743e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f2744f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ Context f2745g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ Bundle f2746h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ f3 f2747i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    h3(f3 f3Var, String str, String str2, Context context, Bundle bundle) {
        super(f3Var);
        this.f2743e = str;
        this.f2744f = str2;
        this.f2745g = context;
        this.f2746h = bundle;
        this.f2747i = f3Var;
    }

    @Override // com.google.android.gms.internal.measurement.f3.a
    public final void a() {
        String str;
        String str2;
        String str3;
        try {
            if (this.f2747i.E(this.f2743e, this.f2744f)) {
                str3 = this.f2744f;
                str2 = this.f2743e;
                str = this.f2747i.f2671a;
            } else {
                str = null;
                str2 = null;
                str3 = null;
            }
            m1.g.k(this.f2745g);
            f3 f3Var = this.f2747i;
            f3Var.f2679i = f3Var.c(this.f2745g, true);
            if (this.f2747i.f2679i == null) {
                Log.w(this.f2747i.f2671a, "Failed to connect to measurement client.");
                return;
            }
            int iA = DynamiteModule.a(this.f2745g, ModuleDescriptor.MODULE_ID);
            int iB = DynamiteModule.b(this.f2745g, ModuleDescriptor.MODULE_ID);
            ((p2) m1.g.k(this.f2747i.f2679i)).initialize(u1.b.W(this.f2745g), new zzdz(118003L, Math.max(iA, iB), iB < iA, str, str2, str3, this.f2746h, b2.y.a(this.f2745g)), this.f2680a);
        } catch (Exception e10) {
            this.f2747i.q(e10, true, false);
        }
    }
}
