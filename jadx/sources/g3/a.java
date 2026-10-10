package g3;

import com.google.gson.internal.f;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import org.apache.log4j.helpers.DateLayout;
import org.apache.log4j.spi.Configurator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Reader f10431a;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f10439i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f10440j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f10441k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int[] f10442l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String[] f10444n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int[] f10445o;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f10432b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final char[] f10433c = new char[1024];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10434d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f10435e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f10436f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f10437g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f10438h = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f10443m = 1;

    /* JADX INFO: renamed from: g3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class C0183a extends f {
        @Override // com.google.gson.internal.f
        public void a(a aVar) throws IOException {
            if (aVar instanceof b3.f) {
                ((b3.f) aVar).l0();
                return;
            }
            int iF = aVar.f10438h;
            if (iF == 0) {
                iF = aVar.f();
            }
            if (iF == 13) {
                aVar.f10438h = 9;
                return;
            }
            if (iF == 12) {
                aVar.f10438h = 8;
                return;
            }
            if (iF == 14) {
                aVar.f10438h = 10;
                return;
            }
            throw new IllegalStateException("Expected a name but was " + aVar.B() + aVar.q());
        }

        C0183a() {
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    private String A() throws IOException {
        String string;
        StringBuilder sb2 = null;
        int i10 = 0;
        while (true) {
            int i11 = 0;
            while (true) {
                int i12 = this.f10434d;
                if (i12 + i11 < this.f10435e) {
                    char c10 = this.f10433c[i12 + i11];
                    if (c10 != '\t' && c10 != '\n' && c10 != '\f' && c10 != '\r' && c10 != ' ') {
                        if (c10 != '#') {
                            if (c10 != ',') {
                                if (c10 != '/' && c10 != '=') {
                                    if (c10 != '{' && c10 != '}' && c10 != ':') {
                                        if (c10 != ';') {
                                            switch (c10) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i11++;
                                                    break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        c();
                    }
                    i10 = i11;
                } else if (i11 >= this.f10433c.length) {
                    if (sb2 == null) {
                        sb2 = new StringBuilder(Math.max(i11, 16));
                    }
                    sb2.append(this.f10433c, this.f10434d, i11);
                    this.f10434d += i11;
                    if (!k(1)) {
                    }
                } else if (!k(i11 + 1)) {
                    i10 = i11;
                }
                if (sb2 == null) {
                    string = new String(this.f10433c, this.f10434d, i10);
                } else {
                    sb2.append(this.f10433c, this.f10434d, i10);
                    string = sb2.toString();
                }
                this.f10434d += i10;
                return string;
            }
        }
    }

    private void V() throws IOException {
        do {
            int i10 = 0;
            while (true) {
                int i11 = this.f10434d;
                if (i11 + i10 < this.f10435e) {
                    char c10 = this.f10433c[i11 + i10];
                    if (c10 != '\t' && c10 != '\n' && c10 != '\f' && c10 != '\r' && c10 != ' ') {
                        if (c10 != '#') {
                            if (c10 != ',') {
                                if (c10 != '/' && c10 != '=') {
                                    if (c10 != '{' && c10 != '}' && c10 != ':') {
                                        if (c10 != ';') {
                                            switch (c10) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i10++;
                                                    break;
                                            }
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                        c();
                    }
                    this.f10434d += i10;
                    return;
                }
                this.f10434d = i11 + i10;
            }
        } while (k(1));
    }

    private void d() throws IOException {
        w(true);
        int i10 = this.f10434d;
        this.f10434d = i10 - 1;
        if (i10 + 4 <= this.f10435e || k(5)) {
            int i11 = this.f10434d;
            char[] cArr = this.f10433c;
            if (cArr[i11] == ')' && cArr[i11 + 1] == ']' && cArr[i11 + 2] == '}' && cArr[i11 + 3] == '\'' && cArr[i11 + 4] == '\n') {
                this.f10434d = i11 + 5;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void Z() throws IOException {
        int i10 = 0;
        do {
            int iF = this.f10438h;
            if (iF == 0) {
                iF = f();
            }
            switch (iF) {
                case 1:
                    G(3);
                    i10++;
                    this.f10438h = 0;
                    break;
                case 2:
                    if (i10 == 0) {
                        this.f10444n[this.f10443m - 1] = null;
                    }
                    this.f10443m--;
                    i10--;
                    this.f10438h = 0;
                    break;
                case 3:
                    G(1);
                    i10++;
                    this.f10438h = 0;
                    break;
                case 4:
                    this.f10443m--;
                    i10--;
                    this.f10438h = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case 11:
                case 15:
                default:
                    this.f10438h = 0;
                    break;
                case 8:
                    P('\'');
                    this.f10438h = 0;
                    break;
                case 9:
                    P('\"');
                    this.f10438h = 0;
                    break;
                case 10:
                    V();
                    this.f10438h = 0;
                    break;
                case 12:
                    P('\'');
                    if (i10 == 0) {
                        this.f10444n[this.f10443m - 1] = "<skipped>";
                    }
                    this.f10438h = 0;
                    break;
                case 13:
                    P('\"');
                    if (i10 == 0) {
                        this.f10444n[this.f10443m - 1] = "<skipped>";
                    }
                    this.f10438h = 0;
                    break;
                case 14:
                    V();
                    if (i10 == 0) {
                        this.f10444n[this.f10443m - 1] = "<skipped>";
                    }
                    this.f10438h = 0;
                    break;
                case 16:
                    this.f10434d += this.f10440j;
                    this.f10438h = 0;
                    break;
                case 17:
                    break;
            }
            return;
        } while (i10 > 0);
        int[] iArr = this.f10445o;
        int i11 = this.f10443m - 1;
        iArr[i11] = iArr[i11] + 1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f10438h = 0;
        this.f10442l[0] = 8;
        this.f10443m = 1;
        this.f10431a.close();
    }

    public String getPath() {
        return l(false);
    }

    public String m() {
        return l(true);
    }

    static {
        f.f4891a = new C0183a();
    }

    private int C() {
        String str;
        String str2;
        int i10;
        char c10 = this.f10433c[this.f10434d];
        if (c10 == 't' || c10 == 'T') {
            str = "true";
            str2 = "TRUE";
            i10 = 5;
        } else if (c10 == 'f' || c10 == 'F') {
            str = "false";
            str2 = "FALSE";
            i10 = 6;
        } else {
            if (c10 != 'n' && c10 != 'N') {
                return 0;
            }
            str = Configurator.NULL;
            str2 = DateLayout.NULL_DATE_FORMAT;
            i10 = 7;
        }
        int length = str.length();
        for (int i11 = 1; i11 < length; i11++) {
            if (this.f10434d + i11 >= this.f10435e && !k(i11 + 1)) {
                return 0;
            }
            char c11 = this.f10433c[this.f10434d + i11];
            if (c11 != str.charAt(i11) && c11 != str2.charAt(i11)) {
                return 0;
            }
        }
        if ((this.f10434d + length < this.f10435e || k(length + 1)) && p(this.f10433c[this.f10434d + length])) {
            return 0;
        }
        this.f10434d += length;
        this.f10438h = i10;
        return i10;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x00ea A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:14:0x0036  */
    /* JADX WARN: Code duplicated, block: B:84:0x00d8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:85:0x00da  */
    /* JADX WARN: Code duplicated, block: B:90:0x00e1  */
    private int F() {
        char c10;
        int i10;
        char[] cArr = this.f10433c;
        int i11 = this.f10434d;
        int i12 = this.f10435e;
        int i13 = 0;
        int i14 = 0;
        char c11 = 0;
        boolean z10 = true;
        long j10 = 0;
        boolean z11 = false;
        while (true) {
            if (i11 + i14 != i12) {
                c10 = cArr[i11 + i14];
                i10 = 0;
                if (c10 != '+') {
                    if (c10 != 'E' || c10 == 'e') {
                        if (c11 == 2 && c11 != 4) {
                            return 0;
                        }
                        c11 = 5;
                    } else if (c10 != '-') {
                        if (c10 != '.') {
                            if (c10 < '0' || c10 > '9') {
                                if (!p(c10)) {
                                    break;
                                }
                                return 0;
                            }
                            if (c11 == 1 || c11 == 0) {
                                j10 = -(c10 - '0');
                                c11 = 2;
                            } else if (c11 == 2) {
                                if (j10 == 0) {
                                    return 0;
                                }
                                long j11 = (10 * j10) - ((long) (c10 - '0'));
                                z10 &= j10 > -922337203685477580L || (j10 == -922337203685477580L && j11 < j10);
                                j10 = j11;
                            } else if (c11 == 3) {
                                c11 = 4;
                            } else if (c11 == 5 || c11 == 6) {
                                c11 = 7;
                            }
                        } else {
                            if (c11 != 2) {
                                return 0;
                            }
                            c11 = 3;
                        }
                    } else if (c11 == 0) {
                        c11 = 1;
                        z11 = true;
                    } else if (c11 != 5) {
                        return 0;
                    }
                    i14++;
                    i13 = 0;
                } else if (c11 != 5) {
                    return 0;
                }
                c11 = 6;
                i14++;
                i13 = 0;
            } else {
                if (i14 == cArr.length) {
                    return i13;
                }
                if (!k(i14 + 1)) {
                    i10 = 0;
                    break;
                }
                i11 = this.f10434d;
                i12 = this.f10435e;
                c10 = cArr[i11 + i14];
                i10 = 0;
                if (c10 != '+') {
                    if (c10 != 'E') {
                        if (c11 == 2) {
                        }
                        c11 = 5;
                    } else {
                        if (c11 == 2) {
                        }
                        c11 = 5;
                    }
                    i14++;
                    i13 = 0;
                } else if (c11 != 5) {
                    return 0;
                }
                c11 = 6;
                i14++;
                i13 = 0;
            }
        }
        if (c11 == 2 && z10 && ((j10 != Long.MIN_VALUE || z11) && (j10 != 0 || !z11))) {
            if (!z11) {
                j10 = -j10;
            }
            this.f10439i = j10;
            this.f10434d += i14;
            this.f10438h = 15;
            return 15;
        }
        if (c11 != 2 && c11 != 4 && c11 != 7) {
            return i10;
        }
        this.f10440j = i14;
        this.f10438h = 16;
        return 16;
    }

    private void G(int i10) {
        int i11 = this.f10443m;
        int[] iArr = this.f10442l;
        if (i11 == iArr.length) {
            int i12 = i11 * 2;
            this.f10442l = Arrays.copyOf(iArr, i12);
            this.f10445o = Arrays.copyOf(this.f10445o, i12);
            this.f10444n = (String[]) Arrays.copyOf(this.f10444n, i12);
        }
        int[] iArr2 = this.f10442l;
        int i13 = this.f10443m;
        this.f10443m = i13 + 1;
        iArr2[i13] = i10;
    }

    private char J() throws IOException {
        int i10;
        if (this.f10434d == this.f10435e && !k(1)) {
            throw b0("Unterminated escape sequence");
        }
        char[] cArr = this.f10433c;
        int i11 = this.f10434d;
        int i12 = i11 + 1;
        this.f10434d = i12;
        char c10 = cArr[i11];
        if (c10 == '\n') {
            this.f10436f++;
            this.f10437g = i12;
            return c10;
        }
        if (c10 == '\"' || c10 == '\'' || c10 == '/' || c10 == '\\') {
            return c10;
        }
        if (c10 == 'b') {
            return '\b';
        }
        if (c10 == 'f') {
            return '\f';
        }
        if (c10 == 'n') {
            return '\n';
        }
        if (c10 == 'r') {
            return '\r';
        }
        if (c10 == 't') {
            return '\t';
        }
        if (c10 != 'u') {
            throw b0("Invalid escape sequence");
        }
        if (i11 + 5 > this.f10435e && !k(4)) {
            throw b0("Unterminated escape sequence");
        }
        int i13 = this.f10434d;
        int i14 = i13 + 4;
        char c11 = 0;
        while (i13 < i14) {
            char c12 = this.f10433c[i13];
            char c13 = (char) (c11 << 4);
            if (c12 >= '0' && c12 <= '9') {
                i10 = c12 - '0';
            } else if (c12 >= 'a' && c12 <= 'f') {
                i10 = c12 - 'W';
            } else {
                if (c12 < 'A' || c12 > 'F') {
                    throw new NumberFormatException("\\u" + new String(this.f10433c, this.f10434d, 4));
                }
                i10 = c12 - '7';
            }
            c11 = (char) (c13 + i10);
            i13++;
        }
        this.f10434d += 4;
        return c11;
    }

    private void P(char c10) throws IOException {
        char[] cArr = this.f10433c;
        do {
            int i10 = this.f10434d;
            int i11 = this.f10435e;
            while (i10 < i11) {
                int i12 = i10 + 1;
                char c11 = cArr[i10];
                if (c11 == c10) {
                    this.f10434d = i12;
                    return;
                }
                if (c11 == '\\') {
                    this.f10434d = i12;
                    J();
                    i10 = this.f10434d;
                    i11 = this.f10435e;
                } else {
                    if (c11 == '\n') {
                        this.f10436f++;
                        this.f10437g = i12;
                    }
                    i10 = i12;
                }
            }
            this.f10434d = i10;
        } while (k(1));
        throw b0("Unterminated string");
    }

    private void S() {
        char c10;
        do {
            if (this.f10434d >= this.f10435e && !k(1)) {
                return;
            }
            char[] cArr = this.f10433c;
            int i10 = this.f10434d;
            int i11 = i10 + 1;
            this.f10434d = i11;
            c10 = cArr[i10];
            if (c10 == '\n') {
                this.f10436f++;
                this.f10437g = i11;
                return;
            }
        } while (c10 != '\r');
    }

    private IOException b0(String str) throws d {
        throw new d(str + q());
    }

    private void c() throws IOException {
        if (!this.f10432b) {
            throw b0("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private boolean k(int i10) throws IOException {
        int i11;
        int i12;
        char[] cArr = this.f10433c;
        int i13 = this.f10437g;
        int i14 = this.f10434d;
        this.f10437g = i13 - i14;
        int i15 = this.f10435e;
        if (i15 != i14) {
            int i16 = i15 - i14;
            this.f10435e = i16;
            System.arraycopy(cArr, i14, cArr, 0, i16);
        } else {
            this.f10435e = 0;
        }
        this.f10434d = 0;
        do {
            Reader reader = this.f10431a;
            int i17 = this.f10435e;
            int i18 = reader.read(cArr, i17, cArr.length - i17);
            if (i18 == -1) {
                return false;
            }
            i11 = this.f10435e + i18;
            this.f10435e = i11;
            if (this.f10436f == 0 && (i12 = this.f10437g) == 0 && i11 > 0 && cArr[0] == 65279) {
                this.f10434d++;
                this.f10437g = i12 + 1;
                i10++;
            }
        } while (i11 < i10);
        return true;
    }

    private String l(boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('$');
        int i10 = 0;
        while (true) {
            int i11 = this.f10443m;
            if (i10 >= i11) {
                return sb2.toString();
            }
            int i12 = this.f10442l[i10];
            if (i12 == 1 || i12 == 2) {
                int i13 = this.f10445o[i10];
                if (z10 && i13 > 0 && i10 == i11 - 1) {
                    i13--;
                }
                sb2.append('[');
                sb2.append(i13);
                sb2.append(']');
            } else if (i12 == 3 || i12 == 4 || i12 == 5) {
                sb2.append('.');
                String str = this.f10444n[i10];
                if (str != null) {
                    sb2.append(str);
                }
            }
            i10++;
        }
    }

    private boolean p(char c10) throws IOException {
        if (c10 == '\t' || c10 == '\n' || c10 == '\f' || c10 == '\r' || c10 == ' ') {
            return false;
        }
        if (c10 != '#') {
            if (c10 == ',') {
                return false;
            }
            if (c10 != '/' && c10 != '=') {
                if (c10 == '{' || c10 == '}' || c10 == ':') {
                    return false;
                }
                if (c10 != ';') {
                    switch (c10) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        c();
        return false;
    }

    private int w(boolean z10) throws IOException {
        char[] cArr = this.f10433c;
        int i10 = this.f10434d;
        int i11 = this.f10435e;
        while (true) {
            if (i10 == i11) {
                this.f10434d = i10;
                if (!k(1)) {
                    if (!z10) {
                        return -1;
                    }
                    throw new EOFException("End of input" + q());
                }
                i10 = this.f10434d;
                i11 = this.f10435e;
            }
            int i12 = i10 + 1;
            char c10 = cArr[i10];
            if (c10 == '\n') {
                this.f10436f++;
                this.f10437g = i12;
            } else if (c10 != ' ' && c10 != '\r' && c10 != '\t') {
                if (c10 == '/') {
                    this.f10434d = i12;
                    if (i12 == i11) {
                        this.f10434d = i10;
                        boolean zK = k(2);
                        this.f10434d++;
                        if (!zK) {
                        }
                        return c10;
                    }
                    c();
                    int i13 = this.f10434d;
                    char c11 = cArr[i13];
                    if (c11 == '*') {
                        this.f10434d = i13 + 1;
                        if (!R("*/")) {
                            throw b0("Unterminated comment");
                        }
                        i10 = this.f10434d + 2;
                        i11 = this.f10435e;
                    } else {
                        if (c11 != '/') {
                            return c10;
                        }
                        this.f10434d = i13 + 1;
                        S();
                        i10 = this.f10434d;
                        i11 = this.f10435e;
                    }
                } else {
                    if (c10 != '#') {
                        this.f10434d = i12;
                        return c10;
                    }
                    this.f10434d = i12;
                    c();
                    S();
                    i10 = this.f10434d;
                    i11 = this.f10435e;
                }
            }
            i10 = i12;
        }
    }

    private String y(char c10) throws IOException {
        int i10;
        char[] cArr = this.f10433c;
        StringBuilder sb2 = null;
        do {
            int i11 = this.f10434d;
            int i12 = this.f10435e;
            while (true) {
                int i13 = i12;
                i10 = i11;
                while (true) {
                    if (i11 < i13) {
                        int i14 = i11 + 1;
                        char c11 = cArr[i11];
                        if (c11 == c10) {
                            this.f10434d = i14;
                            int i15 = (i14 - i10) - 1;
                            if (sb2 == null) {
                                return new String(cArr, i10, i15);
                            }
                            sb2.append(cArr, i10, i15);
                            return sb2.toString();
                        }
                        if (c11 == '\\') {
                            this.f10434d = i14;
                            int i16 = i14 - i10;
                            int i17 = i16 - 1;
                            if (sb2 == null) {
                                sb2 = new StringBuilder(Math.max(i16 * 2, 16));
                            }
                            sb2.append(cArr, i10, i17);
                            sb2.append(J());
                            i11 = this.f10434d;
                            i12 = this.f10435e;
                        } else {
                            if (c11 == '\n') {
                                this.f10436f++;
                                this.f10437g = i14;
                            }
                            i11 = i14;
                        }
                    }
                }
            }
            if (sb2 == null) {
                sb2 = new StringBuilder(Math.max((i11 - i10) * 2, 16));
            }
            sb2.append(cArr, i10, i11 - i10);
            this.f10434d = i11;
        } while (k(1));
        throw b0("Unterminated string");
    }

    public b B() throws IOException {
        int iF = this.f10438h;
        if (iF == 0) {
            iF = f();
        }
        switch (iF) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return b.STRING;
            case 12:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case 17:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final void M(boolean z10) {
        this.f10432b = z10;
    }

    public void a() throws IOException {
        int iF = this.f10438h;
        if (iF == 0) {
            iF = f();
        }
        if (iF == 3) {
            G(1);
            this.f10445o[this.f10443m - 1] = 0;
            this.f10438h = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + B() + q());
        }
    }

    public void b() throws IOException {
        int iF = this.f10438h;
        if (iF == 0) {
            iF = f();
        }
        if (iF == 1) {
            G(3);
            this.f10438h = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + B() + q());
        }
    }

    int f() throws IOException {
        int iW;
        int[] iArr = this.f10442l;
        int i10 = this.f10443m;
        int i11 = iArr[i10 - 1];
        if (i11 == 1) {
            iArr[i10 - 1] = 2;
        } else if (i11 == 2) {
            int iW2 = w(true);
            if (iW2 != 44) {
                if (iW2 != 59) {
                    if (iW2 != 93) {
                        throw b0("Unterminated array");
                    }
                    this.f10438h = 4;
                    return 4;
                }
                c();
            }
        } else {
            if (i11 == 3 || i11 == 5) {
                iArr[i10 - 1] = 4;
                if (i11 == 5 && (iW = w(true)) != 44) {
                    if (iW != 59) {
                        if (iW != 125) {
                            throw b0("Unterminated object");
                        }
                        this.f10438h = 2;
                        return 2;
                    }
                    c();
                }
                int iW3 = w(true);
                if (iW3 == 34) {
                    this.f10438h = 13;
                    return 13;
                }
                if (iW3 == 39) {
                    c();
                    this.f10438h = 12;
                    return 12;
                }
                if (iW3 == 125) {
                    if (i11 == 5) {
                        throw b0("Expected name");
                    }
                    this.f10438h = 2;
                    return 2;
                }
                c();
                this.f10434d--;
                if (!p((char) iW3)) {
                    throw b0("Expected name");
                }
                this.f10438h = 14;
                return 14;
            }
            if (i11 == 4) {
                iArr[i10 - 1] = 5;
                int iW4 = w(true);
                if (iW4 != 58) {
                    if (iW4 != 61) {
                        throw b0("Expected ':'");
                    }
                    c();
                    if (this.f10434d < this.f10435e || k(1)) {
                        char[] cArr = this.f10433c;
                        int i12 = this.f10434d;
                        if (cArr[i12] == '>') {
                            this.f10434d = i12 + 1;
                        }
                    }
                }
            } else if (i11 == 6) {
                if (this.f10432b) {
                    d();
                }
                this.f10442l[this.f10443m - 1] = 7;
            } else if (i11 == 7) {
                if (w(false) == -1) {
                    this.f10438h = 17;
                    return 17;
                }
                c();
                this.f10434d--;
            } else if (i11 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iW5 = w(true);
        if (iW5 == 34) {
            this.f10438h = 9;
            return 9;
        }
        if (iW5 == 39) {
            c();
            this.f10438h = 8;
            return 8;
        }
        if (iW5 != 44 && iW5 != 59) {
            if (iW5 == 91) {
                this.f10438h = 3;
                return 3;
            }
            if (iW5 != 93) {
                if (iW5 == 123) {
                    this.f10438h = 1;
                    return 1;
                }
                this.f10434d--;
                int iC = C();
                if (iC != 0) {
                    return iC;
                }
                int iF = F();
                if (iF != 0) {
                    return iF;
                }
                if (!p(this.f10433c[this.f10434d])) {
                    throw b0("Expected value");
                }
                c();
                this.f10438h = 10;
                return 10;
            }
            if (i11 == 1) {
                this.f10438h = 4;
                return 4;
            }
        }
        if (i11 != 1 && i11 != 2) {
            throw b0("Unexpected value");
        }
        c();
        this.f10434d--;
        this.f10438h = 7;
        return 7;
    }

    public void i() throws IOException {
        int iF = this.f10438h;
        if (iF == 0) {
            iF = f();
        }
        if (iF != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + B() + q());
        }
        int i10 = this.f10443m;
        this.f10443m = i10 - 1;
        int[] iArr = this.f10445o;
        int i11 = i10 - 2;
        iArr[i11] = iArr[i11] + 1;
        this.f10438h = 0;
    }

    public void j() throws IOException {
        int iF = this.f10438h;
        if (iF == 0) {
            iF = f();
        }
        if (iF != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + B() + q());
        }
        int i10 = this.f10443m;
        int i11 = i10 - 1;
        this.f10443m = i11;
        this.f10444n[i11] = null;
        int[] iArr = this.f10445o;
        int i12 = i10 - 2;
        iArr[i12] = iArr[i12] + 1;
        this.f10438h = 0;
    }

    public boolean n() throws IOException {
        int iF = this.f10438h;
        if (iF == 0) {
            iF = f();
        }
        return (iF == 2 || iF == 4 || iF == 17) ? false : true;
    }

    public final boolean o() {
        return this.f10432b;
    }

    String q() {
        return " at line " + (this.f10436f + 1) + " column " + ((this.f10434d - this.f10437g) + 1) + " path " + getPath();
    }

    public boolean r() throws IOException {
        int iF = this.f10438h;
        if (iF == 0) {
            iF = f();
        }
        if (iF == 5) {
            this.f10438h = 0;
            int[] iArr = this.f10445o;
            int i10 = this.f10443m - 1;
            iArr[i10] = iArr[i10] + 1;
            return true;
        }
        if (iF == 6) {
            this.f10438h = 0;
            int[] iArr2 = this.f10445o;
            int i11 = this.f10443m - 1;
            iArr2[i11] = iArr2[i11] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + B() + q());
    }

    public double s() throws IOException {
        int iF = this.f10438h;
        if (iF == 0) {
            iF = f();
        }
        if (iF == 15) {
            this.f10438h = 0;
            int[] iArr = this.f10445o;
            int i10 = this.f10443m - 1;
            iArr[i10] = iArr[i10] + 1;
            return this.f10439i;
        }
        if (iF == 16) {
            this.f10441k = new String(this.f10433c, this.f10434d, this.f10440j);
            this.f10434d += this.f10440j;
        } else if (iF == 8 || iF == 9) {
            this.f10441k = y(iF == 8 ? '\'' : '\"');
        } else if (iF == 10) {
            this.f10441k = A();
        } else if (iF != 11) {
            throw new IllegalStateException("Expected a double but was " + B() + q());
        }
        this.f10438h = 11;
        double d10 = Double.parseDouble(this.f10441k);
        if (!this.f10432b && (Double.isNaN(d10) || Double.isInfinite(d10))) {
            throw new d("JSON forbids NaN and infinities: " + d10 + q());
        }
        this.f10441k = null;
        this.f10438h = 0;
        int[] iArr2 = this.f10445o;
        int i11 = this.f10443m - 1;
        iArr2[i11] = iArr2[i11] + 1;
        return d10;
    }

    public int t() throws IOException {
        int iF = this.f10438h;
        if (iF == 0) {
            iF = f();
        }
        if (iF == 15) {
            long j10 = this.f10439i;
            int i10 = (int) j10;
            if (j10 == i10) {
                this.f10438h = 0;
                int[] iArr = this.f10445o;
                int i11 = this.f10443m - 1;
                iArr[i11] = iArr[i11] + 1;
                return i10;
            }
            throw new NumberFormatException("Expected an int but was " + this.f10439i + q());
        }
        if (iF == 16) {
            this.f10441k = new String(this.f10433c, this.f10434d, this.f10440j);
            this.f10434d += this.f10440j;
        } else {
            if (iF != 8 && iF != 9 && iF != 10) {
                throw new IllegalStateException("Expected an int but was " + B() + q());
            }
            if (iF == 10) {
                this.f10441k = A();
            } else {
                this.f10441k = y(iF == 8 ? '\'' : '\"');
            }
            try {
                int i12 = Integer.parseInt(this.f10441k);
                this.f10438h = 0;
                int[] iArr2 = this.f10445o;
                int i13 = this.f10443m - 1;
                iArr2[i13] = iArr2[i13] + 1;
                return i12;
            } catch (NumberFormatException unused) {
            }
        }
        this.f10438h = 11;
        double d10 = Double.parseDouble(this.f10441k);
        int i14 = (int) d10;
        if (i14 != d10) {
            throw new NumberFormatException("Expected an int but was " + this.f10441k + q());
        }
        this.f10441k = null;
        this.f10438h = 0;
        int[] iArr3 = this.f10445o;
        int i15 = this.f10443m - 1;
        iArr3[i15] = iArr3[i15] + 1;
        return i14;
    }

    public String toString() {
        return getClass().getSimpleName() + q();
    }

    public long u() throws IOException {
        int iF = this.f10438h;
        if (iF == 0) {
            iF = f();
        }
        if (iF == 15) {
            this.f10438h = 0;
            int[] iArr = this.f10445o;
            int i10 = this.f10443m - 1;
            iArr[i10] = iArr[i10] + 1;
            return this.f10439i;
        }
        if (iF == 16) {
            this.f10441k = new String(this.f10433c, this.f10434d, this.f10440j);
            this.f10434d += this.f10440j;
        } else {
            if (iF != 8 && iF != 9 && iF != 10) {
                throw new IllegalStateException("Expected a long but was " + B() + q());
            }
            if (iF == 10) {
                this.f10441k = A();
            } else {
                this.f10441k = y(iF == 8 ? '\'' : '\"');
            }
            try {
                long j10 = Long.parseLong(this.f10441k);
                this.f10438h = 0;
                int[] iArr2 = this.f10445o;
                int i11 = this.f10443m - 1;
                iArr2[i11] = iArr2[i11] + 1;
                return j10;
            } catch (NumberFormatException unused) {
            }
        }
        this.f10438h = 11;
        double d10 = Double.parseDouble(this.f10441k);
        long j11 = (long) d10;
        if (j11 != d10) {
            throw new NumberFormatException("Expected a long but was " + this.f10441k + q());
        }
        this.f10441k = null;
        this.f10438h = 0;
        int[] iArr3 = this.f10445o;
        int i12 = this.f10443m - 1;
        iArr3[i12] = iArr3[i12] + 1;
        return j11;
    }

    public String v() throws IOException {
        String strY;
        int iF = this.f10438h;
        if (iF == 0) {
            iF = f();
        }
        if (iF == 14) {
            strY = A();
        } else if (iF == 12) {
            strY = y('\'');
        } else {
            if (iF != 13) {
                throw new IllegalStateException("Expected a name but was " + B() + q());
            }
            strY = y('\"');
        }
        this.f10438h = 0;
        this.f10444n[this.f10443m - 1] = strY;
        return strY;
    }

    public void x() throws IOException {
        int iF = this.f10438h;
        if (iF == 0) {
            iF = f();
        }
        if (iF == 7) {
            this.f10438h = 0;
            int[] iArr = this.f10445o;
            int i10 = this.f10443m - 1;
            iArr[i10] = iArr[i10] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + B() + q());
    }

    public String z() throws IOException {
        String str;
        int iF = this.f10438h;
        if (iF == 0) {
            iF = f();
        }
        if (iF == 10) {
            str = A();
        } else if (iF == 8) {
            str = y('\'');
        } else if (iF == 9) {
            str = y('\"');
        } else if (iF == 11) {
            str = this.f10441k;
            this.f10441k = null;
        } else if (iF == 15) {
            str = Long.toString(this.f10439i);
        } else {
            if (iF != 16) {
                throw new IllegalStateException("Expected a string but was " + B() + q());
            }
            str = new String(this.f10433c, this.f10434d, this.f10440j);
            this.f10434d += this.f10440j;
        }
        this.f10438h = 0;
        int[] iArr = this.f10445o;
        int i10 = this.f10443m - 1;
        iArr[i10] = iArr[i10] + 1;
        return str;
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.f10442l = iArr;
        iArr[0] = 6;
        this.f10444n = new String[32];
        this.f10445o = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.f10431a = reader;
    }

    private boolean R(String str) {
        int length = str.length();
        while (true) {
            if (this.f10434d + length > this.f10435e && !k(length)) {
                return false;
            }
            char[] cArr = this.f10433c;
            int i10 = this.f10434d;
            if (cArr[i10] == '\n') {
                this.f10436f++;
                this.f10437g = i10 + 1;
            } else {
                for (int i11 = 0; i11 < length; i11++) {
                    if (this.f10433c[this.f10434d + i11] == str.charAt(i11)) {
                    }
                }
                return true;
            }
            this.f10434d++;
        }
    }
}
