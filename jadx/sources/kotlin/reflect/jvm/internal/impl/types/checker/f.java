package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.c0;
import kotlin.reflect.jvm.internal.impl.types.a0;
import kotlin.reflect.jvm.internal.impl.types.f0;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.g1;
import kotlin.reflect.jvm.internal.impl.types.h0;
import kotlin.reflect.jvm.internal.impl.types.k1;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.s1;
import kotlin.reflect.jvm.internal.impl.types.u1;
import kotlin.reflect.jvm.internal.impl.types.v1;
import kotlin.reflect.jvm.internal.impl.types.w1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class f extends kotlin.reflect.jvm.internal.impl.types.h {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    /* synthetic */ class b extends kotlin.jvm.internal.j implements c9.l<na.i, v1> {
        b(Object obj) {
            super(1, obj);
        }

        @Override // kotlin.jvm.internal.c, i9.c
        public final String getName() {
            return "prepareType";
        }

        @Override // kotlin.jvm.internal.c
        public final i9.f getOwner() {
            return c0.b(f.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "prepareType(Lorg/jetbrains/kotlin/types/model/KotlinTypeMarker;)Lorg/jetbrains/kotlin/types/UnwrappedType;";
        }

        @Override // c9.l
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public final v1 invoke(na.i p10) {
            kotlin.jvm.internal.m.f(p10, "p0");
            return ((f) this.receiver).a(p10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f14236a = new a();

        private a() {
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.h
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public v1 a(na.i type) {
        v1 v1VarD;
        kotlin.jvm.internal.m.f(type, "type");
        if (!(type instanceof g0)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        v1 v1VarM0 = ((g0) type).M0();
        if (v1VarM0 instanceof o0) {
            v1VarD = c((o0) v1VarM0);
        } else {
            if (!(v1VarM0 instanceof a0)) {
                throw new r8.n();
            }
            a0 a0Var = (a0) v1VarM0;
            o0 o0VarC = c(a0Var.R0());
            o0 o0VarC2 = c(a0Var.S0());
            v1VarD = (o0VarC == a0Var.R0() && o0VarC2 == a0Var.S0()) ? v1VarM0 : h0.d(o0VarC, o0VarC2);
        }
        return u1.c(v1VarD, v1VarM0, new b(this));
    }

    private final o0 c(o0 o0Var) {
        g0 type;
        g1 g1VarJ0 = o0Var.J0();
        f0 f0VarN = null;
        v1VarM0 = null;
        v1 v1VarM0 = null;
        g0 g0VarW = null;
        if (g1VarJ0 instanceof kotlin.reflect.jvm.internal.impl.resolve.calls.inference.c) {
            kotlin.reflect.jvm.internal.impl.resolve.calls.inference.c cVar = (kotlin.reflect.jvm.internal.impl.resolve.calls.inference.c) g1VarJ0;
            k1 k1VarF = cVar.f();
            if (k1VarF.a() != w1.IN_VARIANCE) {
                k1VarF = null;
            }
            if (k1VarF != null && (type = k1VarF.getType()) != null) {
                v1VarM0 = type.M0();
            }
            v1 v1Var = v1VarM0;
            if (cVar.h() == null) {
                k1 k1VarF2 = cVar.f();
                Collection<g0> collectionB = cVar.b();
                ArrayList arrayList = new ArrayList(kotlin.collections.r.w(collectionB, 10));
                Iterator<T> it = collectionB.iterator();
                while (it.hasNext()) {
                    arrayList.add(((g0) it.next()).M0());
                }
                cVar.j(new j(k1VarF2, arrayList, null, 4, null));
            }
            na.b bVar = na.b.FOR_SUBTYPING;
            j jVarH = cVar.h();
            kotlin.jvm.internal.m.c(jVarH);
            return new i(bVar, jVarH, v1Var, o0Var.I0(), o0Var.K0(), false, 32, null);
        }
        boolean z10 = false;
        if (g1VarJ0 instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.p) {
            Collection<g0> collectionB2 = ((kotlin.reflect.jvm.internal.impl.resolve.constants.p) g1VarJ0).b();
            ArrayList arrayList2 = new ArrayList(kotlin.collections.r.w(collectionB2, 10));
            Iterator<T> it2 = collectionB2.iterator();
            while (it2.hasNext()) {
                g0 g0VarP = s1.p((g0) it2.next(), o0Var.K0());
                kotlin.jvm.internal.m.e(g0VarP, "makeNullableAsSpecified(it, type.isMarkedNullable)");
                arrayList2.add(g0VarP);
            }
            return h0.k(o0Var.I0(), new f0(arrayList2), kotlin.collections.r.l(), false, o0Var.n());
        }
        if ((g1VarJ0 instanceof f0) && o0Var.K0()) {
            f0 f0Var = (f0) g1VarJ0;
            Collection<g0> collectionB3 = f0Var.b();
            ArrayList arrayList3 = new ArrayList(kotlin.collections.r.w(collectionB3, 10));
            Iterator<T> it3 = collectionB3.iterator();
            while (it3.hasNext()) {
                arrayList3.add(oa.a.w((g0) it3.next()));
                z10 = true;
            }
            if (z10) {
                g0 g0VarI = f0Var.i();
                if (g0VarI != null) {
                    g0VarW = oa.a.w(g0VarI);
                }
                f0VarN = new f0(arrayList3).n(g0VarW);
            }
            if (f0VarN != null) {
                f0Var = f0VarN;
            }
            return f0Var.h();
        }
        return o0Var;
    }
}
