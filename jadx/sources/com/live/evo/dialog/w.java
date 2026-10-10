package com.live.evo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.R$style;
import com.live.evo.util.q1;
import com.live.evo.util.x1;
import com.live.evo.widget.BaseButton;
import i5.c0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f5793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Dialog f5794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f5795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private x f5796d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f5797e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private BaseButton f5798f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private BaseButton f5799g;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (w.this.f5794b.isShowing()) {
                w.this.f5794b.dismiss();
            }
            if (w.this.f5796d != null) {
                w.this.f5796d.b();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (w.this.f5794b.isShowing()) {
                w.this.f5794b.dismiss();
            }
            if (w.this.f5796d != null) {
                w.this.f5796d.a();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c implements DialogInterface.OnKeyListener {
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
            if ((i10 != 4 && i10 != 111) || w.this.f5796d == null) {
                return false;
            }
            w.this.f5796d.a();
            return false;
        }

        c() {
        }
    }

    private void c() {
        this.f5798f.setOnClickListener(new a());
        this.f5799g.setOnClickListener(new b());
        this.f5794b.setOnKeyListener(new c());
    }

    private void d() {
        View viewInflate = LayoutInflater.from(this.f5793a).inflate(R$layout.subscribeswitch_dialog, (ViewGroup) null, false);
        this.f5795c = viewInflate;
        this.f5797e = (TextView) viewInflate.findViewById(R$id.subscribeswitchdlg_tv_switch_tips);
        this.f5798f = (BaseButton) this.f5795c.findViewById(R$id.subscribeswitchdlg_btn_sure);
        this.f5799g = (BaseButton) this.f5795c.findViewById(R$id.subscribeswitchdlg_btn_cancel);
        com.live.evo.widget.o oVar = new com.live.evo.widget.o(this.f5793a, R$style.RechargeAlertialog);
        this.f5794b = oVar;
        oVar.setContentView(this.f5795c);
        com.live.evo.util.t.c(this.f5797e);
        com.live.evo.util.t.d(this.f5798f);
        com.live.evo.util.t.d(this.f5799g);
    }

    public boolean e() {
        return this.f5794b.isShowing();
    }

    public void f(x xVar) {
        this.f5796d = xVar;
    }

    public void h() {
        if (!this.f5794b.isShowing()) {
            this.f5794b.show();
        }
        this.f5798f.requestFocus();
    }

    public w(Context context) {
        this.f5793a = context;
        d();
        c();
    }

    public void g(i5.p pVar, c0 c0Var) {
        this.f5797e.setText(String.format(x1.j(R$string.subscribe_switch), c0Var.g(), q1.m(pVar.f().longValue(), x1.j(R$string.HHmm)), pVar.e()));
    }
}
