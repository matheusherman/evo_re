package o;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class a implements ExecutorService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f16414b = TimeUnit.SECONDS.toMillis(10);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile int f16415c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f16416a;

    /* JADX INFO: renamed from: o.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class C0315a {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f16417a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f16418b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f16419c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NonNull
        private final ThreadFactory f16420d = new c(null);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NonNull
        private e f16421e = e.f16435d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f16422f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f16423g;

        public a a() {
            if (TextUtils.isEmpty(this.f16422f)) {
                throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.f16422f);
            }
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.f16418b, this.f16419c, this.f16423g, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new d(this.f16420d, this.f16422f, this.f16421e, this.f16417a));
            if (this.f16423g != 0) {
                threadPoolExecutor.allowCoreThreadTimeOut(true);
            }
            return new a(threadPoolExecutor);
        }

        public b b(String str) {
            this.f16422f = str;
            return this;
        }

        public b c(@IntRange(from = 1) int i10) {
            this.f16418b = i10;
            this.f16419c = i10;
            return this;
        }

        b(boolean z10) {
            this.f16417a = z10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class c implements ThreadFactory {

        /* JADX INFO: renamed from: o.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class C0316a extends Thread {
            C0316a(Runnable runnable) {
                super(runnable);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(9);
                super.run();
            }
        }

        private c() {
        }

        /* synthetic */ c(C0315a c0315a) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            return new C0316a(runnable);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class d implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ThreadFactory f16425a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f16426b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final e f16427c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f16428d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final AtomicInteger f16429e = new AtomicInteger();

        /* JADX INFO: renamed from: o.a$d$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class RunnableC0317a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Runnable f16430a;

            RunnableC0317a(Runnable runnable) {
                this.f16430a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (d.this.f16428d) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    this.f16430a.run();
                } catch (Throwable th) {
                    d.this.f16427c.a(th);
                }
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            Thread threadNewThread = this.f16425a.newThread(new RunnableC0317a(runnable));
            threadNewThread.setName("glide-" + this.f16426b + "-thread-" + this.f16429e.getAndIncrement());
            return threadNewThread;
        }

        d(ThreadFactory threadFactory, String str, e eVar, boolean z10) {
            this.f16425a = threadFactory;
            this.f16426b = str;
            this.f16427c = eVar;
            this.f16428d = z10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f16432a = new C0318a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f16433b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f16434c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final e f16435d;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class b implements e {
            @Override // o.a.e
            public void a(Throwable th) {
                if (th == null || !Log.isLoggable("GlideExecutor", 6)) {
                    return;
                }
                Log.e("GlideExecutor", "Request threw uncaught throwable", th);
            }

            b() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class c implements e {
            @Override // o.a.e
            public void a(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }

            c() {
            }
        }

        void a(Throwable th);

        /* JADX INFO: renamed from: o.a$e$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class C0318a implements e {
            C0318a() {
            }

            @Override // o.a.e
            public void a(Throwable th) {
            }
        }

        static {
            b bVar = new b();
            f16433b = bVar;
            f16434c = new c();
            f16435d = bVar;
        }
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) {
        return this.f16416a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) {
        return (T) this.f16416a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return this.f16416a.submit(runnable);
    }

    public static int b() {
        if (f16415c == 0) {
            f16415c = Math.min(4, o.b.a());
        }
        return f16415c;
    }

    public static b e() {
        return new b(true).c(1).b("disk-cache");
    }

    public static b g() {
        return new b(false).c(b()).b("source");
    }

    public static a i() {
        return new a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f16414b, TimeUnit.MILLISECONDS, new SynchronousQueue(), new d(new c(null), "source-unlimited", e.f16435d, false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j10, @NonNull TimeUnit timeUnit) {
        return this.f16416a.awaitTermination(j10, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.f16416a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j10, @NonNull TimeUnit timeUnit) {
        return this.f16416a.invokeAll(collection, j10, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j10, @NonNull TimeUnit timeUnit) {
        return (T) this.f16416a.invokeAny(collection, j10, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f16416a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f16416a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f16416a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public List<Runnable> shutdownNow() {
        return this.f16416a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t10) {
        return this.f16416a.submit(runnable, t10);
    }

    public String toString() {
        return this.f16416a.toString();
    }

    @VisibleForTesting
    a(ExecutorService executorService) {
        this.f16416a = executorService;
    }

    static int a() {
        if (b() >= 4) {
            return 2;
        }
        return 1;
    }

    public static b c() {
        return new b(true).c(a()).b("animation");
    }

    public static a d() {
        return c().a();
    }

    public static a f() {
        return e().a();
    }

    public static a h() {
        return g().a();
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.f16416a.submit(callable);
    }
}
