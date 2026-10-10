package j9;

import i9.e;
import i9.n;
import i9.p;
import i9.q;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.c0;
import kotlin.reflect.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.types.c1;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.g1;
import kotlin.reflect.jvm.internal.impl.types.h0;
import kotlin.reflect.jvm.internal.impl.types.m1;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.u0;
import kotlin.reflect.jvm.internal.impl.types.w1;
import kotlin.reflect.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a=\u0010\t\u001a\u00020\b*\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001H\u0007¢\u0006\u0004\b\t\u0010\n\u001a5\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Li9/e;", "", "Li9/p;", "arguments", "", "nullable", "", "annotations", "Li9/n;", "b", "(Li9/e;Ljava/util/List;ZLjava/util/List;)Li9/n;", "Lkotlin/reflect/jvm/internal/impl/types/c1;", "attributes", "Lkotlin/reflect/jvm/internal/impl/types/g1;", "typeConstructor", "Lkotlin/reflect/jvm/internal/impl/types/o0;", "a", "(Lkotlin/reflect/jvm/internal/impl/types/c1;Lkotlin/reflect/jvm/internal/impl/types/g1;Ljava/util/List;Z)Lkotlin/reflect/jvm/internal/impl/types/o0;", "kotlin-reflection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class c {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11648a;

        static {
            int[] iArr = new int[q.values().length];
            try {
                iArr[q.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[q.IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[q.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f11648a = iArr;
        }
    }

    public static final n b(e eVar, List<p> arguments, boolean z10, List<? extends Annotation> annotations) {
        h hVarI;
        m.f(eVar, "<this>");
        m.f(arguments, "arguments");
        m.f(annotations, "annotations");
        l lVar = eVar instanceof l ? (l) eVar : null;
        if (lVar == null || (hVarI = lVar.i()) == null) {
            throw new f0("Cannot create type for an unsupported classifier: " + eVar + " (" + eVar.getClass() + ')');
        }
        g1 g1VarH = hVarI.h();
        m.e(g1VarH, "descriptor.typeConstructor");
        List<f1> parameters = g1VarH.getParameters();
        m.e(parameters, "typeConstructor.parameters");
        if (parameters.size() == arguments.size()) {
            return new c0(a(annotations.isEmpty() ? c1.f14231b.h() : c1.f14231b.h(), g1VarH, arguments, z10), null, 2, null);
        }
        throw new IllegalArgumentException("Class declares " + parameters.size() + " type parameters, but " + arguments.size() + " were provided.");
    }

    private static final o0 a(c1 c1Var, g1 g1Var, List<p> list, boolean z10) {
        g0 g0Var;
        int i10;
        na.m u0Var;
        List<f1> parameters = g1Var.getParameters();
        m.e(parameters, "typeConstructor.parameters");
        List<p> list2 = list;
        ArrayList arrayList = new ArrayList(r.w(list2, 10));
        int i11 = 0;
        for (Object obj : list2) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                r.v();
            }
            p pVar = (p) obj;
            c0 c0Var = (c0) pVar.c();
            if (c0Var != null) {
                g0Var = c0Var.getTv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TYPE java.lang.String();
            } else {
                g0Var = null;
            }
            q qVarD = pVar.d();
            if (qVarD == null) {
                i10 = -1;
            } else {
                i10 = a.f11648a[qVarD.ordinal()];
            }
            if (i10 != -1) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 == 3) {
                            w1 w1Var = w1.OUT_VARIANCE;
                            m.c(g0Var);
                            u0Var = new m1(w1Var, g0Var);
                        } else {
                            throw new r8.n();
                        }
                    } else {
                        w1 w1Var2 = w1.IN_VARIANCE;
                        m.c(g0Var);
                        u0Var = new m1(w1Var2, g0Var);
                    }
                } else {
                    w1 w1Var3 = w1.INVARIANT;
                    m.c(g0Var);
                    u0Var = new m1(w1Var3, g0Var);
                }
            } else {
                f1 f1Var = parameters.get(i11);
                m.e(f1Var, "parameters[index]");
                u0Var = new u0(f1Var);
            }
            arrayList.add(u0Var);
            i11 = i12;
        }
        return h0.j(c1Var, g1Var, arrayList, z10, null, 16, null);
    }
}
