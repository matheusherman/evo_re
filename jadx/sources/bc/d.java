package bc;

import ac.h;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.log4j.spi.Configurator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class d implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f1057a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f1058b = new c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f1059c = new e();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f1060d = new f();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f1061e = new g();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f1062f = new C0032d();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f1063g = new b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ThreadLocal<WeakHashMap<Object, Object>> f1064h = new ThreadLocal<>();
    private static final long serialVersionUID = -2587890625525655916L;
    private boolean useFieldNames = true;
    private boolean useClassName = true;
    private boolean useShortClassName = false;
    private boolean useIdentityHashCode = true;
    private String contentStart = "[";
    private String contentEnd = "]";
    private String fieldNameValueSeparator = "=";
    private boolean fieldSeparatorAtStart = false;
    private boolean fieldSeparatorAtEnd = false;
    private String fieldSeparator = ",";
    private String arrayStart = "{";
    private String arraySeparator = ",";
    private boolean arrayContentDetail = true;
    private String arrayEnd = "}";
    private boolean defaultFullDetail = true;
    private String nullText = "<null>";
    private String sizeStartText = "<size=";
    private String sizeEndText = ">";
    private String summaryObjectStartText = "<";
    private String summaryObjectEndText = ">";

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class a extends d {
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return d.f1057a;
        }

        a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class b extends d {
        private static final long serialVersionUID = 1;
        private String FIELD_NAME_PREFIX = "\"";

        private Object readResolve() {
            return d.f1063g;
        }

        private void s0(StringBuffer stringBuffer, String str) {
            stringBuffer.append("\"" + str + "\"");
        }

        @Override // bc.d
        protected void C(StringBuffer stringBuffer, String str) {
            if (str == null) {
                throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
            }
            super.C(stringBuffer, this.FIELD_NAME_PREFIX + str + this.FIELD_NAME_PREFIX);
        }

        @Override // bc.d
        public void a(StringBuffer stringBuffer, String str, Object obj, Boolean bool) {
            if (str == null) {
                throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
            }
            if (!V(bool)) {
                throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
            }
            super.a(stringBuffer, str, obj, bool);
        }

        @Override // bc.d
        protected void l(StringBuffer stringBuffer, String str, Object obj) {
            if (obj == null) {
                F(stringBuffer, str);
            } else if (obj.getClass() == String.class) {
                s0(stringBuffer, (String) obj);
            } else {
                stringBuffer.append(obj);
            }
        }

        b() {
            n0(false);
            p0(false);
            e0("{");
            d0("}");
            c0("[");
            b0("]");
            g0(",");
            f0(":");
            i0(Configurator.NULL);
            m0("\"<");
            l0(">\"");
            k0("\"<size=");
            j0(">\"");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class c extends d {
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return d.f1058b;
        }

        c() {
            e0("[");
            StringBuilder sb2 = new StringBuilder();
            String str = h.G;
            sb2.append(str);
            sb2.append("  ");
            g0(sb2.toString());
            h0(true);
            d0(str + "]");
        }
    }

    /* JADX INFO: renamed from: bc.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class C0032d extends d {
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return d.f1062f;
        }

        C0032d() {
            n0(false);
            p0(false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class e extends d {
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return d.f1059c;
        }

        e() {
            o0(false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class f extends d {
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return d.f1060d;
        }

        f() {
            q0(true);
            p0(false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class g extends d {
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return d.f1061e;
        }

        g() {
            n0(false);
            p0(false);
            o0(false);
            e0("");
            d0("");
        }
    }

    protected void I(StringBuffer stringBuffer, String str, byte[] bArr) {
        R(stringBuffer, str, bArr.length);
    }

    protected void J(StringBuffer stringBuffer, String str, char[] cArr) {
        R(stringBuffer, str, cArr.length);
    }

    protected void K(StringBuffer stringBuffer, String str, double[] dArr) {
        R(stringBuffer, str, dArr.length);
    }

    protected void L(StringBuffer stringBuffer, String str, float[] fArr) {
        R(stringBuffer, str, fArr.length);
    }

    protected void M(StringBuffer stringBuffer, String str, int[] iArr) {
        R(stringBuffer, str, iArr.length);
    }

    protected void N(StringBuffer stringBuffer, String str, long[] jArr) {
        R(stringBuffer, str, jArr.length);
    }

    protected void O(StringBuffer stringBuffer, String str, Object[] objArr) {
        R(stringBuffer, str, objArr.length);
    }

    protected void P(StringBuffer stringBuffer, String str, short[] sArr) {
        R(stringBuffer, str, sArr.length);
    }

    protected void Q(StringBuffer stringBuffer, String str, boolean[] zArr) {
        R(stringBuffer, str, zArr.length);
    }

    static Map<Object, Object> T() {
        return f1064h.get();
    }

    static void Z(Object obj) {
        if (obj != null) {
            if (T() == null) {
                f1064h.set(new WeakHashMap<>());
            }
            T().put(obj, null);
        }
    }

    static void r0(Object obj) {
        Map<Object, Object> mapT;
        if (obj == null || (mapT = T()) == null) {
            return;
        }
        mapT.remove(obj);
        if (mapT.isEmpty()) {
            f1064h.remove();
        }
    }

    protected void B(StringBuffer stringBuffer) {
        stringBuffer.append(this.fieldSeparator);
    }

    protected void C(StringBuffer stringBuffer, String str) {
        if (!this.useFieldNames || str == null) {
            return;
        }
        stringBuffer.append(str);
        stringBuffer.append(this.fieldNameValueSeparator);
    }

    protected void F(StringBuffer stringBuffer, String str) {
        stringBuffer.append(this.nullText);
    }

    public void G(StringBuffer stringBuffer, Object obj) {
        if (obj != null) {
            b(stringBuffer, obj);
            D(stringBuffer, obj);
            d(stringBuffer);
            if (this.fieldSeparatorAtStart) {
                B(stringBuffer);
            }
        }
    }

    protected void H(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(this.summaryObjectStartText);
        stringBuffer.append(U(obj.getClass()));
        stringBuffer.append(this.summaryObjectEndText);
    }

    protected void R(StringBuffer stringBuffer, String str, int i10) {
        stringBuffer.append(this.sizeStartText);
        stringBuffer.append(i10);
        stringBuffer.append(this.sizeEndText);
    }

    protected String S() {
        return this.nullText;
    }

    protected boolean V(Boolean bool) {
        return bool == null ? this.defaultFullDetail : bool.booleanValue();
    }

    protected boolean X() {
        return this.useIdentityHashCode;
    }

    protected void Y(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(this.arrayStart);
        int length = Array.getLength(obj);
        for (int i10 = 0; i10 < length; i10++) {
            Object obj2 = Array.get(obj, i10);
            if (i10 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            if (obj2 == null) {
                F(stringBuffer, str);
            } else {
                E(stringBuffer, str, obj2, this.arrayContentDetail);
            }
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void b(StringBuffer stringBuffer, Object obj) {
        if (!this.useClassName || obj == null) {
            return;
        }
        Z(obj);
        if (this.useShortClassName) {
            stringBuffer.append(U(obj.getClass()));
        } else {
            stringBuffer.append(obj.getClass().getName());
        }
    }

    protected void b0(String str) {
        if (str == null) {
            str = "";
        }
        this.arrayEnd = str;
    }

    protected void c(StringBuffer stringBuffer) {
        stringBuffer.append(this.contentEnd);
    }

    protected void c0(String str) {
        if (str == null) {
            str = "";
        }
        this.arrayStart = str;
    }

    protected void d(StringBuffer stringBuffer) {
        stringBuffer.append(this.contentStart);
    }

    protected void d0(String str) {
        if (str == null) {
            str = "";
        }
        this.contentEnd = str;
    }

    protected void e0(String str) {
        if (str == null) {
            str = "";
        }
        this.contentStart = str;
    }

    protected void f0(String str) {
        if (str == null) {
            str = "";
        }
        this.fieldNameValueSeparator = str;
    }

    protected void g0(String str) {
        if (str == null) {
            str = "";
        }
        this.fieldSeparator = str;
    }

    protected void h0(boolean z10) {
        this.fieldSeparatorAtStart = z10;
    }

    protected void i0(String str) {
        if (str == null) {
            str = "";
        }
        this.nullText = str;
    }

    protected void j0(String str) {
        if (str == null) {
            str = "";
        }
        this.sizeEndText = str;
    }

    protected void k0(String str) {
        if (str == null) {
            str = "";
        }
        this.sizeStartText = str;
    }

    protected void l0(String str) {
        if (str == null) {
            str = "";
        }
        this.summaryObjectEndText = str;
    }

    protected void m0(String str) {
        if (str == null) {
            str = "";
        }
        this.summaryObjectStartText = str;
    }

    protected void n0(boolean z10) {
        this.useClassName = z10;
    }

    protected void o0(boolean z10) {
        this.useFieldNames = z10;
    }

    protected void p0(boolean z10) {
        this.useIdentityHashCode = z10;
    }

    protected void q(StringBuffer stringBuffer, String str, byte[] bArr) {
        stringBuffer.append(this.arrayStart);
        for (int i10 = 0; i10 < bArr.length; i10++) {
            if (i10 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            f(stringBuffer, str, bArr[i10]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void q0(boolean z10) {
        this.useShortClassName = z10;
    }

    protected void r(StringBuffer stringBuffer, String str, char[] cArr) {
        stringBuffer.append(this.arrayStart);
        for (int i10 = 0; i10 < cArr.length; i10++) {
            if (i10 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            g(stringBuffer, str, cArr[i10]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void s(StringBuffer stringBuffer, String str, double[] dArr) {
        stringBuffer.append(this.arrayStart);
        for (int i10 = 0; i10 < dArr.length; i10++) {
            if (i10 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            h(stringBuffer, str, dArr[i10]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void t(StringBuffer stringBuffer, String str, float[] fArr) {
        stringBuffer.append(this.arrayStart);
        for (int i10 = 0; i10 < fArr.length; i10++) {
            if (i10 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            i(stringBuffer, str, fArr[i10]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void u(StringBuffer stringBuffer, String str, int[] iArr) {
        stringBuffer.append(this.arrayStart);
        for (int i10 = 0; i10 < iArr.length; i10++) {
            if (i10 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            j(stringBuffer, str, iArr[i10]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void v(StringBuffer stringBuffer, String str, long[] jArr) {
        stringBuffer.append(this.arrayStart);
        for (int i10 = 0; i10 < jArr.length; i10++) {
            if (i10 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            k(stringBuffer, str, jArr[i10]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void w(StringBuffer stringBuffer, String str, Object[] objArr) {
        stringBuffer.append(this.arrayStart);
        for (int i10 = 0; i10 < objArr.length; i10++) {
            Object obj = objArr[i10];
            if (i10 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            if (obj == null) {
                F(stringBuffer, str);
            } else {
                E(stringBuffer, str, obj, this.arrayContentDetail);
            }
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void x(StringBuffer stringBuffer, String str, short[] sArr) {
        stringBuffer.append(this.arrayStart);
        for (int i10 = 0; i10 < sArr.length; i10++) {
            if (i10 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            o(stringBuffer, str, sArr[i10]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void y(StringBuffer stringBuffer, String str, boolean[] zArr) {
        stringBuffer.append(this.arrayStart);
        for (int i10 = 0; i10 < zArr.length; i10++) {
            if (i10 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            p(stringBuffer, str, zArr[i10]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void z(StringBuffer stringBuffer, Object obj) {
        if (!this.fieldSeparatorAtEnd) {
            a0(stringBuffer);
        }
        c(stringBuffer);
        r0(obj);
    }

    protected d() {
    }

    static boolean W(Object obj) {
        Map<Object, Object> mapT = T();
        if (mapT != null && mapT.containsKey(obj)) {
            return true;
        }
        return false;
    }

    protected void A(StringBuffer stringBuffer, String str) {
        B(stringBuffer);
    }

    protected void D(StringBuffer stringBuffer, Object obj) {
        if (X() && obj != null) {
            Z(obj);
            stringBuffer.append('@');
            stringBuffer.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    protected void E(StringBuffer stringBuffer, String str, Object obj, boolean z10) {
        if (W(obj) && !(obj instanceof Number) && !(obj instanceof Boolean) && !(obj instanceof Character)) {
            e(stringBuffer, str, obj);
            return;
        }
        Z(obj);
        try {
            if (obj instanceof Collection) {
                if (z10) {
                    m(stringBuffer, str, (Collection) obj);
                } else {
                    R(stringBuffer, str, ((Collection) obj).size());
                }
            } else if (obj instanceof Map) {
                if (z10) {
                    n(stringBuffer, str, (Map) obj);
                } else {
                    R(stringBuffer, str, ((Map) obj).size());
                }
            } else if (obj instanceof long[]) {
                if (z10) {
                    v(stringBuffer, str, (long[]) obj);
                } else {
                    N(stringBuffer, str, (long[]) obj);
                }
            } else if (obj instanceof int[]) {
                if (z10) {
                    u(stringBuffer, str, (int[]) obj);
                } else {
                    M(stringBuffer, str, (int[]) obj);
                }
            } else if (obj instanceof short[]) {
                if (z10) {
                    x(stringBuffer, str, (short[]) obj);
                } else {
                    P(stringBuffer, str, (short[]) obj);
                }
            } else if (obj instanceof byte[]) {
                if (z10) {
                    q(stringBuffer, str, (byte[]) obj);
                } else {
                    I(stringBuffer, str, (byte[]) obj);
                }
            } else if (obj instanceof char[]) {
                if (z10) {
                    r(stringBuffer, str, (char[]) obj);
                } else {
                    J(stringBuffer, str, (char[]) obj);
                }
            } else if (obj instanceof double[]) {
                if (z10) {
                    s(stringBuffer, str, (double[]) obj);
                } else {
                    K(stringBuffer, str, (double[]) obj);
                }
            } else if (obj instanceof float[]) {
                if (z10) {
                    t(stringBuffer, str, (float[]) obj);
                } else {
                    L(stringBuffer, str, (float[]) obj);
                }
            } else if (obj instanceof boolean[]) {
                if (z10) {
                    y(stringBuffer, str, (boolean[]) obj);
                } else {
                    Q(stringBuffer, str, (boolean[]) obj);
                }
            } else if (obj.getClass().isArray()) {
                if (z10) {
                    w(stringBuffer, str, (Object[]) obj);
                } else {
                    O(stringBuffer, str, (Object[]) obj);
                }
            } else if (z10) {
                l(stringBuffer, str, obj);
            } else {
                H(stringBuffer, str, obj);
            }
        } finally {
            r0(obj);
        }
    }

    protected String U(Class<?> cls) {
        return ac.c.a(cls);
    }

    public void a(StringBuffer stringBuffer, String str, Object obj, Boolean bool) {
        C(stringBuffer, str);
        if (obj == null) {
            F(stringBuffer, str);
        } else {
            E(stringBuffer, str, obj, V(bool));
        }
        A(stringBuffer, str);
    }

    protected void a0(StringBuffer stringBuffer) {
        int length = stringBuffer.length();
        int length2 = this.fieldSeparator.length();
        if (length > 0 && length2 > 0 && length >= length2) {
            for (int i10 = 0; i10 < length2; i10++) {
                if (stringBuffer.charAt((length - 1) - i10) != this.fieldSeparator.charAt((length2 - 1) - i10)) {
                    return;
                }
            }
            stringBuffer.setLength(length - length2);
        }
    }

    protected void e(StringBuffer stringBuffer, String str, Object obj) {
        ac.e.b(stringBuffer, obj);
    }

    protected void f(StringBuffer stringBuffer, String str, byte b10) {
        stringBuffer.append((int) b10);
    }

    protected void g(StringBuffer stringBuffer, String str, char c10) {
        stringBuffer.append(c10);
    }

    protected void h(StringBuffer stringBuffer, String str, double d10) {
        stringBuffer.append(d10);
    }

    protected void i(StringBuffer stringBuffer, String str, float f10) {
        stringBuffer.append(f10);
    }

    protected void j(StringBuffer stringBuffer, String str, int i10) {
        stringBuffer.append(i10);
    }

    protected void k(StringBuffer stringBuffer, String str, long j10) {
        stringBuffer.append(j10);
    }

    protected void l(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(obj);
    }

    protected void m(StringBuffer stringBuffer, String str, Collection<?> collection) {
        stringBuffer.append(collection);
    }

    protected void n(StringBuffer stringBuffer, String str, Map<?, ?> map) {
        stringBuffer.append(map);
    }

    protected void o(StringBuffer stringBuffer, String str, short s10) {
        stringBuffer.append((int) s10);
    }

    protected void p(StringBuffer stringBuffer, String str, boolean z10) {
        stringBuffer.append(z10);
    }
}
