package e7;

import v6.c;
import x6.g;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f9889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f9890d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f9891e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f9892f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private g f9893g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private v6.a f9894h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private c f9895i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f9896j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f9897k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f9898l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f9899m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f9900n;

    public String b() {
        return this.f9890d;
    }

    public v6.a c() {
        return this.f9894h;
    }

    public String d() {
        return this.f9888b;
    }

    public int e() {
        return this.f9897k;
    }

    public String f() {
        return this.f9896j;
    }

    public int g() {
        return this.f9898l;
    }

    public c h() {
        return this.f9895i;
    }

    public long i() {
        return this.f9900n;
    }

    public long j() {
        return this.f9899m;
    }

    public String k() {
        return this.f9892f;
    }

    public g l() {
        return this.f9893g;
    }

    public String m() {
        return this.f9891e;
    }

    public String n() {
        return this.f9889c;
    }

    public String o() {
        return this.f9887a;
    }

    public void p(int i10) {
        this.f9897k = i10;
    }

    public void q(String str) {
        this.f9896j = str;
    }

    public void r(int i10) {
        this.f9898l = i10;
    }

    public void s(long j10) {
        this.f9900n = j10;
    }

    public void t(String str) {
        this.f9892f = str;
    }

    public void u(String str) {
        this.f9889c = str;
    }

    public a(String str, String str2, String str3, String str4, String str5, v6.a aVar, c cVar, g gVar) {
        this.f9887a = str;
        this.f9888b = str2;
        this.f9889c = str3;
        this.f9891e = str4;
        this.f9890d = str5;
        this.f9895i = cVar;
        this.f9894h = aVar;
        this.f9893g = gVar;
        this.f9899m = a(cVar, str, str2);
    }

    private long a(c cVar, String str, String str2) {
        return (((long) (str2 + ((int) cVar.f())).hashCode()) & 4294967295L) | ((((long) str.hashCode()) << 32) & (-4294967296L));
    }
}
