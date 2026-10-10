package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.load.java.j0;
import kotlin.reflect.jvm.internal.impl.load.kotlin.w;
import kotlin.reflect.jvm.internal.impl.load.kotlin.x;
import kotlin.reflect.jvm.internal.impl.load.kotlin.z;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.n0;
import kotlin.reflect.jvm.internal.impl.types.s1;
import kotlin.reflect.jvm.internal.impl.types.v1;
import r8.v;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d f13458a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends kotlin.jvm.internal.o implements c9.l<kotlin.reflect.jvm.internal.impl.descriptors.b, g0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f13460a = new b();

        b() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final g0 invoke(kotlin.reflect.jvm.internal.impl.descriptors.b it) {
            kotlin.jvm.internal.m.f(it, "it");
            x0 x0VarI0 = it.i0();
            kotlin.jvm.internal.m.c(x0VarI0);
            g0 type = x0VarI0.getType();
            kotlin.jvm.internal.m.e(type, "it.extensionReceiverParameter!!.type");
            return type;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends kotlin.jvm.internal.o implements c9.l<kotlin.reflect.jvm.internal.impl.descriptors.b, g0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f13461a = new c();

        c() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final g0 invoke(kotlin.reflect.jvm.internal.impl.descriptors.b it) {
            kotlin.jvm.internal.m.f(it, "it");
            g0 returnType = it.getReturnType();
            kotlin.jvm.internal.m.c(returnType);
            return returnType;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class d extends kotlin.jvm.internal.o implements c9.l<kotlin.reflect.jvm.internal.impl.descriptors.b, g0> {
        final /* synthetic */ j1 $p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(j1 j1Var) {
            super(1);
            this.$p = j1Var;
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final g0 invoke(kotlin.reflect.jvm.internal.impl.descriptors.b it) {
            kotlin.jvm.internal.m.f(it, "it");
            g0 type = it.f().get(this.$p.getIndex()).getType();
            kotlin.jvm.internal.m.e(type, "it.valueParameters[p.index].type");
            return type;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class e extends kotlin.jvm.internal.o implements c9.l<v1, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f13462a = new e();

        e() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(v1 it) {
            kotlin.jvm.internal.m.f(it, "it");
            return Boolean.valueOf(it instanceof n0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends kotlin.jvm.internal.o implements c9.l<v1, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f13459a = new a();

        a() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(v1 v1Var) {
            boolean z10;
            kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = v1Var.J0().d();
            if (hVarD == null) {
                return Boolean.FALSE;
            }
            ba.f name = hVarD.getName();
            kotlin.reflect.jvm.internal.impl.builtins.jvm.c cVar = kotlin.reflect.jvm.internal.impl.builtins.jvm.c.f12505a;
            if (kotlin.jvm.internal.m.a(name, cVar.h().g()) && kotlin.jvm.internal.m.a(ea.c.h(hVarD), cVar.h())) {
                z10 = true;
            } else {
                z10 = false;
            }
            return Boolean.valueOf(z10);
        }
    }

    public l(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d typeEnhancement) {
        kotlin.jvm.internal.m.f(typeEnhancement, "typeEnhancement");
        this.f13458a = typeEnhancement;
    }

    private final boolean a(g0 g0Var) {
        return s1.c(g0Var, a.f13459a);
    }

    private final g0 b(kotlin.reflect.jvm.internal.impl.descriptors.b bVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar, boolean z10, kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVar, kotlin.reflect.jvm.internal.impl.load.java.b bVar2, q qVar, boolean z11, c9.l<? super kotlin.reflect.jvm.internal.impl.descriptors.b, ? extends g0> lVar) {
        n nVar = new n(aVar, z10, gVar, bVar2, false, 16, null);
        g0 g0VarInvoke = lVar.invoke(bVar);
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> overriddenDescriptors = bVar.e();
        kotlin.jvm.internal.m.e(overriddenDescriptors, "overriddenDescriptors");
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> collection = overriddenDescriptors;
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(collection, 10));
        for (kotlin.reflect.jvm.internal.impl.descriptors.b it : collection) {
            kotlin.jvm.internal.m.e(it, "it");
            arrayList.add(lVar.invoke(it));
        }
        return c(nVar, g0VarInvoke, arrayList, qVar, z11);
    }

    private final g0 c(n nVar, g0 g0Var, List<? extends g0> list, q qVar, boolean z10) {
        return this.f13458a.a(g0Var, nVar.b(g0Var, list, qVar, z10), nVar.u());
    }

    static /* synthetic */ g0 d(l lVar, kotlin.reflect.jvm.internal.impl.descriptors.b bVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar, boolean z10, kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVar, kotlin.reflect.jvm.internal.impl.load.java.b bVar2, q qVar, boolean z11, c9.l lVar2, int i10, Object obj) {
        return lVar.b(bVar, aVar, z10, gVar, bVar2, qVar, (i10 & 32) != 0 ? false : z11, lVar2);
    }

    static /* synthetic */ g0 e(l lVar, n nVar, g0 g0Var, List list, q qVar, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            qVar = null;
        }
        return lVar.c(nVar, g0Var, list, qVar, (i10 & 8) != 0 ? false : z10);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:96:0x01c0  */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01fa, code lost:
    
        if (r3 == null) goto L117;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final <D extends kotlin.reflect.jvm.internal.impl.descriptors.b> D f(D d10, kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVar) {
        D d11;
        g0 g0VarJ;
        k kVar;
        boolean z10;
        boolean z11;
        boolean z12;
        g0 type;
        List<q> listA;
        s9.f fVar;
        d0 getter;
        if (!(d10 instanceof s9.a)) {
            return d10;
        }
        s9.a aVar = (s9.a) d10;
        if (aVar.g() != kotlin.reflect.jvm.internal.impl.descriptors.b.a.FAKE_OVERRIDE || aVar.a().e().size() != 1) {
            kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVarH = kotlin.reflect.jvm.internal.impl.load.java.lazy.a.h(gVar, k(d10, gVar));
            if (!(d10 instanceof s9.f) || (getter = (fVar = (s9.f) d10).getGetter()) == null || getter.Q()) {
                d11 = d10;
            } else {
                d0 getter2 = fVar.getGetter();
                kotlin.jvm.internal.m.c(getter2);
                d11 = getter2;
            }
            g0 type2 = null;
            if (aVar.i0() != null) {
                y yVar = d11 instanceof y ? (y) d11 : null;
                g0VarJ = j(d10, yVar != null ? (j1) yVar.e0(s9.e.G) : null, gVarH, null, false, b.f13460a);
            } else {
                g0VarJ = null;
            }
            s9.e eVar = d10 instanceof s9.e ? (s9.e) d10 : null;
            int i10 = 0;
            if (eVar != null) {
                z zVar = z.f13623a;
                kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = eVar.b();
                kotlin.jvm.internal.m.d(mVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                String strA = w.a(zVar, (kotlin.reflect.jvm.internal.impl.descriptors.e) mVarB, x.c(eVar, false, false, 3, null));
                if (strA != null) {
                    kVar = j.d().get(strA);
                } else {
                    kVar = null;
                }
            } else {
                kVar = null;
            }
            if (kVar != null) {
                kVar.a().size();
                aVar.f().size();
            }
            boolean z13 = (j0.c(gVar.a().i()) || gVarH.a().q().b()) && j0.b(d10);
            List<j1> listF = d11.f();
            kotlin.jvm.internal.m.e(listF, "annotationOwnerForMember.valueParameters");
            List<j1> list = listF;
            ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list, 10));
            for (j1 j1Var : list) {
                arrayList.add(j(d10, j1Var, gVarH, (kVar == null || (listA = kVar.a()) == null) ? null : (q) kotlin.collections.r.j0(listA, j1Var.getIndex()), z13, new d(j1Var)));
            }
            u0 u0Var = d10 instanceof u0 ? (u0) d10 : null;
            g0 g0VarD = d(this, d10, d11, true, gVarH, (u0Var == null || !kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.c.a(u0Var)) ? kotlin.reflect.jvm.internal.impl.load.java.b.METHOD_RETURN_TYPE : kotlin.reflect.jvm.internal.impl.load.java.b.FIELD, kVar != null ? kVar.b() : null, false, c.f13461a, 32, null);
            g0 returnType = aVar.getReturnType();
            kotlin.jvm.internal.m.c(returnType);
            if (a(returnType)) {
                z10 = true;
            } else {
                x0 x0VarI0 = aVar.i0();
                if ((x0VarI0 == null || (type = x0VarI0.getType()) == null) ? false : a(type)) {
                    z10 = true;
                } else {
                    List<j1> valueParameters = aVar.f();
                    kotlin.jvm.internal.m.e(valueParameters, "valueParameters");
                    List<j1> list2 = valueParameters;
                    if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                        Iterator<T> it = list2.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z12 = false;
                                break;
                            }
                            g0 type3 = ((j1) it.next()).getType();
                            kotlin.jvm.internal.m.e(type3, "it.type");
                            if (a(type3)) {
                                z12 = true;
                                break;
                            }
                        }
                    } else {
                        z12 = false;
                        break;
                    }
                    if (z12) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                }
            }
            r8.p<kotlin.reflect.jvm.internal.impl.descriptors.a.InterfaceC0217a<?>, ?> pVarA = z10 ? v.a(da.d.a(), new kotlin.reflect.jvm.internal.impl.load.java.j(d10)) : null;
            if (g0VarJ == null && g0VarD == null) {
                if (arrayList.isEmpty()) {
                    z11 = false;
                    break;
                }
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z11 = false;
                        break;
                    }
                    if (((g0) it2.next()) != null) {
                        z11 = true;
                        break;
                    }
                }
                if (!z11) {
                }
            }
            if (g0VarJ == null) {
                x0 x0VarI1 = aVar.i0();
                if (x0VarI1 != null) {
                    type2 = x0VarI1.getType();
                }
            } else {
                type2 = g0VarJ;
            }
            ArrayList arrayList2 = new ArrayList(kotlin.collections.r.w(arrayList, 10));
            for (Object obj : arrayList) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    kotlin.collections.r.v();
                }
                g0 type4 = (g0) obj;
                if (type4 == null) {
                    type4 = aVar.f().get(i10).getType();
                    kotlin.jvm.internal.m.e(type4, "valueParameters[index].type");
                }
                arrayList2.add(type4);
                i10 = i11;
            }
            if (g0VarD == null) {
                g0VarD = aVar.getReturnType();
                kotlin.jvm.internal.m.c(g0VarD);
            }
            s9.a aVarU = aVar.u(type2, arrayList2, g0VarD, pVarA);
            kotlin.jvm.internal.m.d(aVarU, "null cannot be cast to non-null type D of org.jetbrains.kotlin.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature");
            return aVarU;
        }
        return d10;
    }

    private final g0 j(kotlin.reflect.jvm.internal.impl.descriptors.b bVar, j1 j1Var, kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVar, q qVar, boolean z10, c9.l<? super kotlin.reflect.jvm.internal.impl.descriptors.b, ? extends g0> lVar) {
        kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVarH;
        return b(bVar, j1Var, false, (j1Var == null || (gVarH = kotlin.reflect.jvm.internal.impl.load.java.lazy.a.h(gVar, j1Var.getAnnotations())) == null) ? gVar : gVarH, kotlin.reflect.jvm.internal.impl.load.java.b.VALUE_PARAMETER, qVar, z10, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <D extends kotlin.reflect.jvm.internal.impl.descriptors.b> Collection<D> g(kotlin.reflect.jvm.internal.impl.load.java.lazy.g c10, Collection<? extends D> platformSignatures) {
        kotlin.jvm.internal.m.f(c10, "c");
        kotlin.jvm.internal.m.f(platformSignatures, "platformSignatures");
        Collection<? extends D> collection = platformSignatures;
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(f((kotlin.reflect.jvm.internal.impl.descriptors.b) it.next(), c10));
        }
        return arrayList;
    }

    public final g0 h(g0 type, kotlin.reflect.jvm.internal.impl.load.java.lazy.g context) {
        kotlin.jvm.internal.m.f(type, "type");
        kotlin.jvm.internal.m.f(context, "context");
        g0 g0VarE = e(this, new n(null, false, context, kotlin.reflect.jvm.internal.impl.load.java.b.TYPE_USE, true), type, kotlin.collections.r.l(), null, false, 12, null);
        return g0VarE == null ? type : g0VarE;
    }

    public final List<g0> i(f1 typeParameter, List<? extends g0> bounds, kotlin.reflect.jvm.internal.impl.load.java.lazy.g context) {
        kotlin.jvm.internal.m.f(typeParameter, "typeParameter");
        kotlin.jvm.internal.m.f(bounds, "bounds");
        kotlin.jvm.internal.m.f(context, "context");
        List<? extends g0> list = bounds;
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list, 10));
        for (g0 g0VarE : list) {
            if (!oa.a.b(g0VarE, e.f13462a)) {
                g0VarE = e(this, new n(typeParameter, false, context, kotlin.reflect.jvm.internal.impl.load.java.b.TYPE_PARAMETER_BOUNDS, false, 16, null), g0VarE, kotlin.collections.r.l(), null, false, 12, null);
                if (g0VarE == null) {
                    g0VarE = g0VarE;
                }
            }
            arrayList.add(g0VarE);
        }
        return arrayList;
    }

    private final <D extends kotlin.reflect.jvm.internal.impl.descriptors.b> kotlin.reflect.jvm.internal.impl.descriptors.annotations.g k(D d10, kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVar) {
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f fVar;
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarA = kotlin.reflect.jvm.internal.impl.descriptors.s.a(d10);
        if (hVarA == null) {
            return d10.getAnnotations();
        }
        List<u9.a> listM0 = null;
        if (hVarA instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f) {
            fVar = (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f) hVarA;
        } else {
            fVar = null;
        }
        if (fVar != null) {
            listM0 = fVar.M0();
        }
        List<u9.a> list = listM0;
        if (list != null && !list.isEmpty()) {
            List<u9.a> list2 = listM0;
            ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.e(gVar, (u9.a) it.next(), true));
            }
            return kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.a(kotlin.collections.r.z0(d10.getAnnotations(), arrayList));
        }
        return d10.getAnnotations();
    }
}
