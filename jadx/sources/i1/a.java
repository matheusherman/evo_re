package i1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11004a = 1;

    @NonNull
    public a a(@Nullable Object obj) {
        this.f11004a = (this.f11004a * 31) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    public int b() {
        return this.f11004a;
    }

    @NonNull
    public final a c(boolean z10) {
        this.f11004a = (this.f11004a * 31) + (z10 ? 1 : 0);
        return this;
    }
}
