package com.live.evo.fragment.login;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.util.p1;
import com.live.evo.util.q1;
import com.live.evo.util.x1;
import com.live.evo.util.z0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class m extends Fragment implements View.OnClickListener, View.OnFocusChangeListener {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static m f6268k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f6269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f6270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f6271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f6272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private e5.f f6273e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f6274f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextView f6275g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextView f6276h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextView f6277i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ImageView f6278j;

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        f6268k = null;
        super.onDestroy();
    }

    private void R() {
        this.f6271c.setOnClickListener(this);
        this.f6272d.setOnClickListener(this);
        this.f6272d.setOnFocusChangeListener(this);
        this.f6271c.setOnFocusChangeListener(this);
        this.f6275g.setOnClickListener(this);
        this.f6276h.setOnClickListener(this);
    }

    private void S() {
        this.f6270b = (TextView) this.f6269a.findViewById(R$id.rechargeremindf_tv_remind);
        this.f6271c = (TextView) this.f6269a.findViewById(R$id.rechargeremindf_tv_now);
        this.f6272d = (TextView) this.f6269a.findViewById(R$id.rechargeremindf_tv_later);
        this.f6274f = (TextView) this.f6269a.findViewById(R$id.rechargeremindf_tv_remind_bottom);
        this.f6275g = (TextView) this.f6269a.findViewById(R$id.rechargeremindf_tv_how_to_recharge);
        this.f6276h = (TextView) this.f6269a.findViewById(R$id.rechargeremindf_tv_register_later);
        this.f6277i = (TextView) this.f6269a.findViewById(R$id.rechargeremindf_ltv_remind_hint);
        this.f6278j = (ImageView) this.f6269a.findViewById(R$id.iv_qr_membersite);
        com.live.evo.util.t.c(this.f6270b);
        com.live.evo.util.t.b(this.f6274f);
        com.live.evo.util.t.b(this.f6277i);
        com.live.evo.util.t.d(this.f6271c);
        com.live.evo.util.t.d(this.f6272d);
        this.f6271c.requestFocus();
    }

    public static m T(int i10, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("arg_remind_type", i10);
        bundle.putString("arg_expiry_duration", str);
        m mVar = new m();
        f6268k = mVar;
        mVar.setArguments(bundle);
        return f6268k;
    }

    public static synchronized void U(FragmentManager fragmentManager, int i10, int i11, String str, e5.f fVar) {
        try {
            m mVarT = T(i11, str);
            mVarT.f6273e = fVar;
            Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag("RechargeRemindFragment");
            FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
            if (fragmentFindFragmentByTag != null) {
                fragmentTransactionBeginTransaction.remove(fragmentFindFragmentByTag);
            }
            fragmentTransactionBeginTransaction.add(i10, mVarT, "RechargeRemindFragment").commitAllowingStateLoss();
        } catch (Throwable th) {
            throw th;
        }
    }

    private void V() {
        e5.f fVar = this.f6273e;
        if (fVar != null) {
            fVar.a(this);
        }
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z10) {
        if (z10) {
            z0.d(view);
        } else {
            z0.g(view);
        }
    }

    private void W() {
        int iQ = com.live.evo.l.n().q();
        e5.f fVar = this.f6273e;
        if (fVar != null) {
            if (iQ == 1) {
                fVar.b(this);
                return;
            }
            if (iQ == 3) {
                if (com.live.evo.l.n().l() < q1.b()) {
                    com.live.evo.l.n().K(false);
                    this.f6273e.c(this, 3);
                    return;
                } else {
                    this.f6273e.a(this);
                    return;
                }
            }
            fVar.b(this);
        }
    }

    private void l() {
        String string;
        int i10;
        String strA;
        this.f6277i.setText(Html.fromHtml(p1.a("how_to_new_title", x1.j(R$string.how_to_renew))));
        String strA2 = "";
        if (getArguments() == null) {
            string = "";
            i10 = 1;
        } else {
            i10 = getArguments().getInt("arg_remind_type");
            string = getArguments().getString("arg_expiry_duration");
            if (string == null) {
                string = "";
            }
        }
        t.v.c.i.a aVar = t.v.c.i.a.f18646a;
        boolean zF0 = aVar.f0();
        int iQ = com.live.evo.l.n().q();
        if (i10 != 1) {
            if (i10 == 2 || i10 == 4 || i10 == 10) {
                this.f6271c.setVisibility(0);
                if (iQ == 1 && zF0) {
                    this.f6271c.setText(x1.j(R$string.input_renewal_code));
                    strA2 = p1.a("remind_expired_by_trial", x1.j(R$string.remind_expired_by_trial));
                } else if (iQ == 3 && zF0) {
                    strA2 = p1.a("remind_expired_by_renewcode", x1.j(R$string.remind_expired_by_renew_code));
                    this.f6271c.setText(x1.j(2131952330));
                } else if (iQ == 0 && zF0) {
                    this.f6271c.setText(x1.j(R$string.recharge_now));
                    strA2 = p1.a("remind_expired_mac", x1.j(R$string.remind_expired_mac));
                } else if (zF0) {
                    this.f6271c.setText(x1.j(R$string.recharge_now));
                    strA2 = p1.a("remind_expired", x1.j(R$string.remind_expired));
                } else {
                    this.f6271c.setVisibility(8);
                    this.f6276h.setVisibility(0);
                }
                this.f6272d.setVisibility(8);
            }
        } else if (iQ == 3 && zF0) {
            strA2 = p1.a("renew_code_near_expired_remind", x1.j(R$string.recharge_remind_in_time_by_renew_code));
            this.f6271c.setText(x1.j(2131952616));
            this.f6272d.setVisibility(8);
            this.f6271c.setVisibility(0);
        } else if (iQ == 1 && zF0) {
            strA2 = p1.a("trial_near_expired_remind", x1.j(R$string.recharge_remind_in_time_by_trial));
            this.f6271c.setText(x1.j(R$string.input_renewal_code));
            this.f6271c.setVisibility(0);
            this.f6272d.setVisibility(0);
            this.f6272d.setText(x1.j(R$string.skip));
        } else if (zF0) {
            strA2 = p1.a("normal_near_expired_remind", x1.j(R$string.recharge_remind_in_time));
            this.f6271c.setText(x1.j(R$string.recharge_now));
            this.f6271c.setVisibility(0);
            this.f6272d.setVisibility(0);
            this.f6272d.setText(x1.j(R$string.recharge_later));
        } else {
            this.f6271c.setVisibility(8);
            this.f6276h.setVisibility(0);
        }
        if (iQ == 0) {
            this.f6271c.setVisibility(8);
        }
        if (iQ == -2 || iQ == 2 || iQ == 6) {
            this.f6275g.setVisibility(8);
        }
        this.f6270b.setText(Html.fromHtml(strA2.replace("${ValidTime}", string)));
        String strN = aVar.N();
        if (!strN.isEmpty() && com.live.evo.l.n().v()) {
            String strA3 = p1.a("recharge_guide", x1.j(R$string.recharge_guide));
            strA = strA3.replace("${MS}", strN).replace("${RS}", aVar.N()).replace("${CS}", aVar.v());
        } else {
            strA = p1.a("recharge_guide", x1.j(R$string.renew_rehargecode_tip));
        }
        this.f6274f.setText(Html.fromHtml(strA));
        this.f6275g.setText(Html.fromHtml("<u>" + x1.j(2131953058) + "</u>"));
        if (com.live.evo.l.n().j("member_qr_display", false)) {
            this.f6278j.setVisibility(0);
            Bitmap bitmapT = com.live.evo.l.n().t(aVar.P());
            if (bitmapT != null) {
                com.live.evo.util.v.b(getContext(), bitmapT, R$drawable.qr_placehodler, this.f6278j);
                return;
            }
            return;
        }
        this.f6278j.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R$id.rechargeremindf_tv_how_to_recharge /* 2131429083 */:
                if (this.f6273e != null) {
                    com.live.evo.l.n().K(false);
                    this.f6273e.c(this, 1);
                }
                break;
            case R$id.rechargeremindf_tv_later /* 2131429084 */:
                V();
                break;
            case R$id.rechargeremindf_tv_now /* 2131429085 */:
                W();
                break;
            case R$id.rechargeremindf_tv_register_later /* 2131429086 */:
                V();
                break;
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f6269a = layoutInflater.inflate(R$layout.recharge_remind_fragment, viewGroup, false);
        S();
        l();
        R();
        return this.f6269a;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        l();
    }
}
