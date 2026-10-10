package i9;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0004\u0010\u0005\u001a)\u0010\u000b\u001a\u00020\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0003¢\u0006\u0004\b\u000b\u0010\f\u001a\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0010\"\u001e\u0010\u0015\u001a\u00020\u0003*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\"\u001e\u0010\u0015\u001a\u00020\u0003*\u00020\t8BX\u0083\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Li9/n;", "", "forceWrapper", "Ljava/lang/reflect/Type;", "c", "(Li9/n;Z)Ljava/lang/reflect/Type;", "Ljava/lang/Class;", "jClass", "", "Li9/p;", "arguments", "e", "(Ljava/lang/Class;Ljava/util/List;)Ljava/lang/reflect/Type;", IjkMediaMeta.IJKM_KEY_TYPE, "", "h", "(Ljava/lang/reflect/Type;)Ljava/lang/String;", "f", "(Li9/n;)Ljava/lang/reflect/Type;", "getJavaType$annotations", "(Li9/n;)V", "javaType", "g", "(Li9/p;)Ljava/lang/reflect/Type;", "(Li9/p;)V", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class u {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class b extends kotlin.jvm.internal.k implements c9.l<Class<?>, Class<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f11268a = new b();

        b() {
            super(1, Class.class, "getComponentType", "getComponentType()Ljava/lang/Class;", 0);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public final Class<?> invoke(Class<?> p10) {
            kotlin.jvm.internal.m.f(p10, "p0");
            return p10.getComponentType();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11267a;

        static {
            int[] iArr = new int[q.values().length];
            try {
                iArr[q.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[q.INVARIANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[q.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f11267a = iArr;
        }
    }

    static /* synthetic */ Type d(n nVar, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return c(nVar, z10);
    }

    public static final Type f(n nVar) {
        Type typeF;
        kotlin.jvm.internal.m.f(nVar, "<this>");
        return (!(nVar instanceof kotlin.jvm.internal.n) || (typeF = ((kotlin.jvm.internal.n) nVar).f()) == null) ? d(nVar, false, 1, null) : typeF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String h(Type type) {
        if (!(type instanceof Class)) {
            return type.toString();
        }
        Class cls = (Class) type;
        if (!cls.isArray()) {
            String name = cls.getName();
            kotlin.jvm.internal.m.e(name, "getName(...)");
            return name;
        }
        ta.h hVarO = ta.k.o(type, b.f11268a);
        return ((Class) ta.k.I(hVarO)).getName() + ua.n.A("[]", ta.k.w(hVarO));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Type c(n nVar, boolean z10) {
        Class clsB;
        int i10;
        e eVarC = nVar.c();
        if (eVarC instanceof o) {
            return new t((o) eVarC);
        }
        if (eVarC instanceof d) {
            d dVar = (d) eVarC;
            if (z10) {
                clsB = b9.a.c(dVar);
            } else {
                clsB = b9.a.b(dVar);
            }
            List<p> arguments = nVar.getArguments();
            if (arguments.isEmpty()) {
                return clsB;
            }
            if (clsB.isArray()) {
                if (!clsB.getComponentType().isPrimitive()) {
                    p pVar = (p) kotlin.collections.r.H0(arguments);
                    if (pVar != null) {
                        q variance = pVar.getVariance();
                        n nVar2 = pVar.getTv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TYPE java.lang.String();
                        if (variance == null) {
                            i10 = -1;
                        } else {
                            i10 = a.f11267a[variance.ordinal()];
                        }
                        if (i10 != -1 && i10 != 1) {
                            if (i10 != 2 && i10 != 3) {
                                throw new r8.n();
                            }
                            kotlin.jvm.internal.m.c(nVar2);
                            Type typeD = d(nVar2, false, 1, null);
                            if (!(typeD instanceof Class)) {
                                return new i9.a(typeD);
                            }
                            return clsB;
                        }
                        return clsB;
                    }
                    throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + nVar);
                }
                return clsB;
            }
            return e(clsB, arguments);
        }
        throw new UnsupportedOperationException("Unsupported type classifier: " + nVar);
    }

    private static final Type e(Class<?> cls, List<p> list) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            List<p> list2 = list;
            ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(g((p) it.next()));
            }
            return new s(cls, null, arrayList);
        }
        if (Modifier.isStatic(cls.getModifiers())) {
            List<p> list3 = list;
            ArrayList arrayList2 = new ArrayList(kotlin.collections.r.w(list3, 10));
            Iterator<T> it2 = list3.iterator();
            while (it2.hasNext()) {
                arrayList2.add(g((p) it2.next()));
            }
            return new s(cls, declaringClass, arrayList2);
        }
        int length = cls.getTypeParameters().length;
        Type typeE = e(declaringClass, list.subList(length, list.size()));
        List<p> listSubList = list.subList(0, length);
        ArrayList arrayList3 = new ArrayList(kotlin.collections.r.w(listSubList, 10));
        Iterator<T> it3 = listSubList.iterator();
        while (it3.hasNext()) {
            arrayList3.add(g((p) it3.next()));
        }
        return new s(cls, typeE, arrayList3);
    }

    private static final Type g(p pVar) {
        q qVarD = pVar.d();
        if (qVarD == null) {
            return v.f11269c.a();
        }
        n nVarC = pVar.c();
        kotlin.jvm.internal.m.c(nVarC);
        int i10 = a.f11267a[qVarD.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    return new v(c(nVarC, true), null);
                }
                throw new r8.n();
            }
            return c(nVarC, true);
        }
        return new v(null, c(nVarC, true));
    }
}
