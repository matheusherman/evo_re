package ve;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f19917b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f19916a = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f19918c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f19919d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f19920e = false;

    public g() {
        g(new byte[0]);
    }

    public static void l(int i10) {
        if (i10 < 0 || i10 > 2) {
            throw new IllegalArgumentException();
        }
    }

    protected void a() {
        if (!this.f19916a) {
            throw new IllegalStateException();
        }
    }

    public byte[] b() {
        return this.f19917b;
    }

    public int c() {
        return this.f19918c;
    }

    public boolean d() {
        return this.f19920e;
    }

    public boolean e() {
        return this.f19919d;
    }

    protected void f(boolean z10) {
        this.f19920e = z10;
    }

    public String toString() {
        return new String(this.f19917b);
    }

    public void g(byte[] bArr) {
        a();
        bArr.getClass();
        this.f19917b = bArr;
    }

    public void h(int i10) {
        a();
        l(i10);
        this.f19918c = i10;
    }

    public void j(boolean z10) {
        a();
        this.f19919d = z10;
    }

    public g(byte[] bArr) {
        g(bArr);
    }
}
