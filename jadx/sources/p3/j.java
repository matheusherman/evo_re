package p3;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private StringBuilder f17301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private StringBuilder f17302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Charset f17303c;

    public j() {
        this.f17303c = StandardCharsets.ISO_8859_1;
        this.f17301a = new StringBuilder();
    }

    private void g() {
        Charset charset = this.f17303c;
        Charset charset2 = StandardCharsets.ISO_8859_1;
        if (charset.equals(charset2)) {
            if (this.f17301a.length() > 0) {
                StringBuilder sb2 = this.f17302b;
                if (sb2 == null) {
                    this.f17302b = this.f17301a;
                    this.f17301a = new StringBuilder();
                    return;
                } else {
                    sb2.append((CharSequence) this.f17301a);
                    this.f17301a = new StringBuilder();
                    return;
                }
            }
            return;
        }
        if (this.f17301a.length() > 0) {
            byte[] bytes = this.f17301a.toString().getBytes(charset2);
            this.f17301a = new StringBuilder();
            StringBuilder sb3 = this.f17302b;
            if (sb3 == null) {
                this.f17302b = new StringBuilder(new String(bytes, this.f17303c));
            } else {
                sb3.append(new String(bytes, this.f17303c));
            }
        }
    }

    public void a(byte b10) {
        this.f17301a.append((char) (b10 & 255));
    }

    public void b(char c10) {
        this.f17301a.append((char) (c10 & 255));
    }

    public void d(String str) {
        this.f17301a.append(str);
    }

    public boolean h() {
        if (this.f17301a.length() != 0) {
            return false;
        }
        StringBuilder sb2 = this.f17302b;
        return sb2 == null || sb2.length() == 0;
    }

    public void c(int i10) {
        d(String.valueOf(i10));
    }

    public void e(StringBuilder sb2) {
        g();
        this.f17302b.append((CharSequence) sb2);
    }

    public void f(int i10) throws h3.h {
        g();
        d dVarJ = d.j(i10);
        if (dVarJ != null) {
            this.f17303c = dVarJ.k();
            return;
        }
        throw h3.h.a();
    }

    public int i() {
        return toString().length();
    }

    public String toString() {
        g();
        StringBuilder sb2 = this.f17302b;
        if (sb2 == null) {
            return "";
        }
        return sb2.toString();
    }

    public j(int i10) {
        this.f17303c = StandardCharsets.ISO_8859_1;
        this.f17301a = new StringBuilder(i10);
    }
}
