package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.h1;
import kotlin.reflect.jvm.internal.impl.types.g1;
import kotlin.reflect.jvm.internal.impl.types.o0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class h extends g {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.e0 f12840i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.f f12841j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final g1 f12842k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.resolve.scopes.h f12843l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Set<kotlin.reflect.jvm.internal.impl.descriptors.d> f12844m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.descriptors.d f12845n;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    public boolean A0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean E0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean F() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    public boolean I() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i
    public boolean J() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.descriptors.e P() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean t() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public h1<o0> v0() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean x() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, ba.f fVar, kotlin.reflect.jvm.internal.impl.descriptors.e0 e0Var, kotlin.reflect.jvm.internal.impl.descriptors.f fVar2, Collection<kotlin.reflect.jvm.internal.impl.types.g0> collection, a1 a1Var, boolean z10, ka.n nVar) {
        super(nVar, mVar, fVar, a1Var, z10);
        if (mVar == null) {
            w0(0);
        }
        if (fVar == null) {
            w0(1);
        }
        if (e0Var == null) {
            w0(2);
        }
        if (fVar2 == null) {
            w0(3);
        }
        if (collection == null) {
            w0(4);
        }
        if (a1Var == null) {
            w0(5);
        }
        if (nVar == null) {
            w0(6);
        }
        this.f12840i = e0Var;
        this.f12841j = fVar2;
        this.f12842k = new kotlin.reflect.jvm.internal.impl.types.l(this, Collections.EMPTY_LIST, collection, nVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.e> E() {
        List list = Collections.EMPTY_LIST;
        if (list == null) {
            w0(19);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.t
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h G(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        if (gVar == null) {
            w0(12);
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVar = this.f12843l;
        if (hVar == null) {
            w0(13);
        }
        return hVar;
    }

    public final void G0(kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVar, Set<kotlin.reflect.jvm.internal.impl.descriptors.d> set, kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        if (hVar == null) {
            w0(7);
        }
        if (set == null) {
            w0(8);
        }
        this.f12843l = hVar;
        this.f12844m = set;
        this.f12845n = dVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.descriptors.d M() {
        return this.f12845n;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h N() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h.b bVar = kotlin.reflect.jvm.internal.impl.resolve.scopes.h.b.f14005b;
        if (bVar == null) {
            w0(14);
        }
        return bVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.descriptors.f g() {
        kotlin.reflect.jvm.internal.impl.descriptors.f fVar = this.f12841j;
        if (fVar == null) {
            w0(15);
        }
        return fVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g getAnnotations() {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVarB = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b();
        if (gVarB == null) {
            w0(9);
        }
        return gVarB;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.q
    public kotlin.reflect.jvm.internal.impl.descriptors.u getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.u uVar = kotlin.reflect.jvm.internal.impl.descriptors.t.f13068e;
        if (uVar == null) {
            w0(17);
        }
        return uVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h
    public g1 h() {
        g1 g1Var = this.f12842k;
        if (g1Var == null) {
            w0(10);
        }
        return g1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.d0
    public kotlin.reflect.jvm.internal.impl.descriptors.e0 i() {
        kotlin.reflect.jvm.internal.impl.descriptors.e0 e0Var = this.f12840i;
        if (e0Var == null) {
            w0(16);
        }
        return e0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> k() {
        Set<kotlin.reflect.jvm.internal.impl.descriptors.d> set = this.f12844m;
        if (set == null) {
            w0(11);
        }
        return set;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.i
    public List<f1> r() {
        List<f1> list = Collections.EMPTY_LIST;
        if (list == null) {
            w0(18);
        }
        return list;
    }

    public String toString() {
        return "class " + getName();
    }

    private static /* synthetic */ void w0(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                i11 = 2;
                break;
            case 12:
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "supertypes";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "unsubstitutedMemberScope";
                break;
            case 8:
                objArr[0] = "constructors";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 12:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i10) {
            case 9:
                objArr[1] = "getAnnotations";
                break;
            case 10:
                objArr[1] = "getTypeConstructor";
                break;
            case 11:
                objArr[1] = "getConstructors";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 13:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 14:
                objArr[1] = "getStaticScope";
                break;
            case 15:
                objArr[1] = "getKind";
                break;
            case 16:
                objArr[1] = "getModality";
                break;
            case 17:
                objArr[1] = "getVisibility";
                break;
            case 18:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 19:
                objArr[1] = "getSealedSubclasses";
                break;
        }
        switch (i10) {
            case 7:
            case 8:
                objArr[2] = "initialize";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                break;
            case 12:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                throw new IllegalStateException(str2);
            case 12:
            default:
                throw new IllegalArgumentException(str2);
        }
    }
}
