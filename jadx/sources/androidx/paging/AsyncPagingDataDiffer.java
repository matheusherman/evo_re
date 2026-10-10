package androidx.paging;

import androidx.annotation.IntRange;
import androidx.exifinterface.media.ExifInterface;
import androidx.p000lifecycle.Lifecycle;
import androidx.p000lifecycle.LifecycleKt;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import c9.p;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.flow.f;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import r8.r;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b*\u00013\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B3\b\u0007\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f¢\u0006\u0004\b\u000f\u0010\u0013J\r\u0010\u0014\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0015J\u0019\u0010\u0019\u001a\u0004\u0018\u00018\u00002\b\b\u0001\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001b\u001a\u0004\u0018\u00018\u00002\b\b\u0001\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001b\u0010\u001aJ\u0013\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\"\u001a\u00020\u000e2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u000e0\u001f¢\u0006\u0004\b\"\u0010#J!\u0010$\u001a\u00020\u000e2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u000e0\u001f¢\u0006\u0004\b$\u0010#R \u0010&\u001a\u00020%8\u0000X\u0080\u0004¢\u0006\u0012\n\u0004\b&\u0010'\u0012\u0004\b*\u0010\u0015\u001a\u0004\b(\u0010)R(\u0010,\u001a\u00020+8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0004\b,\u0010-\u0012\u0004\b2\u0010\u0015\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00028\u0000038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00107\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u001d\u0010:\u001a\b\u0012\u0004\u0012\u00020 098\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010>R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010?R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010@R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010@R\u0011\u0010C\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\bA\u0010B\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006D"}, d2 = {"Landroidx/paging/AsyncPagingDataDiffer;", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "diffCallback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "updateCallback", "Lkotlinx/coroutines/i0;", "mainDispatcher", "workerDispatcher", "<init>", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Landroidx/recyclerview/widget/ListUpdateCallback;Lkotlinx/coroutines/i0;Lkotlinx/coroutines/i0;)V", "Landroidx/paging/PagingData;", "pagingData", "Lr8/z;", "submitData", "(Landroidx/paging/PagingData;Lv8/f;)Ljava/lang/Object;", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "(Landroidx/lifecycle/Lifecycle;Landroidx/paging/PagingData;)V", "retry", "()V", "refresh", "", "index", "getItem", "(I)Ljava/lang/Object;", "peek", "Landroidx/paging/ItemSnapshotList;", "snapshot", "()Landroidx/paging/ItemSnapshotList;", "Lkotlin/Function1;", "Landroidx/paging/CombinedLoadStates;", "listener", "addLoadStateListener", "(Lc9/l;)V", "removeLoadStateListener", "Landroidx/paging/DifferCallback;", "differCallback", "Landroidx/paging/DifferCallback;", "getDifferCallback$paging_runtime_release", "()Landroidx/paging/DifferCallback;", "getDifferCallback$paging_runtime_release$annotations", "", "inGetItem", "Z", "getInGetItem$paging_runtime_release", "()Z", "setInGetItem$paging_runtime_release", "(Z)V", "getInGetItem$paging_runtime_release$annotations", "androidx/paging/AsyncPagingDataDiffer$differBase$1", "differBase", "Landroidx/paging/AsyncPagingDataDiffer$differBase$1;", "Ljava/util/concurrent/atomic/AtomicInteger;", "submitDataId", "Ljava/util/concurrent/atomic/AtomicInteger;", "Lkotlinx/coroutines/flow/f;", "loadStateFlow", "Lkotlinx/coroutines/flow/f;", "getLoadStateFlow", "()Lkotlinx/coroutines/flow/f;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "Lkotlinx/coroutines/i0;", "getItemCount", "()I", "itemCount", "paging-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class AsyncPagingDataDiffer<T> {
    private final DiffUtil.ItemCallback<T> diffCallback;
    private final AsyncPagingDataDiffer$differBase$1 differBase;
    private final DifferCallback differCallback;
    private boolean inGetItem;
    private final f<CombinedLoadStates> loadStateFlow;
    private final i0 mainDispatcher;
    private final AtomicInteger submitDataId;
    private final ListUpdateCallback updateCallback;
    private final i0 workerDispatcher;

    /* JADX INFO: renamed from: androidx.paging.AsyncPagingDataDiffer$submitData$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.paging.AsyncPagingDataDiffer$submitData$2", f = "AsyncPagingDataDiffer.kt", l = {159}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/l0;", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass2 extends l implements p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ int $id;
        final /* synthetic */ PagingData $pagingData;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(int i10, PagingData pagingData, v8.f fVar) {
            super(2, fVar);
            this.$id = i10;
            this.$pagingData = pagingData;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> completion) {
            m.f(completion, "completion");
            return new AnonymousClass2(this.$id, this.$pagingData, completion);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((AnonymousClass2) create(l0Var, fVar)).invokeSuspend(z.f17874a);
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
                if (AsyncPagingDataDiffer.this.submitDataId.get() == this.$id) {
                    AsyncPagingDataDiffer$differBase$1 asyncPagingDataDiffer$differBase$1 = AsyncPagingDataDiffer.this.differBase;
                    PagingData<T> pagingData = this.$pagingData;
                    this.label = 1;
                    if (asyncPagingDataDiffer$differBase$1.collectFrom(pagingData, this) == objC) {
                        return objC;
                    }
                }
            }
            return z.f17874a;
        }
    }

    public AsyncPagingDataDiffer(DiffUtil.ItemCallback<T> itemCallback, ListUpdateCallback listUpdateCallback) {
        this(itemCallback, listUpdateCallback, null, null, 12, null);
    }

    public final T getItem(@IntRange(from = 0) int index) {
        try {
            this.inGetItem = true;
            return this.differBase.get(index);
        } finally {
            this.inGetItem = false;
        }
    }

    public final Object submitData(PagingData<T> pagingData, v8.f<? super z> fVar) {
        this.submitDataId.incrementAndGet();
        Object objCollectFrom = this.differBase.collectFrom(pagingData, fVar);
        return objCollectFrom == b.c() ? objCollectFrom : z.f17874a;
    }

    public AsyncPagingDataDiffer(DiffUtil.ItemCallback<T> itemCallback, ListUpdateCallback listUpdateCallback, i0 i0Var) {
        this(itemCallback, listUpdateCallback, i0Var, null, 8, null);
    }

    public final void addLoadStateListener(c9.l<? super CombinedLoadStates, z> listener) {
        m.f(listener, "listener");
        this.differBase.addLoadStateListener(listener);
    }

    /* JADX INFO: renamed from: getDifferCallback$paging_runtime_release, reason: from getter */
    public final DifferCallback getDifferCallback() {
        return this.differCallback;
    }

    /* JADX INFO: renamed from: getInGetItem$paging_runtime_release, reason: from getter */
    public final boolean getInGetItem() {
        return this.inGetItem;
    }

    public final int getItemCount() {
        return this.differBase.getSize();
    }

    public final f<CombinedLoadStates> getLoadStateFlow() {
        return this.loadStateFlow;
    }

    public final T peek(@IntRange(from = 0) int index) {
        return this.differBase.peek(index);
    }

    public final void refresh() {
        this.differBase.refresh();
    }

    public final void removeLoadStateListener(c9.l<? super CombinedLoadStates, z> listener) {
        m.f(listener, "listener");
        this.differBase.removeLoadStateListener(listener);
    }

    public final void retry() {
        this.differBase.retry();
    }

    public final void setInGetItem$paging_runtime_release(boolean z10) {
        this.inGetItem = z10;
    }

    public final ItemSnapshotList<T> snapshot() {
        return this.differBase.snapshot();
    }

    public AsyncPagingDataDiffer(DiffUtil.ItemCallback<T> diffCallback, ListUpdateCallback updateCallback, i0 mainDispatcher, i0 workerDispatcher) {
        m.f(diffCallback, "diffCallback");
        m.f(updateCallback, "updateCallback");
        m.f(mainDispatcher, "mainDispatcher");
        m.f(workerDispatcher, "workerDispatcher");
        this.diffCallback = diffCallback;
        this.updateCallback = updateCallback;
        this.mainDispatcher = mainDispatcher;
        this.workerDispatcher = workerDispatcher;
        DifferCallback differCallback = new DifferCallback() { // from class: androidx.paging.AsyncPagingDataDiffer$differCallback$1
            @Override // androidx.paging.DifferCallback
            public void onChanged(int position, int count) {
                this.this$0.updateCallback.onChanged(position, count, null);
            }

            @Override // androidx.paging.DifferCallback
            public void onInserted(int position, int count) {
                this.this$0.updateCallback.onInserted(position, count);
            }

            @Override // androidx.paging.DifferCallback
            public void onRemoved(int position, int count) {
                this.this$0.updateCallback.onRemoved(position, count);
            }
        };
        this.differCallback = differCallback;
        AsyncPagingDataDiffer$differBase$1 asyncPagingDataDiffer$differBase$1 = new AsyncPagingDataDiffer$differBase$1(this, differCallback, mainDispatcher);
        this.differBase = asyncPagingDataDiffer$differBase$1;
        this.submitDataId = new AtomicInteger(0);
        this.loadStateFlow = asyncPagingDataDiffer$differBase$1.getLoadStateFlow();
    }

    public final void submitData(Lifecycle lifecycle, PagingData<T> pagingData) {
        m.f(lifecycle, "lifecycle");
        m.f(pagingData, "pagingData");
        j.d(LifecycleKt.getCoroutineScope(lifecycle), null, null, new AnonymousClass2(this.submitDataId.incrementAndGet(), pagingData, null), 3, null);
    }

    public /* synthetic */ AsyncPagingDataDiffer(DiffUtil.ItemCallback itemCallback, ListUpdateCallback listUpdateCallback, i0 i0Var, i0 i0Var2, int i10, g gVar) {
        this(itemCallback, listUpdateCallback, (i10 & 4) != 0 ? a1.c() : i0Var, (i10 & 8) != 0 ? a1.a() : i0Var2);
    }

    public static /* synthetic */ void getDifferCallback$paging_runtime_release$annotations() {
    }

    public static /* synthetic */ void getInGetItem$paging_runtime_release$annotations() {
    }
}
