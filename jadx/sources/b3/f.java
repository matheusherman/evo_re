package b3;

import com.google.gson.p;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class f extends g3.a {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final Reader f758t = new a();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final Object f759u = new Object();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Object[] f760p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f761q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String[] f762r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int[] f763s;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends Reader {
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i10, int i11) {
            throw new AssertionError();
        }

        a() {
        }
    }

    @Override // g3.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f760p = new Object[]{f759u};
        this.f761q = 1;
    }

    @Override // g3.a
    public String getPath() {
        return l(false);
    }

    @Override // g3.a
    public String m() {
        return l(true);
    }

    @Override // g3.a
    public String v() {
        return i0(false);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f764a;

        static {
            int[] iArr = new int[g3.b.values().length];
            f764a = iArr;
            try {
                iArr[g3.b.NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f764a[g3.b.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f764a[g3.b.END_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f764a[g3.b.END_DOCUMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public f(com.google.gson.k kVar) {
        super(f758t);
        this.f760p = new Object[32];
        this.f761q = 0;
        this.f762r = new String[32];
        this.f763s = new int[32];
        m0(kVar);
    }

    private String i0(boolean z10) {
        c0(g3.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) j0()).next();
        String str = (String) entry.getKey();
        this.f762r[this.f761q - 1] = z10 ? "<skipped>" : str;
        m0(entry.getValue());
        return str;
    }

    private Object j0() {
        return this.f760p[this.f761q - 1];
    }

    private Object k0() {
        Object[] objArr = this.f760p;
        int i10 = this.f761q - 1;
        this.f761q = i10;
        Object obj = objArr[i10];
        objArr[i10] = null;
        return obj;
    }

    private String l(boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('$');
        int i10 = 0;
        while (true) {
            int i11 = this.f761q;
            if (i10 >= i11) {
                return sb2.toString();
            }
            Object[] objArr = this.f760p;
            Object obj = objArr[i10];
            if (obj instanceof com.google.gson.h) {
                i10++;
                if (i10 < i11 && (objArr[i10] instanceof Iterator)) {
                    int i12 = this.f763s[i10];
                    if (z10 && i12 > 0 && (i10 == i11 - 1 || i10 == i11 - 2)) {
                        i12--;
                    }
                    sb2.append('[');
                    sb2.append(i12);
                    sb2.append(']');
                }
            } else if ((obj instanceof com.google.gson.n) && (i10 = i10 + 1) < i11 && (objArr[i10] instanceof Iterator)) {
                sb2.append('.');
                String str = this.f762r[i10];
                if (str != null) {
                    sb2.append(str);
                }
            }
            i10++;
        }
    }

    private void m0(Object obj) {
        int i10 = this.f761q;
        Object[] objArr = this.f760p;
        if (i10 == objArr.length) {
            int i11 = i10 * 2;
            this.f760p = Arrays.copyOf(objArr, i11);
            this.f763s = Arrays.copyOf(this.f763s, i11);
            this.f762r = (String[]) Arrays.copyOf(this.f762r, i11);
        }
        Object[] objArr2 = this.f760p;
        int i12 = this.f761q;
        this.f761q = i12 + 1;
        objArr2[i12] = obj;
    }

    private String q() {
        return " at path " + getPath();
    }

    @Override // g3.a
    public g3.b B() throws g3.d {
        if (this.f761q == 0) {
            return g3.b.END_DOCUMENT;
        }
        Object objJ0 = j0();
        if (objJ0 instanceof Iterator) {
            boolean z10 = this.f760p[this.f761q - 2] instanceof com.google.gson.n;
            Iterator it = (Iterator) objJ0;
            if (!it.hasNext()) {
                return z10 ? g3.b.END_OBJECT : g3.b.END_ARRAY;
            }
            if (z10) {
                return g3.b.NAME;
            }
            m0(it.next());
            return B();
        }
        if (objJ0 instanceof com.google.gson.n) {
            return g3.b.BEGIN_OBJECT;
        }
        if (objJ0 instanceof com.google.gson.h) {
            return g3.b.BEGIN_ARRAY;
        }
        if (objJ0 instanceof p) {
            p pVar = (p) objJ0;
            if (pVar.x()) {
                return g3.b.STRING;
            }
            if (pVar.u()) {
                return g3.b.BOOLEAN;
            }
            if (pVar.w()) {
                return g3.b.NUMBER;
            }
            throw new AssertionError();
        }
        if (objJ0 instanceof com.google.gson.m) {
            return g3.b.NULL;
        }
        if (objJ0 == f759u) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new g3.d("Custom JsonElement subclass " + objJ0.getClass().getName() + " is not supported");
    }

    @Override // g3.a
    public void a() {
        c0(g3.b.BEGIN_ARRAY);
        m0(((com.google.gson.h) j0()).iterator());
        this.f763s[this.f761q - 1] = 0;
    }

    @Override // g3.a
    public void b() {
        c0(g3.b.BEGIN_OBJECT);
        m0(((com.google.gson.n) j0()).o().iterator());
    }

    @Override // g3.a
    public void i() {
        c0(g3.b.END_ARRAY);
        k0();
        k0();
        int i10 = this.f761q;
        if (i10 > 0) {
            int[] iArr = this.f763s;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    @Override // g3.a
    public void j() {
        c0(g3.b.END_OBJECT);
        this.f762r[this.f761q - 1] = null;
        k0();
        k0();
        int i10 = this.f761q;
        if (i10 > 0) {
            int[] iArr = this.f763s;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    public void l0() {
        c0(g3.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) j0()).next();
        m0(entry.getValue());
        m0(new p((String) entry.getKey()));
    }

    @Override // g3.a
    public boolean r() {
        c0(g3.b.BOOLEAN);
        boolean zN = ((p) k0()).n();
        int i10 = this.f761q;
        if (i10 > 0) {
            int[] iArr = this.f763s;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return zN;
    }

    @Override // g3.a
    public String toString() {
        return f.class.getSimpleName() + q();
    }

    @Override // g3.a
    public void x() {
        c0(g3.b.NULL);
        k0();
        int i10 = this.f761q;
        if (i10 > 0) {
            int[] iArr = this.f763s;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    private void c0(g3.b bVar) {
        if (B() == bVar) {
            return;
        }
        throw new IllegalStateException("Expected " + bVar + " but was " + B() + q());
    }

    @Override // g3.a
    public void Z() throws g3.d {
        int i10 = b.f764a[B().ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        k0();
                        int i11 = this.f761q;
                        if (i11 > 0) {
                            int[] iArr = this.f763s;
                            int i12 = i11 - 1;
                            iArr[i12] = iArr[i12] + 1;
                            return;
                        }
                        return;
                    }
                    return;
                }
                j();
                return;
            }
            i();
            return;
        }
        i0(true);
    }

    com.google.gson.k e0() throws g3.d {
        g3.b bVarB = B();
        if (bVarB != g3.b.NAME && bVarB != g3.b.END_ARRAY && bVarB != g3.b.END_OBJECT && bVarB != g3.b.END_DOCUMENT) {
            com.google.gson.k kVar = (com.google.gson.k) j0();
            Z();
            return kVar;
        }
        throw new IllegalStateException("Unexpected " + bVarB + " when reading a JsonElement.");
    }

    @Override // g3.a
    public boolean n() throws g3.d {
        g3.b bVarB = B();
        if (bVarB != g3.b.END_OBJECT && bVarB != g3.b.END_ARRAY && bVarB != g3.b.END_DOCUMENT) {
            return true;
        }
        return false;
    }

    @Override // g3.a
    public double s() throws g3.d {
        g3.b bVarB = B();
        g3.b bVar = g3.b.NUMBER;
        if (bVarB != bVar && bVarB != g3.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarB + q());
        }
        double dO = ((p) j0()).o();
        if (!o() && (Double.isNaN(dO) || Double.isInfinite(dO))) {
            throw new g3.d("JSON forbids NaN and infinities: " + dO);
        }
        k0();
        int i10 = this.f761q;
        if (i10 > 0) {
            int[] iArr = this.f763s;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return dO;
    }

    @Override // g3.a
    public int t() throws g3.d {
        g3.b bVarB = B();
        g3.b bVar = g3.b.NUMBER;
        if (bVarB != bVar && bVarB != g3.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarB + q());
        }
        int iQ = ((p) j0()).q();
        k0();
        int i10 = this.f761q;
        if (i10 > 0) {
            int[] iArr = this.f763s;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return iQ;
    }

    @Override // g3.a
    public long u() throws g3.d {
        g3.b bVarB = B();
        g3.b bVar = g3.b.NUMBER;
        if (bVarB != bVar && bVarB != g3.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarB + q());
        }
        long jR = ((p) j0()).r();
        k0();
        int i10 = this.f761q;
        if (i10 > 0) {
            int[] iArr = this.f763s;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return jR;
    }

    @Override // g3.a
    public String z() throws g3.d {
        g3.b bVarB = B();
        g3.b bVar = g3.b.STRING;
        if (bVarB != bVar && bVarB != g3.b.NUMBER) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarB + q());
        }
        String strT = ((p) k0()).t();
        int i10 = this.f761q;
        if (i10 > 0) {
            int[] iArr = this.f763s;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return strT;
    }
}
