package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.c0;
import kotlin.reflect.jvm.internal.impl.types.c1;
import kotlin.reflect.jvm.internal.impl.types.d0;
import kotlin.reflect.jvm.internal.impl.types.f0;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.s0;
import kotlin.reflect.jvm.internal.impl.types.v1;
import kotlin.reflect.jvm.internal.impl.types.w0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f14262a = new w();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f14263a = new c("START", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f14264b = new C0267a("ACCEPT_NULL", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f14265c = new d("UNKNOWN", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f14266d = new b("NOT_NULL", 3);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ a[] f14267e = a();

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.types.checker.w$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class C0267a extends a {
            C0267a(String str, int i10) {
                super(str, i10, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.w.a
            public a f(v1 nextType) {
                kotlin.jvm.internal.m.f(nextType, "nextType");
                return i(nextType);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class b extends a {
            b(String str, int i10) {
                super(str, i10, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.w.a
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public b f(v1 nextType) {
                kotlin.jvm.internal.m.f(nextType, "nextType");
                return this;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class c extends a {
            c(String str, int i10) {
                super(str, i10, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.w.a
            public a f(v1 nextType) {
                kotlin.jvm.internal.m.f(nextType, "nextType");
                return i(nextType);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class d extends a {
            d(String str, int i10) {
                super(str, i10, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.w.a
            public a f(v1 nextType) {
                kotlin.jvm.internal.m.f(nextType, "nextType");
                a aVarI = i(nextType);
                return aVarI == a.f14264b ? this : aVarI;
            }
        }

        public /* synthetic */ a(String str, int i10, kotlin.jvm.internal.g gVar) {
            this(str, i10);
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{f14263a, f14264b, f14265c, f14266d};
        }

        public abstract a f(v1 v1Var);

        private a(String str, int i10) {
            super(str, i10);
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f14267e.clone();
        }

        protected final a i(v1 v1Var) {
            kotlin.jvm.internal.m.f(v1Var, "<this>");
            if (v1Var.K0()) {
                return f14264b;
            }
            if ((v1Var instanceof kotlin.reflect.jvm.internal.impl.types.p) && (((kotlin.reflect.jvm.internal.impl.types.p) v1Var).V0() instanceof w0)) {
                return f14266d;
            }
            if (v1Var instanceof w0) {
                return f14265c;
            }
            return o.f14256a.a(v1Var) ? f14266d : f14265c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends kotlin.jvm.internal.o implements c9.a<String> {
        final /* synthetic */ Set<o0> $inputTypes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(Set<? extends o0> set) {
            super(0);
            this.$inputTypes = set;
        }

        @Override // c9.a
        public final String invoke() {
            return "This collections cannot be empty! input types: " + kotlin.collections.r.q0(this.$inputTypes, null, null, null, 0, null, null, 63, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    /* synthetic */ class c extends kotlin.jvm.internal.j implements c9.p<g0, g0, Boolean> {
        c(Object obj) {
            super(2, obj);
        }

        @Override // kotlin.jvm.internal.c, i9.c
        public final String getName() {
            return "isStrictSupertype";
        }

        @Override // kotlin.jvm.internal.c
        public final i9.f getOwner() {
            return c0.b(w.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "isStrictSupertype(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
        }

        @Override // c9.p
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(g0 p10, g0 p11) {
            kotlin.jvm.internal.m.f(p10, "p0");
            kotlin.jvm.internal.m.f(p11, "p1");
            return Boolean.valueOf(((w) this.receiver).e(p10, p11));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    /* synthetic */ class d extends kotlin.jvm.internal.j implements c9.p<g0, g0, Boolean> {
        d(Object obj) {
            super(2, obj);
        }

        @Override // kotlin.jvm.internal.c, i9.c
        public final String getName() {
            return "equalTypes";
        }

        @Override // kotlin.jvm.internal.c
        public final i9.f getOwner() {
            return c0.b(m.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "equalTypes(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
        }

        @Override // c9.p
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(g0 p10, g0 p11) {
            kotlin.jvm.internal.m.f(p10, "p0");
            kotlin.jvm.internal.m.f(p11, "p1");
            return Boolean.valueOf(((m) this.receiver).b(p10, p11));
        }
    }

    private final Collection<o0> b(Collection<? extends o0> collection, c9.p<? super o0, ? super o0, Boolean> pVar) {
        ArrayList<o0> arrayList = new ArrayList(collection);
        Iterator it = arrayList.iterator();
        kotlin.jvm.internal.m.e(it, "filteredTypes.iterator()");
        while (it.hasNext()) {
            o0 upper = (o0) it.next();
            if (!arrayList.isEmpty()) {
                for (o0 lower : arrayList) {
                    if (lower != upper) {
                        kotlin.jvm.internal.m.e(lower, "lower");
                        kotlin.jvm.internal.m.e(upper, "upper");
                        if (pVar.invoke(lower, upper).booleanValue()) {
                            it.remove();
                            break;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e(g0 g0Var, g0 g0Var2) {
        m mVarA = l.f14250b.a();
        return mVarA.d(g0Var, g0Var2) && !mVarA.d(g0Var2, g0Var);
    }

    public final o0 c(List<? extends o0> types) {
        kotlin.jvm.internal.m.f(types, "types");
        types.size();
        ArrayList<o0> arrayList = new ArrayList();
        for (o0 o0Var : types) {
            if (o0Var.J0() instanceof f0) {
                Collection<g0> collectionB = o0Var.J0().b();
                kotlin.jvm.internal.m.e(collectionB, "type.constructor.supertypes");
                Collection<g0> collection = collectionB;
                ArrayList arrayList2 = new ArrayList(kotlin.collections.r.w(collection, 10));
                for (g0 it : collection) {
                    kotlin.jvm.internal.m.e(it, "it");
                    o0 o0VarD = d0.d(it);
                    if (o0Var.K0()) {
                        o0VarD = o0VarD.N0(true);
                    }
                    arrayList2.add(o0VarD);
                }
                arrayList.addAll(arrayList2);
            } else {
                arrayList.add(o0Var);
            }
        }
        a aVarF = a.f14263a;
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            aVarF = aVarF.f((v1) it2.next());
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (o0 o0VarI : arrayList) {
            if (aVarF == a.f14266d) {
                if (o0VarI instanceof i) {
                    o0VarI = s0.k((i) o0VarI);
                }
                o0VarI = s0.i(o0VarI, false, 1, null);
            }
            linkedHashSet.add(o0VarI);
        }
        List<? extends o0> list = types;
        ArrayList arrayList3 = new ArrayList(kotlin.collections.r.w(list, 10));
        Iterator<T> it3 = list.iterator();
        while (it3.hasNext()) {
            arrayList3.add(((o0) it3.next()).I0());
        }
        Iterator it4 = arrayList3.iterator();
        if (!it4.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        Object next = it4.next();
        while (it4.hasNext()) {
            next = ((c1) next).n((c1) it4.next());
        }
        return d(linkedHashSet).P0((c1) next);
    }

    private w() {
    }

    private final o0 d(Set<? extends o0> set) {
        if (set.size() == 1) {
            return (o0) kotlin.collections.r.E0(set);
        }
        new b(set);
        Collection<o0> collectionB = b(set, new c(this));
        collectionB.isEmpty();
        o0 o0VarB = kotlin.reflect.jvm.internal.impl.resolve.constants.n.f13904f.b(collectionB);
        if (o0VarB != null) {
            return o0VarB;
        }
        Collection<o0> collectionB2 = b(collectionB, new d(l.f14250b.a()));
        collectionB2.isEmpty();
        if (collectionB2.size() < 2) {
            return (o0) kotlin.collections.r.E0(collectionB2);
        }
        return new f0(set).h();
    }
}
