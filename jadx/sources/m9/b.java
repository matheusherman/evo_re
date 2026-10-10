package m9;

import ba.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import ka.n;
import kotlin.collections.k0;
import kotlin.collections.r;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.builtins.k;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.descriptors.h1;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;
import kotlin.reflect.jvm.internal.impl.types.c1;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.g1;
import kotlin.reflect.jvm.internal.impl.types.m1;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.w1;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class b extends kotlin.reflect.jvm.internal.impl.descriptors.impl.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f15673m = new a(null);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final ba.b f15674n = new ba.b(k.f12593v, f.l("Function"));

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final ba.b f15675o = new ba.b(k.f12590s, f.l("KFunction"));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final n f15676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final l0 f15677g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final c f15678h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f15679i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final C0302b f15680j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final d f15681k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final List<f1> f15682l;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: m9.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class C0302b extends kotlin.reflect.jvm.internal.impl.types.b {
        @Override // kotlin.reflect.jvm.internal.impl.types.g1
        public boolean e() {
            return true;
        }

        /* JADX INFO: renamed from: m9.b$b$a */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f15684a;

            static {
                int[] iArr = new int[c.values().length];
                try {
                    iArr[c.f15686b.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[c.f15688d.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[c.f15687c.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[c.f15689e.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                f15684a = iArr;
            }
        }

        public C0302b() {
            super(b.this.f15676f);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g1
        public List<f1> getParameters() {
            return b.this.f15682l;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g
        protected Collection<g0> m() {
            List listE;
            int i10 = a.f15684a[b.this.Q0().ordinal()];
            if (i10 == 1) {
                listE = r.e(b.f15674n);
            } else if (i10 == 2) {
                listE = r.o(b.f15675o, new ba.b(k.f12593v, c.f15686b.j(b.this.M0())));
            } else if (i10 == 3) {
                listE = r.e(b.f15674n);
            } else {
                if (i10 != 4) {
                    throw new r8.n();
                }
                listE = r.o(b.f15675o, new ba.b(k.f12585n, c.f15687c.j(b.this.M0())));
            }
            h0 h0VarB = b.this.f15677g.b();
            List<ba.b> list = listE;
            ArrayList arrayList = new ArrayList(r.w(list, 10));
            for (ba.b bVar : list) {
                kotlin.reflect.jvm.internal.impl.descriptors.e eVarA = x.a(h0VarB, bVar);
                if (eVarA == null) {
                    throw new IllegalStateException(("Built-in class " + bVar + " not found").toString());
                }
                List listL0 = r.L0(getParameters(), eVarA.h().getParameters().size());
                ArrayList arrayList2 = new ArrayList(r.w(listL0, 10));
                Iterator it = listL0.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new m1(((f1) it.next()).p()));
                }
                arrayList.add(kotlin.reflect.jvm.internal.impl.types.h0.g(c1.f14231b.h(), eVarA, arrayList2));
            }
            return r.O0(arrayList);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g
        protected d1 q() {
            return d1.a.f12742a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.b
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
        public b d() {
            return b.this;
        }

        public String toString() {
            return d().toString();
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    public boolean A0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean E0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean F() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    public boolean I() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i
    public boolean J() {
        return false;
    }

    public Void N0() {
        return null;
    }

    public Void U0() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean t() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public h1<o0> v0() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean x() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(n storageManager, l0 containingDeclaration, c functionKind, int i10) {
        super(storageManager, functionKind.j(i10));
        m.f(storageManager, "storageManager");
        m.f(containingDeclaration, "containingDeclaration");
        m.f(functionKind, "functionKind");
        this.f15676f = storageManager;
        this.f15677g = containingDeclaration;
        this.f15678h = functionKind;
        this.f15679i = i10;
        this.f15680j = new C0302b();
        this.f15681k = new d(storageManager, this);
        ArrayList arrayList = new ArrayList();
        h9.e eVar = new h9.e(1, i10);
        ArrayList arrayList2 = new ArrayList(r.w(eVar, 10));
        Iterator<Integer> it = eVar.iterator();
        while (it.hasNext()) {
            int iNextInt = ((k0) it).nextInt();
            w1 w1Var = w1.IN_VARIANCE;
            StringBuilder sb2 = new StringBuilder();
            sb2.append('P');
            sb2.append(iNextInt);
            G0(arrayList, this, w1Var, sb2.toString());
            arrayList2.add(z.f17874a);
        }
        G0(arrayList, this, w1.OUT_VARIANCE, "R");
        this.f15682l = r.O0(arrayList);
    }

    private static final void G0(ArrayList<f1> arrayList, b bVar, w1 w1Var, String str) {
        arrayList.add(kotlin.reflect.jvm.internal.impl.descriptors.impl.k0.N0(bVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b(), false, w1Var, f.l(str), arrayList.size(), bVar.f15676f));
    }

    public final int M0() {
        return this.f15679i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.n, kotlin.reflect.jvm.internal.impl.descriptors.m
    /* JADX INFO: renamed from: P0, reason: merged with bridge method [inline-methods] */
    public l0 b() {
        return this.f15677g;
    }

    public final c Q0() {
        return this.f15678h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    /* JADX INFO: renamed from: S0, reason: merged with bridge method [inline-methods] */
    public h.b N() {
        return h.b.f14005b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.t
    /* JADX INFO: renamed from: T0, reason: merged with bridge method [inline-methods] */
    public d G(kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.f15681k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.descriptors.f g() {
        return kotlin.reflect.jvm.internal.impl.descriptors.f.INTERFACE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g getAnnotations() {
        return kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p
    public a1 getSource() {
        a1 NO_SOURCE = a1.f12668a;
        m.e(NO_SOURCE, "NO_SOURCE");
        return NO_SOURCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.q
    public u getVisibility() {
        u PUBLIC = t.f13068e;
        m.e(PUBLIC, "PUBLIC");
        return PUBLIC;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h
    public g1 h() {
        return this.f15680j;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.d0
    public e0 i() {
        return e0.ABSTRACT;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.i
    public List<f1> r() {
        return this.f15682l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.d M() {
        return (kotlin.reflect.jvm.internal.impl.descriptors.d) U0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    /* JADX INFO: renamed from: O0, reason: merged with bridge method [inline-methods] */
    public List<kotlin.reflect.jvm.internal.impl.descriptors.d> k() {
        return r.l();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.e P() {
        return (kotlin.reflect.jvm.internal.impl.descriptors.e) N0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    /* JADX INFO: renamed from: R0, reason: merged with bridge method [inline-methods] */
    public List<kotlin.reflect.jvm.internal.impl.descriptors.e> E() {
        return r.l();
    }

    public String toString() {
        String strF = getName().f();
        m.e(strF, "name.asString()");
        return strF;
    }
}
