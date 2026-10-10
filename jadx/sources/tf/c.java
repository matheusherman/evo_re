package tf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class c {
    private long H;
    private long I;
    private long J;
    private long K;
    private int L;
    private int M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private int T;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f19237c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicBoolean f19235a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private v6.c f19236b = v6.c.LIVE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Set<String> f19238d = new LinkedHashSet();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f19239e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ConcurrentSkipListMap<String, b> f19240f = new ConcurrentSkipListMap<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f19241g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f19242h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f19243i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f19244j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f19245k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f19246l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f19247m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f19248n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f19249o = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f19250p = "";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private List<String> f19251q = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f19252r = "";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f19253s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f19254t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f19255u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f19256v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final vf.a f19257w = new vf.a();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f19258x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f19259y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f19260z = 0;
    private int A = 0;
    private int B = 0;
    private int C = 0;
    private int D = 0;
    private int E = 0;
    private int F = 0;
    private int G = 0;
    private String U = "Unknown";
    private String V = "";
    private String W = "";
    private final Map<String, AtomicInteger> X = new HashMap();

    public int A() {
        return this.A;
    }

    public void A0(int i10) {
        this.f19247m = i10;
    }

    public int B() {
        return this.C;
    }

    public void B0(int i10) {
        this.f19241g = i10;
    }

    public int C() {
        return this.E;
    }

    public void C0(long j10) {
        this.f19244j = j10;
    }

    public int D() {
        return this.B;
    }

    public void D0(int i10) {
        this.f19242h = i10;
    }

    public int E() {
        return this.D;
    }

    public void E0(int i10) {
        this.G = i10;
    }

    public int F() {
        return this.F;
    }

    public void F0(int i10) {
        this.f19246l = i10;
    }

    public int G() {
        return this.L;
    }

    public void G0(String str) {
        this.V = str;
    }

    public int H() {
        return this.f19247m;
    }

    public void H0(int i10) {
        this.T = i10;
    }

    public Map<String, AtomicInteger> I() {
        return this.X;
    }

    public void I0(int i10) {
        this.S = i10;
        if (i10 < 1280) {
            this.U = "SD";
            return;
        }
        if (i10 < 1920) {
            this.U = "HD";
            return;
        }
        if (i10 < 2560) {
            this.U = "FHD";
            return;
        }
        if (i10 < 3840) {
            this.U = "QHD";
        } else if (i10 < 7680) {
            this.U = "UHD(4K)";
        } else {
            this.U = "8K+";
        }
    }

    public int J() {
        return this.f19241g;
    }

    public long K() {
        return this.f19244j;
    }

    public int L() {
        return this.f19242h;
    }

    public int M() {
        return this.G;
    }

    public int N() {
        return this.f19246l;
    }

    public String O() {
        return this.V;
    }

    public int P() {
        return this.T;
    }

    public int Q() {
        return this.S;
    }

    public void R(String str) {
        this.W = str;
    }

    public void S(long j10) {
        this.K = j10;
    }

    public void T(int i10) {
        this.O = i10;
    }

    public void U(int i10) {
        this.f19248n = i10;
    }

    public void V(long j10) {
        this.H = j10;
    }

    public void W(int i10) {
        this.f19243i = i10;
    }

    public void X(LinkedHashSet<String> linkedHashSet) {
        this.f19238d = linkedHashSet;
    }

    public void Y(String str) {
        this.f19250p = str;
    }

    public void Z(long j10) {
        this.f19239e = j10;
    }

    public String a() {
        return this.W;
    }

    public void a0(long j10) {
        this.f19256v = j10;
    }

    public long b() {
        return this.K;
    }

    public void b0(long j10) {
        this.f19254t = j10;
    }

    public int c() {
        return this.O;
    }

    public void c0(long j10) {
        this.f19255u = j10;
    }

    public int d() {
        return this.f19248n;
    }

    public void d0(long j10) {
        this.f19249o = j10;
    }

    public long e() {
        return this.H;
    }

    public void e0(String str) {
        this.f19252r = str;
    }

    public int f() {
        return this.f19243i;
    }

    public void f0(long j10) {
        this.f19253s = j10;
    }

    public Set<String> g() {
        return this.f19238d;
    }

    public void g0(int i10) {
        this.Q = i10;
    }

    public String h() {
        return this.f19250p;
    }

    public void h0(long j10) {
        this.I = j10;
    }

    public long i() {
        return this.f19249o;
    }

    public void i0(int i10) {
        this.f19245k = i10;
    }

    public String j() {
        return this.f19252r;
    }

    public void j0(int i10) {
        this.M = i10;
    }

    public int k() {
        return this.Q;
    }

    public void k0(int i10) {
        this.f19237c = i10;
    }

    public long l() {
        return this.I;
    }

    public void l0(long j10) {
        this.J = j10;
    }

    public int m() {
        return this.f19245k;
    }

    public void m0(int i10) {
        this.N = i10;
    }

    public int n() {
        return this.M;
    }

    public void n0(int i10) {
        this.f19258x = i10;
    }

    public vf.a o() {
        return this.f19257w;
    }

    public void o0(v6.c cVar) {
        this.f19236b = cVar;
    }

    public long p() {
        return this.J;
    }

    public void p0(int i10) {
        this.P = i10;
    }

    public int q() {
        return this.N;
    }

    public void q0(int i10) {
        this.R = i10;
    }

    public List<String> r() {
        return this.f19251q;
    }

    public void r0(int i10) {
        this.f19260z = i10;
    }

    public int s() {
        return this.f19258x;
    }

    public void s0(int i10) {
        this.f19259y = i10;
    }

    public v6.c t() {
        return this.f19236b;
    }

    public void t0(int i10) {
        this.A = i10;
    }

    public ConcurrentSkipListMap<String, b> u() {
        return this.f19240f;
    }

    public void u0(int i10) {
        this.C = i10;
    }

    public int v() {
        return this.P;
    }

    public void v0(int i10) {
        this.E = i10;
    }

    public int w() {
        return this.R;
    }

    public void w0(int i10) {
        this.B = i10;
    }

    public String x() {
        return this.U;
    }

    public void x0(int i10) {
        this.D = i10;
    }

    public int y() {
        return this.f19260z;
    }

    public void y0(int i10) {
        this.F = i10;
    }

    public int z() {
        return this.f19259y;
    }

    public void z0(int i10) {
        this.L = i10;
    }
}
