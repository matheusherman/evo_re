package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import c9.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.types.a0;
import kotlin.reflect.jvm.internal.impl.types.c1;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.j1;
import kotlin.reflect.jvm.internal.impl.types.k1;
import kotlin.reflect.jvm.internal.impl.types.n0;
import kotlin.reflect.jvm.internal.impl.types.o0;
import r8.p;
import ua.n;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class h extends a0 implements n0 {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends o implements l<String, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f13409a = new a();

        a() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(String it) {
            m.f(it, "it");
            return "(raw) " + it;
        }
    }

    private h(o0 o0Var, o0 o0Var2, boolean z10) {
        super(o0Var, o0Var2);
        if (z10) {
            return;
        }
        kotlin.reflect.jvm.internal.impl.types.checker.e.f14235a.d(o0Var, o0Var2);
    }

    private static final boolean W0(String str, String str2) {
        return m.a(str, n.s0(str2, "out ")) || m.a(str2, "*");
    }

    private static final String Y0(String str, String str2) {
        if (!n.N(str, '<', false, 2, null)) {
            return str;
        }
        return n.N0(str, '<', null, 2, null) + '<' + str2 + '>' + n.K0(str, '>', null, 2, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.a0
    public String T0(kotlin.reflect.jvm.internal.impl.renderer.c renderer, kotlin.reflect.jvm.internal.impl.renderer.f options) {
        p pVar;
        m.f(renderer, "renderer");
        m.f(options, "options");
        String strW = renderer.w(R0());
        String strW2 = renderer.w(S0());
        if (options.n()) {
            return "raw (" + strW + ".." + strW2 + ')';
        }
        if (S0().H0().isEmpty()) {
            return renderer.t(strW, strW2, oa.a.i(this));
        }
        List<String> listX0 = X0(renderer, R0());
        List<String> listX1 = X0(renderer, S0());
        List<String> list = listX0;
        String strQ0 = r.q0(list, ", ", null, null, 0, null, a.f13409a, 30, null);
        List listW0 = r.W0(list, listX1);
        if (!(listW0 instanceof Collection) || !listW0.isEmpty()) {
            Iterator it = listW0.iterator();
            do {
                if (!it.hasNext()) {
                    strW2 = Y0(strW2, strQ0);
                    break;
                }
                pVar = (p) it.next();
            } while (W0((String) pVar.c(), (String) pVar.d()));
        } else {
            strW2 = Y0(strW2, strQ0);
            break;
        }
        String strY0 = Y0(strW, strQ0);
        return m.a(strY0, strW2) ? strY0 : renderer.t(strY0, strW2, oa.a.i(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.v1
    /* JADX INFO: renamed from: U0, reason: merged with bridge method [inline-methods] */
    public h N0(boolean z10) {
        return new h(R0().N0(z10), S0().N0(z10));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.v1
    /* JADX INFO: renamed from: V0, reason: merged with bridge method [inline-methods] */
    public a0 T0(kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        g0 g0VarA = kotlinTypeRefiner.a(R0());
        m.d(g0VarA, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        g0 g0VarA2 = kotlinTypeRefiner.a(S0());
        m.d(g0VarA2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new h((o0) g0VarA, (o0) g0VarA2, true);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.v1
    /* JADX INFO: renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public h P0(c1 newAttributes) {
        m.f(newAttributes, "newAttributes");
        return new h(R0().P0(newAttributes), S0().P0(newAttributes));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(o0 lowerBound, o0 upperBound) {
        this(lowerBound, upperBound, false);
        m.f(lowerBound, "lowerBound");
        m.f(upperBound, "upperBound");
    }

    private static final List<String> X0(kotlin.reflect.jvm.internal.impl.renderer.c cVar, g0 g0Var) {
        List<k1> listH0 = g0Var.H0();
        ArrayList arrayList = new ArrayList(r.w(listH0, 10));
        Iterator<T> it = listH0.iterator();
        while (it.hasNext()) {
            arrayList.add(cVar.x((k1) it.next()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.a0
    public o0 Q0() {
        return R0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.types.a0, kotlin.reflect.jvm.internal.impl.types.g0
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h n() {
        kotlin.reflect.jvm.internal.impl.descriptors.e eVar;
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = J0().d();
        j1 j1Var = null;
        Object[] objArr = 0;
        if (hVarD instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) {
            eVar = (kotlin.reflect.jvm.internal.impl.descriptors.e) hVarD;
        } else {
            eVar = null;
        }
        if (eVar != null) {
            kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarW = eVar.W(new g(j1Var, 1, objArr == true ? 1 : 0));
            m.e(hVarW, "classDescriptor.getMemberScope(RawSubstitution())");
            return hVarW;
        }
        throw new IllegalStateException(("Incorrect classifier: " + J0().d()).toString());
    }
}
