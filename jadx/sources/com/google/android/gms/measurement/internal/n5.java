package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.TelemetryData;
import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class n5 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static n5 f3830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Duration f3831e = Duration.ofMinutes(30);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s6 f3832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m1.k f3833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicLong f3834c = new AtomicLong(-1);

    static n5 a(s6 s6Var) {
        if (f3830d == null) {
            f3830d = new n5(s6Var.b(), s6Var);
        }
        return f3830d;
    }

    public final synchronized void b(int i10, int i11, long j10, long j11, int i12) {
        final long jB = this.f3832a.c().b();
        if (this.f3834c.get() != -1 && jB - this.f3834c.get() <= f3831e.toMillis()) {
            return;
        }
        this.f3833b.a(new TelemetryData(0, Arrays.asList(new MethodInvocation(36301, i11, 0, j10, j11, null, null, 0, i12)))).d(new e2.d() { // from class: b2.p
            @Override // e2.d
            public final void c(Exception exc) {
                this.f716a.f3834c.set(jB);
            }
        });
    }

    private n5(Context context, s6 s6Var) {
        this.f3833b = m1.j.b(context, m1.l.a().b("measurement:api").a());
        this.f3832a = s6Var;
    }
}
