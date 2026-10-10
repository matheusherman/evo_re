package kotlin.reflect.jvm.internal.impl.load.java;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.n1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.u f13420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.u f13421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.u f13422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<n1, kotlin.reflect.jvm.internal.impl.descriptors.u> f13423d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a extends kotlin.reflect.jvm.internal.impl.descriptors.r {
        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = TypedValues.TransitionType.S_FROM;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$1";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.u
        public boolean e(ha.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.q qVar, kotlin.reflect.jvm.internal.impl.descriptors.m mVar, boolean z10) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            return s.d(qVar, mVar);
        }

        a(n1 n1Var) {
            super(n1Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class b extends kotlin.reflect.jvm.internal.impl.descriptors.r {
        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = TypedValues.TransitionType.S_FROM;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.u
        public boolean e(ha.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.q qVar, kotlin.reflect.jvm.internal.impl.descriptors.m mVar, boolean z10) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            return s.e(gVar, qVar, mVar);
        }

        b(n1 n1Var) {
            super(n1Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class c extends kotlin.reflect.jvm.internal.impl.descriptors.r {
        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = TypedValues.TransitionType.S_FROM;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$3";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.u
        public boolean e(ha.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.q qVar, kotlin.reflect.jvm.internal.impl.descriptors.m mVar, boolean z10) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            return s.e(gVar, qVar, mVar);
        }

        c(n1 n1Var) {
            super(n1Var);
        }
    }

    private static /* synthetic */ void a(int i10) {
        String str = (i10 == 5 || i10 == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 5 || i10 == 6) ? 2 : 3];
        switch (i10) {
            case 1:
                objArr[0] = TypedValues.TransitionType.S_FROM;
                break;
            case 2:
                objArr[0] = "first";
                break;
            case 3:
                objArr[0] = "second";
                break;
            case 4:
                objArr[0] = "visibility";
                break;
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
                break;
            default:
                objArr[0] = "what";
                break;
        }
        if (i10 == 5 || i10 == 6) {
            objArr[1] = "toDescriptorVisibility";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
        }
        if (i10 == 2 || i10 == 3) {
            objArr[2] = "areInSamePackage";
        } else if (i10 == 4) {
            objArr[2] = "toDescriptorVisibility";
        } else if (i10 != 5 && i10 != 6) {
            objArr[2] = "isVisibleForProtectedAndPackage";
        }
        String str2 = String.format(str, objArr);
        if (i10 != 5 && i10 != 6) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean e(ha.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.q qVar, kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        if (qVar == null) {
            a(0);
        }
        if (mVar == null) {
            a(1);
        }
        if (d(kotlin.reflect.jvm.internal.impl.resolve.e.M(qVar), mVar)) {
            return true;
        }
        return kotlin.reflect.jvm.internal.impl.descriptors.t.f13066c.e(gVar, qVar, mVar, false);
    }

    static {
        a aVar = new a(o9.a.f16511c);
        f13420a = aVar;
        b bVar = new b(o9.c.f16513c);
        f13421b = bVar;
        c cVar = new c(o9.b.f16512c);
        f13422c = cVar;
        f13423d = new HashMap();
        f(aVar);
        f(bVar);
        f(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.m mVar2) {
        if (mVar == null) {
            a(2);
        }
        if (mVar2 == null) {
            a(3);
        }
        l0 l0Var = (l0) kotlin.reflect.jvm.internal.impl.resolve.e.r(mVar, l0.class, false);
        l0 l0Var2 = (l0) kotlin.reflect.jvm.internal.impl.resolve.e.r(mVar2, l0.class, false);
        return (l0Var2 == null || l0Var == null || !l0Var.d().equals(l0Var2.d())) ? false : true;
    }

    private static void f(kotlin.reflect.jvm.internal.impl.descriptors.u uVar) {
        f13423d.put(uVar.b(), uVar);
    }

    public static kotlin.reflect.jvm.internal.impl.descriptors.u g(n1 n1Var) {
        if (n1Var == null) {
            a(4);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.u uVar = f13423d.get(n1Var);
        if (uVar != null) {
            return uVar;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.u uVarJ = kotlin.reflect.jvm.internal.impl.descriptors.t.j(n1Var);
        if (uVarJ == null) {
            a(5);
        }
        return uVarJ;
    }
}
