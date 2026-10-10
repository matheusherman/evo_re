package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.w1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ka.n f12976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h0 f12977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ka.g<ba.c, l0> f12978c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ka.g<a, e> f12979d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ba.b f12980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<Integer> f12981b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.jvm.internal.m.a(this.f12980a, aVar.f12980a) && kotlin.jvm.internal.m.a(this.f12981b, aVar.f12981b);
        }

        public a(ba.b classId, List<Integer> typeParametersCount) {
            kotlin.jvm.internal.m.f(classId, "classId");
            kotlin.jvm.internal.m.f(typeParametersCount, "typeParametersCount");
            this.f12980a = classId;
            this.f12981b = typeParametersCount;
        }

        public final ba.b a() {
            return this.f12980a;
        }

        public final List<Integer> b() {
            return this.f12981b;
        }

        public int hashCode() {
            return (this.f12980a.hashCode() * 31) + this.f12981b.hashCode();
        }

        public String toString() {
            return "ClassRequest(classId=" + this.f12980a + ", typeParametersCount=" + this.f12981b + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends kotlin.reflect.jvm.internal.impl.descriptors.impl.g {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final boolean f12982i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final List<f1> f12983j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.types.l f12984k;

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
        public boolean A0() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
        public boolean E0() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
        public boolean F() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
        public boolean I() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
        public kotlin.reflect.jvm.internal.impl.descriptors.d M() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
        public e P() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.g, kotlin.reflect.jvm.internal.impl.descriptors.d0
        public boolean isExternal() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
        public boolean isInline() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
        public boolean t() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
        public h1<kotlin.reflect.jvm.internal.impl.types.o0> v0() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
        public boolean x() {
            return false;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ka.n storageManager, m container, ba.f name, boolean z10, int i10) {
            super(storageManager, container, name, a1.f12668a, false);
            kotlin.jvm.internal.m.f(storageManager, "storageManager");
            kotlin.jvm.internal.m.f(container, "container");
            kotlin.jvm.internal.m.f(name, "name");
            this.f12982i = z10;
            h9.e eVarM = h9.f.m(0, i10);
            ArrayList arrayList = new ArrayList(kotlin.collections.r.w(eVarM, 10));
            Iterator<Integer> it = eVarM.iterator();
            while (it.hasNext()) {
                int iNextInt = ((kotlin.collections.k0) it).nextInt();
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVarB = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b();
                w1 w1Var = w1.INVARIANT;
                StringBuilder sb2 = new StringBuilder();
                sb2.append('T');
                sb2.append(iNextInt);
                arrayList.add(kotlin.reflect.jvm.internal.impl.descriptors.impl.k0.N0(this, gVarB, false, w1Var, ba.f.l(sb2.toString()), iNextInt, storageManager));
            }
            this.f12983j = arrayList;
            this.f12984k = new kotlin.reflect.jvm.internal.impl.types.l(this, g1.d(this), kotlin.collections.v0.d(ea.c.p(this).l().i()), storageManager);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
        /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
        public kotlin.reflect.jvm.internal.impl.resolve.scopes.h.b N() {
            return kotlin.reflect.jvm.internal.impl.resolve.scopes.h.b.f14005b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.h
        /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
        public kotlin.reflect.jvm.internal.impl.types.l h() {
            return this.f12984k;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.t
        /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
        public kotlin.reflect.jvm.internal.impl.resolve.scopes.h.b G(kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
            kotlin.jvm.internal.m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
            return kotlin.reflect.jvm.internal.impl.resolve.scopes.h.b.f14005b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.i
        public boolean J() {
            return this.f12982i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
        public f g() {
            return f.CLASS;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
        public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g getAnnotations() {
            return kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.q
        public u getVisibility() {
            u PUBLIC = t.f13068e;
            kotlin.jvm.internal.m.e(PUBLIC, "PUBLIC");
            return PUBLIC;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.d0
        public e0 i() {
            return e0.FINAL;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.i
        public List<f1> r() {
            return this.f12983j;
        }

        public String toString() {
            return "class " + getName() + " (not found)";
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
        public Collection<e> E() {
            return kotlin.collections.r.l();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
        public Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> k() {
            return kotlin.collections.v0.e();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends kotlin.jvm.internal.o implements c9.l<a, e> {
        c() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e invoke(a aVar) {
            m mVarD;
            kotlin.jvm.internal.m.f(aVar, "<name for destructuring parameter 0>");
            ba.b bVarA = aVar.a();
            List<Integer> listB = aVar.b();
            if (bVarA.k()) {
                throw new UnsupportedOperationException("Unresolved local class: " + bVarA);
            }
            ba.b bVarG = bVarA.g();
            if (bVarG == null || (mVarD = k0.this.d(bVarG, kotlin.collections.r.c0(listB, 1))) == null) {
                ka.g gVar = k0.this.f12978c;
                ba.c cVarH = bVarA.h();
                kotlin.jvm.internal.m.e(cVarH, "classId.packageFqName");
                mVarD = (g) gVar.invoke(cVarH);
            }
            m mVar = mVarD;
            boolean zL = bVarA.l();
            ka.n nVar = k0.this.f12976a;
            ba.f fVarJ = bVarA.j();
            kotlin.jvm.internal.m.e(fVarJ, "classId.shortClassName");
            Integer num = (Integer) kotlin.collections.r.i0(listB);
            return new b(nVar, mVar, fVarJ, zL, num != null ? num.intValue() : 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class d extends kotlin.jvm.internal.o implements c9.l<ba.c, l0> {
        d() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final l0 invoke(ba.c fqName) {
            kotlin.jvm.internal.m.f(fqName, "fqName");
            return new kotlin.reflect.jvm.internal.impl.descriptors.impl.m(k0.this.f12977b, fqName);
        }
    }

    public k0(ka.n storageManager, h0 module) {
        kotlin.jvm.internal.m.f(storageManager, "storageManager");
        kotlin.jvm.internal.m.f(module, "module");
        this.f12976a = storageManager;
        this.f12977b = module;
        this.f12978c = storageManager.f(new d());
        this.f12979d = storageManager.f(new c());
    }

    public final e d(ba.b classId, List<Integer> typeParametersCount) {
        kotlin.jvm.internal.m.f(classId, "classId");
        kotlin.jvm.internal.m.f(typeParametersCount, "typeParametersCount");
        return this.f12979d.invoke(new a(classId, typeParametersCount));
    }
}
