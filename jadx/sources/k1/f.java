package k1;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f12026a;

    @NonNull
    public final Activity a() {
        return (Activity) this.f12026a;
    }

    @NonNull
    public final FragmentActivity b() {
        return (FragmentActivity) this.f12026a;
    }

    public final boolean c() {
        return this.f12026a instanceof Activity;
    }

    public final boolean d() {
        return this.f12026a instanceof FragmentActivity;
    }

    public f(@NonNull Activity activity) {
        m1.g.l(activity, "Activity must not be null");
        this.f12026a = activity;
    }
}
