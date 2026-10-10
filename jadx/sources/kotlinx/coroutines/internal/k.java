package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.t2;
import kotlinx.coroutines.u1;
import kotlinx.coroutines.v2;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aH\u0010\b\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0019\u0010\f\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u00060\nH\u0000¢\u0006\u0004\b\f\u0010\r\"\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010\"\u0014\u0010\u0012\u001a\u00020\u000e8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lv8/f;", "Lr8/q;", "result", "Lkotlin/Function1;", "", "Lr8/z;", "onCancellation", "b", "(Lv8/f;Ljava/lang/Object;Lc9/l;)V", "Lkotlinx/coroutines/internal/j;", "", "d", "(Lkotlinx/coroutines/internal/j;)Z", "Lkotlinx/coroutines/internal/f0;", "a", "Lkotlinx/coroutines/internal/f0;", "UNDEFINED", "REUSABLE_CLAIMED", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final f0 f14839a = new f0("UNDEFINED");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f0 f14840b = new f0("REUSABLE_CLAIMED");

    public static final <T> void b(v8.f<? super T> fVar, Object obj, c9.l<? super Throwable, r8.z> lVar) {
        if (!(fVar instanceof j)) {
            fVar.resumeWith(obj);
            return;
        }
        j jVar = (j) fVar;
        Object objB = kotlinx.coroutines.f0.b(obj, lVar);
        if (jVar.dispatcher.isDispatchNeeded(jVar.getContext())) {
            jVar._state = objB;
            jVar.resumeMode = 1;
            jVar.dispatcher.dispatch(jVar.getContext(), jVar);
            return;
        }
        e1 e1VarB = t2.f14936a.b();
        if (e1VarB.G()) {
            jVar._state = objB;
            jVar.resumeMode = 1;
            e1VarB.u(jVar);
            return;
        }
        e1VarB.C(true);
        try {
            u1 u1Var = (u1) jVar.getContext().get(u1.INSTANCE);
            if (u1Var == null || u1Var.isActive()) {
                v8.f<T> fVar2 = jVar.continuation;
                Object obj2 = jVar.countOrElement;
                v8.j context = fVar2.getContext();
                Object objC = j0.c(context, obj2);
                v2<?> v2VarG = objC != j0.f14832a ? kotlinx.coroutines.h0.g(fVar2, context, objC) : null;
                try {
                    jVar.continuation.resumeWith(obj);
                    r8.z zVar = r8.z.f17874a;
                    if (v2VarG == null || v2VarG.M0()) {
                        j0.a(context, objC);
                    }
                } catch (Throwable th) {
                    if (v2VarG == null || v2VarG.M0()) {
                        j0.a(context, objC);
                    }
                    throw th;
                }
            } else {
                CancellationException cancellationExceptionJ = u1Var.j();
                jVar.a(objB, cancellationExceptionJ);
                r8.q.Companion companion = r8.q.INSTANCE;
                jVar.resumeWith(r8.q.a(r8.r.a(cancellationExceptionJ)));
            }
            while (e1VarB.P()) {
            }
        } catch (Throwable th2) {
            try {
                jVar.g(th2, null);
            } finally {
                e1VarB.d(true);
            }
        }
    }

    public static /* synthetic */ void c(v8.f fVar, Object obj, c9.l lVar, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            lVar = null;
        }
        b(fVar, obj, lVar);
    }

    public static final boolean d(j<? super r8.z> jVar) {
        r8.z zVar = r8.z.f17874a;
        e1 e1VarB = t2.f14936a.b();
        if (e1VarB.J()) {
            return false;
        }
        if (e1VarB.G()) {
            jVar._state = zVar;
            jVar.resumeMode = 1;
            e1VarB.u(jVar);
            return true;
        }
        e1VarB.C(true);
        try {
            jVar.run();
            do {
            } while (e1VarB.P());
        } catch (Throwable th) {
            try {
                jVar.g(th, null);
            } finally {
                e1VarB.d(true);
            }
        }
        return false;
    }
}
