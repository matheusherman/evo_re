package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import kotlin.Metadata;
import kotlinx.coroutines.b1;
import kotlinx.coroutines.u1;
import kotlinx.coroutines.y1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0012\u0004\u0012\u00028\u00000\u0006:\u0001CB\u001f\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001b\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ9\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u001d2\u0010\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0002¢\u0006\u0004\b!\u0010\"J\u001b\u0010#\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u00132\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(J/\u0010-\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u0016H\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0013H\u0002¢\u0006\u0004\b/\u0010\u0015J\u0019\u00101\u001a\u0004\u0018\u00010\u00052\u0006\u00100\u001a\u00020\u0003H\u0002¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u0003H\u0002¢\u0006\u0004\b3\u00104J\u0019\u00106\u001a\u0004\u0018\u00010\u00052\u0006\u00105\u001a\u00020\u0016H\u0002¢\u0006\u0004\b6\u00107J\u001b\u00108\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u0003H\u0082@ø\u0001\u0000¢\u0006\u0004\b8\u00109J3\u0010<\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010:0\u001d2\u0014\u0010;\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010:0\u001dH\u0002¢\u0006\u0004\b<\u0010=J!\u0010A\u001a\u00020@2\f\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000>H\u0096@ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ\u0017\u0010C\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0004\bC\u0010\u0011J\u001b\u0010D\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\bD\u0010$J\u000f\u0010\u0001\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u0001\u0010EJ%\u0010G\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010:0\u001d2\u0006\u0010F\u001a\u00020\u0016H\u0000¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\u0003H\u0014¢\u0006\u0004\bI\u0010JJ\u001f\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001d2\u0006\u0010K\u001a\u00020\u0007H\u0014¢\u0006\u0004\bL\u0010MJ-\u0010R\u001a\b\u0012\u0004\u0012\u00028\u00000Q2\u0006\u0010O\u001a\u00020N2\u0006\u0010P\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\bR\u0010SR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u00106R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u00106R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR \u0010Z\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010]\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010_\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010\\R\u0016\u0010a\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u00106R\u0016\u0010c\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u00106R\u0014\u0010e\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bd\u0010ER\u0014\u0010h\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bf\u0010gR\u0014\u0010j\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bi\u0010gR\u0014\u0010l\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bk\u0010ER\u0014\u0010m\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010E\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006n"}, d2 = {"Lkotlinx/coroutines/flow/a0;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/b;", "Lkotlinx/coroutines/flow/c0;", "Lkotlinx/coroutines/flow/u;", "", "Lkotlinx/coroutines/flow/internal/m;", "", "replay", "bufferCapacity", "Lkotlinx/coroutines/channels/a;", "onBufferOverflow", "<init>", "(IILkotlinx/coroutines/channels/a;)V", "value", "", "N", "(Ljava/lang/Object;)Z", "O", "Lr8/z;", "B", "()V", "", "newHead", "y", "(J)V", "item", ExifInterface.LONGITUDE_EAST, "(Ljava/lang/Object;)V", "", "curBuffer", "curSize", "newSize", "M", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "D", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/a0$a;", "emitter", "v", "(Lkotlinx/coroutines/flow/a0$a;)V", "newReplayIndex", "newMinCollectorIndex", "newBufferEndIndex", "newQueueEndIndex", "R", "(JJJJ)V", "w", "slot", "Q", "(Lkotlinx/coroutines/flow/c0;)Ljava/lang/Object;", "P", "(Lkotlinx/coroutines/flow/c0;)J", "index", "I", "(J)Ljava/lang/Object;", "u", "(Lkotlinx/coroutines/flow/c0;Lv8/f;)Ljava/lang/Object;", "Lv8/f;", "resumesIn", "F", "([Lv8/f;)[Lv8/f;", "Lkotlinx/coroutines/flow/g;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "a", "emit", "()J", "oldIndex", ExifInterface.LATITUDE_SOUTH, "(J)[Lv8/f;", "z", "()Lkotlinx/coroutines/flow/c0;", "size", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(I)[Lkotlinx/coroutines/flow/c0;", "Lv8/j;", "context", "capacity", "Lkotlinx/coroutines/flow/f;", "b", "(Lv8/j;ILkotlinx/coroutines/channels/a;)Lkotlinx/coroutines/flow/f;", "d", "e", "f", "Lkotlinx/coroutines/channels/a;", "g", "[Ljava/lang/Object;", "buffer", "h", "J", "replayIndex", "i", "minCollectorIndex", "j", "bufferSize", "k", "queueSize", "H", "head", "K", "()I", "replaySize", "L", "totalSize", "G", "bufferEndIndex", "queueEndIndex", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class a0<T> extends kotlinx.coroutines.flow.internal.b<c0> implements u<T>, f, kotlinx.coroutines.flow.internal.m<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int replay;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int bufferCapacity;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final kotlinx.coroutines.channels.a onBufferOverflow;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private Object[] buffer;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long replayIndex;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long minCollectorIndex;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int bufferSize;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int queueSize;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001B3\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/flow/a0$a;", "Lkotlinx/coroutines/b1;", "Lkotlinx/coroutines/flow/a0;", "flow", "", "index", "", "value", "Lv8/f;", "Lr8/z;", "cont", "<init>", "(Lkotlinx/coroutines/flow/a0;JLjava/lang/Object;Lv8/f;)V", "dispose", "()V", "a", "Lkotlinx/coroutines/flow/a0;", "b", "J", "c", "Ljava/lang/Object;", "d", "Lv8/f;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class a implements b1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final a0<?> flow;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        public long index;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final Object value;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final v8.f<r8.z> cont;

        @Override // kotlinx.coroutines.b1
        public void dispose() {
            this.flow.v(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(a0<?> a0Var, long j10, Object obj, v8.f<? super r8.z> fVar) {
            this.flow = a0Var;
            this.index = j10;
            this.value = obj;
            this.cont = fVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.SharedFlowImpl", f = "SharedFlow.kt", l = {372, 379, 382}, m = "collect$suspendImpl")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    static final class c<T> extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ a0<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(a0<T> a0Var, v8.f<? super c> fVar) {
            super(fVar);
            this.this$0 = a0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a0.x(this.this$0, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [v8.f<r8.z>[]] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r6v2 */
    public final v8.f<r8.z>[] F(v8.f<r8.z>[] resumesIn) {
        kotlinx.coroutines.flow.internal.d[] dVarArr;
        c0 c0Var;
        v8.f<? super r8.z> fVar;
        int length = resumesIn.length;
        if (((kotlinx.coroutines.flow.internal.b) this).nCollectors != 0 && (dVarArr = ((kotlinx.coroutines.flow.internal.b) this).slots) != null) {
            int length2 = dVarArr.length;
            int i10 = 0;
            while (i10 < length2) {
                kotlinx.coroutines.flow.internal.d dVar = dVarArr[i10];
                if (dVar == null || (fVar = (c0Var = (c0) dVar).cont) == null || P(c0Var) < 0) {
                    resumesIn = resumesIn;
                } else {
                    if (length >= resumesIn.length) {
                        resumesIn = resumesIn;
                        resumesIn = resumesIn;
                        Object[] objArrCopyOf = Arrays.copyOf((Object[]) resumesIn, Math.max(2, resumesIn.length * 2));
                        kotlin.jvm.internal.m.e(objArrCopyOf, "copyOf(this, newSize)");
                        resumesIn = objArrCopyOf;
                    }
                    resumesIn = resumesIn;
                    resumesIn = resumesIn;
                    ((v8.f[]) resumesIn)[length] = fVar;
                    c0Var.cont = null;
                    length++;
                }
                i10++;
                resumesIn = resumesIn;
            }
            resumesIn = resumesIn;
        }
        return (v8.f[]) resumesIn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(a emitter) {
        synchronized (this) {
            if (emitter.index < H()) {
                return;
            }
            Object[] objArr = this.buffer;
            kotlin.jvm.internal.m.c(objArr);
            if (b0.f(objArr, emitter.index) != emitter) {
                return;
            }
            b0.g(objArr, emitter.index, b0.f14701a);
            w();
            r8.z zVar = r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14699a;

        static {
            int[] iArr = new int[kotlinx.coroutines.channels.a.values().length];
            try {
                iArr[kotlinx.coroutines.channels.a.SUSPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[kotlinx.coroutines.channels.a.DROP_LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[kotlinx.coroutines.channels.a.DROP_OLDEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f14699a = iArr;
        }
    }

    private final void B() {
        Object[] objArr = this.buffer;
        kotlin.jvm.internal.m.c(objArr);
        b0.g(objArr, H(), null);
        this.bufferSize--;
        long jH = H() + 1;
        if (this.replayIndex < jH) {
            this.replayIndex = jH;
        }
        if (this.minCollectorIndex < jH) {
            y(jH);
        }
    }

    private final Object D(T t10, v8.f<? super r8.z> fVar) throws Throwable {
        Throwable th;
        v8.f<r8.z>[] fVarArrF;
        a aVar;
        kotlinx.coroutines.o oVar = new kotlinx.coroutines.o(kotlin.coroutines.intrinsics.b.b(fVar), 1);
        oVar.D();
        v8.f<r8.z>[] fVarArrF2 = kotlinx.coroutines.flow.internal.c.f14726a;
        synchronized (this) {
            try {
                if (N(t10)) {
                    try {
                        r8.q.Companion companion = r8.q.INSTANCE;
                        oVar.resumeWith(r8.q.a(r8.z.f17874a));
                        fVarArrF = F(fVarArrF2);
                        aVar = null;
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } else {
                    try {
                        aVar = new a(this, H() + ((long) L()), t10, oVar);
                        E(aVar);
                        this.queueSize++;
                        if (this.bufferCapacity == 0) {
                            fVarArrF2 = F(fVarArrF2);
                        }
                        fVarArrF = fVarArrF2;
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        throw th;
                    }
                }
                if (aVar != null) {
                    kotlinx.coroutines.q.a(oVar, aVar);
                }
                for (v8.f<r8.z> fVar2 : fVarArrF) {
                    if (fVar2 != null) {
                        r8.q.Companion companion2 = r8.q.INSTANCE;
                        fVar2.resumeWith(r8.q.a(r8.z.f17874a));
                    }
                }
                Object objZ = oVar.z();
                if (objZ == kotlin.coroutines.intrinsics.b.c()) {
                    kotlin.coroutines.jvm.internal.h.c(fVar);
                }
                return objZ == kotlin.coroutines.intrinsics.b.c() ? objZ : r8.z.f17874a;
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long H() {
        return Math.min(this.minCollectorIndex, this.replayIndex);
    }

    private final Object I(long index) {
        Object[] objArr = this.buffer;
        kotlin.jvm.internal.m.c(objArr);
        Object objF = b0.f(objArr, index);
        return objF instanceof a ? ((a) objF).value : objF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int L() {
        return this.bufferSize + this.queueSize;
    }

    private final Object[] M(Object[] curBuffer, int curSize, int newSize) {
        if (newSize <= 0) {
            throw new IllegalStateException("Buffer size overflow");
        }
        Object[] objArr = new Object[newSize];
        this.buffer = objArr;
        if (curBuffer != null) {
            long jH = H();
            for (int i10 = 0; i10 < curSize; i10++) {
                long j10 = ((long) i10) + jH;
                b0.g(objArr, j10, b0.f(curBuffer, j10));
            }
        }
        return objArr;
    }

    private final boolean O(T value) {
        if (this.replay == 0) {
            return true;
        }
        E(value);
        int i10 = this.bufferSize + 1;
        this.bufferSize = i10;
        if (i10 > this.replay) {
            B();
        }
        this.minCollectorIndex = H() + ((long) this.bufferSize);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long P(c0 slot) {
        long j10 = slot.index;
        if (j10 >= G() && (this.bufferCapacity > 0 || j10 > H() || this.queueSize == 0)) {
            return -1L;
        }
        return j10;
    }

    private final Object Q(c0 slot) {
        Object obj;
        v8.f<r8.z>[] fVarArrS = kotlinx.coroutines.flow.internal.c.f14726a;
        synchronized (this) {
            try {
                long jP = P(slot);
                if (jP < 0) {
                    obj = b0.f14701a;
                } else {
                    long j10 = slot.index;
                    Object objI = I(jP);
                    slot.index = jP + 1;
                    fVarArrS = S(j10);
                    obj = objI;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (v8.f<r8.z> fVar : fVarArrS) {
            if (fVar != null) {
                r8.q.Companion companion = r8.q.INSTANCE;
                fVar.resumeWith(r8.q.a(r8.z.f17874a));
            }
        }
        return obj;
    }

    private final Object u(c0 c0Var, v8.f<? super r8.z> fVar) {
        kotlinx.coroutines.o oVar = new kotlinx.coroutines.o(kotlin.coroutines.intrinsics.b.b(fVar), 1);
        oVar.D();
        synchronized (this) {
            try {
                if (P(c0Var) < 0) {
                    c0Var.cont = oVar;
                } else {
                    r8.q.Companion companion = r8.q.INSTANCE;
                    oVar.resumeWith(r8.q.a(r8.z.f17874a));
                }
                r8.z zVar = r8.z.f17874a;
            } catch (Throwable th) {
                throw th;
            }
        }
        Object objZ = oVar.z();
        if (objZ == kotlin.coroutines.intrinsics.b.c()) {
            kotlin.coroutines.jvm.internal.h.c(fVar);
        }
        return objZ == kotlin.coroutines.intrinsics.b.c() ? objZ : r8.z.f17874a;
    }

    private final void w() {
        if (this.bufferCapacity != 0 || this.queueSize > 1) {
            Object[] objArr = this.buffer;
            kotlin.jvm.internal.m.c(objArr);
            while (this.queueSize > 0 && b0.f(objArr, (H() + ((long) L())) - 1) == b0.f14701a) {
                this.queueSize--;
                b0.g(objArr, H() + ((long) L()), null);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0092, code lost:
    
        if (((kotlinx.coroutines.flow.h0) r9).b(r0) == r1) goto L48;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ <T> Object x(a0<T> a0Var, g<? super T> gVar, v8.f<?> fVar) throws Throwable {
        c cVar;
        a0<T> a0Var2;
        Throwable th;
        c0 c0Var;
        g<? super T> gVar2;
        u1 u1Var;
        g gVar3;
        if (fVar instanceof c) {
            cVar = (c) fVar;
            int i10 = cVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                cVar.label = i10 - Integer.MIN_VALUE;
            } else {
                cVar = new c(a0Var, fVar);
            }
        } else {
            cVar = new c(a0Var, fVar);
        }
        Object obj = cVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = cVar.label;
        if (i11 != 0) {
            if (i11 == 1) {
                c0Var = (c0) cVar.L$2;
                g<? super T> gVar4 = (g) cVar.L$1;
                a0<T> a0Var3 = (a0) cVar.L$0;
                try {
                    r8.r.b(obj);
                    gVar2 = gVar4;
                    a0Var = a0Var3;
                    try {
                        u1Var = (u1) cVar.getContext().get(u1.INSTANCE);
                        gVar3 = gVar2;
                    } catch (Throwable th2) {
                        a0Var2 = a0Var;
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    a0Var2 = a0Var3;
                }
            } else {
                if (i11 != 2 && i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u1 u1Var2 = (u1) cVar.L$3;
                c0Var = (c0) cVar.L$2;
                g gVar5 = (g) cVar.L$1;
                a0Var2 = (a0) cVar.L$0;
                try {
                    r8.r.b(obj);
                    gVar3 = gVar5;
                    u1Var = u1Var2;
                    a0Var = a0Var2;
                } catch (Throwable th4) {
                    th = th4;
                }
            }
            a0Var2.h(c0Var);
            throw th;
        }
        r8.r.b(obj);
        c0 c0VarE = a0Var.e();
        try {
            if (gVar instanceof h0) {
                cVar.L$0 = a0Var;
                cVar.L$1 = gVar;
                cVar.L$2 = c0VarE;
                cVar.label = 1;
            }
            gVar2 = gVar;
            c0Var = c0VarE;
            u1Var = (u1) cVar.getContext().get(u1.INSTANCE);
            gVar3 = gVar2;
        } catch (Throwable th5) {
            a0Var2 = a0Var;
            th = th5;
            c0Var = c0VarE;
        }
        while (true) {
            Object objQ = a0Var.Q(c0Var);
            if (objQ == b0.f14701a) {
                cVar.L$0 = a0Var;
                cVar.L$1 = gVar3;
                cVar.L$2 = c0Var;
                cVar.L$3 = u1Var;
                cVar.label = 2;
                if (a0Var.u(c0Var, cVar) == objC) {
                    break;
                }
            } else {
                if (u1Var != null) {
                    y1.g(u1Var);
                }
                cVar.L$0 = a0Var;
                cVar.L$1 = gVar3;
                cVar.L$2 = c0Var;
                cVar.L$3 = u1Var;
                cVar.label = 3;
                if (gVar3.emit(objQ, cVar) == objC) {
                    break;
                }
            }
        }
        return objC;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.b
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public c0[] g(int size) {
        return new c0[size];
    }

    public final v8.f<r8.z>[] S(long oldIndex) {
        long j10;
        long j11;
        long j12;
        kotlinx.coroutines.flow.internal.d[] dVarArr;
        if (oldIndex > this.minCollectorIndex) {
            return kotlinx.coroutines.flow.internal.c.f14726a;
        }
        long jH = H();
        long j13 = ((long) this.bufferSize) + jH;
        if (this.bufferCapacity == 0 && this.queueSize > 0) {
            j13++;
        }
        if (((kotlinx.coroutines.flow.internal.b) this).nCollectors != 0 && (dVarArr = ((kotlinx.coroutines.flow.internal.b) this).slots) != null) {
            for (kotlinx.coroutines.flow.internal.d dVar : dVarArr) {
                if (dVar != null) {
                    long j14 = ((c0) dVar).index;
                    if (j14 >= 0 && j14 < j13) {
                        j13 = j14;
                    }
                }
            }
        }
        if (j13 <= this.minCollectorIndex) {
            return kotlinx.coroutines.flow.internal.c.f14726a;
        }
        long jG = G();
        int iMin = getNCollectors() > 0 ? Math.min(this.queueSize, this.bufferCapacity - ((int) (jG - j13))) : this.queueSize;
        v8.f<r8.z>[] fVarArr = kotlinx.coroutines.flow.internal.c.f14726a;
        long j15 = ((long) this.queueSize) + jG;
        if (iMin > 0) {
            fVarArr = new v8.f[iMin];
            Object[] objArr = this.buffer;
            kotlin.jvm.internal.m.c(objArr);
            j12 = 1;
            long j16 = jG;
            int i10 = 0;
            while (true) {
                if (jG >= j15) {
                    j10 = jH;
                    j11 = j13;
                    jG = j16;
                    break;
                }
                Object objF = b0.f(objArr, jG);
                j10 = jH;
                kotlinx.coroutines.internal.f0 f0Var = b0.f14701a;
                if (objF != f0Var) {
                    kotlin.jvm.internal.m.d(objF, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                    a aVar = (a) objF;
                    int i11 = i10 + 1;
                    j11 = j13;
                    fVarArr[i10] = aVar.cont;
                    b0.g(objArr, jG, f0Var);
                    b0.g(objArr, j16, aVar.value);
                    long j17 = j16 + 1;
                    if (i11 >= iMin) {
                        jG = j17;
                        break;
                    }
                    i10 = i11;
                    j16 = j17;
                } else {
                    j11 = j13;
                }
                jG++;
                jH = j10;
                j13 = j11;
            }
        } else {
            j10 = jH;
            j11 = j13;
            j12 = 1;
        }
        v8.f<r8.z>[] fVarArr2 = fVarArr;
        int i12 = (int) (jG - j10);
        long j18 = getNCollectors() == 0 ? jG : j11;
        long jMax = Math.max(this.replayIndex, jG - ((long) Math.min(this.replay, i12)));
        if (this.bufferCapacity == 0 && jMax < j15) {
            Object[] objArr2 = this.buffer;
            kotlin.jvm.internal.m.c(objArr2);
            if (kotlin.jvm.internal.m.a(b0.f(objArr2, jMax), b0.f14701a)) {
                jG += j12;
                jMax += j12;
            }
        }
        R(jMax, j18, jG, j15);
        w();
        return !(fVarArr2.length == 0) ? F(fVarArr2) : fVarArr2;
    }

    public final long T() {
        long j10 = this.replayIndex;
        if (j10 < this.minCollectorIndex) {
            this.minCollectorIndex = j10;
        }
        return j10;
    }

    @Override // kotlinx.coroutines.flow.u
    public boolean a(T value) {
        int i10;
        boolean z10;
        v8.f<r8.z>[] fVarArrF = kotlinx.coroutines.flow.internal.c.f14726a;
        synchronized (this) {
            if (N(value)) {
                fVarArrF = F(fVarArrF);
                z10 = true;
            } else {
                z10 = false;
            }
        }
        for (v8.f<r8.z> fVar : fVarArrF) {
            if (fVar != null) {
                r8.q.Companion companion = r8.q.INSTANCE;
                fVar.resumeWith(r8.q.a(r8.z.f17874a));
            }
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.b
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public c0 f() {
        return new c0();
    }

    public a0(int i10, int i11, kotlinx.coroutines.channels.a aVar) {
        this.replay = i10;
        this.bufferCapacity = i11;
        this.onBufferOverflow = aVar;
    }

    static /* synthetic */ <T> Object C(a0<T> a0Var, T t10, v8.f<? super r8.z> fVar) throws Throwable {
        if (a0Var.a(t10)) {
            return r8.z.f17874a;
        }
        Object objD = a0Var.D(t10, fVar);
        if (objD == kotlin.coroutines.intrinsics.b.c()) {
            return objD;
        }
        return r8.z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(Object item) {
        int iL = L();
        Object[] objArrM = this.buffer;
        if (objArrM == null) {
            objArrM = M(null, 0, 2);
        } else if (iL >= objArrM.length) {
            objArrM = M(objArrM, iL, objArrM.length * 2);
        }
        b0.g(objArrM, H() + ((long) iL), item);
    }

    private final long G() {
        return H() + ((long) this.bufferSize);
    }

    private final long J() {
        return H() + ((long) this.bufferSize) + ((long) this.queueSize);
    }

    private final int K() {
        return (int) ((H() + ((long) this.bufferSize)) - this.replayIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean N(T value) {
        if (getNCollectors() == 0) {
            return O(value);
        }
        if (this.bufferSize >= this.bufferCapacity && this.minCollectorIndex <= this.replayIndex) {
            int i10 = b.f14699a[this.onBufferOverflow.ordinal()];
            if (i10 != 1) {
                if (i10 == 2) {
                    return true;
                }
            } else {
                return false;
            }
        }
        E(value);
        int i11 = this.bufferSize + 1;
        this.bufferSize = i11;
        if (i11 > this.bufferCapacity) {
            B();
        }
        if (K() > this.replay) {
            R(this.replayIndex + 1, this.minCollectorIndex, G(), J());
        }
        return true;
    }

    private final void R(long newReplayIndex, long newMinCollectorIndex, long newBufferEndIndex, long newQueueEndIndex) {
        long jMin = Math.min(newMinCollectorIndex, newReplayIndex);
        for (long jH = H(); jH < jMin; jH++) {
            Object[] objArr = this.buffer;
            kotlin.jvm.internal.m.c(objArr);
            b0.g(objArr, jH, null);
        }
        this.replayIndex = newReplayIndex;
        this.minCollectorIndex = newMinCollectorIndex;
        this.bufferSize = (int) (newBufferEndIndex - jMin);
        this.queueSize = (int) (newQueueEndIndex - newBufferEndIndex);
    }

    private final void y(long newHead) {
        kotlinx.coroutines.flow.internal.d[] dVarArr;
        if (((kotlinx.coroutines.flow.internal.b) this).nCollectors != 0 && (dVarArr = ((kotlinx.coroutines.flow.internal.b) this).slots) != null) {
            for (kotlinx.coroutines.flow.internal.d dVar : dVarArr) {
                if (dVar != null) {
                    c0 c0Var = (c0) dVar;
                    long j10 = c0Var.index;
                    if (j10 >= 0 && j10 < newHead) {
                        c0Var.index = newHead;
                    }
                }
            }
        }
        this.minCollectorIndex = newHead;
    }

    @Override // kotlinx.coroutines.flow.internal.m
    public f<T> b(v8.j context, int capacity, kotlinx.coroutines.channels.a onBufferOverflow) {
        return b0.e(this, context, capacity, onBufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.z, kotlinx.coroutines.flow.f
    public Object collect(g<? super T> gVar, v8.f<?> fVar) {
        return x(this, gVar, fVar);
    }

    @Override // kotlinx.coroutines.flow.g
    public Object emit(T t10, v8.f<? super r8.z> fVar) {
        return C(this, t10, fVar);
    }
}
