package kotlinx.coroutines;

import androidx.core.location.LocationRequestCompat;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\"\u0018\u0010\t\u001a\u00020\u0006*\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"", "timeMillis", "Lr8/z;", "a", "(JLv8/f;)Ljava/lang/Object;", "Lv8/j;", "Lkotlinx/coroutines/u0;", "b", "(Lv8/j;)Lkotlinx/coroutines/u0;", "delay", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class v0 {
    public static final Object a(long j10, v8.f<? super r8.z> fVar) {
        if (j10 <= 0) {
            return r8.z.f17874a;
        }
        o oVar = new o(kotlin.coroutines.intrinsics.b.b(fVar), 1);
        oVar.D();
        if (j10 < LocationRequestCompat.PASSIVE_INTERVAL) {
            b(oVar.getContext()).b(j10, oVar);
        }
        Object objZ = oVar.z();
        if (objZ == kotlin.coroutines.intrinsics.b.c()) {
            kotlin.coroutines.jvm.internal.h.c(fVar);
        }
        return objZ == kotlin.coroutines.intrinsics.b.c() ? objZ : r8.z.f17874a;
    }

    public static final u0 b(v8.j jVar) {
        v8.j.b bVar = jVar.get(v8.g.INSTANCE);
        u0 u0Var = bVar instanceof u0 ? (u0) bVar : null;
        return u0Var == null ? r0.a() : u0Var;
    }
}
