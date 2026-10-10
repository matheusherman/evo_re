package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class h8 implements h2.a<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzow f3689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ z7 f3690b;

    h8(z7 z7Var, zzow zzowVar) {
        this.f3689a = zzowVar;
        this.f3690b = z7Var;
    }

    private final void c() {
        SparseArray<Long> sparseArrayM = this.f3690b.h().M();
        zzow zzowVar = this.f3689a;
        sparseArrayM.put(zzowVar.f4305c, Long.valueOf(zzowVar.f4304b));
        a6 a6VarH = this.f3690b.h();
        int[] iArr = new int[sparseArrayM.size()];
        long[] jArr = new long[sparseArrayM.size()];
        for (int i10 = 0; i10 < sparseArrayM.size(); i10++) {
            iArr[i10] = sparseArrayM.keyAt(i10);
            jArr[i10] = sparseArrayM.valueAt(i10).longValue();
        }
        Bundle bundle = new Bundle();
        bundle.putIntArray("uriSources", iArr);
        bundle.putLongArray("uriTimestamps", jArr);
        a6VarH.f3381p.b(bundle);
    }

    @Override // h2.a
    public final void a(Object obj) {
        this.f3690b.n();
        c();
        this.f3690b.f4258i = false;
        this.f3690b.f4259j = 1;
        this.f3690b.l().G().b("Successfully registered trigger URI", this.f3689a.f4303a);
        this.f3690b.N0();
    }

    @Override // h2.a
    public final void b(Throwable th) {
        this.f3690b.n();
        this.f3690b.f4258i = false;
        int iE = (this.f3690b.d().u(g0.Z0) ? z7.E(this.f3690b, th) : 2) - 1;
        if (iE == 0) {
            this.f3690b.l().M().c("registerTriggerAsync failed with retriable error. Will try later. App ID, throwable", p5.w(this.f3690b.q().H()), p5.w(th.toString()));
            this.f3690b.f4259j = 1;
            this.f3690b.F0().add(this.f3689a);
            return;
        }
        if (iE != 1) {
            if (iE != 2) {
                return;
            }
            this.f3690b.l().H().c("registerTriggerAsync failed. Dropping URI. App ID, Throwable", p5.w(this.f3690b.q().H()), th);
            c();
            this.f3690b.f4259j = 1;
            this.f3690b.N0();
            return;
        }
        this.f3690b.F0().add(this.f3689a);
        if (this.f3690b.f4259j > g0.f3606v0.a(null).intValue()) {
            this.f3690b.f4259j = 1;
            this.f3690b.l().M().c("registerTriggerAsync failed. May try later. App ID, throwable", p5.w(this.f3690b.q().H()), p5.w(th.toString()));
            return;
        }
        this.f3690b.l().M().d("registerTriggerAsync failed. App ID, delay in seconds, throwable", p5.w(this.f3690b.q().H()), p5.w(String.valueOf(this.f3690b.f4259j)), p5.w(th.toString()));
        z7 z7Var = this.f3690b;
        z7.W0(z7Var, z7Var.f4259j);
        this.f3690b.f4259j <<= 1;
    }
}
