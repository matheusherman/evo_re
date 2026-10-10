package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.k1;
import kotlin.reflect.jvm.internal.impl.types.v1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class j implements kotlin.reflect.jvm.internal.impl.resolve.calls.inference.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k1 f14245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c9.a<? extends List<? extends v1>> f14246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j f14247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f1 f14248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final r8.i f14249e;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends kotlin.jvm.internal.o implements c9.a<List<? extends v1>> {
        final /* synthetic */ List<v1> $supertypes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(List<? extends v1> list) {
            super(0);
            this.$supertypes = list;
        }

        @Override // c9.a
        public final List<? extends v1> invoke() {
            return this.$supertypes;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends kotlin.jvm.internal.o implements c9.a<List<? extends v1>> {
        b() {
            super(0);
        }

        @Override // c9.a
        public final List<? extends v1> invoke() {
            c9.a aVar = j.this.f14246b;
            if (aVar != null) {
                return (List) aVar.invoke();
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends kotlin.jvm.internal.o implements c9.a<List<? extends v1>> {
        final /* synthetic */ List<v1> $supertypes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(List<? extends v1> list) {
            super(0);
            this.$supertypes = list;
        }

        @Override // c9.a
        public final List<? extends v1> invoke() {
            return this.$supertypes;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class d extends kotlin.jvm.internal.o implements c9.a<List<? extends v1>> {
        final /* synthetic */ g $kotlinTypeRefiner;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(g gVar) {
            super(0);
            this.$kotlinTypeRefiner = gVar;
        }

        @Override // c9.a
        public final List<? extends v1> invoke() {
            List<v1> listB = j.this.b();
            g gVar = this.$kotlinTypeRefiner;
            ArrayList arrayList = new ArrayList(kotlin.collections.r.w(listB, 10));
            Iterator<T> it = listB.iterator();
            while (it.hasNext()) {
                arrayList.add(((v1) it.next()).T0(gVar));
            }
            return arrayList;
        }
    }

    public j(k1 projection, c9.a<? extends List<? extends v1>> aVar, j jVar, f1 f1Var) {
        kotlin.jvm.internal.m.f(projection, "projection");
        this.f14245a = projection;
        this.f14246b = aVar;
        this.f14247c = jVar;
        this.f14248d = f1Var;
        this.f14249e = r8.j.b(r8.m.PUBLICATION, new b());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    public kotlin.reflect.jvm.internal.impl.descriptors.h d() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    public boolean e() {
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!kotlin.jvm.internal.m.a(j.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
        j jVar = (j) obj;
        j jVar2 = this.f14247c;
        if (jVar2 == null) {
            jVar2 = this;
        }
        j jVar3 = jVar.f14247c;
        if (jVar3 != null) {
            jVar = jVar3;
        }
        return jVar2 == jVar;
    }

    private final List<v1> i() {
        return (List) this.f14249e.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.calls.inference.b
    public k1 f() {
        return this.f14245a;
    }

    public int hashCode() {
        j jVar = this.f14247c;
        return jVar != null ? jVar.hashCode() : super.hashCode();
    }

    public final void j(List<? extends v1> supertypes) {
        kotlin.jvm.internal.m.f(supertypes, "supertypes");
        this.f14246b = new c(supertypes);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public j c(g kotlinTypeRefiner) {
        kotlin.jvm.internal.m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        k1 k1VarC = f().c(kotlinTypeRefiner);
        kotlin.jvm.internal.m.e(k1VarC, "projection.refine(kotlinTypeRefiner)");
        d dVar = this.f14246b != null ? new d(kotlinTypeRefiner) : null;
        j jVar = this.f14247c;
        if (jVar == null) {
            jVar = this;
        }
        return new j(k1VarC, dVar, jVar, this.f14248d);
    }

    public String toString() {
        return "CapturedType(" + f() + ')';
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    public List<f1> getParameters() {
        return kotlin.collections.r.l();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public List<v1> b() {
        List<v1> listI = i();
        if (listI == null) {
            return kotlin.collections.r.l();
        }
        return listI;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    public kotlin.reflect.jvm.internal.impl.builtins.h l() {
        g0 type = f().getType();
        kotlin.jvm.internal.m.e(type, "projection.type");
        return oa.a.i(type);
    }

    public /* synthetic */ j(k1 k1Var, c9.a aVar, j jVar, f1 f1Var, int i10, kotlin.jvm.internal.g gVar) {
        this(k1Var, (i10 & 2) != 0 ? null : aVar, (i10 & 4) != 0 ? null : jVar, (i10 & 8) != 0 ? null : f1Var);
    }

    public /* synthetic */ j(k1 k1Var, List list, j jVar, int i10, kotlin.jvm.internal.g gVar) {
        this(k1Var, list, (i10 & 4) != 0 ? null : jVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(k1 projection, List<? extends v1> supertypes, j jVar) {
        this(projection, new a(supertypes), jVar, null, 8, null);
        kotlin.jvm.internal.m.f(projection, "projection");
        kotlin.jvm.internal.m.f(supertypes, "supertypes");
    }
}
