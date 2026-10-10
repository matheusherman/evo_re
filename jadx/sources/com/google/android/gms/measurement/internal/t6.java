package com.google.android.gms.measurement.internal;

import android.os.Process;
import androidx.annotation.GuardedBy;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class t6 extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f4057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BlockingQueue<q6<?>> f4058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy("threadLifeCycleLock")
    private boolean f4059c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ p6 f4060d;

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean z10 = false;
        while (!z10) {
            try {
                this.f4060d.f3906j.acquire();
                z10 = true;
            } catch (InterruptedException e10) {
                b(e10);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                q6<?> q6VarPoll = this.f4058b.poll();
                if (q6VarPoll != null) {
                    Process.setThreadPriority(q6VarPoll.f3934b ? threadPriority : 10);
                    q6VarPoll.run();
                } else {
                    synchronized (this.f4057a) {
                        if (this.f4058b.peek() == null && !this.f4060d.f3907k) {
                            try {
                                this.f4057a.wait(30000L);
                            } catch (InterruptedException e11) {
                                b(e11);
                            }
                        }
                    }
                    synchronized (this.f4060d.f3905i) {
                        if (this.f4058b.peek() == null) {
                            c();
                            c();
                            return;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            c();
            throw th;
        }
    }

    public t6(p6 p6Var, String str, BlockingQueue<q6<?>> blockingQueue) {
        this.f4060d = p6Var;
        m1.g.k(str);
        m1.g.k(blockingQueue);
        this.f4057a = new Object();
        this.f4058b = blockingQueue;
        setName(str);
    }

    private final void b(InterruptedException interruptedException) {
        this.f4060d.l().M().b(getName() + " was interrupted", interruptedException);
    }

    private final void c() {
        synchronized (this.f4060d.f3905i) {
            try {
                if (!this.f4059c) {
                    this.f4060d.f3906j.release();
                    this.f4060d.f3905i.notifyAll();
                    if (this == this.f4060d.f3899c) {
                        this.f4060d.f3899c = null;
                    } else if (this == this.f4060d.f3900d) {
                        this.f4060d.f3900d = null;
                    } else {
                        this.f4060d.l().H().a("Current scheduler thread is neither worker nor network");
                    }
                    this.f4059c = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a() {
        synchronized (this.f4057a) {
            this.f4057a.notifyAll();
        }
    }
}
