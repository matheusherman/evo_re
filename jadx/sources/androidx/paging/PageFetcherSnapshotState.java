package androidx.paging;

import androidx.annotation.CheckResult;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import c9.l;
import c9.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.channels.d;
import kotlinx.coroutines.flow.g;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.sync.c;
import r8.n;
import r8.r;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import v8.f;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001:\u0001YB\u0011\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u000e¢\u0006\u0004\b\u0011\u0010\u0010J\u001d\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u0019*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00182\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ3\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0018H\u0007¢\u0006\u0004\b\u001f\u0010 J\u001b\u0010$\u001a\u00020#2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010!¢\u0006\u0004\b$\u0010%J%\u0010(\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010!2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J%\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010,2\b\u0010+\u001a\u0004\u0018\u00010*H\u0000¢\u0006\u0004\b-\u0010.R&\u00101\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0018008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R,\u00104\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0018038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b4\u00102\u001a\u0004\b5\u00106R$\u00108\u001a\u00020\n2\u0006\u00107\u001a\u00020\n8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u00109R\u0016\u0010=\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u00109R\u0016\u0010>\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u00109R\u0016\u0010?\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u00109R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020\n0@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020\n0@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010BR&\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020&0D8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR$\u0010J\u001a\u00020I2\u0006\u00107\u001a\u00020I8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010NR\u0014\u0010P\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bO\u0010;R$\u0010U\u001a\u00020\n2\u0006\u0010Q\u001a\u00020\n8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\bR\u0010;\"\u0004\bS\u0010TR$\u0010X\u001a\u00020\n2\u0006\u0010Q\u001a\u00020\n8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\bV\u0010;\"\u0004\bW\u0010T¨\u0006Z"}, d2 = {"Landroidx/paging/PageFetcherSnapshotState;", "", "Key", "Value", "Landroidx/paging/PagingConfig;", "config", "<init>", "(Landroidx/paging/PagingConfig;)V", "Landroidx/paging/LoadType;", "loadType", "", "generationId$paging_common", "(Landroidx/paging/LoadType;)I", "generationId", "Lkotlinx/coroutines/flow/f;", "consumePrependGenerationIdAsFlow", "()Lkotlinx/coroutines/flow/f;", "consumeAppendGenerationIdAsFlow", IjkMediaMeta.IJKM_KEY_TYPE, "Landroidx/paging/LoadState;", "newState", "", "setSourceLoadState", "(Landroidx/paging/LoadType;Landroidx/paging/LoadState;)Z", "Landroidx/paging/PagingSource$LoadResult$Page;", "Landroidx/paging/PageEvent;", "toPageEvent$paging_common", "(Landroidx/paging/PagingSource$LoadResult$Page;Landroidx/paging/LoadType;)Landroidx/paging/PageEvent;", "toPageEvent", "loadId", "page", "insert", "(ILandroidx/paging/LoadType;Landroidx/paging/PagingSource$LoadResult$Page;)Z", "Landroidx/paging/PageEvent$Drop;", NotificationCompat.CATEGORY_EVENT, "Lr8/z;", "drop", "(Landroidx/paging/PageEvent$Drop;)V", "Landroidx/paging/ViewportHint;", "hint", "dropEventOrNull", "(Landroidx/paging/LoadType;Landroidx/paging/ViewportHint;)Landroidx/paging/PageEvent$Drop;", "Landroidx/paging/ViewportHint$Access;", "viewportHint", "Landroidx/paging/PagingState;", "currentPagingState$paging_common", "(Landroidx/paging/ViewportHint$Access;)Landroidx/paging/PagingState;", "currentPagingState", "", "_pages", "Ljava/util/List;", "", "pages", "getPages$paging_common", "()Ljava/util/List;", "<set-?>", "initialPageIndex", "I", "getInitialPageIndex$paging_common", "()I", "_placeholdersBefore", "_placeholdersAfter", "prependGenerationId", "appendGenerationId", "Lkotlinx/coroutines/channels/d;", "prependGenerationIdCh", "Lkotlinx/coroutines/channels/d;", "appendGenerationIdCh", "", "failedHintsByLoadType", "Ljava/util/Map;", "getFailedHintsByLoadType$paging_common", "()Ljava/util/Map;", "Landroidx/paging/LoadStates;", "sourceLoadStates", "Landroidx/paging/LoadStates;", "getSourceLoadStates$paging_common", "()Landroidx/paging/LoadStates;", "Landroidx/paging/PagingConfig;", "getStorageCount$paging_common", "storageCount", "value", "getPlaceholdersBefore$paging_common", "setPlaceholdersBefore$paging_common", "(I)V", "placeholdersBefore", "getPlaceholdersAfter$paging_common", "setPlaceholdersAfter$paging_common", "placeholdersAfter", "Holder", "paging-common"}, k = 1, mv = {1, 4, 1})
public final class PageFetcherSnapshotState<Key, Value> {
    private final List<PagingSource.LoadResult.Page<Key, Value>> _pages;
    private int _placeholdersAfter;
    private int _placeholdersBefore;
    private int appendGenerationId;
    private final d<Integer> appendGenerationIdCh;
    private final PagingConfig config;
    private final Map<LoadType, ViewportHint> failedHintsByLoadType;
    private int initialPageIndex;
    private final List<PagingSource.LoadResult.Page<Key, Value>> pages;
    private int prependGenerationId;
    private final d<Integer> prependGenerationIdCh;
    private LoadStates sourceLoadStates;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u0001*\b\b\u0003\u0010\u0003*\u00020\u00012\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J9\u0010\f\u001a\u00028\u0004\"\u0004\b\u0004\u0010\b2\u001e\u0010\u000b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\n\u0012\u0004\u0012\u00028\u00040\tH\u0086Hø\u0001\u0000¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Landroidx/paging/PageFetcherSnapshotState$Holder;", "", "Key", "Value", "Landroidx/paging/PagingConfig;", "config", "<init>", "(Landroidx/paging/PagingConfig;)V", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Landroidx/paging/PageFetcherSnapshotState;", "block", "withLock", "(Lc9/l;Lv8/f;)Ljava/lang/Object;", "Lkotlinx/coroutines/sync/a;", "lock", "Lkotlinx/coroutines/sync/a;", "state", "Landroidx/paging/PageFetcherSnapshotState;", "Landroidx/paging/PagingConfig;", "paging-common"}, k = 1, mv = {1, 4, 1})
    public static final class Holder<Key, Value> {
        private final PagingConfig config;
        private final kotlinx.coroutines.sync.a lock;
        private final PageFetcherSnapshotState<Key, Value> state;

