package androidx.paging;

import c9.l;
import c9.p;
import c9.q;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.channels.s;
import kotlinx.coroutines.flow.d0;
import kotlinx.coroutines.flow.f;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import r8.r;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001:\u0002,-B^\u0012(\u0010\u0007\u001a$\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000bø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJA\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00130\u0012*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000f2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u0018J5\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00062\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00160\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010 R)\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\"0\u00128\u0006¢\u0006\u0012\n\u0004\b#\u0010$\u0012\u0004\b'\u0010\u0018\u001a\u0004\b%\u0010&R9\u0010\u0007\u001a$\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00048\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0007\u0010(R\u0016\u0010\b\u001a\u0004\u0018\u00018\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010)R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010*R\"\u0010\f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010+\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"Landroidx/paging/PageFetcher;", "", "Key", "Value", "Lkotlin/Function1;", "Lv8/f;", "Landroidx/paging/PagingSource;", "pagingSourceFactory", "initialKey", "Landroidx/paging/PagingConfig;", "config", "Landroidx/paging/RemoteMediator;", "remoteMediator", "<init>", "(Lc9/l;Ljava/lang/Object;Landroidx/paging/PagingConfig;Landroidx/paging/RemoteMediator;)V", "Landroidx/paging/PageFetcherSnapshot;", "Landroidx/paging/RemoteMediatorAccessor;", "accessor", "Lkotlinx/coroutines/flow/f;", "Landroidx/paging/PageEvent;", "injectRemoteEvents", "(Landroidx/paging/PageFetcherSnapshot;Landroidx/paging/RemoteMediatorAccessor;)Lkotlinx/coroutines/flow/f;", "Lr8/z;", "invalidate", "()V", "refresh", "previousPagingSource", "generateNewPagingSource", "(Landroidx/paging/PagingSource;Lv8/f;)Ljava/lang/Object;", "Landroidx/paging/ConflatedEventBus;", "", "refreshEvents", "Landroidx/paging/ConflatedEventBus;", "retryEvents", "Landroidx/paging/PagingData;", "flow", "Lkotlinx/coroutines/flow/f;", "getFlow", "()Lkotlinx/coroutines/flow/f;", "getFlow$annotations", "Lc9/l;", "Ljava/lang/Object;", "Landroidx/paging/PagingConfig;", "Landroidx/paging/RemoteMediator;", "GenerationInfo", "PagerUiReceiver", "paging-common"}, k = 1, mv = {1, 4, 1})
public final class PageFetcher<Key, Value> {
    private final PagingConfig config;
    private final f<PagingData<Value>> flow;
    private final Key initialKey;
    private final l<v8.f<? super PagingSource<Key, Value>>, Object> pagingSourceFactory;
    private final ConflatedEventBus<Boolean> refreshEvents;
    private final RemoteMediator<Key, Value> remoteMediator;
    private final ConflatedEventBus<z> retryEvents;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u0002*\b\b\u0003\u0010\u0003*\u00020\u00022\u00020\u0002B/\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/paging/PageFetcher$GenerationInfo;", "Key", "", "Value", "snapshot", "Landroidx/paging/PageFetcherSnapshot;", "state", "Landroidx/paging/PagingState;", "(Landroidx/paging/PageFetcherSnapshot;Landroidx/paging/PagingState;)V", "getSnapshot", "()Landroidx/paging/PageFetcherSnapshot;", "getState", "()Landroidx/paging/PagingState;", "paging-common"}, k = 1, mv = {1, 4, 1})
    static final class GenerationInfo<Key, Value> {
        private final PageFetcherSnapshot<Key, Value> snapshot;
        private final PagingState<Key, Value> state;

        public GenerationInfo(PageFetcherSnapshot<Key, Value> snapshot, PagingState<Key, Value> pagingState) {
            m.f(snapshot, "snapshot");
            this.snapshot = snapshot;
            this.state = pagingState;
        }

        public final PageFetcherSnapshot<Key, Value> getSnapshot() {
            return this.snapshot;
        }

