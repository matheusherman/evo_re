package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import c9.p;
import kotlin.Metadata;
import kotlin.jvm.internal.o;
import r8.z;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Landroidx/paging/PagedList;", "previousList", "currentList", "Lr8/z;", "invoke", "(Landroidx/paging/PagedList;Landroidx/paging/PagedList;)V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final class PagedListAdapter$listener$1<T> extends o implements p<PagedList<T>, PagedList<T>, z> {
    final /* synthetic */ PagedListAdapter this$0;

    @Override // c9.p
    public /* bridge */ /* synthetic */ z invoke(Object obj, Object obj2) {
        invoke((PagedList) obj, (PagedList) obj2);
        return z.f17874a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PagedListAdapter$listener$1(PagedListAdapter pagedListAdapter) {
        super(2);
        this.this$0 = pagedListAdapter;
    }

    public final void invoke(PagedList<T> pagedList, PagedList<T> pagedList2) {
        this.this$0.onCurrentListChanged(pagedList2);
        this.this$0.onCurrentListChanged(pagedList, pagedList2);
    }
}
