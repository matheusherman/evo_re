package m1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private static h f15487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final RootTelemetryConfiguration f15488c = new RootTelemetryConfiguration(0, false, false, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private RootTelemetryConfiguration f15489a;

    @VisibleForTesting
    public final synchronized void c(@Nullable RootTelemetryConfiguration rootTelemetryConfiguration) {
        try {
            if (rootTelemetryConfiguration == null) {
                this.f15489a = f15488c;
                return;
            }
            RootTelemetryConfiguration rootTelemetryConfiguration2 = this.f15489a;
            if (rootTelemetryConfiguration2 == null || rootTelemetryConfiguration2.getVersion() < rootTelemetryConfiguration.getVersion()) {
                this.f15489a = rootTelemetryConfiguration;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @NonNull
    public static synchronized h b() {
        try {
            if (f15487b == null) {
                f15487b = new h();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f15487b;
    }

    @Nullable
    public RootTelemetryConfiguration a() {
        return this.f15489a;
    }

    private h() {
    }
}
