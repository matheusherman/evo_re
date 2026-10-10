package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@WorkerThread
final class u5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v5 f4083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f4084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Throwable f4085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f4086d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f4087e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<String, List<String>> f4088f;

    /* synthetic */ u5(String str, v5 v5Var, int i10, Throwable th, byte[] bArr, Map map, b2.s sVar) {
        this(str, v5Var, i10, th, bArr, map);
    }

    private u5(String str, v5 v5Var, int i10, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        m1.g.k(v5Var);
        this.f4083a = v5Var;
        this.f4084b = i10;
        this.f4085c = th;
        this.f4086d = bArr;
        this.f4087e = str;
        this.f4088f = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4083a.a(this.f4087e, this.f4084b, this.f4085c, this.f4086d, this.f4088f);
    }
}
