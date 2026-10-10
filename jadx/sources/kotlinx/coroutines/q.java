package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\n\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lv8/f;", "delegate", "Lkotlinx/coroutines/o;", "b", "(Lv8/f;)Lkotlinx/coroutines/o;", "Lkotlinx/coroutines/n;", "Lkotlinx/coroutines/b1;", "handle", "Lr8/z;", "a", "(Lkotlinx/coroutines/n;Lkotlinx/coroutines/b1;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class q {
    public static final void a(n<?> nVar, b1 b1Var) {
        nVar.h(new c1(b1Var));
    }

    public static final <T> o<T> b(v8.f<? super T> fVar) {
        if (!(fVar instanceof kotlinx.coroutines.internal.j)) {
            return new o<>(fVar, 1);
        }
        o<T> oVarM = ((kotlinx.coroutines.internal.j) fVar).m();
        if (oVarM != null) {
            if (!oVarM.N()) {
                oVarM = null;
            }
            if (oVarM != null) {
                return oVarM;
            }
        }
        return new o<>(fVar, 2);
    }
}