        public Holder(PagingConfig config) {
            m.f(config, "config");
            this.config = config;
            this.lock = c.b(false, 1, null);
            this.state = new PageFetcherSnapshotState<>(config, null);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        public final <T> Object withLock(l<? super PageFetcherSnapshotState<Key, Value>, ? extends T> lVar, f<? super T> fVar) {
            PageFetcherSnapshotState$Holder$withLock$1 pageFetcherSnapshotState$Holder$withLock$1;
            kotlinx.coroutines.sync.a aVar;
            Holder<Key, Value> holder;
            if (fVar instanceof PageFetcherSnapshotState$Holder$withLock$1) {
                pageFetcherSnapshotState$Holder$withLock$1 = (PageFetcherSnapshotState$Holder$withLock$1) fVar;
                int i10 = pageFetcherSnapshotState$Holder$withLock$1.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    pageFetcherSnapshotState$Holder$withLock$1.label = i10 - Integer.MIN_VALUE;
                } else {
                    pageFetcherSnapshotState$Holder$withLock$1 = new PageFetcherSnapshotState$Holder$withLock$1(this, fVar);
                }
            } else {
                pageFetcherSnapshotState$Holder$withLock$1 = new PageFetcherSnapshotState$Holder$withLock$1(this, fVar);
            }
            Object obj = pageFetcherSnapshotState$Holder$withLock$1.result;
            Object objC = b.c();
            int i11 = pageFetcherSnapshotState$Holder$withLock$1.label;
            if (i11 == 0) {
                r.b(obj);
                aVar = this.lock;
                pageFetcherSnapshotState$Holder$withLock$1.L$0 = this;
                pageFetcherSnapshotState$Holder$withLock$1.L$1 = lVar;
                pageFetcherSnapshotState$Holder$withLock$1.L$2 = aVar;
                pageFetcherSnapshotState$Holder$withLock$1.label = 1;
                if (aVar.a(null, pageFetcherSnapshotState$Holder$withLock$1) == objC) {
                    return objC;
                }
                holder = this;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlinx.coroutines.sync.a aVar2 = (kotlinx.coroutines.sync.a) pageFetcherSnapshotState$Holder$withLock$1.L$2;
                l<? super PageFetcherSnapshotState<Key, Value>, ? extends T> lVar2 = (l) pageFetcherSnapshotState$Holder$withLock$1.L$1;
                holder = (Holder) pageFetcherSnapshotState$Holder$withLock$1.L$0;
                r.b(obj);
                aVar = aVar2;
                lVar = lVar2;
            }
            try {
                return lVar.invoke(holder.state);
            } finally {
                kotlin.jvm.internal.l.b(1);
                aVar.b(null);
                kotlin.jvm.internal.l.a(1);
            }
        }

