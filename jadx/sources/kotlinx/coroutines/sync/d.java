package kotlinx.coroutines.sync;

import c9.l;
import c9.p;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlinx.coroutines.channels.i;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.d0;
import kotlinx.coroutines.n;
import kotlinx.coroutines.x2;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u000e*\u00020\u0001H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0015\u0010\u0012J\u001d\u0010\u0017\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u0016H\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0019\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\t0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\bR\u000b\u0010$\u001a\u00020#8\u0002X\u0082\u0004R\u000b\u0010&\u001a\u00020%8\u0002X\u0082\u0004R\u000b\u0010'\u001a\u00020%8\u0002X\u0082\u0004R\u0011\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002X\u0082\u0004R\u0011\u0010+\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002X\u0082\u0004¨\u0006,"}, d2 = {"Lkotlinx/coroutines/sync/d;", "", "", "permits", "acquiredPermits", "<init>", "(II)V", "f", "()I", "Lr8/z;", "e", "()V", "Lkotlinx/coroutines/x2;", "waiter", "", "d", "(Lkotlinx/coroutines/x2;)Z", "k", "()Z", "j", "(Ljava/lang/Object;)Z", "i", "Lkotlinx/coroutines/n;", "c", "(Lkotlinx/coroutines/n;)V", "h", "a", "I", "Lkotlin/Function1;", "", "b", "Lc9/l;", "onCancellationRelease", "g", "availablePermits", "Lkotlinx/atomicfu/AtomicInt;", "_availablePermits", "Lkotlinx/atomicfu/AtomicLong;", "deqIdx", "enqIdx", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/sync/f;", "head", "tail", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f14919c = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "head");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicLongFieldUpdater f14920d = AtomicLongFieldUpdater.newUpdater(d.class, "deqIdx");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f14921e = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "tail");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final AtomicLongFieldUpdater f14922f = AtomicLongFieldUpdater.newUpdater(d.class, "enqIdx");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f14923g = AtomicIntegerFieldUpdater.newUpdater(d.class, "_availablePermits");
    private volatile int _availablePermits;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int permits;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final l<Throwable, z> onCancellationRelease;
    private volatile long deqIdx;
    private volatile long enqIdx;
    private volatile Object head;
    private volatile Object tail;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class a extends k implements p<Long, f, f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f14926a = new a();

        a() {
            super(2, e.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        @Override // c9.p
        public /* bridge */ /* synthetic */ f invoke(Long l10, f fVar) {
            return j(l10.longValue(), fVar);
        }

        public final f j(long j10, f fVar) {
            return e.h(j10, fVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "<anonymous parameter 0>", "Lr8/z;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    static final class b extends o implements l<Throwable, z> {
        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(Throwable th) {
            invoke2(th);
            return z.f17874a;
        }

        b() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            d.this.h();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class c extends k implements p<Long, f, f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f14927a = new c();

        c() {
            super(2, e.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        @Override // c9.p
        public /* bridge */ /* synthetic */ f invoke(Long l10, f fVar) {
            return j(l10.longValue(), fVar);
        }

        public final f j(long j10, f fVar) {
            return e.h(j10, fVar);
        }
    }

    private final boolean d(x2 waiter) {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14921e;
        f fVar = (f) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f14922f.getAndIncrement(this);
        a aVar = a.f14926a;
        long j10 = andIncrement / ((long) e.f14933f);
        loop0: while (true) {
            objC = kotlinx.coroutines.internal.d.c(fVar, j10, aVar);
            if (!d0.c(objC)) {
                c0 c0VarB = d0.b(objC);
                while (true) {
                    c0 c0Var = (c0) atomicReferenceFieldUpdater.get(this);
                    if (c0Var.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String >= c0VarB.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String) {
                        break loop0;
                    }
                    if (!c0VarB.q()) {
                        break;
                    }
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, c0Var, c0VarB)) {
                        if (!c0Var.m()) {
                            break loop0;
                        }
                        c0Var.k();
                        break loop0;
                    }
                    if (c0VarB.m()) {
                        c0VarB.k();
                    }
                }
            } else {
                break;
            }
        }
        f fVar2 = (f) d0.b(objC);
        int i10 = (int) (andIncrement % ((long) e.f14933f));
        if (i.a(fVar2.getF14934e(), i10, null, waiter)) {
            waiter.b(fVar2, i10);
            return true;
        }
        if (!i.a(fVar2.getF14934e(), i10, e.f14929b, e.f14930c)) {
            return false;
        }
        if (waiter instanceof n) {
            m.d(waiter, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            ((n) waiter).q(z.f17874a, this.onCancellationRelease);
        } else {
            if (!(waiter instanceof xa.b)) {
                throw new IllegalStateException(("unexpected: " + waiter).toString());
            }
            ((xa.b) waiter).c(z.f17874a);
        }
        return true;
    }

    private final void e() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i10;
        int i11;
        do {
            atomicIntegerFieldUpdater = f14923g;
            i10 = atomicIntegerFieldUpdater.get(this);
            i11 = this.permits;
            if (i10 <= i11) {
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, i11));
    }

    private final int f() {
        int andDecrement;
        do {
            andDecrement = f14923g.getAndDecrement(this);
        } while (andDecrement > this.permits);
        return andDecrement;
    }

    private final boolean j(Object obj) {
        if (!(obj instanceof n)) {
            if (obj instanceof xa.b) {
                return ((xa.b) obj).a(this, z.f17874a);
            }
            throw new IllegalStateException(("unexpected: " + obj).toString());
        }
        m.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        n nVar = (n) obj;
        Object objE = nVar.e(z.f17874a, null, this.onCancellationRelease);
        if (objE == null) {
            return false;
        }
        nVar.A(objE);
        return true;
    }

    private final boolean k() {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14919c;
        f fVar = (f) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f14920d.getAndIncrement(this);
        long j10 = andIncrement / ((long) e.f14933f);
        c cVar = c.f14927a;
        loop0: while (true) {
            objC = kotlinx.coroutines.internal.d.c(fVar, j10, cVar);
            if (d0.c(objC)) {
                break;
            }
            c0 c0VarB = d0.b(objC);
            while (true) {
                c0 c0Var = (c0) atomicReferenceFieldUpdater.get(this);
                if (c0Var.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String >= c0VarB.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String) {
                    break loop0;
                }
                if (!c0VarB.q()) {
                    break;
                }
                if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, c0Var, c0VarB)) {
                    if (!c0Var.m()) {
                        break loop0;
                    }
                    c0Var.k();
                    break loop0;
                }
                if (c0VarB.m()) {
                    c0VarB.k();
                }
            }
        }
        f fVar2 = (f) d0.b(objC);
        fVar2.b();
        if (fVar2.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String > j10) {
            return false;
        }
        int i10 = (int) (andIncrement % ((long) e.f14933f));
        Object andSet = fVar2.getF14934e().getAndSet(i10, e.f14929b);
        if (andSet != null) {
            if (andSet == e.f14932e) {
                return false;
            }
            return j(andSet);
        }
        int i11 = e.f14928a;
        for (int i12 = 0; i12 < i11; i12++) {
            if (fVar2.getF14934e().get(i10) == e.f14930c) {
                return true;
            }
        }
        return !i.a(fVar2.getF14934e(), i10, e.f14929b, e.f14931d);
    }

    public int g() {
        return Math.max(f14923g.get(this), 0);
    }

    public void h() {
        do {
            int andIncrement = f14923g.getAndIncrement(this);
            if (andIncrement >= this.permits) {
                e();
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.permits).toString());
            }
            if (andIncrement >= 0) {
                return;
            }
        } while (!k());
    }

    public boolean i() {
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f14923g;
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 > this.permits) {
                e();
            } else {
                if (i10 <= 0) {
                    return false;
                }
                if (atomicIntegerFieldUpdater.compareAndSet(this, i10, i10 - 1)) {
                    return true;
                }
            }
        }
    }

    public d(int i10, int i11) {
        this.permits = i10;
        if (i10 > 0) {
            if (i11 >= 0 && i11 <= i10) {
                f fVar = new f(0L, null, 2);
                this.head = fVar;
                this.tail = fVar;
                this._availablePermits = i10 - i11;
                this.onCancellationRelease = new b();
                return;
            }
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i10).toString());
        }
        throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i10).toString());
    }

    protected final void c(n<? super z> waiter) {
        while (f() <= 0) {
            m.d(waiter, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (d((x2) waiter)) {
                return;
            }
        }
        waiter.q(z.f17874a, this.onCancellationRelease);
    }
}
