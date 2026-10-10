package com.live.evo.fragment.login;

import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.live.evo.R$color;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.util.x1;
import com.live.evo.util.z0;
import ziyi.kit.keyboard.KeyUtils;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class l extends Fragment implements View.OnClickListener, com.live.evo.fragment.login.presenter.h, View.OnFocusChangeListener {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static l f6249o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f6250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f6251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f6252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.live.evo.fragment.login.presenter.i f6253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private EditText f6254e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f6255f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextView f6256g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private k f6257h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextView f6258i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private t5.a f6259j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextView f6260k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ImageView f6261l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ziyi.kit.keyboard.b f6262m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Window f6263n;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements View.OnFocusChangeListener {
        a() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            if (!z10) {
                z0.h(l.this.f6256g);
            } else {
                z0.i(l.this.f6256g);
                l.this.f6256g.setVisibility(0);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (!TextUtils.isEmpty(editable) && editable.length() >= 19) {
                l.this.f6254e.setBackground(x1.f(R$drawable.recharge_mini_full));
                l.this.f6254e.setTextColor(x1.e(R$color.recharge_fill_text_color));
                l.this.f6252c.setEnabled(true);
                l.this.f6252c.setFocusable(true);
                return;
            }
            l.this.f6254e.setTextColor(x1.e(R$color.text_color_et_selector_focus));
            l.this.f6254e.setBackground(x1.f(R$drawable.load_et_selector));
            l.this.f6252c.setEnabled(false);
            l.this.f6252c.setFocusable(false);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c implements View.OnKeyListener {
        c() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            if (l.this.f6262m != null && keyEvent.getAction() == 0 && (i10 == 23 || i10 == 66)) {
                if (view.getId() != 2131429069) {
                    return false;
                }
                l.this.f6262m.m0();
                return true;
            }
            if (l.this.f6262m != null && keyEvent.getAction() == 1 && (i10 == 23 || i10 == 66)) {
                return view.getId() == 2131429069;
            }
            if (l.this.f6262m == null || keyEvent.getAction() != 1) {
                return false;
            }
            if ((i10 != 4 && i10 != 111) || view.getId() != 2131429069 || l.this.f6262m.getVisibility() != 0) {
                return false;
            }
            l.this.f6262m.p();
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class d implements com.live.evo.dialog.r.c {
        d() {
        }

        @Override // com.live.evo.dialog.r.c
        public void b() {
            l.this.f6254e.requestFocus();
            l.this.f6254e.setSelection(l.this.f6254e.getText().length());
        }

        @Override // com.live.evo.dialog.r.c
        public void a() {
        }
    }

    private void V() {
        this.f6252c.setOnFocusChangeListener(this);
        this.f6252c.setOnClickListener(this);
        this.f6258i.setOnFocusChangeListener(new a());
        this.f6254e.addTextChangedListener(new b());
        this.f6254e.setOnKeyListener(new c());
    }

    private void W() {
        this.f6251b = (TextView) this.f6250a.findViewById(R$id.rechargeminif_tv_remind);
        this.f6252c = (TextView) this.f6250a.findViewById(R$id.rechargeminif_tv_confirm);
        this.f6255f = (TextView) this.f6250a.findViewById(R$id.rechargeminif_tv_username);
        this.f6254e = (EditText) this.f6250a.findViewById(R$id.rechargeminif_ret_cardnum);
        this.f6256g = (TextView) this.f6250a.findViewById(R$id.rechargeminif_tv_remind_bottom);
        this.f6258i = (TextView) this.f6250a.findViewById(R$id.rechargeminif_tv_how_to_recharge);
        this.f6260k = (TextView) this.f6250a.findViewById(R$id.rechargeminif_tv_remind_hint);
        this.f6261l = (ImageView) this.f6250a.findViewById(R$id.rechargeminif_iv_qr_membersite);
        t5.a aVar = new t5.a(getActivity());
        this.f6259j = aVar;
        aVar.f(com.live.evo.widget.sloading.c.TRANSLATE_CIRCLE);
        this.f6259j.g(R$color.sloading_color);
        com.live.evo.util.t.b(this.f6251b);
        com.live.evo.util.t.d(this.f6252c);
        com.live.evo.util.t.b(this.f6255f);
        com.live.evo.util.t.d(this.f6254e);
        com.live.evo.util.t.b(this.f6256g);
        com.live.evo.util.t.b(this.f6258i);
        ziyi.kit.keyboard.b bVar = this.f6262m;
        if (bVar != null) {
            bVar.l(this.f6254e);
        }
    }

    public static l X() {
        if (f6249o == null) {
            f6249o = new l();
        }
        return f6249o;
    }

    public static synchronized void Y(FragmentManager fragmentManager, Window window, int i10, k kVar) {
        try {
            l lVarX = X();
            lVarX.f6257h = kVar;
            lVarX.f6263n = window;
            Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag("RechargeMiniFragment");
            FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
            if (fragmentFindFragmentByTag == null) {
                fragmentTransactionBeginTransaction.add(i10, lVarX, "RechargeMiniFragment").commitAllowingStateLoss();
            } else {
                fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag).commitAllowingStateLoss();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.live.evo.fragment.login.presenter.h
    public void a() {
        this.f6259j.d();
    }

    @Override // com.live.evo.fragment.login.presenter.h
    public void b() {
        this.f6259j.h();
    }

    @Override // com.live.evo.fragment.login.presenter.h
    public void e() {
        this.f6254e.setText("");
        k kVar = this.f6257h;
        if (kVar != null) {
            kVar.b(this);
        }
    }

    @Override // com.live.evo.fragment.login.presenter.h
    public void i(String str, String str2) {
        String str3;
        com.live.evo.dialog.r rVar = new com.live.evo.dialog.r(getActivity(), new d());
        rVar.k(x1.j(R$string.recharge_fail));
        if (TextUtils.isEmpty(str2)) {
            str3 = "";
        } else {
            str3 = x1.j(2131952013) + str2;
        }
        rVar.j(str, str3);
        rVar.l();
    }

    @Override // com.live.evo.fragment.login.presenter.h
    public void n(String str) {
        this.f6255f.setText(str);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        com.live.evo.fragment.login.presenter.i iVar = this.f6253d;
        if (iVar != null) {
            iVar.u();
        }
        super.onDestroy();
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z10) {
        if (z10) {
            z0.d(view);
        } else {
            z0.g(view);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        this.f6254e.setText("");
        super.onStop();
    }

    private void l() {
        if (com.live.evo.l.n().v()) {
            String strJ = x1.j(R$string.how_to_renew);
            this.f6260k.setText(Html.fromHtml(strJ));
            this.f6251b.setText(Html.fromHtml(x1.j(R$string.recharge_code_remind)));
            String strJ2 = x1.j(R$string.recharge_guide);
            t.v.c.i.a aVar = t.v.c.i.a.f18646a;
            String strN = aVar.N();
            this.f6256g.setText(Html.fromHtml(strJ2.replace("${MS}", strN).replace("${RS}", strN).replace("${CS}", aVar.v())));
            this.f6258i.setText(Html.fromHtml(strJ));
        } else {
            String strJ3 = x1.j(R$string.how_to_buy_play);
            this.f6260k.setText(Html.fromHtml(strJ3));
            this.f6251b.setText(Html.fromHtml(x1.j(R$string.recharge_code_remind)));
            String strJ4 = x1.j(R$string.payment_guide_rechargecode);
            t.v.c.i.a aVar2 = t.v.c.i.a.f18646a;
            String strN2 = aVar2.N();
            this.f6256g.setText(Html.fromHtml(strJ4.replace("${MS}", strN2).replace("${RS}", strN2).replace("${CS}", aVar2.v())));
            this.f6258i.setText(Html.fromHtml(strJ3));
        }
        this.f6253d.z();
        this.f6255f.setText(t.v.c.i.a.f18646a.Z());
        this.f6261l.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == 2131429070 && this.f6252c.isEnabled()) {
            this.f6254e.getText().toString().getClass();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f6250a = layoutInflater.inflate(R$layout.recharge_mini_fragment, viewGroup, false);
        this.f6262m = KeyUtils.t(this.f6263n, getContext(), this.f6250a, getLifecycle(), false);
        com.live.evo.fragment.login.presenter.i iVar = new com.live.evo.fragment.login.presenter.i();
        this.f6253d = iVar;
        iVar.B(this);
        W();
        l();
        V();
        return this.f6250a;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        l();
    }
}
