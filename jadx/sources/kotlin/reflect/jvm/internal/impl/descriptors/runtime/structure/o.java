package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class o extends t implements u9.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Constructor<?> f13050a;

    public o(Constructor<?> member) {
        kotlin.jvm.internal.m.f(member, "member");
        this.f13050a = member;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.t
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public Constructor<?> Q() {
        return this.f13050a;
    }

    @Override // u9.k
    public List<u9.b0> f() {
        Type[] realTypes = Q().getGenericParameterTypes();
        kotlin.jvm.internal.m.e(realTypes, "types");
        if (realTypes.length == 0) {
            return kotlin.collections.r.l();
        }
        Class<?> declaringClass = Q().getDeclaringClass();
        if (declaringClass.getDeclaringClass() != null && !Modifier.isStatic(declaringClass.getModifiers())) {
            realTypes = (Type[]) kotlin.collections.j.p(realTypes, 1, realTypes.length);
        }
        Annotation[][] realAnnotations = Q().getParameterAnnotations();
        if (realAnnotations.length >= realTypes.length) {
            if (realAnnotations.length > realTypes.length) {
                kotlin.jvm.internal.m.e(realAnnotations, "annotations");
                realAnnotations = (Annotation[][]) kotlin.collections.j.p(realAnnotations, realAnnotations.length - realTypes.length, realAnnotations.length);
            }
            kotlin.jvm.internal.m.e(realTypes, "realTypes");
            kotlin.jvm.internal.m.e(realAnnotations, "realAnnotations");
            return R(realTypes, realAnnotations, Q().isVarArgs());
        }
        throw new IllegalStateException("Illegal generic signature: " + Q());
    }

    @Override // u9.z
    public List<a0> getTypeParameters() {
        TypeVariable<Constructor<?>>[] typeParameters = Q().getTypeParameters();
        kotlin.jvm.internal.m.e(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Constructor<?>> typeVariable : typeParameters) {
            arrayList.add(new a0(typeVariable));
        }
        return arrayList;
    }
}
