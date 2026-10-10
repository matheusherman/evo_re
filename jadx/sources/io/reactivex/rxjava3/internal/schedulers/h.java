package io.reactivex.rxjava3.internal.schedulers;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class h extends a implements Runnable {
    private static final long serialVersionUID = 1811839108042568751L;

    public h(Runnable runnable, boolean z10) {
        super(runnable, z10);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.runner = Thread.currentThread();
        try {
            this.runnable.run();
            this.runner = null;
        } catch (Throwable th) {
            dispose();
            this.runner = null;
            p8.a.l(th);
            throw th;
        }
    }

    @Override // io.reactivex.rxjava3.internal.schedulers.a, java.util.concurrent.atomic.AtomicReference
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
