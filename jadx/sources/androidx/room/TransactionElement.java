package androidx.room;

import androidx.annotation.RestrictTo;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlinx.coroutines.u1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\fR\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00000\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Landroidx/room/TransactionElement;", "Lv8/j$b;", "Lkotlinx/coroutines/u1;", "transactionThreadControlJob", "Lv8/g;", "transactionDispatcher", "<init>", "(Lkotlinx/coroutines/u1;Lv8/g;)V", "Lr8/z;", "acquire", "()V", "release", "Lkotlinx/coroutines/u1;", "Lv8/g;", "getTransactionDispatcher$room_ktx_release", "()Lv8/g;", "Ljava/util/concurrent/atomic/AtomicInteger;", "referenceCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "Lv8/j$c;", "getKey", "()Lv8/j$c;", "key", "Key", "room-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class TransactionElement implements v8.j.b {

    /* JADX INFO: renamed from: Key, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AtomicInteger referenceCount;
    private final v8.g transactionDispatcher;
    private final u1 transactionThreadControlJob;

    /* JADX INFO: renamed from: androidx.room.TransactionElement$Key, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/room/TransactionElement$Key;", "Lv8/j$c;", "Landroidx/room/TransactionElement;", "<init>", "()V", "room-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion implements v8.j.c<TransactionElement> {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }
    }

    public TransactionElement(u1 transactionThreadControlJob, v8.g transactionDispatcher) {
        kotlin.jvm.internal.m.f(transactionThreadControlJob, "transactionThreadControlJob");
        kotlin.jvm.internal.m.f(transactionDispatcher, "transactionDispatcher");
        this.transactionThreadControlJob = transactionThreadControlJob;
        this.transactionDispatcher = transactionDispatcher;
        this.referenceCount = new AtomicInteger(0);
    }

    public final void acquire() {
        this.referenceCount.incrementAndGet();
    }

    @Override // v8.j.b
    public v8.j.c<TransactionElement> getKey() {
        return INSTANCE;
    }

    /* JADX INFO: renamed from: getTransactionDispatcher$room_ktx_release, reason: from getter */
    public final v8.g getTransactionDispatcher() {
        return this.transactionDispatcher;
    }

    public final void release() {
        int iDecrementAndGet = this.referenceCount.decrementAndGet();
        if (iDecrementAndGet < 0) {
            throw new IllegalStateException("Transaction was never started or was already released.");
        }
        if (iDecrementAndGet == 0) {
            u1.a.a(this.transactionThreadControlJob, null, 1, null);
        }
    }

    @Override // v8.j
    public <R> R fold(R r10, c9.p<? super R, ? super v8.j.b, ? extends R> pVar) {
        return (R) v8.j.b.a.a(this, r10, pVar);
    }

    @Override // v8.j.b, v8.j
    public <E extends v8.j.b> E get(v8.j.c<E> cVar) {
        return (E) v8.j.b.a.b(this, cVar);
    }

    @Override // v8.j
    public v8.j minusKey(v8.j.c<?> cVar) {
        return v8.j.b.a.c(this, cVar);
    }

    @Override // v8.j
    public v8.j plus(v8.j jVar) {
        return v8.j.b.a.d(this, jVar);
    }
}
