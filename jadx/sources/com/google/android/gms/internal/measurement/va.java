package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class va {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile ob f3173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile v8 f3174b;

    public final int a() {
        if (this.f3174b != null) {
            return this.f3174b.r();
        }
        if (this.f3173a != null) {
            return this.f3173a.e();
        }
        return 0;
    }

    public final ob b(ob obVar) {
        ob obVar2 = this.f3173a;
        this.f3174b = null;
        this.f3173a = obVar;
        return obVar2;
    }

    public final v8 c() {
        if (this.f3174b != null) {
            return this.f3174b;
        }
        synchronized (this) {
            try {
                if (this.f3174b != null) {
                    return this.f3174b;
                }
                if (this.f3173a == null) {
                    this.f3174b = v8.f3170a;
                } else {
                    this.f3174b = this.f3173a.h();
                }
                return this.f3174b;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
