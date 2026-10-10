package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public interface b1 {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public static /* synthetic */ c1 a(b1 b1Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, g1 g1Var, kotlin.reflect.jvm.internal.impl.descriptors.m mVar, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toAttributes");
            }
            if ((i10 & 2) != 0) {
                g1Var = null;
            }
            if ((i10 & 4) != 0) {
                mVar = null;
            }
            return b1Var.a(gVar, g1Var, mVar);
        }
    }

    c1 a(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, g1 g1Var, kotlin.reflect.jvm.internal.impl.descriptors.m mVar);
}
