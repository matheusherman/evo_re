package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class u extends t implements u9.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Method f13054a;

    public u(Method member) {
        kotlin.jvm.internal.m.f(member, "member");
        this.f13054a = member;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.t
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public Method Q() {
        return this.f13054a;
    }

    @Override // u9.r
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public z getReturnType() {
        z.a aVar = z.f13060a;
        Type genericReturnType = Q().getGenericReturnType();
        kotlin.jvm.internal.m.e(genericReturnType, "member.genericReturnType");
        return aVar.a(genericReturnType);
    }

    @Override // u9.r
    public boolean J() {
        if (p() != null) {
            return true;
        }
        return false;
    }

    @Override // u9.r
    public List<u9.b0> f() {
        Type[] genericParameterTypes = Q().getGenericParameterTypes();
        kotlin.jvm.internal.m.e(genericParameterTypes, "member.genericParameterTypes");
        Annotation[][] parameterAnnotations = Q().getParameterAnnotations();
        kotlin.jvm.internal.m.e(parameterAnnotations, "member.parameterAnnotations");
        return R(genericParameterTypes, parameterAnnotations, Q().isVarArgs());
    }

    @Override // u9.z
    public List<a0> getTypeParameters() {
        TypeVariable<Method>[] typeParameters = Q().getTypeParameters();
        kotlin.jvm.internal.m.e(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Method> typeVariable : typeParameters) {
            arrayList.add(new a0(typeVariable));
        }
        return arrayList;
    }

    @Override // u9.r
    public u9.b p() {
        Object defaultValue = Q().getDefaultValue();
        if (defaultValue == null) {
            return null;
        }
        return f.f13031b.a(defaultValue, null);
    }
}
