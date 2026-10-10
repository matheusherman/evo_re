package com.live.evo.fragment.login;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.p000lifecycle.CoroutineLiveDataKt;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.util.p1;
import com.live.evo.util.x1;
import com.live.evo.util.z0;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class h extends Fragment implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f6209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Button f6210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f6211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f6212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f6213e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f6214f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f6215g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private a f6216h;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public class a extends CountDownTimer {
        a(long j10, long j11) {
            super(j10, j11);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            h.this.Y();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
            h.this.Z(j10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface b {
        void a(Fragment fragment);
    }

    private void T() {
        this.f6210b.setOnClickListener(this);
    }

    private void U() {
        this.f6210b = (Button) this.f6209a.findViewById(R$id.loginfinishf_btn_start_play);
        this.f6211c = (TextView) this.f6209a.findViewById(R$id.loginfinishf_tv_remind2);
        this.f6212d = (TextView) this.f6209a.findViewById(R$id.loginfinishf_tv_remind1);
        this.f6213e = (TextView) this.f6209a.findViewById(R$id.loginfinishf_tv_remind3);
        this.f6210b.requestFocus();
        com.live.evo.util.t.b(this.f6211c);
        com.live.evo.util.t.b(this.f6213e);
        com.live.evo.util.t.d(this.f6210b);
        com.live.evo.util.t.d(this.f6212d);
        z0.f(this.f6210b);
    }

    public static h V(int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt("arg_remind_type", i10);
        h hVar = new h();
        hVar.setArguments(bundle);
        return hVar;
    }

    public static synchronized void X(FragmentManager fragmentManager, int i10, int i11, b bVar) {
        h hVarV = V(i11);
        hVarV.f6214f = bVar;
        fragmentManager.beginTransaction().add(i10, hVarV, "LoginFinishFragment_TAG").commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        b bVar = this.f6214f;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(long j10) {
        try {
            this.f6210b.setText(x1.j(R$string.to_recharge) + "(" + TimeUnit.MILLISECONDS.toSeconds(j10) + "s)");
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x00e3  */
    public void W() {
        h hVar;
        String strJ;
        int i10 = getArguments().getInt("arg_remind_type");
        this.f6215g = i10;
        if (i10 != 0) {
            if (i10 != 3) {
                switch (i10) {
                    case 5:
                        hVar = this;
                        hVar.f6213e.setVisibility(4);
                        hVar.f6211c.setVisibility(0);
                        hVar.f6211c.setText(x1.j(R$string.remind_register));
                        strJ = x1.j(R$string.register_success);
                        hVar.f6210b.setText(R$string.watch_now);
                        break;
                    case 6:
                        hVar = this;
                        hVar.f6213e.setVisibility(4);
                        hVar.f6211c.setVisibility(4);
                        strJ = x1.j(R$string.reset_pwd);
                        hVar.f6210b.setText(R$string.watch_now);
                        break;
                    case 7:
                    case 10:
                        this.f6213e.setVisibility(4);
                        this.f6212d.setVisibility(0);
                        strJ = x1.j(R$string.register_success);
                        this.f6211c.setVisibility(0);
                        this.f6211c.setText(x1.j(R$string.remind_register));
                        this.f6210b.setText(R$string.watch_now);
                        a aVar = this.f6216h;
                        if (aVar == null) {
                            hVar = this;
                            a aVar2 = hVar.new a(CoroutineLiveDataKt.DEFAULT_TIMEOUT, 1000L);
                            hVar.f6216h = aVar2;
                            aVar2.start();
                        } else {
                            hVar = this;
                            aVar.cancel();
                            hVar.f6216h.start();
                        }
                        break;
                    case 8:
                        this.f6213e.setVisibility(4);
                        this.f6211c.setVisibility(0);
                        this.f6211c.setText(Html.fromHtml(p1.a("renew_code_bind_success", x1.j(R$string.remind_bind_renewal_code)).replace("${AccountName}", com.live.evo.l.n().d())));
                        strJ = x1.j(R$string.register_success);
                        this.f6210b.setText(R$string.watch_now);
                        hVar = this;
                        break;
                    case 9:
                        strJ = x1.j(R$string.renewal_code_first_time_login_remind1);
                        this.f6213e.setVisibility(0);
                        this.f6213e.setText(com.live.evo.l.n().m());
                        this.f6211c.setVisibility(0);
                        this.f6211c.setText(x1.j(R$string.renewal_code_first_time_login_remind2));
                        this.f6210b.setText(R$string.watch_now);
                        hVar = this;
                        break;
                    default:
                        strJ = "";
                        hVar = this;
                        break;
                }
            } else {
                hVar = this;
                hVar.f6213e.setVisibility(4);
                hVar.f6211c.setVisibility(0);
                hVar.f6211c.setText(x1.j(R$string.remind_register));
                strJ = x1.j(R$string.register_success);
                hVar.f6210b.setText(R$string.watch_now);
            }
        } else {
            hVar = this;
            strJ = x1.j(R$string.recharge_success);
            hVar.f6213e.setVisibility(0);
            hVar.f6213e.setText(com.live.evo.l.n().m());
            hVar.f6211c.setVisibility(0);
            hVar.f6211c.setText(R$string.valid_until);
            hVar.f6210b.setText(R$string.watch_now);
        }
        hVar.f6212d.setText(Html.fromHtml(strJ));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131428615) {
            return;
        }
        a aVar = this.f6216h;
        if (aVar != null) {
            aVar.cancel();
        }
        Y();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f6209a = layoutInflater.inflate(R$layout.login_finish_fragment, viewGroup, false);
        U();
        T();
        return this.f6209a;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        W();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        a aVar = this.f6216h;
        if (aVar != null) {
            aVar.cancel();
        }
    }
}
