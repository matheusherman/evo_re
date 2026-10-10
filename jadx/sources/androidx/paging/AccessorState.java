package androidx.paging;

import androidx.view.k;
import c9.l;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.i;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import r8.n;
import r8.p;
import r8.v;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001:\u0002./B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000e¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001b\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e\u0018\u00010\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0015¢\u0006\u0004\b\u001d\u0010\u0005J\u0015\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u0015¢\u0006\u0004\b \u0010\u0005J\u001f\u0010#\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b#\u0010$R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00130%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001c\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R&\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010+0*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u00060"}, d2 = {"Landroidx/paging/AccessorState;", "", "Key", "Value", "<init>", "()V", "Landroidx/paging/LoadType;", "loadType", "Landroidx/paging/LoadState;", "computeLoadTypeState", "(Landroidx/paging/LoadType;)Landroidx/paging/LoadState;", "Landroidx/paging/LoadStates;", "computeLoadStates", "()Landroidx/paging/LoadStates;", "Landroidx/paging/PagingState;", "pagingState", "", "add", "(Landroidx/paging/LoadType;Landroidx/paging/PagingState;)Z", "Landroidx/paging/AccessorState$BlockState;", "state", "Lr8/z;", "setBlockState", "(Landroidx/paging/LoadType;Landroidx/paging/AccessorState$BlockState;)V", "getPendingRefresh", "()Landroidx/paging/PagingState;", "Lr8/p;", "getPendingBoundary", "()Lr8/p;", "clearPendingRequests", "clearPendingRequest", "(Landroidx/paging/LoadType;)V", "clearErrors", "Landroidx/paging/LoadState$Error;", "errorState", "setError", "(Landroidx/paging/LoadType;Landroidx/paging/LoadState$Error;)V", "", "blockStates", "[Landroidx/paging/AccessorState$BlockState;", "errors", "[Landroidx/paging/LoadState$Error;", "Lkotlin/collections/i;", "Landroidx/paging/AccessorState$PendingRequest;", "pendingRequests", "Lkotlin/collections/i;", "BlockState", "PendingRequest", "paging-common"}, k = 1, mv = {1, 4, 1})
final class AccessorState<Key, Value> {
    private final BlockState[] blockStates;
    private final LoadState.Error[] errors;
    private final i<PendingRequest<Key, Value>> pendingRequests;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/paging/AccessorState$BlockState;", "", "(Ljava/lang/String;I)V", "UNBLOCKED", "COMPLETED", "REQUIRES_REFRESH", "paging-common"}, k = 1, mv = {1, 4, 1})
    public enum BlockState {
        UNBLOCKED,
        COMPLETED,
        REQUIRES_REFRESH
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u0002*\b\b\u0003\u0010\u0003*\u00020\u00022\u00020\u0002B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/paging/AccessorState$PendingRequest;", "Key", "", "Value", "loadType", "Landroidx/paging/LoadType;", "pagingState", "Landroidx/paging/PagingState;", "(Landroidx/paging/LoadType;Landroidx/paging/PagingState;)V", "getLoadType", "()Landroidx/paging/LoadType;", "getPagingState", "()Landroidx/paging/PagingState;", "setPagingState", "(Landroidx/paging/PagingState;)V", "paging-common"}, k = 1, mv = {1, 4, 1})
    public static final class PendingRequest<Key, Value> {
        private final LoadType loadType;
        private PagingState<Key, Value> pagingState;

        public PendingRequest(LoadType loadType, PagingState<Key, Value> pagingState) {
            m.f(loadType, "loadType");
            m.f(pagingState, "pagingState");
            this.loadType = loadType;
            this.pagingState = pagingState;
        }

        public final LoadType getLoadType() {
            return this.loadType;
        }

        public final PagingState<Key, Value> getPagingState() {
            return this.pagingState;
        }

        public final void setPagingState(PagingState<Key, Value> pagingState) {
            m.f(pagingState, "<set-?>");
            this.pagingState = pagingState;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.AccessorState$clearPendingRequest$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "Key", "", "Value", "it", "Landroidx/paging/AccessorState$PendingRequest;", "invoke"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass1 extends o implements l<PendingRequest<Key, Value>, Boolean> {
        final /* synthetic */ LoadType $loadType;

        @Override // c9.l
        public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
            return Boolean.valueOf(invoke((PendingRequest) obj));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LoadType loadType) {
            super(1);
            this.$loadType = loadType;
        }

        public final boolean invoke(PendingRequest<Key, Value> it) {
            m.f(it, "it");
            return it.getLoadType() == this.$loadType;
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BlockState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[BlockState.COMPLETED.ordinal()] = 1;
            iArr[BlockState.REQUIRES_REFRESH.ordinal()] = 2;
            iArr[BlockState.UNBLOCKED.ordinal()] = 3;
        }
    }

