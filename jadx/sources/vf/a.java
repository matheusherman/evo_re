package vf;

import androidx.core.location.LocationRequestCompat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f19926f;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f19943w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f19921a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f19922b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f19923c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f19924d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f19925e = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f19927g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f19928h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f19929i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f19930j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f19931k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f19932l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f19933m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f19934n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f19935o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f19936p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f19937q = LocationRequestCompat.PASSIVE_INTERVAL;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f19938r = Long.MIN_VALUE;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Map<Long, AtomicInteger> f19939s = new HashMap();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Map<Integer, AtomicInteger> f19940t = new HashMap();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f19941u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f19942v = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f19944x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f19945y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f19946z = 0;
    private int A = 0;
    private int B = 0;
    private int C = 0;
    private int D = 0;
    private int E = 0;
    private int F = 0;
    private int G = 0;
    private int H = 0;
    private String I = "";
    private String J = "";
    private String K = "";
    private int L = 0;
    private int M = 0;
    private int N = 0;
    private int O = 0;
    private int P = 0;
    private int Q = 0;
    private int R = 0;
    private int S = 0;
    private Map<String, AtomicInteger> T = new HashMap();
    private Map<Integer, Integer> U = new HashMap();

    public int A() {
        return this.f19943w;
    }

    public void A0(long j10) {
        this.f19929i = j10;
    }

    public int B() {
        return this.f19944x;
    }

    public void B0(int i10) {
        this.f19933m = i10;
    }

    public int C() {
        return this.f19946z;
    }

    public void C0(Map<String, AtomicInteger> map) {
        this.T = map;
    }

    public int D() {
        return this.B;
    }

    public void D0(String str) {
        this.f19923c = str;
    }

    public int E() {
        return this.D;
    }

    public void E0(long j10) {
        this.f19936p = j10;
    }

    public int F() {
        return this.A;
    }

    public void F0(int i10) {
        this.F = i10;
    }

    public int G() {
        return this.C;
    }

    public void G0(String str) {
        this.J = str;
    }

    public int H() {
        return this.E;
    }

    public void H0(int i10) {
        this.H = i10;
    }

    public String I() {
        return this.f19922b;
    }

    public void I0(int i10) {
        this.G = i10;
    }

    public int J() {
        return this.P;
    }

    public long K() {
        return this.f19929i;
    }

    public int L() {
        return this.f19933m;
    }

    public Map<String, AtomicInteger> M() {
        return this.T;
    }

    public String N() {
        return this.f19923c;
    }

    public long O() {
        return this.f19936p;
    }

    public String P() {
        return this.J;
    }

    public int Q() {
        return this.H;
    }

    public int R() {
        return this.G;
    }

    public void S(String str) {
        this.K = str;
    }

    public void T(int i10) {
        this.M = i10;
    }

    public void U(int i10) {
        this.Q = i10;
    }

    public void V(int i10) {
        this.L = i10;
    }

    public void W(int i10) {
        this.f19935o = i10;
    }

    public void X(String str) {
        this.f19921a = str;
    }

    public void Y(int i10) {
        this.f19927g = i10;
    }

    public void Z(long j10) {
        this.f19924d = j10;
    }

    public String a() {
        return this.K;
    }

    public void a0(int i10) {
        this.O = i10;
    }

    public int b() {
        return this.M;
    }

    public void b0(long j10) {
        this.f19938r = j10;
    }

    public int c() {
        return this.Q;
    }

    public void c0(int i10) {
        this.S = i10;
    }

    public int d() {
        return this.L;
    }

    public void d0(int i10) {
        this.f19926f = i10;
    }

    public int e() {
        return this.f19935o;
    }

    public void e0(int i10) {
        this.N = i10;
    }

    public Map<Long, AtomicInteger> f() {
        return this.f19939s;
    }

    public void f0(long j10) {
        this.f19937q = j10;
    }

    public String g() {
        return this.f19921a;
    }

    public void g0(int i10) {
        this.R = i10;
    }

    public int h() {
        return this.f19927g;
    }

    public void h0(int i10) {
        this.f19942v = i10;
    }

    public int i() {
        return this.O;
    }

    public void i0(int i10) {
        this.f19934n = i10;
    }

    public long j() {
        return this.f19938r;
    }

    public void j0(long j10) {
        this.f19941u = j10;
    }

    public int k() {
        return this.S;
    }

    public void k0(int i10) {
        this.f19928h = i10;
    }

    public int l() {
        return this.f19926f;
    }

    public void l0(String str) {
        this.f19925e = str;
    }

    public int m() {
        return this.N;
    }

    public void m0(int i10) {
        this.f19932l = i10;
    }

    public long n() {
        return this.f19937q;
    }

    public void n0(int i10) {
        this.f19930j = i10;
    }

    public int o() {
        return this.R;
    }

    public void o0(String str) {
        this.I = str;
    }

    public int p() {
        return this.f19942v;
    }

    public void p0(int i10) {
        this.f19945y = i10;
    }

    public int q() {
        return this.f19934n;
    }

    public void q0(int i10) {
        this.f19943w = i10;
    }

    public int r() {
        return this.f19931k;
    }

    public void r0(int i10) {
        this.f19944x = i10;
    }

    public long s() {
        return this.f19941u;
    }

    public void s0(int i10) {
        this.f19946z = i10;
    }

    public int t() {
        return this.f19928h;
    }

    public void t0(int i10) {
        this.B = i10;
    }

    public String u() {
        return this.f19925e;
    }

    public void u0(int i10) {
        this.D = i10;
    }

    public int v() {
        return this.f19932l;
    }

    public void v0(int i10) {
        this.A = i10;
    }

    public Map<Integer, AtomicInteger> w() {
        return this.f19940t;
    }

    public void w0(int i10) {
        this.C = i10;
    }

    public int x() {
        return this.f19930j;
    }

    public void x0(int i10) {
        this.E = i10;
    }

    public String y() {
        return this.I;
    }

    public void y0(String str) {
        this.f19922b = str;
    }

    public int z() {
        return this.f19945y;
    }

    public void z0(int i10) {
        this.P = i10;
    }
}
