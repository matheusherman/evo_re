package wa;

import kotlin.Metadata;
import kotlinx.coroutines.i0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lwa/c;", "Lwa/f;", "<init>", "()V", "", "parallelism", "Lkotlinx/coroutines/i0;", "limitedParallelism", "(I)Lkotlinx/coroutines/i0;", "Lr8/z;", "close", "", "toString", "()Ljava/lang/String;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class c extends f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f20429g = new c();

    private c() {
        super(l.f20442c, l.f20443d, l.f20444e, l.f20440a);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // kotlinx.coroutines.i0
    public String toString() {
        return "Dispatchers.Default";
    }

    @Override // kotlinx.coroutines.i0
    public i0 limitedParallelism(int parallelism) {
        kotlinx.coroutines.internal.n.a(parallelism);
        if (parallelism >= l.f20442c) {
            return this;
        }
        return super.limitedParallelism(parallelism);
    }
}
