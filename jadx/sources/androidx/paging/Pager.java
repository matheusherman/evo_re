package androidx.paging;

import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.flow.f;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001BM\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u0000\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0007\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\t¢\u0006\u0004\b\f\u0010\rB7\b\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u0000\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\t¢\u0006\u0004\b\f\u0010\u000eR#\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00100\u000f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/paging/Pager;", "", "Key", "Value", "Landroidx/paging/PagingConfig;", "config", "initialKey", "Landroidx/paging/RemoteMediator;", "remoteMediator", "Lkotlin/Function0;", "Landroidx/paging/PagingSource;", "pagingSourceFactory", "<init>", "(Landroidx/paging/PagingConfig;Ljava/lang/Object;Landroidx/paging/RemoteMediator;Lc9/a;)V", "(Landroidx/paging/PagingConfig;Ljava/lang/Object;Lc9/a;)V", "Lkotlinx/coroutines/flow/f;", "Landroidx/paging/PagingData;", "flow", "Lkotlinx/coroutines/flow/f;", "getFlow", "()Lkotlinx/coroutines/flow/f;", "paging-common"}, k = 1, mv = {1, 4, 1})
public final class Pager<Key, Value> {
    private final f<PagingData<Value>> flow;

    public Pager(PagingConfig pagingConfig, c9.a<? extends PagingSource<Key, Value>> aVar) {
        this(pagingConfig, null, aVar, 2, null);
    }

    @ExperimentalPagingApi
    public Pager(PagingConfig config, Key key, RemoteMediator<Key, Value> remoteMediator, c9.a<? extends PagingSource<Key, Value>> pagingSourceFactory) {
        m.f(config, "config");
        m.f(pagingSourceFactory, "pagingSourceFactory");
        this.flow = new PageFetcher(pagingSourceFactory instanceof SuspendingPagingSourceFactory ? new Pager$flow$1(pagingSourceFactory) : new Pager$flow$2(pagingSourceFactory, null), key, config, remoteMediator).getFlow();
    }

    public final f<PagingData<Value>> getFlow() {
        return this.flow;
    }

    public /* synthetic */ Pager(PagingConfig pagingConfig, Object obj, RemoteMediator remoteMediator, c9.a aVar, int i10, g gVar) {
        this(pagingConfig, (i10 & 2) != 0 ? null : obj, remoteMediator, aVar);
    }

    public /* synthetic */ Pager(PagingConfig pagingConfig, Object obj, c9.a aVar, int i10, g gVar) {
        this(pagingConfig, (i10 & 2) != 0 ? null : obj, aVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Pager(PagingConfig config, Key key, c9.a<? extends PagingSource<Key, Value>> pagingSourceFactory) {
        this(config, key, null, pagingSourceFactory);
        m.f(config, "config");
        m.f(pagingSourceFactory, "pagingSourceFactory");
    }
}
