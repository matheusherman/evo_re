package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class q2 extends t2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference<Bundle> f2951a = new AtomicReference<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2952b;

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0003, code lost:
    
        r4 = r4.get("r");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> T g(Bundle bundle, Class<T> cls) {
        Object obj;
        if (bundle == null || obj == null) {
            return null;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException e10) {
            Log.w("AM", String.format("Unexpected object type. Expected, Received: %s, %s", cls.getCanonicalName(), obj.getClass().getCanonicalName()), e10);
            throw e10;
        }
    }

    public final Bundle f(long j10) {
        Bundle bundle;
        synchronized (this.f2951a) {
            if (!this.f2952b) {
                try {
                    this.f2951a.wait(j10);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            bundle = this.f2951a.get();
        }
        return bundle;
    }

    @Override // com.google.android.gms.internal.measurement.u2
    public final void m(Bundle bundle) {
        synchronized (this.f2951a) {
            try {
                try {
                    this.f2951a.set(bundle);
                    this.f2952b = true;
                    this.f2951a.notify();
                } catch (Throwable th) {
                    this.f2951a.notify();
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final Long W(long j10) {
        return (Long) g(f(j10), Long.class);
    }

    public final String X(long j10) {
        return (String) g(f(j10), String.class);
    }
}
