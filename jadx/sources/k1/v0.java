package k1;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayMap f12080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayMap f12081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e2.h f12082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f12083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f12084e;

    public final Set a() {
        return this.f12080a.keySet();
    }

    public final void b(b bVar, ConnectionResult connectionResult, @Nullable String str) {
        this.f12080a.put(bVar, connectionResult);
        this.f12081b.put(bVar, str);
        this.f12083d--;
        if (!connectionResult.V()) {
            this.f12084e = true;
        }
        if (this.f12083d == 0) {
            if (!this.f12084e) {
                this.f12082c.c(this.f12081b);
            } else {
                this.f12082c.b(new com.google.android.gms.common.api.c(this.f12080a));
            }
        }
    }
}
