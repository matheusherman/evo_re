package androidx.leanback.paging;

import androidx.exifinterface.media.ExifInterface;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.PresenterSelector;
import androidx.p000lifecycle.Lifecycle;
import androidx.paging.AsyncPagingDataDiffer;
import androidx.paging.CombinedLoadStates;
import androidx.paging.PagingData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import c9.l;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.i0;
import r8.z;
import v8.f;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B+\b\u0017\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nB3\b\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\rB3\b\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0010J!\u0010\u0014\u001a\u00020\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011¢\u0006\u0004\b\u0014\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0013¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0013¢\u0006\u0004\b\u001b\u0010\u001aJ!\u0010\u001f\u001a\u00020\u00132\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00130\u001c¢\u0006\u0004\b\u001f\u0010 J!\u0010!\u001a\u00020\u00132\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00130\u001c¢\u0006\u0004\b!\u0010 J\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J\u001a\u0010&\u001a\u0004\u0018\u00018\u00002\u0006\u0010%\u001a\u00020\"H\u0096\u0002¢\u0006\u0004\b&\u0010'R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010(R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010)R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010)R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020\u001d008F¢\u0006\f\u0012\u0004\b3\u0010\u001a\u001a\u0004\b1\u00102\u0082\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"Landroidx/leanback/paging/PagingDataAdapter;", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/leanback/widget/ObjectAdapter;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "diffCallback", "Lkotlinx/coroutines/i0;", "mainDispatcher", "workerDispatcher", "<init>", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Lkotlinx/coroutines/i0;Lkotlinx/coroutines/i0;)V", "Landroidx/leanback/widget/Presenter;", "presenter", "(Landroidx/leanback/widget/Presenter;Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Lkotlinx/coroutines/i0;Lkotlinx/coroutines/i0;)V", "Landroidx/leanback/widget/PresenterSelector;", "presenterSelector", "(Landroidx/leanback/widget/PresenterSelector;Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Lkotlinx/coroutines/i0;Lkotlinx/coroutines/i0;)V", "Landroidx/paging/PagingData;", "pagingData", "Lr8/z;", "submitData", "(Landroidx/paging/PagingData;Lv8/f;)Ljava/lang/Object;", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "(Landroidx/lifecycle/Lifecycle;Landroidx/paging/PagingData;)V", "retry", "()V", "refresh", "Lkotlin/Function1;", "Landroidx/paging/CombinedLoadStates;", "listener", "addLoadStateListener", "(Lc9/l;)V", "removeLoadStateListener", "", "size", "()I", "position", "get", "(I)Ljava/lang/Object;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lkotlinx/coroutines/i0;", "Landroidx/paging/AsyncPagingDataDiffer;", "differ", "Landroidx/paging/AsyncPagingDataDiffer;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "listUpdateCallback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "Lkotlinx/coroutines/flow/f;", "getLoadStateFlow", "()Lkotlinx/coroutines/flow/f;", "getLoadStateFlow$annotations", "loadStateFlow", "leanback-paging_release"}, k = 1, mv = {1, 4, 1})
public final class PagingDataAdapter<T> extends ObjectAdapter {
    private final DiffUtil.ItemCallback<T> diffCallback;
    private final AsyncPagingDataDiffer<T> differ;
    private final ListUpdateCallback listUpdateCallback;
    private final i0 mainDispatcher;
    private final i0 workerDispatcher;

    public PagingDataAdapter(Presenter presenter, DiffUtil.ItemCallback<T> itemCallback) {
        this(presenter, itemCallback, (i0) null, (i0) null, 12, (g) null);
    }

    public final Object submitData(PagingData<T> pagingData, f<? super z> fVar) {
        Object objSubmitData = this.differ.submitData(pagingData, fVar);
        return objSubmitData == b.c() ? objSubmitData : z.f17874a;
    }

    public PagingDataAdapter(Presenter presenter, DiffUtil.ItemCallback<T> itemCallback, i0 i0Var) {
        this(presenter, itemCallback, i0Var, (i0) null, 8, (g) null);
    }

