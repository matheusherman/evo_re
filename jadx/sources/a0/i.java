package a0;

import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class i extends a<i> {

    @Nullable
    private static i A;

    @Nullable
    private static i B;

    @NonNull
    @CheckResult
    public static i s0(@NonNull Class<?> cls) {
        return new i().e(cls);
    }

    @NonNull
    @CheckResult
    public static i t0(@NonNull l.j jVar) {
        return new i().g(jVar);
    }

    @NonNull
    @CheckResult
    public static i u0(@NonNull j.f fVar) {
        return new i().i0(fVar);
    }

    @NonNull
    @CheckResult
    public static i v0(boolean z10) {
        if (z10) {
            if (A == null) {
                A = new i().k0(true).c();
            }
            return A;
        }
        if (B == null) {
            B = new i().k0(false).c();
        }
        return B;
    }

    @Override // a0.a
    public boolean equals(Object obj) {
        return (obj instanceof i) && super.equals(obj);
    }

    @Override // a0.a
    public int hashCode() {
        return super.hashCode();
    }
}
