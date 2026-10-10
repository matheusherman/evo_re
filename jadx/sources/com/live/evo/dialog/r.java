package com.live.evo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$style;
import com.live.evo.widget.BaseButton;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f5763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f5764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ImageView f5765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f5766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f5767e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private BaseButton f5768f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Dialog f5769g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private c f5770h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextView f5771i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private BaseButton f5772j;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (r.this.f5770h != null) {
                r.this.f5770h.b();
                r.this.f5769g.dismiss();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (r.this.f5770h != null) {
                r.this.f5770h.a();
                r.this.f5769g.dismiss();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface c {
        void a();

        void b();
    }

    private void d() {
        com.live.evo.widget.o oVar = new com.live.evo.widget.o(this.f5763a, R$style.RechargeAlertialog);
        this.f5769g = oVar;
        oVar.setContentView(this.f5764b);
    }

    private void e() {
        this.f5768f.setOnClickListener(new a());
        this.f5772j.setOnClickListener(new b());
    }

    private void f() {
        View viewInflate = LayoutInflater.from(this.f5763a).inflate(R$layout.remind_alert_dialog, (ViewGroup) null, false);
        this.f5764b = viewInflate;
        this.f5765c = (ImageView) viewInflate.findViewById(R$id.remindalertdlg_iv_recharge_img);
        this.f5766d = (TextView) this.f5764b.findViewById(R$id.remindalertdlg_tv_title);
        this.f5767e = (TextView) this.f5764b.findViewById(R$id.remindalertdlg_tv_reason);
        this.f5768f = (BaseButton) this.f5764b.findViewById(R$id.remindalertdlg_btn_right);
        this.f5772j = (BaseButton) this.f5764b.findViewById(R$id.remindalertdlg_btn_return);
        this.f5771i = (TextView) this.f5764b.findViewById(R$id.remindalertdlg_tv_code);
        com.live.evo.util.t.d(this.f5766d);
        com.live.evo.util.t.c(this.f5767e);
        com.live.evo.util.t.c(this.f5771i);
        com.live.evo.util.t.d(this.f5768f);
    }

    public void c() {
        this.f5765c.setVisibility(8);
    }

    public void g(String str) {
        this.f5772j.setVisibility(0);
        this.f5772j.setText(str);
    }

    public void h(String str) {
        this.f5768f.setVisibility(0);
        this.f5768f.setText(str);
    }

    public void i(int i10) {
        ImageView imageView;
        if (i10 <= 0 || (imageView = this.f5765c) == null) {
            return;
        }
        imageView.setVisibility(0);
        this.f5765c.setBackgroundResource(i10);
    }

    public void l() {
        this.f5769g.show();
    }

    public r(Context context, c cVar) {
        this.f5763a = context;
        this.f5770h = cVar;
        f();
        d();
        e();
    }

    public void j(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f5767e.setText(str);
            if (str2 != null) {
                this.f5771i.setText(str2);
            }
        }
    }

    public void k(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f5766d.setText(str);
    }
}
