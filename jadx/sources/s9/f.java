package s9;

import java.util.List;
import ka.j;
import kotlin.collections.r;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.types.g0;
import r8.p;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class f extends c0 implements a {
    private final boolean C;
    private final p<kotlin.reflect.jvm.internal.impl.descriptors.a.InterfaceC0217a<?>, ?> D;
    private g0 E;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.m0, kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean A() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected f(m mVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, e0 e0Var, u uVar, boolean z10, ba.f fVar, a1 a1Var, u0 u0Var, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, boolean z11, p<kotlin.reflect.jvm.internal.impl.descriptors.a.InterfaceC0217a<?>, ?> pVar) {
        super(mVar, u0Var, gVar, e0Var, uVar, z10, fVar, aVar, a1Var, false, false, false, false, false, false);
        if (mVar == null) {
            C(0);
        }
        if (gVar == null) {
            C(1);
        }
        if (e0Var == null) {
            C(2);
        }
        if (uVar == null) {
            C(3);
        }
        if (fVar == null) {
            C(4);
        }
        if (a1Var == null) {
            C(5);
        }
        if (aVar == null) {
            C(6);
        }
        this.E = null;
        this.C = z11;
        this.D = pVar;
    }

    private static /* synthetic */ void C(int i10) {
        String str = i10 != 21 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i10 != 21 ? 3 : 2];
        switch (i10) {
            case 1:
            case 8:
                objArr[0] = "annotations";
                break;
            case 2:
            case 9:
                objArr[0] = "modality";
                break;
            case 3:
            case 10:
                objArr[0] = "visibility";
                break;
            case 4:
            case 11:
                objArr[0] = "name";
                break;
            case 5:
            case 12:
            case 18:
                objArr[0] = "source";
                break;
            case 6:
            case 16:
                objArr[0] = "kind";
                break;
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 14:
                objArr[0] = "newModality";
                break;
            case 15:
                objArr[0] = "newVisibility";
                break;
            case 17:
                objArr[0] = "newName";
                break;
            case 19:
                objArr[0] = "enhancedValueParameterTypes";
                break;
            case 20:
                objArr[0] = "enhancedReturnType";
                break;
            case 21:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
                break;
            case 22:
                objArr[0] = "inType";
                break;
        }
        if (i10 != 21) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i10) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "create";
                break;
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 19:
            case 20:
                objArr[2] = "enhance";
                break;
            case 21:
                break;
            case 22:
                objArr[2] = "setInType";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 == 21) {
            throw new IllegalStateException(str2);
        }
    }

    public static f b1(m mVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, e0 e0Var, u uVar, boolean z10, ba.f fVar, a1 a1Var, boolean z11) {
        if (mVar == null) {
            C(7);
        }
        if (gVar == null) {
            C(8);
        }
        if (e0Var == null) {
            C(9);
        }
        if (uVar == null) {
            C(10);
        }
        if (fVar == null) {
            C(11);
        }
        if (a1Var == null) {
            C(12);
        }
        return new f(mVar, gVar, e0Var, uVar, z10, fVar, a1Var, null, kotlin.reflect.jvm.internal.impl.descriptors.b.a.DECLARATION, z11, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.c0
    protected c0 L0(m mVar, e0 e0Var, u uVar, u0 u0Var, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, ba.f fVar, a1 a1Var) {
        if (mVar == null) {
            C(13);
        }
        if (e0Var == null) {
            C(14);
        }
        if (uVar == null) {
            C(15);
        }
        if (aVar == null) {
            C(16);
        }
        if (fVar == null) {
            C(17);
        }
        if (a1Var == null) {
            C(18);
        }
        return new f(mVar, getAnnotations(), e0Var, uVar, f0(), fVar, a1Var, u0Var, aVar, this.C, this.D);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.c0
    public void V0(g0 g0Var) {
        if (g0Var == null) {
            C(22);
        }
        this.E = g0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.c0, kotlin.reflect.jvm.internal.impl.descriptors.a
    public <V> V e0(kotlin.reflect.jvm.internal.impl.descriptors.a.InterfaceC0217a<V> interfaceC0217a) {
        p<kotlin.reflect.jvm.internal.impl.descriptors.a.InterfaceC0217a<?>, ?> pVar = this.D;
        if (pVar == null || !pVar.c().equals(interfaceC0217a)) {
            return null;
        }
        return (V) this.D.d();
    }

    @Override // s9.a
    public a u(g0 g0Var, List<g0> list, g0 g0Var2, p<kotlin.reflect.jvm.internal.impl.descriptors.a.InterfaceC0217a<?>, ?> pVar) {
        d0 d0Var;
        kotlin.reflect.jvm.internal.impl.descriptors.impl.e0 e0Var;
        if (list == null) {
            C(19);
        }
        if (g0Var2 == null) {
            C(20);
        }
        u0 u0VarA = a() == this ? null : a();
        f fVar = new f(b(), getAnnotations(), i(), getVisibility(), f0(), getName(), getSource(), u0VarA, g(), this.C, pVar);
        d0 getter = getGetter();
        if (getter != null) {
            d0 d0Var2 = new d0(fVar, getter.getAnnotations(), getter.i(), getter.getVisibility(), getter.Q(), getter.isExternal(), getter.isInline(), g(), u0VarA == null ? null : u0VarA.getGetter(), getter.getSource());
            d0Var2.J0(getter.Z());
            d0Var2.M0(g0Var2);
            d0Var = d0Var2;
        } else {
            d0Var = null;
        }
        w0 setter = getSetter();
        if (setter != null) {
            e0Var = new kotlin.reflect.jvm.internal.impl.descriptors.impl.e0(fVar, setter.getAnnotations(), setter.i(), setter.getVisibility(), setter.Q(), setter.isExternal(), setter.isInline(), g(), u0VarA == null ? null : u0VarA.getSetter(), setter.getSource());
            e0Var.J0(e0Var.Z());
            e0Var.N0(setter.f().get(0));
        } else {
            e0Var = null;
        }
        fVar.R0(d0Var, e0Var, m0(), j0());
        fVar.W0(S0());
        c9.a<j<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>>> aVar = this.f12883h;
        if (aVar != null) {
            fVar.G0(this.f12882g, aVar);
        }
        fVar.t0(e());
        fVar.X0(g0Var2, getTypeParameters(), b0(), g0Var != null ? kotlin.reflect.jvm.internal.impl.resolve.d.i(this, g0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b()) : null, r.l());
        return fVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.c0, kotlin.reflect.jvm.internal.impl.descriptors.k1
    public boolean isConst() {
        g0 type = getType();
        if (this.C && kotlin.reflect.jvm.internal.impl.descriptors.j.a(type)) {
            if (!kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.r.i(type) || kotlin.reflect.jvm.internal.impl.builtins.h.v0(type)) {
                return true;
            }
            return false;
        }
        return false;
    }
}
