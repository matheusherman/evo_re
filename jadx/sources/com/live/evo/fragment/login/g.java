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
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.tabs.TabLayout;
import com.live.evo.R$color;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.util.a0;
import com.live.evo.util.x1;
import com.live.evo.util.z0;
import com.live.evo.widget.BaseButton;
import com.live.evo.widget.EmailAutoCompleteTextView;
import com.live.evo.widget.RemoveKeyCodeEnterEditText;
import java.util.ArrayList;
import java.util.List;
import ziyi.kit.keyboard.KeyUtils;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class g extends Fragment implements View.OnClickListener, com.live.evo.fragment.login.presenter.a, View.OnFocusChangeListener, e5.a.InterfaceC0175a {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static g f6178z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f6180b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TabLayout f6181c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f6182d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f6183e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f6184f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextView f6185g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private EmailAutoCompleteTextView f6186h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private LinearLayout f6187i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private BaseButton f6188j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private BaseButton f6189k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private com.live.evo.fragment.login.presenter.b f6190l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private f f6191m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f6192n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private t5.a f6193o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private o5.d f6194p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f6195q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f6196r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f6197s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f6198t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f6199u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private RemoveKeyCodeEnterEditText f6201w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Window f6202x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<Integer> f6179a = new a();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ziyi.kit.keyboard.b f6200v = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private View.OnKeyListener f6203y = new e();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends ArrayList {
        a() {
            add(1);
            add(2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            g.this.f6185g.setVisibility(4);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c implements TabLayout.OnTabSelectedListener {
        c() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            g.this.X(TextUtils.equals(tab.getText(), x1.j(R$string.bind_phone)));
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class d implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6206a;

        d(int i10) {
            this.f6206a = i10;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            if (!z10 || view == null) {
                return;
            }
            boolean zEquals = TextUtils.equals(g.this.f6181c.getTabAt(this.f6206a).getText(), x1.j(R$string.bind_phone));
            g.this.f6181c.getTabAt(this.f6206a).select();
            g.this.X(zEquals);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class e implements View.OnKeyListener {
        e() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            View childAt;
            View childAt2;
            int id2;
            TabLayout.Tab tabAt = g.this.f6181c.getTabAt(0);
            TabLayout.Tab tabAt2 = g.this.f6181c.getTabAt(1);
            ViewGroup viewGroup = (ViewGroup) g.this.f6181c.getChildAt(0);
            if (viewGroup == null || viewGroup.getChildCount() < 2) {
                childAt = null;
                childAt2 = null;
            } else {
                childAt = viewGroup.getChildAt(0);
                childAt2 = viewGroup.getChildAt(1);
            }
            if (keyEvent.getAction() == 0 && i10 == 19) {
                if (g.this.f6200v == null || (g.this.f6200v != null && g.this.f6200v.getVisibility() != 0)) {
                    switch (view.getId()) {
                        case R$id.et_checkaccount_userid /* 2131428013 */:
                            tabAt.select();
                            if (childAt != null) {
                                childAt.requestFocus();
                            }
                            return true;
                        case R$id.et_phonenumber /* 2131428021 */:
                        case R$id.spinner_phonecode /* 2131429393 */:
                            g.this.f6181c.requestFocus();
                            tabAt2.select();
                            if (childAt2 != null) {
                                childAt2.requestFocus();
                            }
                            return true;
                        case R$id.tab_layout /* 2131429550 */:
                            if (tabAt.isSelected()) {
                                g.this.f6186h.requestFocus();
                            } else {
                                g.this.f6194p.f().requestFocus();
                            }
                            return true;
                    }
                }
            } else if (g.this.f6200v != null && keyEvent.getAction() == 0 && (i10 == 23 || i10 == 66)) {
                int id3 = view.getId();
                if (id3 == 2131428013 || id3 == 2131428021) {
                    g.this.f6200v.m0();
                    return true;
                }
            } else if (g.this.f6200v != null && keyEvent.getAction() == 1 && (i10 == 23 || i10 == 66)) {
                int id4 = view.getId();
                if (id4 == 2131428013 || id4 == 2131428021) {
                    return true;
                }
            } else if (g.this.f6200v != null && keyEvent.getAction() == 1 && ((i10 == 4 || i10 == 111) && (((id2 = view.getId()) == 2131428013 || id2 == 2131428021) && g.this.f6200v.getVisibility() == 0))) {
                g.this.f6200v.p();
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface f {
        void a(Fragment fragment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(boolean z10) {
        com.live.evo.a.f5187g = z10;
        if (z10) {
            this.f6188j.setNextFocusUpId(R$id.et_phonenumber);
            this.f6189k.setNextFocusUpId(R$id.et_phonenumber);
            this.f6182d.setText(this.f6196r);
            this.f6184f.setText(this.f6198t);
            ziyi.kit.keyboard.b bVar = this.f6200v;
            if (bVar != null && bVar.getTabTag().intValue() != 9) {
                this.f6200v.W();
                this.f6200v.setTabTag(9);
                this.f6200v.l(this.f6201w);
            }
        } else {
            this.f6188j.setNextFocusUpId(R$id.et_checkaccount_userid);
            this.f6189k.setNextFocusUpId(R$id.et_checkaccount_userid);
            this.f6182d.setText(this.f6195q);
            this.f6184f.setText(this.f6197s);
            ziyi.kit.keyboard.b bVar2 = this.f6200v;
            if (bVar2 != null && bVar2.getTabTag().intValue() != 8) {
                this.f6200v.W();
                this.f6200v.setTabTag(8);
                this.f6200v.l(this.f6186h);
            }
        }
        this.f6186h.setVisibility(!z10 ? 0 : 8);
        this.f6187i.setVisibility(z10 ? 0 : 8);
    }

    private void Y() {
        int i10;
        String strD = com.live.evo.a.f5187g ? this.f6194p.d() : this.f6186h.getText().toString().trim();
        if (TextUtils.isEmpty(strD)) {
            h0(x1.j(2131951652));
            return;
        }
        if (!(com.live.evo.a.f5187g ? o5.a.c().g(strD) : o5.a.c().f(strD))) {
            h0(x1.j(2131953141));
            return;
        }
        b();
        if (com.live.evo.a.f5187g) {
            strD = o5.a.c().d(strD);
            i10 = 1;
        } else {
            i10 = 0;
        }
        i5.a aVar = new i5.a();
        if (com.live.evo.a.f5187g) {
            i5.o oVarG = this.f6194p.g();
            aVar.i(oVarG.c());
            aVar.g(oVarG.a());
            aVar.f(this.f6194p.e());
            aVar.j(1);
        } else {
            aVar.j(0);
            aVar.f(strD);
        }
        this.f6190l.y(strD, i10, aVar);
        this.f6188j.setClickable(false);
    }

    private String Z(String str) {
        return x1.d(str, "*");
    }

    private void a0() {
        this.f6186h.setNextFocusRightId(R$id.et_checkaccount_userid);
        this.f6194p.f().setNextFocusRightId(R$id.et_phonenumber);
        this.f6194p.f().setNextFocusDownId(R$id.btn_checkaccount_ok);
        this.f6188j.setNextFocusLeftId(R$id.btn_checkaccount_ok);
        this.f6189k.setNextFocusRightId(R$id.btn_checkaccount_cancel);
        this.f6188j.setOnClickListener(this);
        this.f6189k.setOnClickListener(this);
        this.f6186h.addTextChangedListener(new b());
        this.f6181c.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new c());
        if (this.f6181c.getTabCount() >= 2) {
            ViewGroup viewGroup = (ViewGroup) this.f6181c.getChildAt(0);
            if (viewGroup != null && viewGroup.getChildCount() >= 2) {
                b0(viewGroup.getChildAt(0), 0);
                b0(viewGroup.getChildAt(1), 1);
            }
            this.f6186h.setOnKeyListener(this.f6203y);
            if (viewGroup != null && viewGroup.getChildCount() >= 2) {
                View childAt = viewGroup.getChildAt(0);
                View childAt2 = viewGroup.getChildAt(1);
                childAt.setNextFocusDownId(R$id.et_checkaccount_userid);
                childAt2.setNextFocusDownId(R$id.et_phonenumber);
            }
            this.f6194p.c().setOnKeyListener(this.f6203y);
            this.f6194p.f().setOnKeyListener(this.f6203y);
        }
    }

    private void b0(View view, int i10) {
        if (view != null) {
            view.setOnFocusChangeListener(new d(i10));
        }
    }

    private void c0() {
        this.f6181c = (TabLayout) this.f6180b.findViewById(R$id.tab_layout);
        this.f6182d = (TextView) this.f6180b.findViewById(R$id.tv_checkaccount_remind);
        this.f6183e = (TextView) this.f6180b.findViewById(R$id.tv_checkaccount_code);
        this.f6184f = (TextView) this.f6180b.findViewById(R$id.tv_checkaccount_eg);
        this.f6185g = (TextView) this.f6180b.findViewById(R$id.tv_checkaccount_error);
        this.f6186h = (EmailAutoCompleteTextView) this.f6180b.findViewById(R$id.et_checkaccount_userid);
        this.f6201w = (RemoveKeyCodeEnterEditText) this.f6180b.findViewById(R$id.et_phonenumber);
        this.f6187i = (LinearLayout) this.f6180b.findViewById(R$id.lly_phone);
        this.f6188j = (BaseButton) this.f6180b.findViewById(R$id.btn_checkaccount_ok);
        this.f6189k = (BaseButton) this.f6180b.findViewById(R$id.btn_checkaccount_cancel);
        this.f6194p = new o5.d(getContext(), this.f6180b);
        t5.a aVar = new t5.a(getActivity());
        this.f6193o = aVar;
        aVar.f(com.live.evo.widget.sloading.c.TRANSLATE_CIRCLE);
        this.f6193o.g(R$color.sloading_color);
        if (!this.f6199u) {
            this.f6181c.removeTabAt(1);
        }
        com.live.evo.util.t.b(this.f6182d);
        com.live.evo.util.t.d(this.f6183e);
        com.live.evo.util.t.b(this.f6184f);
        com.live.evo.util.t.b(this.f6185g);
        com.live.evo.util.t.b(this.f6186h);
        com.live.evo.util.t.d(this.f6188j);
        com.live.evo.util.t.d(this.f6189k);
        this.f6186h.requestFocus();
        this.f6195q = x1.j(R$string.bind_remind_email);
        this.f6196r = x1.j(R$string.bind_remind_phone);
        this.f6197s = x1.j(R$string.enter_email);
        this.f6198t = x1.j(R$string.enter_phone);
        ziyi.kit.keyboard.b bVar = this.f6200v;
        if (bVar != null) {
            bVar.l(this.f6186h);
            this.f6200v.setTabTag(8);
        }
    }

    public static g d0() {
        if (f6178z == null) {
            f6178z = new g();
        }
        return f6178z;
    }

    private void e0() {
        this.f6185g.setVisibility(4);
        a();
        this.f6186h.setText("");
        this.f6194p.l("");
        this.f6194p.m(0, true);
        f fVar = this.f6191m;
        if (fVar != null) {
            fVar.a(this);
        }
    }

    public static synchronized void g0(String str, Window window, FragmentManager fragmentManager, int i10, f fVar) {
        try {
            g gVarD0 = d0();
            gVarD0.f6191m = fVar;
            gVarD0.f6192n = str;
            gVarD0.f6202x = window;
            Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag("CheckAccountFragment");
            FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
            if (fragmentFindFragmentByTag == null) {
                fragmentTransactionBeginTransaction.add(i10, gVarD0, "CheckAccountFragment").commitAllowingStateLoss();
            } else {
                gVarD0.l();
                fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag).commitAllowingStateLoss();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void h0(String str) {
        this.f6185g.setVisibility(0);
        this.f6185g.setText(str);
    }

    private void l() {
        this.f6183e.setText(Z(this.f6192n));
        this.f6182d.setText(Html.fromHtml(this.f6195q));
        this.f6184f.setText(Html.fromHtml(this.f6197s));
        this.f6186h.setText("");
        this.f6186h.requestFocus();
        this.f6186h.c("gmail.com,hotmail.com,outlook.com,yahoo.com,yahoo.com.br", false);
        this.f6194p.m(0, true);
        this.f6194p.l("");
        X(false);
    }

    @Override // e5.a.InterfaceC0175a
    public boolean H() {
        ziyi.kit.keyboard.b bVar = this.f6200v;
        if (bVar == null || bVar.getVisibility() != 0) {
            e0();
            return true;
        }
        this.f6200v.p();
        return true;
    }

    public void a() {
        this.f6193o.d();
    }

    public void b() {
        this.f6193o.h();
    }

    public void f0() {
        BaseButton baseButton = this.f6188j;
        if (baseButton != null) {
            baseButton.requestFocus();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        com.live.evo.fragment.login.presenter.b bVar = this.f6190l;
        if (bVar != null) {
            bVar.u();
        }
        a0.q(this, this.f6180b);
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R$id.btn_checkaccount_cancel /* 2131427609 */:
                e0();
                break;
            case R$id.btn_checkaccount_ok /* 2131427610 */:
                this.f6185g.setVisibility(4);
                Y();
                break;
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f6180b = layoutInflater.inflate(R$layout.checkaccount_fragment, viewGroup, false);
        this.f6200v = KeyUtils.t(this.f6202x, getContext(), this.f6180b, getLifecycle(), false);
        com.live.evo.fragment.login.presenter.b bVar = new com.live.evo.fragment.login.presenter.b();
        this.f6190l = bVar;
        bVar.z(this);
        this.f6199u = true;
        c0();
        l();
        a0();
        a0.k(this, this.f6180b);
        return this.f6180b;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }
}
