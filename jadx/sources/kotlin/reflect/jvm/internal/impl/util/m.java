package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.y;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class m implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f14427a = new m();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f14428b = "should not have varargs or parameters with default values";

    @Override // kotlin.reflect.jvm.internal.impl.util.f
    public boolean b(y functionDescriptor) {
        kotlin.jvm.internal.m.f(functionDescriptor, "functionDescriptor");
        List<j1> listF = functionDescriptor.f();
        kotlin.jvm.internal.m.e(listF, "functionDescriptor.valueParameters");
        List<j1> list = listF;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        for (j1 it : list) {
            kotlin.jvm.internal.m.e(it, "it");
            if (ea.c.c(it) || it.h0() != null) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.f
    public String getDescription() {
        return f14428b;
    }

    private m() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.f
    public String a(y yVar) {
        return f.a.a(this, yVar);
    }
}
