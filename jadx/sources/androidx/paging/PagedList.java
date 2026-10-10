package androidx.paging;

import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import c9.l;
import c9.p;
import java.lang.ref.WeakReference;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.collections.r;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m1;
import kotlinx.coroutines.n1;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000e\b'\u0018\u0000 r*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0006sturvwBA\b\u0000\u0012\u0010\u0010\u0005\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u001b\u001a\u00020\u00192\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0016H'¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0013H'¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0019H&¢\u0006\u0004\b \u0010!J\u001f\u0010$\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0018H\u0017¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0019H\u0016¢\u0006\u0004\b&\u0010!J\u0019\u0010)\u001a\u00020\u00192\b\u0010(\u001a\u0004\u0018\u00010'H\u0007¢\u0006\u0004\b)\u0010*J\u001f\u0010.\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u0018H\u0000¢\u0006\u0004\b-\u0010%J\u001a\u0010/\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001d\u001a\u00020\u0013H\u0096\u0002¢\u0006\u0004\b/\u00100J\u0015\u00101\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0013¢\u0006\u0004\b1\u0010\u001fJ\u0013\u00103\u001a\b\u0012\u0004\u0012\u00028\u000002¢\u0006\u0004\b3\u00104J'\u00106\u001a\u00020\u00192\u0018\u00105\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0016¢\u0006\u0004\b6\u0010\u001cJ'\u00107\u001a\u00020\u00192\u0018\u00105\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0016¢\u0006\u0004\b7\u0010\u001cJ'\u0010:\u001a\u00020\u00192\u000e\u00108\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001022\u0006\u0010\u001a\u001a\u000209H\u0007¢\u0006\u0004\b:\u0010;J\u0015\u0010:\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u000209¢\u0006\u0004\b:\u0010<J\u0015\u0010=\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u000209¢\u0006\u0004\b=\u0010<J\u001f\u0010B\u001a\u00020\u00192\u0006\u0010>\u001a\u00020\u00132\u0006\u0010?\u001a\u00020\u0013H\u0000¢\u0006\u0004\b@\u0010AJ\u001f\u0010C\u001a\u00020\u00192\u0006\u0010>\u001a\u00020\u00132\u0006\u0010?\u001a\u00020\u0013H\u0007¢\u0006\u0004\bC\u0010AJ\u001f\u0010D\u001a\u00020\u00192\u0006\u0010>\u001a\u00020\u00132\u0006\u0010?\u001a\u00020\u0013H\u0007¢\u0006\u0004\bD\u0010AR$\u0010(\u001a\u0004\u0018\u00010'8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b(\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010*R\u001a\u0010I\u001a\u00020\u00138\u0000X\u0080\u0004¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010\u0015R \u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090M0L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR2\u0010P\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00160M0L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010OR$\u0010\u0005\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u00048\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0005\u0010Q\u001a\u0004\bR\u0010SR\u001a\u0010\u0007\u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010T\u001a\u0004\bU\u0010VR\u001a\u0010\t\u001a\u00020\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010W\u001a\u0004\bX\u0010YR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010Z\u001a\u0004\b[\u0010\\R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010]\u001a\u0004\b^\u0010_R$\u0010d\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000`8FX\u0087\u0004¢\u0006\f\u0012\u0004\bc\u0010!\u001a\u0004\ba\u0010bR\u0014\u0010f\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\be\u0010\u0015R\u0016\u0010i\u001a\u0004\u0018\u00010\u00018&X¦\u0004¢\u0006\u0006\u001a\u0004\bg\u0010hR\u0014\u0010k\u001a\u00020j8&X¦\u0004¢\u0006\u0006\u001a\u0004\bk\u0010lR\u0011\u0010n\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\bm\u0010\u0015R\u0014\u0010o\u001a\u00020j8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bo\u0010lR\u0011\u0010q\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\bp\u0010\u0015¨\u0006x"}, d2 = {"Landroidx/paging/PagedList;", "", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/AbstractList;", "Landroidx/paging/PagingSource;", "pagingSource", "Lkotlinx/coroutines/l0;", "coroutineScope", "Lkotlinx/coroutines/i0;", "notifyDispatcher", "Landroidx/paging/PagedStorage;", "storage", "Landroidx/paging/PagedList$Config;", "config", "<init>", "(Landroidx/paging/PagingSource;Lkotlinx/coroutines/l0;Lkotlinx/coroutines/i0;Landroidx/paging/PagedStorage;Landroidx/paging/PagedList$Config;)V", "Landroidx/paging/NullPaddedList;", "getNullPaddedList", "()Landroidx/paging/NullPaddedList;", "", "lastLoad", "()I", "Lkotlin/Function2;", "Landroidx/paging/LoadType;", "Landroidx/paging/LoadState;", "Lr8/z;", "callback", "dispatchCurrentLoadState", "(Lc9/p;)V", "index", "loadAroundInternal", "(I)V", "detach", "()V", "loadType", "loadState", "setInitialLoadState", "(Landroidx/paging/LoadType;Landroidx/paging/LoadState;)V", "retry", "Ljava/lang/Runnable;", "refreshRetryCallback", "setRetryCallback", "(Ljava/lang/Runnable;)V", IjkMediaMeta.IJKM_KEY_TYPE, "state", "dispatchStateChangeAsync$paging_common", "dispatchStateChangeAsync", "get", "(I)Ljava/lang/Object;", "loadAround", "", "snapshot", "()Ljava/util/List;", "listener", "addWeakLoadStateListener", "removeWeakLoadStateListener", "previousSnapshot", "Landroidx/paging/PagedList$Callback;", "addWeakCallback", "(Ljava/util/List;Landroidx/paging/PagedList$Callback;)V", "(Landroidx/paging/PagedList$Callback;)V", "removeWeakCallback", "position", "count", "notifyInserted$paging_common", "(II)V", "notifyInserted", "notifyChanged", "notifyRemoved", "Ljava/lang/Runnable;", "getRefreshRetryCallback$paging_common", "()Ljava/lang/Runnable;", "setRefreshRetryCallback$paging_common", "requiredRemainder", "I", "getRequiredRemainder$paging_common", "", "Ljava/lang/ref/WeakReference;", "callbacks", "Ljava/util/List;", "loadStateListeners", "Landroidx/paging/PagingSource;", "getPagingSource", "()Landroidx/paging/PagingSource;", "Lkotlinx/coroutines/l0;", "getCoroutineScope$paging_common", "()Lkotlinx/coroutines/l0;", "Lkotlinx/coroutines/i0;", "getNotifyDispatcher$paging_common", "()Lkotlinx/coroutines/i0;", "Landroidx/paging/PagedStorage;", "getStorage$paging_common", "()Landroidx/paging/PagedStorage;", "Landroidx/paging/PagedList$Config;", "getConfig", "()Landroidx/paging/PagedList$Config;", "Landroidx/paging/DataSource;", "getDataSource", "()Landroidx/paging/DataSource;", "getDataSource$annotations", "dataSource", "getSize", "size", "getLastKey", "()Ljava/lang/Object;", "lastKey", "", "isDetached", "()Z", "getLoadedCount", "loadedCount", "isImmutable", "getPositionOffset", "positionOffset", "Companion", "BoundaryCallback", "Builder", "Callback", "Config", "LoadStateManager", "paging-common"}, k = 1, mv = {1, 4, 1})
public abstract class PagedList<T> extends AbstractList<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<WeakReference<Callback>> callbacks;
    private final Config config;
    private final l0 coroutineScope;
    private final List<WeakReference<p<LoadType, LoadState, z>>> loadStateListeners;
    private final i0 notifyDispatcher;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    private final PagingSource<?, T> pagingSource;
    private Runnable refreshRetryCallback;
    private final int requiredRemainder;
    private final PagedStorage<T> storage;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Landroidx/paging/PagedList$BoundaryCallback;", "", ExifInterface.GPS_DIRECTION_TRUE, "<init>", "()V", "Lr8/z;", "onZeroItemsLoaded", "itemAtFront", "onItemAtFrontLoaded", "(Ljava/lang/Object;)V", "itemAtEnd", "onItemAtEndLoaded", "paging-common"}, k = 1, mv = {1, 4, 1})
    @MainThread
    public static abstract class BoundaryCallback<T> {
        public void onItemAtEndLoaded(T itemAtEnd) {
            m.f(itemAtEnd, "itemAtEnd");
        }

        public void onItemAtFrontLoaded(T itemAtFront) {
            m.f(itemAtFront, "itemAtFront");
        }

        public void onZeroItemsLoaded() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u0001*\b\b\u0002\u0010\u0003*\u00020\u00012\u00020\u0001B%\b\u0016\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB%\b\u0016\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\b\u0010\fB9\b\u0016\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\u0011B9\b\u0016\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\b\u0010\u0012J!\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0017H\u0007¢\u0006\u0004\b \u0010\u001aJ!\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\u0006\u0010!\u001a\u00020\u001b¢\u0006\u0004\b\"\u0010\u001eJ)\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010#¢\u0006\u0004\b%\u0010&J#\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00018\u0001¢\u0006\u0004\b(\u0010)J\u0013\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00020*¢\u0006\u0004\b+\u0010,R\"\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010-R$\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010.R\"\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010/R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u00100R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u00101R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u00102R\u0018\u0010!\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u00102R\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u00103R\u0018\u0010'\u001a\u0004\u0018\u00018\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u00104¨\u00065"}, d2 = {"Landroidx/paging/PagedList$Builder;", "", "Key", "Value", "Landroidx/paging/DataSource;", "dataSource", "Landroidx/paging/PagedList$Config;", "config", "<init>", "(Landroidx/paging/DataSource;Landroidx/paging/PagedList$Config;)V", "", "pageSize", "(Landroidx/paging/DataSource;I)V", "Landroidx/paging/PagingSource;", "pagingSource", "Landroidx/paging/PagingSource$LoadResult$Page;", "initialPage", "(Landroidx/paging/PagingSource;Landroidx/paging/PagingSource$LoadResult$Page;Landroidx/paging/PagedList$Config;)V", "(Landroidx/paging/PagingSource;Landroidx/paging/PagingSource$LoadResult$Page;I)V", "Lkotlinx/coroutines/l0;", "coroutineScope", "setCoroutineScope", "(Lkotlinx/coroutines/l0;)Landroidx/paging/PagedList$Builder;", "Ljava/util/concurrent/Executor;", "notifyExecutor", "setNotifyExecutor", "(Ljava/util/concurrent/Executor;)Landroidx/paging/PagedList$Builder;", "Lkotlinx/coroutines/i0;", "notifyDispatcher", "setNotifyDispatcher", "(Lkotlinx/coroutines/i0;)Landroidx/paging/PagedList$Builder;", "fetchExecutor", "setFetchExecutor", "fetchDispatcher", "setFetchDispatcher", "Landroidx/paging/PagedList$BoundaryCallback;", "boundaryCallback", "setBoundaryCallback", "(Landroidx/paging/PagedList$BoundaryCallback;)Landroidx/paging/PagedList$Builder;", "initialKey", "setInitialKey", "(Ljava/lang/Object;)Landroidx/paging/PagedList$Builder;", "Landroidx/paging/PagedList;", "build", "()Landroidx/paging/PagedList;", "Landroidx/paging/PagingSource;", "Landroidx/paging/DataSource;", "Landroidx/paging/PagingSource$LoadResult$Page;", "Landroidx/paging/PagedList$Config;", "Lkotlinx/coroutines/l0;", "Lkotlinx/coroutines/i0;", "Landroidx/paging/PagedList$BoundaryCallback;", "Ljava/lang/Object;", "paging-common"}, k = 1, mv = {1, 4, 1})
    public static final class Builder<Key, Value> {
        private BoundaryCallback<Value> boundaryCallback;
        private final Config config;
        private l0 coroutineScope;
        private DataSource<Key, Value> dataSource;
        private i0 fetchDispatcher;
        private Key initialKey;
        private final PagingSource.LoadResult.Page<Key, Value> initialPage;
        private i0 notifyDispatcher;
        private final PagingSource<Key, Value> pagingSource;

        public Builder(DataSource<Key, Value> dataSource, Config config) {
            m.f(dataSource, "dataSource");
            m.f(config, "config");
            this.coroutineScope = n1.f14892a;
            this.pagingSource = null;
            this.dataSource = dataSource;
            this.initialPage = null;
            this.config = config;
        }

        public final PagedList<Value> build() {
            i0 i0VarB = this.fetchDispatcher;
            if (i0VarB == null) {
                i0VarB = a1.b();
            }
            i0 i0Var = i0VarB;
            PagingSource<Key, Value> pagingSource = this.pagingSource;
            if (pagingSource == null) {
                DataSource<Key, Value> dataSource = this.dataSource;
                if (dataSource != null) {
                    LegacyPagingSource legacyPagingSource = new LegacyPagingSource(i0Var, dataSource);
                    legacyPagingSource.setPageSize(this.config.pageSize);
                    pagingSource = legacyPagingSource;
                } else {
                    pagingSource = null;
                }
            }
            PagingSource<Key, Value> pagingSource2 = pagingSource;
            if (!(pagingSource2 != null)) {
                throw new IllegalStateException("PagedList cannot be built without a PagingSource or DataSource");
            }
            Companion companion = PagedList.INSTANCE;
            PagingSource.LoadResult.Page<Key, Value> page = this.initialPage;
            l0 l0Var = this.coroutineScope;
            i0 i0VarD = this.notifyDispatcher;
            if (i0VarD == null) {
                i0VarD = a1.c().getImmediate();
            }
            return companion.create(pagingSource2, page, l0Var, i0VarD, i0Var, this.boundaryCallback, this.config, this.initialKey);
        }

        public final Builder<Key, Value> setBoundaryCallback(BoundaryCallback<Value> boundaryCallback) {
            this.boundaryCallback = boundaryCallback;
            return this;
        }

        public final Builder<Key, Value> setCoroutineScope(l0 coroutineScope) {
            m.f(coroutineScope, "coroutineScope");
            this.coroutineScope = coroutineScope;
            return this;
        }

        public final Builder<Key, Value> setFetchDispatcher(i0 fetchDispatcher) {
            m.f(fetchDispatcher, "fetchDispatcher");
            this.fetchDispatcher = fetchDispatcher;
            return this;
        }

        public final Builder<Key, Value> setFetchExecutor(Executor fetchExecutor) {
            m.f(fetchExecutor, "fetchExecutor");
            this.fetchDispatcher = m1.a(fetchExecutor);
            return this;
        }

        public final Builder<Key, Value> setInitialKey(Key initialKey) {
            this.initialKey = initialKey;
            return this;
        }

        public final Builder<Key, Value> setNotifyDispatcher(i0 notifyDispatcher) {
            m.f(notifyDispatcher, "notifyDispatcher");
            this.notifyDispatcher = notifyDispatcher;
            return this;
        }

        public final Builder<Key, Value> setNotifyExecutor(Executor notifyExecutor) {
            m.f(notifyExecutor, "notifyExecutor");
            this.notifyDispatcher = m1.a(notifyExecutor);
            return this;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(DataSource<Key, Value> dataSource, int i10) {
            this(dataSource, PagedListConfigKt.Config$default(i10, 0, false, 0, 0, 30, null));
            m.f(dataSource, "dataSource");
        }

        public Builder(PagingSource<Key, Value> pagingSource, PagingSource.LoadResult.Page<Key, Value> initialPage, Config config) {
            m.f(pagingSource, "pagingSource");
            m.f(initialPage, "initialPage");
            m.f(config, "config");
            this.coroutineScope = n1.f14892a;
            this.pagingSource = pagingSource;
            this.dataSource = null;
            this.initialPage = initialPage;
            this.config = config;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(PagingSource<Key, Value> pagingSource, PagingSource.LoadResult.Page<Key, Value> initialPage, int i10) {
            this(pagingSource, initialPage, PagedListConfigKt.Config$default(i10, 0, false, 0, 0, 30, null));
            m.f(pagingSource, "pagingSource");
            m.f(initialPage, "initialPage");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\tJ\u001f\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Landroidx/paging/PagedList$Callback;", "", "<init>", "()V", "", "position", "count", "Lr8/z;", "onChanged", "(II)V", "onInserted", "onRemoved", "paging-common"}, k = 1, mv = {1, 4, 1})
    public static abstract class Callback {
        public abstract void onChanged(int position, int count);

        public abstract void onInserted(int position, int count);

        public abstract void onRemoved(int position, int count);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u008d\u0001\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00020\u0014\"\b\b\u0001\u0010\u0004*\u00020\u0001\"\b\b\u0002\u0010\u0005*\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00062\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00018\u0001H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001aH\u0000¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Landroidx/paging/PagedList$Companion;", "", "<init>", "()V", "K", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/paging/PagingSource;", "pagingSource", "Landroidx/paging/PagingSource$LoadResult$Page;", "initialPage", "Lkotlinx/coroutines/l0;", "coroutineScope", "Lkotlinx/coroutines/i0;", "notifyDispatcher", "fetchDispatcher", "Landroidx/paging/PagedList$BoundaryCallback;", "boundaryCallback", "Landroidx/paging/PagedList$Config;", "config", "key", "Landroidx/paging/PagedList;", "create", "(Landroidx/paging/PagingSource;Landroidx/paging/PagingSource$LoadResult$Page;Lkotlinx/coroutines/l0;Lkotlinx/coroutines/i0;Lkotlinx/coroutines/i0;Landroidx/paging/PagedList$BoundaryCallback;Landroidx/paging/PagedList$Config;Ljava/lang/Object;)Landroidx/paging/PagedList;", "", "currentSize", "snapshotSize", "Landroidx/paging/PagedList$Callback;", "callback", "Lr8/z;", "dispatchNaiveUpdatesSinceSnapshot$paging_common", "(IILandroidx/paging/PagedList$Callback;)V", "dispatchNaiveUpdatesSinceSnapshot", "paging-common"}, k = 1, mv = {1, 4, 1})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final <K, T> PagedList<T> create(PagingSource<K, T> pagingSource, PagingSource.LoadResult.Page<K, T> initialPage, l0 coroutineScope, i0 notifyDispatcher, i0 fetchDispatcher, BoundaryCallback<T> boundaryCallback, Config config, K key) {
            K k10;
            m.f(pagingSource, "pagingSource");
            m.f(coroutineScope, "coroutineScope");
            m.f(notifyDispatcher, "notifyDispatcher");
            m.f(fetchDispatcher, "fetchDispatcher");
            m.f(config, "config");
            if (initialPage == null) {
                b0 b0Var = new b0();
                k10 = key;
                b0Var.element = (T) new PagingSource.LoadParams.Refresh(k10, config.initialLoadSizeHint, config.enablePlaceholders);
                initialPage = (PagingSource.LoadResult.Page) i.b(null, new PagedList$Companion$create$resolvedInitialPage$1(pagingSource, b0Var, null), 1, null);
            } else {
                k10 = key;
            }
            return new ContiguousPagedList(pagingSource, coroutineScope, notifyDispatcher, fetchDispatcher, boundaryCallback, config, initialPage, k10);
        }

        public final void dispatchNaiveUpdatesSinceSnapshot$paging_common(int currentSize, int snapshotSize, Callback callback) {
            m.f(callback, "callback");
            if (snapshotSize < currentSize) {
                if (snapshotSize > 0) {
                    callback.onChanged(0, snapshotSize);
                }
                int i10 = currentSize - snapshotSize;
                if (i10 > 0) {
                    callback.onInserted(snapshotSize, i10);
                    return;
                }
                return;
            }
            if (currentSize > 0) {
                callback.onChanged(0, currentSize);
            }
            int i11 = snapshotSize - currentSize;
            if (i11 != 0) {
                callback.onRemoved(currentSize, i11);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\u000b\u0010\nJ'\u0010\u000e\u001a\u00020\b2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\f¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\"\u0010\u0019\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015¨\u0006\u001c"}, d2 = {"Landroidx/paging/PagedList$LoadStateManager;", "", "<init>", "()V", "Landroidx/paging/LoadType;", IjkMediaMeta.IJKM_KEY_TYPE, "Landroidx/paging/LoadState;", "state", "Lr8/z;", "setState", "(Landroidx/paging/LoadType;Landroidx/paging/LoadState;)V", "onStateChanged", "Lkotlin/Function2;", "callback", "dispatchCurrentLoadState", "(Lc9/p;)V", "refreshState", "Landroidx/paging/LoadState;", "getRefreshState", "()Landroidx/paging/LoadState;", "setRefreshState", "(Landroidx/paging/LoadState;)V", "startState", "getStartState", "setStartState", "endState", "getEndState", "setEndState", "paging-common"}, k = 1, mv = {1, 4, 1})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static abstract class LoadStateManager {
        private LoadState endState;
        private LoadState refreshState;
        private LoadState startState;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public abstract void onStateChanged(LoadType type, LoadState state);

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[LoadType.values().length];
                $EnumSwitchMapping$0 = iArr;
                iArr[LoadType.REFRESH.ordinal()] = 1;
                iArr[LoadType.PREPEND.ordinal()] = 2;
                iArr[LoadType.APPEND.ordinal()] = 3;
            }
        }

        public final void dispatchCurrentLoadState(p<? super LoadType, ? super LoadState, z> callback) {
            m.f(callback, "callback");
            callback.invoke(LoadType.REFRESH, this.refreshState);
            callback.invoke(LoadType.PREPEND, this.startState);
            callback.invoke(LoadType.APPEND, this.endState);
        }

        public final LoadState getEndState() {
            return this.endState;
        }

        public final LoadState getRefreshState() {
            return this.refreshState;
        }

        public final LoadState getStartState() {
            return this.startState;
        }

        public final void setEndState(LoadState loadState) {
            m.f(loadState, "<set-?>");
            this.endState = loadState;
        }

        public final void setRefreshState(LoadState loadState) {
            m.f(loadState, "<set-?>");
            this.refreshState = loadState;
        }

        public final void setStartState(LoadState loadState) {
            m.f(loadState, "<set-?>");
            this.startState = loadState;
        }

        public final void setState(LoadType type, LoadState state) {
            m.f(type, "type");
            m.f(state, "state");
            int i10 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        if (m.a(this.endState, state)) {
                            return;
                        } else {
                            this.endState = state;
                        }
                    }
                } else if (m.a(this.startState, state)) {
                    return;
                } else {
                    this.startState = state;
                }
            } else if (m.a(this.refreshState, state)) {
                return;
            } else {
                this.refreshState = state;
            }
            onStateChanged(type, state);
        }

        public LoadStateManager() {
            LoadState.NotLoading.Companion companion = LoadState.NotLoading.INSTANCE;
            this.refreshState = companion.getIncomplete$paging_common();
            this.startState = companion.getIncomplete$paging_common();
            this.endState = companion.getIncomplete$paging_common();
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PagedList$addWeakCallback$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "it", "Ljava/lang/ref/WeakReference;", "Landroidx/paging/PagedList$Callback;", "invoke"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass1 extends o implements l<WeakReference<Callback>, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ Boolean invoke(WeakReference<Callback> weakReference) {
            return Boolean.valueOf(invoke2(weakReference));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(WeakReference<Callback> it) {
            m.f(it, "it");
            return it.get() == null;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PagedList$addWeakLoadStateListener$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u000b\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u00002\u001e\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00030\u0002H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/ref/WeakReference;", "Lkotlin/Function2;", "Landroidx/paging/LoadType;", "Landroidx/paging/LoadState;", "Lr8/z;", "it", "", "invoke", "(Ljava/lang/ref/WeakReference;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class C05511 extends o implements l<WeakReference<p<? super LoadType, ? super LoadState, ? extends z>>, Boolean> {
        public static final C05511 INSTANCE = new C05511();

        C05511() {
            super(1);
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ Boolean invoke(WeakReference<p<? super LoadType, ? super LoadState, ? extends z>> weakReference) {
            return Boolean.valueOf(invoke2((WeakReference<p<LoadType, LoadState, z>>) weakReference));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(WeakReference<p<LoadType, LoadState, z>> it) {
            m.f(it, "it");
            return it.get() == null;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PagedList$removeWeakCallback$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "it", "Ljava/lang/ref/WeakReference;", "Landroidx/paging/PagedList$Callback;", "invoke"}, k = 3, mv = {1, 4, 1})
    static final class C05521 extends o implements l<WeakReference<Callback>, Boolean> {
        final /* synthetic */ Callback $callback;

        @Override // c9.l
        public /* bridge */ /* synthetic */ Boolean invoke(WeakReference<Callback> weakReference) {
            return Boolean.valueOf(invoke2(weakReference));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05521(Callback callback) {
            super(1);
            this.$callback = callback;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(WeakReference<Callback> it) {
            m.f(it, "it");
            return it.get() == null || it.get() == this.$callback;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PagedList$removeWeakLoadStateListener$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u000b\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u00002\u001e\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00030\u0002H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/ref/WeakReference;", "Lkotlin/Function2;", "Landroidx/paging/LoadType;", "Landroidx/paging/LoadState;", "Lr8/z;", "it", "", "invoke", "(Ljava/lang/ref/WeakReference;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class C05531 extends o implements l<WeakReference<p<? super LoadType, ? super LoadState, ? extends z>>, Boolean> {
        final /* synthetic */ p $listener;

        @Override // c9.l
        public /* bridge */ /* synthetic */ Boolean invoke(WeakReference<p<? super LoadType, ? super LoadState, ? extends z>> weakReference) {
            return Boolean.valueOf(invoke2((WeakReference<p<LoadType, LoadState, z>>) weakReference));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05531(p pVar) {
            super(1);
            this.$listener = pVar;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(WeakReference<p<LoadType, LoadState, z>> it) {
            m.f(it, "it");
            return it.get() == null || it.get() == this.$listener;
        }
    }

    public final void addWeakCallback(List<? extends T> previousSnapshot, Callback callback) {
        m.f(callback, "callback");
        if (previousSnapshot != null && previousSnapshot != this) {
            INSTANCE.dispatchNaiveUpdatesSinceSnapshot$paging_common(size(), previousSnapshot.size(), callback);
        }
        addWeakCallback(callback);
    }

    public abstract void detach();

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public abstract void dispatchCurrentLoadState(p<? super LoadType, ? super LoadState, z> callback);

    public abstract Object getLastKey();

    /* JADX INFO: renamed from: isDetached */
    public abstract boolean getIsDetached();

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public abstract void loadAroundInternal(int index);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0002\n\u000bB/\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/paging/PagedList$Config;", "", "pageSize", "", "prefetchDistance", "enablePlaceholders", "", "initialLoadSizeHint", "maxSize", "(IIZII)V", "Builder", "Companion", "paging-common"}, k = 1, mv = {1, 4, 1})
    public static final class Config {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int MAX_SIZE_UNBOUNDED = Integer.MAX_VALUE;
        public final boolean enablePlaceholders;
        public final int initialLoadSizeHint;
        public final int maxSize;
        public final int pageSize;
        public final int prefetchDistance;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010\r\u001a\u00020\u00002\b\b\u0001\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u000e\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u000f\u001a\u00020\u00002\b\b\u0001\u0010\b\u001a\u00020\u0006J\u0010\u0010\u0010\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/paging/PagedList$Config$Builder;", "", "()V", "enablePlaceholders", "", "initialLoadSizeHint", "", "maxSize", "pageSize", "prefetchDistance", "build", "Landroidx/paging/PagedList$Config;", "setEnablePlaceholders", "setInitialLoadSizeHint", "setMaxSize", "setPageSize", "setPrefetchDistance", "Companion", "paging-common"}, k = 1, mv = {1, 4, 1})
        public static final class Builder {
            public static final int DEFAULT_INITIAL_PAGE_MULTIPLIER = 3;
            private int pageSize = -1;
            private int prefetchDistance = -1;
            private int initialLoadSizeHint = -1;
            private boolean enablePlaceholders = true;
            private int maxSize = Integer.MAX_VALUE;

            public final Builder setPageSize(@IntRange(from = 1) int pageSize) {
                if (pageSize < 1) {
                    throw new IllegalArgumentException("Page size must be a positive number");
                }
                this.pageSize = pageSize;
                return this;
            }

            public final Config build() {
                if (this.prefetchDistance < 0) {
                    this.prefetchDistance = this.pageSize;
                }
                if (this.initialLoadSizeHint < 0) {
                    this.initialLoadSizeHint = this.pageSize * 3;
                }
                if (!this.enablePlaceholders && this.prefetchDistance == 0) {
                    throw new IllegalArgumentException("Placeholders and prefetch are the only ways to trigger loading of more data in the PagedList, so either placeholders must be enabled, or prefetch distance must be > 0.");
                }
                int i10 = this.maxSize;
                if (i10 == Integer.MAX_VALUE || i10 >= this.pageSize + (this.prefetchDistance * 2)) {
                    return new Config(this.pageSize, this.prefetchDistance, this.enablePlaceholders, this.initialLoadSizeHint, this.maxSize);
                }
                throw new IllegalArgumentException("Maximum size must be at least pageSize + 2*prefetchDist, pageSize=" + this.pageSize + ", prefetchDist=" + this.prefetchDistance + ", maxSize=" + this.maxSize);
            }

            public final Builder setEnablePlaceholders(boolean enablePlaceholders) {
                this.enablePlaceholders = enablePlaceholders;
                return this;
            }

            public final Builder setInitialLoadSizeHint(@IntRange(from = 1) int initialLoadSizeHint) {
                this.initialLoadSizeHint = initialLoadSizeHint;
                return this;
            }

            public final Builder setMaxSize(@IntRange(from = 2) int maxSize) {
                this.maxSize = maxSize;
                return this;
            }

            public final Builder setPrefetchDistance(@IntRange(from = 0) int prefetchDistance) {
                this.prefetchDistance = prefetchDistance;
                return this;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002¨\u0006\u0006"}, d2 = {"Landroidx/paging/PagedList$Config$Companion;", "", "()V", "MAX_SIZE_UNBOUNDED", "", "getMAX_SIZE_UNBOUNDED$annotations", "paging-common"}, k = 1, mv = {1, 4, 1})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(g gVar) {
                this();
            }

            public static /* synthetic */ void getMAX_SIZE_UNBOUNDED$annotations() {
            }
        }

        public Config(int i10, int i11, boolean z10, int i12, int i13) {
            this.pageSize = i10;
            this.prefetchDistance = i11;
            this.enablePlaceholders = z10;
            this.initialLoadSizeHint = i12;
            this.maxSize = i13;
        }
    }

    public PagedList(PagingSource<?, T> pagingSource, l0 coroutineScope, i0 notifyDispatcher, PagedStorage<T> storage, Config config) {
        m.f(pagingSource, "pagingSource");
        m.f(coroutineScope, "coroutineScope");
        m.f(notifyDispatcher, "notifyDispatcher");
        m.f(storage, "storage");
        m.f(config, "config");
        this.pagingSource = pagingSource;
        this.coroutineScope = coroutineScope;
        this.notifyDispatcher = notifyDispatcher;
        this.storage = storage;
        this.config = config;
        this.requiredRemainder = (config.prefetchDistance * 2) + config.pageSize;
        this.callbacks = new ArrayList();
        this.loadStateListeners = new ArrayList();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <K, T> PagedList<T> create(PagingSource<K, T> pagingSource, PagingSource.LoadResult.Page<K, T> page, l0 l0Var, i0 i0Var, i0 i0Var2, BoundaryCallback<T> boundaryCallback, Config config, K k10) {
        return INSTANCE.create(pagingSource, page, l0Var, i0Var, i0Var2, boundaryCallback, config, k10);
    }

    public final void addWeakLoadStateListener(p<? super LoadType, ? super LoadState, z> listener) {
        m.f(listener, "listener");
        r.I(this.loadStateListeners, C05511.INSTANCE);
        this.loadStateListeners.add(new WeakReference<>(listener));
        dispatchCurrentLoadState(listener);
    }

    public final void dispatchStateChangeAsync$paging_common(LoadType type, LoadState state) {
        m.f(type, "type");
        m.f(state, "state");
        j.d(this.coroutineScope, this.notifyDispatcher, null, new PagedList$dispatchStateChangeAsync$1(this, type, state, null), 2, null);
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int index) {
        return this.storage.get(index);
    }

    public final Config getConfig() {
        return this.config;
    }

    /* JADX INFO: renamed from: getCoroutineScope$paging_common, reason: from getter */
    public final l0 getCoroutineScope() {
        return this.coroutineScope;
    }

    public final int getLoadedCount() {
        return this.storage.getStorageCount();
    }

    /* JADX INFO: renamed from: getNotifyDispatcher$paging_common, reason: from getter */
    public final i0 getNotifyDispatcher() {
        return this.notifyDispatcher;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final NullPaddedList<T> getNullPaddedList() {
        return this.storage;
    }

    public PagingSource<?, T> getPagingSource() {
        return this.pagingSource;
    }

    public final int getPositionOffset() {
        return this.storage.getPositionOffset();
    }

    /* JADX INFO: renamed from: getRefreshRetryCallback$paging_common, reason: from getter */
    public final Runnable getRefreshRetryCallback() {
        return this.refreshRetryCallback;
    }

    /* JADX INFO: renamed from: getRequiredRemainder$paging_common, reason: from getter */
    public final int getRequiredRemainder() {
        return this.requiredRemainder;
    }

    public int getSize() {
        return this.storage.size();
    }

    public final PagedStorage<T> getStorage$paging_common() {
        return this.storage;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final int lastLoad() {
        return this.storage.getLastLoadAroundIndex();
    }

    public final void loadAround(int index) {
        if (index >= 0 && index < size()) {
            this.storage.setLastLoadAroundIndex(index);
            loadAroundInternal(index);
            return;
        }
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void notifyChanged(int position, int count) {
        if (count == 0) {
            return;
        }
        Iterator<T> it = r.D0(this.callbacks).iterator();
        while (it.hasNext()) {
            Callback callback = (Callback) ((WeakReference) it.next()).get();
            if (callback != null) {
                callback.onChanged(position, count);
            }
        }
    }

    public final void notifyInserted$paging_common(int position, int count) {
        if (count == 0) {
            return;
        }
        Iterator<T> it = r.D0(this.callbacks).iterator();
        while (it.hasNext()) {
            Callback callback = (Callback) ((WeakReference) it.next()).get();
            if (callback != null) {
                callback.onInserted(position, count);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void notifyRemoved(int position, int count) {
        if (count == 0) {
            return;
        }
        Iterator<T> it = r.D0(this.callbacks).iterator();
        while (it.hasNext()) {
            Callback callback = (Callback) ((WeakReference) it.next()).get();
            if (callback != null) {
                callback.onRemoved(position, count);
            }
        }
    }

    public final void removeWeakCallback(Callback callback) {
        m.f(callback, "callback");
        r.I(this.callbacks, new C05521(callback));
    }

    public final void removeWeakLoadStateListener(p<? super LoadType, ? super LoadState, z> listener) {
        m.f(listener, "listener");
        r.I(this.loadStateListeners, new C05531(listener));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setInitialLoadState(LoadType loadType, LoadState loadState) {
        m.f(loadType, "loadType");
        m.f(loadState, "loadState");
    }

    public final void setRefreshRetryCallback$paging_common(Runnable runnable) {
        this.refreshRetryCallback = runnable;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void setRetryCallback(Runnable refreshRetryCallback) {
        this.refreshRetryCallback = refreshRetryCallback;
    }

    public final void addWeakCallback(Callback callback) {
        m.f(callback, "callback");
        r.I(this.callbacks, AnonymousClass1.INSTANCE);
        this.callbacks.add(new WeakReference<>(callback));
    }

    public final DataSource<?, T> getDataSource() {
        PagingSource<?, T> pagingSource = getPagingSource();
        if (pagingSource instanceof LegacyPagingSource) {
            DataSource<?, T> dataSource$paging_common = ((LegacyPagingSource) pagingSource).getDataSource$paging_common();
            if (dataSource$paging_common != null) {
                return dataSource$paging_common;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.paging.DataSource<*, T>");
        }
        throw new IllegalStateException("Attempt to access dataSource on a PagedList that was instantiated with a " + pagingSource.getClass().getSimpleName() + " instead of a DataSource");
    }

    /* JADX INFO: renamed from: isImmutable */
    public boolean getIsImmutable() {
        return getIsDetached();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ T remove(int i10) {
        return (T) removeAt(i10);
    }

    public /* bridge */ Object removeAt(int i10) {
        return super.remove(i10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    public final List<T> snapshot() {
        if (getIsImmutable()) {
            return this;
        }
        return new SnapshotPagedList(this);
    }

    public static /* synthetic */ void getDataSource$annotations() {
    }

    public void retry() {
    }
}
