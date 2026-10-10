package com.live.evo.fragment;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class z extends c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f6929f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextView f6930g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextView f6931h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextView f6932i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private TextView f6933j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextView f6934k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private TextView f6935l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private TextView f6936m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private LinearLayout f6937n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private LinearLayout f6938o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private LinearLayout f6939p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ImageView f6940q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ImageView f6941r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private ImageView f6942s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private TextView f6943t;

    private void a0() {
        this.f6930g = (TextView) this.f6929f.findViewById(R$id.tv_title);
        this.f6936m = (TextView) this.f6929f.findViewById(R$id.tv_contact_email);
        this.f6935l = (TextView) this.f6929f.findViewById(R$id.tv_contact_official);
        this.f6934k = (TextView) this.f6929f.findViewById(R$id.tv_contact_team);
        this.f6931h = (TextView) this.f6929f.findViewById(R$id.tv_contact_email_title);
        this.f6933j = (TextView) this.f6929f.findViewById(R$id.tv_contact_official_title);
        this.f6932i = (TextView) this.f6929f.findViewById(R$id.tv_contact_team_title);
        this.f6943t = (TextView) this.f6929f.findViewById(R$id.tv_contact_remind);
        this.f6940q = (ImageView) this.f6929f.findViewById(R$id.email_icon);
        this.f6941r = (ImageView) this.f6929f.findViewById(R$id.group_icon);
        this.f6942s = (ImageView) this.f6929f.findViewById(R$id.web_icon);
        LinearLayout linearLayout = (LinearLayout) this.f6929f.findViewById(R$id.email_parent);
        this.f6937n = linearLayout;
        linearLayout.setVisibility(8);
        LinearLayout linearLayout2 = (LinearLayout) this.f6929f.findViewById(R$id.group_parent);
        this.f6938o = linearLayout2;
        linearLayout2.setVisibility(8);
        LinearLayout linearLayout3 = (LinearLayout) this.f6929f.findViewById(R$id.official_parent);
        this.f6939p = linearLayout3;
        linearLayout3.setVisibility(8);
        if (com.live.evo.util.e.b().a()) {
            com.live.evo.util.t.c(this.f6930g);
            com.live.evo.util.t.b(this.f6943t);
        } else {
            com.live.evo.util.t.d(this.f6930g);
            com.live.evo.util.t.d(this.f6943t);
        }
    }

    public void b0(List<i5.q> list) {
        TextView textView;
        TextView textView2;
        LinearLayout linearLayout;
        ImageView imageView;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = 3 > list.size() ? list.size() : 3;
        int i10 = -1;
        for (int i11 = 0; i11 < size; i11++) {
            if (i11 == 0) {
                textView = this.f6931h;
                textView2 = this.f6936m;
                linearLayout = this.f6937n;
                imageView = this.f6940q;
            } else if (i11 == 1) {
                textView = this.f6932i;
                textView2 = this.f6934k;
                linearLayout = this.f6938o;
                imageView = this.f6941r;
            } else {
                textView = this.f6933j;
                textView2 = this.f6935l;
                linearLayout = this.f6939p;
                imageView = this.f6942s;
            }
            if (NotificationCompat.CATEGORY_EMAIL.equals(list.get(i11).d())) {
                i10 = R$drawable.feedback_email;
            } else if ("whatsapp".equals(list.get(i11).d())) {
                i10 = R$drawable.feedback_group;
            } else if ("website".equals(list.get(i11).d())) {
                i10 = R$drawable.feedback_web;
            } else if ("phone".equals(list.get(i11).d())) {
                i10 = R$drawable.feedback_phone;
            } else if ("facebook".equals(list.get(i11).d())) {
                i10 = R$drawable.feedback_facebook;
            } else if ("twitter".equals(list.get(i11).d())) {
                i10 = R$drawable.feedback_twitter;
            }
            textView.setText(list.get(i11).a());
            textView2.setText(list.get(i11).b());
            com.live.evo.util.v.c(getActivity(), list.get(i11).c(), i10, imageView);
            linearLayout.setVisibility(0);
        }
    }

    private void l() {
        this.f6943t.setText(Html.fromHtml(com.live.evo.util.x1.j(R$string.feedback_remind_bottom)));
        this.f6930g.setText(Html.fromHtml(com.live.evo.util.x1.j(R$string.contact_title2)));
        b0(com.live.evo.util.q.d().b());
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f6929f = layoutInflater.inflate(R$layout.contact_fragment, viewGroup, false);
        a0();
        l();
        return this.f6929f;
    }
}
