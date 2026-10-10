package com.live.evo.fragment.login;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.live.evo.R$color;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.util.b1;
import com.live.evo.util.x1;
import i5.a0;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class r extends Fragment implements View.OnClickListener, com.live.evo.fragment.login.presenter.n {
    private static String A = "RenewCodeLoginSupportFragment";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static r f6343z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f6345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.live.evo.fragment.login.presenter.m f6346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private t5.a f6347d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private FragmentManager f6348e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private c f6349f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f6350g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextView f6351h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private View f6352i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private TextView f6353j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextView f6354k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f6355l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private TextView f6356m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private TextView f6357n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private TextView f6358o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private TextView f6359p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private TextView f6360q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private CheckBox f6361r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private View f6362s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private View f6363t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private EditText f6364u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private View f6365v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private View f6366w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private TextView f6367x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q6.b f6344a = q6.c.d(r.class);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private com.live.evo.osd.a f6368y = new b();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                r.this.f6354k.setVisibility(4);
            } else {
                r.this.f6354k.setVisibility(0);
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
    class b implements com.live.evo.osd.a {
        b() {
        }

        @Override // com.live.evo.osd.p
        public void a() {
            r.this.f6344a.debug("exit", new Object[0]);
        }

        @Override // com.live.evo.osd.p
        public void b() {
            r.this.f6344a.debug("rechargeLater", new Object[0]);
        }

        @Override // com.live.evo.osd.a
        public void c() {
            r.this.f6344a.debug("loginSuccess", new Object[0]);
            if (r.this.f6349f != null) {
                r.this.f6349f.c(r.this);
            }
        }

        @Override // com.live.evo.osd.p
        public void e() {
            r.this.f6344a.debug("rechargeSuccess", new Object[0]);
            if (r.this.f6349f != null) {
                r.this.f6349f.c(r.this);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface c {
        void a(Fragment fragment);

        void b(Fragment fragment);

        void c(Fragment fragment);
    }

    private void V() {
        c cVar = this.f6349f;
        if (cVar != null) {
            cVar.b(this);
        }
    }

    private void W() {
        if (this.f6346c == null) {
            this.f6344a.error("RenewCodeLoginSupportPresenter is null", new Object[0]);
            return;
        }
        String string = this.f6364u.getText().toString();
        if (TextUtils.isEmpty(string)) {
            c0("", x1.j(R$string.recharge_key_empty));
        } else {
            this.f6346c.n(getContext(), getArguments().getString("arg_renew_code"), string);
        }
    }

    private void X() {
        this.f6352i.setOnClickListener(this);
        this.f6353j.setOnClickListener(this);
        this.f6359p.setOnClickListener(this);
        this.f6360q.setOnClickListener(this);
        this.f6365v.setOnClickListener(this);
        this.f6366w.setOnClickListener(this);
        this.f6361r.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.live.evo.fragment.login.q
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                b1.e("user_properties", "code_bind_remind_status", String.valueOf(z10 ? 1 : 0));
            }
        });
        this.f6354k.addTextChangedListener(new a());
    }

    private void Y() {
        t5.a aVar = new t5.a(getContext());
        this.f6347d = aVar;
        aVar.f(com.live.evo.widget.sloading.c.TRANSLATE_CIRCLE);
        this.f6347d.g(R$color.sloading_color);
        this.f6350g = this.f6345b.findViewById(R$id.code_first_login_success_parent);
        this.f6351h = (TextView) this.f6345b.findViewById(R$id.recharge_id);
        this.f6356m = (TextView) this.f6345b.findViewById(R$id.tv_first_login_success_remind);
        this.f6352i = this.f6345b.findViewById(R$id.btn_bind);
        this.f6353j = (TextView) this.f6345b.findViewById(R$id.tv_watch_now);
        this.f6354k = (TextView) this.f6345b.findViewById(R$id.tv_error);
        this.f6353j.setPaintFlags(8);
        this.f6353j.getPaint().setAntiAlias(true);
        com.live.evo.util.t.b(this.f6356m);
        this.f6357n = (TextView) this.f6345b.findViewById(R$id.code_bind_title);
        this.f6358o = (TextView) this.f6345b.findViewById(R$id.code_bind_remind);
        this.f6360q = (TextView) this.f6345b.findViewById(R$id.code_bind_later);
        this.f6359p = (TextView) this.f6345b.findViewById(R$id.code_bind_now);
        this.f6361r = (CheckBox) this.f6345b.findViewById(R$id.code_bind_checkbox);
        this.f6362s = this.f6345b.findViewById(R$id.code_bind_parent);
        this.f6363t = this.f6345b.findViewById(R$id.code_confirm_parent);
        this.f6367x = (TextView) this.f6345b.findViewById(R$id.code_confirm_title);
        this.f6364u = (EditText) this.f6345b.findViewById(R$id.code_confirm_et);
        this.f6365v = this.f6345b.findViewById(R$id.code_confirm_ok);
        this.f6366w = this.f6345b.findViewById(R$id.code_confirm_close);
    }

    public static r Z(int i10, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("arg_remind_type", i10);
        bundle.putString("arg_renew_code", str);
        r rVar = new r();
        f6343z = rVar;
        rVar.setArguments(bundle);
        return f6343z;
    }

    public static synchronized void b0(FragmentManager fragmentManager, int i10, String str, int i11, c cVar) {
        try {
            r rVarZ = Z(i11, str);
            rVarZ.f6349f = cVar;
            Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag(A);
            FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
            if (fragmentFindFragmentByTag == null) {
                fragmentTransactionBeginTransaction.add(i10, rVarZ, A).commitAllowingStateLoss();
            } else {
                fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag).commitAllowingStateLoss();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void l() {
        this.f6354k.setVisibility(4);
        if (TextUtils.isEmpty(this.f6355l)) {
            return;
        }
        this.f6354k.setVisibility(0);
        this.f6354k.setText(this.f6355l);
        this.f6355l = "";
    }

    @Override // com.live.evo.fragment.login.presenter.n
    public void b() {
        this.f6347d.h();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        com.live.evo.fragment.login.presenter.m mVar = this.f6346c;
        if (mVar != null) {
            mVar.u();
        }
        super.onPause();
    }

    private void a0() {
        boolean z10 = false;
        switch (getArguments().getInt("arg_remind_type")) {
            case 40:
                b1.e("user_properties", "code_bind_remind_status", String.valueOf(0));
                break;
            case 41:
                this.f6350g.setVisibility(8);
                this.f6362s.setVisibility(8);
                this.f6363t.setVisibility(0);
                this.f6365v.requestFocus();
                this.f6367x.setText(Html.fromHtml(x1.j(R$string.fill_out_key)));
                return;
            case 42:
                break;
            default:
                return;
        }
        this.f6350g.setVisibility(8);
        this.f6362s.setVisibility(0);
        this.f6363t.setVisibility(8);
        this.f6359p.requestFocus();
        this.f6358o.setText(Html.fromHtml(x1.j(R$string.code_bind_remind)));
        List<a0> listD = b1.d("user_properties", "code_bind_remind_status");
        CheckBox checkBox = this.f6361r;
        if (!listD.isEmpty() && listD.get(0).b().equals(String.valueOf(1))) {
            z10 = true;
        }
        checkBox.setChecked(z10);
        this.f6361r.setText(Html.fromHtml(x1.j(R$string.code_bind_tip)));
        this.f6357n.setText(Html.fromHtml(x1.j(R$string.code_bind_title)));
    }

    private void c0(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && str2.contains(":")) {
            String[] strArrSplit = str2.split(":");
            if (strArrSplit.length > 1) {
                str2 = strArrSplit[1] + "(" + strArrSplit[0] + ")";
            }
        }
        this.f6354k.setText(String.format("%s%s", str, str2));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R$id.btn_bind /* 2131427604 */:
            case R$id.code_bind_now /* 2131427736 */:
                V();
                break;
            case R$id.code_bind_later /* 2131427735 */:
            case R$id.tv_watch_now /* 2131429779 */:
                c cVar = this.f6349f;
                if (cVar != null) {
                    cVar.c(this);
                }
                break;
            case R$id.code_confirm_close /* 2131427740 */:
                c cVar2 = this.f6349f;
                if (cVar2 != null) {
                    cVar2.a(this);
                }
                break;
            case R$id.code_confirm_ok /* 2131427742 */:
                W();
                break;
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f6345b = layoutInflater.inflate(R$layout.code_login_support_fragment, viewGroup, false);
        this.f6348e = getFragmentManager();
        this.f6346c = new com.live.evo.fragment.login.presenter.o();
        Y();
        l();
        X();
        return this.f6345b;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        f6343z = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.live.evo.fragment.login.presenter.m mVar = this.f6346c;
        if (mVar != null) {
            mVar.r(this);
        }
        a0();
    }
}
