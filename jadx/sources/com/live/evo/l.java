package com.live.evo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.live.evo.util.b0;
import com.live.evo.util.q1;
import com.live.evo.util.s0;
import com.live.evo.util.t1;
import com.live.evo.util.u1;
import com.live.evo.util.w1;
import com.live.evo.util.x1;
import com.live.evo.util.y0;
import i5.n;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import tf.AccountInfo;
import x1.f1.lb.util.d0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class l {
    private static volatile l W;
    private boolean E;
    private String R;
    Handler S;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f7020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f7021d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f7022e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f7026i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f7027j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f7028k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f7029l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Map<String, String> f7030m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private AccountInfo f7032o;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private String f7042y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q6.b f7018a = q6.c.d(l.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7019b = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f7023f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f7024g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f7025h = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f7031n = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f7033p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f7034q = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f7036s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f7037t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f7038u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f7039v = "";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Map<String, n> f7040w = new HashMap();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private String f7041x = "";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f7043z = -1;
    private boolean A = true;
    private boolean B = true;
    private boolean C = true;
    private boolean D = false;
    private int F = 0;
    private String G = "";
    private volatile int H = 0;
    private String I = "0,0,0";
    private int J = 0;
    private int K = 0;
    private int L = 0;
    private int M = 0;
    private long N = 100;
    private String O = "";
    private String P = "1,2,3";
    private int Q = 1;
    private Runnable T = new a();
    private Runnable U = new b();
    private Runnable V = new c(this);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private w1 f7035r = new w1(this);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.M();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.c();
        }
    }

    private <T> T k(String str, T t10, T t11) {
        Object objValueOf = null;
        if (t11 == null) {
            return null;
        }
        try {
            if (this.f7030m == null) {
                this.f7030m = b0.b();
            }
            Map<String, String> map = this.f7030m;
            if (map == null) {
                return t11;
            }
            String str2 = map.get(str);
            if (str2 != null) {
                try {
                    Class<?> cls = t10.getClass();
                    if (cls.equals(String.class)) {
                        objValueOf = str2;
                    } else if (cls.equals(Integer.class)) {
                        objValueOf = Integer.valueOf(str2);
                    } else if (cls.equals(Boolean.class)) {
                        objValueOf = Boolean.valueOf(str2);
                    } else if (cls.equals(Double.class)) {
                        objValueOf = Double.valueOf(str2);
                    } else if (cls.equals(Short.class)) {
                        objValueOf = Short.valueOf(str2);
                    } else if (cls.equals(Byte.class)) {
                        objValueOf = Byte.valueOf(str2);
                    } else if (cls.equals(Float.class)) {
                        objValueOf = Float.valueOf(str2);
                    } else if (cls.equals(Long.class)) {
                        objValueOf = Long.valueOf(str2);
                    } else if (cls.equals(Character.class)) {
                        objValueOf = Character.valueOf(str2.charAt(0));
                    }
                } catch (Throwable unused) {
                }
            }
            if (objValueOf == null) {
                objValueOf = t11;
            }
        } catch (Throwable unused2) {
        }
        return objValueOf == null ? t11 : (T) objValueOf;
    }

    public int g(String str, int i10) {
        return ((Integer) k(str, 0, Integer.valueOf(i10))).intValue();
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c implements Runnable {
        c(l lVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            xe.c.c().o(new b5.i());
        }
    }

    public static void B(Context context) {
        W = new l();
    }

    private void L() {
        String str = this.J + "," + this.L + "," + this.M;
        this.I = str;
        y0.b("pip_info", str);
    }

    public static l n() {
        if (W == null) {
            synchronized (l.class) {
                try {
                    if (W == null) {
                        W = new l();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return W;
    }

    public boolean A() {
        return d0.f21360a.j();
    }

    public boolean D() {
        if (this.f7027j == 0) {
            return false;
        }
        if (this.f7019b < 0) {
            int iG = g("adult_pwd_dur_min", 60) * 60000;
            if (iG < 0) {
                this.f7019b = 3600000;
            } else {
                this.f7019b = iG;
            }
        }
        if (Math.abs(System.currentTimeMillis() - this.f7027j) < this.f7019b) {
            return this.f7026i;
        }
        if (Math.abs(System.currentTimeMillis() - this.f7027j) <= 31536000000L) {
            return false;
        }
        this.f7027j = System.currentTimeMillis();
        return this.f7026i;
    }

    public boolean F() {
        return t.v.c.i.a.f18646a.k0();
    }

    public boolean G() {
        return this.J > 0;
    }

    public boolean H() {
        return this.L == 1;
    }

    public boolean I() {
        return this.E;
    }

    public boolean J() {
        return !t.v.c.i.a.f18646a.a0();
    }

    public void M() {
        if (this.S == null) {
            HandlerThread handlerThread = new HandlerThread("UserManager");
            handlerThread.start();
            this.S = new Handler(handlerThread.getLooper());
        }
        Handler handler = this.S;
        if (handler != null) {
            handler.removeCallbacks(this.V);
            this.S.removeCallbacks(this.T);
        }
        long jA = u1.b().a();
        long jH = h("expired_schedule_threshold", TimeUnit.HOURS.toMillis(6L));
        long jL = l() - jA;
        if (jL >= jH) {
            Handler handler2 = this.S;
            if (handler2 != null) {
                handler2.postDelayed(this.T, jH);
                return;
            }
            return;
        }
        if (jL < 0) {
            jL = 0;
        }
        Handler handler3 = this.S;
        if (handler3 != null) {
            handler3.postDelayed(this.V, jL);
        }
    }

    public void N(boolean z10) {
        this.f7026i = z10;
        this.f7027j = System.currentTimeMillis();
        if (z10) {
            t.v.c.i.a.f18646a.H0();
        } else {
            t.v.c.i.a.f18646a.I0();
        }
    }

    public void O(String str) {
        this.f7020c = str;
        t.v.c.i.a.f18646a.G0(str);
    }

    public void P(String str) {
        this.f7042y = str;
    }

    public void Q(String str) {
        this.f7021d = str;
    }

    public void R(boolean z10) {
        this.J = z10 ? 1 : 0;
        L();
    }

    public void S(int i10) {
        this.f7031n = i10;
    }

    public void T(Activity activity, com.live.evo.dialog.a.c cVar, i5.h hVar) {
        FragmentManager supportFragmentManager = ((AppCompatActivity) activity).getSupportFragmentManager();
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        Fragment fragmentFindFragmentByTag = supportFragmentManager.findFragmentByTag("AdultKeyNewDialogFragment_TAG");
        if (fragmentFindFragmentByTag != null) {
            fragmentTransactionBeginTransaction.hide(fragmentFindFragmentByTag);
            fragmentTransactionBeginTransaction.remove(fragmentFindFragmentByTag);
        }
        fragmentTransactionBeginTransaction.addToBackStack(null);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        com.live.evo.dialog.a.V(cVar, hVar).show(supportFragmentManager.beginTransaction(), "AdultKeyNewDialogFragment_TAG");
    }

    public void b(Activity activity) {
        FragmentManager supportFragmentManager = ((AppCompatActivity) activity).getSupportFragmentManager();
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        Fragment fragmentFindFragmentByTag = supportFragmentManager.findFragmentByTag("AdultKeyNewDialogFragment_TAG");
        if (fragmentFindFragmentByTag != null) {
            try {
                fragmentTransactionBeginTransaction.hide(fragmentFindFragmentByTag).commitAllowingStateLoss();
                fragmentTransactionBeginTransaction.remove(fragmentFindFragmentByTag).commitAllowingStateLoss();
            } catch (Throwable unused) {
            }
        }
    }

    public String d() {
        return t.v.c.i.a.f18646a.Z();
    }

    public int e() {
        return this.f7043z;
    }

    public boolean f() {
        return this.C;
    }

    public long h(String str, long j10) {
        return ((Long) k(str, 0L, Long.valueOf(j10))).longValue();
    }

    public String i(String str, String str2) {
        return (String) k(str, "", str2);
    }

    public boolean j(String str, boolean z10) {
        return ((Boolean) k(str, Boolean.TRUE, Boolean.valueOf(z10))).booleanValue();
    }

    public long l() {
        return t.v.c.i.a.f18646a.I();
    }

    public String m() {
        return q1.m(t.v.c.i.a.f18646a.I(), x1.j(R$string.ddMMyyyy));
    }

    public String o() {
        return this.f7021d;
    }

    public void p(l5.a aVar) {
        this.f7035r.a(aVar);
    }

    public int q() {
        return s0.f7342a.D();
    }

    public long r() {
        return this.N;
    }

    public int s() {
        return this.M;
    }

    public Bitmap t(String str) {
        return this.f7035r.b(str);
    }

    public String toString() {
        return "UserManager{adultPwdDurMillis=" + this.f7019b + ", adultKey='" + this.f7020c + "', lockKey='" + this.f7021d + "', isActivated=" + this.f7022e + ", isServiceTokenValid=" + this.f7023f + ", isAdultAuth=" + this.f7026i + ", adultAuthTime=" + this.f7027j + ", seed=" + this.f7028k + ", group='" + this.f7029l + "', userPlayStatus=" + this.f7031n + ", accountInfo=" + this.f7032o + ", playGraceUsed=" + this.f7036s + ", isForceLogout=" + this.f7037t + ", isLogout=" + this.f7038u + ", mSessionId='" + this.f7039v + "'}";
    }

    public boolean u() {
        return this.B;
    }

    public boolean v() {
        return x1.f1.lb.config.b.f20643a.f();
    }

    public String w() {
        return j("show_sessionid", true) ? this.f7039v : "";
    }

    public String x() {
        return this.R;
    }

    public boolean y() {
        return t.v.c.i.a.f18646a.q0();
    }

    public boolean z() {
        return !TextUtils.isEmpty(this.f7021d);
    }

    private l() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        long jL = l() - u1.b().a();
        long jH = h("expired_schedule_threshold_int", TimeUnit.HOURS.toMillis(24L));
        if (jL <= jH) {
            t1.a().d(this.V);
            t1.a().c(this.V, Math.max(jL, h("expired_play_grace_time", TimeUnit.MINUTES.toMillis(15L))));
        } else {
            t1.a().d(this.U);
            t1.a().c(this.U, jH);
        }
    }

    public boolean C() {
        return com.live.evo.util.c.a().b();
    }

    public boolean E() {
        return com.live.evo.util.e.b().c();
    }

    public void K(boolean z10) {
    }
}
