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
@Metadata(d1 = {"\u0000J\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ao\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f0\u000b\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u00002\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\r\u0010\u000e\u001ao\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f0\u000b\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u00002\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\r\u0010\u0011\u001a\u007f\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f0\u000b\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00130\u00122\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u00002\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0007¢\u0006\u0004\b\r\u0010\u0018\u001a\u007f\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f0\u000b\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00130\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u00002\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0007¢\u0006\u0004\b\r\u0010\u0019¨\u0006\u001a"}, d2 = {"", "Key", "Value", "Landroidx/paging/DataSource$Factory;", "Landroidx/paging/PagedList$Config;", "config", "initialLoadKey", "Landroidx/paging/PagedList$BoundaryCallback;", "boundaryCallback", "Ljava/util/concurrent/Executor;", "fetchExecutor", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "toLiveData", "(Landroidx/paging/DataSource$Factory;Landroidx/paging/PagedList$Config;Ljava/lang/Object;Landroidx/paging/PagedList$BoundaryCallback;Ljava/util/concurrent/Executor;)Landroidx/lifecycle/LiveData;", "", "pageSize", "(Landroidx/paging/DataSource$Factory;ILjava/lang/Object;Landroidx/paging/PagedList$BoundaryCallback;Ljava/util/concurrent/Executor;)Landroidx/lifecycle/LiveData;", "Lkotlin/Function0;", "Landroidx/paging/PagingSource;", "Lkotlinx/coroutines/l0;", "coroutineScope", "Lkotlinx/coroutines/i0;", "fetchDispatcher", "(Lc9/a;Landroidx/paging/PagedList$Config;Ljava/lang/Object;Landroidx/paging/PagedList$BoundaryCallback;Lkotlinx/coroutines/l0;Lkotlinx/coroutines/i0;)Landroidx/lifecycle/LiveData;", "(Lc9/a;ILjava/lang/Object;Landroidx/paging/PagedList$BoundaryCallback;Lkotlinx/coroutines/l0;Lkotlinx/coroutines/i0;)Landroidx/lifecycle/LiveData;", "paging-runtime_release"}, k = 2, mv = {1, 4, 1})
public final class LivePagedListKt {
    public static final <Key, Value> LiveData<PagedList<Value>> toLiveData(DataSource.Factory<Key, Value> toLiveData, PagedList.Config config, Key key, PagedList.BoundaryCallback<Value> boundaryCallback, Executor fetchExecutor) {
        m.f(toLiveData, "$this$toLiveData");
        m.f(config, "config");
        m.f(fetchExecutor, "fetchExecutor");
        return new LivePagedListBuilder(toLiveData, config).setInitialLoadKey(key).setBoundaryCallback(boundaryCallback).setFetchExecutor(fetchExecutor).build();
    }

