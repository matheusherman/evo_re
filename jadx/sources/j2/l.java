package j2;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.q;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f11563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f11564c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f11565d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f11566e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f11567f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f11568g;

    @Nullable
    public static l a(@NonNull Context context) {
        m1.i iVar = new m1.i(context);
        String strA = iVar.a("google_app_id");
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        return new l(strA, iVar.a("google_api_key"), iVar.a("firebase_database_url"), iVar.a("ga_trackingId"), iVar.a("gcm_defaultSenderId"), iVar.a("google_storage_bucket"), iVar.a("project_id"));
    }

    @NonNull
    public String b() {
        return this.f11562a;
    }

    @NonNull
    public String c() {
        return this.f11563b;
    }

    @Nullable
    public String d() {
        return this.f11566e;
    }

    @Nullable
    public String e() {
        return this.f11568g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return m1.f.a(this.f11563b, lVar.f11563b) && m1.f.a(this.f11562a, lVar.f11562a) && m1.f.a(this.f11564c, lVar.f11564c) && m1.f.a(this.f11565d, lVar.f11565d) && m1.f.a(this.f11566e, lVar.f11566e) && m1.f.a(this.f11567f, lVar.f11567f) && m1.f.a(this.f11568g, lVar.f11568g);
    }

    public int hashCode() {
        return m1.f.b(this.f11563b, this.f11562a, this.f11564c, this.f11565d, this.f11566e, this.f11567f, this.f11568g);
    }

    private l(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        m1.g.p(!q.a(str), "ApplicationId must be set.");
        this.f11563b = str;
        this.f11562a = str2;
        this.f11564c = str3;
        this.f11565d = str4;
        this.f11566e = str5;
        this.f11567f = str6;
        this.f11568g = str7;
    }

    public String toString() {
        return m1.f.c(this).a("applicationId", this.f11563b).a("apiKey", this.f11562a).a("databaseUrl", this.f11564c).a("gcmSenderId", this.f11566e).a("storageBucket", this.f11567f).a("projectId", this.f11568g).toString();
    }
}
