package com.live.evo.fragment.login;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.tabs.TabLayout;
import com.live.evo.R$anim;
import com.live.evo.R$color;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.dialog.z;
import com.live.evo.fragment.t1;
import com.live.evo.util.a0;
import com.live.evo.util.p1;
import com.live.evo.util.r1;
import com.live.evo.util.s0;
import com.live.evo.util.x1;
import com.live.evo.util.z0;
import com.live.evo.widget.EmailAutoCompleteTextView;
import com.live.evo.widget.RechargeEditText;
import com.live.evo.widget.RemoveKeyCodeEnterEditText;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import ziyi.kit.keyboard.KeyUtils;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b extends Fragment implements View.OnClickListener, com.live.evo.fragment.login.presenter.d, View.OnFocusChangeListener, e5.a.InterfaceC0175a {

    @SuppressLint({"StaticFieldLeak"})
    private static b X = null;
    private static String Y = "AccountUserLoginFragment";
    private LinearLayout A;
    private LinearLayout B;
    private RechargeEditText C;
    private ImageView D;
    private View F;
    private TabLayout G;
    private o5.d J;
    private CheckBox K;
    private View L;
    private TextView M;
    private View T;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f6104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Window f6105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f6106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private EditText f6107d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RemoveKeyCodeEnterEditText f6108e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f6109f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextView f6110g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.live.evo.fragment.login.presenter.c f6111h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private t1.b f6112i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private t5.a f6113j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private e5.c f6114k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private TextView f6115l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private TextView f6116m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ImageView f6117n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private z f6118o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private TextView f6119p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ImageView f6120q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ImageView f6121r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f6122s;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private LinearLayout f6125v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private LinearLayout f6126w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private TextView f6127x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private TextView f6128y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private EmailAutoCompleteTextView f6129z;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f6123t = "";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f6124u = "";
    private i5.a E = null;
    private int H = 0;
    private int I = 0;
    private String N = "";
    private String O = "";
    private String P = "";
    private String Q = "";
    private List<j> R = new ArrayList();
    private ziyi.kit.keyboard.b S = null;
    private Handler U = new Handler(Looper.getMainLooper());
    private TextWatcher V = new h();
    private View.OnKeyListener W = new i();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements View.OnFocusChangeListener {
        a() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            if (z10) {
                b.this.L.setBackgroundResource(R$drawable.checkbox_focus);
            } else {
                b.this.L.setBackgroundColor(x1.e(2131102158));
            }
        }
    }

    /* JADX INFO: renamed from: com.live.evo.fragment.login.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class C0078b implements TabLayout.OnTabSelectedListener {
        C0078b() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            b.this.f6115l.setText("");
            b.this.l0(b.this.q0(tab));
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                b.this.f6115l.setVisibility(4);
            } else {
                b.this.f6115l.setVisibility(0);
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
    class d implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f6133a;

        d(j jVar) {
            this.f6133a = jVar;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            if (!z10 || view == null) {
                return;
            }
            this.f6133a.f6145d.select();
            b.this.l0(this.f6133a.f6143b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class e implements z.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6135a;

        e(int i10) {
            this.f6135a = i10;
        }

        @Override // com.live.evo.dialog.z.b
        public void a(i5.a aVar) {
            b.this.f6118o.c();
            if (this.f6135a == 3) {
                b.this.E = aVar;
                b.this.C.setText(x1.c(aVar.a(), 4, 8, "********"));
            } else {
                b.this.t0(aVar);
                b.this.f6107d.setText(TextUtils.isEmpty(aVar.c()) ? "" : aVar.c());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f6137a;

        f(String str) {
            this.f6137a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10;
            b.this.f6107d.setText("");
            EditText editTextF = b.this.f6129z;
            String str = this.f6137a;
            if (o5.a.c().g(this.f6137a)) {
                b.this.J.h(this.f6137a);
                editTextF = b.this.J.f();
                i10 = 2;
            } else {
                String str2 = o5.a.c().f(this.f6137a) ? str : "";
                editTextF.setText(str2);
                if (!TextUtils.isEmpty(str2)) {
                    editTextF.setSelection(str2.length());
                }
                i10 = 1;
            }
            b.this.w0(i10);
            editTextF.requestFocus();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class g implements c9.l<Boolean, r8.z> {
        g() {
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public r8.z invoke(Boolean bool) {
            if (bool.booleanValue()) {
                b.this.A0();
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class h implements TextWatcher {
        h() {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            b.this.f6115l.setText("");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class i implements View.OnKeyListener {
        i() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0 && i10 == 19) {
                if (b.this.S == null || (b.this.S != null && b.this.S.getVisibility() != 0)) {
                    int i11 = 2;
                    switch (view.getId()) {
                        case R$id.et_phonenumber /* 2131428021 */:
                        case R$id.spinner_phonecode /* 2131429393 */:
                            b.this.M0(2);
                            return true;
                        case R$id.loginf_et_username /* 2131428587 */:
                            b.this.M0(1);
                            return true;
                        case R$id.loginf_iv_more_code /* 2131428589 */:
                        case R$id.loginf_ret_renewcode /* 2131428598 */:
                            b.this.M0(3);
                            return true;
                        case R$id.loginf_iv_more_user /* 2131428590 */:
                            if (!com.live.evo.a.f5187g) {
                                i11 = 1;
                            }
                            b.this.M0(i11);
                            return true;
                        default:
                            return false;
                    }
                }
                return false;
            }
            if (b.this.S != null && keyEvent.getAction() == 0 && (i10 == 23 || i10 == 66)) {
                switch (view.getId()) {
                    case R$id.et_phonenumber /* 2131428021 */:
                    case R$id.et_pwd /* 2131428022 */:
                    case R$id.loginf_et_username /* 2131428587 */:
                    case R$id.loginf_ret_renewcode /* 2131428598 */:
                        b.this.S.m0();
                        if (view.getId() != 2131428021) {
                            b.this.T = view;
                        }
                        return true;
                    default:
                        return false;
                }
            }
            if (b.this.S != null && keyEvent.getAction() == 1 && (i10 == 23 || i10 == 66)) {
                switch (view.getId()) {
                    case R$id.et_phonenumber /* 2131428021 */:
                    case R$id.et_pwd /* 2131428022 */:
                    case R$id.loginf_et_username /* 2131428587 */:
                    case R$id.loginf_ret_renewcode /* 2131428598 */:
                        return true;
                    default:
                        return false;
                }
            }
            if (b.this.S != null && keyEvent.getAction() == 1 && (i10 == 4 || i10 == 111)) {
                switch (view.getId()) {
                    case R$id.et_phonenumber /* 2131428021 */:
                    case R$id.et_pwd /* 2131428022 */:
                    case R$id.loginf_et_username /* 2131428587 */:
                    case R$id.loginf_ret_renewcode /* 2131428598 */:
                        if (b.this.T != null) {
                            b.this.T.setOnFocusChangeListener(b.this);
                        }
                        if (b.this.S.getVisibility() == 0) {
                            b.this.S.p();
                            return true;
                        }
                        return false;
                    default:
                        return false;
                }
            }
            if (keyEvent.getAction() == 0 && i10 == 20 && view.getId() == 2131428607) {
                b.this.f6110g.requestFocus();
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f6142a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f6143b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f6144c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        TabLayout.Tab f6145d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        View f6146e;

        /* synthetic */ j(b bVar, com.live.evo.fragment.login.c cVar) {
            this(bVar);
        }

        private j(b bVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(int i10) {
        try {
            com.live.evo.a.f5187g = i10 == 2;
            if (i10 == 1) {
                this.f6109f.setNextFocusDownId(R$id.loginf_tv_login);
                this.f6109f.setNextFocusUpId(-1);
                this.L.setVisibility(8);
                LinearLayout linearLayout = this.f6125v;
                if (linearLayout != null && linearLayout.getVisibility() != 0) {
                    this.f6125v.setVisibility(0);
                }
                this.f6127x.setText(Html.fromHtml(this.O));
                this.f6107d.setNextFocusUpId(R$id.loginf_et_username);
                this.f6129z.setVisibility(0);
                this.A.setVisibility(8);
                LinearLayout linearLayout2 = this.f6126w;
                if (linearLayout2 != null && linearLayout2.getVisibility() == 0) {
                    this.f6126w.setVisibility(8);
                }
                ziyi.kit.keyboard.b bVar = this.S;
                if (bVar == null || bVar.getTabTag().intValue() == 1) {
                    return;
                }
                this.S.W();
                this.S.setTabTag(1);
                this.S.l(this.f6129z);
                this.S.l(this.f6107d);
                return;
            }
            if (i10 != 2) {
                if (i10 != 3) {
                    return;
                }
                this.L.setVisibility(0);
                this.f6109f.setNextFocusDownId(R$id.cb_code_login_tip_parent);
                this.f6109f.setNextFocusUpId(R$id.loginf_ret_renewcode);
                LinearLayout linearLayout3 = this.f6126w;
                if (linearLayout3 != null && linearLayout3.getVisibility() != 0) {
                    this.f6126w.setVisibility(0);
                }
                LinearLayout linearLayout4 = this.f6125v;
                if (linearLayout4 != null && linearLayout4.getVisibility() == 0) {
                    this.f6125v.setVisibility(8);
                }
                ziyi.kit.keyboard.b bVar2 = this.S;
                if (bVar2 == null || bVar2.getTabTag().intValue() == 3) {
                    return;
                }
                this.S.W();
                this.S.setTabTag(3);
                this.S.l(this.C);
                return;
            }
            this.f6109f.setNextFocusDownId(R$id.loginf_tv_login);
            this.f6109f.setNextFocusUpId(-1);
            this.L.setVisibility(8);
            LinearLayout linearLayout5 = this.f6125v;
            if (linearLayout5 != null && linearLayout5.getVisibility() != 0) {
                this.f6125v.setVisibility(0);
            }
            this.f6127x.setText(Html.fromHtml(this.P));
            this.f6107d.setNextFocusUpId(R$id.et_phonenumber);
            this.f6129z.setVisibility(8);
            this.A.setVisibility(0);
            LinearLayout linearLayout6 = this.f6126w;
            if (linearLayout6 != null && linearLayout6.getVisibility() == 0) {
                this.f6126w.setVisibility(8);
            }
            ziyi.kit.keyboard.b bVar3 = this.S;
            if (bVar3 == null || bVar3.getTabTag().intValue() == 2) {
                return;
            }
            this.S.W();
            this.S.setTabTag(2);
            this.S.l(this.f6108e);
            this.S.l(this.f6107d);
        } catch (Throwable unused) {
        }
    }

    private String p0(int i10) {
        if (i10 == 1) {
            return x1.j(R$string.user_email);
        }
        if (i10 != 2) {
            return i10 != 3 ? "" : x1.j(R$string.user_renewcode);
        }
        return x1.j(R$string.user_phone);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        X = null;
        a0.q(this, this.f6104a);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
        i5.a aVar;
        int iQ0 = q0(this.G.getTabAt(this.G.getSelectedTabPosition()));
        if (iQ0 == 1) {
            String strTrim = this.f6129z.getText().toString().trim();
            String strTrim2 = this.f6107d.getText().toString().trim();
            if (m0(strTrim, strTrim2)) {
                this.f6111h.l(strTrim, strTrim2, 0, "", "");
                return;
            }
            return;
        }
        if (iQ0 == 2) {
            String strD = this.J.d();
            String strTrim3 = this.f6107d.getText().toString().trim();
            if (m0(strD, strTrim3)) {
                String strD2 = o5.a.c().d(strD);
                i5.o oVarG = this.J.g();
                this.f6111h.l(strD2, strTrim3, this.I, oVarG.c(), oVarG.a());
                return;
            }
            return;
        }
        if (iQ0 != 3) {
            return;
        }
        String strReplace = this.C.getText().toString().trim().replace(" ", "");
        if (TextUtils.isEmpty(strReplace)) {
            this.C.requestFocus();
            G0(x1.j(R$string.renewal_empty));
            E0(this.C);
            return;
        }
        if (strReplace.contains("********") && (aVar = this.E) != null && aVar.a().startsWith(strReplace.substring(0, 3)) && this.E.a().endsWith(strReplace.substring(strReplace.length() - 4))) {
            strReplace = this.E.a();
        } else if (strReplace.contains("*")) {
            this.C.requestFocus();
            G0(x1.j(R$string.invalid_code));
            E0(this.C);
            return;
        }
        if (this.K.isChecked()) {
            this.f6111h.s(getContext(), strReplace);
            return;
        }
        G0(x1.j(R$string.code_bind_checkbox_tips));
        E0(this.K);
        E0(this.L);
        this.L.requestFocus();
    }

    private void B0() {
        String strD = com.live.evo.a.f5187g ? this.J.d() : this.f6129z.getText().toString().trim();
        i5.a aVarP = s0.f7342a.p();
        if (aVarP == null) {
            aVarP = new i5.a();
            if (com.live.evo.a.f5187g) {
                aVarP.j(1);
                aVarP.f(this.J.e());
                i5.o oVarG = this.J.g();
                aVarP.g(oVarG.a());
                aVarP.i(oVarG.c());
            } else {
                aVarP.j(0);
                aVarP.f(strD);
            }
        }
        this.f6114k.e(this, aVarP);
    }

    private void C0() {
        List<j> list = this.R;
        if (list != null && list.size() >= 1) {
            LinearLayout linearLayout = (LinearLayout) this.G.getChildAt(0);
            linearLayout.setShowDividers(2);
            linearLayout.setDividerDrawable(x1.f(R$drawable.login_tab_divider));
        }
        L0();
    }

    private void D0(int i10) {
        List<j> list = this.R;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (j jVar : this.R) {
            if (i10 == jVar.f6143b) {
                jVar.f6145d.select();
                return;
            }
        }
    }

    public static synchronized void F0(FragmentManager fragmentManager, Window window, int i10, boolean z10, String str, int i11, e5.c cVar) {
        try {
            b bVar = (b) fragmentManager.findFragmentByTag(Y);
            if (i11 == 0) {
                int iD = s0.f7342a.D();
                if (iD == 6) {
                    i11 = 2;
                } else if (iD == 2) {
                    i11 = 1;
                }
            }
            if (bVar == null) {
                b bVarN0 = n0();
                bVarN0.f6105b = window;
                bVarN0.f6114k = cVar;
                bVarN0.f6122s = z10;
                bVarN0.f6123t = str;
                bVarN0.H = i11;
                fragmentManager.beginTransaction().add(i10, bVarN0, Y).commitAllowingStateLoss();
                bVarN0.s0();
            } else if (bVar.f6114k == null) {
                b bVarN1 = n0();
                bVarN1.f6105b = window;
                bVarN1.f6114k = cVar;
                bVarN1.f6122s = z10;
                bVarN1.f6123t = str;
                bVarN1.H = i11;
                fragmentManager.beginTransaction().remove(bVar).commitAllowingStateLoss();
                fragmentManager.beginTransaction().add(i10, bVarN1, Y).commitAllowingStateLoss();
                bVarN1.s0();
            } else {
                bVar.f6105b = window;
                bVar.f6114k = cVar;
                bVar.f6122s = z10;
                bVar.f6111h.p();
                bVar.f6123t = str;
                bVar.H = i11;
                TabLayout tabLayout = bVar.G;
                if (tabLayout != null) {
                    tabLayout.setTag(null);
                }
                fragmentManager.beginTransaction().show(bVar).commitAllowingStateLoss();
                bVar.s0();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void G0(String str) {
        this.f6115l.setVisibility(0);
        this.f6115l.setText(str);
        r1.f(this.f6115l, getActivity(), str, 1);
    }

    private void H0(String str, String str2) {
        if (str2 != null && str2.contains("10101100")) {
            this.f6115l.setText(x1.j(R$string.code_is_block));
            return;
        }
        String[] strArrSplit = str2.split("chr[(]:[)]");
        String str3 = strArrSplit.length > 1 ? strArrSplit[1] : "";
        String str4 = strArrSplit[0];
        if (!TextUtils.isEmpty(str4) && str4.contains(":")) {
            String[] strArrSplit2 = str4.split(":");
            if (strArrSplit2.length > 1) {
                str4 = strArrSplit2[1] + "(" + strArrSplit2[0] + ")";
            }
        }
        String str5 = String.format("%s%s", str, str4);
        this.f6115l.setText(str5);
        if (TextUtils.isEmpty(str3)) {
            r1.f(this.f6115l, getActivity(), str5, 1);
        } else {
            I0(str3, str5);
        }
    }

    private void I0(String str, String str2) {
        new com.live.evo.dialog.b.e(getActivity()).c().h(str2, getString(2131952327), getString(R$string.close), new f(str), null, true, true, true);
    }

    private void J0(int i10) {
        z zVar = new z(getActivity(), i10, new e(i10));
        this.f6118o = zVar;
        if (zVar.f()) {
            this.f6118o.g();
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0035  */
    private int K0(i5.a aVar) {
        int iD = s0.f7342a.D();
        if (aVar != null) {
            if (aVar.e() != 1) {
                if (o5.a.c().g(aVar.d() + aVar.a())) {
                    iD = 6;
                } else {
                    iD = 2;
                }
            } else {
                iD = 6;
            }
        }
        if (iD != 3) {
            return iD != 6 ? 1 : 2;
        }
        return 3;
    }

    private void L0() {
        List<j> list = this.R;
        if (list == null || list.size() <= 0) {
            return;
        }
        if (this.H == 0) {
            this.H = this.R.get(0).f6143b;
            break;
        }
        Iterator<j> it = this.R.iterator();
        do {
            if (!it.hasNext()) {
                this.H = this.R.get(0).f6143b;
                break;
            }
        } while (it.next().f6143b != this.H);
        if (this.G.getTag() != null) {
            w0(((Integer) this.G.getTag()).intValue());
            this.G.setTag(null);
        } else {
            w0(this.H);
        }
        this.H = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0(int i10) {
        for (j jVar : this.R) {
            if (jVar.f6143b == i10) {
                jVar.f6145d.select();
                View view = jVar.f6146e;
                if (view != null) {
                    view.requestFocus();
                    return;
                }
                return;
            }
        }
    }

    private void l() {
        if (this.f6122s) {
            this.f6121r.setVisibility(0);
        }
        this.f6119p.setText(p1.a("adult_login_remind", x1.j(R$string.adult_login_remind)));
        this.f6115l.setVisibility(4);
        this.f6124u = "";
        if (!TextUtils.isEmpty(this.f6123t)) {
            H0("", this.f6123t);
        }
        this.f6106c.setText(Html.fromHtml(p1.a("login_account_title", x1.j(2131952344))));
        this.O = p1.a("login_by_email_remind", x1.j(R$string.login_email));
        this.P = p1.a("login_by_phone_remind", x1.j(R$string.login_phone));
        String strA = p1.a("login_by_renewal_remind", x1.j(R$string.renewal_login_tip));
        this.Q = strA;
        this.f6128y.setText(Html.fromHtml(strA));
        this.M.setText(Html.fromHtml(p1.a("login_by_renewal_code_check_remind", x1.j(R$string.code_login_tip))));
        this.f6129z.c(com.live.evo.l.n().i("email_domains", "gmail.com,hotmail.com,outlook.com,yahoo.com,yahoo.com.br"), false);
        x0();
        C0();
    }

    public static b n0() {
        b bVar = new b();
        X = bVar;
        return bVar;
    }

    private TabLayout.Tab o0(int i10) {
        TabLayout tabLayout = this.G;
        if (tabLayout != null) {
            return tabLayout.getTabAt(i10);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int q0(TabLayout.Tab tab) {
        List<j> list;
        if (tab == null || (list = this.R) == null || list.size() <= 0) {
            return 0;
        }
        for (j jVar : this.R) {
            if (tab.equals(jVar.f6145d)) {
                return jVar.f6143b;
            }
        }
        return 0;
    }

    private View r0(int i10) {
        ViewGroup viewGroup;
        TabLayout tabLayout = this.G;
        if (tabLayout == null || (viewGroup = (ViewGroup) tabLayout.getChildAt(0)) == null || viewGroup.getChildCount() <= i10) {
            return null;
        }
        return viewGroup.getChildAt(i10);
    }

    private void s0() {
        this.U.post(new Runnable() { // from class: com.live.evo.fragment.login.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f6103a.z0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(i5.a aVar) {
        if (com.live.evo.a.f5187g || aVar.e() == 1) {
            this.J.j(aVar);
            return;
        }
        String strA = aVar.a();
        if (o5.a.c().f(strA)) {
            this.f6129z.setText(strA);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            this.f6129z.setSelection(strA.length());
        }
    }

    private void u0() {
        this.f6129z.setNextFocusDownId(R$id.et_pwd);
        this.f6117n.setNextFocusDownId(R$id.et_pwd);
        this.C.setNextFocusDownId(R$id.loginf_tv_login);
        this.D.setNextFocusDownId(R$id.loginf_tv_login);
        this.B.setVisibility(8);
        this.f6109f.setNextFocusRightId(R$id.loginf_tv_login);
        this.f6109f.setNextFocusLeftId(R$id.loginf_tv_login);
        View viewR0 = r0(2);
        if (viewR0 != null) {
            viewR0.setNextFocusDownId(R$id.loginf_ret_renewcode);
        }
        View viewR1 = r0(1);
        if (viewR1 != null) {
            viewR1.setNextFocusDownId(R$id.et_phonenumber);
        }
        this.K.setOnFocusChangeListener(new a());
        this.f6121r.setOnClickListener(this);
        this.f6109f.setOnClickListener(this);
        this.f6110g.setOnClickListener(this);
        this.f6116m.setOnClickListener(this);
        this.f6117n.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.f6109f.setOnFocusChangeListener(this);
        this.f6117n.setOnFocusChangeListener(this);
        this.f6129z.setOnFocusChangeListener(this);
        this.f6107d.setOnFocusChangeListener(this);
        this.C.setOnFocusChangeListener(this);
        this.D.setOnFocusChangeListener(this);
        this.G.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new C0078b());
        List<j> list = this.R;
        if (list != null && list.size() > 0) {
            for (j jVar : this.R) {
                v0(jVar.f6146e, jVar);
            }
            this.f6129z.setOnKeyListener(this.W);
            this.f6117n.setOnKeyListener(this.W);
            this.J.c().setOnKeyListener(this.W);
            this.J.f().setOnKeyListener(this.W);
            this.C.setOnKeyListener(this.W);
            this.D.setOnKeyListener(this.W);
            this.f6107d.setOnKeyListener(this.W);
            this.f6109f.setOnKeyListener(this.W);
        }
        this.f6107d.addTextChangedListener(this.V);
        this.C.addTextChangedListener(this.V);
        this.f6115l.addTextChangedListener(new c());
    }

    private void v0(View view, j jVar) {
        if (view != null) {
            view.setOnFocusChangeListener(new d(jVar));
        }
    }

    private void x0() {
        k0(this.N);
        List<j> list = this.R;
        if (list == null || list.size() <= 1) {
            this.G.setVisibility(8);
        } else {
            this.G.setVisibility(0);
        }
    }

    private void y0() {
        this.f6121r = (ImageView) this.f6104a.findViewById(R$id.loginf_iv_back);
        this.f6106c = (TextView) this.f6104a.findViewById(R$id.loginf_tv_welcome);
        this.f6107d = (EditText) this.f6104a.findViewById(R$id.et_pwd);
        this.f6108e = (RemoveKeyCodeEnterEditText) this.f6104a.findViewById(R$id.et_phonenumber);
        this.f6109f = (TextView) this.f6104a.findViewById(R$id.loginf_tv_login);
        this.f6110g = (TextView) this.f6104a.findViewById(R$id.loginf_tv_register);
        this.f6115l = (TextView) this.f6104a.findViewById(R$id.loginf_tv_error);
        this.f6116m = (TextView) this.f6104a.findViewById(R$id.loginf_tv_forget_pwd);
        this.f6117n = (ImageView) this.f6104a.findViewById(R$id.loginf_iv_more_user);
        this.f6119p = (TextView) this.f6104a.findViewById(R$id.loginf_tv_remind);
        ImageView imageView = (ImageView) this.f6104a.findViewById(R$id.loginf_iv_title);
        this.f6120q = imageView;
        imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), com.live.evo.a.f5198r, null));
        this.F = this.f6104a.findViewById(R$id.loginf_ll_switch);
        this.f6125v = (LinearLayout) this.f6104a.findViewById(R$id.loginf_ll_email_login);
        this.f6126w = (LinearLayout) this.f6104a.findViewById(R$id.loginf_ll_code_login);
        this.f6127x = (TextView) this.f6104a.findViewById(R$id.loginf_tv_account_tip);
        this.f6128y = (TextView) this.f6104a.findViewById(R$id.loginf_tv_renewal_tip);
        this.f6129z = (EmailAutoCompleteTextView) this.f6104a.findViewById(R$id.loginf_et_username);
        this.A = (LinearLayout) this.f6104a.findViewById(R$id.lly_phone);
        this.C = (RechargeEditText) this.f6104a.findViewById(R$id.loginf_ret_renewcode);
        this.D = (ImageView) this.f6104a.findViewById(R$id.loginf_iv_more_code);
        this.G = (TabLayout) this.f6104a.findViewById(R$id.loginf_tl_tab_layout);
        this.B = (LinearLayout) this.f6104a.findViewById(R$id.lly_changephone);
        this.K = (CheckBox) this.f6104a.findViewById(R$id.cb_checkbox);
        this.L = this.f6104a.findViewById(R$id.cb_code_login_tip_parent);
        this.M = (TextView) this.f6104a.findViewById(R$id.cb_code_login_tip);
        this.J = new o5.d(getContext(), this.f6104a);
        this.F.setVisibility(com.live.evo.util.e.b().e() == 1 ? 0 : 8);
        t5.a aVar = new t5.a(getActivity());
        this.f6113j = aVar;
        aVar.f(com.live.evo.widget.sloading.c.TRANSLATE_CIRCLE);
        this.f6113j.g(x1.e(R$color.color_focused));
        this.f6110g.getPaint().setFlags(8);
        this.f6116m.getPaint().setFlags(8);
        this.f6110g.getPaint().setAntiAlias(true);
        this.f6116m.getPaint().setAntiAlias(true);
        com.live.evo.util.t.c(this.f6129z);
        com.live.evo.util.t.c(this.f6107d);
        com.live.evo.util.t.b(this.f6110g);
        com.live.evo.util.t.b(this.f6116m);
        com.live.evo.util.t.d(this.f6109f);
        com.live.evo.util.t.d(this.f6115l);
        com.live.evo.util.t.c(this.C);
        this.f6110g.setText(getResources().getString(2131951940));
        this.f6116m.setText(getResources().getString(R$string.forget_password));
        this.K.setNextFocusRightId(R$id.cb_checkbox);
        if (com.live.evo.l.n().E()) {
            this.f6110g.setVisibility(8);
            this.f6106c.setVisibility(8);
            this.f6116m.setVisibility(4);
            this.f6107d.setNextFocusDownId(R$id.loginf_tv_login);
            this.f6119p.setVisibility(0);
            this.f6120q.setVisibility(8);
        } else {
            this.f6116m.setVisibility(0);
            this.f6120q.setVisibility(0);
            this.f6119p.setVisibility(8);
        }
        if (com.live.evo.util.e.b().d()) {
            this.f6110g.setVisibility(8);
            this.f6116m.setVisibility(8);
        }
        ziyi.kit.keyboard.b bVar = this.S;
        if (bVar != null) {
            bVar.l(this.f6129z);
            this.S.l(this.f6107d);
            this.S.setTabTag(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0() {
        View view = this.T;
        if (view != null) {
            view.setOnFocusChangeListener(this);
        }
        ziyi.kit.keyboard.b bVar = this.S;
        if (bVar == null || bVar.getVisibility() != 0) {
            return;
        }
        this.S.p();
    }

    @Override // e5.a.InterfaceC0175a
    public boolean H() {
        ziyi.kit.keyboard.b bVar = this.S;
        if (bVar != null && bVar.getVisibility() == 0) {
            this.S.p();
            return true;
        }
        ImageView imageView = this.f6121r;
        if (imageView == null || imageView.getVisibility() != 0) {
            return e5.a.a(this);
        }
        e5.c cVar = this.f6114k;
        if (cVar != null) {
            cVar.a(this);
        }
        return true;
    }

    @Override // com.live.evo.fragment.login.presenter.d
    public void J(String str) {
        this.f6115l.setVisibility(0);
        H0("", str);
    }

    @Override // com.live.evo.fragment.login.presenter.d
    public void P() {
        this.f6114k.c(this);
    }

    @Override // com.live.evo.fragment.login.presenter.d
    public void a() {
        this.f6113j.d();
    }

    @Override // com.live.evo.fragment.login.presenter.d
    public void b() {
        this.f6113j.h();
    }

    @Override // com.live.evo.fragment.login.presenter.d
    public void c() {
        e5.c cVar = this.f6114k;
        if (cVar != null) {
            cVar.b(this);
        }
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z10) {
        if (!z10) {
            z0.g(view);
            return;
        }
        z0.d(view);
        if (view.getId() == 2131428022) {
            String string = this.f6107d.getText().toString();
            if (TextUtils.isEmpty(string)) {
                return;
            }
            this.f6107d.setSelection(string.length());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        com.live.evo.fragment.login.presenter.c cVar = this.f6111h;
        if (cVar != null) {
            cVar.u();
        }
        super.onPause();
    }

    private void E0(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getContext(), R$anim.arrow_shake));
    }

    private void k0(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            str = "1,2";
        }
        try {
            String[] strArrSplit = str.split(",");
            if (this.R == null) {
                this.R = new ArrayList();
            }
            this.R.clear();
            int i10 = 0;
            for (String str2 : strArrSplit) {
                try {
                    int iIntValue = Integer.valueOf(str2).intValue();
                    if (iIntValue >= 0 && iIntValue <= 3) {
                        j jVar = new j(this, null);
                        jVar.f6142a = i10;
                        jVar.f6143b = iIntValue;
                        jVar.f6144c = p0(iIntValue);
                        TabLayout.Tab tabO0 = o0(i10);
                        jVar.f6145d = tabO0;
                        tabO0.setText(jVar.f6144c);
                        jVar.f6146e = r0(i10);
                        this.R.add(i10, jVar);
                        i10++;
                    }
                } catch (Throwable unused) {
                }
            }
            int tabCount = this.G.getTabCount() - 1;
            for (int tabCount2 = this.G.getTabCount() - this.R.size(); tabCount2 > 0; tabCount2--) {
                this.G.removeTabAt(tabCount);
                tabCount--;
            }
        } catch (Throwable unused2) {
        }
    }

    private boolean m0(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            if (com.live.evo.a.f5187g) {
                this.J.f().requestFocus();
                E0(this.J.f());
            } else {
                this.f6129z.requestFocus();
                E0(this.f6129z);
            }
            G0(getString(2131951652));
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            G0(x1.j(R$string.password_no_empty));
            this.f6107d.requestFocus();
            E0(this.f6107d);
            return false;
        }
        int iA = o5.a.c().a(str);
        this.I = iA;
        if (iA >= 0) {
            return true;
        }
        this.f6115l.setText(2131953141);
        r1.e(this.f6115l, getActivity(), 2131953141, 1);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(int i10) {
        RechargeEditText rechargeEditText;
        D0(i10);
        l0(i10);
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3 && (rechargeEditText = this.C) != null && TextUtils.isEmpty(rechargeEditText.getText().toString().trim())) {
                    this.C.requestFocus();
                    z0.d(this.C);
                    return;
                }
            } else if (this.J.f() != null) {
                if (TextUtils.isEmpty(this.J.e())) {
                    this.J.f().requestFocus();
                    return;
                }
                EditText editText = this.f6107d;
                if (editText != null) {
                    editText.requestFocus();
                    z0.d(this.f6107d);
                    return;
                }
            }
        } else {
            EmailAutoCompleteTextView emailAutoCompleteTextView = this.f6129z;
            if (emailAutoCompleteTextView != null) {
                if (TextUtils.isEmpty(emailAutoCompleteTextView.getText().toString().trim())) {
                    this.f6129z.requestFocus();
                    z0.d(this.f6129z);
                    return;
                } else {
                    EditText editText2 = this.f6107d;
                    if (editText2 != null) {
                        editText2.requestFocus();
                        z0.d(this.f6107d);
                        return;
                    }
                }
            }
        }
        TextView textView = this.f6109f;
        if (textView != null) {
            textView.requestFocus();
            z0.d(this.f6109f);
        }
    }

    @Override // com.live.evo.fragment.login.presenter.d
    public void d() {
        FragmentActivity activity = getActivity();
        if (activity instanceof AppCompatActivity) {
            t1.INSTANCE.f((AppCompatActivity) activity, this.f6112i, new g());
        }
    }

    @Override // com.live.evo.fragment.login.presenter.d
    public void k(i5.a aVar) {
        boolean z10;
        int iK0 = K0(aVar);
        if (aVar != null) {
            if (!o5.a.c().g(aVar.d() + aVar.a()) && aVar.e() != 1) {
                z10 = false;
            } else {
                z10 = true;
            }
            com.live.evo.a.f5187g = z10;
            t0(aVar);
            String strC = aVar.c();
            if (!TextUtils.isEmpty(strC) && ((com.live.evo.a.f5187g && aVar.e() == 1) || (!com.live.evo.a.f5187g && aVar.e() == 0))) {
                this.f6107d.setText(strC);
                this.f6107d.setSelection(strC.length());
            }
        }
        String strR = t.v.c.i.a.f18646a.r();
        if (!TextUtils.isEmpty(strR)) {
            HashMap map = new HashMap();
            if (map.get(strR) != null) {
                this.E = (i5.a) map.get(strR);
            } else {
                this.E = new i5.a(2, "", "", "", strR);
            }
            String strC2 = x1.c(strR, 4, 8, "********");
            if (!TextUtils.isEmpty(strC2)) {
                this.C.setText(strC2);
                RechargeEditText rechargeEditText = this.C;
                rechargeEditText.setSelection(rechargeEditText.getText().length());
            }
        }
        this.H = iK0;
        L0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i10;
        int id2 = view.getId();
        switch (id2) {
            case R$id.loginf_iv_back /* 2131428588 */:
                e5.c cVar = this.f6114k;
                if (cVar != null) {
                    cVar.a(this);
                }
                break;
            case R$id.loginf_iv_more_code /* 2131428589 */:
                J0(3);
                break;
            case R$id.loginf_iv_more_user /* 2131428590 */:
                if (com.live.evo.a.f5187g) {
                    i10 = 6;
                } else {
                    i10 = 2;
                }
                J0(i10);
                break;
            default:
                switch (id2) {
                    case R$id.loginf_tv_forget_pwd /* 2131428606 */:
                        TabLayout tabLayout = this.G;
                        tabLayout.setTag(Integer.valueOf(q0(tabLayout.getTabAt(tabLayout.getSelectedTabPosition()))));
                        B0();
                        break;
                    case R$id.loginf_tv_login /* 2131428607 */:
                        A0();
                        break;
                    case R$id.loginf_tv_register /* 2131428608 */:
                        if (this.f6114k != null) {
                            TabLayout tabLayout2 = this.G;
                            tabLayout2.setTag(Integer.valueOf(q0(tabLayout2.getTabAt(tabLayout2.getSelectedTabPosition()))));
                            this.f6114k.d(this);
                        }
                        break;
                }
                break;
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f6104a = layoutInflater.inflate(R$layout.accountuser_login_fragment, viewGroup, false);
        this.S = KeyUtils.t(this.f6105b, getContext(), this.f6104a, getLifecycle(), false);
        com.live.evo.fragment.login.presenter.e eVar = new com.live.evo.fragment.login.presenter.e();
        this.f6111h = eVar;
        eVar.r(this);
        this.N = com.live.evo.l.n().i("login_tab_rule", "");
        this.f6112i = t1.INSTANCE.a(getActivity());
        y0();
        l();
        u0();
        a0.k(this, this.f6104a);
        return this.f6104a;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z10) {
        super.onHiddenChanged(z10);
        if (!z10) {
            l();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.live.evo.fragment.login.presenter.c cVar = this.f6111h;
        if (cVar != null) {
            cVar.r(this);
            this.f6111h.p();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
    }
}
