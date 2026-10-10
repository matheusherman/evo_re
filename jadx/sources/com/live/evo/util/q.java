package com.live.evo.util;

import android.os.Handler;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class q {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static q f7330f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<i5.t> f7331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<i5.r> f7332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<i5.q> f7333c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Runnable f7335e = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f7334d = new Handler();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            q.this.a();
        }
    }

    public static q d() {
        if (f7330f == null) {
            synchronized (q.class) {
                try {
                    if (f7330f == null) {
                        f7330f = new q();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f7330f;
    }

    public void a() {
        this.f7334d.removeCallbacks(this.f7335e);
    }

    public List<i5.q> b() {
        return this.f7333c;
    }

    public List<i5.r> c() {
        return this.f7332b;
    }

    public List<i5.t> e() {
        return this.f7331a;
    }

    private q() {
    }
}
