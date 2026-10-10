package androidx.paging;

import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import c9.p;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import r8.r;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0017\u0018\u0000 h*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u00042\u00020\u00052\b\u0012\u0004\u0012\u00028\u00010\u0006:\u0001hBi\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0012\u0012\b\u0010\u0014\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u001f\u0010$\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u001eH\u0002¢\u0006\u0004\b$\u0010%J)\u0010&\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u00172\u0010\u0010\u001a\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\u0012H\u0016¢\u0006\u0004\b&\u0010'J\u001f\u0010*\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+J'\u00101\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u001eH\u0001¢\u0006\u0004\b/\u00100J\u000f\u00102\u001a\u00020\u001bH\u0016¢\u0006\u0004\b2\u00103J)\u00106\u001a\u00020\u001b2\u0018\u00105\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001b04H\u0016¢\u0006\u0004\b6\u00107J\u001f\u0010:\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u00172\u0006\u00109\u001a\u00020(H\u0016¢\u0006\u0004\b:\u0010+J\u0017\u0010=\u001a\u00020\u001b2\u0006\u0010<\u001a\u00020;H\u0017¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\u001bH\u0016¢\u0006\u0004\b?\u00103J\u0017\u0010A\u001a\u00020\u001b2\u0006\u0010@\u001a\u00020;H\u0017¢\u0006\u0004\bA\u0010>J'\u0010E\u001a\u00020\u001b2\u0006\u0010B\u001a\u00020;2\u0006\u0010C\u001a\u00020;2\u0006\u0010D\u001a\u00020;H\u0017¢\u0006\u0004\bE\u0010FJ'\u0010H\u001a\u00020\u001b2\u0006\u0010G\u001a\u00020;2\u0006\u0010C\u001a\u00020;2\u0006\u0010D\u001a\u00020;H\u0017¢\u0006\u0004\bH\u0010FJ\u001f\u0010J\u001a\u00020\u001b2\u0006\u0010I\u001a\u00020;2\u0006\u0010@\u001a\u00020;H\u0016¢\u0006\u0004\bJ\u0010KJ\u001f\u0010L\u001a\u00020\u001b2\u0006\u0010I\u001a\u00020;2\u0006\u0010@\u001a\u00020;H\u0016¢\u0006\u0004\bL\u0010KR\u0016\u0010M\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010O\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010NR\u0016\u0010P\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010R\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010QR\u0016\u0010S\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010NR\u0016\u0010T\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010NR\u0016\u0010U\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010QR\u0014\u0010V\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010QR&\u0010X\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010W8\u0002X\u0082\u0004¢\u0006\f\n\u0004\bX\u0010Y\u0012\u0004\bZ\u00103R#\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010[\u001a\u0004\b\\\u0010]R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010^\u001a\u0004\b_\u0010`R\u0016\u0010\u0014\u001a\u0004\u0018\u00018\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010aR\u001c\u0010e\u001a\u0004\u0018\u00018\u00008VX\u0096\u0004¢\u0006\f\u0012\u0004\bd\u00103\u001a\u0004\bb\u0010cR\u0014\u0010f\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bf\u0010g¨\u0006i"}, d2 = {"Landroidx/paging/ContiguousPagedList;", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/paging/PagedList;", "Landroidx/paging/PagedStorage$Callback;", "Landroidx/paging/LegacyPageFetcher$PageConsumer;", "Landroidx/paging/PagingSource;", "pagingSource", "Lkotlinx/coroutines/l0;", "coroutineScope", "Lkotlinx/coroutines/i0;", "notifyDispatcher", "backgroundDispatcher", "Landroidx/paging/PagedList$BoundaryCallback;", "boundaryCallback", "Landroidx/paging/PagedList$Config;", "config", "Landroidx/paging/PagingSource$LoadResult$Page;", "initialPage", "initialLastKey", "<init>", "(Landroidx/paging/PagingSource;Lkotlinx/coroutines/l0;Lkotlinx/coroutines/i0;Lkotlinx/coroutines/i0;Landroidx/paging/PagedList$BoundaryCallback;Landroidx/paging/PagedList$Config;Landroidx/paging/PagingSource$LoadResult$Page;Ljava/lang/Object;)V", "Landroidx/paging/LoadType;", IjkMediaMeta.IJKM_KEY_TYPE, "", "page", "Lr8/z;", "triggerBoundaryCallback", "(Landroidx/paging/LoadType;Ljava/util/List;)V", "", "post", "tryDispatchBoundaryCallbacks", "(Z)V", "begin", "end", "dispatchBoundaryCallbacks", "(ZZ)V", "onPageResult", "(Landroidx/paging/LoadType;Landroidx/paging/PagingSource$LoadResult$Page;)Z", "Landroidx/paging/LoadState;", "state", "onStateChanged", "(Landroidx/paging/LoadType;Landroidx/paging/LoadState;)V", "deferEmpty", "deferBegin", "deferEnd", "deferBoundaryCallbacks$paging_common", "(ZZZ)V", "deferBoundaryCallbacks", "retry", "()V", "Lkotlin/Function2;", "callback", "dispatchCurrentLoadState", "(Lc9/p;)V", "loadType", "loadState", "setInitialLoadState", "", "index", "loadAroundInternal", "(I)V", "detach", "count", "onInitialized", "leadingNulls", "changed", "added", "onPagePrepended", "(III)V", "endPosition", "onPageAppended", "startOfDrops", "onPagesRemoved", "(II)V", "onPagesSwappedToPlaceholder", "prependItemsRequested", "I", "appendItemsRequested", "boundaryCallbackBeginDeferred", "Z", "boundaryCallbackEndDeferred", "lowestIndexAccessed", "highestIndexAccessed", "replacePagesWithNulls", "shouldTrim", "Landroidx/paging/LegacyPageFetcher;", "pager", "Landroidx/paging/LegacyPageFetcher;", "getPager$annotations", "Landroidx/paging/PagingSource;", "getPagingSource", "()Landroidx/paging/PagingSource;", "Landroidx/paging/PagedList$BoundaryCallback;", "getBoundaryCallback$paging_common", "()Landroidx/paging/PagedList$BoundaryCallback;", "Ljava/lang/Object;", "getLastKey", "()Ljava/lang/Object;", "getLastKey$annotations", "lastKey", "isDetached", "()Z", "Companion", "paging-common"}, k = 1, mv = {1, 4, 1})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ContiguousPagedList<K, V> extends PagedList<V> implements PagedStorage.Callback, LegacyPageFetcher.PageConsumer<V> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int appendItemsRequested;
    private final PagedList.BoundaryCallback<V> boundaryCallback;
    private boolean boundaryCallbackBeginDeferred;
    private boolean boundaryCallbackEndDeferred;
    private int highestIndexAccessed;
    private final K initialLastKey;
    private int lowestIndexAccessed;
    private final LegacyPageFetcher<K, V> pager;
    private final PagingSource<K, V> pagingSource;
    private int prependItemsRequested;
    private boolean replacePagesWithNulls;
    private final boolean shouldTrim;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\bJ%\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u000b¨\u0006\f"}, d2 = {"Landroidx/paging/ContiguousPagedList$Companion;", "", "()V", "getAppendItemsRequested", "", "prefetchDistance", "index", "itemsBeforeTrailingNulls", "getAppendItemsRequested$paging_common", "getPrependItemsRequested", "leadingNulls", "getPrependItemsRequested$paging_common", "paging-common"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        private Companion() {
        }

        public final int getAppendItemsRequested$paging_common(int prefetchDistance, int index, int itemsBeforeTrailingNulls) {
            return ((index + prefetchDistance) + 1) - itemsBeforeTrailingNulls;
        }

        public final int getPrependItemsRequested$paging_common(int prefetchDistance, int index, int leadingNulls) {
            return prefetchDistance - (index - leadingNulls);
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: androidx.paging.ContiguousPagedList$tryDispatchBoundaryCallbacks$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.paging.ContiguousPagedList$tryDispatchBoundaryCallbacks$1", f = "ContiguousPagedList.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlinx/coroutines/l0;", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass1 extends l implements p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ boolean $dispatchBegin;
        final /* synthetic */ boolean $dispatchEnd;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z10, boolean z11, v8.f fVar) {
            super(2, fVar);
            this.$dispatchBegin = z10;
            this.$dispatchEnd = z11;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> completion) {
            m.f(completion, "completion");
            return new AnonymousClass1(this.$dispatchBegin, this.$dispatchEnd, completion);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((AnonymousClass1) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.label == 0) {
                r.b(obj);
                ContiguousPagedList.this.dispatchBoundaryCallbacks(this.$dispatchBegin, this.$dispatchEnd);
                return z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // androidx.paging.PagedStorage.Callback
    @MainThread
    public void onInitialized(int count) {
        notifyInserted$paging_common(0, count);
        this.replacePagesWithNulls = getStorage$paging_common().getPlaceholdersBefore() > 0 || getStorage$paging_common().getPlaceholdersAfter() > 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContiguousPagedList(PagingSource<K, V> pagingSource, l0 coroutineScope, i0 notifyDispatcher, i0 backgroundDispatcher, PagedList.BoundaryCallback<V> boundaryCallback, PagedList.Config config, PagingSource.LoadResult.Page<K, V> initialPage, K k10) {
        super(pagingSource, coroutineScope, notifyDispatcher, new PagedStorage(), config);
        m.f(pagingSource, "pagingSource");
        m.f(coroutineScope, "coroutineScope");
        m.f(notifyDispatcher, "notifyDispatcher");
        m.f(backgroundDispatcher, "backgroundDispatcher");
        m.f(config, "config");
        m.f(initialPage, "initialPage");
        this.pagingSource = pagingSource;
        this.boundaryCallback = boundaryCallback;
        this.initialLastKey = k10;
        this.lowestIndexAccessed = Integer.MAX_VALUE;
        this.highestIndexAccessed = Integer.MIN_VALUE;
        this.shouldTrim = config.maxSize != Integer.MAX_VALUE;
        PagedStorage<V> storage$paging_common = getStorage$paging_common();
        if (storage$paging_common == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.paging.LegacyPageFetcher.KeyProvider<K>");
        }
        this.pager = new LegacyPageFetcher<>(coroutineScope, config, pagingSource, notifyDispatcher, backgroundDispatcher, this, storage$paging_common);
        if (config.enablePlaceholders) {
            getStorage$paging_common().init(initialPage.getItemsBefore() != Integer.MIN_VALUE ? initialPage.getItemsBefore() : 0, initialPage, initialPage.getItemsAfter() != Integer.MIN_VALUE ? initialPage.getItemsAfter() : 0, 0, this, (initialPage.getItemsBefore() == Integer.MIN_VALUE || initialPage.getItemsAfter() == Integer.MIN_VALUE) ? false : true);
        } else {
            getStorage$paging_common().init(0, initialPage, 0, initialPage.getItemsBefore() != Integer.MIN_VALUE ? initialPage.getItemsBefore() : 0, this, false);
        }
        triggerBoundaryCallback(LoadType.REFRESH, initialPage.getData());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchBoundaryCallbacks(boolean begin, boolean end) {
        if (begin) {
            PagedList.BoundaryCallback<V> boundaryCallback = this.boundaryCallback;
            m.c(boundaryCallback);
            boundaryCallback.onItemAtFrontLoaded(getStorage$paging_common().getFirstLoadedItem$paging_common());
        }
        if (end) {
            PagedList.BoundaryCallback<V> boundaryCallback2 = this.boundaryCallback;
            m.c(boundaryCallback2);
            boundaryCallback2.onItemAtEndLoaded(getStorage$paging_common().getLastLoadedItem$paging_common());
        }
    }

    private final void triggerBoundaryCallback(LoadType type, List<? extends V> page) {
        if (this.boundaryCallback != null) {
            boolean z10 = false;
            boolean z11 = getStorage$paging_common().size() == 0;
            boolean z12 = !z11 && type == LoadType.PREPEND && page.isEmpty();
            if (!z11 && type == LoadType.APPEND && page.isEmpty()) {
                z10 = true;
            }
            deferBoundaryCallbacks$paging_common(z11, z12, z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tryDispatchBoundaryCallbacks(boolean post) {
        boolean z10 = this.boundaryCallbackBeginDeferred && this.lowestIndexAccessed <= getConfig().prefetchDistance;
        boolean z11 = this.boundaryCallbackEndDeferred && this.highestIndexAccessed >= (size() - 1) - getConfig().prefetchDistance;
        if (z10 || z11) {
            if (z10) {
                this.boundaryCallbackBeginDeferred = false;
            }
            if (z11) {
                this.boundaryCallbackEndDeferred = false;
            }
            if (post) {
                j.d(getCoroutineScope(), getNotifyDispatcher(), null, new AnonymousClass1(z10, z11, null), 2, null);
            } else {
                dispatchBoundaryCallbacks(z10, z11);
            }
        }
    }

    @AnyThread
    public final void deferBoundaryCallbacks$paging_common(boolean deferEmpty, boolean deferBegin, boolean deferEnd) {
        if (this.boundaryCallback == null) {
            throw new IllegalStateException("Can't defer BoundaryCallback, no instance");
        }
        if (this.lowestIndexAccessed == Integer.MAX_VALUE) {
            this.lowestIndexAccessed = getStorage$paging_common().size();
        }
        if (this.highestIndexAccessed == Integer.MIN_VALUE) {
            this.highestIndexAccessed = 0;
        }
        if (deferEmpty || deferBegin || deferEnd) {
            j.d(getCoroutineScope(), getNotifyDispatcher(), null, new ContiguousPagedList$deferBoundaryCallbacks$1(this, deferEmpty, deferBegin, deferEnd, null), 2, null);
        }
    }

    @Override // androidx.paging.PagedList
    public void detach() {
        this.pager.detach();
    }

    @Override // androidx.paging.PagedList
    public void dispatchCurrentLoadState(p<? super LoadType, ? super LoadState, z> callback) {
        m.f(callback, "callback");
        this.pager.getLoadStateManager().dispatchCurrentLoadState(callback);
    }

    public final PagedList.BoundaryCallback<V> getBoundaryCallback$paging_common() {
        return this.boundaryCallback;
    }

    @Override // androidx.paging.PagedList
    public final PagingSource<K, V> getPagingSource() {
        return this.pagingSource;
    }

    @Override // androidx.paging.PagedList
    /* JADX INFO: renamed from: isDetached */
    public boolean getIsDetached() {
        return this.pager.isDetached();
    }

    @Override // androidx.paging.PagedList
    @MainThread
    public void loadAroundInternal(int index) {
        Companion companion = INSTANCE;
        int prependItemsRequested$paging_common = companion.getPrependItemsRequested$paging_common(getConfig().prefetchDistance, index, getStorage$paging_common().getPlaceholdersBefore());
        int appendItemsRequested$paging_common = companion.getAppendItemsRequested$paging_common(getConfig().prefetchDistance, index, getStorage$paging_common().getPlaceholdersBefore() + getStorage$paging_common().getStorageCount());
        int iMax = Math.max(prependItemsRequested$paging_common, this.prependItemsRequested);
        this.prependItemsRequested = iMax;
        if (iMax > 0) {
            this.pager.trySchedulePrepend();
        }
        int iMax2 = Math.max(appendItemsRequested$paging_common, this.appendItemsRequested);
        this.appendItemsRequested = iMax2;
        if (iMax2 > 0) {
            this.pager.tryScheduleAppend();
        }
        this.lowestIndexAccessed = Math.min(this.lowestIndexAccessed, index);
        this.highestIndexAccessed = Math.max(this.highestIndexAccessed, index);
        tryDispatchBoundaryCallbacks(true);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0067  */
    @Override // androidx.paging.LegacyPageFetcher.PageConsumer
    public boolean onPageResult(LoadType type, PagingSource.LoadResult.Page<?, V> page) {
        m.f(type, "type");
        m.f(page, "page");
        List<? extends V> data = page.getData();
        boolean z10 = true;
        boolean z11 = false;
        boolean z12 = lastLoad() > getStorage$paging_common().getMiddleOfLoadedRange();
        boolean z13 = this.shouldTrim && getStorage$paging_common().shouldPreTrimNewPage(getConfig().maxSize, getRequiredRemainder(), data.size());
        LoadType loadType = LoadType.APPEND;
        if (type == loadType) {
            if (!z13 || z12) {
                getStorage$paging_common().appendPage$paging_common(page, this);
                int size = this.appendItemsRequested - data.size();
                this.appendItemsRequested = size;
                if (size <= 0 || data.isEmpty()) {
                    z10 = false;
                }
                z11 = z10;
            } else {
                this.appendItemsRequested = 0;
            }
        } else {
            if (type != LoadType.PREPEND) {
                throw new IllegalArgumentException("unexpected result type " + type);
            }
            if (z13 && z12) {
                this.prependItemsRequested = 0;
            } else {
                getStorage$paging_common().prependPage$paging_common(page, this);
                int size2 = this.prependItemsRequested - data.size();
                this.prependItemsRequested = size2;
                if (size2 <= 0 || data.isEmpty()) {
                    z10 = false;
                }
                z11 = z10;
            }
        }
        if (this.shouldTrim) {
            if (z12) {
                if (!(this.pager.getLoadStateManager().getStartState() instanceof LoadState.Loading) && getStorage$paging_common().trimFromFront$paging_common(this.replacePagesWithNulls, getConfig().maxSize, getRequiredRemainder(), this)) {
                    this.pager.getLoadStateManager().setState(LoadType.PREPEND, LoadState.NotLoading.INSTANCE.getIncomplete$paging_common());
                }
            } else if (!(this.pager.getLoadStateManager().getEndState() instanceof LoadState.Loading) && getStorage$paging_common().trimFromEnd$paging_common(this.replacePagesWithNulls, getConfig().maxSize, getRequiredRemainder(), this)) {
                this.pager.getLoadStateManager().setState(loadType, LoadState.NotLoading.INSTANCE.getIncomplete$paging_common());
            }
        }
        triggerBoundaryCallback(type, data);
        return z11;
    }

    @Override // androidx.paging.LegacyPageFetcher.PageConsumer
    public void onStateChanged(LoadType type, LoadState state) {
        m.f(type, "type");
        m.f(state, "state");
        dispatchStateChangeAsync$paging_common(type, state);
    }

    @Override // androidx.paging.PagedList
    public void setInitialLoadState(LoadType loadType, LoadState loadState) {
        m.f(loadType, "loadType");
        m.f(loadState, "loadState");
        this.pager.getLoadStateManager().setState(loadType, loadState);
    }

    @Override // androidx.paging.PagedList
    public K getLastKey() {
        K refreshKey;
        PagingState<?, V> refreshKeyInfo = getStorage$paging_common().getRefreshKeyInfo(getConfig());
        if (refreshKeyInfo != null && (refreshKey = this.pagingSource.getRefreshKey(refreshKeyInfo)) != null) {
            return refreshKey;
        }
        return this.initialLastKey;
    }

    @Override // androidx.paging.PagedStorage.Callback
    @MainThread
    public void onPageAppended(int endPosition, int changed, int added) {
        notifyChanged(endPosition, changed);
        notifyInserted$paging_common(endPosition + changed, added);
    }

    @Override // androidx.paging.PagedStorage.Callback
    @MainThread
    public void onPagePrepended(int leadingNulls, int changed, int added) {
        notifyChanged(leadingNulls, changed);
        notifyInserted$paging_common(0, added);
        this.lowestIndexAccessed += added;
        this.highestIndexAccessed += added;
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void onPagesRemoved(int startOfDrops, int count) {
        notifyRemoved(startOfDrops, count);
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void onPagesSwappedToPlaceholder(int startOfDrops, int count) {
        notifyChanged(startOfDrops, count);
    }

    @Override // androidx.paging.PagedList
    public void retry() {
        Runnable refreshRetryCallback;
        super.retry();
        this.pager.retry();
        if ((this.pager.getLoadStateManager().getRefreshState() instanceof LoadState.Error) && (refreshRetryCallback = getRefreshRetryCallback()) != null) {
            refreshRetryCallback.run();
        }
    }

    public static /* synthetic */ void getLastKey$annotations() {
    }

    private static /* synthetic */ void getPager$annotations() {
    }
}
