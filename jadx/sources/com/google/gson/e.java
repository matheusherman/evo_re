package com.google.gson;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class e {
    static final com.google.gson.d A = com.google.gson.c.f4794a;
    static final w B = v.f4933a;
    static final w C = v.f4934b;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    static final String f4802z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ThreadLocal<Map<f3.a<?>, x<?>>> f4803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentMap<f3.a<?>, x<?>> f4804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.gson.internal.c f4805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b3.e f4806d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final List<y> f4807e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final com.google.gson.internal.d f4808f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final com.google.gson.d f4809g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Map<Type, g<?>> f4810h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final boolean f4811i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final boolean f4812j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final boolean f4813k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final boolean f4814l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final boolean f4815m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final boolean f4816n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final boolean f4817o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final boolean f4818p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final String f4819q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    final int f4820r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final int f4821s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final t f4822t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final List<y> f4823u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    final List<y> f4824v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final w f4825w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    final w f4826x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    final List<u> f4827y;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends x<Number> {
        a() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.q();
                return;
            }
            double dDoubleValue = number.doubleValue();
            e.d(dDoubleValue);
            cVar.A(dDoubleValue);
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Double b(g3.a aVar) throws IOException {
            if (aVar.B() == g3.b.NULL) {
                aVar.x();
                return null;
            }
            return Double.valueOf(aVar.s());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b extends x<Number> {
        b() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.q();
                return;
            }
            float fFloatValue = number.floatValue();
            e.d(fFloatValue);
            if (!(number instanceof Float)) {
                number = Float.valueOf(fFloatValue);
            }
            cVar.F(number);
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Float b(g3.a aVar) throws IOException {
            if (aVar.B() == g3.b.NULL) {
                aVar.x();
                return null;
            }
            return Float.valueOf((float) aVar.s());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c extends x<Number> {
        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.q();
            } else {
                cVar.G(number.toString());
            }
        }

        c() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(g3.a aVar) throws IOException {
            if (aVar.B() == g3.b.NULL) {
                aVar.x();
                return null;
            }
            return Long.valueOf(aVar.u());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class d extends x<AtomicLong> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ x f4830a;

        d(x xVar) {
            this.f4830a = xVar;
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicLong b(g3.a aVar) {
            return new AtomicLong(((Number) this.f4830a.b(aVar)).longValue());
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, AtomicLong atomicLong) {
            this.f4830a.d(cVar, Long.valueOf(atomicLong.get()));
        }
    }

    /* JADX INFO: renamed from: com.google.gson.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class C0055e extends x<AtomicLongArray> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ x f4831a;

        C0055e(x xVar) {
            this.f4831a = xVar;
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicLongArray b(g3.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.a();
            while (aVar.n()) {
                arrayList.add(Long.valueOf(((Number) this.f4831a.b(aVar)).longValue()));
            }
            aVar.i();
            int size = arrayList.size();
            AtomicLongArray atomicLongArray = new AtomicLongArray(size);
            for (int i10 = 0; i10 < size; i10++) {
                atomicLongArray.set(i10, ((Long) arrayList.get(i10)).longValue());
            }
            return atomicLongArray;
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, AtomicLongArray atomicLongArray) throws IOException {
            cVar.c();
            int length = atomicLongArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                this.f4831a.d(cVar, Long.valueOf(atomicLongArray.get(i10)));
            }
            cVar.i();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class f<T> extends b3.l<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private x<T> f4832a = null;

        private x<T> f() {
            x<T> xVar = this.f4832a;
            if (xVar != null) {
                return xVar;
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        public void g(x<T> xVar) {
            if (this.f4832a != null) {
                throw new AssertionError("Delegate is already set");
            }
            this.f4832a = xVar;
        }

        f() {
        }

        @Override // com.google.gson.x
        public T b(g3.a aVar) {
            return f().b(aVar);
        }

        @Override // com.google.gson.x
        public void d(g3.c cVar, T t10) {
            f().d(cVar, t10);
        }

        @Override // b3.l
        public x<T> e() {
            return f();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public e() {
        com.google.gson.internal.d dVar = com.google.gson.internal.d.f4877g;
        com.google.gson.d dVar2 = A;
        Map map = Collections.EMPTY_MAP;
        t tVar = t.f4925a;
        String str = f4802z;
        List list = Collections.EMPTY_LIST;
        this(dVar, dVar2, map, false, false, false, true, false, false, false, true, tVar, str, 2, 2, list, list, list, B, C, list);
    }

    private static void a(Object obj, g3.a aVar) {
        if (obj != null) {
            try {
                if (aVar.B() == g3.b.END_DOCUMENT) {
                } else {
                    throw new s("JSON document was not fully consumed.");
                }
            } catch (g3.d e10) {
                throw new s(e10);
            } catch (IOException e11) {
                throw new l(e11);
            }
        }
    }

    private static x<AtomicLong> b(x<Number> xVar) {
        return new d(xVar).a();
    }

    private static x<AtomicLongArray> c(x<Number> xVar) {
        return new C0055e(xVar).a();
    }

    private x<Number> e(boolean z10) {
        return z10 ? b3.o.f848v : new a();
    }

    private x<Number> f(boolean z10) {
        return z10 ? b3.o.f847u : new b();
    }

    private static x<Number> s(t tVar) {
        return tVar == t.f4925a ? b3.o.f846t : new c();
    }

    public <T> T g(k kVar, f3.a<T> aVar) {
        if (kVar == null) {
            return null;
        }
        return (T) i(new b3.f(kVar), aVar);
    }

    public <T> T m(String str, f3.a<T> aVar) {
        if (str == null) {
            return null;
        }
        return (T) j(new StringReader(str), aVar);
    }

    public <T> x<T> p(f3.a<T> aVar) {
        boolean z10;
        Objects.requireNonNull(aVar, "type must not be null");
        x<T> xVar = (x) this.f4804b.get(aVar);
        if (xVar != null) {
            return xVar;
        }
        Map<? extends f3.a<?>, ? extends x<?>> map = this.f4803a.get();
        if (map == null) {
            map = new HashMap<>();
            this.f4803a.set((Map<f3.a<?>, x<?>>) map);
            z10 = true;
        } else {
            x<T> xVar2 = (x) map.get(aVar);
            if (xVar2 != null) {
                return xVar2;
            }
            z10 = false;
        }
        try {
            f fVar = new f();
            map.put(aVar, fVar);
            Iterator<y> it = this.f4807e.iterator();
            x<T> xVarA = null;
            while (it.hasNext()) {
                xVarA = it.next().a(this, aVar);
                if (xVarA != null) {
                    fVar.g(xVarA);
                    map.put(aVar, xVarA);
                    break;
                }
            }
            if (z10) {
                this.f4803a.remove();
            }
            if (xVarA != null) {
                if (z10) {
                    this.f4804b.putAll(map);
                }
                return xVarA;
            }
            throw new IllegalArgumentException("GSON (2.10.1) cannot handle " + aVar);
        } catch (Throwable th) {
            if (z10) {
                this.f4803a.remove();
            }
            throw th;
        }
    }

    public <T> x<T> r(y yVar, f3.a<T> aVar) {
        if (!this.f4807e.contains(yVar)) {
            yVar = this.f4806d;
        }
        boolean z10 = false;
        for (y yVar2 : this.f4807e) {
            if (z10) {
                x<T> xVarA = yVar2.a(this, aVar);
                if (xVarA != null) {
                    return xVarA;
                }
            } else if (yVar2 == yVar) {
                z10 = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public g3.a t(Reader reader) {
        g3.a aVar = new g3.a(reader);
        aVar.M(this.f4816n);
        return aVar;
    }

    public String toString() {
        return "{serializeNulls:" + this.f4811i + ",factories:" + this.f4807e + ",instanceCreators:" + this.f4805c + "}";
    }

    public g3.c u(Writer writer) throws IOException {
        if (this.f4813k) {
            writer.write(")]}'\n");
        }
        g3.c cVar = new g3.c(writer);
        if (this.f4815m) {
            cVar.w("  ");
        }
        cVar.v(this.f4814l);
        cVar.x(this.f4816n);
        cVar.y(this.f4811i);
        return cVar;
    }

    public String v(k kVar) {
        StringWriter stringWriter = new StringWriter();
        z(kVar, stringWriter);
        return stringWriter.toString();
    }

    public String w(Object obj) {
        return obj == null ? v(m.f4922a) : x(obj, obj.getClass());
    }

    public String x(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        B(obj, type, stringWriter);
        return stringWriter.toString();
    }

    static void d(double d10) {
        if (!Double.isNaN(d10) && !Double.isInfinite(d10)) {
            return;
        }
        throw new IllegalArgumentException(d10 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
    }

    public void A(Object obj, Type type, g3.c cVar) {
        x xVarP = p(f3.a.b(type));
        boolean zM = cVar.m();
        cVar.x(true);
        boolean zL = cVar.l();
        cVar.v(this.f4814l);
        boolean zK = cVar.k();
        cVar.y(this.f4811i);
        try {
            try {
                xVarP.d(cVar, obj);
                cVar.x(zM);
                cVar.v(zL);
                cVar.y(zK);
            } catch (IOException e10) {
                throw new l(e10);
            } catch (AssertionError e11) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e11.getMessage(), e11);
            }
        } catch (Throwable th) {
            cVar.x(zM);
            cVar.v(zL);
            cVar.y(zK);
            throw th;
        }
    }

    public void B(Object obj, Type type, Appendable appendable) {
        try {
            A(obj, type, u(com.google.gson.internal.m.c(appendable)));
        } catch (IOException e10) {
            throw new l(e10);
        }
    }

    public <T> T h(k kVar, Type type) {
        return (T) g(kVar, f3.a.b(type));
    }

    public <T> T i(g3.a aVar, f3.a<T> aVar2) {
        boolean zO = aVar.o();
        boolean z10 = true;
        aVar.M(true);
        try {
            try {
                try {
                    aVar.B();
                    z10 = false;
                    T tB = p(aVar2).b(aVar);
                    aVar.M(zO);
                    return tB;
                } catch (AssertionError e10) {
                    throw new AssertionError("AssertionError (GSON 2.10.1): " + e10.getMessage(), e10);
                } catch (IllegalStateException e11) {
                    throw new s(e11);
                }
            } catch (EOFException e12) {
                if (z10) {
                    aVar.M(zO);
                    return null;
                }
                throw new s(e12);
            } catch (IOException e13) {
                throw new s(e13);
            }
        } catch (Throwable th) {
            aVar.M(zO);
            throw th;
        }
    }

    public <T> T j(Reader reader, f3.a<T> aVar) {
        g3.a aVarT = t(reader);
        T t10 = (T) i(aVarT, aVar);
        a(t10, aVarT);
        return t10;
    }

    public <T> T k(Reader reader, Class<T> cls) {
        return (T) com.google.gson.internal.k.b(cls).cast(j(reader, f3.a.a(cls)));
    }

    public <T> T l(Reader reader, Type type) {
        return (T) j(reader, f3.a.b(type));
    }

    public <T> T n(String str, Class<T> cls) {
        return (T) com.google.gson.internal.k.b(cls).cast(m(str, f3.a.a(cls)));
    }

    public <T> T o(String str, Type type) {
        return (T) m(str, f3.a.b(type));
    }

    public <T> x<T> q(Class<T> cls) {
        return p(f3.a.a(cls));
    }

    public void y(k kVar, g3.c cVar) {
        boolean zM = cVar.m();
        cVar.x(true);
        boolean zL = cVar.l();
        cVar.v(this.f4814l);
        boolean zK = cVar.k();
        cVar.y(this.f4811i);
        try {
            try {
                com.google.gson.internal.m.b(kVar, cVar);
                cVar.x(zM);
                cVar.v(zL);
                cVar.y(zK);
            } catch (IOException e10) {
                throw new l(e10);
            } catch (AssertionError e11) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e11.getMessage(), e11);
            }
        } catch (Throwable th) {
            cVar.x(zM);
            cVar.v(zL);
            cVar.y(zK);
            throw th;
        }
    }

    public void z(k kVar, Appendable appendable) {
        try {
            y(kVar, u(com.google.gson.internal.m.c(appendable)));
        } catch (IOException e10) {
            throw new l(e10);
        }
    }

    e(com.google.gson.internal.d dVar, com.google.gson.d dVar2, Map<Type, g<?>> map, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, t tVar, String str, int i10, int i11, List<y> list, List<y> list2, List<y> list3, w wVar, w wVar2, List<u> list4) {
        this.f4803a = new ThreadLocal<>();
        this.f4804b = new ConcurrentHashMap();
        this.f4808f = dVar;
        this.f4809g = dVar2;
        this.f4810h = map;
        com.google.gson.internal.c cVar = new com.google.gson.internal.c(map, z17, list4);
        this.f4805c = cVar;
        this.f4811i = z10;
        this.f4812j = z11;
        this.f4813k = z12;
        this.f4814l = z13;
        this.f4815m = z14;
        this.f4816n = z15;
        this.f4817o = z16;
        this.f4818p = z17;
        this.f4822t = tVar;
        this.f4819q = str;
        this.f4820r = i10;
        this.f4821s = i11;
        this.f4823u = list;
        this.f4824v = list2;
        this.f4825w = wVar;
        this.f4826x = wVar2;
        this.f4827y = list4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(b3.o.W);
        arrayList.add(b3.j.e(wVar));
        arrayList.add(dVar);
        arrayList.addAll(list3);
        arrayList.add(b3.o.C);
        arrayList.add(b3.o.f839m);
        arrayList.add(b3.o.f833g);
        arrayList.add(b3.o.f835i);
        arrayList.add(b3.o.f837k);
        x<Number> xVarS = s(tVar);
        arrayList.add(b3.o.c(Long.TYPE, Long.class, xVarS));
        arrayList.add(b3.o.c(Double.TYPE, Double.class, e(z16)));
        arrayList.add(b3.o.c(Float.TYPE, Float.class, f(z16)));
        arrayList.add(b3.i.e(wVar2));
        arrayList.add(b3.o.f841o);
        arrayList.add(b3.o.f843q);
        arrayList.add(b3.o.b(AtomicLong.class, b(xVarS)));
        arrayList.add(b3.o.b(AtomicLongArray.class, c(xVarS)));
        arrayList.add(b3.o.f845s);
        arrayList.add(b3.o.f850x);
        arrayList.add(b3.o.E);
        arrayList.add(b3.o.G);
        arrayList.add(b3.o.b(BigDecimal.class, b3.o.f852z));
        arrayList.add(b3.o.b(BigInteger.class, b3.o.A));
        arrayList.add(b3.o.b(com.google.gson.internal.g.class, b3.o.B));
        arrayList.add(b3.o.I);
        arrayList.add(b3.o.K);
        arrayList.add(b3.o.O);
        arrayList.add(b3.o.Q);
        arrayList.add(b3.o.U);
        arrayList.add(b3.o.M);
        arrayList.add(b3.o.f830d);
        arrayList.add(b3.c.f751b);
        arrayList.add(b3.o.S);
        if (e3.d.f9872a) {
            arrayList.add(e3.d.f9876e);
            arrayList.add(e3.d.f9875d);
            arrayList.add(e3.d.f9877f);
        }
        arrayList.add(b3.a.f745c);
        arrayList.add(b3.o.f828b);
        arrayList.add(new b3.b(cVar));
        arrayList.add(new b3.h(cVar, z11));
        b3.e eVar = new b3.e(cVar);
        this.f4806d = eVar;
        arrayList.add(eVar);
        arrayList.add(b3.o.X);
        arrayList.add(new b3.k(cVar, dVar2, dVar, eVar, list4));
        this.f4807e = Collections.unmodifiableList(arrayList);
    }
}
