package com.live.evo.fragment.login;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.util.x1;
import com.live.evo.widget.BaseButton;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class n extends Fragment implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f6279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BaseButton f6280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f6281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f6282d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f6283e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private i f6284f;

    private void R() {
        this.f6280b.setOnClickListener(this);
    }

    private void S() {
        this.f6280b = (BaseButton) this.f6279a.findViewById(R$id.loginfinishminif_btn_start_play);
        this.f6281c = (TextView) this.f6279a.findViewById(R$id.loginfinishminif_tv_remind2);
        this.f6282d = (TextView) this.f6279a.findViewById(R$id.loginfinishminif_tv_remind1);
        this.f6283e = (TextView) this.f6279a.findViewById(R$id.loginfinishminif_tv_remind3);
        this.f6280b.requestFocus();
        com.live.evo.util.t.b(this.f6281c);
        com.live.evo.util.t.b(this.f6283e);
        com.live.evo.util.t.d(this.f6280b);
        com.live.evo.util.t.d(this.f6282d);
    }

    public static n T() {
        return new n();
    }

    public static synchronized void V(FragmentManager fragmentManager, int i10, i iVar) {
        n nVarT = T();
        nVarT.f6284f = iVar;
        fragmentManager.beginTransaction().add(i10, nVarT, "RechargeSuccessminiFragment").commitAllowingStateLoss();
    }

    public void U() {
        String strJ = x1.j(R$string.valid_until);
        this.f6283e.setVisibility(0);
        this.f6283e.setText(t.v.c.i.a.f18646a.H());
        this.f6282d.setText(x1.j(R$string.remind_recharge_successfully));
        this.f6281c.setText(Html.fromHtml(strJ));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i iVar;
        if (view.getId() == 2131428621 && (iVar = this.f6284f) != null) {
            iVar.a(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f6279a = layoutInflater.inflate(R$layout.login_finish_fragment_mini, viewGroup, false);
        S();
        R();
        return this.f6279a;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        U();
    }
}
