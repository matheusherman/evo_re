package kotlinx.coroutines;

import androidx.core.location.LocationRequestCompat;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u0019\u0010\u0011\u001a\u00020\u00102\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00102\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0014J\u0015\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001a\u0010\u0003R\u0016\u0010\u001d\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010$\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\nR\u0011\u0010(\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b'\u0010\fR\u0011\u0010)\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\f¨\u0006*"}, d2 = {"Lkotlinx/coroutines/e1;", "Lkotlinx/coroutines/i0;", "<init>", "()V", "", "unconfined", "", "q", "(Z)J", "M", "()J", "P", "()Z", "R", "Lkotlinx/coroutines/x0;", "task", "Lr8/z;", "u", "(Lkotlinx/coroutines/x0;)V", "C", "(Z)V", "d", "", "parallelism", "limitedParallelism", "(I)Lkotlinx/coroutines/i0;", "shutdown", "a", "J", "useCount", "b", "Z", "shared", "Lkotlin/collections/i;", "c", "Lkotlin/collections/i;", "unconfinedQueue", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "nextTime", "G", "isUnconfinedLoopActive", "isUnconfinedQueueEmpty", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class e1 extends i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long useCount;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean shared;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private kotlin.collections.i<x0<?>> unconfinedQueue;

    public boolean R() {
        return false;
    }

    public static /* synthetic */ void F(e1 e1Var, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        e1Var.C(z10);
    }

    public static /* synthetic */ void o(e1 e1Var, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        e1Var.d(z10);
    }

    private final long q(boolean unconfined) {
        if (unconfined) {
            return IjkMediaMeta.AV_CH_WIDE_RIGHT;
        }
        return 1L;
    }

    protected long A() {
        kotlin.collections.i<x0<?>> iVar = this.unconfinedQueue;
        if (iVar == null || iVar.isEmpty()) {
            return LocationRequestCompat.PASSIVE_INTERVAL;
        }
        return 0L;
    }

    public final void C(boolean unconfined) {
        this.useCount += q(unconfined);
        if (unconfined) {
            return;
        }
        this.shared = true;
    }

    public final boolean G() {
        return this.useCount >= q(true);
    }

    public final boolean J() {
        kotlin.collections.i<x0<?>> iVar = this.unconfinedQueue;
        if (iVar != null) {
            return iVar.isEmpty();
        }
        return true;
    }

    public final boolean P() {
        x0<?> x0VarV;
        kotlin.collections.i<x0<?>> iVar = this.unconfinedQueue;
        if (iVar == null || (x0VarV = iVar.v()) == null) {
            return false;
        }
        x0VarV.run();
        return true;
    }

    public final void d(boolean unconfined) {
        long jQ = this.useCount - q(unconfined);
        this.useCount = jQ;
        if (jQ <= 0 && this.shared) {
            shutdown();
        }
    }

    public final void u(x0<?> task) {
        kotlin.collections.i<x0<?>> iVar = this.unconfinedQueue;
        if (iVar == null) {
            iVar = new kotlin.collections.i<>();
            this.unconfinedQueue = iVar;
        }
        iVar.addLast(task);
    }

    public long M() {
        if (!P()) {
            return LocationRequestCompat.PASSIVE_INTERVAL;
        }
        return 0L;
    }

    @Override // kotlinx.coroutines.i0
    public final i0 limitedParallelism(int parallelism) {
        kotlinx.coroutines.internal.n.a(parallelism);
        return this;
    }

    public void shutdown() {
    }
}
