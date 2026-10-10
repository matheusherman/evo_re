package com.live.evo_mobile.ui;

import android.os.Build;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.live.evo.R$color;
import com.live.evo.R$layout;
import com.tvc.lib.mobile.ui.base.BaseDataBindActivity;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0012\u0010\u0004¨\u0006\u0013"}, d2 = {"Lcom/live/evo_mobile/ui/AboutUsActivity;", "Lcom/tvc/lib/mobile/ui/base/BaseDataBindActivity;", "Lz4/d;", "<init>", "()V", "Landroid/widget/TextView;", "textView", "", "htmlText", "Lr8/z;", "I", "(Landroid/widget/TextView;Ljava/lang/String;)V", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "J", "(Ljava/lang/String;)Ljava/lang/String;", "", "x", "()I", "v", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AboutUsActivity extends BaseDataBindActivity<z4.d> {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/live/evo_mobile/ui/AboutUsActivity$a", "Lf3/a;", "", "", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends f3.a<Map<String, ? extends String>> {
        a() {
        }
    }

    private final void I(TextView textView, String htmlText) {
        if (Build.VERSION.SDK_INT >= 24) {
            textView.setText(Html.fromHtml(htmlText, 0));
        } else {
            textView.setText(Html.fromHtml(htmlText));
        }
        textView.setVisibility(0);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private final String J(String url) {
        return ua.n.C(ua.n.C(url, "http://", "", true), "https://", "", true);
    }

    @Override // com.tvc.lib.mobile.ui.base.BaseDataBindActivity
    public void v() {
        String str;
        String str2;
        com.tvc.lib.mobile.ext.a.c(this, R$color.status_bar_bg_color, Boolean.FALSE);
        t().f22729a.f22835a.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AboutUsActivity.H(this.f7872a, view);
            }
        });
        t().f22729a.f22836b.setText(getString(2131951948));
        TextView textView = t().f22743o;
        kotlin.jvm.internal.g0 g0Var = kotlin.jvm.internal.g0.f12340a;
        String string = getString(2131951934);
        kotlin.jvm.internal.m.e(string, "getString(...)");
        String str3 = "";
        String str4 = String.format(string, Arrays.copyOf(new Object[]{""}, 1));
        kotlin.jvm.internal.m.e(str4, "format(...)");
        textView.setText(str4);
        t.v.c.i.a aVar = t.v.c.i.a.f18646a;
        String strN = aVar.N();
        String strV = aVar.v();
        String strW = aVar.w();
        String strX = aVar.x();
        StringBuilder sb2 = new StringBuilder();
        if (x1.f1.lb.config.b.f20643a.f() && !TextUtils.isEmpty(strN)) {
            sb2.append("Site: <a href=\"");
            sb2.append(strN);
            sb2.append("\">");
            sb2.append(J(strN));
            sb2.append("</a>");
        }
        if (!TextUtils.isEmpty(strV)) {
            if (sb2.length() > 0) {
                sb2.append("<br/>");
            }
            sb2.append("Email: ");
            sb2.append("<a href=\"mailto:" + strV + "\">" + strV + "</a>");
        }
        if (!TextUtils.isEmpty(strW)) {
            if (sb2.length() > 0) {
                sb2.append("<br/>");
            }
            String str5 = "<a href=\"" + strW + "\">" + J(strW) + "</a>";
            sb2.append("Facebook: ");
            sb2.append(str5);
        }
        if (TextUtils.isEmpty(strX)) {
            str = "</a>";
            str2 = "\">";
        } else {
            if (sb2.length() > 0) {
                sb2.append("<br/>");
            }
            str = "</a>";
            str2 = "\">";
            String str6 = "<a href=\"https://wa.me/" + ua.n.E(ua.n.E(strX, "+", "", false, 4, null), " ", "", false, 4, null) + str2 + strX + str;
            sb2.append("WhatsApp: ");
            sb2.append(str6);
        }
        String strY = aVar.y();
        if (!TextUtils.isEmpty(strY)) {
            try {
                if (ua.n.I(ua.n.Q0(strY).toString(), "{", false, 2, null)) {
                    Object objO = new com.google.gson.e().o(strY, new a().d());
                    kotlin.jvm.internal.m.e(objO, "fromJson(...)");
                    Map map = (Map) objO;
                    String str7 = (String) map.get(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL);
                    if (str7 != null) {
                        ua.n.Q0(str7).toString();
                    }
                    String str8 = (String) map.get("qr");
                    strY = str8 == null ? "" : str8;
                    String str9 = (String) map.get("tip");
                    if (str9 != null) {
                        str3 = str9;
                    }
                }
            } catch (Throwable th) {
                getLogger().error("parse qrcode json failure", th);
            }
            String str10 = str3;
            t().f22735g.setVisibility(8);
            if (strY.length() != 0) {
                if (sb2.length() > 0) {
                    sb2.append("<br/><br/>");
                }
                String string2 = str10.length() == 0 ? getString(2131951943) : ua.n.Q0(ua.n.E(str10, "QR", "", false, 4, null)).toString();
                kotlin.jvm.internal.m.c(string2);
                sb2.append(string2);
                sb2.append(": <a href=\"");
                sb2.append(strY);
                sb2.append(str2);
                sb2.append(getString(2131951893));
                sb2.append(str);
            }
        }
        if (sb2.length() > 0) {
            String string3 = sb2.toString();
            kotlin.jvm.internal.m.e(string3, "toString(...)");
            TextView info1 = t().f22733e;
            kotlin.jvm.internal.m.e(info1, "info1");
            I(info1, string3);
        } else {
            t().f22733e.setVisibility(8);
        }
        String string4 = getString(2131952216);
        kotlin.jvm.internal.m.e(string4, "getString(...)");
        if (string4.length() > 0) {
            TextView info2 = t().f22734f;
            kotlin.jvm.internal.m.e(info2, "info2");
            I(info2, string4);
        } else {
            t().f22734f.setVisibility(8);
        }
        t().f22739k.setText("ID: " + of.a.f16585a.k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(AboutUsActivity aboutUsActivity, View view) {
        aboutUsActivity.finish();
    }

    @Override // com.tvc.lib.mobile.ui.base.BaseDataBindActivity
    public int x() {
        return R$layout.activity_about_us;
    }
}
