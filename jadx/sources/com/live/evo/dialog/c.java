package com.live.evo.dialog;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.R$style;
import com.live.evo.util.m1;
import com.live.evo.util.o0;
import com.live.evo.util.o1;
import com.live.evo.util.x1;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c extends com.live.evo.widget.o implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q6.b f5685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f5686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f5687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private InterfaceC0071c f5688d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Button f5689e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Button f5690f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f5691g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private LinearLayout f5692h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextView f5693i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ImageView f5694j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextView f5695k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private View f5696l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f5697m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private SimpleDateFormat f5698n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private h8.c f5699o;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements j8.c<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int[] f5700a;

        a(int[] iArr) {
            this.f5700a = iArr;
        }

        @Override // j8.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Long l10) {
            int[] iArr = this.f5700a;
            int i10 = iArr[0];
            iArr[0] = i10 - 1;
            long j10 = i10;
            try {
                c.this.g(j10);
            } catch (Exception e10) {
                c.this.f5685a.error("eoc failure", e10);
            }
            if (j10 < 0) {
                c.this.f();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements j8.c<Throwable> {
        b() {
        }

        @Override // j8.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            c.this.f5685a.error("eco count down failure", th);
        }
    }

    /* JADX INFO: renamed from: com.live.evo.dialog.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface InterfaceC0071c {
        void a(int i10);
    }

    public c(@NonNull Context context) {
        this(context, R$style.RechargeAlertialog2);
    }

    public c(@NonNull Context context, @StyleRes int i10) {
        super(context, i10);
        this.f5685a = q6.c.d(c.class);
        this.f5691g = 1000L;
        this.f5697m = true;
        this.f5686b = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        h8.c cVar = this.f5699o;
        if (cVar != null && !cVar.f()) {
            this.f5699o.dispose();
        }
        this.f5697m = false;
        InterfaceC0071c interfaceC0071c = this.f5688d;
        if (interfaceC0071c != null) {
            interfaceC0071c.a(3);
        }
        this.f5695k.setVisibility(0);
        this.f5692h.setVisibility(0);
        this.f5696l.setVisibility(0);
        if (o0.p() != null) {
            this.f5694j.setBackground(o0.p().n());
        }
        this.f5694j.setVisibility(0);
        this.f5689e.requestFocus();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f5694j, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f5693i, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f5687c, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.f5695k, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat4);
        animatorSet.setDuration(2000L);
        animatorSet.start();
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(500L);
        animatorSet2.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        animatorSet2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(long j10) {
        Date date = new Date(j10 * 1000);
        if (this.f5698n == null) {
            this.f5698n = o1.a("mm:ss");
        }
        this.f5687c.setText(this.f5698n.format(date));
    }

    public void e(InterfaceC0071c interfaceC0071c) {
        this.f5688d = interfaceC0071c;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (this.f5697m) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, @NonNull KeyEvent keyEvent) {
        if (this.f5697m) {
            h8.c cVar = this.f5699o;
            if (cVar != null && !cVar.f()) {
                this.f5699o.dispose();
            }
            InterfaceC0071c interfaceC0071c = this.f5688d;
            if (interfaceC0071c != null) {
                interfaceC0071c.a(4);
            }
            dismiss();
        }
        return super.onKeyDown(i10, keyEvent);
    }

    private void d() {
        if (com.live.evo.util.e.b().a()) {
            com.live.evo.util.t.c(this.f5693i);
            com.live.evo.util.t.c(this.f5695k);
            com.live.evo.util.t.c(this.f5687c);
            com.live.evo.util.t.b(this.f5689e);
            com.live.evo.util.t.b(this.f5690f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R$id.countdownl_btn_cancel /* 2131427791 */:
                InterfaceC0071c interfaceC0071c = this.f5688d;
                if (interfaceC0071c != null) {
                    interfaceC0071c.a(1);
                }
                cancel();
                break;
            case R$id.countdownl_btn_sure /* 2131427792 */:
                h8.c cVar = this.f5699o;
                if (cVar != null && !cVar.f()) {
                    this.f5699o.dispose();
                }
                InterfaceC0071c interfaceC0071c2 = this.f5688d;
                if (interfaceC0071c2 != null) {
                    interfaceC0071c2.a(0);
                }
                dismiss();
                break;
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.countdown_layout_d);
        this.f5687c = (TextView) findViewById(R$id.countdownl_tv_time_countdown);
        this.f5689e = (Button) findViewById(R$id.countdownl_btn_sure);
        this.f5690f = (Button) findViewById(R$id.countdownl_btn_cancel);
        this.f5692h = (LinearLayout) findViewById(R$id.countdownl_ll_btn_parent);
        this.f5694j = (ImageView) findViewById(R$id.countdownl_iv_wallpapers);
        this.f5695k = (TextView) findViewById(R$id.countdownl_tv_remind_stop);
        this.f5693i = (TextView) findViewById(R$id.countdownl_tv_remind_start);
        d();
        this.f5696l = findViewById(R$id.countdownl_view_line);
        this.f5689e.setOnClickListener(this);
        this.f5690f.setOnClickListener(this);
        String strI = com.live.evo.l.n().i("start_remind_word", x1.j(R$string.tv_start_remind).replace("\\n", "\n"));
        com.live.evo.l lVarN = com.live.evo.l.n();
        long j10 = com.live.evo.a.f5191k;
        long jH = lVarN.h("remind_time_continue", j10);
        if (jH > 0) {
            j10 = jH;
        }
        if (y4.a.f22397a.booleanValue()) {
            j10 = 10000;
        }
        this.f5699o = m1.b(new a(new int[]{((int) j10) / 1000}), new b(), f8.c.d());
        String strI2 = com.live.evo.l.n().i("stop_remind_word", x1.j(R$string.tv_stop_remind));
        this.f5693i.setText(strI);
        this.f5695k.setText(strI2);
        this.f5697m = true;
        getWindow().setLayout(-1, -1);
        if (com.live.evo.l.n().E()) {
            this.f5689e.setBackground(x1.f(R$drawable.btn_bg_adult_selector));
            this.f5690f.setBackground(x1.f(R$drawable.btn_bg_adult_selector));
        }
    }
}
