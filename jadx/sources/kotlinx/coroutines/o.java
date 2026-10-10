package kotlinx.coroutines;

import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\u00060\u0004j\u0002`\u00052\u00020\u0006B\u001d\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0017\u001a\u00020\u00162\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0001\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0001\u0010\u000fJ\u000f\u0010\u0019\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0019\u0010\u000fJ\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J!\u0010\"\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\b\"\u0010#J)\u0010'\u001a\u00020&2\u0018\u0010\u001e\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00160$j\u0002`%H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\tH\u0002¢\u0006\u0004\b*\u0010+JK\u00100\u001a\u0004\u0018\u00010\u001d2\u0006\u0010!\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\n\u001a\u00020\t2\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0016\u0018\u00010$2\b\u0010/\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\b0\u00101J9\u00102\u001a\u00020\u00162\b\u0010-\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\n\u001a\u00020\t2\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0016\u0018\u00010$H\u0002¢\u0006\u0004\b2\u00103J;\u00105\u001a\u0004\u0018\u0001042\b\u0010-\u001a\u0004\u0018\u00010\u001d2\b\u0010/\u001a\u0004\u0018\u00010\u001d2\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0016\u0018\u00010$H\u0002¢\u0006\u0004\b5\u00106J\u0019\u00108\u001a\u0002072\b\u0010-\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u0016H\u0002¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u0016H\u0016¢\u0006\u0004\b<\u0010;J\u000f\u0010=\u001a\u00020\rH\u0001¢\u0006\u0004\b=\u0010\u000fJ\u0011\u0010>\u001a\u0004\u0018\u00010\u001dH\u0010¢\u0006\u0004\b>\u0010?J!\u0010A\u001a\u00020\u00162\b\u0010@\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0011\u001a\u00020\u0010H\u0010¢\u0006\u0004\bA\u0010BJ\u0019\u0010C\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\bC\u0010\u0013J\u0017\u0010D\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0004\bD\u0010EJ\u001f\u0010F\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020&2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\bF\u0010GJ)\u0010H\u001a\u00020\u00162\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00160$2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\bH\u0010IJ\u0017\u0010L\u001a\u00020\u00102\u0006\u0010K\u001a\u00020JH\u0016¢\u0006\u0004\bL\u0010MJ\u0011\u0010N\u001a\u0004\u0018\u00010\u001dH\u0001¢\u0006\u0004\bN\u0010?J\u000f\u0010O\u001a\u00020\u0016H\u0000¢\u0006\u0004\bO\u0010;J \u0010R\u001a\u00020\u00162\f\u0010Q\u001a\b\u0012\u0004\u0012\u00028\u00000PH\u0016ø\u0001\u0000¢\u0006\u0004\bR\u0010 J-\u0010T\u001a\u00020\u00162\u0006\u0010S\u001a\u00028\u00002\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0016\u0018\u00010$H\u0016¢\u0006\u0004\bT\u0010UJ#\u0010W\u001a\u00020\u00162\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00142\u0006\u0010V\u001a\u00020\tH\u0016¢\u0006\u0004\bW\u0010XJ)\u0010Y\u001a\u00020\u00162\u0018\u0010\u001e\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00160$j\u0002`%H\u0016¢\u0006\u0004\bY\u0010ZJ\u000f\u0010[\u001a\u00020\u0016H\u0000¢\u0006\u0004\b[\u0010;J9\u0010\\\u001a\u0004\u0018\u00010\u001d2\u0006\u0010S\u001a\u00028\u00002\b\u0010/\u001a\u0004\u0018\u00010\u001d2\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0016\u0018\u00010$H\u0016¢\u0006\u0004\b\\\u0010]J\u0017\u0010_\u001a\u00020\u00162\u0006\u0010^\u001a\u00020\u001dH\u0016¢\u0006\u0004\b_\u0010 J\u001b\u0010a\u001a\u00020\u0016*\u00020`2\u0006\u0010S\u001a\u00028\u0000H\u0016¢\u0006\u0004\ba\u0010bJ\u001f\u0010c\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010!\u001a\u0004\u0018\u00010\u001dH\u0010¢\u0006\u0004\bc\u0010dJ\u001b\u0010e\u001a\u0004\u0018\u00010\u00102\b\u0010!\u001a\u0004\u0018\u00010\u001dH\u0010¢\u0006\u0004\be\u0010fJ\u000f\u0010h\u001a\u00020gH\u0016¢\u0006\u0004\bh\u0010iJ\u000f\u0010j\u001a\u00020gH\u0014¢\u0006\u0004\bj\u0010iR \u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\be\u0010k\u001a\u0004\bl\u0010mR\u001a\u0010r\u001a\u00020n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\\\u0010o\u001a\u0004\bp\u0010qR\u0016\u0010t\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bs\u0010\u001cR\u0014\u0010v\u001a\u00020g8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bu\u0010iR\u0016\u0010!\u001a\u0004\u0018\u00010\u001d8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bw\u0010?R\u0014\u0010y\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bx\u0010\u000fR\u001c\u0010|\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bz\u0010{R\u000b\u0010~\u001a\u00020}8\u0002X\u0082\u0004R\u0014\u0010\u0080\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u007f8\u0002X\u0082\u0004R\u0014\u0010\u0081\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u007f8\u0002X\u0082\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0082\u0001"}, d2 = {"Lkotlinx/coroutines/o;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/x0;", "Lkotlinx/coroutines/n;", "Lkotlin/coroutines/jvm/internal/e;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/x2;", "Lv8/f;", "delegate", "", "resumeMode", "<init>", "(Lv8/f;I)V", "", "H", "()Z", "", "cause", "r", "(Ljava/lang/Throwable;)Z", "Lkotlinx/coroutines/internal/c0;", "segment", "Lr8/z;", "p", "(Lkotlinx/coroutines/internal/c0;Ljava/lang/Throwable;)V", "R", "Lkotlinx/coroutines/b1;", ExifInterface.LONGITUDE_EAST, "()Lkotlinx/coroutines/b1;", "", "handler", "F", "(Ljava/lang/Object;)V", "state", "J", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Lkotlin/Function1;", "Lkotlinx/coroutines/CompletionHandler;", "Lkotlinx/coroutines/l;", "I", "(Lc9/l;)Lkotlinx/coroutines/l;", "mode", "v", "(I)V", "Lkotlinx/coroutines/j2;", "proposedUpdate", "onCancellation", "idempotent", "Q", "(Lkotlinx/coroutines/j2;Ljava/lang/Object;ILc9/l;Ljava/lang/Object;)Ljava/lang/Object;", "O", "(Ljava/lang/Object;ILc9/l;)V", "Lkotlinx/coroutines/internal/f0;", ExifInterface.LATITUDE_SOUTH, "(Ljava/lang/Object;Ljava/lang/Object;Lc9/l;)Lkotlinx/coroutines/internal/f0;", "", "k", "(Ljava/lang/Object;)Ljava/lang/Void;", "t", "()V", "D", "N", "j", "()Ljava/lang/Object;", "takenState", "a", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "u", "L", "(Ljava/lang/Throwable;)V", "m", "(Lkotlinx/coroutines/l;Ljava/lang/Throwable;)V", "n", "(Lc9/l;Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/u1;", "parent", "w", "(Lkotlinx/coroutines/u1;)Ljava/lang/Throwable;", "z", "M", "Lr8/q;", "result", "resumeWith", "value", "q", "(Ljava/lang/Object;Lc9/l;)V", "index", "b", "(Lkotlinx/coroutines/internal/c0;I)V", "h", "(Lc9/l;)V", "s", "e", "(Ljava/lang/Object;Ljava/lang/Object;Lc9/l;)Ljava/lang/Object;", "token", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lkotlinx/coroutines/i0;", "o", "(Lkotlinx/coroutines/i0;Ljava/lang/Object;)V", "f", "(Ljava/lang/Object;)Ljava/lang/Object;", "d", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "", "toString", "()Ljava/lang/String;", "K", "Lv8/f;", "c", "()Lv8/f;", "Lv8/j;", "Lv8/j;", "getContext", "()Lv8/j;", "context", "x", "parentHandle", "C", "stateDebugRepresentation", "B", "G", "isCompleted", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/e;", "callerFrame", "Lkotlinx/atomicfu/AtomicInt;", "_decisionAndIndex", "Lkotlinx/atomicfu/AtomicRef;", "_parentHandle", "_state", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class o<T> extends x0<T> implements n<T>, kotlin.coroutines.jvm.internal.e, x2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f14895f = AtomicIntegerFieldUpdater.newUpdater(o.class, "_decisionAndIndex");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f14896g = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_state");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f14897h = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_parentHandle");
    private volatile int _decisionAndIndex;
    private volatile Object _parentHandle;
    private volatile Object _state;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final v8.f<T> delegate;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final v8.j context;

    private final void F(Object handler) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14896g;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof d)) {
                if (obj instanceof l ? true : obj instanceof kotlinx.coroutines.internal.c0) {
                    J(handler, obj);
                } else {
                    if (obj instanceof b0) {
                        b0 b0Var = (b0) obj;
                        if (!b0Var.b()) {
                            J(handler, obj);
                        }
                        if (obj instanceof r) {
                            Throwable th = b0Var.cause;
                            if (handler instanceof l) {
                                m((l) handler, th);
                                return;
                            } else {
                                kotlin.jvm.internal.m.d(handler, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                                p((kotlinx.coroutines.internal.c0) handler, th);
                                return;
                            }
                        }
                        return;
                    }
                    if (obj instanceof CompletedContinuation) {
                        CompletedContinuation completedContinuation = (CompletedContinuation) obj;
                        if (completedContinuation.cancelHandler != null) {
                            J(handler, obj);
                        }
                        if (handler instanceof kotlinx.coroutines.internal.c0) {
                            return;
                        }
                        kotlin.jvm.internal.m.d(handler, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                        l lVar = (l) handler;
                        if (completedContinuation.c()) {
                            m(lVar, completedContinuation.cancelCause);
                            return;
                        } else {
                            if (androidx.concurrent.futures.a.a(f14896g, this, obj, CompletedContinuation.b(completedContinuation, null, lVar, null, null, null, 29, null))) {
                                return;
                            }
                        }
                    } else {
                        if (handler instanceof kotlinx.coroutines.internal.c0) {
                            return;
                        }
                        kotlin.jvm.internal.m.d(handler, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                        if (androidx.concurrent.futures.a.a(f14896g, this, obj, new CompletedContinuation(obj, (l) handler, null, null, null, 28, null))) {
                            return;
                        }
                    }
                }
            } else if (androidx.concurrent.futures.a.a(f14896g, this, obj, handler)) {
                return;
            }
        }
    }

    private final boolean H() {
        if (!y0.c(this.resumeMode)) {
            return false;
        }
        v8.f<T> fVar = this.delegate;
        kotlin.jvm.internal.m.d(fVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((kotlinx.coroutines.internal.j) fVar).r();
    }

    private final l I(c9.l<? super Throwable, r8.z> handler) {
        return handler instanceof l ? (l) handler : new r1(handler);
    }

    private final void J(Object handler, Object state) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + handler + ", already has " + state).toString());
    }

    private final void O(Object proposedUpdate, int resumeMode, c9.l<? super Throwable, r8.z> onCancellation) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14896g;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof j2)) {
                Object obj2 = proposedUpdate;
                c9.l<? super Throwable, r8.z> lVar = onCancellation;
                if (obj instanceof r) {
                    r rVar = (r) obj;
                    if (rVar.c()) {
                        if (lVar != null) {
                            n(lVar, rVar.cause);
                            return;
                        }
                        return;
                    }
                }
                k(obj2);
                throw new r8.e();
            }
            Object obj3 = proposedUpdate;
            int i10 = resumeMode;
            c9.l<? super Throwable, r8.z> lVar2 = onCancellation;
            if (androidx.concurrent.futures.a.a(f14896g, this, obj, Q((j2) obj, obj3, i10, lVar2, null))) {
                t();
                v(i10);
                return;
            } else {
                proposedUpdate = obj3;
                resumeMode = i10;
                onCancellation = lVar2;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void P(o oVar, Object obj, int i10, c9.l lVar, int i11, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i11 & 4) != 0) {
            lVar = null;
        }
        oVar.O(obj, i10, lVar);
    }

    private final Object Q(j2 state, Object proposedUpdate, int resumeMode, c9.l<? super Throwable, r8.z> onCancellation, Object idempotent) {
        if (proposedUpdate instanceof b0) {
            return proposedUpdate;
        }
        if ((y0.b(resumeMode) || idempotent != null) && !(onCancellation == null && !(state instanceof l) && idempotent == null)) {
            return new CompletedContinuation(proposedUpdate, state instanceof l ? (l) state : null, onCancellation, idempotent, null, 16, null);
        }
        return proposedUpdate;
    }

    private final boolean R() {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f14895f;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            int i11 = i10 >> 29;
            if (i11 != 0) {
                if (i11 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!f14895f.compareAndSet(this, i10, BasicMeasure.EXACTLY + (536870911 & i10)));
        return true;
    }

    private final kotlinx.coroutines.internal.f0 S(Object proposedUpdate, Object idempotent, c9.l<? super Throwable, r8.z> onCancellation) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14896g;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof j2)) {
                Object obj2 = idempotent;
                if ((obj instanceof CompletedContinuation) && obj2 != null && ((CompletedContinuation) obj).idempotentResume == obj2) {
                    return p.f14901a;
                }
                return null;
            }
            Object obj3 = proposedUpdate;
            Object obj4 = idempotent;
            c9.l<? super Throwable, r8.z> lVar = onCancellation;
            if (androidx.concurrent.futures.a.a(f14896g, this, obj, Q((j2) obj, obj3, this.resumeMode, lVar, obj4))) {
                t();
                return p.f14901a;
            }
            proposedUpdate = obj3;
            onCancellation = lVar;
            idempotent = obj4;
        }
    }

    private final boolean T() {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f14895f;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            int i11 = i10 >> 29;
            if (i11 != 0) {
                if (i11 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended");
            }
        } while (!f14895f.compareAndSet(this, i10, 536870912 + (536870911 & i10)));
        return true;
    }

    private final Void k(Object proposedUpdate) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + proposedUpdate).toString());
    }

    private final void p(kotlinx.coroutines.internal.c0<?> segment, Throwable cause) {
        int i10 = f14895f.get(this) & 536870911;
        if (i10 == 536870911) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
        }
        try {
            segment.o(i10, cause, getContext());
        } catch (Throwable th) {
            k0.a(getContext(), new e0("Exception in invokeOnCancellation handler for " + this, th));
        }
    }

    private final b1 x() {
        return (b1) f14897h.get(this);
    }

    @Override // kotlinx.coroutines.n
    public void A(Object token) {
        v(this.resumeMode);
    }

    public final Object B() {
        return f14896g.get(this);
    }

    protected String K() {
        return "CancellableContinuation";
    }

    public final void M() {
        Throwable thV;
        v8.f<T> fVar = this.delegate;
        kotlinx.coroutines.internal.j jVar = fVar instanceof kotlinx.coroutines.internal.j ? (kotlinx.coroutines.internal.j) fVar : null;
        if (jVar == null || (thV = jVar.v(this)) == null) {
            return;
        }
        s();
        u(thV);
    }

    public final boolean N() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14896g;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if ((obj instanceof CompletedContinuation) && ((CompletedContinuation) obj).idempotentResume != null) {
            s();
            return false;
        }
        f14895f.set(this, 536870911);
        atomicReferenceFieldUpdater.set(this, d.f14663a);
        return true;
    }

    @Override // kotlinx.coroutines.x0
    public void a(Object takenState, Throwable cause) {
        Throwable th;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14896g;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof j2) {
                throw new IllegalStateException("Not completed");
            }
            if (obj instanceof b0) {
                return;
            }
            if (obj instanceof CompletedContinuation) {
                CompletedContinuation completedContinuation = (CompletedContinuation) obj;
                if (completedContinuation.c()) {
                    throw new IllegalStateException("Must be called at most once");
                }
                Throwable th2 = cause;
                th = th2;
                if (androidx.concurrent.futures.a.a(f14896g, this, obj, CompletedContinuation.b(completedContinuation, null, null, null, null, th2, 15, null))) {
                    completedContinuation.d(this, th);
                    return;
                }
            } else {
                th = cause;
                if (androidx.concurrent.futures.a.a(f14896g, this, obj, new CompletedContinuation(obj, null, null, null, th, 14, null))) {
                    return;
                }
            }
            cause = th;
        }
    }

    @Override // kotlinx.coroutines.x2
    public void b(kotlinx.coroutines.internal.c0<?> segment, int index) {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f14895f;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            if ((i10 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, ((i10 >> 29) << 29) + index));
        F(segment);
    }

    @Override // kotlinx.coroutines.x0
    public final v8.f<T> c() {
        return this.delegate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.x0
    public <T> T f(Object state) {
        return state instanceof CompletedContinuation ? (T) ((CompletedContinuation) state).result : state;
    }

    @Override // kotlin.coroutines.jvm.internal.e
    public kotlin.coroutines.jvm.internal.e getCallerFrame() {
        v8.f<T> fVar = this.delegate;
        if (fVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) fVar;
        }
        return null;
    }

    @Override // v8.f
    public v8.j getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.n
    public void o(i0 i0Var, T t10) {
        v8.f<T> fVar = this.delegate;
        kotlinx.coroutines.internal.j jVar = fVar instanceof kotlinx.coroutines.internal.j ? (kotlinx.coroutines.internal.j) fVar : null;
        P(this, t10, (jVar != null ? jVar.dispatcher : null) == i0Var ? 4 : this.resumeMode, null, 4, null);
    }

    @Override // kotlinx.coroutines.n
    public void q(T value, c9.l<? super Throwable, r8.z> onCancellation) {
        O(value, this.resumeMode, onCancellation);
    }

    public String toString() {
        return K() + '(' + p0.c(this.delegate) + "){" + C() + "}@" + p0.b(this);
    }

    @Override // kotlinx.coroutines.n
    public boolean u(Throwable cause) {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14896g;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof j2)) {
                return false;
            }
        } while (!androidx.concurrent.futures.a.a(f14896g, this, obj, new r(this, cause, (obj instanceof l) || (obj instanceof kotlinx.coroutines.internal.c0))));
        j2 j2Var = (j2) obj;
        if (j2Var instanceof l) {
            m((l) obj, cause);
        } else if (j2Var instanceof kotlinx.coroutines.internal.c0) {
            p((kotlinx.coroutines.internal.c0) obj, cause);
        }
        t();
        v(this.resumeMode);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o(v8.f<? super T> fVar, int i10) {
        super(i10);
        this.delegate = fVar;
        this.context = fVar.getContext();
        this._decisionAndIndex = 536870911;
        this._state = d.f14663a;
    }

    private final String C() {
        Object objB = B();
        if (objB instanceof j2) {
            return "Active";
        }
        if (objB instanceof r) {
            return "Cancelled";
        }
        return "Completed";
    }

    private final b1 E() {
        u1 u1Var = (u1) getContext().get(u1.INSTANCE);
        if (u1Var == null) {
            return null;
        }
        b1 b1VarD = u1.a.d(u1Var, true, false, new s(this), 2, null);
        androidx.concurrent.futures.a.a(f14897h, this, null, b1VarD);
        return b1VarD;
    }

    private final boolean r(Throwable cause) {
        if (!H()) {
            return false;
        }
        v8.f<T> fVar = this.delegate;
        kotlin.jvm.internal.m.d(fVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((kotlinx.coroutines.internal.j) fVar).s(cause);
    }

    private final void t() {
        if (!H()) {
            s();
        }
    }

    private final void v(int mode) {
        if (R()) {
            return;
        }
        y0.a(this, mode);
    }

    public void D() {
        b1 b1VarE = E();
        if (b1VarE != null && G()) {
            b1VarE.dispose();
            f14897h.set(this, i2.f14809a);
        }
    }

    public boolean G() {
        return !(B() instanceof j2);
    }

    public final void L(Throwable cause) {
        if (r(cause)) {
            return;
        }
        u(cause);
        t();
    }

    @Override // kotlinx.coroutines.x0
    public Throwable d(Object state) {
        Throwable thD = super.d(state);
        if (thD != null) {
            return thD;
        }
        return null;
    }

    @Override // kotlinx.coroutines.n
    public Object e(T value, Object idempotent, c9.l<? super Throwable, r8.z> onCancellation) {
        return S(value, idempotent, onCancellation);
    }

    @Override // kotlinx.coroutines.n
    public void h(c9.l<? super Throwable, r8.z> handler) {
        F(I(handler));
    }

    @Override // kotlinx.coroutines.x0
    public Object j() {
        return B();
    }

    public final void m(l handler, Throwable cause) {
        try {
            handler.e(cause);
        } catch (Throwable th) {
            k0.a(getContext(), new e0("Exception in invokeOnCancellation handler for " + this, th));
        }
    }

    public final void n(c9.l<? super Throwable, r8.z> onCancellation, Throwable cause) {
        try {
            onCancellation.invoke(cause);
        } catch (Throwable th) {
            k0.a(getContext(), new e0("Exception in resume onCancellation handler for " + this, th));
        }
    }

    @Override // v8.f
    public void resumeWith(Object result) {
        P(this, f0.c(result, this), this.resumeMode, null, 4, null);
    }

    public final void s() {
        b1 b1VarX = x();
        if (b1VarX == null) {
            return;
        }
        b1VarX.dispose();
        f14897h.set(this, i2.f14809a);
    }

    public Throwable w(u1 parent) {
        return parent.j();
    }

    public final Object z() {
        u1 u1Var;
        boolean zH = H();
        if (T()) {
            if (x() == null) {
                E();
            }
            if (zH) {
                M();
            }
            return kotlin.coroutines.intrinsics.b.c();
        }
        if (zH) {
            M();
        }
        Object objB = B();
        if (!(objB instanceof b0)) {
            if (y0.b(this.resumeMode) && (u1Var = (u1) getContext().get(u1.INSTANCE)) != null && !u1Var.isActive()) {
                CancellationException cancellationExceptionJ = u1Var.j();
                a(objB, cancellationExceptionJ);
                throw cancellationExceptionJ;
            }
            return f(objB);
        }
        throw ((b0) objB).cause;
    }
}
