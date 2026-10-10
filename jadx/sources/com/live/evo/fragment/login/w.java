package com.live.evo.fragment.login;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.util.x1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class w extends Fragment implements View.OnClickListener {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f6444g = "WelcomeFragment";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private i f6445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f6446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f6447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f6448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f6449e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ImageView f6450f;

    private void R() {
        this.f6447c.setOnClickListener(this);
    }

    private void S() {
        this.f6447c = (TextView) this.f6446b.findViewById(R$id.welcomef_tv_start_play);
        this.f6448d = (TextView) this.f6446b.findViewById(R$id.welcomef_tv_remind);
        this.f6449e = (TextView) this.f6446b.findViewById(R$id.welcomef_tv_welcome);
        ImageView imageView = (ImageView) this.f6446b.findViewById(R$id.welcomef_iv_icon);
        this.f6450f = imageView;
        imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), com.live.evo.a.f5198r, null));
        this.f6447c.requestFocus();
        com.live.evo.util.t.b(this.f6448d);
        com.live.evo.util.t.b(this.f6449e);
        com.live.evo.util.t.d(this.f6447c);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
        alphaAnimation.setRepeatMode(2);
        alphaAnimation.setRepeatCount(-1);
        alphaAnimation.setDuration(1500L);
        this.f6447c.setAnimation(alphaAnimation);
        alphaAnimation.start();
    }

    public static w T() {
        return new w();
    }

    public static synchronized void U(FragmentManager fragmentManager, int i10, i iVar) {
        w wVarT = T();
        wVarT.f6445a = iVar;
        fragmentManager.beginTransaction().add(i10, wVarT, f6444g).commitAllowingStateLoss();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i iVar = this.f6445a;
        if (iVar != null) {
            iVar.a(this);
        }
    }

    private void l() {
        this.f6448d.setText(Html.fromHtml(requireActivity().getString(R$string.welcome_remind, Integer.valueOf(t.v.c.i.a.f18646a.T()))));
        this.f6449e.setText(Html.fromHtml(x1.j(R$string.welcome_to_tvexpress).replace("${AppName}", x1.j(2131951743))));
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f6446b = layoutInflater.inflate(R$layout.welcome_fragment, viewGroup, false);
        S();
        l();
        R();
        return this.f6446b;
    }
}
