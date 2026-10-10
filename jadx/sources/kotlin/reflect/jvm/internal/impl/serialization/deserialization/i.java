package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Iterator;
import java.util.Set;
import kotlin.collections.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.m0;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f14140c = new b(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<ba.b> f14141d = v0.d(ba.b.m(kotlin.reflect.jvm.internal.impl.builtins.k.a.f12604d.l()));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f14142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c9.l<a, kotlin.reflect.jvm.internal.impl.descriptors.e> f14143b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ba.b f14144a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final g f14145b;

        public a(ba.b classId, g gVar) {
            kotlin.jvm.internal.m.f(classId, "classId");
            this.f14144a = classId;
            this.f14145b = gVar;
        }

        public final g a() {
            return this.f14145b;
        }

        public final ba.b b() {
            return this.f14144a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && kotlin.jvm.internal.m.a(this.f14144a, ((a) obj).f14144a);
        }

        public int hashCode() {
            return this.f14144a.hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }

        private b() {
        }

        public final Set<ba.b> a() {
            return i.f14141d;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends kotlin.jvm.internal.o implements c9.l<a, kotlin.reflect.jvm.internal.impl.descriptors.e> {
        c() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.jvm.internal.impl.descriptors.e invoke(a key) {
            kotlin.jvm.internal.m.f(key, "key");
            return i.this.c(key);
        }
    }

    public i(k components) {
        kotlin.jvm.internal.m.f(components, "components");
        this.f14142a = components;
        this.f14143b = components.u().i(new c());
    }

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.e e(i iVar, ba.b bVar, g gVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            gVar = null;
        }
        return iVar.d(bVar, gVar);
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.e d(ba.b classId, g gVar) {
        kotlin.jvm.internal.m.f(classId, "classId");
        return this.f14143b.invoke(new a(classId, gVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.descriptors.e c(a aVar) {
        Object next;
        m mVarA;
        l0 l0Var;
        ba.f fVarJ;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.d dVar;
        ba.b bVarB = aVar.b();
        Iterator<n9.b> it = this.f14142a.k().iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.descriptors.e eVarB = it.next().b(bVarB);
            if (eVarB != null) {
                return eVarB;
            }
        }
        if (f14141d.contains(bVarB)) {
            return null;
        }
        g gVarA = aVar.a();
        if (gVarA == null && (gVarA = this.f14142a.e().a(bVarB)) == null) {
            return null;
        }
        y9.c cVarA = gVarA.a();
        w9.c cVarB = gVarA.b();
        y9.a aVarC = gVarA.c();
        a1 a1VarD = gVarA.d();
        ba.b bVarG = bVarB.g();
        if (bVarG != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.e eVarE = e(this, bVarG, null, 2, null);
            if (eVarE instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.d) {
                dVar = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.d) eVarE;
            } else {
                dVar = null;
            }
            if (dVar == null) {
                return null;
            }
            ba.f fVarJ2 = bVarB.j();
            kotlin.jvm.internal.m.e(fVarJ2, "classId.shortClassName");
            if (!dVar.c1(fVarJ2)) {
                return null;
            }
            mVarA = dVar.V0();
        } else {
            m0 m0VarR = this.f14142a.r();
            ba.c cVarH = bVarB.h();
            kotlin.jvm.internal.m.e(cVarH, "classId.packageFqName");
            Iterator<T> it2 = o0.c(m0VarR, cVarH).iterator();
            do {
                if (it2.hasNext()) {
                    next = it2.next();
                    l0Var = (l0) next;
                    if (!(l0Var instanceof o)) {
                        break;
                    }
                    fVarJ = bVarB.j();
                    kotlin.jvm.internal.m.e(fVarJ, "classId.shortClassName");
                } else {
                    next = null;
                    break;
                }
            } while (!((o) l0Var).G0(fVarJ));
            l0 l0Var2 = (l0) next;
            if (l0Var2 == null) {
                return null;
            }
            k kVar = this.f14142a;
            w9.t tVarH1 = cVarB.h1();
            kotlin.jvm.internal.m.e(tVarH1, "classProto.typeTable");
            y9.g gVar = new y9.g(tVarH1);
            y9.h.a aVar2 = y9.h.f22527b;
            w9.w wVarJ1 = cVarB.j1();
            kotlin.jvm.internal.m.e(wVarJ1, "classProto.versionRequirementTable");
            mVarA = kVar.a(l0Var2, cVarA, gVar, aVar2.a(wVarJ1), aVarC, null);
            aVarC = aVarC;
        }
        return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.d(mVarA, cVarB, cVarA, aVarC, a1VarD);
    }
}
