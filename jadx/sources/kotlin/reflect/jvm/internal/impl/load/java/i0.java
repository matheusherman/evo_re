package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.n0;
import kotlin.collections.v0;
import org.apache.log4j.helpers.DateLayout;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13217a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<a.C0226a> f13218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List<String> f13219c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List<String> f13220d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map<a.C0226a, c> f13221e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Map<String, c> f13222f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Set<ba.f> f13223g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Set<String> f13224h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final a.C0226a f13225i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Map<a.C0226a, ba.f> f13226j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Map<String, ba.f> f13227k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final List<ba.f> f13228l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Map<ba.f, ba.f> f13229m;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.load.java.i0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class C0226a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final ba.f f13230a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f13231b;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0226a)) {
                    return false;
                }
                C0226a c0226a = (C0226a) obj;
                return kotlin.jvm.internal.m.a(this.f13230a, c0226a.f13230a) && kotlin.jvm.internal.m.a(this.f13231b, c0226a.f13231b);
            }

            public C0226a(ba.f name, String signature) {
                kotlin.jvm.internal.m.f(name, "name");
                kotlin.jvm.internal.m.f(signature, "signature");
                this.f13230a = name;
                this.f13231b = signature;
            }

            public final ba.f a() {
                return this.f13230a;
            }

            public final String b() {
                return this.f13231b;
            }

            public int hashCode() {
                return (this.f13230a.hashCode() * 31) + this.f13231b.hashCode();
            }

            public String toString() {
                return "NameAndSignature(name=" + this.f13230a + ", signature=" + this.f13231b + ')';
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final C0226a m(String str, String str2, String str3, String str4) {
            ba.f fVarL = ba.f.l(str2);
            kotlin.jvm.internal.m.e(fVarL, "identifier(name)");
            return new C0226a(fVarL, kotlin.reflect.jvm.internal.impl.load.kotlin.z.f13623a.k(str, str2 + '(' + str3 + ')' + str4));
        }

        public final ba.f b(ba.f name) {
            kotlin.jvm.internal.m.f(name, "name");
            return f().get(name);
        }

        public final boolean k(ba.f fVar) {
            kotlin.jvm.internal.m.f(fVar, "<this>");
            return g().contains(fVar);
        }

        public final b l(String builtinSignature) {
            kotlin.jvm.internal.m.f(builtinSignature, "builtinSignature");
            if (c().contains(builtinSignature)) {
                return b.ONE_COLLECTION_PARAMETER;
            }
            return ((c) n0.j(i(), builtinSignature)) == c.f13236a ? b.OBJECT_PARAMETER_GENERIC : b.OBJECT_PARAMETER_NON_GENERIC;
        }

        public final List<String> c() {
            return i0.f13219c;
        }

        public final Set<ba.f> d() {
            return i0.f13223g;
        }

        public final Set<String> e() {
            return i0.f13224h;
        }

        public final Map<ba.f, ba.f> f() {
            return i0.f13229m;
        }

        public final List<ba.f> g() {
            return i0.f13228l;
        }

        public final C0226a h() {
            return i0.f13225i;
        }

        public final Map<String, c> i() {
            return i0.f13222f;
        }

        public final Map<String, ba.f> j() {
            return i0.f13227k;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f13236a = new c(DateLayout.NULL_DATE_FORMAT, 0, null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f13237b = new c("INDEX", 1, -1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f13238c = new c("FALSE", 2, Boolean.FALSE);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f13239d = new a("MAP_GET_OR_DEFAULT", 3);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ c[] f13240e = a();
        private final Object defaultValue;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class a extends c {
            /* JADX WARN: Illegal instructions before constructor call */
            a(String str, int i10) {
                kotlin.jvm.internal.g gVar = null;
                super(str, i10, gVar, gVar);
            }
        }

        public /* synthetic */ c(String str, int i10, Object obj, kotlin.jvm.internal.g gVar) {
            this(str, i10, obj);
        }

        private static final /* synthetic */ c[] a() {
            return new c[]{f13236a, f13237b, f13238c, f13239d};
        }

        private c(String str, int i10, Object obj) {
            super(str, i10);
            this.defaultValue = obj;
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) f13240e.clone();
        }
    }

    static {
        Set<String> setH = v0.h("containsAll", "removeAll", "retainAll");
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(setH, 10));
        for (String str : setH) {
            a aVar = f13217a;
            String strJ = fa.e.BOOLEAN.j();
            kotlin.jvm.internal.m.e(strJ, "BOOLEAN.desc");
            arrayList.add(aVar.m("java/util/Collection", str, "Ljava/util/Collection;", strJ));
        }
        f13218b = arrayList;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(kotlin.collections.r.w(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((a.C0226a) it.next()).b());
        }
        f13219c = arrayList3;
        List<a.C0226a> list = f13218b;
        ArrayList arrayList4 = new ArrayList(kotlin.collections.r.w(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList4.add(((a.C0226a) it2.next()).a().f());
        }
        f13220d = arrayList4;
        kotlin.reflect.jvm.internal.impl.load.kotlin.z zVar = kotlin.reflect.jvm.internal.impl.load.kotlin.z.f13623a;
        a aVar2 = f13217a;
        String strI = zVar.i("Collection");
        fa.e eVar = fa.e.BOOLEAN;
        String strJ2 = eVar.j();
        kotlin.jvm.internal.m.e(strJ2, "BOOLEAN.desc");
        a.C0226a c0226aM = aVar2.m(strI, "contains", "Ljava/lang/Object;", strJ2);
        c cVar = c.f13238c;
        r8.p pVarA = r8.v.a(c0226aM, cVar);
        String strI2 = zVar.i("Collection");
        String strJ3 = eVar.j();
        kotlin.jvm.internal.m.e(strJ3, "BOOLEAN.desc");
        r8.p pVarA2 = r8.v.a(aVar2.m(strI2, "remove", "Ljava/lang/Object;", strJ3), cVar);
        String strI3 = zVar.i("Map");
        String strJ4 = eVar.j();
        kotlin.jvm.internal.m.e(strJ4, "BOOLEAN.desc");
        r8.p pVarA3 = r8.v.a(aVar2.m(strI3, "containsKey", "Ljava/lang/Object;", strJ4), cVar);
        String strI4 = zVar.i("Map");
        String strJ5 = eVar.j();
        kotlin.jvm.internal.m.e(strJ5, "BOOLEAN.desc");
        r8.p pVarA4 = r8.v.a(aVar2.m(strI4, "containsValue", "Ljava/lang/Object;", strJ5), cVar);
        String strI5 = zVar.i("Map");
        String strJ6 = eVar.j();
        kotlin.jvm.internal.m.e(strJ6, "BOOLEAN.desc");
        r8.p pVarA5 = r8.v.a(aVar2.m(strI5, "remove", "Ljava/lang/Object;Ljava/lang/Object;", strJ6), cVar);
        r8.p pVarA6 = r8.v.a(aVar2.m(zVar.i("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), c.f13239d);
        a.C0226a c0226aM2 = aVar2.m(zVar.i("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;");
        c cVar2 = c.f13236a;
        r8.p pVarA7 = r8.v.a(c0226aM2, cVar2);
        r8.p pVarA8 = r8.v.a(aVar2.m(zVar.i("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), cVar2);
        String strI6 = zVar.i("List");
        fa.e eVar2 = fa.e.INT;
        String strJ7 = eVar2.j();
        kotlin.jvm.internal.m.e(strJ7, "INT.desc");
        a.C0226a c0226aM3 = aVar2.m(strI6, "indexOf", "Ljava/lang/Object;", strJ7);
        c cVar3 = c.f13237b;
        r8.p pVarA9 = r8.v.a(c0226aM3, cVar3);
        String strI7 = zVar.i("List");
        String strJ8 = eVar2.j();
        kotlin.jvm.internal.m.e(strJ8, "INT.desc");
        Map<a.C0226a, c> mapL = n0.l(pVarA, pVarA2, pVarA3, pVarA4, pVarA5, pVarA6, pVarA7, pVarA8, pVarA9, r8.v.a(aVar2.m(strI7, "lastIndexOf", "Ljava/lang/Object;", strJ8), cVar3));
        f13221e = mapL;
        LinkedHashMap linkedHashMap = new LinkedHashMap(n0.e(mapL.size()));
        Iterator<T> it3 = mapL.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it3.next();
            linkedHashMap.put(((a.C0226a) entry.getKey()).b(), entry.getValue());
        }
        f13222f = linkedHashMap;
        Set setK = v0.k(f13221e.keySet(), f13218b);
        ArrayList arrayList5 = new ArrayList(kotlin.collections.r.w(setK, 10));
        Iterator it4 = setK.iterator();
        while (it4.hasNext()) {
            arrayList5.add(((a.C0226a) it4.next()).a());
        }
        f13223g = kotlin.collections.r.S0(arrayList5);
        ArrayList arrayList6 = new ArrayList(kotlin.collections.r.w(setK, 10));
        Iterator it5 = setK.iterator();
        while (it5.hasNext()) {
            arrayList6.add(((a.C0226a) it5.next()).b());
        }
        f13224h = kotlin.collections.r.S0(arrayList6);
        a aVar3 = f13217a;
        fa.e eVar3 = fa.e.INT;
        String strJ9 = eVar3.j();
        kotlin.jvm.internal.m.e(strJ9, "INT.desc");
        a.C0226a c0226aM4 = aVar3.m("java/util/List", "removeAt", strJ9, "Ljava/lang/Object;");
        f13225i = c0226aM4;
        kotlin.reflect.jvm.internal.impl.load.kotlin.z zVar2 = kotlin.reflect.jvm.internal.impl.load.kotlin.z.f13623a;
        String strH = zVar2.h("Number");
        String strJ10 = fa.e.BYTE.j();
        kotlin.jvm.internal.m.e(strJ10, "BYTE.desc");
        r8.p pVarA10 = r8.v.a(aVar3.m(strH, "toByte", "", strJ10), ba.f.l("byteValue"));
        String strH2 = zVar2.h("Number");
        String strJ11 = fa.e.SHORT.j();
        kotlin.jvm.internal.m.e(strJ11, "SHORT.desc");
        r8.p pVarA11 = r8.v.a(aVar3.m(strH2, "toShort", "", strJ11), ba.f.l("shortValue"));
        String strH3 = zVar2.h("Number");
        String strJ12 = eVar3.j();
        kotlin.jvm.internal.m.e(strJ12, "INT.desc");
        r8.p pVarA12 = r8.v.a(aVar3.m(strH3, "toInt", "", strJ12), ba.f.l("intValue"));
        String strH4 = zVar2.h("Number");
        String strJ13 = fa.e.LONG.j();
        kotlin.jvm.internal.m.e(strJ13, "LONG.desc");
        r8.p pVarA13 = r8.v.a(aVar3.m(strH4, "toLong", "", strJ13), ba.f.l("longValue"));
        String strH5 = zVar2.h("Number");
        String strJ14 = fa.e.FLOAT.j();
        kotlin.jvm.internal.m.e(strJ14, "FLOAT.desc");
        r8.p pVarA14 = r8.v.a(aVar3.m(strH5, "toFloat", "", strJ14), ba.f.l("floatValue"));
        String strH6 = zVar2.h("Number");
        String strJ15 = fa.e.DOUBLE.j();
        kotlin.jvm.internal.m.e(strJ15, "DOUBLE.desc");
        r8.p pVarA15 = r8.v.a(aVar3.m(strH6, "toDouble", "", strJ15), ba.f.l("doubleValue"));
        r8.p pVarA16 = r8.v.a(c0226aM4, ba.f.l("remove"));
        String strH7 = zVar2.h("CharSequence");
        String strJ16 = eVar3.j();
        kotlin.jvm.internal.m.e(strJ16, "INT.desc");
        String strJ17 = fa.e.CHAR.j();
        kotlin.jvm.internal.m.e(strJ17, "CHAR.desc");
        Map<a.C0226a, ba.f> mapL2 = n0.l(pVarA10, pVarA11, pVarA12, pVarA13, pVarA14, pVarA15, pVarA16, r8.v.a(aVar3.m(strH7, "get", strJ16, strJ17), ba.f.l("charAt")));
        f13226j = mapL2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(n0.e(mapL2.size()));
        Iterator<T> it6 = mapL2.entrySet().iterator();
        while (it6.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it6.next();
            linkedHashMap2.put(((a.C0226a) entry2.getKey()).b(), entry2.getValue());
        }
        f13227k = linkedHashMap2;
        Set<a.C0226a> setKeySet = f13226j.keySet();
        ArrayList arrayList7 = new ArrayList(kotlin.collections.r.w(setKeySet, 10));
        Iterator<T> it7 = setKeySet.iterator();
        while (it7.hasNext()) {
            arrayList7.add(((a.C0226a) it7.next()).a());
        }
        f13228l = arrayList7;
        Set<Map.Entry<a.C0226a, ba.f>> setEntrySet = f13226j.entrySet();
        ArrayList<r8.p> arrayList8 = new ArrayList(kotlin.collections.r.w(setEntrySet, 10));
        Iterator<T> it8 = setEntrySet.iterator();
        while (it8.hasNext()) {
            Map.Entry entry3 = (Map.Entry) it8.next();
            arrayList8.add(new r8.p(((a.C0226a) entry3.getKey()).a(), entry3.getValue()));
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(h9.f.c(n0.e(kotlin.collections.r.w(arrayList8, 10)), 16));
        for (r8.p pVar : arrayList8) {
            linkedHashMap3.put((ba.f) pVar.d(), (ba.f) pVar.c());
        }
        f13229m = linkedHashMap3;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum b {
        ONE_COLLECTION_PARAMETER("Ljava/util/Collection<+Ljava/lang/Object;>;", false),
        OBJECT_PARAMETER_NON_GENERIC(null, true),
        OBJECT_PARAMETER_GENERIC("Ljava/lang/Object;", true);

        private final boolean isObjectReplacedWithTypeParameter;
        private final String valueParametersSignature;

        b(String str, boolean z10) {
            this.valueParametersSignature = str;
            this.isObjectReplacedWithTypeParameter = z10;
        }
    }
}
