package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import c9.p;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ)\u0010\u000e\u001a\u00020\u00072\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\u00020\u00148\u0016X\u0096D¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u00148\u0016X\u0096D¢\u0006\f\n\u0004\b\u0018\u0010\u0016\u001a\u0004\b\u0018\u0010\u0017R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0019R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Landroidx/paging/SnapshotPagedList;", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/paging/PagedList;", "pagedList", "<init>", "(Landroidx/paging/PagedList;)V", "Lr8/z;", "detach", "()V", "Lkotlin/Function2;", "Landroidx/paging/LoadType;", "Landroidx/paging/LoadState;", "callback", "dispatchCurrentLoadState", "(Lc9/p;)V", "", "index", "loadAroundInternal", "(I)V", "", "isImmutable", "Z", "()Z", "isDetached", "Landroidx/paging/PagedList;", "getLastKey", "()Ljava/lang/Object;", "lastKey", "paging-common"}, k = 1, mv = {1, 4, 1})
public final class SnapshotPagedList<T> extends PagedList<T> {
    private final boolean isDetached;
    private final boolean isImmutable;
    private final PagedList<T> pagedList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnapshotPagedList(PagedList<T> pagedList) {
        super(pagedList.getPagingSource(), pagedList.getCoroutineScope(), pagedList.getNotifyDispatcher(), pagedList.getStorage$paging_common().snapshot(), pagedList.getConfig());
        m.f(pagedList, "pagedList");
        this.pagedList = pagedList;
        this.isImmutable = true;
        this.isDetached = true;
    }

    @Override // androidx.paging.PagedList
    public void dispatchCurrentLoadState(p<? super LoadType, ? super LoadState, z> callback) {
        m.f(callback, "callback");
    }

    @Override // androidx.paging.PagedList
    public Object getLastKey() {
        return this.pagedList.getLastKey();
    }

    @Override // androidx.paging.PagedList
    /* JADX INFO: renamed from: isDetached, reason: from getter */
    public boolean getIsDetached() {
        return this.isDetached;
    }

    @Override // androidx.paging.PagedList
    /* JADX INFO: renamed from: isImmutable, reason: from getter */
    public boolean getIsImmutable() {
        return this.isImmutable;
    }

    @Override // androidx.paging.PagedList
    public void detach() {
    }

    @Override // androidx.paging.PagedList
    public void loadAroundInternal(int index) {
    }
}
