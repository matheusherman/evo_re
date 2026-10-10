package com.taobao.sophix;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile ScheduledThreadPoolExecutor f8469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile ScheduledThreadPoolExecutor f8470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicInteger f8471c = new AtomicInteger();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f8472a;

        public a(String str) {
            this.f8472a = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f8472a + k0.f8471c.getAndIncrement());
            thread.setPriority(5);
            return thread;
        }
    }

    public static void a(Runnable runnable) {
        try {
            b().execute(runnable);
        } catch (Throwable th) {
            s.a("ThreadPoolFactory", "executeSingle", th, new Object[0]);
        }
    }

    private static ScheduledThreadPoolExecutor b() {
        if (f8470b == null) {
            synchronized (k0.class) {
                try {
                    if (f8470b == null) {
                        f8470b = new ScheduledThreadPoolExecutor(4, new a("Sophix-Report"));
                        f8470b.setKeepAliveTime(10L, TimeUnit.SECONDS);
                        f8470b.allowCoreThreadTimeOut(true);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f8470b;
    }

    private static ScheduledThreadPoolExecutor c() {
        if (f8469a == null) {
            synchronized (k0.class) {
                try {
                    if (f8469a == null) {
                        f8469a = new ScheduledThreadPoolExecutor(1, new a("Sophix-Load"));
                        f8469a.setKeepAliveTime(10L, TimeUnit.SECONDS);
                        f8469a.allowCoreThreadTimeOut(true);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f8469a;
    }

    public static void a(Runnable runnable, long j10) {
        try {
            c().schedule(runnable, j10, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            s.a("ThreadPoolFactory", "executeSingle", th, new Object[0]);
        }
    }
}
