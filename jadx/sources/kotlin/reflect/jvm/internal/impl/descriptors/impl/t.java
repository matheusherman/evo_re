package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.types.n1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class t implements kotlin.reflect.jvm.internal.impl.descriptors.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12950a = new a(null);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }

        public final kotlin.reflect.jvm.internal.impl.resolve.scopes.h a(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, n1 typeSubstitution, kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
            kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarC;
            kotlin.jvm.internal.m.f(eVar, "<this>");
            kotlin.jvm.internal.m.f(typeSubstitution, "typeSubstitution");
            kotlin.jvm.internal.m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
            t tVar = eVar instanceof t ? (t) eVar : null;
            if (tVar != null && (hVarC = tVar.C(typeSubstitution, kotlinTypeRefiner)) != null) {
                return hVarC;
            }
            kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarW = eVar.W(typeSubstitution);
            kotlin.jvm.internal.m.e(hVarW, "this.getMemberScope(\n   …ubstitution\n            )");
            return hVarW;
        }

        public final kotlin.reflect.jvm.internal.impl.resolve.scopes.h b(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
            kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarG;
            kotlin.jvm.internal.m.f(eVar, "<this>");
            kotlin.jvm.internal.m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
            t tVar = eVar instanceof t ? (t) eVar : null;
            if (tVar != null && (hVarG = tVar.G(kotlinTypeRefiner)) != null) {
                return hVarG;
            }
            kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarZ0 = eVar.z0();
            kotlin.jvm.internal.m.e(hVarZ0, "this.unsubstitutedMemberScope");
            return hVarZ0;
        }
    }

    protected abstract kotlin.reflect.jvm.internal.impl.resolve.scopes.h C(n1 n1Var, kotlin.reflect.jvm.internal.impl.types.checker.g gVar);

    protected abstract kotlin.reflect.jvm.internal.impl.resolve.scopes.h G(kotlin.reflect.jvm.internal.impl.types.checker.g gVar);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.m
    public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.h a() {
        return a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.m a() {
        return a();
    }
}