        private final Object withLock$$forInline(l lVar, f fVar) {
            kotlinx.coroutines.sync.a aVar = this.lock;
            kotlin.jvm.internal.l.c(0);
            aVar.a(null, fVar);
            kotlin.jvm.internal.l.c(2);
            kotlin.jvm.internal.l.c(1);
            try {
                return lVar.invoke(this.state);
            } finally {
                kotlin.jvm.internal.l.b(1);
                aVar.b(null);
                kotlin.jvm.internal.l.a(1);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshotState$consumeAppendGenerationIdAsFlow$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.paging.PageFetcherSnapshotState$consumeAppendGenerationIdAsFlow$1", f = "PageFetcherSnapshotState.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Key", "Value", "Lkotlinx/coroutines/flow/g;", "", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.l implements p<g<? super Integer>, f<? super z>, Object> {
        int label;

        AnonymousClass1(f fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final f<z> create(Object obj, f<?> completion) {
            m.f(completion, "completion");
            return new AnonymousClass1(completion);
        }

        @Override // c9.p
        public final Object invoke(g<? super Integer> gVar, f<? super z> fVar) {
            return ((AnonymousClass1) create(gVar, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.label == 0) {
                r.b(obj);
                PageFetcherSnapshotState.this.appendGenerationIdCh.offer(kotlin.coroutines.jvm.internal.b.b(PageFetcherSnapshotState.this.appendGenerationId));
                return z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshotState$consumePrependGenerationIdAsFlow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.paging.PageFetcherSnapshotState$consumePrependGenerationIdAsFlow$1", f = "PageFetcherSnapshotState.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Key", "Value", "Lkotlinx/coroutines/flow/g;", "", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class C05481 extends kotlin.coroutines.jvm.internal.l implements p<g<? super Integer>, f<? super z>, Object> {
        int label;

        C05481(f fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final f<z> create(Object obj, f<?> completion) {
            m.f(completion, "completion");
            return new C05481(completion);
        }

        @Override // c9.p
        public final Object invoke(g<? super Integer> gVar, f<? super z> fVar) {
            return ((C05481) create(gVar, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.label == 0) {
                r.b(obj);
                PageFetcherSnapshotState.this.prependGenerationIdCh.offer(kotlin.coroutines.jvm.internal.b.b(PageFetcherSnapshotState.this.prependGenerationId));
                return z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private PageFetcherSnapshotState(PagingConfig pagingConfig) {
        this.config = pagingConfig;
        ArrayList arrayList = new ArrayList();
        this._pages = arrayList;
        this.pages = arrayList;
        this.prependGenerationIdCh = kotlinx.coroutines.channels.g.b(-1, null, null, 6, null);
        this.appendGenerationIdCh = kotlinx.coroutines.channels.g.b(-1, null, null, 6, null);
        this.failedHintsByLoadType = new LinkedHashMap();
        this.sourceLoadStates = LoadStates.INSTANCE.getIDLE();
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6;
        public static final /* synthetic */ int[] $EnumSwitchMapping$7;
        public static final /* synthetic */ int[] $EnumSwitchMapping$8;

        static {
            int[] iArr = new int[LoadType.values().length];
            $EnumSwitchMapping$0 = iArr;
            LoadType loadType = LoadType.REFRESH;
            iArr[loadType.ordinal()] = 1;
            LoadType loadType2 = LoadType.PREPEND;
            iArr[loadType2.ordinal()] = 2;
            LoadType loadType3 = LoadType.APPEND;
            iArr[loadType3.ordinal()] = 3;
            int[] iArr2 = new int[LoadType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[loadType.ordinal()] = 1;
            iArr2[loadType2.ordinal()] = 2;
            iArr2[loadType3.ordinal()] = 3;
            int[] iArr3 = new int[LoadType.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[loadType.ordinal()] = 1;
            iArr3[loadType2.ordinal()] = 2;
            iArr3[loadType3.ordinal()] = 3;
            int[] iArr4 = new int[LoadType.values().length];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[loadType.ordinal()] = 1;
            iArr4[loadType2.ordinal()] = 2;
            iArr4[loadType3.ordinal()] = 3;
            int[] iArr5 = new int[LoadType.values().length];
            $EnumSwitchMapping$4 = iArr5;
            iArr5[loadType2.ordinal()] = 1;
            iArr5[loadType3.ordinal()] = 2;
            int[] iArr6 = new int[LoadType.values().length];
            $EnumSwitchMapping$5 = iArr6;
            iArr6[loadType2.ordinal()] = 1;
            int[] iArr7 = new int[LoadType.values().length];
            $EnumSwitchMapping$6 = iArr7;
            iArr7[loadType2.ordinal()] = 1;
            int[] iArr8 = new int[LoadType.values().length];
            $EnumSwitchMapping$7 = iArr8;
            iArr8[loadType2.ordinal()] = 1;
            int[] iArr9 = new int[LoadType.values().length];
            $EnumSwitchMapping$8 = iArr9;
            iArr9[loadType2.ordinal()] = 1;
        }
    }

    public final kotlinx.coroutines.flow.f<Integer> consumeAppendGenerationIdAsFlow() {
        return h.D(h.l(this.appendGenerationIdCh), new AnonymousClass1(null));
    }

    public final kotlinx.coroutines.flow.f<Integer> consumePrependGenerationIdAsFlow() {
        return h.D(h.l(this.prependGenerationIdCh), new C05481(null));
    }

    public final PagingState<Key, Value> currentPagingState$paging_common(ViewportHint.Access viewportHint) {
        Integer numValueOf;
        List listO0 = kotlin.collections.r.O0(this.pages);
        if (viewportHint != null) {
            int placeholdersBefore$paging_common = getPlaceholdersBefore$paging_common();
            int i10 = -this.initialPageIndex;
            int iN = kotlin.collections.r.n(this.pages) - this.initialPageIndex;
            int pageOffset = viewportHint.getPageOffset();
            int i11 = i10;
            while (i11 < pageOffset) {
                placeholdersBefore$paging_common += i11 > iN ? this.config.pageSize : this.pages.get(this.initialPageIndex + i11).getData().size();
                i11++;
            }
            int indexInPage = placeholdersBefore$paging_common + viewportHint.getIndexInPage();
            if (viewportHint.getPageOffset() < i10) {
                indexInPage -= this.config.pageSize;
            }
            numValueOf = Integer.valueOf(indexInPage);
        } else {
            numValueOf = null;
        }
        return new PagingState<>(listO0, numValueOf, this.config, getPlaceholdersBefore$paging_common());
    }

    public final void drop(PageEvent.Drop<Value> event) {
        m.f(event, "event");
        if (!(event.getPageCount() <= this.pages.size())) {
            throw new IllegalStateException(("invalid drop count. have " + this.pages.size() + " but wanted to drop " + event.getPageCount()).toString());
        }
        this.failedHintsByLoadType.remove(event.getLoadType());
        this.sourceLoadStates = this.sourceLoadStates.modifyState$paging_common(event.getLoadType(), LoadState.NotLoading.INSTANCE.getIncomplete$paging_common());
        int i10 = WhenMappings.$EnumSwitchMapping$4[event.getLoadType().ordinal()];
        if (i10 == 1) {
            int pageCount = event.getPageCount();
            for (int i11 = 0; i11 < pageCount; i11++) {
                this._pages.remove(0);
            }
            this.initialPageIndex -= event.getPageCount();
            setPlaceholdersBefore$paging_common(event.getPlaceholdersRemaining());
            int i12 = this.prependGenerationId + 1;
            this.prependGenerationId = i12;
            this.prependGenerationIdCh.offer(Integer.valueOf(i12));
            return;
        }
        if (i10 != 2) {
            throw new IllegalArgumentException("cannot drop " + event.getLoadType());
        }
        int pageCount2 = event.getPageCount();
        for (int i13 = 0; i13 < pageCount2; i13++) {
            this._pages.remove(this.pages.size() - 1);
        }
        setPlaceholdersAfter$paging_common(event.getPlaceholdersRemaining());
        int i14 = this.appendGenerationId + 1;
        this.appendGenerationId = i14;
        this.appendGenerationIdCh.offer(Integer.valueOf(i14));
    }

    public final PageEvent.Drop<Value> dropEventOrNull(LoadType loadType, ViewportHint hint) {
        int iN;
        int i10;
        int size;
        m.f(loadType, "loadType");
        m.f(hint, "hint");
        if (this.config.maxSize == Integer.MAX_VALUE || this.pages.size() <= 2 || getStorageCount$paging_common() <= this.config.maxSize) {
            return null;
        }
        int placeholdersBefore$paging_common = 0;
        if (!(loadType != LoadType.REFRESH)) {
            throw new IllegalArgumentException(("Drop LoadType must be PREPEND or APPEND, but got " + loadType).toString());
        }
        int i11 = 0;
        int i12 = 0;
        while (i11 < this.pages.size() && getStorageCount$paging_common() - i12 > this.config.maxSize) {
            if (WhenMappings.$EnumSwitchMapping$5[loadType.ordinal()] != 1) {
                List<PagingSource.LoadResult.Page<Key, Value>> list = this.pages;
                size = list.get(kotlin.collections.r.n(list) - i11).getData().size();
            } else {
                size = this.pages.get(i11).getData().size();
            }
            if (((WhenMappings.$EnumSwitchMapping$6[loadType.ordinal()] != 1 ? hint.getPresentedItemsAfter() : hint.getPresentedItemsBefore()) - i12) - size < this.config.prefetchDistance) {
                break;
            }
            i12 += size;
            i11++;
        }
        if (i11 == 0) {
            return null;
        }
        int iN2 = WhenMappings.$EnumSwitchMapping$7[loadType.ordinal()] != 1 ? (kotlin.collections.r.n(this.pages) - this.initialPageIndex) - (i11 - 1) : -this.initialPageIndex;
        if (WhenMappings.$EnumSwitchMapping$8[loadType.ordinal()] != 1) {
            iN = kotlin.collections.r.n(this.pages);
            i10 = this.initialPageIndex;
        } else {
            iN = i11 - 1;
            i10 = this.initialPageIndex;
        }
        int i13 = iN - i10;
        if (this.config.enablePlaceholders) {
            placeholdersBefore$paging_common = (loadType == LoadType.PREPEND ? getPlaceholdersBefore$paging_common() : getPlaceholdersAfter$paging_common()) + i12;
        }
        return new PageEvent.Drop<>(loadType, iN2, i13, placeholdersBefore$paging_common);
    }

    public final int generationId$paging_common(LoadType loadType) {
        m.f(loadType, "loadType");
        int i10 = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
        if (i10 == 1) {
            throw new IllegalArgumentException("Cannot get loadId for loadType: REFRESH");
        }
        if (i10 == 2) {
            return this.prependGenerationId;
        }
        if (i10 == 3) {
            return this.appendGenerationId;
        }
        throw new n();
    }

    public final Map<LoadType, ViewportHint> getFailedHintsByLoadType$paging_common() {
        return this.failedHintsByLoadType;
    }

    /* JADX INFO: renamed from: getInitialPageIndex$paging_common, reason: from getter */
    public final int getInitialPageIndex() {
        return this.initialPageIndex;
    }

    public final List<PagingSource.LoadResult.Page<Key, Value>> getPages$paging_common() {
        return this.pages;
    }

    public final int getPlaceholdersAfter$paging_common() {
        if (this.config.enablePlaceholders) {
            return this._placeholdersAfter;
        }
        return 0;
    }

    public final int getPlaceholdersBefore$paging_common() {
        if (this.config.enablePlaceholders) {
            return this._placeholdersBefore;
        }
        return 0;
    }

    /* JADX INFO: renamed from: getSourceLoadStates$paging_common, reason: from getter */
    public final LoadStates getSourceLoadStates() {
        return this.sourceLoadStates;
    }

    public final int getStorageCount$paging_common() {
        Iterator<T> it = this.pages.iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((PagingSource.LoadResult.Page) it.next()).getData().size();
        }
        return size;
    }

    @CheckResult
    public final boolean insert(int loadId, LoadType loadType, PagingSource.LoadResult.Page<Key, Value> page) {
        m.f(loadType, "loadType");
        m.f(page, "page");
        int i10 = WhenMappings.$EnumSwitchMapping$3[loadType.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    if (this.pages.isEmpty()) {
                        throw new IllegalStateException("should've received an init before append");
                    }
                    if (loadId != this.appendGenerationId) {
                        return false;
                    }
                    this._pages.add(page);
                    setPlaceholdersAfter$paging_common(page.getItemsAfter() == Integer.MIN_VALUE ? h9.f.c(getPlaceholdersAfter$paging_common() - page.getData().size(), 0) : page.getItemsAfter());
                    this.failedHintsByLoadType.remove(LoadType.APPEND);
                }
            } else {
                if (this.pages.isEmpty()) {
                    throw new IllegalStateException("should've received an init before prepend");
                }
                if (loadId != this.prependGenerationId) {
                    return false;
                }
                this._pages.add(0, page);
                this.initialPageIndex++;
                setPlaceholdersBefore$paging_common(page.getItemsBefore() == Integer.MIN_VALUE ? h9.f.c(getPlaceholdersBefore$paging_common() - page.getData().size(), 0) : page.getItemsBefore());
                this.failedHintsByLoadType.remove(LoadType.PREPEND);
            }
        } else {
            if (!this.pages.isEmpty()) {
                throw new IllegalStateException("cannot receive multiple init calls");
            }
            if (!(loadId == 0)) {
                throw new IllegalStateException("init loadId must be the initial value, 0");
            }
            this._pages.add(page);
            this.initialPageIndex = 0;
            setPlaceholdersAfter$paging_common(page.getItemsAfter());
            setPlaceholdersBefore$paging_common(page.getItemsBefore());
        }
        return true;
    }

    public final void setPlaceholdersAfter$paging_common(int i10) {
        if (i10 == Integer.MIN_VALUE) {
            i10 = 0;
        }
        this._placeholdersAfter = i10;
    }

    public final void setPlaceholdersBefore$paging_common(int i10) {
        if (i10 == Integer.MIN_VALUE) {
            i10 = 0;
        }
        this._placeholdersBefore = i10;
    }

    public final boolean setSourceLoadState(LoadType type, LoadState newState) {
        m.f(type, "type");
        m.f(newState, "newState");
        if (m.a(this.sourceLoadStates.get$paging_common(type), newState)) {
            return false;
        }
        this.sourceLoadStates = this.sourceLoadStates.modifyState$paging_common(type, newState);
        return true;
    }

    public final PageEvent<Value> toPageEvent$paging_common(PagingSource.LoadResult.Page<Key, Value> toPageEvent, LoadType loadType) {
        m.f(toPageEvent, "$this$toPageEvent");
        m.f(loadType, "loadType");
        int i10 = WhenMappings.$EnumSwitchMapping$1[loadType.ordinal()];
        int size = 0;
        if (i10 != 1) {
            if (i10 == 2) {
                size = 0 - this.initialPageIndex;
            } else {
                if (i10 != 3) {
                    throw new n();
                }
                size = (this.pages.size() - this.initialPageIndex) - 1;
            }
        }
        List listE = kotlin.collections.r.e(new TransformablePage(size, toPageEvent.getData()));
        int i11 = WhenMappings.$EnumSwitchMapping$2[loadType.ordinal()];
        if (i11 == 1) {
            return PageEvent.Insert.INSTANCE.Refresh(listE, getPlaceholdersBefore$paging_common(), getPlaceholdersAfter$paging_common(), new CombinedLoadStates(this.sourceLoadStates.getRefresh(), this.sourceLoadStates.getPrepend(), this.sourceLoadStates.getAppend(), this.sourceLoadStates, null));
        }
        if (i11 == 2) {
            return PageEvent.Insert.INSTANCE.Prepend(listE, getPlaceholdersBefore$paging_common(), new CombinedLoadStates(this.sourceLoadStates.getRefresh(), this.sourceLoadStates.getPrepend(), this.sourceLoadStates.getAppend(), this.sourceLoadStates, null));
        }
        if (i11 == 3) {
            return PageEvent.Insert.INSTANCE.Append(listE, getPlaceholdersAfter$paging_common(), new CombinedLoadStates(this.sourceLoadStates.getRefresh(), this.sourceLoadStates.getPrepend(), this.sourceLoadStates.getAppend(), this.sourceLoadStates, null));
        }
        throw new n();
    }

    public /* synthetic */ PageFetcherSnapshotState(PagingConfig pagingConfig, kotlin.jvm.internal.g gVar) {
        this(pagingConfig);
    }
}
