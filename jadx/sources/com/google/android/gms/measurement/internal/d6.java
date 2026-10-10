package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class d6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f3481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ a6 f3482d;

    public d6(a6 a6Var, String str, String str2) {
        this.f3482d = a6Var;
        m1.g.e(str);
        this.f3479a = str;
    }

    @WorkerThread
    public final String a() {
        if (!this.f3480b) {
            this.f3480b = true;
            this.f3481c = this.f3482d.L().getString(this.f3479a, null);
        }
        return this.f3481c;
    }

    @WorkerThread
    public final void b(String str) {
        SharedPreferences.Editor editorEdit = this.f3482d.L().edit();
        editorEdit.putString(this.f3479a, str);
        editorEdit.apply();
        this.f3481c = str;
    }
}
