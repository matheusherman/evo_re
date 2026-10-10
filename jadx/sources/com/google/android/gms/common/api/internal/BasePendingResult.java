package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.api.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import k1.a1;
import m1.g;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@KeepName
public abstract class BasePendingResult<R extends k> extends h<R> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static final ThreadLocal f2182n = new b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private l f2188f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private k f2190h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Status f2191i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile boolean f2192j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f2193k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f2194l;

    @KeepName
    private c resultGuardian;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f2183a = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CountDownLatch f2186d = new CountDownLatch(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ArrayList f2187e = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicReference f2189g = new AtomicReference();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f2195m = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    protected final a f2184b = new a(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    protected final WeakReference f2185c = new WeakReference(null);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @VisibleForTesting
    public static class a<R extends k> extends x1.l {
        public final void a(@NonNull l lVar, @NonNull k kVar) {
            ThreadLocal threadLocal = BasePendingResult.f2182n;
            sendMessage(obtainMessage(1, new Pair((l) g.k(lVar), kVar)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            int i10 = message.what;
            if (i10 != 1) {
                if (i10 == 2) {
                    ((BasePendingResult) message.obj).b(Status.f2155i);
                    return;
                }
                Log.wtf("BasePendingResult", "Don't know how to handle message: " + i10, new Exception());
                return;
            }
            Pair pair = (Pair) message.obj;
            l lVar = (l) pair.first;
            k kVar = (k) pair.second;
            try {
                lVar.a(kVar);
            } catch (RuntimeException e10) {
                BasePendingResult.h(kVar);
                throw e10;
            }
        }

        public a(@NonNull Looper looper) {
            super(looper);
        }
    }

    @NonNull
    protected abstract R a(@NonNull Status status);

    private final k e() {
        k kVar;
        synchronized (this.f2183a) {
            g.p(!this.f2192j, "Result has already been consumed.");
            g.p(c(), "Result is not ready.");
            kVar = this.f2190h;
            this.f2190h = null;
            this.f2188f = null;
            this.f2192j = true;
        }
        if (((com.google.android.gms.common.api.internal.a) this.f2189g.getAndSet(null)) == null) {
            return (k) g.k(kVar);
        }
        throw null;
    }

    private final void f(k kVar) {
        this.f2190h = kVar;
        this.f2191i = kVar.B();
        this.f2186d.countDown();
        a1 a1Var = null;
        if (this.f2193k) {
            this.f2188f = null;
        } else {
            l lVar = this.f2188f;
            if (lVar != null) {
                this.f2184b.removeMessages(2);
                this.f2184b.a(lVar, e());
            } else if (this.f2190h instanceof i) {
                this.resultGuardian = new c(this, a1Var);
            }
        }
        ArrayList arrayList = this.f2187e;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((h.a) arrayList.get(i10)).a(this.f2191i);
        }
        this.f2187e.clear();
    }

    public static void h(@Nullable k kVar) {
        if (kVar instanceof i) {
            try {
                ((i) kVar).release();
            } catch (RuntimeException e10) {
                Log.w("BasePendingResult", "Unable to release ".concat(String.valueOf(kVar)), e10);
            }
        }
    }

    @Deprecated
    public final void b(@NonNull Status status) {
        synchronized (this.f2183a) {
            try {
                if (!c()) {
                    d(a(status));
                    this.f2194l = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean c() {
        return this.f2186d.getCount() == 0;
    }

    public final void d(@NonNull R r10) {
        synchronized (this.f2183a) {
            try {
                if (this.f2194l || this.f2193k) {
                    h(r10);
                    return;
                }
                c();
                g.p(!c(), "Results have already been set");
                g.p(!this.f2192j, "Result has already been consumed");
                f(r10);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Deprecated
    BasePendingResult() {
    }
}
