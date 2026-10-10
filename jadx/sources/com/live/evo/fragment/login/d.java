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

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d extends Fragment implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6147a = getClass().getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f6148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f6149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f6150d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f6151e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f6152f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextView f6153g;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface a {
        void a();

        void next();
    }

    private void R() {
        this.f6150d.setOnClickListener(this);
        this.f6151e.setOnClickListener(this);
    }

    private void S() {
        this.f6150d = (TextView) this.f6149c.findViewById(R$id.adultwarningf_btn_exit);
        this.f6151e = (TextView) this.f6149c.findViewById(R$id.adultwarningf_btn_enter);
        this.f6152f = (TextView) this.f6149c.findViewById(R$id.adultwarningf_tv_remind1);
        this.f6153g = (TextView) this.f6149c.findViewById(R$id.adultwarningf_tv_remind2);
        com.live.evo.util.t.d(this.f6150d);
        com.live.evo.util.t.d(this.f6151e);
        com.live.evo.util.t.c(this.f6152f);
        com.live.evo.util.t.b(this.f6153g);
        this.f6151e.requestFocus();
    }

    public static d T() {
        return new d();
    }

    public static void U(FragmentManager fragmentManager, int i10, a aVar) {
        d dVarT = T();
        dVarT.f6148b = aVar;
        fragmentManager.beginTransaction().add(i10, dVarT, dVarT.f6147a).commitAllowingStateLoss();
    }

    private void l() {
        String strI = com.live.evo.l.n().i("attention_remind_one", x1.j(R$string.attention_remind_1));
        String strI2 = com.live.evo.l.n().i("attention_remind_one", x1.j(R$string.attention_remind_2));
        this.f6152f.setText(Html.fromHtml(strI));
        this.f6153g.setText(Html.fromHtml(strI2));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R$id.adultwarningf_btn_enter /* 2131427491 */:
                if (this.f6148b != null) {
                    getFragmentManager().beginTransaction().hide(this).commitAllowingStateLoss();
                    this.f6148b.next();
                }
                break;
            case R$id.adultwarningf_btn_exit /* 2131427492 */:
                if (this.f6148b != null) {
                    getFragmentManager().beginTransaction().hide(this).commitAllowingStateLoss();
                    this.f6148b.a();
                }
                break;
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f6149c = layoutInflater.inflate(R$layout.adult_warning_fragment, viewGroup, false);
        S();
        l();
        R();
        return this.f6149c;
    }
}
