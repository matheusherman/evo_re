package kotlin.reflect.jvm.internal.calls;

import androidx.exifinterface.media.ExifInterface;
import c9.l;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.c0;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.f0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u001a#\u0010\u0003\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u00002\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001aK\u0010\u0014\u001a\u00028\u0000\"\b\b\u0000\u0010\r*\u00020\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00000\u000f2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0000¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0018²\u0006\u0016\u0010\u0016\u001a\u00020\u0005\"\b\b\u0000\u0010\r*\u00020\u00008\nX\u008a\u0084\u0002²\u0006\u0016\u0010\u0017\u001a\u00020\u0007\"\b\b\u0000\u0010\r*\u00020\u00008\nX\u008a\u0084\u0002"}, d2 = {"", "Ljava/lang/Class;", "expectedType", "k", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;", "", "index", "", "name", "expectedJvmType", "", "j", "(ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Void;", ExifInterface.GPS_DIRECTION_TRUE, "annotationClass", "", "values", "", "Ljava/lang/reflect/Method;", "methods", "d", "(Ljava/lang/Class;Ljava/util/Map;Ljava/util/List;)Ljava/lang/Object;", "hashCode", "toString", "kotlin-reflection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class c {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "", "a", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0})
    static final class a extends o implements c9.a<Integer> {
        final /* synthetic */ Map<String, Object> $values;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Map<String, ? extends Object> map) {
            super(0);
            this.$values = map;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            int iHashCode;
            Iterator<T> it = this.$values.entrySet().iterator();
            int iHashCode2 = 0;
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if (value instanceof boolean[]) {
                    iHashCode = Arrays.hashCode((boolean[]) value);
                } else if (value instanceof char[]) {
                    iHashCode = Arrays.hashCode((char[]) value);
                } else if (value instanceof byte[]) {
                    iHashCode = Arrays.hashCode((byte[]) value);
                } else if (value instanceof short[]) {
                    iHashCode = Arrays.hashCode((short[]) value);
                } else if (value instanceof int[]) {
                    iHashCode = Arrays.hashCode((int[]) value);
                } else if (value instanceof float[]) {
                    iHashCode = Arrays.hashCode((float[]) value);
                } else if (value instanceof long[]) {
                    iHashCode = Arrays.hashCode((long[]) value);
                } else if (value instanceof double[]) {
                    iHashCode = Arrays.hashCode((double[]) value);
                } else {
                    iHashCode = value instanceof Object[] ? Arrays.hashCode((Object[]) value) : value.hashCode();
                }
                iHashCode2 += iHashCode ^ (str.hashCode() * 127);
            }
            return Integer.valueOf(iHashCode2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class b extends o implements c9.a<String> {
        final /* synthetic */ Class<T> $annotationClass;
        final /* synthetic */ Map<String, Object> $values;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00000\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "", "", "entry", "", "a", "(Ljava/util/Map$Entry;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 8, 0})
        static final class a extends o implements l<Map.Entry<? extends String, ? extends Object>, CharSequence> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f12393a = new a();

            a() {
                super(1);
            }

            @Override // c9.l
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final CharSequence invoke(Map.Entry<String, ? extends Object> entry) {
                String string;
                m.f(entry, "entry");
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof boolean[]) {
                    string = Arrays.toString((boolean[]) value);
                    m.e(string, "toString(this)");
                } else if (value instanceof char[]) {
                    string = Arrays.toString((char[]) value);
                    m.e(string, "toString(this)");
                } else if (value instanceof byte[]) {
                    string = Arrays.toString((byte[]) value);
                    m.e(string, "toString(this)");
                } else if (value instanceof short[]) {
                    string = Arrays.toString((short[]) value);
                    m.e(string, "toString(this)");
                } else if (value instanceof int[]) {
                    string = Arrays.toString((int[]) value);
                    m.e(string, "toString(this)");
                } else if (value instanceof float[]) {
                    string = Arrays.toString((float[]) value);
                    m.e(string, "toString(this)");
                } else if (value instanceof long[]) {
                    string = Arrays.toString((long[]) value);
                    m.e(string, "toString(this)");
                } else if (value instanceof double[]) {
                    string = Arrays.toString((double[]) value);
                    m.e(string, "toString(this)");
                } else if (value instanceof Object[]) {
                    string = Arrays.toString((Object[]) value);
                    m.e(string, "toString(this)");
                } else {
                    string = value.toString();
                }
                return key + '=' + string;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Class<T> cls, Map<String, ? extends Object> map) {
            super(0);
            this.$annotationClass = cls;
            this.$values = map;
        }

        @Override // c9.a
        public final String invoke() throws IOException {
            Class<T> cls = this.$annotationClass;
            Map<String, Object> map = this.$values;
            StringBuilder sb2 = new StringBuilder();
            sb2.append('@');
            sb2.append(cls.getCanonicalName());
            c0.n0(map.entrySet(), sb2, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : "(", (124 & 8) == 0 ? ")" : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : a.f12393a);
            String string = sb2.toString();
            m.e(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
    }

    public static final <T> T d(Class<T> annotationClass, Map<String, ? extends Object> values, List<Method> methods) {
        m.f(annotationClass, "annotationClass");
        m.f(values, "values");
        m.f(methods, "methods");
        r8.i iVarA = r8.j.a(new a(values));
        T t10 = (T) Proxy.newProxyInstance(annotationClass.getClassLoader(), new Class[]{annotationClass}, new kotlin.reflect.jvm.internal.calls.b(annotationClass, values, r8.j.a(new b(annotationClass, values)), iVarA, methods));
        m.d(t10, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.createAnnotationInstance");
        return t10;
    }

    public static /* synthetic */ Object e(Class cls, Map map, List list, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            Set setKeySet = map.keySet();
            ArrayList arrayList = new ArrayList(r.w(setKeySet, 10));
            Iterator it = setKeySet.iterator();
            while (it.hasNext()) {
                arrayList.add(cls.getDeclaredMethod((String) it.next(), null));
            }
            list = arrayList;
        }
        return d(cls, map, list);
    }

    private static final <T> boolean f(Class<T> cls, List<Method> list, Map<String, ? extends Object> map, Object obj) throws IllegalAccessException, InvocationTargetException {
        boolean zA;
        boolean z10;
        i9.d dVarA;
        Annotation annotation = obj instanceof Annotation ? (Annotation) obj : null;
        if (m.a((annotation == null || (dVarA = b9.a.a(annotation)) == null) ? null : b9.a.b(dVarA), cls)) {
            List<Method> list2 = list;
            if ((list2 instanceof Collection) && list2.isEmpty()) {
                z10 = true;
            } else {
                for (Method method : list2) {
                    Object obj2 = map.get(method.getName());
                    Object objInvoke = method.invoke(obj, null);
                    if (obj2 instanceof boolean[]) {
                        m.d(objInvoke, "null cannot be cast to non-null type kotlin.BooleanArray");
                        zA = Arrays.equals((boolean[]) obj2, (boolean[]) objInvoke);
                    } else if (obj2 instanceof char[]) {
                        m.d(objInvoke, "null cannot be cast to non-null type kotlin.CharArray");
                        zA = Arrays.equals((char[]) obj2, (char[]) objInvoke);
                    } else if (obj2 instanceof byte[]) {
                        m.d(objInvoke, "null cannot be cast to non-null type kotlin.ByteArray");
                        zA = Arrays.equals((byte[]) obj2, (byte[]) objInvoke);
                    } else if (obj2 instanceof short[]) {
                        m.d(objInvoke, "null cannot be cast to non-null type kotlin.ShortArray");
                        zA = Arrays.equals((short[]) obj2, (short[]) objInvoke);
                    } else if (obj2 instanceof int[]) {
                        m.d(objInvoke, "null cannot be cast to non-null type kotlin.IntArray");
                        zA = Arrays.equals((int[]) obj2, (int[]) objInvoke);
                    } else if (obj2 instanceof float[]) {
                        m.d(objInvoke, "null cannot be cast to non-null type kotlin.FloatArray");
                        zA = Arrays.equals((float[]) obj2, (float[]) objInvoke);
                    } else if (obj2 instanceof long[]) {
                        m.d(objInvoke, "null cannot be cast to non-null type kotlin.LongArray");
                        zA = Arrays.equals((long[]) obj2, (long[]) objInvoke);
                    } else if (obj2 instanceof double[]) {
                        m.d(objInvoke, "null cannot be cast to non-null type kotlin.DoubleArray");
                        zA = Arrays.equals((double[]) obj2, (double[]) objInvoke);
                    } else if (obj2 instanceof Object[]) {
                        m.d(objInvoke, "null cannot be cast to non-null type kotlin.Array<*>");
                        zA = Arrays.equals((Object[]) obj2, (Object[]) objInvoke);
                    } else {
                        zA = m.a(obj2, objInvoke);
                    }
                    if (!zA) {
                        z10 = false;
                    }
                }
                z10 = true;
            }
            if (z10) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object i(Class annotationClass, Map values, r8.i toString$delegate, r8.i hashCode$delegate, List methods, Object obj, Method method, Object[] args) {
        m.f(annotationClass, "$annotationClass");
        m.f(values, "$values");
        m.f(toString$delegate, "$toString$delegate");
        m.f(hashCode$delegate, "$hashCode$delegate");
        m.f(methods, "$methods");
        String name = method.getName();
        if (name != null) {
            int iHashCode = name.hashCode();
            if (iHashCode != -1776922004) {
                if (iHashCode != 147696667) {
                    if (iHashCode == 1444986633 && name.equals("annotationType")) {
                        return annotationClass;
                    }
                } else if (name.equals("hashCode")) {
                    return Integer.valueOf(g(hashCode$delegate));
                }
            } else if (name.equals("toString")) {
                return h(toString$delegate);
            }
        }
        if (m.a(name, "equals") && args != null && args.length == 1) {
            m.e(args, "args");
            return Boolean.valueOf(f(annotationClass, methods, values, kotlin.collections.j.n0(args)));
        }
        if (values.containsKey(name)) {
            return values.get(name);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Method is not supported: ");
        sb2.append(method);
        sb2.append(" (args: ");
        if (args == null) {
            args = new Object[0];
        }
        sb2.append(kotlin.collections.j.E0(args));
        sb2.append(')');
        throw new f0(sb2.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void j(int i10, String str, Class<?> cls) {
        i9.d dVarB;
        String strB;
        if (m.a(cls, Class.class)) {
            dVarB = kotlin.jvm.internal.c0.b(i9.d.class);
        } else {
            dVarB = (cls.isArray() && m.a(cls.getComponentType(), Class.class)) ? kotlin.jvm.internal.c0.b(i9.d[].class) : b9.a.e(cls);
        }
        if (m.a(dVarB.b(), kotlin.jvm.internal.c0.b(Object[].class).b())) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(dVarB.b());
            sb2.append('<');
            Class<?> componentType = b9.a.b(dVarB).getComponentType();
            m.e(componentType, "kotlinClass.java.componentType");
            sb2.append(b9.a.e(componentType).b());
            sb2.append('>');
            strB = sb2.toString();
        } else {
            strB = dVarB.b();
        }
        throw new IllegalArgumentException("Argument #" + i10 + ' ' + str + " is not of the required type " + strB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object k(Object obj, Class<?> cls) {
        if (obj instanceof Class) {
            return null;
        }
        if (obj instanceof i9.d) {
            obj = b9.a.b((i9.d) obj);
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Class[]) {
                return null;
            }
            if (objArr instanceof i9.d[]) {
                m.d(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
                i9.d[] dVarArr = (i9.d[]) obj;
                ArrayList arrayList = new ArrayList(dVarArr.length);
                for (i9.d dVar : dVarArr) {
                    arrayList.add(b9.a.b(dVar));
                }
                obj = arrayList.toArray(new Class[0]);
            } else {
                obj = objArr;
            }
        }
        if (cls.isInstance(obj)) {
            return obj;
        }
        return null;
    }

    private static final int g(r8.i<Integer> iVar) {
        return iVar.getValue().intValue();
    }

    private static final String h(r8.i<String> iVar) {
        return iVar.getValue();
    }
}
