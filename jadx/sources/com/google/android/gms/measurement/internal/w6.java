package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteException;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.BinderThread;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.measurement.internal.w6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class w6 extends b2.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final gc f4143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Boolean f4144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f4145c;

    public w6(gc gcVar) {
        this(gcVar, null);
    }

    @Override // b2.g
    @BinderThread
    public final void A(final zzq zzqVar, final Bundle bundle, final b2.h hVar) {
        e0(zzqVar, false);
        final String str = (String) m1.g.k(zzqVar.f4322a);
        this.f4143a.a().E(new Runnable() { // from class: b2.b0
            @Override // java.lang.Runnable
            public final void run() {
                w6.X(this.f649a, zzqVar, bundle, hVar, str);
            }
        });
    }

    @Override // b2.g
    @BinderThread
    public final zzan D(zzq zzqVar) {
        e0(zzqVar, false);
        m1.g.e(zzqVar.f4322a);
        try {
            return (zzan) this.f4143a.a().C(new m7(this, zzqVar)).get(10000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e10) {
            this.f4143a.l().H().c("Failed to get consent. appId", p5.w(zzqVar.f4322a), e10);
            return new zzan(null);
        }
    }

    @Override // b2.g
    @BinderThread
    public final List<zzai> E(String str, String str2, String str3) {
        b0(str, true);
        try {
            return (List) this.f4143a.a().x(new h7(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e10) {
            this.f4143a.l().H().b("Failed to get conditional user properties as", e10);
            return Collections.EMPTY_LIST;
        }
    }

    @Override // b2.g
    @BinderThread
    public final void F(final Bundle bundle, final zzq zzqVar) {
        e0(zzqVar, false);
        final String str = zzqVar.f4322a;
        m1.g.k(str);
        f0(new Runnable() { // from class: b2.e0
            @Override // java.lang.Runnable
            public final void run() {
                w6.g(this.f672a, bundle, str, zzqVar);
            }
        });
    }

    @Override // b2.g
    @BinderThread
    public final List<zzpy> M(zzq zzqVar, boolean z10) {
        e0(zzqVar, false);
        String str = zzqVar.f4322a;
        m1.g.k(str);
        try {
            List<tc> list = (List) this.f4143a.a().x(new z6(this, str)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (tc tcVar : list) {
                if (z10 || !wc.I0(tcVar.f4077c)) {
                    arrayList.add(new zzpy(tcVar));
                }
            }
            return arrayList;
        } catch (InterruptedException e10) {
            e = e10;
            this.f4143a.l().H().c("Failed to get user properties. appId", p5.w(zzqVar.f4322a), e);
            return null;
        } catch (ExecutionException e11) {
            e = e11;
            this.f4143a.l().H().c("Failed to get user properties. appId", p5.w(zzqVar.f4322a), e);
            return null;
        }
    }

    @Override // b2.g
    @BinderThread
    public final void P(zzq zzqVar) {
        e0(zzqVar, false);
        f0(new x6(this, zzqVar));
    }

    @Override // b2.g
    @BinderThread
    public final List<zzai> Q(String str, String str2, zzq zzqVar) {
        e0(zzqVar, false);
        String str3 = zzqVar.f4322a;
        m1.g.k(str3);
        try {
            return (List) this.f4143a.a().x(new i7(this, str3, str, str2)).get();
        } catch (InterruptedException | ExecutionException e10) {
            this.f4143a.l().H().b("Failed to get conditional user properties", e10);
            return Collections.EMPTY_LIST;
        }
    }

    @Override // b2.g
    @BinderThread
    public final List<zzpy> V(String str, String str2, boolean z10, zzq zzqVar) {
        e0(zzqVar, false);
        String str3 = zzqVar.f4322a;
        m1.g.k(str3);
        try {
            List<tc> list = (List) this.f4143a.a().x(new g7(this, str3, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (tc tcVar : list) {
                if (z10 || !wc.I0(tcVar.f4077c)) {
                    arrayList.add(new zzpy(tcVar));
                }
            }
            return arrayList;
        } catch (InterruptedException e10) {
            e = e10;
            this.f4143a.l().H().c("Failed to query user properties. appId", p5.w(zzqVar.f4322a), e);
            return Collections.EMPTY_LIST;
        } catch (ExecutionException e11) {
            e = e11;
            this.f4143a.l().H().c("Failed to query user properties. appId", p5.w(zzqVar.f4322a), e);
            return Collections.EMPTY_LIST;
        }
    }

    @Override // b2.g
    @BinderThread
    public final String i(zzq zzqVar) {
        e0(zzqVar, false);
        return this.f4143a.g0(zzqVar);
    }

    @Override // b2.g
    @BinderThread
    public final List<zzow> l(zzq zzqVar, Bundle bundle) {
        e0(zzqVar, false);
        m1.g.k(zzqVar.f4322a);
        if (!this.f4143a.x0().u(g0.f3573i1)) {
            try {
                return (List) this.f4143a.a().x(new s7(this, zzqVar, bundle)).get();
            } catch (InterruptedException | ExecutionException e10) {
                this.f4143a.l().H().c("Failed to get trigger URIs. appId", p5.w(zzqVar.f4322a), e10);
                return Collections.EMPTY_LIST;
            }
        }
        try {
            return (List) this.f4143a.a().C(new p7(this, zzqVar, bundle)).get(10000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e11) {
            this.f4143a.l().H().c("Failed to get trigger URIs. appId", p5.w(zzqVar.f4322a), e11);
            return Collections.EMPTY_LIST;
        }
    }

    @Override // b2.g
    @BinderThread
    public final List<zzpy> r(String str, String str2, String str3, boolean z10) {
        b0(str, true);
        try {
            List<tc> list = (List) this.f4143a.a().x(new f7(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (tc tcVar : list) {
                if (z10 || !wc.I0(tcVar.f4077c)) {
                    arrayList.add(new zzpy(tcVar));
                }
            }
            return arrayList;
        } catch (InterruptedException e10) {
            e = e10;
            this.f4143a.l().H().c("Failed to get user properties as. appId", p5.w(str), e);
            return Collections.EMPTY_LIST;
        } catch (ExecutionException e11) {
            e = e11;
            this.f4143a.l().H().c("Failed to get user properties as. appId", p5.w(str), e);
            return Collections.EMPTY_LIST;
        }
    }

    @Override // b2.g
    @BinderThread
    public final void t(zzq zzqVar) {
        e0(zzqVar, false);
        f0(new c7(this, zzqVar));
    }

    @Override // b2.g
    @BinderThread
    public final void u(zzq zzqVar) {
        e0(zzqVar, false);
        f0(new y6(this, zzqVar));
    }

    private w6(gc gcVar, String str) {
        m1.g.k(gcVar);
        this.f4143a = gcVar;
        this.f4145c = null;
    }

    public static /* synthetic */ void W(w6 w6Var, zzq zzqVar) {
        w6Var.f4143a.P0();
        w6Var.f4143a.D0(zzqVar);
    }

    public static /* synthetic */ void X(w6 w6Var, zzq zzqVar, Bundle bundle, b2.h hVar, String str) {
        w6Var.f4143a.P0();
        try {
            hVar.z(w6Var.f4143a.s(zzqVar, bundle));
        } catch (RemoteException e10) {
            w6Var.f4143a.l().H().c("Failed to return trigger URIs for app", str, e10);
        }
    }

    public static /* synthetic */ void Y(w6 w6Var, zzq zzqVar, zzag zzagVar) {
        w6Var.f4143a.P0();
        w6Var.f4143a.M((String) m1.g.k(zzqVar.f4322a), zzagVar);
    }

    public static /* synthetic */ void Z(w6 w6Var, String str, zzpb zzpbVar, b2.l lVar) {
        w6Var.f4143a.P0();
        zzpd zzpdVarM = w6Var.f4143a.m(str, zzpbVar);
        try {
            lVar.o(zzpdVarM);
            w6Var.f4143a.l().L().c("[sgtm] Sending queued upload batches to client. appId, count", str, Integer.valueOf(zzpdVarM.f4314a.size()));
        } catch (RemoteException e10) {
            w6Var.f4143a.l().H().c("[sgtm] Failed to return upload batches for app", str, e10);
        }
    }

    public static /* synthetic */ void d0(w6 w6Var, zzq zzqVar) {
        w6Var.f4143a.P0();
        w6Var.f4143a.B0(zzqVar);
    }

    public static /* synthetic */ void g(w6 w6Var, Bundle bundle, String str, zzq zzqVar) {
        boolean zU = w6Var.f4143a.x0().u(g0.f3558d1);
        boolean zU2 = w6Var.f4143a.x0().u(g0.f3564f1);
        if (bundle.isEmpty() && zU) {
            m mVarA0 = w6Var.f4143a.A0();
            mVarA0.n();
            mVarA0.v();
            try {
                mVarA0.C().execSQL("delete from default_event_params where app_id=?", new String[]{str});
                return;
            } catch (SQLiteException e10) {
                mVarA0.l().H().b("Error clearing default event params", e10);
                return;
            }
        }
        w6Var.f4143a.A0().r0(str, bundle);
        if (w6Var.f4143a.A0().q0(str, zzqVar.F)) {
            if (zU2) {
                w6Var.f4143a.A0().f0(str, Long.valueOf(zzqVar.F), null, bundle);
            } else {
                w6Var.f4143a.A0().f0(str, null, null, bundle);
            }
        }
    }

    private final void h0(zzbj zzbjVar, zzq zzqVar) {
        this.f4143a.P0();
        this.f4143a.z(zzbjVar, zzqVar);
    }

    @Override // b2.g
    @BinderThread
    public final void B(long j10, String str, String str2, String str3) {
        f0(new b7(this, str2, str3, str, j10));
    }

    @Override // b2.g
    @BinderThread
    public final void H(final zzq zzqVar, final zzag zzagVar) {
        if (this.f4143a.x0().u(g0.P0)) {
            e0(zzqVar, false);
            f0(new Runnable() { // from class: b2.z
                @Override // java.lang.Runnable
                public final void run() {
                    w6.Y(this.f742a, zzqVar, zzagVar);
                }
            });
        }
    }

    @Override // b2.g
    @BinderThread
    public final void K(final zzq zzqVar) {
        m1.g.e(zzqVar.f4322a);
        m1.g.k(zzqVar.f4342u);
        a0(new Runnable() { // from class: b2.c0
            @Override // java.lang.Runnable
            public final void run() {
                w6.d0(this.f654a, zzqVar);
            }
        });
    }

    @Override // b2.g
    @BinderThread
    public final void R(zzq zzqVar) {
        m1.g.e(zzqVar.f4322a);
        b0(zzqVar.f4322a, false);
        f0(new j7(this, zzqVar));
    }

    @Override // b2.g
    @BinderThread
    public final void U(zzq zzqVar) {
        m1.g.e(zzqVar.f4322a);
        m1.g.k(zzqVar.f4342u);
        a0(new k7(this, zzqVar));
    }

    @VisibleForTesting
    final zzbj c0(zzbj zzbjVar, zzq zzqVar) {
        zzbi zzbiVar;
        if (!"_cmp".equals(zzbjVar.f4299a) || (zzbiVar = zzbjVar.f4300b) == null || zzbiVar.J() == 0) {
            return zzbjVar;
        }
        String strJ0 = zzbjVar.f4300b.j0("_cis");
        if (!"referrer broadcast".equals(strJ0) && !"referrer API".equals(strJ0)) {
            return zzbjVar;
        }
        this.f4143a.l().K().b("Event has been filtered ", zzbjVar.toString());
        return new zzbj("_cmpx", zzbjVar.f4300b, zzbjVar.f4301c, zzbjVar.f4302d);
    }

    final void g0(zzbj zzbjVar, zzq zzqVar) {
        boolean zE;
        if (!this.f4143a.G0().Z(zzqVar.f4322a)) {
            h0(zzbjVar, zzqVar);
            return;
        }
        this.f4143a.l().L().b("EES config found for", zzqVar.f4322a);
        j6 j6VarG0 = this.f4143a.G0();
        String str = zzqVar.f4322a;
        com.google.android.gms.internal.measurement.c0 c0Var = TextUtils.isEmpty(str) ? null : j6VarG0.f3735j.get(str);
        if (c0Var == null) {
            this.f4143a.l().L().b("EES not loaded for", zzqVar.f4322a);
            h0(zzbjVar, zzqVar);
            return;
        }
        try {
            Map<String, Object> mapR = this.f4143a.M0().R(zzbjVar.f4300b.S(), true);
            String strA = b2.j0.a(zzbjVar.f4299a);
            if (strA == null) {
                strA = zzbjVar.f4299a;
            }
            zE = c0Var.e(new com.google.android.gms.internal.measurement.e(strA, zzbjVar.f4302d, mapR));
        } catch (com.google.android.gms.internal.measurement.d1 unused) {
            this.f4143a.l().H().c("EES error. appId, eventName", zzqVar.f4323b, zzbjVar.f4299a);
            zE = false;
        }
        if (!zE) {
            this.f4143a.l().L().b("EES was not applied to event", zzbjVar.f4299a);
            h0(zzbjVar, zzqVar);
            return;
        }
        if (c0Var.h()) {
            this.f4143a.l().L().b("EES edited event", zzbjVar.f4299a);
            h0(this.f4143a.M0().I(c0Var.a().d()), zzqVar);
        } else {
            h0(zzbjVar, zzqVar);
        }
        if (c0Var.g()) {
            for (com.google.android.gms.internal.measurement.e eVar : c0Var.a().f()) {
                this.f4143a.l().L().b("EES logging created event", eVar.e());
                h0(this.f4143a.M0().I(eVar), zzqVar);
            }
        }
    }

    @Override // b2.g
    @BinderThread
    public final void p(zzq zzqVar, final zzpb zzpbVar, final b2.l lVar) {
        if (this.f4143a.x0().u(g0.P0)) {
            e0(zzqVar, false);
            final String str = (String) m1.g.k(zzqVar.f4322a);
            this.f4143a.a().E(new Runnable() { // from class: b2.d0
                @Override // java.lang.Runnable
                public final void run() {
                    w6.Z(this.f663a, str, zzpbVar, lVar);
                }
            });
        } else {
            try {
                lVar.o(new zzpd(Collections.EMPTY_LIST));
                this.f4143a.l().L().a("[sgtm] Client upload is not enabled on the service side.");
            } catch (RemoteException e10) {
                this.f4143a.l().M().b("[sgtm] UploadBatchesCallback failed.", e10);
            }
        }
    }

    @Override // b2.g
    @BinderThread
    public final void y(final zzq zzqVar) {
        m1.g.e(zzqVar.f4322a);
        m1.g.k(zzqVar.f4342u);
        a0(new Runnable() { // from class: b2.a0
            @Override // java.lang.Runnable
            public final void run() {
                w6.W(this.f647a, zzqVar);
            }
        });
    }

    @VisibleForTesting
    private final void a0(Runnable runnable) {
        m1.g.k(runnable);
        if (this.f4143a.a().L()) {
            runnable.run();
        } else {
            this.f4143a.a().H(runnable);
        }
    }

    @BinderThread
    private final void b0(String str, boolean z10) {
        boolean z11;
        if (!TextUtils.isEmpty(str)) {
            if (z10) {
                try {
                    if (this.f4144b == null) {
                        if (!"com.google.android.gms".equals(this.f4145c) && !com.google.android.gms.common.util.r.a(this.f4143a.b(), Binder.getCallingUid()) && !com.google.android.gms.common.e.a(this.f4143a.b()).c(Binder.getCallingUid())) {
                            z11 = false;
                        } else {
                            z11 = true;
                        }
                        this.f4144b = Boolean.valueOf(z11);
                    }
                    if (this.f4144b.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e10) {
                    this.f4143a.l().H().b("Measurement Service called with invalid calling package. appId", p5.w(str));
                    throw e10;
                }
            }
            if (this.f4145c == null && com.google.android.gms.common.d.j(this.f4143a.b(), Binder.getCallingUid(), str)) {
                this.f4145c = str;
            }
            if (str.equals(this.f4145c)) {
                return;
            } else {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
            }
        }
        this.f4143a.l().H().a("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    @BinderThread
    private final void e0(zzq zzqVar, boolean z10) {
        m1.g.k(zzqVar);
        m1.g.e(zzqVar.f4322a);
        b0(zzqVar.f4322a, false);
        this.f4143a.N0().l0(zzqVar.f4323b, zzqVar.f4337p);
    }

    @VisibleForTesting
    private final void f0(Runnable runnable) {
        m1.g.k(runnable);
        if (this.f4143a.a().L()) {
            runnable.run();
        } else {
            this.f4143a.a().E(runnable);
        }
    }

    @Override // b2.g
    @BinderThread
    public final void N(zzbj zzbjVar, zzq zzqVar) {
        m1.g.k(zzbjVar);
        e0(zzqVar, false);
        f0(new l7(this, zzbjVar, zzqVar));
    }

    @Override // b2.g
    @BinderThread
    public final void T(zzbj zzbjVar, String str, String str2) {
        m1.g.k(zzbjVar);
        m1.g.e(str);
        b0(str, true);
        f0(new o7(this, zzbjVar, str));
    }

    @Override // b2.g
    @BinderThread
    public final void k(zzai zzaiVar) {
        m1.g.k(zzaiVar);
        m1.g.k(zzaiVar.f4288c);
        m1.g.e(zzaiVar.f4286a);
        b0(zzaiVar.f4286a, true);
        f0(new d7(this, new zzai(zzaiVar)));
    }

    @Override // b2.g
    @BinderThread
    public final void n(zzai zzaiVar, zzq zzqVar) {
        m1.g.k(zzaiVar);
        m1.g.k(zzaiVar.f4288c);
        e0(zzqVar, false);
        zzai zzaiVar2 = new zzai(zzaiVar);
        zzaiVar2.f4286a = zzqVar.f4322a;
        f0(new e7(this, zzaiVar2, zzqVar));
    }

    @Override // b2.g
    @BinderThread
    public final void q(zzpy zzpyVar, zzq zzqVar) {
        m1.g.k(zzpyVar);
        e0(zzqVar, false);
        f0(new q7(this, zzpyVar, zzqVar));
    }

    @Override // b2.g
    @BinderThread
    public final byte[] w(zzbj zzbjVar, String str) {
        m1.g.e(str);
        m1.g.k(zzbjVar);
        b0(str, true);
        this.f4143a.l().G().b("Log and bundle. event", this.f4143a.C0().c(zzbjVar.f4299a));
        long jC = this.f4143a.c().c() / 1000000;
        try {
            byte[] bArr = (byte[]) this.f4143a.a().C(new n7(this, zzbjVar, str)).get();
            if (bArr == null) {
                this.f4143a.l().H().b("Log and bundle returned null. appId", p5.w(str));
                bArr = new byte[0];
            }
            this.f4143a.l().G().d("Log and bundle processed. event, size, time_ms", this.f4143a.C0().c(zzbjVar.f4299a), Integer.valueOf(bArr.length), Long.valueOf((this.f4143a.c().c() / 1000000) - jC));
            return bArr;
        } catch (InterruptedException e10) {
            e = e10;
            this.f4143a.l().H().d("Failed to log and bundle. appId, event, error", p5.w(str), this.f4143a.C0().c(zzbjVar.f4299a), e);
            return null;
        } catch (ExecutionException e11) {
            e = e11;
            this.f4143a.l().H().d("Failed to log and bundle. appId, event, error", p5.w(str), this.f4143a.C0().c(zzbjVar.f4299a), e);
            return null;
        }
    }
}
