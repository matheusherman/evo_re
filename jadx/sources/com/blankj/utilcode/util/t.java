package com.blankj.utilcode.util;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Handler f1244a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<Integer, Map<Integer, ExecutorService>> f1245b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<Object, ExecutorService> f1246c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f1247d = Runtime.getRuntime().availableProcessors();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Timer f1248e = new Timer();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class a extends LinkedBlockingQueue<Runnable> {
        private int mCapacity;
        private volatile b mPool;

        a() {
            this.mCapacity = Integer.MAX_VALUE;
        }

        @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public boolean offer(@NonNull Runnable runnable) {
            if (this.mCapacity > size() || this.mPool == null || this.mPool.getPoolSize() >= this.mPool.getMaximumPoolSize()) {
                return super.offer(runnable);
            }
            return false;
        }

        a(boolean z10) {
            this.mCapacity = Integer.MAX_VALUE;
            if (z10) {
                this.mCapacity = 0;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends ThreadPoolExecutor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f1249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private a f1250b;

        /* JADX INFO: Access modifiers changed from: private */
        public static ExecutorService b(int i10, int i11) {
            if (i10 == -8) {
                return new b(t.f1247d + 1, (t.f1247d * 2) + 1, 30L, TimeUnit.SECONDS, new a(true), new c("cpu", i11));
            }
            if (i10 == -4) {
                return new b((t.f1247d * 2) + 1, (t.f1247d * 2) + 1, 30L, TimeUnit.SECONDS, new a(), new c("io", i11));
            }
            if (i10 == -2) {
                return new b(0, 128, 60L, TimeUnit.SECONDS, new a(true), new c("cached", i11));
            }
            if (i10 == -1) {
                return new b(1, 1, 0L, TimeUnit.MILLISECONDS, new a(), new c("single", i11));
            }
            return new b(i10, i10, 0L, TimeUnit.MILLISECONDS, new a(), new c("fixed(" + i10 + ")", i11));
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        protected void afterExecute(Runnable runnable, Throwable th) {
            this.f1249a.decrementAndGet();
            super.afterExecute(runnable, th);
        }

        b(int i10, int i11, long j10, TimeUnit timeUnit, a aVar, ThreadFactory threadFactory) {
            super(i10, i11, j10, timeUnit, aVar, threadFactory);
            this.f1249a = new AtomicInteger();
            aVar.mPool = this;
            this.f1250b = aVar;
        }

        @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            if (!isShutdown()) {
                this.f1249a.incrementAndGet();
                try {
                    super.execute(runnable);
                } catch (RejectedExecutionException unused) {
                    Log.e("ThreadUtils", "This will not happen!");
                    this.f1250b.offer(runnable);
                } catch (Throwable unused2) {
                    this.f1249a.decrementAndGet();
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends AtomicLong implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final AtomicInteger f1251a = new AtomicInteger(1);
        private static final long serialVersionUID = -9209200509960368598L;
        private final boolean isDaemon;
        private final String namePrefix;
        private final int priority;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class a extends Thread {
            a(Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    super.run();
                } catch (Throwable th) {
                    Log.e("ThreadUtils", "Request threw uncaught throwable", th);
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class b implements Thread.UncaughtExceptionHandler {
            b() {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                System.out.println(th);
            }
        }

        c(String str, int i10) {
            this(str, i10, false);
        }

        c(String str, int i10, boolean z10) {
            this.namePrefix = str + "-pool-" + f1251a.getAndIncrement() + "-thread-";
            this.priority = i10;
            this.isDaemon = z10;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            a aVar = new a(runnable, this.namePrefix + getAndIncrement());
            aVar.setDaemon(this.isDaemon);
            aVar.setUncaughtExceptionHandler(new b());
            aVar.setPriority(this.priority);
            return aVar;
        }
    }

    public static ExecutorService b() {
        return c(-2);
    }

    private static ExecutorService c(int i10) {
        return d(i10, 5);
    }

    private static ExecutorService d(int i10, int i11) {
        ExecutorService executorServiceB;
        Map<Integer, Map<Integer, ExecutorService>> map = f1245b;
        synchronized (map) {
            try {
                Map<Integer, ExecutorService> map2 = map.get(Integer.valueOf(i10));
                if (map2 == null) {
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                    executorServiceB = b.b(i10, i11);
                    concurrentHashMap.put(Integer.valueOf(i11), executorServiceB);
                    map.put(Integer.valueOf(i10), concurrentHashMap);
                } else {
                    executorServiceB = map2.get(Integer.valueOf(i11));
                    if (executorServiceB == null) {
                        executorServiceB = b.b(i10, i11);
                        map2.put(Integer.valueOf(i11), executorServiceB);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return executorServiceB;
    }

    public static void f(Runnable runnable, long j10) {
        f1244a.postDelayed(runnable, j10);
    }

    public static void e(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            f1244a.post(runnable);
        }
    }
}
