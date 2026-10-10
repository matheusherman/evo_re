package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f3472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f3473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final String f3474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final long f3475d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final long f3476e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final zzbi f3477f;

    d0(s6 s6Var, String str, String str2, String str3, long j10, long j11, Bundle bundle) {
        zzbi zzbiVar;
        m1.g.e(str2);
        m1.g.e(str3);
        this.f3472a = str2;
        this.f3473b = str3;
        this.f3474c = TextUtils.isEmpty(str) ? null : str;
        this.f3475d = j10;
        this.f3476e = j11;
        if (j11 != 0 && j11 > j10) {
            s6Var.l().M().b("Event created with reverse previous/current timestamps. appId", p5.w(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            zzbiVar = new zzbi(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    s6Var.l().H().a("Param name can't be null");
                    it.remove();
                } else {
                    Object objT0 = s6Var.P().t0(next, bundle2.get(next));
                    if (objT0 == null) {
                        s6Var.l().M().b("Param value can't be null", s6Var.F().f(next));
                        it.remove();
                    } else {
                        s6Var.P().P(bundle2, next, objT0);
                    }
                }
            }
            zzbiVar = new zzbi(bundle2);
        }
        this.f3477f = zzbiVar;
    }

    final d0 a(s6 s6Var, long j10) {
        return new d0(s6Var, this.f3474c, this.f3472a, this.f3473b, this.f3475d, j10, this.f3477f);
    }

    public final String toString() {
        return "Event{appId='" + this.f3472a + "', name='" + this.f3473b + "', params=" + String.valueOf(this.f3477f) + "}";
    }

    private d0(s6 s6Var, String str, String str2, String str3, long j10, long j11, zzbi zzbiVar) {
        m1.g.e(str2);
        m1.g.e(str3);
        m1.g.k(zzbiVar);
        this.f3472a = str2;
        this.f3473b = str3;
        this.f3474c = TextUtils.isEmpty(str) ? null : str;
        this.f3475d = j10;
        this.f3476e = j11;
        if (j11 != 0 && j11 > j10) {
            s6Var.l().M().c("Event created with reverse previous/current timestamps. appId, name", p5.w(str2), p5.w(str3));
        }
        this.f3477f = zzbiVar;
    }
}
