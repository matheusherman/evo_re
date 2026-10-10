package androidx.paging;

import c9.l;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* JADX INFO: Add missing generic type declarations: [Value, Key] */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Landroidx/paging/PagingState;", "Key", "Value", "", "it", "Landroidx/paging/AccessorState;", "invoke"}, k = 3, mv = {1, 4, 1})
final class RemoteMediatorAccessImpl$launchRefresh$1$1$pendingPagingState$1<Key, Value> extends o implements l<AccessorState<Key, Value>, PagingState<Key, Value>> {
    public static final RemoteMediatorAccessImpl$launchRefresh$1$1$pendingPagingState$1 INSTANCE = new RemoteMediatorAccessImpl$launchRefresh$1$1$pendingPagingState$1();

    RemoteMediatorAccessImpl$launchRefresh$1$1$pendingPagingState$1() {
        super(1);
    }

    @Override // c9.l
    public final PagingState<Key, Value> invoke(AccessorState<Key, Value> it) {
        m.f(it, "it");
        return it.getPendingRefresh();
    }
}
