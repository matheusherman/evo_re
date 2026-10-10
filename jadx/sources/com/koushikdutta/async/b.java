package com.koushikdutta.async;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Semaphore f5038a = new Semaphore(0);

    public void b() {
        this.f5038a.release();
        x.h(this);
    }

    public boolean c(long j10, TimeUnit timeUnit) {
        long jConvert = TimeUnit.MILLISECONDS.convert(j10, timeUnit);
        x xVarG = x.g(Thread.currentThread());
        b bVar = xVarG.waiter;
        xVarG.waiter = this;
        Semaphore semaphore = xVarG.queueSemaphore;
        try {
            if (this.f5038a.tryAcquire()) {
                return true;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            while (true) {
                Runnable runnableI = xVarG.remove();
                if (runnableI != null) {
                    runnableI.run();
                } else {
                    if (!semaphore.tryAcquire(Math.max(1, semaphore.availablePermits()), jConvert, TimeUnit.MILLISECONDS)) {
                        return false;
                    }
                    if (this.f5038a.tryAcquire()) {
                        return true;
                    }
                    if (System.currentTimeMillis() - jCurrentTimeMillis >= jConvert) {
                        return false;
                    }
                }
            }
        } finally {
            xVarG.waiter = bVar;
        }
    }

    public void a() {
        x xVarG = x.g(Thread.currentThread());
        b bVar = xVarG.waiter;
        xVarG.waiter = this;
        Semaphore semaphore = xVarG.queueSemaphore;
        try {
            if (this.f5038a.tryAcquire()) {
                return;
            }
            while (true) {
                Runnable runnableI = xVarG.remove();
                if (runnableI == null) {
                    semaphore.acquire(Math.max(1, semaphore.availablePermits()));
                    if (this.f5038a.tryAcquire()) {
                        return;
                    }
                } else {
                    runnableI.run();
                }
            }
        } finally {
            xVarG.waiter = bVar;
        }
    }
}
