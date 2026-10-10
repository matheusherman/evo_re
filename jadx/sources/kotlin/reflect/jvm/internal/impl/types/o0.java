package kotlin.reflect.jvm.internal.impl.types;

import java.io.IOException;
import java.util.Iterator;
import org.apache.log4j.spi.LocationInfo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class o0 extends v1 implements na.k, na.l {
    public o0() {
        super(null);
    }

    /* JADX INFO: renamed from: Q0 */
    public abstract o0 N0(boolean z10);

    /* JADX INFO: renamed from: R0 */
    public abstract o0 P0(c1 c1Var);

    public String toString() throws IOException {
        StringBuilder sb2 = new StringBuilder();
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> it = getAnnotations().iterator();
        while (it.hasNext()) {
            ua.n.m(sb2, "[", kotlin.reflect.jvm.internal.impl.renderer.c.s(kotlin.reflect.jvm.internal.impl.renderer.c.f13793j, it.next(), null, 2, null), "] ");
        }
        sb2.append(J0());
        if (!H0().isEmpty()) {
            kotlin.collections.c0.n0(H0(), sb2, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : "<", (124 & 8) == 0 ? ">" : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null);
        }
        if (K0()) {
            sb2.append(LocationInfo.NA);
        }
        String string = sb2.toString();
        kotlin.jvm.internal.m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
