package g3;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;
import org.apache.log4j.spi.Configurator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c implements Closeable, Flushable {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Pattern f10457j = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String[] f10458k = new String[128];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String[] f10459l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Writer f10460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f10461b = new int[32];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f10462c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f10463d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f10464e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f10465f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f10466g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f10467h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f10468i;

    public c i() {
        return f(1, 2, ']');
    }

    public c j() {
        return f(3, 5, '}');
    }

    static {
        for (int i10 = 0; i10 <= 31; i10++) {
            f10458k[i10] = String.format("\\u%04x", Integer.valueOf(i10));
        }
        String[] strArr = f10458k;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f10459l = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    private void M() throws IOException {
        if (this.f10467h != null) {
            a();
            z(this.f10467h);
            this.f10467h = null;
        }
    }

    private static boolean n(Class<? extends Number> cls) {
        return cls == Integer.class || cls == Long.class || cls == Double.class || cls == Float.class || cls == Byte.class || cls == Short.class || cls == BigDecimal.class || cls == BigInteger.class || cls == AtomicInteger.class || cls == AtomicLong.class;
    }

    private void p() throws IOException {
        if (this.f10463d == null) {
            return;
        }
        this.f10460a.write(10);
        int i10 = this.f10462c;
        for (int i11 = 1; i11 < i10; i11++) {
            this.f10460a.write(this.f10463d);
        }
    }

    private int s() {
        int i10 = this.f10462c;
        if (i10 != 0) {
            return this.f10461b[i10 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void t(int i10) {
        int i11 = this.f10462c;
        int[] iArr = this.f10461b;
        if (i11 == iArr.length) {
            this.f10461b = Arrays.copyOf(iArr, i11 * 2);
        }
        int[] iArr2 = this.f10461b;
        int i12 = this.f10462c;
        this.f10462c = i12 + 1;
        iArr2[i12] = i10;
    }

    private void u(int i10) {
        this.f10461b[this.f10462c - 1] = i10;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0034  */
    private void z(String str) throws IOException {
        String str2;
        String[] strArr = this.f10466g ? f10459l : f10458k;
        this.f10460a.write(34);
        int length = str.length();
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            char cCharAt = str.charAt(i11);
            if (cCharAt < 128) {
                str2 = strArr[cCharAt];
                if (str2 != null) {
                    if (i10 < i11) {
                        this.f10460a.write(str, i10, i11 - i10);
                    }
                    this.f10460a.write(str2);
                    i10 = i11 + 1;
                }
            } else {
                if (cCharAt == 8232) {
                    str2 = "\\u2028";
                } else if (cCharAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i10 < i11) {
                    this.f10460a.write(str, i10, i11 - i10);
                }
                this.f10460a.write(str2);
                i10 = i11 + 1;
            }
        }
        if (i10 < length) {
            this.f10460a.write(str, i10, length - i10);
        }
        this.f10460a.write(34);
    }

    public c C(Boolean bool) throws IOException {
        if (bool == null) {
            return q();
        }
        M();
        b();
        this.f10460a.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public c F(Number number) throws IOException {
        if (number == null) {
            return q();
        }
        M();
        String string = number.toString();
        if (!string.equals("-Infinity") && !string.equals("Infinity") && !string.equals("NaN")) {
            Class<?> cls = number.getClass();
            if (!n(cls) && !f10457j.matcher(string).matches()) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + string);
            }
        } else if (!this.f10465f) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + string);
        }
        b();
        this.f10460a.append((CharSequence) string);
        return this;
    }

    public c G(String str) throws IOException {
        if (str == null) {
            return q();
        }
        M();
        b();
        z(str);
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f10460a.close();
        int i10 = this.f10462c;
        if (i10 > 1 || (i10 == 1 && this.f10461b[i10 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f10462c = 0;
    }

    public void flush() throws IOException {
        if (this.f10462c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f10460a.flush();
    }

    public final boolean k() {
        return this.f10468i;
    }

    public final boolean l() {
        return this.f10466g;
    }

    public boolean m() {
        return this.f10465f;
    }

    public c o(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f10467h != null) {
            throw new IllegalStateException();
        }
        if (this.f10462c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f10467h = str;
        return this;
    }

    public c q() throws IOException {
        if (this.f10467h != null) {
            if (!this.f10468i) {
                this.f10467h = null;
                return this;
            }
            M();
        }
        b();
        this.f10460a.write(Configurator.NULL);
        return this;
    }

    public final void v(boolean z10) {
        this.f10466g = z10;
    }

    public final void x(boolean z10) {
        this.f10465f = z10;
    }

    public final void y(boolean z10) {
        this.f10468i = z10;
    }

    public c(Writer writer) {
        t(6);
        this.f10464e = ":";
        this.f10468i = true;
        Objects.requireNonNull(writer, "out == null");
        this.f10460a = writer;
    }

    private void a() throws IOException {
        int iS = s();
        if (iS == 5) {
            this.f10460a.write(44);
        } else if (iS != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        p();
        u(4);
    }

    private void b() throws IOException {
        int iS = s();
        if (iS != 1) {
            if (iS != 2) {
                if (iS != 4) {
                    if (iS != 6) {
                        if (iS == 7) {
                            if (!this.f10465f) {
                                throw new IllegalStateException("JSON must have only one top-level value.");
                            }
                        } else {
                            throw new IllegalStateException("Nesting problem.");
                        }
                    }
                    u(7);
                    return;
                }
                this.f10460a.append((CharSequence) this.f10464e);
                u(5);
                return;
            }
            this.f10460a.append(',');
            p();
            return;
        }
        u(2);
        p();
    }

    private c f(int i10, int i11, char c10) throws IOException {
        int iS = s();
        if (iS != i11 && iS != i10) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f10467h == null) {
            this.f10462c--;
            if (iS == i11) {
                p();
            }
            this.f10460a.write(c10);
            return this;
        }
        throw new IllegalStateException("Dangling name: " + this.f10467h);
    }

    private c r(int i10, char c10) throws IOException {
        b();
        t(i10);
        this.f10460a.write(c10);
        return this;
    }

    public c A(double d10) throws IOException {
        M();
        if (!this.f10465f && (Double.isNaN(d10) || Double.isInfinite(d10))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d10);
        }
        b();
        this.f10460a.append((CharSequence) Double.toString(d10));
        return this;
    }

    public c B(long j10) throws IOException {
        M();
        b();
        this.f10460a.write(Long.toString(j10));
        return this;
    }

    public c J(boolean z10) throws IOException {
        String str;
        M();
        b();
        Writer writer = this.f10460a;
        if (z10) {
            str = "true";
        } else {
            str = "false";
        }
        writer.write(str);
        return this;
    }

    public c c() throws IOException {
        M();
        return r(1, '[');
    }

    public c d() throws IOException {
        M();
        return r(3, '{');
    }

    public final void w(String str) {
        if (str.length() == 0) {
            this.f10463d = null;
            this.f10464e = ":";
        } else {
            this.f10463d = str;
            this.f10464e = ": ";
        }
    }
}