        public final PagingState<Key, Value> getState() {
            return this.state;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u0001*\b\b\u0003\u0010\u0003*\u00020\u00012\u00020\u0004B)\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0011R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0013R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/paging/PageFetcher$PagerUiReceiver;", "", "Key", "Value", "Landroidx/paging/UiReceiver;", "Landroidx/paging/PageFetcherSnapshot;", "pageFetcherSnapshot", "Landroidx/paging/ConflatedEventBus;", "Lr8/z;", "retryEventBus", "<init>", "(Landroidx/paging/PageFetcher;Landroidx/paging/PageFetcherSnapshot;Landroidx/paging/ConflatedEventBus;)V", "Landroidx/paging/ViewportHint;", "viewportHint", "accessHint", "(Landroidx/paging/ViewportHint;)V", "retry", "()V", "refresh", "Landroidx/paging/PageFetcherSnapshot;", "Landroidx/paging/ConflatedEventBus;", "paging-common"}, k = 1, mv = {1, 4, 1})
    public final class PagerUiReceiver<Key, Value> implements UiReceiver {
        private final PageFetcherSnapshot<Key, Value> pageFetcherSnapshot;
        private final ConflatedEventBus<z> retryEventBus;
        final /* synthetic */ PageFetcher this$0;

        public PagerUiReceiver(PageFetcher pageFetcher, PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, ConflatedEventBus<z> retryEventBus) {
            m.f(pageFetcherSnapshot, "pageFetcherSnapshot");
            m.f(retryEventBus, "retryEventBus");
            this.this$0 = pageFetcher;
            this.pageFetcherSnapshot = pageFetcherSnapshot;
            this.retryEventBus = retryEventBus;
        }

        @Override // androidx.paging.UiReceiver
        public void accessHint(ViewportHint viewportHint) {
            m.f(viewportHint, "viewportHint");
            this.pageFetcherSnapshot.accessHint(viewportHint);
        }

        @Override // androidx.paging.UiReceiver
        public void refresh() {
            this.this$0.refresh();
        }

