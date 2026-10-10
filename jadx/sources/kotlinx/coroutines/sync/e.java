package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.internal.i0;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u001a!\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\"\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b\"\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f\"\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\f\"\u0014\u0010\u0011\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\f\"\u0014\u0010\u0013\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\f\"\u0014\u0010\u0015\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\b¨\u0006\u0016"}, d2 = {"", IjkMediaMeta.IJKM_KEY_TRACK_ID, "Lkotlinx/coroutines/sync/f;", "prev", "h", "(JLkotlinx/coroutines/sync/f;)Lkotlinx/coroutines/sync/f;", "", "a", "I", "MAX_SPIN_CYCLES", "Lkotlinx/coroutines/internal/f0;", "b", "Lkotlinx/coroutines/internal/f0;", "PERMIT", "c", "TAKEN", "d", "BROKEN", "e", "CANCELLED", "f", "SEGMENT_SIZE", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f14928a = i0.e("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final f0 f14929b = new f0("PERMIT");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final f0 f14930c = new f0("TAKEN");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final f0 f14931d = new f0("BROKEN");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final f0 f14932e = new f0("CANCELLED");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f14933f = i0.e("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final f h(long j10, f fVar) {
        return new f(j10, fVar, 0);
    }
}
