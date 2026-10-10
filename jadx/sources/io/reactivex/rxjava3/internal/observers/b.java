package io.reactivex.rxjava3.internal.observers;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class b<T> extends AtomicInteger implements o8.a<T> {
    private static final long serialVersionUID = -1001730202384742097L;

    @Override // o8.c
    public final boolean offer(T t10) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
