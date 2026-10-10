package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.CompletedWithCancellation;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.t2;
import kotlinx.coroutines.x0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u00028\u00000\u0005B\u001d\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012H\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0015H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0011\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0010¢\u0006\u0004\b\u001d\u0010\u001eJ \u0010!\u001a\u00020\u000e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J!\u0010$\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0019\u001a\u00020\u0016H\u0010¢\u0006\u0004\b$\u0010%J\u001f\u0010)\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00028\u0000H\u0000¢\u0006\u0004\b)\u0010*J\u000f\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b,\u0010-R\u0014\u0010\u0007\u001a\u00020\u00068\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u001e\u00105\u001a\u0004\u0018\u00010\u001c8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b2\u00103\u0012\u0004\b4\u0010\u0010R\u0014\u00107\u001a\u00020\u001c8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b6\u00103R\u001a\u00109\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\u0014R\u0014\u0010'\u001a\u00020&8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b:\u0010;R\u001c\u0010>\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0013\u0010C\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0B8\u0002X\u0082\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006D"}, d2 = {"Lkotlinx/coroutines/internal/j;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/x0;", "Lkotlin/coroutines/jvm/internal/e;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lv8/f;", "Lkotlinx/coroutines/i0;", "dispatcher", "continuation", "<init>", "(Lkotlinx/coroutines/i0;Lv8/f;)V", "", "r", "()Z", "Lr8/z;", "k", "()V", "t", "Lkotlinx/coroutines/o;", "m", "()Lkotlinx/coroutines/o;", "Lkotlinx/coroutines/n;", "", "v", "(Lkotlinx/coroutines/n;)Ljava/lang/Throwable;", "cause", "s", "(Ljava/lang/Throwable;)Z", "", "j", "()Ljava/lang/Object;", "Lr8/q;", "result", "resumeWith", "(Ljava/lang/Object;)V", "takenState", "a", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "Lv8/j;", "context", "value", "n", "(Lv8/j;Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "d", "Lkotlinx/coroutines/i0;", "e", "Lv8/f;", "f", "Ljava/lang/Object;", "get_state$kotlinx_coroutines_core$annotations", "_state", "g", "countOrElement", "p", "reusableCancellableContinuation", "getContext", "()Lv8/j;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/e;", "callerFrame", "c", "()Lv8/f;", "delegate", "Lkotlinx/atomicfu/AtomicRef;", "_reusableCancellableContinuation", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class j<T> extends x0<T> implements kotlin.coroutines.jvm.internal.e, v8.f<T> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f14827h = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final kotlinx.coroutines.i0 dispatcher;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final v8.f<T> continuation;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    public Object _state;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Object countOrElement;

    /* JADX WARN: Multi-variable type inference failed */
    public j(kotlinx.coroutines.i0 i0Var, v8.f<? super T> fVar) {
        super(-1);
        this.dispatcher = i0Var;
        this.continuation = fVar;
        this._state = k.f14839a;
        this.countOrElement = j0.b(getContext());
    }

    private final kotlinx.coroutines.o<?> p() {
        Object obj = f14827h.get(this);
        if (obj instanceof kotlinx.coroutines.o) {
            return (kotlinx.coroutines.o) obj;
        }
        return null;
    }

    @Override // kotlinx.coroutines.x0
    public void a(Object takenState, Throwable cause) {
        if (takenState instanceof CompletedWithCancellation) {
            ((CompletedWithCancellation) takenState).onCancellation.invoke(cause);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.e
    public kotlin.coroutines.jvm.internal.e getCallerFrame() {
        v8.f<T> fVar = this.continuation;
        if (fVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) fVar;
        }
        return null;
    }

    @Override // v8.f
    public v8.j getContext() {
        return this.continuation.getContext();
    }

    @Override // kotlinx.coroutines.x0
    public Object j() {
        Object obj = this._state;
        this._state = k.f14839a;
        return obj;
    }

    public final void k() {
        while (f14827h.get(this) == k.f14840b) {
        }
    }

    public final kotlinx.coroutines.o<T> m() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14827h;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                f14827h.set(this, k.f14840b);
                return null;
            }
            if (obj instanceof kotlinx.coroutines.o) {
                if (androidx.concurrent.futures.a.a(f14827h, this, obj, k.f14840b)) {
                    return (kotlinx.coroutines.o) obj;
                }
            } else if (obj != k.f14840b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final void n(v8.j context, T value) {
        this._state = value;
        this.resumeMode = 1;
        this.dispatcher.dispatchYield(context, this);
    }

    public final boolean r() {
        return f14827h.get(this) != null;
    }

    @Override // v8.f
    public void resumeWith(Object result) {
        v8.j context = this.continuation.getContext();
        Object objD = kotlinx.coroutines.f0.d(result, null, 1, null);
        if (this.dispatcher.isDispatchNeeded(context)) {
            this._state = objD;
            this.resumeMode = 0;
            this.dispatcher.dispatch(context, this);
            return;
        }
        e1 e1VarB = t2.f14936a.b();
        if (e1VarB.G()) {
            this._state = objD;
            this.resumeMode = 0;
            e1VarB.u(this);
            return;
        }
        e1VarB.C(true);
        try {
            v8.j context2 = getContext();
            Object objC = j0.c(context2, this.countOrElement);
            try {
                this.continuation.resumeWith(result);
                r8.z zVar = r8.z.f17874a;
                j0.a(context2, objC);
                while (e1VarB.P()) {
                }
            } catch (Throwable th) {
                j0.a(context2, objC);
                throw th;
            }
        } catch (Throwable th2) {
            try {
                g(th2, null);
            } finally {
                e1VarB.d(true);
            }
        }
    }

    public final boolean s(Throwable cause) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14827h;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            f0 f0Var = k.f14840b;
            if (kotlin.jvm.internal.m.a(obj, f0Var)) {
                if (androidx.concurrent.futures.a.a(f14827h, this, f0Var, cause)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (androidx.concurrent.futures.a.a(f14827h, this, obj, null)) {
                    return false;
                }
            }
        }
    }

    public String toString() {
        return "DispatchedContinuation[" + this.dispatcher + ", " + kotlinx.coroutines.p0.c(this.continuation) + ']';
    }

    public final Throwable v(kotlinx.coroutines.n<?> continuation) {
        f0 f0Var;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14827h;
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            f0Var = k.f14840b;
            if (obj != f0Var) {
                if (obj instanceof Throwable) {
                    if (androidx.concurrent.futures.a.a(f14827h, this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.");
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!androidx.concurrent.futures.a.a(f14827h, this, f0Var, continuation));
        return null;
    }

    public final void t() {
        k();
        kotlinx.coroutines.o<?> oVarP = p();
        if (oVarP != null) {
            oVarP.s();
        }
    }

    @Override // kotlinx.coroutines.x0
    public v8.f<T> c() {
        return this;
    }
}
