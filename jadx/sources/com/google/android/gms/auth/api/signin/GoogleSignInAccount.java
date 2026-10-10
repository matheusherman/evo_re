package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.util.d;
import com.google.android.gms.common.util.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@Deprecated
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new a();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    @VisibleForTesting
    public static final d f2075n = g.d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f2076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final String f2077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final String f2078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final String f2079d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final String f2080e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private final Uri f2081f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private String f2082g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f2083h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f2084i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final List f2085j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private final String f2086k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private final String f2087l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Set f2088m = new HashSet();

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.f2084i.equals(this.f2084i) && googleSignInAccount.k0().equals(k0());
    }

    @NonNull
    public static GoogleSignInAccount m0(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Uri uri, @Nullable Long l10, @NonNull String str7, @NonNull Set set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, l10.longValue(), m1.g.e(str7), new ArrayList((Collection) m1.g.k(set)), str5, str6);
    }

    @Nullable
    public String J() {
        return this.f2080e;
    }

    @Nullable
    public String M() {
        return this.f2079d;
    }

    @Nullable
    public String P() {
        return this.f2087l;
    }

    @Nullable
    public String S() {
        return this.f2086k;
    }

    @Nullable
    public String V() {
        return this.f2077b;
    }

    public int hashCode() {
        return ((this.f2084i.hashCode() + 527) * 31) + k0().hashCode();
    }

    @Nullable
    public String i0() {
        return this.f2078c;
    }

    @Nullable
    public Uri j0() {
        return this.f2081f;
    }

    @NonNull
    public Set<Scope> k0() {
        HashSet hashSet = new HashSet(this.f2085j);
        hashSet.addAll(this.f2088m);
        return hashSet;
    }

    @Nullable
    public String l0() {
        return this.f2082g;
    }

    @Nullable
    public Account w() {
        String str = this.f2079d;
        if (str == null) {
            return null;
        }
        return new Account(str, "com.google");
    }

    GoogleSignInAccount(int i10, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Uri uri, @Nullable String str5, long j10, String str6, List list, @Nullable String str7, @Nullable String str8) {
        this.f2076a = i10;
        this.f2077b = str;
        this.f2078c = str2;
        this.f2079d = str3;
        this.f2080e = str4;
        this.f2081f = uri;
        this.f2082g = str5;
        this.f2083h = j10;
        this.f2084i = str6;
        this.f2085j = list;
        this.f2086k = str7;
        this.f2087l = str8;
    }

    @Nullable
    public static GoogleSignInAccount n0(@Nullable String str) throws JSONException {
        Uri uri;
        String strOptString;
        String strOptString2;
        String strOptString3;
        String strOptString4;
        String strOptString5;
        String strOptString6 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString7 = jSONObject.optString("photoUrl");
        if (!TextUtils.isEmpty(strOptString7)) {
            uri = Uri.parse(strOptString7);
        } else {
            uri = null;
        }
        long j10 = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            hashSet.add(new Scope(jSONArray.getString(i10)));
        }
        String strOptString8 = jSONObject.optString(IjkMediaMeta.IJKM_KEY_TRACK_ID);
        if (jSONObject.has("tokenId")) {
            strOptString = jSONObject.optString("tokenId");
        } else {
            strOptString = null;
        }
        if (jSONObject.has(NotificationCompat.CATEGORY_EMAIL)) {
            strOptString2 = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
        } else {
            strOptString2 = null;
        }
        if (jSONObject.has("displayName")) {
            strOptString3 = jSONObject.optString("displayName");
        } else {
            strOptString3 = null;
        }
        if (jSONObject.has("givenName")) {
            strOptString4 = jSONObject.optString("givenName");
        } else {
            strOptString4 = null;
        }
        if (jSONObject.has("familyName")) {
            strOptString5 = jSONObject.optString("familyName");
        } else {
            strOptString5 = null;
        }
        GoogleSignInAccount googleSignInAccountM0 = m0(strOptString8, strOptString, strOptString2, strOptString3, strOptString4, strOptString5, uri, Long.valueOf(j10), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        if (jSONObject.has("serverAuthCode")) {
            strOptString6 = jSONObject.optString("serverAuthCode");
        }
        googleSignInAccountM0.f2082g = strOptString6;
        return googleSignInAccountM0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int iA = n1.b.a(parcel);
        n1.b.k(parcel, 1, this.f2076a);
        n1.b.r(parcel, 2, V(), false);
        n1.b.r(parcel, 3, i0(), false);
        n1.b.r(parcel, 4, M(), false);
        n1.b.r(parcel, 5, J(), false);
        n1.b.q(parcel, 6, j0(), i10, false);
        n1.b.r(parcel, 7, l0(), false);
        n1.b.n(parcel, 8, this.f2083h);
        n1.b.r(parcel, 9, this.f2084i, false);
        n1.b.v(parcel, 10, this.f2085j, false);
        n1.b.r(parcel, 11, S(), false);
        n1.b.r(parcel, 12, P(), false);
        n1.b.b(parcel, iA);
    }
}
