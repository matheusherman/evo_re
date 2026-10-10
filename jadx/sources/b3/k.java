package b3;

import com.google.gson.s;
import com.google.gson.u;
import com.google.gson.x;
import com.google.gson.y;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class k implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.gson.internal.c f785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.gson.d f786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.gson.internal.d f787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b3.e f788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<u> f789e;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f790f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Method f791g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f792h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ x f793i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ com.google.gson.e f794j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ f3.a f795k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ boolean f796l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ boolean f797m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Field field, boolean z10, boolean z11, boolean z12, Method method, boolean z13, x xVar, com.google.gson.e eVar, f3.a aVar, boolean z14, boolean z15) {
            super(str, field, z10, z11);
            this.f790f = z12;
            this.f791g = method;
            this.f792h = z13;
            this.f793i = xVar;
            this.f794j = eVar;
            this.f795k = aVar;
            this.f796l = z14;
            this.f797m = z15;
        }

        @Override // b3.k.c
        void a(g3.a aVar, int i10, Object[] objArr) {
            Object objB = this.f793i.b(aVar);
            if (objB != null || !this.f796l) {
                objArr[i10] = objB;
                return;
            }
            throw new com.google.gson.o("null is not allowed as value for record component '" + this.f802c + "' of primitive type; at path " + aVar.getPath());
        }

        @Override // b3.k.c
        void b(g3.a aVar, Object obj) throws IllegalAccessException {
            Object objB = this.f793i.b(aVar);
            if (objB == null && this.f796l) {
                return;
            }
            if (this.f790f) {
                k.c(obj, this.f801b);
            } else if (this.f797m) {
                throw new com.google.gson.l("Cannot set value of 'static final' " + d3.a.g(this.f801b, false));
            }
            this.f801b.set(obj, objB);
        }

        @Override // b3.k.c
        void c(g3.c cVar, Object obj) throws IllegalAccessException {
            Object objInvoke;
            if (this.f803d) {
                if (this.f790f) {
                    Method method = this.f791g;
                    if (method == null) {
                        k.c(obj, this.f801b);
                    } else {
                        k.c(obj, method);
                    }
                }
                Method method2 = this.f791g;
                if (method2 != null) {
                    try {
                        objInvoke = method2.invoke(obj, null);
                    } catch (InvocationTargetException e10) {
                        throw new com.google.gson.l("Accessor " + d3.a.g(this.f791g, false) + " threw exception", e10.getCause());
                    }
                } else {
                    objInvoke = this.f801b.get(obj);
                }
                if (objInvoke == obj) {
                    return;
                }
                cVar.o(this.f800a);
                (this.f792h ? this.f793i : new n(this.f794j, this.f793i, this.f795k.d())).d(cVar, objInvoke);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static abstract class b<T, A> extends x<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map<String, c> f799a;

        abstract A e();

        abstract T f(A a10);

        abstract void g(A a10, g3.a aVar, c cVar);

        @Override // com.google.gson.x
        public void d(g3.c cVar, T t10) throws IOException {
            if (t10 == null) {
                cVar.q();
                return;
            }
            cVar.d();
            try {
                Iterator<c> it = this.f799a.values().iterator();
                while (it.hasNext()) {
                    it.next().c(cVar, t10);
                }
                cVar.j();
            } catch (IllegalAccessException e10) {
                throw d3.a.e(e10);
            }
        }

        b(Map<String, c> map) {
            this.f799a = map;
        }

        @Override // com.google.gson.x
        public T b(g3.a aVar) throws IOException {
            if (aVar.B() == g3.b.NULL) {
                aVar.x();
                return null;
            }
            A aE = e();
            try {
                aVar.b();
                while (aVar.n()) {
                    c cVar = this.f799a.get(aVar.v());
                    if (cVar != null && cVar.f804e) {
                        g(aE, aVar, cVar);
                    } else {
                        aVar.Z();
                    }
                }
                aVar.j();
                return f(aE);
            } catch (IllegalAccessException e10) {
                throw d3.a.e(e10);
            } catch (IllegalStateException e11) {
                throw new s(e11);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class d<T> extends b<T, T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.google.gson.internal.i<T> f805b;

        @Override // b3.k.b
        T e() {
            return this.f805b.a();
        }

        d(com.google.gson.internal.i<T> iVar, Map<String, c> map) {
            super(map);
            this.f805b = iVar;
        }

        @Override // b3.k.b
        void g(T t10, g3.a aVar, c cVar) {
            cVar.b(aVar, t10);
        }

        @Override // b3.k.b
        T f(T t10) {
            return t10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class e<T> extends b<T, Object[]> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final Map<Class<?>, Object> f806e = j();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Constructor<T> f807b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Object[] f808c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Map<String, Integer> f809d;

        private static Map<Class<?>, Object> j() {
            HashMap map = new HashMap();
            map.put(Byte.TYPE, (byte) 0);
            map.put(Short.TYPE, (short) 0);
            map.put(Integer.TYPE, 0);
            map.put(Long.TYPE, 0L);
            map.put(Float.TYPE, Float.valueOf(0.0f));
            map.put(Double.TYPE, Double.valueOf(0.0d));
            map.put(Character.TYPE, (char) 0);
            map.put(Boolean.TYPE, Boolean.FALSE);
            return map;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // b3.k.b
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Object[] e() {
            return (Object[]) this.f808c.clone();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // b3.k.b
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public T f(Object[] objArr) {
            try {
                return this.f807b.newInstance(objArr);
            } catch (IllegalAccessException e10) {
                throw d3.a.e(e10);
            } catch (IllegalArgumentException e11) {
                e = e11;
                throw new RuntimeException("Failed to invoke constructor '" + d3.a.c(this.f807b) + "' with args " + Arrays.toString(objArr), e);
            } catch (InstantiationException e12) {
                e = e12;
                throw new RuntimeException("Failed to invoke constructor '" + d3.a.c(this.f807b) + "' with args " + Arrays.toString(objArr), e);
            } catch (InvocationTargetException e13) {
                throw new RuntimeException("Failed to invoke constructor '" + d3.a.c(this.f807b) + "' with args " + Arrays.toString(objArr), e13.getCause());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // b3.k.b
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(Object[] objArr, g3.a aVar, c cVar) {
            Integer num = this.f809d.get(cVar.f802c);
            if (num != null) {
                cVar.a(aVar, num.intValue(), objArr);
                return;
            }
            throw new IllegalStateException("Could not find the index in the constructor '" + d3.a.c(this.f807b) + "' for field with name '" + cVar.f802c + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }

        e(Class<T> cls, Map<String, c> map, boolean z10) {
            super(map);
            this.f809d = new HashMap();
            Constructor<T> constructorI = d3.a.i(cls);
            this.f807b = constructorI;
            if (z10) {
                k.c(null, constructorI);
            } else {
                d3.a.l(constructorI);
            }
            String[] strArrJ = d3.a.j(cls);
            for (int i10 = 0; i10 < strArrJ.length; i10++) {
                this.f809d.put(strArrJ[i10], Integer.valueOf(i10));
            }
            Class<?>[] parameterTypes = this.f807b.getParameterTypes();
            this.f808c = new Object[parameterTypes.length];
            for (int i11 = 0; i11 < parameterTypes.length; i11++) {
                this.f808c[i11] = f806e.get(parameterTypes[i11]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <M extends AccessibleObject & Member> void c(Object obj, M m10) {
        if (Modifier.isStatic(m10.getModifiers())) {
            obj = null;
        }
        if (com.google.gson.internal.l.a(m10, obj)) {
            return;
        }
        throw new com.google.gson.l(d3.a.g(m10, true) + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Field f801b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f802c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f803d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final boolean f804e;

        abstract void a(g3.a aVar, int i10, Object[] objArr);

        abstract void b(g3.a aVar, Object obj);

        abstract void c(g3.c cVar, Object obj);

        protected c(String str, Field field, boolean z10, boolean z11) {
            this.f800a = str;
            this.f801b = field;
            this.f802c = field.getName();
            this.f803d = z10;
            this.f804e = z11;
        }
    }

    private c d(com.google.gson.e eVar, Field field, Method method, String str, f3.a<?> aVar, boolean z10, boolean z11, boolean z12) {
        boolean zA = com.google.gson.internal.k.a(aVar.c());
        int modifiers = field.getModifiers();
        boolean z13 = Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers);
        a3.b bVar = (a3.b) field.getAnnotation(a3.b.class);
        x<?> xVarB = bVar != null ? this.f788d.b(this.f785a, eVar, aVar, bVar) : null;
        boolean z14 = xVarB != null;
        if (xVarB == null) {
            xVarB = eVar.p(aVar);
        }
        return new a(str, field, z10, z11, z12, method, z14, xVarB, eVar, aVar, zA, z13);
    }

    private Map<String, c> e(com.google.gson.e eVar, f3.a<?> aVar, Class<?> cls, boolean z10, boolean z11) {
        boolean z12;
        Method method;
        int i10;
        int i11;
        Class<?> cls2 = cls;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!cls2.isInterface()) {
            f3.a<?> aVarB = aVar;
            boolean z13 = z10;
            Class<?> clsC = cls2;
            while (clsC != Object.class) {
                Field[] declaredFields = clsC.getDeclaredFields();
                boolean z14 = true;
                boolean z15 = false;
                if (clsC != cls2 && declaredFields.length > 0) {
                    u.a aVarB2 = com.google.gson.internal.l.b(this.f789e, clsC);
                    if (aVarB2 == u.a.BLOCK_ALL) {
                        throw new com.google.gson.l("ReflectionAccessFilter does not permit using reflection for " + clsC + " (supertype of " + cls2 + "). Register a TypeAdapter for this type or adjust the access filter.");
                    }
                    z13 = aVarB2 == u.a.BLOCK_INACCESSIBLE;
                }
                boolean z16 = z13;
                int length = declaredFields.length;
                int i12 = 0;
                while (i12 < length) {
                    int i13 = i12;
                    Field field = declaredFields[i13];
                    boolean zG = this.g(field, z14);
                    boolean zG2 = this.g(field, z15);
                    if (zG || zG2) {
                        if (!z11) {
                            z12 = zG2;
                            method = null;
                        } else if (Modifier.isStatic(field.getModifiers())) {
                            method = null;
                            z12 = false;
                        } else {
                            Method methodH = d3.a.h(clsC, field);
                            if (!z16) {
                                d3.a.l(methodH);
                            }
                            if (methodH.getAnnotation(a3.c.class) != null && field.getAnnotation(a3.c.class) == null) {
                                throw new com.google.gson.l("@SerializedName on " + d3.a.g(methodH, z15) + " is not supported");
                            }
                            method = methodH;
                            z12 = zG2;
                        }
                        if (!z16 && method == null) {
                            d3.a.l(field);
                        }
                        Type typeO = com.google.gson.internal.b.o(aVarB.d(), clsC, field.getGenericType());
                        List<String> listF = this.f(field);
                        int size = listF.size();
                        c cVar = null;
                        int i14 = 0;
                        while (i14 < size) {
                            String str = listF.get(i14);
                            if (i14 != 0) {
                                zG = false;
                            }
                            int i15 = i13;
                            List<String> list = listF;
                            boolean z17 = zG;
                            int i16 = length;
                            c cVar2 = (c) linkedHashMap.put(str, this.d(eVar, field, method, str, f3.a.b(typeO), z17, z12, z16));
                            if (cVar == null) {
                                cVar = cVar2;
                            }
                            i14++;
                            this = this;
                            zG = z17;
                            length = i16;
                            i13 = i15;
                            listF = list;
                        }
                        i10 = length;
                        i11 = i13;
                        if (cVar != null) {
                            throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + cVar.f800a + "'; conflict is caused by fields " + d3.a.f(cVar.f801b) + " and " + d3.a.f(field));
                        }
                    } else {
                        i10 = length;
                        i11 = i13;
                    }
                    i12 = i11 + 1;
                    this = this;
                    aVarB = aVarB;
                    length = i10;
                    z14 = true;
                    z15 = false;
                }
                aVarB = f3.a.b(com.google.gson.internal.b.o(aVarB.d(), clsC, clsC.getGenericSuperclass()));
                clsC = aVarB.c();
                cls2 = cls;
                z13 = z16;
            }
        }
        return linkedHashMap;
    }

    private List<String> f(Field field) {
        a3.c cVar = (a3.c) field.getAnnotation(a3.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f786b.a(field));
        }
        String strValue = cVar.value();
        String[] strArrAlternate = cVar.alternate();
        if (strArrAlternate.length == 0) {
            return Collections.singletonList(strValue);
        }
        ArrayList arrayList = new ArrayList(strArrAlternate.length + 1);
        arrayList.add(strValue);
        Collections.addAll(arrayList, strArrAlternate);
        return arrayList;
    }

    private boolean g(Field field, boolean z10) {
        return (this.f787c.d(field.getType(), z10) || this.f787c.h(field, z10)) ? false : true;
    }

    public k(com.google.gson.internal.c cVar, com.google.gson.d dVar, com.google.gson.internal.d dVar2, b3.e eVar, List<u> list) {
        this.f785a = cVar;
        this.f786b = dVar;
        this.f787c = dVar2;
        this.f788d = eVar;
        this.f789e = list;
    }

    @Override // com.google.gson.y
    public <T> x<T> a(com.google.gson.e eVar, f3.a<T> aVar) {
        boolean z10;
        Class<? super T> clsC = aVar.c();
        if (!Object.class.isAssignableFrom(clsC)) {
            return null;
        }
        u.a aVarB = com.google.gson.internal.l.b(this.f789e, clsC);
        if (aVarB != u.a.BLOCK_ALL) {
            if (aVarB == u.a.BLOCK_INACCESSIBLE) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (d3.a.k(clsC)) {
                return new e(clsC, e(eVar, aVar, clsC, z10, true), z10);
            }
            return new d(this.f785a.b(aVar), e(eVar, aVar, clsC, z10, false));
        }
        throw new com.google.gson.l("ReflectionAccessFilter does not permit using reflection for " + clsC + ". Register a TypeAdapter for this type or adjust the access filter.");
    }
}
