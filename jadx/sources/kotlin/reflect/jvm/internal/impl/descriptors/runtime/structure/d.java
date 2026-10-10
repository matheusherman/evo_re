package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.n0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<i9.d<? extends Object>> f13024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<Class<? extends Object>, Class<? extends Object>> f13025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<Class<? extends Object>, Class<? extends Object>> f13026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<Class<? extends r8.c<?>>, Integer> f13027d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends kotlin.jvm.internal.o implements c9.l<ParameterizedType, ParameterizedType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f13028a = new a();

        a() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ParameterizedType invoke(ParameterizedType it) {
            kotlin.jvm.internal.m.f(it, "it");
            Type ownerType = it.getOwnerType();
            if (ownerType instanceof ParameterizedType) {
                return (ParameterizedType) ownerType;
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends kotlin.jvm.internal.o implements c9.l<ParameterizedType, ta.h<? extends Type>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f13029a = new b();

        b() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ta.h<Type> invoke(ParameterizedType it) {
            kotlin.jvm.internal.m.f(it, "it");
            Type[] actualTypeArguments = it.getActualTypeArguments();
            kotlin.jvm.internal.m.e(actualTypeArguments, "it.actualTypeArguments");
            return kotlin.collections.j.G(actualTypeArguments);
        }
    }

    static {
        int i10 = 0;
        List<i9.d<? extends Object>> listO = kotlin.collections.r.o(kotlin.jvm.internal.c0.b(Boolean.TYPE), kotlin.jvm.internal.c0.b(Byte.TYPE), kotlin.jvm.internal.c0.b(Character.TYPE), kotlin.jvm.internal.c0.b(Double.TYPE), kotlin.jvm.internal.c0.b(Float.TYPE), kotlin.jvm.internal.c0.b(Integer.TYPE), kotlin.jvm.internal.c0.b(Long.TYPE), kotlin.jvm.internal.c0.b(Short.TYPE));
        f13024a = listO;
        List<i9.d<? extends Object>> list = listO;
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            i9.d dVar = (i9.d) it.next();
            arrayList.add(r8.v.a(b9.a.c(dVar), b9.a.d(dVar)));
        }
        f13025b = n0.q(arrayList);
        List<i9.d<? extends Object>> list2 = f13024a;
        ArrayList arrayList2 = new ArrayList(kotlin.collections.r.w(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            i9.d dVar2 = (i9.d) it2.next();
            arrayList2.add(r8.v.a(b9.a.d(dVar2), b9.a.c(dVar2)));
        }
        f13026c = n0.q(arrayList2);
        List listO2 = kotlin.collections.r.o(c9.a.class, c9.l.class, c9.p.class, c9.q.class, c9.r.class, c9.s.class, c9.t.class, c9.u.class, c9.v.class, c9.w.class, c9.b.class, c9.c.class, c9.d.class, c9.e.class, c9.f.class, c9.g.class, c9.h.class, c9.i.class, c9.j.class, c9.k.class, c9.m.class, c9.n.class, c9.o.class);
        ArrayList arrayList3 = new ArrayList(kotlin.collections.r.w(listO2, 10));
        for (Object obj : listO2) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.r.v();
            }
            arrayList3.add(r8.v.a((Class) obj, Integer.valueOf(i10)));
            i10 = i11;
        }
        f13027d = n0.q(arrayList3);
    }

    public static final ba.b a(Class<?> cls) {
        ba.b bVarM;
        ba.b bVarA;
        kotlin.jvm.internal.m.f(cls, "<this>");
        if (cls.isPrimitive()) {
            throw new IllegalArgumentException("Can't compute ClassId for primitive type: " + cls);
        }
        if (cls.isArray()) {
            throw new IllegalArgumentException("Can't compute ClassId for array type: " + cls);
        }
        if (cls.getEnclosingMethod() == null && cls.getEnclosingConstructor() == null) {
            String simpleName = cls.getSimpleName();
            kotlin.jvm.internal.m.e(simpleName, "simpleName");
            if (simpleName.length() != 0) {
                Class<?> declaringClass = cls.getDeclaringClass();
                if (declaringClass == null || (bVarA = a(declaringClass)) == null || (bVarM = bVarA.d(ba.f.l(cls.getSimpleName()))) == null) {
                    bVarM = ba.b.m(new ba.c(cls.getName()));
                }
                kotlin.jvm.internal.m.e(bVarM, "declaringClass?.classId?…Id.topLevel(FqName(name))");
                return bVarM;
            }
        }
        ba.c cVar = new ba.c(cls.getName());
        return new ba.b(cVar.e(), ba.c.k(cVar.g()), true);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final String b(Class<?> cls) {
        kotlin.jvm.internal.m.f(cls, "<this>");
        if (!cls.isPrimitive()) {
            if (cls.isArray()) {
                String name = cls.getName();
                kotlin.jvm.internal.m.e(name, "name");
                return ua.n.D(name, '.', '/', false, 4, null);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append('L');
            String name2 = cls.getName();
            kotlin.jvm.internal.m.e(name2, "name");
            sb2.append(ua.n.D(name2, '.', '/', false, 4, null));
            sb2.append(';');
            return sb2.toString();
        }
        String name3 = cls.getName();
        switch (name3.hashCode()) {
            case -1325958191:
                if (name3.equals("double")) {
                    return "D";
                }
                break;
            case 104431:
                if (name3.equals("int")) {
                    return "I";
                }
                break;
            case 3039496:
                if (name3.equals("byte")) {
                    return "B";
                }
                break;
            case 3052374:
                if (name3.equals("char")) {
                    return "C";
                }
                break;
            case 3327612:
                if (name3.equals("long")) {
                    return "J";
                }
                break;
            case 3625364:
                if (name3.equals("void")) {
                    return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
                }
                break;
            case 64711720:
                if (name3.equals(TypedValues.Custom.S_BOOLEAN)) {
                    return "Z";
                }
                break;
            case 97526364:
                if (name3.equals(TypedValues.Custom.S_FLOAT)) {
                    return "F";
                }
                break;
            case 109413500:
                if (name3.equals("short")) {
                    return ExifInterface.LATITUDE_SOUTH;
                }
                break;
        }
        throw new IllegalArgumentException("Unsupported primitive type: " + cls);
    }

    public static final List<Type> c(Type type) {
        kotlin.jvm.internal.m.f(type, "<this>");
        if (!(type instanceof ParameterizedType)) {
            return kotlin.collections.r.l();
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType.getOwnerType() != null) {
            return ta.k.P(ta.k.D(ta.k.o(type, a.f13028a), b.f13029a));
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        kotlin.jvm.internal.m.e(actualTypeArguments, "actualTypeArguments");
        return kotlin.collections.j.E0(actualTypeArguments);
    }

    public static final Class<?> d(Class<?> cls) {
        kotlin.jvm.internal.m.f(cls, "<this>");
        return f13025b.get(cls);
    }

    public static final ClassLoader e(Class<?> cls) {
        kotlin.jvm.internal.m.f(cls, "<this>");
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader != null) {
            return classLoader;
        }
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        kotlin.jvm.internal.m.e(systemClassLoader, "getSystemClassLoader()");
        return systemClassLoader;
    }

    public static final Class<?> f(Class<?> cls) {
        kotlin.jvm.internal.m.f(cls, "<this>");
        return f13026c.get(cls);
    }

    public static final boolean g(Class<?> cls) {
        kotlin.jvm.internal.m.f(cls, "<this>");
        return Enum.class.isAssignableFrom(cls);
    }
}
