package androidx.paging;

import c9.l;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import r8.z;

/* JADX INFO: Add missing generic type declarations: [Value, Key] */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Key", "Value", "Landroidx/paging/AccessorState;", "it", "Lr8/z;", "invoke", "(Landroidx/paging/AccessorState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final class RemoteMediatorAccessImpl$launchRefresh$1$1$1$1<Key, Value> extends o implements l<AccessorState<Key, Value>, z> {
    final /* synthetic */ RemoteMediator.MediatorResult $loadResult;

    @Override // c9.l
    public /* bridge */ /* synthetic */ z invoke(Object obj) {
        invoke((AccessorState) obj);
        return z.f17874a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RemoteMediatorAccessImpl$launchRefresh$1$1$1$1(RemoteMediator.MediatorResult mediatorResult) {
        super(1);
        this.$loadResult = mediatorResult;
    }

    public final void invoke(AccessorState<Key, Value> it) {
        m.f(it, "it");
        it.clearPendingRequests();
        AccessorState.BlockState blockState = ((RemoteMediator.MediatorResult.Success) this.$loadResult).getEndOfPaginationReached() ? AccessorState.BlockState.COMPLETED : AccessorState.BlockState.UNBLOCKED;
        if (((RemoteMediator.MediatorResult.Success) this.$loadResult).getEndOfPaginationReached()) {
            it.setBlockState(LoadType.REFRESH, AccessorState.BlockState.COMPLETED);
        }
        LoadType loadType = LoadType.APPEND;
        it.setBlockState(loadType, blockState);
        LoadType loadType2 = LoadType.PREPEND;
        it.setBlockState(loadType2, blockState);
        it.setError(loadType, null);
        it.setError(loadType2, null);
    }
}
