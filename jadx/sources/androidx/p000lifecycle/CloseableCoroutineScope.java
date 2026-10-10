package androidx.p000lifecycle;

import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.l0;
import v8.j;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/lifecycle/CloseableCoroutineScope;", "Ljava/io/Closeable;", "Lkotlinx/coroutines/l0;", "Lv8/j;", "context", "<init>", "(Lv8/j;)V", "Lr8/z;", "close", "()V", "coroutineContext", "Lv8/j;", "getCoroutineContext", "()Lv8/j;", "lifecycle-viewmodel-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CloseableCoroutineScope implements Closeable, l0 {
    private final j coroutineContext;

    public CloseableCoroutineScope(j context) {
        m.f(context, "context");
        this.coroutineContext = context;
    }

    @Override // kotlinx.coroutines.l0
    public j getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a2.d(getCoroutineContext(), null, 1, null);
    }
}
