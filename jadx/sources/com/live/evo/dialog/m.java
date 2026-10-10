package com.live.evo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$style;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f5744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Dialog f5745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f5746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private n f5747d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f5748e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Button f5749f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Button f5750g;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (m.this.f5745b.isShowing()) {
                m.this.f5745b.dismiss();
            }
            if (m.this.f5747d != null) {
                m.this.f5747d.a();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (m.this.f5745b.isShowing()) {
                m.this.f5745b.dismiss();
            }
        }
    }

    private void e() {
        this.f5749f.setOnClickListener(new a());
        this.f5750g.setOnClickListener(new b());
    }

    private void f() {
        View viewInflate = LayoutInflater.from(this.f5744a).inflate(R$layout.exit_dialog, (ViewGroup) null, false);
        this.f5746c = viewInflate;
        this.f5748e = (TextView) viewInflate.findViewById(R$id.exitdlg_tv_exit);
        this.f5749f = (Button) this.f5746c.findViewById(R$id.exitdlg_btn_sure);
        this.f5750g = (Button) this.f5746c.findViewById(R$id.exitdlg_btn_cancel);
        com.live.evo.widget.o oVar = new com.live.evo.widget.o(this.f5744a, R$style.RechargeAlertialog);
        this.f5745b = oVar;
        oVar.setContentView(this.f5746c);
        com.live.evo.util.t.c(this.f5748e);
        if (com.live.evo.util.e.b().a()) {
            com.live.evo.util.t.b(this.f5749f);
            com.live.evo.util.t.b(this.f5750g);
        } else {
            com.live.evo.util.t.d(this.f5749f);
            com.live.evo.util.t.d(this.f5750g);
        }
    }

    public void c() {
        if (this.f5745b.isShowing()) {
            this.f5745b.dismiss();
        }
    }

    public void d() {
        if (this.f5745b.isShowing()) {
            this.f5745b.dismiss();
        }
    }

    public boolean g() {
        return this.f5745b.isShowing();
    }

    public void h(n nVar) {
        this.f5747d = nVar;
    }

    public void i() {
        if (!this.f5745b.isShowing()) {
            this.f5745b.show();
        }
        this.f5749f.requestFocus();
    }

    public m(Context context) {
        this.f5744a = context;
        f();
        e();
    }
}
