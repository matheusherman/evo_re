package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.k1;
import kotlin.reflect.jvm.internal.impl.types.p1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class l0 extends m0 implements j1 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f12856l = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f12857f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f12858g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f12859h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f12860i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.types.g0 f12861j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final j1 f12862k;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }

        public final l0 a(kotlin.reflect.jvm.internal.impl.descriptors.a containingDeclaration, j1 j1Var, int i10, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations, ba.f name, kotlin.reflect.jvm.internal.impl.types.g0 outType, boolean z10, boolean z11, boolean z12, kotlin.reflect.jvm.internal.impl.types.g0 g0Var, a1 source, c9.a<? extends List<? extends k1>> aVar) {
            kotlin.jvm.internal.m.f(containingDeclaration, "containingDeclaration");
            kotlin.jvm.internal.m.f(annotations, "annotations");
            kotlin.jvm.internal.m.f(name, "name");
            kotlin.jvm.internal.m.f(outType, "outType");
            kotlin.jvm.internal.m.f(source, "source");
            return aVar == null ? new l0(containingDeclaration, j1Var, i10, annotations, name, outType, z10, z11, z12, g0Var, source) : new b(containingDeclaration, j1Var, i10, annotations, name, outType, z10, z11, z12, g0Var, source, aVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends l0 {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final r8.i f12863m;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class a extends kotlin.jvm.internal.o implements c9.a<List<? extends k1>> {
            a() {
                super(0);
            }

            @Override // c9.a
            public final List<? extends k1> invoke() {
                return b.this.J0();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(kotlin.reflect.jvm.internal.impl.descriptors.a containingDeclaration, j1 j1Var, int i10, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations, ba.f name, kotlin.reflect.jvm.internal.impl.types.g0 outType, boolean z10, boolean z11, boolean z12, kotlin.reflect.jvm.internal.impl.types.g0 g0Var, a1 source, c9.a<? extends List<? extends k1>> destructuringVariables) {
            super(containingDeclaration, j1Var, i10, annotations, name, outType, z10, z11, z12, g0Var, source);
            kotlin.jvm.internal.m.f(containingDeclaration, "containingDeclaration");
            kotlin.jvm.internal.m.f(annotations, "annotations");
            kotlin.jvm.internal.m.f(name, "name");
            kotlin.jvm.internal.m.f(outType, "outType");
            kotlin.jvm.internal.m.f(source, "source");
            kotlin.jvm.internal.m.f(destructuringVariables, "destructuringVariables");
            this.f12863m = r8.j.a(destructuringVariables);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.l0, kotlin.reflect.jvm.internal.impl.descriptors.j1
        public j1 B(kotlin.reflect.jvm.internal.impl.descriptors.a newOwner, ba.f newName, int i10) {
            kotlin.jvm.internal.m.f(newOwner, "newOwner");
            kotlin.jvm.internal.m.f(newName, "newName");
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations = getAnnotations();
            kotlin.jvm.internal.m.e(annotations, "annotations");
            kotlin.reflect.jvm.internal.impl.types.g0 type = getType();
            kotlin.jvm.internal.m.e(type, "type");
            boolean zQ0 = q0();
            boolean zX = X();
            boolean zT = T();
            kotlin.reflect.jvm.internal.impl.types.g0 g0VarH0 = h0();
            a1 NO_SOURCE = a1.f12668a;
            kotlin.jvm.internal.m.e(NO_SOURCE, "NO_SOURCE");
            return new b(newOwner, null, i10, annotations, newName, type, zQ0, zX, zT, g0VarH0, NO_SOURCE, new a());
        }

        public final List<k1> J0() {
            return (List) this.f12863m.getValue();
        }
    }

    public Void H0() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k1
    public boolean f0() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(kotlin.reflect.jvm.internal.impl.descriptors.a containingDeclaration, j1 j1Var, int i10, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations, ba.f name, kotlin.reflect.jvm.internal.impl.types.g0 outType, boolean z10, boolean z11, boolean z12, kotlin.reflect.jvm.internal.impl.types.g0 g0Var, a1 source) {
        super(containingDeclaration, annotations, name, outType, source);
        kotlin.jvm.internal.m.f(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.m.f(annotations, "annotations");
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(outType, "outType");
        kotlin.jvm.internal.m.f(source, "source");
        this.f12857f = i10;
        this.f12858g = z10;
        this.f12859h = z11;
        this.f12860i = z12;
        this.f12861j = g0Var;
        this.f12862k = j1Var == null ? this : j1Var;
    }

    public static final l0 G0(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, j1 j1Var, int i10, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, ba.f fVar, kotlin.reflect.jvm.internal.impl.types.g0 g0Var, boolean z10, boolean z11, boolean z12, kotlin.reflect.jvm.internal.impl.types.g0 g0Var2, a1 a1Var, c9.a<? extends List<? extends k1>> aVar2) {
        return f12856l.a(aVar, j1Var, i10, gVar, fVar, g0Var, z10, z11, z12, g0Var2, a1Var, aVar2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1
    public j1 B(kotlin.reflect.jvm.internal.impl.descriptors.a newOwner, ba.f newName, int i10) {
        kotlin.jvm.internal.m.f(newOwner, "newOwner");
        kotlin.jvm.internal.m.f(newName, "newName");
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations = getAnnotations();
        kotlin.jvm.internal.m.e(annotations, "annotations");
        kotlin.reflect.jvm.internal.impl.types.g0 type = getType();
        kotlin.jvm.internal.m.e(type, "type");
        boolean zQ0 = q0();
        boolean zX = X();
        boolean zT = T();
        kotlin.reflect.jvm.internal.impl.types.g0 g0VarH0 = h0();
        a1 NO_SOURCE = a1.f12668a;
        kotlin.jvm.internal.m.e(NO_SOURCE, "NO_SOURCE");
        return new l0(newOwner, null, i10, annotations, newName, type, zQ0, zX, zT, g0VarH0, NO_SOURCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public <R, D> R H(kotlin.reflect.jvm.internal.impl.descriptors.o<R, D> visitor, D d10) {
        kotlin.jvm.internal.m.f(visitor, "visitor");
        return visitor.k(this, d10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c1
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public j1 c(p1 substitutor) {
        kotlin.jvm.internal.m.f(substitutor, "substitutor");
        if (substitutor.k()) {
            return this;
        }
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1
    public boolean T() {
        return this.f12860i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1
    public boolean X() {
        return this.f12859h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.k, kotlin.reflect.jvm.internal.impl.descriptors.m
    public kotlin.reflect.jvm.internal.impl.descriptors.a b() {
        kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = super.b();
        kotlin.jvm.internal.m.d(mVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        return (kotlin.reflect.jvm.internal.impl.descriptors.a) mVarB;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1
    public int getIndex() {
        return this.f12857f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.q
    public kotlin.reflect.jvm.internal.impl.descriptors.u getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.u LOCAL = kotlin.reflect.jvm.internal.impl.descriptors.t.f13069f;
        kotlin.jvm.internal.m.e(LOCAL, "LOCAL");
        return LOCAL;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1
    public kotlin.reflect.jvm.internal.impl.types.g0 h0() {
        return this.f12861j;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1
    public boolean q0() {
        if (!this.f12858g) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.a aVarB = b();
        kotlin.jvm.internal.m.d(aVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableMemberDescriptor");
        return ((kotlin.reflect.jvm.internal.impl.descriptors.b) aVarB).g().a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k1
    public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.resolve.constants.g S() {
        return (kotlin.reflect.jvm.internal.impl.resolve.constants.g) H0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.k
    public j1 a() {
        j1 j1Var = this.f12862k;
        return j1Var == this ? this : j1Var.a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public Collection<j1> e() {
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.a> collectionE = b().e();
        kotlin.jvm.internal.m.e(collectionE, "containingDeclaration.overriddenDescriptors");
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.a> collection = collectionE;
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.descriptors.a) it.next()).f().get(getIndex()));
        }
        return arrayList;
    }
}
