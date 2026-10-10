package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.types.c1;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.g1;
import kotlin.reflect.jvm.internal.impl.types.m1;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.o1;
import kotlin.reflect.jvm.internal.impl.types.w1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class n implements g1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f13904f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f13905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h0 f13906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<g0> f13907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final o0 f13908d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final r8.i f13909e;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.resolve.constants.n$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        private enum EnumC0253a {
            COMMON_SUPER_TYPE,
            INTERSECTION_TYPE
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private final o0 e(o0 o0Var, o0 o0Var2, EnumC0253a enumC0253a) {
            if (o0Var != null && o0Var2 != null) {
                g1 g1VarJ0 = o0Var.J0();
                g1 g1VarJ1 = o0Var2.J0();
                boolean z10 = g1VarJ0 instanceof n;
                if (z10 && (g1VarJ1 instanceof n)) {
                    return c((n) g1VarJ0, (n) g1VarJ1, enumC0253a);
                }
                if (z10) {
                    return d((n) g1VarJ0, o0Var2);
                }
                if (g1VarJ1 instanceof n) {
                    return d((n) g1VarJ1, o0Var);
                }
            }
            return null;
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public /* synthetic */ class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f13913a;

            static {
                int[] iArr = new int[EnumC0253a.values().length];
                try {
                    iArr[EnumC0253a.COMMON_SUPER_TYPE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC0253a.INTERSECTION_TYPE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f13913a = iArr;
            }
        }

        private a() {
        }

        private final o0 c(n nVar, n nVar2, EnumC0253a enumC0253a) {
            Set setM0;
            int i10 = b.f13913a[enumC0253a.ordinal()];
            if (i10 == 1) {
                setM0 = kotlin.collections.r.m0(nVar.k(), nVar2.k());
            } else {
                if (i10 != 2) {
                    throw new r8.n();
                }
                setM0 = kotlin.collections.r.T0(nVar.k(), nVar2.k());
            }
            return kotlin.reflect.jvm.internal.impl.types.h0.e(c1.f14231b.h(), new n(nVar.f13905a, nVar.f13906b, setM0, null), false);
        }

        public final o0 b(Collection<? extends o0> types) {
            kotlin.jvm.internal.m.f(types, "types");
            return a(types, EnumC0253a.INTERSECTION_TYPE);
        }

        private final o0 a(Collection<? extends o0> collection, EnumC0253a enumC0253a) {
            if (collection.isEmpty()) {
                return null;
            }
            Iterator<T> it = collection.iterator();
            if (it.hasNext()) {
                Object next = it.next();
                while (it.hasNext()) {
                    o0 o0Var = (o0) it.next();
                    next = n.f13904f.e((o0) next, o0Var, enumC0253a);
                }
                return (o0) next;
            }
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }

        private final o0 d(n nVar, o0 o0Var) {
            if (nVar.k().contains(o0Var)) {
                return o0Var;
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends kotlin.jvm.internal.o implements c9.a<List<o0>> {
        b() {
            super(0);
        }

        @Override // c9.a
        public final List<o0> invoke() {
            o0 o0VarP = n.this.l().x().p();
            kotlin.jvm.internal.m.e(o0VarP, "builtIns.comparable.defaultType");
            List<o0> listR = kotlin.collections.r.r(o1.f(o0VarP, kotlin.collections.r.e(new m1(w1.IN_VARIANCE, n.this.f13908d)), null, 2, null));
            if (!n.this.n()) {
                listR.add(n.this.l().L());
            }
            return listR;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends kotlin.jvm.internal.o implements c9.l<g0, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f13914a = new c();

        c() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(g0 it) {
            kotlin.jvm.internal.m.f(it, "it");
            return it.toString();
        }
    }

    public /* synthetic */ n(long j10, h0 h0Var, Set set, kotlin.jvm.internal.g gVar) {
        this(j10, h0Var, set);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    public kotlin.reflect.jvm.internal.impl.descriptors.h d() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    public boolean e() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private n(long j10, h0 h0Var, Set<? extends g0> set) {
        this.f13908d = kotlin.reflect.jvm.internal.impl.types.h0.e(c1.f14231b.h(), this, false);
        this.f13909e = r8.j.a(new b());
        this.f13905a = j10;
        this.f13906b = h0Var;
        this.f13907c = set;
    }

    private final List<g0> m() {
        return (List) this.f13909e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean n() {
        Collection<g0> collectionA = t.a(this.f13906b);
        if ((collectionA instanceof Collection) && collectionA.isEmpty()) {
            return true;
        }
        Iterator<T> it = collectionA.iterator();
        while (it.hasNext()) {
            if (this.f13907c.contains((g0) it.next())) {
                return false;
            }
        }
        return true;
    }

    private final String o() {
        return '[' + kotlin.collections.r.q0(this.f13907c, ",", null, null, 0, null, c.f13914a, 30, null) + ']';
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    public g1 c(kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    public final Set<g0> k() {
        return this.f13907c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    public kotlin.reflect.jvm.internal.impl.builtins.h l() {
        return this.f13906b.l();
    }

    public String toString() {
        return "IntegerLiteralType" + o();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    public Collection<g0> b() {
        return m();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    public List<f1> getParameters() {
        return kotlin.collections.r.l();
    }
}
