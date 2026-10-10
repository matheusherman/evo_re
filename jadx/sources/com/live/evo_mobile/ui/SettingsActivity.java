package com.live.evo_mobile.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.live.evo.R$color;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.stub.StubApp;
import com.tvc.lib.mobile.ui.base.BaseDataBindActivity;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0018\u0010\u0004R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0006R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010$\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/live/evo_mobile/ui/SettingsActivity;", "Lcom/tvc/lib/mobile/ui/base/BaseDataBindActivity;", "Lz4/m;", "<init>", "()V", "Lr8/z;", "Z", "Y", "", "bgAlpha", "Q", "(F)V", "Landroid/view/View;", "R", "()Landroid/view/View;", "", "x", "()I", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "v", "onResume", "onPause", "", "k", "isApkDownloading", "", "l", "J", "lastClickTime", "m", "delayMillis", "n", "I", "currentLanguagePosition", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SettingsActivity extends BaseDataBindActivity<z4.m> {

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isApkDownloading;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private long lastClickTime;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long delayMillis = 2000;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int currentLanguagePosition;

    static {
        StubApp.interface11(12868);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z U(SettingsActivity settingsActivity, Integer num, nf.a0 a0Var) {
        if (a0Var != null) {
            settingsActivity.t().f22854f.setVisibility(8);
            settingsActivity.t().f22852d.setVisibility(0);
            settingsActivity.t().f22856h.setVisibility(0);
            v7.c cVar = new v7.c(a0Var.b().getVersionName() + "\n" + a0Var.a(), new c9.a() { // from class: com.live.evo_mobile.ui.g2
                @Override // c9.a
                public final Object invoke() {
                    return SettingsActivity.V();
                }
            });
            String string = settingsActivity.getString(2131953114);
            kotlin.jvm.internal.m.e(string, "getString(...)");
            cVar.setTitle(string);
            FragmentManager supportFragmentManager = settingsActivity.getSupportFragmentManager();
            kotlin.jvm.internal.m.e(supportFragmentManager, "getSupportFragmentManager(...)");
            cVar.X(supportFragmentManager);
        } else if (num != null) {
            int iIntValue = num.intValue();
            if (settingsActivity.t().f22854f.getVisibility() != 0) {
                settingsActivity.t().f22854f.setVisibility(0);
                settingsActivity.t().f22852d.setVisibility(4);
                settingsActivity.t().f22856h.setVisibility(4);
            }
            settingsActivity.t().f22854f.setText(settingsActivity.getLatestNewVersion() + ": " + iIntValue + "%");
        }
        return r8.z.f17874a;
    }

    @Override // com.tvc.lib.mobile.ui.base.BaseDataBindActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle savedInstanceState);

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(final SettingsActivity settingsActivity, View view) {
        if (settingsActivity.isApkDownloading) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - settingsActivity.lastClickTime <= settingsActivity.delayMillis) {
            return;
        }
        settingsActivity.lastClickTime = jCurrentTimeMillis;
        settingsActivity.l(new c9.p() { // from class: com.live.evo_mobile.ui.f2
            @Override // c9.p
            public final Object invoke(Object obj, Object obj2) {
                return SettingsActivity.U(this.f7933a, (Integer) obj, (nf.a0) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z V() {
        return r8.z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(SettingsActivity settingsActivity, View view) {
        settingsActivity.startActivity(new Intent(settingsActivity, (Class<?>) AboutUsActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(final SettingsActivity settingsActivity, final PopupWindow popupWindow, AdapterView adapterView, View view, final int i10, long j10) {
        if (i10 == settingsActivity.currentLanguagePosition) {
            popupWindow.dismiss();
            return;
        }
        String string = settingsActivity.getString(2131952746);
        kotlin.jvm.internal.m.e(string, "getString(...)");
        v7.c cVar = new v7.c(string, new c9.a() { // from class: com.live.evo_mobile.ui.h2
            @Override // c9.a
            public final Object invoke() {
                return SettingsActivity.b0(this.f7955a, i10, popupWindow);
            }
        });
        FragmentManager supportFragmentManager = settingsActivity.getSupportFragmentManager();
        kotlin.jvm.internal.m.e(supportFragmentManager, "getSupportFragmentManager(...)");
        cVar.X(supportFragmentManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z b0(SettingsActivity settingsActivity, int i10, PopupWindow popupWindow) {
        settingsActivity.currentLanguagePosition = i10;
        x1.f1.lb.util.n0 n0Var = x1.f1.lb.util.n0.f21425a;
        if (i10 >= n0Var.e().size()) {
            settingsActivity.currentLanguagePosition = 0;
        }
        String str = n0Var.e().get(settingsActivity.currentLanguagePosition);
        settingsActivity.t().f22857i.setText(n0Var.e().get(settingsActivity.currentLanguagePosition));
        Context origApplicationContext = StubApp.getOrigApplicationContext(settingsActivity.getApplicationContext());
        kotlin.jvm.internal.m.e(origApplicationContext, "getApplicationContext(...)");
        n0Var.q(str, origApplicationContext, settingsActivity.currentLanguagePosition);
        popupWindow.dismiss();
        settingsActivity.Y();
        return r8.z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(SettingsActivity settingsActivity) {
        settingsActivity.Q(1.0f);
    }

    private final void Q(float bgAlpha) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = bgAlpha;
        getWindow().setAttributes(attributes);
    }

    private final View R() {
        View viewInflate = LayoutInflater.from(this).inflate(R$layout.setting_picker, (ViewGroup) null);
        kotlin.jvm.internal.m.e(viewInflate, "inflate(...)");
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(SettingsActivity settingsActivity, View view) {
        settingsActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(SettingsActivity settingsActivity, View view) {
        settingsActivity.Z();
    }

    private final void Y() {
        finish();
        xe.c.c().o(new nf.b());
    }

    private final void Z() {
        View viewR = R();
        final PopupWindow popupWindow = new PopupWindow(viewR, -1, -2);
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        Q(0.5f);
        popupWindow.showAtLocation(t().getRoot(), 80, 0, 0);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.live.evo_mobile.ui.c2
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                SettingsActivity.c0(this.f7885a);
            }
        });
        View viewFindViewById = viewR.findViewById(R$id.iv_guide_date_pick_cancel);
        ((TextView) viewR.findViewById(R$id.picker_title)).setText(getString(2131952747));
        ListView listView = (ListView) viewR.findViewById(R$id.lv_date_pick);
        List<String> listE = x1.f1.lb.util.n0.f21425a.e();
        kotlin.jvm.internal.m.c(listView);
        com.live.evo_mobile.adapter.l lVar = new com.live.evo_mobile.adapter.l(this, R$layout.setting_date_pick_item, listE, listView);
        if (this.currentLanguagePosition < 0) {
            this.currentLanguagePosition = 0;
        }
        listView.setItemChecked(this.currentLanguagePosition, true);
        lVar.a(this.currentLanguagePosition);
        listView.setAdapter((ListAdapter) lVar);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.d2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsActivity.d0(popupWindow, view);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.live.evo_mobile.ui.e2
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                SettingsActivity.a0(this.f7928a, popupWindow, adapterView, view, i10, j10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(PopupWindow popupWindow, View view) {
        popupWindow.dismiss();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // com.tvc.lib.mobile.ui.base.BaseDataBindActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.tvc.lib.mobile.ui.base.BaseDataBindActivity
    public void v() {
        com.tvc.lib.mobile.ext.a.c(this, R$color.status_bar_bg_color, Boolean.FALSE);
        t().f22859k.f22835a.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.y1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsActivity.S(this.f8216a, view);
            }
        });
        t().f22859k.f22836b.setText(getString(2131952743));
        t().f22856h.setText(y());
        t().f22861m.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.z1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsActivity.T(this.f8218a, view);
            }
        });
        t().f22860l.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.a2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsActivity.W(this.f7875a, view);
            }
        });
        x1.f1.lb.util.n0 n0Var = x1.f1.lb.util.n0.f21425a;
        Context origApplicationContext = StubApp.getOrigApplicationContext(getApplicationContext());
        kotlin.jvm.internal.m.e(origApplicationContext, "getApplicationContext(...)");
        int iC = n0Var.c(origApplicationContext, -1);
        if (iC != -1 && iC < n0Var.e().size()) {
            t().f22857i.setText(n0Var.e().get(iC));
            this.currentLanguagePosition = iC;
        } else {
            t().f22857i.setText(n0Var.e().get(0));
            this.currentLanguagePosition = 0;
        }
        t().f22862n.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.b2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsActivity.X(this.f7879a, view);
            }
        });
    }

    @Override // com.tvc.lib.mobile.ui.base.BaseDataBindActivity
    public int x() {
        return R$layout.activity_settings;
    }
}
