package k1;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class i<L> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f12033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f12034b;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f12033a == iVar.f12033a && this.f12034b.equals(iVar.f12034b);
    }

    public int hashCode() {
        return (System.identityHashCode(this.f12033a) * 31) + this.f12034b.hashCode();
    }
}
