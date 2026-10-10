package com.live.evo.widget;

import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.leanback.widget.BaseGridView;
import androidx.leanback.widget.VerticalGridView;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.R$style;
import com.live.evo.util.x1;
import i5.y;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class s extends PopupWindow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LayoutInflater f7705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private VerticalGridView f7706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f7707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f7708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f7709e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f7710f;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements BaseGridView.OnKeyInterceptListener {
        a() {
        }

        @Override // androidx.leanback.widget.BaseGridView.OnKeyInterceptListener
        public boolean onInterceptKeyEvent(KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() == 82 && keyEvent.getAction() == 0) {
                s.this.dismiss();
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            s.this.f7707c.sendBroadcast(new Intent("com.bb.action.EPG"));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (x1.m(1000L)) {
                return;
            }
            s.this.f7707c.sendBroadcast(new Intent("com.bb.action.update"));
        }
    }

    private void b() {
        this.f7706b.setOnKeyInterceptListener(new a());
        c(0, true, false);
    }

    private void c(int i10, boolean z10, boolean z11) {
        this.f7706b.removeAllViews();
        this.f7710f = i10;
        ArrayList arrayList = new ArrayList();
        if (!z11) {
            y yVar = new y();
            yVar.e(R$drawable.epg_icon);
            yVar.f("E P G");
            yVar.d(new b());
            arrayList.add(yVar);
        }
        y yVar2 = new y();
        yVar2.e(R$drawable.update_icon);
        yVar2.f(this.f7707c.getString(R$string.version) + "" + x1.f1.lb.util.k.f21398a.t());
        yVar2.d(new c());
        arrayList.add(yVar2);
        this.f7706b.setAdapter(new p(this.f7707c, arrayList, false));
    }

    private void d() {
        View viewInflate = this.f7705a.inflate(R$layout.popup_menu_c, (ViewGroup) null);
        setContentView(viewInflate);
        setFocusable(true);
        setBackgroundDrawable(this.f7707c.getResources().getDrawable(R$drawable.bg_popup_menu));
        setOutsideTouchable(false);
        setHeight(-1);
        setWidth(com.live.evo.util.n.a(270));
        setClippingEnabled(false);
        setAnimationStyle(R$style.AnimationFade);
        this.f7706b = (VerticalGridView) viewInflate.findViewById(R$id.menu_view);
    }

    public s(Context context) {
        super(context);
        this.f7708d = 1.0f;
        this.f7709e = 200L;
        this.f7710f = 0;
        this.f7707c = context;
        this.f7705a = LayoutInflater.from(context);
        d();
        b();
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
    }

    public void e(int i10, boolean z10, boolean z11) {
        c(i10, z10, z11);
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View view, int i10, int i11, int i12) {
        super.showAtLocation(view, i10, i11, i12);
    }
}
