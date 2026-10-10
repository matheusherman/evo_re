package androidx.paging;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.p000lifecycle.LiveData;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m1;
import kotlinx.coroutines.n1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001B%\b\u0017\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB%\b\u0017\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\b\u0010\fB+\b\u0017\u0012\u0018\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e0\r\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\u0010B+\b\u0017\u0012\u0018\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e0\r\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\b\u0010\u0011J!\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\b\u0010\u0016\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\"0!¢\u0006\u0004\b#\u0010$R(\u0010\u000f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e\u0018\u00010\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010%R\"\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010&R\u001a\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\u0007\u0010'\u0012\u0004\b(\u0010)R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010*R\u0018\u0010+\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R$\u0010\u001a\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u001a\u0010-\u0012\u0004\b.\u0010)R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101¨\u00062"}, d2 = {"Landroidx/paging/LivePagedListBuilder;", "", "Key", "Value", "Landroidx/paging/DataSource$Factory;", "dataSourceFactory", "Landroidx/paging/PagedList$Config;", "config", "<init>", "(Landroidx/paging/DataSource$Factory;Landroidx/paging/PagedList$Config;)V", "", "pageSize", "(Landroidx/paging/DataSource$Factory;I)V", "Lkotlin/Function0;", "Landroidx/paging/PagingSource;", "pagingSourceFactory", "(Lc9/a;Landroidx/paging/PagedList$Config;)V", "(Lc9/a;I)V", "Lkotlinx/coroutines/l0;", "coroutineScope", "setCoroutineScope", "(Lkotlinx/coroutines/l0;)Landroidx/paging/LivePagedListBuilder;", "key", "setInitialLoadKey", "(Ljava/lang/Object;)Landroidx/paging/LivePagedListBuilder;", "Landroidx/paging/PagedList$BoundaryCallback;", "boundaryCallback", "setBoundaryCallback", "(Landroidx/paging/PagedList$BoundaryCallback;)Landroidx/paging/LivePagedListBuilder;", "Ljava/util/concurrent/Executor;", "fetchExecutor", "setFetchExecutor", "(Ljava/util/concurrent/Executor;)Landroidx/paging/LivePagedListBuilder;", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "build", "()Landroidx/lifecycle/LiveData;", "Lc9/a;", "Landroidx/paging/DataSource$Factory;", "Landroidx/paging/PagedList$Config;", "getConfig$annotations", "()V", "Lkotlinx/coroutines/l0;", "initialLoadKey", "Ljava/lang/Object;", "Landroidx/paging/PagedList$BoundaryCallback;", "getBoundaryCallback$annotations", "Lkotlinx/coroutines/i0;", "fetchDispatcher", "Lkotlinx/coroutines/i0;", "paging-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class LivePagedListBuilder<Key, Value> {
    private PagedList.BoundaryCallback<Value> boundaryCallback;
    private final PagedList.Config config;
    private l0 coroutineScope;
    private final DataSource.Factory<Key, Value> dataSourceFactory;
    private i0 fetchDispatcher;
    private Key initialLoadKey;
    private final c9.a<PagingSource<Key, Value>> pagingSourceFactory;

    public LivePagedListBuilder(DataSource.Factory<Key, Value> dataSourceFactory, PagedList.Config config) {
        m.f(dataSourceFactory, "dataSourceFactory");
        m.f(config, "config");
        this.coroutineScope = n1.f14892a;
        Executor iOThreadExecutor = ArchTaskExecutor.getIOThreadExecutor();
        m.e(iOThreadExecutor, "ArchTaskExecutor.getIOThreadExecutor()");
        this.fetchDispatcher = m1.a(iOThreadExecutor);
        this.pagingSourceFactory = null;
        this.dataSourceFactory = dataSourceFactory;
        this.config = config;
    }

    public final LiveData<PagedList<Value>> build() {
        c9.a<PagingSource<Key, Value>> aVarAsPagingSourceFactory = this.pagingSourceFactory;
        if (aVarAsPagingSourceFactory == null) {
            DataSource.Factory<Key, Value> factory = this.dataSourceFactory;
            aVarAsPagingSourceFactory = factory != null ? factory.asPagingSourceFactory(this.fetchDispatcher) : null;
        }
        c9.a<PagingSource<Key, Value>> aVar = aVarAsPagingSourceFactory;
        if (!(aVar != null)) {
            throw new IllegalStateException("LivePagedList cannot be built without a PagingSourceFactory or DataSource.Factory");
        }
        l0 l0Var = this.coroutineScope;
        Key key = this.initialLoadKey;
        PagedList.Config config = this.config;
        PagedList.BoundaryCallback<Value> boundaryCallback = this.boundaryCallback;
        Executor mainThreadExecutor = ArchTaskExecutor.getMainThreadExecutor();
        m.e(mainThreadExecutor, "ArchTaskExecutor.getMainThreadExecutor()");
        return new LivePagedList(l0Var, key, config, boundaryCallback, aVar, m1.a(mainThreadExecutor), this.fetchDispatcher);
    }

    public final LivePagedListBuilder<Key, Value> setBoundaryCallback(PagedList.BoundaryCallback<Value> boundaryCallback) {
        this.boundaryCallback = boundaryCallback;
        return this;
    }

    public final LivePagedListBuilder<Key, Value> setCoroutineScope(l0 coroutineScope) {
        m.f(coroutineScope, "coroutineScope");
        this.coroutineScope = coroutineScope;
        return this;
    }

    public final LivePagedListBuilder<Key, Value> setFetchExecutor(Executor fetchExecutor) {
        m.f(fetchExecutor, "fetchExecutor");
        this.fetchDispatcher = m1.a(fetchExecutor);
        return this;
    }

    public final LivePagedListBuilder<Key, Value> setInitialLoadKey(Key key) {
        this.initialLoadKey = key;
        return this;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LivePagedListBuilder(DataSource.Factory<Key, Value> dataSourceFactory, int i10) {
        this(dataSourceFactory, new PagedList.Config.Builder().setPageSize(i10).build());
        m.f(dataSourceFactory, "dataSourceFactory");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LivePagedListBuilder(c9.a<? extends PagingSource<Key, Value>> pagingSourceFactory, PagedList.Config config) {
        m.f(pagingSourceFactory, "pagingSourceFactory");
        m.f(config, "config");
        this.coroutineScope = n1.f14892a;
        Executor iOThreadExecutor = ArchTaskExecutor.getIOThreadExecutor();
        m.e(iOThreadExecutor, "ArchTaskExecutor.getIOThreadExecutor()");
        this.fetchDispatcher = m1.a(iOThreadExecutor);
        this.pagingSourceFactory = pagingSourceFactory;
        this.dataSourceFactory = null;
        this.config = config;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LivePagedListBuilder(c9.a<? extends PagingSource<Key, Value>> pagingSourceFactory, int i10) {
        this(pagingSourceFactory, new PagedList.Config.Builder().setPageSize(i10).build());
        m.f(pagingSourceFactory, "pagingSourceFactory");
    }

    private static /* synthetic */ void getBoundaryCallback$annotations() {
    }

    private static /* synthetic */ void getConfig$annotations() {
    }
}
