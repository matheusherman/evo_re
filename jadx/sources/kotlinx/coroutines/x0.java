package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\b!\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\u0011\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH ¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\fH\u0010¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0014\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u001a\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001e8 X \u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001f¨\u0006!"}, d2 = {"Lkotlinx/coroutines/x0;", ExifInterface.GPS_DIRECTION_TRUE, "Lwa/h;", "Lkotlinx/coroutines/SchedulerTask;", "", "resumeMode", "<init>", "(I)V", "", "j", "()Ljava/lang/Object;", "takenState", "", "cause", "Lr8/z;", "a", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "state", "f", "(Ljava/lang/Object;)Ljava/lang/Object;", "d", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "run", "()V", "exception", "finallyException", "g", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)V", "c", "I", "Lv8/f;", "()Lv8/f;", "delegate", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class x0<T> extends wa.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public int resumeMode;

    public abstract v8.f<T> c();

    public abstract Object j();

    public Throwable d(Object state) {
        b0 b0Var = state instanceof b0 ? (b0) state : null;
        if (b0Var != null) {
            return b0Var.cause;
        }
        return null;
    }

    public final void g(Throwable exception, Throwable finallyException) {
        if (exception == null && finallyException == null) {
            return;
        }
        if (exception != null && finallyException != null) {
            r8.a.a(exception, finallyException);
        }
        if (exception == null) {
            exception = finallyException;
        }
        kotlin.jvm.internal.m.c(exception);
        k0.a(c().getContext(), new o0("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", exception));
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object objA;
        Object objA2;
        wa.i iVar = this.taskContext;
        try {
            v8.f<T> fVarC = c();
            kotlin.jvm.internal.m.d(fVarC, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            kotlinx.coroutines.internal.j jVar = (kotlinx.coroutines.internal.j) fVarC;
            v8.f<T> fVar = jVar.continuation;
            Object obj = jVar.countOrElement;
            v8.j context = fVar.getContext();
            Object objC = kotlinx.coroutines.internal.j0.c(context, obj);
            v2<?> v2VarG = objC != kotlinx.coroutines.internal.j0.f14832a ? h0.g(fVar, context, objC) : null;
            try {
                v8.j context2 = fVar.getContext();
                Object objJ = j();
                Throwable thD = d(objJ);
                u1 u1Var = (thD == null && y0.b(this.resumeMode)) ? (u1) context2.get(u1.INSTANCE) : null;
                if (u1Var != null && !u1Var.isActive()) {
                    CancellationException cancellationExceptionJ = u1Var.j();
                    a(objJ, cancellationExceptionJ);
                    r8.q.Companion companion = r8.q.INSTANCE;
                    fVar.resumeWith(r8.q.a(r8.r.a(cancellationExceptionJ)));
                } else if (thD != null) {
                    r8.q.Companion companion2 = r8.q.INSTANCE;
                    fVar.resumeWith(r8.q.a(r8.r.a(thD)));
                } else {
                    r8.q.Companion companion3 = r8.q.INSTANCE;
                    fVar.resumeWith(r8.q.a(f(objJ)));
                }
                r8.z zVar = r8.z.f17874a;
                if (v2VarG == null || v2VarG.M0()) {
                    kotlinx.coroutines.internal.j0.a(context, objC);
                }
                try {
                    iVar.a();
                    objA2 = r8.q.a(r8.z.f17874a);
                } catch (Throwable th) {
                    r8.q.Companion companion4 = r8.q.INSTANCE;
                    objA2 = r8.q.a(r8.r.a(th));
                }
                g(null, r8.q.c(objA2));
            } catch (Throwable th2) {
                if (v2VarG == null || v2VarG.M0()) {
                    kotlinx.coroutines.internal.j0.a(context, objC);
                }
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                r8.q.Companion companion5 = r8.q.INSTANCE;
                iVar.a();
                objA = r8.q.a(r8.z.f17874a);
            } catch (Throwable th4) {
                r8.q.Companion companion6 = r8.q.INSTANCE;
                objA = r8.q.a(r8.r.a(th4));
            }
            g(th3, r8.q.c(objA));
        }
    }

    public x0(int i10) {
        this.resumeMode = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T f(Object state) {
        return state;
    }

    public void a(Object takenState, Throwable cause) {
    }
}
