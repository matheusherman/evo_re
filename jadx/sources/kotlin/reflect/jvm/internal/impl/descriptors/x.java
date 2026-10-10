package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class x {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    /* synthetic */ class a extends kotlin.jvm.internal.j implements c9.l<ba.b, ba.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f13082a = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.internal.c, i9.c
        public final String getName() {
            return "getOuterClassId";
        }

        @Override // kotlin.jvm.internal.c
        public final i9.f getOwner() {
            return kotlin.jvm.internal.c0.b(ba.b.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
        }

        @Override // c9.l
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public final ba.b invoke(ba.b p10) {
            kotlin.jvm.internal.m.f(p10, "p0");
            return p10.g();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends kotlin.jvm.internal.o implements c9.l<ba.b, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f13083a = new b();

        b() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke(ba.b it) {
            kotlin.jvm.internal.m.f(it, "it");
            return 0;
        }
    }

    public static final e a(h0 h0Var, ba.b classId) {
        kotlin.jvm.internal.m.f(h0Var, "<this>");
        kotlin.jvm.internal.m.f(classId, "classId");
        h hVarB = b(h0Var, classId);
        if (hVarB instanceof e) {
            return (e) hVarB;
        }
        return null;
    }

    public static final h b(h0 h0Var, ba.b classId) {
        kotlin.jvm.internal.m.f(h0Var, "<this>");
        kotlin.jvm.internal.m.f(classId, "classId");
        h0 h0VarA = kotlin.reflect.jvm.internal.impl.resolve.o.a(h0Var);
        if (h0VarA == null) {
            ba.c cVarH = classId.h();
            kotlin.jvm.internal.m.e(cVarH, "classId.packageFqName");
            q0 q0VarU = h0Var.U(cVarH);
            List<ba.f> listF = classId.i().f();
            kotlin.jvm.internal.m.e(listF, "classId.relativeClassName.pathSegments()");
            kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarN = q0VarU.n();
            Object objG0 = kotlin.collections.r.g0(listF);
            kotlin.jvm.internal.m.e(objG0, "segments.first()");
            h hVarE = hVarN.e((ba.f) objG0, r9.d.FROM_DESERIALIZATION);
            if (hVarE == null) {
                return null;
            }
            for (ba.f name : listF.subList(1, listF.size())) {
                if (!(hVarE instanceof e)) {
                    return null;
                }
                kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarU0 = ((e) hVarE).u0();
                kotlin.jvm.internal.m.e(name, "name");
                h hVarE2 = hVarU0.e(name, r9.d.FROM_DESERIALIZATION);
                hVarE = hVarE2 instanceof e ? (e) hVarE2 : null;
                if (hVarE == null) {
                    return null;
                }
            }
            return hVarE;
        }
        ba.c cVarH2 = classId.h();
        kotlin.jvm.internal.m.e(cVarH2, "classId.packageFqName");
        q0 q0VarU2 = h0VarA.U(cVarH2);
        List<ba.f> listF2 = classId.i().f();
        kotlin.jvm.internal.m.e(listF2, "classId.relativeClassName.pathSegments()");
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarN2 = q0VarU2.n();
        Object objG1 = kotlin.collections.r.g0(listF2);
        kotlin.jvm.internal.m.e(objG1, "segments.first()");
        h hVarE3 = hVarN2.e((ba.f) objG1, r9.d.FROM_DESERIALIZATION);
        if (hVarE3 == null) {
            hVarE3 = null;
            break;
        }
        for (ba.f name2 : listF2.subList(1, listF2.size())) {
            if (hVarE3 instanceof e) {
                kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarU1 = ((e) hVarE3).u0();
                kotlin.jvm.internal.m.e(name2, "name");
                h hVarE4 = hVarU1.e(name2, r9.d.FROM_DESERIALIZATION);
                hVarE3 = hVarE4 instanceof e ? (e) hVarE4 : null;
                if (hVarE3 != null) {
                }
            }
            hVarE3 = null;
        }
        if (hVarE3 != null) {
            return hVarE3;
        }
        ba.c cVarH3 = classId.h();
        kotlin.jvm.internal.m.e(cVarH3, "classId.packageFqName");
        q0 q0VarU3 = h0Var.U(cVarH3);
        List<ba.f> listF3 = classId.i().f();
        kotlin.jvm.internal.m.e(listF3, "classId.relativeClassName.pathSegments()");
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarN3 = q0VarU3.n();
        Object objG2 = kotlin.collections.r.g0(listF3);
        kotlin.jvm.internal.m.e(objG2, "segments.first()");
        h hVarE5 = hVarN3.e((ba.f) objG2, r9.d.FROM_DESERIALIZATION);
        if (hVarE5 == null) {
            return null;
        }
        for (ba.f name3 : listF3.subList(1, listF3.size())) {
            if (!(hVarE5 instanceof e)) {
                return null;
            }
            kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarU2 = ((e) hVarE5).u0();
            kotlin.jvm.internal.m.e(name3, "name");
            h hVarE6 = hVarU2.e(name3, r9.d.FROM_DESERIALIZATION);
            hVarE5 = hVarE6 instanceof e ? (e) hVarE6 : null;
            if (hVarE5 == null) {
                return null;
            }
        }
        return hVarE5;
    }

    public static final e c(h0 h0Var, ba.b classId, k0 notFoundClasses) {
        kotlin.jvm.internal.m.f(h0Var, "<this>");
        kotlin.jvm.internal.m.f(classId, "classId");
        kotlin.jvm.internal.m.f(notFoundClasses, "notFoundClasses");
        e eVarA = a(h0Var, classId);
        return eVarA != null ? eVarA : notFoundClasses.d(classId, ta.k.P(ta.k.J(ta.k.o(classId, a.f13082a), b.f13083a)));
    }

    public static final e1 d(h0 h0Var, ba.b classId) {
        kotlin.jvm.internal.m.f(h0Var, "<this>");
        kotlin.jvm.internal.m.f(classId, "classId");
        h hVarB = b(h0Var, classId);
        if (hVarB instanceof e1) {
            return (e1) hVarB;
        }
        return null;
    }
}
