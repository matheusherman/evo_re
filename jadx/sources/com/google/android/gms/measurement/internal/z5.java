package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class z5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f4245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f4246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ a6 f4249e;

    public z5(a6 a6Var, String str, boolean z10) {
        this.f4249e = a6Var;
        m1.g.e(str);
        this.f4245a = str;
        this.f4246b = z10;
    }

    @WorkerThread
    public final void a(boolean z10) {
        SharedPreferences.Editor editorEdit = this.f4249e.L().edit();
        editorEdit.putBoolean(this.f4245a, z10);
        editorEdit.apply();
        this.f4248d = z10;
    }

    @WorkerThread
    public final boolean b() {
        if (!this.f4247c) {
            this.f4247c = true;
            this.f4248d = this.f4249e.L().getBoolean(this.f4245a, this.f4246b);
        }
        return this.f4248d;
    }
}
