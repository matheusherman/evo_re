package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.n0;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.w;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.z;
import kotlin.reflect.jvm.internal.impl.load.kotlin.r;
import kotlin.reflect.jvm.internal.impl.load.kotlin.s;
import kotlin.reflect.jvm.internal.impl.load.kotlin.t;
import kotlin.reflect.jvm.internal.impl.load.kotlin.y;
import r8.p;
import r8.v;
import u9.u;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class h extends z {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final /* synthetic */ i9.k<Object>[] f13323o = {c0.g(new w(c0.b(h.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), c0.g(new w(c0.b(h.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final u f13324g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.g f13325h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final aa.e f13326i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ka.i f13327j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final d f13328k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ka.i<List<ba.c>> f13329l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g f13330m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final ka.i f13331n;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends o implements c9.a<Map<String, ? extends s>> {
        a() {
            super(0);
        }

        @Override // c9.a
        public final Map<String, ? extends s> invoke() {
            y yVarO = h.this.f13325h.a().o();
            String strB = h.this.d().b();
            kotlin.jvm.internal.m.e(strB, "fqName.asString()");
            List<String> listA = yVarO.a(strB);
            h hVar = h.this;
            ArrayList arrayList = new ArrayList();
            for (String str : listA) {
                ba.b bVarM = ba.b.m(fa.d.d(str).e());
                kotlin.jvm.internal.m.e(bVarM, "topLevel(JvmClassName.by…velClassMaybeWithDollars)");
                s sVarA = r.a(hVar.f13325h.a().j(), bVarM, hVar.f13326i);
                p pVarA = sVarA != null ? v.a(str, sVarA) : null;
                if (pVarA != null) {
                    arrayList.add(pVarA);
                }
            }
            return n0.q(arrayList);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends o implements c9.a<HashMap<fa.d, fa.d>> {

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f13332a;

            static {
                int[] iArr = new int[v9.a.EnumC0377a.values().length];
                try {
                    iArr[v9.a.EnumC0377a.MULTIFILE_CLASS_PART.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[v9.a.EnumC0377a.FILE_FACADE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f13332a = iArr;
            }
        }

        b() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HashMap<fa.d, fa.d> invoke() {
            HashMap<fa.d, fa.d> map = new HashMap<>();
            for (Map.Entry<String, s> entry : h.this.J0().entrySet()) {
                String key = entry.getKey();
                s value = entry.getValue();
                fa.d dVarD = fa.d.d(key);
                kotlin.jvm.internal.m.e(dVarD, "byInternalName(partInternalName)");
                v9.a aVarG = value.g();
                int i10 = a.f13332a[aVarG.c().ordinal()];
                if (i10 == 1) {
                    String strE = aVarG.e();
                    if (strE != null) {
                        fa.d dVarD2 = fa.d.d(strE);
                        kotlin.jvm.internal.m.e(dVarD2, "byInternalName(header.mu…: continue@kotlinClasses)");
                        map.put(dVarD, dVarD2);
                    }
                } else if (i10 == 2) {
                    map.put(dVarD, dVarD);
                }
            }
            return map;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends o implements c9.a<List<? extends ba.c>> {
        c() {
            super(0);
        }

        @Override // c9.a
        public final List<? extends ba.c> invoke() {
            Collection<u> collectionX = h.this.f13324g.x();
            ArrayList arrayList = new ArrayList(kotlin.collections.r.w(collectionX, 10));
            Iterator<T> it = collectionX.iterator();
            while (it.hasNext()) {
                arrayList.add(((u) it.next()).d());
            }
            return arrayList;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(kotlin.reflect.jvm.internal.impl.load.java.lazy.g outerContext, u jPackage) {
        super(outerContext.d(), jPackage.d());
        kotlin.jvm.internal.m.f(outerContext, "outerContext");
        kotlin.jvm.internal.m.f(jPackage, "jPackage");
        this.f13324g = jPackage;
        kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVarD = kotlin.reflect.jvm.internal.impl.load.java.lazy.a.d(outerContext, this, null, 0, 6, null);
        this.f13325h = gVarD;
        this.f13326i = sa.c.a(outerContext.a().b().d().g());
        this.f13327j = gVarD.e().c(new a());
        this.f13328k = new d(gVarD, jPackage, this);
        this.f13329l = gVarD.e().e(new c(), kotlin.collections.r.l());
        this.f13330m = gVarD.a().i().b() ? kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b() : kotlin.reflect.jvm.internal.impl.load.java.lazy.e.a(gVarD, jPackage);
        this.f13331n = gVarD.e().c(new b());
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.e I0(u9.g jClass) {
        kotlin.jvm.internal.m.f(jClass, "jClass");
        return this.f13328k.j().P(jClass);
    }

    public final Map<String, s> J0() {
        return (Map) ka.m.a(this.f13327j, this, f13323o[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l0
    /* JADX INFO: renamed from: K0, reason: merged with bridge method [inline-methods] */
    public d n() {
        return this.f13328k;
    }

    public final List<ba.c> L0() {
        return this.f13329l.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.b, kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g getAnnotations() {
        return this.f13330m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.z, kotlin.reflect.jvm.internal.impl.descriptors.impl.k, kotlin.reflect.jvm.internal.impl.descriptors.p
    public a1 getSource() {
        return new t(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.z, kotlin.reflect.jvm.internal.impl.descriptors.impl.j
    public String toString() {
        return "Lazy Java package fragment: " + d() + " of module " + this.f13325h.a().m();
    }
}
