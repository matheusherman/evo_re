package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import ka.n;
import kotlin.collections.r;
import kotlin.collections.v0;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.w;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.z;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.s;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.j0;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.p1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class i implements n9.a, n9.c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final /* synthetic */ i9.k<Object>[] f12548h = {c0.g(new w(c0.b(i.class), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;")), c0.g(new w(c0.b(i.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), c0.g(new w(c0.b(i.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;"))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h0 f12549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.builtins.jvm.d f12550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ka.i f12551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final g0 f12552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ka.i f12553e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ka.a<ba.c, kotlin.reflect.jvm.internal.impl.descriptors.e> f12554f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ka.i f12555g;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private enum a {
        HIDDEN,
        VISIBLE,
        NOT_CONSIDERED,
        DROP
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends o implements c9.a<o0> {
        final /* synthetic */ n $storageManager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(n nVar) {
            super(0);
            this.$storageManager = nVar;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final o0 invoke() {
            return x.c(i.this.u().a(), kotlin.reflect.jvm.internal.impl.builtins.jvm.e.f12526d.a(), new k0(this.$storageManager, i.this.u().a())).p();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class d extends z {
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.l0
        /* JADX INFO: renamed from: B0, reason: merged with bridge method [inline-methods] */
        public kotlin.reflect.jvm.internal.impl.resolve.scopes.h.b n() {
            return kotlin.reflect.jvm.internal.impl.resolve.scopes.h.b.f14005b;
        }

        d(h0 h0Var, ba.c cVar) {
            super(h0Var, cVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class e extends o implements c9.a<g0> {
        e() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final g0 invoke() {
            o0 o0VarI = i.this.f12549a.l().i();
            m.e(o0VarI, "moduleDescriptor.builtIns.anyType");
            return o0VarI;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class f extends o implements c9.a<kotlin.reflect.jvm.internal.impl.descriptors.e> {
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f $javaAnalogueDescriptor;
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.e $kotlinMutableClassIfContainer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f fVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
            super(0);
            this.$javaAnalogueDescriptor = fVar;
            this.$kotlinMutableClassIfContainer = eVar;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.jvm.internal.impl.descriptors.e invoke() {
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f fVar = this.$javaAnalogueDescriptor;
            kotlin.reflect.jvm.internal.impl.load.java.components.g EMPTY = kotlin.reflect.jvm.internal.impl.load.java.components.g.f13180a;
            m.e(EMPTY, "EMPTY");
            return fVar.J0(EMPTY, this.$kotlinMutableClassIfContainer);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class g extends o implements c9.l<kotlin.reflect.jvm.internal.impl.resolve.scopes.h, Collection<? extends z0>> {
        final /* synthetic */ ba.f $name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(ba.f fVar) {
            super(1);
            this.$name = fVar;
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection<z0> invoke(kotlin.reflect.jvm.internal.impl.resolve.scopes.h it) {
            m.f(it, "it");
            return it.c(this.$name, r9.d.FROM_BUILTINS);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class h extends sa.b.AbstractC0358b<kotlin.reflect.jvm.internal.impl.descriptors.e, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f12562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b0<a> f12563b;

        h(String str, b0<a> b0Var) {
            this.f12562a = str;
            this.f12563b = b0Var;
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [T, kotlin.reflect.jvm.internal.impl.builtins.jvm.i$a] */
        /* JADX WARN: Type inference failed for: r0v5, types: [T, kotlin.reflect.jvm.internal.impl.builtins.jvm.i$a] */
        /* JADX WARN: Type inference failed for: r0v6, types: [T, kotlin.reflect.jvm.internal.impl.builtins.jvm.i$a] */
        @Override // sa.b.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean c(kotlin.reflect.jvm.internal.impl.descriptors.e javaClassDescriptor) {
            m.f(javaClassDescriptor, "javaClassDescriptor");
            String strA = kotlin.reflect.jvm.internal.impl.load.kotlin.w.a(kotlin.reflect.jvm.internal.impl.load.kotlin.z.f13623a, javaClassDescriptor, this.f12562a);
            k kVar = k.f12565a;
            if (kVar.e().contains(strA)) {
                this.f12563b.element = a.HIDDEN;
            } else if (kVar.h().contains(strA)) {
                this.f12563b.element = a.VISIBLE;
            } else if (kVar.c().contains(strA)) {
                this.f12563b.element = a.DROP;
            }
            return this.f12563b.element == null;
        }

        @Override // sa.b.d
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public a a() {
            a aVar = this.f12563b.element;
            return aVar == null ? a.NOT_CONSIDERED : aVar;
        }
    }

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.builtins.jvm.i$i, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class C0216i extends o implements c9.l<kotlin.reflect.jvm.internal.impl.descriptors.b, Boolean> {
        C0216i() {
            super(1);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0021  */
        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
            boolean z10;
            if (bVar.g() == kotlin.reflect.jvm.internal.impl.descriptors.b.a.DECLARATION) {
                kotlin.reflect.jvm.internal.impl.builtins.jvm.d dVar = i.this.f12550b;
                kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = bVar.b();
                m.d(mVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                if (dVar.c((kotlin.reflect.jvm.internal.impl.descriptors.e) mVarB)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
            } else {
                z10 = false;
            }
            return Boolean.valueOf(z10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class j extends o implements c9.a<kotlin.reflect.jvm.internal.impl.descriptors.annotations.g> {
        j() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g invoke() {
            return kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.a(r.e(kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.b(i.this.f12549a.l(), "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version", null, null, 6, null)));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12561a;

        static {
            int[] iArr = new int[a.values().length];
            try {
                iArr[a.HIDDEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[a.NOT_CONSIDERED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[a.DROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[a.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f12561a = iArr;
        }
    }

    public i(h0 moduleDescriptor, n storageManager, c9.a<kotlin.reflect.jvm.internal.impl.builtins.jvm.f.b> settingsComputation) {
        m.f(moduleDescriptor, "moduleDescriptor");
        m.f(storageManager, "storageManager");
        m.f(settingsComputation, "settingsComputation");
        this.f12549a = moduleDescriptor;
        this.f12550b = kotlin.reflect.jvm.internal.impl.builtins.jvm.d.f12525a;
        this.f12551c = storageManager.c(settingsComputation);
        this.f12552d = l(storageManager);
        this.f12553e = storageManager.c(new c(storageManager));
        this.f12554f = storageManager.d();
        this.f12555g = storageManager.c(new j());
    }

    private final g0 l(n nVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.impl.h hVar = new kotlin.reflect.jvm.internal.impl.descriptors.impl.h(new d(this.f12549a, new ba.c("java.io")), ba.f.l("Serializable"), e0.ABSTRACT, kotlin.reflect.jvm.internal.impl.descriptors.f.INTERFACE, r.e(new j0(nVar, new e())), a1.f12668a, false, nVar);
        hVar.G0(kotlin.reflect.jvm.internal.impl.resolve.scopes.h.b.f14005b, v0.e(), null);
        o0 o0VarP = hVar.p();
        m.e(o0VarP, "mockSerializableClass.defaultType");
        return o0VarP;
    }

    private final o0 n() {
        return (o0) ka.m.a(this.f12553e, this, f12548h[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable s(i this$0, kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        m.f(this$0, "this$0");
        Collection<g0> collectionB = eVar.h().b();
        m.e(collectionB, "it.typeConstructor.supertypes");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionB.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = ((g0) it.next()).J0().d();
            kotlin.reflect.jvm.internal.impl.descriptors.h hVarA = hVarD != null ? hVarD.a() : null;
            kotlin.reflect.jvm.internal.impl.descriptors.e eVar2 = hVarA instanceof kotlin.reflect.jvm.internal.impl.descriptors.e ? (kotlin.reflect.jvm.internal.impl.descriptors.e) hVarA : null;
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f fVarQ = eVar2 != null ? this$0.q(eVar2) : null;
            if (fVarQ != null) {
                arrayList.add(fVarQ);
            }
        }
        return arrayList;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g t() {
        return (kotlin.reflect.jvm.internal.impl.descriptors.annotations.g) ka.m.a(this.f12555g, this, f12548h[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.builtins.jvm.f.b u() {
        return (kotlin.reflect.jvm.internal.impl.builtins.jvm.f.b) ka.m.a(this.f12551c, this, f12548h[0]);
    }

    @Override // n9.a
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> a(kotlin.reflect.jvm.internal.impl.descriptors.e classDescriptor) {
        m.f(classDescriptor, "classDescriptor");
        if (classDescriptor.g() != kotlin.reflect.jvm.internal.impl.descriptors.f.CLASS || !u().b()) {
            return r.l();
        }
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f fVarQ = q(classDescriptor);
        if (fVarQ == null) {
            return r.l();
        }
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarF = kotlin.reflect.jvm.internal.impl.builtins.jvm.d.f(this.f12550b, ea.c.l(fVarQ), kotlin.reflect.jvm.internal.impl.builtins.jvm.b.f12503h.a(), null, 4, null);
        if (eVarF == null) {
            return r.l();
        }
        p1 p1VarC = l.a(eVarF, fVarQ).c();
        List<kotlin.reflect.jvm.internal.impl.descriptors.d> listK = fVarQ.k();
        ArrayList<kotlin.reflect.jvm.internal.impl.descriptors.d> arrayList = new ArrayList();
        for (Object obj : listK) {
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) obj;
            if (dVar.getVisibility().d()) {
                Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> collectionK = eVarF.k();
                m.e(collectionK, "defaultKotlinVersion.constructors");
                Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> collection = collectionK;
                if (!(collection instanceof Collection) || !collection.isEmpty()) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            kotlin.reflect.jvm.internal.impl.descriptors.d it2 = (kotlin.reflect.jvm.internal.impl.descriptors.d) it.next();
                            m.e(it2, "it");
                            if (o(it2, p1VarC, dVar)) {
                            }
                        }
                    }
                }
                if (!x(dVar, classDescriptor) && !kotlin.reflect.jvm.internal.impl.builtins.h.k0(dVar) && !k.f12565a.d().contains(kotlin.reflect.jvm.internal.impl.load.kotlin.w.a(kotlin.reflect.jvm.internal.impl.load.kotlin.z.f13623a, fVarQ, kotlin.reflect.jvm.internal.impl.load.kotlin.x.c(dVar, false, false, 3, null)))) {
                    arrayList.add(obj);
                }
            }
        }
        ArrayList arrayList2 = new ArrayList(r.w(arrayList, 10));
        for (kotlin.reflect.jvm.internal.impl.descriptors.d dVar2 : arrayList) {
            y.a<? extends y> aVarQ = dVar2.q();
            aVarQ.p(classDescriptor);
            aVarQ.f(classDescriptor.p());
            aVarQ.e();
            aVarQ.k(p1VarC.j());
            if (!k.f12565a.g().contains(kotlin.reflect.jvm.internal.impl.load.kotlin.w.a(kotlin.reflect.jvm.internal.impl.load.kotlin.z.f13623a, fVarQ, kotlin.reflect.jvm.internal.impl.load.kotlin.x.c(dVar2, false, false, 3, null)))) {
                aVarQ.s(t());
            }
            y yVarBuild = aVarQ.build();
            m.d(yVarBuild, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
            arrayList2.add((kotlin.reflect.jvm.internal.impl.descriptors.d) yVarBuild);
        }
        return arrayList2;
    }

    @Override // n9.c
    public boolean b(kotlin.reflect.jvm.internal.impl.descriptors.e classDescriptor, z0 functionDescriptor) {
        m.f(classDescriptor, "classDescriptor");
        m.f(functionDescriptor, "functionDescriptor");
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f fVarQ = q(classDescriptor);
        if (fVarQ == null || !functionDescriptor.getAnnotations().F(n9.d.a())) {
            return true;
        }
        if (!u().b()) {
            return false;
        }
        String strC = kotlin.reflect.jvm.internal.impl.load.kotlin.x.c(functionDescriptor, false, false, 3, null);
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.g gVarZ0 = fVarQ.z0();
        ba.f name = functionDescriptor.getName();
        m.e(name, "functionDescriptor.name");
        Collection<z0> collectionC = gVarZ0.c(name, r9.d.FROM_BUILTINS);
        if ((collectionC instanceof Collection) && collectionC.isEmpty()) {
            return false;
        }
        Iterator<T> it = collectionC.iterator();
        while (it.hasNext()) {
            if (m.a(kotlin.reflect.jvm.internal.impl.load.kotlin.x.c((z0) it.next(), false, false, 3, null), strC)) {
                return true;
            }
        }
        return false;
    }

    @Override // n9.a
    public Collection<g0> c(kotlin.reflect.jvm.internal.impl.descriptors.e classDescriptor) {
        m.f(classDescriptor, "classDescriptor");
        ba.d dVarM = ea.c.m(classDescriptor);
        k kVar = k.f12565a;
        if (!kVar.i(dVarM)) {
            return kVar.j(dVarM) ? r.e(this.f12552d) : r.l();
        }
        o0 cloneableType = n();
        m.e(cloneableType, "cloneableType");
        return r.o(cloneableType, this.f12552d);
    }

    @Override // n9.a
    public Collection<z0> d(ba.f name, kotlin.reflect.jvm.internal.impl.descriptors.e classDescriptor) {
        m.f(name, "name");
        m.f(classDescriptor, "classDescriptor");
        if (m.a(name, kotlin.reflect.jvm.internal.impl.builtins.jvm.a.f12501e.a()) && (classDescriptor instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.d) && kotlin.reflect.jvm.internal.impl.builtins.h.d0(classDescriptor)) {
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.d dVar = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.d) classDescriptor;
            List<w9.i> listH0 = dVar.W0().H0();
            m.e(listH0, "classDescriptor.classProto.functionList");
            List<w9.i> list = listH0;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (m.a(kotlin.reflect.jvm.internal.impl.serialization.deserialization.w.b(dVar.V0().g(), ((w9.i) it.next()).d0()), kotlin.reflect.jvm.internal.impl.builtins.jvm.a.f12501e.a())) {
                        return r.l();
                    }
                }
            }
            return r.e(k(dVar, (z0) r.E0(n().n().c(name, r9.d.FROM_BUILTINS))));
        }
        if (!u().b()) {
            return r.l();
        }
        Collection<z0> collectionM = m(classDescriptor, new g(name));
        ArrayList arrayList = new ArrayList();
        for (z0 z0Var : collectionM) {
            kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = z0Var.b();
            m.d(mVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            y yVarC = z0Var.c(l.a((kotlin.reflect.jvm.internal.impl.descriptors.e) mVarB, classDescriptor).c());
            m.d(yVarC, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor");
            y.a<? extends z0> aVarQ = ((z0) yVarC).q();
            aVarQ.p(classDescriptor);
            aVarQ.d(classDescriptor.F0());
            aVarQ.e();
            int i10 = b.f12561a[r(z0Var).ordinal()];
            z0 z0Var2 = null;
            if (i10 != 1) {
                if (i10 == 2) {
                    aVarQ.s(t());
                } else if (i10 != 3) {
                }
                y yVarBuild = aVarQ.build();
                m.c(yVarBuild);
                z0Var2 = (z0) yVarBuild;
            } else if (!f0.a(classDescriptor)) {
                aVarQ.h();
                y yVarBuild2 = aVarQ.build();
                m.c(yVarBuild2);
                z0Var2 = (z0) yVarBuild2;
            }
            if (z0Var2 != null) {
                arrayList.add(z0Var2);
            }
        }
        return arrayList;
    }

    @Override // n9.a
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public Set<ba.f> e(kotlin.reflect.jvm.internal.impl.descriptors.e classDescriptor) {
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.g gVarZ0;
        Set<ba.f> setB;
        m.f(classDescriptor, "classDescriptor");
        if (!u().b()) {
            return v0.e();
        }
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f fVarQ = q(classDescriptor);
        return (fVarQ == null || (gVarZ0 = fVarQ.z0()) == null || (setB = gVarZ0.b()) == null) ? v0.e() : setB;
    }

    private final z0 k(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.d dVar, z0 z0Var) {
        y.a<? extends z0> aVarQ = z0Var.q();
        aVarQ.p(dVar);
        aVarQ.n(t.f13068e);
        aVarQ.f(dVar.p());
        aVarQ.d(dVar.F0());
        y yVarBuild = aVarQ.build();
        m.c(yVarBuild);
        return (z0) yVarBuild;
    }

    private final Collection<z0> m(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, c9.l<? super kotlin.reflect.jvm.internal.impl.resolve.scopes.h, ? extends Collection<? extends z0>> lVar) {
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f fVarQ = q(eVar);
        if (fVarQ == null) {
            return r.l();
        }
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.e> collectionG = this.f12550b.g(ea.c.l(fVarQ), kotlin.reflect.jvm.internal.impl.builtins.jvm.b.f12503h.a());
        kotlin.reflect.jvm.internal.impl.descriptors.e eVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.e) r.t0(collectionG);
        if (eVar2 == null) {
            return r.l();
        }
        sa.g.b bVar = sa.g.f18524c;
        ArrayList arrayList = new ArrayList(r.w(collectionG, 10));
        Iterator<T> it = collectionG.iterator();
        while (it.hasNext()) {
            arrayList.add(ea.c.l((kotlin.reflect.jvm.internal.impl.descriptors.e) it.next()));
        }
        sa.g gVarB = bVar.b(arrayList);
        boolean zC = this.f12550b.c(eVar);
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarZ0 = this.f12554f.a(ea.c.l(fVarQ), new f(fVarQ, eVar2)).z0();
        m.e(hVarZ0, "fakeJavaClassDescriptor.unsubstitutedMemberScope");
        Collection<? extends z0> collectionInvoke = lVar.invoke(hVarZ0);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : collectionInvoke) {
            z0 z0Var = (z0) obj;
            if (z0Var.g() == kotlin.reflect.jvm.internal.impl.descriptors.b.a.DECLARATION && z0Var.getVisibility().d() && !kotlin.reflect.jvm.internal.impl.builtins.h.k0(z0Var)) {
                Collection<? extends y> collectionE = z0Var.e();
                m.e(collectionE, "analogueMember.overriddenDescriptors");
                Collection<? extends y> collection = collectionE;
                if (!(collection instanceof Collection) || !collection.isEmpty()) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = ((y) it2.next()).b();
                            m.e(mVarB, "it.containingDeclaration");
                            if (gVarB.contains(ea.c.l(mVarB))) {
                            }
                        }
                    }
                }
                if (!v(z0Var, zC)) {
                    arrayList2.add(obj);
                }
            }
        }
        return arrayList2;
    }

    private static final boolean o(kotlin.reflect.jvm.internal.impl.descriptors.l lVar, p1 p1Var, kotlin.reflect.jvm.internal.impl.descriptors.l lVar2) {
        if (kotlin.reflect.jvm.internal.impl.resolve.k.x(lVar, lVar2.c(p1Var)) == kotlin.reflect.jvm.internal.impl.resolve.k.i.a.OVERRIDABLE) {
            return true;
        }
        return false;
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f q(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        ba.b bVarN;
        ba.c cVarB;
        if (kotlin.reflect.jvm.internal.impl.builtins.h.a0(eVar) || !kotlin.reflect.jvm.internal.impl.builtins.h.B0(eVar)) {
            return null;
        }
        ba.d dVarM = ea.c.m(eVar);
        if (dVarM.f() && (bVarN = kotlin.reflect.jvm.internal.impl.builtins.jvm.c.f12505a.n(dVarM)) != null && (cVarB = bVarN.b()) != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.e eVarD = s.d(u().a(), cVarB, r9.d.FROM_BUILTINS);
            if (eVarD instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f) {
                return (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f) eVarD;
            }
        }
        return null;
    }

    private final a r(y yVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = yVar.b();
        m.d(mVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        Object objB = sa.b.b(r.e((kotlin.reflect.jvm.internal.impl.descriptors.e) mVarB), new kotlin.reflect.jvm.internal.impl.builtins.jvm.h(this), new h(kotlin.reflect.jvm.internal.impl.load.kotlin.x.c(yVar, false, false, 3, null), new b0()));
        m.e(objB, "jvmDescriptor = computeJ…CONSIDERED\n            })");
        return (a) objB;
    }

    private final boolean v(z0 z0Var, boolean z10) {
        kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = z0Var.b();
        m.d(mVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        String strC = kotlin.reflect.jvm.internal.impl.load.kotlin.x.c(z0Var, false, false, 3, null);
        if (z10 ^ k.f12565a.f().contains(kotlin.reflect.jvm.internal.impl.load.kotlin.w.a(kotlin.reflect.jvm.internal.impl.load.kotlin.z.f13623a, (kotlin.reflect.jvm.internal.impl.descriptors.e) mVarB, strC))) {
            return true;
        }
        Boolean boolE = sa.b.e(r.e(z0Var), kotlin.reflect.jvm.internal.impl.builtins.jvm.g.f12546a, new C0216i());
        m.e(boolE, "private fun SimpleFuncti…scriptor)\n        }\n    }");
        return boolE.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable w(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
        return bVar.a().e();
    }

    private final boolean x(kotlin.reflect.jvm.internal.impl.descriptors.l lVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        ba.d dVarM;
        if (lVar.f().size() == 1) {
            List<j1> valueParameters = lVar.f();
            m.e(valueParameters, "valueParameters");
            kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = ((j1) r.F0(valueParameters)).getType().J0().d();
            if (hVarD != null) {
                dVarM = ea.c.m(hVarD);
            } else {
                dVarM = null;
            }
            if (m.a(dVarM, ea.c.m(eVar))) {
                return true;
            }
            return false;
        }
        return false;
    }
}
