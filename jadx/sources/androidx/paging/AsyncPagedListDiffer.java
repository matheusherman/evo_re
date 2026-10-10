package androidx.paging;

import androidx.annotation.VisibleForTesting;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import c9.l;
import c9.p;
import h9.f;
import i9.g;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0002lmB#\b\u0017\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bB\u001f\b\u0017\u0012\u0006\u0010\n\u001a\u00020\t\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b¢\u0006\u0004\b\u0007\u0010\rJ9\u0010\u0014\u001a\u00020\u00132\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001b\u001a\u00020\u00132\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ)\u0010\u001b\u001a\u00020\u00132\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u001b\u0010\u001dJM\u0010'\u001a\u00020\u00132\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0004\b%\u0010&J\u001d\u0010*\u001a\u00020\u00132\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000(H\u0016¢\u0006\u0004\b*\u0010+J7\u0010*\u001a\u00020\u00132(\u0010-\u001a$\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u00130,¢\u0006\u0004\b*\u0010.J\u001d\u0010/\u001a\u00020\u00132\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000(H\u0016¢\u0006\u0004\b/\u0010+J7\u0010/\u001a\u00020\u00132(\u0010-\u001a$\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u00130,¢\u0006\u0004\b/\u0010.J)\u00102\u001a\u00020\u00132\u0018\u0010)\u001a\u0014\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u00130,H\u0016¢\u0006\u0004\b2\u0010.J)\u00103\u001a\u00020\u00132\u0018\u0010)\u001a\u0014\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u00130,H\u0016¢\u0006\u0004\b3\u0010.R\"\u00104\u001a\u00020\t8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R&\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b8\u0000X\u0080\u0004¢\u0006\u0012\n\u0004\b\f\u0010:\u0012\u0004\b=\u0010>\u001a\u0004\b;\u0010<R\"\u0010@\u001a\u00020?8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER,\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(0F8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\bG\u0010H\u0012\u0004\bK\u0010>\u001a\u0004\bI\u0010JR$\u0010\u001a\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u001a\u0010L\u0012\u0004\bM\u0010>R$\u0010N\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\bN\u0010L\u0012\u0004\bO\u0010>R(\u0010P\u001a\u00020\u00168\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0004\bP\u0010Q\u0012\u0004\bV\u0010>\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001a\u0010X\u001a\u00020W8\u0002X\u0082\u0004¢\u0006\f\n\u0004\bX\u0010Y\u0012\u0004\bZ\u0010>R&\u0010\\\u001a\u0014\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u00130[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R2\u0010_\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u00130,0^8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010bR\u001a\u0010d\u001a\u00020c8\u0002X\u0082\u0004¢\u0006\f\n\u0004\bd\u0010e\u0012\u0004\bf\u0010>R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\f\u0012\u0004\bi\u0010>\u001a\u0004\bg\u0010hR\u0014\u0010k\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bj\u0010S¨\u0006n"}, d2 = {"Landroidx/paging/AsyncPagedListDiffer;", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "diffCallback", "<init>", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", "Landroidx/recyclerview/widget/ListUpdateCallback;", "listUpdateCallback", "Landroidx/recyclerview/widget/AsyncDifferConfig;", "config", "(Landroidx/recyclerview/widget/ListUpdateCallback;Landroidx/recyclerview/widget/AsyncDifferConfig;)V", "Landroidx/paging/PagedList;", "previousList", "currentList", "Ljava/lang/Runnable;", "commitCallback", "Lr8/z;", "onCurrentListChanged", "(Landroidx/paging/PagedList;Landroidx/paging/PagedList;Ljava/lang/Runnable;)V", "", "index", "getItem", "(I)Ljava/lang/Object;", "pagedList", "submitList", "(Landroidx/paging/PagedList;)V", "(Landroidx/paging/PagedList;Ljava/lang/Runnable;)V", "newList", "diffSnapshot", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "diffResult", "Landroidx/paging/RecordingCallback;", "recordingCallback", "lastAccessIndex", "latchPagedList$paging_runtime_release", "(Landroidx/paging/PagedList;Landroidx/paging/PagedList;Landroidx/recyclerview/widget/DiffUtil$DiffResult;Landroidx/paging/RecordingCallback;ILjava/lang/Runnable;)V", "latchPagedList", "Landroidx/paging/AsyncPagedListDiffer$PagedListListener;", "listener", "addPagedListListener", "(Landroidx/paging/AsyncPagedListDiffer$PagedListListener;)V", "Lkotlin/Function2;", "callback", "(Lc9/p;)V", "removePagedListListener", "Landroidx/paging/LoadType;", "Landroidx/paging/LoadState;", "addLoadStateListener", "removeLoadStateListener", "updateCallback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "getUpdateCallback$paging_runtime_release", "()Landroidx/recyclerview/widget/ListUpdateCallback;", "setUpdateCallback$paging_runtime_release", "(Landroidx/recyclerview/widget/ListUpdateCallback;)V", "Landroidx/recyclerview/widget/AsyncDifferConfig;", "getConfig$paging_runtime_release", "()Landroidx/recyclerview/widget/AsyncDifferConfig;", "getConfig$paging_runtime_release$annotations", "()V", "Ljava/util/concurrent/Executor;", "mainThreadExecutor", "Ljava/util/concurrent/Executor;", "getMainThreadExecutor$paging_runtime_release", "()Ljava/util/concurrent/Executor;", "setMainThreadExecutor$paging_runtime_release", "(Ljava/util/concurrent/Executor;)V", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getListeners$paging_runtime_release", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "getListeners$paging_runtime_release$annotations", "Landroidx/paging/PagedList;", "getPagedList$annotations", "snapshot", "getSnapshot$annotations", "maxScheduledGeneration", "I", "getMaxScheduledGeneration$paging_runtime_release", "()I", "setMaxScheduledGeneration$paging_runtime_release", "(I)V", "getMaxScheduledGeneration$paging_runtime_release$annotations", "Landroidx/paging/PagedList$LoadStateManager;", "loadStateManager", "Landroidx/paging/PagedList$LoadStateManager;", "getLoadStateManager$annotations", "Lkotlin/reflect/KFunction2;", "loadStateListener", "Li9/g;", "", "loadStateListeners", "Ljava/util/List;", "getLoadStateListeners$paging_runtime_release", "()Ljava/util/List;", "Landroidx/paging/PagedList$Callback;", "pagedListCallback", "Landroidx/paging/PagedList$Callback;", "getPagedListCallback$annotations", "getCurrentList", "()Landroidx/paging/PagedList;", "getCurrentList$annotations", "getItemCount", "itemCount", "OnCurrentListChangedWrapper", "PagedListListener", "paging-runtime_release"}, k = 1, mv = {1, 4, 1})
public class AsyncPagedListDiffer<T> {
    private final AsyncDifferConfig<T> config;
    private final CopyOnWriteArrayList<PagedListListener<T>> listeners;
    private final g<z> loadStateListener;
    private final List<p<LoadType, LoadState, z>> loadStateListeners;
    private final PagedList.LoadStateManager loadStateManager;
    private Executor mainThreadExecutor;
    private int maxScheduledGeneration;
    private PagedList<T> pagedList;
    private final PagedList.Callback pagedListCallback;
    private PagedList<T> snapshot;
    public ListUpdateCallback updateCallback;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003B1\u0012(\u0010\u0007\u001a$\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ/\u0010\f\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00052\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\f\u0010\rR9\u0010\u0007\u001a$\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/paging/AsyncPagedListDiffer$OnCurrentListChangedWrapper;", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/paging/AsyncPagedListDiffer$PagedListListener;", "Lkotlin/Function2;", "Landroidx/paging/PagedList;", "Lr8/z;", "callback", "<init>", "(Lc9/p;)V", "previousList", "currentList", "onCurrentListChanged", "(Landroidx/paging/PagedList;Landroidx/paging/PagedList;)V", "Lc9/p;", "getCallback", "()Lc9/p;", "paging-runtime_release"}, k = 1, mv = {1, 4, 1})
    private static final class OnCurrentListChangedWrapper<T> implements PagedListListener<T> {
        private final p<PagedList<T>, PagedList<T>, z> callback;

        /* JADX WARN: Multi-variable type inference failed */
        public OnCurrentListChangedWrapper(p<? super PagedList<T>, ? super PagedList<T>, z> callback) {
            m.f(callback, "callback");
            this.callback = callback;
        }

        public final p<PagedList<T>, PagedList<T>, z> getCallback() {
            return this.callback;
        }

        @Override // androidx.paging.AsyncPagedListDiffer.PagedListListener
        public void onCurrentListChanged(PagedList<T> previousList, PagedList<T> currentList) {
            this.callback.invoke(previousList, currentList);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\u00020\u0001J/\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0003H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/paging/AsyncPagedListDiffer$PagedListListener;", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/paging/PagedList;", "previousList", "currentList", "Lr8/z;", "onCurrentListChanged", "(Landroidx/paging/PagedList;Landroidx/paging/PagedList;)V", "paging-runtime_release"}, k = 1, mv = {1, 4, 1})
    public interface PagedListListener<T> {
        void onCurrentListChanged(PagedList<T> previousList, PagedList<T> currentList);
    }

    /* JADX INFO: renamed from: androidx.paging.AsyncPagedListDiffer$removePagedListListener$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u0002H\u0002 \u0006*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "it", "Landroidx/paging/AsyncPagedListDiffer$PagedListListener;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass1 extends o implements l<PagedListListener<T>, Boolean> {
        final /* synthetic */ p $callback;

        @Override // c9.l
        public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
            return Boolean.valueOf(invoke((PagedListListener) obj));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(p pVar) {
            super(1);
            this.$callback = pVar;
        }

        public final boolean invoke(PagedListListener<T> pagedListListener) {
            return (pagedListListener instanceof OnCurrentListChangedWrapper) && ((OnCurrentListChangedWrapper) pagedListListener).getCallback() == this.$callback;
        }
    }

    public AsyncPagedListDiffer(RecyclerView.Adapter<?> adapter, DiffUtil.ItemCallback<T> diffCallback) {
        m.f(adapter, "adapter");
        m.f(diffCallback, "diffCallback");
        Executor mainThreadExecutor = ArchTaskExecutor.getMainThreadExecutor();
        m.e(mainThreadExecutor, "ArchTaskExecutor.getMainThreadExecutor()");
        this.mainThreadExecutor = mainThreadExecutor;
        this.listeners = new CopyOnWriteArrayList<>();
        PagedList.LoadStateManager loadStateManager = new PagedList.LoadStateManager() { // from class: androidx.paging.AsyncPagedListDiffer$loadStateManager$1
            @Override // androidx.paging.PagedList.LoadStateManager
            public void onStateChanged(LoadType type, LoadState state) {
                m.f(type, "type");
                m.f(state, "state");
                Iterator<T> it = this.this$0.getLoadStateListeners$paging_runtime_release().iterator();
                while (it.hasNext()) {
                    ((p) it.next()).invoke(type, state);
                }
            }
        };
        this.loadStateManager = loadStateManager;
        this.loadStateListener = new AsyncPagedListDiffer$loadStateListener$1(loadStateManager);
        this.loadStateListeners = new CopyOnWriteArrayList();
        this.pagedListCallback = new PagedList.Callback() { // from class: androidx.paging.AsyncPagedListDiffer$pagedListCallback$1
            @Override // androidx.paging.PagedList.Callback
            public void onChanged(int position, int count) {
                this.this$0.getUpdateCallback$paging_runtime_release().onChanged(position, count, null);
            }

            @Override // androidx.paging.PagedList.Callback
            public void onInserted(int position, int count) {
                this.this$0.getUpdateCallback$paging_runtime_release().onInserted(position, count);
            }

            @Override // androidx.paging.PagedList.Callback
            public void onRemoved(int position, int count) {
                this.this$0.getUpdateCallback$paging_runtime_release().onRemoved(position, count);
            }
        };
        this.updateCallback = new AdapterListUpdateCallback(adapter);
        AsyncDifferConfig<T> asyncDifferConfigBuild = new AsyncDifferConfig.Builder(diffCallback).build();
        m.e(asyncDifferConfigBuild, "AsyncDifferConfig.Builder(diffCallback).build()");
        this.config = asyncDifferConfigBuild;
    }

    public void addPagedListListener(PagedListListener<T> listener) {
        m.f(listener, "listener");
        this.listeners.add(listener);
    }

    public void removePagedListListener(PagedListListener<T> listener) {
        m.f(listener, "listener");
        this.listeners.remove(listener);
    }

    public void submitList(PagedList<T> pagedList) {
        submitList(pagedList, null);
    }

    private final void onCurrentListChanged(PagedList<T> previousList, PagedList<T> currentList, Runnable commitCallback) {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((PagedListListener) it.next()).onCurrentListChanged(previousList, currentList);
        }
        if (commitCallback != null) {
            commitCallback.run();
        }
    }

    public void addLoadStateListener(p<? super LoadType, ? super LoadState, z> listener) {
        m.f(listener, "listener");
        PagedList<T> pagedList = this.pagedList;
        if (pagedList != null) {
            pagedList.addWeakLoadStateListener(listener);
        } else {
            this.loadStateManager.dispatchCurrentLoadState(listener);
        }
        this.loadStateListeners.add(listener);
    }

    public final void addPagedListListener(p<? super PagedList<T>, ? super PagedList<T>, z> callback) {
        m.f(callback, "callback");
        this.listeners.add(new OnCurrentListChangedWrapper(callback));
    }

    public final AsyncDifferConfig<T> getConfig$paging_runtime_release() {
        return this.config;
    }

    public PagedList<T> getCurrentList() {
        PagedList<T> pagedList = this.snapshot;
        return pagedList != null ? pagedList : this.pagedList;
    }

    public T getItem(int index) {
        PagedList<T> pagedList = this.snapshot;
        PagedList<T> pagedList2 = this.pagedList;
        if (pagedList != null) {
            return pagedList.get(index);
        }
        if (pagedList2 == null) {
            throw new IndexOutOfBoundsException("Item count is zero, getItem() call is invalid");
        }
        pagedList2.loadAround(index);
        return pagedList2.get(index);
    }

    public final CopyOnWriteArrayList<PagedListListener<T>> getListeners$paging_runtime_release() {
        return this.listeners;
    }

    public final List<p<LoadType, LoadState, z>> getLoadStateListeners$paging_runtime_release() {
        return this.loadStateListeners;
    }

    /* JADX INFO: renamed from: getMainThreadExecutor$paging_runtime_release, reason: from getter */
    public final Executor getMainThreadExecutor() {
        return this.mainThreadExecutor;
    }

    /* JADX INFO: renamed from: getMaxScheduledGeneration$paging_runtime_release, reason: from getter */
    public final int getMaxScheduledGeneration() {
        return this.maxScheduledGeneration;
    }

    public final ListUpdateCallback getUpdateCallback$paging_runtime_release() {
        ListUpdateCallback listUpdateCallback = this.updateCallback;
        if (listUpdateCallback == null) {
            m.v("updateCallback");
        }
        return listUpdateCallback;
    }

    public final void latchPagedList$paging_runtime_release(PagedList<T> newList, PagedList<T> diffSnapshot, DiffUtil.DiffResult diffResult, RecordingCallback recordingCallback, int lastAccessIndex, Runnable commitCallback) {
        m.f(newList, "newList");
        m.f(diffSnapshot, "diffSnapshot");
        m.f(diffResult, "diffResult");
        m.f(recordingCallback, "recordingCallback");
        PagedList<T> pagedList = this.snapshot;
        if (pagedList == null || this.pagedList != null) {
            throw new IllegalStateException("must be in snapshot state to apply diff");
        }
        this.pagedList = newList;
        newList.addWeakLoadStateListener((p) this.loadStateListener);
        this.snapshot = null;
        NullPaddedList<T> nullPaddedList = pagedList.getNullPaddedList();
        ListUpdateCallback listUpdateCallback = this.updateCallback;
        if (listUpdateCallback == null) {
            m.v("updateCallback");
        }
        NullPaddedListDiffHelperKt.dispatchDiff(nullPaddedList, listUpdateCallback, pagedList.getNullPaddedList(), diffResult);
        recordingCallback.dispatchRecordingTo(this.pagedListCallback);
        newList.addWeakCallback(this.pagedListCallback);
        if (!newList.isEmpty()) {
            newList.loadAround(f.h(NullPaddedListDiffHelperKt.transformAnchorIndex(pagedList.getNullPaddedList(), diffResult, diffSnapshot.getNullPaddedList(), lastAccessIndex), 0, newList.size() - 1));
        }
        onCurrentListChanged(pagedList, this.pagedList, commitCallback);
    }

    public void removeLoadStateListener(p<? super LoadType, ? super LoadState, z> listener) {
        m.f(listener, "listener");
        this.loadStateListeners.remove(listener);
        PagedList<T> pagedList = this.pagedList;
        if (pagedList != null) {
            pagedList.removeWeakLoadStateListener(listener);
        }
    }

    public final void removePagedListListener(p<? super PagedList<T>, ? super PagedList<T>, z> callback) {
        m.f(callback, "callback");
        r.I(this.listeners, new AnonymousClass1(callback));
    }

    public final void setMainThreadExecutor$paging_runtime_release(Executor executor) {
        m.f(executor, "<set-?>");
        this.mainThreadExecutor = executor;
    }

    public final void setMaxScheduledGeneration$paging_runtime_release(int i10) {
        this.maxScheduledGeneration = i10;
    }

    public final void setUpdateCallback$paging_runtime_release(ListUpdateCallback listUpdateCallback) {
        m.f(listUpdateCallback, "<set-?>");
        this.updateCallback = listUpdateCallback;
    }

    public void submitList(final PagedList<T> pagedList, final Runnable commitCallback) {
        final int i10 = this.maxScheduledGeneration + 1;
        this.maxScheduledGeneration = i10;
        if (pagedList == this.pagedList) {
            if (commitCallback != null) {
                commitCallback.run();
                return;
            }
            return;
        }
        PagedList<T> currentList = getCurrentList();
        if (pagedList == null) {
            int itemCount = getItemCount();
            PagedList<T> pagedList2 = this.pagedList;
            if (pagedList2 != null) {
                pagedList2.removeWeakCallback(this.pagedListCallback);
                pagedList2.removeWeakLoadStateListener((p) this.loadStateListener);
                this.pagedList = null;
            } else if (this.snapshot != null) {
                this.snapshot = null;
            }
            ListUpdateCallback listUpdateCallback = this.updateCallback;
            if (listUpdateCallback == null) {
                m.v("updateCallback");
            }
            listUpdateCallback.onRemoved(0, itemCount);
            onCurrentListChanged(currentList, null, commitCallback);
            return;
        }
        if (getCurrentList() == null) {
            this.pagedList = pagedList;
            pagedList.addWeakLoadStateListener((p) this.loadStateListener);
            pagedList.addWeakCallback(this.pagedListCallback);
            ListUpdateCallback listUpdateCallback2 = this.updateCallback;
            if (listUpdateCallback2 == null) {
                m.v("updateCallback");
            }
            listUpdateCallback2.onInserted(0, pagedList.size());
            onCurrentListChanged(null, pagedList, commitCallback);
            return;
        }
        PagedList<T> pagedList3 = this.pagedList;
        if (pagedList3 != null) {
            pagedList3.removeWeakCallback(this.pagedListCallback);
            pagedList3.removeWeakLoadStateListener((p) this.loadStateListener);
            List<T> listSnapshot = pagedList3.snapshot();
            if (listSnapshot == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.paging.PagedList<T>");
            }
            this.snapshot = (PagedList) listSnapshot;
            this.pagedList = null;
        }
        final PagedList<T> pagedList4 = this.snapshot;
        if (pagedList4 == null || this.pagedList != null) {
            throw new IllegalStateException("must be in snapshot state to diff");
        }
        List<T> listSnapshot2 = pagedList.snapshot();
        if (listSnapshot2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.paging.PagedList<T>");
        }
        final PagedList pagedList5 = (PagedList) listSnapshot2;
        final RecordingCallback recordingCallback = new RecordingCallback();
        pagedList.addWeakCallback(recordingCallback);
        this.config.getBackgroundThreadExecutor().execute(new Runnable() { // from class: androidx.paging.AsyncPagedListDiffer.submitList.2
            @Override // java.lang.Runnable
            public final void run() {
                NullPaddedList<T> nullPaddedList = pagedList4.getNullPaddedList();
                NullPaddedList<T> nullPaddedList2 = pagedList5.getNullPaddedList();
                DiffUtil.ItemCallback<T> diffCallback = AsyncPagedListDiffer.this.getConfig$paging_runtime_release().getDiffCallback();
                m.e(diffCallback, "config.diffCallback");
                final DiffUtil.DiffResult diffResultComputeDiff = NullPaddedListDiffHelperKt.computeDiff(nullPaddedList, nullPaddedList2, diffCallback);
                AsyncPagedListDiffer.this.getMainThreadExecutor().execute(new Runnable() { // from class: androidx.paging.AsyncPagedListDiffer.submitList.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        int maxScheduledGeneration = AsyncPagedListDiffer.this.getMaxScheduledGeneration();
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        if (maxScheduledGeneration == i10) {
                            AsyncPagedListDiffer.this.latchPagedList$paging_runtime_release(pagedList, pagedList5, diffResultComputeDiff, recordingCallback, pagedList4.lastLoad(), commitCallback);
                        }
                    }
                });
            }
        });
    }

    public int getItemCount() {
        PagedList<T> currentList = getCurrentList();
        if (currentList != null) {
            return currentList.size();
        }
        return 0;
    }

    public AsyncPagedListDiffer(ListUpdateCallback listUpdateCallback, AsyncDifferConfig<T> config) {
        m.f(listUpdateCallback, "listUpdateCallback");
        m.f(config, "config");
        Executor mainThreadExecutor = ArchTaskExecutor.getMainThreadExecutor();
        m.e(mainThreadExecutor, "ArchTaskExecutor.getMainThreadExecutor()");
        this.mainThreadExecutor = mainThreadExecutor;
        this.listeners = new CopyOnWriteArrayList<>();
        PagedList.LoadStateManager loadStateManager = new PagedList.LoadStateManager() { // from class: androidx.paging.AsyncPagedListDiffer$loadStateManager$1
            @Override // androidx.paging.PagedList.LoadStateManager
            public void onStateChanged(LoadType type, LoadState state) {
                m.f(type, "type");
                m.f(state, "state");
                Iterator<T> it = this.this$0.getLoadStateListeners$paging_runtime_release().iterator();
                while (it.hasNext()) {
                    ((p) it.next()).invoke(type, state);
                }
            }
        };
        this.loadStateManager = loadStateManager;
        this.loadStateListener = new AsyncPagedListDiffer$loadStateListener$1(loadStateManager);
        this.loadStateListeners = new CopyOnWriteArrayList();
        this.pagedListCallback = new PagedList.Callback() { // from class: androidx.paging.AsyncPagedListDiffer$pagedListCallback$1
            @Override // androidx.paging.PagedList.Callback
            public void onChanged(int position, int count) {
                this.this$0.getUpdateCallback$paging_runtime_release().onChanged(position, count, null);
            }

            @Override // androidx.paging.PagedList.Callback
            public void onInserted(int position, int count) {
                this.this$0.getUpdateCallback$paging_runtime_release().onInserted(position, count);
            }

            @Override // androidx.paging.PagedList.Callback
            public void onRemoved(int position, int count) {
                this.this$0.getUpdateCallback$paging_runtime_release().onRemoved(position, count);
            }
        };
        this.updateCallback = listUpdateCallback;
        this.config = config;
    }

    public static /* synthetic */ void getConfig$paging_runtime_release$annotations() {
    }

    public static /* synthetic */ void getCurrentList$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getListeners$paging_runtime_release$annotations() {
    }

    private static /* synthetic */ void getLoadStateManager$annotations() {
    }

    public static /* synthetic */ void getMaxScheduledGeneration$paging_runtime_release$annotations() {
    }

    private static /* synthetic */ void getPagedList$annotations() {
    }

    private static /* synthetic */ void getPagedListCallback$annotations() {
    }

    private static /* synthetic */ void getSnapshot$annotations() {
    }
}
