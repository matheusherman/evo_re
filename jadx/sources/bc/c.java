package bc;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile d f1053d = d.f1057a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StringBuffer f1054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f1055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d f1056c;

    public static d b() {
        return f1053d;
    }

    public c a(String str, Object obj) {
        this.f1056c.a(this.f1054a, str, obj, null);
        return this;
    }

    public Object c() {
        return this.f1055b;
    }

    public StringBuffer d() {
        return this.f1054a;
    }

    public d e() {
        return this.f1056c;
    }

    public c(Object obj, d dVar, StringBuffer stringBuffer) {
        dVar = dVar == null ? b() : dVar;
        stringBuffer = stringBuffer == null ? new StringBuffer(512) : stringBuffer;
        this.f1054a = stringBuffer;
        this.f1056c = dVar;
        this.f1055b = obj;
        dVar.G(stringBuffer, obj);
    }

    public static String f(Object obj, d dVar) {
        return b.q(obj, dVar);
    }

    public String toString() {
        if (c() == null) {
            d().append(e().S());
        } else {
            this.f1056c.z(d(), c());
        }
        return d().toString();
    }
}
