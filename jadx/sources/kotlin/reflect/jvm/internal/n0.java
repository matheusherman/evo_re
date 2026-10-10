package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.types.k1;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a/\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a5\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001b\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0001*\u0006\u0012\u0002\b\u00030\u0001H\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0014*\u00020\u0013H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0019\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018*\u00020\u0017H\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018*\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u0019*\u00020\u001eH\u0002¢\u0006\u0004\b\u001f\u0010 \u001a!\u0010#\u001a\u0004\u0018\u00010\"*\u0006\u0012\u0002\b\u00030!2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b#\u0010$\u001a\u001d\u0010&\u001a\u0004\u0018\u00010\"*\u00020%2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b&\u0010'\u001a\u0017\u0010)\u001a\u0004\u0018\u00010(*\u0004\u0018\u00010\"H\u0000¢\u0006\u0004\b)\u0010*\u001a\u001b\u0010,\u001a\b\u0012\u0002\b\u0003\u0018\u00010+*\u0004\u0018\u00010\"H\u0000¢\u0006\u0004\b,\u0010-\u001a\u001b\u0010/\u001a\b\u0012\u0002\b\u0003\u0018\u00010.*\u0004\u0018\u00010\"H\u0000¢\u0006\u0004\b/\u00100\u001a\u0019\u00103\u001a\u0004\u0018\u00010\"2\u0006\u00102\u001a\u000201H\u0000¢\u0006\u0004\b3\u00104\u001ai\u0010D\u001a\u00028\u0001\"\b\b\u0000\u00106*\u000205\"\b\b\u0001\u00108*\u0002072\n\u00109\u001a\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010:\u001a\u00028\u00002\u0006\u0010<\u001a\u00020;2\u0006\u0010>\u001a\u00020=2\u0006\u0010@\u001a\u00020?2\u0018\u0010C\u001a\u0014\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010AH\u0000¢\u0006\u0004\bD\u0010E\u001a'\u0010I\u001a\u00028\u0000\"\u0004\b\u0000\u0010F2\f\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000GH\u0080\bø\u0001\u0000¢\u0006\u0004\bI\u0010J\"\u001a\u0010O\u001a\u00020K8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b&\u0010L\u001a\u0004\bM\u0010N\"\u0018\u0010T\u001a\u00020Q*\u00020P8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bR\u0010S\"\u001a\u0010X\u001a\u0004\u0018\u00010U*\u0002078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bV\u0010W\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006Y"}, d2 = {"Lkotlin/reflect/jvm/internal/impl/descriptors/e;", "Ljava/lang/Class;", "p", "(Lkotlin/reflect/jvm/internal/impl/descriptors/e;)Ljava/lang/Class;", "Ljava/lang/ClassLoader;", "classLoader", "Lba/b;", "kotlinClassId", "", "arrayDimensions", "l", "(Ljava/lang/ClassLoader;Lba/b;I)Ljava/lang/Class;", "", "packageName", "className", "m", "(Ljava/lang/ClassLoader;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/Class;", "f", "(Ljava/lang/Class;)Ljava/lang/Class;", "Lkotlin/reflect/jvm/internal/impl/descriptors/u;", "Li9/r;", "q", "(Lkotlin/reflect/jvm/internal/impl/descriptors/u;)Li9/r;", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/a;", "", "", "e", "(Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/a;)Ljava/util/List;", "s", "(Ljava/util/List;)Ljava/util/List;", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/c;", "o", "(Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/c;)Ljava/lang/annotation/Annotation;", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/g;", "", "r", "(Lkotlin/reflect/jvm/internal/impl/resolve/constants/g;Ljava/lang/ClassLoader;)Ljava/lang/Object;", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/b;", "a", "(Lkotlin/reflect/jvm/internal/impl/resolve/constants/b;Ljava/lang/ClassLoader;)Ljava/lang/Object;", "Lkotlin/reflect/jvm/internal/o;", "c", "(Ljava/lang/Object;)Lkotlin/reflect/jvm/internal/o;", "Lkotlin/reflect/jvm/internal/a0;", "d", "(Ljava/lang/Object;)Lkotlin/reflect/jvm/internal/a0;", "Lkotlin/reflect/jvm/internal/j;", "b", "(Ljava/lang/Object;)Lkotlin/reflect/jvm/internal/j;", "Ljava/lang/reflect/Type;", IjkMediaMeta.IJKM_KEY_TYPE, "g", "(Ljava/lang/reflect/Type;)Ljava/lang/Object;", "Lkotlin/reflect/jvm/internal/impl/protobuf/q;", "M", "Lkotlin/reflect/jvm/internal/impl/descriptors/a;", "D", "moduleAnchor", "proto", "Ly9/c;", "nameResolver", "Ly9/g;", "typeTable", "Ly9/a;", "metadataVersion", "Lkotlin/Function2;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/v;", "createDescriptor", "deserializeToDescriptor", "(Ljava/lang/Class;Lorg/jetbrains/kotlin/protobuf/MessageLite;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;Lorg/jetbrains/kotlin/metadata/deserialization/BinaryVersion;Lc9/p;)Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;", "R", "Lkotlin/Function0;", "block", "reflectionCall", "(Lc9/a;)Ljava/lang/Object;", "Lba/c;", "Lba/c;", "getJVM_STATIC", "()Lorg/jetbrains/kotlin/name/FqName;", "JVM_STATIC", "Li9/n;", "", "k", "(Li9/n;)Z", "isInlineClassType", "Lkotlin/reflect/jvm/internal/impl/descriptors/x0;", "getInstanceReceiverParameter", "(Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;)Lorg/jetbrains/kotlin/descriptors/ReceiverParameterDescriptor;", "instanceReceiverParameter", "kotlin-reflection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ba.c f14531a = new ba.c("kotlin.jvm.JvmStatic");

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.List<? extends java.lang.annotation.Annotation>, java.util.List<java.lang.annotation.Annotation>] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.List<java.lang.annotation.Annotation>] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.util.ArrayList, java.util.Collection] */
    private static final List<Annotation> s(List<? extends Annotation> list) throws IllegalAccessException, InvocationTargetException {
        List listE;
        Iterable<Annotation> iterable = (Iterable) list;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return list;
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.m.a(b9.a.b(b9.a.a((Annotation) it.next())).getSimpleName(), "Container")) {
                list = new ArrayList<>();
                for (Annotation annotation : iterable) {
                    Class clsB = b9.a.b(b9.a.a(annotation));
                    if (!kotlin.jvm.internal.m.a(clsB.getSimpleName(), "Container") || clsB.getAnnotation(kotlin.jvm.internal.e0.class) == null) {
                        listE = kotlin.collections.r.e(annotation);
                    } else {
                        Object objInvoke = clsB.getDeclaredMethod("value", null).invoke(annotation, null);
                        kotlin.jvm.internal.m.d(objInvoke, "null cannot be cast to non-null type kotlin.Array<out kotlin.Annotation>");
                        listE = kotlin.collections.j.d((Annotation[]) objInvoke);
                    }
                    kotlin.collections.r.C(list, listE);
                }
                break;
            }
        }
        return list;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14532a;

        static {
            int[] iArr = new int[kotlin.reflect.jvm.internal.impl.builtins.i.values().length];
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.i.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.i.CHAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.i.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.i.SHORT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.i.INT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.i.FLOAT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.i.LONG.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.i.DOUBLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            f14532a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final Object a(kotlin.reflect.jvm.internal.impl.resolve.constants.b bVar, ClassLoader classLoader) {
        kotlin.reflect.jvm.internal.impl.types.g0 g0VarC;
        Class clsN;
        kotlin.reflect.jvm.internal.impl.resolve.constants.w wVar = bVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.w ? (kotlin.reflect.jvm.internal.impl.resolve.constants.w) bVar : null;
        if (wVar == null || (g0VarC = wVar.c()) == null) {
            return null;
        }
        List<? extends kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> listB = bVar.b();
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(listB, 10));
        Iterator<T> it = listB.iterator();
        while (it.hasNext()) {
            arrayList.add(r((kotlin.reflect.jvm.internal.impl.resolve.constants.g) it.next(), classLoader));
        }
        kotlin.reflect.jvm.internal.impl.builtins.i iVarN = kotlin.reflect.jvm.internal.impl.builtins.h.N(g0VarC);
        int i10 = 0;
        switch (iVarN == null ? -1 : a.f14532a[iVarN.ordinal()]) {
            case -1:
                if (!kotlin.reflect.jvm.internal.impl.builtins.h.c0(g0VarC)) {
                    throw new IllegalStateException(("Not an array type: " + g0VarC).toString());
                }
                kotlin.reflect.jvm.internal.impl.types.g0 type = ((k1) kotlin.collections.r.F0(g0VarC.H0())).getType();
                kotlin.jvm.internal.m.e(type, "type.arguments.single().type");
                kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = type.J0().d();
                kotlin.reflect.jvm.internal.impl.descriptors.e eVar = hVarD instanceof kotlin.reflect.jvm.internal.impl.descriptors.e ? (kotlin.reflect.jvm.internal.impl.descriptors.e) hVarD : null;
                if (eVar == null) {
                    throw new IllegalStateException(("Not a class type: " + type).toString());
                }
                if (kotlin.reflect.jvm.internal.impl.builtins.h.v0(type)) {
                    int size = bVar.b().size();
                    String[] strArr = new String[size];
                    while (i10 < size) {
                        Object obj = arrayList.get(i10);
                        kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type kotlin.String");
                        strArr[i10] = obj;
                        i10++;
                    }
                    return strArr;
                }
                if (kotlin.reflect.jvm.internal.impl.builtins.h.l0(eVar)) {
                    int size2 = bVar.b().size();
                    Class[] clsArr = new Class[size2];
                    while (i10 < size2) {
                        Object obj2 = arrayList.get(i10);
                        kotlin.jvm.internal.m.d(obj2, "null cannot be cast to non-null type java.lang.Class<*>");
                        clsArr[i10] = obj2;
                        i10++;
                    }
                    return clsArr;
                }
                ba.b bVarK = ea.c.k(eVar);
                if (bVarK == null || (clsN = n(classLoader, bVarK, 0, 4, null)) == null) {
                    return null;
                }
                Object objNewInstance = Array.newInstance((Class<?>) clsN, bVar.b().size());
                kotlin.jvm.internal.m.d(objNewInstance, "null cannot be cast to non-null type kotlin.Array<in kotlin.Any?>");
                Object[] objArr = (Object[]) objNewInstance;
                int size3 = arrayList.size();
                while (i10 < size3) {
                    objArr[i10] = arrayList.get(i10);
                    i10++;
                }
                return objArr;
            case 0:
            default:
                throw new r8.n();
            case 1:
                int size4 = bVar.b().size();
                boolean[] zArr = new boolean[size4];
                while (i10 < size4) {
                    Object obj3 = arrayList.get(i10);
                    kotlin.jvm.internal.m.d(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                    zArr[i10] = ((Boolean) obj3).booleanValue();
                    i10++;
                }
                return zArr;
            case 2:
                int size5 = bVar.b().size();
                char[] cArr = new char[size5];
                while (i10 < size5) {
                    Object obj4 = arrayList.get(i10);
                    kotlin.jvm.internal.m.d(obj4, "null cannot be cast to non-null type kotlin.Char");
                    cArr[i10] = ((Character) obj4).charValue();
                    i10++;
                }
                return cArr;
            case 3:
                int size6 = bVar.b().size();
                byte[] bArr = new byte[size6];
                while (i10 < size6) {
                    Object obj5 = arrayList.get(i10);
                    kotlin.jvm.internal.m.d(obj5, "null cannot be cast to non-null type kotlin.Byte");
                    bArr[i10] = ((Byte) obj5).byteValue();
                    i10++;
                }
                return bArr;
            case 4:
                int size7 = bVar.b().size();
                short[] sArr = new short[size7];
                while (i10 < size7) {
                    Object obj6 = arrayList.get(i10);
                    kotlin.jvm.internal.m.d(obj6, "null cannot be cast to non-null type kotlin.Short");
                    sArr[i10] = ((Short) obj6).shortValue();
                    i10++;
                }
                return sArr;
            case 5:
                int size8 = bVar.b().size();
                int[] iArr = new int[size8];
                while (i10 < size8) {
                    Object obj7 = arrayList.get(i10);
                    kotlin.jvm.internal.m.d(obj7, "null cannot be cast to non-null type kotlin.Int");
                    iArr[i10] = ((Integer) obj7).intValue();
                    i10++;
                }
                return iArr;
            case 6:
                int size9 = bVar.b().size();
                float[] fArr = new float[size9];
                while (i10 < size9) {
                    Object obj8 = arrayList.get(i10);
                    kotlin.jvm.internal.m.d(obj8, "null cannot be cast to non-null type kotlin.Float");
                    fArr[i10] = ((Float) obj8).floatValue();
                    i10++;
                }
                return fArr;
            case 7:
                int size10 = bVar.b().size();
                long[] jArr = new long[size10];
                while (i10 < size10) {
                    Object obj9 = arrayList.get(i10);
                    kotlin.jvm.internal.m.d(obj9, "null cannot be cast to non-null type kotlin.Long");
                    jArr[i10] = ((Long) obj9).longValue();
                    i10++;
                }
                return jArr;
            case 8:
                int size11 = bVar.b().size();
                double[] dArr = new double[size11];
                while (i10 < size11) {
                    Object obj10 = arrayList.get(i10);
                    kotlin.jvm.internal.m.d(obj10, "null cannot be cast to non-null type kotlin.Double");
                    dArr[i10] = ((Double) obj10).doubleValue();
                    i10++;
                }
                return dArr;
        }
    }

    public static final j<?> b(Object obj) {
        j<?> jVar = obj instanceof j ? (j) obj : null;
        if (jVar != null) {
            return jVar;
        }
        o oVarC = c(obj);
        return oVarC != null ? oVarC : d(obj);
    }

    public static final o c(Object obj) {
        o oVar = obj instanceof o ? (o) obj : null;
        if (oVar != null) {
            return oVar;
        }
        kotlin.jvm.internal.j jVar = obj instanceof kotlin.jvm.internal.j ? (kotlin.jvm.internal.j) obj : null;
        i9.c cVarCompute = jVar != null ? jVar.compute() : null;
        if (cVarCompute instanceof o) {
            return (o) cVarCompute;
        }
        return null;
    }

    public static final a0<?> d(Object obj) {
        a0<?> a0Var = obj instanceof a0 ? (a0) obj : null;
        if (a0Var != null) {
            return a0Var;
        }
        kotlin.jvm.internal.x xVar = obj instanceof kotlin.jvm.internal.x ? (kotlin.jvm.internal.x) obj : null;
        i9.c cVarCompute = xVar != null ? xVar.compute() : null;
        if (cVarCompute instanceof a0) {
            return (a0) cVarCompute;
        }
        return null;
    }

    public static final List<Annotation> e(kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar) {
        Annotation annotationO;
        kotlin.jvm.internal.m.f(aVar, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations = aVar.getAnnotations();
        ArrayList arrayList = new ArrayList();
        for (kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar : annotations) {
            a1 source = cVar.getSource();
            if (source instanceof p9.b) {
                annotationO = ((p9.b) source).d();
            } else if (source instanceof p9.l.a) {
                kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.p pVarB = ((p9.l.a) source).b();
                kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.e eVar = pVarB instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.e ? (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.e) pVarB : null;
                annotationO = eVar != null ? eVar.P() : null;
            } else {
                annotationO = o(cVar);
            }
            if (annotationO != null) {
                arrayList.add(annotationO);
            }
        }
        return s(arrayList);
    }

    public static final Class<?> f(Class<?> cls) {
        kotlin.jvm.internal.m.f(cls, "<this>");
        return Array.newInstance(cls, 0).getClass();
    }

    public static final Object g(Type type) {
        kotlin.jvm.internal.m.f(type, "type");
        if (!(type instanceof Class) || !((Class) type).isPrimitive()) {
            return null;
        }
        if (kotlin.jvm.internal.m.a(type, Boolean.TYPE)) {
            return Boolean.FALSE;
        }
        if (kotlin.jvm.internal.m.a(type, Character.TYPE)) {
            return (char) 0;
        }
        if (kotlin.jvm.internal.m.a(type, Byte.TYPE)) {
            return (byte) 0;
        }
        if (kotlin.jvm.internal.m.a(type, Short.TYPE)) {
            return (short) 0;
        }
        if (kotlin.jvm.internal.m.a(type, Integer.TYPE)) {
            return 0;
        }
        if (kotlin.jvm.internal.m.a(type, Float.TYPE)) {
            return Float.valueOf(0.0f);
        }
        if (kotlin.jvm.internal.m.a(type, Long.TYPE)) {
            return 0L;
        }
        if (kotlin.jvm.internal.m.a(type, Double.TYPE)) {
            return Double.valueOf(0.0d);
        }
        if (kotlin.jvm.internal.m.a(type, Void.TYPE)) {
            throw new IllegalStateException("Parameter with void type is illegal");
        }
        throw new UnsupportedOperationException("Unknown primitive: " + type);
    }

    public static final <M extends kotlin.reflect.jvm.internal.impl.protobuf.q, D extends kotlin.reflect.jvm.internal.impl.descriptors.a> D h(Class<?> moduleAnchor, M proto, y9.c nameResolver, y9.g typeTable, y9.a metadataVersion, c9.p<? super kotlin.reflect.jvm.internal.impl.serialization.deserialization.v, ? super M, ? extends D> createDescriptor) {
        List<w9.s> listM0;
        kotlin.jvm.internal.m.f(moduleAnchor, "moduleAnchor");
        kotlin.jvm.internal.m.f(proto, "proto");
        kotlin.jvm.internal.m.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.m.f(typeTable, "typeTable");
        kotlin.jvm.internal.m.f(metadataVersion, "metadataVersion");
        kotlin.jvm.internal.m.f(createDescriptor, "createDescriptor");
        p9.k kVarA = g0.a(moduleAnchor);
        if (proto instanceof w9.i) {
            listM0 = ((w9.i) proto).l0();
        } else {
            if (!(proto instanceof w9.n)) {
                throw new IllegalStateException(("Unsupported message: " + proto).toString());
            }
            listM0 = ((w9.n) proto).m0();
        }
        List<w9.s> typeParameters = listM0;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.k kVarA2 = kVarA.a();
        kotlin.reflect.jvm.internal.impl.descriptors.h0 h0VarB = kVarA.b();
        y9.h hVarB = y9.h.f22527b.b();
        kotlin.jvm.internal.m.e(typeParameters, "typeParameters");
        return createDescriptor.invoke(new kotlin.reflect.jvm.internal.impl.serialization.deserialization.v(new kotlin.reflect.jvm.internal.impl.serialization.deserialization.m(kVarA2, nameResolver, h0VarB, typeTable, hVarB, metadataVersion, null, null, typeParameters)), proto);
    }

    public static final x0 i(kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        kotlin.jvm.internal.m.f(aVar, "<this>");
        if (aVar.b0() == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = aVar.b();
        kotlin.jvm.internal.m.d(mVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        return ((kotlin.reflect.jvm.internal.impl.descriptors.e) mVarB).F0();
    }

    public static final ba.c j() {
        return f14531a;
    }

    public static final boolean k(i9.n nVar) {
        kotlin.reflect.jvm.internal.impl.types.g0 g0VarJ;
        kotlin.jvm.internal.m.f(nVar, "<this>");
        c0 c0Var = nVar instanceof c0 ? (c0) nVar : null;
        return (c0Var == null || (g0VarJ = c0Var.getTv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TYPE java.lang.String()) == null || !kotlin.reflect.jvm.internal.impl.resolve.g.c(g0VarJ)) ? false : true;
    }

    private static final Class<?> l(ClassLoader classLoader, ba.b bVar, int i10) {
        kotlin.reflect.jvm.internal.impl.builtins.jvm.c cVar = kotlin.reflect.jvm.internal.impl.builtins.jvm.c.f12505a;
        ba.d dVarJ = bVar.b().j();
        kotlin.jvm.internal.m.e(dVarJ, "kotlinClassId.asSingleFqName().toUnsafe()");
        ba.b bVarN = cVar.n(dVarJ);
        if (bVarN != null) {
            bVar = bVarN;
        }
        String strB = bVar.h().b();
        kotlin.jvm.internal.m.e(strB, "javaClassId.packageFqName.asString()");
        String strB2 = bVar.i().b();
        kotlin.jvm.internal.m.e(strB2, "javaClassId.relativeClassName.asString()");
        return m(classLoader, strB, strB2, i10);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static final Class<?> m(ClassLoader classLoader, String str, String str2, int i10) {
        if (kotlin.jvm.internal.m.a(str, "kotlin")) {
            switch (str2.hashCode()) {
                case -901856463:
                    if (str2.equals("BooleanArray")) {
                        return boolean[].class;
                    }
                    break;
                case -763279523:
                    if (str2.equals("ShortArray")) {
                        return short[].class;
                    }
                    break;
                case -755911549:
                    if (str2.equals("CharArray")) {
                        return char[].class;
                    }
                    break;
                case -74930671:
                    if (str2.equals("ByteArray")) {
                        return byte[].class;
                    }
                    break;
                case 22374632:
                    if (str2.equals("DoubleArray")) {
                        return double[].class;
                    }
                    break;
                case 63537721:
                    if (str2.equals("Array")) {
                        return Object[].class;
                    }
                    break;
                case 601811914:
                    if (str2.equals("IntArray")) {
                        return int[].class;
                    }
                    break;
                case 948852093:
                    if (str2.equals("FloatArray")) {
                        return float[].class;
                    }
                    break;
                case 2104330525:
                    if (str2.equals("LongArray")) {
                        return long[].class;
                    }
                    break;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        if (i10 > 0) {
            for (int i11 = 0; i11 < i10; i11++) {
                sb2.append("[");
            }
            sb2.append("L");
        }
        if (str.length() > 0) {
            sb2.append(str + '.');
        }
        sb2.append(ua.n.D(str2, '.', '$', false, 4, null));
        if (i10 > 0) {
            sb2.append(";");
        }
        String string = sb2.toString();
        kotlin.jvm.internal.m.e(string, "StringBuilder().apply(builderAction).toString()");
        return p9.e.a(classLoader, string);
    }

    static /* synthetic */ Class n(ClassLoader classLoader, ba.b bVar, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return l(classLoader, bVar, i10);
    }

    public static final Class<?> p(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        kotlin.jvm.internal.m.f(eVar, "<this>");
        a1 source = eVar.getSource();
        kotlin.jvm.internal.m.e(source, "source");
        if (source instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.u) {
            kotlin.reflect.jvm.internal.impl.load.kotlin.s sVarD = ((kotlin.reflect.jvm.internal.impl.load.kotlin.u) source).d();
            kotlin.jvm.internal.m.d(sVarD, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.components.ReflectKotlinClass");
            return ((p9.f) sVarD).a();
        }
        if (source instanceof p9.l.a) {
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.p pVarB = ((p9.l.a) source).b();
            kotlin.jvm.internal.m.d(pVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
            return ((kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.l) pVarB).t();
        }
        ba.b bVarK = ea.c.k(eVar);
        if (bVarK == null) {
            return null;
        }
        return l(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.e(eVar.getClass()), bVarK, 0);
    }

    public static final i9.r q(kotlin.reflect.jvm.internal.impl.descriptors.u uVar) {
        kotlin.jvm.internal.m.f(uVar, "<this>");
        if (kotlin.jvm.internal.m.a(uVar, kotlin.reflect.jvm.internal.impl.descriptors.t.f13068e)) {
            return i9.r.PUBLIC;
        }
        if (kotlin.jvm.internal.m.a(uVar, kotlin.reflect.jvm.internal.impl.descriptors.t.f13066c)) {
            return i9.r.PROTECTED;
        }
        if (kotlin.jvm.internal.m.a(uVar, kotlin.reflect.jvm.internal.impl.descriptors.t.f13067d)) {
            return i9.r.INTERNAL;
        }
        if (kotlin.jvm.internal.m.a(uVar, kotlin.reflect.jvm.internal.impl.descriptors.t.f13064a) ? true : kotlin.jvm.internal.m.a(uVar, kotlin.reflect.jvm.internal.impl.descriptors.t.f13065b)) {
            return i9.r.PRIVATE;
        }
        return null;
    }

    private static final Object r(kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> gVar, ClassLoader classLoader) {
        if (gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.a) {
            return o(((kotlin.reflect.jvm.internal.impl.resolve.constants.a) gVar).b());
        }
        if (gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.b) {
            return a((kotlin.reflect.jvm.internal.impl.resolve.constants.b) gVar, classLoader);
        }
        if (gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.j) {
            r8.p<? extends ba.b, ? extends ba.f> pVarB = ((kotlin.reflect.jvm.internal.impl.resolve.constants.j) gVar).b();
            ba.b bVarA = pVarB.a();
            ba.f fVarB = pVarB.b();
            Class clsN = n(classLoader, bVarA, 0, 4, null);
            if (clsN != null) {
                return m0.a(clsN, fVarB.f());
            }
            return null;
        }
        if (!(gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.q)) {
            if (gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.k ? true : gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.s) {
                return null;
            }
            return gVar.b();
        }
        kotlin.reflect.jvm.internal.impl.resolve.constants.q.b bVarB = ((kotlin.reflect.jvm.internal.impl.resolve.constants.q) gVar).b();
        if (bVarB instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.q.b.C0254b) {
            kotlin.reflect.jvm.internal.impl.resolve.constants.q.b.C0254b c0254b = (kotlin.reflect.jvm.internal.impl.resolve.constants.q.b.C0254b) bVarB;
            return l(classLoader, c0254b.b(), c0254b.a());
        }
        if (!(bVarB instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.q.b.a)) {
            throw new r8.n();
        }
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = ((kotlin.reflect.jvm.internal.impl.resolve.constants.q.b.a) bVarB).a().J0().d();
        kotlin.reflect.jvm.internal.impl.descriptors.e eVar = hVarD instanceof kotlin.reflect.jvm.internal.impl.descriptors.e ? (kotlin.reflect.jvm.internal.impl.descriptors.e) hVarD : null;
        if (eVar != null) {
            return p(eVar);
        }
        return null;
    }

    private static final Annotation o(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        Class<?> clsP;
        r8.p pVarA;
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarI = ea.c.i(cVar);
        if (eVarI != null) {
            clsP = p(eVarI);
        } else {
            clsP = null;
        }
        if (!androidx.view.k.a(clsP)) {
            clsP = null;
        }
        if (clsP == null) {
            return null;
        }
        Set<Map.Entry<ba.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>>> setEntrySet = cVar.a().entrySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            ba.f fVar = (ba.f) entry.getKey();
            kotlin.reflect.jvm.internal.impl.resolve.constants.g gVar = (kotlin.reflect.jvm.internal.impl.resolve.constants.g) entry.getValue();
            ClassLoader classLoader = clsP.getClassLoader();
            kotlin.jvm.internal.m.e(classLoader, "annotationClass.classLoader");
            Object objR = r(gVar, classLoader);
            if (objR != null) {
                pVarA = r8.v.a(fVar.f(), objR);
            } else {
                pVarA = null;
            }
            if (pVarA != null) {
                arrayList.add(pVarA);
            }
        }
        return (Annotation) kotlin.reflect.jvm.internal.calls.c.e(clsP, kotlin.collections.n0.q(arrayList), null, 4, null);
    }
}
