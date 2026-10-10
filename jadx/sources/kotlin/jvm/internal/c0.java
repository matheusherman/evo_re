package kotlin.jvm.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final d0 f12333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final i9.d[] f12334b;

    static {
        d0 d0Var = null;
        try {
            d0Var = (d0) kotlin.reflect.jvm.internal.i0.class.newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (d0Var == null) {
            d0Var = new d0();
        }
        f12333a = d0Var;
        f12334b = new i9.d[0];
    }

    public static i9.g a(j jVar) {
        return f12333a.a(jVar);
    }

    public static i9.d b(Class cls) {
        return f12333a.b(cls);
    }

    public static i9.f c(Class cls) {
        return f12333a.c(cls, "");
    }

    public static i9.f d(Class cls, String str) {
        return f12333a.c(cls, str);
    }

    public static i9.i e(p pVar) {
        return f12333a.d(pVar);
    }

    public static i9.l f(t tVar) {
        return f12333a.e(tVar);
    }

    public static i9.m g(v vVar) {
        return f12333a.f(vVar);
    }

    public static String h(i iVar) {
        return f12333a.g(iVar);
    }

    public static String i(o oVar) {
        return f12333a.h(oVar);
    }
}
