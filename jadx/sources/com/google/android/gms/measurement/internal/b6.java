package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class b6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f3413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f3414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f3415d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ a6 f3416e;

    public b6(a6 a6Var, String str, long j10) {
        this.f3416e = a6Var;
        m1.g.e(str);
        this.f3412a = str;
        this.f3413b = j10;
    }

    @WorkerThread
    public final long a() {
        if (!this.f3414c) {
            this.f3414c = true;
            this.f3415d = this.f3416e.L().getLong(this.f3412a, this.f3413b);
        }
        return this.f3415d;
    }

    @WorkerThread
    public final void b(long j10) {
        SharedPreferences.Editor editorEdit = this.f3416e.L().edit();
        editorEdit.putLong(this.f3412a, j10);
        editorEdit.apply();
        this.f3415d = j10;
    }
}
