package com.live.evo.fragment;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.p000lifecycle.CoroutineLiveDataKt;
import com.live.evo.R$color;
import com.live.evo.R$dimen;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.activity.LiveNewActivity;
import com.live.evo.widget.AdBannerView;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnPageChangeListener;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class r2 extends l5.b implements View.OnKeyListener, com.live.evo.fragment.login.presenter.f {
    private static SoftReference<r2> S1;
    private static com.live.evo.osd.persenter.a T1;
    private static y1 U1;
    private static View V1;
    private static boolean W1;
    private TextView A;
    private com.live.evo.osd.a C;
    private TextView D;
    private t5.a D1;
    private TextView E;
    private AdBannerView E1;
    private List<Pair<String, String>> F;
    private View J;
    private TextView K;
    private TextView K1;
    private TextView L;
    private View L1;
    private TextView M;
    private View N;
    private View O;
    private TextView P;
    private View Q;
    private ImageView R;
    private TextView S;
    private TextView T;
    private ImageView U;
    private TextView V;
    private View W;
    private TextView X;
    private View Y;
    private TextView Z;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    private TextView f6591b1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private View f6592l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private View f6593m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ImageView f6594n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private TextView f6595o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private TextView f6596p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private TextView f6597q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private TextView f6598r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Button f6599s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Button f6600t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private TextView f6601u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ImageView f6602v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private View f6603w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private TextView f6604x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private LinearLayout f6605y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Banner f6606z;
    private boolean B = false;
    private int G = 0;
    private int H = 0;
    private long I = 0;
    private List<String> F1 = new ArrayList();
    private Handler G1 = new Handler();
    private int H1 = 0;
    private boolean I1 = false;
    private boolean J1 = true;
    private boolean M1 = false;
    private View.OnFocusChangeListener N1 = new a(this);
    Runnable O1 = new b(this);
    private View.OnClickListener P1 = new c();
    private Runnable Q1 = new d();
    private int R1 = 0;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements View.OnFocusChangeListener {
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            if (z10) {
                com.live.evo.util.z0.d(view);
            } else {
                com.live.evo.util.z0.g(view);
            }
        }

        a(r2 r2Var) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id2 = view.getId();
            if (id2 != 2131428776) {
                switch (id2) {
                    case R$id.myaccountf_bn_myaccount_banner /* 2131428750 */:
                        r2.this.Z0();
                        break;
                    case R$id.myaccountf_btn_account_add_email /* 2131428751 */:
                        r2.this.b1();
                        break;
                    case R$id.myaccountf_btn_account_bind /* 2131428752 */:
                        r2.this.K0();
                        break;
                }
                return;
            }
            r2.this.W0();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            r2.this.d1(null, false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            r2.this.N.setVisibility(8);
            r2.this.f1(false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class f implements a5.a {
        f() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            r2.this.g1();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            r2.this.N.setVisibility(8);
            r2.this.f1(false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            r2.this.N.setVisibility(8);
            r2.this.f1(false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f6614a;

        j(r2 r2Var, Runnable runnable) {
            this.f6614a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f6614a == null || r2.W1) {
                return;
            }
            r2.W1 = true;
            this.f6614a.run();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class k implements com.live.evo.osd.a {
        k() {
        }

        @Override // com.live.evo.osd.a
        public void c() {
            FragmentActivity activity = r2.this.getActivity();
            if (activity == null) {
                return;
            }
            ((LiveNewActivity) activity).L3();
            r2.this.U0();
        }

        @Override // com.live.evo.osd.p
        public void e() {
            FragmentActivity activity = r2.this.getActivity();
            if (activity == null) {
                return;
            }
            ((LiveNewActivity) activity).L3();
            r2.this.U0();
        }

        @Override // com.live.evo.osd.p
        public void a() {
        }

        @Override // com.live.evo.osd.p
        public void b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class m implements com.live.evo.dialog.r.c {
        m() {
        }

        @Override // com.live.evo.dialog.r.c
        public void b() {
            com.live.evo.fragment.login.j.g0(r2.this.getChildFragmentManager(), 22, r2.this.C);
        }

        @Override // com.live.evo.dialog.r.c
        public void a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class n implements OnPageChangeListener {
        n() {
        }

        @Override // com.youth.banner.listener.OnPageChangeListener
        public void onPageSelected(int i10) {
            r2.this.R1 = i10;
        }

        @Override // com.youth.banner.listener.OnPageChangeListener
        public void onPageScrollStateChanged(int i10) {
        }

        @Override // com.youth.banner.listener.OnPageChangeListener
        public void onPageScrolled(int i10, float f10, int i11) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class o implements View.OnKeyListener {
        o() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                if (i10 == 19) {
                    if (r2.V1 != null) {
                        r2.V1.requestFocus();
                        return true;
                    }
                } else {
                    if (i10 == 22) {
                        if (r2.this.N != null && r2.this.N.getVisibility() == 0) {
                            if (r2.this.O != null && r2.this.O.getVisibility() == 0) {
                                r2.this.Q.requestFocus();
                                return true;
                            }
                            if (r2.this.W != null && r2.this.W.getVisibility() == 0) {
                                r2.this.Y.requestFocus();
                                return true;
                            }
                        } else if (r2.this.f6605y != null && r2.this.f6605y.getVisibility() == 0) {
                            if (r2.this.L0()) {
                                r2.this.f6606z.requestFocus();
                            }
                        } else if (r2.this.F1.size() > 0 && r2.this.E1 != null && r2.this.E1.getVisibility() == 0) {
                            r2.this.E1.requestFocus();
                            r2.this.I1 = true;
                            r2.this.E1.isAutoLoop(false);
                            r2.this.E1.stop();
                        }
                        return true;
                    }
                    if (i10 == 21) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class p implements View.OnKeyListener {
        p() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                if (i10 == 19) {
                    if (r2.V1 != null) {
                        r2.V1.requestFocus();
                        return true;
                    }
                } else {
                    if (i10 == 22) {
                        if (r2.this.N != null && r2.this.N.getVisibility() == 0) {
                            if (r2.this.O != null && r2.this.O.getVisibility() == 0) {
                                r2.this.Q.requestFocus();
                                return true;
                            }
                            if (r2.this.W != null && r2.this.W.getVisibility() == 0) {
                                r2.this.Y.requestFocus();
                                return true;
                            }
                        } else if (r2.this.f6605y != null && r2.this.f6605y.getVisibility() == 0) {
                            if (r2.this.L0()) {
                                r2.this.f6606z.requestFocus();
                            }
                        } else if (r2.this.F1.size() > 0 && r2.this.E1 != null && r2.this.E1.getVisibility() == 0) {
                            r2.this.E1.requestFocus();
                            r2.this.I1 = true;
                            r2.this.E1.isAutoLoop(false);
                            r2.this.E1.stop();
                        }
                        return true;
                    }
                    if (i10 == 21) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class q implements View.OnKeyListener {
        q() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                if (i10 == 19) {
                    if (r2.this.f6599s != null && r2.this.f6599s.getVisibility() == 0) {
                        r2.this.f6599s.requestFocus();
                        return true;
                    }
                    if (r2.this.f6600t != null && r2.this.f6600t.getVisibility() == 0) {
                        r2.this.f6600t.requestFocus();
                        return true;
                    }
                    if (r2.V1 != null) {
                        r2.V1.requestFocus();
                        return true;
                    }
                } else {
                    if (i10 == 21) {
                        if (r2.this.f6599s != null && r2.this.f6599s.getVisibility() == 0) {
                            r2.this.f6599s.requestFocus();
                        } else if (r2.this.D != null) {
                            r2.this.D.requestFocus();
                        }
                        return true;
                    }
                    if (i10 == 22) {
                        if (r2.this.N != null && r2.this.N.getVisibility() == 0) {
                            if (r2.this.O != null && r2.this.O.getVisibility() == 0) {
                                r2.this.Q.requestFocus();
                                return true;
                            }
                            if (r2.this.W != null && r2.this.W.getVisibility() == 0) {
                                r2.this.Y.requestFocus();
                                return true;
                            }
                        } else if (r2.this.f6605y != null && r2.this.f6605y.getVisibility() == 0) {
                            if (r2.this.L0()) {
                                r2.this.f6606z.requestFocus();
                            }
                        } else if (r2.this.F1.size() > 0 && r2.this.E1 != null && r2.this.E1.getVisibility() == 0) {
                            r2.this.E1.requestFocus();
                            r2.this.I1 = true;
                            r2.this.E1.isAutoLoop(false);
                            r2.this.E1.stop();
                        }
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class r implements View.OnKeyListener {
        r() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                if (i10 == 19) {
                    if (r2.V1 != null) {
                        r2.V1.requestFocus();
                        return true;
                    }
                    if (r2.this.f6599s != null && r2.this.f6599s.getVisibility() == 0) {
                        r2.this.f6599s.requestFocus();
                        return true;
                    }
                    return false;
                }
                if (i10 == 22) {
                    if (r2.this.f6605y != null && r2.this.f6605y.getVisibility() == 0 && r2.this.L0()) {
                        r2.this.f6606z.requestFocus();
                    }
                    return true;
                }
                if (i10 == 21) {
                    if (r2.this.N != null && r2.this.N.getVisibility() == 0) {
                        if (r2.this.O != null && r2.this.O.getVisibility() == 0) {
                            r2.this.Q.requestFocus();
                            return true;
                        }
                        if (r2.this.W != null && r2.this.W.getVisibility() == 0) {
                            r2.this.Y.requestFocus();
                            return true;
                        }
                        return false;
                    }
                    if (r2.this.f6599s != null && r2.this.f6599s.getVisibility() == 0) {
                        r2.this.f6599s.requestFocus();
                        return true;
                    }
                    if (r2.this.D != null && r2.this.D.getVisibility() == 0) {
                        r2.this.D.requestFocus();
                        return true;
                    }
                    if (r2.V1 != null) {
                        r2.V1.requestFocus();
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class s implements View.OnKeyListener {
        s() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                if (i10 == 19) {
                    if (r2.V1 != null) {
                        r2.V1.requestFocus();
                    } else if (r2.this.f6599s != null && r2.this.f6599s.getVisibility() == 0) {
                        r2.this.f6599s.requestFocus();
                    }
                    r2.this.I1 = false;
                    r2.this.E1.isAutoLoop(true);
                    r2.this.E1.start();
                    return true;
                }
                if (i10 == 22) {
                    if (com.live.evo.util.x1.m(200L)) {
                        return true;
                    }
                    if (r2.this.F1.size() <= 1 || r2.this.H1 == r2.this.F1.size() - 1) {
                        r2.this.E1.requestFocus();
                    } else {
                        r2.this.E1.setCurrentItem((r2.this.E1.getCurrentItem() + 1) % r2.this.E1.getItemCount());
                    }
                    return true;
                }
                if (i10 == 21) {
                    if (com.live.evo.util.x1.m(200L)) {
                        return true;
                    }
                    if (r2.this.F1.size() > 1 && r2.this.H1 != 0) {
                        r2.this.E1.setCurrentItem((r2.this.E1.getCurrentItem() - 1) % r2.this.E1.getItemCount());
                    } else {
                        if (r2.this.N != null && r2.this.N.getVisibility() == 0) {
                            if (r2.this.O != null && r2.this.O.getVisibility() == 0) {
                                r2.this.Q.requestFocus();
                            } else if (r2.this.W != null && r2.this.W.getVisibility() == 0) {
                                r2.this.Y.requestFocus();
                            }
                        } else if (r2.this.f6599s != null && r2.this.f6599s.getVisibility() == 0) {
                            r2.this.f6599s.requestFocus();
                        } else if (r2.this.D != null && r2.this.D.getVisibility() == 0) {
                            r2.this.D.requestFocus();
                        } else if (r2.V1 != null) {
                            r2.V1.requestFocus();
                        }
                        r2.this.I1 = false;
                        r2.this.E1.isAutoLoop(true);
                        r2.this.E1.start();
                    }
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class t implements View.OnKeyListener {
        t() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                if (i10 == 19) {
                    if (r2.V1 != null) {
                        r2.V1.requestFocus();
                        return true;
                    }
                    if (r2.this.f6599s != null && r2.this.f6599s.getVisibility() == 0) {
                        r2.this.f6599s.requestFocus();
                        return true;
                    }
                } else {
                    if (i10 == 22) {
                        if (r2.this.f6605y != null && r2.this.f6605y.getVisibility() == 0) {
                            if (r2.this.L0()) {
                                r2.this.f6606z.requestFocus();
                            }
                        } else if (r2.this.F1.size() > 0 && r2.this.E1 != null && r2.this.E1.getVisibility() == 0) {
                            r2.this.E1.requestFocus();
                            r2.this.I1 = true;
                            r2.this.E1.isAutoLoop(false);
                            r2.this.E1.stop();
                        }
                        return true;
                    }
                    if (i10 == 21) {
                        if (r2.this.f6599s != null && r2.this.f6599s.getVisibility() == 0) {
                            r2.this.f6599s.requestFocus();
                            return true;
                        }
                        if (r2.this.D != null && r2.this.D.getVisibility() == 0) {
                            r2.this.D.requestFocus();
                            return true;
                        }
                        if (r2.V1 != null) {
                            r2.V1.requestFocus();
                            return true;
                        }
                    } else if (i10 == 20) {
                        if (r2.this.W != null && r2.this.W.getVisibility() == 0) {
                            r2.this.Y.requestFocus();
                        }
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class u implements View.OnKeyListener {
        u() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                if (i10 == 20) {
                    return true;
                }
                if (i10 == 22) {
                    if (r2.this.f6605y != null && r2.this.f6605y.getVisibility() == 0) {
                        if (r2.this.L0()) {
                            r2.this.f6606z.requestFocus();
                        }
                    } else if (r2.this.F1.size() > 0 && r2.this.E1 != null && r2.this.E1.getVisibility() == 0) {
                        r2.this.E1.requestFocus();
                        r2.this.I1 = true;
                        r2.this.E1.isAutoLoop(false);
                        r2.this.E1.stop();
                    }
                    return true;
                }
                if (i10 == 21) {
                    if (r2.this.f6599s != null && r2.this.f6599s.getVisibility() == 0) {
                        r2.this.f6599s.requestFocus();
                        return true;
                    }
                    if (r2.this.D != null && r2.this.D.getVisibility() == 0) {
                        r2.this.D.requestFocus();
                        return true;
                    }
                    if (r2.V1 != null) {
                        r2.V1.requestFocus();
                        return true;
                    }
                } else if (i10 == 19) {
                    if (r2.this.Q != null && r2.this.Q.getVisibility() == 0) {
                        r2.this.Q.requestFocus();
                    } else if (r2.V1 != null) {
                        r2.V1.requestFocus();
                    } else if (r2.this.f6599s != null && r2.this.f6599s.getVisibility() == 0) {
                        r2.this.f6599s.requestFocus();
                    }
                    return true;
                }
            }
            return false;
        }
    }

    private void O0() {
        this.G = 1;
        this.H = 0;
        this.I = com.live.evo.util.u1.b().a();
    }

    private void P0() {
        long jB;
        this.B = false;
        try {
            i5.f fVarF = v4.g.e().f(String.valueOf(3));
            if (fVarF == null || fVarF.a() == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            this.F = new ArrayList();
            int dimension = (int) getResources().getDimension(R$dimen.banner_bg_width);
            v4.g.e();
            int iB = com.live.evo.util.n.b();
            for (int i10 = 0; i10 < fVarF.a().size(); i10++) {
                if (!TextUtils.isEmpty(fVarF.a().get(i10).d())) {
                    arrayList.add(fVarF.a().get(i10).d());
                    this.F.add(new Pair<>(fVarF.a().get(i10).a(), fVarF.a().get(i10).d()));
                }
            }
            if (fVarF.a().get(0) != null) {
                float f10 = fVarF.a().get(0).f();
                float f11 = dimension;
                float f12 = f10 / f11;
                float fC = fVarF.a().get(0).c();
                float f13 = iB;
                if (f12 >= fC / f13) {
                    iB = (int) ((f11 / f10) * fC);
                } else {
                    dimension = (int) ((f13 / fC) * f10);
                }
                jB = fVarF.a().get(0).b();
                if (jB < 3000) {
                    jB = 3000;
                }
            } else {
                jB = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
            }
            boolean z10 = arrayList.size() > 0;
            this.B = z10;
            if (z10) {
                this.f6606z.getLayoutParams().height = iB;
                this.f6606z.getLayoutParams().width = dimension;
                this.f6606z.setLoopTime(jB);
                this.f6606z.setDatas(arrayList);
                this.f6606z.setAdapter(new com.live.evo.catchup.player.b(getContext(), arrayList));
                this.f6606z.start();
                if (v4.g.e().c()) {
                    this.f6605y.setVisibility(0);
                    this.f6606z.start();
                }
            }
        } catch (Exception unused) {
        }
    }

    private synchronized void e1() {
        Handler handler;
        if (com.live.evo.l.n().v()) {
            int iE = com.live.evo.l.n().e();
            if ((iE == 0 || iE == 1) && (handler = this.G1) != null) {
                handler.removeCallbacks(this.Q1);
                this.G1.postDelayed(this.Q1, 2000L);
            }
        }
    }

    private boolean h1(boolean z10) {
        String[] strArrSplit;
        if (!z10) {
            return false;
        }
        String strI = com.live.evo.l.n().i("share_code_show_cfg", "1");
        if (!TextUtils.isEmpty(strI) && (strArrSplit = strI.split(",")) != null && strArrSplit.length > 0) {
            String strValueOf = String.valueOf(com.live.evo.l.n().e());
            for (String str : strArrSplit) {
                if (strValueOf.equals(str.trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements Runnable {
        b(r2 r2Var) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class l implements com.live.evo.dialog.r.c {
        l(r2 r2Var) {
        }

        @Override // com.live.evo.dialog.r.c
        public void a() {
        }

        @Override // com.live.evo.dialog.r.c
        public void b() {
        }
    }

    private void N0() {
        int iD = com.live.evo.util.s0.f7342a.D();
        boolean z10 = iD == 6 && com.live.evo.l.n().j("phone_account_add_email", false);
        T0(z10);
        if (z10) {
            this.f6600t.setVisibility(0);
        } else {
            this.f6600t.setVisibility(8);
        }
        if (!com.live.evo.l.n().j("phone_account_profile_show_email", true)) {
            this.L1.setVisibility(8);
            return;
        }
        String strI = t.v.c.i.a.f18646a.i();
        if (TextUtils.isEmpty(strI) || iD != 6) {
            this.L1.setVisibility(8);
        } else {
            this.L1.setVisibility(0);
            this.K1.setText(com.live.evo.util.x1.g(strI, false));
        }
    }

    private void R0() {
        int iD = com.live.evo.util.s0.f7342a.D();
        com.live.evo.l.n().e();
        this.f6599s.setVisibility(0);
        this.D.setVisibility(0);
        int i10 = 2131952327;
        int i11 = R$string.log_out;
        if (iD == 2 || iD == 6) {
            if (t.v.c.i.a.f18646a.o0()) {
                this.f6599s.setVisibility(0);
                this.D.setVisibility(8);
            } else {
                this.f6599s.setVisibility(8);
                this.D.setVisibility(0);
                i10 = R$string.recharge_now;
            }
        } else if (iD == 3) {
            i10 = R$string.bind_email;
        } else {
            i11 = R$string.sign_up;
        }
        this.f6599s.setText(i10);
        this.D.setText(i11);
        if (this.M1) {
            this.f6599s.requestFocus();
        }
    }

    private void S0() {
        this.f6599s.setOnKeyListener(new o());
        this.f6600t.setOnKeyListener(new p());
        this.D.setOnKeyListener(new q());
        this.f6606z.setOnKeyListener(new r());
        this.E1.setOnKeyListener(new s());
        this.Q.setOnKeyListener(new t());
        this.Y.setOnKeyListener(new u());
    }

    private void T0(boolean z10) {
        try {
            int iD = com.live.evo.util.s0.f7342a.D();
            v0.b().c();
            if (iD == 6 && z10) {
                this.f6602v.setImageDrawable(null);
                this.f6603w.setVisibility(0);
                this.f6601u.setText(R$string.add_email_tip_default);
                return;
            }
            this.f6603w.setVisibility(8);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private void X0(String str) {
        y1 y1Var = U1;
        if (y1Var != null) {
            y1Var.b();
        }
        if (getContext() instanceof LiveNewActivity) {
            ((LiveNewActivity) getContext()).X1(str);
        }
    }

    public static r2 Y0(String str, View view, com.live.evo.osd.persenter.a aVar, y1 y1Var) {
        SoftReference<r2> softReference = S1;
        if (softReference == null || softReference.get() == null) {
            V1 = view;
            T1 = aVar;
            U1 = y1Var;
            softReference = new SoftReference<>(new r2());
            Bundle bundle = new Bundle();
            bundle.putString("tag", str);
            softReference.get().setArguments(bundle);
            S1 = softReference;
        } else {
            try {
                softReference.get().R0();
            } catch (Throwable unused) {
            }
        }
        return softReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0() {
        this.H++;
        i5.f fVarF = v4.g.e().f(String.valueOf(3));
        if (fVarF == null || fVarF.a() == null || this.R1 >= fVarF.a().size()) {
            return;
        }
        com.live.evo.util.b.c(getActivity(), fVarF.a().get(this.R1).e());
        com.live.evo.osd.persenter.a aVar = T1;
        if (aVar != null) {
            aVar.hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1() {
        y1 y1Var = U1;
        if (y1Var != null) {
            y1Var.c();
        }
        com.live.evo.fragment.login.j.g0(getChildFragmentManager(), 52, this.C);
    }

    private void c1() {
        try {
            if (this.N.getVisibility() != 0) {
                return;
            }
            List<i5.b0> listC = com.live.evo.fragment.a.a().c();
            ArrayList arrayList = new ArrayList();
            Iterator<i5.b0> it = listC.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(it.next().a()));
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d1(Runnable runnable, boolean z10) {
        if (runnable != null) {
            W1 = false;
            com.live.evo.util.t1.a().c(new j(this, runnable), 2000L);
        }
        com.live.evo.l.n().l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f1(boolean z10) {
        View view = this.f6593m;
        if (view == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        int[] rules = layoutParams.getRules();
        boolean z11 = false;
        if (rules != null && rules.length > 0) {
            for (int i10 : rules) {
                if (i10 == 13) {
                    z11 = true;
                    break;
                }
            }
        }
        if (z10) {
            if (!z11 && this.N.getVisibility() != 0) {
                return;
            }
            layoutParams.addRule(9);
            layoutParams.removeRule(13);
        } else {
            if (z11 && this.N.getVisibility() == 0) {
                return;
            }
            layoutParams.addRule(13);
            layoutParams.removeRule(9);
        }
        this.f6593m.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g1() {
        if (com.live.evo.fragment.a.a().c() == null || com.live.evo.fragment.a.a().c().size() <= 0) {
            this.N.setVisibility(8);
            f1(false);
            return;
        }
        this.N.setVisibility(0);
        f1(true);
        this.S.setText(com.live.evo.fragment.a.a().c().get(0).c() + "");
        this.T.setText(com.live.evo.fragment.a.a().c().get(0).d() + "");
        com.live.evo.util.v.c(getContext(), com.live.evo.fragment.a.a().c().get(0).b(), R$drawable.qr_placehodler, this.R);
        try {
            Map map = (Map) com.live.evo.util.w.c().n(com.live.evo.l.n().i("bff_show_configs", ""), HashMap.class);
            if (map != null) {
                Object obj = map.get("title");
                String strReplace = obj != null ? obj.toString().replace("\"", "") : "";
                if (!TextUtils.isEmpty(strReplace)) {
                    this.P.setText(Html.fromHtml(strReplace));
                }
                Object obj2 = map.get("remind");
                String strReplace2 = obj2 != null ? obj2.toString().replace("\"", "") : "";
                if (!TextUtils.isEmpty(strReplace2)) {
                    this.V.setText(Html.fromHtml(strReplace2));
                }
            }
        } catch (Exception unused) {
        }
        if (com.live.evo.l.n().j("bff_show_others", false)) {
            this.W.setVisibility(0);
            try {
                Map map2 = (Map) com.live.evo.util.w.c().n(com.live.evo.l.n().i("bff_show_others_configs", ""), HashMap.class);
                if (map2 != null) {
                    Object obj3 = map2.get("title");
                    String strReplace3 = obj3 != null ? obj3.toString().replace("\"", "") : "";
                    if (!TextUtils.isEmpty(strReplace3)) {
                        this.X.setText(Html.fromHtml(strReplace3));
                    }
                    Object obj4 = map2.get("remind1");
                    String strReplace4 = obj4 != null ? obj4.toString().replace("\"", "") : "";
                    if (!TextUtils.isEmpty(strReplace4)) {
                        this.Z.setText(Html.fromHtml(strReplace4));
                    }
                    Object obj5 = map2.get("remind2");
                    String strReplace5 = obj5 != null ? obj5.toString().replace("\"", "") : "";
                    if (!TextUtils.isEmpty(strReplace5)) {
                        this.f6591b1.setText(Html.fromHtml(strReplace5));
                    }
                }
            } catch (Exception unused2) {
            }
        } else {
            this.W.setVisibility(8);
        }
        c1();
    }

    @Override // com.live.evo.fragment.login.presenter.f
    public void C(String str, String str2) {
        String str3;
        com.live.evo.dialog.r rVar = new com.live.evo.dialog.r(getActivity(), new m());
        rVar.k(com.live.evo.util.x1.j(R$string.recharge_fail));
        if (TextUtils.isEmpty(str2)) {
            str3 = "";
        } else {
            str3 = com.live.evo.util.x1.j(2131952013) + str2;
        }
        rVar.g(com.live.evo.util.x1.j(R$string.close));
        rVar.h(com.live.evo.util.x1.j(R$string.tv_continue));
        rVar.c();
        rVar.j(str, str3);
        rVar.l();
    }

    public void U0() {
        String strJ;
        String strA;
        if (this.E == null) {
            return;
        }
        i1();
        long jL = com.live.evo.l.n().l();
        com.live.evo.util.s0 s0Var = com.live.evo.util.s0.f7342a;
        int iD = s0Var.D();
        int iR = s0Var.r();
        com.live.evo.l.n().e();
        String strQ = s0Var.q();
        if (t.v.c.i.a.f18646a.l0()) {
            strJ = com.live.evo.util.x1.j(R$string.user_free);
        } else if (com.live.evo.util.u1.b().a() >= jL) {
            strJ = com.live.evo.util.x1.j(R$string.expired);
        } else if (iR == 8) {
            strJ = com.live.evo.util.x1.j(R$string.user_device);
            strQ = com.live.evo.util.x1.j(R$string.user_device);
        } else {
            strJ = iR == 6 ? com.live.evo.util.x1.j(R$string.user_phone) : com.live.evo.util.x1.j(R$string.user_email);
        }
        if (iR == 3) {
            strJ = com.live.evo.util.x1.j(R$string.user_renewcode);
            strA = com.live.evo.util.p1.a("myaccount_bottom_tip", com.live.evo.util.x1.j(R$string.myaccount_bottom_tip_bind));
        } else if (iD == 2 || iD == 6) {
            strA = "";
        } else if (iR != 8 || com.live.evo.l.n().F()) {
            if (com.live.evo.l.n().F()) {
                strQ = com.live.evo.util.x1.j(R$string.user_free);
            }
            strA = "";
        } else {
            strA = com.live.evo.util.p1.a("myaccount_bottom_tip_online", com.live.evo.util.x1.j(R$string.myaccount_bottom_tip_bind));
        }
        if (TextUtils.isEmpty(strA)) {
            this.E.setVisibility(8);
        } else {
            this.E.setText(Html.fromHtml(strA));
            this.E.setVisibility(0);
        }
        R0();
        this.f6596p.setText(strJ);
        this.f6595o.setText(com.live.evo.util.x1.g(strQ, iD == 3));
        if (iD == 2 || iD == 3 || iD == 6 || (iD == -2 && !com.live.evo.l.n().F())) {
            this.f6592l.setVisibility(0);
        } else {
            this.f6592l.setVisibility(4);
        }
        if (iD == 1 && jL == 0) {
            this.f6597q.setText("");
            this.f6598r.setVisibility(4);
        } else {
            this.f6598r.setVisibility(0);
            this.f6597q.setText(com.live.evo.l.n().m());
        }
        if (com.live.evo.l.n().E()) {
            this.f6595o.setVisibility(0);
            this.f6599s.setVisibility(0);
        }
        V0();
        Q0();
        N0();
    }

    @Override // com.live.evo.fragment.login.presenter.f
    public void a() {
        this.D1.d();
    }

    public void a1() {
        Button button = this.f6599s;
        if (button != null && button.getVisibility() == 0) {
            this.f6599s.requestFocus();
            return;
        }
        Button button2 = this.f6600t;
        if (button2 != null && button2.getVisibility() == 0) {
            this.f6600t.requestFocus();
            return;
        }
        TextView textView = this.D;
        if (textView != null) {
            textView.requestFocus();
        }
    }

    @Override // com.live.evo.fragment.login.presenter.f
    public void b() {
        this.D1.h();
    }

    @Override // l5.b
    protected void d0() {
        this.f6606z.setNextFocusUpId(R$id.myaccountf_bn_myaccount_banner);
        this.f6606z.setNextFocusDownId(R$id.myaccountf_bn_myaccount_banner);
        this.f6606z.setNextFocusRightId(R$id.myaccountf_bn_myaccount_banner);
        this.f6599s.setOnClickListener(this.P1);
        this.f6600t.setOnClickListener(this.P1);
        this.f6599s.setOnKeyListener(this);
        this.f6605y.setOnKeyListener(this);
        this.f6606z.setOnClickListener(this.P1);
        this.D.setOnClickListener(this.P1);
        this.f6599s.setOnFocusChangeListener(this.N1);
        this.Q.setOnClickListener(this.P1);
        this.Y.setOnClickListener(this.P1);
        this.E1.setOnKeyListener(this);
        this.f6606z.addOnPageChangeListener(new n());
        S0();
    }

    @Override // com.live.evo.fragment.login.presenter.f
    public void e() {
        y1 y1Var = U1;
        if (y1Var != null) {
            y1Var.c();
        }
        com.live.evo.fragment.login.j.g0(getChildFragmentManager(), 49, this.C);
    }

    @Override // l5.b
    public void h0(boolean z10) {
        this.J1 = z10;
        if (!z10) {
            if (M0()) {
                this.I = com.live.evo.util.u1.b().a() - this.I;
            }
            if (this.B) {
                this.f6606z.stop();
                return;
            }
            return;
        }
        e1();
        U0();
        if (M0()) {
            LinearLayout linearLayout = this.f6605y;
            if (linearLayout != null && linearLayout.getVisibility() != 0) {
                this.f6605y.setVisibility(0);
            }
            O0();
            this.f6606z.start();
            return;
        }
        LinearLayout linearLayout2 = this.f6605y;
        if (linearLayout2 == null || linearLayout2.getVisibility() != 0) {
            return;
        }
        this.f6605y.setVisibility(8);
        this.f6606z.stop();
    }

    @Override // com.live.evo.fragment.login.presenter.f
    public void i(String str, String str2) {
        String str3;
        com.live.evo.dialog.r rVar = new com.live.evo.dialog.r(getActivity(), new l(this));
        rVar.k(com.live.evo.util.x1.j(R$string.recharge_fail));
        if (TextUtils.isEmpty(str2)) {
            str3 = "";
        } else {
            str3 = com.live.evo.util.x1.j(2131952013) + str2;
        }
        rVar.j(str, str3);
        rVar.l();
    }

    @Override // com.live.evo.fragment.login.presenter.f
    public void z() {
        y1 y1Var = U1;
        if (y1Var != null) {
            y1Var.c();
        }
        com.live.evo.osd.a aVar = this.C;
        if (aVar != null) {
            aVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0() {
        int iE = com.live.evo.l.n().e();
        int iD = com.live.evo.util.s0.f7342a.D();
        if (iE != 1) {
            if (iD != 2 && iD != 6) {
                if (iD == 3) {
                    y1 y1Var = U1;
                    if (y1Var != null) {
                        y1Var.c();
                    }
                    com.live.evo.fragment.login.j.g0(getChildFragmentManager(), 25, this.C);
                    return;
                }
                y1 y1Var2 = U1;
                if (y1Var2 != null) {
                    y1Var2.c();
                }
                com.live.evo.fragment.login.j.g0(getChildFragmentManager(), 22, this.C);
                return;
            }
            y1 y1Var3 = U1;
            if (y1Var3 != null) {
                y1Var3.c();
            }
            com.live.evo.fragment.login.j.g0(getChildFragmentManager(), 22, this.C);
            return;
        }
        if (iD != 2 && iD != 6) {
            if (iD != 8 && iD != 3) {
                y1 y1Var4 = U1;
                if (y1Var4 != null) {
                    y1Var4.c();
                }
                com.live.evo.fragment.login.j.g0(getChildFragmentManager(), 22, this.C);
                return;
            }
            y1 y1Var5 = U1;
            if (y1Var5 != null) {
                y1Var5.c();
            }
            com.live.evo.fragment.login.j.g0(getChildFragmentManager(), 25, this.C);
            return;
        }
        y1 y1Var6 = U1;
        if (y1Var6 != null) {
            y1Var6.c();
        }
        com.live.evo.fragment.login.j.g0(getChildFragmentManager(), 22, this.C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean L0() {
        if (M0() && v4.g.e().d()) {
            return true;
        }
        return false;
    }

    private boolean M0() {
        if (v4.g.e().c() && this.B) {
            return true;
        }
        return false;
    }

    private void Q0() {
        if (com.live.evo.l.n().j("bff_show", true)) {
            if (getActivity() != null) {
                if (com.live.evo.l.n().e() == 2) {
                    if (com.live.evo.fragment.a.a().c() != null && com.live.evo.fragment.a.a().c().size() > 0) {
                        if (getActivity() != null) {
                            getActivity().runOnUiThread(new g());
                            return;
                        }
                        return;
                    } else {
                        if (getActivity() != null) {
                            getActivity().runOnUiThread(new e());
                        }
                        com.live.evo.fragment.a.a().b(new f());
                        return;
                    }
                }
                if (getActivity() != null) {
                    getActivity().runOnUiThread(new h());
                    return;
                }
                return;
            }
            return;
        }
        if (getActivity() != null) {
            getActivity().runOnUiThread(new i());
        }
    }

    private void V0() {
        if (h1(com.live.evo.l.n().j("share_code_show", false)) && !TextUtils.isEmpty(com.live.evo.l.n().x())) {
            this.J.setVisibility(0);
            this.L.setText(com.live.evo.l.n().x());
            String strA = com.live.evo.util.p1.a("share_code_remind", com.live.evo.util.x1.j(R$string.share_code_remind));
            if (Build.VERSION.SDK_INT >= 24) {
                this.K.setText(Html.fromHtml(strA, 0));
            } else {
                this.K.setText(Html.fromHtml(strA));
            }
            this.M.setText(com.live.evo.l.n().i("share_code_tips", com.live.evo.util.x1.j(R$string.share_this_code)));
            return;
        }
        this.J.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0() {
        int iE = com.live.evo.l.n().e();
        int iD = com.live.evo.util.s0.f7342a.D();
        if (iE != 1) {
            if (iD != 2 && iD != 6 && iD != 3) {
                y1 y1Var = U1;
                if (y1Var != null) {
                    y1Var.c();
                }
                com.live.evo.fragment.login.j.g0(getChildFragmentManager(), 21, this.C);
                return;
            }
            X0("");
            return;
        }
        if (iD != 2 && iD != 6 && iD != 3) {
            if (iD == 8) {
                y1 y1Var2 = U1;
                if (y1Var2 != null) {
                    y1Var2.c();
                }
                com.live.evo.fragment.login.j.g0(getChildFragmentManager(), 22, this.C);
                return;
            }
            y1 y1Var3 = U1;
            if (y1Var3 != null) {
                y1Var3.c();
            }
            com.live.evo.fragment.login.j.g0(getChildFragmentManager(), 22, this.C);
            return;
        }
        X0("");
    }

    private void i1() {
        boolean z10;
        if (com.live.evo.l.n().F() && !com.live.evo.l.n().E()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getContext() != null && (getContext() instanceof LiveNewActivity)) {
            ((LiveNewActivity) getContext()).D4(z10);
        }
    }

    @Override // com.live.evo.fragment.c
    protected void W(boolean z10) {
        super.W(z10);
    }

    @Override // l5.b
    protected int b0() {
        return R$layout.tabfunction_fragment_myaccount;
    }

    @Override // l5.b
    protected void c0(Bundle bundle) {
        U0();
        P0();
        this.f6604x.setText(com.live.evo.l.n().w());
    }

    @Override // l5.b
    protected void f0(View view) {
        this.f6592l = view.findViewById(R$id.myaccountf_status_layout);
        this.f6593m = view.findViewById(R$id.myaccountf_ll_layout_account);
        this.f6594n = (ImageView) view.findViewById(R$id.myaccountf_iv_account);
        this.f6595o = (TextView) view.findViewById(R$id.myaccountf_tv_account_userid);
        this.f6596p = (TextView) view.findViewById(R$id.myaccountf_tv_account_status);
        this.f6597q = (TextView) view.findViewById(R$id.myaccountf_tv_account_expirydate);
        this.f6598r = (TextView) view.findViewById(R$id.myaccountf_tv_account_expiry);
        this.f6599s = (Button) view.findViewById(R$id.myaccountf_btn_account_bind);
        this.f6600t = (Button) view.findViewById(R$id.myaccountf_btn_account_add_email);
        this.f6603w = view.findViewById(R$id.myaccountf_iv_add_email_area);
        this.f6601u = (TextView) view.findViewById(R$id.myaccountf_iv_add_email_tip);
        this.f6602v = (ImageView) view.findViewById(R$id.myaccountf_iv_add_email_pic);
        this.f6604x = (TextView) view.findViewById(R$id.myaccountf_tv_session);
        this.f6605y = (LinearLayout) view.findViewById(R$id.myaccountf_ll_layout_account_banner);
        this.f6606z = (Banner) view.findViewById(R$id.myaccountf_bn_myaccount_banner);
        this.A = (TextView) view.findViewById(R$id.myaccountf_tv_error);
        this.D = (TextView) view.findViewById(R$id.myaccountf_tv_account_logout);
        this.E = (TextView) view.findViewById(R$id.myaccountf_tv_account_remind);
        this.J = view.findViewById(R$id.myaccountf_ll_sharecode);
        this.L = (TextView) view.findViewById(R$id.myaccountf_tv_sharecode);
        this.K = (TextView) view.findViewById(R$id.myaccountf_tv_sharecode_remind);
        this.M = (TextView) view.findViewById(R$id.myaccountf_tv_sharecode_tip);
        this.N = view.findViewById(R$id.myaccountf_ll_layout_bff);
        this.O = view.findViewById(R$id.myaccountf_bff_user_layout);
        this.P = (TextView) view.findViewById(R$id.myaccountf_bff_title);
        this.Q = view.findViewById(R$id.myaccountf_bff_layout);
        this.R = (ImageView) view.findViewById(R$id.myaccountf_bff_user_iv);
        this.S = (TextView) view.findViewById(R$id.myaccountf_bff_user_tv);
        this.T = (TextView) view.findViewById(R$id.myaccountf_bff_contact_tv);
        this.U = (ImageView) view.findViewById(R$id.myaccountf_bff_logo);
        this.V = (TextView) view.findViewById(R$id.myaccountf_bff_remind);
        this.W = view.findViewById(R$id.myaccountf_bff_otheruser_layout);
        this.X = (TextView) view.findViewById(R$id.myaccountf_otherbff_title);
        this.Y = view.findViewById(R$id.myaccountf_otherbff_layout);
        this.Z = (TextView) view.findViewById(R$id.myaccountf_bff_other_remind1);
        this.f6591b1 = (TextView) view.findViewById(R$id.myaccountf_bff_other_remind2);
        this.E1 = (AdBannerView) view.findViewById(R$id.myaccountf_ad_banner);
        this.K1 = (TextView) view.findViewById(R$id.myaccountf_tv_account_profile_email);
        this.L1 = view.findViewById(R$id.myaccountf_tv_account_profile_area);
        t5.a aVar = new t5.a(getActivity());
        this.D1 = aVar;
        aVar.f(com.live.evo.widget.sloading.c.TRANSLATE_CIRCLE);
        this.D1.g(R$color.sloading_color);
        this.D.getPaint().setFlags(8);
        this.D.getPaint().setAntiAlias(true);
        com.live.evo.util.t.a(this.f6596p);
        com.live.evo.util.t.b(this.f6597q);
        com.live.evo.util.t.b(this.f6598r);
        com.live.evo.util.t.c(this.f6595o);
        com.live.evo.util.t.d(this.f6599s);
        com.live.evo.util.t.b(this.f6604x);
        com.live.evo.util.t.c(this.L);
        com.live.evo.util.t.b(this.M);
        com.live.evo.util.t.d(this.P);
        com.live.evo.util.t.c(this.S);
        com.live.evo.util.t.b(this.T);
        com.live.evo.util.t.b(this.X);
        com.live.evo.util.t.c(this.Z);
        com.live.evo.util.t.b(this.f6591b1);
        R0();
        if (this.C == null) {
            this.C = new k();
        }
    }

    @Override // l5.b, com.live.evo.fragment.c, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.M1 = arguments.getBoolean("isToLogin", false);
        }
    }

    @Override // l5.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        S1 = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        AdBannerView adBannerView;
        AdBannerView adBannerView2;
        if (keyEvent.getAction() == 0) {
            Button button = this.f6599s;
            if (button == null) {
                return true;
            }
            if (i10 == 21) {
                if (button.isFocused()) {
                    if (this.f6605y != null && M0()) {
                        this.f6605y.setVisibility(0);
                    }
                    return true;
                }
            } else if (i10 == 22) {
                if (button.isFocused()) {
                    LinearLayout linearLayout = this.f6605y;
                    if (linearLayout != null && linearLayout.getVisibility() == 0) {
                        if (L0()) {
                            this.f6606z.requestFocus();
                        } else {
                            i0(getView());
                        }
                    } else if (this.F1.size() > 0 && (adBannerView2 = this.E1) != null && adBannerView2.getVisibility() == 0) {
                        this.E1.requestFocus();
                        this.I1 = true;
                        this.E1.isAutoLoop(false);
                        this.E1.stop();
                    } else {
                        i0(getView());
                    }
                    return true;
                }
                if (this.f6605y != null && L0() && ((this.f6605y.isFocused() || this.f6606z.isFocused()) && this.f6605y.getVisibility() == 0)) {
                    i0(getView());
                    return true;
                }
                if (this.F1.size() > 0 && (adBannerView = this.E1) != null && adBannerView.getVisibility() == 0 && this.E1.isFocused()) {
                    if (com.live.evo.util.x1.m(200L)) {
                        return true;
                    }
                    if (this.F1.size() <= 1 || this.H1 == this.F1.size() - 1) {
                        i0(getView());
                    } else {
                        AdBannerView adBannerView3 = this.E1;
                        adBannerView3.setCurrentItem((adBannerView3.getCurrentItem() + 1) % this.E1.getItemCount());
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.live.evo.fragment.c, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.live.evo.fragment.c, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        O0();
    }
}
