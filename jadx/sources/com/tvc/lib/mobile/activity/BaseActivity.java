package com.tvc.lib.mobile.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;
import nf.j;
import nf.k;
import q6.b;
import q6.c;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\n\u0010\u0003R\"\u0010\u0011\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/tvc/lib/mobile/activity/BaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lr8/z;", "onCreate", "(Landroid/os/Bundle;)V", "onStop", "onResume", "Lq6/b;", "kotlin.jvm.PlatformType", "a", "Lq6/b;", "k", "()Lq6/b;", "logger", "Landroid/os/Handler;", "b", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "handler", "", "c", "Z", "leftWithFocus", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final b logger = c.d(getClass());

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Handler handler = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean leftWithFocus;

    /* JADX INFO: renamed from: k, reason: from getter */
    protected final b getLogger() {
        return this.logger;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.leftWithFocus) {
            this.logger.a("activity on resume[" + hashCode() + "@" + getClass() + "], leftWithFocus[" + this.leftWithFocus + "]", new Object[0]);
            xe.c.c().l(new j());
            this.leftWithFocus = false;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        boolean zHasWindowFocus = hasWindowFocus();
        this.logger.a("activity on stop[" + hashCode() + "@" + getClass() + "], hasFocus[" + zHasWindowFocus + "]", new Object[0]);
        if (zHasWindowFocus) {
            xe.c.c().l(new k());
            this.leftWithFocus = true;
        }
    }
}
