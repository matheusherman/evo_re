package dc;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Long f9726a = 0L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Long f9727b = 1L;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Long f9728c = -1L;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Integer f9729d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Integer f9730e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Integer f9731f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Short f9732g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Short f9733h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Short f9734i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Byte f9735j = (byte) 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Byte f9736k = (byte) 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Byte f9737l = (byte) -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Double f9738m = Double.valueOf(0.0d);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Double f9739n = Double.valueOf(1.0d);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Double f9740o = Double.valueOf(-1.0d);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Float f9741p = Float.valueOf(0.0f);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Float f9742q = Float.valueOf(1.0f);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Float f9743r = Float.valueOf(-1.0f);

    public static double a(String str) {
        return b(str, 0.0d);
    }

    public static double b(String str, double d10) {
        if (str == null) {
            return d10;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return d10;
        }
    }

    public static long c(String str) {
        return d(str, 0L);
    }

    public static long d(String str, long j10) {
        if (str == null) {
            return j10;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j10;
        }
    }
}
