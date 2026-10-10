package tf;

import com.google.android.material.timepicker.TimeModel;
import java.util.Locale;
import x1.f1.lb.util.d1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f19220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f19221c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f19222d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f19223e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f19224f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f19219a = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f19225g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f19226h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f19227i = d1.c();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f19228j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f19229k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f19230l = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f19231m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f19232n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f19233o = true;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f19234p = 0;

    public long a() {
        return this.f19227i;
    }

    public String b() {
        return this.f19226h;
    }

    public String c() {
        return this.f19222d;
    }

    public int d() {
        return this.f19220b;
    }

    public String e() {
        return this.f19219a;
    }

    public long f() {
        return this.f19234p;
    }

    public int g() {
        return this.f19232n;
    }

    public String h() {
        return this.f19225g;
    }

    public int i() {
        return this.f19230l;
    }

    public long j() {
        return this.f19228j;
    }

    public int k() {
        return this.f19231m;
    }

    public long l() {
        return this.f19229k;
    }

    public boolean m() {
        return this.f19233o;
    }

    public void n(int i10) {
        this.f19220b = i10;
    }

    public void o(boolean z10) {
        this.f19233o = z10;
    }

    public void p(String str) {
        this.f19219a = str;
    }

    public void q(long j10) {
        this.f19234p = j10;
    }

    public void r(int i10) {
        this.f19232n = i10;
    }

    public void s(String str) {
        this.f19225g = str;
    }

    public void t(int i10) {
        this.f19230l = i10;
    }

    public void u(long j10) {
        this.f19228j = j10;
    }

    public void v(int i10) {
        this.f19231m = i10;
    }

    public void w(long j10) {
        this.f19229k = j10;
    }

    public b(String str, Long l10, int i10) {
        String str2;
        long jLongValue;
        this.f19221c = "";
        this.f19222d = "";
        this.f19223e = 0;
        this.f19224f = 0L;
        this.f19221c = str;
        if (l10 == null) {
            str2 = String.format(Locale.ENGLISH, TimeModel.NUMBER_FORMAT, Integer.valueOf(i10));
        } else {
            str2 = String.format(Locale.ENGLISH, "%d-%d", Integer.valueOf(i10), l10);
        }
        this.f19222d = str2;
        if (l10 == null) {
            jLongValue = i10;
        } else {
            jLongValue = l10.longValue();
        }
        this.f19224f = jLongValue;
        this.f19223e = i10;
    }
}
