package eb;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9929b;

    public String a() {
        return this.f9929b;
    }

    public String b() {
        return this.f9928a;
    }

    public void c(String str) {
        this.f9929b = str;
    }

    public void d(String str) {
        this.f9928a = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("</");
        String str = this.f9928a;
        if (str != null) {
            sb2.append(str);
            sb2.append(":");
        }
        sb2.append(this.f9929b);
        sb2.append('>');
        return sb2.toString();
    }
}
