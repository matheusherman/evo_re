package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.n0;
import kotlin.collections.r;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.s1;
import r8.v;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f12661a = new o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<ba.f> f12662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Set<ba.f> f12663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final HashMap<ba.b, ba.b> f12664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final HashMap<ba.b, ba.b> f12665e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final HashMap<m, ba.f> f12666f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Set<ba.f> f12667g;

    static {
        n[] nVarArrValues = n.values();
        ArrayList arrayList = new ArrayList(nVarArrValues.length);
        for (n nVar : nVarArrValues) {
            arrayList.add(nVar.j());
        }
        f12662b = r.S0(arrayList);
        m[] mVarArrValues = m.values();
        ArrayList arrayList2 = new ArrayList(mVarArrValues.length);
        for (m mVar : mVarArrValues) {
            arrayList2.add(mVar.f());
        }
        f12663c = r.S0(arrayList2);
        f12664d = new HashMap<>();
        f12665e = new HashMap<>();
        f12666f = n0.k(v.a(m.f12651a, ba.f.l("ubyteArrayOf")), v.a(m.f12652b, ba.f.l("ushortArrayOf")), v.a(m.f12653c, ba.f.l("uintArrayOf")), v.a(m.f12654d, ba.f.l("ulongArrayOf")));
        n[] nVarArrValues2 = n.values();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (n nVar2 : nVarArrValues2) {
            linkedHashSet.add(nVar2.f().j());
        }
        f12667g = linkedHashSet;
        for (n nVar3 : n.values()) {
            f12664d.put(nVar3.f(), nVar3.i());
            f12665e.put(nVar3.i(), nVar3.f());
        }
    }

    public static final boolean d(g0 type) {
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD;
        kotlin.jvm.internal.m.f(type, "type");
        if (s1.w(type) || (hVarD = type.J0().d()) == null) {
            return false;
        }
        return f12661a.c(hVarD);
    }

    public final ba.b a(ba.b arrayClassId) {
        kotlin.jvm.internal.m.f(arrayClassId, "arrayClassId");
        return f12664d.get(arrayClassId);
    }

    public final boolean b(ba.f name) {
        kotlin.jvm.internal.m.f(name, "name");
        return f12667g.contains(name);
    }

    public final boolean c(kotlin.reflect.jvm.internal.impl.descriptors.m descriptor) {
        kotlin.jvm.internal.m.f(descriptor, "descriptor");
        kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = descriptor.b();
        return (mVarB instanceof l0) && kotlin.jvm.internal.m.a(((l0) mVarB).d(), k.f12593v) && f12662b.contains(descriptor.getName());
    }

    private o() {
    }
}
