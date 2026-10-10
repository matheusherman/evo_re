package com.google.gson.internal;

import com.google.gson.u;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Type, com.google.gson.g<?>> f4855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f4856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<u> f4857c;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a<T> implements com.google.gson.internal.i<T> {
        @Override // com.google.gson.internal.i
        public T a() {
            return (T) new TreeSet();
        }

        a() {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b<T> implements com.google.gson.internal.i<T> {
        @Override // com.google.gson.internal.i
        public T a() {
            return (T) new LinkedHashSet();
        }

        b() {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.gson.internal.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class C0057c<T> implements com.google.gson.internal.i<T> {
        @Override // com.google.gson.internal.i
        public T a() {
            return (T) new ArrayDeque();
        }

        C0057c() {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class d<T> implements com.google.gson.internal.i<T> {
        @Override // com.google.gson.internal.i
        public T a() {
            return (T) new ArrayList();
        }

        d() {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class e<T> implements com.google.gson.internal.i<T> {
        @Override // com.google.gson.internal.i
        public T a() {
            return (T) new ConcurrentSkipListMap();
        }

        e() {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class f<T> implements com.google.gson.internal.i<T> {
        @Override // com.google.gson.internal.i
        public T a() {
            return (T) new ConcurrentHashMap();
        }

        f() {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class g<T> implements com.google.gson.internal.i<T> {
        @Override // com.google.gson.internal.i
        public T a() {
            return (T) new TreeMap();
        }

        g() {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class h<T> implements com.google.gson.internal.i<T> {
        @Override // com.google.gson.internal.i
        public T a() {
            return (T) new LinkedHashMap();
        }

        h() {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class i<T> implements com.google.gson.internal.i<T> {
        @Override // com.google.gson.internal.i
        public T a() {
            return (T) new com.google.gson.internal.h();
        }

        i() {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class j<T> implements com.google.gson.internal.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f4858a;

        j(Class cls) {
            this.f4858a = cls;
        }

        @Override // com.google.gson.internal.i
        public T a() {
            try {
                return (T) com.google.gson.internal.n.f4916a.d(this.f4858a);
            } catch (Exception e10) {
                throw new RuntimeException("Unable to create instance of " + this.f4858a + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e10);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class k<T> implements com.google.gson.internal.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.google.gson.g f4860a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Type f4861b;

        k(com.google.gson.g gVar, Type type) {
            this.f4860a = gVar;
            this.f4861b = type;
        }

        @Override // com.google.gson.internal.i
        public T a() {
            return (T) this.f4860a.a(this.f4861b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class l<T> implements com.google.gson.internal.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4863a;

        l(String str) {
            this.f4863a = str;
        }

        @Override // com.google.gson.internal.i
        public T a() {
            throw new com.google.gson.l(this.f4863a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class m<T> implements com.google.gson.internal.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.google.gson.g f4865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Type f4866b;

        m(com.google.gson.g gVar, Type type) {
            this.f4865a = gVar;
            this.f4866b = type;
        }

        @Override // com.google.gson.internal.i
        public T a() {
            return (T) this.f4865a.a(this.f4866b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class n<T> implements com.google.gson.internal.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4868a;

        n(String str) {
            this.f4868a = str;
        }

        @Override // com.google.gson.internal.i
        public T a() {
            throw new com.google.gson.l(this.f4868a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class o<T> implements com.google.gson.internal.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4870a;

        o(String str) {
            this.f4870a = str;
        }

        @Override // com.google.gson.internal.i
        public T a() {
            throw new com.google.gson.l(this.f4870a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class p<T> implements com.google.gson.internal.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f4872a;

        p(Type type) {
            this.f4872a = type;
        }

        @Override // com.google.gson.internal.i
        public T a() {
            Type type = this.f4872a;
            if (!(type instanceof ParameterizedType)) {
                throw new com.google.gson.l("Invalid EnumSet type: " + this.f4872a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return (T) EnumSet.noneOf((Class) type2);
            }
            throw new com.google.gson.l("Invalid EnumSet type: " + this.f4872a.toString());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class q<T> implements com.google.gson.internal.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f4873a;

        q(Type type) {
            this.f4873a = type;
        }

        @Override // com.google.gson.internal.i
        public T a() {
            Type type = this.f4873a;
            if (!(type instanceof ParameterizedType)) {
                throw new com.google.gson.l("Invalid EnumMap type: " + this.f4873a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return (T) new EnumMap((Class) type2);
            }
            throw new com.google.gson.l("Invalid EnumMap type: " + this.f4873a.toString());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class r<T> implements com.google.gson.internal.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4874a;

        r(String str) {
            this.f4874a = str;
        }

        @Override // com.google.gson.internal.i
        public T a() {
            throw new com.google.gson.l(this.f4874a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class s<T> implements com.google.gson.internal.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4875a;

        s(String str) {
            this.f4875a = str;
        }

        @Override // com.google.gson.internal.i
        public T a() {
            throw new com.google.gson.l(this.f4875a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class t<T> implements com.google.gson.internal.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Constructor f4876a;

        t(Constructor constructor) {
            this.f4876a = constructor;
        }

        @Override // com.google.gson.internal.i
        public T a() {
            try {
                return (T) this.f4876a.newInstance(null);
            } catch (IllegalAccessException e10) {
                throw d3.a.e(e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException("Failed to invoke constructor '" + d3.a.c(this.f4876a) + "' with no args", e11);
            } catch (InvocationTargetException e12) {
                throw new RuntimeException("Failed to invoke constructor '" + d3.a.c(this.f4876a) + "' with no args", e12.getCause());
            }
        }
    }

    private static <T> com.google.gson.internal.i<T> d(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new a();
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new b();
            }
            return Queue.class.isAssignableFrom(cls) ? new C0057c() : new d();
        }
        if (!Map.class.isAssignableFrom(cls)) {
            return null;
        }
        if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
            return new e();
        }
        if (ConcurrentMap.class.isAssignableFrom(cls)) {
            return new f();
        }
        if (SortedMap.class.isAssignableFrom(cls)) {
            return new g();
        }
        return (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(f3.a.b(((ParameterizedType) type).getActualTypeArguments()[0]).c())) ? new i() : new h();
    }

    private static <T> com.google.gson.internal.i<T> e(Type type, Class<? super T> cls) {
        if (EnumSet.class.isAssignableFrom(cls)) {
            return new p(type);
        }
        if (cls == EnumMap.class) {
            return new q(type);
        }
        return null;
    }

    private <T> com.google.gson.internal.i<T> f(Class<? super T> cls) {
        if (this.f4856b) {
            return new j(cls);
        }
        return new l("Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.");
    }

    public String toString() {
        return this.f4855a.toString();
    }

    public c(Map<Type, com.google.gson.g<?>> map, boolean z10, List<u> list) {
        this.f4855a = map;
        this.f4856b = z10;
        this.f4857c = list;
    }

    static String a(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: " + cls.getName();
        }
        if (Modifier.isAbstract(modifiers)) {
            return "Abstract classes can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName();
        }
        return null;
    }

    private static <T> com.google.gson.internal.i<T> c(Class<? super T> cls, u.a aVar) {
        String strM;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(null);
            u.a aVar2 = u.a.ALLOW;
            if (aVar != aVar2 && (!com.google.gson.internal.l.a(declaredConstructor, null) || (aVar == u.a.BLOCK_ALL && !Modifier.isPublic(declaredConstructor.getModifiers())))) {
                return new r("Unable to invoke no-args constructor of " + cls + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.");
            }
            if (aVar == aVar2 && (strM = d3.a.m(declaredConstructor)) != null) {
                return new s(strM);
            }
            return new t(declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public <T> com.google.gson.internal.i<T> b(f3.a<T> aVar) {
        Type typeD = aVar.d();
        Class<? super T> clsC = aVar.c();
        com.google.gson.g<?> gVar = this.f4855a.get(typeD);
        if (gVar != null) {
            return new k(gVar, typeD);
        }
        com.google.gson.g<?> gVar2 = this.f4855a.get(clsC);
        if (gVar2 != null) {
            return new m(gVar2, typeD);
        }
        com.google.gson.internal.i<T> iVarE = e(typeD, clsC);
        if (iVarE != null) {
            return iVarE;
        }
        u.a aVarB = com.google.gson.internal.l.b(this.f4857c, clsC);
        com.google.gson.internal.i<T> iVarC = c(clsC, aVarB);
        if (iVarC != null) {
            return iVarC;
        }
        com.google.gson.internal.i<T> iVarD = d(typeD, clsC);
        if (iVarD != null) {
            return iVarD;
        }
        String strA = a(clsC);
        if (strA != null) {
            return new n(strA);
        }
        if (aVarB == u.a.ALLOW) {
            return f(clsC);
        }
        return new o("Unable to create instance of " + clsC + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.");
    }
}
