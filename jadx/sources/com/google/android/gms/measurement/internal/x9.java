package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.measurement.internal.x9;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.log4j.helpers.FileWatchdog;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class x9 extends m5 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final xa f4200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b2.g f4201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile Boolean f4202e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final v f4203f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final sb f4204g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<Runnable> f4205h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final v f4206i;

    public static /* synthetic */ void S(x9 x9Var, AtomicReference atomicReference, zzq zzqVar, Bundle bundle) {
        synchronized (atomicReference) {
            try {
                b2.g gVar = x9Var.f4201d;
                if (gVar == null) {
                    x9Var.l().H().a("Failed to request trigger URIs; not connected to service");
                    return;
                }
                m1.g.k(zzqVar);
                gVar.A(zzqVar, bundle, new da(x9Var, atomicReference));
                x9Var.r0();
            } catch (RemoteException e10) {
                x9Var.l().H().b("Failed to request trigger URIs; remote exception", e10);
                atomicReference.notifyAll();
            }
        }
    }

    public static /* synthetic */ void T(x9 x9Var, AtomicReference atomicReference, zzq zzqVar, zzpb zzpbVar) {
        synchronized (atomicReference) {
            try {
                b2.g gVar = x9Var.f4201d;
                if (gVar == null) {
                    x9Var.l().H().a("[sgtm] Failed to get upload batches; not connected to service");
                    return;
                }
                m1.g.k(zzqVar);
                gVar.p(zzqVar, zzpbVar, new fa(x9Var, atomicReference));
                x9Var.r0();
            } catch (RemoteException e10) {
                x9Var.l().H().b("[sgtm] Failed to get upload batches; remote exception", e10);
                atomicReference.notifyAll();
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.m5
    protected final boolean y() {
        return false;
    }

    public static /* synthetic */ void R(x9 x9Var, zzq zzqVar, zzag zzagVar) {
        b2.g gVar = x9Var.f4201d;
        if (gVar == null) {
            x9Var.l().H().a("[sgtm] Discarding data. Failed to update batch upload status.");
            return;
        }
        try {
            gVar.H(zzqVar, zzagVar);
            x9Var.r0();
        } catch (RemoteException e10) {
            x9Var.l().H().c("[sgtm] Failed to update batch upload status, rowId, exception", Long.valueOf(zzagVar.f4283a), e10);
        }
    }

    public static /* synthetic */ void v0(x9 x9Var) {
        b2.g gVar = x9Var.f4201d;
        if (gVar == null) {
            x9Var.l().H().a("Failed to send storage consent settings to service");
            return;
        }
        try {
            zzq zzqVarU0 = x9Var.u0(false);
            m1.g.k(zzqVarU0);
            gVar.y(zzqVarU0);
            x9Var.r0();
        } catch (RemoteException e10) {
            x9Var.l().H().b("Failed to send storage consent settings to the service", e10);
        }
    }

    public static /* synthetic */ void w0(x9 x9Var) {
        b2.g gVar = x9Var.f4201d;
        if (gVar == null) {
            x9Var.l().H().a("Failed to send Dma consent settings to service");
            return;
        }
        try {
            zzq zzqVarU0 = x9Var.u0(false);
            m1.g.k(zzqVarU0);
            gVar.K(zzqVarU0);
            x9Var.r0();
        } catch (RemoteException e10) {
            x9Var.l().H().b("Failed to send Dma consent settings to the service", e10);
        }
    }

    @WorkerThread
    final void G(b2.g gVar, AbstractSafeParcelable abstractSafeParcelable, zzq zzqVar) throws Throwable {
        int size;
        long j10;
        long jB;
        n();
        z();
        int i10 = 100;
        int i11 = 0;
        for (int i12 = 100; i11 < 1001 && i10 == i12; i12 = 100) {
            ArrayList arrayList = new ArrayList();
            List<b2.n> listE = r().E(i12);
            if (listE != null) {
                arrayList.addAll(listE);
                size = listE.size();
            } else {
                size = 0;
            }
            if (abstractSafeParcelable != null && size < i12) {
                arrayList.add(new b2.n(abstractSafeParcelable, "", 0L));
            }
            boolean zU = d().u(g0.U0);
            int size2 = arrayList.size();
            int i13 = 0;
            while (i13 < size2) {
                int i14 = i13 + 1;
                AbstractSafeParcelable abstractSafeParcelable2 = ((b2.n) arrayList.get(i13)).f715a;
                if (abstractSafeParcelable2 instanceof zzbj) {
                    if (zU) {
                        try {
                            long jA = this.f3965a.c().a();
                            try {
                                jB = this.f3965a.c().b();
                                j10 = jA;
                            } catch (RemoteException e10) {
                                e = e10;
                                jB = 0;
                                j10 = jA;
                                l().H().b("Failed to send event to the service", e);
                                if (!zU && j10 != 0) {
                                    n5.a(this.f3965a).b(36301, 13, j10, this.f3965a.c().a(), (int) (this.f3965a.c().b() - jB));
                                }
                                i13 = i14;
                            }
                        } catch (RemoteException e11) {
                            e = e11;
                            j10 = 0;
                            jB = 0;
                        }
                    } else {
                        j10 = 0;
                        jB = 0;
                    }
                    try {
                        gVar.N((zzbj) abstractSafeParcelable2, zzqVar);
                        if (zU) {
                            l().L().a("Logging telemetry for logEvent from database");
                            n5.a(this.f3965a).b(36301, 0, j10, this.f3965a.c().a(), (int) (this.f3965a.c().b() - jB));
                        }
                    } catch (RemoteException e12) {
                        e = e12;
                        l().H().b("Failed to send event to the service", e);
                        if (!zU) {
                        }
                    }
                } else if (abstractSafeParcelable2 instanceof zzpy) {
                    try {
                        gVar.q((zzpy) abstractSafeParcelable2, zzqVar);
                    } catch (RemoteException e13) {
                        l().H().b("Failed to send user property to the service", e13);
                    }
                } else if (abstractSafeParcelable2 instanceof zzai) {
                    try {
                        gVar.n((zzai) abstractSafeParcelable2, zzqVar);
                    } catch (RemoteException e14) {
                        l().H().b("Failed to send conditional user property to the service", e14);
                    }
                } else if (d().u(g0.f3588n1) && (abstractSafeParcelable2 instanceof zzbi)) {
                    try {
                        gVar.F(((zzbi) abstractSafeParcelable2).S(), zzqVar);
                    } catch (RemoteException e15) {
                        l().H().b("Failed to send default event parameters to the service", e15);
                    }
                } else {
                    l().H().a("Discarding data. Unrecognized parcel type.");
                }
                i13 = i14;
            }
            i11++;
            i10 = size;
        }
    }

    final Boolean d0() {
        return this.f4202e;
    }

    protected x9(s6 s6Var) {
        super(s6Var);
        this.f4205h = new ArrayList();
        this.f4204g = new sb(s6Var.c());
        this.f4200c = new xa(this);
        this.f4203f = new z9(this, s6Var);
        this.f4206i = new la(this, s6Var);
    }

    static /* synthetic */ void P(x9 x9Var, ComponentName componentName) {
        x9Var.n();
        if (x9Var.f4201d != null) {
            x9Var.f4201d = null;
            x9Var.l().L().b("Disconnected from device MeasurementService", componentName);
            x9Var.n();
            x9Var.g0();
        }
    }

    @WorkerThread
    private final void V(Runnable runnable) {
        n();
        if (l0()) {
            runnable.run();
        } else {
            if (this.f4205h.size() >= 1000) {
                l().H().a("Discarding data. Max runnable queue size reached");
                return;
            }
            this.f4205h.add(runnable);
            this.f4206i.b(FileWatchdog.DEFAULT_DELAY);
            g0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void q0() {
        n();
        l().L().b("Processing queued up service tasks", Integer.valueOf(this.f4205h.size()));
        Iterator<Runnable> it = this.f4205h.iterator();
        while (it.hasNext()) {
            try {
                it.next().run();
            } catch (RuntimeException e10) {
                l().H().b("Task exception while flushing queue", e10);
            }
        }
        this.f4205h.clear();
        this.f4206i.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void r0() {
        n();
        this.f4204g.c();
        this.f4203f.b(g0.Y.a(null).longValue());
    }

    @WorkerThread
    private final zzq u0(boolean z10) {
        String strP;
        h5 h5VarQ = q();
        if (z10) {
            strP = l().P();
        } else {
            strP = null;
        }
        return h5VarQ.D(strP);
    }

    static /* synthetic */ void y0(x9 x9Var) {
        x9Var.n();
        if (x9Var.l0()) {
            x9Var.l().L().a("Inactivity, disconnecting from the service");
            x9Var.h0();
        }
    }

    @WorkerThread
    public final void E(Bundle bundle) {
        boolean z10;
        n();
        z();
        zzbi zzbiVar = new zzbi(bundle);
        if (d().u(g0.f3588n1) && r().H(zzbiVar)) {
            z10 = true;
        } else {
            z10 = false;
        }
        V(new ma(this, true, u0(false), z10, zzbiVar, bundle));
    }

    @WorkerThread
    protected final void F(b2.g gVar) {
        n();
        m1.g.k(gVar);
        this.f4201d = gVar;
        r0();
        q0();
    }

    @WorkerThread
    public final void H(com.google.android.gms.internal.measurement.u2 u2Var) {
        n();
        z();
        V(new ja(this, u0(false), u2Var));
    }

    @WorkerThread
    public final void I(com.google.android.gms.internal.measurement.u2 u2Var, zzbj zzbjVar, String str) {
        n();
        z();
        if (j().v(12451000) != 0) {
            l().M().a("Not bundling data. Service unavailable or out of date");
            j().W(u2Var, new byte[0]);
        } else {
            V(new pa(this, zzbjVar, str, u2Var));
        }
    }

    @WorkerThread
    protected final void J(com.google.android.gms.internal.measurement.u2 u2Var, String str, String str2) {
        n();
        z();
        V(new va(this, str, str2, u0(false), u2Var));
    }

    @WorkerThread
    protected final void K(com.google.android.gms.internal.measurement.u2 u2Var, String str, String str2, boolean z10) {
        n();
        z();
        V(new aa(this, str, str2, u0(false), z10, u2Var));
    }

    @WorkerThread
    protected final void L(final zzag zzagVar) {
        n();
        z();
        final zzq zzqVarU0 = u0(true);
        m1.g.k(zzqVarU0);
        V(new Runnable() { // from class: b2.i1
            @Override // java.lang.Runnable
            public final void run() {
                x9.R(this.f693a, zzqVarU0, zzagVar);
            }
        });
    }

    @WorkerThread
    protected final void M(zzai zzaiVar) {
        m1.g.k(zzaiVar);
        n();
        z();
        V(new ta(this, true, u0(true), r().G(zzaiVar), new zzai(zzaiVar), zzaiVar));
    }

    @WorkerThread
    protected final void N(zzbj zzbjVar, String str) {
        m1.g.k(zzbjVar);
        n();
        z();
        V(new qa(this, true, u0(true), r().I(zzbjVar), zzbjVar, str));
    }

    @WorkerThread
    protected final void O(q9 q9Var) {
        n();
        z();
        V(new na(this, q9Var));
    }

    @WorkerThread
    protected final void U(zzpy zzpyVar) {
        n();
        z();
        V(new ea(this, u0(true), r().J(zzpyVar), zzpyVar));
    }

    @WorkerThread
    public final void W(AtomicReference<String> atomicReference) {
        n();
        z();
        V(new ga(this, atomicReference, u0(false)));
    }

    @WorkerThread
    protected final void X(final AtomicReference<List<zzow>> atomicReference, final Bundle bundle) {
        n();
        z();
        final zzq zzqVarU0 = u0(false);
        if (d().u(g0.f3576j1)) {
            V(new Runnable() { // from class: b2.h1
                @Override // java.lang.Runnable
                public final void run() {
                    x9.S(this.f685a, atomicReference, zzqVarU0, bundle);
                }
            });
        } else {
            V(new ba(this, atomicReference, zzqVarU0, bundle));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void Y(final AtomicReference<zzpd> atomicReference, final zzpb zzpbVar) {
        n();
        z();
        final zzq zzqVarU0 = u0(false);
        V(new Runnable() { // from class: b2.j1
            @Override // java.lang.Runnable
            public final void run() {
                x9.T(this.f700a, atomicReference, zzqVarU0, zzpbVar);
            }
        });
    }

    @WorkerThread
    protected final void Z(AtomicReference<List<zzai>> atomicReference, String str, String str2, String str3) {
        n();
        z();
        V(new sa(this, atomicReference, str, str2, str3, u0(false)));
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ p6 a() {
        return super.a();
    }

    @WorkerThread
    protected final void a0(AtomicReference<List<zzpy>> atomicReference, String str, String str2, String str3, boolean z10) {
        n();
        z();
        V(new ua(this, atomicReference, str, str2, str3, u0(false), z10));
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ Context b() {
        return super.b();
    }

    @WorkerThread
    protected final void b0(boolean z10) {
        n();
        z();
        if (n0()) {
            V(new ra(this, u0(false)));
        }
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ com.google.android.gms.common.util.d c() {
        return super.c();
    }

    @WorkerThread
    protected final zzan c0() {
        n();
        z();
        b2.g gVar = this.f4201d;
        if (gVar == null) {
            g0();
            l().G().a("Failed to get consents; not connected to service yet.");
            return null;
        }
        zzq zzqVarU0 = u0(false);
        m1.g.k(zzqVarU0);
        try {
            zzan zzanVarD = gVar.D(zzqVarU0);
            r0();
            return zzanVarD;
        } catch (RemoteException e10) {
            l().H().b("Failed to get consents; remote exception", e10);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ i d() {
        return super.d();
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ e e() {
        return super.e();
    }

    @WorkerThread
    protected final void e0() {
        n();
        z();
        V(new ka(this, u0(true)));
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ a0 f() {
        return super.f();
    }

    @WorkerThread
    protected final void f0() {
        n();
        z();
        zzq zzqVarU0 = u0(true);
        r().L();
        V(new ia(this, zzqVarU0));
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ k5 g() {
        return super.g();
    }

    @WorkerThread
    final void g0() {
        n();
        z();
        if (!l0()) {
            if (p0()) {
                this.f4200c.b();
                return;
            }
            if (!d().a0()) {
                List<ResolveInfo> listQueryIntentServices = b().getPackageManager().queryIntentServices(new Intent().setClassName(b(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
                if (listQueryIntentServices != null && !listQueryIntentServices.isEmpty()) {
                    Intent intent = new Intent("com.google.android.gms.measurement.START");
                    intent.setComponent(new ComponentName(b(), "com.google.android.gms.measurement.AppMeasurementService"));
                    this.f4200c.c(intent);
                    return;
                }
                l().H().a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ a6 h() {
        return super.h();
    }

    @WorkerThread
    public final void h0() {
        n();
        z();
        this.f4200c.e();
        try {
            s1.b.b().c(b(), this.f4200c);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.f4201d = null;
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ l9 i() {
        return super.i();
    }

    @WorkerThread
    protected final void i0() {
        n();
        z();
        zzq zzqVarU0 = u0(false);
        r().K();
        V(new ha(this, zzqVarU0));
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ wc j() {
        return super.j();
    }

    @WorkerThread
    protected final void j0() {
        n();
        z();
        V(new Runnable() { // from class: b2.f1
            @Override // java.lang.Runnable
            public final void run() {
                x9.w0(this.f676a);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.v2, com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ void k() {
        super.k();
    }

    @WorkerThread
    protected final void k0() {
        n();
        z();
        V(new oa(this, u0(true)));
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ p5 l() {
        return super.l();
    }

    @WorkerThread
    public final boolean l0() {
        n();
        z();
        if (this.f4201d != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.v2, com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ void m() {
        super.m();
    }

    @WorkerThread
    final boolean m0() {
        n();
        z();
        if (!p0() || j().J0() >= 200900) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.v2, com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ void n() {
        super.n();
    }

    @WorkerThread
    final boolean n0() {
        n();
        z();
        if (!p0() || j().J0() >= g0.I0.a(null).intValue()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ w o() {
        return super.o();
    }

    @WorkerThread
    final boolean o0() {
        n();
        z();
        if (!p0() || j().J0() >= 241200) {
            return true;
        }
        return false;
    }

    @WorkerThread
    final boolean p0() {
        boolean z10;
        n();
        z();
        if (this.f4202e == null) {
            n();
            z();
            Boolean boolP = h().P();
            boolean z11 = true;
            if (boolP == null || !boolP.booleanValue()) {
                boolean z12 = false;
                if (q().E() == 1) {
                    z10 = true;
                } else {
                    l().L().a("Checking service availability");
                    int iV = j().v(12451000);
                    if (iV != 0) {
                        if (iV != 1) {
                            if (iV != 2) {
                                if (iV != 3) {
                                    if (iV != 9) {
                                        if (iV != 18) {
                                            l().M().b("Unexpected service status", Integer.valueOf(iV));
                                        } else {
                                            l().M().a("Service updating");
                                        }
                                    } else {
                                        l().M().a("Service invalid");
                                    }
                                } else {
                                    l().M().a("Service disabled");
                                }
                                z10 = false;
                                z11 = false;
                            } else {
                                l().G().a("Service container out of date");
                                if (j().J0() >= 17443) {
                                    if (boolP != null) {
                                        z11 = false;
                                    }
                                    z10 = false;
                                }
                            }
                        } else {
                            l().L().a("Service missing");
                        }
                        z10 = true;
                        z11 = false;
                    } else {
                        l().L().a("Service available");
                    }
                    z10 = true;
                }
                if (!z11 && d().a0()) {
                    l().H().a("No way to upload. Consider using the full version of Analytics");
                } else {
                    z12 = z10;
                }
                if (z12) {
                    h().x(z11);
                }
            }
            this.f4202e = Boolean.valueOf(z11);
        }
        return this.f4202e.booleanValue();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ h5 q() {
        return super.q();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ j5 r() {
        return super.r();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ z7 s() {
        return super.s();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ o9 t() {
        return super.t();
    }

    @WorkerThread
    protected final void t0(boolean z10) {
        n();
        z();
        V(new Runnable() { // from class: b2.g1
            @Override // java.lang.Runnable
            public final void run() {
                x9.v0(this.f682a);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ s9 u() {
        return super.u();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ x9 v() {
        return super.v();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ ib w() {
        return super.w();
    }
}
