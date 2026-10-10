package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u001a'\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a5\u0010\u000b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0017\u0010\r\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u0001H\u0002¢\u0006\u0004\b\r\u0010\u000e\"\u0018\u0010\u0011\u001a\u00020\t*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0018\u0010\u0013\u001a\u00020\t*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0014"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/x0;", "", "mode", "Lr8/z;", "a", "(Lkotlinx/coroutines/x0;I)V", "Lv8/f;", "delegate", "", "undispatched", "d", "(Lkotlinx/coroutines/x0;Lv8/f;Z)V", "e", "(Lkotlinx/coroutines/x0;)V", "b", "(I)Z", "isCancellableMode", "c", "isReusableMode", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class y0 {
    public static final boolean b(int i10) {
        return i10 == 1 || i10 == 2;
    }

    public static final boolean c(int i10) {
        return i10 == 2;
    }

    private static final void e(x0<?> x0Var) {
        e1 e1VarB = t2.f14936a.b();
        if (e1VarB.G()) {
            e1VarB.u(x0Var);
            return;
        }
        e1VarB.C(true);
        try {
            d(x0Var, x0Var.c(), true);
            do {
            } while (e1VarB.P());
        } catch (Throwable th) {
            try {
                x0Var.g(th, null);
            } finally {
                e1VarB.d(true);
            }
        }
    }

    public static final <T> void a(x0<? super T> x0Var, int i10) {
        boolean z10;
        v8.f<? super T> fVarC = x0Var.c();
        if (i10 == 4) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10 && (fVarC instanceof kotlinx.coroutines.internal.j) && b(i10) == b(x0Var.resumeMode)) {
            i0 i0Var = ((kotlinx.coroutines.internal.j) fVarC).dispatcher;
            v8.j context = fVarC.getContext();
            if (i0Var.isDispatchNeeded(context)) {
                i0Var.dispatch(context, x0Var);
                return;
            } else {
                e(x0Var);
                return;
            }
        }
        d(x0Var, fVarC, z10);
    }

    public static final <T> void d(x0<? super T> x0Var, v8.f<? super T> fVar, boolean z10) {
        Object objF;
        v2<?> v2VarG;
        boolean zM0;
        Object objJ = x0Var.j();
        Throwable thD = x0Var.d(objJ);
        if (thD != null) {
            r8.q.Companion companion = r8.q.INSTANCE;
            objF = r8.r.a(thD);
        } else {
            r8.q.Companion companion2 = r8.q.INSTANCE;
            objF = x0Var.f(objJ);
        }
        Object objA = r8.q.a(objF);
        if (z10) {
            kotlin.jvm.internal.m.d(fVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
            kotlinx.coroutines.internal.j jVar = (kotlinx.coroutines.internal.j) fVar;
            v8.f<T> fVar2 = jVar.continuation;
            Object obj = jVar.countOrElement;
            v8.j context = fVar2.getContext();
            Object objC = kotlinx.coroutines.internal.j0.c(context, obj);
            if (objC != kotlinx.coroutines.internal.j0.f14832a) {
                v2VarG = h0.g(fVar2, context, objC);
            } else {
                v2VarG = null;
            }
            try {
                jVar.continuation.resumeWith(objA);
                r8.z zVar = r8.z.f17874a;
                if (v2VarG != null) {
                    if (!zM0) {
                        return;
                    }
                }
                return;
            } finally {
                if (v2VarG == null || v2VarG.M0()) {
                    kotlinx.coroutines.internal.j0.a(context, objC);
                }
            }
        }
        fVar.resumeWith(objA);
    }
}
