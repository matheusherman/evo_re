package com.live.evo.activity.base;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import b5.f;
import g5.a;
import kotlin.Metadata;
import org.greenrobot.eventbus.ThreadMode;
import x1.f1.lb.util.e0;
import xe.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\u0004J\r\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\u0004J\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0015\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/live/evo/activity/base/BasicActivity;", "Lcom/live/evo/activity/base/LoginBaseActivity;", "Lg5/a;", "<init>", "()V", "Lr8/z;", "init", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "v", "x", "Lb5/f;", NotificationCompat.CATEGORY_EVENT, "onMessageEvent", "(Lb5/f;)V", "s", "", "u", "()Z", "onDestroy", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BasicActivity extends LoginBaseActivity implements a {
    public boolean u() {
        return false;
    }

    @m(threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(f event) {
        kotlin.jvm.internal.m.f(event, "event");
        s(event);
    }

    public void s(f event) {
        kotlin.jvm.internal.m.f(event, "event");
    }

    public final void v() {
        e0.f21385a.a(this);
    }

    public final void x() {
        e0.f21385a.b(this);
    }

    private final void init() {
        setContentView(g());
        if (u()) {
            v();
        }
        f();
        w();
        t();
    }

    @Override // com.live.evo.activity.base.BaseActivity, com.live.evo.activity.base.MonitorableActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    @Override // com.live.evo.activity.base.BaseActivity, com.live.evo.activity.base.MonitorableActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        x();
        super.onDestroy();
    }

    public void t() {
        a.C0184a.a(this);
    }

    public void w() {
        a.C0184a.b(this);
    }
}
