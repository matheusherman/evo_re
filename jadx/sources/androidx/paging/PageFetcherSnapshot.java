package androidx.paging;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import c9.p;
import c9.q;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.channels.d;
import kotlinx.coroutines.flow.b0;
import kotlinx.coroutines.flow.f;
import kotlinx.coroutines.flow.g;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.flow.u;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.u1;
import r8.r;
import r8.z;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001Bm\u0012\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000e\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0015\u001a\u00020\n*\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ9\u0010!\u001a\u0004\u0018\u00018\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001d2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0002¢\u0006\u0004\b!\u0010\"J%\u0010%\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010#H\u0082@ø\u0001\u0000¢\u0006\u0004\b%\u0010&J\u0015\u0010'\u001a\u00020\n2\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\n¢\u0006\u0004\b)\u0010*J!\u0010,\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010+H\u0086@ø\u0001\u0000¢\u0006\u0004\b,\u0010-J%\u0010.\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u001e0\t2\u0006\u0010\u0018\u001a\u00020\u0017H\u0082@ø\u0001\u0000¢\u0006\u0004\b.\u0010/J\u0013\u00100\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0004\b0\u0010-J#\u00103\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u00102\u001a\u000201H\u0082@ø\u0001\u0000¢\u0006\u0004\b3\u00104J+\u00105\u001a\u00020\n*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001d2\u0006\u0010\u0018\u001a\u00020\u0017H\u0082@ø\u0001\u0000¢\u0006\u0004\b5\u00106R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020#078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010;\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010>\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R \u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010A0@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR \u0010E\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010H\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR#\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010A0\t8\u0006¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u001c\u0010\u0004\u001a\u0004\u0018\u00018\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010N\u001a\u0004\bO\u0010PR&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010Q\u001a\u0004\bR\u0010SR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010TR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010KR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010UR%\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010V\u001a\u0004\bW\u0010XR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010Y\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006Z"}, d2 = {"Landroidx/paging/PageFetcherSnapshot;", "", "Key", "Value", "initialKey", "Landroidx/paging/PagingSource;", "pagingSource", "Landroidx/paging/PagingConfig;", "config", "Lkotlinx/coroutines/flow/f;", "Lr8/z;", "retryFlow", "", "triggerRemoteRefresh", "Landroidx/paging/RemoteMediatorConnection;", "remoteMediatorConnection", "Lkotlin/Function0;", "invalidate", "<init>", "(Ljava/lang/Object;Landroidx/paging/PagingSource;Landroidx/paging/PagingConfig;Lkotlinx/coroutines/flow/f;ZLandroidx/paging/RemoteMediatorConnection;Lc9/a;)V", "Lkotlinx/coroutines/l0;", "startConsumingHints", "(Lkotlinx/coroutines/l0;)V", "Landroidx/paging/LoadType;", "loadType", "key", "Landroidx/paging/PagingSource$LoadParams;", "loadParams", "(Landroidx/paging/LoadType;Ljava/lang/Object;)Landroidx/paging/PagingSource$LoadParams;", "Landroidx/paging/PageFetcherSnapshotState;", "", "generationId", "presentedItemsBeyondAnchor", "nextLoadKeyOrNull", "(Landroidx/paging/PageFetcherSnapshotState;Landroidx/paging/LoadType;II)Ljava/lang/Object;", "Landroidx/paging/ViewportHint;", "viewportHint", "retryLoadError", "(Landroidx/paging/LoadType;Landroidx/paging/ViewportHint;Lv8/f;)Ljava/lang/Object;", "accessHint", "(Landroidx/paging/ViewportHint;)V", "close", "()V", "Landroidx/paging/PagingState;", "refreshKeyInfo", "(Lv8/f;)Ljava/lang/Object;", "collectAsGenerationalViewportHints", "(Lkotlinx/coroutines/flow/f;Landroidx/paging/LoadType;Lv8/f;)Ljava/lang/Object;", "doInitialLoad", "Landroidx/paging/GenerationalViewportHint;", "generationalHint", "doLoad", "(Landroidx/paging/LoadType;Landroidx/paging/GenerationalViewportHint;Lv8/f;)Ljava/lang/Object;", "setLoading", "(Landroidx/paging/PageFetcherSnapshotState;Landroidx/paging/LoadType;Lv8/f;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/u;", "hintSharedFlow", "Lkotlinx/coroutines/flow/u;", "Landroidx/paging/ViewportHint$Access;", "lastHint", "Landroidx/paging/ViewportHint$Access;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "pageEventChCollected", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lkotlinx/coroutines/channels/d;", "Landroidx/paging/PageEvent;", "pageEventCh", "Lkotlinx/coroutines/channels/d;", "Landroidx/paging/PageFetcherSnapshotState$Holder;", "stateHolder", "Landroidx/paging/PageFetcherSnapshotState$Holder;", "Lkotlinx/coroutines/z;", "pageEventChannelFlowJob", "Lkotlinx/coroutines/z;", "pageEventFlow", "Lkotlinx/coroutines/flow/f;", "getPageEventFlow", "()Lkotlinx/coroutines/flow/f;", "Ljava/lang/Object;", "getInitialKey$paging_common", "()Ljava/lang/Object;", "Landroidx/paging/PagingSource;", "getPagingSource$paging_common", "()Landroidx/paging/PagingSource;", "Landroidx/paging/PagingConfig;", "Z", "Landroidx/paging/RemoteMediatorConnection;", "getRemoteMediatorConnection", "()Landroidx/paging/RemoteMediatorConnection;", "Lc9/a;", "paging-common"}, k = 1, mv = {1, 4, 1})
public final class PageFetcherSnapshot<Key, Value> {
    private final PagingConfig config;
    private final u<ViewportHint> hintSharedFlow;
    private final Key initialKey;
    private final c9.a<z> invalidate;
    private ViewportHint.Access lastHint;
    private final d<PageEvent<Value>> pageEventCh;
    private final AtomicBoolean pageEventChCollected;
    private final kotlinx.coroutines.z pageEventChannelFlowJob;
    private final f<PageEvent<Value>> pageEventFlow;
    private final PagingSource<Key, Value> pagingSource;
    private final RemoteMediatorConnection<Key, Value> remoteMediatorConnection;
    private final f<z> retryFlow;
    private final PageFetcherSnapshotState.Holder<Key, Value> stateHolder;
    private final boolean triggerRemoteRefresh;

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Key", "Value", "Lr8/z;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass1 extends o implements c9.a<z> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // c9.a
        public /* bridge */ /* synthetic */ z invoke() {
            invoke2();
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$3", f = "PageFetcherSnapshot.kt", l = {}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "Landroidx/paging/GenerationalViewportHint;", "Key", "", "Value", "previous", "next", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass3 extends l implements q<GenerationalViewportHint, GenerationalViewportHint, v8.f<? super GenerationalViewportHint>, Object> {
        final /* synthetic */ LoadType $loadType;
        private /* synthetic */ Object L$0;
        private /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(LoadType loadType, v8.f fVar) {
            super(3, fVar);
            this.$loadType = loadType;
        }

        public final v8.f<z> create(GenerationalViewportHint previous, GenerationalViewportHint next, v8.f<? super GenerationalViewportHint> continuation) {
            m.f(previous, "previous");
            m.f(next, "next");
            m.f(continuation, "continuation");
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$loadType, continuation);
            anonymousClass3.L$0 = previous;
            anonymousClass3.L$1 = next;
            return anonymousClass3;
        }

