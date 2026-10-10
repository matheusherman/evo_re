package eb;

import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f9917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private cb.b f9918d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f9919e;

    /* JADX INFO: renamed from: eb.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class C0177a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Map<Integer, String> f9920a = fb.f.a();

        public static String a(long j10) {
            String str = f9920a.get(Integer.valueOf((int) j10));
            if (str != null) {
                return str;
            }
            return "AttrId:0x" + Long.toHexString(j10);
        }
    }

    public String a() {
        return this.f9916b;
    }

    public String b() {
        return this.f9915a;
    }

    public cb.b c() {
        return this.f9918d;
    }

    public String d() {
        return this.f9919e;
    }

    public void e(String str) {
        this.f9916b = str;
    }

    public void f(String str) {
        this.f9915a = str;
    }

    public void g(String str) {
        this.f9917c = str;
    }

    public void h(cb.b bVar) {
        this.f9918d = bVar;
    }

    public void i(String str) {
        this.f9919e = str;
    }

    public String j(db.i iVar, Locale locale) {
        String str = this.f9917c;
        if (str != null) {
            return str;
        }
        cb.b bVar = this.f9918d;
        return bVar != null ? bVar.k(iVar, locale) : "";
    }

    public String toString() {
        return "Attribute{name='" + this.f9916b + "', namespace='" + this.f9915a + "'}";
    }
}