        @Override // androidx.paging.UiReceiver
        public void retry() {
            this.retryEventBus.send(z.f17874a);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcher$generateNewPagingSource$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.paging.PageFetcher", f = "PageFetcher.kt", l = {211}, m = "generateNewPagingSource")
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00032\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00030\u0005H\u0082@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "Key", "Value", "Landroidx/paging/PagingSource;", "previousPagingSource", "Lv8/f;", "continuation", "generateNewPagingSource", "(Landroidx/paging/PagingSource;Lv8/f;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass1 extends d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(v8.f fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PageFetcher.this.generateNewPagingSource(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcher$generateNewPagingSource$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Key", "Value", "Lr8/z;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final /* synthetic */ class AnonymousClass3 extends k implements c9.a<z> {
        @Override // c9.a
        public /* bridge */ /* synthetic */ z invoke() {
            invoke2();
            return z.f17874a;
        }

        AnonymousClass3(PageFetcher pageFetcher) {
            super(0, pageFetcher, PageFetcher.class, "invalidate", "invalidate()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((PageFetcher) this.receiver).invalidate();
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcher$generateNewPagingSource$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Key", "Value", "Lr8/z;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final /* synthetic */ class AnonymousClass4 extends k implements c9.a<z> {
        @Override // c9.a
        public /* bridge */ /* synthetic */ z invoke() {
            invoke2();
            return z.f17874a;
        }

        AnonymousClass4(PageFetcher pageFetcher) {
            super(0, pageFetcher, PageFetcher.class, "invalidate", "invalidate()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((PageFetcher) this.receiver).invalidate();
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcher$injectRemoteEvents$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.paging.PageFetcher$injectRemoteEvents$1", f = "PageFetcher.kt", l = {253}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0003H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Key", "Value", "Lkotlinx/coroutines/channels/s;", "Landroidx/paging/PageEvent;", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class C05411 extends kotlin.coroutines.jvm.internal.l implements p<s<? super PageEvent<Value>>, v8.f<? super z>, Object> {
        final /* synthetic */ RemoteMediatorAccessor $accessor;
        final /* synthetic */ PageFetcherSnapshot $this_injectRemoteEvents;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.paging.PageFetcher$injectRemoteEvents$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "androidx.paging.PageFetcher$injectRemoteEvents$1$1", f = "PageFetcher.kt", l = {139}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u008a@¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "Key", "Value", "Landroidx/paging/LoadType;", IjkMediaMeta.IJKM_KEY_TYPE, "Landroidx/paging/LoadState;", "state", "Lr8/z;", "invoke", "(Landroidx/paging/LoadType;Landroidx/paging/LoadState;Lv8/f;)Ljava/lang/Object;", "dispatchIfValid"}, k = 3, mv = {1, 4, 1})
        static final class C00171 extends kotlin.coroutines.jvm.internal.l implements q<LoadType, LoadState, v8.f<? super z>, Object> {
            final /* synthetic */ s $this_channelFlow;
            private /* synthetic */ Object L$0;
            private /* synthetic */ Object L$1;
            int label;

            @Override // c9.q
            public final Object invoke(LoadType loadType, LoadState loadState, v8.f<? super z> fVar) {
                return ((C00171) create(loadType, loadState, fVar)).invokeSuspend(z.f17874a);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00171(s sVar, v8.f fVar) {
                super(3, fVar);
                this.$this_channelFlow = sVar;
            }

            public final v8.f<z> create(LoadType type, LoadState state, v8.f<? super z> continuation) {
                m.f(type, "type");
                m.f(state, "state");
                m.f(continuation, "continuation");
                C00171 c00171 = new C00171(this.$this_channelFlow, continuation);
                c00171.L$0 = type;
                c00171.L$1 = state;
                return c00171;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
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
                    LoadType loadType = (LoadType) this.L$0;
                    LoadState loadState = (LoadState) this.L$1;
                    if (PageEvent.LoadStateUpdate.INSTANCE.canDispatchWithoutInsert$paging_common(loadState, true)) {
                        s sVar = this.$this_channelFlow;
                        PageEvent.LoadStateUpdate loadStateUpdate = new PageEvent.LoadStateUpdate(loadType, true, loadState);
                        this.L$0 = null;
                        this.label = 1;
                        if (sVar.b(loadStateUpdate, this) == objC) {
                            return objC;
                        }
                    }
                }
                return z.f17874a;
            }
        }

        /* JADX INFO: renamed from: androidx.paging.PageFetcher$injectRemoteEvents$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "androidx.paging.PageFetcher$injectRemoteEvents$1$2", f = "PageFetcher.kt", l = {253}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Key", "Value", "Lkotlinx/coroutines/l0;", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
        static final class AnonymousClass2 extends kotlin.coroutines.jvm.internal.l implements p<l0, v8.f<? super z>, Object> {
            final /* synthetic */ C00171 $dispatchIfValid$1;
            final /* synthetic */ MutableLoadStateCollection $loadStates;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(MutableLoadStateCollection mutableLoadStateCollection, C00171 c00171, v8.f fVar) {
                super(2, fVar);
                this.$loadStates = mutableLoadStateCollection;
                this.$dispatchIfValid$1 = c00171;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(Object obj, v8.f<?> completion) {
                m.f(completion, "completion");
                return C05411.this.new AnonymousClass2(this.$loadStates, this.$dispatchIfValid$1, completion);
            }

            @Override // c9.p
            public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                return ((AnonymousClass2) create(l0Var, fVar)).invokeSuspend(z.f17874a);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [T, androidx.paging.LoadStates] */
            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
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
                    b0 b0Var = new b0();
                    b0Var.element = LoadStates.INSTANCE.getIDLE();
                    d0<LoadStates> state = C05411.this.$accessor.getState();
                    PageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1 pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1 = new PageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1(this, b0Var);
                    this.label = 1;
                    if (state.collect(pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1, this) == objC) {
                        return objC;
                    }
                }
                return z.f17874a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05411(PageFetcherSnapshot pageFetcherSnapshot, RemoteMediatorAccessor remoteMediatorAccessor, v8.f fVar) {
            super(2, fVar);
            this.$this_injectRemoteEvents = pageFetcherSnapshot;
            this.$accessor = remoteMediatorAccessor;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> completion) {
            m.f(completion, "completion");
            C05411 c05411 = new C05411(this.$this_injectRemoteEvents, this.$accessor, completion);
            c05411.L$0 = obj;
            return c05411;
        }

        @Override // c9.p
        public final Object invoke(Object obj, v8.f<? super z> fVar) {
            return ((C05411) create(obj, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
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
                s sVar = (s) this.L$0;
                MutableLoadStateCollection mutableLoadStateCollection = new MutableLoadStateCollection();
                j.d(sVar, null, null, new AnonymousClass2(mutableLoadStateCollection, new C00171(sVar, null), null), 3, null);
                f<PageEvent<Value>> pageEventFlow = this.$this_injectRemoteEvents.getPageEventFlow();
                PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$collect$1 pageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$collect$1 = new PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$collect$1(this, sVar, mutableLoadStateCollection);
                this.label = 1;
                if (pageEventFlow.collect(pageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$collect$1, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PageFetcher(l<? super v8.f<? super PagingSource<Key, Value>>, ? extends Object> pagingSourceFactory, Key key, PagingConfig config, RemoteMediator<Key, Value> remoteMediator) {
        m.f(pagingSourceFactory, "pagingSourceFactory");
        m.f(config, "config");
        this.pagingSourceFactory = pagingSourceFactory;
        this.initialKey = key;
        this.config = config;
        this.remoteMediator = remoteMediator;
        this.refreshEvents = new ConflatedEventBus<>(null, 1, null);
        this.retryEvents = new ConflatedEventBus<>(null, 1, null);
        this.flow = h.h(new PageFetcher$flow$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final f<PageEvent<Value>> injectRemoteEvents(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, RemoteMediatorAccessor<Key, Value> remoteMediatorAccessor) {
        return remoteMediatorAccessor == null ? pageFetcherSnapshot.getPageEventFlow() : h.h(new C05411(pageFetcherSnapshot, remoteMediatorAccessor, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidate() {
        this.refreshEvents.send(Boolean.FALSE);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    final /* synthetic */ Object generateNewPagingSource(PagingSource<Key, Value> pagingSource, v8.f<? super PagingSource<Key, Value>> fVar) {
        AnonymousClass1 anonymousClass1;
        PageFetcher<Key, Value> pageFetcher;
        if (fVar instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) fVar;
            int i10 = anonymousClass1.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i10 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(fVar);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(fVar);
        }
        Object objInvoke = anonymousClass1.result;
        Object objC = b.c();
        int i11 = anonymousClass1.label;
        if (i11 == 0) {
            r.b(objInvoke);
            l<v8.f<? super PagingSource<Key, Value>>, Object> lVar = this.pagingSourceFactory;
            anonymousClass1.L$0 = this;
            anonymousClass1.L$1 = pagingSource;
            anonymousClass1.label = 1;
            objInvoke = lVar.invoke(anonymousClass1);
            if (objInvoke == objC) {
                return objC;
            }
            pageFetcher = this;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            pagingSource = (PagingSource) anonymousClass1.L$1;
            pageFetcher = (PageFetcher) anonymousClass1.L$0;
            r.b(objInvoke);
        }
        PagingSource<Key, Value> pagingSource2 = (PagingSource) objInvoke;
        if (pagingSource2 instanceof LegacyPagingSource) {
            ((LegacyPagingSource) pagingSource2).setPageSize(pageFetcher.config.pageSize);
        }
        if (!(pagingSource2 != pagingSource)) {
            throw new IllegalStateException("An instance of PagingSource was re-used when Pager expected to create a new\ninstance. Ensure that the pagingSourceFactory passed to Pager always returns a\nnew instance of PagingSource.");
        }
        pagingSource2.registerInvalidatedCallback(new AnonymousClass3(pageFetcher));
        if (pagingSource != null) {
            pagingSource.unregisterInvalidatedCallback(new AnonymousClass4(pageFetcher));
        }
        if (pagingSource != null) {
            pagingSource.invalidate();
        }
        return pagingSource2;
    }

    public final f<PagingData<Value>> getFlow() {
        return this.flow;
    }

    public final void refresh() {
        this.refreshEvents.send(Boolean.TRUE);
    }

    public /* synthetic */ PageFetcher(l lVar, Object obj, PagingConfig pagingConfig, RemoteMediator remoteMediator, int i10, g gVar) {
        this(lVar, obj, pagingConfig, (i10 & 8) != 0 ? null : remoteMediator);
    }

    public static /* synthetic */ void getFlow$annotations() {
    }
}
