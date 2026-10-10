package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import kotlin.collections.r;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.types.g1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f13885a = new c();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends kotlin.jvm.internal.o implements c9.p<kotlin.reflect.jvm.internal.impl.descriptors.m, kotlin.reflect.jvm.internal.impl.descriptors.m, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f13886a = new a();

        a() {
            super(2);
        }

        @Override // c9.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.m mVar2) {
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends kotlin.jvm.internal.o implements c9.p<kotlin.reflect.jvm.internal.impl.descriptors.m, kotlin.reflect.jvm.internal.impl.descriptors.m, Boolean> {
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.a $a;
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.a $b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
            super(2);
            this.$a = aVar;
            this.$b = aVar2;
        }

        @Override // c9.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.m mVar2) {
            return Boolean.valueOf(kotlin.jvm.internal.m.a(mVar, this.$a) && kotlin.jvm.internal.m.a(mVar2, this.$b));
        }
    }

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.resolve.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class C0252c extends kotlin.jvm.internal.o implements c9.p<kotlin.reflect.jvm.internal.impl.descriptors.m, kotlin.reflect.jvm.internal.impl.descriptors.m, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0252c f13887a = new C0252c();

        C0252c() {
            super(2);
        }

        @Override // c9.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.m mVar2) {
            return Boolean.FALSE;
        }
    }

    public static /* synthetic */ boolean c(c cVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, boolean z10, boolean z11, boolean z12, kotlin.reflect.jvm.internal.impl.types.checker.g gVar, int i10, Object obj) {
        return cVar.b(aVar, aVar2, z10, (i10 & 8) != 0 ? true : z11, (i10 & 16) != 0 ? false : z12, gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(boolean z10, kotlin.reflect.jvm.internal.impl.descriptors.a a10, kotlin.reflect.jvm.internal.impl.descriptors.a b10, g1 c10, g1 c11) {
        kotlin.jvm.internal.m.f(a10, "$a");
        kotlin.jvm.internal.m.f(b10, "$b");
        kotlin.jvm.internal.m.f(c10, "c1");
        kotlin.jvm.internal.m.f(c11, "c2");
        if (kotlin.jvm.internal.m.a(c10, c11)) {
            return true;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = c10.d();
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD2 = c11.d();
        if ((hVarD instanceof f1) && (hVarD2 instanceof f1)) {
            return f13885a.i((f1) hVarD, (f1) hVarD2, z10, new b(a10, b10));
        }
        return false;
    }

    public static /* synthetic */ boolean g(c cVar, kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.m mVar2, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z11 = true;
        }
        return cVar.f(mVar, mVar2, z10, z11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean j(c cVar, f1 f1Var, f1 f1Var2, boolean z10, c9.p pVar, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            pVar = C0252c.f13887a;
        }
        return cVar.i(f1Var, f1Var2, z10, pVar);
    }

    private final a1 l(kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        while (aVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.b) {
            kotlin.reflect.jvm.internal.impl.descriptors.b bVar = (kotlin.reflect.jvm.internal.impl.descriptors.b) aVar;
            if (bVar.g() != kotlin.reflect.jvm.internal.impl.descriptors.b.a.FAKE_OVERRIDE) {
                break;
            }
            Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> overriddenDescriptors = bVar.e();
            kotlin.jvm.internal.m.e(overriddenDescriptors, "overriddenDescriptors");
            aVar = (kotlin.reflect.jvm.internal.impl.descriptors.b) r.G0(overriddenDescriptors);
            if (aVar == null) {
                return null;
            }
        }
        return aVar.getSource();
    }

    public final boolean b(kotlin.reflect.jvm.internal.impl.descriptors.a a10, kotlin.reflect.jvm.internal.impl.descriptors.a b10, boolean z10, boolean z11, boolean z12, kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.m.f(a10, "a");
        kotlin.jvm.internal.m.f(b10, "b");
        kotlin.jvm.internal.m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        if (kotlin.jvm.internal.m.a(a10, b10)) {
            return true;
        }
        if (!kotlin.jvm.internal.m.a(a10.getName(), b10.getName())) {
            return false;
        }
        if (z11 && (a10 instanceof d0) && (b10 instanceof d0) && ((d0) a10).I() != ((d0) b10).I()) {
            return false;
        }
        if ((kotlin.jvm.internal.m.a(a10.b(), b10.b()) && (!z10 || !kotlin.jvm.internal.m.a(l(a10), l(b10)))) || e.E(a10) || e.E(b10) || !k(a10, b10, a.f13886a, z10)) {
            return false;
        }
        k kVarI = k.i(kotlinTypeRefiner, new kotlin.reflect.jvm.internal.impl.resolve.b(z10, a10, b10));
        kotlin.jvm.internal.m.e(kVarI, "create(kotlinTypeRefiner…= a && y == b }\n        }");
        k.i.a aVarC = kVarI.E(a10, b10, null, !z12).c();
        k.i.a aVar = k.i.a.OVERRIDABLE;
        return aVarC == aVar && kVarI.E(b10, a10, null, z12 ^ true).c() == aVar;
    }

    public final boolean f(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.m mVar2, boolean z10, boolean z11) {
        if ((mVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) && (mVar2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.e)) {
            return e((kotlin.reflect.jvm.internal.impl.descriptors.e) mVar, (kotlin.reflect.jvm.internal.impl.descriptors.e) mVar2);
        }
        if ((mVar instanceof f1) && (mVar2 instanceof f1)) {
            return j(this, (f1) mVar, (f1) mVar2, z10, null, 8, null);
        }
        if ((mVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.a) && (mVar2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.a)) {
            return c(this, (kotlin.reflect.jvm.internal.impl.descriptors.a) mVar, (kotlin.reflect.jvm.internal.impl.descriptors.a) mVar2, z10, z11, false, kotlin.reflect.jvm.internal.impl.types.checker.g.a.f14237a, 16, null);
        }
        return ((mVar instanceof l0) && (mVar2 instanceof l0)) ? kotlin.jvm.internal.m.a(((l0) mVar).d(), ((l0) mVar2).d()) : kotlin.jvm.internal.m.a(mVar, mVar2);
    }

    public final boolean h(f1 a10, f1 b10, boolean z10) {
        kotlin.jvm.internal.m.f(a10, "a");
        kotlin.jvm.internal.m.f(b10, "b");
        return j(this, a10, b10, z10, null, 8, null);
    }

    public final boolean i(f1 a10, f1 b10, boolean z10, c9.p<? super kotlin.reflect.jvm.internal.impl.descriptors.m, ? super kotlin.reflect.jvm.internal.impl.descriptors.m, Boolean> equivalentCallables) {
        kotlin.jvm.internal.m.f(a10, "a");
        kotlin.jvm.internal.m.f(b10, "b");
        kotlin.jvm.internal.m.f(equivalentCallables, "equivalentCallables");
        if (kotlin.jvm.internal.m.a(a10, b10)) {
            return true;
        }
        return !kotlin.jvm.internal.m.a(a10.b(), b10.b()) && k(a10, b10, equivalentCallables, z10) && a10.getIndex() == b10.getIndex();
    }

    private c() {
    }

    private final boolean e(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar2) {
        return kotlin.jvm.internal.m.a(eVar.h(), eVar2.h());
    }

    private final boolean k(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.m mVar2, c9.p<? super kotlin.reflect.jvm.internal.impl.descriptors.m, ? super kotlin.reflect.jvm.internal.impl.descriptors.m, Boolean> pVar, boolean z10) {
        kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = mVar.b();
        kotlin.reflect.jvm.internal.impl.descriptors.m mVarB2 = mVar2.b();
        if (!(mVarB instanceof kotlin.reflect.jvm.internal.impl.descriptors.b) && !(mVarB2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.b)) {
            return g(this, mVarB, mVarB2, z10, false, 8, null);
        }
        return pVar.invoke(mVarB, mVarB2).booleanValue();
    }
}
