package ha;

import kotlin.reflect.jvm.internal.impl.types.g0;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class j extends a {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(g0 g0Var) {
        this(g0Var, null);
        if (g0Var == null) {
            c(0);
        }
    }

    private static /* synthetic */ void c(int i10) {
        Object[] objArr = new Object[3];
        if (i10 != 2) {
            objArr[0] = IjkMediaMeta.IJKM_KEY_TYPE;
        } else {
            objArr[0] = "newType";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/TransientReceiver";
        if (i10 != 2) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "replaceType";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private j(g0 g0Var, g gVar) {
        super(g0Var, gVar);
        if (g0Var == null) {
            c(1);
        }
    }

    public String toString() {
        return "{Transient} : " + getType();
    }
}
