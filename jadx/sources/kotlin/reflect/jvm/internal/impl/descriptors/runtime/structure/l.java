package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.m1;
import kotlin.reflect.jvm.internal.impl.descriptors.n1;
import u9.d0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class l extends p implements kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.h, v, u9.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<?> f13039a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    /* synthetic */ class a extends kotlin.jvm.internal.j implements c9.l<Member, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f13040a = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.internal.c, i9.c
        public final String getName() {
            return "isSynthetic";
        }

        @Override // kotlin.jvm.internal.c
        public final i9.f getOwner() {
            return kotlin.jvm.internal.c0.b(Member.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "isSynthetic()Z";
        }

        @Override // c9.l
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Member p10) {
            kotlin.jvm.internal.m.f(p10, "p0");
            return Boolean.valueOf(p10.isSynthetic());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    /* synthetic */ class b extends kotlin.jvm.internal.j implements c9.l<Constructor<?>, o> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f13041a = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.internal.c, i9.c
        public final String getName() {
            return "<init>";
        }

        @Override // kotlin.jvm.internal.c
        public final i9.f getOwner() {
            return kotlin.jvm.internal.c0.b(o.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Constructor;)V";
        }

        @Override // c9.l
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public final o invoke(Constructor<?> p10) {
            kotlin.jvm.internal.m.f(p10, "p0");
            return new o(p10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    /* synthetic */ class c extends kotlin.jvm.internal.j implements c9.l<Member, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f13042a = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.internal.c, i9.c
        public final String getName() {
            return "isSynthetic";
        }

        @Override // kotlin.jvm.internal.c
        public final i9.f getOwner() {
            return kotlin.jvm.internal.c0.b(Member.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "isSynthetic()Z";
        }

        @Override // c9.l
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Member p10) {
            kotlin.jvm.internal.m.f(p10, "p0");
            return Boolean.valueOf(p10.isSynthetic());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    /* synthetic */ class d extends kotlin.jvm.internal.j implements c9.l<Field, r> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f13043a = new d();

        d() {
            super(1);
        }

        @Override // kotlin.jvm.internal.c, i9.c
        public final String getName() {
            return "<init>";
        }

        @Override // kotlin.jvm.internal.c
        public final i9.f getOwner() {
            return kotlin.jvm.internal.c0.b(r.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Field;)V";
        }

        @Override // c9.l
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public final r invoke(Field p10) {
            kotlin.jvm.internal.m.f(p10, "p0");
            return new r(p10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class g extends kotlin.jvm.internal.o implements c9.l<Method, Boolean> {
        g() {
            super(1);
        }

        /* JADX WARN: Code duplicated, block: B:9:0x001e  */
        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Method method) {
            boolean z10 = false;
            if (!method.isSynthetic()) {
                if (l.this.y()) {
                    l lVar = l.this;
                    kotlin.jvm.internal.m.e(method, "method");
                    if (!lVar.W(method)) {
                        z10 = true;
                    }
                } else {
                    z10 = true;
                }
            }
            return Boolean.valueOf(z10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    /* synthetic */ class h extends kotlin.jvm.internal.j implements c9.l<Method, u> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f13046a = new h();

        h() {
            super(1);
        }

        @Override // kotlin.jvm.internal.c, i9.c
        public final String getName() {
            return "<init>";
        }

        @Override // kotlin.jvm.internal.c
        public final i9.f getOwner() {
            return kotlin.jvm.internal.c0.b(u.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Method;)V";
        }

        @Override // c9.l
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public final u invoke(Method p10) {
            kotlin.jvm.internal.m.f(p10, "p0");
            return new u(p10);
        }
    }

    @Override // u9.g
    public d0 G() {
        return null;
    }

    @Override // u9.d
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return getAnnotations();
    }

    @Override // u9.d
    public /* bridge */ /* synthetic */ u9.a j(ba.c cVar) {
        return j(cVar);
    }

    @Override // u9.d
    public boolean l() {
        return false;
    }

    @Override // u9.g
    public boolean r() {
        return false;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class e extends kotlin.jvm.internal.o implements c9.l<Class<?>, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f13044a = new e();

        e() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Class<?> cls) {
            boolean z10;
            String simpleName = cls.getSimpleName();
            kotlin.jvm.internal.m.e(simpleName, "it.simpleName");
            if (simpleName.length() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            return Boolean.valueOf(z10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class f extends kotlin.jvm.internal.o implements c9.l<Class<?>, ba.f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f13045a = new f();

        f() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ba.f invoke(Class<?> cls) {
            String simpleName = cls.getSimpleName();
            if (!ba.f.n(simpleName)) {
                simpleName = null;
            }
            if (simpleName == null) {
                return null;
            }
            return ba.f.l(simpleName);
        }
    }

    public l(Class<?> klass) {
        kotlin.jvm.internal.m.f(klass, "klass");
        this.f13039a = klass;
    }

    @Override // u9.g
    public boolean B() throws IllegalAccessException, InvocationTargetException {
        Boolean boolF = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.b.f13007a.f(this.f13039a);
        if (boolF != null) {
            return boolF.booleanValue();
        }
        return false;
    }

    @Override // u9.g
    public boolean F() {
        return this.f13039a.isInterface();
    }

    @Override // u9.g
    public Collection<u9.j> L() throws IllegalAccessException, InvocationTargetException {
        Class<?>[] clsArrC = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.b.f13007a.c(this.f13039a);
        if (clsArrC == null) {
            return kotlin.collections.r.l();
        }
        ArrayList arrayList = new ArrayList(clsArrC.length);
        for (Class<?> cls : clsArrC) {
            arrayList.add(new n(cls));
        }
        return arrayList;
    }

    @Override // u9.g
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public List<o> k() {
        Constructor<?>[] declaredConstructors = this.f13039a.getDeclaredConstructors();
        kotlin.jvm.internal.m.e(declaredConstructors, "klass.declaredConstructors");
        return ta.k.P(ta.k.J(ta.k.z(kotlin.collections.j.G(declaredConstructors), a.f13040a), b.f13041a));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.h
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public Class<?> t() {
        return this.f13039a;
    }

    @Override // u9.g
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public List<r> A() {
        Field[] declaredFields = this.f13039a.getDeclaredFields();
        kotlin.jvm.internal.m.e(declaredFields, "klass.declaredFields");
        return ta.k.P(ta.k.J(ta.k.z(kotlin.collections.j.G(declaredFields), c.f13042a), d.f13043a));
    }

    @Override // u9.g
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public List<ba.f> I() {
        Class<?>[] declaredClasses = this.f13039a.getDeclaredClasses();
        kotlin.jvm.internal.m.e(declaredClasses, "klass.declaredClasses");
        return ta.k.P(ta.k.K(ta.k.z(kotlin.collections.j.G(declaredClasses), e.f13044a), f.f13045a));
    }

    @Override // u9.g
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public List<u> K() {
        Method[] declaredMethods = this.f13039a.getDeclaredMethods();
        kotlin.jvm.internal.m.e(declaredMethods, "klass.declaredMethods");
        return ta.k.P(ta.k.J(ta.k.y(kotlin.collections.j.G(declaredMethods), new g()), h.f13046a));
    }

    @Override // u9.g
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public l h() {
        Class<?> declaringClass = this.f13039a.getDeclaringClass();
        if (declaringClass != null) {
            return new l(declaringClass);
        }
        return null;
    }

    @Override // u9.g
    public Collection<u9.j> b() {
        if (kotlin.jvm.internal.m.a(this.f13039a, Object.class)) {
            return kotlin.collections.r.l();
        }
        f0 f0Var = new f0(2);
        Type genericSuperclass = this.f13039a.getGenericSuperclass();
        f0Var.a(genericSuperclass != null ? genericSuperclass : Object.class);
        Type[] genericInterfaces = this.f13039a.getGenericInterfaces();
        kotlin.jvm.internal.m.e(genericInterfaces, "klass.genericInterfaces");
        f0Var.b(genericInterfaces);
        List listO = kotlin.collections.r.o(f0Var.d(new Type[f0Var.c()]));
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(listO, 10));
        Iterator it = listO.iterator();
        while (it.hasNext()) {
            arrayList.add(new n((Type) it.next()));
        }
        return arrayList;
    }

    @Override // u9.g
    public ba.c d() {
        ba.c cVarB = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.a(this.f13039a).b();
        kotlin.jvm.internal.m.e(cVarB, "klass.classId.asSingleFqName()");
        return cVarB;
    }

    public boolean equals(Object obj) {
        return (obj instanceof l) && kotlin.jvm.internal.m.a(this.f13039a, ((l) obj).f13039a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.h, u9.d
    public List<kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.e> getAnnotations() {
        Annotation[] declaredAnnotations;
        List<kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.e> listB;
        AnnotatedElement annotatedElementT = t();
        return (annotatedElementT == null || (declaredAnnotations = annotatedElementT.getDeclaredAnnotations()) == null || (listB = i.b(declaredAnnotations)) == null) ? kotlin.collections.r.l() : listB;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.v
    public int getModifiers() {
        return this.f13039a.getModifiers();
    }

    @Override // u9.t
    public ba.f getName() {
        ba.f fVarL = ba.f.l(this.f13039a.getSimpleName());
        kotlin.jvm.internal.m.e(fVarL, "identifier(klass.simpleName)");
        return fVarL;
    }

    @Override // u9.z
    public List<a0> getTypeParameters() {
        TypeVariable<Class<?>>[] typeParameters = this.f13039a.getTypeParameters();
        kotlin.jvm.internal.m.e(typeParameters, "klass.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Class<?>> typeVariable : typeParameters) {
            arrayList.add(new a0(typeVariable));
        }
        return arrayList;
    }

    public int hashCode() {
        return this.f13039a.hashCode();
    }

    @Override // u9.g
    public Collection<u9.w> i() {
        Object[] objArrD = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.b.f13007a.d(this.f13039a);
        if (objArrD == null) {
            objArrD = new Object[0];
        }
        ArrayList arrayList = new ArrayList(objArrD.length);
        for (Object obj : objArrD) {
            arrayList.add(new y(obj));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.h, u9.d
    public kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.e j(ba.c fqName) {
        Annotation[] declaredAnnotations;
        kotlin.jvm.internal.m.f(fqName, "fqName");
        AnnotatedElement annotatedElementT = t();
        if (annotatedElementT == null || (declaredAnnotations = annotatedElementT.getDeclaredAnnotations()) == null) {
            return null;
        }
        return i.a(declaredAnnotations, fqName);
    }

    @Override // u9.g
    public boolean o() {
        return this.f13039a.isAnnotation();
    }

    @Override // u9.g
    public boolean q() throws IllegalAccessException, InvocationTargetException {
        Boolean boolE = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.b.f13007a.e(this.f13039a);
        if (boolE != null) {
            return boolE.booleanValue();
        }
        return false;
    }

    public String toString() {
        return l.class.getName() + ": " + this.f13039a;
    }

    @Override // u9.g
    public boolean y() {
        return this.f13039a.isEnum();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean W(Method method) {
        String name = method.getName();
        if (kotlin.jvm.internal.m.a(name, "values")) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            kotlin.jvm.internal.m.e(parameterTypes, "method.parameterTypes");
            if (parameterTypes.length == 0) {
                return true;
            }
            return false;
        }
        if (!kotlin.jvm.internal.m.a(name, "valueOf")) {
            return false;
        }
        return Arrays.equals(method.getParameterTypes(), new Class[]{String.class});
    }

    @Override // u9.s
    public boolean O() {
        return Modifier.isStatic(getModifiers());
    }

    @Override // u9.s
    public n1 getVisibility() {
        int modifiers = getModifiers();
        if (Modifier.isPublic(modifiers)) {
            return m1.h.f12995c;
        }
        if (Modifier.isPrivate(modifiers)) {
            return m1.e.f12992c;
        }
        if (Modifier.isProtected(modifiers)) {
            if (Modifier.isStatic(modifiers)) {
                return o9.c.f16513c;
            }
            return o9.b.f16512c;
        }
        return o9.a.f16511c;
    }

    @Override // u9.s
    public boolean isAbstract() {
        return Modifier.isAbstract(getModifiers());
    }

    @Override // u9.s
    public boolean isFinal() {
        return Modifier.isFinal(getModifiers());
    }
}
