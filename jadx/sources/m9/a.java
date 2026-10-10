package m9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import ka.n;
import kotlin.collections.r;
import kotlin.collections.v0;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.builtins.f;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class a implements n9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n f15671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h0 f15672b;

    public a(n storageManager, h0 module) {
        m.f(storageManager, "storageManager");
        m.f(module, "module");
        this.f15671a = storageManager;
        this.f15672b = module;
    }

    @Override // n9.b
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.e> a(ba.c packageFqName) {
        m.f(packageFqName, "packageFqName");
        return v0.e();
    }

    @Override // n9.b
    public kotlin.reflect.jvm.internal.impl.descriptors.e b(ba.b classId) {
        m.f(classId, "classId");
        if (classId.k() || classId.l()) {
            return null;
        }
        String strB = classId.i().b();
        m.e(strB, "classId.relativeClassName.asString()");
        if (!ua.n.O(strB, "Function", false, 2, null)) {
            return null;
        }
        ba.c cVarH = classId.h();
        m.e(cVarH, "classId.packageFqName");
        c.a.C0303a c0303aC = c.f15685a.c(strB, cVarH);
        if (c0303aC == null) {
            return null;
        }
        c cVarA = c0303aC.a();
        int iB = c0303aC.b();
        List<l0> listD = this.f15672b.U(cVarH).D();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listD) {
            if (obj instanceof kotlin.reflect.jvm.internal.impl.builtins.b) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (obj2 instanceof f) {
                arrayList2.add(obj2);
            }
        }
        l0 l0Var = (f) r.i0(arrayList2);
        if (l0Var == null) {
            l0Var = (kotlin.reflect.jvm.internal.impl.builtins.b) r.g0(arrayList);
        }
        return new b(this.f15671a, l0Var, cVarA, iB);
    }

    @Override // n9.b
    public boolean c(ba.c packageFqName, ba.f name) {
        m.f(packageFqName, "packageFqName");
        m.f(name, "name");
        String strF = name.f();
        m.e(strF, "name.asString()");
        return (ua.n.I(strF, "Function", false, 2, null) || ua.n.I(strF, "KFunction", false, 2, null) || ua.n.I(strF, "SuspendFunction", false, 2, null) || ua.n.I(strF, "KSuspendFunction", false, 2, null)) && c.f15685a.c(strF, packageFqName) != null;
    }
}
