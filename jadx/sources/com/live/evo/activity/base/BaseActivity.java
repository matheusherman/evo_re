package com.live.evo.activity.base;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.IdRes;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.stub.StubApp;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import me.jessyan.autosize.AutoSizeCompat;
import nf.j;
import nf.k;
import q6.b;
import q6.c;
import x1.f1.lb.util.e0;
import x1.f1.lb.util.j0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 B2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001#B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0017¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0005J\u0017\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0014\u0010\u0005J\u000f\u0010\u0015\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0015\u0010\u0005J\u000f\u0010\u0016\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0016\u0010\u0005J\u000f\u0010\u0017\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0017\u0010\u0005J/\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00062\u000e\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u00192\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\fH\u0016¢\u0006\u0004\b \u0010\u0005J\u000f\u0010!\u001a\u00020\fH\u0016¢\u0006\u0004\b!\u0010\u0005J\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'R\u001c\u0010+\u001a\n )*\u0004\u0018\u00010(0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010*R\"\u00101\u001a\u00020\"8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010$\"\u0004\b/\u00100R\"\u00109\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006C"}, d2 = {"Lcom/live/evo/activity/base/BaseActivity;", "Lcom/live/evo/activity/base/MonitorableActivity;", "", "Lx1/f1/lb/util/j0$a;", "<init>", "()V", "", "n", "()Ljava/lang/Integer;", "o", "Landroid/os/Bundle;", "savedInstanceState", "Lr8/z;", "onCreate", "(Landroid/os/Bundle;)V", "onContentChanged", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onStop", "onPause", "onResume", "onDestroy", "requestCode", "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "q", "p", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "a", "()Lcom/google/firebase/analytics/FirebaseAnalytics;", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "Lq6/b;", "kotlin.jvm.PlatformType", "Lq6/b;", "logger", "b", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "m", "r", "(Lcom/google/firebase/analytics/FirebaseAnalytics;)V", "firebaseAnalytics", "", "c", "Z", "getLeftWithFocus", "()Z", "setLeftWithFocus", "(Z)V", "leftWithFocus", "Landroid/view/View;", "d", "Landroid/view/View;", "loadingView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "loadingTextView", "f", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseActivity extends MonitorableActivity implements j0.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f5410g = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final b logger = c.d(BaseActivity.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public FirebaseAnalytics firebaseAnalytics;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean leftWithFocus;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View loadingView;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView loadingTextView;

    @IdRes
    public Integer n() {
        return null;
    }

    @IdRes
    public Integer o() {
        return null;
    }

    public final FirebaseAnalytics m() {
        FirebaseAnalytics firebaseAnalytics = this.firebaseAnalytics;
        if (firebaseAnalytics != null) {
            return firebaseAnalytics;
        }
        m.v("firebaseAnalytics");
        return null;
    }

    @Override // com.live.evo.activity.base.MonitorableActivity, androidx.appcompat.app.AppCompatActivity, androidx.view.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        String str;
        m.f(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if (x1.f1.lb.config.b.f20643a.t()) {
            b bVar = this.logger;
            int i10 = newConfig.orientation;
            if (i10 != 1) {
                str = i10 != 2 ? "unknown" : "landscape";
            } else {
                str = "portrait";
            }
            bVar.debug("onConfigurationChanged orientation[" + str + "], densityDpi[" + newConfig.densityDpi, new Object[0]);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        StubApp.interface22(requestCode, permissions, grantResults);
        m.f(permissions, "permissions");
        m.f(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if ((grantResults.length == 0) || grantResults[0] != 0) {
            if (requestCode == f5410g) {
                p();
            }
        } else if (requestCode == f5410g) {
            q();
        }
    }

    public void p() {
        this.logger.warn("user denied external storage permission", new Object[0]);
    }

    public void q() {
        this.logger.a("user granted external storage permission", new Object[0]);
    }

    public final void r(FirebaseAnalytics firebaseAnalytics) {
        m.f(firebaseAnalytics, "<set-?>");
        this.firebaseAnalytics = firebaseAnalytics;
    }

    @Override // x1.f1.lb.util.j0.a
    public FirebaseAnalytics a() {
        return m();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = super.getResources();
        if (m.a(Looper.myLooper(), Looper.getMainLooper())) {
            AutoSizeCompat.autoConvertDensityOfGlobal(resources);
        }
        m.c(resources);
        return resources;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        super.onContentChanged();
        Integer numN = n();
        if (numN != null) {
            this.loadingView = findViewById(numN.intValue());
        }
        Integer numO = o();
        if (numO != null) {
            this.loadingTextView = (TextView) findViewById(numO.intValue());
        }
    }

    @Override // com.live.evo.activity.base.MonitorableActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        r(FirebaseAnalytics.getInstance(this));
    }

    @Override // com.live.evo.activity.base.MonitorableActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // com.live.evo.activity.base.MonitorableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        if (hasWindowFocus()) {
            xe.c.c().l(new k());
            this.leftWithFocus = true;
        }
        e0.f21385a.b(this);
    }

    @Override // com.live.evo.activity.base.MonitorableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        e0.f21385a.a(this);
        if (this.leftWithFocus) {
            this.logger.a("activity on resume[" + hashCode() + "@" + getClass() + "], leftWithFocus[" + this.leftWithFocus + "]", new Object[0]);
            xe.c.c().l(new j());
            this.leftWithFocus = false;
        }
    }

    @Override // com.live.evo.activity.base.MonitorableActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
    }
}
