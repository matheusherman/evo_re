package p9;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.reflect.jvm.internal.impl.load.kotlin.s;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f17438a = new c();

    private final kotlin.reflect.jvm.internal.impl.resolve.constants.f a(Class<?> cls) {
        int i10 = 0;
        while (cls.isArray()) {
            i10++;
            cls = cls.getComponentType();
            kotlin.jvm.internal.m.e(cls, "currentClass.componentType");
        }
        if (!cls.isPrimitive()) {
            ba.b bVarA = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.a(cls);
            kotlin.reflect.jvm.internal.impl.builtins.jvm.c cVar = kotlin.reflect.jvm.internal.impl.builtins.jvm.c.f12505a;
            ba.c cVarB = bVarA.b();
            kotlin.jvm.internal.m.e(cVarB, "javaClassId.asSingleFqName()");
            ba.b bVarM = cVar.m(cVarB);
            if (bVarM != null) {
                bVarA = bVarM;
            }
            return new kotlin.reflect.jvm.internal.impl.resolve.constants.f(bVarA, i10);
        }
        if (kotlin.jvm.internal.m.a(cls, Void.TYPE)) {
            ba.b bVarM2 = ba.b.m(kotlin.reflect.jvm.internal.impl.builtins.k.a.f12608f.l());
            kotlin.jvm.internal.m.e(bVarM2, "topLevel(StandardNames.FqNames.unit.toSafe())");
            return new kotlin.reflect.jvm.internal.impl.resolve.constants.f(bVarM2, i10);
        }
        kotlin.reflect.jvm.internal.impl.builtins.i iVarL = fa.e.f(cls.getName()).l();
        kotlin.jvm.internal.m.e(iVarL, "get(currentClass.name).primitiveType");
        if (i10 > 0) {
            ba.b bVarM3 = ba.b.m(iVarL.f());
            kotlin.jvm.internal.m.e(bVarM3, "topLevel(primitiveType.arrayTypeFqName)");
            return new kotlin.reflect.jvm.internal.impl.resolve.constants.f(bVarM3, i10 - 1);
        }
        ba.b bVarM4 = ba.b.m(iVarL.j());
        kotlin.jvm.internal.m.e(bVarM4, "topLevel(primitiveType.typeFqName)");
        return new kotlin.reflect.jvm.internal.impl.resolve.constants.f(bVarM4, i10);
    }

    public final void b(Class<?> klass, s.c visitor) throws InvocationTargetException {
        kotlin.jvm.internal.m.f(klass, "klass");
        kotlin.jvm.internal.m.f(visitor, "visitor");
        Annotation[] declaredAnnotations = klass.getDeclaredAnnotations();
        kotlin.jvm.internal.m.e(declaredAnnotations, "klass.declaredAnnotations");
        for (Annotation annotation : declaredAnnotations) {
            kotlin.jvm.internal.m.e(annotation, "annotation");
            f(visitor, annotation);
        }
        visitor.a();
    }

    public final void i(Class<?> klass, s.d memberVisitor) throws InvocationTargetException {
        kotlin.jvm.internal.m.f(klass, "klass");
        kotlin.jvm.internal.m.f(memberVisitor, "memberVisitor");
        e(klass, memberVisitor);
        c(klass, memberVisitor);
        d(klass, memberVisitor);
    }

    private c() {
    }

    private final void c(Class<?> cls, s.d dVar) throws InvocationTargetException {
        boolean z10;
        Constructor<?>[] constructorArr;
        int i10;
        int i11;
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        kotlin.jvm.internal.m.e(declaredConstructors, "klass.declaredConstructors");
        int length = declaredConstructors.length;
        int i12 = 0;
        while (i12 < length) {
            Constructor<?> constructor = declaredConstructors[i12];
            ba.f fVar = ba.h.f951j;
            m mVar = m.f17452a;
            kotlin.jvm.internal.m.e(constructor, "constructor");
            s.e eVarA = dVar.a(fVar, mVar.a(constructor));
            if (eVarA == null) {
                constructorArr = declaredConstructors;
                i10 = length;
                i11 = i12;
            } else {
                Annotation[] declaredAnnotations = constructor.getDeclaredAnnotations();
                kotlin.jvm.internal.m.e(declaredAnnotations, "constructor.declaredAnnotations");
                for (Annotation annotation : declaredAnnotations) {
                    kotlin.jvm.internal.m.e(annotation, "annotation");
                    f(eVarA, annotation);
                }
                Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
                kotlin.jvm.internal.m.e(parameterAnnotations, "parameterAnnotations");
                if (parameterAnnotations.length == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    int length2 = constructor.getParameterTypes().length - parameterAnnotations.length;
                    int length3 = parameterAnnotations.length;
                    for (int i13 = 0; i13 < length3; i13++) {
                        Annotation[] annotations = parameterAnnotations[i13];
                        kotlin.jvm.internal.m.e(annotations, "annotations");
                        int length4 = annotations.length;
                        int i14 = 0;
                        while (i14 < length4) {
                            Annotation annotation2 = annotations[i14];
                            Class<?> clsB = b9.a.b(b9.a.a(annotation2));
                            Constructor<?>[] constructorArr2 = declaredConstructors;
                            int i15 = length;
                            ba.b bVarA = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.a(clsB);
                            int i16 = i12;
                            kotlin.jvm.internal.m.e(annotation2, "annotation");
                            s.a aVarB = eVarA.b(i13 + length2, bVarA, new b(annotation2));
                            if (aVarB != null) {
                                f17438a.h(aVarB, annotation2, clsB);
                            }
                            i14++;
                            declaredConstructors = constructorArr2;
                            length = i15;
                            i12 = i16;
                        }
                    }
                }
                constructorArr = declaredConstructors;
                i10 = length;
                i11 = i12;
                eVarA.a();
            }
            i12 = i11 + 1;
            declaredConstructors = constructorArr;
            length = i10;
        }
    }

    private final void d(Class<?> cls, s.d dVar) throws InvocationTargetException {
        Field[] declaredFields = cls.getDeclaredFields();
        kotlin.jvm.internal.m.e(declaredFields, "klass.declaredFields");
        for (Field field : declaredFields) {
            ba.f fVarL = ba.f.l(field.getName());
            kotlin.jvm.internal.m.e(fVarL, "identifier(field.name)");
            m mVar = m.f17452a;
            kotlin.jvm.internal.m.e(field, "field");
            s.c cVarB = dVar.b(fVarL, mVar.b(field), null);
            if (cVarB != null) {
                Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
                kotlin.jvm.internal.m.e(declaredAnnotations, "field.declaredAnnotations");
                for (Annotation annotation : declaredAnnotations) {
                    kotlin.jvm.internal.m.e(annotation, "annotation");
                    f(cVarB, annotation);
                }
                cVarB.a();
            }
        }
    }

    private final void e(Class<?> cls, s.d dVar) throws InvocationTargetException {
        Method[] methodArr;
        Method[] declaredMethods = cls.getDeclaredMethods();
        kotlin.jvm.internal.m.e(declaredMethods, "klass.declaredMethods");
        int length = declaredMethods.length;
        int i10 = 0;
        while (i10 < length) {
            Method method = declaredMethods[i10];
            ba.f fVarL = ba.f.l(method.getName());
            kotlin.jvm.internal.m.e(fVarL, "identifier(method.name)");
            m mVar = m.f17452a;
            kotlin.jvm.internal.m.e(method, "method");
            s.e eVarA = dVar.a(fVarL, mVar.c(method));
            if (eVarA == null) {
                methodArr = declaredMethods;
            } else {
                Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                kotlin.jvm.internal.m.e(declaredAnnotations, "method.declaredAnnotations");
                for (Annotation annotation : declaredAnnotations) {
                    kotlin.jvm.internal.m.e(annotation, "annotation");
                    f(eVarA, annotation);
                }
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                kotlin.jvm.internal.m.e(parameterAnnotations, "method.parameterAnnotations");
                Annotation[][] annotationArr = parameterAnnotations;
                int length2 = annotationArr.length;
                for (int i11 = 0; i11 < length2; i11++) {
                    Annotation[] annotations = annotationArr[i11];
                    kotlin.jvm.internal.m.e(annotations, "annotations");
                    int length3 = annotations.length;
                    int i12 = 0;
                    while (i12 < length3) {
                        Annotation annotation2 = annotations[i12];
                        Class<?> clsB = b9.a.b(b9.a.a(annotation2));
                        ba.b bVarA = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.a(clsB);
                        Method[] methodArr2 = declaredMethods;
                        kotlin.jvm.internal.m.e(annotation2, "annotation");
                        s.a aVarB = eVarA.b(i11, bVarA, new b(annotation2));
                        if (aVarB != null) {
                            f17438a.h(aVarB, annotation2, clsB);
                        }
                        i12++;
                        declaredMethods = methodArr2;
                    }
                }
                methodArr = declaredMethods;
                eVarA.a();
            }
            i10++;
            declaredMethods = methodArr;
        }
    }

    private final void f(s.c cVar, Annotation annotation) throws InvocationTargetException {
        Class<?> clsB = b9.a.b(b9.a.a(annotation));
        s.a aVarC = cVar.c(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.a(clsB), new b(annotation));
        if (aVarC != null) {
            f17438a.h(aVarC, annotation, clsB);
        }
    }

    private final void g(s.a aVar, ba.f fVar, Object obj) throws InvocationTargetException {
        Class<?> enclosingClass = obj.getClass();
        if (kotlin.jvm.internal.m.a(enclosingClass, Class.class)) {
            kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type java.lang.Class<*>");
            aVar.d(fVar, a((Class) obj));
            return;
        }
        if (i.f17445a.contains(enclosingClass)) {
            aVar.f(fVar, obj);
            return;
        }
        if (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.g(enclosingClass)) {
            if (!enclosingClass.isEnum()) {
                enclosingClass = enclosingClass.getEnclosingClass();
            }
            kotlin.jvm.internal.m.e(enclosingClass, "if (clazz.isEnum) clazz else clazz.enclosingClass");
            ba.b bVarA = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.a(enclosingClass);
            kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type kotlin.Enum<*>");
            ba.f fVarL = ba.f.l(((Enum) obj).name());
            kotlin.jvm.internal.m.e(fVarL, "identifier((value as Enum<*>).name)");
            aVar.c(fVar, bVarA, fVarL);
            return;
        }
        if (Annotation.class.isAssignableFrom(enclosingClass)) {
            Class<?>[] interfaces = enclosingClass.getInterfaces();
            kotlin.jvm.internal.m.e(interfaces, "clazz.interfaces");
            Class<?> annotationClass = (Class) kotlin.collections.j.n0(interfaces);
            kotlin.jvm.internal.m.e(annotationClass, "annotationClass");
            s.a aVarE = aVar.e(fVar, kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.a(annotationClass));
            if (aVarE != null) {
                kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type kotlin.Annotation");
                h(aVarE, (Annotation) obj, annotationClass);
                return;
            }
            return;
        }
        if (enclosingClass.isArray()) {
            s.b bVarB = aVar.b(fVar);
            if (bVarB == null) {
                return;
            }
            Class<?> componentType = enclosingClass.getComponentType();
            int i10 = 0;
            if (componentType.isEnum()) {
                kotlin.jvm.internal.m.e(componentType, "componentType");
                ba.b bVarA2 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.a(componentType);
                kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type kotlin.Array<*>");
                Object[] objArr = (Object[]) obj;
                int length = objArr.length;
                while (i10 < length) {
                    Object obj2 = objArr[i10];
                    kotlin.jvm.internal.m.d(obj2, "null cannot be cast to non-null type kotlin.Enum<*>");
                    ba.f fVarL2 = ba.f.l(((Enum) obj2).name());
                    kotlin.jvm.internal.m.e(fVarL2, "identifier((element as Enum<*>).name)");
                    bVarB.c(bVarA2, fVarL2);
                    i10++;
                }
            } else if (kotlin.jvm.internal.m.a(componentType, Class.class)) {
                kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type kotlin.Array<*>");
                Object[] objArr2 = (Object[]) obj;
                int length2 = objArr2.length;
                while (i10 < length2) {
                    Object obj3 = objArr2[i10];
                    kotlin.jvm.internal.m.d(obj3, "null cannot be cast to non-null type java.lang.Class<*>");
                    bVarB.e(a((Class) obj3));
                    i10++;
                }
            } else if (Annotation.class.isAssignableFrom(componentType)) {
                kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type kotlin.Array<*>");
                Object[] objArr3 = (Object[]) obj;
                int length3 = objArr3.length;
                while (i10 < length3) {
                    Object obj4 = objArr3[i10];
                    kotlin.jvm.internal.m.e(componentType, "componentType");
                    s.a aVarD = bVarB.d(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.a(componentType));
                    if (aVarD != null) {
                        kotlin.jvm.internal.m.d(obj4, "null cannot be cast to non-null type kotlin.Annotation");
                        h(aVarD, (Annotation) obj4, componentType);
                    }
                    i10++;
                }
            } else {
                kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type kotlin.Array<*>");
                Object[] objArr4 = (Object[]) obj;
                int length4 = objArr4.length;
                while (i10 < length4) {
                    bVarB.b(objArr4[i10]);
                    i10++;
                }
            }
            bVarB.a();
            return;
        }
        throw new UnsupportedOperationException("Unsupported annotation argument value (" + enclosingClass + "): " + obj);
    }

    private final void h(s.a aVar, Annotation annotation, Class<?> cls) throws InvocationTargetException {
        Method[] declaredMethods = cls.getDeclaredMethods();
        kotlin.jvm.internal.m.e(declaredMethods, "annotationType.declaredMethods");
        for (Method method : declaredMethods) {
            try {
                Object objInvoke = method.invoke(annotation, null);
                kotlin.jvm.internal.m.c(objInvoke);
                ba.f fVarL = ba.f.l(method.getName());
                kotlin.jvm.internal.m.e(fVarL, "identifier(method.name)");
                g(aVar, fVarL, objInvoke);
            } catch (IllegalAccessException unused) {
            }
        }
        aVar.a();
    }
}
