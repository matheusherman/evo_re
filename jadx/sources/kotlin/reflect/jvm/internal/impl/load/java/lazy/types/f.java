package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.j1;
import kotlin.reflect.jvm.internal.impl.types.k1;
import kotlin.reflect.jvm.internal.impl.types.m1;
import kotlin.reflect.jvm.internal.impl.types.s1;
import kotlin.reflect.jvm.internal.impl.types.w1;
import kotlin.reflect.jvm.internal.impl.types.x;
import kotlin.reflect.jvm.internal.impl.types.y;
import r8.n;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class f extends x {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13403a;

        static {
            int[] iArr = new int[c.values().length];
            try {
                iArr[c.FLEXIBLE_LOWER_BOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[c.FLEXIBLE_UPPER_BOUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[c.INFLEXIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f13403a = iArr;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.x
    public k1 a(f1 parameter, y typeAttr, j1 typeParameterUpperBoundEraser, g0 erasedUpperBound) {
        k1 m1Var;
        m.f(parameter, "parameter");
        m.f(typeAttr, "typeAttr");
        m.f(typeParameterUpperBoundEraser, "typeParameterUpperBoundEraser");
        m.f(erasedUpperBound, "erasedUpperBound");
        if (!(typeAttr instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a)) {
            return super.a(parameter, typeAttr, typeParameterUpperBoundEraser, erasedUpperBound);
        }
        kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVarL = (kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a) typeAttr;
        if (!aVarL.i()) {
            aVarL = aVarL.l(c.INFLEXIBLE);
        }
        int i10 = a.f13403a[aVarL.g().ordinal()];
        if (i10 == 1) {
            return new m1(w1.INVARIANT, erasedUpperBound);
        }
        if (i10 != 2 && i10 != 3) {
            throw new n();
        }
        if (parameter.j().f()) {
            List<f1> parameters = erasedUpperBound.J0().getParameters();
            m.e(parameters, "erasedUpperBound.constructor.parameters");
            m1Var = !parameters.isEmpty() ? new m1(w1.OUT_VARIANCE, erasedUpperBound) : s1.t(parameter, aVarL);
        } else {
            m1Var = new m1(w1.INVARIANT, ea.c.j(parameter).H());
        }
        m.e(m1Var, "{\n                if (!p…          }\n            }");
        return m1Var;
    }
}
