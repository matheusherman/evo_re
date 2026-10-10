package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.l0;
import r8.z;
import v8.f;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B)\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u000e\u001a\u00020\rH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Landroidx/paging/MulticastedPagingData;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/l0;", "scope", "Landroidx/paging/PagingData;", "parent", "Landroidx/paging/ActiveFlowTracker;", "tracker", "<init>", "(Lkotlinx/coroutines/l0;Landroidx/paging/PagingData;Landroidx/paging/ActiveFlowTracker;)V", "asPagingData", "()Landroidx/paging/PagingData;", "Lr8/z;", "close", "(Lv8/f;)Ljava/lang/Object;", "Landroidx/paging/CachedPageEventFlow;", "accumulated", "Landroidx/paging/CachedPageEventFlow;", "Lkotlinx/coroutines/l0;", "getScope", "()Lkotlinx/coroutines/l0;", "Landroidx/paging/PagingData;", "getParent", "Landroidx/paging/ActiveFlowTracker;", "getTracker", "()Landroidx/paging/ActiveFlowTracker;", "paging-common"}, k = 1, mv = {1, 4, 1})
final class MulticastedPagingData<T> {
    private final CachedPageEventFlow<T> accumulated;
    private final PagingData<T> parent;
    private final l0 scope;
    private final ActiveFlowTracker tracker;

    public MulticastedPagingData(l0 scope, PagingData<T> parent, ActiveFlowTracker activeFlowTracker) {
        m.f(scope, "scope");
        m.f(parent, "parent");
        this.scope = scope;
        this.parent = parent;
        this.tracker = activeFlowTracker;
        this.accumulated = new CachedPageEventFlow<>(h.B(h.D(parent.getFlow$paging_common(), new MulticastedPagingData$accumulated$1(this, null)), new MulticastedPagingData$accumulated$2(this, null)), scope);
    }

    public final PagingData<T> asPagingData() {
        return new PagingData<>(this.accumulated.getDownstreamFlow(), this.parent.getReceiver());
    }

    public final Object close(f<? super z> fVar) {
        Object objClose = this.accumulated.close(fVar);
        return objClose == b.c() ? objClose : z.f17874a;
    }

    public final PagingData<T> getParent() {
        return this.parent;
    }

    public final l0 getScope() {
        return this.scope;
    }

    public final ActiveFlowTracker getTracker() {
        return this.tracker;
    }

    public /* synthetic */ MulticastedPagingData(l0 l0Var, PagingData pagingData, ActiveFlowTracker activeFlowTracker, int i10, g gVar) {
        this(l0Var, pagingData, (i10 & 4) != 0 ? null : activeFlowTracker);
    }
}
