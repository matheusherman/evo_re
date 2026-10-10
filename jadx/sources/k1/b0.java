package k1;

import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f11981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Feature f11982b;

    public final boolean equals(@Nullable Object obj) {
        if (obj != null && (obj instanceof b0)) {
            b0 b0Var = (b0) obj;
            if (m1.f.a(this.f11981a, b0Var.f11981a) && m1.f.a(this.f11982b, b0Var.f11982b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return m1.f.b(this.f11981a, this.f11982b);
    }

    /* synthetic */ b0(b bVar, Feature feature, a0 a0Var) {
        this.f11981a = bVar;
        this.f11982b = feature;
    }

    public final String toString() {
        return m1.f.c(this).a("key", this.f11981a).a("feature", this.f11982b).toString();
    }
}
