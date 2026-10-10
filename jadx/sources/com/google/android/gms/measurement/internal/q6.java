package com.google.android.gms.measurement.internal;

import androidx.annotation.NonNull;
import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class q6<V> extends FutureTask<V> implements Comparable<q6<V>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f3933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final boolean f3934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f3935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ p6 f3936d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    q6(p6 p6Var, Runnable runnable, boolean z10, String str) {
        super(com.google.android.gms.internal.measurement.m2.a().b(runnable), null);
        this.f3936d = p6Var;
        m1.g.k(str);
        long andIncrement = p6.f3898l.getAndIncrement();
        this.f3933a = andIncrement;
        this.f3935c = str;
        this.f3934b = z10;
        if (andIncrement == LocationRequestCompat.PASSIVE_INTERVAL) {
            p6Var.l().H().a("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(@NonNull Object obj) {
        q6 q6Var = (q6) obj;
        boolean z10 = this.f3934b;
        if (z10 != q6Var.f3934b) {
            return z10 ? -1 : 1;
        }
        long j10 = this.f3933a;
        long j11 = q6Var.f3933a;
        if (j10 < j11) {
            return -1;
        }
        if (j10 > j11) {
            return 1;
        }
        this.f3936d.l().J().b("Two tasks share the same index. index", Long.valueOf(this.f3933a));
        return 0;
    }

    @Override // java.util.concurrent.FutureTask
    protected final void setException(Throwable th) {
        this.f3936d.l().H().b(this.f3935c, th);
        super.setException(th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    q6(p6 p6Var, Callable<V> callable, boolean z10, String str) {
        super(com.google.android.gms.internal.measurement.m2.a().a(callable));
        this.f3936d = p6Var;
        m1.g.k(str);
        long andIncrement = p6.f3898l.getAndIncrement();
        this.f3933a = andIncrement;
        this.f3935c = str;
        this.f3934b = z10;
        if (andIncrement == LocationRequestCompat.PASSIVE_INTERVAL) {
            p6Var.l().H().a("Tasks index overflow");
        }
    }
}
