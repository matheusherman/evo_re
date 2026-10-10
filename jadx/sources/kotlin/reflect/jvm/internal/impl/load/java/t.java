package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class t implements kotlin.reflect.jvm.internal.impl.resolve.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13424a = new a(null);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }

        public final boolean a(kotlin.reflect.jvm.internal.impl.descriptors.a superDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a subDescriptor) {
            kotlin.jvm.internal.m.f(superDescriptor, "superDescriptor");
            kotlin.jvm.internal.m.f(subDescriptor, "subDescriptor");
            if ((subDescriptor instanceof s9.e) && (superDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.y)) {
                s9.e eVar = (s9.e) subDescriptor;
                eVar.f().size();
                kotlin.reflect.jvm.internal.impl.descriptors.y yVar = (kotlin.reflect.jvm.internal.impl.descriptors.y) superDescriptor;
                yVar.f().size();
                List<j1> listF = eVar.a().f();
                kotlin.jvm.internal.m.e(listF, "subDescriptor.original.valueParameters");
                List<j1> listF2 = yVar.a().f();
                kotlin.jvm.internal.m.e(listF2, "superDescriptor.original.valueParameters");
                for (r8.p pVar : kotlin.collections.r.W0(listF, listF2)) {
                    j1 subParameter = (j1) pVar.a();
                    j1 superParameter = (j1) pVar.b();
                    kotlin.jvm.internal.m.e(subParameter, "subParameter");
                    boolean z10 = c((kotlin.reflect.jvm.internal.impl.descriptors.y) subDescriptor, subParameter) instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.n.d;
                    kotlin.jvm.internal.m.e(superParameter, "superParameter");
                    if (z10 != (c(yVar, superParameter) instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.n.d)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private final boolean b(kotlin.reflect.jvm.internal.impl.descriptors.y yVar) {
            kotlin.reflect.jvm.internal.impl.descriptors.e eVar;
            if (yVar.f().size() != 1) {
                return false;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = yVar.b();
            kotlin.reflect.jvm.internal.impl.descriptors.e eVar2 = null;
            if (mVarB instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) {
                eVar = (kotlin.reflect.jvm.internal.impl.descriptors.e) mVarB;
            } else {
                eVar = null;
            }
            if (eVar == null) {
                return false;
            }
            List<j1> listF = yVar.f();
            kotlin.jvm.internal.m.e(listF, "f.valueParameters");
            kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = ((j1) kotlin.collections.r.F0(listF)).getType().J0().d();
            if (hVarD instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) {
                eVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.e) hVarD;
            }
            if (eVar2 == null || !kotlin.reflect.jvm.internal.impl.builtins.h.r0(eVar) || !kotlin.jvm.internal.m.a(ea.c.l(eVar), ea.c.l(eVar2))) {
                return false;
            }
            return true;
        }

        private final kotlin.reflect.jvm.internal.impl.load.kotlin.n c(kotlin.reflect.jvm.internal.impl.descriptors.y yVar, j1 j1Var) {
            if (!kotlin.reflect.jvm.internal.impl.load.kotlin.x.e(yVar) && !b(yVar)) {
                kotlin.reflect.jvm.internal.impl.types.g0 type = j1Var.getType();
                kotlin.jvm.internal.m.e(type, "valueParameterDescriptor.type");
                return kotlin.reflect.jvm.internal.impl.load.kotlin.x.g(type);
            }
            kotlin.reflect.jvm.internal.impl.types.g0 type2 = j1Var.getType();
            kotlin.jvm.internal.m.e(type2, "valueParameterDescriptor.type");
            return kotlin.reflect.jvm.internal.impl.load.kotlin.x.g(oa.a.w(type2));
        }
    }

    private final boolean c(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        if ((aVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.b) && (aVar2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.y) && !kotlin.reflect.jvm.internal.impl.builtins.h.g0(aVar2)) {
            f fVar = f.f13199n;
            kotlin.reflect.jvm.internal.impl.descriptors.y yVar = (kotlin.reflect.jvm.internal.impl.descriptors.y) aVar2;
            ba.f name = yVar.getName();
            kotlin.jvm.internal.m.e(name, "subDescriptor.name");
            if (!fVar.l(name)) {
                i0.a aVar3 = i0.f13217a;
                ba.f name2 = yVar.getName();
                kotlin.jvm.internal.m.e(name2, "subDescriptor.name");
                if (!aVar3.k(name2)) {
                    return false;
                }
            }
            kotlin.reflect.jvm.internal.impl.descriptors.b bVarE = h0.e((kotlin.reflect.jvm.internal.impl.descriptors.b) aVar);
            boolean z10 = aVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.y;
            kotlin.reflect.jvm.internal.impl.descriptors.y yVar2 = z10 ? (kotlin.reflect.jvm.internal.impl.descriptors.y) aVar : null;
            if (!(yVar2 != null && yVar.s0() == yVar2.s0()) && (bVarE == null || !yVar.s0())) {
                return true;
            }
            if ((eVar instanceof s9.c) && yVar.Z() == null && bVarE != null && !h0.f(eVar, bVarE)) {
                if ((bVarE instanceof kotlin.reflect.jvm.internal.impl.descriptors.y) && z10 && f.k((kotlin.reflect.jvm.internal.impl.descriptors.y) bVarE) != null) {
                    String strC = kotlin.reflect.jvm.internal.impl.load.kotlin.x.c(yVar, false, false, 2, null);
                    kotlin.reflect.jvm.internal.impl.descriptors.y yVarA = ((kotlin.reflect.jvm.internal.impl.descriptors.y) aVar).a();
                    kotlin.jvm.internal.m.e(yVarA, "superDescriptor.original");
                    if (kotlin.jvm.internal.m.a(strC, kotlin.reflect.jvm.internal.impl.load.kotlin.x.c(yVarA, false, false, 2, null))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.f
    public kotlin.reflect.jvm.internal.impl.resolve.f.a a() {
        return kotlin.reflect.jvm.internal.impl.resolve.f.a.CONFLICTS_ONLY;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.f
    public kotlin.reflect.jvm.internal.impl.resolve.f.b b(kotlin.reflect.jvm.internal.impl.descriptors.a superDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a subDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        kotlin.jvm.internal.m.f(superDescriptor, "superDescriptor");
        kotlin.jvm.internal.m.f(subDescriptor, "subDescriptor");
        if (c(superDescriptor, subDescriptor, eVar)) {
            return kotlin.reflect.jvm.internal.impl.resolve.f.b.INCOMPATIBLE;
        }
        return f13424a.a(superDescriptor, subDescriptor) ? kotlin.reflect.jvm.internal.impl.resolve.f.b.INCOMPATIBLE : kotlin.reflect.jvm.internal.impl.resolve.f.b.UNKNOWN;
    }
}