    public final void addLoadStateListener(l<? super CombinedLoadStates, z> listener) {
        m.f(listener, "listener");
        this.differ.addLoadStateListener(listener);
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    public T get(int position) {
        return this.differ.getItem(position);
    }

    public final kotlinx.coroutines.flow.f<CombinedLoadStates> getLoadStateFlow() {
        return this.differ.getLoadStateFlow();
    }

    public final void refresh() {
        this.differ.refresh();
    }

    public final void removeLoadStateListener(l<? super CombinedLoadStates, z> listener) {
        m.f(listener, "listener");
        this.differ.removeLoadStateListener(listener);
    }

    public final void retry() {
        this.differ.retry();
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    public int size() {
        return this.differ.getItemCount();
    }

    public PagingDataAdapter(PresenterSelector presenterSelector, DiffUtil.ItemCallback<T> itemCallback) {
        this(presenterSelector, itemCallback, (i0) null, (i0) null, 12, (g) null);
    }

    public final void submitData(Lifecycle lifecycle, PagingData<T> pagingData) {
        m.f(lifecycle, "lifecycle");
        m.f(pagingData, "pagingData");
        this.differ.submitData(lifecycle, pagingData);
    }

    public PagingDataAdapter(PresenterSelector presenterSelector, DiffUtil.ItemCallback<T> itemCallback, i0 i0Var) {
        this(presenterSelector, itemCallback, i0Var, (i0) null, 8, (g) null);
    }

    public PagingDataAdapter(DiffUtil.ItemCallback<T> itemCallback) {
        this(itemCallback, null, null, 6, null);
    }

    public PagingDataAdapter(DiffUtil.ItemCallback<T> itemCallback, i0 i0Var) {
        this(itemCallback, i0Var, null, 4, null);
    }

    public /* synthetic */ PagingDataAdapter(DiffUtil.ItemCallback itemCallback, i0 i0Var, i0 i0Var2, int i10, g gVar) {
        this(itemCallback, (i10 & 2) != 0 ? a1.c() : i0Var, (i10 & 4) != 0 ? a1.a() : i0Var2);
    }

    public PagingDataAdapter(DiffUtil.ItemCallback<T> diffCallback, i0 mainDispatcher, i0 workerDispatcher) {
        m.f(diffCallback, "diffCallback");
        m.f(mainDispatcher, "mainDispatcher");
        m.f(workerDispatcher, "workerDispatcher");
        ListUpdateCallback listUpdateCallback = new ListUpdateCallback() { // from class: androidx.leanback.paging.PagingDataAdapter$listUpdateCallback$1
            @Override // androidx.recyclerview.widget.ListUpdateCallback
            public void onChanged(int position, int count, Object payload) {
                this.this$0.notifyItemRangeChanged(position, count, payload);
            }

            @Override // androidx.recyclerview.widget.ListUpdateCallback
            public void onInserted(int position, int count) {
                this.this$0.notifyItemRangeInserted(position, count);
            }

            @Override // androidx.recyclerview.widget.ListUpdateCallback
            public void onMoved(int fromPosition, int toPosition) {
                this.this$0.notifyItemMoved(fromPosition, toPosition);
            }

            @Override // androidx.recyclerview.widget.ListUpdateCallback
            public void onRemoved(int position, int count) {
                this.this$0.notifyItemRangeRemoved(position, count);
            }
        };
        this.listUpdateCallback = listUpdateCallback;
        this.diffCallback = diffCallback;
        this.mainDispatcher = mainDispatcher;
        this.workerDispatcher = workerDispatcher;
        this.differ = new AsyncPagingDataDiffer<>(diffCallback, listUpdateCallback, mainDispatcher, workerDispatcher);
    }

    public /* synthetic */ PagingDataAdapter(Presenter presenter, DiffUtil.ItemCallback itemCallback, i0 i0Var, i0 i0Var2, int i10, g gVar) {
        this(presenter, itemCallback, (i10 & 4) != 0 ? a1.c() : i0Var, (i10 & 8) != 0 ? a1.a() : i0Var2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagingDataAdapter(Presenter presenter, DiffUtil.ItemCallback<T> diffCallback, i0 mainDispatcher, i0 workerDispatcher) {
        super(presenter);
        m.f(presenter, "presenter");
        m.f(diffCallback, "diffCallback");
        m.f(mainDispatcher, "mainDispatcher");
        m.f(workerDispatcher, "workerDispatcher");
        ListUpdateCallback listUpdateCallback = new ListUpdateCallback() { // from class: androidx.leanback.paging.PagingDataAdapter$listUpdateCallback$1
            @Override // androidx.recyclerview.widget.ListUpdateCallback
            public void onChanged(int position, int count, Object payload) {
                this.this$0.notifyItemRangeChanged(position, count, payload);
            }

            @Override // androidx.recyclerview.widget.ListUpdateCallback
            public void onInserted(int position, int count) {
                this.this$0.notifyItemRangeInserted(position, count);
            }

            @Override // androidx.recyclerview.widget.ListUpdateCallback
            public void onMoved(int fromPosition, int toPosition) {
                this.this$0.notifyItemMoved(fromPosition, toPosition);
            }

            @Override // androidx.recyclerview.widget.ListUpdateCallback
            public void onRemoved(int position, int count) {
                this.this$0.notifyItemRangeRemoved(position, count);
            }
        };
        this.listUpdateCallback = listUpdateCallback;
        this.diffCallback = diffCallback;
        this.mainDispatcher = mainDispatcher;
        this.workerDispatcher = workerDispatcher;
        this.differ = new AsyncPagingDataDiffer<>(diffCallback, listUpdateCallback, mainDispatcher, workerDispatcher);
    }

    public static /* synthetic */ void getLoadStateFlow$annotations() {
    }

    public /* synthetic */ PagingDataAdapter(PresenterSelector presenterSelector, DiffUtil.ItemCallback itemCallback, i0 i0Var, i0 i0Var2, int i10, g gVar) {
        this(presenterSelector, itemCallback, (i10 & 4) != 0 ? a1.c() : i0Var, (i10 & 8) != 0 ? a1.a() : i0Var2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagingDataAdapter(PresenterSelector presenterSelector, DiffUtil.ItemCallback<T> diffCallback, i0 mainDispatcher, i0 workerDispatcher) {
        super(presenterSelector);
        m.f(presenterSelector, "presenterSelector");
        m.f(diffCallback, "diffCallback");
        m.f(mainDispatcher, "mainDispatcher");
        m.f(workerDispatcher, "workerDispatcher");
        ListUpdateCallback listUpdateCallback = new ListUpdateCallback() { // from class: androidx.leanback.paging.PagingDataAdapter$listUpdateCallback$1
            @Override // androidx.recyclerview.widget.ListUpdateCallback
            public void onChanged(int position, int count, Object payload) {
                this.this$0.notifyItemRangeChanged(position, count, payload);
            }

            @Override // androidx.recyclerview.widget.ListUpdateCallback
            public void onInserted(int position, int count) {
                this.this$0.notifyItemRangeInserted(position, count);
            }

            @Override // androidx.recyclerview.widget.ListUpdateCallback
            public void onMoved(int fromPosition, int toPosition) {
                this.this$0.notifyItemMoved(fromPosition, toPosition);
            }

            @Override // androidx.recyclerview.widget.ListUpdateCallback
            public void onRemoved(int position, int count) {
                this.this$0.notifyItemRangeRemoved(position, count);
            }
        };
        this.listUpdateCallback = listUpdateCallback;
        this.diffCallback = diffCallback;
        this.mainDispatcher = mainDispatcher;
        this.workerDispatcher = workerDispatcher;
        this.differ = new AsyncPagingDataDiffer<>(diffCallback, listUpdateCallback, mainDispatcher, workerDispatcher);
    }
}
