package h8;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
abstract class e<T> extends AtomicReference<T> implements c {
    private static final long serialVersionUID = 6537757548749041217L;

    protected abstract void a(T t10);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    e(T t10) {
        super(t10);
        Objects.requireNonNull(t10, "value is null");
    }

    @Override // h8.c
    public final void dispose() {
        T andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            a(andSet);
        }
    }

    @Override // h8.c
    public final boolean f() {
        if (get() == null) {
            return true;
        }
        return false;
    }
}
