package androidx.paging;

import c9.p;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlinx.coroutines.h;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.l0;
import r8.n;
import r8.r;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u0000 $*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0001$B#\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00142\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0019\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u001bR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001cR&\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Landroidx/paging/LegacyPagingSource;", "", "Key", "Value", "Landroidx/paging/PagingSource;", "Lkotlinx/coroutines/i0;", "fetchDispatcher", "Landroidx/paging/DataSource;", "dataSource", "<init>", "(Lkotlinx/coroutines/i0;Landroidx/paging/DataSource;)V", "Landroidx/paging/PagingSource$LoadParams;", "params", "", "guessPageSize", "(Landroidx/paging/PagingSource$LoadParams;)I", "pageSize", "Lr8/z;", "setPageSize", "(I)V", "Landroidx/paging/PagingSource$LoadResult;", "load", "(Landroidx/paging/PagingSource$LoadParams;Lv8/f;)Ljava/lang/Object;", "Landroidx/paging/PagingState;", "state", "getRefreshKey", "(Landroidx/paging/PagingState;)Ljava/lang/Object;", "I", "Lkotlinx/coroutines/i0;", "Landroidx/paging/DataSource;", "getDataSource$paging_common", "()Landroidx/paging/DataSource;", "", "getJumpingSupported", "()Z", "jumpingSupported", "Companion", "paging-common"}, k = 1, mv = {1, 4, 1})
public final class LegacyPagingSource<Key, Value> extends PagingSource<Key, Value> {
    public static final int PAGE_SIZE_NOT_SET = Integer.MIN_VALUE;
    private final DataSource<Key, Value> dataSource;
    private final i0 fetchDispatcher;
    private int pageSize;

