package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import c9.p;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\b\u0012\u0004\u0012\u00028\u00010\u0005B\u0017\b\u0014\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\b\u0010\tB\u0017\b\u0014\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0004\b\b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0010\u0010\u0014J\u0019\u0010\u0017\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001c\u001a\u00020\u000f2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\rH\u0017¢\u0006\u0004\b\u001c\u0010\u0011J/\u0010\u001c\u001a\u00020\u000f2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\r2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\rH\u0016¢\u0006\u0004\b\u001c\u0010\u001eJ)\u0010#\u001a\u00020\u000f2\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u000f0\u001fH\u0016¢\u0006\u0004\b#\u0010$J)\u0010%\u001a\u00020\u000f2\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u000f0\u001fH\u0016¢\u0006\u0004\b%\u0010$J\u0019\u0010)\u001a\u00020(2\n\u0010'\u001a\u0006\u0012\u0002\b\u00030&¢\u0006\u0004\b)\u0010*J\u0019\u0010,\u001a\u00020(2\n\u0010+\u001a\u0006\u0012\u0002\b\u00030&¢\u0006\u0004\b,\u0010*J%\u0010-\u001a\u00020(2\n\u0010'\u001a\u0006\u0012\u0002\b\u00030&2\n\u0010+\u001a\u0006\u0012\u0002\b\u00030&¢\u0006\u0004\b-\u0010.R&\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000/8\u0000X\u0080\u0004¢\u0006\u0012\n\u0004\b0\u00101\u0012\u0004\b4\u00105\u001a\u0004\b2\u00103R<\u0010\"\u001a$\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\r\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\r\u0012\u0004\u0012\u00020\u000f0\u001f8\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\"\u00106\u0012\u0004\b7\u00105R\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\r8VX\u0096\u0004¢\u0006\f\u0012\u0004\b:\u00105\u001a\u0004\b8\u00109¨\u0006;"}, d2 = {"Landroidx/paging/PagedListAdapter;", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "diffCallback", "<init>", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", "Landroidx/recyclerview/widget/AsyncDifferConfig;", "config", "(Landroidx/recyclerview/widget/AsyncDifferConfig;)V", "Landroidx/paging/PagedList;", "pagedList", "Lr8/z;", "submitList", "(Landroidx/paging/PagedList;)V", "Ljava/lang/Runnable;", "commitCallback", "(Landroidx/paging/PagedList;Ljava/lang/Runnable;)V", "", "position", "getItem", "(I)Ljava/lang/Object;", "getItemCount", "()I", "currentList", "onCurrentListChanged", "previousList", "(Landroidx/paging/PagedList;Landroidx/paging/PagedList;)V", "Lkotlin/Function2;", "Landroidx/paging/LoadType;", "Landroidx/paging/LoadState;", "listener", "addLoadStateListener", "(Lc9/p;)V", "removeLoadStateListener", "Landroidx/paging/LoadStateAdapter;", "header", "Landroidx/recyclerview/widget/ConcatAdapter;", "withLoadStateHeader", "(Landroidx/paging/LoadStateAdapter;)Landroidx/recyclerview/widget/ConcatAdapter;", "footer", "withLoadStateFooter", "withLoadStateHeaderAndFooter", "(Landroidx/paging/LoadStateAdapter;Landroidx/paging/LoadStateAdapter;)Landroidx/recyclerview/widget/ConcatAdapter;", "Landroidx/paging/AsyncPagedListDiffer;", "differ", "Landroidx/paging/AsyncPagedListDiffer;", "getDiffer$paging_runtime_release", "()Landroidx/paging/AsyncPagedListDiffer;", "getDiffer$paging_runtime_release$annotations", "()V", "Lc9/p;", "getListener$annotations", "getCurrentList", "()Landroidx/paging/PagedList;", "getCurrentList$annotations", "paging-runtime_release"}, k = 1, mv = {1, 4, 1})
public abstract class PagedListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    private final AsyncPagedListDiffer<T> differ;
    private final p<PagedList<T>, PagedList<T>, z> listener;

    /* JADX INFO: renamed from: androidx.paging.PagedListAdapter$withLoadStateFooter$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Landroidx/paging/LoadType;", "loadType", "Landroidx/paging/LoadState;", "loadState", "Lr8/z;", "invoke", "(Landroidx/paging/LoadType;Landroidx/paging/LoadState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass1 extends o implements p<LoadType, LoadState, z> {
        final /* synthetic */ LoadStateAdapter $footer;

        @Override // c9.p
        public /* bridge */ /* synthetic */ z invoke(LoadType loadType, LoadState loadState) {
            invoke2(loadType, loadState);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LoadStateAdapter loadStateAdapter) {
            super(2);
            this.$footer = loadStateAdapter;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LoadType loadType, LoadState loadState) {
            m.f(loadType, "loadType");
            m.f(loadState, "loadState");
            if (loadType == LoadType.APPEND) {
                this.$footer.setLoadState(loadState);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PagedListAdapter$withLoadStateHeader$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Landroidx/paging/LoadType;", "loadType", "Landroidx/paging/LoadState;", "loadState", "Lr8/z;", "invoke", "(Landroidx/paging/LoadType;Landroidx/paging/LoadState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class C05541 extends o implements p<LoadType, LoadState, z> {
        final /* synthetic */ LoadStateAdapter $header;

        @Override // c9.p
        public /* bridge */ /* synthetic */ z invoke(LoadType loadType, LoadState loadState) {
            invoke2(loadType, loadState);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05541(LoadStateAdapter loadStateAdapter) {
            super(2);
            this.$header = loadStateAdapter;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LoadType loadType, LoadState loadState) {
            m.f(loadType, "loadType");
            m.f(loadState, "loadState");
            if (loadType == LoadType.PREPEND) {
                this.$header.setLoadState(loadState);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PagedListAdapter$withLoadStateHeaderAndFooter$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Landroidx/paging/LoadType;", "loadType", "Landroidx/paging/LoadState;", "loadState", "Lr8/z;", "invoke", "(Landroidx/paging/LoadType;Landroidx/paging/LoadState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class C05551 extends o implements p<LoadType, LoadState, z> {
        final /* synthetic */ LoadStateAdapter $footer;
        final /* synthetic */ LoadStateAdapter $header;

        @Override // c9.p
        public /* bridge */ /* synthetic */ z invoke(LoadType loadType, LoadState loadState) {
            invoke2(loadType, loadState);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05551(LoadStateAdapter loadStateAdapter, LoadStateAdapter loadStateAdapter2) {
            super(2);
            this.$header = loadStateAdapter;
            this.$footer = loadStateAdapter2;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LoadType loadType, LoadState loadState) {
            m.f(loadType, "loadType");
            m.f(loadState, "loadState");
            if (loadType == LoadType.PREPEND) {
                this.$header.setLoadState(loadState);
            } else if (loadType == LoadType.APPEND) {
                this.$footer.setLoadState(loadState);
            }
        }
    }

    protected PagedListAdapter(DiffUtil.ItemCallback<T> diffCallback) {
        m.f(diffCallback, "diffCallback");
        PagedListAdapter$listener$1 pagedListAdapter$listener$1 = new PagedListAdapter$listener$1(this);
        this.listener = pagedListAdapter$listener$1;
        AsyncPagedListDiffer<T> asyncPagedListDiffer = new AsyncPagedListDiffer<>(this, diffCallback);
        this.differ = asyncPagedListDiffer;
        asyncPagedListDiffer.addPagedListListener(pagedListAdapter$listener$1);
    }

    public void onCurrentListChanged(PagedList<T> currentList) {
    }

    public void submitList(PagedList<T> pagedList) {
        this.differ.submitList(pagedList);
    }

    public void addLoadStateListener(p<? super LoadType, ? super LoadState, z> listener) {
        m.f(listener, "listener");
        this.differ.addLoadStateListener(listener);
    }

    public PagedList<T> getCurrentList() {
        return this.differ.getCurrentList();
    }

    public final AsyncPagedListDiffer<T> getDiffer$paging_runtime_release() {
        return this.differ;
    }

    protected T getItem(int position) {
        return this.differ.getItem(position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.differ.getItemCount();
    }

    public void onCurrentListChanged(PagedList<T> previousList, PagedList<T> currentList) {
    }

    public void removeLoadStateListener(p<? super LoadType, ? super LoadState, z> listener) {
        m.f(listener, "listener");
        this.differ.removeLoadStateListener(listener);
    }

    public void submitList(PagedList<T> pagedList, Runnable commitCallback) {
        this.differ.submitList(pagedList, commitCallback);
    }

    public final ConcatAdapter withLoadStateFooter(LoadStateAdapter<?> footer) {
        m.f(footer, "footer");
        addLoadStateListener(new AnonymousClass1(footer));
        return new ConcatAdapter((RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this, footer});
    }

    public final ConcatAdapter withLoadStateHeader(LoadStateAdapter<?> header) {
        m.f(header, "header");
        addLoadStateListener(new C05541(header));
        return new ConcatAdapter((RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{header, this});
    }

    public final ConcatAdapter withLoadStateHeaderAndFooter(LoadStateAdapter<?> header, LoadStateAdapter<?> footer) {
        m.f(header, "header");
        m.f(footer, "footer");
        addLoadStateListener(new C05551(header, footer));
        return new ConcatAdapter((RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{header, this, footer});
    }

    protected PagedListAdapter(AsyncDifferConfig<T> config) {
        m.f(config, "config");
        PagedListAdapter$listener$1 pagedListAdapter$listener$1 = new PagedListAdapter$listener$1(this);
        this.listener = pagedListAdapter$listener$1;
        AsyncPagedListDiffer<T> asyncPagedListDiffer = new AsyncPagedListDiffer<>(new AdapterListUpdateCallback(this), config);
        this.differ = asyncPagedListDiffer;
        asyncPagedListDiffer.addPagedListListener(pagedListAdapter$listener$1);
    }

    public static /* synthetic */ void getCurrentList$annotations() {
    }

    public static /* synthetic */ void getDiffer$paging_runtime_release$annotations() {
    }

    private static /* synthetic */ void getListener$annotations() {
    }
}
