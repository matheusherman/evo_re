package v4;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static a f19587h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19588a = getClass().getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q6.b f19589b = q6.c.d(a.class);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f19592e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f19593f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<String, Integer> f19594g = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.google.gson.e f19590c = new com.google.gson.f().d().e("yyyy-MM-dd HH:mm:ss").b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Type f19591d = new C0373a(this).d();

    /* JADX INFO: renamed from: v4.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class C0373a extends f3.a<Map<String, String>> {
        C0373a(a aVar) {
        }
    }

    public static a b() {
        if (f19587h == null) {
            f19587h = new a();
        }
        return f19587h;
    }

    public int c() {
        if (this.f19592e <= 0) {
            this.f19592e = 3;
        }
        return this.f19592e;
    }

    public boolean d() {
        return this.f19593f;
    }

    private a() {
    }

    public void a(String str, String str2, Map<String, Object> map, w4.b bVar) {
    }
}
