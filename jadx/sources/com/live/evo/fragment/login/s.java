package com.live.evo.fragment.login;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
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
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.tabs.TabLayout;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.fragment.t1;
import com.live.evo.util.a0;
import com.live.evo.util.p1;
import com.live.evo.util.r1;
import com.live.evo.util.x1;
import com.live.evo.util.z0;
import com.live.evo.widget.EmailAutoCompleteTextView;
import com.live.evo.widget.RemoveKeyCodeEnterEditText;
import java.util.concurrent.TimeUnit;
import r8.z;
import ziyi.kit.keyboard.KeyUtils;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class s extends Fragment implements View.OnClickListener, com.live.evo.fragment.login.presenter.q, View.OnFocusChangeListener, e5.a.InterfaceC0175a {
    private static String G = "ResetAccountPasswordFragment";
    private static e5.j H;
    private static s I;
    private Window B;
    private ImageView C;
    private View D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f6371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f6372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f6373c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f6374d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TabLayout f6375e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private LinearLayout f6376f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private LinearLayout f6377g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private EmailAutoCompleteTextView f6378h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private RemoveKeyCodeEnterEditText f6379i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private EditText f6380j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private EditText f6381k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private TextView f6382l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private com.live.evo.fragment.login.presenter.p f6383m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private t1.b f6384n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private TextView f6385o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private t5.a f6386p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private TextView f6387q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private i5.a f6388r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f6389s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private TextView f6390t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private TextView f6391u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private j f6392v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private o5.d f6393w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f6394x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private String f6395y = "";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private String f6396z = "";
    private ziyi.kit.keyboard.b A = null;
    private o5.b E = new f();
    private View.OnKeyListener F = new a();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements View.OnKeyListener {
        a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x006d, code lost:
        
            if (r9 != 2131429393) goto L80;
         */
        @Override // android.view.View.OnKeyListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            View childAt;
            View childAt2;
            TabLayout.Tab tabAt = s.this.f6375e.getTabAt(0);
            TabLayout.Tab tabAt2 = s.this.f6375e.getTabAt(1);
            ViewGroup viewGroup = (ViewGroup) s.this.f6375e.getChildAt(0);
            if (viewGroup == null || viewGroup.getChildCount() < 2) {
                childAt = null;
                childAt2 = null;
            } else {
                childAt = viewGroup.getChildAt(0);
                childAt2 = viewGroup.getChildAt(1);
            }
            if (keyEvent.getAction() == 0 && i10 == 19) {
                if (s.this.A == null || (s.this.A != null && s.this.A.getVisibility() != 0)) {
                    int id2 = view.getId();
                    if (id2 != 2131428021) {
                        if (id2 == 2131429119) {
                            if (s.this.f6372b.getVisibility() != 0) {
                                return true;
                            }
                            tabAt.select();
                            if (childAt != null) {
                                childAt.requestFocus();
                            }
                            return true;
                        }
                    }
                    if (s.this.f6372b.getVisibility() != 0) {
                        return true;
                    }
                    s.this.f6375e.requestFocus();
                    tabAt2.select();
                    if (childAt2 != null) {
                        childAt2.requestFocus();
                    }
                    return true;
                }
            } else {
                if (s.this.A != null && keyEvent.getAction() == 0 && (i10 == 23 || i10 == 66)) {
                    switch (view.getId()) {
                        case R$id.et_phonenumber /* 2131428021 */:
                        case R$id.et_pwd /* 2131428022 */:
                        case R$id.resetpwd_et_email /* 2131429175 */:
                        case R$id.resetpwd_et_verify_code /* 2131429176 */:
                            s.this.A.m0();
                            if (view.getId() != 2131428021) {
                                s.this.D = view;
                            }
                            return true;
                    }
                }
                if (s.this.A != null && keyEvent.getAction() == 1 && (i10 == 23 || i10 == 66)) {
                    switch (view.getId()) {
                        case R$id.et_phonenumber /* 2131428021 */:
                        case R$id.et_pwd /* 2131428022 */:
                        case R$id.resetpwd_et_email /* 2131429175 */:
                        case R$id.resetpwd_et_verify_code /* 2131429176 */:
                            return true;
                    }
                }
                if (s.this.A != null && keyEvent.getAction() == 1 && (i10 == 4 || i10 == 111)) {
                    switch (view.getId()) {
                        case R$id.et_phonenumber /* 2131428021 */:
                        case R$id.et_pwd /* 2131428022 */:
                        case R$id.resetpwd_et_email /* 2131429175 */:
                        case R$id.resetpwd_et_verify_code /* 2131429176 */:
                            if (s.this.D != null) {
                                s.this.D.setOnFocusChangeListener(s.this);
                            }
                            if (s.this.A.getVisibility() == 0) {
                                s.this.A.p();
                                return true;
                            }
                        default:
                            return false;
                    }
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            s.this.f6387q.setText("");
            if (s.this.f6392v != null) {
                s.this.f6392v.cancel();
                s.this.f6382l.setText(x1.j(2131952907));
                s.this.f6382l.setClickable(true);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            s.this.f6387q.setText("");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class d implements TextWatcher {
        d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                s.this.f6387q.setVisibility(4);
            } else {
                s.this.f6387q.setVisibility(0);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class e implements TabLayout.OnTabSelectedListener {
        e() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            s.this.f6387q.setText("");
            boolean z10 = tab.getPosition() > 0;
            com.live.evo.a.f5187g = z10;
            s.this.b0(z10);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class f implements o5.b {
        f() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class g implements com.live.evo.dialog.r.c {
        g() {
        }

        @Override // com.live.evo.dialog.r.c
        public void b() {
            s.this.f6387q.setText("");
            s.this.f6382l.setClickable(true);
            s.this.f6382l.setText(x1.j(2131952907));
            if (s.this.f6392v != null) {
                s.this.f6392v.cancel();
            }
        }

        @Override // com.live.evo.dialog.r.c
        public void a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class i implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6404a;

        i(int i10) {
            this.f6404a = i10;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            if (!z10 || view == null) {
                return;
            }
            boolean z11 = this.f6404a > 0;
            s.this.f6375e.getTabAt(this.f6404a).select();
            s.this.b0(z11);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public class j extends CountDownTimer {
        public j(long j10, long j11) {
            super(j10, j11);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            try {
                s.this.f6382l.setText(x1.j(2131952907));
                s.this.f6382l.setClickable(true);
            } catch (Exception unused) {
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
            s.this.n0(j10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class h implements c9.l<Boolean, z> {
        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public z invoke(Boolean bool) {
            return null;
        }

        h(s sVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(boolean z10) {
        if (z10) {
            ziyi.kit.keyboard.b bVar = this.A;
            if (bVar != null && bVar.getTabTag().intValue() != 7) {
                this.A.W();
                this.A.setTabTag(7);
                this.A.l(this.f6379i);
                this.A.l(this.f6380j);
                this.A.l(this.f6381k);
            }
            this.f6391u.setText(Html.fromHtml(this.f6396z));
            this.f6382l.setNextFocusUpId(R$id.et_phonenumber);
            this.f6380j.setNextFocusUpId(R$id.et_phonenumber);
        } else {
            ziyi.kit.keyboard.b bVar2 = this.A;
            if (bVar2 != null && bVar2.getTabTag().intValue() != 6) {
                this.A.W();
                this.A.setTabTag(6);
                this.A.l(this.f6378h);
                this.A.l(this.f6380j);
                this.A.l(this.f6381k);
            }
            this.f6391u.setText(Html.fromHtml(this.f6395y));
            this.f6382l.setNextFocusUpId(R$id.resetpwd_et_email);
            this.f6380j.setNextFocusUpId(R$id.resetpwd_et_email);
        }
        this.f6378h.setVisibility(!z10 ? 0 : 8);
        this.f6377g.setVisibility(z10 ? 0 : 8);
    }

    public static s d0() {
        if (I == null) {
            I = new s();
        }
        return I;
    }

    private void e0(i5.a aVar) {
        if (com.live.evo.a.f5187g) {
            this.f6393w.j(aVar);
            if (TextUtils.isEmpty(aVar.a())) {
                this.f6393w.f().requestFocus();
            }
            this.f6393w.n(aVar);
        } else {
            this.f6378h.setText(aVar.a());
            if (TextUtils.isEmpty(aVar.a())) {
                this.f6378h.requestFocus();
                z0.d(this.f6378h);
            } else {
                this.f6378h.setSelection(aVar.a().length());
            }
        }
        if (!TextUtils.isEmpty(aVar.a())) {
            this.f6382l.requestFocus();
        }
        b0(com.live.evo.a.f5187g);
    }

    private void f0() {
        this.f6382l.setOnClickListener(this);
        this.f6385o.setOnClickListener(this);
        this.f6390t.setOnClickListener(this);
        this.f6378h.setOnFocusChangeListener(this);
        this.f6382l.setOnFocusChangeListener(this);
        this.f6380j.setOnFocusChangeListener(this);
        this.f6381k.setOnFocusChangeListener(this);
        this.f6385o.setOnFocusChangeListener(this);
        this.f6378h.setOnFocusChangeListener(this);
        this.f6390t.setOnFocusChangeListener(this);
        this.f6378h.setNextFocusDownId(R$id.tv_verify);
        EmailAutoCompleteTextView emailAutoCompleteTextView = this.f6378h;
        int i10 = R$id.resetpwd_et_email;
        emailAutoCompleteTextView.setNextFocusRightId(R$id.resetpwd_et_email);
        this.f6393w.c().setNextFocusDownId(R$id.et_phonenumber);
        this.f6393w.c().setNextFocusLeftId(R$id.spinner_phonecode);
        this.f6393w.f().setNextFocusDownId(R$id.tv_verify);
        this.f6393w.f().setNextFocusRightId(R$id.tv_verify);
        this.f6382l.setNextFocusDownId(R$id.et_pwd);
        this.f6382l.setNextFocusLeftId(R$id.tv_verify);
        this.f6382l.setNextFocusRightId(R$id.resetpwd_et_verify_code);
        this.f6382l.setNextFocusUpId(this.f6388r.e() == 1 ? R$id.et_phonenumber : R$id.resetpwd_et_email);
        this.f6380j.setNextFocusRightId(R$id.resetpwd_et_verify_code);
        EditText editText = this.f6380j;
        if (this.f6388r.e() == 1) {
            i10 = R$id.et_phonenumber;
        }
        editText.setNextFocusUpId(i10);
        this.f6380j.setNextFocusDownId(R$id.et_pwd);
        this.f6380j.setNextFocusLeftId(R$id.tv_verify);
        this.f6381k.setNextFocusDownId(R$id.resetpwd_tv_submit);
        this.f6381k.setNextFocusUpId(R$id.tv_verify);
        this.f6381k.setNextFocusRightId(R$id.et_pwd);
        this.f6385o.setNextFocusRightId(R$id.resetpwd_tv_return);
        this.f6385o.setNextFocusUpId(R$id.et_pwd);
        this.f6385o.setNextFocusLeftId(R$id.resetpwd_tv_submit);
        this.f6390t.setNextFocusLeftId(R$id.resetpwd_tv_submit);
        this.f6390t.setNextFocusUpId(R$id.et_pwd);
        this.f6390t.setNextFocusRightId(R$id.resetpwd_tv_return);
        this.f6378h.addTextChangedListener(new b());
        this.f6381k.addTextChangedListener(new c());
        this.f6387q.addTextChangedListener(new d());
        this.f6375e.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new e());
        if (this.f6375e.getTabCount() >= 2) {
            ViewGroup viewGroup = (ViewGroup) this.f6375e.getChildAt(0);
            if (viewGroup != null && viewGroup.getChildCount() >= 2) {
                g0(viewGroup.getChildAt(0), 0);
                g0(viewGroup.getChildAt(1), 1);
            }
            if (com.live.evo.util.e.b().e() == 1) {
                this.f6378h.setOnKeyListener(this.F);
                this.f6379i.setOnKeyListener(this.F);
                this.f6380j.setOnKeyListener(this.F);
                this.f6381k.setOnKeyListener(this.F);
                this.f6393w.c().setOnKeyListener(this.F);
                this.f6393w.f().setOnKeyListener(this.F);
            }
        }
    }

    private void g0(View view, int i10) {
        if (view != null) {
            view.setOnFocusChangeListener(new i(i10));
        }
    }

    private void h0() {
        this.f6372b = this.f6371a.findViewById(R$id.resetpwd_lly_switch);
        this.f6373c = (TextView) this.f6371a.findViewById(R$id.resetpwd_tv_title);
        this.f6374d = (TextView) this.f6371a.findViewById(R$id.resetpwd_tv_redmind);
        this.f6375e = (TabLayout) this.f6371a.findViewById(R$id.resetpwd_tab_layout);
        this.f6376f = (LinearLayout) this.f6371a.findViewById(R$id.lly_changephone);
        this.f6378h = (EmailAutoCompleteTextView) this.f6371a.findViewById(R$id.resetpwd_et_email);
        this.f6379i = (RemoveKeyCodeEnterEditText) this.f6371a.findViewById(R$id.et_phonenumber);
        this.f6377g = (LinearLayout) this.f6371a.findViewById(R$id.lly_phone);
        this.f6382l = (TextView) this.f6371a.findViewById(R$id.tv_verify);
        this.f6380j = (EditText) this.f6371a.findViewById(R$id.resetpwd_et_verify_code);
        this.f6381k = (EditText) this.f6371a.findViewById(R$id.et_pwd);
        this.f6385o = (TextView) this.f6371a.findViewById(R$id.resetpwd_tv_submit);
        this.f6390t = (TextView) this.f6371a.findViewById(R$id.resetpwd_tv_return);
        this.f6391u = (TextView) this.f6371a.findViewById(R$id.resetpwd_tv_remind);
        this.f6387q = (TextView) this.f6371a.findViewById(R$id.resetpwd_tv_error);
        ImageView imageView = (ImageView) this.f6371a.findViewById(R$id.resetpwd_iv_title);
        this.C = imageView;
        imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), com.live.evo.a.f5198r, null));
        this.C.setVisibility(0);
        t5.a aVar = new t5.a(getContext());
        this.f6386p = aVar;
        aVar.f(com.live.evo.widget.sloading.c.TRANSLATE_CIRCLE);
        this.f6386p.g(ViewCompat.MEASURED_STATE_MASK);
        com.live.evo.util.t.b(this.f6391u);
        com.live.evo.util.t.c(this.f6378h);
        com.live.evo.util.t.c(this.f6382l);
        com.live.evo.util.t.c(this.f6380j);
        com.live.evo.util.t.d(this.f6385o);
        com.live.evo.util.t.d(this.f6390t);
        ziyi.kit.keyboard.b bVar = this.A;
        if (bVar != null) {
            bVar.l(this.f6378h);
            this.A.l(this.f6380j);
            this.A.l(this.f6381k);
            this.A.setTabTag(6);
        }
        this.f6393w = new o5.d(getContext(), this.f6371a);
        this.f6378h.c(com.live.evo.l.n().i("email_domains", "gmail.com,hotmail.com,outlook.com,yahoo.com,yahoo.com.br"), false);
    }

    private void i0() {
        e5.j jVar = H;
        if (jVar != null) {
            jVar.a(this);
        }
        j jVar2 = this.f6392v;
        if (jVar2 != null) {
            jVar2.cancel();
        }
        this.f6393w.f().setEnabled(true);
        this.f6378h.setEnabled(true);
        this.f6382l.setText(getResources().getString(2131952907));
        this.f6382l.setClickable(true);
        this.f6387q.setText("");
    }

    public static synchronized void j0(FragmentManager fragmentManager, Window window, int i10, i5.a aVar, boolean z10, e5.j jVar) {
        try {
            s sVarD0 = d0();
            H = jVar;
            Bundle bundle = new Bundle();
            bundle.putBoolean("hasPhoneFeature", com.live.evo.l.n().j("contain_phone_account", true));
            bundle.putSerializable("accountBean", aVar);
            bundle.putBoolean("onlyChange", z10);
            sVarD0.setArguments(bundle);
            sVarD0.B = window;
            Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag(G);
            FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
            if (fragmentFindFragmentByTag == null) {
                fragmentTransactionBeginTransaction.add(i10, sVarD0, G).commitAllowingStateLoss();
            } else {
                sVarD0.l();
                fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag).commitAllowingStateLoss();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void l0() {
        int i10;
        i5.o oVarG = this.f6393w.g();
        String strD = com.live.evo.a.f5187g ? this.f6393w.d() : this.f6378h.getText().toString().trim();
        if (TextUtils.isEmpty(strD)) {
            this.f6387q.setText(x1.j(2131951980));
            r1.f(this.f6387q, getActivity(), x1.j(2131951980), 1);
            return;
        }
        if (!(com.live.evo.a.f5187g ? o5.a.c().g(strD) : o5.a.c().f(strD))) {
            this.f6387q.setText(x1.j(2131953141));
            r1.f(this.f6387q, getActivity(), x1.j(2131953141), 1);
            return;
        }
        String strTrim = this.f6380j.getText().toString().trim();
        if (TextUtils.isEmpty(strTrim)) {
            k0(x1.j(2131953166), null);
            return;
        }
        String strTrim2 = this.f6381k.getText().toString().trim();
        if (TextUtils.isEmpty(strTrim2)) {
            k0(x1.j(2131952756), null);
            return;
        }
        if (strTrim2.length() < 6 || strTrim2.length() > 16) {
            k0(x1.j(2131952758), null);
            return;
        }
        b();
        if (com.live.evo.a.f5187g) {
            strD = o5.a.c().d(strD);
            i10 = 1;
        } else {
            i10 = 0;
        }
        this.f6383m.x(strTrim, strD, strTrim2, i10, oVarG.c(), oVarG.a());
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void m0() {
        TabLayout tabLayout = this.f6375e;
        if (tabLayout == null || tabLayout.getTabCount() <= 1) {
            return;
        }
        this.f6372b.setVisibility(0);
        this.f6375e.getTabAt(com.live.evo.a.f5187g ? 1 : 0).select();
        b0(com.live.evo.a.f5187g);
        if (com.live.evo.a.f5187g) {
            this.f6393w.f().requestFocus();
            return;
        }
        EmailAutoCompleteTextView emailAutoCompleteTextView = this.f6378h;
        this.D = emailAutoCompleteTextView;
        emailAutoCompleteTextView.requestFocus();
        z0.d(this.f6378h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(long j10) {
        try {
            this.f6382l.setText(x1.j(2131952906) + TimeUnit.MILLISECONDS.toSeconds(j10) + "s)");
        } catch (Exception unused) {
        }
    }

    @Override // e5.a.InterfaceC0175a
    public boolean H() {
        ziyi.kit.keyboard.b bVar = this.A;
        if (bVar != null && bVar.getVisibility() == 0) {
            View view = this.D;
            if (view != null) {
                view.setOnFocusChangeListener(this);
            }
            this.A.p();
            return true;
        }
        TextView textView = this.f6390t;
        if (textView == null || textView.getVisibility() != 0) {
            return e5.a.a(this);
        }
        i0();
        return true;
    }

    @Override // com.live.evo.fragment.login.presenter.q
    public void a() {
        this.f6386p.d();
    }

    public void b() {
        this.f6386p.h();
    }

    @Override // com.live.evo.fragment.login.presenter.q
    public void j(String str, String str2) {
        this.f6386p.d();
        com.live.evo.dialog.r rVar = new com.live.evo.dialog.r(getActivity(), new g());
        rVar.k(x1.j(2131953168));
        rVar.j(str, x1.j(2131952013) + str2);
        rVar.l();
        k0("", str);
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
    public void onPause() {
        com.live.evo.fragment.login.presenter.p pVar = this.f6383m;
        if (pVar != null) {
            pVar.u();
        }
        super.onPause();
    }

    private void c0() {
        Bundle arguments = getArguments();
        boolean z10 = arguments.getBoolean("onlyChange");
        this.f6394x = arguments.getBoolean("hasPhoneFeature");
        this.f6388r = (i5.a) arguments.getSerializable("accountBean");
        if (this.f6394x) {
            this.f6389s = z10;
        } else {
            this.f6389s = true;
        }
    }

    private void k0(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            str3 = "";
        } else {
            str3 = str2;
        }
        if (!TextUtils.isEmpty(str2) && str2.contains(":")) {
            String[] strArrSplit = str2.split(":");
            if (strArrSplit.length > 1) {
                str3 = strArrSplit[1] + "(" + strArrSplit[0] + ")";
            }
        }
        String str4 = String.format("%s%s", str, str3);
        this.f6387q.setText(str4);
        r1.f(this.f6387q, getActivity(), str4, 1);
    }

    private void l() {
        this.f6373c.setText(Html.fromHtml(p1.a("reset_account_title", getString(R$string.reset_account_title))));
        this.f6374d.setText(Html.fromHtml(p1.a("reset_account_title_below", getString(R$string.reset_account_title_below))));
        this.f6395y = p1.a("RESET_REMIND", getString(R$string.reset_password_remind)) + " " + t.v.c.i.a.f18646a.v();
        this.f6396z = p1.a("reset_remind_phone", getString(R$string.reset_password_remind_phone));
        this.f6391u.setText(Html.fromHtml(this.f6395y));
        c0();
        e0(this.f6388r);
        if (this.f6389s) {
            this.f6393w.f().setEnabled(false);
            this.f6378h.setEnabled(false);
        } else {
            this.f6393w.f().setEnabled(true);
            this.f6378h.setEnabled(true);
        }
        m0();
    }

    @Override // com.live.evo.fragment.login.presenter.q
    public void G() {
        a();
        this.f6378h.setEnabled(true);
        if (!this.f6389s) {
            String strTrim = this.f6378h.getText().toString().trim();
            i5.a aVar = new i5.a();
            if (com.live.evo.a.f5187g) {
                aVar.j(1);
                aVar.f(this.f6393w.e());
                i5.o oVarG = this.f6393w.g();
                aVar.g(oVarG.a());
                aVar.i(oVarG.c());
                aVar.h(this.f6381k.getText().toString().trim());
            } else {
                aVar.j(0);
                aVar.f(strTrim);
                aVar.h(this.f6381k.getText().toString().trim());
            }
        } else {
            j jVar = this.f6392v;
            if (jVar != null) {
                jVar.cancel();
            }
        }
        e5.j jVar2 = H;
        if (jVar2 != null) {
            jVar2.b(this);
        }
    }

    @Override // com.live.evo.fragment.login.presenter.q
    public void d() {
        FragmentActivity activity = getActivity();
        if (activity instanceof AppCompatActivity) {
            t1.INSTANCE.f((AppCompatActivity) activity, this.f6384n, new h(this));
        }
    }

    @Override // com.live.evo.fragment.login.presenter.q
    public void h() {
        a();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        c0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String strTrim;
        boolean zF;
        s sVar;
        switch (view.getId()) {
            case R$id.resetpwd_tv_return /* 2131429184 */:
                i0();
                break;
            case R$id.resetpwd_tv_submit /* 2131429185 */:
                l0();
                break;
            case R$id.tv_verify /* 2131429775 */:
                if (com.live.evo.a.f5187g) {
                    strTrim = this.f6393w.d();
                } else {
                    strTrim = this.f6378h.getText().toString().trim();
                }
                int i10 = 1;
                if (TextUtils.isEmpty(strTrim)) {
                    this.f6387q.setText(x1.j(2131951980));
                    r1.f(this.f6387q, getActivity(), x1.j(2131951980), 1);
                } else {
                    if (com.live.evo.a.f5187g) {
                        zF = o5.a.c().g(strTrim);
                    } else {
                        zF = o5.a.c().f(strTrim);
                    }
                    if (!zF) {
                        this.f6387q.setText(x1.j(2131953141));
                        r1.f(this.f6387q, getActivity(), x1.j(2131953141), 1);
                    } else {
                        b();
                        i5.a aVar = new i5.a();
                        if (com.live.evo.a.f5187g) {
                            strTrim = o5.a.c().d(strTrim);
                            i5.o oVarG = this.f6393w.g();
                            aVar.j(1);
                            aVar.f(this.f6393w.e());
                            aVar.i(oVarG.c());
                            aVar.g(oVarG.a());
                        } else {
                            aVar.j(0);
                            aVar.f(strTrim);
                            i10 = 0;
                        }
                        this.f6383m.j(strTrim, i10, aVar);
                        j jVar = this.f6392v;
                        if (jVar == null) {
                            sVar = this;
                            j jVar2 = sVar.new j(120000L, 1000L);
                            sVar.f6392v = jVar2;
                            jVar2.start();
                        } else {
                            sVar = this;
                            jVar.cancel();
                            sVar.f6392v.start();
                        }
                        sVar.f6382l.setClickable(false);
                    }
                }
                break;
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        this.f6371a = layoutInflater.inflate(R$layout.reset_account_password, viewGroup, false);
        this.A = KeyUtils.t(this.B, getContext(), this.f6371a, getLifecycle(), false);
        this.f6383m = new com.live.evo.fragment.login.presenter.r();
        this.f6384n = t1.INSTANCE.a(getActivity());
        this.f6383m.r(this);
        h0();
        l();
        f0();
        a0.k(this, this.f6371a);
        return this.f6371a;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        I = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.live.evo.fragment.login.presenter.p pVar = this.f6383m;
        if (pVar != null) {
            pVar.r(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        j jVar = this.f6392v;
        if (jVar != null) {
            jVar.cancel();
            this.f6382l.setClickable(true);
            this.f6382l.setText(x1.j(2131952907));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
    }
}
