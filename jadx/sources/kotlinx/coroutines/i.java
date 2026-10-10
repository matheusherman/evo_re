package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001aQ\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\"\u0010\u0007\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lv8/j;", "context", "Lkotlin/Function2;", "Lkotlinx/coroutines/l0;", "Lv8/f;", "", "block", "a", "(Lv8/j;Lc9/p;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/BuildersKt")
public final /* synthetic */ class i {
    public static /* synthetic */ Object b(v8.j jVar, c9.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            jVar = v8.k.f19724a;
        }
        return h.e(jVar, pVar);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0036  */
    public static final <T> T a(v8.j jVar, c9.p<? super l0, ? super v8.f<? super T>, ? extends Object> pVar) {
        e1 e1Var;
        e1 e1VarA;
        v8.j jVarD;
        Thread threadCurrentThread = Thread.currentThread();
        v8.g gVar = (v8.g) jVar.get(v8.g.INSTANCE);
        if (gVar == null) {
            e1VarA = t2.f14936a.b();
            jVarD = h0.d(n1.f14892a, jVar.plus(e1VarA));
        } else {
            e1 e1Var2 = null;
            if (gVar instanceof e1) {
                e1Var = (e1) gVar;
            } else {
                e1Var = null;
            }
            if (e1Var != null) {
                if (e1Var.R()) {
                    e1Var2 = e1Var;
                }
                if (e1Var2 != null) {
                    e1VarA = e1Var2;
                } else {
                    e1VarA = t2.f14936a.a();
                }
            } else {
                e1VarA = t2.f14936a.a();
            }
            jVarD = h0.d(n1.f14892a, jVar);
        }
        f fVar = new f(jVarD, threadCurrentThread, e1VarA);
        fVar.L0(n0.DEFAULT, fVar, pVar);
        return (T) fVar.M0();
    }
}
