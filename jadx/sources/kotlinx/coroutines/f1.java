package kotlinx.coroutines;

import androidx.core.location.LocationRequestCompat;
import androidx.exifinterface.media.ExifInterface;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b \u0018\u00002\u00020\u00012\u00020\u0002:\u0003<\u001d=B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\t\u001a\u00020\b2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0019\u0010\u0004J%\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00122\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001f\u0010 J!\u0010$\u001a\u00020\r2\u0006\u0010\"\u001a\u00020!2\n\u0010#\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\r2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0016¢\u0006\u0004\b&\u0010'J\u001d\u0010(\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000f¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\rH\u0004¢\u0006\u0004\b*\u0010\u0004R$\u00100\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0014\u00102\u001a\u00020\b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b1\u0010-R\u0014\u00104\u001a\u00020\u00128TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b3\u0010 R\u0013\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u000106058\u0002X\u0082\u0004R\u000b\u00109\u001a\u0002088\u0002X\u0082\u0004R\u0013\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010:058\u0002X\u0082\u0004¨\u0006>"}, d2 = {"Lkotlinx/coroutines/f1;", "Lkotlinx/coroutines/g1;", "Lkotlinx/coroutines/u0;", "<init>", "()V", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "task", "", "j0", "(Ljava/lang/Runnable;)Z", "e0", "()Ljava/lang/Runnable;", "Lr8/z;", "c0", "Lkotlinx/coroutines/f1$b;", "r0", "(Lkotlinx/coroutines/f1$b;)Z", "", "now", "delayedTask", "", "p0", "(JLkotlinx/coroutines/f1$b;)I", "m0", "shutdown", "timeMillis", "Lkotlinx/coroutines/n;", "continuation", "b", "(JLkotlinx/coroutines/n;)V", "M", "()J", "Lv8/j;", "context", "block", "dispatch", "(Lv8/j;Ljava/lang/Runnable;)V", "i0", "(Ljava/lang/Runnable;)V", "o0", "(JLkotlinx/coroutines/f1$b;)V", "n0", "value", "k0", "()Z", "q0", "(Z)V", "isCompleted", "l0", "isEmpty", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "nextTime", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/f1$c;", "_delayed", "Lkotlinx/atomicfu/AtomicBoolean;", "_isCompleted", "", "_queue", "a", "c", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class f1 extends g1 implements u0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f14678d = AtomicReferenceFieldUpdater.newUpdater(f1.class, Object.class, "_queue");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f14679e = AtomicReferenceFieldUpdater.newUpdater(f1.class, Object.class, "_delayed");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f14680f = AtomicIntegerFieldUpdater.newUpdater(f1.class, "_isCompleted");
    private volatile Object _delayed;
    private volatile int _isCompleted = 0;
    private volatile Object _queue;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/f1$a;", "Lkotlinx/coroutines/f1$b;", "", "nanoTime", "Lkotlinx/coroutines/n;", "Lr8/z;", "cont", "<init>", "(Lkotlinx/coroutines/f1;JLkotlinx/coroutines/n;)V", "run", "()V", "", "toString", "()Ljava/lang/String;", "c", "Lkotlinx/coroutines/n;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final n<r8.z> cont;

        /* JADX WARN: Multi-variable type inference failed */
        public a(long j10, n<? super r8.z> nVar) {
            super(j10);
            this.cont = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.cont.o(f1.this, r8.z.f17874a);
        }

        @Override // kotlinx.coroutines.f1.b
        public String toString() {
            return super.toString() + this.cont;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u00052\u00060\u0006j\u0002`\u0007B\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\"\u0010*\u001a\u00020\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R0\u00100\u001a\b\u0012\u0002\b\u0003\u0018\u00010+2\f\u0010,\u001a\b\u0012\u0002\b\u0003\u0018\u00010+8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b \u0010/¨\u00061"}, d2 = {"Lkotlinx/coroutines/f1$b;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/b1;", "Lkotlinx/coroutines/internal/o0;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "", "nanoTime", "<init>", "(J)V", TransactionPartnerType.OTHER, "", "k", "(Lkotlinx/coroutines/f1$b;)I", "now", "", "n", "(J)Z", "Lkotlinx/coroutines/f1$c;", "delayed", "Lkotlinx/coroutines/f1;", "eventLoop", "m", "(JLkotlinx/coroutines/f1$c;Lkotlinx/coroutines/f1;)I", "Lr8/z;", "dispose", "()V", "", "toString", "()Ljava/lang/String;", "a", "J", "_heap", "Ljava/lang/Object;", "b", "I", "getIndex", "()I", "setIndex", "(I)V", "index", "Lkotlinx/coroutines/internal/n0;", "value", "j", "()Lkotlinx/coroutines/internal/n0;", "(Lkotlinx/coroutines/internal/n0;)V", "heap", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class b implements Runnable, Comparable<b>, b1, kotlinx.coroutines.internal.o0 {
        private volatile Object _heap;

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        public long nanoTime;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int index = -1;

        @Override // kotlinx.coroutines.b1
        public final void dispose() {
            synchronized (this) {
                try {
                    Object obj = this._heap;
                    if (obj == i1.f14807a) {
                        return;
                    }
                    c cVar = obj instanceof c ? (c) obj : null;
                    if (cVar != null) {
                        cVar.g(this);
                    }
                    this._heap = i1.f14807a;
                    r8.z zVar = r8.z.f17874a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final int m(long now, c delayed, f1 eventLoop) {
            synchronized (this) {
                if (this._heap == i1.f14807a) {
                    return 2;
                }
                synchronized (delayed) {
                    try {
                        b bVarB = delayed.b();
                        if (eventLoop.k0()) {
                            return 1;
                        }
                        if (bVarB == null) {
                            delayed.timeNow = now;
                        } else {
                            long j10 = bVarB.nanoTime;
                            if (j10 - now < 0) {
                                now = j10;
                            }
                            if (now - delayed.timeNow > 0) {
                                delayed.timeNow = now;
                            }
                        }
                        long j11 = this.nanoTime;
                        long j12 = delayed.timeNow;
                        if (j11 - j12 < 0) {
                            this.nanoTime = j12;
                        }
                        delayed.a(this);
                        return 0;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        @Override // kotlinx.coroutines.internal.o0
        public void a(kotlinx.coroutines.internal.n0<?> n0Var) {
            if (this._heap == i1.f14807a) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            this._heap = n0Var;
        }

        @Override // kotlinx.coroutines.internal.o0
        public int getIndex() {
            return this.index;
        }

        @Override // kotlinx.coroutines.internal.o0
        public kotlinx.coroutines.internal.n0<?> j() {
            Object obj = this._heap;
            if (obj instanceof kotlinx.coroutines.internal.n0) {
                return (kotlinx.coroutines.internal.n0) obj;
            }
            return null;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public int compareTo(b other) {
            long j10 = this.nanoTime - other.nanoTime;
            if (j10 > 0) {
                return 1;
            }
            return j10 < 0 ? -1 : 0;
        }

        public final boolean n(long now) {
            return now - this.nanoTime >= 0;
        }

        @Override // kotlinx.coroutines.internal.o0
        public void setIndex(int i10) {
            this.index = i10;
        }

        public String toString() {
            return "Delayed[nanos=" + this.nanoTime + ']';
        }

        public b(long j10) {
            this.nanoTime = j10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/f1$c;", "Lkotlinx/coroutines/internal/n0;", "Lkotlinx/coroutines/f1$b;", "", "timeNow", "<init>", "(J)V", "c", "J", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class c extends kotlinx.coroutines.internal.n0<b> {

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        public long timeNow;

        public c(long j10) {
            this.timeNow = j10;
        }
    }

    private final void c0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14678d;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                if (androidx.concurrent.futures.a.a(f14678d, this, null, i1.f14808b)) {
                    return;
                }
            } else if (obj instanceof kotlinx.coroutines.internal.s) {
                ((kotlinx.coroutines.internal.s) obj).d();
                return;
            } else {
                if (obj == i1.f14808b) {
                    return;
                }
                kotlinx.coroutines.internal.s sVar = new kotlinx.coroutines.internal.s(8, true);
                kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                sVar.a((Runnable) obj);
                if (androidx.concurrent.futures.a.a(f14678d, this, obj, sVar)) {
                    return;
                }
            }
        }
    }

    private final Runnable e0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14678d;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                return null;
            }
            if (obj instanceof kotlinx.coroutines.internal.s) {
                kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                kotlinx.coroutines.internal.s sVar = (kotlinx.coroutines.internal.s) obj;
                Object objJ = sVar.j();
                if (objJ != kotlinx.coroutines.internal.s.f14869h) {
                    return (Runnable) objJ;
                }
                androidx.concurrent.futures.a.a(f14678d, this, obj, sVar.i());
            } else {
                if (obj == i1.f14808b) {
                    return null;
                }
                if (androidx.concurrent.futures.a.a(f14678d, this, obj, null)) {
                    kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                    return (Runnable) obj;
                }
            }
        }
    }

    private final boolean j0(Runnable task) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14678d;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (k0()) {
                return false;
            }
            if (obj == null) {
                if (androidx.concurrent.futures.a.a(f14678d, this, null, task)) {
                    return true;
                }
            } else if (obj instanceof kotlinx.coroutines.internal.s) {
                kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                kotlinx.coroutines.internal.s sVar = (kotlinx.coroutines.internal.s) obj;
                int iA = sVar.a(task);
                if (iA == 0) {
                    return true;
                }
                if (iA == 1) {
                    androidx.concurrent.futures.a.a(f14678d, this, obj, sVar.i());
                } else if (iA == 2) {
                    return false;
                }
            } else {
                if (obj == i1.f14808b) {
                    return false;
                }
                kotlinx.coroutines.internal.s sVar2 = new kotlinx.coroutines.internal.s(8, true);
                kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                sVar2.a((Runnable) obj);
                sVar2.a(task);
                if (androidx.concurrent.futures.a.a(f14678d, this, obj, sVar2)) {
                    return true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean k0() {
        return f14680f.get(this) != 0;
    }

    private final void q0(boolean z10) {
        f14680f.set(this, z10 ? 1 : 0);
    }

    private final boolean r0(b task) {
        c cVar = (c) f14679e.get(this);
        return (cVar != null ? cVar.e() : null) == task;
    }

    protected final void n0() {
        f14678d.set(this, null);
        f14679e.set(this, null);
    }

    @Override // kotlinx.coroutines.e1
    public void shutdown() {
        t2.f14936a.c();
        q0(true);
        c0();
        while (M() <= 0) {
        }
        m0();
    }

    private final void m0() {
        b bVarI;
        kotlinx.coroutines.c.a();
        long jNanoTime = System.nanoTime();
        while (true) {
            c cVar = (c) f14679e.get(this);
            if (cVar != null && (bVarI = cVar.i()) != null) {
                V(jNanoTime, bVarI);
            } else {
                return;
            }
        }
    }

    private final int p0(long now, b delayedTask) {
        if (k0()) {
            return 1;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14679e;
        c cVar = (c) atomicReferenceFieldUpdater.get(this);
        if (cVar == null) {
            androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, null, new c(now));
            Object obj = atomicReferenceFieldUpdater.get(this);
            kotlin.jvm.internal.m.c(obj);
            cVar = (c) obj;
        }
        return delayedTask.m(now, cVar, this);
    }

    @Override // kotlinx.coroutines.e1
    protected long A() {
        b bVarE;
        if (super.A() == 0) {
            return 0L;
        }
        Object obj = f14678d.get(this);
        if (obj != null) {
            if (obj instanceof kotlinx.coroutines.internal.s) {
                if (!((kotlinx.coroutines.internal.s) obj).g()) {
                    return 0L;
                }
            } else {
                if (obj != i1.f14808b) {
                    return 0L;
                }
                return LocationRequestCompat.PASSIVE_INTERVAL;
            }
        }
        c cVar = (c) f14679e.get(this);
        if (cVar == null || (bVarE = cVar.e()) == null) {
            return LocationRequestCompat.PASSIVE_INTERVAL;
        }
        long j10 = bVarE.nanoTime;
        kotlinx.coroutines.c.a();
        return h9.f.d(j10 - System.nanoTime(), 0L);
    }

    @Override // kotlinx.coroutines.e1
    public long M() {
        b bVarH;
        boolean zJ0;
        if (P()) {
            return 0L;
        }
        c cVar = (c) f14679e.get(this);
        if (cVar != null && !cVar.d()) {
            kotlinx.coroutines.c.a();
            long jNanoTime = System.nanoTime();
            do {
                synchronized (cVar) {
                    try {
                        b bVarB = cVar.b();
                        bVarH = null;
                        if (bVarB != null) {
                            b bVar = bVarB;
                            if (bVar.n(jNanoTime)) {
                                zJ0 = j0(bVar);
                            } else {
                                zJ0 = false;
                            }
                            if (zJ0) {
                                bVarH = cVar.h(0);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } while (bVarH != null);
        }
        Runnable runnableE0 = e0();
        if (runnableE0 != null) {
            runnableE0.run();
            return 0L;
        }
        return A();
    }

    @Override // kotlinx.coroutines.u0
    public void b(long timeMillis, n<? super r8.z> continuation) {
        long jC = i1.c(timeMillis);
        if (jC < 4611686018427387903L) {
            kotlinx.coroutines.c.a();
            long jNanoTime = System.nanoTime();
            a aVar = new a(jC + jNanoTime, continuation);
            o0(jNanoTime, aVar);
            q.a(continuation, aVar);
        }
    }

    @Override // kotlinx.coroutines.i0
    public final void dispatch(v8.j context, Runnable block) {
        i0(block);
    }

    public void i0(Runnable task) {
        if (j0(task)) {
            Z();
        } else {
            q0.f14902g.i0(task);
        }
    }

    protected boolean l0() {
        if (!J()) {
            return false;
        }
        c cVar = (c) f14679e.get(this);
        if (cVar != null && !cVar.d()) {
            return false;
        }
        Object obj = f14678d.get(this);
        if (obj == null) {
            return true;
        }
        if (obj instanceof kotlinx.coroutines.internal.s) {
            return ((kotlinx.coroutines.internal.s) obj).g();
        }
        if (obj != i1.f14808b) {
            return false;
        }
        return true;
    }

    public final void o0(long now, b delayedTask) {
        int iP0 = p0(now, delayedTask);
        if (iP0 != 0) {
            if (iP0 != 1) {
                if (iP0 != 2) {
                    throw new IllegalStateException("unexpected result");
                }
                return;
            } else {
                V(now, delayedTask);
                return;
            }
        }
        if (r0(delayedTask)) {
            Z();
        }
    }
}
