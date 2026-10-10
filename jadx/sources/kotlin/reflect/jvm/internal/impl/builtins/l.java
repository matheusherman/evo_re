package kotlin.reflect.jvm.internal.impl.builtins;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.r;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.y;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.types.c1;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.g1;
import kotlin.reflect.jvm.internal.impl.types.h0;
import kotlin.reflect.jvm.internal.impl.types.k1;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.w1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final y f12650a;

    static {
        kotlin.reflect.jvm.internal.impl.descriptors.impl.m mVar = new kotlin.reflect.jvm.internal.impl.descriptors.impl.m(la.k.f15326a.i(), k.f12585n);
        kotlin.reflect.jvm.internal.impl.descriptors.f fVar = kotlin.reflect.jvm.internal.impl.descriptors.f.INTERFACE;
        ba.f fVarG = k.f12588q.g();
        a1 a1Var = a1.f12668a;
        ka.n nVar = ka.f.f12182e;
        y yVar = new y(mVar, fVar, false, false, fVarG, a1Var, nVar);
        yVar.I0(e0.ABSTRACT);
        yVar.K0(t.f13068e);
        yVar.J0(r.e(k0.N0(yVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b(), false, w1.IN_VARIANCE, ba.f.l(ExifInterface.GPS_DIRECTION_TRUE), 0, nVar)));
        yVar.G0();
        f12650a = yVar;
    }

    public static final o0 a(g0 suspendFunType) {
        kotlin.jvm.internal.m.f(suspendFunType, "suspendFunType");
        g.q(suspendFunType);
        h hVarI = oa.a.i(suspendFunType);
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations = suspendFunType.getAnnotations();
        g0 g0VarJ = g.j(suspendFunType);
        List<g0> listE = g.e(suspendFunType);
        List<k1> listL = g.l(suspendFunType);
        ArrayList arrayList = new ArrayList(r.w(listL, 10));
        Iterator<T> it = listL.iterator();
        while (it.hasNext()) {
            arrayList.add(((k1) it.next()).getType());
        }
        c1 c1VarH = c1.f14231b.h();
        g1 g1VarH = f12650a.h();
        kotlin.jvm.internal.m.e(g1VarH, "FAKE_CONTINUATION_CLASS_DESCRIPTOR.typeConstructor");
        List listC0 = r.C0(arrayList, h0.j(c1VarH, g1VarH, r.e(oa.a.a(g.k(suspendFunType))), false, null, 16, null));
        o0 o0VarI = oa.a.i(suspendFunType).I();
        kotlin.jvm.internal.m.e(o0VarI, "suspendFunType.builtIns.nullableAnyType");
        return g.b(hVarI, annotations, g0VarJ, listE, listC0, null, o0VarI, (128 & 128) != 0 ? false : false).N0(suspendFunType.K0());
    }
}
