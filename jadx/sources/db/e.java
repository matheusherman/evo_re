package db;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private short f9675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private short f9676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f9677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f9678d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte f9679e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private byte f9680f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private short f9681g;

    public void e(int i10) {
        this.f9681g = (short) i10;
    }

    public void i(short s10) {
        this.f9679e = (byte) s10;
    }

    public void j(short s10) {
        this.f9680f = (byte) s10;
    }

    public String a() {
        return this.f9678d;
    }

    public int b() {
        return this.f9681g & 65535;
    }

    public String c() {
        return this.f9677c;
    }

    public void d(String str) {
        this.f9678d = str;
    }

    public void f(String str) {
        this.f9677c = str;
    }

    public void g(short s10) {
        this.f9675a = s10;
    }

    public void h(short s10) {
        this.f9676b = s10;
    }
}
