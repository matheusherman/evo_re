package androidx.paging;

import androidx.annotation.IntRange;
import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import c9.l;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.flow.f0;
import kotlinx.coroutines.flow.v;
import kotlinx.coroutines.i0;
import r8.r;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u009b\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001@\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJO\u0010\u0016\u001a\u0004\u0018\u00010\u00122\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014H¦@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001d\u001a\u00020\u000b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u001c\u0010 \u001a\u0004\u0018\u00018\u00002\b\b\u0001\u0010\u001f\u001a\u00020\u0012H\u0086\u0002¢\u0006\u0004\b \u0010!J\u0019\u0010\"\u001a\u0004\u0018\u00018\u00002\b\b\u0001\u0010\u001f\u001a\u00020\u0012¢\u0006\u0004\b\"\u0010!J\u0013\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000#¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\u000b¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\u000b¢\u0006\u0004\b(\u0010'J!\u0010+\u001a\u00020\u000b2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b0)¢\u0006\u0004\b+\u0010,J!\u0010-\u001a\u00020\u000b2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b0)¢\u0006\u0004\b-\u0010,R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00102\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R&\u00108\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b0)078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010?R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00000@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020\t0C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010FR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010GR\u0011\u0010J\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0017\u0010N\u001a\b\u0012\u0004\u0012\u00020\t0K8F¢\u0006\u0006\u001a\u0004\bL\u0010M\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006O"}, d2 = {"Landroidx/paging/PagingDataDiffer;", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/paging/DifferCallback;", "differCallback", "Lkotlinx/coroutines/i0;", "mainDispatcher", "<init>", "(Landroidx/paging/DifferCallback;Lkotlinx/coroutines/i0;)V", "Landroidx/paging/CombinedLoadStates;", "states", "Lr8/z;", "dispatchLoadStates", "(Landroidx/paging/CombinedLoadStates;)V", "Landroidx/paging/NullPaddedList;", "previousList", "newList", "newCombinedLoadStates", "", "lastAccessedIndex", "Lkotlin/Function0;", "onListPresentable", "presentNewList", "(Landroidx/paging/NullPaddedList;Landroidx/paging/NullPaddedList;Landroidx/paging/CombinedLoadStates;ILc9/a;Lv8/f;)Ljava/lang/Object;", "", "postEvents", "()Z", "Landroidx/paging/PagingData;", "pagingData", "collectFrom", "(Landroidx/paging/PagingData;Lv8/f;)Ljava/lang/Object;", "index", "get", "(I)Ljava/lang/Object;", "peek", "Landroidx/paging/ItemSnapshotList;", "snapshot", "()Landroidx/paging/ItemSnapshotList;", "retry", "()V", "refresh", "Lkotlin/Function1;", "listener", "addLoadStateListener", "(Lc9/l;)V", "removeLoadStateListener", "Landroidx/paging/PagePresenter;", "presenter", "Landroidx/paging/PagePresenter;", "Landroidx/paging/UiReceiver;", "receiver", "Landroidx/paging/UiReceiver;", "Landroidx/paging/MutableLoadStateCollection;", "combinedLoadStates", "Landroidx/paging/MutableLoadStateCollection;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "loadStateListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/paging/SingleRunner;", "collectFromRunner", "Landroidx/paging/SingleRunner;", "lastAccessedIndexUnfulfilled", "Z", "I", "androidx/paging/PagingDataDiffer$processPageEventCallback$1", "processPageEventCallback", "Landroidx/paging/PagingDataDiffer$processPageEventCallback$1;", "Lkotlinx/coroutines/flow/v;", "_combinedLoadState", "Lkotlinx/coroutines/flow/v;", "Landroidx/paging/DifferCallback;", "Lkotlinx/coroutines/i0;", "getSize", "()I", "size", "Lkotlinx/coroutines/flow/f;", "getLoadStateFlow", "()Lkotlinx/coroutines/flow/f;", "loadStateFlow", "paging-common"}, k = 1, mv = {1, 4, 1})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class PagingDataDiffer<T> {
    private final v<CombinedLoadStates> _combinedLoadState;
    private final SingleRunner collectFromRunner;
    private final MutableLoadStateCollection combinedLoadStates;
    private final DifferCallback differCallback;
    private volatile int lastAccessedIndex;
    private volatile boolean lastAccessedIndexUnfulfilled;
    private final CopyOnWriteArrayList<l<CombinedLoadStates, z>> loadStateListeners;
    private final i0 mainDispatcher;
    private PagePresenter<T> presenter;
    private final PagingDataDiffer$processPageEventCallback$1 processPageEventCallback;
    private UiReceiver receiver;

    /* JADX INFO: renamed from: androidx.paging.PagingDataDiffer$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/paging/CombinedLoadStates;", "it", "Lr8/z;", "invoke", "(Landroidx/paging/CombinedLoadStates;)V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass1 extends o implements l<CombinedLoadStates, z> {
        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(CombinedLoadStates combinedLoadStates) {
            invoke2(combinedLoadStates);
            return z.f17874a;
        }

        AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CombinedLoadStates it) {
            m.f(it, "it");
            PagingDataDiffer.this._combinedLoadState.setValue(it);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PagingDataDiffer$collectFrom$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.paging.PagingDataDiffer$collectFrom$2", f = "PagingDataDiffer.kt", l = {363}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lr8/z;", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass2 extends kotlin.coroutines.jvm.internal.l implements l<v8.f<? super z>, Object> {
        final /* synthetic */ PagingData $pagingData;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(PagingData pagingData, v8.f fVar) {
            super(1, fVar);
            this.$pagingData = pagingData;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(v8.f<?> completion) {
            m.f(completion, "completion");
            return new AnonymousClass2(this.$pagingData, completion);
        }

        @Override // c9.l
        public final Object invoke(v8.f<? super z> fVar) {
            return ((AnonymousClass2) create(fVar)).invokeSuspend(z.f17874a);
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
                PagingDataDiffer.this.receiver = this.$pagingData.getReceiver();
                kotlinx.coroutines.flow.f<PageEvent<T>> flow$paging_common = this.$pagingData.getFlow$paging_common();
                PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1 pagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1 = new PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1(this);
                this.label = 1;
                if (flow$paging_common.collect(pagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.paging.PagingDataDiffer$processPageEventCallback$1] */
    public PagingDataDiffer(DifferCallback differCallback, i0 mainDispatcher) {
        m.f(differCallback, "differCallback");
        m.f(mainDispatcher, "mainDispatcher");
        this.differCallback = differCallback;
        this.mainDispatcher = mainDispatcher;
        this.presenter = PagePresenter.INSTANCE.initial$paging_common();
        MutableLoadStateCollection mutableLoadStateCollection = new MutableLoadStateCollection();
        this.combinedLoadStates = mutableLoadStateCollection;
        this.loadStateListeners = new CopyOnWriteArrayList<>();
        this.collectFromRunner = new SingleRunner(false, 1, null);
        this.processPageEventCallback = new PagePresenter.ProcessPageEventCallback() { // from class: androidx.paging.PagingDataDiffer$processPageEventCallback$1
            @Override // androidx.paging.PagePresenter.ProcessPageEventCallback
            public void onChanged(int position, int count) {
                this.this$0.differCallback.onChanged(position, count);
            }

            @Override // androidx.paging.PagePresenter.ProcessPageEventCallback
            public void onInserted(int position, int count) {
                this.this$0.differCallback.onInserted(position, count);
            }

            @Override // androidx.paging.PagePresenter.ProcessPageEventCallback
            public void onRemoved(int position, int count) {
                this.this$0.differCallback.onRemoved(position, count);
            }

            @Override // androidx.paging.PagePresenter.ProcessPageEventCallback
            public void onStateUpdate(LoadType loadType, boolean fromMediator, LoadState loadState) {
                m.f(loadType, "loadType");
                m.f(loadState, "loadState");
                if (m.a(this.this$0.combinedLoadStates.get(loadType, fromMediator), loadState)) {
                    return;
                }
                this.this$0.combinedLoadStates.set(loadType, fromMediator, loadState);
                CombinedLoadStates combinedLoadStatesSnapshot = this.this$0.combinedLoadStates.snapshot();
                Iterator it = this.this$0.loadStateListeners.iterator();
                while (it.hasNext()) {
                    ((l) it.next()).invoke(combinedLoadStatesSnapshot);
                }
            }
        };
        this._combinedLoadState = f0.a(mutableLoadStateCollection.snapshot());
        addLoadStateListener(new AnonymousClass1());
    }

    public final T get(@IntRange(from = 0) int index) {
        this.lastAccessedIndexUnfulfilled = true;
        this.lastAccessedIndex = index;
        UiReceiver uiReceiver = this.receiver;
        if (uiReceiver != null) {
            uiReceiver.accessHint(this.presenter.accessHintForPresenterIndex(index));
        }
        return this.presenter.get(index);
    }

    public boolean postEvents() {
        return false;
    }

    public abstract Object presentNewList(NullPaddedList<T> nullPaddedList, NullPaddedList<T> nullPaddedList2, CombinedLoadStates combinedLoadStates, int i10, c9.a<z> aVar, v8.f<? super Integer> fVar);

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchLoadStates(CombinedLoadStates states) {
        if (m.a(this.combinedLoadStates.snapshot(), states)) {
            return;
        }
        this.combinedLoadStates.set(states);
        Iterator<T> it = this.loadStateListeners.iterator();
        while (it.hasNext()) {
            ((l) it.next()).invoke(states);
        }
    }

    public final void addLoadStateListener(l<? super CombinedLoadStates, z> listener) {
        m.f(listener, "listener");
        this.loadStateListeners.add(listener);
        listener.invoke(this.combinedLoadStates.snapshot());
    }

    public final Object collectFrom(PagingData<T> pagingData, v8.f<? super z> fVar) {
        Object objRunInIsolation$default = SingleRunner.runInIsolation$default(this.collectFromRunner, 0, new AnonymousClass2(pagingData, null), fVar, 1, null);
        return objRunInIsolation$default == b.c() ? objRunInIsolation$default : z.f17874a;
    }

    public final kotlinx.coroutines.flow.f<CombinedLoadStates> getLoadStateFlow() {
        return this._combinedLoadState;
    }

    public final int getSize() {
        return this.presenter.getSize();
    }

    public final T peek(@IntRange(from = 0) int index) {
        return this.presenter.get(index);
    }

    public final void refresh() {
        UiReceiver uiReceiver = this.receiver;
        if (uiReceiver != null) {
            uiReceiver.refresh();
        }
    }

    public final void removeLoadStateListener(l<? super CombinedLoadStates, z> listener) {
        m.f(listener, "listener");
        this.loadStateListeners.remove(listener);
    }

    public final void retry() {
        UiReceiver uiReceiver = this.receiver;
        if (uiReceiver != null) {
            uiReceiver.retry();
        }
    }

    public final ItemSnapshotList<T> snapshot() {
        return this.presenter.snapshot();
    }

    public /* synthetic */ PagingDataDiffer(DifferCallback differCallback, i0 i0Var, int i10, g gVar) {
        this(differCallback, (i10 & 2) != 0 ? a1.c() : i0Var);
    }
}
