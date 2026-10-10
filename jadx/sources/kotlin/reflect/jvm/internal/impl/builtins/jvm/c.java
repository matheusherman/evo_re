package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import ua.n;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f12505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f12506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f12507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f12508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f12509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ba.b f12510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ba.c f12511g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ba.b f12512h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final ba.b f12513i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ba.b f12514j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final HashMap<ba.d, ba.b> f12515k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final HashMap<ba.d, ba.b> f12516l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final HashMap<ba.d, ba.c> f12517m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final HashMap<ba.d, ba.c> f12518n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final HashMap<ba.b, ba.b> f12519o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final HashMap<ba.b, ba.b> f12520p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final List<a> f12521q;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ba.b f12522a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ba.b f12523b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ba.b f12524c;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return m.a(this.f12522a, aVar.f12522a) && m.a(this.f12523b, aVar.f12523b) && m.a(this.f12524c, aVar.f12524c);
        }

        public a(ba.b javaClass, ba.b kotlinReadOnly, ba.b kotlinMutable) {
            m.f(javaClass, "javaClass");
            m.f(kotlinReadOnly, "kotlinReadOnly");
            m.f(kotlinMutable, "kotlinMutable");
            this.f12522a = javaClass;
            this.f12523b = kotlinReadOnly;
            this.f12524c = kotlinMutable;
        }

        public final ba.b a() {
            return this.f12522a;
        }

        public final ba.b b() {
            return this.f12523b;
        }

        public final ba.b c() {
            return this.f12524c;
        }

        public final ba.b d() {
            return this.f12522a;
        }

        public int hashCode() {
            return (((this.f12522a.hashCode() * 31) + this.f12523b.hashCode()) * 31) + this.f12524c.hashCode();
        }

        public String toString() {
            return "PlatformMutabilityMapping(javaClass=" + this.f12522a + ", kotlinReadOnly=" + this.f12523b + ", kotlinMutable=" + this.f12524c + ')';
        }
    }

    static {
        c cVar = new c();
        f12505a = cVar;
        StringBuilder sb2 = new StringBuilder();
        m9.c cVar2 = m9.c.f15686b;
        sb2.append(cVar2.i().toString());
        sb2.append('.');
        sb2.append(cVar2.f());
        f12506b = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        m9.c cVar3 = m9.c.f15688d;
        sb3.append(cVar3.i().toString());
        sb3.append('.');
        sb3.append(cVar3.f());
        f12507c = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        m9.c cVar4 = m9.c.f15687c;
        sb4.append(cVar4.i().toString());
        sb4.append('.');
        sb4.append(cVar4.f());
        f12508d = sb4.toString();
        StringBuilder sb5 = new StringBuilder();
        m9.c cVar5 = m9.c.f15689e;
        sb5.append(cVar5.i().toString());
        sb5.append('.');
        sb5.append(cVar5.f());
        f12509e = sb5.toString();
        ba.b bVarM = ba.b.m(new ba.c("kotlin.jvm.functions.FunctionN"));
        m.e(bVarM, "topLevel(FqName(\"kotlin.jvm.functions.FunctionN\"))");
        f12510f = bVarM;
        ba.c cVarB = bVarM.b();
        m.e(cVarB, "FUNCTION_N_CLASS_ID.asSingleFqName()");
        f12511g = cVarB;
        ba.i iVar = ba.i.f960a;
        f12512h = iVar.k();
        f12513i = iVar.j();
        f12514j = cVar.g(Class.class);
        f12515k = new HashMap<>();
        f12516l = new HashMap<>();
        f12517m = new HashMap<>();
        f12518n = new HashMap<>();
        f12519o = new HashMap<>();
        f12520p = new HashMap<>();
        ba.b bVarM2 = ba.b.m(kotlin.reflect.jvm.internal.impl.builtins.k.a.U);
        m.e(bVarM2, "topLevel(FqNames.iterable)");
        ba.c cVar6 = kotlin.reflect.jvm.internal.impl.builtins.k.a.f12603c0;
        ba.c cVarH = bVarM2.h();
        ba.c cVarH2 = bVarM2.h();
        m.e(cVarH2, "kotlinReadOnly.packageFqName");
        ba.c cVarG = ba.e.g(cVar6, cVarH2);
        a aVar = new a(cVar.g(Iterable.class), bVarM2, new ba.b(cVarH, cVarG, false));
        ba.b bVarM3 = ba.b.m(kotlin.reflect.jvm.internal.impl.builtins.k.a.T);
        m.e(bVarM3, "topLevel(FqNames.iterator)");
        ba.c cVar7 = kotlin.reflect.jvm.internal.impl.builtins.k.a.f12601b0;
        ba.c cVarH3 = bVarM3.h();
        ba.c cVarH4 = bVarM3.h();
        m.e(cVarH4, "kotlinReadOnly.packageFqName");
        a aVar2 = new a(cVar.g(Iterator.class), bVarM3, new ba.b(cVarH3, ba.e.g(cVar7, cVarH4), false));
        ba.b bVarM4 = ba.b.m(kotlin.reflect.jvm.internal.impl.builtins.k.a.V);
        m.e(bVarM4, "topLevel(FqNames.collection)");
        ba.c cVar8 = kotlin.reflect.jvm.internal.impl.builtins.k.a.f12605d0;
        ba.c cVarH5 = bVarM4.h();
        ba.c cVarH6 = bVarM4.h();
        m.e(cVarH6, "kotlinReadOnly.packageFqName");
        a aVar3 = new a(cVar.g(Collection.class), bVarM4, new ba.b(cVarH5, ba.e.g(cVar8, cVarH6), false));
        ba.b bVarM5 = ba.b.m(kotlin.reflect.jvm.internal.impl.builtins.k.a.W);
        m.e(bVarM5, "topLevel(FqNames.list)");
        ba.c cVar9 = kotlin.reflect.jvm.internal.impl.builtins.k.a.f12607e0;
        ba.c cVarH7 = bVarM5.h();
        ba.c cVarH8 = bVarM5.h();
        m.e(cVarH8, "kotlinReadOnly.packageFqName");
        a aVar4 = new a(cVar.g(List.class), bVarM5, new ba.b(cVarH7, ba.e.g(cVar9, cVarH8), false));
        ba.b bVarM6 = ba.b.m(kotlin.reflect.jvm.internal.impl.builtins.k.a.Y);
        m.e(bVarM6, "topLevel(FqNames.set)");
        ba.c cVar10 = kotlin.reflect.jvm.internal.impl.builtins.k.a.f12611g0;
        ba.c cVarH9 = bVarM6.h();
        ba.c cVarH10 = bVarM6.h();
        m.e(cVarH10, "kotlinReadOnly.packageFqName");
        a aVar5 = new a(cVar.g(Set.class), bVarM6, new ba.b(cVarH9, ba.e.g(cVar10, cVarH10), false));
        ba.b bVarM7 = ba.b.m(kotlin.reflect.jvm.internal.impl.builtins.k.a.X);
        m.e(bVarM7, "topLevel(FqNames.listIterator)");
        ba.c cVar11 = kotlin.reflect.jvm.internal.impl.builtins.k.a.f12609f0;
        ba.c cVarH11 = bVarM7.h();
        ba.c cVarH12 = bVarM7.h();
        m.e(cVarH12, "kotlinReadOnly.packageFqName");
        a aVar6 = new a(cVar.g(ListIterator.class), bVarM7, new ba.b(cVarH11, ba.e.g(cVar11, cVarH12), false));
        ba.c cVar12 = kotlin.reflect.jvm.internal.impl.builtins.k.a.Z;
        ba.b bVarM8 = ba.b.m(cVar12);
        m.e(bVarM8, "topLevel(FqNames.map)");
        ba.c cVar13 = kotlin.reflect.jvm.internal.impl.builtins.k.a.f12613h0;
        ba.c cVarH13 = bVarM8.h();
        ba.c cVarH14 = bVarM8.h();
        m.e(cVarH14, "kotlinReadOnly.packageFqName");
        a aVar7 = new a(cVar.g(Map.class), bVarM8, new ba.b(cVarH13, ba.e.g(cVar13, cVarH14), false));
        ba.b bVarD = ba.b.m(cVar12).d(kotlin.reflect.jvm.internal.impl.builtins.k.a.f12599a0.g());
        m.e(bVarD, "topLevel(FqNames.map).cr…mes.mapEntry.shortName())");
        ba.c cVar14 = kotlin.reflect.jvm.internal.impl.builtins.k.a.f12615i0;
        ba.c cVarH15 = bVarD.h();
        ba.c cVarH16 = bVarD.h();
        m.e(cVarH16, "kotlinReadOnly.packageFqName");
        List<a> listO = r.o(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, new a(cVar.g(Map.Entry.class), bVarD, new ba.b(cVarH15, ba.e.g(cVar14, cVarH16), false)));
        f12521q = listO;
        cVar.f(Object.class, kotlin.reflect.jvm.internal.impl.builtins.k.a.f12600b);
        cVar.f(String.class, kotlin.reflect.jvm.internal.impl.builtins.k.a.f12612h);
        cVar.f(CharSequence.class, kotlin.reflect.jvm.internal.impl.builtins.k.a.f12610g);
        cVar.e(Throwable.class, kotlin.reflect.jvm.internal.impl.builtins.k.a.f12638u);
        cVar.f(Cloneable.class, kotlin.reflect.jvm.internal.impl.builtins.k.a.f12604d);
        cVar.f(Number.class, kotlin.reflect.jvm.internal.impl.builtins.k.a.f12632r);
        cVar.e(Comparable.class, kotlin.reflect.jvm.internal.impl.builtins.k.a.f12640v);
        cVar.f(Enum.class, kotlin.reflect.jvm.internal.impl.builtins.k.a.f12634s);
        cVar.e(Annotation.class, kotlin.reflect.jvm.internal.impl.builtins.k.a.G);
        Iterator<a> it = listO.iterator();
        while (it.hasNext()) {
            f12505a.d(it.next());
        }
        for (fa.e eVar : fa.e.values()) {
            c cVar15 = f12505a;
            ba.b bVarM9 = ba.b.m(eVar.m());
            m.e(bVarM9, "topLevel(jvmType.wrapperFqName)");
            kotlin.reflect.jvm.internal.impl.builtins.i iVarL = eVar.l();
            m.e(iVarL, "jvmType.primitiveType");
            ba.b bVarM10 = ba.b.m(kotlin.reflect.jvm.internal.impl.builtins.k.c(iVarL));
            m.e(bVarM10, "topLevel(StandardNames.g…e(jvmType.primitiveType))");
            cVar15.a(bVarM9, bVarM10);
        }
        for (ba.b bVar : kotlin.reflect.jvm.internal.impl.builtins.c.f12458a.a()) {
            c cVar16 = f12505a;
            ba.b bVarM11 = ba.b.m(new ba.c("kotlin.jvm.internal." + bVar.j().f() + "CompanionObject"));
            m.e(bVarM11, "topLevel(FqName(\"kotlin.…g() + \"CompanionObject\"))");
            ba.b bVarD2 = bVar.d(ba.h.f945d);
            m.e(bVarD2, "classId.createNestedClas…AME_FOR_COMPANION_OBJECT)");
            cVar16.a(bVarM11, bVarD2);
        }
        for (int i10 = 0; i10 < 23; i10++) {
            c cVar17 = f12505a;
            ba.b bVarM12 = ba.b.m(new ba.c("kotlin.jvm.functions.Function" + i10));
            m.e(bVarM12, "topLevel(FqName(\"kotlin.…m.functions.Function$i\"))");
            cVar17.a(bVarM12, kotlin.reflect.jvm.internal.impl.builtins.k.a(i10));
            cVar17.c(new ba.c(f12507c + i10), f12512h);
        }
        for (int i11 = 0; i11 < 22; i11++) {
            m9.c cVar18 = m9.c.f15689e;
            f12505a.c(new ba.c((cVar18.i().toString() + '.' + cVar18.f()) + i11), f12512h);
        }
        c cVar19 = f12505a;
        ba.c cVarL = kotlin.reflect.jvm.internal.impl.builtins.k.a.f12602c.l();
        m.e(cVarL, "nothing.toSafe()");
        cVar19.c(cVarL, cVar19.g(Void.class));
    }

    private final void b(ba.b bVar, ba.b bVar2) {
        HashMap<ba.d, ba.b> map = f12515k;
        ba.d dVarJ = bVar.b().j();
        m.e(dVarJ, "javaClassId.asSingleFqName().toUnsafe()");
        map.put(dVarJ, bVar2);
    }

    private final void c(ba.c cVar, ba.b bVar) {
        HashMap<ba.d, ba.b> map = f12516l;
        ba.d dVarJ = cVar.j();
        m.e(dVarJ, "kotlinFqNameUnsafe.toUnsafe()");
        map.put(dVarJ, bVar);
    }

    public final ba.c h() {
        return f12511g;
    }

    public final List<a> i() {
        return f12521q;
    }

    public final boolean k(ba.d dVar) {
        return f12517m.containsKey(dVar);
    }

    public final boolean l(ba.d dVar) {
        return f12518n.containsKey(dVar);
    }

    public final ba.b m(ba.c fqName) {
        m.f(fqName, "fqName");
        return f12515k.get(fqName.j());
    }

    public final ba.b n(ba.d kotlinFqName) {
        m.f(kotlinFqName, "kotlinFqName");
        if (j(kotlinFqName, f12506b)) {
            return f12510f;
        }
        if (j(kotlinFqName, f12508d)) {
            return f12510f;
        }
        if (j(kotlinFqName, f12507c)) {
            return f12512h;
        }
        return j(kotlinFqName, f12509e) ? f12512h : f12516l.get(kotlinFqName);
    }

    public final ba.c o(ba.d dVar) {
        return f12517m.get(dVar);
    }

    public final ba.c p(ba.d dVar) {
        return f12518n.get(dVar);
    }

    private c() {
    }

    private final void a(ba.b bVar, ba.b bVar2) {
        b(bVar, bVar2);
        ba.c cVarB = bVar2.b();
        m.e(cVarB, "kotlinClassId.asSingleFqName()");
        c(cVarB, bVar);
    }

    private final void d(a aVar) {
        ba.b bVarA = aVar.a();
        ba.b bVarB = aVar.b();
        ba.b bVarC = aVar.c();
        a(bVarA, bVarB);
        ba.c cVarB = bVarC.b();
        m.e(cVarB, "mutableClassId.asSingleFqName()");
        c(cVarB, bVarA);
        f12519o.put(bVarC, bVarB);
        f12520p.put(bVarB, bVarC);
        ba.c cVarB2 = bVarB.b();
        m.e(cVarB2, "readOnlyClassId.asSingleFqName()");
        ba.c cVarB3 = bVarC.b();
        m.e(cVarB3, "mutableClassId.asSingleFqName()");
        HashMap<ba.d, ba.c> map = f12517m;
        ba.d dVarJ = bVarC.b().j();
        m.e(dVarJ, "mutableClassId.asSingleFqName().toUnsafe()");
        map.put(dVarJ, cVarB2);
        HashMap<ba.d, ba.c> map2 = f12518n;
        ba.d dVarJ2 = cVarB2.j();
        m.e(dVarJ2, "readOnlyFqName.toUnsafe()");
        map2.put(dVarJ2, cVarB3);
    }

    private final void e(Class<?> cls, ba.c cVar) {
        ba.b bVarG = g(cls);
        ba.b bVarM = ba.b.m(cVar);
        m.e(bVarM, "topLevel(kotlinFqName)");
        a(bVarG, bVarM);
    }

    private final void f(Class<?> cls, ba.d dVar) {
        ba.c cVarL = dVar.l();
        m.e(cVarL, "kotlinFqName.toSafe()");
        e(cls, cVarL);
    }

    private final ba.b g(Class<?> cls) {
        if (!cls.isPrimitive()) {
            cls.isArray();
        }
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            ba.b bVarM = ba.b.m(new ba.c(cls.getCanonicalName()));
            m.e(bVarM, "topLevel(FqName(clazz.canonicalName))");
            return bVarM;
        }
        ba.b bVarD = g(declaringClass).d(ba.f.l(cls.getSimpleName()));
        m.e(bVarD, "classId(outer).createNes…tifier(clazz.simpleName))");
        return bVarD;
    }

    private final boolean j(ba.d dVar, String str) {
        Integer numN;
        String strB = dVar.b();
        m.e(strB, "kotlinFqName.asString()");
        String strG0 = n.G0(strB, str, "");
        if (strG0.length() <= 0 || n.C0(strG0, '0', false, 2, null) || (numN = n.n(strG0)) == null || numN.intValue() < 23) {
            return false;
        }
        return true;
    }
}
