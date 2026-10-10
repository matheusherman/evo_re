package db;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long[] f9719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private short f9721c;

    public boolean a(int i10) {
        return i10 < this.f9719a.length;
    }

    public short b() {
        return this.f9721c;
    }

    public String c() {
        return this.f9720b;
    }

    public void d(long[] jArr) {
        this.f9719a = jArr;
    }

    public void e(String str) {
        this.f9720b = str;
    }

    public String toString() {
        return "TypeSpec{name='" + this.f9720b + "', id=" + ((int) this.f9721c) + '}';
    }

    public n(o oVar) {
        this.f9721c = oVar.e();
    }
}
