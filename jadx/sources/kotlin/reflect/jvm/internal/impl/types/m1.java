package kotlin.reflect.jvm.internal.impl.types;

import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class m1 extends l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w1 f14341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g0 f14342b;

    public m1(w1 w1Var, g0 g0Var) {
        if (w1Var == null) {
            d(0);
        }
        if (g0Var == null) {
            d(1);
        }
        this.f14341a = w1Var;
        this.f14342b = g0Var;
    }

    private static /* synthetic */ void d(int i10) {
        String str = (i10 == 4 || i10 == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 4 || i10 == 5) ? 2 : 3];
        switch (i10) {
            case 1:
            case 2:
            case 3:
                objArr[0] = IjkMediaMeta.IJKM_KEY_TYPE;
                break;
            case 4:
            case 5:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
                break;
            case 6:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "projection";
                break;
        }
        if (i10 == 4) {
            objArr[1] = "getProjectionKind";
        } else if (i10 != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
        } else {
            objArr[1] = "getType";
        }
        if (i10 == 3) {
            objArr[2] = "replaceType";
        } else if (i10 != 4 && i10 != 5) {
            if (i10 != 6) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "refine";
            }
        }
        String str2 = String.format(str, objArr);
        if (i10 != 4 && i10 != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.k1
    public boolean b() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.k1
    public w1 a() {
        w1 w1Var = this.f14341a;
        if (w1Var == null) {
            d(4);
        }
        return w1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.k1
    public k1 c(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        if (gVar == null) {
            d(6);
        }
        return new m1(this.f14341a, gVar.a(this.f14342b));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.k1
    public g0 getType() {
        g0 g0Var = this.f14342b;
        if (g0Var == null) {
            d(5);
        }
        return g0Var;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public m1(g0 g0Var) {
        this(w1.INVARIANT, g0Var);
        if (g0Var == null) {
            d(2);
        }
    }
}
