package com.live.evo.fragment.login;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.widget.BaseButton;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class e extends com.live.evo.fragment.c implements View.OnClickListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f6154f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ImageView f6155g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ImageView f6156h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private BaseButton f6157i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private TextView f6158j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextView f6159k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private TextView f6160l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private TextView f6161m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private TextView f6162n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private i f6163o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f6164p = 50;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Bitmap f6165q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Bitmap f6166r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Bitmap f6167s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f6168t = true;

    private void a0() {
        try {
            if (this.f6167s != null) {
                com.bumptech.glide.c.t(getContext()).s(this.f6167s).b0(R$drawable.qr_placehodler).E0(this.f6155g);
            }
        } catch (Exception unused) {
        }
    }

    private void c0() {
        this.f6157i.setOnClickListener(this);
    }

    private void d0() {
        this.f6155g = (ImageView) this.f6154f.findViewById(R$id.bff_user_qrcode);
        this.f6156h = (ImageView) this.f6154f.findViewById(R$id.bff_user_logo);
        this.f6157i = (BaseButton) this.f6154f.findViewById(R$id.bff_fragment_back);
        this.f6158j = (TextView) this.f6154f.findViewById(R$id.bff_userinfo_title);
        this.f6159k = (TextView) this.f6154f.findViewById(R$id.bff_userinfo_contact);
        this.f6160l = (TextView) this.f6154f.findViewById(R$id.bff_userinfo_rate);
        this.f6161m = (TextView) this.f6154f.findViewById(R$id.bff_userinfo_report);
        this.f6162n = (TextView) this.f6154f.findViewById(R$id.bff_userinfo_remind);
        com.live.evo.util.t.c(this.f6158j);
        com.live.evo.util.t.b(this.f6159k);
        com.live.evo.util.t.b(this.f6160l);
        com.live.evo.util.t.b(this.f6161m);
        com.live.evo.util.t.b(this.f6162n);
        com.live.evo.util.t.b(this.f6157i);
    }

    public static e e0() {
        return new e();
    }

    public static synchronized void h0(FragmentManager fragmentManager, int i10, int i11, i iVar) {
        e eVarE0 = e0();
        eVarE0.f6163o = iVar;
        eVarE0.f6164p = i11;
        fragmentManager.beginTransaction().add(i10, eVarE0, "BffInfoFragment").commitAllowingStateLoss();
    }

    public void g0() {
        if (this.f6155g == null) {
            return;
        }
        this.f6168t = true;
        if (this.f6164p == 51) {
            a0();
        } else {
            b0();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i iVar;
        if (view.getId() == 2131427562 && (iVar = this.f6163o) != null) {
            iVar.a(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f6154f = layoutInflater.inflate(R$layout.bffinfo_fragment, viewGroup, false);
        d0();
        c0();
        f0();
        return this.f6154f;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.live.evo.fragment.c, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        g0();
    }

    private void b0() {
    }

    private void f0() {
    }
}
