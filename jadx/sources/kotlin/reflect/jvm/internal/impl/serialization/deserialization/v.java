package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.n0;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.types.g0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f14197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.e f14198b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends kotlin.jvm.internal.o implements c9.a<List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c>> {
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.serialization.deserialization.b $kind;
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.q $proto;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(kotlin.reflect.jvm.internal.impl.protobuf.q qVar, kotlin.reflect.jvm.internal.impl.serialization.deserialization.b bVar) {
            super(0);
            this.$proto = qVar;
            this.$kind = bVar;
        }

        @Override // c9.a
        public final List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> invoke() {
            List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> listO0;
            v vVar = v.this;
            y yVarC = vVar.c(vVar.f14197a.e());
            if (yVarC != null) {
                listO0 = kotlin.collections.r.O0(v.this.f14197a.c().d().i(yVarC, this.$proto, this.$kind));
            } else {
                listO0 = null;
            }
            return listO0 == null ? kotlin.collections.r.l() : listO0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends kotlin.jvm.internal.o implements c9.a<List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c>> {
        final /* synthetic */ boolean $isDelegate;
        final /* synthetic */ w9.n $proto;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(boolean z10, w9.n nVar) {
            super(0);
            this.$isDelegate = z10;
            this.$proto = nVar;
        }

        @Override // c9.a
        public final List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> invoke() {
            List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> listO0;
            v vVar = v.this;
            y yVarC = vVar.c(vVar.f14197a.e());
            if (yVarC != null) {
                boolean z10 = this.$isDelegate;
                v vVar2 = v.this;
                w9.n nVar = this.$proto;
                listO0 = z10 ? kotlin.collections.r.O0(vVar2.f14197a.c().d().k(yVarC, nVar)) : kotlin.collections.r.O0(vVar2.f14197a.c().d().f(yVarC, nVar));
            } else {
                listO0 = null;
            }
            return listO0 == null ? kotlin.collections.r.l() : listO0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends kotlin.jvm.internal.o implements c9.a<List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c>> {
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.serialization.deserialization.b $kind;
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.q $proto;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(kotlin.reflect.jvm.internal.impl.protobuf.q qVar, kotlin.reflect.jvm.internal.impl.serialization.deserialization.b bVar) {
            super(0);
            this.$proto = qVar;
            this.$kind = bVar;
        }

        @Override // c9.a
        public final List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> invoke() {
            List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> listE;
            v vVar = v.this;
            y yVarC = vVar.c(vVar.f14197a.e());
            if (yVarC != null) {
                listE = v.this.f14197a.c().d().e(yVarC, this.$proto, this.$kind);
            } else {
                listE = null;
            }
            return listE == null ? kotlin.collections.r.l() : listE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class d extends kotlin.jvm.internal.o implements c9.a<ka.j<? extends kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>>> {
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.j $property;
        final /* synthetic */ w9.n $proto;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class a extends kotlin.jvm.internal.o implements c9.a<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> {
            final /* synthetic */ kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.j $property;
            final /* synthetic */ w9.n $proto;
            final /* synthetic */ v this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(v vVar, w9.n nVar, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.j jVar) {
                super(0);
                this.this$0 = vVar;
                this.$proto = nVar;
                this.$property = jVar;
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> invoke() {
                v vVar = this.this$0;
                y yVarC = vVar.c(vVar.f14197a.e());
                kotlin.jvm.internal.m.c(yVarC);
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.c<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> cVarD = this.this$0.f14197a.c().d();
                w9.n nVar = this.$proto;
                g0 returnType = this.$property.getReturnType();
                kotlin.jvm.internal.m.e(returnType, "property.returnType");
                return cVarD.j(yVarC, nVar, returnType);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(w9.n nVar, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.j jVar) {
            super(0);
            this.$proto = nVar;
            this.$property = jVar;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ka.j<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> invoke() {
            return v.this.f14197a.h().g(new a(v.this, this.$proto, this.$property));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class e extends kotlin.jvm.internal.o implements c9.a<ka.j<? extends kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>>> {
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.j $property;
        final /* synthetic */ w9.n $proto;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class a extends kotlin.jvm.internal.o implements c9.a<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> {
            final /* synthetic */ kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.j $property;
            final /* synthetic */ w9.n $proto;
            final /* synthetic */ v this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(v vVar, w9.n nVar, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.j jVar) {
                super(0);
                this.this$0 = vVar;
                this.$proto = nVar;
                this.$property = jVar;
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> invoke() {
                v vVar = this.this$0;
                y yVarC = vVar.c(vVar.f14197a.e());
                kotlin.jvm.internal.m.c(yVarC);
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.c<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> cVarD = this.this$0.f14197a.c().d();
                w9.n nVar = this.$proto;
                g0 returnType = this.$property.getReturnType();
                kotlin.jvm.internal.m.e(returnType, "property.returnType");
                return cVarD.d(yVarC, nVar, returnType);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(w9.n nVar, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.j jVar) {
            super(0);
            this.$proto = nVar;
            this.$property = jVar;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ka.j<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> invoke() {
            return v.this.f14197a.h().g(new a(v.this, this.$proto, this.$property));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class f extends kotlin.jvm.internal.o implements c9.a<List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c>> {
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.q $callable;
        final /* synthetic */ y $containerOfCallable;
        final /* synthetic */ int $i;
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.serialization.deserialization.b $kind;
        final /* synthetic */ w9.u $proto;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(y yVar, kotlin.reflect.jvm.internal.impl.protobuf.q qVar, kotlin.reflect.jvm.internal.impl.serialization.deserialization.b bVar, int i10, w9.u uVar) {
            super(0);
            this.$containerOfCallable = yVar;
            this.$callable = qVar;
            this.$kind = bVar;
            this.$i = i10;
            this.$proto = uVar;
        }

        @Override // c9.a
        public final List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> invoke() {
            return kotlin.collections.r.O0(v.this.f14197a.c().d().h(this.$containerOfCallable, this.$callable, this.$kind, this.$i, this.$proto));
        }
    }

    public final u0 l(w9.n proto) {
        y9.b.d<w9.x> dVar;
        y9.b.d<w9.k> dVar2;
        kotlin.reflect.jvm.internal.impl.descriptors.impl.d0 d0VarD;
        kotlin.reflect.jvm.internal.impl.descriptors.impl.d0 d0Var;
        kotlin.reflect.jvm.internal.impl.descriptors.impl.e0 e0VarE;
        g0 g0VarQ;
        kotlin.jvm.internal.m.f(proto, "proto");
        int iA0 = proto.o0() ? proto.a0() : k(proto.d0());
        kotlin.reflect.jvm.internal.impl.descriptors.m mVarE = this.f14197a.e();
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVarD = d(proto, iA0, kotlin.reflect.jvm.internal.impl.serialization.deserialization.b.PROPERTY);
        z zVar = z.f14212a;
        kotlin.reflect.jvm.internal.impl.descriptors.e0 e0VarB = zVar.b(y9.b.f22498e.d(iA0));
        kotlin.reflect.jvm.internal.impl.descriptors.u uVarA = a0.a(zVar, y9.b.f22497d.d(iA0));
        Boolean boolD = y9.b.f22517x.d(iA0);
        kotlin.jvm.internal.m.e(boolD, "IS_VAR.get(flags)");
        boolean zBooleanValue = boolD.booleanValue();
        ba.f fVarB = w.b(this.f14197a.g(), proto.c0());
        kotlin.reflect.jvm.internal.impl.descriptors.b.a aVarB = a0.b(zVar, y9.b.f22508o.d(iA0));
        Boolean boolD2 = y9.b.B.d(iA0);
        kotlin.jvm.internal.m.e(boolD2, "IS_LATEINIT.get(flags)");
        boolean zBooleanValue2 = boolD2.booleanValue();
        Boolean boolD3 = y9.b.A.d(iA0);
        kotlin.jvm.internal.m.e(boolD3, "IS_CONST.get(flags)");
        boolean zBooleanValue3 = boolD3.booleanValue();
        Boolean boolD4 = y9.b.D.d(iA0);
        kotlin.jvm.internal.m.e(boolD4, "IS_EXTERNAL_PROPERTY.get(flags)");
        boolean zBooleanValue4 = boolD4.booleanValue();
        Boolean boolD5 = y9.b.E.d(iA0);
        kotlin.jvm.internal.m.e(boolD5, "IS_DELEGATED.get(flags)");
        boolean zBooleanValue5 = boolD5.booleanValue();
        Boolean boolD6 = y9.b.F.d(iA0);
        int i10 = iA0;
        kotlin.jvm.internal.m.e(boolD6, "IS_EXPECT_PROPERTY.get(flags)");
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.j jVar = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.j(mVarE, null, gVarD, e0VarB, uVarA, zBooleanValue, fVarB, aVarB, zBooleanValue2, zBooleanValue3, zBooleanValue4, zBooleanValue5, boolD6.booleanValue(), proto, this.f14197a.g(), this.f14197a.j(), this.f14197a.k(), this.f14197a.d());
        m mVar = this.f14197a;
        List<w9.s> listM0 = proto.m0();
        kotlin.jvm.internal.m.e(listM0, "proto.typeParameterList");
        m mVarB = m.b(mVar, jVar, listM0, null, null, null, null, 60, null);
        Boolean boolD7 = y9.b.f22518y.d(i10);
        kotlin.jvm.internal.m.e(boolD7, "HAS_GETTER.get(flags)");
        boolean zBooleanValue6 = boolD7.booleanValue();
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVarG = (zBooleanValue6 && y9.f.h(proto)) ? g(proto, kotlin.reflect.jvm.internal.impl.serialization.deserialization.b.PROPERTY_GETTER) : kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b();
        g0 g0VarQ2 = mVarB.i().q(y9.f.n(proto, this.f14197a.j()));
        List<f1> listJ = mVarB.i().j();
        x0 x0VarE = e();
        w9.q qVarL = y9.f.l(proto, this.f14197a.j());
        x0 x0VarI = (qVarL == null || (g0VarQ = mVarB.i().q(qVarL)) == null) ? null : kotlin.reflect.jvm.internal.impl.resolve.d.i(jVar, g0VarQ, gVarG);
        List<w9.q> listD = y9.f.d(proto, this.f14197a.j());
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(listD, 10));
        int i11 = 0;
        for (Object obj : listD) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.r.v();
            }
            arrayList.add(n((w9.q) obj, mVarB, jVar, i11));
            i11 = i12;
        }
        jVar.X0(g0VarQ2, listJ, x0VarE, x0VarI, arrayList);
        Boolean boolD8 = y9.b.f22496c.d(i10);
        kotlin.jvm.internal.m.e(boolD8, "HAS_ANNOTATIONS.get(flags)");
        boolean zBooleanValue7 = boolD8.booleanValue();
        y9.b.d<w9.x> dVar3 = y9.b.f22497d;
        w9.x xVarD = dVar3.d(i10);
        y9.b.d<w9.k> dVar4 = y9.b.f22498e;
        int iB = y9.b.b(zBooleanValue7, xVarD, dVar4.d(i10), false, false, false);
        if (zBooleanValue6) {
            int iB0 = proto.p0() ? proto.b0() : iB;
            Boolean boolD9 = y9.b.J.d(iB0);
            kotlin.jvm.internal.m.e(boolD9, "IS_NOT_DEFAULT.get(getterFlags)");
            boolean zBooleanValue8 = boolD9.booleanValue();
            Boolean boolD10 = y9.b.K.d(iB0);
            kotlin.jvm.internal.m.e(boolD10, "IS_EXTERNAL_ACCESSOR.get(getterFlags)");
            boolean zBooleanValue9 = boolD10.booleanValue();
            Boolean boolD11 = y9.b.L.d(iB0);
            kotlin.jvm.internal.m.e(boolD11, "IS_INLINE_ACCESSOR.get(getterFlags)");
            boolean zBooleanValue10 = boolD11.booleanValue();
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVarD2 = d(proto, iB0, kotlin.reflect.jvm.internal.impl.serialization.deserialization.b.PROPERTY_GETTER);
            if (zBooleanValue8) {
                z zVar2 = z.f14212a;
                dVar2 = dVar4;
                dVar = dVar3;
                d0VarD = new kotlin.reflect.jvm.internal.impl.descriptors.impl.d0(jVar, gVarD2, zVar2.b(dVar4.d(iB0)), a0.a(zVar2, dVar3.d(iB0)), !zBooleanValue8, zBooleanValue9, zBooleanValue10, jVar.g(), null, a1.f12668a);
            } else {
                dVar = dVar3;
                dVar2 = dVar4;
                d0VarD = kotlin.reflect.jvm.internal.impl.resolve.d.d(jVar, gVarD2);
                kotlin.jvm.internal.m.e(d0VarD, "{\n                Descri…nnotations)\n            }");
            }
            d0VarD.M0(jVar.getReturnType());
        } else {
            mVarB = mVarB;
            dVar = dVar3;
            dVar2 = dVar4;
            d0VarD = null;
        }
        Boolean boolD12 = y9.b.f22519z.d(i10);
        kotlin.jvm.internal.m.e(boolD12, "HAS_SETTER.get(flags)");
        if (boolD12.booleanValue()) {
            if (proto.w0()) {
                iB = proto.i0();
            }
            int i13 = iB;
            Boolean boolD13 = y9.b.J.d(i13);
            kotlin.jvm.internal.m.e(boolD13, "IS_NOT_DEFAULT.get(setterFlags)");
            boolean zBooleanValue11 = boolD13.booleanValue();
            Boolean boolD14 = y9.b.K.d(i13);
            kotlin.jvm.internal.m.e(boolD14, "IS_EXTERNAL_ACCESSOR.get(setterFlags)");
            boolean zBooleanValue12 = boolD14.booleanValue();
            Boolean boolD15 = y9.b.L.d(i13);
            kotlin.jvm.internal.m.e(boolD15, "IS_INLINE_ACCESSOR.get(setterFlags)");
            boolean zBooleanValue13 = boolD15.booleanValue();
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.b bVar = kotlin.reflect.jvm.internal.impl.serialization.deserialization.b.PROPERTY_SETTER;
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVarD3 = d(proto, i13, bVar);
            if (zBooleanValue11) {
                z zVar3 = z.f14212a;
                d0Var = d0VarD;
                kotlin.reflect.jvm.internal.impl.descriptors.impl.e0 e0Var = new kotlin.reflect.jvm.internal.impl.descriptors.impl.e0(jVar, gVarD3, zVar3.b(dVar2.d(i13)), a0.a(zVar3, dVar.d(i13)), !zBooleanValue11, zBooleanValue12, zBooleanValue13, jVar.g(), null, a1.f12668a);
                e0Var.N0((j1) kotlin.collections.r.F0(m.b(mVarB, e0Var, kotlin.collections.r.l(), null, null, null, null, 60, null).f().o(kotlin.collections.r.e(proto.j0()), proto, bVar)));
                e0VarE = e0Var;
            } else {
                d0Var = d0VarD;
                e0VarE = kotlin.reflect.jvm.internal.impl.resolve.d.e(jVar, gVarD3, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b());
                kotlin.jvm.internal.m.e(e0VarE, "{\n                Descri…          )\n            }");
            }
        } else {
            d0Var = d0VarD;
            e0VarE = null;
        }
        Boolean boolD16 = y9.b.C.d(i10);
        kotlin.jvm.internal.m.e(boolD16, "HAS_CONSTANT.get(flags)");
        if (boolD16.booleanValue()) {
            jVar.H0(new d(proto, jVar));
        }
        kotlin.reflect.jvm.internal.impl.descriptors.m mVarE2 = this.f14197a.e();
        kotlin.reflect.jvm.internal.impl.descriptors.e eVar = mVarE2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.e ? (kotlin.reflect.jvm.internal.impl.descriptors.e) mVarE2 : null;
        if ((eVar != null ? eVar.g() : null) == kotlin.reflect.jvm.internal.impl.descriptors.f.ANNOTATION_CLASS) {
            jVar.H0(new e(proto, jVar));
        }
        jVar.R0(d0Var, e0VarE, new kotlin.reflect.jvm.internal.impl.descriptors.impl.o(f(proto, false), jVar), new kotlin.reflect.jvm.internal.impl.descriptors.impl.o(f(proto, true), jVar));
        return jVar;
    }

    public v(m c10) {
        kotlin.jvm.internal.m.f(c10, "c");
        this.f14197a = c10;
        this.f14198b = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.e(c10.c().p(), c10.c().q());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final y c(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        if (mVar instanceof l0) {
            return new y.b(((l0) mVar).d(), this.f14197a.g(), this.f14197a.j(), this.f14197a.d());
        }
        if (mVar instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.d) {
            return ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.d) mVar).a1();
        }
        return null;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g d(kotlin.reflect.jvm.internal.impl.protobuf.q qVar, int i10, kotlin.reflect.jvm.internal.impl.serialization.deserialization.b bVar) {
        return !y9.b.f22496c.d(i10).booleanValue() ? kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b() : new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n(this.f14197a.h(), new a(qVar, bVar));
    }

    private final x0 e() {
        kotlin.reflect.jvm.internal.impl.descriptors.m mVarE = this.f14197a.e();
        kotlin.reflect.jvm.internal.impl.descriptors.e eVar = mVarE instanceof kotlin.reflect.jvm.internal.impl.descriptors.e ? (kotlin.reflect.jvm.internal.impl.descriptors.e) mVarE : null;
        if (eVar != null) {
            return eVar.F0();
        }
        return null;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g f(w9.n nVar, boolean z10) {
        return !y9.b.f22496c.d(nVar.a0()).booleanValue() ? kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b() : new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n(this.f14197a.h(), new b(z10, nVar));
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g g(kotlin.reflect.jvm.internal.impl.protobuf.q qVar, kotlin.reflect.jvm.internal.impl.serialization.deserialization.b bVar) {
        return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.a(this.f14197a.h(), new c(qVar, bVar));
    }

    private final int k(int i10) {
        return (i10 & 63) + ((i10 >> 8) << 6);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x007c  */
    private final List<j1> o(List<w9.u> list, kotlin.reflect.jvm.internal.impl.protobuf.q qVar, kotlin.reflect.jvm.internal.impl.serialization.deserialization.b bVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVarB;
        kotlin.reflect.jvm.internal.impl.descriptors.m mVarE = this.f14197a.e();
        kotlin.jvm.internal.m.d(mVarE, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        kotlin.reflect.jvm.internal.impl.descriptors.a aVar = (kotlin.reflect.jvm.internal.impl.descriptors.a) mVarE;
        kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = aVar.b();
        kotlin.jvm.internal.m.e(mVarB, "callableDescriptor.containingDeclaration");
        y yVarC = c(mVarB);
        List<w9.u> list2 = list;
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list2, 10));
        int i10 = 0;
        for (Object obj : list2) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.r.v();
            }
            w9.u uVar = (w9.u) obj;
            int iJ = uVar.Q() ? uVar.J() : 0;
            if (yVarC != null) {
                Boolean boolD = y9.b.f22496c.d(iJ);
                kotlin.jvm.internal.m.e(boolD, "HAS_ANNOTATIONS.get(flags)");
                if (boolD.booleanValue()) {
                    gVarB = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n(this.f14197a.h(), new f(yVarC, qVar, bVar, i10, uVar));
                } else {
                    gVarB = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b();
                }
            } else {
                gVarB = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b();
            }
            ba.f fVarB = w.b(this.f14197a.g(), uVar.K());
            g0 g0VarQ = this.f14197a.i().q(y9.f.q(uVar, this.f14197a.j()));
            Boolean boolD2 = y9.b.G.d(iJ);
            kotlin.jvm.internal.m.e(boolD2, "DECLARES_DEFAULT_VALUE.get(flags)");
            boolean zBooleanValue = boolD2.booleanValue();
            Boolean boolD3 = y9.b.H.d(iJ);
            kotlin.jvm.internal.m.e(boolD3, "IS_CROSSINLINE.get(flags)");
            boolean zBooleanValue2 = boolD3.booleanValue();
            Boolean boolD4 = y9.b.I.d(iJ);
            kotlin.jvm.internal.m.e(boolD4, "IS_NOINLINE.get(flags)");
            boolean zBooleanValue3 = boolD4.booleanValue();
            w9.q qVarT = y9.f.t(uVar, this.f14197a.j());
            g0 g0VarQ2 = qVarT != null ? this.f14197a.i().q(qVarT) : null;
            a1 NO_SOURCE = a1.f12668a;
            kotlin.jvm.internal.m.e(NO_SOURCE, "NO_SOURCE");
            kotlin.reflect.jvm.internal.impl.descriptors.a aVar2 = aVar;
            arrayList.add(new kotlin.reflect.jvm.internal.impl.descriptors.impl.l0(aVar2, null, i10, gVarB, fVarB, g0VarQ, zBooleanValue, zBooleanValue2, zBooleanValue3, g0VarQ2, NO_SOURCE));
            aVar = aVar2;
            i10 = i11;
        }
        return kotlin.collections.r.O0(arrayList);
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.d i(w9.d proto, boolean z10) {
        kotlin.jvm.internal.m.f(proto, "proto");
        kotlin.reflect.jvm.internal.impl.descriptors.m mVarE = this.f14197a.e();
        kotlin.jvm.internal.m.d(mVarE, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        kotlin.reflect.jvm.internal.impl.descriptors.e eVar = (kotlin.reflect.jvm.internal.impl.descriptors.e) mVarE;
        int I = proto.I();
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.b bVar = kotlin.reflect.jvm.internal.impl.serialization.deserialization.b.FUNCTION;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.c cVar = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.c(eVar, null, d(proto, I, bVar), z10, kotlin.reflect.jvm.internal.impl.descriptors.b.a.DECLARATION, proto, this.f14197a.g(), this.f14197a.j(), this.f14197a.k(), this.f14197a.d(), null, 1024, null);
        v vVarF = m.b(this.f14197a, cVar, kotlin.collections.r.l(), null, null, null, null, 60, null).f();
        List<w9.u> listL = proto.L();
        kotlin.jvm.internal.m.e(listL, "proto.valueParameterList");
        cVar.m1(vVarF.o(listL, proto, bVar), a0.a(z.f14212a, y9.b.f22497d.d(proto.I())));
        cVar.c1(eVar.p());
        cVar.S0(eVar.I());
        cVar.U0(!y9.b.f22507n.d(proto.I()).booleanValue());
        return cVar;
    }

    public final z0 j(w9.i proto) {
        g0 g0VarQ;
        kotlin.jvm.internal.m.f(proto, "proto");
        int iC0 = proto.s0() ? proto.c0() : k(proto.e0());
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.b bVar = kotlin.reflect.jvm.internal.impl.serialization.deserialization.b.FUNCTION;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVarD = d(proto, iC0, bVar);
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVarG = y9.f.g(proto) ? g(proto, bVar) : kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b();
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.k kVar = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.k(this.f14197a.e(), null, gVarD, w.b(this.f14197a.g(), proto.d0()), a0.b(z.f14212a, y9.b.f22508o.d(iC0)), proto, this.f14197a.g(), this.f14197a.j(), kotlin.jvm.internal.m.a(ea.c.l(this.f14197a.e()).c(w.b(this.f14197a.g(), proto.d0())), b0.f14034a) ? y9.h.f22527b.b() : this.f14197a.k(), this.f14197a.d(), null, 1024, null);
        m mVar = this.f14197a;
        List<w9.s> listL0 = proto.l0();
        kotlin.jvm.internal.m.e(listL0, "proto.typeParameterList");
        m mVarB = m.b(mVar, kVar, listL0, null, null, null, null, 60, null);
        w9.q qVarK = y9.f.k(proto, this.f14197a.j());
        x0 x0VarI = (qVarK == null || (g0VarQ = mVarB.i().q(qVarK)) == null) ? null : kotlin.reflect.jvm.internal.impl.resolve.d.i(kVar, g0VarQ, gVarG);
        x0 x0VarE = e();
        List<w9.q> listC = y9.f.c(proto, this.f14197a.j());
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (Object obj : listC) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.r.v();
            }
            x0 x0VarN = n((w9.q) obj, mVarB, kVar, i10);
            if (x0VarN != null) {
                arrayList.add(x0VarN);
            }
            i10 = i11;
        }
        List<f1> listJ = mVarB.i().j();
        v vVarF = mVarB.f();
        List<w9.u> listP0 = proto.p0();
        kotlin.jvm.internal.m.e(listP0, "proto.valueParameterList");
        List<j1> listO = vVarF.o(listP0, proto, kotlin.reflect.jvm.internal.impl.serialization.deserialization.b.FUNCTION);
        g0 g0VarQ2 = mVarB.i().q(y9.f.m(proto, this.f14197a.j()));
        z zVar = z.f14212a;
        h(kVar, x0VarI, x0VarE, arrayList, listJ, listO, g0VarQ2, zVar.b(y9.b.f22498e.d(iC0)), a0.a(zVar, y9.b.f22497d.d(iC0)), n0.i());
        Boolean boolD = y9.b.f22509p.d(iC0);
        kotlin.jvm.internal.m.e(boolD, "IS_OPERATOR.get(flags)");
        kVar.b1(boolD.booleanValue());
        Boolean boolD2 = y9.b.f22510q.d(iC0);
        kotlin.jvm.internal.m.e(boolD2, "IS_INFIX.get(flags)");
        kVar.Y0(boolD2.booleanValue());
        Boolean boolD3 = y9.b.f22513t.d(iC0);
        kotlin.jvm.internal.m.e(boolD3, "IS_EXTERNAL_FUNCTION.get(flags)");
        kVar.T0(boolD3.booleanValue());
        Boolean boolD4 = y9.b.f22511r.d(iC0);
        kotlin.jvm.internal.m.e(boolD4, "IS_INLINE.get(flags)");
        kVar.a1(boolD4.booleanValue());
        Boolean boolD5 = y9.b.f22512s.d(iC0);
        kotlin.jvm.internal.m.e(boolD5, "IS_TAILREC.get(flags)");
        kVar.e1(boolD5.booleanValue());
        Boolean boolD6 = y9.b.f22514u.d(iC0);
        kotlin.jvm.internal.m.e(boolD6, "IS_SUSPEND.get(flags)");
        kVar.d1(boolD6.booleanValue());
        Boolean boolD7 = y9.b.f22515v.d(iC0);
        kotlin.jvm.internal.m.e(boolD7, "IS_EXPECT_FUNCTION.get(flags)");
        kVar.S0(boolD7.booleanValue());
        kVar.U0(!y9.b.f22516w.d(iC0).booleanValue());
        r8.p<kotlin.reflect.jvm.internal.impl.descriptors.a.InterfaceC0217a<?>, Object> pVarA = this.f14197a.c().h().a(proto, kVar, this.f14197a.j(), mVarB.i());
        if (pVarA != null) {
            kVar.Q0(pVarA.c(), pVarA.d());
        }
        return kVar;
    }

    public final e1 m(w9.r proto) {
        kotlin.jvm.internal.m.f(proto, "proto");
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.a aVar = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0;
        List<w9.b> listQ = proto.Q();
        kotlin.jvm.internal.m.e(listQ, "proto.annotationList");
        List<w9.b> list = listQ;
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list, 10));
        for (w9.b it : list) {
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.e eVar = this.f14198b;
            kotlin.jvm.internal.m.e(it, "it");
            arrayList.add(eVar.a(it, this.f14197a.g()));
        }
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.l lVar = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.l(this.f14197a.h(), this.f14197a.e(), aVar.a(arrayList), w.b(this.f14197a.g(), proto.W()), a0.a(z.f14212a, y9.b.f22497d.d(proto.V())), proto, this.f14197a.g(), this.f14197a.j(), this.f14197a.k(), this.f14197a.d());
        m mVar = this.f14197a;
        List<w9.s> listZ = proto.Z();
        kotlin.jvm.internal.m.e(listZ, "proto.typeParameterList");
        m mVarB = m.b(mVar, lVar, listZ, null, null, null, null, 60, null);
        lVar.M0(mVarB.i().j(), mVarB.i().l(y9.f.r(proto, this.f14197a.j()), false), mVarB.i().l(y9.f.e(proto, this.f14197a.j()), false));
        return lVar;
    }

    private final void h(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.k kVar, x0 x0Var, x0 x0Var2, List<? extends x0> list, List<? extends f1> list2, List<? extends j1> list3, g0 g0Var, kotlin.reflect.jvm.internal.impl.descriptors.e0 e0Var, kotlin.reflect.jvm.internal.impl.descriptors.u uVar, Map<? extends kotlin.reflect.jvm.internal.impl.descriptors.a.InterfaceC0217a<?>, ?> map) {
        kVar.k1(x0Var, x0Var2, list, list2, list3, g0Var, e0Var, uVar, map);
    }

    private final x0 n(w9.q qVar, m mVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar, int i10) {
        return kotlin.reflect.jvm.internal.impl.resolve.d.b(aVar, mVar.i().q(qVar), null, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b(), i10);
    }
}
