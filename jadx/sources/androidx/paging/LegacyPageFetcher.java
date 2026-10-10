package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import c9.p;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import r8.r;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001:\u0002CDBW\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\r\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J+\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010 \u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0017H\u0002¢\u0006\u0004\b$\u0010#J\r\u0010%\u001a\u00020\u0017¢\u0006\u0004\b%\u0010#J\r\u0010&\u001a\u00020\u0017¢\u0006\u0004\b&\u0010#J\r\u0010'\u001a\u00020\u0017¢\u0006\u0004\b'\u0010#J\r\u0010(\u001a\u00020\u0017¢\u0006\u0004\b(\u0010#R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R(\u0010-\u001a\u00020,8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0004\b-\u0010.\u0012\u0004\b3\u0010#\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00104R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00105\u001a\u0004\b6\u00107R#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u00108\u001a\u0004\b9\u0010:R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010;R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010;R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010<\u001a\u0004\b=\u0010>R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010?R\u0011\u0010A\u001a\u00020@8F¢\u0006\u0006\u001a\u0004\bA\u0010B¨\u0006E"}, d2 = {"Landroidx/paging/LegacyPageFetcher;", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlinx/coroutines/l0;", "pagedListScope", "Landroidx/paging/PagedList$Config;", "config", "Landroidx/paging/PagingSource;", "source", "Lkotlinx/coroutines/i0;", "notifyDispatcher", "fetchDispatcher", "Landroidx/paging/LegacyPageFetcher$PageConsumer;", "pageConsumer", "Landroidx/paging/LegacyPageFetcher$KeyProvider;", "keyProvider", "<init>", "(Lkotlinx/coroutines/l0;Landroidx/paging/PagedList$Config;Landroidx/paging/PagingSource;Lkotlinx/coroutines/i0;Lkotlinx/coroutines/i0;Landroidx/paging/LegacyPageFetcher$PageConsumer;Landroidx/paging/LegacyPageFetcher$KeyProvider;)V", "Landroidx/paging/LoadType;", IjkMediaMeta.IJKM_KEY_TYPE, "Landroidx/paging/PagingSource$LoadParams;", "params", "Lr8/z;", "scheduleLoad", "(Landroidx/paging/LoadType;Landroidx/paging/PagingSource$LoadParams;)V", "Landroidx/paging/PagingSource$LoadResult$Page;", "value", "onLoadSuccess", "(Landroidx/paging/LoadType;Landroidx/paging/PagingSource$LoadResult$Page;)V", "", "throwable", "onLoadError", "(Landroidx/paging/LoadType;Ljava/lang/Throwable;)V", "schedulePrepend", "()V", "scheduleAppend", "trySchedulePrepend", "tryScheduleAppend", "retry", "detach", "Ljava/util/concurrent/atomic/AtomicBoolean;", "detached", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Landroidx/paging/PagedList$LoadStateManager;", "loadStateManager", "Landroidx/paging/PagedList$LoadStateManager;", "getLoadStateManager", "()Landroidx/paging/PagedList$LoadStateManager;", "setLoadStateManager", "(Landroidx/paging/PagedList$LoadStateManager;)V", "getLoadStateManager$annotations", "Lkotlinx/coroutines/l0;", "Landroidx/paging/PagedList$Config;", "getConfig", "()Landroidx/paging/PagedList$Config;", "Landroidx/paging/PagingSource;", "getSource", "()Landroidx/paging/PagingSource;", "Lkotlinx/coroutines/i0;", "Landroidx/paging/LegacyPageFetcher$PageConsumer;", "getPageConsumer", "()Landroidx/paging/LegacyPageFetcher$PageConsumer;", "Landroidx/paging/LegacyPageFetcher$KeyProvider;", "", "isDetached", "()Z", "KeyProvider", "PageConsumer", "paging-common"}, k = 1, mv = {1, 4, 1})
public final class LegacyPageFetcher<K, V> {
    private final PagedList.Config config;
    private final AtomicBoolean detached;
    private final i0 fetchDispatcher;
    private final KeyProvider<K> keyProvider;
    private PagedList.LoadStateManager loadStateManager;
    private final i0 notifyDispatcher;
    private final PageConsumer<V> pageConsumer;
    private final l0 pagedListScope;
    private final PagingSource<K, V> source;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b`\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u00022\u00020\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00018\u0002X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00018\u0002X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"Landroidx/paging/LegacyPageFetcher$KeyProvider;", "K", "", "nextKey", "getNextKey", "()Ljava/lang/Object;", "prevKey", "getPrevKey", "paging-common"}, k = 1, mv = {1, 4, 1})
    public interface KeyProvider<K> {
        K getNextKey();

        K getPrevKey();
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u00012\u00020\u0001J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0010\u0010\u0006\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/paging/LegacyPageFetcher$PageConsumer;", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/paging/LoadType;", IjkMediaMeta.IJKM_KEY_TYPE, "Landroidx/paging/PagingSource$LoadResult$Page;", "page", "", "onPageResult", "(Landroidx/paging/LoadType;Landroidx/paging/PagingSource$LoadResult$Page;)Z", "Landroidx/paging/LoadState;", "state", "Lr8/z;", "onStateChanged", "(Landroidx/paging/LoadType;Landroidx/paging/LoadState;)V", "paging-common"}, k = 1, mv = {1, 4, 1})
    public interface PageConsumer<V> {
        boolean onPageResult(LoadType type, PagingSource.LoadResult.Page<?, V> page);

        void onStateChanged(LoadType type, LoadState state);
    }

    /* JADX INFO: renamed from: androidx.paging.LegacyPageFetcher$scheduleLoad$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.paging.LegacyPageFetcher$scheduleLoad$1", f = "LegacyPageFetcher.kt", l = {53}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlinx/coroutines/l0;", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass1 extends l implements p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ PagingSource.LoadParams $params;
        final /* synthetic */ LoadType $type;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.paging.LegacyPageFetcher$scheduleLoad$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @f(c = "androidx.paging.LegacyPageFetcher$scheduleLoad$1$1", f = "LegacyPageFetcher.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlinx/coroutines/l0;", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
        static final class C00151 extends l implements p<l0, v8.f<? super z>, Object> {
            final /* synthetic */ PagingSource.LoadResult $value;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00151(PagingSource.LoadResult loadResult, v8.f fVar) {
                super(2, fVar);
                this.$value = loadResult;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(Object obj, v8.f<?> completion) {
                m.f(completion, "completion");
                return AnonymousClass1.this.new C00151(this.$value, completion);
            }

            @Override // c9.p
            public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                return ((C00151) create(l0Var, fVar)).invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                b.c();
                if (this.label == 0) {
                    r.b(obj);
                    PagingSource.LoadResult loadResult = this.$value;
                    if (loadResult instanceof PagingSource.LoadResult.Page) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        LegacyPageFetcher.this.onLoadSuccess(anonymousClass1.$type, (PagingSource.LoadResult.Page) loadResult);
                    } else if (loadResult instanceof PagingSource.LoadResult.Error) {
                        AnonymousClass1 anonymousClass2 = AnonymousClass1.this;
                        LegacyPageFetcher.this.onLoadError(anonymousClass2.$type, ((PagingSource.LoadResult.Error) loadResult).getThrowable());
                    }
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PagingSource.LoadParams loadParams, LoadType loadType, v8.f fVar) {
            super(2, fVar);
            this.$params = loadParams;
            this.$type = loadType;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> completion) {
            m.f(completion, "completion");
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$params, this.$type, completion);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((AnonymousClass1) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            l0 l0Var;
            Object objC = b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    l0Var = (l0) this.L$0;
                    r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r.b(obj);
                l0 l0Var2 = (l0) this.L$0;
                PagingSource<K, V> source = LegacyPageFetcher.this.getSource();
                PagingSource.LoadParams<K> loadParams = this.$params;
                this.L$0 = l0Var2;
                this.label = 1;
                Object objLoad = source.load(loadParams, this);
                if (objLoad == objC) {
                    return objC;
                }
                l0Var = l0Var2;
                obj = objLoad;
            }
            PagingSource.LoadResult loadResult = (PagingSource.LoadResult) obj;
            if (!LegacyPageFetcher.this.getSource().getInvalid()) {
                j.d(l0Var, LegacyPageFetcher.this.notifyDispatcher, null, new C00151(loadResult, null), 2, null);
                return z.f17874a;
            }
            LegacyPageFetcher.this.detach();
            return z.f17874a;
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[LoadType.PREPEND.ordinal()] = 1;
            iArr[LoadType.APPEND.ordinal()] = 2;
        }
    }

    public LegacyPageFetcher(l0 pagedListScope, PagedList.Config config, PagingSource<K, V> source, i0 notifyDispatcher, i0 fetchDispatcher, PageConsumer<V> pageConsumer, KeyProvider<K> keyProvider) {
        m.f(pagedListScope, "pagedListScope");
        m.f(config, "config");
        m.f(source, "source");
        m.f(notifyDispatcher, "notifyDispatcher");
        m.f(fetchDispatcher, "fetchDispatcher");
        m.f(pageConsumer, "pageConsumer");
        m.f(keyProvider, "keyProvider");
        this.pagedListScope = pagedListScope;
        this.config = config;
        this.source = source;
        this.notifyDispatcher = notifyDispatcher;
        this.fetchDispatcher = fetchDispatcher;
        this.pageConsumer = pageConsumer;
        this.keyProvider = keyProvider;
        this.detached = new AtomicBoolean(false);
        this.loadStateManager = new PagedList.LoadStateManager() { // from class: androidx.paging.LegacyPageFetcher$loadStateManager$1
            @Override // androidx.paging.PagedList.LoadStateManager
            public void onStateChanged(LoadType type, LoadState state) {
                m.f(type, "type");
                m.f(state, "state");
                this.this$0.getPageConsumer().onStateChanged(type, state);
            }
        };
    }

    private final void scheduleAppend() {
        K nextKey = this.keyProvider.getNextKey();
        if (nextKey == null) {
            onLoadSuccess(LoadType.APPEND, PagingSource.LoadResult.Page.INSTANCE.empty$paging_common());
            return;
        }
        PagedList.LoadStateManager loadStateManager = this.loadStateManager;
        LoadType loadType = LoadType.APPEND;
        loadStateManager.setState(loadType, LoadState.Loading.INSTANCE);
        PagedList.Config config = this.config;
        scheduleLoad(loadType, new PagingSource.LoadParams.Append(nextKey, config.pageSize, config.enablePlaceholders));
    }

    private final void scheduleLoad(LoadType type, PagingSource.LoadParams<K> params) {
        j.d(this.pagedListScope, this.fetchDispatcher, null, new AnonymousClass1(params, type, null), 2, null);
    }

    private final void schedulePrepend() {
        K prevKey = this.keyProvider.getPrevKey();
        if (prevKey == null) {
            onLoadSuccess(LoadType.PREPEND, PagingSource.LoadResult.Page.INSTANCE.empty$paging_common());
            return;
        }
        PagedList.LoadStateManager loadStateManager = this.loadStateManager;
        LoadType loadType = LoadType.PREPEND;
        loadStateManager.setState(loadType, LoadState.Loading.INSTANCE);
        PagedList.Config config = this.config;
        scheduleLoad(loadType, new PagingSource.LoadParams.Prepend(prevKey, config.pageSize, config.enablePlaceholders));
    }

    public final void detach() {
        this.detached.set(true);
    }

    public final PagedList.Config getConfig() {
        return this.config;
    }

    public final PagedList.LoadStateManager getLoadStateManager() {
        return this.loadStateManager;
    }

    public final PageConsumer<V> getPageConsumer() {
        return this.pageConsumer;
    }

    public final PagingSource<K, V> getSource() {
        return this.source;
    }

    public final boolean isDetached() {
        return this.detached.get();
    }

    public final void retry() {
        if (this.loadStateManager.getStartState() instanceof LoadState.Error) {
            schedulePrepend();
        }
        if (this.loadStateManager.getEndState() instanceof LoadState.Error) {
            scheduleAppend();
        }
    }

    public final void setLoadStateManager(PagedList.LoadStateManager loadStateManager) {
        m.f(loadStateManager, "<set-?>");
        this.loadStateManager = loadStateManager;
    }

    public final void tryScheduleAppend() {
        LoadState endState = this.loadStateManager.getEndState();
        if (!(endState instanceof LoadState.NotLoading) || endState.getEndOfPaginationReached()) {
            return;
        }
        scheduleAppend();
    }

    public final void trySchedulePrepend() {
        LoadState startState = this.loadStateManager.getStartState();
        if (!(startState instanceof LoadState.NotLoading) || startState.getEndOfPaginationReached()) {
            return;
        }
        schedulePrepend();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLoadError(LoadType type, Throwable throwable) {
        if (isDetached()) {
            return;
        }
        this.loadStateManager.setState(type, new LoadState.Error(throwable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLoadSuccess(LoadType type, PagingSource.LoadResult.Page<K, V> value) {
        LoadState.NotLoading incomplete$paging_common;
        if (isDetached()) {
            return;
        }
        if (this.pageConsumer.onPageResult(type, value)) {
            int i10 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (i10 != 1) {
                if (i10 == 2) {
                    scheduleAppend();
                    return;
                }
                throw new IllegalStateException("Can only fetch more during append/prepend");
            }
            schedulePrepend();
            return;
        }
        PagedList.LoadStateManager loadStateManager = this.loadStateManager;
        if (value.getData().isEmpty()) {
            incomplete$paging_common = LoadState.NotLoading.INSTANCE.getComplete$paging_common();
        } else {
            incomplete$paging_common = LoadState.NotLoading.INSTANCE.getIncomplete$paging_common();
        }
        loadStateManager.setState(type, incomplete$paging_common);
    }

    public static /* synthetic */ void getLoadStateManager$annotations() {
    }
}
