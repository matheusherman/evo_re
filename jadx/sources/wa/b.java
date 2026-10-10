package wa;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.internal.g0;
import kotlinx.coroutines.k1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\n\u0010\u0012\u001a\u00060\u0005j\u0002`\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\n\u0010\u0012\u001a\u00060\u0005j\u0002`\u0011H\u0017¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lwa/b;", "Lkotlinx/coroutines/k1;", "Ljava/util/concurrent/Executor;", "<init>", "()V", "Ljava/lang/Runnable;", "command", "Lr8/z;", "execute", "(Ljava/lang/Runnable;)V", "", "parallelism", "Lkotlinx/coroutines/i0;", "limitedParallelism", "(I)Lkotlinx/coroutines/i0;", "Lv8/j;", "context", "Lkotlinx/coroutines/Runnable;", "block", "dispatch", "(Lv8/j;Ljava/lang/Runnable;)V", "dispatchYield", "close", "", "toString", "()Ljava/lang/String;", "c", "Lkotlinx/coroutines/i0;", "default", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class b extends k1 implements Executor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f20427b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final i0 default = m.f20448a.limitedParallelism(kotlinx.coroutines.internal.i0.e("kotlinx.coroutines.io.parallelism", h9.f.c(64, g0.a()), 0, 0, 12, null));

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // kotlinx.coroutines.i0
    public void dispatch(v8.j context, Runnable block) {
        default.dispatch(context, block);
    }

    @Override // kotlinx.coroutines.i0
    public void dispatchYield(v8.j context, Runnable block) {
        default.dispatchYield(context, block);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        dispatch(v8.k.f19724a, command);
    }

    @Override // kotlinx.coroutines.i0
    public i0 limitedParallelism(int parallelism) {
        return m.f20448a.limitedParallelism(parallelism);
    }

    @Override // kotlinx.coroutines.i0
    public String toString() {
        return "Dispatchers.IO";
    }

    private b() {
    }
}
