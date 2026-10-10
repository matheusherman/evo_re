package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.o0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class p extends kotlin.reflect.jvm.internal.impl.util.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f14433a = new p();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<h> f14434b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends kotlin.jvm.internal.o implements c9.l<y, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f14435a = new a();

        a() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(y $receiver) {
            kotlin.jvm.internal.m.f($receiver, "$this$$receiver");
            List<j1> valueParameters = $receiver.f();
            kotlin.jvm.internal.m.e(valueParameters, "valueParameters");
            j1 j1Var = (j1) kotlin.collections.r.u0(valueParameters);
            boolean z10 = false;
            if (j1Var != null && !ea.c.c(j1Var) && j1Var.h0() == null) {
                z10 = true;
            }
            p pVar = p.f14433a;
            if (z10) {
                return null;
            }
            return "last parameter should not have a default value or be a vararg";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends kotlin.jvm.internal.o implements c9.l<y, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f14436a = new b();

        b() {
            super(1);
        }

        private static final boolean b(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
            return (mVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) && kotlin.reflect.jvm.internal.impl.builtins.h.a0((kotlin.reflect.jvm.internal.impl.descriptors.e) mVar);
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0052  */
        /* JADX WARN: Code duplicated, block: B:17:0x0054  */
        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(y $receiver) {
            boolean z10;
            kotlin.jvm.internal.m.f($receiver, "$this$$receiver");
            p pVar = p.f14433a;
            kotlin.reflect.jvm.internal.impl.descriptors.m containingDeclaration = $receiver.b();
            kotlin.jvm.internal.m.e(containingDeclaration, "containingDeclaration");
            if (b(containingDeclaration)) {
                z10 = true;
            } else {
                Collection<? extends y> overriddenDescriptors = $receiver.e();
                kotlin.jvm.internal.m.e(overriddenDescriptors, "overriddenDescriptors");
                Collection<? extends y> collection = overriddenDescriptors;
                if (!collection.isEmpty()) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = ((y) it.next()).b();
                            kotlin.jvm.internal.m.e(mVarB, "it.containingDeclaration");
                            if (b(mVarB)) {
                            }
                        } else if (kotlin.reflect.jvm.internal.impl.descriptors.s.c($receiver)) {
                            z10 = false;
                        }
                        z10 = true;
                    }
                } else if (kotlin.reflect.jvm.internal.impl.descriptors.s.c($receiver)) {
                    z10 = false;
                } else {
                    z10 = true;
                }
            }
            if (z10) {
                return null;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("must override ''equals()'' in Any");
            kotlin.reflect.jvm.internal.impl.descriptors.m containingDeclaration2 = $receiver.b();
            kotlin.jvm.internal.m.e(containingDeclaration2, "containingDeclaration");
            if (kotlin.reflect.jvm.internal.impl.resolve.g.f(containingDeclaration2)) {
                kotlin.reflect.jvm.internal.impl.renderer.c cVar = kotlin.reflect.jvm.internal.impl.renderer.c.f13792i;
                kotlin.reflect.jvm.internal.impl.descriptors.m mVarB2 = $receiver.b();
                kotlin.jvm.internal.m.d(mVarB2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                o0 o0VarP = ((kotlin.reflect.jvm.internal.impl.descriptors.e) mVarB2).p();
                kotlin.jvm.internal.m.e(o0VarP, "containingDeclaration as…ssDescriptor).defaultType");
                sb2.append(" or define ''equals(other: " + cVar.w(oa.a.y(o0VarP)) + "): Boolean''");
            }
            String string = sb2.toString();
            kotlin.jvm.internal.m.e(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends kotlin.jvm.internal.o implements c9.l<y, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f14437a = new c();

        c() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(y $receiver) {
            boolean zR;
            kotlin.jvm.internal.m.f($receiver, "$this$$receiver");
            x0 x0VarB0 = $receiver.b0();
            if (x0VarB0 == null) {
                x0VarB0 = $receiver.i0();
            }
            p pVar = p.f14433a;
            boolean z10 = false;
            if (x0VarB0 != null) {
                g0 returnType = $receiver.getReturnType();
                if (returnType != null) {
                    g0 type = x0VarB0.getType();
                    kotlin.jvm.internal.m.e(type, "receiver.type");
                    zR = oa.a.r(returnType, type);
                } else {
                    zR = false;
                }
                if (zR || pVar.d($receiver, x0VarB0)) {
                    z10 = true;
                }
            }
            if (z10) {
                return null;
            }
            return "receiver must be a supertype of the return type";
        }
    }

    static {
        ba.f fVar = q.f14448k;
        k.b bVar = k.b.f14425b;
        h hVar = new h(fVar, new f[]{bVar, new t.a(1)}, (c9.l) null, 4, (kotlin.jvm.internal.g) null);
        h hVar2 = new h(q.f14449l, new f[]{bVar, new t.a(2)}, a.f14435a);
        ba.f fVar2 = q.f14439b;
        m mVar = m.f14427a;
        t.a aVar = new t.a(2);
        j jVar = j.f14421a;
        h hVar3 = new h(fVar2, new f[]{bVar, mVar, aVar, jVar}, (c9.l) null, 4, (kotlin.jvm.internal.g) null);
        h hVar4 = new h(q.f14440c, new f[]{bVar, mVar, new t.a(3), jVar}, (c9.l) null, 4, (kotlin.jvm.internal.g) null);
        h hVar5 = new h(q.f14441d, new f[]{bVar, mVar, new t.b(2), jVar}, (c9.l) null, 4, (kotlin.jvm.internal.g) null);
        h hVar6 = new h(q.f14446i, new f[]{bVar}, (c9.l) null, 4, (kotlin.jvm.internal.g) null);
        ba.f fVar3 = q.f14445h;
        t.d dVar = t.d.f14479b;
        r.a aVar2 = r.a.f14467d;
        h hVar7 = new h(fVar3, new f[]{bVar, dVar, mVar, aVar2}, (c9.l) null, 4, (kotlin.jvm.internal.g) null);
        ba.f fVar4 = q.f14447j;
        t.c cVar = t.c.f14478b;
        f14434b = kotlin.collections.r.o(hVar, hVar2, hVar3, hVar4, hVar5, hVar6, hVar7, new h(fVar4, new f[]{bVar, cVar}, (c9.l) null, 4, (kotlin.jvm.internal.g) null), new h(q.f14450m, new f[]{bVar, cVar}, (c9.l) null, 4, (kotlin.jvm.internal.g) null), new h(q.f14451n, new f[]{bVar, cVar, aVar2}, (c9.l) null, 4, (kotlin.jvm.internal.g) null), new h(q.I, new f[]{bVar, dVar, mVar}, (c9.l) null, 4, (kotlin.jvm.internal.g) null), new h(q.J, new f[]{bVar, dVar, mVar}, (c9.l) null, 4, (kotlin.jvm.internal.g) null), new h(q.f14442e, new f[]{k.a.f14424b}, b.f14436a), new h(q.f14444g, new f[]{bVar, r.b.f14469d, dVar, mVar}, (c9.l) null, 4, (kotlin.jvm.internal.g) null), new h(q.S, new f[]{bVar, dVar, mVar}, (c9.l) null, 4, (kotlin.jvm.internal.g) null), new h(q.R, new f[]{bVar, cVar}, (c9.l) null, 4, (kotlin.jvm.internal.g) null), new h(kotlin.collections.r.o(q.f14461x, q.f14462y), new f[]{bVar}, c.f14437a), new h(q.V, new f[]{bVar, r.c.f14471d, dVar, mVar}, (c9.l) null, 4, (kotlin.jvm.internal.g) null), new h(q.f14453p, new f[]{bVar, cVar}, (c9.l) null, 4, (kotlin.jvm.internal.g) null));
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.b
    public List<h> b() {
        return f14434b;
    }

    private p() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean d(y yVar, x0 x0Var) {
        ba.b bVarK;
        e1 e1Var;
        g0 returnType;
        ha.g value = x0Var.getValue();
        kotlin.jvm.internal.m.e(value, "receiver.value");
        if (!(value instanceof ha.e)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarO = ((ha.e) value).o();
        if (!eVarO.I() || (bVarK = ea.c.k(eVarO)) == null) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarB = x.b(ea.c.p(eVarO), bVarK);
        if (hVarB instanceof e1) {
            e1Var = (e1) hVarB;
        } else {
            e1Var = null;
        }
        if (e1Var == null || (returnType = yVar.getReturnType()) == null) {
            return false;
        }
        return oa.a.r(returnType, e1Var.R());
    }
}
