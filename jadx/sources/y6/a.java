package y6;

import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected a7.a f22398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected k f22399b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected c f22401d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected b f22402e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected String f22404g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected long f22400c = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected boolean f22403f = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected long f22405h = 200;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f22406i = 16;

    public abstract void a(int i10, int i11, String str, int i12, int i13, byte[] bArr, boolean z10);

    public abstract void b(int i10, String str, byte[] bArr);

    public abstract void c(int i10, int i11, String str, int i12, int i13, byte[] bArr, boolean z10);

    public abstract void d(int i10, int i11, String str, byte[] bArr);

    public abstract void e(int i10, String str, int i11, int i12, byte[] bArr);

    public abstract void f(int i10, String str, byte[] bArr);

    public abstract byte[] g(int i10, String str, boolean z10);

    public abstract byte[] h(int i10);

    public abstract byte[] j(int i10, String str);

    public abstract InputStream k();

    public abstract void m(String str, int i10);

    public abstract void n();

    public abstract void o();

    public long i() {
        return this.f22405h;
    }

    public void l(int i10, long j10) {
        this.f22406i = i10;
        if (j10 < 50 || j10 > 500) {
            return;
        }
        this.f22405h = j10;
    }
}
