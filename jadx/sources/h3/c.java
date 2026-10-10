package h3;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f10763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private p3.b f10764b;

    public p3.b a() {
        if (this.f10764b == null) {
            this.f10764b = this.f10763a.b();
        }
        return this.f10764b;
    }

    public p3.a b(int i10, p3.a aVar) {
        return this.f10763a.c(i10, aVar);
    }

    public int c() {
        return this.f10763a.d();
    }

    public int d() {
        return this.f10763a.f();
    }

    public boolean e() {
        return this.f10763a.e().f();
    }

    public c f() {
        return new c(this.f10763a.a(this.f10763a.e().g()));
    }

    public c(b bVar) {
        if (bVar != null) {
            this.f10763a = bVar;
            return;
        }
        throw new IllegalArgumentException("Binarizer must be non-null.");
    }

    public String toString() {
        try {
            return a().toString();
        } catch (m unused) {
            return "";
        }
    }
}
