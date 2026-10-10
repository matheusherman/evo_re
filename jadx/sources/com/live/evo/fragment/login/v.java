package com.live.evo.fragment.login;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.util.x1;
import com.live.evo.widget.BaseButton;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import org.apache.log4j.spi.LocationInfo;
import x1.f1.lb.util.t0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class v extends com.live.evo.fragment.c implements View.OnClickListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f6437f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ImageView f6438g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private BaseButton f6439h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextView f6440i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private TextView f6441j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextView f6442k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private i f6443l;

    private void a0() {
        try {
            this.f6440i.setText("test");
            t0.f21446a.d(b0("https://share-code-h5-tvebr.tomatoto.xyz", "test"), 200, this.f6438g, null);
        } catch (Exception unused) {
        }
    }

    private String b0(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        if (!str.endsWith(LocationInfo.NA)) {
            str = str + LocationInfo.NA;
        }
        String language = Locale.getDefault().getLanguage();
        if (!"pt".equals(language) && !"en".equals(language) && !"es".equals(language)) {
            language = "pt";
        }
        try {
            str3 = "sh=" + str2 + "&a=" + URLEncoder.encode(t.v.c.i.a.f18646a.Y(), "utf-8") + "&r=" + URLEncoder.encode("evo", "utf-8");
        } catch (UnsupportedEncodingException unused) {
            str3 = "sh=" + str2 + "&a=" + t.v.c.i.a.f18646a.Y() + "&r=evo";
        }
        return str + (str3 + "&la=" + language + "&ls=stb");
    }

    private void c0() {
        this.f6439h.setOnClickListener(this);
    }

    private void d0() {
        this.f6440i = (TextView) this.f6437f.findViewById(R$id.sharecode_tv);
        this.f6441j = (TextView) this.f6437f.findViewById(R$id.sharecode_title);
        this.f6442k = (TextView) this.f6437f.findViewById(R$id.sharecode_remind_tve);
        this.f6438g = (ImageView) this.f6437f.findViewById(R$id.sharecode_qrcode);
        this.f6439h = (BaseButton) this.f6437f.findViewById(R$id.sharecode_fragment_back);
        com.live.evo.util.t.a(this.f6440i);
        com.live.evo.util.t.a(this.f6441j);
        com.live.evo.util.t.c(this.f6442k);
        com.live.evo.util.t.b(this.f6439h);
    }

    public static v e0() {
        return new v();
    }

    private void f0() {
        try {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 24) {
                this.f6441j.setText(Html.fromHtml(x1.j(R$string.share_code_tip_title), 0));
            } else {
                this.f6441j.setText(Html.fromHtml(x1.j(R$string.share_code_tip_title)));
            }
            String strJ = x1.j(R$string.share_code_remind);
            if (i10 >= 24) {
                this.f6442k.setText(Html.fromHtml(strJ, 0));
            } else {
                this.f6442k.setText(Html.fromHtml(strJ));
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized void i0(FragmentManager fragmentManager, int i10, i iVar) {
        v vVarE0 = e0();
        vVarE0.f6443l = iVar;
        fragmentManager.beginTransaction().add(i10, vVarE0, "ShareCodeInfoFragment").commitAllowingStateLoss();
    }

    public void h0() {
        if (this.f6438g == null) {
            return;
        }
        try {
            a0();
            f0();
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i iVar;
        if (view.getId() == 2131429355 && (iVar = this.f6443l) != null) {
            iVar.a(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f6437f = layoutInflater.inflate(R$layout.sharecode_info_fragment, viewGroup, false);
        d0();
        c0();
        g0();
        return this.f6437f;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.live.evo.fragment.c, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        h0();
    }

    private void g0() {
    }
}
