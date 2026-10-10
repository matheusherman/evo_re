package m1;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class l implements com.google.android.gms.common.api.a.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public static final l f15498b = a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final String f15499a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private String f15500a;

        @NonNull
        public l a() {
            return new l(this.f15500a, null);
        }

        @NonNull
        public a b(@Nullable String str) {
            this.f15500a = str;
            return this;
        }

        /* synthetic */ a(p pVar) {
        }
    }

    @NonNull
    public static a a() {
        return new a(null);
    }

    @NonNull
    public final Bundle b() {
        Bundle bundle = new Bundle();
        String str = this.f15499a;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            return f.a(this.f15499a, ((l) obj).f15499a);
        }
        return false;
    }

    public final int hashCode() {
        return f.b(this.f15499a);
    }

    /* synthetic */ l(String str, q qVar) {
        this.f15499a = str;
    }
}
