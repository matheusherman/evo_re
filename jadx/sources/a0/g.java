package a0;

import android.graphics.drawable.Drawable;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import l.q;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class g<R> implements d<R>, h<R> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final a f44k = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f45a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f46b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f47c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f48d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    @GuardedBy("this")
    private R f49e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    @GuardedBy("this")
    private e f50f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f51g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f52h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f53i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    @GuardedBy("this")
    private q f54j;

    public g(int i10, int i11) {
        this(i10, i11, true, f44k);
    }

    private synchronized R o(Long l10) {
        try {
            if (this.f47c && !isDone()) {
                e0.l.a();
            }
            if (this.f51g) {
                throw new CancellationException();
            }
            if (this.f53i) {
                throw new ExecutionException(this.f54j);
            }
            if (this.f52h) {
                return this.f49e;
            }
            if (l10 == null) {
                this.f48d.b(this, 0L);
            } else if (l10.longValue() > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jLongValue = l10.longValue() + jCurrentTimeMillis;
                while (!isDone() && jCurrentTimeMillis < jLongValue) {
                    this.f48d.b(this, jLongValue - jCurrentTimeMillis);
                    jCurrentTimeMillis = System.currentTimeMillis();
                }
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            if (this.f53i) {
                throw new ExecutionException(this.f54j);
            }
            if (this.f51g) {
                throw new CancellationException();
            }
            if (!this.f52h) {
                throw new TimeoutException();
            }
            return this.f49e;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // b0.i
    public synchronized void b(@NonNull R r10, @Nullable c0.b<? super R> bVar) {
    }

    @Override // a0.h
    public synchronized boolean c(R r10, Object obj, b0.i<R> iVar, j.a aVar, boolean z10) {
        this.f52h = true;
        this.f49e = r10;
        this.f48d.a(this);
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        synchronized (this) {
            try {
                if (isDone()) {
                    return false;
                }
                this.f51g = true;
                this.f48d.a(this);
                e eVar = null;
                if (z10) {
                    e eVar2 = this.f50f;
                    this.f50f = null;
                    eVar = eVar2;
                }
                if (eVar != null) {
                    eVar.clear();
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // a0.h
    public synchronized boolean e(@Nullable q qVar, Object obj, b0.i<R> iVar, boolean z10) {
        this.f53i = true;
        this.f54j = qVar;
        this.f48d.a(this);
        return false;
    }

    @Override // b0.i
    public synchronized void g(@Nullable Drawable drawable) {
    }

    @Override // java.util.concurrent.Future
    public R get() {
        try {
            return o(null);
        } catch (TimeoutException e10) {
            throw new AssertionError(e10);
        }
    }

    @Override // b0.i
    public synchronized void i(@Nullable e eVar) {
        this.f50f = eVar;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.f51g;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        return this.f51g || this.f52h || this.f53i;
    }

    @Override // b0.i
    @Nullable
    public synchronized e l() {
        return this.f50f;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @VisibleForTesting
    static class a {
        a() {
        }

        void a(Object obj) {
            obj.notifyAll();
        }

        void b(Object obj, long j10) throws InterruptedException {
            obj.wait(j10);
        }
    }

    g(int i10, int i11, boolean z10, a aVar) {
        this.f45a = i10;
        this.f46b = i11;
        this.f47c = z10;
        this.f48d = aVar;
    }

    @Override // b0.i
    public void j(@NonNull b0.h hVar) {
        hVar.e(this.f45a, this.f46b);
    }

    public String toString() {
        e eVar;
        String str;
        String str2 = super.toString() + "[status=";
        synchronized (this) {
            try {
                eVar = null;
                if (this.f51g) {
                    str = "CANCELLED";
                } else if (this.f53i) {
                    str = "FAILURE";
                } else if (this.f52h) {
                    str = "SUCCESS";
                } else {
                    str = "PENDING";
                    eVar = this.f50f;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (eVar == null) {
            return str2 + str + "]";
        }
        return str2 + str + ", request=[" + eVar + "]]";
    }

    @Override // java.util.concurrent.Future
    public R get(long j10, @NonNull TimeUnit timeUnit) {
        return o(Long.valueOf(timeUnit.toMillis(j10)));
    }

    @Override // com.bumptech.glide.manager.m
    public void d() {
    }

    @Override // com.bumptech.glide.manager.m
    public void h() {
    }

    @Override // com.bumptech.glide.manager.m
    public void onStart() {
    }

    @Override // b0.i
    public void a(@NonNull b0.h hVar) {
    }

    @Override // b0.i
    public void k(@Nullable Drawable drawable) {
    }

    @Override // b0.i
    public void n(@Nullable Drawable drawable) {
    }
}
