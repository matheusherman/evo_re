package com.live.evo.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.R$style;
import com.live.evo.util.q1;
import com.live.evo.util.x1;
import com.live.evo.widget.BaseButton;
import i5.c0;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f5777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f5778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f5779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.live.evo.widget.o f5780d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ImageView f5781e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f5782f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextView f5783g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private BaseButton f5784h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private BaseButton f5785i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private TextView f5786j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Timer f5789m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private TimerTask f5790n;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f5787k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f5788l = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f5791o = -1;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface a {
        void a();

        void b(int i10);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class b extends TimerTask {
        /* synthetic */ b(u uVar, v vVar) {
            this();
        }

        private b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            u.this.f5791o--;
            u.this.f5786j.setText(u.this.k());
            if (u.this.f5791o <= 0) {
                u.this.f5788l = true;
                u.this.f5780d.dismiss();
                if (u.this.f5778b != null) {
                    u.this.f5778b.a();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(View view) {
        this.f5788l = true;
        if (this.f5780d.isShowing()) {
            this.f5780d.dismiss();
        }
        a aVar = this.f5778b;
        if (aVar != null) {
            aVar.b(this.f5787k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(View view) {
        this.f5788l = true;
        if (this.f5780d.isShowing()) {
            this.f5780d.dismiss();
        }
        a aVar = this.f5778b;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void p(c0 c0Var) {
        this.f5788l = false;
        this.f5787k = c0Var.f();
        c0Var.a();
        Long lH = c0Var.h();
        Long lJ = c0Var.j();
        String strM = q1.m(lH.longValue(), x1.j(R$string.HHmm));
        String strM2 = q1.m(lJ.longValue(), x1.j(R$string.HHmm));
        String strG = c0Var.g();
        c0Var.b();
        com.live.evo.util.v.d(this.f5777a, c0Var.e(), this.f5781e);
        if (TextUtils.isEmpty(strG)) {
            strG = x1.j(R$string.epg_none);
        }
        this.f5783g.setText(strG);
        this.f5782f.setText(strM + "--" + strM2);
        int iLongValue = (int) ((lJ.longValue() - q1.b()) / 1000);
        this.f5791o = iLongValue;
        if (iLongValue <= 0) {
            this.f5791o = 20;
        }
        this.f5786j.setText(k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String k() {
        int i10 = this.f5791o;
        if (i10 > 0) {
            return i10 < 3600 ? String.format("%1$02d:%2$02d", Integer.valueOf(i10 / 60), Integer.valueOf(i10 % 60)) : String.format("%1$02d:%2$02d:%3$02d", Integer.valueOf(i10 / 3600), Integer.valueOf((i10 % 3600) / 60), Integer.valueOf(i10 % 60));
        }
        return "00:00";
    }

    private void l() {
        this.f5784h.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo.dialog.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f5775a.n(view);
            }
        });
        this.f5785i.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo.dialog.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f5776a.o(view);
            }
        });
    }

    private void m() {
        this.f5779c = LayoutInflater.from(this.f5777a).inflate(R$layout.popup_subscribe, (ViewGroup) null);
        com.live.evo.widget.o oVar = new com.live.evo.widget.o(this.f5777a, R$style.RechargeAlertialog);
        this.f5780d = oVar;
        oVar.setContentView(this.f5779c);
        this.f5780d.setCancelable(false);
        this.f5780d.setCanceledOnTouchOutside(false);
        this.f5781e = (ImageView) this.f5779c.findViewById(R$id.popupsubscribe_iv_icon);
        this.f5782f = (TextView) this.f5779c.findViewById(R$id.popupsubscribe_tv_time);
        this.f5783g = (TextView) this.f5779c.findViewById(R$id.popupsubscribe_mtv_program);
        this.f5784h = (BaseButton) this.f5779c.findViewById(R$id.popupsubscribe_btn_watch);
        this.f5785i = (BaseButton) this.f5779c.findViewById(R$id.popupsubscribe_btn_ignore);
        TextView textView = (TextView) this.f5779c.findViewById(R$id.popupsubscribe_tv_timecount);
        this.f5786j = textView;
        textView.setVisibility(4);
        if (com.live.evo.util.e.b().a()) {
            com.live.evo.util.t.b(this.f5782f);
            com.live.evo.util.t.c(this.f5783g);
            com.live.evo.util.t.b(this.f5786j);
            com.live.evo.util.t.b(this.f5784h);
            com.live.evo.util.t.b(this.f5785i);
            return;
        }
        com.live.evo.util.t.c(this.f5782f);
        com.live.evo.util.t.c(this.f5783g);
        com.live.evo.util.t.b(this.f5786j);
        com.live.evo.util.t.d(this.f5784h);
        com.live.evo.util.t.d(this.f5785i);
    }

    private void s() {
        Timer timer = this.f5789m;
        if (timer != null) {
            timer.cancel();
            this.f5789m = null;
        }
        TimerTask timerTask = this.f5790n;
        if (timerTask != null) {
            timerTask.cancel();
            this.f5790n = null;
        }
    }

    public void q() {
        if (!this.f5780d.isShowing()) {
            this.f5780d.show();
        }
        r();
    }

    public u(Context context, a aVar) {
        this.f5777a = context;
        this.f5778b = aVar;
        m();
        l();
    }

    private void r() {
        s();
        this.f5789m = new Timer();
        b bVar = new b(this, null);
        this.f5790n = bVar;
        this.f5789m.schedule(bVar, 0L, 1000L);
    }

    public void j() {
        s();
        if (this.f5788l && this.f5780d.isShowing()) {
            this.f5780d.dismiss();
        }
    }
}
