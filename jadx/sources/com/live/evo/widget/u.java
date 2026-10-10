package com.live.evo.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.live.evo.R$drawable;
import com.live.evo.R$layout;
import com.live.evo.R$style;
import com.live.evo.util.x1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class u extends PopupWindow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LayoutInflater f7746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f7747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f7748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f7749d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f7750e;

    @SuppressLint({"RestrictedApi"})
    private void b() {
        View viewInflate = this.f7746a.inflate(R$layout.popup_trial, (ViewGroup) null);
        this.f7747b = viewInflate;
        setContentView(viewInflate);
        setFocusable(false);
        setBackgroundDrawable(x1.f(R$drawable.icon_transport));
        setOutsideTouchable(true);
        setHeight(com.live.evo.util.n.a(150));
        setWidth(com.live.evo.util.n.a(150));
        setAnimationStyle(R$style.AnimationFade);
    }

    public u(Context context) {
        super(context);
        this.f7749d = 1.0f;
        this.f7750e = 500L;
        this.f7748c = context;
        this.f7746a = LayoutInflater.from(context);
        b();
        a();
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View view, int i10, int i11, int i12) {
        super.showAtLocation(view, i10, i11, i12);
    }

    @SuppressLint({"RestrictedApi"})
    private void a() {
    }
}
