package kotlinx.coroutines;

import java.util.concurrent.Executor;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003*\f\b\u0007\u0010\u0005\"\u00020\u00042\u00020\u0004¨\u0006\u0006"}, d2 = {"Ljava/util/concurrent/Executor;", "Lkotlinx/coroutines/i0;", "a", "(Ljava/util/concurrent/Executor;)Lkotlinx/coroutines/i0;", "Lkotlinx/coroutines/k1;", "CloseableCoroutineDispatcher", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class m1 {
    public static final i0 a(Executor executor) {
        return new l1(executor);
    }
}
