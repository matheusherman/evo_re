package x1.f1.lb.util;

import android.app.Activity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.hjq.toast.Toaster;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lx1/f1/lb/util/g1;", "", "<init>", "()V", "", TypedValues.Custom.S_STRING, "Lr8/z;", "e", "(Ljava/lang/String;)V", "c", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g1 f21390a = new g1();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String str) {
        if (c.f21341a.o()) {
            Toaster.showLong((CharSequence) str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(String str) {
        if (c.f21341a.o()) {
            Toaster.showShort((CharSequence) str);
        }
    }

    public final void c(final String string) {
        kotlin.jvm.internal.m.f(string, "string");
        Activity activityJ = c.f21341a.j();
        if (activityJ != null) {
            activityJ.runOnUiThread(new Runnable() { // from class: x1.f1.lb.util.e1
                @Override // java.lang.Runnable
                public final void run() {
                    g1.d(string);
                }
            });
        }
    }

    public final void e(final String string) {
        kotlin.jvm.internal.m.f(string, "string");
        Activity activityJ = c.f21341a.j();
        if (activityJ != null) {
            activityJ.runOnUiThread(new Runnable() { // from class: x1.f1.lb.util.f1
                @Override // java.lang.Runnable
                public final void run() {
                    g1.f(string);
                }
            });
        }
    }

    private g1() {
    }
}
