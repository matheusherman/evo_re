package v3;

import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private m f19540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private h3.f f19541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private h3.f f19542d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final StringBuilder f19543e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f19544f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f19545g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private l f19546h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f19547i;

    public void j() {
        this.f19545g = -1;
    }

    public void k() {
        this.f19546h = null;
    }

    private int h() {
        return this.f19539a.length() - this.f19547i;
    }

    public int a() {
        return this.f19543e.length();
    }

    public StringBuilder b() {
        return this.f19543e;
    }

    public char c() {
        return this.f19539a.charAt(this.f19544f);
    }

    public String d() {
        return this.f19539a;
    }

    public int e() {
        return this.f19545g;
    }

    public l g() {
        return this.f19546h;
    }

    public boolean i() {
        return this.f19544f < h();
    }

    public void l(h3.f fVar, h3.f fVar2) {
        this.f19541c = fVar;
        this.f19542d = fVar2;
    }

    public void m(int i10) {
        this.f19547i = i10;
    }

    public void n(m mVar) {
        this.f19540b = mVar;
    }

    public void o(int i10) {
        this.f19545g = i10;
    }

    public void q(int i10) {
        l lVar = this.f19546h;
        if (lVar == null || i10 > lVar.a()) {
            this.f19546h = l.l(i10, this.f19540b, this.f19541c, this.f19542d, true);
        }
    }

    public void r(char c10) {
        this.f19543e.append(c10);
    }

    public void s(String str) {
        this.f19543e.append(str);
    }

    h(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb2 = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i10 = 0; i10 < length; i10++) {
            char c10 = (char) (bytes[i10] & 255);
            if (c10 == '?' && str.charAt(i10) != '?') {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
            sb2.append(c10);
        }
        this.f19539a = sb2.toString();
        this.f19540b = m.FORCE_NONE;
        this.f19543e = new StringBuilder(str.length());
        this.f19545g = -1;
    }

    public int f() {
        return h() - this.f19544f;
    }

    public void p() {
        q(a());
    }
}
