package com.live.evo;

import android.R;
import android.app.Activity;
import android.os.Handler;
import android.widget.PopupWindow;
import com.live.evo.dialog.m;
import com.live.evo.dialog.n;
import com.live.evo.widget.q;
import com.live.evo.widget.s;
import com.live.evo.widget.t;
import com.live.evo.widget.u;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class g {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final q6.b f6951o = q6.c.d(g.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.live.evo.dialog.f f6953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Activity f6954c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Handler f6955d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private q f6956e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private m f6957f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private u f6958g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private s f6961j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f6962k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f6959h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f6960i = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Runnable f6963l = new a();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Runnable f6964m = new b();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Runnable f6965n = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6952a = 10000;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f6961j.dismiss();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.d(g.this);
            throw null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f6956e.dismiss();
        }
    }

    public void s(Object... objArr) {
        i5.h hVar = (i5.h) objArr[0];
        if (this.f6953b.D()) {
            this.f6953b.t();
        } else if (!hVar.p() && com.live.evo.util.b.b(this.f6954c)) {
            this.f6953b.F(hVar);
        }
    }

    private static void f(PopupWindow popupWindow) {
        if (popupWindow != null) {
            try {
                popupWindow.dismiss();
            } catch (Exception e10) {
                f6951o.error(e10.getMessage(), e10);
            }
        }
    }

    private void i() {
        this.f6956e = new q(this.f6954c, this.f6955d);
    }

    private void j(x4.a aVar) {
        if (this.f6953b == null) {
            this.f6953b = new com.live.evo.dialog.f(this.f6954c, null, this.f6955d, aVar);
        }
    }

    private void k() {
        this.f6957f = new m(this.f6954c);
    }

    private void l() {
        s sVar = new s(this.f6954c);
        this.f6961j = sVar;
        sVar.setAnimationStyle(R$style.showPopupAnimation);
        this.f6961j.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.live.evo.f
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                this.f5829a.n();
            }
        });
    }

    private void m() {
        u uVar = new u(this.f6954c);
        this.f6958g = uVar;
        uVar.setAnimationStyle(R$style.showPopupAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        this.f6955d.removeCallbacks(this.f6963l);
    }

    public static g o(Activity activity, Handler handler, x4.a aVar) {
        return new g(activity, handler, aVar);
    }

    public void e() {
        Handler handler = this.f6955d;
        if (handler != null) {
            try {
                handler.removeCallbacks(this.f6965n);
                this.f6955d.removeCallbacks(this.f6964m);
            } catch (Exception unused) {
            }
        }
        f(this.f6956e);
        f(null);
        f(this.f6958g);
    }

    public void g() {
        m mVar = this.f6957f;
        if (mVar == null || !mVar.g()) {
            return;
        }
        this.f6957f.d();
    }

    public boolean h() {
        q qVar = this.f6956e;
        if (qVar == null || !qVar.isShowing()) {
            return false;
        }
        this.f6956e.dismiss();
        this.f6955d.removeCallbacks(this.f6965n);
        return true;
    }

    public void p(i5.h hVar) {
        if (hVar != null) {
            this.f6959h = hVar.j();
            this.f6962k = !hVar.p();
            this.f6960i = hVar.p();
        }
    }

    public void q(n nVar) {
        if (this.f6957f.g()) {
            return;
        }
        this.f6957f.h(nVar);
        this.f6957f.i();
    }

    public void r(i5.h hVar, int i10, int i11, int i12) {
        if (com.live.evo.util.b.b(this.f6954c)) {
            if (this.f6956e.isShowing()) {
                this.f6955d.removeCallbacks(this.f6965n);
            }
            if (hVar == null) {
                return;
            }
            this.f6956e.s(hVar, i12);
            this.f6956e.showAtLocation(this.f6954c.findViewById(R.id.content), 80, 0, 1);
            this.f6956e.q();
            this.f6955d.postDelayed(this.f6965n, this.f6952a);
            if (this.f6956e.isShowing()) {
                this.f6955d.removeCallbacks(this.f6965n);
            }
            this.f6956e.s(hVar, i12);
            this.f6956e.showAtLocation(this.f6954c.findViewById(R.id.content), 80, 0, 1);
            this.f6956e.q();
            this.f6955d.postDelayed(this.f6965n, this.f6952a);
        }
    }

    public void t() {
        if (this.f6961j.isShowing()) {
            this.f6961j.dismiss();
            return;
        }
        if (k.b().d()) {
            this.f6961j.e(this.f6959h, this.f6962k, this.f6960i);
        }
        this.f6961j.showAtLocation(this.f6954c.findViewById(R.id.content), 5, 0, 0);
        this.f6955d.postDelayed(this.f6963l, TimeUnit.MINUTES.toMillis(1L));
    }

    public void u(boolean z10) {
        Activity activity;
        if (!z10) {
            if (this.f6958g.isShowing()) {
                this.f6958g.dismiss();
            }
        } else {
            if (!com.live.evo.util.b.b(this.f6954c) || this.f6958g.isShowing() || (activity = this.f6954c) == null) {
                return;
            }
            this.f6958g.showAtLocation(activity.findViewById(R.id.content), 51, 0, 0);
        }
    }

    private g(Activity activity, Handler handler, x4.a aVar) {
        this.f6954c = activity;
        this.f6955d = handler;
        l();
        k();
        i();
        j(aVar);
        m();
    }

    static /* bridge */ /* synthetic */ t d(g gVar) {
        gVar.getClass();
        return null;
    }
}
