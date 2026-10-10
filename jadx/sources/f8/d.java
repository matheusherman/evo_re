package f8;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import g8.h;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class d extends h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f10071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f10072d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class a extends h.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f10073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f10074b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private volatile boolean f10075c;

        @Override // h8.c
        public void dispose() {
            this.f10075c = true;
            this.f10073a.removeCallbacksAndMessages(this);
        }

        @Override // g8.h.c
        @SuppressLint({"NewApi"})
        public h8.c c(Runnable runnable, long j10, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            if (this.f10075c) {
                return h8.b.a();
            }
            b bVar = new b(this.f10073a, p8.a.n(runnable));
            Message messageObtain = Message.obtain(this.f10073a, bVar);
            messageObtain.obj = this;
            if (this.f10074b) {
                messageObtain.setAsynchronous(true);
            }
            this.f10073a.sendMessageDelayed(messageObtain, timeUnit.toMillis(j10));
            if (!this.f10075c) {
                return bVar;
            }
            this.f10073a.removeCallbacks(bVar);
            return h8.b.a();
        }

        @Override // h8.c
        public boolean f() {
            return this.f10075c;
        }

        a(Handler handler, boolean z10) {
            this.f10073a = handler;
            this.f10074b = z10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class b implements Runnable, h8.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f10076a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Runnable f10077b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private volatile boolean f10078c;

        @Override // h8.c
        public void dispose() {
            this.f10076a.removeCallbacks(this);
            this.f10078c = true;
        }

        @Override // h8.c
        public boolean f() {
            return this.f10078c;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f10077b.run();
            } catch (Throwable th) {
                p8.a.l(th);
            }
        }

        b(Handler handler, Runnable runnable) {
            this.f10076a = handler;
            this.f10077b = runnable;
        }
    }

    @Override // g8.h
    public h.c c() {
        return new a(this.f10071c, this.f10072d);
    }

    @Override // g8.h
    @SuppressLint({"NewApi"})
    public h8.c e(Runnable runnable, long j10, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        b bVar = new b(this.f10071c, p8.a.n(runnable));
        Message messageObtain = Message.obtain(this.f10071c, bVar);
        if (this.f10072d) {
            messageObtain.setAsynchronous(true);
        }
        this.f10071c.sendMessageDelayed(messageObtain, timeUnit.toMillis(j10));
        return bVar;
    }

    d(Handler handler, boolean z10) {
        this.f10071c = handler;
        this.f10072d = z10;
    }
}
