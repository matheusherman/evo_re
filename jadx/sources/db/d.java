package db;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d extends cb.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f9669d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f9670e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f9671f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f9672g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f9673h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f9674i;

    public d(int i10, long j10) {
        super(512, i10, j10);
    }

    public long d() {
        return fb.h.b(this.f9669d);
    }

    public int e() {
        return this.f9673h;
    }

    public String f() {
        return this.f9670e;
    }

    public int g() {
        return this.f9671f;
    }

    public void l(String str) {
        this.f9670e = str;
    }

    public void h(long j10) {
        this.f9669d = fb.h.e(j10);
    }

    public void i(long j10) {
        this.f9673h = fb.h.a(j10);
    }

    public void j(long j10) {
        this.f9674i = fb.h.a(j10);
    }

    public void k(long j10) {
        this.f9672g = fb.h.a(j10);
    }

    public void m(long j10) {
        this.f9671f = fb.h.a(j10);
    }
}
