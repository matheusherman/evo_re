package io.reactivex.rxjava3.internal.schedulers;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class i extends a implements Callable<Void> {
    private static final long serialVersionUID = 1811839108042568751L;

    public i(Runnable runnable, boolean z10) {
        super(runnable, z10);
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Void call() {
        this.runner = Thread.currentThread();
        try {
            try {
                this.runnable.run();
                return null;
            } finally {
                lazySet(a.f11412a);
                this.runner = null;
            }
        } catch (Throwable th) {
            p8.a.l(th);
            throw th;
        }
    }

    @Override // io.reactivex.rxjava3.internal.schedulers.a, java.util.concurrent.atomic.AtomicReference
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
