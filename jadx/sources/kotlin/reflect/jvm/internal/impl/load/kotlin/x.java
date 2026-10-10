package kotlin.reflect.jvm.internal.impl.load.kotlin;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.load.java.h0;
import kotlin.reflect.jvm.internal.impl.types.g0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class x {
    public static final String b(kotlin.reflect.jvm.internal.impl.descriptors.y yVar, boolean z10, boolean z11) {
        String strF;
        kotlin.jvm.internal.m.f(yVar, "<this>");
        StringBuilder sb2 = new StringBuilder();
        if (z11) {
            if (yVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.l) {
                strF = "<init>";
            } else {
                strF = yVar.getName().f();
                kotlin.jvm.internal.m.e(strF, "name.asString()");
            }
            sb2.append(strF);
        }
        sb2.append("(");
        x0 x0VarI0 = yVar.i0();
        if (x0VarI0 != null) {
            g0 type = x0VarI0.getType();
            kotlin.jvm.internal.m.e(type, "it.type");
            a(sb2, type);
        }
        Iterator<j1> it = yVar.f().iterator();
        while (it.hasNext()) {
            g0 type2 = it.next().getType();
            kotlin.jvm.internal.m.e(type2, "parameter.type");
            a(sb2, type2);
        }
        sb2.append(")");
        if (z10) {
            if (f.c(yVar)) {
                sb2.append(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
            } else {
                g0 returnType = yVar.getReturnType();
                kotlin.jvm.internal.m.c(returnType);
                a(sb2, returnType);
            }
        }
        String string = sb2.toString();
        kotlin.jvm.internal.m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static /* synthetic */ String c(kotlin.reflect.jvm.internal.impl.descriptors.y yVar, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            z11 = true;
        }
        return b(yVar, z10, z11);
    }

    public static final String d(kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        kotlin.jvm.internal.m.f(aVar, "<this>");
        z zVar = z.f13623a;
        if (kotlin.reflect.jvm.internal.impl.resolve.e.E(aVar)) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = aVar.b();
        kotlin.reflect.jvm.internal.impl.descriptors.e eVar = mVarB instanceof kotlin.reflect.jvm.internal.impl.descriptors.e ? (kotlin.reflect.jvm.internal.impl.descriptors.e) mVarB : null;
        if (eVar == null || eVar.getName().m()) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.a aVarA = aVar.a();
        z0 z0Var = aVarA instanceof z0 ? (z0) aVarA : null;
        if (z0Var == null) {
            return null;
        }
        return w.a(zVar, eVar, c(z0Var, false, false, 3, null));
    }

    public static final boolean e(kotlin.reflect.jvm.internal.impl.descriptors.a f10) {
        kotlin.reflect.jvm.internal.impl.descriptors.y yVarK;
        kotlin.jvm.internal.m.f(f10, "f");
        if (!(f10 instanceof kotlin.reflect.jvm.internal.impl.descriptors.y)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.y yVar = (kotlin.reflect.jvm.internal.impl.descriptors.y) f10;
        if (kotlin.jvm.internal.m.a(yVar.getName().f(), "remove") && yVar.f().size() == 1 && !h0.h((kotlin.reflect.jvm.internal.impl.descriptors.b) f10)) {
            List<j1> listF = yVar.a().f();
            kotlin.jvm.internal.m.e(listF, "f.original.valueParameters");
            g0 type = ((j1) kotlin.collections.r.F0(listF)).getType();
            kotlin.jvm.internal.m.e(type, "f.original.valueParameters.single().type");
            n nVarG = g(type);
            n.d dVar = nVarG instanceof n.d ? (n.d) nVarG : null;
            if ((dVar != null ? dVar.i() : null) != fa.e.INT || (yVarK = kotlin.reflect.jvm.internal.impl.load.java.f.k(yVar)) == null) {
                return false;
            }
            List<j1> listF2 = yVarK.a().f();
            kotlin.jvm.internal.m.e(listF2, "overridden.original.valueParameters");
            g0 type2 = ((j1) kotlin.collections.r.F0(listF2)).getType();
            kotlin.jvm.internal.m.e(type2, "overridden.original.valueParameters.single().type");
            n nVarG2 = g(type2);
            kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = yVarK.b();
            kotlin.jvm.internal.m.e(mVarB, "overridden.containingDeclaration");
            if (kotlin.jvm.internal.m.a(ea.c.m(mVarB), kotlin.reflect.jvm.internal.impl.builtins.k.a.f12605d0.j()) && (nVarG2 instanceof n.c) && kotlin.jvm.internal.m.a(((n.c) nVarG2).i(), "java/lang/Object")) {
                return true;
            }
        }
        return false;
    }

    public static final String f(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        kotlin.jvm.internal.m.f(eVar, "<this>");
        kotlin.reflect.jvm.internal.impl.builtins.jvm.c cVar = kotlin.reflect.jvm.internal.impl.builtins.jvm.c.f12505a;
        ba.d dVarJ = ea.c.l(eVar).j();
        kotlin.jvm.internal.m.e(dVarJ, "fqNameSafe.toUnsafe()");
        ba.b bVarN = cVar.n(dVarJ);
        if (bVarN == null) {
            return f.b(eVar, null, 2, null);
        }
        String strF = fa.d.b(bVarN).f();
        kotlin.jvm.internal.m.e(strF, "byClassId(it).internalName");
        return strF;
    }

    public static final n g(g0 g0Var) {
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        return (n) f.e(g0Var, p.f13611a, c0.f13536o, b0.f13531a, null, null, 32, null);
    }

    private static final void a(StringBuilder sb2, g0 g0Var) {
        sb2.append(g(g0Var));
    }
}
