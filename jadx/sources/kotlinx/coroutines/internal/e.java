package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.internal.e;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u00020\u0002B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\fR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u0004\u0018\u00018\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00028\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\u0019\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u001b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000eR\u0013\u0010\u0003\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0014R\u0014\u0010\u001e\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u000eR\u0013\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001f8\u0002X\u0082\u0004R\u0013\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u001f8\u0002X\u0082\u0004¨\u0006\""}, d2 = {"Lkotlinx/coroutines/internal/e;", "N", "", "prev", "<init>", "(Lkotlinx/coroutines/internal/e;)V", "value", "", "l", "(Lkotlinx/coroutines/internal/e;)Z", "Lr8/z;", "b", "()V", "j", "()Z", "k", "f", "()Ljava/lang/Object;", "nextOrClosed", "c", "()Lkotlinx/coroutines/internal/e;", "aliveSegmentLeft", "d", "aliveSegmentRight", "e", "next", "i", "isTail", "g", "h", "isRemoved", "Lkotlinx/atomicfu/AtomicRef;", "_next", "_prev", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class e<N extends e<N>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f14817a = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_next");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f14818b = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_prev");
    private volatile Object _next;
    private volatile Object _prev;

    public abstract boolean h();

    /* JADX INFO: Access modifiers changed from: private */
    public final Object f() {
        return f14817a.get(this);
    }

    public final void b() {
        f14818b.lazySet(this, null);
    }

    public final N g() {
        return (N) f14818b.get(this);
    }

    public final boolean j() {
        return androidx.concurrent.futures.a.a(f14817a, this, null, d.f14816a);
    }

    public final boolean l(N value) {
        return androidx.concurrent.futures.a.a(f14817a, this, null, value);
    }

    public e(N n10) {
        this._prev = n10;
    }

    private final N c() {
        N n10 = (N) g();
        while (n10 != null && n10.h()) {
            n10 = (N) f14818b.get(n10);
        }
        return n10;
    }

    private final N d() {
        e eVarE;
        N n10 = (N) e();
        kotlin.jvm.internal.m.c(n10);
        while (n10.h() && (eVarE = n10.e()) != null) {
            n10 = (N) eVarE;
        }
        return n10;
    }

    public final N e() {
        Object objF = f();
        if (objF == d.f14816a) {
            return null;
        }
        return (N) objF;
    }

    public final boolean i() {
        if (e() == null) {
            return true;
        }
        return false;
    }

    public final void k() {
        Object obj;
        e eVar;
        if (i()) {
            return;
        }
        while (true) {
            e eVarC = c();
            e eVarD = d();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14818b;
            do {
                obj = atomicReferenceFieldUpdater.get(eVarD);
                if (((e) obj) == null) {
                    eVar = null;
                } else {
                    eVar = eVarC;
                }
            } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, eVarD, obj, eVar));
            if (eVarC != null) {
                f14817a.set(eVarC, eVarD);
            }
            if (!eVarD.h() || eVarD.i()) {
                if (eVarC == null || !eVarC.h()) {
                    return;
                }
            }
        }
    }
}
