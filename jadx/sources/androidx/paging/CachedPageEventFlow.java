package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import androidx.paging.multicast.Multicaster;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.flow.f;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.l0;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B#\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u000b\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R&\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00140\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R)\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00038\u0006¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Landroidx/paging/CachedPageEventFlow;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/f;", "Landroidx/paging/PageEvent;", "src", "Lkotlinx/coroutines/l0;", "scope", "<init>", "(Lkotlinx/coroutines/flow/f;Lkotlinx/coroutines/l0;)V", "Lr8/z;", "close", "(Lv8/f;)Ljava/lang/Object;", "Landroidx/paging/FlattenedPageController;", "pageController", "Landroidx/paging/FlattenedPageController;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "collectedFromSource", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Landroidx/paging/multicast/Multicaster;", "Lkotlin/collections/h0;", "multicastedSrc", "Landroidx/paging/multicast/Multicaster;", "downstreamFlow", "Lkotlinx/coroutines/flow/f;", "getDownstreamFlow", "()Lkotlinx/coroutines/flow/f;", "getDownstreamFlow$annotations", "()V", "paging-common"}, k = 1, mv = {1, 4, 1})
public final class CachedPageEventFlow<T> {
    private final AtomicBoolean collectedFromSource;
    private final f<PageEvent<T>> downstreamFlow;
    private final Multicaster<IndexedValue<PageEvent<T>>> multicastedSrc;
    private final FlattenedPageController<T> pageController;

    public CachedPageEventFlow(f<? extends PageEvent<T>> src, l0 scope) {
        m.f(src, "src");
        m.f(scope, "scope");
        FlattenedPageController<T> flattenedPageController = new FlattenedPageController<>();
        this.pageController = flattenedPageController;
        this.collectedFromSource = new AtomicBoolean(false);
        this.multicastedSrc = new Multicaster<>(scope, 0, h.v(new CachedPageEventFlow$multicastedSrc$1(this, src, null)), false, new CachedPageEventFlow$multicastedSrc$2(flattenedPageController), true, 8, null);
        this.downstreamFlow = h.h(new CachedPageEventFlow$downstreamFlow$1(this, null));
    }

    public final Object close(v8.f<? super z> fVar) {
        Object objClose = this.multicastedSrc.close(fVar);
        return objClose == b.c() ? objClose : z.f17874a;
    }

    public final f<PageEvent<T>> getDownstreamFlow() {
        return this.downstreamFlow;
    }

    public static /* synthetic */ void getDownstreamFlow$annotations() {
    }
}
