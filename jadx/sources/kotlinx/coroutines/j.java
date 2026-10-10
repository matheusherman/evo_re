package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aL\u0010\u000b\u001a\u00020\n*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001aX\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\r*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001aR\u0010\u0011\u001a\u00028\u0000\"\u0004\b\u0000\u0010\r2\u0006\u0010\u0002\u001a\u00020\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\u0086@ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/l0;", "Lv8/j;", "context", "Lkotlinx/coroutines/n0;", "start", "Lkotlin/Function2;", "Lv8/f;", "Lr8/z;", "", "block", "Lkotlinx/coroutines/u1;", "c", "(Lkotlinx/coroutines/l0;Lv8/j;Lkotlinx/coroutines/n0;Lc9/p;)Lkotlinx/coroutines/u1;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/s0;", "a", "(Lkotlinx/coroutines/l0;Lv8/j;Lkotlinx/coroutines/n0;Lc9/p;)Lkotlinx/coroutines/s0;", "e", "(Lv8/j;Lc9/p;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/BuildersKt")
public final /* synthetic */ class j {
    public static /* synthetic */ s0 b(l0 l0Var, v8.j jVar, n0 n0Var, c9.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            jVar = v8.k.f19724a;
        }
        if ((i10 & 2) != 0) {
            n0Var = n0.DEFAULT;
        }
        return h.a(l0Var, jVar, n0Var, pVar);
    }

    public static /* synthetic */ u1 d(l0 l0Var, v8.j jVar, n0 n0Var, c9.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            jVar = v8.k.f19724a;
        }
        if ((i10 & 2) != 0) {
            n0Var = n0.DEFAULT;
        }
        return h.c(l0Var, jVar, n0Var, pVar);
    }

    public static final <T> s0<T> a(l0 l0Var, v8.j jVar, n0 n0Var, c9.p<? super l0, ? super v8.f<? super T>, ? extends Object> pVar) {
        t0 t0Var;
        v8.j jVarD = h0.d(l0Var, jVar);
        if (n0Var.i()) {
            t0Var = new e2(jVarD, pVar);
        } else {
            t0Var = new t0(jVarD, true);
        }
        ((a) t0Var).L0(n0Var, t0Var, pVar);
        return (s0<T>) t0Var;
    }

    public static final u1 c(l0 l0Var, v8.j jVar, n0 n0Var, c9.p<? super l0, ? super v8.f<? super r8.z>, ? extends Object> pVar) {
        a o2Var;
        v8.j jVarD = h0.d(l0Var, jVar);
        if (n0Var.i()) {
            o2Var = new f2(jVarD, pVar);
        } else {
            o2Var = new o2(jVarD, true);
        }
        o2Var.L0(n0Var, o2Var, pVar);
        return o2Var;
    }

    public static final <T> Object e(v8.j jVar, c9.p<? super l0, ? super v8.f<? super T>, ? extends Object> pVar, v8.f<? super T> fVar) throws Throwable {
        Object objM0;
        v8.j context = fVar.getContext();
        v8.j jVarE = h0.e(context, jVar);
        y1.h(jVarE);
        if (jVarE == context) {
            kotlinx.coroutines.internal.b0 b0Var = new kotlinx.coroutines.internal.b0(jVarE, fVar);
            objM0 = va.b.b(b0Var, b0Var, pVar);
        } else {
            v8.g.Companion bVar = v8.g.INSTANCE;
            if (kotlin.jvm.internal.m.a(jVarE.get(bVar), context.get(bVar))) {
                v2 v2Var = new v2(jVarE, fVar);
                v8.j context2 = v2Var.getContext();
                Object objC = kotlinx.coroutines.internal.j0.c(context2, null);
                try {
                    Object objB = va.b.b(v2Var, v2Var, pVar);
                    kotlinx.coroutines.internal.j0.a(context2, objC);
                    objM0 = objB;
                } catch (Throwable th) {
                    kotlinx.coroutines.internal.j0.a(context2, objC);
                    throw th;
                }
            } else {
                w0 w0Var = new w0(jVarE, fVar);
                va.a.d(pVar, w0Var, w0Var, null, 4, null);
                objM0 = w0Var.M0();
            }
        }
        if (objM0 == kotlin.coroutines.intrinsics.b.c()) {
            kotlin.coroutines.jvm.internal.h.c(fVar);
        }
        return objM0;
    }
}
