package k1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.a.d;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class b<O extends com.google.android.gms.common.api.a.d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f11977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.gms.common.api.a f11978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final com.google.android.gms.common.api.a.d f11979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final String f11980d;

    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return m1.f.a(this.f11978b, bVar.f11978b) && m1.f.a(this.f11979c, bVar.f11979c) && m1.f.a(this.f11980d, bVar.f11980d);
    }

    @NonNull
    public static <O extends com.google.android.gms.common.api.a.d> b<O> a(@NonNull com.google.android.gms.common.api.a<O> aVar, @Nullable O o10, @Nullable String str) {
        return new b<>(aVar, o10, str);
    }

    @NonNull
    public final String b() {
        return this.f11978b.b();
    }

    public final int hashCode() {
        return this.f11977a;
    }

    private b(com.google.android.gms.common.api.a aVar, @Nullable com.google.android.gms.common.api.a.d dVar, @Nullable String str) {
        this.f11978b = aVar;
        this.f11979c = dVar;
        this.f11980d = str;
        this.f11977a = m1.f.b(aVar, dVar, str);
    }
}