    private final LoadState computeLoadTypeState(LoadType loadType) {
        i<PendingRequest<Key, Value>> iVar = this.pendingRequests;
        if (!k.a(iVar) || !iVar.isEmpty()) {
            Iterator<PendingRequest<Key, Value>> it = iVar.iterator();
            while (it.hasNext()) {
                if (it.next().getLoadType() == loadType) {
                    return LoadState.Loading.INSTANCE;
                }
            }
        }
        LoadState.Error error = this.errors[loadType.ordinal()];
        if (error != null) {
            return error;
        }
        int i10 = WhenMappings.$EnumSwitchMapping$0[this.blockStates[loadType.ordinal()].ordinal()];
        if (i10 == 1) {
            return LoadState.NotLoading.INSTANCE.getComplete$paging_common();
        }
        if (i10 == 2) {
            return LoadState.NotLoading.INSTANCE.getIncomplete$paging_common();
        }
        if (i10 == 3) {
            return LoadState.NotLoading.INSTANCE.getIncomplete$paging_common();
        }
        throw new n();
    }

    public final boolean add(LoadType loadType, PagingState<Key, Value> pagingState) {
        PendingRequest<Key, Value> next;
        m.f(loadType, "loadType");
        m.f(pagingState, "pagingState");
        Iterator<PendingRequest<Key, Value>> it = this.pendingRequests.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (next.getLoadType() != loadType);
        PendingRequest<Key, Value> pendingRequest = next;
        if (pendingRequest != null) {
            pendingRequest.setPagingState(pagingState);
            return false;
        }
        if (this.blockStates[loadType.ordinal()] != BlockState.UNBLOCKED && loadType != LoadType.REFRESH) {
            return false;
        }
        LoadType loadType2 = LoadType.REFRESH;
        if (loadType == loadType2) {
            setError(loadType2, null);
        }
        if (this.errors[loadType.ordinal()] == null) {
            return this.pendingRequests.add(new PendingRequest<>(loadType, pagingState));
        }
        return false;
    }

    public final void clearErrors() {
        int length = this.errors.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.errors[i10] = null;
        }
    }

    public final void clearPendingRequest(LoadType loadType) {
        m.f(loadType, "loadType");
        r.I(this.pendingRequests, new AnonymousClass1(loadType));
    }

    public final void clearPendingRequests() {
        this.pendingRequests.clear();
    }

    public final LoadStates computeLoadStates() {
        return new LoadStates(computeLoadTypeState(LoadType.REFRESH), computeLoadTypeState(LoadType.PREPEND), computeLoadTypeState(LoadType.APPEND));
    }

    public final p<LoadType, PagingState<Key, Value>> getPendingBoundary() {
        PendingRequest<Key, Value> next;
        Iterator<PendingRequest<Key, Value>> it = this.pendingRequests.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (next.getLoadType() == LoadType.REFRESH);
        PendingRequest<Key, Value> pendingRequest = next;
        if (pendingRequest != null) {
            return v.a(pendingRequest.getLoadType(), pendingRequest.getPagingState());
        }
        return null;
    }

    public final PagingState<Key, Value> getPendingRefresh() {
        PendingRequest<Key, Value> next;
        Iterator<PendingRequest<Key, Value>> it = this.pendingRequests.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (next.getLoadType() != LoadType.REFRESH);
        PendingRequest<Key, Value> pendingRequest = next;
        if (pendingRequest != null) {
            return pendingRequest.getPagingState();
        }
        return null;
    }

    public final void setBlockState(LoadType loadType, BlockState state) {
        m.f(loadType, "loadType");
        m.f(state, "state");
        this.blockStates[loadType.ordinal()] = state;
    }

    public final void setError(LoadType loadType, LoadState.Error errorState) {
        m.f(loadType, "loadType");
        this.errors[loadType.ordinal()] = errorState;
    }

    public AccessorState() {
        int length = LoadType.values().length;
        BlockState[] blockStateArr = new BlockState[length];
        for (int i10 = 0; i10 < length; i10++) {
            blockStateArr[i10] = BlockState.UNBLOCKED;
        }
        this.blockStates = blockStateArr;
        int length2 = LoadType.values().length;
        LoadState.Error[] errorArr = new LoadState.Error[length2];
        for (int i11 = 0; i11 < length2; i11++) {
            errorArr[i11] = null;
        }
        this.errors = errorArr;
        this.pendingRequests = new i<>();
    }
}