        @Override // c9.q
        public final Object invoke(GenerationalViewportHint generationalViewportHint, GenerationalViewportHint generationalViewportHint2, v8.f<? super GenerationalViewportHint> fVar) {
            return ((AnonymousClass3) create(generationalViewportHint, generationalViewportHint2, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.label == 0) {
                r.b(obj);
                GenerationalViewportHint generationalViewportHint = (GenerationalViewportHint) this.L$0;
                GenerationalViewportHint generationalViewportHint2 = (GenerationalViewportHint) this.L$1;
                if (PageFetcherSnapshotKt.shouldPrioritizeOver(generationalViewportHint2, generationalViewportHint, this.$loadType)) {
                    return generationalViewportHint2;
                }
                return generationalViewportHint;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$doInitialLoad$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.paging.PageFetcherSnapshot", f = "PageFetcherSnapshot.kt", l = {TypedValues.MotionType.TYPE_ANIMATE_CIRCLEANGLE_TO, 283, 286, 618, 630, 642, 315, 654, 666, 340}, m = "doInitialLoad")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0082@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Key", "Value", "Lv8/f;", "Lr8/z;", "continuation", "doInitialLoad", "(Lv8/f;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    static final class C05421 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C05421(v8.f fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PageFetcherSnapshot.this.doInitialLoad(this);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$doLoad$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.paging.PageFetcherSnapshot", f = "PageFetcherSnapshot.kt", l = {679, 691, 381, 389, IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH, 715, 432, 727, 451, 477, 739}, m = "doLoad")
    @Metadata(d1 = {"\u0000 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0082@¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"", "Key", "Value", "Landroidx/paging/LoadType;", "loadType", "Landroidx/paging/GenerationalViewportHint;", "generationalHint", "Lv8/f;", "Lr8/z;", "continuation", "doLoad", "(Landroidx/paging/LoadType;Landroidx/paging/GenerationalViewportHint;Lv8/f;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    static final class C05431 extends kotlin.coroutines.jvm.internal.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C05431(v8.f fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PageFetcherSnapshot.this.doLoad(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$refreshKeyInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.paging.PageFetcherSnapshot", f = "PageFetcherSnapshot.kt", l = {590}, m = "refreshKeyInfo")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u001a\u0010\u0005\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00040\u0003H\u0086@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Key", "Value", "Lv8/f;", "Landroidx/paging/PagingState;", "continuation", "refreshKeyInfo", "(Lv8/f;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    static final class C05441 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C05441(v8.f fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PageFetcherSnapshot.this.refreshKeyInfo(this);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$setLoading$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.paging.PageFetcherSnapshot", f = "PageFetcherSnapshot.kt", l = {TypedValues.PositionType.TYPE_TRANSITION_EASING}, m = "setLoading")
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0082@¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", "Key", "Value", "Landroidx/paging/PageFetcherSnapshotState;", "Landroidx/paging/LoadType;", "loadType", "Lv8/f;", "Lr8/z;", "continuation", "setLoading", "(Landroidx/paging/PageFetcherSnapshotState;Landroidx/paging/LoadType;Lv8/f;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    static final class C05451 extends kotlin.coroutines.jvm.internal.d {
        int label;
        /* synthetic */ Object result;

        C05451(v8.f fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PageFetcherSnapshot.this.setLoading(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$startConsumingHints$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.paging.PageFetcherSnapshot$startConsumingHints$1", f = "PageFetcherSnapshot.kt", l = {222}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Key", "Value", "Lkotlinx/coroutines/l0;", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class C05461 extends l implements p<l0, v8.f<? super z>, Object> {
        int label;

        /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$startConsumingHints$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "androidx.paging.PageFetcherSnapshot$startConsumingHints$1$2", f = "PageFetcherSnapshot.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Key", "Value", "Landroidx/paging/ViewportHint;", "it", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
        static final class AnonymousClass2 extends l implements p<ViewportHint, v8.f<? super z>, Object> {
            int label;

            AnonymousClass2(v8.f fVar) {
                super(2, fVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(Object obj, v8.f<?> completion) {
                m.f(completion, "completion");
                return C05461.this.new AnonymousClass2(completion);
            }

            @Override // c9.p
            public final Object invoke(ViewportHint viewportHint, v8.f<? super z> fVar) {
                return ((AnonymousClass2) create(viewportHint, fVar)).invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                b.c();
                if (this.label == 0) {
                    r.b(obj);
                    PageFetcherSnapshot.this.invalidate.invoke();
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C05461(v8.f fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> completion) {
            m.f(completion, "completion");
            return new C05461(completion);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((C05461) create(l0Var, fVar)).invokeSuspend(z.f17874a);
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
                final u uVar = PageFetcherSnapshot.this.hintSharedFlow;
                f<ViewportHint> fVar = new f<ViewportHint>() { // from class: androidx.paging.PageFetcherSnapshot$startConsumingHints$1$invokeSuspend$$inlined$filter$1

                    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$startConsumingHints$1$invokeSuspend$$inlined$filter$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
                    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/g;", "value", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 1})
                    public static final class AnonymousClass2 implements g<ViewportHint> {
                        final /* synthetic */ g $this_unsafeFlow$inlined;
                        final /* synthetic */ PageFetcherSnapshot$startConsumingHints$1$invokeSuspend$$inlined$filter$1 this$0;

                        /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$startConsumingHints$1$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
                        @kotlin.coroutines.jvm.internal.f(c = "androidx.paging.PageFetcherSnapshot$startConsumingHints$1$invokeSuspend$$inlined$filter$1$2", f = "PageFetcherSnapshot.kt", l = {136}, m = "emit")
                        @Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0006\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "value", "Lv8/f;", "Lr8/z;", "continuation", "", "emit"}, k = 3, mv = {1, 4, 1})
                        public static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
                            Object L$0;
                            Object L$1;
                            Object L$2;
                            Object L$3;
                            Object L$4;
                            Object L$5;
                            Object L$6;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(v8.f fVar) {
                                super(fVar);
                            }

                            @Override // kotlin.coroutines.jvm.internal.a
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(g gVar, PageFetcherSnapshot$startConsumingHints$1$invokeSuspend$$inlined$filter$1 pageFetcherSnapshot$startConsumingHints$1$invokeSuspend$$inlined$filter$1) {
                            this.$this_unsafeFlow$inlined = gVar;
                            this.this$0 = pageFetcherSnapshot$startConsumingHints$1$invokeSuspend$$inlined$filter$1;
                        }

                        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                        @Override // kotlinx.coroutines.flow.g
                        public Object emit(ViewportHint viewportHint, v8.f fVar) {
                            AnonymousClass1 anonymousClass1;
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
                            Object obj = anonymousClass1.result;
                            Object objC = b.c();
                            int i11 = anonymousClass1.label;
                            if (i11 == 0) {
                                r.b(obj);
                                g gVar = this.$this_unsafeFlow$inlined;
                                ViewportHint viewportHint2 = viewportHint;
                                if (!kotlin.coroutines.jvm.internal.b.a(viewportHint2.getPresentedItemsBefore() * (-1) > PageFetcherSnapshot.this.config.jumpThreshold || viewportHint2.getPresentedItemsAfter() * (-1) > PageFetcherSnapshot.this.config.jumpThreshold).booleanValue()) {
                                    return z.f17874a;
                                }
                                anonymousClass1.label = 1;
                                if (gVar.emit(viewportHint, anonymousClass1) == objC) {
                                    return objC;
                                }
                            } else {
                                if (i11 != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                r.b(obj);
                            }
                            return z.f17874a;
                        }
                    }

                    @Override // kotlinx.coroutines.flow.f
                    public Object collect(g<? super ViewportHint> gVar, v8.f fVar2) {
                        Object objCollect = uVar.collect(new AnonymousClass2(gVar, this), fVar2);
                        return objCollect == b.c() ? objCollect : z.f17874a;
                    }
                };
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(null);
                this.label = 1;
                if (h.j(fVar, anonymousClass2, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$startConsumingHints$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.paging.PageFetcherSnapshot$startConsumingHints$2", f = "PageFetcherSnapshot.kt", l = {590, 228}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Key", "Value", "Lkotlinx/coroutines/l0;", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass2 extends l implements p<l0, v8.f<? super z>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        AnonymousClass2(v8.f fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> completion) {
            m.f(completion, "completion");
            return new AnonymousClass2(completion);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((AnonymousClass2) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0061, code lost:
        
            if (r1.collectAsGenerationalViewportHints(r7, r3, r6) == r0) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            PageFetcherSnapshot pageFetcherSnapshot;
            PageFetcherSnapshotState.Holder holder;
            kotlinx.coroutines.sync.a aVar;
            Object objC = b.c();
            int i10 = this.label;
            try {
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 == 2) {
                            r.b(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        pageFetcherSnapshot = (PageFetcherSnapshot) this.L$2;
                        aVar = (kotlinx.coroutines.sync.a) this.L$1;
                        holder = (PageFetcherSnapshotState.Holder) this.L$0;
                        r.b(obj);
                    }
                    return z.f17874a;
                }
                r.b(obj);
                pageFetcherSnapshot = PageFetcherSnapshot.this;
                holder = pageFetcherSnapshot.stateHolder;
                kotlinx.coroutines.sync.a aVar2 = holder.lock;
                this.L$0 = holder;
                this.L$1 = aVar2;
                this.L$2 = pageFetcherSnapshot;
                this.label = 1;
                if (aVar2.a(null, this) != objC) {
                    aVar = aVar2;
                }
                return objC;
                f<Integer> fVarConsumePrependGenerationIdAsFlow = holder.state.consumePrependGenerationIdAsFlow();
                aVar.b(null);
                LoadType loadType = LoadType.PREPEND;
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 2;
            } catch (Throwable th) {
                aVar.b(null);
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$startConsumingHints$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.paging.PageFetcherSnapshot$startConsumingHints$3", f = "PageFetcherSnapshot.kt", l = {590, 233}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Key", "Value", "Lkotlinx/coroutines/l0;", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class C05473 extends l implements p<l0, v8.f<? super z>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        C05473(v8.f fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> completion) {
            m.f(completion, "completion");
            return new C05473(completion);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((C05473) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0061, code lost:
        
            if (r1.collectAsGenerationalViewportHints(r7, r3, r6) == r0) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            PageFetcherSnapshot pageFetcherSnapshot;
            PageFetcherSnapshotState.Holder holder;
            kotlinx.coroutines.sync.a aVar;
            Object objC = b.c();
            int i10 = this.label;
            try {
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 == 2) {
                            r.b(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        pageFetcherSnapshot = (PageFetcherSnapshot) this.L$2;
                        aVar = (kotlinx.coroutines.sync.a) this.L$1;
                        holder = (PageFetcherSnapshotState.Holder) this.L$0;
                        r.b(obj);
                    }
                    return z.f17874a;
                }
                r.b(obj);
                pageFetcherSnapshot = PageFetcherSnapshot.this;
                holder = pageFetcherSnapshot.stateHolder;
                kotlinx.coroutines.sync.a aVar2 = holder.lock;
                this.L$0 = holder;
                this.L$1 = aVar2;
                this.L$2 = pageFetcherSnapshot;
                this.label = 1;
                if (aVar2.a(null, this) != objC) {
                    aVar = aVar2;
                }
                return objC;
                f<Integer> fVarConsumeAppendGenerationIdAsFlow = holder.state.consumeAppendGenerationIdAsFlow();
                aVar.b(null);
                LoadType loadType = LoadType.APPEND;
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 2;
            } catch (Throwable th) {
                aVar.b(null);
                throw th;
            }
        }
    }

    public PageFetcherSnapshot(Key key, PagingSource<Key, Value> pagingSource, PagingConfig config, f<z> retryFlow, boolean z10, RemoteMediatorConnection<Key, Value> remoteMediatorConnection, c9.a<z> invalidate) {
        m.f(pagingSource, "pagingSource");
        m.f(config, "config");
        m.f(retryFlow, "retryFlow");
        m.f(invalidate, "invalidate");
        this.initialKey = key;
        this.pagingSource = pagingSource;
        this.config = config;
        this.retryFlow = retryFlow;
        this.triggerRemoteRefresh = z10;
        this.remoteMediatorConnection = remoteMediatorConnection;
        this.invalidate = invalidate;
        if (!(config.jumpThreshold == Integer.MIN_VALUE || pagingSource.getJumpingSupported())) {
            throw new IllegalArgumentException("PagingConfig.jumpThreshold was set, but the associated PagingSource has not marked support for jumps by overriding PagingSource.jumpingSupported to true.");
        }
        this.hintSharedFlow = b0.b(1, 0, null, 6, null);
        this.pageEventChCollected = new AtomicBoolean(false);
        this.pageEventCh = kotlinx.coroutines.channels.g.b(-2, null, null, 6, null);
        this.stateHolder = new PageFetcherSnapshotState.Holder<>(config);
        kotlinx.coroutines.z zVarB = a2.b(null, 1, null);
        this.pageEventChannelFlowJob = zVarB;
        this.pageEventFlow = CancelableChannelFlowKt.cancelableChannelFlow(zVarB, new PageFetcherSnapshot$pageEventFlow$1(this, null));
    }

    /* JADX WARN: Code duplicated, block: B:135:0x044d A[PHI: r0 r6 r7 r9 r10 r11 r12 r13
      0x044d: PHI (r0v65 kotlin.jvm.internal.y) = (r0v69 kotlin.jvm.internal.y), (r0v70 kotlin.jvm.internal.y) binds: [B:134:0x044a, B:140:0x0458] A[DONT_GENERATE, DONT_INLINE]
      0x044d: PHI (r6v35 androidx.paging.PagingSource$LoadResult) = (r6v37 androidx.paging.PagingSource$LoadResult), (r6v39 androidx.paging.PagingSource$LoadResult) binds: [B:134:0x044a, B:140:0x0458] A[DONT_GENERATE, DONT_INLINE]
      0x044d: PHI (r7v36 androidx.paging.PagingSource$LoadParams<Key>) = (r7v38 androidx.paging.PagingSource$LoadParams<Key>), (r7v39 androidx.paging.PagingSource$LoadParams<Key>) binds: [B:134:0x044a, B:140:0x0458] A[DONT_GENERATE, DONT_INLINE]
      0x044d: PHI (r9v26 ??) = (r9v28 ??), (r9v35 ??) binds: [B:134:0x044a, B:140:0x0458] A[DONT_GENERATE, DONT_INLINE]
      0x044d: PHI (r10v50 kotlin.jvm.internal.b0) = (r10v52 kotlin.jvm.internal.b0), (r10v54 kotlin.jvm.internal.b0) binds: [B:134:0x044a, B:140:0x0458] A[DONT_GENERATE, DONT_INLINE]
      0x044d: PHI (r11v33 kotlin.jvm.internal.z) = (r11v35 kotlin.jvm.internal.z), (r11v36 kotlin.jvm.internal.z) binds: [B:134:0x044a, B:140:0x0458] A[DONT_GENERATE, DONT_INLINE]
      0x044d: PHI (r12v44 androidx.paging.GenerationalViewportHint) = (r12v46 androidx.paging.GenerationalViewportHint), (r12v47 androidx.paging.GenerationalViewportHint) binds: [B:134:0x044a, B:140:0x0458] A[DONT_GENERATE, DONT_INLINE]
      0x044d: PHI (r13v30 androidx.paging.LoadType) = (r13v32 androidx.paging.LoadType), (r13v33 androidx.paging.LoadType) binds: [B:134:0x044a, B:140:0x0458] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:139:0x0456  */
    /* JADX WARN: Code duplicated, block: B:141:0x045a  */
    /* JADX WARN: Code duplicated, block: B:144:0x047a  */
    /* JADX WARN: Code duplicated, block: B:147:0x0492 A[Catch: all -> 0x04b8, TRY_LEAVE, TryCatch #4 {all -> 0x04b8, blocks: (B:145:0x047d, B:147:0x0492), top: B:239:0x047d }] */
    /* JADX WARN: Code duplicated, block: B:150:0x04b2  */
    /* JADX WARN: Code duplicated, block: B:154:0x04bc  */
    /* JADX WARN: Code duplicated, block: B:162:0x04e0  */
    /* JADX WARN: Code duplicated, block: B:163:0x04e3  */
    /* JADX WARN: Code duplicated, block: B:167:0x0510  */
    /* JADX WARN: Code duplicated, block: B:170:0x0529 A[Catch: all -> 0x0563, TRY_LEAVE, TryCatch #1 {all -> 0x0563, blocks: (B:168:0x051b, B:170:0x0529), top: B:234:0x051b }] */
    /* JADX WARN: Code duplicated, block: B:173:0x0551  */
    /* JADX WARN: Code duplicated, block: B:180:0x057d A[Catch: all -> 0x008f, TryCatch #8 {all -> 0x008f, blocks: (B:174:0x055a, B:178:0x056a, B:180:0x057d, B:182:0x0589, B:184:0x058d, B:186:0x059a, B:185:0x0594, B:187:0x059d, B:191:0x05d1, B:14:0x0083, B:19:0x00bb), top: B:247:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:184:0x058d A[Catch: all -> 0x008f, TryCatch #8 {all -> 0x008f, blocks: (B:174:0x055a, B:178:0x056a, B:180:0x057d, B:182:0x0589, B:184:0x058d, B:186:0x059a, B:185:0x0594, B:187:0x059d, B:191:0x05d1, B:14:0x0083, B:19:0x00bb), top: B:247:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:185:0x0594 A[Catch: all -> 0x008f, TryCatch #8 {all -> 0x008f, blocks: (B:174:0x055a, B:178:0x056a, B:180:0x057d, B:182:0x0589, B:184:0x058d, B:186:0x059a, B:185:0x0594, B:187:0x059d, B:191:0x05d1, B:14:0x0083, B:19:0x00bb), top: B:247:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:189:0x05c7  */
    /* JADX WARN: Code duplicated, block: B:190:0x05c8  */
    /* JADX WARN: Code duplicated, block: B:194:0x05db  */
    /* JADX WARN: Code duplicated, block: B:197:0x05e6  */
    /* JADX WARN: Code duplicated, block: B:200:0x05eb  */
    /* JADX WARN: Code duplicated, block: B:203:0x05f5  */
    /* JADX WARN: Code duplicated, block: B:206:0x05fa A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code duplicated, block: B:86:0x0332  */
    /* JADX WARN: Code duplicated, block: B:89:0x0356  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v67 */
    /* JADX WARN: Type inference failed for: r0v73 */
    /* JADX WARN: Type inference failed for: r10v39 */
    /* JADX WARN: Type inference failed for: r10v43, types: [androidx.paging.PageFetcherSnapshot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v46 */
    /* JADX WARN: Type inference failed for: r10v59 */
    /* JADX WARN: Type inference failed for: r10v61, types: [androidx.paging.PageFetcherSnapshot] */
    /* JADX WARN: Type inference failed for: r10v65 */
    /* JADX WARN: Type inference failed for: r10v66 */
    /* JADX WARN: Type inference failed for: r12v49, types: [androidx.paging.PageFetcherSnapshot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v51 */
    /* JADX WARN: Type inference failed for: r12v55 */
    /* JADX WARN: Type inference failed for: r13v10, types: [T] */
    /* JADX WARN: Type inference failed for: r13v40 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v25 */
    /* JADX WARN: Type inference failed for: r1v10, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r5v38, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r5v42, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v43 */
    /* JADX WARN: Type inference failed for: r5v45 */
    /* JADX WARN: Type inference failed for: r5v48 */
    /* JADX WARN: Type inference failed for: r5v49 */
    /* JADX WARN: Type inference failed for: r5v64 */
    /* JADX WARN: Type inference failed for: r5v72 */
    /* JADX WARN: Type inference failed for: r5v73 */
    /* JADX WARN: Type inference failed for: r5v74 */
    /* JADX WARN: Type inference failed for: r5v75 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v22, types: [androidx.paging.PageFetcherSnapshot] */
    /* JADX WARN: Type inference failed for: r9v23, types: [androidx.paging.PageFetcherSnapshot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25, types: [androidx.paging.PageFetcherSnapshot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v26, types: [androidx.paging.PageFetcherSnapshot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v28 */
    /* JADX WARN: Type inference failed for: r9v29, types: [androidx.paging.PageFetcherSnapshot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v32 */
    /* JADX WARN: Type inference failed for: r9v35 */
    /* JADX WARN: Type inference failed for: r9v36 */
    /* JADX WARN: Type inference failed for: r9v37 */
    /* JADX WARN: Type inference failed for: r9v38 */
    /* JADX WARN: Type inference failed for: r9v39 */
    /* JADX WARN: Type inference failed for: r9v40 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:205:0x05f8 -> B:217:0x0645). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:207:0x05fc -> B:217:0x0645). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:209:0x0623 -> B:245:0x0626). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    final /* synthetic */ java.lang.Object doLoad(androidx.paging.LoadType r19, androidx.paging.GenerationalViewportHint r20, v8.f<? super r8.z> r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1670
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot.doLoad(androidx.paging.LoadType, androidx.paging.GenerationalViewportHint, v8.f):java.lang.Object");
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;

        static {
            int[] iArr = new int[LoadType.values().length];
            $EnumSwitchMapping$0 = iArr;
            LoadType loadType = LoadType.REFRESH;
            iArr[loadType.ordinal()] = 1;
            int[] iArr2 = new int[LoadType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[loadType.ordinal()] = 1;
            int[] iArr3 = new int[LoadType.values().length];
            $EnumSwitchMapping$2 = iArr3;
            LoadType loadType2 = LoadType.PREPEND;
            iArr3[loadType2.ordinal()] = 1;
            LoadType loadType3 = LoadType.APPEND;
            iArr3[loadType3.ordinal()] = 2;
            iArr3[loadType.ordinal()] = 3;
            int[] iArr4 = new int[LoadType.values().length];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[loadType2.ordinal()] = 1;
            iArr4[loadType3.ordinal()] = 2;
            int[] iArr5 = new int[LoadType.values().length];
            $EnumSwitchMapping$4 = iArr5;
            iArr5[loadType2.ordinal()] = 1;
        }
    }

    private final PagingSource.LoadParams<Key> loadParams(LoadType loadType, Key key) {
        return PagingSource.LoadParams.INSTANCE.create(loadType, key, loadType == LoadType.REFRESH ? this.config.initialLoadSize : this.config.pageSize, this.config.enablePlaceholders);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startConsumingHints(l0 l0Var) {
        if (this.config.jumpThreshold != Integer.MIN_VALUE) {
            j.d(l0Var, null, null, new C05461(null), 3, null);
        }
        j.d(l0Var, null, null, new AnonymousClass2(null), 3, null);
        j.d(l0Var, null, null, new C05473(null), 3, null);
    }

    public final void accessHint(ViewportHint viewportHint) {
        m.f(viewportHint, "viewportHint");
        if (viewportHint instanceof ViewportHint.Access) {
            this.lastHint = (ViewportHint.Access) viewportHint;
        }
        this.hintSharedFlow.a(viewportHint);
    }

    public final void close() {
        u1.a.a(this.pageEventChannelFlowJob, null, 1, null);
    }

    final /* synthetic */ Object collectAsGenerationalViewportHints(f<Integer> fVar, final LoadType loadType, v8.f<? super z> fVar2) {
        Object objCollect = h.k(h.F(h.H(fVar, new PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$flatMapLatest$1(null, this, loadType)), new AnonymousClass3(loadType, null))).collect(new g<GenerationalViewportHint>() { // from class: androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$collect$1
            @Override // kotlinx.coroutines.flow.g
            public Object emit(GenerationalViewportHint generationalViewportHint, v8.f fVar3) throws Throwable {
                Object objDoLoad = this.this$0.doLoad(loadType, generationalViewportHint, fVar3);
                return objDoLoad == b.c() ? objDoLoad : z.f17874a;
            }
        }, fVar2);
        return objCollect == b.c() ? objCollect : z.f17874a;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x027a  */
    /* JADX WARN: Code duplicated, block: B:107:0x027e  */
    /* JADX WARN: Code duplicated, block: B:112:0x02ae A[Catch: all -> 0x02c8, TRY_LEAVE, TryCatch #3 {all -> 0x02c8, blocks: (B:110:0x0297, B:112:0x02ae), top: B:132:0x0297 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x0155 A[EXC_TOP_SPLITTER, PHI: r2 r5 r6 r7
      0x0155: PHI (r2v19 kotlinx.coroutines.sync.a) = (r2v16 kotlinx.coroutines.sync.a), (r2v22 kotlinx.coroutines.sync.a) binds: [B:50:0x0151, B:26:0x00a4] A[DONT_GENERATE, DONT_INLINE]
      0x0155: PHI (r5v11 androidx.paging.PageFetcherSnapshotState$Holder<Key, Value>) = 
      (r5v10 androidx.paging.PageFetcherSnapshotState$Holder<Key, Value>)
      (r5v15 androidx.paging.PageFetcherSnapshotState$Holder<Key, Value>)
     binds: [B:50:0x0151, B:26:0x00a4] A[DONT_GENERATE, DONT_INLINE]
      0x0155: PHI (r6v7 androidx.paging.PagingSource$LoadResult) = (r6v6 androidx.paging.PagingSource$LoadResult), (r6v9 androidx.paging.PagingSource$LoadResult) binds: [B:50:0x0151, B:26:0x00a4] A[DONT_GENERATE, DONT_INLINE]
      0x0155: PHI (r7v4 androidx.paging.PageFetcherSnapshot) = (r7v2 androidx.paging.PageFetcherSnapshot), (r7v6 androidx.paging.PageFetcherSnapshot) binds: [B:50:0x0151, B:26:0x00a4] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:132:0x0297 A[EXC_TOP_SPLITTER, PHI: r5 r6 r7 r12
      0x0297: PHI (r5v38 androidx.paging.PageFetcherSnapshotState$Holder<Key, Value>) = 
      (r5v9 androidx.paging.PageFetcherSnapshotState$Holder<Key, Value>)
      (r5v41 androidx.paging.PageFetcherSnapshotState$Holder<Key, Value>)
     binds: [B:108:0x0294, B:17:0x0039] A[DONT_GENERATE, DONT_INLINE]
      0x0297: PHI (r6v18 androidx.paging.PagingSource$LoadResult) = (r6v6 androidx.paging.PagingSource$LoadResult), (r6v23 androidx.paging.PagingSource$LoadResult) binds: [B:108:0x0294, B:17:0x0039] A[DONT_GENERATE, DONT_INLINE]
      0x0297: PHI (r7v13 androidx.paging.PageFetcherSnapshot) = (r7v2 androidx.paging.PageFetcherSnapshot), (r7v16 androidx.paging.PageFetcherSnapshot) binds: [B:108:0x0294, B:17:0x0039] A[DONT_GENERATE, DONT_INLINE]
      0x0297: PHI (r12v39 kotlinx.coroutines.sync.a) = (r12v14 kotlinx.coroutines.sync.a), (r12v41 kotlinx.coroutines.sync.a) binds: [B:108:0x0294, B:17:0x0039] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:134:0x0188 A[EXC_TOP_SPLITTER, PHI: r2 r3 r5 r6 r7
      0x0188: PHI (r2v23 boolean) = (r2v20 boolean), (r2v27 boolean) binds: [B:54:0x0184, B:25:0x008d] A[DONT_GENERATE, DONT_INLINE]
      0x0188: PHI (r3v2 kotlinx.coroutines.sync.a) = (r3v1 kotlinx.coroutines.sync.a), (r3v6 kotlinx.coroutines.sync.a) binds: [B:54:0x0184, B:25:0x008d] A[DONT_GENERATE, DONT_INLINE]
      0x0188: PHI (r5v16 androidx.paging.PageFetcherSnapshotState$Holder<Key, Value>) = 
      (r5v13 androidx.paging.PageFetcherSnapshotState$Holder<Key, Value>)
      (r5v29 androidx.paging.PageFetcherSnapshotState$Holder<Key, Value>)
     binds: [B:54:0x0184, B:25:0x008d] A[DONT_GENERATE, DONT_INLINE]
      0x0188: PHI (r6v10 androidx.paging.PagingSource$LoadResult) = (r6v7 androidx.paging.PagingSource$LoadResult), (r6v13 androidx.paging.PagingSource$LoadResult) binds: [B:54:0x0184, B:25:0x008d] A[DONT_GENERATE, DONT_INLINE]
      0x0188: PHI (r7v7 androidx.paging.PageFetcherSnapshot) = (r7v4 androidx.paging.PageFetcherSnapshot), (r7v9 androidx.paging.PageFetcherSnapshot) binds: [B:54:0x0184, B:25:0x008d] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x0113  */
    /* JADX WARN: Code duplicated, block: B:41:0x0115  */
    /* JADX WARN: Code duplicated, block: B:46:0x0134  */
    /* JADX WARN: Code duplicated, block: B:49:0x013c  */
    /* JADX WARN: Code duplicated, block: B:58:0x01a0 A[Catch: all -> 0x01aa, TryCatch #4 {all -> 0x01aa, blocks: (B:56:0x0188, B:58:0x01a0, B:61:0x01ad, B:63:0x01b6, B:64:0x01bf), top: B:134:0x0188 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x01b6 A[Catch: all -> 0x01aa, TryCatch #4 {all -> 0x01aa, blocks: (B:56:0x0188, B:58:0x01a0, B:61:0x01ad, B:63:0x01b6, B:64:0x01bf), top: B:134:0x0188 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:70:0x01df  */
    /* JADX WARN: Code duplicated, block: B:73:0x0202  */
    /* JADX WARN: Code duplicated, block: B:74:0x0204  */
    /* JADX WARN: Code duplicated, block: B:79:0x0210  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code duplicated, block: B:82:0x0216  */
    /* JADX WARN: Code duplicated, block: B:84:0x021f  */
    /* JADX WARN: Code duplicated, block: B:89:0x023f  */
    /* JADX WARN: Code duplicated, block: B:93:0x0256  */
    /* JADX WARN: Code duplicated, block: B:96:0x0263  */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x02c5, code lost:
    
        if (r2.b(r7, r0) == r1) goto L114;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r2v2, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r2v33, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v9, types: [kotlinx.coroutines.sync.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final /* synthetic */ Object doInitialLoad(v8.f<? super z> fVar) throws Throwable {
        C05421 c05421;
        PageFetcherSnapshotState.Holder<Key, Value> holder;
        PageFetcherSnapshot pageFetcherSnapshot;
        kotlinx.coroutines.sync.a aVar;
        PageFetcherSnapshotState<Key, Value> pageFetcherSnapshotState;
        LoadType loadType;
        PageFetcherSnapshot pageFetcherSnapshot2;
        PageFetcherSnapshot pageFetcherSnapshot3;
        PagingSource.LoadResult loadResult;
        PageFetcherSnapshotState.Holder<Key, Value> holder2;
        kotlinx.coroutines.sync.a aVar2;
        PageFetcherSnapshotState.Holder<Key, Value> holder3;
        kotlinx.coroutines.sync.a aVar3;
        boolean zBooleanValue;
        PageFetcherSnapshotState.Holder<Key, Value> holder4;
        kotlinx.coroutines.sync.a aVar4;
        PageFetcherSnapshotState pageFetcherSnapshotState2;
        LoadState.NotLoading.Companion companion;
        PagingSource.LoadResult loadResult2;
        PageFetcherSnapshot pageFetcherSnapshot4;
        PageFetcherSnapshotState.Holder<Key, Value> holder5;
        kotlinx.coroutines.sync.a aVar5;
        kotlinx.coroutines.sync.a aVar6;
        PagingSource.LoadResult loadResult3;
        PageFetcherSnapshot pageFetcherSnapshot5;
        d<PageEvent<Value>> dVar;
        PageEvent<Value> pageEvent$paging_common;
        PagingSource.LoadResult.Page page;
        PageFetcherSnapshotState.Holder<Key, Value> holder6;
        kotlinx.coroutines.sync.a aVar7;
        kotlinx.coroutines.sync.a aVar8;
        PageFetcherSnapshot pageFetcherSnapshot6;
        PagingState<Key, Value> pagingStateCurrentPagingState$paging_common;
        PagingSource.LoadResult.Page page2;
        kotlinx.coroutines.sync.a aVar9;
        Throwable th;
        PageFetcherSnapshotState pageFetcherSnapshotState3;
        LoadState.Error error;
        LoadType loadType2;
        if (fVar instanceof C05421) {
            c05421 = (C05421) fVar;
            int i10 = c05421.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c05421.label = i10 - Integer.MIN_VALUE;
            } else {
                c05421 = new C05421(fVar);
            }
        } else {
            c05421 = new C05421(fVar);
        }
        Object objLoad = c05421.result;
        Object objC = b.c();
        ?? r10 = c05421.label;
        try {
            try {
                switch (r10) {
                    case 0:
                        r.b(objLoad);
                        holder = this.stateHolder;
                        kotlinx.coroutines.sync.a aVar10 = ((PageFetcherSnapshotState.Holder) holder).lock;
                        c05421.L$0 = this;
                        c05421.L$1 = holder;
                        c05421.L$2 = aVar10;
                        c05421.label = 1;
                        if (aVar10.a(null, c05421) != objC) {
                            pageFetcherSnapshot = this;
                            aVar = aVar10;
                            pageFetcherSnapshotState = ((PageFetcherSnapshotState.Holder) holder).state;
                            loadType = LoadType.REFRESH;
                            c05421.L$0 = pageFetcherSnapshot;
                            c05421.L$1 = aVar;
                            c05421.L$2 = null;
                            c05421.label = 2;
                            if (pageFetcherSnapshot.setLoading(pageFetcherSnapshotState, loadType, c05421) == objC) {
                                pageFetcherSnapshot2 = pageFetcherSnapshot;
                                r10 = aVar;
                                z zVar = z.f17874a;
                                r10.b(null);
                                PagingSource.LoadParams<Key> loadParams = pageFetcherSnapshot2.loadParams(LoadType.REFRESH, pageFetcherSnapshot2.initialKey);
                                PagingSource<Key, Value> pagingSource = pageFetcherSnapshot2.pagingSource;
                                c05421.L$0 = pageFetcherSnapshot2;
                                c05421.L$1 = null;
                                c05421.label = 3;
                                objLoad = pagingSource.load(loadParams, c05421);
                                if (objLoad != objC) {
                                    pageFetcherSnapshot3 = pageFetcherSnapshot2;
                                    loadResult = (PagingSource.LoadResult) objLoad;
                                    if (loadResult instanceof PagingSource.LoadResult.Page) {
                                        if (loadResult instanceof PagingSource.LoadResult.Error) {
                                            holder2 = pageFetcherSnapshot3.stateHolder;
                                            aVar2 = ((PageFetcherSnapshotState.Holder) holder2).lock;
                                            c05421.L$0 = pageFetcherSnapshot3;
                                            c05421.L$1 = loadResult;
                                            c05421.L$2 = holder2;
                                            c05421.L$3 = aVar2;
                                            c05421.label = 9;
                                            if (aVar2.a(null, c05421) != objC) {
                                                try {
                                                    pageFetcherSnapshotState3 = ((PageFetcherSnapshotState.Holder) holder2).state;
                                                    error = new LoadState.Error(((PagingSource.LoadResult.Error) loadResult).getThrowable());
                                                    loadType2 = LoadType.REFRESH;
                                                    if (pageFetcherSnapshotState3.setSourceLoadState(loadType2, error)) {
                                                        d<PageEvent<Value>> dVar2 = pageFetcherSnapshot3.pageEventCh;
                                                        PageEvent.LoadStateUpdate loadStateUpdate = new PageEvent.LoadStateUpdate(loadType2, false, error);
                                                        c05421.L$0 = aVar2;
                                                        c05421.L$1 = null;
                                                        c05421.L$2 = null;
                                                        c05421.L$3 = null;
                                                        c05421.label = 10;
                                                    }
                                                    aVar9 = aVar2;
                                                    z zVar2 = z.f17874a;
                                                    aVar9.b(null);
                                                } catch (Throwable th2) {
                                                    aVar9 = aVar2;
                                                    th = th2;
                                                    aVar9.b(null);
                                                    throw th;
                                                }
                                            }
                                            break;
                                        }
                                        return z.f17874a;
                                    }
                                    holder3 = pageFetcherSnapshot3.stateHolder;
                                    aVar3 = ((PageFetcherSnapshotState.Holder) holder3).lock;
                                    c05421.L$0 = pageFetcherSnapshot3;
                                    c05421.L$1 = loadResult;
                                    c05421.L$2 = holder3;
                                    c05421.L$3 = aVar3;
                                    c05421.label = 4;
                                    if (aVar3.a(null, c05421) != objC) {
                                        try {
                                            Boolean boolA = kotlin.coroutines.jvm.internal.b.a(((PageFetcherSnapshotState.Holder) holder3).state.insert(0, LoadType.REFRESH, (PagingSource.LoadResult.Page) loadResult));
                                            aVar3.b(null);
                                            zBooleanValue = boolA.booleanValue();
                                            holder4 = pageFetcherSnapshot3.stateHolder;
                                            aVar4 = ((PageFetcherSnapshotState.Holder) holder4).lock;
                                            c05421.L$0 = pageFetcherSnapshot3;
                                            c05421.L$1 = loadResult;
                                            c05421.L$2 = holder4;
                                            c05421.L$3 = aVar4;
                                            c05421.Z$0 = zBooleanValue;
                                            c05421.label = 5;
                                            if (aVar4.a(null, c05421) != objC) {
                                                try {
                                                    pageFetcherSnapshotState2 = ((PageFetcherSnapshotState.Holder) holder4).state;
                                                    LoadType loadType3 = LoadType.REFRESH;
                                                    companion = LoadState.NotLoading.INSTANCE;
                                                    pageFetcherSnapshotState2.setSourceLoadState(loadType3, companion.getIncomplete$paging_common());
                                                    if (((PagingSource.LoadResult.Page) loadResult).getPrevKey() == null) {
                                                        pageFetcherSnapshotState2.setSourceLoadState(LoadType.PREPEND, companion.getComplete$paging_common());
                                                    }
                                                    if (((PagingSource.LoadResult.Page) loadResult).getNextKey() == null) {
                                                        pageFetcherSnapshotState2.setSourceLoadState(LoadType.APPEND, companion.getComplete$paging_common());
                                                    }
                                                    z zVar3 = z.f17874a;
                                                    aVar4.b(null);
                                                    if (zBooleanValue) {
                                                        loadResult2 = loadResult;
                                                        pageFetcherSnapshot4 = pageFetcherSnapshot3;
                                                        if (pageFetcherSnapshot4.remoteMediatorConnection != null) {
                                                            page = (PagingSource.LoadResult.Page) loadResult2;
                                                            if (page.getPrevKey() != null) {
                                                            }
                                                            holder6 = pageFetcherSnapshot4.stateHolder;
                                                            aVar7 = ((PageFetcherSnapshotState.Holder) holder6).lock;
                                                            c05421.L$0 = pageFetcherSnapshot4;
                                                            c05421.L$1 = loadResult2;
                                                            c05421.L$2 = holder6;
                                                            c05421.L$3 = aVar7;
                                                            c05421.label = 8;
                                                            if (aVar7.a(null, c05421) != objC) {
                                                                aVar8 = aVar7;
                                                                pageFetcherSnapshot6 = pageFetcherSnapshot4;
                                                                pagingStateCurrentPagingState$paging_common = ((PageFetcherSnapshotState.Holder) holder6).state.currentPagingState$paging_common(pageFetcherSnapshot6.lastHint);
                                                                aVar8.b(null);
                                                                page2 = (PagingSource.LoadResult.Page) loadResult2;
                                                                if (page2.getPrevKey() == null) {
                                                                    pageFetcherSnapshot6.remoteMediatorConnection.requestLoad(LoadType.PREPEND, pagingStateCurrentPagingState$paging_common);
                                                                }
                                                                if (page2.getNextKey() == null) {
                                                                    pageFetcherSnapshot6.remoteMediatorConnection.requestLoad(LoadType.APPEND, pagingStateCurrentPagingState$paging_common);
                                                                }
                                                            }
                                                        }
                                                        return z.f17874a;
                                                    }
                                                    holder5 = pageFetcherSnapshot3.stateHolder;
                                                    aVar5 = ((PageFetcherSnapshotState.Holder) holder5).lock;
                                                    c05421.L$0 = pageFetcherSnapshot3;
                                                    c05421.L$1 = loadResult;
                                                    c05421.L$2 = holder5;
                                                    c05421.L$3 = aVar5;
                                                    c05421.label = 6;
                                                    if (aVar5.a(null, c05421) != objC) {
                                                        aVar6 = aVar5;
                                                        loadResult3 = loadResult;
                                                        pageFetcherSnapshot5 = pageFetcherSnapshot3;
                                                        PageFetcherSnapshotState pageFetcherSnapshotState4 = ((PageFetcherSnapshotState.Holder) holder5).state;
                                                        dVar = pageFetcherSnapshot5.pageEventCh;
                                                        pageEvent$paging_common = pageFetcherSnapshotState4.toPageEvent$paging_common((PagingSource.LoadResult.Page) loadResult3, LoadType.REFRESH);
                                                        c05421.L$0 = pageFetcherSnapshot5;
                                                        c05421.L$1 = loadResult3;
                                                        c05421.L$2 = aVar6;
                                                        c05421.L$3 = null;
                                                        c05421.label = 7;
                                                        if (dVar.b(pageEvent$paging_common, c05421) != objC) {
                                                            loadResult2 = loadResult3;
                                                            pageFetcherSnapshot4 = pageFetcherSnapshot5;
                                                            r10 = aVar6;
                                                            z zVar4 = z.f17874a;
                                                            r10.b(null);
                                                            if (pageFetcherSnapshot4.remoteMediatorConnection != null) {
                                                                page = (PagingSource.LoadResult.Page) loadResult2;
                                                                if (page.getPrevKey() != null || page.getNextKey() == null) {
                                                                    holder6 = pageFetcherSnapshot4.stateHolder;
                                                                    aVar7 = ((PageFetcherSnapshotState.Holder) holder6).lock;
                                                                    c05421.L$0 = pageFetcherSnapshot4;
                                                                    c05421.L$1 = loadResult2;
                                                                    c05421.L$2 = holder6;
                                                                    c05421.L$3 = aVar7;
                                                                    c05421.label = 8;
                                                                    if (aVar7.a(null, c05421) != objC) {
                                                                        aVar8 = aVar7;
                                                                        pageFetcherSnapshot6 = pageFetcherSnapshot4;
                                                                        try {
                                                                            pagingStateCurrentPagingState$paging_common = ((PageFetcherSnapshotState.Holder) holder6).state.currentPagingState$paging_common(pageFetcherSnapshot6.lastHint);
                                                                            aVar8.b(null);
                                                                            page2 = (PagingSource.LoadResult.Page) loadResult2;
                                                                            if (page2.getPrevKey() == null) {
                                                                                pageFetcherSnapshot6.remoteMediatorConnection.requestLoad(LoadType.PREPEND, pagingStateCurrentPagingState$paging_common);
                                                                            }
                                                                            if (page2.getNextKey() == null) {
                                                                                pageFetcherSnapshot6.remoteMediatorConnection.requestLoad(LoadType.APPEND, pagingStateCurrentPagingState$paging_common);
                                                                            }
                                                                        } catch (Throwable th3) {
                                                                            aVar8.b(null);
                                                                            throw th3;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            return z.f17874a;
                                                        }
                                                    }
                                                } catch (Throwable th4) {
                                                    aVar4.b(null);
                                                    throw th4;
                                                }
                                            }
                                        } catch (Throwable th5) {
                                            aVar3.b(null);
                                            throw th5;
                                        }
                                    }
                                }
                            }
                        }
                        return objC;
                    case 1:
                        kotlinx.coroutines.sync.a aVar11 = (kotlinx.coroutines.sync.a) c05421.L$2;
                        holder = (PageFetcherSnapshotState.Holder) c05421.L$1;
                        pageFetcherSnapshot = (PageFetcherSnapshot) c05421.L$0;
                        r.b(objLoad);
                        aVar = aVar11;
                        pageFetcherSnapshotState = ((PageFetcherSnapshotState.Holder) holder).state;
                        loadType = LoadType.REFRESH;
                        c05421.L$0 = pageFetcherSnapshot;
                        c05421.L$1 = aVar;
                        c05421.L$2 = null;
                        c05421.label = 2;
                        if (pageFetcherSnapshot.setLoading(pageFetcherSnapshotState, loadType, c05421) == objC) {
                            pageFetcherSnapshot2 = pageFetcherSnapshot;
                            r10 = aVar;
                            z zVar5 = z.f17874a;
                            r10.b(null);
                            PagingSource.LoadParams<Key> loadParams2 = pageFetcherSnapshot2.loadParams(LoadType.REFRESH, pageFetcherSnapshot2.initialKey);
                            PagingSource<Key, Value> pagingSource2 = pageFetcherSnapshot2.pagingSource;
                            c05421.L$0 = pageFetcherSnapshot2;
                            c05421.L$1 = null;
                            c05421.label = 3;
                            objLoad = pagingSource2.load(loadParams2, c05421);
                            if (objLoad != objC) {
                                pageFetcherSnapshot3 = pageFetcherSnapshot2;
                                loadResult = (PagingSource.LoadResult) objLoad;
                                if (loadResult instanceof PagingSource.LoadResult.Page) {
                                    if (loadResult instanceof PagingSource.LoadResult.Error) {
                                        holder2 = pageFetcherSnapshot3.stateHolder;
                                        aVar2 = ((PageFetcherSnapshotState.Holder) holder2).lock;
                                        c05421.L$0 = pageFetcherSnapshot3;
                                        c05421.L$1 = loadResult;
                                        c05421.L$2 = holder2;
                                        c05421.L$3 = aVar2;
                                        c05421.label = 9;
                                        if (aVar2.a(null, c05421) != objC) {
                                            pageFetcherSnapshotState3 = ((PageFetcherSnapshotState.Holder) holder2).state;
                                            error = new LoadState.Error(((PagingSource.LoadResult.Error) loadResult).getThrowable());
                                            loadType2 = LoadType.REFRESH;
                                            if (pageFetcherSnapshotState3.setSourceLoadState(loadType2, error)) {
                                                d<PageEvent<Value>> dVar3 = pageFetcherSnapshot3.pageEventCh;
                                                PageEvent.LoadStateUpdate loadStateUpdate2 = new PageEvent.LoadStateUpdate(loadType2, false, error);
                                                c05421.L$0 = aVar2;
                                                c05421.L$1 = null;
                                                c05421.L$2 = null;
                                                c05421.L$3 = null;
                                                c05421.label = 10;
                                            }
                                            aVar9 = aVar2;
                                            z zVar6 = z.f17874a;
                                            aVar9.b(null);
                                        }
                                        break;
                                    }
                                    return z.f17874a;
                                }
                                holder3 = pageFetcherSnapshot3.stateHolder;
                                aVar3 = ((PageFetcherSnapshotState.Holder) holder3).lock;
                                c05421.L$0 = pageFetcherSnapshot3;
                                c05421.L$1 = loadResult;
                                c05421.L$2 = holder3;
                                c05421.L$3 = aVar3;
                                c05421.label = 4;
                                if (aVar3.a(null, c05421) != objC) {
                                    Boolean boolA2 = kotlin.coroutines.jvm.internal.b.a(((PageFetcherSnapshotState.Holder) holder3).state.insert(0, LoadType.REFRESH, (PagingSource.LoadResult.Page) loadResult));
                                    aVar3.b(null);
                                    zBooleanValue = boolA2.booleanValue();
                                    holder4 = pageFetcherSnapshot3.stateHolder;
                                    aVar4 = ((PageFetcherSnapshotState.Holder) holder4).lock;
                                    c05421.L$0 = pageFetcherSnapshot3;
                                    c05421.L$1 = loadResult;
                                    c05421.L$2 = holder4;
                                    c05421.L$3 = aVar4;
                                    c05421.Z$0 = zBooleanValue;
                                    c05421.label = 5;
                                    if (aVar4.a(null, c05421) != objC) {
                                        pageFetcherSnapshotState2 = ((PageFetcherSnapshotState.Holder) holder4).state;
                                        LoadType loadType4 = LoadType.REFRESH;
                                        companion = LoadState.NotLoading.INSTANCE;
                                        pageFetcherSnapshotState2.setSourceLoadState(loadType4, companion.getIncomplete$paging_common());
                                        if (((PagingSource.LoadResult.Page) loadResult).getPrevKey() == null) {
                                            pageFetcherSnapshotState2.setSourceLoadState(LoadType.PREPEND, companion.getComplete$paging_common());
                                        }
                                        if (((PagingSource.LoadResult.Page) loadResult).getNextKey() == null) {
                                            pageFetcherSnapshotState2.setSourceLoadState(LoadType.APPEND, companion.getComplete$paging_common());
                                        }
                                        z zVar7 = z.f17874a;
                                        aVar4.b(null);
                                        if (zBooleanValue) {
                                            loadResult2 = loadResult;
                                            pageFetcherSnapshot4 = pageFetcherSnapshot3;
                                            if (pageFetcherSnapshot4.remoteMediatorConnection != null) {
                                                page = (PagingSource.LoadResult.Page) loadResult2;
                                                if (page.getPrevKey() != null) {
                                                }
                                                holder6 = pageFetcherSnapshot4.stateHolder;
                                                aVar7 = ((PageFetcherSnapshotState.Holder) holder6).lock;
                                                c05421.L$0 = pageFetcherSnapshot4;
                                                c05421.L$1 = loadResult2;
                                                c05421.L$2 = holder6;
                                                c05421.L$3 = aVar7;
                                                c05421.label = 8;
                                                if (aVar7.a(null, c05421) != objC) {
                                                    aVar8 = aVar7;
                                                    pageFetcherSnapshot6 = pageFetcherSnapshot4;
                                                    pagingStateCurrentPagingState$paging_common = ((PageFetcherSnapshotState.Holder) holder6).state.currentPagingState$paging_common(pageFetcherSnapshot6.lastHint);
                                                    aVar8.b(null);
                                                    page2 = (PagingSource.LoadResult.Page) loadResult2;
                                                    if (page2.getPrevKey() == null) {
                                                        pageFetcherSnapshot6.remoteMediatorConnection.requestLoad(LoadType.PREPEND, pagingStateCurrentPagingState$paging_common);
                                                    }
                                                    if (page2.getNextKey() == null) {
                                                        pageFetcherSnapshot6.remoteMediatorConnection.requestLoad(LoadType.APPEND, pagingStateCurrentPagingState$paging_common);
                                                    }
                                                }
                                                break;
                                            }
                                            return z.f17874a;
                                        }
                                        holder5 = pageFetcherSnapshot3.stateHolder;
                                        aVar5 = ((PageFetcherSnapshotState.Holder) holder5).lock;
                                        c05421.L$0 = pageFetcherSnapshot3;
                                        c05421.L$1 = loadResult;
                                        c05421.L$2 = holder5;
                                        c05421.L$3 = aVar5;
                                        c05421.label = 6;
                                        if (aVar5.a(null, c05421) != objC) {
                                            aVar6 = aVar5;
                                            loadResult3 = loadResult;
                                            pageFetcherSnapshot5 = pageFetcherSnapshot3;
                                            PageFetcherSnapshotState pageFetcherSnapshotState5 = ((PageFetcherSnapshotState.Holder) holder5).state;
                                            dVar = pageFetcherSnapshot5.pageEventCh;
                                            pageEvent$paging_common = pageFetcherSnapshotState5.toPageEvent$paging_common((PagingSource.LoadResult.Page) loadResult3, LoadType.REFRESH);
                                            c05421.L$0 = pageFetcherSnapshot5;
                                            c05421.L$1 = loadResult3;
                                            c05421.L$2 = aVar6;
                                            c05421.L$3 = null;
                                            c05421.label = 7;
                                            if (dVar.b(pageEvent$paging_common, c05421) != objC) {
                                                loadResult2 = loadResult3;
                                                pageFetcherSnapshot4 = pageFetcherSnapshot5;
                                                r10 = aVar6;
                                                z zVar8 = z.f17874a;
                                                r10.b(null);
                                                if (pageFetcherSnapshot4.remoteMediatorConnection != null) {
                                                    page = (PagingSource.LoadResult.Page) loadResult2;
                                                    if (page.getPrevKey() != null) {
                                                    }
                                                    holder6 = pageFetcherSnapshot4.stateHolder;
                                                    aVar7 = ((PageFetcherSnapshotState.Holder) holder6).lock;
                                                    c05421.L$0 = pageFetcherSnapshot4;
                                                    c05421.L$1 = loadResult2;
                                                    c05421.L$2 = holder6;
                                                    c05421.L$3 = aVar7;
                                                    c05421.label = 8;
                                                    if (aVar7.a(null, c05421) != objC) {
                                                        aVar8 = aVar7;
                                                        pageFetcherSnapshot6 = pageFetcherSnapshot4;
                                                        pagingStateCurrentPagingState$paging_common = ((PageFetcherSnapshotState.Holder) holder6).state.currentPagingState$paging_common(pageFetcherSnapshot6.lastHint);
                                                        aVar8.b(null);
                                                        page2 = (PagingSource.LoadResult.Page) loadResult2;
                                                        if (page2.getPrevKey() == null) {
                                                            pageFetcherSnapshot6.remoteMediatorConnection.requestLoad(LoadType.PREPEND, pagingStateCurrentPagingState$paging_common);
                                                        }
                                                        if (page2.getNextKey() == null) {
                                                            pageFetcherSnapshot6.remoteMediatorConnection.requestLoad(LoadType.APPEND, pagingStateCurrentPagingState$paging_common);
                                                        }
                                                    }
                                                    break;
                                                }
                                                return z.f17874a;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        return objC;
                    case 2:
                        kotlinx.coroutines.sync.a aVar12 = (kotlinx.coroutines.sync.a) c05421.L$1;
                        pageFetcherSnapshot2 = (PageFetcherSnapshot) c05421.L$0;
                        r.b(objLoad);
                        r10 = aVar12;
                        z zVar9 = z.f17874a;
                        r10.b(null);
                        PagingSource.LoadParams<Key> loadParams3 = pageFetcherSnapshot2.loadParams(LoadType.REFRESH, pageFetcherSnapshot2.initialKey);
                        PagingSource<Key, Value> pagingSource3 = pageFetcherSnapshot2.pagingSource;
                        c05421.L$0 = pageFetcherSnapshot2;
                        c05421.L$1 = null;
                        c05421.label = 3;
                        objLoad = pagingSource3.load(loadParams3, c05421);
                        if (objLoad != objC) {
                            pageFetcherSnapshot3 = pageFetcherSnapshot2;
                            loadResult = (PagingSource.LoadResult) objLoad;
                            if (loadResult instanceof PagingSource.LoadResult.Page) {
                                if (loadResult instanceof PagingSource.LoadResult.Error) {
                                    holder2 = pageFetcherSnapshot3.stateHolder;
                                    aVar2 = ((PageFetcherSnapshotState.Holder) holder2).lock;
                                    c05421.L$0 = pageFetcherSnapshot3;
                                    c05421.L$1 = loadResult;
                                    c05421.L$2 = holder2;
                                    c05421.L$3 = aVar2;
                                    c05421.label = 9;
                                    if (aVar2.a(null, c05421) != objC) {
                                        pageFetcherSnapshotState3 = ((PageFetcherSnapshotState.Holder) holder2).state;
                                        error = new LoadState.Error(((PagingSource.LoadResult.Error) loadResult).getThrowable());
                                        loadType2 = LoadType.REFRESH;
                                        if (pageFetcherSnapshotState3.setSourceLoadState(loadType2, error)) {
                                            d<PageEvent<Value>> dVar4 = pageFetcherSnapshot3.pageEventCh;
                                            PageEvent.LoadStateUpdate loadStateUpdate3 = new PageEvent.LoadStateUpdate(loadType2, false, error);
                                            c05421.L$0 = aVar2;
                                            c05421.L$1 = null;
                                            c05421.L$2 = null;
                                            c05421.L$3 = null;
                                            c05421.label = 10;
                                        }
                                        aVar9 = aVar2;
                                        z zVar10 = z.f17874a;
                                        aVar9.b(null);
                                    }
                                    break;
                                }
                                return z.f17874a;
                            }
                            holder3 = pageFetcherSnapshot3.stateHolder;
                            aVar3 = ((PageFetcherSnapshotState.Holder) holder3).lock;
                            c05421.L$0 = pageFetcherSnapshot3;
                            c05421.L$1 = loadResult;
                            c05421.L$2 = holder3;
                            c05421.L$3 = aVar3;
                            c05421.label = 4;
                            if (aVar3.a(null, c05421) != objC) {
                                Boolean boolA3 = kotlin.coroutines.jvm.internal.b.a(((PageFetcherSnapshotState.Holder) holder3).state.insert(0, LoadType.REFRESH, (PagingSource.LoadResult.Page) loadResult));
                                aVar3.b(null);
                                zBooleanValue = boolA3.booleanValue();
                                holder4 = pageFetcherSnapshot3.stateHolder;
                                aVar4 = ((PageFetcherSnapshotState.Holder) holder4).lock;
                                c05421.L$0 = pageFetcherSnapshot3;
                                c05421.L$1 = loadResult;
                                c05421.L$2 = holder4;
                                c05421.L$3 = aVar4;
                                c05421.Z$0 = zBooleanValue;
                                c05421.label = 5;
                                if (aVar4.a(null, c05421) != objC) {
                                    pageFetcherSnapshotState2 = ((PageFetcherSnapshotState.Holder) holder4).state;
                                    LoadType loadType5 = LoadType.REFRESH;
                                    companion = LoadState.NotLoading.INSTANCE;
                                    pageFetcherSnapshotState2.setSourceLoadState(loadType5, companion.getIncomplete$paging_common());
                                    if (((PagingSource.LoadResult.Page) loadResult).getPrevKey() == null) {
                                        pageFetcherSnapshotState2.setSourceLoadState(LoadType.PREPEND, companion.getComplete$paging_common());
                                    }
                                    if (((PagingSource.LoadResult.Page) loadResult).getNextKey() == null) {
                                        pageFetcherSnapshotState2.setSourceLoadState(LoadType.APPEND, companion.getComplete$paging_common());
                                    }
                                    z zVar11 = z.f17874a;
                                    aVar4.b(null);
                                    if (zBooleanValue) {
                                        loadResult2 = loadResult;
                                        pageFetcherSnapshot4 = pageFetcherSnapshot3;
                                        if (pageFetcherSnapshot4.remoteMediatorConnection != null) {
                                            page = (PagingSource.LoadResult.Page) loadResult2;
                                            if (page.getPrevKey() != null) {
                                            }
                                            holder6 = pageFetcherSnapshot4.stateHolder;
                                            aVar7 = ((PageFetcherSnapshotState.Holder) holder6).lock;
                                            c05421.L$0 = pageFetcherSnapshot4;
                                            c05421.L$1 = loadResult2;
                                            c05421.L$2 = holder6;
                                            c05421.L$3 = aVar7;
                                            c05421.label = 8;
                                            if (aVar7.a(null, c05421) != objC) {
                                                aVar8 = aVar7;
                                                pageFetcherSnapshot6 = pageFetcherSnapshot4;
                                                pagingStateCurrentPagingState$paging_common = ((PageFetcherSnapshotState.Holder) holder6).state.currentPagingState$paging_common(pageFetcherSnapshot6.lastHint);
                                                aVar8.b(null);
                                                page2 = (PagingSource.LoadResult.Page) loadResult2;
                                                if (page2.getPrevKey() == null) {
                                                    pageFetcherSnapshot6.remoteMediatorConnection.requestLoad(LoadType.PREPEND, pagingStateCurrentPagingState$paging_common);
                                                }
                                                if (page2.getNextKey() == null) {
                                                    pageFetcherSnapshot6.remoteMediatorConnection.requestLoad(LoadType.APPEND, pagingStateCurrentPagingState$paging_common);
                                                }
                                            }
                                            break;
                                        }
                                        return z.f17874a;
                                    }
                                    holder5 = pageFetcherSnapshot3.stateHolder;
                                    aVar5 = ((PageFetcherSnapshotState.Holder) holder5).lock;
                                    c05421.L$0 = pageFetcherSnapshot3;
                                    c05421.L$1 = loadResult;
                                    c05421.L$2 = holder5;
                                    c05421.L$3 = aVar5;
                                    c05421.label = 6;
                                    if (aVar5.a(null, c05421) != objC) {
                                        aVar6 = aVar5;
                                        loadResult3 = loadResult;
                                        pageFetcherSnapshot5 = pageFetcherSnapshot3;
                                        PageFetcherSnapshotState pageFetcherSnapshotState6 = ((PageFetcherSnapshotState.Holder) holder5).state;
                                        dVar = pageFetcherSnapshot5.pageEventCh;
                                        pageEvent$paging_common = pageFetcherSnapshotState6.toPageEvent$paging_common((PagingSource.LoadResult.Page) loadResult3, LoadType.REFRESH);
                                        c05421.L$0 = pageFetcherSnapshot5;
                                        c05421.L$1 = loadResult3;
                                        c05421.L$2 = aVar6;
                                        c05421.L$3 = null;
                                        c05421.label = 7;
                                        if (dVar.b(pageEvent$paging_common, c05421) != objC) {
                                            loadResult2 = loadResult3;
                                            pageFetcherSnapshot4 = pageFetcherSnapshot5;
                                            r10 = aVar6;
                                            z zVar12 = z.f17874a;
                                            r10.b(null);
                                            if (pageFetcherSnapshot4.remoteMediatorConnection != null) {
                                                page = (PagingSource.LoadResult.Page) loadResult2;
                                                if (page.getPrevKey() != null) {
                                                }
                                                holder6 = pageFetcherSnapshot4.stateHolder;
                                                aVar7 = ((PageFetcherSnapshotState.Holder) holder6).lock;
                                                c05421.L$0 = pageFetcherSnapshot4;
                                                c05421.L$1 = loadResult2;
                                                c05421.L$2 = holder6;
                                                c05421.L$3 = aVar7;
                                                c05421.label = 8;
                                                if (aVar7.a(null, c05421) != objC) {
                                                    aVar8 = aVar7;
                                                    pageFetcherSnapshot6 = pageFetcherSnapshot4;
                                                    pagingStateCurrentPagingState$paging_common = ((PageFetcherSnapshotState.Holder) holder6).state.currentPagingState$paging_common(pageFetcherSnapshot6.lastHint);
                                                    aVar8.b(null);
                                                    page2 = (PagingSource.LoadResult.Page) loadResult2;
                                                    if (page2.getPrevKey() == null) {
                                                        pageFetcherSnapshot6.remoteMediatorConnection.requestLoad(LoadType.PREPEND, pagingStateCurrentPagingState$paging_common);
                                                    }
                                                    if (page2.getNextKey() == null) {
                                                        pageFetcherSnapshot6.remoteMediatorConnection.requestLoad(LoadType.APPEND, pagingStateCurrentPagingState$paging_common);
                                                    }
                                                }
                                                break;
                                            }
                                            return z.f17874a;
                                        }
                                    }
                                }
                            }
                        }
                        return objC;
                    case 3:
                        PageFetcherSnapshot pageFetcherSnapshot7 = (PageFetcherSnapshot) c05421.L$0;
                        r.b(objLoad);
                        pageFetcherSnapshot3 = pageFetcherSnapshot7;
                        loadResult = (PagingSource.LoadResult) objLoad;
                        if (loadResult instanceof PagingSource.LoadResult.Page) {
                            if (loadResult instanceof PagingSource.LoadResult.Error) {
                                holder2 = pageFetcherSnapshot3.stateHolder;
                                aVar2 = ((PageFetcherSnapshotState.Holder) holder2).lock;
                                c05421.L$0 = pageFetcherSnapshot3;
                                c05421.L$1 = loadResult;
                                c05421.L$2 = holder2;
                                c05421.L$3 = aVar2;
                                c05421.label = 9;
                                if (aVar2.a(null, c05421) != objC) {
                                    pageFetcherSnapshotState3 = ((PageFetcherSnapshotState.Holder) holder2).state;
                                    error = new LoadState.Error(((PagingSource.LoadResult.Error) loadResult).getThrowable());
                                    loadType2 = LoadType.REFRESH;
                                    if (pageFetcherSnapshotState3.setSourceLoadState(loadType2, error)) {
                                        d<PageEvent<Value>> dVar5 = pageFetcherSnapshot3.pageEventCh;
                                        PageEvent.LoadStateUpdate loadStateUpdate4 = new PageEvent.LoadStateUpdate(loadType2, false, error);
                                        c05421.L$0 = aVar2;
                                        c05421.L$1 = null;
                                        c05421.L$2 = null;
                                        c05421.L$3 = null;
                                        c05421.label = 10;
                                    }
                                    aVar9 = aVar2;
                                    z zVar13 = z.f17874a;
                                    aVar9.b(null);
                                }
                                break;
                            }
                            return z.f17874a;
                        }
                        holder3 = pageFetcherSnapshot3.stateHolder;
                        aVar3 = ((PageFetcherSnapshotState.Holder) holder3).lock;
                        c05421.L$0 = pageFetcherSnapshot3;
                        c05421.L$1 = loadResult;
                        c05421.L$2 = holder3;
                        c05421.L$3 = aVar3;
                        c05421.label = 4;
                        if (aVar3.a(null, c05421) != objC) {
                            Boolean boolA4 = kotlin.coroutines.jvm.internal.b.a(((PageFetcherSnapshotState.Holder) holder3).state.insert(0, LoadType.REFRESH, (PagingSource.LoadResult.Page) loadResult));
                            aVar3.b(null);
                            zBooleanValue = boolA4.booleanValue();
                            holder4 = pageFetcherSnapshot3.stateHolder;
                            aVar4 = ((PageFetcherSnapshotState.Holder) holder4).lock;
                            c05421.L$0 = pageFetcherSnapshot3;
                            c05421.L$1 = loadResult;
                            c05421.L$2 = holder4;
                            c05421.L$3 = aVar4;
                            c05421.Z$0 = zBooleanValue;
                            c05421.label = 5;
                            if (aVar4.a(null, c05421) != objC) {
                                pageFetcherSnapshotState2 = ((PageFetcherSnapshotState.Holder) holder4).state;
                                LoadType loadType6 = LoadType.REFRESH;
                                companion = LoadState.NotLoading.INSTANCE;
                                pageFetcherSnapshotState2.setSourceLoadState(loadType6, companion.getIncomplete$paging_common());
                                if (((PagingSource.LoadResult.Page) loadResult).getPrevKey() == null) {
                                    pageFetcherSnapshotState2.setSourceLoadState(LoadType.PREPEND, companion.getComplete$paging_common());
                                }
                                if (((PagingSource.LoadResult.Page) loadResult).getNextKey() == null) {
                                    pageFetcherSnapshotState2.setSourceLoadState(LoadType.APPEND, companion.getComplete$paging_common());
                                }
                                z zVar14 = z.f17874a;
                                aVar4.b(null);
                                if (zBooleanValue) {
                                    loadResult2 = loadResult;
                                    pageFetcherSnapshot4 = pageFetcherSnapshot3;
                                    if (pageFetcherSnapshot4.remoteMediatorConnection != null) {
                                        page = (PagingSource.LoadResult.Page) loadResult2;
                                        if (page.getPrevKey() != null) {
                                        }
                                        holder6 = pageFetcherSnapshot4.stateHolder;
                                        aVar7 = ((PageFetcherSnapshotState.Holder) holder6).lock;
                                        c05421.L$0 = pageFetcherSnapshot4;
                                        c05421.L$1 = loadResult2;
                                        c05421.L$2 = holder6;
                                        c05421.L$3 = aVar7;
                                        c05421.label = 8;
                                        if (aVar7.a(null, c05421) != objC) {
                                            aVar8 = aVar7;
                                            pageFetcherSnapshot6 = pageFetcherSnapshot4;
                                            pagingStateCurrentPagingState$paging_common = ((PageFetcherSnapshotState.Holder) holder6).state.currentPagingState$paging_common(pageFetcherSnapshot6.lastHint);
                                            aVar8.b(null);
                                            page2 = (PagingSource.LoadResult.Page) loadResult2;
                                            if (page2.getPrevKey() == null) {
                                                pageFetcherSnapshot6.remoteMediatorConnection.requestLoad(LoadType.PREPEND, pagingStateCurrentPagingState$paging_common);
                                            }
                                            if (page2.getNextKey() == null) {
                                                pageFetcherSnapshot6.remoteMediatorConnection.requestLoad(LoadType.APPEND, pagingStateCurrentPagingState$paging_common);
                                            }
                                        }
                                        break;
                                    }
                                    return z.f17874a;
                                }
                                holder5 = pageFetcherSnapshot3.stateHolder;
                                aVar5 = ((PageFetcherSnapshotState.Holder) holder5).lock;
                                c05421.L$0 = pageFetcherSnapshot3;
                                c05421.L$1 = loadResult;
                                c05421.L$2 = holder5;
                                c05421.L$3 = aVar5;
                                c05421.label = 6;
                                if (aVar5.a(null, c05421) != objC) {
                                    aVar6 = aVar5;
                                    loadResult3 = loadResult;
                                    pageFetcherSnapshot5 = pageFetcherSnapshot3;
                                    PageFetcherSnapshotState pageFetcherSnapshotState7 = ((PageFetcherSnapshotState.Holder) holder5).state;
                                    dVar = pageFetcherSnapshot5.pageEventCh;
                                    pageEvent$paging_common = pageFetcherSnapshotState7.toPageEvent$paging_common((PagingSource.LoadResult.Page) loadResult3, LoadType.REFRESH);
                                    c05421.L$0 = pageFetcherSnapshot5;
                                    c05421.L$1 = loadResult3;
                                    c05421.L$2 = aVar6;
                                    c05421.L$3 = null;
                                    c05421.label = 7;
                                    if (dVar.b(pageEvent$paging_common, c05421) != objC) {
                                        loadResult2 = loadResult3;
                                        pageFetcherSnapshot4 = pageFetcherSnapshot5;
                                        r10 = aVar6;
                                        z zVar15 = z.f17874a;
                                        r10.b(null);
                                        if (pageFetcherSnapshot4.remoteMediatorConnection != null) {
                                            page = (PagingSource.LoadResult.Page) loadResult2;
                                            if (page.getPrevKey() != null) {
                                            }
                                            holder6 = pageFetcherSnapshot4.stateHolder;
                                            aVar7 = ((PageFetcherSnapshotState.Holder) holder6).lock;
                                            c05421.L$0 = pageFetcherSnapshot4;
                                            c05421.L$1 = loadResult2;
                                            c05421.L$2 = holder6;
                                            c05421.L$3 = aVar7;
                                            c05421.label = 8;
                                            if (aVar7.a(null, c05421) != objC) {
                                                aVar8 = aVar7;
                                                pageFetcherSnapshot6 = pageFetcherSnapshot4;
                                                pagingStateCurrentPagingState$paging_common = ((PageFetcherSnapshotState.Holder) holder6).state.currentPagingState$paging_common(pageFetcherSnapshot6.lastHint);
                                                aVar8.b(null);
                                                page2 = (PagingSource.LoadResult.Page) loadResult2;
                                                if (page2.getPrevKey() == null) {
                                                    pageFetcherSnapshot6.remoteMediatorConnection.requestLoad(LoadType.PREPEND, pagingStateCurrentPagingState$paging_common);
                                                }
                                                if (page2.getNextKey() == null) {
                                                    pageFetcherSnapshot6.remoteMediatorConnection.requestLoad(LoadType.APPEND, pagingStateCurrentPagingState$paging_common);
                                                }
                                            }
                                            break;
                                        }
                                        return z.f17874a;
                                    }
                                }
                            }
                        }
                        return objC;
                    case 4:
                        aVar3 = (kotlinx.coroutines.sync.a) c05421.L$3;
                        holder3 = (PageFetcherSnapshotState.Holder) c05421.L$2;
                        loadResult = (PagingSource.LoadResult) c05421.L$1;
                        pageFetcherSnapshot3 = (PageFetcherSnapshot) c05421.L$0;
                        r.b(objLoad);
                        Boolean boolA5 = kotlin.coroutines.jvm.internal.b.a(((PageFetcherSnapshotState.Holder) holder3).state.insert(0, LoadType.REFRESH, (PagingSource.LoadResult.Page) loadResult));
                        aVar3.b(null);
                        zBooleanValue = boolA5.booleanValue();
                        holder4 = pageFetcherSnapshot3.stateHolder;
                        aVar4 = ((PageFetcherSnapshotState.Holder) holder4).lock;
                        c05421.L$0 = pageFetcherSnapshot3;
                        c05421.L$1 = loadResult;
                        c05421.L$2 = holder4;
                        c05421.L$3 = aVar4;
                        c05421.Z$0 = zBooleanValue;
                        c05421.label = 5;
                        if (aVar4.a(null, c05421) != objC) {
                            pageFetcherSnapshotState2 = ((PageFetcherSnapshotState.Holder) holder4).state;
                            LoadType loadType7 = LoadType.REFRESH;
                            companion = LoadState.NotLoading.INSTANCE;
                            pageFetcherSnapshotState2.setSourceLoadState(loadType7, companion.getIncomplete$paging_common());
                            if (((PagingSource.LoadResult.Page) loadResult).getPrevKey() == null) {
                                pageFetcherSnapshotState2.setSourceLoadState(LoadType.PREPEND, companion.getComplete$paging_common());
                            }
                            if (((PagingSource.LoadResult.Page) loadResult).getNextKey() == null) {
                                pageFetcherSnapshotState2.setSourceLoadState(LoadType.APPEND, companion.getComplete$paging_common());
                            }
                            z zVar16 = z.f17874a;
                            aVar4.b(null);
                            if (zBooleanValue) {
                                loadResult2 = loadResult;
                                pageFetcherSnapshot4 = pageFetcherSnapshot3;
                                if (pageFetcherSnapshot4.remoteMediatorConnection != null) {
                                    page = (PagingSource.LoadResult.Page) loadResult2;
                                    if (page.getPrevKey() != null) {
                                    }
                                    holder6 = pageFetcherSnapshot4.stateHolder;
                                    aVar7 = ((PageFetcherSnapshotState.Holder) holder6).lock;
                                    c05421.L$0 = pageFetcherSnapshot4;
                                    c05421.L$1 = loadResult2;
                                    c05421.L$2 = holder6;
                                    c05421.L$3 = aVar7;
                                    c05421.label = 8;
                                    if (aVar7.a(null, c05421) != objC) {
                                        aVar8 = aVar7;
                                        pageFetcherSnapshot6 = pageFetcherSnapshot4;
                                        pagingStateCurrentPagingState$paging_common = ((PageFetcherSnapshotState.Holder) holder6).state.currentPagingState$paging_common(pageFetcherSnapshot6.lastHint);
                                        aVar8.b(null);
                                        page2 = (PagingSource.LoadResult.Page) loadResult2;
                                        if (page2.getPrevKey() == null) {
                                            pageFetcherSnapshot6.remoteMediatorConnection.requestLoad(LoadType.PREPEND, pagingStateCurrentPagingState$paging_common);
                                        }
                                        if (page2.getNextKey() == null) {
                                            pageFetcherSnapshot6.remoteMediatorConnection.requestLoad(LoadType.APPEND, pagingStateCurrentPagingState$paging_common);
                                        }
                                    }
                                    break;
                                }
                                return z.f17874a;
                            }
                            holder5 = pageFetcherSnapshot3.stateHolder;
                            aVar5 = ((PageFetcherSnapshotState.Holder) holder5).lock;
                            c05421.L$0 = pageFetcherSnapshot3;
                            c05421.L$1 = loadResult;
                            c05421.L$2 = holder5;
                            c05421.L$3 = aVar5;
                            c05421.label = 6;
                            if (aVar5.a(null, c05421) != objC) {
                                aVar6 = aVar5;
                                loadResult3 = loadResult;
                                pageFetcherSnapshot5 = pageFetcherSnapshot3;
                                PageFetcherSnapshotState pageFetcherSnapshotState8 = ((PageFetcherSnapshotState.Holder) holder5).state;
                                dVar = pageFetcherSnapshot5.pageEventCh;
                                pageEvent$paging_common = pageFetcherSnapshotState8.toPageEvent$paging_common((PagingSource.LoadResult.Page) loadResult3, LoadType.REFRESH);
                                c05421.L$0 = pageFetcherSnapshot5;
                                c05421.L$1 = loadResult3;
                                c05421.L$2 = aVar6;
                                c05421.L$3 = null;
                                c05421.label = 7;
                                if (dVar.b(pageEvent$paging_common, c05421) != objC) {
                                    loadResult2 = loadResult3;
                                    pageFetcherSnapshot4 = pageFetcherSnapshot5;
                                    r10 = aVar6;
                                    z zVar17 = z.f17874a;
                                    r10.b(null);
                                    if (pageFetcherSnapshot4.remoteMediatorConnection != null) {
                                        page = (PagingSource.LoadResult.Page) loadResult2;
                                        if (page.getPrevKey() != null) {
                                        }
                                        holder6 = pageFetcherSnapshot4.stateHolder;
                                        aVar7 = ((PageFetcherSnapshotState.Holder) holder6).lock;
                                        c05421.L$0 = pageFetcherSnapshot4;
                                        c05421.L$1 = loadResult2;
                                        c05421.L$2 = holder6;
                                        c05421.L$3 = aVar7;
                                        c05421.label = 8;
                                        if (aVar7.a(null, c05421) != objC) {
                                            aVar8 = aVar7;
                                            pageFetcherSnapshot6 = pageFetcherSnapshot4;
                                            pagingStateCurrentPagingState$paging_common = ((PageFetcherSnapshotState.Holder) holder6).state.currentPagingState$paging_common(pageFetcherSnapshot6.lastHint);
                                            aVar8.b(null);
                                            page2 = (PagingSource.LoadResult.Page) loadResult2;
                                            if (page2.getPrevKey() == null) {
                                                pageFetcherSnapshot6.remoteMediatorConnection.requestLoad(LoadType.PREPEND, pagingStateCurrentPagingState$paging_common);
                                            }
                                            if (page2.getNextKey() == null) {
                                                pageFetcherSnapshot6.remoteMediatorConnection.requestLoad(LoadType.APPEND, pagingStateCurrentPagingState$paging_common);
                                            }
                                        }
                                        break;
                                    }
                                    return z.f17874a;
                                }
                            }
                        }
                        return objC;
                    case 5:
                        zBooleanValue = c05421.Z$0;
                        aVar4 = (kotlinx.coroutines.sync.a) c05421.L$3;
                        holder4 = (PageFetcherSnapshotState.Holder) c05421.L$2;
                        loadResult = (PagingSource.LoadResult) c05421.L$1;
                        pageFetcherSnapshot3 = (PageFetcherSnapshot) c05421.L$0;
                        r.b(objLoad);
                        pageFetcherSnapshotState2 = ((PageFetcherSnapshotState.Holder) holder4).state;
                        LoadType loadType8 = LoadType.REFRESH;
                        companion = LoadState.NotLoading.INSTANCE;
                        pageFetcherSnapshotState2.setSourceLoadState(loadType8, companion.getIncomplete$paging_common());
                        if (((PagingSource.LoadResult.Page) loadResult).getPrevKey() == null) {
                            pageFetcherSnapshotState2.setSourceLoadState(LoadType.PREPEND, companion.getComplete$paging_common());
                        }
                        if (((PagingSource.LoadResult.Page) loadResult).getNextKey() == null) {
                            pageFetcherSnapshotState2.setSourceLoadState(LoadType.APPEND, companion.getComplete$paging_common());
                        }
                        z zVar18 = z.f17874a;
                        aVar4.b(null);
                        if (zBooleanValue) {
                            loadResult2 = loadResult;
                            pageFetcherSnapshot4 = pageFetcherSnapshot3;
                            if (pageFetcherSnapshot4.remoteMediatorConnection != null) {
                                page = (PagingSource.LoadResult.Page) loadResult2;
                                if (page.getPrevKey() != null) {
                                }
                                holder6 = pageFetcherSnapshot4.stateHolder;
                                aVar7 = ((PageFetcherSnapshotState.Holder) holder6).lock;
                                c05421.L$0 = pageFetcherSnapshot4;
                                c05421.L$1 = loadResult2;
                                c05421.L$2 = holder6;
                                c05421.L$3 = aVar7;
                                c05421.label = 8;
                                if (aVar7.a(null, c05421) != objC) {
                                    aVar8 = aVar7;
                                    pageFetcherSnapshot6 = pageFetcherSnapshot4;
                                    pagingStateCurrentPagingState$paging_common = ((PageFetcherSnapshotState.Holder) holder6).state.currentPagingState$paging_common(pageFetcherSnapshot6.lastHint);
                                    aVar8.b(null);
                                    page2 = (PagingSource.LoadResult.Page) loadResult2;
                                    if (page2.getPrevKey() == null) {
                                        pageFetcherSnapshot6.remoteMediatorConnection.requestLoad(LoadType.PREPEND, pagingStateCurrentPagingState$paging_common);
                                    }
                                    if (page2.getNextKey() == null) {
                                        pageFetcherSnapshot6.remoteMediatorConnection.requestLoad(LoadType.APPEND, pagingStateCurrentPagingState$paging_common);
                                    }
                                }
                                break;
                            }
                            return z.f17874a;
                        }
                        holder5 = pageFetcherSnapshot3.stateHolder;
                        aVar5 = ((PageFetcherSnapshotState.Holder) holder5).lock;
                        c05421.L$0 = pageFetcherSnapshot3;
                        c05421.L$1 = loadResult;
                        c05421.L$2 = holder5;
                        c05421.L$3 = aVar5;
                        c05421.label = 6;
                        if (aVar5.a(null, c05421) != objC) {
                            aVar6 = aVar5;
                            loadResult3 = loadResult;
                            pageFetcherSnapshot5 = pageFetcherSnapshot3;
                            PageFetcherSnapshotState pageFetcherSnapshotState9 = ((PageFetcherSnapshotState.Holder) holder5).state;
                            dVar = pageFetcherSnapshot5.pageEventCh;
                            pageEvent$paging_common = pageFetcherSnapshotState9.toPageEvent$paging_common((PagingSource.LoadResult.Page) loadResult3, LoadType.REFRESH);
                            c05421.L$0 = pageFetcherSnapshot5;
                            c05421.L$1 = loadResult3;
                            c05421.L$2 = aVar6;
                            c05421.L$3 = null;
                            c05421.label = 7;
                            if (dVar.b(pageEvent$paging_common, c05421) != objC) {
                                loadResult2 = loadResult3;
                                pageFetcherSnapshot4 = pageFetcherSnapshot5;
                                r10 = aVar6;
                                z zVar19 = z.f17874a;
                                r10.b(null);
                                if (pageFetcherSnapshot4.remoteMediatorConnection != null) {
                                    page = (PagingSource.LoadResult.Page) loadResult2;
                                    if (page.getPrevKey() != null) {
                                    }
                                    holder6 = pageFetcherSnapshot4.stateHolder;
                                    aVar7 = ((PageFetcherSnapshotState.Holder) holder6).lock;
                                    c05421.L$0 = pageFetcherSnapshot4;
                                    c05421.L$1 = loadResult2;
                                    c05421.L$2 = holder6;
                                    c05421.L$3 = aVar7;
                                    c05421.label = 8;
                                    if (aVar7.a(null, c05421) != objC) {
                                        aVar8 = aVar7;
                                        pageFetcherSnapshot6 = pageFetcherSnapshot4;
                                        pagingStateCurrentPagingState$paging_common = ((PageFetcherSnapshotState.Holder) holder6).state.currentPagingState$paging_common(pageFetcherSnapshot6.lastHint);
                                        aVar8.b(null);
                                        page2 = (PagingSource.LoadResult.Page) loadResult2;
                                        if (page2.getPrevKey() == null) {
                                            pageFetcherSnapshot6.remoteMediatorConnection.requestLoad(LoadType.PREPEND, pagingStateCurrentPagingState$paging_common);
                                        }
                                        if (page2.getNextKey() == null) {
                                            pageFetcherSnapshot6.remoteMediatorConnection.requestLoad(LoadType.APPEND, pagingStateCurrentPagingState$paging_common);
                                        }
                                    }
                                    break;
                                }
                                return z.f17874a;
                            }
                        }
                        return objC;
                    case 6:
                        kotlinx.coroutines.sync.a aVar13 = (kotlinx.coroutines.sync.a) c05421.L$3;
                        holder5 = (PageFetcherSnapshotState.Holder) c05421.L$2;
                        loadResult3 = (PagingSource.LoadResult) c05421.L$1;
                        pageFetcherSnapshot5 = (PageFetcherSnapshot) c05421.L$0;
                        r.b(objLoad);
                        aVar6 = aVar13;
                        PageFetcherSnapshotState pageFetcherSnapshotState10 = ((PageFetcherSnapshotState.Holder) holder5).state;
                        dVar = pageFetcherSnapshot5.pageEventCh;
                        pageEvent$paging_common = pageFetcherSnapshotState10.toPageEvent$paging_common((PagingSource.LoadResult.Page) loadResult3, LoadType.REFRESH);
                        c05421.L$0 = pageFetcherSnapshot5;
                        c05421.L$1 = loadResult3;
                        c05421.L$2 = aVar6;
                        c05421.L$3 = null;
                        c05421.label = 7;
                        if (dVar.b(pageEvent$paging_common, c05421) != objC) {
                            loadResult2 = loadResult3;
                            pageFetcherSnapshot4 = pageFetcherSnapshot5;
                            r10 = aVar6;
                            z zVar110 = z.f17874a;
                            r10.b(null);
                            if (pageFetcherSnapshot4.remoteMediatorConnection != null) {
                                page = (PagingSource.LoadResult.Page) loadResult2;
                                if (page.getPrevKey() != null) {
                                }
                                holder6 = pageFetcherSnapshot4.stateHolder;
                                aVar7 = ((PageFetcherSnapshotState.Holder) holder6).lock;
                                c05421.L$0 = pageFetcherSnapshot4;
                                c05421.L$1 = loadResult2;
                                c05421.L$2 = holder6;
                                c05421.L$3 = aVar7;
                                c05421.label = 8;
                                if (aVar7.a(null, c05421) != objC) {
                                    aVar8 = aVar7;
                                    pageFetcherSnapshot6 = pageFetcherSnapshot4;
                                    pagingStateCurrentPagingState$paging_common = ((PageFetcherSnapshotState.Holder) holder6).state.currentPagingState$paging_common(pageFetcherSnapshot6.lastHint);
                                    aVar8.b(null);
                                    page2 = (PagingSource.LoadResult.Page) loadResult2;
                                    if (page2.getPrevKey() == null) {
                                        pageFetcherSnapshot6.remoteMediatorConnection.requestLoad(LoadType.PREPEND, pagingStateCurrentPagingState$paging_common);
                                    }
                                    if (page2.getNextKey() == null) {
                                        pageFetcherSnapshot6.remoteMediatorConnection.requestLoad(LoadType.APPEND, pagingStateCurrentPagingState$paging_common);
                                    }
                                }
                                break;
                            }
                            return z.f17874a;
                        }
                        return objC;
                    case 7:
                        kotlinx.coroutines.sync.a aVar14 = (kotlinx.coroutines.sync.a) c05421.L$2;
                        loadResult2 = (PagingSource.LoadResult) c05421.L$1;
                        pageFetcherSnapshot4 = (PageFetcherSnapshot) c05421.L$0;
                        r.b(objLoad);
                        r10 = aVar14;
                        z zVar111 = z.f17874a;
                        r10.b(null);
                        if (pageFetcherSnapshot4.remoteMediatorConnection != null) {
                            page = (PagingSource.LoadResult.Page) loadResult2;
                            if (page.getPrevKey() != null) {
                                break;
                            }
                            holder6 = pageFetcherSnapshot4.stateHolder;
                            aVar7 = ((PageFetcherSnapshotState.Holder) holder6).lock;
                            c05421.L$0 = pageFetcherSnapshot4;
                            c05421.L$1 = loadResult2;
                            c05421.L$2 = holder6;
                            c05421.L$3 = aVar7;
                            c05421.label = 8;
                            if (aVar7.a(null, c05421) != objC) {
                                aVar8 = aVar7;
                                pageFetcherSnapshot6 = pageFetcherSnapshot4;
                                pagingStateCurrentPagingState$paging_common = ((PageFetcherSnapshotState.Holder) holder6).state.currentPagingState$paging_common(pageFetcherSnapshot6.lastHint);
                                aVar8.b(null);
                                page2 = (PagingSource.LoadResult.Page) loadResult2;
                                if (page2.getPrevKey() == null) {
                                    pageFetcherSnapshot6.remoteMediatorConnection.requestLoad(LoadType.PREPEND, pagingStateCurrentPagingState$paging_common);
                                }
                                if (page2.getNextKey() == null) {
                                    pageFetcherSnapshot6.remoteMediatorConnection.requestLoad(LoadType.APPEND, pagingStateCurrentPagingState$paging_common);
                                }
                            }
                            return objC;
                        }
                        return z.f17874a;
                    case 8:
                        aVar8 = (kotlinx.coroutines.sync.a) c05421.L$3;
                        holder6 = (PageFetcherSnapshotState.Holder) c05421.L$2;
                        loadResult2 = (PagingSource.LoadResult) c05421.L$1;
                        pageFetcherSnapshot6 = (PageFetcherSnapshot) c05421.L$0;
                        r.b(objLoad);
                        pagingStateCurrentPagingState$paging_common = ((PageFetcherSnapshotState.Holder) holder6).state.currentPagingState$paging_common(pageFetcherSnapshot6.lastHint);
                        aVar8.b(null);
                        page2 = (PagingSource.LoadResult.Page) loadResult2;
                        if (page2.getPrevKey() == null) {
                            pageFetcherSnapshot6.remoteMediatorConnection.requestLoad(LoadType.PREPEND, pagingStateCurrentPagingState$paging_common);
                        }
                        if (page2.getNextKey() == null) {
                            pageFetcherSnapshot6.remoteMediatorConnection.requestLoad(LoadType.APPEND, pagingStateCurrentPagingState$paging_common);
                        }
                        return z.f17874a;
                    case 9:
                        kotlinx.coroutines.sync.a aVar15 = (kotlinx.coroutines.sync.a) c05421.L$3;
                        holder2 = (PageFetcherSnapshotState.Holder) c05421.L$2;
                        loadResult = (PagingSource.LoadResult) c05421.L$1;
                        pageFetcherSnapshot3 = (PageFetcherSnapshot) c05421.L$0;
                        r.b(objLoad);
                        aVar2 = aVar15;
                        pageFetcherSnapshotState3 = ((PageFetcherSnapshotState.Holder) holder2).state;
                        error = new LoadState.Error(((PagingSource.LoadResult.Error) loadResult).getThrowable());
                        loadType2 = LoadType.REFRESH;
                        if (pageFetcherSnapshotState3.setSourceLoadState(loadType2, error)) {
                            d<PageEvent<Value>> dVar6 = pageFetcherSnapshot3.pageEventCh;
                            PageEvent.LoadStateUpdate loadStateUpdate5 = new PageEvent.LoadStateUpdate(loadType2, false, error);
                            c05421.L$0 = aVar2;
                            c05421.L$1 = null;
                            c05421.L$2 = null;
                            c05421.L$3 = null;
                            c05421.label = 10;
                            break;
                        }
                        aVar9 = aVar2;
                        z zVar112 = z.f17874a;
                        aVar9.b(null);
                        return z.f17874a;
                    case 10:
                        aVar9 = (kotlinx.coroutines.sync.a) c05421.L$0;
                        try {
                            r.b(objLoad);
                            z zVar113 = z.f17874a;
                            aVar9.b(null);
                            return z.f17874a;
                        } catch (Throwable th6) {
                            th = th6;
                            aVar9.b(null);
                            throw th;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th7) {
                r10.b(null);
                throw th7;
            }
        } catch (Throwable th8) {
            r10.b(null);
            throw th8;
        }
    }

    public final Key getInitialKey$paging_common() {
        return this.initialKey;
    }

    public final f<PageEvent<Value>> getPageEventFlow() {
        return this.pageEventFlow;
    }

    public final PagingSource<Key, Value> getPagingSource$paging_common() {
        return this.pagingSource;
    }

    public final RemoteMediatorConnection<Key, Value> getRemoteMediatorConnection() {
        return this.remoteMediatorConnection;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object refreshKeyInfo(v8.f<? super PagingState<Key, Value>> fVar) {
        C05441 c05441;
        PageFetcherSnapshotState.Holder<Key, Value> holder;
        PageFetcherSnapshot<Key, Value> pageFetcherSnapshot;
        kotlinx.coroutines.sync.a aVar;
        if (fVar instanceof C05441) {
            c05441 = (C05441) fVar;
            int i10 = c05441.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c05441.label = i10 - Integer.MIN_VALUE;
            } else {
                c05441 = new C05441(fVar);
            }
        } else {
            c05441 = new C05441(fVar);
        }
        Object obj = c05441.result;
        Object objC = b.c();
        int i11 = c05441.label;
        if (i11 == 0) {
            r.b(obj);
            holder = this.stateHolder;
            kotlinx.coroutines.sync.a aVar2 = ((PageFetcherSnapshotState.Holder) holder).lock;
            c05441.L$0 = this;
            c05441.L$1 = holder;
            c05441.L$2 = aVar2;
            c05441.label = 1;
            if (aVar2.a(null, c05441) == objC) {
                return objC;
            }
            pageFetcherSnapshot = this;
            aVar = aVar2;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            aVar = (kotlinx.coroutines.sync.a) c05441.L$2;
            holder = (PageFetcherSnapshotState.Holder) c05441.L$1;
            pageFetcherSnapshot = (PageFetcherSnapshot) c05441.L$0;
            r.b(obj);
        }
        try {
            PageFetcherSnapshotState pageFetcherSnapshotState = ((PageFetcherSnapshotState.Holder) holder).state;
            ViewportHint.Access access = pageFetcherSnapshot.lastHint;
            return (access == null || pageFetcherSnapshotState.getPages$paging_common().isEmpty()) ? null : pageFetcherSnapshotState.currentPagingState$paging_common(access);
        } finally {
            aVar.b(null);
        }
    }

    final /* synthetic */ Object retryLoadError(LoadType loadType, ViewportHint viewportHint, v8.f<? super z> fVar) throws Throwable {
        if (WhenMappings.$EnumSwitchMapping$1[loadType.ordinal()] != 1) {
            if (!(viewportHint != null)) {
                throw new IllegalStateException("Cannot retry APPEND / PREPEND load on PagingSource without ViewportHint");
            }
            this.hintSharedFlow.a(viewportHint);
        } else {
            Object objDoInitialLoad = doInitialLoad(fVar);
            if (objDoInitialLoad == b.c()) {
                return objDoInitialLoad;
            }
        }
        return z.f17874a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    final /* synthetic */ Object setLoading(PageFetcherSnapshotState<Key, Value> pageFetcherSnapshotState, LoadType loadType, v8.f<? super z> fVar) {
        C05451 c05451;
        if (fVar instanceof C05451) {
            c05451 = (C05451) fVar;
            int i10 = c05451.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c05451.label = i10 - Integer.MIN_VALUE;
            } else {
                c05451 = new C05451(fVar);
            }
        } else {
            c05451 = new C05451(fVar);
        }
        Object obj = c05451.result;
        Object objC = b.c();
        int i11 = c05451.label;
        if (i11 == 0) {
            r.b(obj);
            LoadState.Loading loading = LoadState.Loading.INSTANCE;
            if (pageFetcherSnapshotState.setSourceLoadState(loadType, loading)) {
                d<PageEvent<Value>> dVar = this.pageEventCh;
                PageEvent.LoadStateUpdate loadStateUpdate = new PageEvent.LoadStateUpdate(loadType, false, loading);
                c05451.label = 1;
                if (dVar.b(loadStateUpdate, c05451) == objC) {
                    return objC;
                }
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r.b(obj);
        }
        return z.f17874a;
    }

    private final Key nextLoadKeyOrNull(PageFetcherSnapshotState<Key, Value> pageFetcherSnapshotState, LoadType loadType, int i10, int i11) {
        if (i10 != pageFetcherSnapshotState.generationId$paging_common(loadType) || (pageFetcherSnapshotState.getSourceLoadStates().get$paging_common(loadType) instanceof LoadState.Error) || i11 >= this.config.prefetchDistance) {
            return null;
        }
        if (loadType == LoadType.PREPEND) {
            return (Key) ((PagingSource.LoadResult.Page) kotlin.collections.r.g0(pageFetcherSnapshotState.getPages$paging_common())).getPrevKey();
        }
        return (Key) ((PagingSource.LoadResult.Page) kotlin.collections.r.s0(pageFetcherSnapshotState.getPages$paging_common())).getNextKey();
    }

    public /* synthetic */ PageFetcherSnapshot(Object obj, PagingSource pagingSource, PagingConfig pagingConfig, f fVar, boolean z10, RemoteMediatorConnection remoteMediatorConnection, c9.a aVar, int i10, kotlin.jvm.internal.g gVar) {
        this(obj, pagingSource, pagingConfig, fVar, (i10 & 16) != 0 ? false : z10, (i10 & 32) != 0 ? null : remoteMediatorConnection, (i10 & 64) != 0 ? AnonymousClass1.INSTANCE : aVar);
    }
}
