package p3;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List<CharsetEncoder> f17298c = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CharsetEncoder[] f17299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f17300b;

    static {
        String[] strArr = {"IBM437", "ISO-8859-2", "ISO-8859-3", "ISO-8859-4", "ISO-8859-5", "ISO-8859-6", "ISO-8859-7", "ISO-8859-8", "ISO-8859-9", "ISO-8859-10", "ISO-8859-11", "ISO-8859-13", "ISO-8859-14", "ISO-8859-15", "ISO-8859-16", "windows-1250", "windows-1251", "windows-1252", "windows-1256", "Shift_JIS"};
        for (int i10 = 0; i10 < 20; i10++) {
            String str = strArr[i10];
            if (d.i(str) != null) {
                try {
                    f17298c.add(Charset.forName(str).newEncoder());
                } catch (UnsupportedCharsetException unused) {
                }
            }
        }
    }

    public boolean a(char c10, int i10) {
        return this.f17299a[i10].canEncode("" + c10);
    }

    public byte[] b(char c10, int i10) {
        return ("" + c10).getBytes(this.f17299a[i10].charset());
    }

    public byte[] c(String str, int i10) {
        return str.getBytes(this.f17299a[i10].charset());
    }

    public Charset d(int i10) {
        return this.f17299a[i10].charset();
    }

    public int e(int i10) {
        return d.f(this.f17299a[i10].charset()).l();
    }

    public int f() {
        return this.f17300b;
    }

    public int g() {
        return this.f17299a.length;
    }

    public h(String str, Charset charset, int i10) {
        boolean z10;
        boolean z11;
        ArrayList arrayList = new ArrayList();
        arrayList.add(StandardCharsets.ISO_8859_1.newEncoder());
        int i11 = 0;
        if (charset != null && charset.name().startsWith("UTF")) {
            z10 = true;
        } else {
            z10 = false;
        }
        for (int i12 = 0; i12 < str.length(); i12++) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    CharsetEncoder charsetEncoder = (CharsetEncoder) it.next();
                    char cCharAt = str.charAt(i12);
                    if (cCharAt == i10 || charsetEncoder.canEncode(cCharAt)) {
                        z11 = true;
                        break;
                    }
                } else {
                    z11 = false;
                    break;
                }
            }
            if (!z11) {
                for (CharsetEncoder charsetEncoder2 : f17298c) {
                    if (charsetEncoder2.canEncode(str.charAt(i12))) {
                        arrayList.add(charsetEncoder2);
                        z11 = true;
                        break;
                    }
                }
            }
            if (!z11) {
                z10 = true;
            }
        }
        if (arrayList.size() == 1 && !z10) {
            this.f17299a = new CharsetEncoder[]{(CharsetEncoder) arrayList.get(0)};
        } else {
            this.f17299a = new CharsetEncoder[arrayList.size() + 2];
            Iterator it2 = arrayList.iterator();
            int i13 = 0;
            while (it2.hasNext()) {
                this.f17299a[i13] = (CharsetEncoder) it2.next();
                i13++;
            }
            this.f17299a[i13] = StandardCharsets.UTF_8.newEncoder();
            this.f17299a[i13 + 1] = StandardCharsets.UTF_16BE.newEncoder();
        }
        if (charset != null) {
            while (true) {
                CharsetEncoder[] charsetEncoderArr = this.f17299a;
                if (i11 >= charsetEncoderArr.length) {
                    break;
                } else if (charsetEncoderArr[i11] == null || !charset.name().equals(this.f17299a[i11].charset().name())) {
                    i11++;
                }
            }
            i11 = -1;
        } else {
            i11 = -1;
        }
        this.f17300b = i11;
    }
}
