package androidx.paging;

import androidx.p000lifecycle.LiveData;
import c9.p;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.h;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.u1;
import r8.r;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00050\u0004B[\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000b\u0012\u0018\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e0\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J+\u0010\u001c\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0017H\u0014¢\u0006\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00170\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010*R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010+R\u001c\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010,R&\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010&R\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010-R\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010-¨\u0006."}, d2 = {"Landroidx/paging/LivePagedList;", "", "Key", "Value", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "Lkotlinx/coroutines/l0;", "coroutineScope", "initialKey", "Landroidx/paging/PagedList$Config;", "config", "Landroidx/paging/PagedList$BoundaryCallback;", "boundaryCallback", "Lkotlin/Function0;", "Landroidx/paging/PagingSource;", "pagingSourceFactory", "Lkotlinx/coroutines/i0;", "notifyDispatcher", "fetchDispatcher", "<init>", "(Lkotlinx/coroutines/l0;Ljava/lang/Object;Landroidx/paging/PagedList$Config;Landroidx/paging/PagedList$BoundaryCallback;Lc9/a;Lkotlinx/coroutines/i0;Lkotlinx/coroutines/i0;)V", "", "force", "Lr8/z;", "invalidate", "(Z)V", "previous", "next", "onItemUpdate", "(Landroidx/paging/PagedList;Landroidx/paging/PagedList;)V", "onActive", "()V", "currentData", "Landroidx/paging/PagedList;", "Lkotlinx/coroutines/u1;", "currentJob", "Lkotlinx/coroutines/u1;", "callback", "Lc9/a;", "Ljava/lang/Runnable;", "refreshRetryCallback", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/l0;", "Landroidx/paging/PagedList$Config;", "Landroidx/paging/PagedList$BoundaryCallback;", "Lkotlinx/coroutines/i0;", "paging-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class LivePagedList<Key, Value> extends LiveData<PagedList<Value>> {
    private final PagedList.BoundaryCallback<Value> boundaryCallback;
    private final c9.a<z> callback;
    private final PagedList.Config config;
    private final l0 coroutineScope;
    private PagedList<Value> currentData;
    private u1 currentJob;
    private final i0 fetchDispatcher;
    private final i0 notifyDispatcher;
    private final c9.a<PagingSource<Key, Value>> pagingSourceFactory;
    private final Runnable refreshRetryCallback;

    /* JADX INFO: renamed from: androidx.paging.LivePagedList$invalidate$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.paging.LivePagedList$invalidate$1", f = "LivePagedList.kt", l = {79, 86}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Key", "Value", "Lkotlinx/coroutines/l0;", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass1 extends l implements p<l0, v8.f<? super z>, Object> {
        Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: renamed from: androidx.paging.LivePagedList$invalidate$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @f(c = "androidx.paging.LivePagedList$invalidate$1$1", f = "LivePagedList.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Key", "Value", "Lkotlinx/coroutines/l0;", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
        static final class C00161 extends l implements p<l0, v8.f<? super z>, Object> {
            int label;

            C00161(v8.f fVar) {
                super(2, fVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(Object obj, v8.f<?> completion) {
                m.f(completion, "completion");
                return AnonymousClass1.this.new C00161(completion);
            }

            @Override // c9.p
            public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                return ((C00161) create(l0Var, fVar)).invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                b.c();
                if (this.label == 0) {
                    r.b(obj);
                    LivePagedList.this.currentData.setInitialLoadState(LoadType.REFRESH, LoadState.Loading.INSTANCE);
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass1(v8.f fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> completion) {
            m.f(completion, "completion");
            return new AnonymousClass1(completion);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((AnonymousClass1) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0096  */
        /* JADX WARN: Code duplicated, block: B:21:0x00ad  */
        /* JADX WARN: Code duplicated, block: B:23:0x00b1  */
        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            PagingSource pagingSource;
            Object obj2;
            PagingSource.LoadResult loadResult;
            Object objC = b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        Object obj3 = this.L$1;
                        pagingSource = (PagingSource) this.L$0;
                        r.b(obj);
                        obj2 = obj3;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    pagingSource = (PagingSource) this.L$0;
                    r.b(obj);
                }
                loadResult = (PagingSource.LoadResult) obj;
                if (loadResult instanceof PagingSource.LoadResult.Error) {
                    LivePagedList.this.currentData.setInitialLoadState(LoadType.REFRESH, new LoadState.Error(((PagingSource.LoadResult.Error) loadResult).getThrowable()));
                } else if (loadResult instanceof PagingSource.LoadResult.Page) {
                    PagedList pagedListCreate = PagedList.INSTANCE.create(pagingSource, (PagingSource.LoadResult.Page) loadResult, LivePagedList.this.coroutineScope, LivePagedList.this.notifyDispatcher, LivePagedList.this.fetchDispatcher, LivePagedList.this.boundaryCallback, LivePagedList.this.config, obj2);
                    LivePagedList livePagedList = LivePagedList.this;
                    livePagedList.onItemUpdate(livePagedList.currentData, pagedListCreate);
                    LivePagedList.this.currentData = pagedListCreate;
                    LivePagedList.this.postValue(pagedListCreate);
                }
                return z.f17874a;
            }
            r.b(obj);
            LivePagedList.this.currentData.getPagingSource().unregisterInvalidatedCallback(LivePagedList.this.callback);
            PagingSource pagingSource2 = (PagingSource) LivePagedList.this.pagingSourceFactory.invoke();
            pagingSource2.registerInvalidatedCallback(LivePagedList.this.callback);
            i0 i0Var = LivePagedList.this.notifyDispatcher;
            C00161 c00161 = new C00161(null);
            this.L$0 = pagingSource2;
            this.label = 1;
            if (h.g(i0Var, c00161, this) != objC) {
                pagingSource = pagingSource2;
            }
            return objC;
            Object lastKey = LivePagedList.this.currentData.getLastKey();
            PagingSource.LoadParams<Key> refreshLoadParams = PagingSourceKt.toRefreshLoadParams(LivePagedList.this.config, lastKey);
            this.L$0 = pagingSource;
            this.L$1 = lastKey;
            this.label = 2;
            Object objLoad = pagingSource.load(refreshLoadParams, this);
            if (objLoad != objC) {
                obj2 = lastKey;
                obj = objLoad;
                loadResult = (PagingSource.LoadResult) obj;
                if (loadResult instanceof PagingSource.LoadResult.Error) {
                    LivePagedList.this.currentData.setInitialLoadState(LoadType.REFRESH, new LoadState.Error(((PagingSource.LoadResult.Error) loadResult).getThrowable()));
                } else if (loadResult instanceof PagingSource.LoadResult.Page) {
                    PagedList pagedListCreate2 = PagedList.INSTANCE.create(pagingSource, (PagingSource.LoadResult.Page) loadResult, LivePagedList.this.coroutineScope, LivePagedList.this.notifyDispatcher, LivePagedList.this.fetchDispatcher, LivePagedList.this.boundaryCallback, LivePagedList.this.config, obj2);
                    LivePagedList livePagedList2 = LivePagedList.this;
                    livePagedList2.onItemUpdate(livePagedList2.currentData, pagedListCreate2);
                    LivePagedList.this.currentData = pagedListCreate2;
                    LivePagedList.this.postValue(pagedListCreate2);
                }
                return z.f17874a;
            }
            return objC;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onItemUpdate(PagedList<Value> previous, PagedList<Value> next) {
        previous.setRetryCallback(null);
        next.setRetryCallback(this.refreshRetryCallback);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LivePagedList(l0 coroutineScope, Key key, PagedList.Config config, PagedList.BoundaryCallback<Value> boundaryCallback, c9.a<? extends PagingSource<Key, Value>> pagingSourceFactory, i0 notifyDispatcher, i0 fetchDispatcher) {
        super(new InitialPagedList((PagingSource) pagingSourceFactory.invoke(), coroutineScope, notifyDispatcher, fetchDispatcher, config, key));
        m.f(coroutineScope, "coroutineScope");
        m.f(config, "config");
        m.f(pagingSourceFactory, "pagingSourceFactory");
        m.f(notifyDispatcher, "notifyDispatcher");
        m.f(fetchDispatcher, "fetchDispatcher");
        this.coroutineScope = coroutineScope;
        this.config = config;
        this.boundaryCallback = boundaryCallback;
        this.pagingSourceFactory = pagingSourceFactory;
        this.notifyDispatcher = notifyDispatcher;
        this.fetchDispatcher = fetchDispatcher;
        this.callback = new LivePagedList$callback$1(this);
        Runnable runnable = new Runnable() { // from class: androidx.paging.LivePagedList$refreshRetryCallback$1
            @Override // java.lang.Runnable
            public final void run() {
                this.this$0.invalidate(true);
            }
        };
        this.refreshRetryCallback = runnable;
        PagedList<Value> value = getValue();
        m.c(value);
        this.currentData = value;
        value.setRetryCallback(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidate(boolean force) {
        u1 u1Var = this.currentJob;
        if (u1Var == null || force) {
            if (u1Var != null) {
                u1.a.a(u1Var, null, 1, null);
            }
            this.currentJob = j.d(this.coroutineScope, this.fetchDispatcher, null, new AnonymousClass1(null), 2, null);
        }
    }

    @Override // androidx.p000lifecycle.LiveData
    protected void onActive() {
        super.onActive();
        invalidate(false);
    }
}
