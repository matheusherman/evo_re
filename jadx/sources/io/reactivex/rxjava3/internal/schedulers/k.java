package io.reactivex.rxjava3.internal.schedulers;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f11462a = b(true, "rx3.purge-enabled", true, true, new a());

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a implements j8.d<String, String> {
        a() {
        }

        @Override // j8.d
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String apply(String str) {
            return System.getProperty(str);
        }
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, threadFactory);
        scheduledThreadPoolExecutor.setRemoveOnCancelPolicy(f11462a);
        return scheduledThreadPoolExecutor;
    }

    static boolean b(boolean z10, String str, boolean z11, boolean z12, j8.d<String, String> dVar) {
        if (!z10) {
            return z12;
        }
        try {
            String strApply = dVar.apply(str);
            return strApply == null ? z11 : "true".equals(strApply);
        } catch (Throwable th) {
            i8.b.b(th);
            return z11;
        }
    }
}
