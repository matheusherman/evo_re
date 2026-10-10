package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class mb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f3822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f3823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ jb f3824c;

    mb(jb jbVar, long j10, long j11) {
        this.f3824c = jbVar;
        this.f3822a = j10;
        this.f3823b = j11;
    }

    public static /* synthetic */ void a(mb mbVar) {
        jb jbVar = mbVar.f3824c;
        long j10 = mbVar.f3822a;
        long j11 = mbVar.f3823b;
        jbVar.f3748b.n();
        jbVar.f3748b.l().G().a("Application going to the background");
        jbVar.f3748b.h().f3386u.a(true);
        jbVar.f3748b.F(true);
        if (!jbVar.f3748b.d().Y()) {
            jbVar.f3748b.G(false, false, j11);
            jbVar.f3748b.f3721f.e(j11);
        }
        jbVar.f3748b.l().K().b("Application backgrounded at: timestamp_millis", Long.valueOf(j10));
        jbVar.f3748b.s().G0();
        if (jbVar.f3748b.d().u(g0.S0)) {
            long jD = jbVar.f3748b.j().G0(jbVar.f3748b.b().getPackageName(), jbVar.f3748b.d().W()) ? 1000L : jbVar.f3748b.d().D(jbVar.f3748b.b().getPackageName(), g0.E);
            jbVar.f3748b.l().L().b("[sgtm] Scheduling batch upload with minimum latency in millis", Long.valueOf(jD));
            jbVar.f3748b.t().D(jD);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3824c.f3748b.a().E(new Runnable() { // from class: com.google.android.gms.measurement.internal.lb
            @Override // java.lang.Runnable
            public final void run() {
                mb.a(this.f3789a);
            }
        });
    }
}
