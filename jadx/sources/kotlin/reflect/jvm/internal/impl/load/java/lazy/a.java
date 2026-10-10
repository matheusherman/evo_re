package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.load.java.y;
import u9.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a {

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class C0227a extends o implements c9.a<y> {
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.g $containingDeclaration;
        final /* synthetic */ g $this_childForClassOrPackage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0227a(g gVar, kotlin.reflect.jvm.internal.impl.descriptors.g gVar2) {
            super(0);
            this.$this_childForClassOrPackage = gVar;
            this.$containingDeclaration = gVar2;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final y invoke() {
            return a.g(this.$this_childForClassOrPackage, this.$containingDeclaration.getAnnotations());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends o implements c9.a<y> {
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.annotations.g $additionalAnnotations;
        final /* synthetic */ g $this_copyWithNewDefaultTypeQualifiers;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(g gVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar2) {
            super(0);
            this.$this_copyWithNewDefaultTypeQualifiers = gVar;
            this.$additionalAnnotations = gVar2;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final y invoke() {
            return a.g(this.$this_copyWithNewDefaultTypeQualifiers, this.$additionalAnnotations);
        }
    }

    public static final g b(g gVar, k typeParameterResolver) {
        m.f(gVar, "<this>");
        m.f(typeParameterResolver, "typeParameterResolver");
        return new g(gVar.a(), typeParameterResolver, gVar.c());
    }

    public static final g c(g gVar, kotlin.reflect.jvm.internal.impl.descriptors.g containingDeclaration, z zVar, int i10) {
        m.f(gVar, "<this>");
        m.f(containingDeclaration, "containingDeclaration");
        return a(gVar, containingDeclaration, zVar, i10, r8.j.b(r8.m.NONE, new C0227a(gVar, containingDeclaration)));
    }

    public static /* synthetic */ g d(g gVar, kotlin.reflect.jvm.internal.impl.descriptors.g gVar2, z zVar, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            zVar = null;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return c(gVar, gVar2, zVar, i10);
    }

    public static final g e(g gVar, kotlin.reflect.jvm.internal.impl.descriptors.m containingDeclaration, z typeParameterOwner, int i10) {
        m.f(gVar, "<this>");
        m.f(containingDeclaration, "containingDeclaration");
        m.f(typeParameterOwner, "typeParameterOwner");
        return a(gVar, containingDeclaration, typeParameterOwner, i10, gVar.c());
    }

    public static /* synthetic */ g f(g gVar, kotlin.reflect.jvm.internal.impl.descriptors.m mVar, z zVar, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return e(gVar, mVar, zVar, i10);
    }

    public static final y g(g gVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g additionalAnnotations) {
        m.f(gVar, "<this>");
        m.f(additionalAnnotations, "additionalAnnotations");
        return gVar.a().a().c(gVar.b(), additionalAnnotations);
    }

    public static final g h(g gVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g additionalAnnotations) {
        m.f(gVar, "<this>");
        m.f(additionalAnnotations, "additionalAnnotations");
        return additionalAnnotations.isEmpty() ? gVar : new g(gVar.a(), gVar.f(), r8.j.b(r8.m.NONE, new b(gVar, additionalAnnotations)));
    }

    public static final g i(g gVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.b components) {
        m.f(gVar, "<this>");
        m.f(components, "components");
        return new g(components, gVar.f(), gVar.c());
    }

    private static final g a(g gVar, kotlin.reflect.jvm.internal.impl.descriptors.m mVar, z zVar, int i10, r8.i<y> iVar) {
        k kVarF;
        kotlin.reflect.jvm.internal.impl.load.java.lazy.b bVarA = gVar.a();
        if (zVar != null) {
            kVarF = new h(gVar, mVar, zVar, i10);
        } else {
            kVarF = gVar.f();
        }
        return new g(bVarA, kVarF, iVar);
    }
}
