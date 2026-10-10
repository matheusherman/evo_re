package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.load.kotlin.b.a;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class b<A, S extends a<? extends A>> implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.f<A> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q f13523a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static abstract class a<A> {
        public abstract Map<v, List<A>> a();
    }

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private enum EnumC0238b {
        PROPERTY,
        BACKING_FIELD,
        DELEGATE_FIELD
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class d implements s.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b<A, S> f13529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList<A> f13530b;

        d(b<A, S> bVar, ArrayList<A> arrayList) {
            this.f13529a = bVar;
            this.f13530b = arrayList;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.c
        public s.a c(ba.b classId, a1 source) {
            kotlin.jvm.internal.m.f(classId, "classId");
            kotlin.jvm.internal.m.f(source, "source");
            return this.f13529a.x(classId, source, this.f13530b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.c
        public void a() {
        }
    }

    private final List<A> m(kotlin.reflect.jvm.internal.impl.serialization.deserialization.y yVar, v vVar, boolean z10, boolean z11, Boolean bool, boolean z12) {
        s sVarO = o(yVar, u(yVar, z10, z11, bool, z12));
        if (sVarO == null) {
            return kotlin.collections.r.l();
        }
        List<A> list = p(sVarO).a().get(vVar);
        return list == null ? kotlin.collections.r.l() : list;
    }

    protected abstract S p(s sVar);

    public abstract aa.e t();

    protected abstract s.a w(ba.b bVar, a1 a1Var, List<A> list);

    protected abstract A z(w9.b bVar, y9.c cVar);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13528a;

        static {
            int[] iArr = new int[kotlin.reflect.jvm.internal.impl.serialization.deserialization.b.values().length];
            try {
                iArr[kotlin.reflect.jvm.internal.impl.serialization.deserialization.b.PROPERTY_GETTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.serialization.deserialization.b.PROPERTY_SETTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.serialization.deserialization.b.PROPERTY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f13528a = iArr;
        }
    }

    public b(q kotlinClassFinder) {
        kotlin.jvm.internal.m.f(kotlinClassFinder, "kotlinClassFinder");
        this.f13523a = kotlinClassFinder;
    }

    private final int l(kotlin.reflect.jvm.internal.impl.serialization.deserialization.y yVar, kotlin.reflect.jvm.internal.impl.protobuf.q qVar) {
        if (qVar instanceof w9.i) {
            return y9.f.g((w9.i) qVar) ? 1 : 0;
        }
        if (qVar instanceof w9.n) {
            return y9.f.h((w9.n) qVar) ? 1 : 0;
        }
        if (!(qVar instanceof w9.d)) {
            throw new UnsupportedOperationException("Unsupported message: " + qVar.getClass());
        }
        kotlin.jvm.internal.m.d(yVar, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.ProtoContainer.Class");
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.y.a aVar = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.y.a) yVar;
        if (aVar.g() == w9.c.EnumC0388c.ENUM_CLASS) {
            return 2;
        }
        return aVar.i() ? 1 : 0;
    }

    static /* synthetic */ List n(b bVar, kotlin.reflect.jvm.internal.impl.serialization.deserialization.y yVar, v vVar, boolean z10, boolean z11, Boolean bool, boolean z12, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findClassAndLoadMemberAnnotations");
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        if ((i10 & 8) != 0) {
            z11 = false;
        }
        if ((i10 & 16) != 0) {
            bool = null;
        }
        if ((i10 & 32) != 0) {
            z12 = false;
        }
        return bVar.m(yVar, vVar, z10, z11, bool, z12);
    }

    public static /* synthetic */ v s(b bVar, kotlin.reflect.jvm.internal.impl.protobuf.q qVar, y9.c cVar, y9.g gVar, kotlin.reflect.jvm.internal.impl.serialization.deserialization.b bVar2, boolean z10, int i10, Object obj) {
        if (obj == null) {
            return bVar.r(qVar, cVar, gVar, bVar2, (i10 & 16) != 0 ? false : z10);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCallableSignature");
    }

    private final List<A> y(kotlin.reflect.jvm.internal.impl.serialization.deserialization.y yVar, w9.n nVar, EnumC0238b enumC0238b) {
        Boolean boolD = y9.b.A.d(nVar.a0());
        kotlin.jvm.internal.m.e(boolD, "IS_CONST.get(proto.flags)");
        boolD.booleanValue();
        boolean zF = aa.i.f(nVar);
        if (enumC0238b == EnumC0238b.PROPERTY) {
            v vVarB = kotlin.reflect.jvm.internal.impl.load.kotlin.c.b(nVar, yVar.b(), yVar.d(), false, true, false, 40, null);
            return vVarB == null ? kotlin.collections.r.l() : n(this, yVar, vVarB, true, false, boolD, zF, 8, null);
        }
        v vVarB2 = kotlin.reflect.jvm.internal.impl.load.kotlin.c.b(nVar, yVar.b(), yVar.d(), true, false, false, 48, null);
        if (vVarB2 == null) {
            return kotlin.collections.r.l();
        }
        return ua.n.O(vVarB2.a(), "$delegate", false, 2, null) != (enumC0238b == EnumC0238b.DELEGATE_FIELD) ? kotlin.collections.r.l() : m(yVar, vVarB2, true, true, boolD, zF);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.f
    public List<A> a(w9.q proto, y9.c nameResolver) {
        kotlin.jvm.internal.m.f(proto, "proto");
        kotlin.jvm.internal.m.f(nameResolver, "nameResolver");
        Object objT = proto.t(z9.a.f23129f);
        kotlin.jvm.internal.m.e(objT, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
        Iterable<w9.b> iterable = (Iterable) objT;
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(iterable, 10));
        for (w9.b it : iterable) {
            kotlin.jvm.internal.m.e(it, "it");
            arrayList.add(z(it, nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.f
    public List<A> b(kotlin.reflect.jvm.internal.impl.serialization.deserialization.y.a container) {
        kotlin.jvm.internal.m.f(container, "container");
        s sVarA = A(container);
        if (sVarA != null) {
            ArrayList arrayList = new ArrayList(1);
            sVarA.h(new d(this, arrayList), q(sVarA));
            return arrayList;
        }
        throw new IllegalStateException(("Class for loading annotations is not found: " + container.a()).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.f
    public List<A> c(w9.s proto, y9.c nameResolver) {
        kotlin.jvm.internal.m.f(proto, "proto");
        kotlin.jvm.internal.m.f(nameResolver, "nameResolver");
        Object objT = proto.t(z9.a.f23131h);
        kotlin.jvm.internal.m.e(objT, "proto.getExtension(JvmPr….typeParameterAnnotation)");
        Iterable<w9.b> iterable = (Iterable) objT;
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(iterable, 10));
        for (w9.b it : iterable) {
            kotlin.jvm.internal.m.e(it, "it");
            arrayList.add(z(it, nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.f
    public List<A> e(kotlin.reflect.jvm.internal.impl.serialization.deserialization.y container, kotlin.reflect.jvm.internal.impl.protobuf.q proto, kotlin.reflect.jvm.internal.impl.serialization.deserialization.b kind) {
        kotlin.jvm.internal.m.f(container, "container");
        kotlin.jvm.internal.m.f(proto, "proto");
        kotlin.jvm.internal.m.f(kind, "kind");
        v vVarS = s(this, proto, container.b(), container.d(), kind, false, 16, null);
        return vVarS != null ? n(this, container, v.f13620b.e(vVarS, 0), false, false, null, false, 60, null) : kotlin.collections.r.l();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.f
    public List<A> f(kotlin.reflect.jvm.internal.impl.serialization.deserialization.y container, w9.n proto) {
        kotlin.jvm.internal.m.f(container, "container");
        kotlin.jvm.internal.m.f(proto, "proto");
        return y(container, proto, EnumC0238b.BACKING_FIELD);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.f
    public List<A> g(kotlin.reflect.jvm.internal.impl.serialization.deserialization.y container, w9.g proto) {
        kotlin.jvm.internal.m.f(container, "container");
        kotlin.jvm.internal.m.f(proto, "proto");
        v.a aVar = v.f13620b;
        String string = container.b().getString(proto.E());
        String strC = ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.y.a) container).e().c();
        kotlin.jvm.internal.m.e(strC, "container as ProtoContai…Class).classId.asString()");
        return n(this, container, aVar.a(string, aa.b.b(strC)), false, false, null, false, 60, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.f
    public List<A> h(kotlin.reflect.jvm.internal.impl.serialization.deserialization.y container, kotlin.reflect.jvm.internal.impl.protobuf.q callableProto, kotlin.reflect.jvm.internal.impl.serialization.deserialization.b kind, int i10, w9.u proto) {
        kotlin.jvm.internal.m.f(container, "container");
        kotlin.jvm.internal.m.f(callableProto, "callableProto");
        kotlin.jvm.internal.m.f(kind, "kind");
        kotlin.jvm.internal.m.f(proto, "proto");
        v vVarS = s(this, callableProto, container.b(), container.d(), kind, false, 16, null);
        if (vVarS == null) {
            return kotlin.collections.r.l();
        }
        return n(this, container, v.f13620b.e(vVarS, i10 + l(container, callableProto)), false, false, null, false, 60, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.f
    public List<A> i(kotlin.reflect.jvm.internal.impl.serialization.deserialization.y container, kotlin.reflect.jvm.internal.impl.protobuf.q proto, kotlin.reflect.jvm.internal.impl.serialization.deserialization.b kind) {
        kotlin.jvm.internal.m.f(container, "container");
        kotlin.jvm.internal.m.f(proto, "proto");
        kotlin.jvm.internal.m.f(kind, "kind");
        if (kind == kotlin.reflect.jvm.internal.impl.serialization.deserialization.b.PROPERTY) {
            return y(container, (w9.n) proto, EnumC0238b.PROPERTY);
        }
        v vVarS = s(this, proto, container.b(), container.d(), kind, false, 16, null);
        return vVarS == null ? kotlin.collections.r.l() : n(this, container, vVarS, false, false, null, false, 60, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.f
    public List<A> k(kotlin.reflect.jvm.internal.impl.serialization.deserialization.y container, w9.n proto) {
        kotlin.jvm.internal.m.f(container, "container");
        kotlin.jvm.internal.m.f(proto, "proto");
        return y(container, proto, EnumC0238b.DELEGATE_FIELD);
    }

    protected final s o(kotlin.reflect.jvm.internal.impl.serialization.deserialization.y container, s sVar) {
        kotlin.jvm.internal.m.f(container, "container");
        if (sVar != null) {
            return sVar;
        }
        if (container instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.y.a) {
            return A((kotlin.reflect.jvm.internal.impl.serialization.deserialization.y.a) container);
        }
        return null;
    }

    protected byte[] q(s kotlinClass) {
        kotlin.jvm.internal.m.f(kotlinClass, "kotlinClass");
        return null;
    }

    protected final v r(kotlin.reflect.jvm.internal.impl.protobuf.q proto, y9.c nameResolver, y9.g typeTable, kotlin.reflect.jvm.internal.impl.serialization.deserialization.b kind, boolean z10) {
        kotlin.jvm.internal.m.f(proto, "proto");
        kotlin.jvm.internal.m.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.m.f(typeTable, "typeTable");
        kotlin.jvm.internal.m.f(kind, "kind");
        if (proto instanceof w9.d) {
            v.a aVar = v.f13620b;
            aa.d.b bVarB = aa.i.f190a.b((w9.d) proto, nameResolver, typeTable);
            if (bVarB == null) {
                return null;
            }
            return aVar.b(bVarB);
        }
        if (proto instanceof w9.i) {
            v.a aVar2 = v.f13620b;
            aa.d.b bVarE = aa.i.f190a.e((w9.i) proto, nameResolver, typeTable);
            if (bVarE == null) {
                return null;
            }
            return aVar2.b(bVarE);
        }
        if (proto instanceof w9.n) {
            kotlin.reflect.jvm.internal.impl.protobuf.i.f<w9.n, z9.a.d> propertySignature = z9.a.f23127d;
            kotlin.jvm.internal.m.e(propertySignature, "propertySignature");
            z9.a.d dVar = (z9.a.d) y9.e.a((kotlin.reflect.jvm.internal.impl.protobuf.i.d) proto, propertySignature);
            if (dVar == null) {
                return null;
            }
            int i10 = c.f13528a[kind.ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        return null;
                    }
                    return kotlin.reflect.jvm.internal.impl.load.kotlin.c.a((w9.n) proto, nameResolver, typeTable, true, true, z10);
                }
                if (!dVar.G()) {
                    return null;
                }
                v.a aVar3 = v.f13620b;
                z9.a.c cVarB = dVar.B();
                kotlin.jvm.internal.m.e(cVarB, "signature.setter");
                return aVar3.c(nameResolver, cVarB);
            }
            if (dVar.F()) {
                v.a aVar4 = v.f13620b;
                z9.a.c cVarA = dVar.A();
                kotlin.jvm.internal.m.e(cVarA, "signature.getter");
                return aVar4.c(nameResolver, cVarA);
            }
        }
        return null;
    }

    protected final s u(kotlin.reflect.jvm.internal.impl.serialization.deserialization.y container, boolean z10, boolean z11, Boolean bool, boolean z12) {
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.y.a aVarH;
        kotlin.jvm.internal.m.f(container, "container");
        if (z10) {
            if (bool == null) {
                throw new IllegalStateException(("isConst should not be null for property (container=" + container + ')').toString());
            }
            if (container instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.y.a) {
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.y.a aVar = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.y.a) container;
                if (aVar.g() == w9.c.EnumC0388c.INTERFACE) {
                    q qVar = this.f13523a;
                    ba.b bVarD = aVar.e().d(ba.f.l("DefaultImpls"));
                    kotlin.jvm.internal.m.e(bVarD, "container.classId.create…EFAULT_IMPLS_CLASS_NAME))");
                    return r.a(qVar, bVarD, t());
                }
            }
            if (bool.booleanValue() && (container instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.y.b)) {
                a1 a1VarC = container.c();
                m mVar = a1VarC instanceof m ? (m) a1VarC : null;
                fa.d dVarF = mVar != null ? mVar.f() : null;
                if (dVarF != null) {
                    q qVar2 = this.f13523a;
                    String strF = dVarF.f();
                    kotlin.jvm.internal.m.e(strF, "facadeClassName.internalName");
                    ba.b bVarM = ba.b.m(new ba.c(ua.n.D(strF, '/', '.', false, 4, null)));
                    kotlin.jvm.internal.m.e(bVarM, "topLevel(FqName(facadeCl…lName.replace('/', '.')))");
                    return r.a(qVar2, bVarM, t());
                }
            }
        }
        if (z11 && (container instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.y.a)) {
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.y.a aVar2 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.y.a) container;
            if (aVar2.g() == w9.c.EnumC0388c.COMPANION_OBJECT && (aVarH = aVar2.h()) != null && (aVarH.g() == w9.c.EnumC0388c.CLASS || aVarH.g() == w9.c.EnumC0388c.ENUM_CLASS || (z12 && (aVarH.g() == w9.c.EnumC0388c.INTERFACE || aVarH.g() == w9.c.EnumC0388c.ANNOTATION_CLASS)))) {
                return A(aVarH);
            }
        }
        if (!(container instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.y.b) || !(container.c() instanceof m)) {
            return null;
        }
        a1 a1VarC2 = container.c();
        kotlin.jvm.internal.m.d(a1VarC2, "null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
        m mVar2 = (m) a1VarC2;
        s sVarG = mVar2.g();
        return sVarG == null ? r.a(this.f13523a, mVar2.d(), t()) : sVarG;
    }

    protected final boolean v(ba.b classId) {
        s sVarA;
        kotlin.jvm.internal.m.f(classId, "classId");
        return classId.g() != null && kotlin.jvm.internal.m.a(classId.j().f(), "Container") && (sVarA = r.a(this.f13523a, classId, t())) != null && l9.a.f15247a.c(sVarA);
    }

    protected final s.a x(ba.b annotationClassId, a1 source, List<A> result) {
        kotlin.jvm.internal.m.f(annotationClassId, "annotationClassId");
        kotlin.jvm.internal.m.f(source, "source");
        kotlin.jvm.internal.m.f(result, "result");
        if (l9.a.f15247a.b().contains(annotationClassId)) {
            return null;
        }
        return w(annotationClassId, source, result);
    }

    private final s A(kotlin.reflect.jvm.internal.impl.serialization.deserialization.y.a aVar) {
        u uVar;
        a1 a1VarC = aVar.c();
        if (a1VarC instanceof u) {
            uVar = (u) a1VarC;
        } else {
            uVar = null;
        }
        if (uVar == null) {
            return null;
        }
        return uVar.d();
    }
}
