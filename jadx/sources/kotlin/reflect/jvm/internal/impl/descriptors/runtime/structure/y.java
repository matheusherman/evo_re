package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class y extends t implements u9.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f13059a;

    @Override // u9.w
    public boolean a() {
        return false;
    }

    public y(Object recordComponent) {
        kotlin.jvm.internal.m.f(recordComponent, "recordComponent");
        this.f13059a = recordComponent;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.t
    public Member Q() throws IllegalAccessException, InvocationTargetException {
        Method methodC = a.f13002a.c(this.f13059a);
        if (methodC != null) {
            return methodC;
        }
        throw new NoSuchMethodError("Can't find `getAccessor` method");
    }

    @Override // u9.w
    public u9.x getType() throws IllegalAccessException, InvocationTargetException {
        Class<?> clsD = a.f13002a.d(this.f13059a);
        if (clsD != null) {
            return new n(clsD);
        }
        throw new NoSuchMethodError("Can't find `getType` method");
    }
}
