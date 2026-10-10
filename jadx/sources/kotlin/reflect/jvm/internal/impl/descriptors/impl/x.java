package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.q0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class x extends j implements kotlin.reflect.jvm.internal.impl.descriptors.h0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ka.n f12955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.builtins.h f12956d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ba.f f12957e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<kotlin.reflect.jvm.internal.impl.descriptors.g0<?>, Object> f12958f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a0 f12959g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private v f12960h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.descriptors.m0 f12961i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f12962j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ka.g<ba.c, q0> f12963k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final r8.i f12964l;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends kotlin.jvm.internal.o implements c9.a<i> {
        a() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i invoke() {
            v vVar = x.this.f12960h;
            x xVar = x.this;
            if (vVar == null) {
                throw new AssertionError("Dependencies of module " + xVar.L0() + " were not set before querying module content");
            }
            List<x> listA = vVar.a();
            x.this.K0();
            listA.contains(x.this);
            List<x> list = listA;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((x) it.next()).P0();
            }
            ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                kotlin.reflect.jvm.internal.impl.descriptors.m0 m0Var = ((x) it2.next()).f12961i;
                kotlin.jvm.internal.m.c(m0Var);
                arrayList.add(m0Var);
            }
            return new i(arrayList, "CompositeProvider@ModuleDescriptor for " + x.this.getName());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends kotlin.jvm.internal.o implements c9.l<ba.c, q0> {
        b() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final q0 invoke(ba.c fqName) {
            kotlin.jvm.internal.m.f(fqName, "fqName");
            a0 a0Var = x.this.f12959g;
            x xVar = x.this;
            return a0Var.a(xVar, fqName, xVar.f12955c);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public x(ba.f moduleName, ka.n storageManager, kotlin.reflect.jvm.internal.impl.builtins.h builtIns, ca.a aVar) {
        this(moduleName, storageManager, builtIns, aVar, null, null, 48, null);
        kotlin.jvm.internal.m.f(moduleName, "moduleName");
        kotlin.jvm.internal.m.f(storageManager, "storageManager");
        kotlin.jvm.internal.m.f(builtIns, "builtIns");
    }

    public /* synthetic */ x(ba.f fVar, ka.n nVar, kotlin.reflect.jvm.internal.impl.builtins.h hVar, ca.a aVar, Map map, ba.f fVar2, int i10, kotlin.jvm.internal.g gVar) {
        this(fVar, nVar, hVar, (i10 & 8) != 0 ? null : aVar, (i10 & 16) != 0 ? kotlin.collections.n0.i() : map, (i10 & 32) != 0 ? null : fVar2);
    }

    private final i N0() {
        return (i) this.f12964l.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean P0() {
        return this.f12961i != null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h0
    public <T> T D0(kotlin.reflect.jvm.internal.impl.descriptors.g0<T> capability) {
        kotlin.jvm.internal.m.f(capability, "capability");
        T t10 = (T) this.f12958f.get(capability);
        if (t10 == null) {
            return null;
        }
        return t10;
    }

    public final void O0(kotlin.reflect.jvm.internal.impl.descriptors.m0 providerForModuleContent) {
        kotlin.jvm.internal.m.f(providerForModuleContent, "providerForModuleContent");
        P0();
        this.f12961i = providerForModuleContent;
    }

    public boolean Q0() {
        return this.f12962j;
    }

    public final void R0(List<x> descriptors) {
        kotlin.jvm.internal.m.f(descriptors, "descriptors");
        S0(descriptors, v0.e());
    }

    public final void S0(List<x> descriptors, Set<x> friends) {
        kotlin.jvm.internal.m.f(descriptors, "descriptors");
        kotlin.jvm.internal.m.f(friends, "friends");
        T0(new w(descriptors, friends, kotlin.collections.r.l(), v0.e()));
    }

    public final void T0(v dependencies) {
        kotlin.jvm.internal.m.f(dependencies, "dependencies");
        this.f12960h = dependencies;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h0
    public q0 U(ba.c fqName) {
        kotlin.jvm.internal.m.f(fqName, "fqName");
        K0();
        return this.f12963k.invoke(fqName);
    }

    public final void U0(x... descriptors) {
        kotlin.jvm.internal.m.f(descriptors, "descriptors");
        R0(kotlin.collections.j.E0(descriptors));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h0
    public boolean a0(kotlin.reflect.jvm.internal.impl.descriptors.h0 targetModule) {
        kotlin.jvm.internal.m.f(targetModule, "targetModule");
        if (kotlin.jvm.internal.m.a(this, targetModule)) {
            return true;
        }
        v vVar = this.f12960h;
        kotlin.jvm.internal.m.c(vVar);
        return kotlin.collections.r.a0(vVar.b(), targetModule) || p0().contains(targetModule) || targetModule.p0().contains(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h0
    public kotlin.reflect.jvm.internal.impl.builtins.h l() {
        return this.f12956d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h0
    public Collection<ba.c> m(ba.c fqName, c9.l<? super ba.f, Boolean> nameFilter) {
        kotlin.jvm.internal.m.f(fqName, "fqName");
        kotlin.jvm.internal.m.f(nameFilter, "nameFilter");
        K0();
        return M0().m(fqName, nameFilter);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h0
    public List<kotlin.reflect.jvm.internal.impl.descriptors.h0> p0() {
        v vVar = this.f12960h;
        if (vVar != null) {
            return vVar.c();
        }
        throw new AssertionError("Dependencies of module " + L0() + " were not set");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String L0() {
        String string = getName().toString();
        kotlin.jvm.internal.m.e(string, "name.toString()");
        return string;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public <R, D> R H(kotlin.reflect.jvm.internal.impl.descriptors.o<R, D> oVar, D d10) {
        return (R) kotlin.reflect.jvm.internal.impl.descriptors.h0.a.a(this, oVar, d10);
    }

    public void K0() {
        if (!Q0()) {
            kotlin.reflect.jvm.internal.impl.descriptors.b0.a(this);
        }
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.m0 M0() {
        K0();
        return N0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public kotlin.reflect.jvm.internal.impl.descriptors.m b() {
        return kotlin.reflect.jvm.internal.impl.descriptors.h0.a.b(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.j
    public String toString() {
        String string = super.toString();
        kotlin.jvm.internal.m.e(string, "super.toString()");
        if (Q0()) {
            return string;
        }
        return string + " !isValid";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(ba.f moduleName, ka.n storageManager, kotlin.reflect.jvm.internal.impl.builtins.h builtIns, ca.a aVar, Map<kotlin.reflect.jvm.internal.impl.descriptors.g0<?>, ? extends Object> capabilities, ba.f fVar) {
        super(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b(), moduleName);
        kotlin.jvm.internal.m.f(moduleName, "moduleName");
        kotlin.jvm.internal.m.f(storageManager, "storageManager");
        kotlin.jvm.internal.m.f(builtIns, "builtIns");
        kotlin.jvm.internal.m.f(capabilities, "capabilities");
        this.f12955c = storageManager;
        this.f12956d = builtIns;
        this.f12957e = fVar;
        if (moduleName.m()) {
            this.f12958f = capabilities;
            a0 a0Var = (a0) D0(a0.f12770a.a());
            this.f12959g = a0Var == null ? a0.b.f12773b : a0Var;
            this.f12962j = true;
            this.f12963k = storageManager.f(new b());
            this.f12964l = r8.j.a(new a());
            return;
        }
        throw new IllegalArgumentException("Module name must be special: " + moduleName);
    }
}
