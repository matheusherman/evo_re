package com.tvc.lib.mobile.activity;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import nf.j;
import nf.k;
import org.greenrobot.eventbus.ThreadMode;
import t7.a;
import u7.MessageEventData;
import xe.c;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\u0004J\r\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\u0004J\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0017\u0010\u0004R\u0016\u0010\u001a\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/tvc/lib/mobile/activity/BasicActivity;", "Lcom/tvc/lib/mobile/activity/BaseActivity;", "Lt7/a;", "<init>", "()V", "Lr8/z;", "init", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "o", "q", "Lu7/h;", NotificationCompat.CATEGORY_EVENT, "onMessageEvent", "(Lu7/h;)V", "l", "", "n", "()Z", "onStop", "onResume", "onDestroy", "d", "Z", "leftWithFocus", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BasicActivity extends BaseActivity implements a {

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean leftWithFocus;

    public boolean n() {
        return false;
    }

    public void l(MessageEventData event) {
        m.f(event, "event");
    }

    @xe.m(threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(MessageEventData event) {
        m.f(event, "event");
        l(event);
    }

    private final void init() {
        setContentView(g());
        if (n()) {
            o();
        }
        f();
        p();
        m();
    }

    public void m() {
        a.C0366a.a(this);
    }

    public final void o() {
        if (!c.c().j(this)) {
            c.c().q(this);
        }
    }

    @Override // com.tvc.lib.mobile.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        q();
        super.onDestroy();
    }

    @Override // com.tvc.lib.mobile.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.leftWithFocus) {
            getLogger().a("activity on resume[" + hashCode() + "@" + getClass() + "], leftWithFocus[" + this.leftWithFocus + "]", new Object[0]);
            c.c().l(new j());
            this.leftWithFocus = false;
        }
    }

    @Override // com.tvc.lib.mobile.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        boolean zHasWindowFocus = hasWindowFocus();
        getLogger().a("activity on stop[" + hashCode() + "@" + getClass() + "], hasFocus[" + zHasWindowFocus + "]", new Object[0]);
        if (zHasWindowFocus) {
            c.c().l(new k());
            this.leftWithFocus = true;
        }
    }

    public void p() {
        a.C0366a.b(this);
    }

    public final void q() {
        if (c.c().j(this)) {
            c.c().u(this);
        }
    }
}
