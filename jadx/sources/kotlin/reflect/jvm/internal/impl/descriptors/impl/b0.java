package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.types.p1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class b0 extends k implements t0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f12774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f12775f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.e0 f12776g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final u0 f12777h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f12778i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.b.a f12779j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.descriptors.u f12780k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.descriptors.y f12781l;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean A() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    public boolean A0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.k
    /* JADX INFO: renamed from: G0 */
    public abstract t0 a();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    public boolean I() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean L() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c1
    public kotlin.reflect.jvm.internal.impl.descriptors.y c(p1 p1Var) {
        if (p1Var == null) {
            C(7);
        }
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public <V> V e0(kotlin.reflect.jvm.internal.impl.descriptors.a.InterfaceC0217a<V> interfaceC0217a) {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean isInfix() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean isOperator() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean isSuspend() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean s0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean y0() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(kotlin.reflect.jvm.internal.impl.descriptors.e0 e0Var, kotlin.reflect.jvm.internal.impl.descriptors.u uVar, u0 u0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, ba.f fVar, boolean z10, boolean z11, boolean z12, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, a1 a1Var) {
        super(u0Var.b(), gVar, fVar, a1Var);
        if (e0Var == null) {
            C(0);
        }
        if (uVar == null) {
            C(1);
        }
        if (u0Var == null) {
            C(2);
        }
        if (gVar == null) {
            C(3);
        }
        if (fVar == null) {
            C(4);
        }
        if (a1Var == null) {
            C(5);
        }
        this.f12781l = null;
        this.f12776g = e0Var;
        this.f12780k = uVar;
        this.f12777h = u0Var;
        this.f12774e = z10;
        this.f12775f = z11;
        this.f12778i = z12;
        this.f12779j = aVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.b
    /* JADX INFO: renamed from: B0, reason: merged with bridge method [inline-methods] */
    public t0 g0(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.e0 e0Var, kotlin.reflect.jvm.internal.impl.descriptors.u uVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, boolean z10) {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    protected Collection<t0> H0(boolean z10) {
        ArrayList arrayList = new ArrayList(0);
        for (u0 u0Var : x0().e()) {
            kotlin.reflect.jvm.internal.impl.descriptors.m getter = z10 ? u0Var.getGetter() : u0Var.getSetter();
            if (getter != null) {
                arrayList.add(getter);
            }
        }
        return arrayList;
    }

    public void I0(boolean z10) {
        this.f12774e = z10;
    }

    public void J0(kotlin.reflect.jvm.internal.impl.descriptors.y yVar) {
        this.f12781l = yVar;
    }

    public void K0(kotlin.reflect.jvm.internal.impl.descriptors.u uVar) {
        this.f12780k = uVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.t0
    public boolean Q() {
        return this.f12774e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y
    public kotlin.reflect.jvm.internal.impl.descriptors.y Z() {
        return this.f12781l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.b
    public kotlin.reflect.jvm.internal.impl.descriptors.b.a g() {
        kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar = this.f12779j;
        if (aVar == null) {
            C(6);
        }
        return aVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<f1> getTypeParameters() {
        List<f1> list = Collections.EMPTY_LIST;
        if (list == null) {
            C(9);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.q
    public kotlin.reflect.jvm.internal.impl.descriptors.u getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.u uVar = this.f12780k;
        if (uVar == null) {
            C(11);
        }
        return uVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    public kotlin.reflect.jvm.internal.impl.descriptors.e0 i() {
        kotlin.reflect.jvm.internal.impl.descriptors.e0 e0Var = this.f12776g;
        if (e0Var == null) {
            C(10);
        }
        return e0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    public boolean isExternal() {
        return this.f12775f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean isInline() {
        return this.f12778i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.b
    public void t0(Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> collection) {
        if (collection == null) {
            C(16);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.t0
    public u0 x0() {
        u0 u0Var = this.f12777h;
        if (u0Var == null) {
            C(13);
        }
        return u0Var;
    }

    private static /* synthetic */ void C(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 7:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                i11 = 2;
                break;
            case 7:
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "visibility";
                break;
            case 2:
                objArr[0] = "correspondingProperty";
                break;
            case 3:
                objArr[0] = "annotations";
                break;
            case 4:
                objArr[0] = "name";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 7:
                objArr[0] = "substitutor";
                break;
            case 16:
                objArr[0] = "overriddenDescriptors";
                break;
            default:
                objArr[0] = "modality";
                break;
        }
        switch (i10) {
            case 6:
                objArr[1] = "getKind";
                break;
            case 7:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 8:
                objArr[1] = "substitute";
                break;
            case 9:
                objArr[1] = "getTypeParameters";
                break;
            case 10:
                objArr[1] = "getModality";
                break;
            case 11:
                objArr[1] = "getVisibility";
                break;
            case 12:
                objArr[1] = "getCorrespondingVariable";
                break;
            case 13:
                objArr[1] = "getCorrespondingProperty";
                break;
            case 14:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 15:
                objArr[1] = "getOverriddenDescriptors";
                break;
        }
        switch (i10) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                break;
            case 7:
                objArr[2] = "substitute";
                break;
            case 16:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                throw new IllegalStateException(str2);
            case 7:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public x0 b0() {
        return x0().b0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public x0 i0() {
        return x0().i0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<x0> n0() {
        List<x0> listN0 = x0().n0();
        if (listN0 == null) {
            C(14);
        }
        return listN0;
    }
}
