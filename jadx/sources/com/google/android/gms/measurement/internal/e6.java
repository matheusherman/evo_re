package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import androidx.core.location.LocationRequestCompat;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class e6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f3504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f3505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f3506d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ a6 f3507e;

    /* synthetic */ e6(a6 a6Var, String str, long j10, b2.t tVar) {
        this(a6Var, str, j10);
    }

    private e6(a6 a6Var, String str, long j10) {
        this.f3507e = a6Var;
        m1.g.e(str);
        m1.g.a(j10 > 0);
        this.f3503a = str + ":start";
        this.f3504b = str + ":count";
        this.f3505c = str + ":value";
        this.f3506d = j10;
    }

    @WorkerThread
    private final long c() {
        return this.f3507e.L().getLong(this.f3503a, 0L);
    }

    @WorkerThread
    private final void d() {
        this.f3507e.n();
        long jA = this.f3507e.c().a();
        SharedPreferences.Editor editorEdit = this.f3507e.L().edit();
        editorEdit.remove(this.f3504b);
        editorEdit.remove(this.f3505c);
        editorEdit.putLong(this.f3503a, jA);
        editorEdit.apply();
    }

    @WorkerThread
    public final Pair<String, Long> a() {
        long jAbs;
        this.f3507e.n();
        this.f3507e.n();
        long jC = c();
        if (jC == 0) {
            d();
            jAbs = 0;
        } else {
            jAbs = Math.abs(jC - this.f3507e.c().a());
        }
        long j10 = this.f3506d;
        if (jAbs < j10) {
            return null;
        }
        if (jAbs > (j10 << 1)) {
            d();
            return null;
        }
        String string = this.f3507e.L().getString(this.f3505c, null);
        long j11 = this.f3507e.L().getLong(this.f3504b, 0L);
        d();
        return (string == null || j11 <= 0) ? a6.B : new Pair<>(string, Long.valueOf(j11));
    }

    @WorkerThread
    public final void b(String str, long j10) {
        this.f3507e.n();
        if (c() == 0) {
            d();
        }
        if (str == null) {
            str = "";
        }
        long j11 = this.f3507e.L().getLong(this.f3504b, 0L);
        if (j11 <= 0) {
            SharedPreferences.Editor editorEdit = this.f3507e.L().edit();
            editorEdit.putString(this.f3505c, str);
            editorEdit.putLong(this.f3504b, 1L);
            editorEdit.apply();
            return;
        }
        long j12 = j11 + 1;
        boolean z10 = (this.f3507e.j().V0().nextLong() & LocationRequestCompat.PASSIVE_INTERVAL) < LocationRequestCompat.PASSIVE_INTERVAL / j12;
        SharedPreferences.Editor editorEdit2 = this.f3507e.L().edit();
        if (z10) {
            editorEdit2.putString(this.f3505c, str);
        }
        editorEdit2.putLong(this.f3504b, j12);
        editorEdit2.apply();
    }
}