    /* JADX INFO: renamed from: androidx.paging.LegacyPagingSource$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Key", "Value", "Lr8/z;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final /* synthetic */ class AnonymousClass1 extends k implements c9.a<z> {
        @Override // c9.a
        public /* bridge */ /* synthetic */ z invoke() {
            invoke2();
            return z.f17874a;
        }

        AnonymousClass1(LegacyPagingSource legacyPagingSource) {
            super(0, legacyPagingSource, LegacyPagingSource.class, "invalidate", "invalidate()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((LegacyPagingSource) this.receiver).invalidate();
        }
    }

    /* JADX INFO: renamed from: androidx.paging.LegacyPagingSource$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Key", "Value", "Lr8/z;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass2 extends o implements c9.a<z> {

        /* JADX INFO: renamed from: androidx.paging.LegacyPagingSource$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Key", "Value", "Lr8/z;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
        static final /* synthetic */ class AnonymousClass1 extends k implements c9.a<z> {
            @Override // c9.a
            public /* bridge */ /* synthetic */ z invoke() {
                invoke2();
                return z.f17874a;
            }

            AnonymousClass1(LegacyPagingSource legacyPagingSource) {
                super(0, legacyPagingSource, LegacyPagingSource.class, "invalidate", "invalidate()V", 0);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ((LegacyPagingSource) this.receiver).invalidate();
            }
        }

        @Override // c9.a
        public /* bridge */ /* synthetic */ z invoke() {
            invoke2();
            return z.f17874a;
        }

        AnonymousClass2() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            LegacyPagingSource.this.getDataSource$paging_common().removeInvalidatedCallback(new LegacyPagingSource$sam$androidx_paging_DataSource_InvalidatedCallback$0(new AnonymousClass1(LegacyPagingSource.this)));
            LegacyPagingSource.this.getDataSource$paging_common().invalidate();
        }
    }

    /* JADX INFO: renamed from: androidx.paging.LegacyPagingSource$load$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.paging.LegacyPagingSource$load$2", f = "LegacyPagingSource.kt", l = {108}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Key", "Value", "Lkotlinx/coroutines/l0;", "Landroidx/paging/PagingSource$LoadResult$Page;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class C05402 extends l implements p<l0, v8.f<? super PagingSource.LoadResult.Page<Key, Value>>, Object> {
        final /* synthetic */ b0 $dataSourceParams;
        final /* synthetic */ PagingSource.LoadParams $params;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05402(b0 b0Var, PagingSource.LoadParams loadParams, v8.f fVar) {
            super(2, fVar);
            this.$dataSourceParams = b0Var;
            this.$params = loadParams;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> completion) {
            m.f(completion, "completion");
            return new C05402(this.$dataSourceParams, this.$params, completion);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, Object obj) {
            return ((C05402) create(l0Var, (v8.f) obj)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object prevKey;
            Object objC = b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r.b(obj);
                DataSource<Key, Value> dataSource$paging_common = LegacyPagingSource.this.getDataSource$paging_common();
                DataSource.Params<Key> params = (DataSource.Params) this.$dataSourceParams.element;
                this.label = 1;
                obj = dataSource$paging_common.load$paging_common(params, this);
                if (obj == objC) {
                    return objC;
                }
            }
            DataSource.BaseResult baseResult = (DataSource.BaseResult) obj;
            List<Value> list = baseResult.data;
            Object nextKey = null;
            if (list.isEmpty() && (this.$params instanceof PagingSource.LoadParams.Prepend)) {
                prevKey = null;
            } else {
                prevKey = baseResult.getPrevKey();
            }
            if (!baseResult.data.isEmpty() || !(this.$params instanceof PagingSource.LoadParams.Append)) {
                nextKey = baseResult.getNextKey();
            }
            return new PagingSource.LoadResult.Page(list, prevKey, nextKey, baseResult.getItemsBefore(), baseResult.getItemsAfter());
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DataSource.KeyType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[DataSource.KeyType.POSITIONAL.ordinal()] = 1;
            iArr[DataSource.KeyType.PAGE_KEYED.ordinal()] = 2;
            iArr[DataSource.KeyType.ITEM_KEYED.ordinal()] = 3;
        }
    }

    public LegacyPagingSource(i0 fetchDispatcher, DataSource<Key, Value> dataSource) {
        m.f(fetchDispatcher, "fetchDispatcher");
        m.f(dataSource, "dataSource");
        this.fetchDispatcher = fetchDispatcher;
        this.dataSource = dataSource;
        this.pageSize = Integer.MIN_VALUE;
        dataSource.addInvalidatedCallback(new LegacyPagingSource$sam$androidx_paging_DataSource_InvalidatedCallback$0(new AnonymousClass1(this)));
        registerInvalidatedCallback(new AnonymousClass2());
        if (getInvalid() || !dataSource.isInvalid()) {
            return;
        }
        invalidate();
    }

    private final int guessPageSize(PagingSource.LoadParams<Key> params) {
        return ((params instanceof PagingSource.LoadParams.Refresh) && params.getLoadSize() % 3 == 0) ? params.getLoadSize() / 3 : params.getLoadSize();
    }

    public final DataSource<Key, Value> getDataSource$paging_common() {
        return this.dataSource;
    }

    @Override // androidx.paging.PagingSource
    public boolean getJumpingSupported() {
        return this.dataSource.getType() == DataSource.KeyType.POSITIONAL;
    }

    @Override // androidx.paging.PagingSource
    public Key getRefreshKey(PagingState<Key, Value> state) {
        Key prevKey;
        Value valueClosestItemToPosition;
        m.f(state, "state");
        int i10 = WhenMappings.$EnumSwitchMapping$0[this.dataSource.getType().ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                return null;
            }
            if (i10 != 3) {
                throw new n();
            }
            Integer anchorPosition = state.getAnchorPosition();
            if (anchorPosition == null || (valueClosestItemToPosition = state.closestItemToPosition(anchorPosition.intValue())) == null) {
                return null;
            }
            return this.dataSource.getKeyInternal$paging_common(valueClosestItemToPosition);
        }
        Integer anchorPosition2 = state.getAnchorPosition();
        if (anchorPosition2 == null) {
            return null;
        }
        int iIntValue = anchorPosition2.intValue();
        int size = iIntValue - ((PagingState) state).leadingPlaceholderCount;
        for (int i11 = 0; i11 < kotlin.collections.r.n(state.getPages()) && size > kotlin.collections.r.n(state.getPages().get(i11).getData()); i11++) {
            size -= state.getPages().get(i11).getData().size();
        }
        PagingSource.LoadResult.Page<Key, Value> pageClosestPageToPosition = state.closestPageToPosition(iIntValue);
        if (pageClosestPageToPosition == null || (prevKey = pageClosestPageToPosition.getPrevKey()) == null) {
            prevKey = (Key) 0;
        }
        return (Key) Integer.valueOf(prevKey.intValue() + size);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, androidx.paging.DataSource$Params] */
    @Override // androidx.paging.PagingSource
    public Object load(PagingSource.LoadParams<Key> loadParams, v8.f<? super PagingSource.LoadResult<Key, Value>> fVar) {
        LoadType loadType;
        if (loadParams instanceof PagingSource.LoadParams.Refresh) {
            loadType = LoadType.REFRESH;
        } else if (loadParams instanceof PagingSource.LoadParams.Append) {
            loadType = LoadType.APPEND;
        } else {
            if (!(loadParams instanceof PagingSource.LoadParams.Prepend)) {
                throw new n();
            }
            loadType = LoadType.PREPEND;
        }
        LoadType loadType2 = loadType;
        if (this.pageSize == Integer.MIN_VALUE) {
            System.out.println((Object) "WARNING: pageSize on the LegacyPagingSource is not set.\nWhen using legacy DataSource / DataSourceFactory with Paging3, page size\nshould've been set by the paging library but it is not set yet.\n\nIf you are seeing this message in tests where you are testing DataSource\nin isolation (without a Pager), it is expected and page size will be estimated\nbased on parameters.\n\nIf you are seeing this message despite using a Pager, please file a bug:\nhttps://issuetracker.google.com/issues/new?component=413106");
            this.pageSize = guessPageSize(loadParams);
        }
        b0 b0Var = new b0();
        b0Var.element = new DataSource.Params(loadType2, loadParams.getKey(), loadParams.getLoadSize(), loadParams.getPlaceholdersEnabled(), this.pageSize);
        return h.g(this.fetchDispatcher, new C05402(b0Var, loadParams, null), fVar);
    }

    public final void setPageSize(int pageSize) {
        int i10 = this.pageSize;
        if (i10 == Integer.MIN_VALUE || pageSize == i10) {
            this.pageSize = pageSize;
            return;
        }
        throw new IllegalStateException(("Page size is already set to " + this.pageSize + '.').toString());
    }
}
