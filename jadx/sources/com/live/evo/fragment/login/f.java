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
import androidx.fragment.app.FragmentTransaction;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.util.x1;
import com.live.evo.widget.BaseButton;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class f extends com.live.evo.fragment.c implements View.OnClickListener, e5.a.InterfaceC0175a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static f f6169n;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f6170f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextView f6171g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextView f6172h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextView f6173i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private TextView f6174j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private BaseButton f6175k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private BaseButton f6176l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private a f6177m;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface a {
        void a(Fragment fragment, int i10);
    }

    @Override // e5.a.InterfaceC0175a
    public boolean H() {
        d0(1);
        return true;
    }

    private void a0() {
        this.f6175k.setNextFocusRightId(R$id.btn_checkaccount_cancel);
        this.f6176l.setNextFocusLeftId(R$id.btn_checkaccount_ok);
        this.f6175k.setOnClickListener(this);
        this.f6176l.setOnClickListener(this);
        this.f6173i.setOnClickListener(this);
    }

    private void b0() {
        this.f6171g = (TextView) this.f6170f.findViewById(R$id.bindtipf_tv_tip_title);
        this.f6172h = (TextView) this.f6170f.findViewById(R$id.bindtipf_tv_tip_remind);
        this.f6175k = (BaseButton) this.f6170f.findViewById(R$id.bindtipf_btn_bindemail);
        this.f6176l = (BaseButton) this.f6170f.findViewById(R$id.bindtipf_btn_bindlater);
        this.f6173i = (TextView) this.f6170f.findViewById(R$id.bindtipf_tv_not_tip);
        this.f6174j = (TextView) this.f6170f.findViewById(R$id.bindtipf_tv_error);
        this.f6173i.getPaint().setFlags(8);
        com.live.evo.util.t.b(this.f6171g);
        com.live.evo.util.t.b(this.f6172h);
        com.live.evo.util.t.b(this.f6175k);
        com.live.evo.util.t.b(this.f6176l);
        com.live.evo.util.t.b(this.f6173i);
        com.live.evo.util.t.b(this.f6174j);
    }

    public static f c0() {
        if (f6169n == null) {
            f6169n = new f();
        }
        return f6169n;
    }

    private void d0(int i10) {
        this.f6174j.setVisibility(4);
        a aVar = this.f6177m;
        if (aVar != null) {
            aVar.a(this, i10);
        }
    }

    public static synchronized void e0(FragmentManager fragmentManager, int i10, a aVar) {
        try {
            f fVarC0 = c0();
            Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag("BindAccountTipFragment");
            FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
            fVarC0.f6177m = aVar;
            if (fragmentFindFragmentByTag == null) {
                fragmentTransactionBeginTransaction.add(i10, fVarC0, "BindAccountTipFragment").commitAllowingStateLoss();
            } else {
                fVarC0.l();
                fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag).commitAllowingStateLoss();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void l() {
        this.f6171g.setText(x1.j(R$string.tip_bind_title));
        this.f6172h.setText(Html.fromHtml(x1.j(R$string.tip_bind_remind)));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R$id.bindtipf_btn_bindemail /* 2131427573 */:
                d0(0);
                break;
            case R$id.bindtipf_btn_bindlater /* 2131427574 */:
                d0(1);
                break;
            case R$id.bindtipf_tv_not_tip /* 2131427578 */:
                d0(2);
                break;
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f6170f = layoutInflater.inflate(R$layout.fragment_bindaccount_tip, viewGroup, false);
        b0();
        l();
        a0();
        return this.f6170f;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.live.evo.fragment.c, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }
}
