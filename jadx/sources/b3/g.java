package b3;

import com.google.gson.p;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class g extends g3.c {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Writer f765p = new a();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final p f766q = new p("closed");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final List<com.google.gson.k> f767m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f768n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private com.google.gson.k f769o;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends Writer {
        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i10, int i11) {
            throw new AssertionError();
        }

        a() {
        }
    }

    public g() {
        super(f765p);
        this.f767m = new ArrayList();
        this.f769o = com.google.gson.m.f4922a;
    }

    private com.google.gson.k R() {
        List<com.google.gson.k> list = this.f767m;
        return list.get(list.size() - 1);
    }

    private void S(com.google.gson.k kVar) {
        if (this.f768n != null) {
            if (!kVar.i() || k()) {
                ((com.google.gson.n) R()).n(this.f768n, kVar);
            }
            this.f768n = null;
            return;
        }
        if (this.f767m.isEmpty()) {
            this.f769o = kVar;
            return;
        }
        com.google.gson.k kVarR = R();
        if (!(kVarR instanceof com.google.gson.h)) {
            throw new IllegalStateException();
        }
        ((com.google.gson.h) kVarR).n(kVar);
    }

    @Override // g3.c
    public g3.c B(long j10) {
        S(new p(Long.valueOf(j10)));
        return this;
    }

    @Override // g3.c
    public g3.c C(Boolean bool) {
        if (bool == null) {
            return q();
        }
        S(new p(bool));
        return this;
    }

    @Override // g3.c
    public g3.c F(Number number) {
        if (number == null) {
            return q();
        }
        if (!m()) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        S(new p(number));
        return this;
    }

    @Override // g3.c
    public g3.c G(String str) {
        if (str == null) {
            return q();
        }
        S(new p(str));
        return this;
    }

    @Override // g3.c
    public g3.c J(boolean z10) {
        S(new p(Boolean.valueOf(z10)));
        return this;
    }

    public com.google.gson.k P() {
        if (this.f767m.isEmpty()) {
            return this.f769o;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f767m);
    }

    @Override // g3.c
    public g3.c c() {
        com.google.gson.h hVar = new com.google.gson.h();
        S(hVar);
        this.f767m.add(hVar);
        return this;
    }

    @Override // g3.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f767m.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.f767m.add(f766q);
    }

    @Override // g3.c
    public g3.c d() {
        com.google.gson.n nVar = new com.google.gson.n();
        S(nVar);
        this.f767m.add(nVar);
        return this;
    }

    @Override // g3.c
    public g3.c i() {
        if (this.f767m.isEmpty() || this.f768n != null) {
            throw new IllegalStateException();
        }
        if (!(R() instanceof com.google.gson.h)) {
            throw new IllegalStateException();
        }
        List<com.google.gson.k> list = this.f767m;
        list.remove(list.size() - 1);
        return this;
    }

    @Override // g3.c
    public g3.c j() {
        if (this.f767m.isEmpty() || this.f768n != null) {
            throw new IllegalStateException();
        }
        if (!(R() instanceof com.google.gson.n)) {
            throw new IllegalStateException();
        }
        List<com.google.gson.k> list = this.f767m;
        list.remove(list.size() - 1);
        return this;
    }

    @Override // g3.c
    public g3.c o(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f767m.isEmpty() || this.f768n != null) {
            throw new IllegalStateException();
        }
        if (!(R() instanceof com.google.gson.n)) {
            throw new IllegalStateException();
        }
        this.f768n = str;
        return this;
    }

    @Override // g3.c
    public g3.c q() {
        S(com.google.gson.m.f4922a);
        return this;
    }

    @Override // g3.c
    public g3.c A(double d10) {
        if (!m() && (Double.isNaN(d10) || Double.isInfinite(d10))) {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d10);
        }
        S(new p(Double.valueOf(d10)));
        return this;
    }

    @Override // g3.c, java.io.Flushable
    public void flush() {
    }
}
