package com.koushikdutta.async;

import java.io.Closeable;
import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
class u implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Selector f5160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AtomicBoolean f5161b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Semaphore f5162c = new Semaphore(0);

    public boolean j() {
        for (int i10 = 0; i10 < 100; i10++) {
            try {
                this.f5162c.tryAcquire(10L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                return true;
            }
        }
        return false;
    }

    public Selector a() {
        return this.f5160a;
    }

    public Set<SelectionKey> b() {
        return this.f5160a.keys();
    }

    public void c() {
        d(0L);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f5160a.close();
    }

    public int f() {
        return this.f5160a.selectNow();
    }

    public Set<SelectionKey> i() {
        return this.f5160a.selectedKeys();
    }

    public boolean isOpen() {
        return this.f5160a.isOpen();
    }

    public void k() {
        boolean zTryAcquire = this.f5162c.tryAcquire();
        this.f5160a.wakeup();
        if (zTryAcquire) {
            if (this.f5161b.getAndSet(true)) {
                this.f5160a.wakeup();
                return;
            }
            try {
                j();
                this.f5160a.wakeup();
            } finally {
                this.f5161b.set(false);
            }
        }
    }

    public u(Selector selector) {
        this.f5160a = selector;
    }

    public void d(long j10) {
        try {
            this.f5162c.drainPermits();
            this.f5160a.select(j10);
        } finally {
            this.f5162c.release(Integer.MAX_VALUE);
        }
    }
}
