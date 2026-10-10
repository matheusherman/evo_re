package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.types.w1;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class k0 extends e {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final c9.l<kotlin.reflect.jvm.internal.impl.types.g0, Void> f12853k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final List<kotlin.reflect.jvm.internal.impl.types.g0> f12854l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f12855m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private k0(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z10, w1 w1Var, ba.f fVar, int i10, a1 a1Var, c9.l<kotlin.reflect.jvm.internal.impl.types.g0, Void> lVar, d1 d1Var, ka.n nVar) {
        super(nVar, mVar, gVar, fVar, w1Var, z10, i10, a1Var, d1Var);
        if (mVar == null) {
            C(19);
        }
        if (gVar == null) {
            C(20);
        }
        if (w1Var == null) {
            C(21);
        }
        if (fVar == null) {
            C(22);
        }
        if (a1Var == null) {
            C(23);
        }
        if (d1Var == null) {
            C(24);
        }
        if (nVar == null) {
            C(25);
        }
        this.f12854l = new ArrayList(1);
        this.f12855m = false;
        this.f12853k = lVar;
    }

    private static /* synthetic */ void C(int i10) {
        String str = (i10 == 5 || i10 == 28) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 5 || i10 == 28) ? 2 : 3];
        switch (i10) {
            case 1:
            case 7:
            case 13:
            case 20:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 14:
            case 21:
                objArr[0] = "variance";
                break;
            case 3:
            case 9:
            case 15:
            case 22:
                objArr[0] = "name";
                break;
            case 4:
            case 11:
            case 18:
            case 25:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 28:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 16:
            case 23:
                objArr[0] = "source";
                break;
            case 17:
                objArr[0] = "supertypeLoopsResolver";
                break;
            case 24:
                objArr[0] = "supertypeLoopsChecker";
                break;
            case 26:
                objArr[0] = "bound";
                break;
            case 27:
                objArr[0] = IjkMediaMeta.IJKM_KEY_TYPE;
                break;
        }
        if (i10 == 5) {
            objArr[1] = "createWithDefaultBound";
        } else if (i10 != 28) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
        } else {
            objArr[1] = "resolveUpperBounds";
        }
        switch (i10) {
            case 5:
            case 28:
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createForFurtherModification";
                break;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                objArr[2] = "<init>";
                break;
            case 26:
                objArr[2] = "addUpperBound";
                break;
            case 27:
                objArr[2] = "reportSupertypeLoopError";
                break;
            default:
                objArr[2] = "createWithDefaultBound";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 5 && i10 != 28) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    private void J0() {
        if (this.f12855m) {
            return;
        }
        throw new IllegalStateException("Type parameter descriptor is not initialized: " + Q0());
    }

    private void K0() {
        if (this.f12855m) {
            throw new IllegalStateException("Type parameter descriptor is already initialized: " + Q0());
        }
    }

    public static k0 L0(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z10, w1 w1Var, ba.f fVar, int i10, a1 a1Var, c9.l<kotlin.reflect.jvm.internal.impl.types.g0, Void> lVar, d1 d1Var, ka.n nVar) {
        if (mVar == null) {
            C(12);
        }
        if (gVar == null) {
            C(13);
        }
        if (w1Var == null) {
            C(14);
        }
        if (fVar == null) {
            C(15);
        }
        if (a1Var == null) {
            C(16);
        }
        if (d1Var == null) {
            C(17);
        }
        if (nVar == null) {
            C(18);
        }
        return new k0(mVar, gVar, z10, w1Var, fVar, i10, a1Var, lVar, d1Var, nVar);
    }

    public static k0 M0(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z10, w1 w1Var, ba.f fVar, int i10, a1 a1Var, ka.n nVar) {
        if (mVar == null) {
            C(6);
        }
        if (gVar == null) {
            C(7);
        }
        if (w1Var == null) {
            C(8);
        }
        if (fVar == null) {
            C(9);
        }
        if (a1Var == null) {
            C(10);
        }
        if (nVar == null) {
            C(11);
        }
        return L0(mVar, gVar, z10, w1Var, fVar, i10, a1Var, null, d1.a.f12742a, nVar);
    }

    public static f1 N0(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z10, w1 w1Var, ba.f fVar, int i10, ka.n nVar) {
        if (mVar == null) {
            C(0);
        }
        if (gVar == null) {
            C(1);
        }
        if (w1Var == null) {
            C(2);
        }
        if (fVar == null) {
            C(3);
        }
        if (nVar == null) {
            C(4);
        }
        k0 k0VarM0 = M0(mVar, gVar, z10, w1Var, fVar, i10, a1.f12668a, nVar);
        k0VarM0.I0(ea.c.j(mVar).y());
        k0VarM0.R0();
        return k0VarM0;
    }

    private String Q0() {
        return getName() + " declared in " + kotlin.reflect.jvm.internal.impl.resolve.e.m(b());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.e
    protected void G0(kotlin.reflect.jvm.internal.impl.types.g0 g0Var) {
        if (g0Var == null) {
            C(27);
        }
        c9.l<kotlin.reflect.jvm.internal.impl.types.g0, Void> lVar = this.f12853k;
        if (lVar == null) {
            return;
        }
        lVar.invoke(g0Var);
    }

    public void I0(kotlin.reflect.jvm.internal.impl.types.g0 g0Var) {
        if (g0Var == null) {
            C(26);
        }
        K0();
        O0(g0Var);
    }

    public boolean P0() {
        return this.f12855m;
    }

    private void O0(kotlin.reflect.jvm.internal.impl.types.g0 g0Var) {
        if (kotlin.reflect.jvm.internal.impl.types.i0.a(g0Var)) {
            return;
        }
        this.f12854l.add(g0Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.e
    protected List<kotlin.reflect.jvm.internal.impl.types.g0> H0() {
        J0();
        List<kotlin.reflect.jvm.internal.impl.types.g0> list = this.f12854l;
        if (list == null) {
            C(28);
        }
        return list;
    }

    public void R0() {
        K0();
        this.f12855m = true;
    }
}
