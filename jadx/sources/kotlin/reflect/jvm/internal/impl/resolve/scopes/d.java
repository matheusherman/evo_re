package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.r;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f13966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f13967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f13968e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f13969f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f13970g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f13971h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f13972i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f13973j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f13974k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f13975l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f13976m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f13977n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final d f13978o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final d f13979p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final d f13980q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final d f13981r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final d f13982s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final d f13983t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final d f13984u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final d f13985v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final d f13986w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final d f13987x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final List<a.C0255a> f13988y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final List<a.C0255a> f13989z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<c> f13990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f13991b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.resolve.scopes.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        private static final class C0255a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f13992a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f13993b;

            public C0255a(int i10, String name) {
                kotlin.jvm.internal.m.f(name, "name");
                this.f13992a = i10;
                this.f13993b = name;
            }

            public final int a() {
                return this.f13992a;
            }

            public final String b() {
                return this.f13993b;
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int j() {
            int i10 = d.f13967d;
            d.f13967d <<= 1;
            return i10;
        }

        public final int b() {
            return d.f13974k;
        }

        public final int c() {
            return d.f13975l;
        }

        public final int d() {
            return d.f13972i;
        }

        public final int e() {
            return d.f13968e;
        }

        public final int f() {
            return d.f13971h;
        }

        public final int g() {
            return d.f13969f;
        }

        public final int h() {
            return d.f13970g;
        }

        public final int i() {
            return d.f13973j;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(int i10, List<? extends c> excludes) {
        kotlin.jvm.internal.m.f(excludes, "excludes");
        this.f13990a = excludes;
        Iterator it = excludes.iterator();
        while (it.hasNext()) {
            i10 &= ~((c) it.next()).a();
        }
        this.f13991b = i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!kotlin.jvm.internal.m.a(d.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.DescriptorKindFilter");
        d dVar = (d) obj;
        return kotlin.jvm.internal.m.a(this.f13990a, dVar.f13990a) && this.f13991b == dVar.f13991b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        a.C0255a c0255a;
        a.C0255a c0255a2;
        a aVar = new a(null);
        f13966c = aVar;
        f13967d = 1;
        int iJ = aVar.j();
        f13968e = iJ;
        int iJ2 = aVar.j();
        f13969f = iJ2;
        int iJ3 = aVar.j();
        f13970g = iJ3;
        int iJ4 = aVar.j();
        f13971h = iJ4;
        int iJ5 = aVar.j();
        f13972i = iJ5;
        int iJ6 = aVar.j();
        f13973j = iJ6;
        int iJ7 = aVar.j() - 1;
        f13974k = iJ7;
        int i10 = iJ | iJ2 | iJ3;
        f13975l = i10;
        int i11 = iJ2 | iJ5 | iJ6;
        f13976m = i11;
        int i12 = iJ5 | iJ6;
        f13977n = i12;
        int i13 = 2;
        f13978o = new d(iJ7, 0 == true ? 1 : 0, i13, 0 == true ? 1 : 0);
        f13979p = new d(i12, 0 == true ? 1 : 0, i13, 0 == true ? 1 : 0);
        f13980q = new d(iJ, 0 == true ? 1 : 0, i13, 0 == true ? 1 : 0);
        f13981r = new d(iJ2, 0 == true ? 1 : 0, i13, 0 == true ? 1 : 0);
        f13982s = new d(iJ3, 0 == true ? 1 : 0, i13, 0 == true ? 1 : 0);
        f13983t = new d(i10, 0 == true ? 1 : 0, i13, 0 == true ? 1 : 0);
        f13984u = new d(iJ4, 0 == true ? 1 : 0, i13, 0 == true ? 1 : 0);
        f13985v = new d(iJ5, 0 == true ? 1 : 0, i13, 0 == true ? 1 : 0);
        f13986w = new d(iJ6, 0 == true ? 1 : 0, i13, 0 == true ? 1 : 0);
        f13987x = new d(i11, 0 == true ? 1 : 0, i13, 0 == true ? 1 : 0);
        Field[] fields = d.class.getFields();
        kotlin.jvm.internal.m.e(fields, "T::class.java.fields");
        ArrayList<Field> arrayList = new ArrayList();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                arrayList.add(field);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Field field2 : arrayList) {
            Object obj = field2.get(null);
            d dVar = obj instanceof d ? (d) obj : null;
            if (dVar != null) {
                int i14 = dVar.f13991b;
                String name = field2.getName();
                kotlin.jvm.internal.m.e(name, "field.name");
                c0255a2 = new a.C0255a(i14, name);
            } else {
                c0255a2 = null;
            }
            if (c0255a2 != null) {
                arrayList2.add(c0255a2);
            }
        }
        f13988y = arrayList2;
        Field[] fields2 = d.class.getFields();
        kotlin.jvm.internal.m.e(fields2, "T::class.java.fields");
        ArrayList arrayList3 = new ArrayList();
        for (Field field3 : fields2) {
            if (Modifier.isStatic(field3.getModifiers())) {
                arrayList3.add(field3);
            }
        }
        ArrayList<Field> arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (kotlin.jvm.internal.m.a(((Field) obj2).getType(), Integer.TYPE)) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for (Field field4 : arrayList4) {
            Object obj3 = field4.get(null);
            kotlin.jvm.internal.m.d(obj3, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue = ((Integer) obj3).intValue();
            if (iIntValue == ((-iIntValue) & iIntValue)) {
                String name2 = field4.getName();
                kotlin.jvm.internal.m.e(name2, "field.name");
                c0255a = new a.C0255a(iIntValue, name2);
            } else {
                c0255a = null;
            }
            if (c0255a != null) {
                arrayList5.add(c0255a);
            }
        }
        f13989z = arrayList5;
    }

    public final boolean a(int i10) {
        return (i10 & this.f13991b) != 0;
    }

    public int hashCode() {
        return (this.f13990a.hashCode() * 31) + this.f13991b;
    }

    public final List<c> l() {
        return this.f13990a;
    }

    public final int m() {
        return this.f13991b;
    }

    public final d n(int i10) {
        int i11 = i10 & this.f13991b;
        if (i11 == 0) {
            return null;
        }
        return new d(i11, this.f13990a);
    }

    public String toString() {
        Object next;
        Iterator<T> it = f13988y.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((a.C0255a) next).a() != this.f13991b);
        a.C0255a c0255a = (a.C0255a) next;
        String strB = c0255a != null ? c0255a.b() : null;
        if (strB == null) {
            List<a.C0255a> list = f13989z;
            ArrayList arrayList = new ArrayList();
            for (a.C0255a c0255a2 : list) {
                String strB2 = a(c0255a2.a()) ? c0255a2.b() : null;
                if (strB2 != null) {
                    arrayList.add(strB2);
                }
            }
            strB = r.q0(arrayList, " | ", null, null, 0, null, null, 62, null);
        }
        return "DescriptorKindFilter(" + strB + ", " + this.f13990a + ')';
    }

    public /* synthetic */ d(int i10, List list, int i11, kotlin.jvm.internal.g gVar) {
        this(i10, (i11 & 2) != 0 ? r.l() : list);
    }
}
