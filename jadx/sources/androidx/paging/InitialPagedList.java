package androidx.paging;

import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.l0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004BE\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/paging/InitialPagedList;", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/paging/ContiguousPagedList;", "Landroidx/paging/PagingSource;", "pagingSource", "Lkotlinx/coroutines/l0;", "coroutineScope", "Lkotlinx/coroutines/i0;", "notifyDispatcher", "backgroundDispatcher", "Landroidx/paging/PagedList$Config;", "config", "initialLastKey", "<init>", "(Landroidx/paging/PagingSource;Lkotlinx/coroutines/l0;Lkotlinx/coroutines/i0;Lkotlinx/coroutines/i0;Landroidx/paging/PagedList$Config;Ljava/lang/Object;)V", "paging-common"}, k = 1, mv = {1, 4, 1})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class InitialPagedList<K, V> extends ContiguousPagedList<K, V> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InitialPagedList(PagingSource<K, V> pagingSource, l0 coroutineScope, i0 notifyDispatcher, i0 backgroundDispatcher, PagedList.Config config, K k10) {
        super(pagingSource, coroutineScope, notifyDispatcher, backgroundDispatcher, null, config, PagingSource.LoadResult.Page.INSTANCE.empty$paging_common(), k10);
        m.f(pagingSource, "pagingSource");
        m.f(coroutineScope, "coroutineScope");
        m.f(notifyDispatcher, "notifyDispatcher");
        m.f(backgroundDispatcher, "backgroundDispatcher");
        m.f(config, "config");
    }
}
