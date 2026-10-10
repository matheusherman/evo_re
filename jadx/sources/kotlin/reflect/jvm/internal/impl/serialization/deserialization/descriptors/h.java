package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.n0;
import kotlin.collections.v0;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.w;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.protobuf.q;
import kotlin.reflect.jvm.internal.impl.protobuf.s;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.v;
import r8.z;
import w9.r;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class h extends kotlin.reflect.jvm.internal.impl.resolve.scopes.i {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final /* synthetic */ i9.k<Object>[] f14086f = {c0.g(new w(c0.b(h.class), "classNames", "getClassNames$deserialization()Ljava/util/Set;")), c0.g(new w(c0.b(h.class), "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;"))};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.m f14087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f14088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ka.i f14089d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ka.j f14090e;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private interface a {
        Collection<u0> a(ba.f fVar, r9.b bVar);

        Set<ba.f> b();

        Collection<z0> c(ba.f fVar, r9.b bVar);

        Set<ba.f> d();

        e1 e(ba.f fVar);

        Set<ba.f> f();

        void g(Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> collection, kotlin.reflect.jvm.internal.impl.resolve.scopes.d dVar, c9.l<? super ba.f, Boolean> lVar, r9.b bVar);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class b implements a {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        static final /* synthetic */ i9.k<Object>[] f14091o = {c0.g(new w(c0.b(b.class), "declaredFunctions", "getDeclaredFunctions()Ljava/util/List;")), c0.g(new w(c0.b(b.class), "declaredProperties", "getDeclaredProperties()Ljava/util/List;")), c0.g(new w(c0.b(b.class), "allTypeAliases", "getAllTypeAliases()Ljava/util/List;")), c0.g(new w(c0.b(b.class), "allFunctions", "getAllFunctions()Ljava/util/List;")), c0.g(new w(c0.b(b.class), "allProperties", "getAllProperties()Ljava/util/List;")), c0.g(new w(c0.b(b.class), "typeAliasesByName", "getTypeAliasesByName()Ljava/util/Map;")), c0.g(new w(c0.b(b.class), "functionsByName", "getFunctionsByName()Ljava/util/Map;")), c0.g(new w(c0.b(b.class), "propertiesByName", "getPropertiesByName()Ljava/util/Map;")), c0.g(new w(c0.b(b.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), c0.g(new w(c0.b(b.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<w9.i> f14092a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<w9.n> f14093b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<r> f14094c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ka.i f14095d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final ka.i f14096e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ka.i f14097f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final ka.i f14098g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final ka.i f14099h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final ka.i f14100i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final ka.i f14101j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final ka.i f14102k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final ka.i f14103l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final ka.i f14104m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final /* synthetic */ h f14105n;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class a extends o implements c9.a<List<? extends z0>> {
            a() {
                super(0);
            }

            @Override // c9.a
            public final List<? extends z0> invoke() {
                return kotlin.collections.r.B0(b.this.D(), b.this.t());
            }
        }

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class C0262b extends o implements c9.a<List<? extends u0>> {
            C0262b() {
                super(0);
            }

            @Override // c9.a
            public final List<? extends u0> invoke() {
                return kotlin.collections.r.B0(b.this.E(), b.this.u());
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class c extends o implements c9.a<List<? extends e1>> {
            c() {
                super(0);
            }

            @Override // c9.a
            public final List<? extends e1> invoke() {
                return b.this.z();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class d extends o implements c9.a<List<? extends z0>> {
            d() {
                super(0);
            }

            @Override // c9.a
            public final List<? extends z0> invoke() {
                return b.this.v();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class e extends o implements c9.a<List<? extends u0>> {
            e() {
                super(0);
            }

            @Override // c9.a
            public final List<? extends u0> invoke() {
                return b.this.y();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class f extends o implements c9.a<Set<? extends ba.f>> {
            final /* synthetic */ h this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            f(h hVar) {
                super(0);
                this.this$1 = hVar;
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Set<ba.f> invoke() {
                b bVar = b.this;
                List list = bVar.f14092a;
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                h hVar = bVar.f14105n;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    linkedHashSet.add(kotlin.reflect.jvm.internal.impl.serialization.deserialization.w.b(hVar.p().g(), ((w9.i) ((q) it.next())).d0()));
                }
                return v0.k(linkedHashSet, this.this$1.t());
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class g extends o implements c9.a<Map<ba.f, ? extends List<? extends z0>>> {
            g() {
                super(0);
            }

            @Override // c9.a
            public final Map<ba.f, ? extends List<? extends z0>> invoke() {
                List listA = b.this.A();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : listA) {
                    ba.f name = ((z0) obj).getName();
                    kotlin.jvm.internal.m.e(name, "it.name");
                    Object arrayList = linkedHashMap.get(name);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        linkedHashMap.put(name, arrayList);
                    }
                    ((List) arrayList).add(obj);
                }
                return linkedHashMap;
            }
        }

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h$b$h, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class C0263h extends o implements c9.a<Map<ba.f, ? extends List<? extends u0>>> {
            C0263h() {
                super(0);
            }

            @Override // c9.a
            public final Map<ba.f, ? extends List<? extends u0>> invoke() {
                List listB = b.this.B();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : listB) {
                    ba.f name = ((u0) obj).getName();
                    kotlin.jvm.internal.m.e(name, "it.name");
                    Object arrayList = linkedHashMap.get(name);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        linkedHashMap.put(name, arrayList);
                    }
                    ((List) arrayList).add(obj);
                }
                return linkedHashMap;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class i extends o implements c9.a<Map<ba.f, ? extends e1>> {
            i() {
                super(0);
            }

            @Override // c9.a
            public final Map<ba.f, ? extends e1> invoke() {
                List listC = b.this.C();
                LinkedHashMap linkedHashMap = new LinkedHashMap(h9.f.c(n0.e(kotlin.collections.r.w(listC, 10)), 16));
                for (Object obj : listC) {
                    ba.f name = ((e1) obj).getName();
                    kotlin.jvm.internal.m.e(name, "it.name");
                    linkedHashMap.put(name, obj);
                }
                return linkedHashMap;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class j extends o implements c9.a<Set<? extends ba.f>> {
            final /* synthetic */ h this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            j(h hVar) {
                super(0);
                this.this$1 = hVar;
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Set<ba.f> invoke() {
                b bVar = b.this;
                List list = bVar.f14093b;
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                h hVar = bVar.f14105n;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    linkedHashSet.add(kotlin.reflect.jvm.internal.impl.serialization.deserialization.w.b(hVar.p().g(), ((w9.n) ((q) it.next())).c0()));
                }
                return v0.k(linkedHashSet, this.this$1.u());
            }
        }

        public b(h hVar, List<w9.i> functionList, List<w9.n> propertyList, List<r> typeAliasList) {
            kotlin.jvm.internal.m.f(functionList, "functionList");
            kotlin.jvm.internal.m.f(propertyList, "propertyList");
            kotlin.jvm.internal.m.f(typeAliasList, "typeAliasList");
            this.f14105n = hVar;
            this.f14092a = functionList;
            this.f14093b = propertyList;
            this.f14094c = hVar.p().c().g().g() ? typeAliasList : kotlin.collections.r.l();
            this.f14095d = hVar.p().h().c(new d());
            this.f14096e = hVar.p().h().c(new e());
            this.f14097f = hVar.p().h().c(new c());
            this.f14098g = hVar.p().h().c(new a());
            this.f14099h = hVar.p().h().c(new C0262b());
            this.f14100i = hVar.p().h().c(new i());
            this.f14101j = hVar.p().h().c(new g());
            this.f14102k = hVar.p().h().c(new C0263h());
            this.f14103l = hVar.p().h().c(new f(hVar));
            this.f14104m = hVar.p().h().c(new j(hVar));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<z0> A() {
            return (List) ka.m.a(this.f14098g, this, f14091o[3]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<u0> B() {
            return (List) ka.m.a(this.f14099h, this, f14091o[4]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<e1> C() {
            return (List) ka.m.a(this.f14097f, this, f14091o[2]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<z0> D() {
            return (List) ka.m.a(this.f14095d, this, f14091o[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<u0> E() {
            return (List) ka.m.a(this.f14096e, this, f14091o[1]);
        }

        private final Map<ba.f, Collection<z0>> F() {
            return (Map) ka.m.a(this.f14101j, this, f14091o[6]);
        }

        private final Map<ba.f, Collection<u0>> G() {
            return (Map) ka.m.a(this.f14102k, this, f14091o[7]);
        }

        private final Map<ba.f, e1> H() {
            return (Map) ka.m.a(this.f14100i, this, f14091o[5]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<z0> t() {
            Set<ba.f> setT = this.f14105n.t();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = setT.iterator();
            while (it.hasNext()) {
                kotlin.collections.r.C(arrayList, w((ba.f) it.next()));
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<u0> u() {
            Set<ba.f> setU = this.f14105n.u();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = setU.iterator();
            while (it.hasNext()) {
                kotlin.collections.r.C(arrayList, x((ba.f) it.next()));
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<z0> v() {
            List<w9.i> list = this.f14092a;
            h hVar = this.f14105n;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                z0 z0VarJ = hVar.p().f().j((w9.i) ((q) it.next()));
                if (!hVar.x(z0VarJ)) {
                    z0VarJ = null;
                }
                if (z0VarJ != null) {
                    arrayList.add(z0VarJ);
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<u0> y() {
            List<w9.n> list = this.f14093b;
            h hVar = this.f14105n;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                u0 u0VarL = hVar.p().f().l((w9.n) ((q) it.next()));
                if (u0VarL != null) {
                    arrayList.add(u0VarL);
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<e1> z() {
            List<r> list = this.f14094c;
            h hVar = this.f14105n;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                e1 e1VarM = hVar.p().f().m((r) ((q) it.next()));
                if (e1VarM != null) {
                    arrayList.add(e1VarM);
                }
            }
            return arrayList;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h.a
        public Collection<u0> a(ba.f name, r9.b location) {
            kotlin.jvm.internal.m.f(name, "name");
            kotlin.jvm.internal.m.f(location, "location");
            if (!d().contains(name)) {
                return kotlin.collections.r.l();
            }
            Collection<u0> collection = G().get(name);
            return collection == null ? kotlin.collections.r.l() : collection;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h.a
        public Set<ba.f> b() {
            return (Set) ka.m.a(this.f14103l, this, f14091o[8]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h.a
        public Collection<z0> c(ba.f name, r9.b location) {
            kotlin.jvm.internal.m.f(name, "name");
            kotlin.jvm.internal.m.f(location, "location");
            if (!b().contains(name)) {
                return kotlin.collections.r.l();
            }
            Collection<z0> collection = F().get(name);
            return collection == null ? kotlin.collections.r.l() : collection;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h.a
        public Set<ba.f> d() {
            return (Set) ka.m.a(this.f14104m, this, f14091o[9]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h.a
        public e1 e(ba.f name) {
            kotlin.jvm.internal.m.f(name, "name");
            return H().get(name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h.a
        public Set<ba.f> f() {
            List<r> list = this.f14094c;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            h hVar = this.f14105n;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(kotlin.reflect.jvm.internal.impl.serialization.deserialization.w.b(hVar.p().g(), ((r) ((q) it.next())).W()));
            }
            return linkedHashSet;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h.a
        public void g(Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> result, kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, c9.l<? super ba.f, Boolean> nameFilter, r9.b location) {
            kotlin.jvm.internal.m.f(result, "result");
            kotlin.jvm.internal.m.f(kindFilter, "kindFilter");
            kotlin.jvm.internal.m.f(nameFilter, "nameFilter");
            kotlin.jvm.internal.m.f(location, "location");
            if (kindFilter.a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f13966c.i())) {
                for (Object obj : B()) {
                    ba.f name = ((u0) obj).getName();
                    kotlin.jvm.internal.m.e(name, "it.name");
                    if (nameFilter.invoke(name).booleanValue()) {
                        result.add(obj);
                    }
                }
            }
            if (kindFilter.a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f13966c.d())) {
                for (Object obj2 : A()) {
                    ba.f name2 = ((z0) obj2).getName();
                    kotlin.jvm.internal.m.e(name2, "it.name");
                    if (nameFilter.invoke(name2).booleanValue()) {
                        result.add(obj2);
                    }
                }
            }
        }

        private final List<z0> w(ba.f fVar) {
            List<z0> listD = D();
            h hVar = this.f14105n;
            ArrayList arrayList = new ArrayList();
            for (Object obj : listD) {
                if (kotlin.jvm.internal.m.a(((kotlin.reflect.jvm.internal.impl.descriptors.m) obj).getName(), fVar)) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size();
            hVar.k(fVar, arrayList);
            return arrayList.subList(size, arrayList.size());
        }

        private final List<u0> x(ba.f fVar) {
            List<u0> listE = E();
            h hVar = this.f14105n;
            ArrayList arrayList = new ArrayList();
            for (Object obj : listE) {
                if (kotlin.jvm.internal.m.a(((kotlin.reflect.jvm.internal.impl.descriptors.m) obj).getName(), fVar)) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size();
            hVar.l(fVar, arrayList);
            return arrayList.subList(size, arrayList.size());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class c implements a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        static final /* synthetic */ i9.k<Object>[] f14106j = {c0.g(new w(c0.b(c.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), c0.g(new w(c0.b(c.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<ba.f, byte[]> f14107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<ba.f, byte[]> f14108b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Map<ba.f, byte[]> f14109c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ka.g<ba.f, Collection<z0>> f14110d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final ka.g<ba.f, Collection<u0>> f14111e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ka.h<ba.f, e1> f14112f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final ka.i f14113g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final ka.i f14114h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ h f14115i;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class a extends o implements c9.a {
            final /* synthetic */ ByteArrayInputStream $inputStream;
            final /* synthetic */ s $parser;
            final /* synthetic */ h this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(s sVar, ByteArrayInputStream byteArrayInputStream, h hVar) {
                super(0);
                this.$parser = sVar;
                this.$inputStream = byteArrayInputStream;
                this.this$0 = hVar;
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final q invoke() {
                return (q) this.$parser.c(this.$inputStream, this.this$0.p().c().j());
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class b extends o implements c9.a<Set<? extends ba.f>> {
            final /* synthetic */ h this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(h hVar) {
                super(0);
                this.this$1 = hVar;
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Set<ba.f> invoke() {
                return v0.k(c.this.f14107a.keySet(), this.this$1.t());
            }
        }

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class C0264c extends o implements c9.l<ba.f, Collection<? extends z0>> {
            C0264c() {
                super(1);
            }

            @Override // c9.l
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Collection<z0> invoke(ba.f it) {
                kotlin.jvm.internal.m.f(it, "it");
                return c.this.m(it);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class d extends o implements c9.l<ba.f, Collection<? extends u0>> {
            d() {
                super(1);
            }

            @Override // c9.l
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Collection<u0> invoke(ba.f it) {
                kotlin.jvm.internal.m.f(it, "it");
                return c.this.n(it);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class e extends o implements c9.l<ba.f, e1> {
            e() {
                super(1);
            }

            @Override // c9.l
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final e1 invoke(ba.f it) {
                kotlin.jvm.internal.m.f(it, "it");
                return c.this.o(it);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class f extends o implements c9.a<Set<? extends ba.f>> {
            final /* synthetic */ h this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            f(h hVar) {
                super(0);
                this.this$1 = hVar;
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Set<ba.f> invoke() {
                return v0.k(c.this.f14108b.keySet(), this.this$1.u());
            }
        }

        public c(h hVar, List<w9.i> functionList, List<w9.n> propertyList, List<r> typeAliasList) throws IOException {
            Map<ba.f, byte[]> mapI;
            kotlin.jvm.internal.m.f(functionList, "functionList");
            kotlin.jvm.internal.m.f(propertyList, "propertyList");
            kotlin.jvm.internal.m.f(typeAliasList, "typeAliasList");
            this.f14115i = hVar;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : functionList) {
                ba.f fVarB = kotlin.reflect.jvm.internal.impl.serialization.deserialization.w.b(hVar.p().g(), ((w9.i) ((q) obj)).d0());
                Object arrayList = linkedHashMap.get(fVarB);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(fVarB, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            this.f14107a = p(linkedHashMap);
            h hVar2 = this.f14115i;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj2 : propertyList) {
                ba.f fVarB2 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.w.b(hVar2.p().g(), ((w9.n) ((q) obj2)).c0());
                Object arrayList2 = linkedHashMap2.get(fVarB2);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    linkedHashMap2.put(fVarB2, arrayList2);
                }
                ((List) arrayList2).add(obj2);
            }
            this.f14108b = p(linkedHashMap2);
            if (this.f14115i.p().c().g().g()) {
                h hVar3 = this.f14115i;
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                for (Object obj3 : typeAliasList) {
                    ba.f fVarB3 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.w.b(hVar3.p().g(), ((r) ((q) obj3)).W());
                    Object arrayList3 = linkedHashMap3.get(fVarB3);
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                        linkedHashMap3.put(fVarB3, arrayList3);
                    }
                    ((List) arrayList3).add(obj3);
                }
                mapI = p(linkedHashMap3);
            } else {
                mapI = n0.i();
            }
            this.f14109c = mapI;
            this.f14110d = this.f14115i.p().h().f(new C0264c());
            this.f14111e = this.f14115i.p().h().f(new d());
            this.f14112f = this.f14115i.p().h().i(new e());
            this.f14113g = this.f14115i.p().h().c(new b(this.f14115i));
            this.f14114h = this.f14115i.p().h().c(new f(this.f14115i));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:7:0x002c  */
        public final Collection<z0> m(ba.f fVar) {
            List<w9.i> listL;
            Map<ba.f, byte[]> map = this.f14107a;
            s<w9.i> PARSER = w9.i.f20220b;
            kotlin.jvm.internal.m.e(PARSER, "PARSER");
            h hVar = this.f14115i;
            byte[] bArr = map.get(fVar);
            if (bArr != null) {
                List listP = ta.k.P(ta.k.n(new a(PARSER, new ByteArrayInputStream(bArr), this.f14115i)));
                if (listP != null) {
                    listL = listP;
                } else {
                    listL = kotlin.collections.r.l();
                }
            } else {
                listL = kotlin.collections.r.l();
            }
            ArrayList arrayList = new ArrayList(listL.size());
            for (w9.i it : listL) {
                v vVarF = hVar.p().f();
                kotlin.jvm.internal.m.e(it, "it");
                z0 z0VarJ = vVarF.j(it);
                if (!hVar.x(z0VarJ)) {
                    z0VarJ = null;
                }
                if (z0VarJ != null) {
                    arrayList.add(z0VarJ);
                }
            }
            hVar.k(fVar, arrayList);
            return sa.a.c(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:7:0x002c  */
        public final Collection<u0> n(ba.f fVar) {
            List<w9.n> listL;
            Map<ba.f, byte[]> map = this.f14108b;
            s<w9.n> PARSER = w9.n.f20264b;
            kotlin.jvm.internal.m.e(PARSER, "PARSER");
            h hVar = this.f14115i;
            byte[] bArr = map.get(fVar);
            if (bArr != null) {
                List listP = ta.k.P(ta.k.n(new a(PARSER, new ByteArrayInputStream(bArr), this.f14115i)));
                if (listP != null) {
                    listL = listP;
                } else {
                    listL = kotlin.collections.r.l();
                }
            } else {
                listL = kotlin.collections.r.l();
            }
            ArrayList arrayList = new ArrayList(listL.size());
            for (w9.n it : listL) {
                v vVarF = hVar.p().f();
                kotlin.jvm.internal.m.e(it, "it");
                u0 u0VarL = vVarF.l(it);
                if (u0VarL != null) {
                    arrayList.add(u0VarL);
                }
            }
            hVar.l(fVar, arrayList);
            return sa.a.c(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final e1 o(ba.f fVar) {
            r rVarN0;
            byte[] bArr = this.f14109c.get(fVar);
            if (bArr == null || (rVarN0 = r.n0(new ByteArrayInputStream(bArr), this.f14115i.p().c().j())) == null) {
                return null;
            }
            return this.f14115i.p().f().m(rVarN0);
        }

        private final Map<ba.f, byte[]> p(Map<ba.f, ? extends Collection<? extends kotlin.reflect.jvm.internal.impl.protobuf.a>> map) throws IOException {
            LinkedHashMap linkedHashMap = new LinkedHashMap(n0.e(map.size()));
            Iterator<T> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Iterable iterable = (Iterable) entry.getValue();
                ArrayList arrayList = new ArrayList(kotlin.collections.r.w(iterable, 10));
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    ((kotlin.reflect.jvm.internal.impl.protobuf.a) it2.next()).f(byteArrayOutputStream);
                    arrayList.add(z.f17874a);
                }
                linkedHashMap.put(key, byteArrayOutputStream.toByteArray());
            }
            return linkedHashMap;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h.a
        public Collection<u0> a(ba.f name, r9.b location) {
            kotlin.jvm.internal.m.f(name, "name");
            kotlin.jvm.internal.m.f(location, "location");
            return !d().contains(name) ? kotlin.collections.r.l() : this.f14111e.invoke(name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h.a
        public Set<ba.f> b() {
            return (Set) ka.m.a(this.f14113g, this, f14106j[0]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h.a
        public Collection<z0> c(ba.f name, r9.b location) {
            kotlin.jvm.internal.m.f(name, "name");
            kotlin.jvm.internal.m.f(location, "location");
            return !b().contains(name) ? kotlin.collections.r.l() : this.f14110d.invoke(name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h.a
        public Set<ba.f> d() {
            return (Set) ka.m.a(this.f14114h, this, f14106j[1]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h.a
        public e1 e(ba.f name) {
            kotlin.jvm.internal.m.f(name, "name");
            return this.f14112f.invoke(name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h.a
        public Set<ba.f> f() {
            return this.f14109c.keySet();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h.a
        public void g(Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> result, kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, c9.l<? super ba.f, Boolean> nameFilter, r9.b location) {
            kotlin.jvm.internal.m.f(result, "result");
            kotlin.jvm.internal.m.f(kindFilter, "kindFilter");
            kotlin.jvm.internal.m.f(nameFilter, "nameFilter");
            kotlin.jvm.internal.m.f(location, "location");
            if (kindFilter.a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f13966c.i())) {
                Set<ba.f> setD = d();
                ArrayList arrayList = new ArrayList();
                for (ba.f fVar : setD) {
                    if (nameFilter.invoke(fVar).booleanValue()) {
                        arrayList.addAll(a(fVar, location));
                    }
                }
                kotlin.reflect.jvm.internal.impl.resolve.h INSTANCE = kotlin.reflect.jvm.internal.impl.resolve.h.f13931a;
                kotlin.jvm.internal.m.e(INSTANCE, "INSTANCE");
                kotlin.collections.r.B(arrayList, INSTANCE);
                result.addAll(arrayList);
            }
            if (kindFilter.a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f13966c.d())) {
                Set<ba.f> setB = b();
                ArrayList arrayList2 = new ArrayList();
                for (ba.f fVar2 : setB) {
                    if (nameFilter.invoke(fVar2).booleanValue()) {
                        arrayList2.addAll(c(fVar2, location));
                    }
                }
                kotlin.reflect.jvm.internal.impl.resolve.h INSTANCE2 = kotlin.reflect.jvm.internal.impl.resolve.h.f13931a;
                kotlin.jvm.internal.m.e(INSTANCE2, "INSTANCE");
                kotlin.collections.r.B(arrayList2, INSTANCE2);
                result.addAll(arrayList2);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class d extends o implements c9.a<Set<? extends ba.f>> {
        final /* synthetic */ c9.a<Collection<ba.f>> $classNames;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(c9.a<? extends Collection<ba.f>> aVar) {
            super(0);
            this.$classNames = aVar;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Set<ba.f> invoke() {
            return kotlin.collections.r.S0(this.$classNames.invoke());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class e extends o implements c9.a<Set<? extends ba.f>> {
        e() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Set<ba.f> invoke() {
            Set<ba.f> setS = h.this.s();
            if (setS == null) {
                return null;
            }
            return v0.k(v0.k(h.this.q(), h.this.f14088c.f()), setS);
        }
    }

    protected abstract void i(Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> collection, c9.l<? super ba.f, Boolean> lVar);

    protected abstract ba.b m(ba.f fVar);

    protected abstract Set<ba.f> s();

    protected abstract Set<ba.f> t();

    protected abstract Set<ba.f> u();

    protected h(kotlin.reflect.jvm.internal.impl.serialization.deserialization.m c10, List<w9.i> functionList, List<w9.n> propertyList, List<r> typeAliasList, c9.a<? extends Collection<ba.f>> classNames) {
        kotlin.jvm.internal.m.f(c10, "c");
        kotlin.jvm.internal.m.f(functionList, "functionList");
        kotlin.jvm.internal.m.f(propertyList, "propertyList");
        kotlin.jvm.internal.m.f(typeAliasList, "typeAliasList");
        kotlin.jvm.internal.m.f(classNames, "classNames");
        this.f14087b = c10;
        this.f14088c = n(functionList, propertyList, typeAliasList);
        this.f14089d = c10.h().c(new d(classNames));
        this.f14090e = c10.h().g(new e());
    }

    private final a n(List<w9.i> list, List<w9.n> list2, List<r> list3) {
        return this.f14087b.c().g().a() ? new b(this, list, list2, list3) : new c(this, list, list2, list3);
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.e o(ba.f fVar) {
        return this.f14087b.c().b(m(fVar));
    }

    private final Set<ba.f> r() {
        return (Set) ka.m.b(this.f14090e, this, f14086f[1]);
    }

    private final e1 v(ba.f fVar) {
        return this.f14088c.e(fVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Collection<u0> a(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        return this.f14088c.a(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Set<ba.f> b() {
        return this.f14088c.b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Collection<z0> c(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        return this.f14088c.c(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Set<ba.f> d() {
        return this.f14088c.d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    public kotlin.reflect.jvm.internal.impl.descriptors.h e(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        if (w(name)) {
            return o(name);
        }
        if (this.f14088c.f().contains(name)) {
            return v(name);
        }
        return null;
    }

    protected final Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> j(kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, c9.l<? super ba.f, Boolean> nameFilter, r9.b location) {
        kotlin.jvm.internal.m.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.m.f(nameFilter, "nameFilter");
        kotlin.jvm.internal.m.f(location, "location");
        ArrayList arrayList = new ArrayList(0);
        kotlin.reflect.jvm.internal.impl.resolve.scopes.d.a aVar = kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f13966c;
        if (kindFilter.a(aVar.g())) {
            i(arrayList, nameFilter);
        }
        this.f14088c.g(arrayList, kindFilter, nameFilter, location);
        if (kindFilter.a(aVar.c())) {
            for (ba.f fVar : q()) {
                if (nameFilter.invoke(fVar).booleanValue()) {
                    sa.a.a(arrayList, o(fVar));
                }
            }
        }
        if (kindFilter.a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f13966c.h())) {
            for (ba.f fVar2 : this.f14088c.f()) {
                if (nameFilter.invoke(fVar2).booleanValue()) {
                    sa.a.a(arrayList, this.f14088c.e(fVar2));
                }
            }
        }
        return sa.a.c(arrayList);
    }

    protected void k(ba.f name, List<z0> functions) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(functions, "functions");
    }

    protected void l(ba.f name, List<u0> descriptors) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(descriptors, "descriptors");
    }

    protected final kotlin.reflect.jvm.internal.impl.serialization.deserialization.m p() {
        return this.f14087b;
    }

    public final Set<ba.f> q() {
        return (Set) ka.m.a(this.f14089d, this, f14086f[0]);
    }

    protected boolean w(ba.f name) {
        kotlin.jvm.internal.m.f(name, "name");
        return q().contains(name);
    }

    protected boolean x(z0 function) {
        kotlin.jvm.internal.m.f(function, "function");
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Set<ba.f> f() {
        return r();
    }
}
