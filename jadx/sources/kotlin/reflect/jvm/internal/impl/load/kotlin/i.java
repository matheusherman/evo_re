package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import java.util.Set;
import kotlin.collections.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f13581b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Set<v9.a.EnumC0377a> f13582c = v0.d(v9.a.EnumC0377a.CLASS);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<v9.a.EnumC0377a> f13583d = v0.h(v9.a.EnumC0377a.FILE_FACADE, v9.a.EnumC0377a.MULTIFILE_CLASS_PART);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final aa.e f13584e = new aa.e(1, 1, 2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final aa.e f13585f = new aa.e(1, 1, 11);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final aa.e f13586g = new aa.e(1, 1, 13);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public kotlin.reflect.jvm.internal.impl.serialization.deserialization.k f13587a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }

        public final aa.e a() {
            return i.f13586g;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends kotlin.jvm.internal.o implements c9.a<Collection<? extends ba.f>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f13588a = new b();

        b() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection<ba.f> invoke() {
            return kotlin.collections.r.l();
        }
    }

    public final kotlin.reflect.jvm.internal.impl.resolve.scopes.h b(l0 descriptor, s kotlinClass) {
        r8.p<aa.f, w9.l> pVarM;
        kotlin.jvm.internal.m.f(descriptor, "descriptor");
        kotlin.jvm.internal.m.f(kotlinClass, "kotlinClass");
        String[] strArrK = k(kotlinClass, f13583d);
        if (strArrK == null) {
            return null;
        }
        String[] strArrG = kotlinClass.g().g();
        try {
            if (strArrG == null) {
                return null;
            }
            try {
                pVarM = aa.i.m(strArrK, strArrG);
            } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                throw new IllegalStateException("Could not read data from " + kotlinClass.f(), e10);
            }
        } catch (Throwable th) {
            if (g() || kotlinClass.g().d().h(f())) {
                throw th;
            }
            pVarM = null;
        }
        if (pVarM == null) {
            return null;
        }
        aa.f fVarA = pVarM.a();
        w9.l lVarB = pVarM.b();
        m mVar = new m(kotlinClass, lVarB, fVarA, e(kotlinClass), i(kotlinClass), c(kotlinClass));
        return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.i(descriptor, lVarB, fVarA, kotlinClass.g().d(), mVar, d(), "scope for " + mVar + " in " + descriptor, b.f13588a);
    }

    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.k d() {
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.k kVar = this.f13587a;
        if (kVar != null) {
            return kVar;
        }
        kotlin.jvm.internal.m.v("components");
        return null;
    }

    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.g j(s kotlinClass) {
        String[] strArrG;
        r8.p<aa.f, w9.c> pVarI;
        kotlin.jvm.internal.m.f(kotlinClass, "kotlinClass");
        String[] strArrK = k(kotlinClass, f13582c);
        if (strArrK == null || (strArrG = kotlinClass.g().g()) == null) {
            return null;
        }
        try {
            try {
                pVarI = aa.i.i(strArrK, strArrG);
            } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                throw new IllegalStateException("Could not read data from " + kotlinClass.f(), e10);
            }
        } catch (Throwable th) {
            if (g() || kotlinClass.g().d().h(f())) {
                throw th;
            }
            pVarI = null;
        }
        if (pVarI == null) {
            return null;
        }
        return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.g(pVarI.a(), pVarI.b(), kotlinClass.g().d(), new u(kotlinClass, e(kotlinClass), i(kotlinClass), c(kotlinClass)));
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.e l(s kotlinClass) {
        kotlin.jvm.internal.m.f(kotlinClass, "kotlinClass");
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.g gVarJ = j(kotlinClass);
        if (gVarJ == null) {
            return null;
        }
        return d().f().d(kotlinClass.e(), gVarJ);
    }

    public final void m(g components) {
        kotlin.jvm.internal.m.f(components, "components");
        n(components.a());
    }

    public final void n(kotlin.reflect.jvm.internal.impl.serialization.deserialization.k kVar) {
        kotlin.jvm.internal.m.f(kVar, "<set-?>");
        this.f13587a = kVar;
    }

    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e c(s sVar) {
        if (d().g().b()) {
            return kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e.STABLE;
        }
        if (sVar.g().j()) {
            return kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e.FIR_UNSTABLE;
        }
        if (sVar.g().k()) {
            return kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e.IR_UNSTABLE;
        }
        return kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e.STABLE;
    }

    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.s<aa.e> e(s sVar) {
        if (!g() && !sVar.g().d().h(f())) {
            return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.s<>(sVar.g().d(), aa.e.f177i, f(), f().k(sVar.g().d().j()), sVar.f(), sVar.e());
        }
        return null;
    }

    private final aa.e f() {
        return sa.c.a(d().g());
    }

    private final boolean g() {
        return d().g().e();
    }

    private final boolean h(s sVar) {
        if (!d().g().c() && sVar.g().i() && kotlin.jvm.internal.m.a(sVar.g().d(), f13585f)) {
            return true;
        }
        return false;
    }

    private final boolean i(s sVar) {
        if ((d().g().f() && (sVar.g().i() || kotlin.jvm.internal.m.a(sVar.g().d(), f13584e))) || h(sVar)) {
            return true;
        }
        return false;
    }

    private final String[] k(s sVar, Set<? extends v9.a.EnumC0377a> set) {
        v9.a aVarG = sVar.g();
        String[] strArrA = aVarG.a();
        if (strArrA == null) {
            strArrA = aVarG.b();
        }
        if (strArrA == null || !set.contains(aVarG.c())) {
            return null;
        }
        return strArrA;
    }
}
