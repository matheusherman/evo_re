package io.reactivex.rxjava3.internal.schedulers;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class e extends g8.h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final g f11454d = new g("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx3.newthread-priority", 5).intValue())));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ThreadFactory f11455c;

    public e() {
        this(f11454d);
    }

    public e(ThreadFactory threadFactory) {
        this.f11455c = threadFactory;
    }

    @Override // g8.h
    public g8.h.c c() {
        return new f(this.f11455c);
    }
}
