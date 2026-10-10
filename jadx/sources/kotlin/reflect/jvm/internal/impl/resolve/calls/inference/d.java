package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.ArrayList;
import java.util.List;
import ka.f;
import ka.n;
import kotlin.collections.j;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.j0;
import kotlin.reflect.jvm.internal.impl.types.k1;
import kotlin.reflect.jvm.internal.impl.types.m1;
import kotlin.reflect.jvm.internal.impl.types.n1;
import kotlin.reflect.jvm.internal.impl.types.q;
import kotlin.reflect.jvm.internal.impl.types.w1;
import r8.p;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends o implements c9.a<g0> {
        final /* synthetic */ k1 $this_createCapturedIfNeeded;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(k1 k1Var) {
            super(0);
            this.$this_createCapturedIfNeeded = k1Var;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final g0 invoke() {
            g0 type = this.$this_createCapturedIfNeeded.getType();
            m.e(type, "this@createCapturedIfNeeded.type");
            return type;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends q {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f13894d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(n1 n1Var, boolean z10) {
            super(n1Var);
            this.f13894d = z10;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.n1
        public boolean b() {
            return this.f13894d;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.q, kotlin.reflect.jvm.internal.impl.types.n1
        public k1 e(g0 key) {
            m.f(key, "key");
            k1 k1VarE = super.e(key);
            if (k1VarE == null) {
                return null;
            }
            h hVarD = key.J0().d();
            return d.b(k1VarE, hVarD instanceof f1 ? (f1) hVarD : null);
        }
    }

    public static /* synthetic */ n1 f(n1 n1Var, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return e(n1Var, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k1 b(k1 k1Var, f1 f1Var) {
        if (f1Var == null || k1Var.a() == w1.INVARIANT) {
            return k1Var;
        }
        if (f1Var.j() != k1Var.a()) {
            return new m1(c(k1Var));
        }
        if (!k1Var.b()) {
            return new m1(k1Var.getType());
        }
        n NO_LOCKS = f.f12182e;
        m.e(NO_LOCKS, "NO_LOCKS");
        return new m1(new j0(NO_LOCKS, new a(k1Var)));
    }

    public static final g0 c(k1 typeProjection) {
        m.f(typeProjection, "typeProjection");
        return new kotlin.reflect.jvm.internal.impl.resolve.calls.inference.a(typeProjection, null, false, null, 14, null);
    }

    public static final boolean d(g0 g0Var) {
        m.f(g0Var, "<this>");
        return g0Var.J0() instanceof kotlin.reflect.jvm.internal.impl.resolve.calls.inference.b;
    }

    public static final n1 e(n1 n1Var, boolean z10) {
        m.f(n1Var, "<this>");
        if (!(n1Var instanceof e0)) {
            return new b(n1Var, z10);
        }
        e0 e0Var = (e0) n1Var;
        f1[] f1VarArrJ = e0Var.j();
        List<p> listU0 = j.U0(e0Var.i(), e0Var.j());
        ArrayList arrayList = new ArrayList(r.w(listU0, 10));
        for (p pVar : listU0) {
            arrayList.add(b((k1) pVar.c(), (f1) pVar.d()));
        }
        return new e0(f1VarArrJ, (k1[]) arrayList.toArray(new k1[0]), z10);
    }
}
