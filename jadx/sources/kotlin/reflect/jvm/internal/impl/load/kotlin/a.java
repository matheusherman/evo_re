package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.types.g0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class a<A, C> extends kotlin.reflect.jvm.internal.impl.load.kotlin.b<A, C0236a<? extends A, ? extends C>> implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.c<A, C> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ka.g<s, C0236a<A, C>> f13508b;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class C0236a<A, C> extends kotlin.reflect.jvm.internal.impl.load.kotlin.b.a<A> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<v, List<A>> f13509a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<v, C> f13510b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Map<v, C> f13511c;

        /* JADX WARN: Multi-variable type inference failed */
        public C0236a(Map<v, ? extends List<? extends A>> memberAnnotations, Map<v, ? extends C> propertyConstants, Map<v, ? extends C> annotationParametersDefaultValues) {
            kotlin.jvm.internal.m.f(memberAnnotations, "memberAnnotations");
            kotlin.jvm.internal.m.f(propertyConstants, "propertyConstants");
            kotlin.jvm.internal.m.f(annotationParametersDefaultValues, "annotationParametersDefaultValues");
            this.f13509a = memberAnnotations;
            this.f13510b = propertyConstants;
            this.f13511c = annotationParametersDefaultValues;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.b.a
        public Map<v, List<A>> a() {
            return this.f13509a;
        }

        public final Map<v, C> b() {
            return this.f13511c;
        }

        public final Map<v, C> c() {
            return this.f13510b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends kotlin.jvm.internal.o implements c9.p<C0236a<? extends A, ? extends C>, v, C> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f13512a = new b();

        b() {
            super(2);
        }

        @Override // c9.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C invoke(C0236a<? extends A, ? extends C> loadConstantFromProperty, v it) {
            kotlin.jvm.internal.m.f(loadConstantFromProperty, "$this$loadConstantFromProperty");
            kotlin.jvm.internal.m.f(it, "it");
            return loadConstantFromProperty.b().get(it);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class c implements s.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a<A, C> f13513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ HashMap<v, List<A>> f13514b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ s f13515c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ HashMap<v, C> f13516d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ HashMap<v, C> f13517e;

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public final class C0237a extends b implements s.e {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ c f13518d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0237a(c cVar, v signature) {
                super(cVar, signature);
                kotlin.jvm.internal.m.f(signature, "signature");
                this.f13518d = cVar;
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.e
            public s.a b(int i10, ba.b classId, a1 source) {
                kotlin.jvm.internal.m.f(classId, "classId");
                kotlin.jvm.internal.m.f(source, "source");
                v vVarE = v.f13620b.e(d(), i10);
                List<A> arrayList = this.f13518d.f13514b.get(vVarE);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.f13518d.f13514b.put(vVarE, arrayList);
                }
                return this.f13518d.f13513a.x(classId, source, arrayList);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public class b implements s.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final v f13519a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final ArrayList<A> f13520b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ c f13521c;

            public b(c cVar, v signature) {
                kotlin.jvm.internal.m.f(signature, "signature");
                this.f13521c = cVar;
                this.f13519a = signature;
                this.f13520b = new ArrayList<>();
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.c
            public void a() {
                if (this.f13520b.isEmpty()) {
                    return;
                }
                this.f13521c.f13514b.put(this.f13519a, this.f13520b);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.c
            public s.a c(ba.b classId, a1 source) {
                kotlin.jvm.internal.m.f(classId, "classId");
                kotlin.jvm.internal.m.f(source, "source");
                return this.f13521c.f13513a.x(classId, source, this.f13520b);
            }

            protected final v d() {
                return this.f13519a;
            }
        }

        c(a<A, C> aVar, HashMap<v, List<A>> map, s sVar, HashMap<v, C> map2, HashMap<v, C> map3) {
            this.f13513a = aVar;
            this.f13514b = map;
            this.f13515c = sVar;
            this.f13516d = map2;
            this.f13517e = map3;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.d
        public s.e a(ba.f name, String desc) {
            kotlin.jvm.internal.m.f(name, "name");
            kotlin.jvm.internal.m.f(desc, "desc");
            v.a aVar = v.f13620b;
            String strF = name.f();
            kotlin.jvm.internal.m.e(strF, "name.asString()");
            return new C0237a(this, aVar.d(strF, desc));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.d
        public s.c b(ba.f name, String desc, Object obj) {
            C cF;
            kotlin.jvm.internal.m.f(name, "name");
            kotlin.jvm.internal.m.f(desc, "desc");
            v.a aVar = v.f13620b;
            String strF = name.f();
            kotlin.jvm.internal.m.e(strF, "name.asString()");
            v vVarA = aVar.a(strF, desc);
            if (obj != null && (cF = this.f13513a.F(desc, obj)) != null) {
                this.f13517e.put(vVarA, cF);
            }
            return new b(this, vVarA);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class d extends kotlin.jvm.internal.o implements c9.p<C0236a<? extends A, ? extends C>, v, C> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f13522a = new d();

        d() {
            super(2);
        }

        @Override // c9.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C invoke(C0236a<? extends A, ? extends C> loadConstantFromProperty, v it) {
            kotlin.jvm.internal.m.f(loadConstantFromProperty, "$this$loadConstantFromProperty");
            kotlin.jvm.internal.m.f(it, "it");
            return loadConstantFromProperty.c().get(it);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class e extends kotlin.jvm.internal.o implements c9.l<s, C0236a<? extends A, ? extends C>> {
        final /* synthetic */ a<A, C> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(a<A, C> aVar) {
            super(1);
            this.this$0 = aVar;
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C0236a<A, C> invoke(s kotlinClass) {
            kotlin.jvm.internal.m.f(kotlinClass, "kotlinClass");
            return this.this$0.E(kotlinClass);
        }
    }

    protected abstract C F(String str, Object obj);

    protected abstract C H(C c10);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ka.n storageManager, q kotlinClassFinder) {
        super(kotlinClassFinder);
        kotlin.jvm.internal.m.f(storageManager, "storageManager");
        kotlin.jvm.internal.m.f(kotlinClassFinder, "kotlinClassFinder");
        this.f13508b = storageManager.f(new e(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C0236a<A, C> E(s sVar) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        sVar.i(new c(this, map, sVar, map3, map2), q(sVar));
        return new C0236a<>(map, map2, map3);
    }

    private final C G(kotlin.reflect.jvm.internal.impl.serialization.deserialization.y yVar, w9.n nVar, kotlin.reflect.jvm.internal.impl.serialization.deserialization.b bVar, g0 g0Var, c9.p<? super C0236a<? extends A, ? extends C>, ? super v, ? extends C> pVar) {
        C cInvoke;
        s sVarO = o(yVar, u(yVar, true, true, y9.b.A.d(nVar.a0()), aa.i.f(nVar)));
        if (sVarO == null) {
            return null;
        }
        v vVarR = r(nVar, yVar.b(), yVar.d(), bVar, sVarO.g().d().d(i.f13581b.a()));
        if (vVarR == null || (cInvoke = pVar.invoke(this.f13508b.invoke(sVarO), vVarR)) == null) {
            return null;
        }
        return kotlin.reflect.jvm.internal.impl.builtins.o.d(g0Var) ? H(cInvoke) : cInvoke;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.b
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public C0236a<A, C> p(s binaryClass) {
        kotlin.jvm.internal.m.f(binaryClass, "binaryClass");
        return this.f13508b.invoke(binaryClass);
    }

    protected final boolean D(ba.b annotationClassId, Map<ba.f, ? extends kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> arguments) {
        kotlin.jvm.internal.m.f(annotationClassId, "annotationClassId");
        kotlin.jvm.internal.m.f(arguments, "arguments");
        if (!kotlin.jvm.internal.m.a(annotationClassId, l9.a.f15247a.a())) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> gVar = arguments.get(ba.f.l("value"));
        kotlin.reflect.jvm.internal.impl.resolve.constants.q qVar = gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.q ? (kotlin.reflect.jvm.internal.impl.resolve.constants.q) gVar : null;
        if (qVar == null) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.resolve.constants.q.b bVarB = qVar.b();
        kotlin.reflect.jvm.internal.impl.resolve.constants.q.b.C0254b c0254b = bVarB instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.q.b.C0254b ? (kotlin.reflect.jvm.internal.impl.resolve.constants.q.b.C0254b) bVarB : null;
        if (c0254b == null) {
            return false;
        }
        return v(c0254b.b());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.c
    public C d(kotlin.reflect.jvm.internal.impl.serialization.deserialization.y container, w9.n proto, g0 expectedType) {
        kotlin.jvm.internal.m.f(container, "container");
        kotlin.jvm.internal.m.f(proto, "proto");
        kotlin.jvm.internal.m.f(expectedType, "expectedType");
        return G(container, proto, kotlin.reflect.jvm.internal.impl.serialization.deserialization.b.PROPERTY_GETTER, expectedType, b.f13512a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.c
    public C j(kotlin.reflect.jvm.internal.impl.serialization.deserialization.y container, w9.n proto, g0 expectedType) {
        kotlin.jvm.internal.m.f(container, "container");
        kotlin.jvm.internal.m.f(proto, "proto");
        kotlin.jvm.internal.m.f(expectedType, "expectedType");
        return G(container, proto, kotlin.reflect.jvm.internal.impl.serialization.deserialization.b.PROPERTY, expectedType, d.f13522a);
    }
}
