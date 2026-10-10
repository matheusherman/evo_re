package androidx.paging;

import c9.l;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.flow.d0;
import kotlinx.coroutines.flow.f0;
import kotlinx.coroutines.flow.v;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J3\u0010\n\u001a\u00028\u0002\"\u0004\b\u0002\u0010\u00062\u001e\u0010\t\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u00028\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Landroidx/paging/AccessorStateHolder;", "", "Key", "Value", "<init>", "()V", "R", "Lkotlin/Function1;", "Landroidx/paging/AccessorState;", "block", "use", "(Lc9/l;)Ljava/lang/Object;", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/flow/v;", "Landroidx/paging/LoadStates;", "_loadStates", "Lkotlinx/coroutines/flow/v;", "internalState", "Landroidx/paging/AccessorState;", "Lkotlinx/coroutines/flow/d0;", "getLoadStates", "()Lkotlinx/coroutines/flow/d0;", "loadStates", "paging-common"}, k = 1, mv = {1, 4, 1})
final class AccessorStateHolder<Key, Value> {
    private final ReentrantLock lock = new ReentrantLock();
    private final v<LoadStates> _loadStates = f0.a(LoadStates.INSTANCE.getIDLE());
    private final AccessorState<Key, Value> internalState = new AccessorState<>();

    public final d0<LoadStates> getLoadStates() {
        return this._loadStates;
    }

    public final <R> R use(l<? super AccessorState<Key, Value>, ? extends R> block) {
        m.f(block, "block");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            R rInvoke = block.invoke(this.internalState);
            this._loadStates.setValue(this.internalState.computeLoadStates());
            return rInvoke;
        } finally {
            reentrantLock.unlock();
        }
    }
}
