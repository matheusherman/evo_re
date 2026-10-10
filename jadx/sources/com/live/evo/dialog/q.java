package com.live.evo.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$style;
import com.live.evo.util.r0;
import com.live.evo.widget.BaseButton;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f5755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Dialog f5756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f5757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f5758d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private BaseButton f5759e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private BaseButton f5760f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private LinearLayout f5761g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ImageView f5762h;

    private void d() {
        this.f5759e.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo.dialog.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f5753a.g(view);
            }
        });
        this.f5760f.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo.dialog.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f5754a.h(view);
            }
        });
    }

    private void e() {
        View viewInflate = LayoutInflater.from(this.f5755a).inflate(R$layout.notice_alert_dialog, (ViewGroup) null, false);
        this.f5757c = viewInflate;
        this.f5758d = (TextView) viewInflate.findViewById(R$id.noticealertdlg_tv_title);
        this.f5759e = (BaseButton) this.f5757c.findViewById(R$id.noticealertdlg_btn_ok);
        this.f5760f = (BaseButton) this.f5757c.findViewById(R$id.noticealertdlg_btn_direct);
        this.f5761g = (LinearLayout) this.f5757c.findViewById(R$id.noticealertdlg_tv_layout);
        this.f5762h = (ImageView) this.f5757c.findViewById(R$id.noticealertdlg_iv);
        com.live.evo.widget.o oVar = new com.live.evo.widget.o(this.f5755a, R$style.RechargeAlertialog);
        this.f5756b = oVar;
        oVar.setContentView(this.f5757c);
        com.live.evo.util.t.c(this.f5758d);
        com.live.evo.util.t.d(this.f5759e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(View view) {
        if (this.f5756b.isShowing()) {
            this.f5756b.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(View view) {
        Context context = this.f5755a;
        if (context instanceof Activity) {
            r0.f7337a.d((Activity) context, null);
        }
        if (this.f5756b.isShowing()) {
            this.f5756b.dismiss();
        }
    }

    public void c() {
        if (this.f5756b.isShowing()) {
            this.f5756b.dismiss();
        }
    }

    public boolean f() {
        return this.f5756b.isShowing();
    }

    public q(Context context) {
        this.f5755a = context;
        e();
        d();
    }
}
