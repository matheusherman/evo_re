package kotlin.reflect.jvm.internal.impl.renderer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.c0;
import kotlin.collections.r;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.o;
import kotlin.reflect.jvm.internal.impl.descriptors.q0;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.resolve.constants.q;
import kotlin.reflect.jvm.internal.impl.types.a0;
import kotlin.reflect.jvm.internal.impl.types.f0;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.g1;
import kotlin.reflect.jvm.internal.impl.types.i0;
import kotlin.reflect.jvm.internal.impl.types.k1;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.p;
import kotlin.reflect.jvm.internal.impl.types.s0;
import kotlin.reflect.jvm.internal.impl.types.s1;
import kotlin.reflect.jvm.internal.impl.types.v1;
import kotlin.reflect.jvm.internal.impl.types.w1;
import kotlin.reflect.jvm.internal.impl.types.x1;
import org.apache.log4j.spi.LocationInfo;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d extends kotlin.reflect.jvm.internal.impl.renderer.c implements kotlin.reflect.jvm.internal.impl.renderer.f {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.renderer.g f13807l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final r8.i f13808m;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class a implements o<z, StringBuilder> {

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.renderer.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public /* synthetic */ class C0249a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f13810a;

            static {
                int[] iArr = new int[l.values().length];
                try {
                    iArr[l.PRETTY.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[l.DEBUG.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[l.NONE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f13810a = iArr;
            }
        }

        public a() {
        }

        private final void t(t0 t0Var, StringBuilder sb2, String str) throws IOException {
            int i10 = C0249a.f13810a[d.this.l0().ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    return;
                }
                p(t0Var, sb2);
                return;
            }
            d.this.R0(t0Var, sb2);
            sb2.append(str + " for ");
            d dVar = d.this;
            u0 u0VarX0 = t0Var.x0();
            kotlin.jvm.internal.m.e(u0VarX0, "descriptor.correspondingProperty");
            dVar.A1(u0VarX0, sb2);
        }

        public void A(j1 descriptor, StringBuilder builder) {
            kotlin.jvm.internal.m.f(descriptor, "descriptor");
            kotlin.jvm.internal.m.f(builder, "builder");
            d.this.S1(descriptor, true, builder, true);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public /* bridge */ /* synthetic */ z a(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, StringBuilder sb2) throws IOException {
            n(eVar, sb2);
            return z.f17874a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public /* bridge */ /* synthetic */ z b(v0 v0Var, StringBuilder sb2) throws IOException {
            v(v0Var, sb2);
            return z.f17874a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public /* bridge */ /* synthetic */ z c(q0 q0Var, StringBuilder sb2) {
            s(q0Var, sb2);
            return z.f17874a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public /* bridge */ /* synthetic */ z d(u0 u0Var, StringBuilder sb2) throws IOException {
            u(u0Var, sb2);
            return z.f17874a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public /* bridge */ /* synthetic */ z e(e1 e1Var, StringBuilder sb2) {
            y(e1Var, sb2);
            return z.f17874a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public /* bridge */ /* synthetic */ z f(l0 l0Var, StringBuilder sb2) {
            r(l0Var, sb2);
            return z.f17874a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public /* bridge */ /* synthetic */ z g(y yVar, StringBuilder sb2) throws IOException {
            p(yVar, sb2);
            return z.f17874a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public /* bridge */ /* synthetic */ z h(kotlin.reflect.jvm.internal.impl.descriptors.l lVar, StringBuilder sb2) throws IOException {
            o(lVar, sb2);
            return z.f17874a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public /* bridge */ /* synthetic */ z i(w0 w0Var, StringBuilder sb2) throws IOException {
            w(w0Var, sb2);
            return z.f17874a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public /* bridge */ /* synthetic */ z j(h0 h0Var, StringBuilder sb2) {
            q(h0Var, sb2);
            return z.f17874a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public /* bridge */ /* synthetic */ z k(j1 j1Var, StringBuilder sb2) {
            A(j1Var, sb2);
            return z.f17874a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public /* bridge */ /* synthetic */ z l(x0 x0Var, StringBuilder sb2) {
            x(x0Var, sb2);
            return z.f17874a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public /* bridge */ /* synthetic */ z m(f1 f1Var, StringBuilder sb2) {
            z(f1Var, sb2);
            return z.f17874a;
        }

        public void n(kotlin.reflect.jvm.internal.impl.descriptors.e descriptor, StringBuilder builder) throws IOException {
            kotlin.jvm.internal.m.f(descriptor, "descriptor");
            kotlin.jvm.internal.m.f(builder, "builder");
            d.this.X0(descriptor, builder);
        }

        public void o(kotlin.reflect.jvm.internal.impl.descriptors.l constructorDescriptor, StringBuilder builder) throws IOException {
            kotlin.jvm.internal.m.f(constructorDescriptor, "constructorDescriptor");
            kotlin.jvm.internal.m.f(builder, "builder");
            d.this.c1(constructorDescriptor, builder);
        }

        public void p(y descriptor, StringBuilder builder) throws IOException {
            kotlin.jvm.internal.m.f(descriptor, "descriptor");
            kotlin.jvm.internal.m.f(builder, "builder");
            d.this.i1(descriptor, builder);
        }

        public void q(h0 descriptor, StringBuilder builder) {
            kotlin.jvm.internal.m.f(descriptor, "descriptor");
            kotlin.jvm.internal.m.f(builder, "builder");
            d.this.s1(descriptor, builder, true);
        }

        public void r(l0 descriptor, StringBuilder builder) {
            kotlin.jvm.internal.m.f(descriptor, "descriptor");
            kotlin.jvm.internal.m.f(builder, "builder");
            d.this.w1(descriptor, builder);
        }

        public void s(q0 descriptor, StringBuilder builder) {
            kotlin.jvm.internal.m.f(descriptor, "descriptor");
            kotlin.jvm.internal.m.f(builder, "builder");
            d.this.y1(descriptor, builder);
        }

        public void u(u0 descriptor, StringBuilder builder) throws IOException {
            kotlin.jvm.internal.m.f(descriptor, "descriptor");
            kotlin.jvm.internal.m.f(builder, "builder");
            d.this.A1(descriptor, builder);
        }

        public void v(v0 descriptor, StringBuilder builder) throws IOException {
            kotlin.jvm.internal.m.f(descriptor, "descriptor");
            kotlin.jvm.internal.m.f(builder, "builder");
            t(descriptor, builder, "getter");
        }

        public void w(w0 descriptor, StringBuilder builder) throws IOException {
            kotlin.jvm.internal.m.f(descriptor, "descriptor");
            kotlin.jvm.internal.m.f(builder, "builder");
            t(descriptor, builder, "setter");
        }

        public void x(x0 descriptor, StringBuilder builder) {
            kotlin.jvm.internal.m.f(descriptor, "descriptor");
            kotlin.jvm.internal.m.f(builder, "builder");
            builder.append(descriptor.getName());
        }

        public void y(e1 descriptor, StringBuilder builder) {
            kotlin.jvm.internal.m.f(descriptor, "descriptor");
            kotlin.jvm.internal.m.f(builder, "builder");
            d.this.I1(descriptor, builder);
        }

        public void z(f1 descriptor, StringBuilder builder) {
            kotlin.jvm.internal.m.f(descriptor, "descriptor");
            kotlin.jvm.internal.m.f(builder, "builder");
            d.this.N1(descriptor, builder, true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends kotlin.jvm.internal.o implements c9.l<k1, CharSequence> {
        c() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(k1 it) {
            kotlin.jvm.internal.m.f(it, "it");
            if (it.b()) {
                return "*";
            }
            d dVar = d.this;
            g0 type = it.getType();
            kotlin.jvm.internal.m.e(type, "it.type");
            String strW = dVar.w(type);
            if (it.a() == w1.INVARIANT) {
                return strW;
            }
            return it.a() + ' ' + strW;
        }
    }

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.renderer.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class C0250d extends kotlin.jvm.internal.o implements c9.a<d> {

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.renderer.d$d$a */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class a extends kotlin.jvm.internal.o implements c9.l<kotlin.reflect.jvm.internal.impl.renderer.f, z> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f13813a = new a();

            a() {
                super(1);
            }

            public final void a(kotlin.reflect.jvm.internal.impl.renderer.f withOptions) {
                kotlin.jvm.internal.m.f(withOptions, "$this$withOptions");
                withOptions.a(kotlin.collections.v0.k(withOptions.m(), r.o(kotlin.reflect.jvm.internal.impl.builtins.k.a.C, kotlin.reflect.jvm.internal.impl.builtins.k.a.D)));
            }

            @Override // c9.l
            public /* bridge */ /* synthetic */ z invoke(kotlin.reflect.jvm.internal.impl.renderer.f fVar) {
                a(fVar);
                return z.f17874a;
            }
        }

        C0250d() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final d invoke() {
            kotlin.reflect.jvm.internal.impl.renderer.c cVarY = d.this.y(a.f13813a);
            kotlin.jvm.internal.m.d(cVarY, "null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
            return (d) cVarY;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class e extends kotlin.jvm.internal.o implements c9.l<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>, CharSequence> {
        e() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> it) {
            kotlin.jvm.internal.m.f(it, "it");
            return d.this.b1(it);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class f extends kotlin.jvm.internal.o implements c9.l<j1, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f13814a = new f();

        f() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(j1 j1Var) {
            return "";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class g extends kotlin.jvm.internal.o implements c9.l<g0, CharSequence> {
        g() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(g0 it) {
            d dVar = d.this;
            kotlin.jvm.internal.m.e(it, "it");
            return dVar.w(it);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class h extends kotlin.jvm.internal.o implements c9.l<g0, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f13815a = new h();

        h() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(g0 it) {
            kotlin.jvm.internal.m.f(it, "it");
            return it instanceof kotlin.reflect.jvm.internal.impl.types.w0 ? ((kotlin.reflect.jvm.internal.impl.types.w0) it).S0() : it;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I1(e1 e1Var, StringBuilder sb2) {
        V0(this, sb2, e1Var, null, 2, null);
        u visibility = e1Var.getVisibility();
        kotlin.jvm.internal.m.e(visibility, "typeAlias.visibility");
        V1(visibility, sb2);
        n1(e1Var, sb2);
        sb2.append(l1("typealias"));
        sb2.append(" ");
        s1(e1Var, sb2, true);
        List<f1> listR = e1Var.r();
        kotlin.jvm.internal.m.e(listR, "typeAlias.declaredTypeParameters");
        P1(listR, sb2, false);
        W0(e1Var, sb2);
        sb2.append(" = ");
        sb2.append(w(e1Var.c0()));
    }

    private final void M(StringBuilder sb2, List<? extends k1> list) throws IOException {
        c0.n0(list, sb2, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:9:0x0033  */
    public final void c1(kotlin.reflect.jvm.internal.impl.descriptors.l lVar, StringBuilder sb2) throws IOException {
        boolean z10;
        kotlin.reflect.jvm.internal.impl.descriptors.d dVarM;
        V0(this, sb2, lVar, null, 2, null);
        if (this.f13807l.S() || lVar.w().i() != e0.SEALED) {
            u visibility = lVar.getVisibility();
            kotlin.jvm.internal.m.e(visibility, "constructor.visibility");
            if (V1(visibility, sb2)) {
                z10 = true;
            } else {
                z10 = false;
            }
        } else {
            z10 = false;
        }
        m1(lVar, sb2);
        boolean z11 = p0() || !lVar.v() || z10;
        if (z11) {
            sb2.append(l1("constructor"));
        }
        kotlin.reflect.jvm.internal.impl.descriptors.i iVarB = lVar.b();
        kotlin.jvm.internal.m.e(iVarB, "constructor.containingDeclaration");
        if (w0()) {
            if (z11) {
                sb2.append(" ");
            }
            s1(iVarB, sb2, true);
            List<f1> typeParameters = lVar.getTypeParameters();
            kotlin.jvm.internal.m.e(typeParameters, "constructor.typeParameters");
            P1(typeParameters, sb2, false);
        }
        List<j1> listF = lVar.f();
        kotlin.jvm.internal.m.e(listF, "constructor.valueParameters");
        T1(listF, lVar.A(), sb2);
        if (o0() && !lVar.v() && (iVarB instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) && (dVarM = ((kotlin.reflect.jvm.internal.impl.descriptors.e) iVarB).M()) != null) {
            List<j1> listF2 = dVarM.f();
            kotlin.jvm.internal.m.e(listF2, "primaryConstructor.valueParameters");
            ArrayList arrayList = new ArrayList();
            for (Object obj : listF2) {
                j1 j1Var = (j1) obj;
                if (!j1Var.q0() && j1Var.h0() == null) {
                    arrayList.add(obj);
                }
            }
            if (!arrayList.isEmpty()) {
                sb2.append(" : ");
                sb2.append(l1("this"));
                sb2.append(r.q0(arrayList, ", ", "(", ")", 0, null, f.f13814a, 24, null));
            }
        }
        if (w0()) {
            List<f1> typeParameters2 = lVar.getTypeParameters();
            kotlin.jvm.internal.m.e(typeParameters2, "constructor.typeParameters");
            W1(typeParameters2, sb2);
        }
    }

    private final void d1(List<? extends x0> list, StringBuilder sb2) {
        if (list.isEmpty()) {
            return;
        }
        sb2.append("context(");
        int i10 = 0;
        for (x0 x0Var : list) {
            int i11 = i10 + 1;
            U0(sb2, x0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.e.RECEIVER);
            g0 type = x0Var.getType();
            kotlin.jvm.internal.m.e(type, "contextReceiver.type");
            sb2.append(g1(type));
            if (i10 == r.n(list)) {
                sb2.append(") ");
            } else {
                sb2.append(", ");
            }
            i10 = i11;
        }
    }

    private final void e1(StringBuilder sb2, g0 g0Var) {
        V0(this, sb2, g0Var, null, 2, null);
        p pVar = g0Var instanceof p ? (p) g0Var : null;
        o0 o0VarV0 = pVar != null ? pVar.V0() : null;
        if (i0.a(g0Var)) {
            if (oa.a.u(g0Var) && k0()) {
                sb2.append(f1(la.k.f15326a.p(g0Var)));
            } else {
                if (!(g0Var instanceof la.h) || d0()) {
                    sb2.append(g0Var.J0().toString());
                } else {
                    sb2.append(((la.h) g0Var).S0());
                }
                sb2.append(J1(g0Var.H0()));
            }
        } else if (g0Var instanceof kotlin.reflect.jvm.internal.impl.types.w0) {
            sb2.append(((kotlin.reflect.jvm.internal.impl.types.w0) g0Var).S0().toString());
        } else if (o0VarV0 instanceof kotlin.reflect.jvm.internal.impl.types.w0) {
            sb2.append(((kotlin.reflect.jvm.internal.impl.types.w0) o0VarV0).S0().toString());
        } else {
            M1(this, sb2, g0Var, null, 2, null);
        }
        if (g0Var.K0()) {
            sb2.append(LocationInfo.NA);
        }
        if (s0.c(g0Var)) {
            sb2.append(" & Any");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13811a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f13812b;

        static {
            int[] iArr = new int[m.values().length];
            try {
                iArr[m.PLAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[m.HTML.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f13811a = iArr;
            int[] iArr2 = new int[k.values().length];
            try {
                iArr2[k.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[k.ONLY_NON_SYNTHESIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[k.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            f13812b = iArr2;
        }
    }

    public d(kotlin.reflect.jvm.internal.impl.renderer.g options) {
        kotlin.jvm.internal.m.f(options, "options");
        this.f13807l = options;
        options.k0();
        this.f13808m = r8.j.a(new C0250d());
    }

    private final void E1(StringBuilder sb2, o0 o0Var) {
        if (kotlin.jvm.internal.m.a(o0Var, s1.f14371b) || s1.k(o0Var)) {
            sb2.append("???");
            return;
        }
        if (la.k.o(o0Var)) {
            if (!B0()) {
                sb2.append("???");
                return;
            }
            g1 g1VarJ0 = o0Var.J0();
            kotlin.jvm.internal.m.d(g1VarJ0, "null cannot be cast to non-null type org.jetbrains.kotlin.types.error.ErrorTypeConstructor");
            sb2.append(f1(((la.i) g1VarJ0).h(0)));
            return;
        }
        if (i0.a(o0Var)) {
            e1(sb2, o0Var);
        } else if (X1(o0Var)) {
            j1(sb2, o0Var);
        } else {
            e1(sb2, o0Var);
        }
    }

    private final String K0() {
        return O(">");
    }

    private final void L(StringBuilder sb2, kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.m mVarB;
        String name;
        if ((mVar instanceof l0) || (mVar instanceof q0) || (mVarB = mVar.b()) == null || (mVarB instanceof h0)) {
            return;
        }
        sb2.append(" ");
        sb2.append(o1("defined in"));
        sb2.append(" ");
        ba.d dVarM = kotlin.reflect.jvm.internal.impl.resolve.e.m(mVarB);
        kotlin.jvm.internal.m.e(dVarM, "getFqName(containingDeclaration)");
        sb2.append(dVarM.e() ? "root package" : u(dVarM));
        if (G0() && (mVarB instanceof l0) && (mVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.p) && (name = ((kotlin.reflect.jvm.internal.impl.descriptors.p) mVar).getSource().a().getName()) != null) {
            sb2.append(" ");
            sb2.append(o1("in file"));
            sb2.append(" ");
            sb2.append(name);
        }
    }

    private final e0 M0(d0 d0Var) {
        if (d0Var instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) {
            return ((kotlin.reflect.jvm.internal.impl.descriptors.e) d0Var).g() == kotlin.reflect.jvm.internal.impl.descriptors.f.INTERFACE ? e0.ABSTRACT : e0.FINAL;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = d0Var.b();
        kotlin.reflect.jvm.internal.impl.descriptors.e eVar = mVarB instanceof kotlin.reflect.jvm.internal.impl.descriptors.e ? (kotlin.reflect.jvm.internal.impl.descriptors.e) mVarB : null;
        if (eVar == null) {
            return e0.FINAL;
        }
        if (!(d0Var instanceof kotlin.reflect.jvm.internal.impl.descriptors.b)) {
            return e0.FINAL;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.b bVar = (kotlin.reflect.jvm.internal.impl.descriptors.b) d0Var;
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> collectionE = bVar.e();
        kotlin.jvm.internal.m.e(collectionE, "this.overriddenDescriptors");
        if (!collectionE.isEmpty() && eVar.i() != e0.FINAL) {
            return e0.OPEN;
        }
        if (eVar.g() != kotlin.reflect.jvm.internal.impl.descriptors.f.INTERFACE || kotlin.jvm.internal.m.a(bVar.getVisibility(), t.f13064a)) {
            return e0.FINAL;
        }
        e0 e0VarI = bVar.i();
        e0 e0Var = e0.ABSTRACT;
        return e0VarI == e0Var ? e0Var : e0.OPEN;
    }

    static /* synthetic */ void M1(d dVar, StringBuilder sb2, g0 g0Var, g1 g1Var, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            g1Var = g0Var.J0();
        }
        dVar.L1(sb2, g0Var, g1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N1(f1 f1Var, StringBuilder sb2, boolean z10) {
        if (z10) {
            sb2.append(O0());
        }
        if (E0()) {
            sb2.append("/*");
            sb2.append(f1Var.getIndex());
            sb2.append("*/ ");
        }
        r1(sb2, f1Var.z(), "reified");
        String strI = f1Var.j().i();
        boolean z11 = true;
        r1(sb2, strI.length() > 0, strI);
        V0(this, sb2, f1Var, null, 2, null);
        s1(f1Var, sb2, z10);
        int size = f1Var.getUpperBounds().size();
        if ((size > 1 && !z10) || size == 1) {
            g0 upperBound = f1Var.getUpperBounds().iterator().next();
            if (!kotlin.reflect.jvm.internal.impl.builtins.h.j0(upperBound)) {
                sb2.append(" : ");
                kotlin.jvm.internal.m.e(upperBound, "upperBound");
                sb2.append(w(upperBound));
            }
        } else if (z10) {
            for (g0 upperBound2 : f1Var.getUpperBounds()) {
                if (!kotlin.reflect.jvm.internal.impl.builtins.h.j0(upperBound2)) {
                    if (z11) {
                        sb2.append(" : ");
                    } else {
                        sb2.append(" & ");
                    }
                    kotlin.jvm.internal.m.e(upperBound2, "upperBound");
                    sb2.append(w(upperBound2));
                    z11 = false;
                }
            }
        }
        if (z10) {
            sb2.append(K0());
        }
    }

    private final String O0() {
        return O("<");
    }

    private final void Q1(kotlin.reflect.jvm.internal.impl.descriptors.k1 k1Var, StringBuilder sb2, boolean z10) {
        if (z10 || !(k1Var instanceof j1)) {
            sb2.append(l1(k1Var.f0() ? "var" : "val"));
            sb2.append(" ");
        }
    }

    static /* synthetic */ void R1(d dVar, kotlin.reflect.jvm.internal.impl.descriptors.k1 k1Var, StringBuilder sb2, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        dVar.Q1(k1Var, sb2, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x0060  */
    public final void S1(j1 j1Var, boolean z10, StringBuilder sb2, boolean z11) {
        boolean z12;
        if (z11) {
            sb2.append(l1("value-parameter"));
            sb2.append(" ");
        }
        if (E0()) {
            sb2.append("/*");
            sb2.append(j1Var.getIndex());
            sb2.append("*/ ");
        }
        V0(this, sb2, j1Var, null, 2, null);
        r1(sb2, j1Var.X(), "crossinline");
        r1(sb2, j1Var.T(), "noinline");
        boolean z13 = false;
        if (t0()) {
            kotlin.reflect.jvm.internal.impl.descriptors.a aVarB = j1Var.b();
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar = aVarB instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) aVarB : null;
            if (dVar == null || !dVar.v()) {
                z12 = false;
            } else {
                z12 = true;
            }
        } else {
            z12 = false;
        }
        if (z12) {
            r1(sb2, P(), "actual");
        }
        U1(j1Var, z10, sb2, z11, z12);
        if (V() != null) {
            if (n() ? j1Var.q0() : ea.c.c(j1Var)) {
                z13 = true;
            }
        }
        if (z13) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(" = ");
            c9.l<j1, String> lVarV = V();
            kotlin.jvm.internal.m.c(lVarV);
            sb3.append(lVarV.invoke(j1Var));
            sb2.append(sb3.toString());
        }
    }

    static /* synthetic */ void V0(d dVar, StringBuilder sb2, kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.e eVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            eVar = null;
        }
        dVar.U0(sb2, aVar, eVar);
    }

    private final d Y() {
        return (d) this.f13808m.getValue();
    }

    private final void Y0(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, StringBuilder sb2) {
        sb2.append(l1(kotlin.reflect.jvm.internal.impl.renderer.c.f13784a.a(eVar)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String b1(kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> gVar) {
        if (gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.b) {
            return r.q0(((kotlin.reflect.jvm.internal.impl.resolve.constants.b) gVar).b(), ", ", "{", "}", 0, null, new e(), 24, null);
        }
        if (gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.a) {
            return ua.n.s0(kotlin.reflect.jvm.internal.impl.renderer.c.s(this, ((kotlin.reflect.jvm.internal.impl.resolve.constants.a) gVar).b(), null, 2, null), "@");
        }
        if (!(gVar instanceof q)) {
            return gVar.toString();
        }
        q.b bVarB = ((q) gVar).b();
        if (bVarB instanceof q.b.a) {
            return ((q.b.a) bVarB).a() + "::class";
        }
        if (!(bVarB instanceof q.b.C0254b)) {
            throw new r8.n();
        }
        q.b.C0254b c0254b = (q.b.C0254b) bVarB;
        String strB = c0254b.b().b().b();
        kotlin.jvm.internal.m.e(strB, "classValue.classId.asSingleFqName().asString()");
        for (int i10 = 0; i10 < c0254b.a(); i10++) {
            strB = "kotlin.Array<" + strB + '>';
        }
        return strB + "::class";
    }

    private final void r1(StringBuilder sb2, boolean z10, String str) {
        if (z10) {
            sb2.append(l1(str));
            sb2.append(" ");
        }
    }

    private final void u1(StringBuilder sb2, g0 g0Var) {
        if ((g0Var instanceof x1) && n() && !((x1) g0Var).O0()) {
            sb2.append("<Not computed yet>");
            return;
        }
        v1 v1VarM0 = g0Var.M0();
        if (v1VarM0 instanceof a0) {
            sb2.append(((a0) v1VarM0).T0(this, this));
        } else if (v1VarM0 instanceof o0) {
            E1(sb2, (o0) v1VarM0);
        }
    }

    public c9.l<g0, g0> A0() {
        return this.f13807l.a0();
    }

    public boolean B0() {
        return this.f13807l.b0();
    }

    public boolean C0() {
        return this.f13807l.c0();
    }

    public kotlin.reflect.jvm.internal.impl.renderer.c.l D0() {
        return this.f13807l.d0();
    }

    public boolean E0() {
        return this.f13807l.e0();
    }

    public boolean F0() {
        return this.f13807l.f0();
    }

    public boolean G0() {
        return this.f13807l.g0();
    }

    public boolean H0() {
        return this.f13807l.h0();
    }

    public boolean I0() {
        return this.f13807l.i0();
    }

    public boolean J0() {
        return this.f13807l.j0();
    }

    public String J1(List<? extends k1> typeArguments) throws IOException {
        kotlin.jvm.internal.m.f(typeArguments, "typeArguments");
        if (typeArguments.isEmpty()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(O0());
        M(sb2, typeArguments);
        sb2.append(K0());
        String string = sb2.toString();
        kotlin.jvm.internal.m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public String K1(g1 typeConstructor) {
        kotlin.jvm.internal.m.f(typeConstructor, "typeConstructor");
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = typeConstructor.d();
        if (hVarD instanceof f1 ? true : hVarD instanceof kotlin.reflect.jvm.internal.impl.descriptors.e ? true : hVarD instanceof e1) {
            return Z0(hVarD);
        }
        if (hVarD == null) {
            return typeConstructor instanceof f0 ? ((f0) typeConstructor).j(h.f13815a) : typeConstructor.toString();
        }
        throw new IllegalStateException(("Unexpected classifier: " + hVarD.getClass()).toString());
    }

    public boolean P() {
        return this.f13807l.r();
    }

    public boolean Q() {
        return this.f13807l.s();
    }

    public c9.l<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, Boolean> R() {
        return this.f13807l.t();
    }

    public boolean S() {
        return this.f13807l.u();
    }

    public boolean T() {
        return this.f13807l.v();
    }

    public kotlin.reflect.jvm.internal.impl.renderer.b U() {
        return this.f13807l.w();
    }

    public c9.l<j1, String> V() {
        return this.f13807l.x();
    }

    public boolean W() {
        return this.f13807l.y();
    }

    public Set<ba.c> X() {
        return this.f13807l.z();
    }

    public boolean Z() {
        return this.f13807l.A();
    }

    public String Z0(kotlin.reflect.jvm.internal.impl.descriptors.h klass) {
        kotlin.jvm.internal.m.f(klass, "klass");
        return la.k.m(klass) ? klass.h().toString() : U().a(klass, this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void a(Set<ba.c> set) {
        kotlin.jvm.internal.m.f(set, "<set-?>");
        this.f13807l.a(set);
    }

    public boolean a0() {
        return this.f13807l.B();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void b(boolean z10) {
        this.f13807l.b(z10);
    }

    public boolean b0() {
        return this.f13807l.C();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void c(Set<? extends kotlin.reflect.jvm.internal.impl.renderer.e> set) {
        kotlin.jvm.internal.m.f(set, "<set-?>");
        this.f13807l.c(set);
    }

    public boolean c0() {
        return this.f13807l.D();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void d(k kVar) {
        kotlin.jvm.internal.m.f(kVar, "<set-?>");
        this.f13807l.d(kVar);
    }

    public boolean d0() {
        return this.f13807l.E();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void e(boolean z10) {
        this.f13807l.e(z10);
    }

    public Set<kotlin.reflect.jvm.internal.impl.renderer.e> e0() {
        return this.f13807l.F();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public boolean f() {
        return this.f13807l.f();
    }

    public boolean f0() {
        return this.f13807l.G();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void g(kotlin.reflect.jvm.internal.impl.renderer.b bVar) {
        kotlin.jvm.internal.m.f(bVar, "<set-?>");
        this.f13807l.g(bVar);
    }

    public final kotlin.reflect.jvm.internal.impl.renderer.g g0() {
        return this.f13807l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void h(boolean z10) {
        this.f13807l.h(z10);
    }

    public j h0() {
        return this.f13807l.H();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void i(boolean z10) {
        this.f13807l.i(z10);
    }

    public k i0() {
        return this.f13807l.I();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void j(boolean z10) {
        this.f13807l.j(z10);
    }

    public boolean j0() {
        return this.f13807l.J();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void k(boolean z10) {
        this.f13807l.k(z10);
    }

    public boolean k0() {
        return this.f13807l.K();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void l(m mVar) {
        kotlin.jvm.internal.m.f(mVar, "<set-?>");
        this.f13807l.l(mVar);
    }

    public l l0() {
        return this.f13807l.L();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public Set<ba.c> m() {
        return this.f13807l.m();
    }

    public boolean m0() {
        return this.f13807l.M();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public boolean n() {
        return this.f13807l.n();
    }

    public boolean n0() {
        return this.f13807l.N();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public kotlin.reflect.jvm.internal.impl.renderer.a o() {
        return this.f13807l.o();
    }

    public boolean o0() {
        return this.f13807l.O();
    }

    public String o1(String message) {
        kotlin.jvm.internal.m.f(message, "message");
        int i10 = b.f13811a[z0().ordinal()];
        if (i10 == 1) {
            return message;
        }
        if (i10 != 2) {
            throw new r8.n();
        }
        return "<i>" + message + "</i>";
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void p(boolean z10) {
        this.f13807l.p(z10);
    }

    public boolean p0() {
        return this.f13807l.P();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public String q(kotlin.reflect.jvm.internal.impl.descriptors.m declarationDescriptor) {
        kotlin.jvm.internal.m.f(declarationDescriptor, "declarationDescriptor");
        StringBuilder sb2 = new StringBuilder();
        declarationDescriptor.H(new a(), sb2);
        if (F0()) {
            L(sb2, declarationDescriptor);
        }
        String string = sb2.toString();
        kotlin.jvm.internal.m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public boolean q0() {
        return this.f13807l.Q();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public String r(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c annotation, kotlin.reflect.jvm.internal.impl.descriptors.annotations.e eVar) throws IOException {
        kotlin.jvm.internal.m.f(annotation, "annotation");
        StringBuilder sb2 = new StringBuilder();
        sb2.append('@');
        if (eVar != null) {
            sb2.append(eVar.f() + ':');
        }
        g0 type = annotation.getType();
        sb2.append(w(type));
        if (a0()) {
            List<String> listT0 = T0(annotation);
            if (b0() || !listT0.isEmpty()) {
                c0.n0(listT0, sb2, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : "(", (124 & 8) == 0 ? ")" : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null);
            }
        }
        if (E0() && (i0.a(type) || (type.J0().d() instanceof k0.b))) {
            sb2.append(" /* annotation class not found */");
        }
        String string = sb2.toString();
        kotlin.jvm.internal.m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public boolean r0() {
        return this.f13807l.R();
    }

    public boolean s0() {
        return this.f13807l.S();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public String t(String lowerRendered, String upperRendered, kotlin.reflect.jvm.internal.impl.builtins.h builtIns) {
        kotlin.jvm.internal.m.f(lowerRendered, "lowerRendered");
        kotlin.jvm.internal.m.f(upperRendered, "upperRendered");
        kotlin.jvm.internal.m.f(builtIns, "builtIns");
        if (n.f(lowerRendered, upperRendered)) {
            if (!ua.n.I(upperRendered, "(", false, 2, null)) {
                return lowerRendered + '!';
            }
            return '(' + lowerRendered + ")!";
        }
        kotlin.reflect.jvm.internal.impl.renderer.b bVarU = U();
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarW = builtIns.w();
        kotlin.jvm.internal.m.e(eVarW, "builtIns.collection");
        String strO0 = ua.n.O0(bVarU.a(eVarW, this), "Collection", null, 2, null);
        String strD = n.d(lowerRendered, strO0 + "Mutable", upperRendered, strO0, strO0 + "(Mutable)");
        if (strD != null) {
            return strD;
        }
        String strD2 = n.d(lowerRendered, strO0 + "MutableMap.MutableEntry", upperRendered, strO0 + "Map.Entry", strO0 + "(Mutable)Map.(Mutable)Entry");
        if (strD2 != null) {
            return strD2;
        }
        kotlin.reflect.jvm.internal.impl.renderer.b bVarU2 = U();
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarJ = builtIns.j();
        kotlin.jvm.internal.m.e(eVarJ, "builtIns.array");
        String strO1 = ua.n.O0(bVarU2.a(eVarJ, this), "Array", null, 2, null);
        String strD3 = n.d(lowerRendered, strO1 + O("Array<"), upperRendered, strO1 + O("Array<out "), strO1 + O("Array<(out) "));
        if (strD3 != null) {
            return strD3;
        }
        return '(' + lowerRendered + ".." + upperRendered + ')';
    }

    public boolean t0() {
        return this.f13807l.T();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public String u(ba.d fqName) {
        kotlin.jvm.internal.m.f(fqName, "fqName");
        List<ba.f> listH = fqName.h();
        kotlin.jvm.internal.m.e(listH, "fqName.pathSegments()");
        return h1(listH);
    }

    public boolean u0() {
        return this.f13807l.U();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public String v(ba.f name, boolean z10) {
        kotlin.jvm.internal.m.f(name, "name");
        String strO = O(n.b(name));
        if (!S() || z0() != m.HTML || !z10) {
            return strO;
        }
        return "<b>" + strO + "</b>";
    }

    public boolean v0() {
        return this.f13807l.V();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public String w(g0 type) {
        kotlin.jvm.internal.m.f(type, "type");
        StringBuilder sb2 = new StringBuilder();
        t1(sb2, A0().invoke(type));
        String string = sb2.toString();
        kotlin.jvm.internal.m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public boolean w0() {
        return this.f13807l.W();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.c
    public String x(k1 typeProjection) throws IOException {
        kotlin.jvm.internal.m.f(typeProjection, "typeProjection");
        StringBuilder sb2 = new StringBuilder();
        M(sb2, r.e(typeProjection));
        String string = sb2.toString();
        kotlin.jvm.internal.m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public boolean x0() {
        return this.f13807l.X();
    }

    public boolean y0() {
        return this.f13807l.Y();
    }

    public m z0() {
        return this.f13807l.Z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A1(u0 u0Var, StringBuilder sb2) throws IOException {
        u0 u0Var2;
        StringBuilder sb3;
        boolean z10;
        if (!y0()) {
            if (!x0()) {
                B1(u0Var, sb2);
                List<x0> listN0 = u0Var.n0();
                kotlin.jvm.internal.m.e(listN0, "property.contextReceiverParameters");
                d1(listN0, sb2);
                u visibility = u0Var.getVisibility();
                kotlin.jvm.internal.m.e(visibility, "property.visibility");
                V1(visibility, sb2);
                boolean z11 = false;
                if (e0().contains(kotlin.reflect.jvm.internal.impl.renderer.e.CONST) && u0Var.isConst()) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                r1(sb2, z10, "const");
                n1(u0Var, sb2);
                q1(u0Var, sb2);
                v1(u0Var, sb2);
                if (e0().contains(kotlin.reflect.jvm.internal.impl.renderer.e.LATEINIT) && u0Var.o0()) {
                    z11 = true;
                }
                r1(sb2, z11, "lateinit");
                m1(u0Var, sb2);
            }
            u0Var2 = u0Var;
            sb3 = sb2;
            R1(this, u0Var2, sb3, false, 4, null);
            List<f1> typeParameters = u0Var2.getTypeParameters();
            kotlin.jvm.internal.m.e(typeParameters, "property.typeParameters");
            P1(typeParameters, sb3, true);
            C1(u0Var2, sb3);
        } else {
            u0Var2 = u0Var;
            sb3 = sb2;
        }
        s1(u0Var2, sb3, true);
        sb3.append(": ");
        g0 type = u0Var2.getType();
        kotlin.jvm.internal.m.e(type, "property.type");
        sb3.append(w(type));
        D1(u0Var2, sb3);
        k1(u0Var2, sb3);
        List<f1> typeParameters2 = u0Var2.getTypeParameters();
        kotlin.jvm.internal.m.e(typeParameters2, "property.typeParameters");
        W1(typeParameters2, sb3);
    }

    private final void B1(u0 u0Var, StringBuilder sb2) {
        if (e0().contains(kotlin.reflect.jvm.internal.impl.renderer.e.ANNOTATIONS)) {
            V0(this, sb2, u0Var, null, 2, null);
            w wVarM0 = u0Var.m0();
            if (wVarM0 != null) {
                U0(sb2, wVarM0, kotlin.reflect.jvm.internal.impl.descriptors.annotations.e.FIELD);
            }
            w wVarJ0 = u0Var.j0();
            if (wVarJ0 != null) {
                U0(sb2, wVarJ0, kotlin.reflect.jvm.internal.impl.descriptors.annotations.e.PROPERTY_DELEGATE_FIELD);
            }
            if (l0() == l.NONE) {
                v0 getter = u0Var.getGetter();
                if (getter != null) {
                    U0(sb2, getter, kotlin.reflect.jvm.internal.impl.descriptors.annotations.e.PROPERTY_GETTER);
                }
                w0 setter = u0Var.getSetter();
                if (setter != null) {
                    U0(sb2, setter, kotlin.reflect.jvm.internal.impl.descriptors.annotations.e.PROPERTY_SETTER);
                    List<j1> listF = setter.f();
                    kotlin.jvm.internal.m.e(listF, "setter.valueParameters");
                    j1 it = (j1) r.F0(listF);
                    kotlin.jvm.internal.m.e(it, "it");
                    U0(sb2, it, kotlin.reflect.jvm.internal.impl.descriptors.annotations.e.SETTER_PARAMETER);
                }
            }
        }
    }

    private final void C1(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, StringBuilder sb2) {
        x0 x0VarI0 = aVar.i0();
        if (x0VarI0 != null) {
            U0(sb2, x0VarI0, kotlin.reflect.jvm.internal.impl.descriptors.annotations.e.RECEIVER);
            g0 type = x0VarI0.getType();
            kotlin.jvm.internal.m.e(type, "receiver.type");
            sb2.append(g1(type));
            sb2.append(".");
        }
    }

    private final void D1(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, StringBuilder sb2) {
        x0 x0VarI0;
        if (m0() && (x0VarI0 = aVar.i0()) != null) {
            sb2.append(" on ");
            g0 type = x0VarI0.getType();
            kotlin.jvm.internal.m.e(type, "receiver.type");
            sb2.append(w(type));
        }
    }

    private final void F1(StringBuilder sb2) {
        int length = sb2.length();
        if (length != 0 && sb2.charAt(length - 1) == ' ') {
            return;
        }
        sb2.append(' ');
    }

    private final void G1(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, StringBuilder sb2) throws IOException {
        if (!I0() && !kotlin.reflect.jvm.internal.impl.builtins.h.n0(eVar.p())) {
            Collection<g0> collectionB = eVar.h().b();
            kotlin.jvm.internal.m.e(collectionB, "klass.typeConstructor.supertypes");
            if (!collectionB.isEmpty()) {
                if (collectionB.size() != 1 || !kotlin.reflect.jvm.internal.impl.builtins.h.b0(collectionB.iterator().next())) {
                    F1(sb2);
                    sb2.append(": ");
                    c0.n0(collectionB, sb2, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : new g());
                }
            }
        }
    }

    private final void H1(y yVar, StringBuilder sb2) {
        r1(sb2, yVar.isSuspend(), "suspend");
    }

    private final boolean L0(g0 g0Var) {
        if (!kotlin.reflect.jvm.internal.impl.builtins.g.q(g0Var) && g0Var.getAnnotations().isEmpty()) {
            return false;
        }
        return true;
    }

    private final void L1(StringBuilder sb2, g0 g0Var, g1 g1Var) {
        kotlin.reflect.jvm.internal.impl.descriptors.s0 s0VarA = kotlin.reflect.jvm.internal.impl.descriptors.g1.a(g0Var);
        if (s0VarA == null) {
            sb2.append(K1(g1Var));
            sb2.append(J1(g0Var.H0()));
        } else {
            z1(sb2, s0VarA);
        }
    }

    private final String N() {
        int i10 = b.f13811a[z0().ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                return "&rarr;";
            }
            throw new r8.n();
        }
        return O("->");
    }

    private final boolean N0(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        return kotlin.jvm.internal.m.a(cVar.d(), kotlin.reflect.jvm.internal.impl.builtins.k.a.E);
    }

    private final String O(String str) {
        return z0().f(str);
    }

    private final void O1(StringBuilder sb2, List<? extends f1> list) {
        Iterator<? extends f1> it = list.iterator();
        while (it.hasNext()) {
            N1(it.next(), sb2, false);
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
    }

    private final boolean P0(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
        return !bVar.e().isEmpty();
    }

    private final void P1(List<? extends f1> list, StringBuilder sb2, boolean z10) {
        if (!J0() && !list.isEmpty()) {
            sb2.append(O0());
            O1(sb2, list);
            sb2.append(K0());
            if (z10) {
                sb2.append(" ");
            }
        }
    }

    private final void Q0(StringBuilder sb2, kotlin.reflect.jvm.internal.impl.types.a aVar) {
        m mVarZ0 = z0();
        m mVar = m.HTML;
        if (mVarZ0 == mVar) {
            sb2.append("<font color=\"808080\"><i>");
        }
        sb2.append(" /* = ");
        u1(sb2, aVar.R());
        sb2.append(" */");
        if (z0() == mVar) {
            sb2.append("</i></font>");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R0(t0 t0Var, StringBuilder sb2) {
        n1(t0Var, sb2);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003b  */
    private final void S0(y yVar, StringBuilder sb2) {
        boolean z10;
        boolean z11 = false;
        if (yVar.isOperator()) {
            Collection<? extends y> collectionE = yVar.e();
            kotlin.jvm.internal.m.e(collectionE, "functionDescriptor.overriddenDescriptors");
            Collection<? extends y> collection = collectionE;
            if (!collection.isEmpty()) {
                Iterator<T> it = collection.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((y) it.next()).isOperator()) {
                            if (!Q()) {
                                z10 = false;
                            }
                        }
                    }
                }
            }
            z10 = true;
        } else {
            z10 = false;
        }
        if (yVar.isInfix()) {
            Collection<? extends y> collectionE2 = yVar.e();
            kotlin.jvm.internal.m.e(collectionE2, "functionDescriptor.overriddenDescriptors");
            Collection<? extends y> collection2 = collectionE2;
            if (!collection2.isEmpty()) {
                Iterator<T> it2 = collection2.iterator();
                while (it2.hasNext()) {
                    if (((y) it2.next()).isInfix()) {
                        if (Q()) {
                            break;
                        }
                    }
                }
                z11 = true;
            } else {
                z11 = true;
            }
        }
        r1(sb2, yVar.L(), "tailrec");
        H1(yVar, sb2);
        r1(sb2, yVar.isInline(), "inline");
        r1(sb2, z11, "infix");
        r1(sb2, z10, "operator");
    }

    private final List<String> T0(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarI;
        String strB1;
        kotlin.reflect.jvm.internal.impl.descriptors.d dVarM;
        List<j1> listF;
        Map<ba.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> mapA = cVar.a();
        List listL = null;
        if (q0()) {
            eVarI = ea.c.i(cVar);
        } else {
            eVarI = null;
        }
        if (eVarI != null && (dVarM = eVarI.M()) != null && (listF = dVarM.f()) != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : listF) {
                if (((j1) obj).q0()) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(r.w(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((j1) it.next()).getName());
            }
            listL = arrayList2;
        }
        if (listL == null) {
            listL = r.l();
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listL) {
            ba.f it2 = (ba.f) obj2;
            kotlin.jvm.internal.m.e(it2, "it");
            if (!mapA.containsKey(it2)) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList(r.w(arrayList3, 10));
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            arrayList4.add(((ba.f) it3.next()).f() + " = ...");
        }
        Set<Map.Entry<ba.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>>> setEntrySet = mapA.entrySet();
        ArrayList arrayList5 = new ArrayList(r.w(setEntrySet, 10));
        Iterator<T> it4 = setEntrySet.iterator();
        while (it4.hasNext()) {
            Map.Entry entry = (Map.Entry) it4.next();
            ba.f fVar = (ba.f) entry.getKey();
            kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> gVar = (kotlin.reflect.jvm.internal.impl.resolve.constants.g) entry.getValue();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(fVar.f());
            sb2.append(" = ");
            if (!listL.contains(fVar)) {
                strB1 = b1(gVar);
            } else {
                strB1 = "...";
            }
            sb2.append(strB1);
            arrayList5.add(sb2.toString());
        }
        return r.I0(r.B0(arrayList4, arrayList5));
    }

    private final void T1(Collection<? extends j1> collection, boolean z10, StringBuilder sb2) {
        boolean zY1 = Y1(z10);
        int size = collection.size();
        D0().b(size, sb2);
        int i10 = 0;
        for (j1 j1Var : collection) {
            D0().a(j1Var, i10, size, sb2);
            S1(j1Var, zY1, sb2, false);
            D0().d(j1Var, i10, size, sb2);
            i10++;
        }
        D0().c(size, sb2);
    }

    private final void U0(StringBuilder sb2, kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.e eVar) {
        Set<ba.c> setX;
        if (e0().contains(kotlin.reflect.jvm.internal.impl.renderer.e.ANNOTATIONS)) {
            if (aVar instanceof g0) {
                setX = m();
            } else {
                setX = X();
            }
            c9.l<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, Boolean> lVarR = R();
            for (kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar : aVar.getAnnotations()) {
                if (!r.a0(setX, cVar.d()) && !N0(cVar) && (lVarR == null || lVarR.invoke(cVar).booleanValue())) {
                    sb2.append(r(cVar, eVar));
                    if (W()) {
                        sb2.append('\n');
                        kotlin.jvm.internal.m.e(sb2, "append('\\n')");
                    } else {
                        sb2.append(" ");
                    }
                }
            }
        }
    }

    private final void U1(kotlin.reflect.jvm.internal.impl.descriptors.k1 k1Var, boolean z10, StringBuilder sb2, boolean z11, boolean z12) {
        j1 j1Var;
        g0 g0Var;
        boolean z13;
        g0 type = k1Var.getType();
        kotlin.jvm.internal.m.e(type, "variable.type");
        g0 g0VarH0 = null;
        if (k1Var instanceof j1) {
            j1Var = (j1) k1Var;
        } else {
            j1Var = null;
        }
        if (j1Var != null) {
            g0VarH0 = j1Var.h0();
        }
        if (g0VarH0 == null) {
            g0Var = type;
        } else {
            g0Var = g0VarH0;
        }
        if (g0VarH0 != null) {
            z13 = true;
        } else {
            z13 = false;
        }
        r1(sb2, z13, "vararg");
        if (z12 || (z11 && !y0())) {
            Q1(k1Var, sb2, z12);
        }
        if (z10) {
            s1(k1Var, sb2, z11);
            sb2.append(": ");
        }
        sb2.append(w(g0Var));
        k1(k1Var, sb2);
        if (E0() && g0VarH0 != null) {
            sb2.append(" /*");
            sb2.append(w(type));
            sb2.append("*/");
        }
    }

    private final boolean V1(u uVar, StringBuilder sb2) {
        if (!e0().contains(kotlin.reflect.jvm.internal.impl.renderer.e.VISIBILITY)) {
            return false;
        }
        if (f0()) {
            uVar = uVar.f();
        }
        if (!s0() && kotlin.jvm.internal.m.a(uVar, t.f13075l)) {
            return false;
        }
        sb2.append(l1(uVar.c()));
        sb2.append(" ");
        return true;
    }

    private final void W0(kotlin.reflect.jvm.internal.impl.descriptors.i iVar, StringBuilder sb2) {
        List<f1> listR = iVar.r();
        kotlin.jvm.internal.m.e(listR, "classifier.declaredTypeParameters");
        List<f1> parameters = iVar.h().getParameters();
        kotlin.jvm.internal.m.e(parameters, "classifier.typeConstructor.parameters");
        if (E0() && iVar.J() && parameters.size() > listR.size()) {
            sb2.append(" /*captured type parameters: ");
            O1(sb2, parameters.subList(listR.size(), parameters.size()));
            sb2.append("*/");
        }
    }

    private final void W1(List<? extends f1> list, StringBuilder sb2) throws IOException {
        if (!J0()) {
            ArrayList arrayList = new ArrayList(0);
            for (f1 f1Var : list) {
                List<g0> upperBounds = f1Var.getUpperBounds();
                kotlin.jvm.internal.m.e(upperBounds, "typeParameter.upperBounds");
                for (g0 it : r.c0(upperBounds, 1)) {
                    StringBuilder sb3 = new StringBuilder();
                    ba.f name = f1Var.getName();
                    kotlin.jvm.internal.m.e(name, "typeParameter.name");
                    sb3.append(v(name, false));
                    sb3.append(" : ");
                    kotlin.jvm.internal.m.e(it, "it");
                    sb3.append(w(it));
                    arrayList.add(sb3.toString());
                }
            }
            if (!arrayList.isEmpty()) {
                sb2.append(" ");
                sb2.append(l1("where"));
                sb2.append(" ");
                c0.n0(arrayList, sb2, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X0(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, StringBuilder sb2) throws IOException {
        boolean z10;
        kotlin.reflect.jvm.internal.impl.descriptors.d dVarM;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        if (eVar.g() == kotlin.reflect.jvm.internal.impl.descriptors.f.ENUM_ENTRY) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!y0()) {
            V0(this, sb2, eVar, null, 2, null);
            List<x0> listC0 = eVar.C0();
            kotlin.jvm.internal.m.e(listC0, "klass.contextReceivers");
            d1(listC0, sb2);
            if (!z10) {
                u visibility = eVar.getVisibility();
                kotlin.jvm.internal.m.e(visibility, "klass.visibility");
                V1(visibility, sb2);
            }
            if ((eVar.g() != kotlin.reflect.jvm.internal.impl.descriptors.f.INTERFACE || eVar.i() != e0.ABSTRACT) && (!eVar.g().f() || eVar.i() != e0.FINAL)) {
                e0 e0VarI = eVar.i();
                kotlin.jvm.internal.m.e(e0VarI, "klass.modality");
                p1(e0VarI, sb2, M0(eVar));
            }
            n1(eVar, sb2);
            if (e0().contains(kotlin.reflect.jvm.internal.impl.renderer.e.INNER) && eVar.J()) {
                z11 = true;
            } else {
                z11 = false;
            }
            r1(sb2, z11, "inner");
            if (e0().contains(kotlin.reflect.jvm.internal.impl.renderer.e.DATA) && eVar.E0()) {
                z12 = true;
            } else {
                z12 = false;
            }
            r1(sb2, z12, "data");
            if (e0().contains(kotlin.reflect.jvm.internal.impl.renderer.e.INLINE) && eVar.isInline()) {
                z13 = true;
            } else {
                z13 = false;
            }
            r1(sb2, z13, "inline");
            if (e0().contains(kotlin.reflect.jvm.internal.impl.renderer.e.VALUE) && eVar.F()) {
                z14 = true;
            } else {
                z14 = false;
            }
            r1(sb2, z14, "value");
            if (e0().contains(kotlin.reflect.jvm.internal.impl.renderer.e.FUN) && eVar.x()) {
                z15 = true;
            } else {
                z15 = false;
            }
            r1(sb2, z15, "fun");
            Y0(eVar, sb2);
        }
        if (!kotlin.reflect.jvm.internal.impl.resolve.e.x(eVar)) {
            if (!y0()) {
                F1(sb2);
            }
            s1(eVar, sb2, true);
        } else {
            a1(eVar, sb2);
        }
        if (z10) {
            return;
        }
        List<f1> listR = eVar.r();
        kotlin.jvm.internal.m.e(listR, "klass.declaredTypeParameters");
        P1(listR, sb2, false);
        W0(eVar, sb2);
        if (!eVar.g().f() && T() && (dVarM = eVar.M()) != null) {
            sb2.append(" ");
            V0(this, sb2, dVarM, null, 2, null);
            u visibility2 = dVarM.getVisibility();
            kotlin.jvm.internal.m.e(visibility2, "primaryConstructor.visibility");
            V1(visibility2, sb2);
            sb2.append(l1("constructor"));
            List<j1> listF = dVarM.f();
            kotlin.jvm.internal.m.e(listF, "primaryConstructor.valueParameters");
            T1(listF, dVarM.A(), sb2);
        }
        G1(eVar, sb2);
        W1(listR, sb2);
    }

    private final boolean X1(g0 g0Var) {
        if (kotlin.reflect.jvm.internal.impl.builtins.g.o(g0Var)) {
            List<k1> listH0 = g0Var.H0();
            if (!(listH0 instanceof Collection) || !listH0.isEmpty()) {
                Iterator<T> it = listH0.iterator();
                while (it.hasNext()) {
                    if (((k1) it.next()).b()) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }
        return false;
    }

    private final boolean Y1(boolean z10) {
        int i10 = b.f13812b[i0().ordinal()];
        if (i10 == 1) {
            return true;
        }
        if (i10 != 2) {
            if (i10 == 3) {
                return false;
            }
            throw new r8.n();
        }
        if (!z10) {
            return true;
        }
        return false;
    }

    private final void a1(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, StringBuilder sb2) {
        if (n0()) {
            if (y0()) {
                sb2.append("companion object");
            }
            F1(sb2);
            kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = mVar.b();
            if (mVarB != null) {
                sb2.append("of ");
                ba.f name = mVarB.getName();
                kotlin.jvm.internal.m.e(name, "containingDeclaration.name");
                sb2.append(v(name, false));
            }
        }
        if (!E0() && kotlin.jvm.internal.m.a(mVar.getName(), ba.h.f945d)) {
            return;
        }
        if (!y0()) {
            F1(sb2);
        }
        ba.f name2 = mVar.getName();
        kotlin.jvm.internal.m.e(name2, "descriptor.name");
        sb2.append(v(name2, true));
    }

    private final String f1(String str) {
        int i10 = b.f13811a[z0().ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                return "<font color=red><b>" + str + "</b></font>";
            }
            throw new r8.n();
        }
        return str;
    }

    private final String g1(g0 g0Var) {
        String strW = w(g0Var);
        if ((X1(g0Var) && !s1.l(g0Var)) || (g0Var instanceof p)) {
            return '(' + strW + ')';
        }
        return strW;
    }

    private final String h1(List<ba.f> list) {
        return O(n.c(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i1(y yVar, StringBuilder sb2) throws IOException {
        y yVar2;
        StringBuilder sb3;
        String strW;
        if (!y0()) {
            if (!x0()) {
                yVar2 = yVar;
                sb3 = sb2;
                V0(this, sb3, yVar2, null, 2, null);
                List<x0> listN0 = yVar2.n0();
                kotlin.jvm.internal.m.e(listN0, "function.contextReceiverParameters");
                d1(listN0, sb3);
                u visibility = yVar2.getVisibility();
                kotlin.jvm.internal.m.e(visibility, "function.visibility");
                V1(visibility, sb3);
                q1(yVar2, sb3);
                if (Z()) {
                    n1(yVar2, sb3);
                }
                v1(yVar2, sb3);
                if (Z()) {
                    S0(yVar2, sb3);
                } else {
                    H1(yVar2, sb3);
                }
                m1(yVar2, sb3);
                if (E0()) {
                    if (yVar2.s0()) {
                        sb3.append("/*isHiddenToOvercomeSignatureClash*/ ");
                    }
                    if (yVar2.y0()) {
                        sb3.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
                    }
                }
            } else {
                yVar2 = yVar;
                sb3 = sb2;
            }
            sb3.append(l1("fun"));
            sb3.append(" ");
            List<f1> typeParameters = yVar2.getTypeParameters();
            kotlin.jvm.internal.m.e(typeParameters, "function.typeParameters");
            P1(typeParameters, sb3, true);
            C1(yVar2, sb3);
        } else {
            yVar2 = yVar;
            sb3 = sb2;
        }
        s1(yVar2, sb3, true);
        List<j1> listF = yVar2.f();
        kotlin.jvm.internal.m.e(listF, "function.valueParameters");
        T1(listF, yVar2.A(), sb3);
        D1(yVar2, sb3);
        g0 returnType = yVar2.getReturnType();
        if (!H0() && (C0() || returnType == null || !kotlin.reflect.jvm.internal.impl.builtins.h.C0(returnType))) {
            sb3.append(": ");
            if (returnType == null) {
                strW = "[NULL]";
            } else {
                strW = w(returnType);
            }
            sb3.append(strW);
        }
        List<f1> typeParameters2 = yVar2.getTypeParameters();
        kotlin.jvm.internal.m.e(typeParameters2, "function.typeParameters");
        W1(typeParameters2, sb3);
    }

    private final void j1(StringBuilder sb2, g0 g0Var) {
        boolean z10;
        boolean z11;
        ba.f fVarD;
        boolean z12;
        int length = sb2.length();
        V0(Y(), sb2, g0Var, null, 2, null);
        if (sb2.length() != length) {
            z10 = true;
        } else {
            z10 = false;
        }
        g0 g0VarJ = kotlin.reflect.jvm.internal.impl.builtins.g.j(g0Var);
        List<g0> listE = kotlin.reflect.jvm.internal.impl.builtins.g.e(g0Var);
        if (!listE.isEmpty()) {
            sb2.append("context(");
            Iterator<g0> it = listE.subList(0, r.n(listE)).iterator();
            while (it.hasNext()) {
                t1(sb2, it.next());
                sb2.append(", ");
            }
            t1(sb2, (g0) r.s0(listE));
            sb2.append(") ");
        }
        boolean zQ = kotlin.reflect.jvm.internal.impl.builtins.g.q(g0Var);
        boolean zK0 = g0Var.K0();
        if (!zK0 && (!z10 || g0VarJ == null)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            if (zQ) {
                sb2.insert(length, '(');
            } else {
                if (z10) {
                    ua.a.c(ua.n.U0(sb2));
                    if (sb2.charAt(ua.n.V(sb2) - 1) != ')') {
                        sb2.insert(ua.n.V(sb2), "()");
                    }
                }
                sb2.append("(");
            }
        }
        r1(sb2, zQ, "suspend");
        if (g0VarJ != null) {
            if ((!X1(g0VarJ) || g0VarJ.K0()) && !L0(g0VarJ) && !(g0VarJ instanceof p)) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (z12) {
                sb2.append("(");
            }
            t1(sb2, g0VarJ);
            if (z12) {
                sb2.append(")");
            }
            sb2.append(".");
        }
        sb2.append("(");
        if (kotlin.reflect.jvm.internal.impl.builtins.g.m(g0Var) && g0Var.H0().size() <= 1) {
            sb2.append("???");
        } else {
            int i10 = 0;
            for (k1 k1Var : kotlin.reflect.jvm.internal.impl.builtins.g.l(g0Var)) {
                int i11 = i10 + 1;
                if (i10 > 0) {
                    sb2.append(", ");
                }
                if (j0()) {
                    g0 type = k1Var.getType();
                    kotlin.jvm.internal.m.e(type, "typeProjection.type");
                    fVarD = kotlin.reflect.jvm.internal.impl.builtins.g.d(type);
                } else {
                    fVarD = null;
                }
                if (fVarD != null) {
                    sb2.append(v(fVarD, false));
                    sb2.append(": ");
                }
                sb2.append(x(k1Var));
                i10 = i11;
            }
        }
        sb2.append(") ");
        sb2.append(N());
        sb2.append(" ");
        t1(sb2, kotlin.reflect.jvm.internal.impl.builtins.g.k(g0Var));
        if (z11) {
            sb2.append(")");
        }
        if (zK0) {
            sb2.append(LocationInfo.NA);
        }
    }

    private final void k1(kotlin.reflect.jvm.internal.impl.descriptors.k1 k1Var, StringBuilder sb2) {
        kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> gVarS;
        if (c0() && (gVarS = k1Var.S()) != null) {
            sb2.append(" = ");
            sb2.append(O(b1(gVarS)));
        }
    }

    private final String l1(String str) {
        int i10 = b.f13811a[z0().ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                if (!S()) {
                    return "<b>" + str + "</b>";
                }
            } else {
                throw new r8.n();
            }
        }
        return str;
    }

    private final void m1(kotlin.reflect.jvm.internal.impl.descriptors.b bVar, StringBuilder sb2) {
        if (e0().contains(kotlin.reflect.jvm.internal.impl.renderer.e.MEMBER_KIND) && E0() && bVar.g() != kotlin.reflect.jvm.internal.impl.descriptors.b.a.DECLARATION) {
            sb2.append("/*");
            sb2.append(qa.a.f(bVar.g().name()));
            sb2.append("*/ ");
        }
    }

    private final void n1(d0 d0Var, StringBuilder sb2) {
        boolean z10;
        r1(sb2, d0Var.isExternal(), "external");
        boolean z11 = false;
        if (e0().contains(kotlin.reflect.jvm.internal.impl.renderer.e.EXPECT) && d0Var.I()) {
            z10 = true;
        } else {
            z10 = false;
        }
        r1(sb2, z10, "expect");
        if (e0().contains(kotlin.reflect.jvm.internal.impl.renderer.e.ACTUAL) && d0Var.A0()) {
            z11 = true;
        }
        r1(sb2, z11, "actual");
    }

    private final void p1(e0 e0Var, StringBuilder sb2, e0 e0Var2) {
        if (!r0() && e0Var == e0Var2) {
            return;
        }
        r1(sb2, e0().contains(kotlin.reflect.jvm.internal.impl.renderer.e.MODALITY), qa.a.f(e0Var.name()));
    }

    private final void q1(kotlin.reflect.jvm.internal.impl.descriptors.b bVar, StringBuilder sb2) {
        if (!kotlin.reflect.jvm.internal.impl.resolve.e.J(bVar) || bVar.i() != e0.FINAL) {
            if (h0() == j.RENDER_OVERRIDE && bVar.i() == e0.OPEN && P0(bVar)) {
                return;
            }
            e0 e0VarI = bVar.i();
            kotlin.jvm.internal.m.e(e0VarI, "callable.modality");
            p1(e0VarI, sb2, M0(bVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s1(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, StringBuilder sb2, boolean z10) {
        ba.f name = mVar.getName();
        kotlin.jvm.internal.m.e(name, "descriptor.name");
        sb2.append(v(name, z10));
    }

    private final void t1(StringBuilder sb2, g0 g0Var) {
        kotlin.reflect.jvm.internal.impl.types.a aVar;
        v1 v1VarM0 = g0Var.M0();
        if (v1VarM0 instanceof kotlin.reflect.jvm.internal.impl.types.a) {
            aVar = (kotlin.reflect.jvm.internal.impl.types.a) v1VarM0;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            if (u0()) {
                u1(sb2, aVar.R());
                return;
            }
            u1(sb2, aVar.V0());
            if (v0()) {
                Q0(sb2, aVar);
                return;
            }
            return;
        }
        u1(sb2, g0Var);
    }

    private final void v1(kotlin.reflect.jvm.internal.impl.descriptors.b bVar, StringBuilder sb2) {
        if (e0().contains(kotlin.reflect.jvm.internal.impl.renderer.e.OVERRIDE) && P0(bVar) && h0() != j.RENDER_OPEN) {
            r1(sb2, true, "override");
            if (E0()) {
                sb2.append("/*");
                sb2.append(bVar.e().size());
                sb2.append("*/ ");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w1(l0 l0Var, StringBuilder sb2) {
        x1(l0Var.d(), "package-fragment", sb2);
        if (n()) {
            sb2.append(" in ");
            s1(l0Var.b(), sb2, false);
        }
    }

    private final void x1(ba.c cVar, String str, StringBuilder sb2) {
        sb2.append(l1(str));
        ba.d dVarJ = cVar.j();
        kotlin.jvm.internal.m.e(dVarJ, "fqName.toUnsafe()");
        String strU = u(dVarJ);
        if (strU.length() > 0) {
            sb2.append(" ");
            sb2.append(strU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y1(q0 q0Var, StringBuilder sb2) {
        x1(q0Var.d(), "package", sb2);
        if (n()) {
            sb2.append(" in context of ");
            s1(q0Var.r0(), sb2, false);
        }
    }

    private final void z1(StringBuilder sb2, kotlin.reflect.jvm.internal.impl.descriptors.s0 s0Var) {
        kotlin.reflect.jvm.internal.impl.descriptors.s0 s0VarC = s0Var.c();
        if (s0VarC != null) {
            z1(sb2, s0VarC);
            sb2.append('.');
            ba.f name = s0Var.b().getName();
            kotlin.jvm.internal.m.e(name, "possiblyInnerType.classifierDescriptor.name");
            sb2.append(v(name, false));
        } else {
            g1 g1VarH = s0Var.b().h();
            kotlin.jvm.internal.m.e(g1VarH, "possiblyInnerType.classi…escriptor.typeConstructor");
            sb2.append(K1(g1VarH));
        }
        sb2.append(J1(s0Var.a()));
    }
}
