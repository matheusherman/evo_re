package androidx.paging;

import androidx.annotation.IntRange;
import androidx.exifinterface.media.ExifInterface;
import androidx.p000lifecycle.Lifecycle;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import c9.l;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.flow.f;
import kotlinx.coroutines.i0;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\b\u0012\u0004\u0012\u00028\u00010\u0005B+\b\u0007\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001d\u001a\u00020\u000f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010\u001d\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u001f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b¢\u0006\u0004\b\u001d\u0010!J\r\u0010\"\u001a\u00020\u000f¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\u000f¢\u0006\u0004\b$\u0010#J\u001b\u0010%\u001a\u0004\u0018\u00018\u00002\b\b\u0001\u0010\u0013\u001a\u00020\u0012H\u0004¢\u0006\u0004\b%\u0010&J\u0019\u0010(\u001a\u0004\u0018\u00018\u00002\b\b\u0001\u0010'\u001a\u00020\u0012¢\u0006\u0004\b(\u0010&J\u0013\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000)¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0012H\u0016¢\u0006\u0004\b,\u0010-J!\u00101\u001a\u00020\u000f2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u000f0.¢\u0006\u0004\b1\u00102J!\u00103\u001a\u00020\u000f2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u000f0.¢\u0006\u0004\b3\u00102J\u0019\u00107\u001a\u0002062\n\u00105\u001a\u0006\u0012\u0002\b\u000304¢\u0006\u0004\b7\u00108J\u0019\u0010:\u001a\u0002062\n\u00109\u001a\u0006\u0012\u0002\b\u000304¢\u0006\u0004\b:\u00108J%\u0010;\u001a\u0002062\n\u00105\u001a\u0006\u0012\u0002\b\u0003042\n\u00109\u001a\u0006\u0012\u0002\b\u000304¢\u0006\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u001d\u0010C\u001a\b\u0012\u0004\u0012\u00020/0B8\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006G"}, d2 = {"Landroidx/paging/PagingDataAdapter;", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "diffCallback", "Lkotlinx/coroutines/i0;", "mainDispatcher", "workerDispatcher", "<init>", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Lkotlinx/coroutines/i0;Lkotlinx/coroutines/i0;)V", "Landroidx/recyclerview/widget/RecyclerView$Adapter$StateRestorationPolicy;", "strategy", "Lr8/z;", "setStateRestorationPolicy", "(Landroidx/recyclerview/widget/RecyclerView$Adapter$StateRestorationPolicy;)V", "", "position", "", "getItemId", "(I)J", "", "hasStableIds", "setHasStableIds", "(Z)V", "Landroidx/paging/PagingData;", "pagingData", "submitData", "(Landroidx/paging/PagingData;Lv8/f;)Ljava/lang/Object;", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "(Landroidx/lifecycle/Lifecycle;Landroidx/paging/PagingData;)V", "retry", "()V", "refresh", "getItem", "(I)Ljava/lang/Object;", "index", "peek", "Landroidx/paging/ItemSnapshotList;", "snapshot", "()Landroidx/paging/ItemSnapshotList;", "getItemCount", "()I", "Lkotlin/Function1;", "Landroidx/paging/CombinedLoadStates;", "listener", "addLoadStateListener", "(Lc9/l;)V", "removeLoadStateListener", "Landroidx/paging/LoadStateAdapter;", "header", "Landroidx/recyclerview/widget/ConcatAdapter;", "withLoadStateHeader", "(Landroidx/paging/LoadStateAdapter;)Landroidx/recyclerview/widget/ConcatAdapter;", "footer", "withLoadStateFooter", "withLoadStateHeaderAndFooter", "(Landroidx/paging/LoadStateAdapter;Landroidx/paging/LoadStateAdapter;)Landroidx/recyclerview/widget/ConcatAdapter;", "userSetRestorationPolicy", "Z", "Landroidx/paging/AsyncPagingDataDiffer;", "differ", "Landroidx/paging/AsyncPagingDataDiffer;", "Lkotlinx/coroutines/flow/f;", "loadStateFlow", "Lkotlinx/coroutines/flow/f;", "getLoadStateFlow", "()Lkotlinx/coroutines/flow/f;", "paging-runtime_release"}, k = 1, mv = {1, 4, 1})
public abstract class PagingDataAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    private final AsyncPagingDataDiffer<T> differ;
    private final f<CombinedLoadStates> loadStateFlow;
    private boolean userSetRestorationPolicy;

    /* JADX INFO: renamed from: androidx.paging.PagingDataAdapter$withLoadStateFooter$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Landroidx/paging/CombinedLoadStates;", "loadStates", "Lr8/z;", "invoke", "(Landroidx/paging/CombinedLoadStates;)V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class C05561 extends o implements l<CombinedLoadStates, z> {
        final /* synthetic */ LoadStateAdapter $footer;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(CombinedLoadStates combinedLoadStates) {
            invoke2(combinedLoadStates);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05561(LoadStateAdapter loadStateAdapter) {
            super(1);
            this.$footer = loadStateAdapter;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CombinedLoadStates loadStates) {
            m.f(loadStates, "loadStates");
            this.$footer.setLoadState(loadStates.getAppend());
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PagingDataAdapter$withLoadStateHeader$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Landroidx/paging/CombinedLoadStates;", "loadStates", "Lr8/z;", "invoke", "(Landroidx/paging/CombinedLoadStates;)V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class C05571 extends o implements l<CombinedLoadStates, z> {
        final /* synthetic */ LoadStateAdapter $header;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(CombinedLoadStates combinedLoadStates) {
            invoke2(combinedLoadStates);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05571(LoadStateAdapter loadStateAdapter) {
            super(1);
            this.$header = loadStateAdapter;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CombinedLoadStates loadStates) {
            m.f(loadStates, "loadStates");
            this.$header.setLoadState(loadStates.getPrepend());
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PagingDataAdapter$withLoadStateHeaderAndFooter$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Landroidx/paging/CombinedLoadStates;", "loadStates", "Lr8/z;", "invoke", "(Landroidx/paging/CombinedLoadStates;)V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class C05581 extends o implements l<CombinedLoadStates, z> {
        final /* synthetic */ LoadStateAdapter $footer;
        final /* synthetic */ LoadStateAdapter $header;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(CombinedLoadStates combinedLoadStates) {
            invoke2(combinedLoadStates);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05581(LoadStateAdapter loadStateAdapter, LoadStateAdapter loadStateAdapter2) {
            super(1);
            this.$header = loadStateAdapter;
            this.$footer = loadStateAdapter2;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CombinedLoadStates loadStates) {
            m.f(loadStates, "loadStates");
            this.$header.setLoadState(loadStates.getPrepend());
            this.$footer.setLoadState(loadStates.getAppend());
        }
    }

    public PagingDataAdapter(DiffUtil.ItemCallback<T> itemCallback) {
        this(itemCallback, null, null, 6, null);
    }

    public final Object submitData(PagingData<T> pagingData, v8.f<? super z> fVar) {
        Object objSubmitData = this.differ.submitData(pagingData, fVar);
        return objSubmitData == b.c() ? objSubmitData : z.f17874a;
    }

    public PagingDataAdapter(DiffUtil.ItemCallback<T> itemCallback, i0 i0Var) {
        this(itemCallback, i0Var, null, 4, null);
    }

    public final void addLoadStateListener(l<? super CombinedLoadStates, z> listener) {
        m.f(listener, "listener");
        this.differ.addLoadStateListener(listener);
    }

    protected final T getItem(@IntRange(from = 0) int position) {
        return this.differ.getItem(position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.differ.getItemCount();
    }

    public final f<CombinedLoadStates> getLoadStateFlow() {
        return this.loadStateFlow;
    }

    public final T peek(@IntRange(from = 0) int index) {
        return this.differ.peek(index);
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

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean hasStableIds) {
        throw new UnsupportedOperationException("Stable ids are unsupported on PagingDataAdapter.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy strategy) {
        m.f(strategy, "strategy");
        this.userSetRestorationPolicy = true;
        super.setStateRestorationPolicy(strategy);
    }

    public final ItemSnapshotList<T> snapshot() {
        return this.differ.snapshot();
    }

    public final ConcatAdapter withLoadStateFooter(LoadStateAdapter<?> footer) {
        m.f(footer, "footer");
        addLoadStateListener(new C05561(footer));
        return new ConcatAdapter((RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this, footer});
    }

    public final ConcatAdapter withLoadStateHeader(LoadStateAdapter<?> header) {
        m.f(header, "header");
        addLoadStateListener(new C05571(header));
        return new ConcatAdapter((RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{header, this});
    }

    public final ConcatAdapter withLoadStateHeaderAndFooter(LoadStateAdapter<?> header, LoadStateAdapter<?> footer) {
        m.f(header, "header");
        m.f(footer, "footer");
        addLoadStateListener(new C05581(header, footer));
        return new ConcatAdapter((RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{header, this, footer});
    }

    public /* synthetic */ PagingDataAdapter(DiffUtil.ItemCallback itemCallback, i0 i0Var, i0 i0Var2, int i10, g gVar) {
        this(itemCallback, (i10 & 2) != 0 ? a1.c() : i0Var, (i10 & 4) != 0 ? a1.a() : i0Var2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int position) {
        return super.getItemId(position);
    }

    public final void submitData(Lifecycle lifecycle, PagingData<T> pagingData) {
        m.f(lifecycle, "lifecycle");
        m.f(pagingData, "pagingData");
        this.differ.submitData(lifecycle, pagingData);
    }

    public PagingDataAdapter(DiffUtil.ItemCallback<T> diffCallback, i0 mainDispatcher, i0 workerDispatcher) {
        m.f(diffCallback, "diffCallback");
        m.f(mainDispatcher, "mainDispatcher");
        m.f(workerDispatcher, "workerDispatcher");
        super.setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy.PREVENT);
        registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() { // from class: androidx.paging.PagingDataAdapter.1
            private final void considerAllowingStateRestoration() {
                if (PagingDataAdapter.this.getStateRestorationPolicy() != RecyclerView.Adapter.StateRestorationPolicy.PREVENT || PagingDataAdapter.this.userSetRestorationPolicy) {
                    return;
                }
                PagingDataAdapter.this.setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy.ALLOW);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int positionStart, int itemCount) {
                considerAllowingStateRestoration();
                PagingDataAdapter.this.unregisterAdapterDataObserver(this);
                super.onItemRangeInserted(positionStart, itemCount);
            }
        });
        AsyncPagingDataDiffer<T> asyncPagingDataDiffer = new AsyncPagingDataDiffer<>(diffCallback, new AdapterListUpdateCallback(this), mainDispatcher, workerDispatcher);
        this.differ = asyncPagingDataDiffer;
        this.loadStateFlow = asyncPagingDataDiffer.getLoadStateFlow();
    }
}
