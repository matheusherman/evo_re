package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.types.g0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public interface c {
    Map<ba.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> a();

    ba.c d();

    a1 getSource();

    g0 getType();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public static ba.c a(c cVar) {
            kotlin.reflect.jvm.internal.impl.descriptors.e eVarI = ea.c.i(cVar);
            if (eVarI != null) {
                if (la.k.m(eVarI)) {
                    eVarI = null;
                }
                if (eVarI != null) {
                    return ea.c.h(eVarI);
                }
            }
            return null;
        }
    }
}
