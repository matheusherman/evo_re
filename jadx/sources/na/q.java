package na;

import kotlin.reflect.jvm.internal.impl.types.w1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class q {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16104a;

        static {
            int[] iArr = new int[w1.values().length];
            try {
                iArr[w1.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[w1.IN_VARIANCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[w1.OUT_VARIANCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f16104a = iArr;
        }
    }

    public static final u a(w1 w1Var) {
        kotlin.jvm.internal.m.f(w1Var, "<this>");
        int i10 = a.f16104a[w1Var.ordinal()];
        if (i10 == 1) {
            return u.INV;
        }
        if (i10 == 2) {
            return u.IN;
        }
        if (i10 == 3) {
            return u.OUT;
        }
        throw new r8.n();
    }
}
