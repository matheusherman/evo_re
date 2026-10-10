package com.live.evo.boot;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f5529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f5530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f5531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ThreadPoolExecutor f5532d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ThreadFactory f5533e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final BlockingQueue<Runnable> f5534f;

    /* JADX INFO: renamed from: com.live.evo.boot.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class ThreadFactoryC0066a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f5535a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AsyncExecutor #" + this.f5535a.getAndIncrement());
        }

        ThreadFactoryC0066a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f5536a;

        b(Runnable runnable) {
            this.f5536a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f5536a.run();
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Runnable runnable) {
        f5532d.execute(new b(runnable));
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f5529a = iAvailableProcessors;
        int iMax = Math.max(2, Math.min(iAvailableProcessors - 1, 4));
        f5530b = iMax;
        int i10 = (iAvailableProcessors * 2) + 1;
        f5531c = i10;
        ThreadFactoryC0066a threadFactoryC0066a = new ThreadFactoryC0066a();
        f5533e = threadFactoryC0066a;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(128);
        f5534f = linkedBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(iMax, i10, 30L, TimeUnit.SECONDS, linkedBlockingQueue, threadFactoryC0066a, new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f5532d = threadPoolExecutor;
    }
}
