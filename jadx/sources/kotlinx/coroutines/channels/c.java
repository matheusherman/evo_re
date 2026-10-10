package kotlinx.coroutines.channels;

import androidx.core.location.LocationRequestCompat;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.internal.i0;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b$\u001a3\u0010\u0004\u001a \u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0001\"\u0004\b\u0000\u0010\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a1\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0006\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¢\u0006\u0004\b\b\u0010\t\u001a?\u0010\u0012\u001a\u00020\u0011\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\f\u001a\u00028\u00002\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001f\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001f\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001d\u0010\u001e\"\u001c\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!\"\u0014\u0010%\u001a\u00020\u00148\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b#\u0010$\"\u0014\u0010'\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010$\"\u0014\u0010+\u001a\u00020(8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b)\u0010*\"\u0014\u0010-\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010*\"\u0014\u0010/\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010*\"\u0014\u00101\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010*\"\u0014\u00103\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010*\"\u0014\u00105\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u0010*\"\u0014\u00107\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u0010*\"\u0014\u00109\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u0010*\"\u001a\u0010=\u001a\u00020(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b:\u0010*\u001a\u0004\b;\u0010<\"\u0014\u0010?\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010*\"\u0014\u0010A\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010*\"\u0014\u0010C\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010*\"\u0014\u0010E\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010*\"\u0014\u0010G\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010*\"\u0014\u0010I\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010*\"\u0014\u0010K\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010*¨\u0006L"}, d2 = {ExifInterface.LONGITUDE_EAST, "Lkotlin/reflect/KFunction2;", "", "Lkotlinx/coroutines/channels/j;", "y", "()Li9/g;", IjkMediaMeta.IJKM_KEY_TRACK_ID, "prev", "x", "(JLkotlinx/coroutines/channels/j;)Lkotlinx/coroutines/channels/j;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/n;", "value", "Lkotlin/Function1;", "", "Lr8/z;", "onCancellation", "", "B", "(Lkotlinx/coroutines/n;Ljava/lang/Object;Lc9/l;)Z", "", "capacity", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(I)J", "counter", "closeStatus", "w", "(JI)J", "pauseEB", "v", "(JZ)J", "", "a", "Lkotlinx/coroutines/channels/j;", "NULL_SEGMENT", "b", "I", "SEGMENT_SIZE", "c", "EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS", "Lkotlinx/coroutines/internal/f0;", "d", "Lkotlinx/coroutines/internal/f0;", "BUFFERED", "e", "IN_BUFFER", "f", "RESUMING_BY_RCV", "g", "RESUMING_BY_EB", "h", "POISONED", "i", "DONE_RCV", "j", "INTERRUPTED_SEND", "k", "INTERRUPTED_RCV", "l", "z", "()Lkotlinx/coroutines/internal/f0;", "CHANNEL_CLOSED", "m", "SUSPEND", "n", "SUSPEND_NO_WAITER", "o", "FAILED", "p", "NO_RECEIVE_RESULT", "q", "CLOSE_HANDLER_CLOSED", "r", "CLOSE_HANDLER_INVOKED", "s", "NO_CLOSE_CAUSE", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final j<Object> f14629a = new j<>(-1, null, null, 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f14630b = i0.e("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f14631c = i0.e("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f0 f14632d = new f0("BUFFERED");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final f0 f14633e = new f0("SHOULD_BUFFER");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final f0 f14634f = new f0("S_RESUMING_BY_RCV");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final f0 f14635g = new f0("RESUMING_BY_EB");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final f0 f14636h = new f0("POISONED");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final f0 f14637i = new f0("DONE_RCV");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final f0 f14638j = new f0("INTERRUPTED_SEND");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final f0 f14639k = new f0("INTERRUPTED_RCV");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final f0 f14640l = new f0("CHANNEL_CLOSED");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final f0 f14641m = new f0("SUSPEND");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final f0 f14642n = new f0("SUSPEND_NO_WAITER");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final f0 f14643o = new f0("FAILED");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final f0 f14644p = new f0("NO_RECEIVE_RESULT");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final f0 f14645q = new f0("CLOSE_HANDLER_CLOSED");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final f0 f14646r = new f0("CLOSE_HANDLER_INVOKED");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final f0 f14647s = new f0("NO_CLOSE_CAUSE");

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class a<E> extends kotlin.jvm.internal.k implements c9.p<Long, j<E>, j<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f14648a = new a();

        a() {
            super(2, c.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
        }

        @Override // c9.p
        public /* bridge */ /* synthetic */ Object invoke(Long l10, Object obj) {
            return j(l10.longValue(), (j) obj);
        }

        public final j<E> j(long j10, j<E> jVar) {
            return c.x(j10, jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean B(kotlinx.coroutines.n<? super T> nVar, T t10, c9.l<? super Throwable, z> lVar) {
        Object objE = nVar.e(t10, null, lVar);
        if (objE == null) {
            return false;
        }
        nVar.A(objE);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long w(long j10, int i10) {
        return (((long) i10) << 60) + j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long A(int i10) {
        if (i10 != 0) {
            return i10 != Integer.MAX_VALUE ? i10 : LocationRequestCompat.PASSIVE_INTERVAL;
        }
        return 0L;
    }

    static /* synthetic */ boolean C(kotlinx.coroutines.n nVar, Object obj, c9.l lVar, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            lVar = null;
        }
        return B(nVar, obj, lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long v(long j10, boolean z10) {
        return (z10 ? 4611686018427387904L : 0L) + j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E> j<E> x(long j10, j<E> jVar) {
        return new j<>(j10, jVar, jVar.u(), 0);
    }

    public static final <E> i9.g<j<E>> y() {
        return a.f14648a;
    }

    public static final f0 z() {
        return f14640l;
    }
}
