package wa;

import kotlin.Metadata;
import kotlinx.coroutines.i0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0017¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\rH\u0017¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lwa/m;", "Lkotlinx/coroutines/i0;", "<init>", "()V", "Lv8/j;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lr8/z;", "dispatchYield", "(Lv8/j;Ljava/lang/Runnable;)V", "dispatch", "", "parallelism", "limitedParallelism", "(I)Lkotlinx/coroutines/i0;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class m extends i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f20448a = new m();

    @Override // kotlinx.coroutines.i0
    public void dispatch(v8.j context, Runnable block) {
        c.f20429g.o(block, l.f20447h, false);
    }

    @Override // kotlinx.coroutines.i0
    public void dispatchYield(v8.j context, Runnable block) {
        c.f20429g.o(block, l.f20447h, true);
    }

    private m() {
    }

    @Override // kotlinx.coroutines.i0
    public i0 limitedParallelism(int parallelism) {
        kotlinx.coroutines.internal.n.a(parallelism);
        if (parallelism >= l.f20443d) {
            return this;
        }
        return super.limitedParallelism(parallelism);
    }
}
