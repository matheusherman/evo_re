package b3;

import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import org.apache.log4j.spi.Configurator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class o {
    public static final com.google.gson.x<BigInteger> A;
    public static final com.google.gson.x<com.google.gson.internal.g> B;
    public static final com.google.gson.y C;
    public static final com.google.gson.x<StringBuilder> D;
    public static final com.google.gson.y E;
    public static final com.google.gson.x<StringBuffer> F;
    public static final com.google.gson.y G;
    public static final com.google.gson.x<URL> H;
    public static final com.google.gson.y I;
    public static final com.google.gson.x<URI> J;
    public static final com.google.gson.y K;
    public static final com.google.gson.x<InetAddress> L;
    public static final com.google.gson.y M;
    public static final com.google.gson.x<UUID> N;
    public static final com.google.gson.y O;
    public static final com.google.gson.x<Currency> P;
    public static final com.google.gson.y Q;
    public static final com.google.gson.x<Calendar> R;
    public static final com.google.gson.y S;
    public static final com.google.gson.x<Locale> T;
    public static final com.google.gson.y U;
    public static final com.google.gson.x<com.google.gson.k> V;
    public static final com.google.gson.y W;
    public static final com.google.gson.y X;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.google.gson.x<Class> f827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.google.gson.y f828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.google.gson.x<BitSet> f829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.google.gson.y f830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final com.google.gson.x<Boolean> f831e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final com.google.gson.x<Boolean> f832f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final com.google.gson.y f833g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final com.google.gson.x<Number> f834h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final com.google.gson.y f835i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final com.google.gson.x<Number> f836j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final com.google.gson.y f837k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final com.google.gson.x<Number> f838l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final com.google.gson.y f839m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final com.google.gson.x<AtomicInteger> f840n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final com.google.gson.y f841o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final com.google.gson.x<AtomicBoolean> f842p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final com.google.gson.y f843q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final com.google.gson.x<AtomicIntegerArray> f844r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final com.google.gson.y f845s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final com.google.gson.x<Number> f846t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final com.google.gson.x<Number> f847u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final com.google.gson.x<Number> f848v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final com.google.gson.x<Character> f849w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final com.google.gson.y f850x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final com.google.gson.x<String> f851y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final com.google.gson.x<BigDecimal> f852z;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends com.google.gson.x<AtomicIntegerArray> {
        @Override // com.google.gson.x
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicIntegerArray b(g3.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.a();
            while (aVar.n()) {
                try {
                    arrayList.add(Integer.valueOf(aVar.t()));
                } catch (NumberFormatException e10) {
                    throw new com.google.gson.s(e10);
                }
            }
            aVar.i();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i10 = 0; i10 < size; i10++) {
                atomicIntegerArray.set(i10, ((Integer) arrayList.get(i10)).intValue());
            }
            return atomicIntegerArray;
        }

        a() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
            cVar.c();
            int length = atomicIntegerArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                cVar.B(atomicIntegerArray.get(i10));
            }
            cVar.i();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a0 implements com.google.gson.y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f853a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.google.gson.x f854b;

        /* JADX INFO: Add missing generic type declarations: [T1] */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class a<T1> extends com.google.gson.x<T1> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Class f855a;

            a(Class cls) {
                this.f855a = cls;
            }

            @Override // com.google.gson.x
            public T1 b(g3.a aVar) {
                T1 t10 = (T1) a0.this.f854b.b(aVar);
                if (t10 == null || this.f855a.isInstance(t10)) {
                    return t10;
                }
                throw new com.google.gson.s("Expected a " + this.f855a.getName() + " but was " + t10.getClass().getName() + "; at path " + aVar.m());
            }

            @Override // com.google.gson.x
            public void d(g3.c cVar, T1 t10) {
                a0.this.f854b.d(cVar, t10);
            }
        }

        a0(Class cls, com.google.gson.x xVar) {
            this.f853a = cls;
            this.f854b = xVar;
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.f853a.getName() + ",adapter=" + this.f854b + "]";
        }

        @Override // com.google.gson.y
        public <T2> com.google.gson.x<T2> a(com.google.gson.e eVar, f3.a<T2> aVar) {
            Class<? super T2> clsC = aVar.c();
            if (!this.f853a.isAssignableFrom(clsC)) {
                return null;
            }
            return new a(clsC);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b extends com.google.gson.x<Number> {
        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.q();
            } else {
                cVar.B(number.longValue());
            }
        }

        b() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(g3.a aVar) throws IOException {
            if (aVar.B() == g3.b.NULL) {
                aVar.x();
                return null;
            }
            try {
                return Long.valueOf(aVar.u());
            } catch (NumberFormatException e10) {
                throw new com.google.gson.s(e10);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c extends com.google.gson.x<Number> {
        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.q();
                return;
            }
            if (!(number instanceof Float)) {
                number = Float.valueOf(number.floatValue());
            }
            cVar.F(number);
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
            return Float.valueOf((float) aVar.s());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class d extends com.google.gson.x<Number> {
        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.q();
            } else {
                cVar.A(number.doubleValue());
            }
        }

        d() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(g3.a aVar) throws IOException {
            if (aVar.B() == g3.b.NULL) {
                aVar.x();
                return null;
            }
            return Double.valueOf(aVar.s());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class d0 extends com.google.gson.x<Boolean> {
        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, Boolean bool) throws IOException {
            cVar.G(bool == null ? Configurator.NULL : bool.toString());
        }

        d0() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Boolean b(g3.a aVar) throws IOException {
            if (aVar.B() == g3.b.NULL) {
                aVar.x();
                return null;
            }
            return Boolean.valueOf(aVar.z());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class e extends com.google.gson.x<Character> {
        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, Character ch) throws IOException {
            cVar.G(ch == null ? null : String.valueOf(ch));
        }

        e() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Character b(g3.a aVar) throws IOException {
            if (aVar.B() == g3.b.NULL) {
                aVar.x();
                return null;
            }
            String strZ = aVar.z();
            if (strZ.length() == 1) {
                return Character.valueOf(strZ.charAt(0));
            }
            throw new com.google.gson.s("Expecting character, got: " + strZ + "; at " + aVar.m());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class e0 extends com.google.gson.x<Number> {
        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.q();
            } else {
                cVar.B(number.byteValue());
            }
        }

        e0() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(g3.a aVar) throws IOException {
            if (aVar.B() == g3.b.NULL) {
                aVar.x();
                return null;
            }
            try {
                int iT = aVar.t();
                if (iT <= 255 && iT >= -128) {
                    return Byte.valueOf((byte) iT);
                }
                throw new com.google.gson.s("Lossy conversion from " + iT + " to byte; at path " + aVar.m());
            } catch (NumberFormatException e10) {
                throw new com.google.gson.s(e10);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class f0 extends com.google.gson.x<Number> {
        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.q();
            } else {
                cVar.B(number.shortValue());
            }
        }

        f0() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(g3.a aVar) throws IOException {
            if (aVar.B() == g3.b.NULL) {
                aVar.x();
                return null;
            }
            try {
                int iT = aVar.t();
                if (iT <= 65535 && iT >= -32768) {
                    return Short.valueOf((short) iT);
                }
                throw new com.google.gson.s("Lossy conversion from " + iT + " to short; at path " + aVar.m());
            } catch (NumberFormatException e10) {
                throw new com.google.gson.s(e10);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class g0 extends com.google.gson.x<Number> {
        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.q();
            } else {
                cVar.B(number.intValue());
            }
        }

        g0() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(g3.a aVar) throws IOException {
            if (aVar.B() == g3.b.NULL) {
                aVar.x();
                return null;
            }
            try {
                return Integer.valueOf(aVar.t());
            } catch (NumberFormatException e10) {
                throw new com.google.gson.s(e10);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class h0 extends com.google.gson.x<AtomicInteger> {
        @Override // com.google.gson.x
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicInteger b(g3.a aVar) {
            try {
                return new AtomicInteger(aVar.t());
            } catch (NumberFormatException e10) {
                throw new com.google.gson.s(e10);
            }
        }

        h0() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, AtomicInteger atomicInteger) throws IOException {
            cVar.B(atomicInteger.get());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class i0 extends com.google.gson.x<AtomicBoolean> {
        @Override // com.google.gson.x
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicBoolean b(g3.a aVar) {
            return new AtomicBoolean(aVar.r());
        }

        i0() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, AtomicBoolean atomicBoolean) throws IOException {
            cVar.J(atomicBoolean.get());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class j extends com.google.gson.x<StringBuilder> {
        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, StringBuilder sb2) throws IOException {
            cVar.G(sb2 == null ? null : sb2.toString());
        }

        j() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public StringBuilder b(g3.a aVar) throws IOException {
            if (aVar.B() == g3.b.NULL) {
                aVar.x();
                return null;
            }
            return new StringBuilder(aVar.z());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class j0<T extends Enum<T>> extends com.google.gson.x<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<String, T> f858a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<String, T> f859b = new HashMap();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Map<T, String> f860c = new HashMap();

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class a implements PrivilegedAction<Field[]> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Class f861a;

            a(Class cls) {
                this.f861a = cls;
            }

            @Override // java.security.PrivilegedAction
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Field[] run() {
                Field[] declaredFields = this.f861a.getDeclaredFields();
                ArrayList arrayList = new ArrayList(declaredFields.length);
                for (Field field : declaredFields) {
                    if (field.isEnumConstant()) {
                        arrayList.add(field);
                    }
                }
                Field[] fieldArr = (Field[]) arrayList.toArray(new Field[0]);
                AccessibleObject.setAccessible(fieldArr, true);
                return fieldArr;
            }
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, T t10) throws IOException {
            cVar.G(t10 == null ? null : this.f860c.get(t10));
        }

        public j0(Class<T> cls) {
            try {
                for (Field field : (Field[]) AccessController.doPrivileged(new a(cls))) {
                    Enum r10 = (Enum) field.get(null);
                    String strName = r10.name();
                    String string = r10.toString();
                    a3.c cVar = (a3.c) field.getAnnotation(a3.c.class);
                    if (cVar != null) {
                        strName = cVar.value();
                        for (String str : cVar.alternate()) {
                            this.f858a.put(str, (T) r10);
                        }
                    }
                    this.f858a.put(strName, (T) r10);
                    this.f859b.put(string, (T) r10);
                    this.f860c.put((T) r10, strName);
                }
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public T b(g3.a aVar) throws IOException {
            if (aVar.B() == g3.b.NULL) {
                aVar.x();
                return null;
            }
            String strZ = aVar.z();
            T t10 = this.f858a.get(strZ);
            if (t10 == null) {
                return this.f859b.get(strZ);
            }
            return t10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class k extends com.google.gson.x<Class> {
        @Override // com.google.gson.x
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Class b(g3.a aVar) {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, Class cls) {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }

        k() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class l extends com.google.gson.x<StringBuffer> {
        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, StringBuffer stringBuffer) throws IOException {
            cVar.G(stringBuffer == null ? null : stringBuffer.toString());
        }

        l() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public StringBuffer b(g3.a aVar) throws IOException {
            if (aVar.B() == g3.b.NULL) {
                aVar.x();
                return null;
            }
            return new StringBuffer(aVar.z());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class m extends com.google.gson.x<URL> {
        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, URL url) throws IOException {
            cVar.G(url == null ? null : url.toExternalForm());
        }

        m() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public URL b(g3.a aVar) throws IOException {
            if (aVar.B() == g3.b.NULL) {
                aVar.x();
                return null;
            }
            String strZ = aVar.z();
            if (Configurator.NULL.equals(strZ)) {
                return null;
            }
            return new URL(strZ);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class n extends com.google.gson.x<URI> {
        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, URI uri) throws IOException {
            cVar.G(uri == null ? null : uri.toASCIIString());
        }

        n() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public URI b(g3.a aVar) throws IOException {
            if (aVar.B() == g3.b.NULL) {
                aVar.x();
                return null;
            }
            try {
                String strZ = aVar.z();
                if (Configurator.NULL.equals(strZ)) {
                    return null;
                }
                return new URI(strZ);
            } catch (URISyntaxException e10) {
                throw new com.google.gson.l(e10);
            }
        }
    }

    /* JADX INFO: renamed from: b3.o$o, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class C0030o extends com.google.gson.x<InetAddress> {
        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, InetAddress inetAddress) throws IOException {
            cVar.G(inetAddress == null ? null : inetAddress.getHostAddress());
        }

        C0030o() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public InetAddress b(g3.a aVar) throws IOException {
            if (aVar.B() == g3.b.NULL) {
                aVar.x();
                return null;
            }
            return InetAddress.getByName(aVar.z());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class p extends com.google.gson.x<UUID> {
        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, UUID uuid) throws IOException {
            cVar.G(uuid == null ? null : uuid.toString());
        }

        p() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public UUID b(g3.a aVar) throws IOException {
            if (aVar.B() == g3.b.NULL) {
                aVar.x();
                return null;
            }
            String strZ = aVar.z();
            try {
                return UUID.fromString(strZ);
            } catch (IllegalArgumentException e10) {
                throw new com.google.gson.s("Failed parsing '" + strZ + "' as UUID; at path " + aVar.m(), e10);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class r extends com.google.gson.x<Calendar> {
        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                cVar.q();
                return;
            }
            cVar.d();
            cVar.o("year");
            cVar.B(calendar.get(1));
            cVar.o("month");
            cVar.B(calendar.get(2));
            cVar.o("dayOfMonth");
            cVar.B(calendar.get(5));
            cVar.o("hourOfDay");
            cVar.B(calendar.get(11));
            cVar.o("minute");
            cVar.B(calendar.get(12));
            cVar.o("second");
            cVar.B(calendar.get(13));
            cVar.j();
        }

        r() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Calendar b(g3.a aVar) throws IOException {
            if (aVar.B() == g3.b.NULL) {
                aVar.x();
                return null;
            }
            aVar.b();
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            while (aVar.B() != g3.b.END_OBJECT) {
                String strV = aVar.v();
                int iT = aVar.t();
                if ("year".equals(strV)) {
                    i10 = iT;
                } else if ("month".equals(strV)) {
                    i11 = iT;
                } else if ("dayOfMonth".equals(strV)) {
                    i12 = iT;
                } else if ("hourOfDay".equals(strV)) {
                    i13 = iT;
                } else if ("minute".equals(strV)) {
                    i14 = iT;
                } else if ("second".equals(strV)) {
                    i15 = iT;
                }
            }
            aVar.j();
            return new GregorianCalendar(i10, i11, i12, i13, i14, i15);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class s extends com.google.gson.x<Locale> {
        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, Locale locale) throws IOException {
            cVar.G(locale == null ? null : locale.toString());
        }

        s() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Locale b(g3.a aVar) throws IOException {
            String strNextToken;
            String strNextToken2;
            String strNextToken3 = null;
            if (aVar.B() == g3.b.NULL) {
                aVar.x();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.z(), "_");
            if (stringTokenizer.hasMoreElements()) {
                strNextToken = stringTokenizer.nextToken();
            } else {
                strNextToken = null;
            }
            if (stringTokenizer.hasMoreElements()) {
                strNextToken2 = stringTokenizer.nextToken();
            } else {
                strNextToken2 = null;
            }
            if (stringTokenizer.hasMoreElements()) {
                strNextToken3 = stringTokenizer.nextToken();
            }
            if (strNextToken2 == null && strNextToken3 == null) {
                return new Locale(strNextToken);
            }
            if (strNextToken3 == null) {
                return new Locale(strNextToken, strNextToken2);
            }
            return new Locale(strNextToken, strNextToken2, strNextToken3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class t extends com.google.gson.x<com.google.gson.k> {
        private com.google.gson.k f(g3.a aVar, g3.b bVar) throws IOException {
            int i10 = b0.f857a[bVar.ordinal()];
            if (i10 == 1) {
                return new com.google.gson.p(new com.google.gson.internal.g(aVar.z()));
            }
            if (i10 == 2) {
                return new com.google.gson.p(aVar.z());
            }
            if (i10 == 3) {
                return new com.google.gson.p(Boolean.valueOf(aVar.r()));
            }
            if (i10 == 6) {
                aVar.x();
                return com.google.gson.m.f4922a;
            }
            throw new IllegalStateException("Unexpected token: " + bVar);
        }

        private com.google.gson.k g(g3.a aVar, g3.b bVar) throws IOException {
            int i10 = b0.f857a[bVar.ordinal()];
            if (i10 == 4) {
                aVar.a();
                return new com.google.gson.h();
            }
            if (i10 != 5) {
                return null;
            }
            aVar.b();
            return new com.google.gson.n();
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public com.google.gson.k b(g3.a aVar) throws IOException {
            if (aVar instanceof b3.f) {
                return ((b3.f) aVar).e0();
            }
            g3.b bVarB = aVar.B();
            com.google.gson.k kVarG = g(aVar, bVarB);
            if (kVarG == null) {
                return f(aVar, bVarB);
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            while (true) {
                if (aVar.n()) {
                    String strV = kVarG instanceof com.google.gson.n ? aVar.v() : null;
                    g3.b bVarB2 = aVar.B();
                    com.google.gson.k kVarG2 = g(aVar, bVarB2);
                    boolean z10 = kVarG2 != null;
                    if (kVarG2 == null) {
                        kVarG2 = f(aVar, bVarB2);
                    }
                    if (kVarG instanceof com.google.gson.h) {
                        ((com.google.gson.h) kVarG).n(kVarG2);
                    } else {
                        ((com.google.gson.n) kVarG).n(strV, kVarG2);
                    }
                    if (z10) {
                        arrayDeque.addLast(kVarG);
                        kVarG = kVarG2;
                    }
                } else {
                    if (kVarG instanceof com.google.gson.h) {
                        aVar.i();
                    } else {
                        aVar.j();
                    }
                    if (arrayDeque.isEmpty()) {
                        return kVarG;
                    }
                    kVarG = (com.google.gson.k) arrayDeque.removeLast();
                }
            }
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, com.google.gson.k kVar) throws IOException {
            if (kVar == null || kVar.i()) {
                cVar.q();
                return;
            }
            if (kVar.m()) {
                com.google.gson.p pVarG = kVar.g();
                if (pVarG.w()) {
                    cVar.F(pVarG.s());
                    return;
                } else if (pVarG.u()) {
                    cVar.J(pVarG.n());
                    return;
                } else {
                    cVar.G(pVarG.t());
                    return;
                }
            }
            if (kVar.h()) {
                cVar.c();
                Iterator<com.google.gson.k> it = kVar.e().iterator();
                while (it.hasNext()) {
                    d(cVar, it.next());
                }
                cVar.i();
                return;
            }
            if (!kVar.k()) {
                throw new IllegalArgumentException("Couldn't write " + kVar.getClass());
            }
            cVar.d();
            for (Map.Entry<String, com.google.gson.k> entry : kVar.f().o()) {
                cVar.o(entry.getKey());
                d(cVar, entry.getValue());
            }
            cVar.j();
        }

        t() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class v extends com.google.gson.x<BitSet> {
        @Override // com.google.gson.x
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public BitSet b(g3.a aVar) throws IOException {
            BitSet bitSet = new BitSet();
            aVar.a();
            g3.b bVarB = aVar.B();
            int i10 = 0;
            while (bVarB != g3.b.END_ARRAY) {
                int i11 = b0.f857a[bVarB.ordinal()];
                boolean zR = true;
                if (i11 == 1 || i11 == 2) {
                    int iT = aVar.t();
                    if (iT == 0) {
                        zR = false;
                    } else if (iT != 1) {
                        throw new com.google.gson.s("Invalid bitset value " + iT + ", expected 0 or 1; at path " + aVar.m());
                    }
                } else {
                    if (i11 != 3) {
                        throw new com.google.gson.s("Invalid bitset value type: " + bVarB + "; at path " + aVar.getPath());
                    }
                    zR = aVar.r();
                }
                if (zR) {
                    bitSet.set(i10);
                }
                i10++;
                bVarB = aVar.B();
            }
            aVar.i();
            return bitSet;
        }

        v() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, BitSet bitSet) throws IOException {
            cVar.c();
            int length = bitSet.length();
            for (int i10 = 0; i10 < length; i10++) {
                cVar.B(bitSet.get(i10) ? 1L : 0L);
            }
            cVar.i();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class w implements com.google.gson.y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f3.a f863a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.google.gson.x f864b;

        w(f3.a aVar, com.google.gson.x xVar) {
            this.f863a = aVar;
            this.f864b = xVar;
        }

        @Override // com.google.gson.y
        public <T> com.google.gson.x<T> a(com.google.gson.e eVar, f3.a<T> aVar) {
            if (aVar.equals(this.f863a)) {
                return this.f864b;
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class x implements com.google.gson.y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.google.gson.x f866b;

        x(Class cls, com.google.gson.x xVar) {
            this.f865a = cls;
            this.f866b = xVar;
        }

        public String toString() {
            return "Factory[type=" + this.f865a.getName() + ",adapter=" + this.f866b + "]";
        }

        @Override // com.google.gson.y
        public <T> com.google.gson.x<T> a(com.google.gson.e eVar, f3.a<T> aVar) {
            if (aVar.c() == this.f865a) {
                return this.f866b;
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class y implements com.google.gson.y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f867a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Class f868b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.google.gson.x f869c;

        y(Class cls, Class cls2, com.google.gson.x xVar) {
            this.f867a = cls;
            this.f868b = cls2;
            this.f869c = xVar;
        }

        public String toString() {
            return "Factory[type=" + this.f868b.getName() + "+" + this.f867a.getName() + ",adapter=" + this.f869c + "]";
        }

        @Override // com.google.gson.y
        public <T> com.google.gson.x<T> a(com.google.gson.e eVar, f3.a<T> aVar) {
            Class<? super T> clsC = aVar.c();
            if (clsC != this.f867a && clsC != this.f868b) {
                return null;
            }
            return this.f869c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class z implements com.google.gson.y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f870a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Class f871b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.google.gson.x f872c;

        z(Class cls, Class cls2, com.google.gson.x xVar) {
            this.f870a = cls;
            this.f871b = cls2;
            this.f872c = xVar;
        }

        public String toString() {
            return "Factory[type=" + this.f870a.getName() + "+" + this.f871b.getName() + ",adapter=" + this.f872c + "]";
        }

        @Override // com.google.gson.y
        public <T> com.google.gson.x<T> a(com.google.gson.e eVar, f3.a<T> aVar) {
            Class<? super T> clsC = aVar.c();
            if (clsC != this.f870a && clsC != this.f871b) {
                return null;
            }
            return this.f872c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f857a;

        static {
            int[] iArr = new int[g3.b.values().length];
            f857a = iArr;
            try {
                iArr[g3.b.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f857a[g3.b.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f857a[g3.b.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f857a[g3.b.BEGIN_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f857a[g3.b.BEGIN_OBJECT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f857a[g3.b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c0 extends com.google.gson.x<Boolean> {
        c0() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Boolean b(g3.a aVar) throws IOException {
            g3.b bVarB = aVar.B();
            if (bVarB == g3.b.NULL) {
                aVar.x();
                return null;
            }
            if (bVarB == g3.b.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(aVar.z()));
            }
            return Boolean.valueOf(aVar.r());
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, Boolean bool) throws IOException {
            cVar.C(bool);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class f extends com.google.gson.x<String> {
        f() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public String b(g3.a aVar) throws IOException {
            g3.b bVarB = aVar.B();
            if (bVarB == g3.b.NULL) {
                aVar.x();
                return null;
            }
            if (bVarB == g3.b.BOOLEAN) {
                return Boolean.toString(aVar.r());
            }
            return aVar.z();
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, String str) throws IOException {
            cVar.G(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class g extends com.google.gson.x<BigDecimal> {
        g() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public BigDecimal b(g3.a aVar) throws IOException {
            if (aVar.B() == g3.b.NULL) {
                aVar.x();
                return null;
            }
            String strZ = aVar.z();
            try {
                return new BigDecimal(strZ);
            } catch (NumberFormatException e10) {
                throw new com.google.gson.s("Failed parsing '" + strZ + "' as BigDecimal; at path " + aVar.m(), e10);
            }
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, BigDecimal bigDecimal) throws IOException {
            cVar.F(bigDecimal);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class h extends com.google.gson.x<BigInteger> {
        h() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public BigInteger b(g3.a aVar) throws IOException {
            if (aVar.B() == g3.b.NULL) {
                aVar.x();
                return null;
            }
            String strZ = aVar.z();
            try {
                return new BigInteger(strZ);
            } catch (NumberFormatException e10) {
                throw new com.google.gson.s("Failed parsing '" + strZ + "' as BigInteger; at path " + aVar.m(), e10);
            }
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, BigInteger bigInteger) throws IOException {
            cVar.F(bigInteger);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class i extends com.google.gson.x<com.google.gson.internal.g> {
        i() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public com.google.gson.internal.g b(g3.a aVar) throws IOException {
            if (aVar.B() == g3.b.NULL) {
                aVar.x();
                return null;
            }
            return new com.google.gson.internal.g(aVar.z());
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, com.google.gson.internal.g gVar) throws IOException {
            cVar.F(gVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class q extends com.google.gson.x<Currency> {
        q() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Currency b(g3.a aVar) throws IOException {
            String strZ = aVar.z();
            try {
                return Currency.getInstance(strZ);
            } catch (IllegalArgumentException e10) {
                throw new com.google.gson.s("Failed parsing '" + strZ + "' as Currency; at path " + aVar.m(), e10);
            }
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, Currency currency) throws IOException {
            cVar.G(currency.getCurrencyCode());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class u implements com.google.gson.y {
        u() {
        }

        @Override // com.google.gson.y
        public <T> com.google.gson.x<T> a(com.google.gson.e eVar, f3.a<T> aVar) {
            Class<? super T> clsC = aVar.c();
            if (Enum.class.isAssignableFrom(clsC) && clsC != Enum.class) {
                if (!clsC.isEnum()) {
                    clsC = clsC.getSuperclass();
                }
                return new j0(clsC);
            }
            return null;
        }
    }

    static {
        com.google.gson.x<Class> xVarA = new k().a();
        f827a = xVarA;
        f828b = b(Class.class, xVarA);
        com.google.gson.x<BitSet> xVarA2 = new v().a();
        f829c = xVarA2;
        f830d = b(BitSet.class, xVarA2);
        c0 c0Var = new c0();
        f831e = c0Var;
        f832f = new d0();
        f833g = c(Boolean.TYPE, Boolean.class, c0Var);
        e0 e0Var = new e0();
        f834h = e0Var;
        f835i = c(Byte.TYPE, Byte.class, e0Var);
        f0 f0Var = new f0();
        f836j = f0Var;
        f837k = c(Short.TYPE, Short.class, f0Var);
        g0 g0Var = new g0();
        f838l = g0Var;
        f839m = c(Integer.TYPE, Integer.class, g0Var);
        com.google.gson.x<AtomicInteger> xVarA3 = new h0().a();
        f840n = xVarA3;
        f841o = b(AtomicInteger.class, xVarA3);
        com.google.gson.x<AtomicBoolean> xVarA4 = new i0().a();
        f842p = xVarA4;
        f843q = b(AtomicBoolean.class, xVarA4);
        com.google.gson.x<AtomicIntegerArray> xVarA5 = new a().a();
        f844r = xVarA5;
        f845s = b(AtomicIntegerArray.class, xVarA5);
        f846t = new b();
        f847u = new c();
        f848v = new d();
        e eVar = new e();
        f849w = eVar;
        f850x = c(Character.TYPE, Character.class, eVar);
        f fVar = new f();
        f851y = fVar;
        f852z = new g();
        A = new h();
        B = new i();
        C = b(String.class, fVar);
        j jVar = new j();
        D = jVar;
        E = b(StringBuilder.class, jVar);
        l lVar = new l();
        F = lVar;
        G = b(StringBuffer.class, lVar);
        m mVar = new m();
        H = mVar;
        I = b(URL.class, mVar);
        n nVar = new n();
        J = nVar;
        K = b(URI.class, nVar);
        C0030o c0030o = new C0030o();
        L = c0030o;
        M = e(InetAddress.class, c0030o);
        p pVar = new p();
        N = pVar;
        O = b(UUID.class, pVar);
        com.google.gson.x<Currency> xVarA6 = new q().a();
        P = xVarA6;
        Q = b(Currency.class, xVarA6);
        r rVar = new r();
        R = rVar;
        S = d(Calendar.class, GregorianCalendar.class, rVar);
        s sVar = new s();
        T = sVar;
        U = b(Locale.class, sVar);
        t tVar = new t();
        V = tVar;
        W = e(com.google.gson.k.class, tVar);
        X = new u();
    }

    public static <TT> com.google.gson.y a(f3.a<TT> aVar, com.google.gson.x<TT> xVar) {
        return new w(aVar, xVar);
    }

    public static <TT> com.google.gson.y b(Class<TT> cls, com.google.gson.x<TT> xVar) {
        return new x(cls, xVar);
    }

    public static <TT> com.google.gson.y c(Class<TT> cls, Class<TT> cls2, com.google.gson.x<? super TT> xVar) {
        return new y(cls, cls2, xVar);
    }

    public static <TT> com.google.gson.y d(Class<TT> cls, Class<? extends TT> cls2, com.google.gson.x<? super TT> xVar) {
        return new z(cls, cls2, xVar);
    }

    public static <T1> com.google.gson.y e(Class<T1> cls, com.google.gson.x<T1> xVar) {
        return new a0(cls, xVar);
    }
}
