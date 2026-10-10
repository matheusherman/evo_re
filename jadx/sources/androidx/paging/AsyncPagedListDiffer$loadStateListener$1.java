package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import c9.p;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/paging/LoadType;", "p1", "Landroidx/paging/LoadState;", "p2", "Lr8/z;", "invoke", "(Landroidx/paging/LoadType;Landroidx/paging/LoadState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final /* synthetic */ class AsyncPagedListDiffer$loadStateListener$1 extends k implements p<LoadType, LoadState, z> {
    @Override // c9.p
    public /* bridge */ /* synthetic */ z invoke(LoadType loadType, LoadState loadState) {
        invoke2(loadType, loadState);
        return z.f17874a;
    }

    AsyncPagedListDiffer$loadStateListener$1(PagedList.LoadStateManager loadStateManager) {
        super(2, loadStateManager, PagedList.LoadStateManager.class, "onStateChanged", "onStateChanged(Landroidx/paging/LoadType;Landroidx/paging/LoadState;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(LoadType p10, LoadState p11) {
        m.f(p10, "p1");
        m.f(p11, "p2");
        ((PagedList.LoadStateManager) this.receiver).onStateChanged(p10, p11);
    }
}
