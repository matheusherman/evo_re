package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.h1;
import kotlin.reflect.jvm.internal.impl.types.g1;
import kotlin.reflect.jvm.internal.impl.types.o0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class y extends g {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.f f12965i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f12966j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.descriptors.e0 f12967k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.descriptors.u f12968l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private g1 f12969m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private List<f1> f12970n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Collection<kotlin.reflect.jvm.internal.impl.types.g0> f12971o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final ka.n f12972p;

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

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.descriptors.d M() {
        return null;
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
    public y(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.f fVar, boolean z10, boolean z11, ba.f fVar2, a1 a1Var, ka.n nVar) {
        super(nVar, mVar, fVar2, a1Var, z11);
        if (mVar == null) {
            w0(0);
        }
        if (fVar == null) {
            w0(1);
        }
        if (fVar2 == null) {
            w0(2);
        }
        if (a1Var == null) {
            w0(3);
        }
        if (nVar == null) {
            w0(4);
        }
        this.f12971o = new ArrayList();
        this.f12972p = nVar;
        this.f12965i = fVar;
        this.f12966j = z10;
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
            w0(16);
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h.b bVar = kotlin.reflect.jvm.internal.impl.resolve.scopes.h.b.f14005b;
        if (bVar == null) {
            w0(17);
        }
        return bVar;
    }

    public void G0() {
        this.f12969m = new kotlin.reflect.jvm.internal.impl.types.l(this, this.f12970n, this.f12971o, this.f12972p);
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.d> it = k().iterator();
        while (it.hasNext()) {
            ((f) it.next()).c1(p());
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public Set<kotlin.reflect.jvm.internal.impl.descriptors.d> k() {
        Set<kotlin.reflect.jvm.internal.impl.descriptors.d> set = Collections.EMPTY_SET;
        if (set == null) {
            w0(13);
        }
        return set;
    }

    public void I0(kotlin.reflect.jvm.internal.impl.descriptors.e0 e0Var) {
        if (e0Var == null) {
            w0(6);
        }
        this.f12967k = e0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i
    public boolean J() {
        return this.f12966j;
    }

    public void J0(List<f1> list) {
        if (list == null) {
            w0(14);
        }
        if (this.f12970n == null) {
            this.f12970n = new ArrayList(list);
            return;
        }
        throw new IllegalStateException("Type parameters are already set for " + getName());
    }

    public void K0(kotlin.reflect.jvm.internal.impl.descriptors.u uVar) {
        if (uVar == null) {
            w0(9);
        }
        this.f12968l = uVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h N() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h.b bVar = kotlin.reflect.jvm.internal.impl.resolve.scopes.h.b.f14005b;
        if (bVar == null) {
            w0(18);
        }
        return bVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.descriptors.f g() {
        kotlin.reflect.jvm.internal.impl.descriptors.f fVar = this.f12965i;
        if (fVar == null) {
            w0(8);
        }
        return fVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g getAnnotations() {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVarB = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b();
        if (gVarB == null) {
            w0(5);
        }
        return gVarB;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.q
    public kotlin.reflect.jvm.internal.impl.descriptors.u getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.u uVar = this.f12968l;
        if (uVar == null) {
            w0(10);
        }
        return uVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h
    public g1 h() {
        g1 g1Var = this.f12969m;
        if (g1Var == null) {
            w0(11);
        }
        return g1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.d0
    public kotlin.reflect.jvm.internal.impl.descriptors.e0 i() {
        kotlin.reflect.jvm.internal.impl.descriptors.e0 e0Var = this.f12967k;
        if (e0Var == null) {
            w0(7);
        }
        return e0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.i
    public List<f1> r() {
        List<f1> list = this.f12970n;
        if (list == null) {
            w0(15);
        }
        return list;
    }

    private static /* synthetic */ void w0(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                i11 = 2;
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "kind";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
                break;
            case 6:
                objArr[0] = "modality";
                break;
            case 9:
                objArr[0] = "visibility";
                break;
            case 12:
                objArr[0] = "supertype";
                break;
            case 14:
                objArr[0] = "typeParameters";
                break;
            case 16:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i10) {
            case 5:
                objArr[1] = "getAnnotations";
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
                break;
            case 7:
                objArr[1] = "getModality";
                break;
            case 8:
                objArr[1] = "getKind";
                break;
            case 10:
                objArr[1] = "getVisibility";
                break;
            case 11:
                objArr[1] = "getTypeConstructor";
                break;
            case 13:
                objArr[1] = "getConstructors";
                break;
            case 15:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 17:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 18:
                objArr[1] = "getStaticScope";
                break;
            case 19:
                objArr[1] = "getSealedSubclasses";
                break;
        }
        switch (i10) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                break;
            case 6:
                objArr[2] = "setModality";
                break;
            case 9:
                objArr[2] = "setVisibility";
                break;
            case 12:
                objArr[2] = "addSupertype";
                break;
            case 14:
                objArr[2] = "setTypeParameterDescriptors";
                break;
            case 16:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                throw new IllegalStateException(str2);
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public String toString() {
        return j.G(this);
    }
}
