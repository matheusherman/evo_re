package com.live.evo_mobile.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.view.OnBackPressedCallback;
import com.live.evo.R$color;
import com.live.evo.R$layout;
import com.live.evo_mobile.ui.MainViewActivity;
import com.stub.StubApp;
import com.tvc.lib.mobile.ui.base.BaseDataBindActivity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \\2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001]B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\f\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u000fJ!\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001d\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010 \u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\"\u0010\u0004J\u0019\u0010%\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010#H\u0014¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0013H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u0004J\r\u0010)\u001a\u00020\u0015¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020\u0005¢\u0006\u0004\b+\u0010\u0004J\r\u0010,\u001a\u00020\u0005¢\u0006\u0004\b,\u0010\u0004J\r\u0010-\u001a\u00020\u0005¢\u0006\u0004\b-\u0010\u0004J\u0017\u0010.\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b.\u0010!J\u0017\u0010/\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b/\u0010!J\u0015\u00102\u001a\u00020\u00052\u0006\u00101\u001a\u000200¢\u0006\u0004\b2\u00103J\u001d\u00106\u001a\u00020\u00052\u0006\u00104\u001a\u0002002\u0006\u00105\u001a\u000200¢\u0006\u0004\b6\u00107J\u0017\u00108\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b8\u0010!J\r\u00109\u001a\u00020\u0005¢\u0006\u0004\b9\u0010\u0004J\r\u0010:\u001a\u00020\u0005¢\u0006\u0004\b:\u0010\u0004J\u0017\u0010<\u001a\u00020\u00152\u0006\u0010;\u001a\u00020\u001bH\u0016¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u0005H\u0014¢\u0006\u0004\b>\u0010\u0004J\r\u0010?\u001a\u00020\u0005¢\u0006\u0004\b?\u0010\u0004J\u0017\u0010B\u001a\u00020\u00152\u0006\u0010A\u001a\u00020@H\u0016¢\u0006\u0004\bB\u0010CR\u0016\u0010F\u001a\u0004\u0018\u0001008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010H\u001a\u00020\u00138\u0002X\u0082D¢\u0006\u0006\n\u0004\bG\u0010\"R\u0014\u0010J\u001a\u00020\u00138\u0002X\u0082D¢\u0006\u0006\n\u0004\bI\u0010\"R\u0014\u0010L\u001a\u00020\u00138\u0002X\u0082D¢\u0006\u0006\n\u0004\bK\u0010\"R\u0014\u0010N\u001a\u00020\u00138\u0002X\u0082D¢\u0006\u0006\n\u0004\bM\u0010\"R\u0016\u0010P\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010\"R\u0016\u0010R\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010\"R\u001c\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00130\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u001b\u0010[\u001a\u00020V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z¨\u0006^"}, d2 = {"Lcom/live/evo_mobile/ui/login/LoginTypeActivity;", "Lcom/tvc/lib/mobile/ui/base/BaseDataBindActivity;", "Lz4/a;", "<init>", "()V", "Lr8/z;", "R", "", "Landroidx/fragment/app/Fragment;", "L", "()Ljava/util/List;", "fragments", ExifInterface.LATITUDE_SOUTH, "(Ljava/util/List;)V", "N", "()Landroidx/fragment/app/Fragment;", "M", "P", "K", "", "index", "", "skipRecord", "Z", "(IZ)V", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "U", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "view", "Q", "(Landroid/view/View;)V", "I", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "x", "()I", ExifInterface.GPS_DIRECTION_TRUE, "()Z", "c0", "b0", "d0", "toCodeLogin", "toCreateAccount", "", NotificationCompat.CATEGORY_EMAIL, "e0", "(Ljava/lang/String;)V", "phone", "preCode", "f0", "(Ljava/lang/String;Ljava/lang/String;)V", "toScanLogin", "Y", "X", "me", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "onStop", ExifInterface.LONGITUDE_WEST, "Landroid/view/KeyEvent;", "keyEvent", "dispatchKeyEvent", "(Landroid/view/KeyEvent;)Z", "k", "Ljava/lang/String;", "TAG", "l", "LOGIN_FROM_START", "m", "LOGIN_FROM_ACCOUNT", "n", "LOGIN_FROM_ME_ICON", "o", "LOGIN_FROM_PLAYER", "p", "loginFrom", "q", "currentPage", "r", "Ljava/util/List;", "stepRecord", "Lcom/live/evo_mobile/ui/login/t0;", "s", "Lr8/i;", "O", "()Lcom/live/evo_mobile/ui/login/t0;", "loginViewPagerAdapter", "t", "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoginTypeActivity extends BaseDataBindActivity<z4.a> {

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final int LOGIN_FROM_START;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private int currentPage;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final String TAG = kotlin.jvm.internal.c0.b(LoginTypeActivity.class).e();

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int LOGIN_FROM_ACCOUNT = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final int LOGIN_FROM_ME_ICON = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final int LOGIN_FROM_PLAYER = 3;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private int loginFrom = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private List<Integer> stepRecord = new ArrayList();

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    private final r8.i loginViewPagerAdapter = r8.j.a(new c9.a() { // from class: com.live.evo_mobile.ui.login.m0
        @Override // c9.a
        public final Object invoke() {
            return LoginTypeActivity.V(this.f8081a);
        }
    });

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/live/evo_mobile/ui/login/LoginTypeActivity$b", "Landroidx/activity/OnBackPressedCallback;", "Lr8/z;", "handleOnBackPressed", "()V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends OnBackPressedCallback {
        b() {
            super(true);
        }

        @Override // androidx.view.OnBackPressedCallback
        public void handleOnBackPressed() {
            LoginTypeActivity.this.X();
        }
    }

    public final void c0() {
        a0(this, 0, false, 2, null);
    }

    @Override // com.tvc.lib.mobile.ui.base.BaseDataBindActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle savedInstanceState);

    public final void toCreateAccount(View view) {
        a0(this, 2, false, 2, null);
    }

    static {
        StubApp.interface11(12965);
        INSTANCE = new Companion(null);
    }

    private final void I() {
        v7.c cVar = new v7.c(getString(2131952763), new c9.a() { // from class: com.live.evo_mobile.ui.login.l0
            @Override // c9.a
            public final Object invoke() {
                return LoginTypeActivity.J(this.f8079a);
            }
        });
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        kotlin.jvm.internal.m.e(supportFragmentManager, "getSupportFragmentManager(...)");
        cVar.X(supportFragmentManager);
    }

    private final Fragment K() {
        return u.INSTANCE.a();
    }

    private final List<Fragment> L() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(N());
        arrayList.add(M());
        arrayList.add(K());
        arrayList.add(P());
        return arrayList;
    }

    private final Fragment M() {
        return k0.INSTANCE.a(T());
    }

    private final Fragment N() {
        return s0.INSTANCE.a();
    }

    private final t0 O() {
        return (t0) this.loginViewPagerAdapter.getValue();
    }

    private final Fragment P() {
        return g1.INSTANCE.c();
    }

    private final void Q(View view) {
        InputMethodManager inputMethodManager;
        if (view == null || (inputMethodManager = (InputMethodManager) getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private final boolean U(View v10, MotionEvent event) {
        if (!(v10 instanceof EditText)) {
            return false;
        }
        int[] iArr = new int[2];
        EditText editText = (EditText) v10;
        editText.getLocationInWindow(iArr);
        int i10 = iArr[0];
        int i11 = iArr[1];
        return event.getX() <= ((float) i10) || event.getX() >= ((float) (editText.getWidth() + i10)) || event.getY() <= ((float) i11) || event.getY() >= ((float) (editText.getHeight() + i11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t0 V(LoginTypeActivity loginTypeActivity) {
        return new t0(loginTypeActivity);
    }

    private final void Z(int index, boolean skipRecord) {
        if (!skipRecord) {
            if (index == 0) {
                this.stepRecord.clear();
            }
            this.stepRecord.add(Integer.valueOf(index));
        }
        this.currentPage = index;
        t().f22672a.setCurrentItem(index, false);
    }

    static /* synthetic */ void a0(LoginTypeActivity loginTypeActivity, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        loginTypeActivity.Z(i10, z10);
    }

    public final boolean T() {
        return this.loginFrom == this.LOGIN_FROM_START;
    }

    public final void W() {
        if (this.loginFrom == this.LOGIN_FROM_START) {
            I();
        } else {
            finish();
        }
    }

    public final void X() {
        if (this.stepRecord.isEmpty() || this.stepRecord.size() == 1) {
            W();
            return;
        }
        List<Integer> list = this.stepRecord;
        list.remove(list.size() - 1);
        List<Integer> list2 = this.stepRecord;
        Z(list2.get(list2.size() - 1).intValue(), true);
    }

    public final void Y() {
        if (this.loginFrom == this.LOGIN_FROM_START) {
            startActivity(new Intent(this, (Class<?>) MainViewActivity.class));
        }
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        kotlin.jvm.internal.m.f(keyEvent, "keyEvent");
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0 || keyCode != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        X();
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me2) {
        kotlin.jvm.internal.m.f(me2, "me");
        if (me2.getAction() == 0) {
            View currentFocus = getCurrentFocus();
            if (U(currentFocus, me2)) {
                Q(currentFocus);
            }
        }
        return super.dispatchTouchEvent(me2);
    }

    public final void e0(String email) {
        kotlin.jvm.internal.m.f(email, "email");
        Fragment item = O().getItem(3);
        kotlin.jvm.internal.m.d(item, "null cannot be cast to non-null type com.live.evo_mobile.ui.login.ResetPasswordFragment");
        ((g1) item).X0(email);
        a0(this, 3, false, 2, null);
    }

    public final void f0(String phone, String preCode) {
        kotlin.jvm.internal.m.f(phone, "phone");
        kotlin.jvm.internal.m.f(preCode, "preCode");
        Fragment item = O().getItem(3);
        kotlin.jvm.internal.m.d(item, "null cannot be cast to non-null type com.live.evo_mobile.ui.login.ResetPasswordFragment");
        ((g1) item).Y0(phone, preCode);
        a0(this, 3, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z J(LoginTypeActivity loginTypeActivity) {
        xe.c.c().l(new nf.i());
        z7.j.f23105a.m();
        loginTypeActivity.finish();
        Process.killProcess(Process.myPid());
        return r8.z.f17874a;
    }

    private final void S(List<Fragment> fragments) {
        t().f22672a.clearOnPageChangeListeners();
        O().c(fragments);
        t().f22672a.setAdapter(O());
        t().f22672a.setOffscreenPageLimit(O().getCount());
        com.tvc.lib.mobile.ext.a.c(this, R$color.nav_bg_color, Boolean.FALSE);
    }

    public final void b0() {
        Fragment item = O().getItem(1);
        kotlin.jvm.internal.m.d(item, "null cannot be cast to non-null type com.live.evo_mobile.ui.login.LoginAccountFragment");
        ((k0) item).T0();
        a0(this, 1, false, 2, null);
    }

    public final void d0() {
        Fragment item = O().getItem(1);
        kotlin.jvm.internal.m.d(item, "null cannot be cast to non-null type com.live.evo_mobile.ui.login.LoginAccountFragment");
        ((k0) item).U0();
        a0(this, 1, false, 2, null);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    @Override // com.tvc.lib.mobile.ui.base.BaseDataBindActivity
    public void v() {
        S(L());
        R();
        String strI = t.v.c.i.a.f18646a.i();
        if (strI.length() > 0) {
            if (a.INSTANCE.a().g(strI)) {
                d0();
                return;
            } else {
                b0();
                return;
            }
        }
        c0();
    }

    @Override // com.tvc.lib.mobile.ui.base.BaseDataBindActivity
    public int x() {
        return R$layout.account_activity_login_type;
    }

    private final void R() {
    }

    public final void toCodeLogin(View view) {
    }

    public final void toScanLogin(View view) {
    }
}
