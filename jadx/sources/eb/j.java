package eb;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f9934c;

    public b a() {
        return this.f9934c;
    }

    public String b() {
        return this.f9933b;
    }

    public String c() {
        return this.f9932a;
    }

    public void d(b bVar) {
        this.f9934c = bVar;
    }

    public void e(String str) {
        this.f9933b = str;
    }

    public void f(String str) {
        this.f9932a = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('<');
        String str = this.f9932a;
        if (str != null) {
            sb2.append(str);
            sb2.append(":");
        }
        sb2.append(this.f9933b);
        sb2.append('>');
        return sb2.toString();
    }
}