    public static /* synthetic */ LiveData toLiveData$default(DataSource.Factory factory, PagedList.Config config, Object obj, PagedList.BoundaryCallback boundaryCallback, Executor executor, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            obj = null;
        }
        if ((i10 & 4) != 0) {
            boundaryCallback = null;
        }
        if ((i10 & 8) != 0) {
            executor = ArchTaskExecutor.getIOThreadExecutor();
            m.e(executor, "ArchTaskExecutor.getIOThreadExecutor()");
        }
        return toLiveData((DataSource.Factory<Object, Value>) factory, config, obj, boundaryCallback, executor);
    }

    public static /* synthetic */ LiveData toLiveData$default(DataSource.Factory factory, int i10, Object obj, PagedList.BoundaryCallback boundaryCallback, Executor executor, int i11, Object obj2) {
        if ((i11 & 2) != 0) {
            obj = null;
        }
        if ((i11 & 4) != 0) {
            boundaryCallback = null;
        }
        if ((i11 & 8) != 0) {
            executor = ArchTaskExecutor.getIOThreadExecutor();
            m.e(executor, "ArchTaskExecutor.getIOThreadExecutor()");
        }
        return toLiveData((DataSource.Factory<Object, Value>) factory, i10, obj, boundaryCallback, executor);
    }

    public static /* synthetic */ LiveData toLiveData$default(c9.a aVar, PagedList.Config config, Object obj, PagedList.BoundaryCallback boundaryCallback, l0 l0Var, i0 i0Var, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            obj = null;
        }
        if ((i10 & 4) != 0) {
            boundaryCallback = null;
        }
        if ((i10 & 8) != 0) {
            l0Var = n1.f14892a;
        }
        if ((i10 & 16) != 0) {
            Executor iOThreadExecutor = ArchTaskExecutor.getIOThreadExecutor();
            m.e(iOThreadExecutor, "ArchTaskExecutor.getIOThreadExecutor()");
            i0Var = m1.a(iOThreadExecutor);
        }
        return toLiveData((c9.a<? extends PagingSource<Object, Value>>) aVar, config, obj, boundaryCallback, l0Var, i0Var);
    }

    public static final <Key, Value> LiveData<PagedList<Value>> toLiveData(DataSource.Factory<Key, Value> toLiveData, int i10, Key key, PagedList.BoundaryCallback<Value> boundaryCallback, Executor fetchExecutor) {
        m.f(toLiveData, "$this$toLiveData");
        m.f(fetchExecutor, "fetchExecutor");
        return new LivePagedListBuilder(toLiveData, PagedListConfigKt.Config$default(i10, 0, false, 0, 0, 30, null)).setInitialLoadKey(key).setBoundaryCallback(boundaryCallback).setFetchExecutor(fetchExecutor).build();
    }

    public static /* synthetic */ LiveData toLiveData$default(c9.a aVar, int i10, Object obj, PagedList.BoundaryCallback boundaryCallback, l0 l0Var, i0 i0Var, int i11, Object obj2) {
        if ((i11 & 2) != 0) {
            obj = null;
        }
        if ((i11 & 4) != 0) {
            boundaryCallback = null;
        }
        if ((i11 & 8) != 0) {
            l0Var = n1.f14892a;
        }
        if ((i11 & 16) != 0) {
            Executor iOThreadExecutor = ArchTaskExecutor.getIOThreadExecutor();
            m.e(iOThreadExecutor, "ArchTaskExecutor.getIOThreadExecutor()");
            i0Var = m1.a(iOThreadExecutor);
        }
        return toLiveData((c9.a<? extends PagingSource<Object, Value>>) aVar, i10, obj, boundaryCallback, l0Var, i0Var);
    }

    public static final <Key, Value> LiveData<PagedList<Value>> toLiveData(c9.a<? extends PagingSource<Key, Value>> toLiveData, PagedList.Config config, Key key, PagedList.BoundaryCallback<Value> boundaryCallback, l0 coroutineScope, i0 fetchDispatcher) {
        m.f(toLiveData, "$this$toLiveData");
        m.f(config, "config");
        m.f(coroutineScope, "coroutineScope");
        m.f(fetchDispatcher, "fetchDispatcher");
        Executor mainThreadExecutor = ArchTaskExecutor.getMainThreadExecutor();
        m.e(mainThreadExecutor, "ArchTaskExecutor.getMainThreadExecutor()");
        return new LivePagedList(coroutineScope, key, config, boundaryCallback, toLiveData, m1.a(mainThreadExecutor), fetchDispatcher);
    }

    public static final <Key, Value> LiveData<PagedList<Value>> toLiveData(c9.a<? extends PagingSource<Key, Value>> toLiveData, int i10, Key key, PagedList.BoundaryCallback<Value> boundaryCallback, l0 coroutineScope, i0 fetchDispatcher) {
        m.f(toLiveData, "$this$toLiveData");
        m.f(coroutineScope, "coroutineScope");
        m.f(fetchDispatcher, "fetchDispatcher");
        PagedList.Config configBuild = new PagedList.Config.Builder().setPageSize(i10).build();
        Executor mainThreadExecutor = ArchTaskExecutor.getMainThreadExecutor();
        m.e(mainThreadExecutor, "ArchTaskExecutor.getMainThreadExecutor()");
        return new LivePagedList(coroutineScope, key, configBuild, boundaryCallback, toLiveData, m1.a(mainThreadExecutor), fetchDispatcher);
    }
}
