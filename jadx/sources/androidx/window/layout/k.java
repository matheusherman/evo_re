package androidx.window.layout;

import android.content.Context;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final /* synthetic */ class k {
    static {
        WindowInfoTracker.Companion companion = WindowInfoTracker.INSTANCE;
    }

    public static WindowInfoTracker a(Context context) {
        return WindowInfoTracker.INSTANCE.getOrCreate(context);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void b(WindowInfoTrackerDecorator windowInfoTrackerDecorator) {
        WindowInfoTracker.INSTANCE.overrideDecorator(windowInfoTrackerDecorator);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void c() {
        WindowInfoTracker.INSTANCE.reset();
    }
}
