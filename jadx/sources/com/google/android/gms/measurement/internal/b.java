package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.google.android.gms.internal.measurement.o5 f3407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Long f3408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f3409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zc f3410d;

    /* synthetic */ b(zc zcVar, b2.a aVar) {
        this(zcVar);
    }

    private b(zc zcVar) {
        this.f3410d = zcVar;
    }

    final com.google.android.gms.internal.measurement.o5 a(String str, com.google.android.gms.internal.measurement.o5 o5Var) {
        Object obj;
        String strA0 = o5Var.a0();
        List<com.google.android.gms.internal.measurement.q5> listB0 = o5Var.b0();
        this.f3410d.o();
        Long l10 = (Long) sc.g0(o5Var, "_eid");
        boolean z10 = l10 != null;
        if (z10 && strA0.equals("_ep")) {
            m1.g.k(l10);
            this.f3410d.o();
            strA0 = (String) sc.g0(o5Var, "_en");
            if (TextUtils.isEmpty(strA0)) {
                this.f3410d.l().J().b("Extra parameter without an event name. eventId", l10);
                return null;
            }
            if (this.f3407a == null || this.f3408b == null || l10.longValue() != this.f3408b.longValue()) {
                Pair<com.google.android.gms.internal.measurement.o5, Long> pairK = this.f3410d.r().K(str, l10);
                if (pairK == null || (obj = pairK.first) == null) {
                    this.f3410d.l().J().c("Extra parameter without existing main event. eventName, eventId", strA0, l10);
                    return null;
                }
                this.f3407a = (com.google.android.gms.internal.measurement.o5) obj;
                this.f3409c = ((Long) pairK.second).longValue();
                this.f3410d.o();
                this.f3408b = (Long) sc.g0(this.f3407a, "_eid");
            }
            long j10 = this.f3409c - 1;
            this.f3409c = j10;
            if (j10 <= 0) {
                m mVarR = this.f3410d.r();
                mVarR.n();
                mVarR.l().L().b("Clearing complex main event info. appId", str);
                try {
                    mVarR.C().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                } catch (SQLiteException e10) {
                    mVarR.l().H().b("Error clearing complex main event", e10);
                }
            } else {
                this.f3410d.r().t0(str, l10, this.f3409c, this.f3407a);
            }
            ArrayList arrayList = new ArrayList();
            for (com.google.android.gms.internal.measurement.q5 q5Var : this.f3407a.b0()) {
                this.f3410d.o();
                if (sc.G(o5Var, q5Var.c0()) == null) {
                    arrayList.add(q5Var);
                }
            }
            if (arrayList.isEmpty()) {
                this.f3410d.l().J().b("No unique parameters in main event. eventName", strA0);
            } else {
                arrayList.addAll(listB0);
                listB0 = arrayList;
            }
        } else if (z10) {
            this.f3408b = l10;
            this.f3407a = o5Var;
            this.f3410d.o();
            long jLongValue = ((Long) sc.K(o5Var, "_epc", 0L)).longValue();
            this.f3409c = jLongValue;
            if (jLongValue <= 0) {
                this.f3410d.l().J().b("Complex event with zero extra param count. eventName", strA0);
            } else {
                this.f3410d.r().t0(str, (Long) m1.g.k(l10), this.f3409c, o5Var);
            }
        }
        return (com.google.android.gms.internal.measurement.o5) ((com.google.android.gms.internal.measurement.ea) o5Var.C().F(strA0).L().E(listB0).w());
    }
}
