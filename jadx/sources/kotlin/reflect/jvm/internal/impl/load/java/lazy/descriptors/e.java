package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.n0;
import kotlin.collections.r;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.w;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.load.java.b0;
import kotlin.reflect.jvm.internal.impl.resolve.constants.q;
import kotlin.reflect.jvm.internal.impl.resolve.constants.s;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.i0;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.r1;
import kotlin.reflect.jvm.internal.impl.types.w1;
import r8.p;
import r8.v;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class e implements kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, s9.g {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final /* synthetic */ i9.k<Object>[] f13285i = {c0.g(new w(c0.b(e.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), c0.g(new w(c0.b(e.class), IjkMediaMeta.IJKM_KEY_TYPE, "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), c0.g(new w(c0.b(e.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.g f13286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u9.a f13287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ka.j f13288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ka.i f13289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final t9.a f13290e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ka.i f13291f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f13292g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f13293h;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends o implements c9.a<Map<ba.f, ? extends kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>>> {
        a() {
            super(0);
        }

        @Override // c9.a
        public final Map<ba.f, ? extends kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> invoke() {
            Collection<u9.b> arguments = e.this.f13287b.getArguments();
            e eVar = e.this;
            ArrayList arrayList = new ArrayList();
            for (u9.b bVar : arguments) {
                ba.f name = bVar.getName();
                if (name == null) {
                    name = b0.f13111c;
                }
                kotlin.reflect.jvm.internal.impl.resolve.constants.g gVarL = eVar.l(bVar);
                p pVarA = gVarL != null ? v.a(name, gVarL) : null;
                if (pVarA != null) {
                    arrayList.add(pVarA);
                }
            }
            return n0.q(arrayList);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends o implements c9.a<ba.c> {
        b() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ba.c invoke() {
            ba.b bVarE = e.this.f13287b.e();
            if (bVarE != null) {
                return bVarE.b();
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends o implements c9.a<o0> {
        c() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final o0 invoke() {
            ba.c cVarD = e.this.d();
            if (cVarD == null) {
                return la.k.d(la.j.f15302f2, e.this.f13287b.toString());
            }
            kotlin.reflect.jvm.internal.impl.descriptors.e eVarF = kotlin.reflect.jvm.internal.impl.builtins.jvm.d.f(kotlin.reflect.jvm.internal.impl.builtins.jvm.d.f12525a, cVarD, e.this.f13286a.d().l(), null, 4, null);
            if (eVarF == null) {
                u9.g gVarW = e.this.f13287b.w();
                eVarF = gVarW != null ? e.this.f13286a.a().n().a(gVarW) : null;
                if (eVarF == null) {
                    eVarF = e.this.h(cVarD);
                }
            }
            return eVarF.p();
        }
    }

    public e(kotlin.reflect.jvm.internal.impl.load.java.lazy.g c10, u9.a javaAnnotation, boolean z10) {
        kotlin.jvm.internal.m.f(c10, "c");
        kotlin.jvm.internal.m.f(javaAnnotation, "javaAnnotation");
        this.f13286a = c10;
        this.f13287b = javaAnnotation;
        this.f13288c = c10.e().g(new b());
        this.f13289d = c10.e().c(new c());
        this.f13290e = c10.a().t().a(javaAnnotation);
        this.f13291f = c10.e().c(new a());
        this.f13292g = javaAnnotation.g();
        this.f13293h = javaAnnotation.s() || z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.descriptors.e h(ba.c cVar) {
        h0 h0VarD = this.f13286a.d();
        ba.b bVarM = ba.b.m(cVar);
        kotlin.jvm.internal.m.e(bVarM, "topLevel(fqName)");
        return x.c(h0VarD, bVarM, this.f13286a.a().b().d().q());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> l(u9.b bVar) {
        if (bVar instanceof u9.o) {
            return kotlin.reflect.jvm.internal.impl.resolve.constants.h.d(kotlin.reflect.jvm.internal.impl.resolve.constants.h.f13899a, ((u9.o) bVar).getValue(), null, 2, null);
        }
        if (bVar instanceof u9.m) {
            u9.m mVar = (u9.m) bVar;
            return o(mVar.b(), mVar.d());
        }
        if (!(bVar instanceof u9.e)) {
            if (bVar instanceof u9.c) {
                return m(((u9.c) bVar).a());
            }
            if (bVar instanceof u9.h) {
                return p(((u9.h) bVar).c());
            }
            return null;
        }
        u9.e eVar = (u9.e) bVar;
        ba.f name = eVar.getName();
        if (name == null) {
            name = b0.f13111c;
        }
        kotlin.jvm.internal.m.e(name, "argument.name ?: DEFAULT_ANNOTATION_MEMBER_NAME");
        return n(name, eVar.e());
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> m(u9.a aVar) {
        return new kotlin.reflect.jvm.internal.impl.resolve.constants.a(new e(this.f13286a, aVar, false, 4, null));
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> o(ba.b bVar, ba.f fVar) {
        if (bVar == null || fVar == null) {
            return null;
        }
        return new kotlin.reflect.jvm.internal.impl.resolve.constants.j(bVar, fVar);
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> p(u9.x xVar) {
        return q.f13915b.a(this.f13286a.g().o(xVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.b.b(r1.COMMON, false, false, null, 7, null)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    public Map<ba.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> a() {
        return (Map) ka.m.a(this.f13291f, this, f13285i[2]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    public ba.c d() {
        return (ba.c) ka.m.b(this.f13288c, this, f13285i[0]);
    }

    @Override // s9.g
    public boolean g() {
        return this.f13292g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public t9.a getSource() {
        return this.f13290e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public o0 getType() {
        return (o0) ka.m.a(this.f13289d, this, f13285i[1]);
    }

    public final boolean k() {
        return this.f13293h;
    }

    public String toString() {
        return kotlin.reflect.jvm.internal.impl.renderer.c.s(kotlin.reflect.jvm.internal.impl.renderer.c.f13790g, this, null, 2, null);
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> n(ba.f fVar, List<? extends u9.b> list) {
        g0 g0VarL;
        o0 type = getType();
        kotlin.jvm.internal.m.e(type, "type");
        if (i0.a(type)) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarI = ea.c.i(this);
        kotlin.jvm.internal.m.c(eVarI);
        j1 j1VarB = kotlin.reflect.jvm.internal.impl.load.java.components.a.b(fVar, eVarI);
        if (j1VarB == null || (g0VarL = j1VarB.getType()) == null) {
            g0VarL = this.f13286a.a().m().l().l(w1.INVARIANT, la.k.d(la.j.f15300e2, new String[0]));
        }
        kotlin.jvm.internal.m.e(g0VarL, "DescriptorResolverUtils.…GUMENT)\n                )");
        List<? extends u9.b> list2 = list;
        ArrayList arrayList = new ArrayList(r.w(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> gVarL = l((u9.b) it.next());
            if (gVarL == null) {
                gVarL = new s();
            }
            arrayList.add(gVarL);
        }
        return kotlin.reflect.jvm.internal.impl.resolve.constants.h.f13899a.b(arrayList, g0VarL);
    }

    public /* synthetic */ e(kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVar, u9.a aVar, boolean z10, int i10, kotlin.jvm.internal.g gVar2) {
        this(gVar, aVar, (i10 & 4) != 0 ? false : z10);
    }
}
