package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.m0;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class n implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m0 f14180a;

    public n(m0 packageFragmentProvider) {
        kotlin.jvm.internal.m.f(packageFragmentProvider, "packageFragmentProvider");
        this.f14180a = packageFragmentProvider;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.h
    public g a(ba.b classId) {
        g gVarA;
        kotlin.jvm.internal.m.f(classId, "classId");
        m0 m0Var = this.f14180a;
        ba.c cVarH = classId.h();
        kotlin.jvm.internal.m.e(cVarH, "classId.packageFqName");
        for (l0 l0Var : o0.c(m0Var, cVarH)) {
            if ((l0Var instanceof o) && (gVarA = ((o) l0Var).B0().a(classId)) != null) {
                return gVarA;
            }
        }
        return null;
    }
}
