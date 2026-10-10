package va;

import androidx.exifinterface.media.ExifInterface;
import c9.p;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.h0;
import kotlinx.coroutines.d2;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.j0;
import r8.q;
import r8.r;
import v8.f;
import v8.j;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aT\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022\u0006\u0010\u0005\u001a\u00028\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001aV\u0010\f\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u0005\u001a\u00028\u00012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "Lv8/f;", "", "receiver", "completion", "Lr8/z;", "a", "(Lc9/p;Ljava/lang/Object;Lv8/f;)V", "Lkotlinx/coroutines/internal/b0;", "block", "b", "(Lkotlinx/coroutines/internal/b0;Ljava/lang/Object;Lc9/p;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class b {
    public static final <T, R> Object b(b0<? super T> b0Var, R r10, p<? super R, ? super f<? super T>, ? extends Object> pVar) {
        Object b0Var2;
        try {
            b0Var2 = ((p) h0.f(pVar, 2)).invoke(r10, b0Var);
        } catch (Throwable th) {
            b0Var2 = new kotlinx.coroutines.b0(th, false, 2, null);
        }
        if (b0Var2 == kotlin.coroutines.intrinsics.b.c()) {
            return kotlin.coroutines.intrinsics.b.c();
        }
        Object objL0 = b0Var.l0(b0Var2);
        if (objL0 == d2.f14666b) {
            return kotlin.coroutines.intrinsics.b.c();
        }
        if (objL0 instanceof kotlinx.coroutines.b0) {
            throw ((kotlinx.coroutines.b0) objL0).cause;
        }
        return d2.h(objL0);
    }

    public static final <R, T> void a(p<? super R, ? super f<? super T>, ? extends Object> pVar, R r10, f<? super T> fVar) {
        f fVarA = h.a(fVar);
        try {
            j context = fVar.getContext();
            Object objC = j0.c(context, null);
            try {
                Object objInvoke = ((p) h0.f(pVar, 2)).invoke(r10, fVarA);
                j0.a(context, objC);
                if (objInvoke != kotlin.coroutines.intrinsics.b.c()) {
                    fVarA.resumeWith(q.a(objInvoke));
                }
            } catch (Throwable th) {
                j0.a(context, objC);
                throw th;
            }
        } catch (Throwable th2) {
            q.Companion companion = q.INSTANCE;
            fVarA.resumeWith(q.a(r.a(th2)));
        }
    }
}
