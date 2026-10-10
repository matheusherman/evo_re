package com.live.evo_mobile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Switch;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts;
import com.live.evo.R$color;
import com.live.evo.R$layout;
import com.live.evo.R$mipmap;
import com.live.evo.R$string;
import com.live.evo_mobile.ui.favorite.FavoriteListActivity;
import com.live.evo_mobile.ui.login.LoginTypeActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import org.greenrobot.eventbus.ThreadMode;
import u7.MainSettingData;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 B2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0007¢\u0006\u0004\b\u0019\u0010\u0004J\u0017\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001b\u0010\rR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010$\u001a\n !*\u0004\u0018\u00010 0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082D¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001b\u00102\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001b\u00105\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010/\u001a\u0004\b4\u00101R\u001c\u0010:\u001a\b\u0012\u0004\u0012\u000207068\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b8\u00109R\u001c\u0010<\u001a\b\u0012\u0004\u0012\u000207068\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b;\u00109R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020>0=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006D"}, d2 = {"Lcom/live/evo_mobile/ui/k0;", "Lcom/tvc/lib/mobile/ui/base/d;", "Lz4/s0;", "<init>", "()V", "Landroid/widget/Switch;", "switch", "Lr8/z;", "r0", "(Landroid/widget/Switch;)V", "", "canUseCache", "p0", "(Z)V", "", ExifInterface.LONGITUDE_WEST, "()I", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "R", "onResume", "onPause", "Lnf/c;", NotificationCompat.CATEGORY_EVENT, "onEvent", "(Lnf/c;)V", "q0", "hidden", "onHiddenChanged", "Ljava/util/concurrent/atomic/AtomicBoolean;", "e", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInRecharge", "Lq6/b;", "kotlin.jvm.PlatformType", "f", "Lq6/b;", "logger", "", "g", "Ljava/lang/String;", "authCodeUrlKey", "Landroid/os/Handler;", "h", "Landroid/os/Handler;", "handler", "Lcom/live/evo_mobile/adapter/k;", "i", "Lr8/i;", "h0", "()Lcom/live/evo_mobile/adapter/k;", "mSettingListAdapter1", "j", "i0", "mSettingListAdapter2", "", "Lu7/g;", "k", "Ljava/util/List;", "mSttings1", "l", "mSttings2", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "m", "Landroidx/activity/result/ActivityResultLauncher;", "jumpForResult", "n", "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class k0 extends com.tvc.lib.mobile.ui.base.d<z4.s0> {

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean isInRecharge = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger = q6.c.d(k0.class);

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final String authCodeUrlKey = "authCode";

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Handler handler = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final r8.i mSettingListAdapter1 = r8.j.a(new c9.a() { // from class: com.live.evo_mobile.ui.h0
        @Override // c9.a
        public final Object invoke() {
            return k0.n0();
        }
    });

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final r8.i mSettingListAdapter2 = r8.j.a(new c9.a() { // from class: com.live.evo_mobile.ui.i0
        @Override // c9.a
        public final Object invoke() {
            return k0.o0();
        }
    });

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private List<MainSettingData> mSttings1;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private List<MainSettingData> mSttings2;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final ActivityResultLauncher<Intent> jumpForResult;

    /* JADX INFO: renamed from: com.live.evo_mobile.ui.k0$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/live/evo_mobile/ui/k0$a;", "", "<init>", "()V", "Lcom/live/evo_mobile/ui/k0;", "a", "()Lcom/live/evo_mobile/ui/k0;", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final k0 a() {
            return new k0();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/live/evo_mobile/ui/k0$b", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Lr8/z;", "onGlobalLayout", "()V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ViewGroup.LayoutParams layoutParams = k0.this.T().f22961b.getLayoutParams();
            int width = k0.this.T().f22961b.getWidth();
            layoutParams.width = width;
            layoutParams.height = (int) (((double) width) / 5.85d);
            k0.this.T().f22961b.setLayoutParams(layoutParams);
            if (k0.this.T().f22961b.getViewTreeObserver().isAlive()) {
                k0.this.T().f22961b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/live/evo_mobile/ui/k0$c", "Lcom/live/evo_mobile/adapter/k$a;", "", "checked", "Landroid/widget/Switch;", "switch", "Lr8/z;", "a", "(ZLandroid/widget/Switch;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c implements com.live.evo_mobile.adapter.k.a {
        c() {
        }

        @Override // com.live.evo_mobile.adapter.k.a
        public void a(boolean checked, Switch r10) {
            kotlin.jvm.internal.m.f(r10, "switch");
            if (checked) {
                if (t.v.c.i.a.f18646a.e0()) {
                    return;
                }
                k0.this.r0(r10);
            } else {
                t.v.c.i.a aVar = t.v.c.i.a.f18646a;
                if (aVar.e0()) {
                    aVar.I0();
                    u5.i.INSTANCE.b(false);
                    xe.c.c().o(new nf.d(true, "", "enter family"));
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/live/evo_mobile/ui/k0$d", "Lx1/f1/lb/util/m;", "", "value", "Lr8/z;", "d", "(I)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d implements x1.f1.lb.util.m<Integer> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Switch f7978b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ u5.i f7979c;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/live/evo_mobile/ui/k0$d$a", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class a implements x1.f1.lb.util.m<String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ k0 f7980a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Switch f7981b;

            a(k0 k0Var, Switch r10) {
                this.f7980a = k0Var;
                this.f7981b = r10;
            }

            @Override // x1.f1.lb.util.m
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(String v10) {
                kotlin.jvm.internal.m.f(v10, "v");
                t.v.c.i.a.f18646a.G0("");
                if (this.f7980a.getActivity() != null) {
                    this.f7980a.r0(this.f7981b);
                }
            }
        }

        public void d(int value) {
            if (value != 1) {
                if (value == 2) {
                    xe.c.c().o(new nf.d(true, "", "enter adult"));
                    return;
                } else {
                    if (value != 3) {
                        return;
                    }
                    this.f7978b.setChecked(false);
                    return;
                }
            }
            u5.c cVar = new u5.c();
            cVar.b0(new a(k0.this, this.f7978b));
            final k0 k0Var = k0.this;
            final u5.i iVar = this.f7979c;
            cVar.a0(new DialogInterface.OnCancelListener() { // from class: com.live.evo_mobile.ui.l0
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    k0.d.e(k0Var, iVar, dialogInterface);
                }
            });
            if (k0.this.getActivity() != null) {
                FragmentActivity activity = k0.this.getActivity();
                kotlin.jvm.internal.m.c(activity);
                cVar.show(activity.getSupportFragmentManager(), "reset_parental_ctrl_password");
            }
        }

        d(Switch r10, u5.i iVar) {
            this.f7978b = r10;
            this.f7979c = iVar;
        }

        @Override // x1.f1.lb.util.m
        public /* bridge */ /* synthetic */ void a(Integer num) {
            d(num.intValue());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(k0 k0Var, u5.i iVar, DialogInterface dialogInterface) {
            if (k0Var.getActivity() != null) {
                FragmentActivity activity = k0Var.getActivity();
                kotlin.jvm.internal.m.c(activity);
                iVar.show(activity.getSupportFragmentManager(), "set_lock_password");
            }
        }
    }

    private final com.live.evo_mobile.adapter.k h0() {
        return (com.live.evo_mobile.adapter.k) this.mSettingListAdapter1.getValue();
    }

    private final com.live.evo_mobile.adapter.k i0() {
        return (com.live.evo_mobile.adapter.k) this.mSettingListAdapter2.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(k0 k0Var, g0.d adapter, View view, int i10) {
        kotlin.jvm.internal.m.f(adapter, "adapter");
        kotlin.jvm.internal.m.f(view, "view");
        if (i10 == 0) {
            k0Var.startActivity(new Intent(k0Var.getActivity(), (Class<?>) ShareActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(k0 k0Var, g0.d adapter, View view, int i10) {
        kotlin.jvm.internal.m.f(adapter, "adapter");
        kotlin.jvm.internal.m.f(view, "view");
        if (((MainSettingData) adapter.getItem(i10)) == null) {
            return;
        }
        if (i10 == 1) {
            k0Var.startActivity(new Intent(k0Var.getActivity(), (Class<?>) SettingsActivity.class));
        } else {
            if (i10 != 2) {
                return;
            }
            k0Var.startActivity(new Intent(k0Var.getActivity(), (Class<?>) AboutUsActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z l0(k0 k0Var, View it) {
        kotlin.jvm.internal.m.f(it, "it");
        if (!kotlin.jvm.internal.m.a(it, k0Var.T().f22960a) && !kotlin.jvm.internal.m.a(it, k0Var.T().f22962c)) {
            if (kotlin.jvm.internal.m.a(it, k0Var.T().f22963d)) {
                if (t.v.c.i.a.f18646a.Z().length() == 0) {
                    Intent intent = new Intent(k0Var.getActivity(), (Class<?>) LoginTypeActivity.class);
                    intent.putExtra("loginFrom", 2);
                    k0Var.startActivity(intent);
                } else {
                    k0Var.startActivity(new Intent(k0Var.getActivity(), (Class<?>) AccountManageActivity.class));
                }
            } else if (kotlin.jvm.internal.m.a(it, k0Var.T().f22961b)) {
                if (t.v.c.i.a.f18646a.Z().length() == 0) {
                    Intent intent2 = new Intent(k0Var.getActivity(), (Class<?>) LoginTypeActivity.class);
                    intent2.putExtra("loginFrom", 2);
                    k0Var.startActivity(intent2);
                } else {
                    FragmentActivity activity = k0Var.getActivity();
                    kotlin.jvm.internal.m.d(activity, "null cannot be cast to non-null type com.live.evo_mobile.ui.MainViewActivity");
                    ((MainViewActivity) activity).c0();
                }
            } else if (kotlin.jvm.internal.m.a(it, k0Var.T().f22967h)) {
                k0Var.jumpForResult.launch(new Intent(k0Var.getActivity(), (Class<?>) FavoriteListActivity.class));
            } else if (kotlin.jvm.internal.m.a(it, k0Var.T().f22968i)) {
                k0Var.jumpForResult.launch(new Intent(k0Var.getActivity(), (Class<?>) HistoryListActivity.class));
            }
        }
        return r8.z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.live.evo_mobile.adapter.k n0() {
        return new com.live.evo_mobile.adapter.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.live.evo_mobile.adapter.k o0() {
        return new com.live.evo_mobile.adapter.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0(Switch r10) {
        u5.i iVar = new u5.i();
        iVar.k0(new d(r10, iVar));
        if (getActivity() != null) {
            iVar.show(requireActivity().getSupportFragmentManager(), "set_lock_password");
        }
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public void V() {
        this.mSttings1 = new ArrayList();
        String string = getString(2131952428);
        kotlin.jvm.internal.m.e(string, "getString(...)");
        List<MainSettingData> list = null;
        MainSettingData mainSettingData = new MainSettingData(R$mipmap.main_setting_icon4, string, null, Boolean.valueOf(t.v.c.i.a.f18646a.e0()));
        String string2 = getString(2131952743);
        kotlin.jvm.internal.m.e(string2, "getString(...)");
        MainSettingData mainSettingData2 = new MainSettingData(R$mipmap.main_setting_icon7, string2, null, null, 12, null);
        String string3 = getString(2131951948);
        kotlin.jvm.internal.m.e(string3, "getString(...)");
        this.mSttings2 = kotlin.collections.r.r(mainSettingData, mainSettingData2, new MainSettingData(R$mipmap.about_us_icon, string3, null, null, 12, null));
        List<MainSettingData> list2 = this.mSttings1;
        if (list2 == null) {
            kotlin.jvm.internal.m.v("mSttings1");
            list2 = null;
        }
        if (list2.isEmpty()) {
            T().f22965f.setVisibility(8);
        } else {
            T().f22965f.setVisibility(0);
            T().f22965f.setAdapter(h0());
        }
        T().f22966g.setAdapter(i0());
        ViewTreeObserver viewTreeObserver = T().f22961b.getViewTreeObserver();
        kotlin.jvm.internal.m.e(viewTreeObserver, "getViewTreeObserver(...)");
        viewTreeObserver.addOnGlobalLayoutListener(new b());
        com.live.evo_mobile.adapter.k kVarH0 = h0();
        List<MainSettingData> list3 = this.mSttings1;
        if (list3 == null) {
            kotlin.jvm.internal.m.v("mSttings1");
            list3 = null;
        }
        kVarH0.submitList(list3);
        com.live.evo_mobile.adapter.k kVarI0 = i0();
        List<MainSettingData> list4 = this.mSttings2;
        if (list4 == null) {
            kotlin.jvm.internal.m.v("mSttings2");
        } else {
            list = list4;
        }
        kVarI0.submitList(list);
        i0().R(new c());
        i0.c.b(h0(), 0L, new g0.d.InterfaceC0181d() { // from class: com.live.evo_mobile.ui.e0
            @Override // g0.d.InterfaceC0181d
            public final void b(g0.d dVar, View view, int i10) {
                k0.j0(this.f7926a, dVar, view, i10);
            }
        }, 1, null);
        i0.c.b(i0(), 0L, new g0.d.InterfaceC0181d() { // from class: com.live.evo_mobile.ui.f0
            @Override // g0.d.InterfaceC0181d
            public final void b(g0.d dVar, View view, int i10) {
                k0.k0(this.f7931a, dVar, view, i10);
            }
        }, 1, null);
        com.tvc.lib.mobile.ext.d.f(new View[]{T().f22960a, T().f22962c, T().f22963d, T().f22961b, T().f22967h, T().f22968i}, 0L, new c9.l() { // from class: com.live.evo_mobile.ui.g0
            @Override // c9.l
            public final Object invoke(Object obj) {
                return k0.l0(this.f7952a, (View) obj);
            }
        }, 2, null);
    }

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(nf.c event) {
        kotlin.jvm.internal.m.f(event, "event");
        xe.c.c().s(event);
        u5.i.INSTANCE.b(false);
        i0().notifyDataSetChanged();
        xe.c.c().o(new nf.d(true, "", "enter family"));
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    public final void q0() {
        String string;
        t.v.c.i.a aVar = t.v.c.i.a.f18646a;
        String strZ = aVar.Z();
        if (strZ.length() == 0 || aVar.H().length() == 0) {
            Context context = getContext();
            if (context != null) {
                string = context.getString(2131952082);
            } else {
                string = null;
            }
        } else {
            string = aVar.H();
            if (string.length() == 0) {
                Context context2 = getContext();
                if (context2 != null) {
                    string = context2.getString(2131952083);
                } else {
                    string = null;
                }
            }
        }
        Context context3 = getContext();
        T().f22971l.setText((context3 != null ? context3.getString(2131951654) : null) + " " + string);
        if (strZ.length() == 0) {
            T().f22970k.setVisibility(8);
            Context context4 = getContext();
            strZ = context4 != null ? context4.getString(2131952181) : null;
        } else {
            Context context5 = getContext();
            String string2 = context5 != null ? context5.getString(R$string.user_id) : null;
            String str = string2 + " " + of.a.f16585a.k();
            T().f22970k.setVisibility(0);
            T().f22970k.setText(str);
        }
        T().f22969j.setText(strZ);
    }

    public k0() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.live.evo_mobile.ui.j0
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                k0.m0(this.f7960a, (ActivityResult) obj);
            }
        });
        kotlin.jvm.internal.m.e(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.jumpForResult = activityResultLauncherRegisterForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(k0 k0Var, ActivityResult activityResult) {
        int resultCode = activityResult.getResultCode();
        String stringExtra = null;
        Boolean boolValueOf = null;
        if (resultCode != 2) {
            if (resultCode == 4 && activityResult.getData() != null) {
                Intent data = activityResult.getData();
                if (data != null) {
                    boolValueOf = Boolean.valueOf(data.getBooleanExtra("hasModify", false));
                }
                if (boolValueOf != null) {
                    k0Var.p0(!boolValueOf.booleanValue());
                    return;
                }
                return;
            }
            return;
        }
        if (activityResult.getData() != null) {
            Intent data2 = activityResult.getData();
            if (data2 != null) {
                stringExtra = data2.getStringExtra("channelId");
            }
            FragmentActivity activity = k0Var.getActivity();
            kotlin.jvm.internal.m.d(activity, "null cannot be cast to non-null type com.live.evo_mobile.ui.MainViewActivity");
            ((MainViewActivity) activity).T(stringExtra);
        }
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public int R() {
        return R$color.color_focused;
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public int W() {
        return R$layout.fragment_main_me;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            p0(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.tvc.lib.mobile.ext.f.d(this);
    }

    @Override // com.tvc.lib.mobile.ui.base.d, androidx.fragment.app.Fragment
    public void onResume() {
        q0();
        super.onResume();
        if (!t.v.c.i.a.f18646a.e0()) {
            i0().notifyDataSetChanged();
        }
        com.tvc.lib.mobile.ext.f.c(this);
    }

    private final void p0(boolean canUseCache) {
    }
}
