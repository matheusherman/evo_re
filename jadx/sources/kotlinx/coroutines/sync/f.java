package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlinx.coroutines.internal.c0;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import v8.j;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00178\u0006¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/sync/f;", "Lkotlinx/coroutines/internal/c0;", "", IjkMediaMeta.IJKM_KEY_TRACK_ID, "prev", "", "pointers", "<init>", "(JLkotlinx/coroutines/sync/f;I)V", "index", "", "cause", "Lv8/j;", "context", "Lr8/z;", "o", "(ILjava/lang/Throwable;Lv8/j;)V", "", "toString", "()Ljava/lang/String;", "n", "()I", "numberOfSlots", "Lkotlinx/atomicfu/AtomicArray;", "", "acquirers", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class f extends c0<f> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicReferenceArray f14934e;

    /* JADX INFO: renamed from: r, reason: from getter */
    public final AtomicReferenceArray getF14934e() {
        return this.f14934e;
    }

    public String toString() {
        return "SemaphoreSegment[id=" + this.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String + ", hashCode=" + hashCode() + ']';
    }

    public f(long j10, f fVar, int i10) {
        super(j10, fVar, i10);
        this.f14934e = new AtomicReferenceArray(e.f14933f);
    }

    @Override // kotlinx.coroutines.internal.c0
    public int n() {
        return e.f14933f;
    }

    @Override // kotlinx.coroutines.internal.c0
    public void o(int index, Throwable cause, j context) {
        getF14934e().set(index, e.f14932e);
        p();
    }
}
