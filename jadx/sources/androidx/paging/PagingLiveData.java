package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import androidx.p000lifecycle.FlowLiveDataConversions;
import androidx.p000lifecycle.Lifecycle;
import androidx.p000lifecycle.LifecycleKt;
import androidx.p000lifecycle.LiveData;
import androidx.p000lifecycle.ViewModel;
import androidx.p000lifecycle.ViewModelKt;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.l0;
import v8.j;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a;\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a;\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00022\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\n\u001a;\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0006\u0010\r\"A\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u0002\"\b\b\u0000\u0010\u000e*\u00020\u0000\"\b\b\u0001\u0010\u000f*\u00020\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagingData;", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "cachedIn", "(Landroidx/lifecycle/LiveData;Landroidx/lifecycle/Lifecycle;)Landroidx/lifecycle/LiveData;", "Landroidx/lifecycle/ViewModel;", "viewModel", "(Landroidx/lifecycle/LiveData;Landroidx/lifecycle/ViewModel;)Landroidx/lifecycle/LiveData;", "Lkotlinx/coroutines/l0;", "scope", "(Landroidx/lifecycle/LiveData;Lkotlinx/coroutines/l0;)Landroidx/lifecycle/LiveData;", "Key", "Value", "Landroidx/paging/Pager;", "getLiveData", "(Landroidx/paging/Pager;)Landroidx/lifecycle/LiveData;", "liveData", "paging-runtime_release"}, k = 2, mv = {1, 4, 1})
public final class PagingLiveData {
    public static final <T> LiveData<PagingData<T>> cachedIn(LiveData<PagingData<T>> cachedIn, Lifecycle lifecycle) {
        m.f(cachedIn, "$this$cachedIn");
        m.f(lifecycle, "lifecycle");
        return FlowLiveDataConversions.asLiveData$default(CachedPagingDataKt.cachedIn(FlowLiveDataConversions.asFlow(cachedIn), LifecycleKt.getCoroutineScope(lifecycle)), (j) null, 0L, 3, (Object) null);
    }

    public static final <Key, Value> LiveData<PagingData<Value>> getLiveData(Pager<Key, Value> liveData) {
        m.f(liveData, "$this$liveData");
        return FlowLiveDataConversions.asLiveData$default(liveData.getFlow(), (j) null, 0L, 3, (Object) null);
    }

    public static final <T> LiveData<PagingData<T>> cachedIn(LiveData<PagingData<T>> cachedIn, ViewModel viewModel) {
        m.f(cachedIn, "$this$cachedIn");
        m.f(viewModel, "viewModel");
        return FlowLiveDataConversions.asLiveData$default(CachedPagingDataKt.cachedIn(FlowLiveDataConversions.asFlow(cachedIn), ViewModelKt.getViewModelScope(viewModel)), (j) null, 0L, 3, (Object) null);
    }

    public static final <T> LiveData<PagingData<T>> cachedIn(LiveData<PagingData<T>> cachedIn, l0 scope) {
        m.f(cachedIn, "$this$cachedIn");
        m.f(scope, "scope");
        return FlowLiveDataConversions.asLiveData$default(CachedPagingDataKt.cachedIn(FlowLiveDataConversions.asFlow(cachedIn), scope), (j) null, 0L, 3, (Object) null);
    }
}
