package t1;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.stub.StubApp;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final e f18865b = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private d f18866a = null;

    @NonNull
    @VisibleForTesting
    public final synchronized d b(@NonNull Context context) {
        try {
            if (this.f18866a == null) {
                if (StubApp.getOrigApplicationContext(context.getApplicationContext()) != null) {
                    context = StubApp.getOrigApplicationContext(context.getApplicationContext());
                }
                this.f18866a = new d(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f18866a;
    }

    @NonNull
    public static d a(@NonNull Context context) {
        return f18865b.b(context);
    }
}
