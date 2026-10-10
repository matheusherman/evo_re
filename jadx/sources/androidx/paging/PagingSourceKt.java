package androidx.paging;

import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u0001H\u0002H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"toRefreshLoadParams", "Landroidx/paging/PagingSource$LoadParams;", "Key", "", "Landroidx/paging/PagedList$Config;", "key", "(Landroidx/paging/PagedList$Config;Ljava/lang/Object;)Landroidx/paging/PagingSource$LoadParams;", "paging-common"}, k = 2, mv = {1, 4, 1})
public final class PagingSourceKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <Key> PagingSource.LoadParams<Key> toRefreshLoadParams(PagedList.Config toRefreshLoadParams, Key key) {
        m.f(toRefreshLoadParams, "$this$toRefreshLoadParams");
        return new PagingSource.LoadParams.Refresh(key, toRefreshLoadParams.initialLoadSizeHint, toRefreshLoadParams.enablePlaceholders);
    }
}
