package com.live.evo.fragment.login;

import android.annotation.SuppressLint;
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
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.tabs.TabLayout;
import com.live.evo.MyApplication;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.fragment.t1;
import com.live.evo.util.p1;
import com.live.evo.util.s0;
import com.live.evo.util.x1;
import com.live.evo.util.z0;
import com.live.evo.widget.EmailAutoCompleteTextView;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.spi.Configurator;
import r8.z;
import x1.f1.lb.util.g1;
import ziyi.kit.keyboard.KeyUtils;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class p extends Fragment implements View.OnClickListener, com.live.evo.fragment.login.presenter.k, View.OnFocusChangeListener, TextWatcher, e5.a.InterfaceC0175a {

    @SuppressLint({"StaticFieldLeak"})
    private static p I = null;
    private static String J = "RegisterEmailFragment";
    private boolean A;
    private i5.a B;
    private Window D;
    private View E;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f6288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f6289e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f6290f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TabLayout f6291g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private LinearLayout f6292h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private EmailAutoCompleteTextView f6293i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private EditText f6294j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private EditText f6295k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private TextView f6296l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private TextView f6297m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private e5.h f6298n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private com.live.evo.fragment.login.presenter.j f6299o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private t1.b f6300p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private TextView f6301q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private t5.a f6302r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private TextView f6303s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private TextView f6304t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private j f6305u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private k f6306v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private TextView f6307w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private TextView f6308x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private ImageView f6309y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private o5.d f6310z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q6.b f6285a = q6.c.d(com.live.evo.fragment.login.j.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6286b = 1;
    private ziyi.kit.keyboard.b C = null;
    private Runnable F = new f();
    private Runnable G = new g();
    private View.OnKeyListener H = new i();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            p.this.f6301q.setText("");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                p.this.f6301q.setVisibility(4);
            } else {
                p.this.f6301q.setVisibility(0);
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
    class c implements TabLayout.OnTabSelectedListener {
        c() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            p.this.f6301q.setText("");
            p.this.h0(TextUtils.equals(tab.getText(), x1.j(R$string.register_phone)));
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class d implements com.live.evo.dialog.r.c {
        d() {
        }

        @Override // com.live.evo.dialog.r.c
        public void b() {
            p.this.p0();
        }

        @Override // com.live.evo.dialog.r.c
        public void a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class e implements com.live.evo.dialog.r.c {
        e() {
        }

        @Override // com.live.evo.dialog.r.c
        public void b() {
            p.this.f6301q.setText("");
            p.this.p0();
        }

        @Override // com.live.evo.dialog.r.c
        public void a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            p.this.f6296l.setClickable(true);
            p.this.f6296l.setText(MyApplication.a().getString(2131952907));
            if (p.this.f6305u != null) {
                p.this.f6305u.cancel();
            }
            p.this.f6297m.setClickable(true);
            p.this.f6297m.setText(MyApplication.a().getString(2131952907));
            if (p.this.f6306v != null) {
                p.this.f6306v.cancel();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            p.this.n0();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class h implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6318a;

        h(int i10) {
            this.f6318a = i10;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            if (!z10 || view == null) {
                return;
            }
            boolean zEquals = TextUtils.equals(p.this.f6291g.getTabAt(this.f6318a).getText(), x1.j(R$string.register_phone));
            p.this.f6291g.getTabAt(this.f6318a).select();
            p.this.h0(zEquals);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class i implements View.OnKeyListener {
        i() {
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
            TabLayout.Tab tabAt = p.this.f6291g.getTabAt(0);
            TabLayout.Tab tabAt2 = p.this.f6291g.getTabAt(1);
            ViewGroup viewGroup = (ViewGroup) p.this.f6291g.getChildAt(0);
            if (viewGroup == null || viewGroup.getChildCount() < 2) {
                childAt = null;
                childAt2 = null;
            } else {
                childAt = viewGroup.getChildAt(0);
                childAt2 = viewGroup.getChildAt(1);
            }
            if (keyEvent.getAction() == 0 && i10 == 19) {
                if (p.this.C == null || (p.this.C != null && p.this.C.getVisibility() != 0)) {
                    int id2 = view.getId();
                    if (id2 != 2131428021) {
                        if (id2 == 2131429119) {
                            if (p.this.f6290f.getVisibility() != 0) {
                                return true;
                            }
                            tabAt.select();
                            if (childAt != null) {
                                childAt.requestFocus();
                            }
                            return true;
                        }
                    }
                    if (p.this.f6290f.getVisibility() != 0) {
                        return true;
                    }
                    p.this.f6291g.requestFocus();
                    tabAt2.select();
                    if (childAt2 != null) {
                        childAt2.requestFocus();
                    }
                    return true;
                }
            } else {
                if (p.this.C != null && keyEvent.getAction() == 0 && (i10 == 23 || i10 == 66)) {
                    switch (view.getId()) {
                        case R$id.et_phonenumber /* 2131428021 */:
                        case R$id.et_pwd /* 2131428022 */:
                        case R$id.registeremail_et_email /* 2131429119 */:
                        case R$id.registeremail_et_verify_code /* 2131429120 */:
                            p.this.C.m0();
                            if (view.getId() != 2131428021) {
                                p.this.E = view;
                            }
                            return true;
                    }
                }
                if (p.this.C != null && keyEvent.getAction() == 1 && (i10 == 23 || i10 == 66)) {
                    switch (view.getId()) {
                        case R$id.et_phonenumber /* 2131428021 */:
                        case R$id.et_pwd /* 2131428022 */:
                        case R$id.registeremail_et_email /* 2131429119 */:
                        case R$id.registeremail_et_verify_code /* 2131429120 */:
                            return true;
                    }
                }
                if (p.this.C != null && keyEvent.getAction() == 1 && (i10 == 4 || i10 == 111)) {
                    switch (view.getId()) {
                        case R$id.et_phonenumber /* 2131428021 */:
                        case R$id.et_pwd /* 2131428022 */:
                        case R$id.registeremail_et_email /* 2131429119 */:
                        case R$id.registeremail_et_verify_code /* 2131429120 */:
                            if (p.this.E != null) {
                                p.this.E.setOnFocusChangeListener(p.this);
                            }
                            if (p.this.C.getVisibility() == 0) {
                                p.this.C.p();
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
    public class j extends CountDownTimer {
        j(long j10, long j11) {
            super(j10, j11);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            try {
                p.this.f6296l.setText(x1.j(2131952907));
                p.this.f6296l.setClickable(true);
            } catch (Exception unused) {
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
            p.this.u0(j10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public class k extends CountDownTimer {
        k(long j10, long j11) {
            super(j10, j11);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            try {
                p.this.f6297m.setText(x1.j(2131952907));
                p.this.f6297m.setClickable(true);
            } catch (Exception unused) {
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
            p.this.v0(j10);
        }
    }

    public static /* synthetic */ z R(Boolean bool) {
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        I = null;
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(boolean z10) {
        if (z10) {
            ziyi.kit.keyboard.b bVar = this.C;
            if (bVar != null && bVar.getTabTag().intValue() != 5) {
                this.C.W();
                this.C.setTabTag(5);
                this.C.l(this.f6310z.f());
                this.C.l(this.f6294j);
                this.C.l(this.f6295k);
            }
            this.f6297m.setNextFocusUpId(R$id.et_phonenumber);
            this.f6294j.setNextFocusRightId(R$id.tv_verify_phone);
            this.f6295k.setNextFocusUpId(R$id.tv_verify_phone);
        } else {
            ziyi.kit.keyboard.b bVar2 = this.C;
            if (bVar2 != null && bVar2.getTabTag().intValue() != 4) {
                this.C.W();
                this.C.setTabTag(4);
                this.C.l(this.f6293i);
                this.C.l(this.f6294j);
                this.C.l(this.f6295k);
            }
            this.f6296l.setNextFocusUpId(R$id.registeremail_et_email);
            this.f6294j.setNextFocusRightId(R$id.tv_verify);
            this.f6295k.setNextFocusUpId(R$id.tv_verify);
        }
        this.f6296l.setVisibility(!z10 ? 0 : 8);
        this.f6297m.setVisibility(z10 ? 0 : 8);
        this.f6293i.setVisibility(!z10 ? 0 : 8);
        this.f6292h.setVisibility(z10 ? 0 : 8);
    }

    public static p i0() {
        if (I == null) {
            I = new p();
        }
        return I;
    }

    private void j0(i5.a aVar) {
        if (aVar == null) {
            return;
        }
        if (com.live.evo.a.f5187g) {
            this.f6310z.j(aVar);
            if (TextUtils.isEmpty(aVar.a())) {
                this.f6310z.f().requestFocus();
            }
            this.f6310z.n(aVar);
        } else {
            this.f6293i.setText(aVar.a());
            if (TextUtils.isEmpty(aVar.a())) {
                this.f6293i.requestFocus();
                z0.d(this.f6293i);
            } else {
                this.f6293i.setSelection(aVar.a().length());
            }
        }
        if (TextUtils.isEmpty(aVar.a())) {
            return;
        }
        if (com.live.evo.a.f5187g) {
            this.f6297m.requestFocus();
        } else {
            this.f6296l.requestFocus();
        }
    }

    private void k0() {
        ViewGroup viewGroup;
        this.f6310z.c().setNextFocusDownId(R$id.et_phonenumber);
        this.f6310z.f().setNextFocusDownId(R$id.tv_verify_phone);
        this.f6310z.f().setNextFocusRightId(R$id.tv_verify_phone);
        this.f6293i.setNextFocusDownId(R$id.tv_verify);
        this.f6296l.setNextFocusDownId(R$id.et_pwd);
        this.f6296l.setNextFocusLeftId(R$id.registeremail_et_verify_code);
        this.f6296l.setNextFocusRightId(R$id.tv_verify);
        this.f6297m.setNextFocusDownId(R$id.et_pwd);
        this.f6297m.setNextFocusLeftId(R$id.registeremail_et_verify_code);
        this.f6297m.setNextFocusRightId(R$id.tv_verify_phone);
        this.f6294j.setNextFocusRightId(R$id.tv_verify);
        this.f6294j.setNextFocusUpId(R$id.registeremail_et_email);
        this.f6294j.setNextFocusDownId(R$id.et_pwd);
        this.f6294j.setNextFocusLeftId(R$id.registeremail_et_verify_code);
        this.f6295k.setNextFocusDownId(R$id.registeremail_tv_submit);
        this.f6295k.setNextFocusUpId(R$id.tv_verify);
        this.f6295k.setNextFocusRightId(R$id.et_pwd);
        if (this.f6307w.getVisibility() == 0) {
            this.f6303s.setNextFocusRightId(R$id.registeremail_tv_button_return);
        } else {
            this.f6303s.setNextFocusRightId(R$id.registeremail_tv_submit);
        }
        this.f6303s.setNextFocusUpId(R$id.et_pwd);
        this.f6303s.setNextFocusLeftId(R$id.registeremail_tv_submit);
        this.f6307w.setNextFocusLeftId(R$id.registeremail_tv_submit);
        this.f6307w.setNextFocusUpId(R$id.et_pwd);
        this.f6307w.setNextFocusRightId(R$id.registeremail_tv_button_return);
        this.f6296l.setOnClickListener(this);
        this.f6297m.setOnClickListener(this);
        this.f6303s.setOnClickListener(this);
        this.f6307w.setOnClickListener(this);
        this.f6296l.setOnFocusChangeListener(this);
        this.f6297m.setOnFocusChangeListener(this);
        this.f6295k.setOnFocusChangeListener(this);
        this.f6303s.setOnFocusChangeListener(this);
        this.f6293i.setOnFocusChangeListener(this);
        this.f6294j.setOnFocusChangeListener(this);
        this.f6307w.setOnFocusChangeListener(this);
        this.f6294j.addTextChangedListener(this);
        this.f6293i.addTextChangedListener(new a());
        this.f6295k.addTextChangedListener(this);
        this.f6301q.addTextChangedListener(new b());
        this.f6291g.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new c());
        if (this.f6291g.getTabCount() >= 2 && (viewGroup = (ViewGroup) this.f6291g.getChildAt(0)) != null && viewGroup.getChildCount() >= 2) {
            l0(viewGroup.getChildAt(0), 0);
            l0(viewGroup.getChildAt(1), 1);
        }
        this.f6293i.setOnKeyListener(this.H);
        this.f6310z.c().setOnKeyListener(this.H);
        this.f6310z.f().setOnKeyListener(this.H);
        this.f6294j.setOnKeyListener(this.H);
        this.f6295k.setOnKeyListener(this.H);
    }

    private void l() {
        String strA;
        String strD;
        j0(this.B);
        int i10 = this.f6286b;
        if (i10 == 0) {
            strA = p1.a("register_bindemail_remind", x1.j(R$string.register_by_bind));
            this.f6307w.setVisibility(8);
            this.f6308x.setVisibility(0);
            this.f6308x.setText(String.format("%s%s", x1.j(R$string.user_id), t.v.c.i.a.f18646a.Z()));
        } else if (i10 == 1) {
            strA = x1.j(R$string.normal_register_remind) + " " + s0.f7342a.z();
            this.f6308x.setVisibility(8);
            this.f6307w.setVisibility(0);
        } else if (i10 == 2) {
            strA = x1.j(R$string.normal_register_remind) + " " + s0.f7342a.z();
            this.f6308x.setVisibility(8);
            this.f6307w.setVisibility(0);
        } else if (i10 != 3) {
            strA = "";
        } else {
            strA = x1.j(R$string.register_by_bind_renew_code);
            this.f6307w.setVisibility(8);
            this.f6308x.setVisibility(0);
            t.v.c.i.a aVar = t.v.c.i.a.f18646a;
            if (aVar.r().isEmpty()) {
                strD = x1.j(R$string.user_device);
            } else {
                String strR = aVar.r();
                strD = TextUtils.isEmpty(strR) ? Configurator.NULL : x1.d(strR, "*");
            }
            this.f6308x.setText(String.format("%s: %s", x1.j(R$string.renewal_code), strD));
        }
        if (this.f6286b == 0) {
            this.f6295k.setVisibility(8);
        } else {
            this.f6295k.setText("");
            this.f6294j.setText("");
            this.f6295k.setVisibility(0);
        }
        this.f6304t.setText(Html.fromHtml(strA));
        if (this.f6287c) {
            this.f6307w.setVisibility(0);
        }
        t0();
        if (!this.f6288d) {
            this.f6293i.setEnabled(true);
            this.f6310z.c().setEnabled(true);
            this.f6310z.f().setEnabled(true);
        } else {
            this.f6293i.setEnabled(false);
            this.f6310z.c().setEnabled(false);
            this.f6310z.f().setEnabled(false);
            this.f6296l.requestFocus();
            this.E = this.f6296l;
        }
    }

    private void l0(View view, int i10) {
        if (view != null) {
            view.setOnFocusChangeListener(new h(i10));
        }
    }

    private void m0() {
        ImageView imageView = (ImageView) this.f6289e.findViewById(R$id.registeremail_iv_title);
        this.f6309y = imageView;
        imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), com.live.evo.a.f5198r, null));
        this.f6290f = this.f6289e.findViewById(R$id.lly_login_switch);
        this.f6291g = (TabLayout) this.f6289e.findViewById(R$id.tab_layout);
        this.f6293i = (EmailAutoCompleteTextView) this.f6289e.findViewById(R$id.registeremail_et_email);
        this.f6292h = (LinearLayout) this.f6289e.findViewById(R$id.lly_phone);
        this.f6296l = (TextView) this.f6289e.findViewById(R$id.tv_verify);
        this.f6297m = (TextView) this.f6289e.findViewById(R$id.tv_verify_phone);
        this.f6294j = (EditText) this.f6289e.findViewById(R$id.registeremail_et_verify_code);
        this.f6295k = (EditText) this.f6289e.findViewById(R$id.et_pwd);
        this.f6301q = (TextView) this.f6289e.findViewById(R$id.registeremail_tv_error);
        this.f6303s = (TextView) this.f6289e.findViewById(R$id.registeremail_tv_submit);
        this.f6304t = (TextView) this.f6289e.findViewById(R$id.registeremail_ltv_remind);
        this.f6307w = (TextView) this.f6289e.findViewById(R$id.registeremail_tv_button_return);
        this.f6308x = (TextView) this.f6289e.findViewById(R$id.registeremail_tv_account);
        TextView textView = (TextView) this.f6289e.findViewById(R$id.tv_trial_tip);
        if (!this.A) {
            this.f6291g.setVisibility(8);
        }
        this.f6310z = new o5.d(getContext(), this.f6289e);
        t5.a aVar = new t5.a(getContext());
        this.f6302r = aVar;
        aVar.f(com.live.evo.widget.sloading.c.TRANSLATE_CIRCLE);
        this.f6302r.g(ViewCompat.MEASURED_STATE_MASK);
        com.live.evo.util.t.c(this.f6293i);
        com.live.evo.util.t.c(this.f6296l);
        com.live.evo.util.t.c(this.f6297m);
        com.live.evo.util.t.c(this.f6294j);
        com.live.evo.util.t.c(this.f6295k);
        com.live.evo.util.t.c(this.f6301q);
        com.live.evo.util.t.b(this.f6308x);
        com.live.evo.util.t.d(this.f6303s);
        com.live.evo.util.t.d(this.f6307w);
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity);
        textView.setText(Html.fromHtml(activity.getString(R$string.free_trial_tip, Integer.valueOf(t.v.c.i.a.f18646a.T()))));
        this.f6293i.c("gmail.com,hotmail.com,outlook.com,yahoo.com,yahoo.com.br", false);
        ziyi.kit.keyboard.b bVar = this.C;
        if (bVar != null) {
            bVar.l(this.f6293i);
            this.C.l(this.f6294j);
            this.C.l(this.f6295k);
            this.C.setTabTag(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        e5.h hVar = this.f6298n;
        if (hVar != null) {
            hVar.a(this);
        }
        j jVar = this.f6305u;
        if (jVar != null) {
            jVar.cancel();
        }
        k kVar = this.f6306v;
        if (kVar != null) {
            kVar.cancel();
        }
        if (this.f6288d) {
            this.f6293i.setEnabled(true);
            this.f6310z.c().setEnabled(true);
            this.f6310z.f().setEnabled(true);
        }
        this.f6296l.setText(MyApplication.a().getString(2131952907));
        this.f6296l.setClickable(true);
        this.f6297m.setText(MyApplication.a().getString(2131952907));
        this.f6297m.setClickable(true);
        this.f6301q.setText("");
    }

    private void o0() {
        String str;
        int i10;
        boolean zEquals = TextUtils.equals(this.f6291g.getTabAt(this.f6291g.getSelectedTabPosition()).getText(), x1.j(R$string.register_email));
        if (this.f6288d) {
            zEquals = !com.live.evo.a.f5187g;
        }
        String strTrim = zEquals ? this.f6293i.getText().toString().trim() : this.f6310z.d();
        if (TextUtils.isEmpty(strTrim)) {
            this.f6301q.setText(2131951652);
            g1.f21390a.c(getString(2131951652));
            return;
        }
        o5.a aVarC = o5.a.c();
        if (!(zEquals ? aVarC.f(strTrim) : aVarC.g(strTrim))) {
            this.f6301q.setText(2131953141);
            g1.f21390a.c(getString(2131953141));
            return;
        }
        String strTrim2 = this.f6294j.getText().toString().trim();
        if (TextUtils.isEmpty(strTrim2)) {
            this.f6301q.setText(2131953166);
            g1.f21390a.c(getString(2131953166));
            return;
        }
        if (this.f6286b != 0) {
            String strTrim3 = this.f6295k.getText().toString().trim();
            if (TextUtils.isEmpty(strTrim3)) {
                this.f6301q.setText(2131952756);
                g1.f21390a.c(getString(2131952756));
                return;
            } else {
                if (strTrim3.length() < 6 || strTrim3.length() > 16) {
                    r0(x1.j(2131952758), "");
                    return;
                }
                str = strTrim3;
            }
        } else {
            str = "";
        }
        b();
        i5.a aVar = new i5.a();
        if (zEquals) {
            aVar.j(0);
            aVar.f(strTrim);
            aVar.h(str);
            i10 = 0;
        } else {
            strTrim = o5.a.c().d(strTrim);
            i5.o oVarG = this.f6310z.g();
            aVar.j(1);
            aVar.f(this.f6310z.e());
            aVar.i(oVarG.c());
            aVar.g(oVarG.a());
            aVar.h(str);
            i10 = 1;
        }
        String str2 = strTrim;
        int i11 = this.f6286b;
        if (i11 == 3 || i11 == 0) {
            g1.f21390a.c(getString(R$string.not_supported_yet));
        } else {
            this.f6299o.t(str2, i10, strTrim2, str, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0() {
        boolean zEquals = TextUtils.equals(this.f6291g.getTabAt(this.f6291g.getSelectedTabPosition()).getText(), x1.j(R$string.register_phone));
        if (this.f6288d) {
            zEquals = com.live.evo.a.f5187g;
        }
        if (zEquals) {
            this.f6297m.setClickable(true);
            this.f6297m.setText(x1.j(2131952907));
            k kVar = this.f6306v;
            if (kVar != null) {
                kVar.cancel();
                return;
            }
            return;
        }
        this.f6296l.setClickable(true);
        this.f6296l.setText(x1.j(2131952907));
        j jVar = this.f6305u;
        if (jVar != null) {
            jVar.cancel();
        }
    }

    public static synchronized void q0(FragmentManager fragmentManager, Window window, int i10, int i11, boolean z10, boolean z11, i5.a aVar, e5.h hVar) {
        try {
            p pVarI0 = i0();
            pVarI0.A = true;
            pVarI0.f6286b = i11;
            pVarI0.f6287c = z10;
            pVarI0.f6288d = z11;
            pVarI0.f6298n = hVar;
            pVarI0.D = window;
            pVarI0.B = aVar;
            Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag(J);
            FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
            if (fragmentFindFragmentByTag != null || pVarI0.isAdded()) {
                pVarI0.l();
                fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag).commitAllowingStateLoss();
            } else {
                fragmentTransactionBeginTransaction.add(i10, pVarI0, J).commitAllowingStateLoss();
                fragmentManager.executePendingTransactions();
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            throw th;
        }
    }

    private void s0(String str, Runnable runnable, Runnable runnable2) {
        new com.live.evo.dialog.b.e(getActivity()).c().h(str, getString(R$string.close), getString(2131952330), runnable, runnable2, true, true, true);
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
    private void t0() {
        View view;
        if (this.f6288d && (view = this.f6290f) != null) {
            view.setVisibility(8);
            h0(com.live.evo.a.f5187g);
            return;
        }
        TabLayout tabLayout = this.f6291g;
        if (tabLayout == null || tabLayout.getTabCount() <= 1) {
            return;
        }
        this.f6290f.setVisibility(0);
        this.f6291g.getTabAt(com.live.evo.a.f5187g ? 1 : 0).select();
        h0(com.live.evo.a.f5187g);
        if (com.live.evo.a.f5187g) {
            this.f6310z.f().requestFocus();
            return;
        }
        this.f6293i.requestFocus();
        EmailAutoCompleteTextView emailAutoCompleteTextView = this.f6293i;
        this.E = emailAutoCompleteTextView;
        z0.d(emailAutoCompleteTextView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(long j10) {
        try {
            this.f6296l.setText(x1.j(2131952906) + TimeUnit.MILLISECONDS.toSeconds(j10) + "s)");
        } catch (Exception e10) {
            this.f6285a.error(e10.getMessage(), e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(long j10) {
        try {
            this.f6297m.setText(x1.j(2131952906) + TimeUnit.MILLISECONDS.toSeconds(j10) + "s)");
        } catch (Exception e10) {
            this.f6285a.error(e10.getMessage(), e10);
        }
    }

    private void w0() {
        this.f6301q.setText("");
        boolean zEquals = TextUtils.equals(this.f6291g.getTabAt(this.f6291g.getSelectedTabPosition()).getText(), x1.j(R$string.register_email));
        int i10 = 1;
        if (this.f6288d) {
            zEquals = !com.live.evo.a.f5187g;
        }
        String strTrim = zEquals ? this.f6293i.getText().toString().trim() : this.f6310z.d();
        if (TextUtils.isEmpty(strTrim)) {
            this.f6301q.setText(2131951652);
            g1.f21390a.c(getString(2131951652));
            return;
        }
        o5.a aVarC = o5.a.c();
        if (!(zEquals ? aVarC.f(strTrim) : aVarC.g(strTrim))) {
            this.f6301q.setText(2131953141);
            g1.f21390a.c(getString(2131953141));
            return;
        }
        b();
        i5.a aVar = new i5.a();
        if (zEquals) {
            aVar.j(0);
            aVar.f(strTrim);
            i10 = 0;
        } else {
            strTrim = o5.a.c().d(strTrim);
            i5.o oVarG = this.f6310z.g();
            aVar.j(1);
            aVar.f(this.f6310z.e());
            aVar.i(oVarG.c());
            aVar.g(oVarG.a());
        }
        this.f6299o.j(strTrim, i10, aVar);
        if (zEquals) {
            j jVar = this.f6305u;
            if (jVar == null) {
                j jVar2 = new j(120000L, 1000L);
                this.f6305u = jVar2;
                jVar2.start();
            } else {
                jVar.cancel();
                this.f6305u.start();
            }
            this.f6296l.setClickable(false);
            return;
        }
        k kVar = this.f6306v;
        if (kVar == null) {
            k kVar2 = new k(120000L, 1000L);
            this.f6306v = kVar2;
            kVar2.start();
        } else {
            kVar.cancel();
            this.f6306v.start();
        }
        this.f6297m.setClickable(false);
    }

    @Override // e5.a.InterfaceC0175a
    public boolean H() {
        ziyi.kit.keyboard.b bVar = this.C;
        if (bVar != null && bVar.getVisibility() == 0) {
            this.C.p();
            return true;
        }
        TextView textView = this.f6307w;
        if (textView == null || textView.getVisibility() != 0) {
            return e5.a.a(this);
        }
        n0();
        return true;
    }

    @Override // com.live.evo.fragment.login.presenter.k
    public void a() {
        this.f6302r.d();
    }

    public void b() {
        this.f6302r.h();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        this.f6301q.setText("");
    }

    @Override // com.live.evo.fragment.login.presenter.k
    public void j(String str, String str2) {
        this.f6302r.d();
        if (str2.equals("10101059")) {
            s0(str, this.F, this.G);
            return;
        }
        com.live.evo.dialog.r rVar = new com.live.evo.dialog.r(getActivity(), new d());
        rVar.k(x1.j(2131953168));
        rVar.j(str, x1.j(2131952013) + str2);
        rVar.l();
        r0("", str);
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
        com.live.evo.fragment.login.presenter.j jVar = this.f6299o;
        if (jVar != null) {
            jVar.u();
        }
        super.onPause();
    }

    private void r0(String str, String str2) {
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
        String str4 = String.format("%s %s", str, str3);
        this.f6301q.setText(str4);
        g1.f21390a.c(str4);
    }

    @Override // com.live.evo.fragment.login.presenter.k
    public void A(String str, String str2) {
        a();
        if (str2.contains("10101059")) {
            s0(str, this.F, this.G);
            return;
        }
        com.live.evo.dialog.r rVar = new com.live.evo.dialog.r(getActivity(), new e());
        rVar.k(x1.j(2131952960));
        rVar.j(str, x1.j(2131952013) + str2);
        rVar.l();
    }

    @Override // com.live.evo.fragment.login.presenter.k
    public void c() {
        a();
        this.f6296l.setText(x1.j(2131952907));
        this.f6296l.setClickable(true);
        this.f6297m.setText(x1.j(2131952907));
        this.f6297m.setClickable(true);
        j jVar = this.f6305u;
        if (jVar != null) {
            jVar.cancel();
        }
        k kVar = this.f6306v;
        if (kVar != null) {
            kVar.cancel();
        }
        this.f6302r.d();
        this.f6298n.b(this);
    }

    @Override // com.live.evo.fragment.login.presenter.k
    public void d() {
        FragmentActivity activity = getActivity();
        if (activity instanceof AppCompatActivity) {
            t1.INSTANCE.f((AppCompatActivity) activity, this.f6300p, new c9.l() { // from class: com.live.evo.fragment.login.o
                @Override // c9.l
                public final Object invoke(Object obj) {
                    return p.R((Boolean) obj);
                }
            });
        }
    }

    @Override // com.live.evo.fragment.login.presenter.k
    public void h() {
        a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R$id.registeremail_tv_button_return /* 2131429125 */:
                n0();
                break;
            case R$id.registeremail_tv_submit /* 2131429129 */:
                o0();
                break;
            case R$id.tv_verify /* 2131429775 */:
                w0();
                break;
            case R$id.tv_verify_phone /* 2131429776 */:
                w0();
                break;
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        this.f6289e = layoutInflater.inflate(R$layout.register_email, viewGroup, false);
        this.f6299o = new com.live.evo.fragment.login.presenter.l();
        this.f6300p = t1.INSTANCE.a(getActivity());
        this.f6299o.r(this);
        this.C = KeyUtils.t(this.D, getContext(), this.f6289e, getLifecycle(), false);
        m0();
        l();
        k0();
        return this.f6289e;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.live.evo.fragment.login.presenter.j jVar = this.f6299o;
        if (jVar != null) {
            jVar.r(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        j jVar = this.f6305u;
        if (jVar != null) {
            jVar.cancel();
            this.f6296l.setClickable(true);
            this.f6296l.setText(x1.j(2131952907));
        }
        k kVar = this.f6306v;
        if (kVar != null) {
            kVar.cancel();
            this.f6297m.setClickable(true);
            this.f6297m.setText(x1.j(2131952907));
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }
}
