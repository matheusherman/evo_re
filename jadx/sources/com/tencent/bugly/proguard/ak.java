package com.tencent.bugly.proguard;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class ak {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f8757a = new AtomicInteger(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ak f8758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ScheduledExecutorService f8759c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("BuglyThread-" + ak.f8757a.getAndIncrement());
            return thread;
        }
    }

    public static synchronized ak a() {
        try {
            if (f8758b == null) {
                f8758b = new ak();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f8758b;
    }

    public final synchronized void b() {
        ScheduledExecutorService scheduledExecutorService = this.f8759c;
        if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
            al.c("[AsyncTaskHandler] Close async handler.", new Object[0]);
            this.f8759c.shutdownNow();
        }
    }

    public final synchronized boolean c() {
        ScheduledExecutorService scheduledExecutorService = this.f8759c;
        return (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) ? false : true;
    }

    protected ak() {
        this.f8759c = null;
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(3, new a());
        this.f8759c = scheduledExecutorServiceNewScheduledThreadPool;
        if (scheduledExecutorServiceNewScheduledThreadPool != null && !scheduledExecutorServiceNewScheduledThreadPool.isShutdown()) {
            return;
        }
        al.d("[AsyncTaskHandler] ScheduledExecutorService is not valiable!", new Object[0]);
    }

    public final synchronized boolean a(Runnable runnable, long j10) {
        if (!c()) {
            al.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        }
        if (j10 <= 0) {
            j10 = 0;
        }
        al.c("[AsyncTaskHandler] Post a delay(time: %dms) task: %s", Long.valueOf(j10), runnable.getClass().getName());
        try {
            this.f8759c.schedule(runnable, j10, TimeUnit.MILLISECONDS);
            return true;
        } catch (Throwable th) {
            if (p.f9101c) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public final synchronized boolean a(Runnable runnable) {
        if (!c()) {
            al.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        }
        if (runnable == null) {
            al.d("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        }
        al.c("[AsyncTaskHandler] Post a normal task: %s", runnable.getClass().getName());
        try {
            this.f8759c.execute(runnable);
            return true;
        } catch (Throwable th) {
            if (p.f9101c) {
                th.printStackTrace();
            }
            return false;
        }
    }
}
