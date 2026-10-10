package com.live.evo.fragment;

import androidx.p000lifecycle.CoroutineLiveDataKt;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a f5830d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<Object> f5831a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<i5.b0> f5832b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Runnable f5833c = new RunnableC0075a();

    /* JADX INFO: renamed from: com.live.evo.fragment.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class RunnableC0075a implements Runnable {
        RunnableC0075a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b(null);
        }
    }

    public static a a() {
        if (f5830d == null) {
            f5830d = new a();
        }
        return f5830d;
    }

    public List<i5.b0> c() {
        return this.f5832b;
    }

    private a() {
    }

    public void d() {
        com.live.evo.util.t1.a().d(this.f5833c);
        long jG = com.live.evo.l.n().g("bff_request_time", 60000);
        if (jG < CoroutineLiveDataKt.DEFAULT_TIMEOUT) {
            jG = 5000;
        }
        com.live.evo.util.t1.a().c(this.f5833c, jG);
    }

    public void b(a5.a aVar) {
    }
}
