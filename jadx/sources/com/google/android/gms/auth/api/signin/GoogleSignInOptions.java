package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@Deprecated
public class GoogleSignInOptions extends AbstractSafeParcelable implements com.google.android.gms.common.api.a.d, ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public static final GoogleSignInOptions f2089l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public static final GoogleSignInOptions f2090m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    @VisibleForTesting
    public static final Scope f2091n = new Scope("profile");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    @VisibleForTesting
    public static final Scope f2092o = new Scope(NotificationCompat.CATEGORY_EMAIL);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    @VisibleForTesting
    public static final Scope f2093p = new Scope("openid");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    @VisibleForTesting
    public static final Scope f2094q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NonNull
    @VisibleForTesting
    public static final Scope f2095r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final Comparator f2096s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f2097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList f2098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private Account f2099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f2100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f2101e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f2102f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private String f2103g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private String f2104h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ArrayList f2105i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private String f2106j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Map f2107k;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f2109b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f2110c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f2111d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        private String f2112e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        private Account f2113f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        private String f2114g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        private String f2116i;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Set f2108a = new HashSet();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Map f2115h = new HashMap();

        @NonNull
        public GoogleSignInOptions a() {
            if (this.f2108a.contains(GoogleSignInOptions.f2095r)) {
                Set set = this.f2108a;
                Scope scope = GoogleSignInOptions.f2094q;
                if (set.contains(scope)) {
                    this.f2108a.remove(scope);
                }
            }
            if (this.f2111d && (this.f2113f == null || !this.f2108a.isEmpty())) {
                b();
            }
            return new GoogleSignInOptions(3, new ArrayList(this.f2108a), this.f2113f, this.f2111d, this.f2109b, this.f2110c, this.f2112e, this.f2114g, this.f2115h, this.f2116i, null);
        }

        @NonNull
        public a b() {
            this.f2108a.add(GoogleSignInOptions.f2093p);
            return this;
        }

        @NonNull
        public a c() {
            this.f2108a.add(GoogleSignInOptions.f2091n);
            return this;
        }

        @NonNull
        public a d(@NonNull Scope scope, @NonNull Scope... scopeArr) {
            this.f2108a.add(scope);
            this.f2108a.addAll(Arrays.asList(scopeArr));
            return this;
        }
    }

    /* synthetic */ GoogleSignInOptions(int i10, ArrayList arrayList, Account account, boolean z10, boolean z11, boolean z12, String str, String str2, Map map, String str3, h1.a aVar) {
        this(3, arrayList, account, z10, z11, z12, str, str2, map, str3);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0052 A[Catch: ClassCastException -> 0x0090, TryCatch #0 {ClassCastException -> 0x0090, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0018, B:12:0x0028, B:15:0x0035, B:17:0x0039, B:22:0x004a, B:24:0x0052, B:30:0x006a, B:32:0x0072, B:34:0x007a, B:36:0x0082, B:27:0x005d, B:20:0x0040), top: B:42:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x005c  */
    /* JADX WARN: Code duplicated, block: B:27:0x005d A[Catch: ClassCastException -> 0x0090, TryCatch #0 {ClassCastException -> 0x0090, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0018, B:12:0x0028, B:15:0x0035, B:17:0x0039, B:22:0x004a, B:24:0x0052, B:30:0x006a, B:32:0x0072, B:34:0x007a, B:36:0x0082, B:27:0x005d, B:20:0x0040), top: B:42:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0069  */
    /* JADX WARN: Code duplicated, block: B:30:0x006a A[Catch: ClassCastException -> 0x0090, TryCatch #0 {ClassCastException -> 0x0090, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0018, B:12:0x0028, B:15:0x0035, B:17:0x0039, B:22:0x004a, B:24:0x0052, B:30:0x006a, B:32:0x0072, B:34:0x007a, B:36:0x0082, B:27:0x005d, B:20:0x0040), top: B:42:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0072 A[Catch: ClassCastException -> 0x0090, TryCatch #0 {ClassCastException -> 0x0090, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0018, B:12:0x0028, B:15:0x0035, B:17:0x0039, B:22:0x004a, B:24:0x0052, B:30:0x006a, B:32:0x0072, B:34:0x007a, B:36:0x0082, B:27:0x005d, B:20:0x0040), top: B:42:0x0004 }] */
    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.f2105i.isEmpty() && googleSignInOptions.f2105i.isEmpty() && this.f2098b.size() == googleSignInOptions.P().size() && this.f2098b.containsAll(googleSignInOptions.P())) {
                Account account = this.f2099c;
                if (account == null) {
                    if (googleSignInOptions.w() == null) {
                        if (TextUtils.isEmpty(this.f2103g)) {
                            if (TextUtils.isEmpty(googleSignInOptions.S())) {
                                if (this.f2102f != googleSignInOptions.V() && this.f2100d == googleSignInOptions.i0() && this.f2101e == googleSignInOptions.j0() && TextUtils.equals(this.f2106j, googleSignInOptions.M())) {
                                    return true;
                                }
                            }
                        } else if (!this.f2103g.equals(googleSignInOptions.S())) {
                            if (this.f2102f != googleSignInOptions.V()) {
                            }
                        }
                    }
                } else if (account.equals(googleSignInOptions.w())) {
                    if (TextUtils.isEmpty(this.f2103g)) {
                        if (TextUtils.isEmpty(googleSignInOptions.S())) {
                            if (this.f2102f != googleSignInOptions.V()) {
                            }
                        }
                    } else if (!this.f2103g.equals(googleSignInOptions.S())) {
                        if (this.f2102f != googleSignInOptions.V()) {
                        }
                    }
                }
            }
        } catch (ClassCastException unused) {
        }
        return false;
    }

    static {
        Scope scope = new Scope("https://www.googleapis.com/auth/games_lite");
        f2094q = scope;
        f2095r = new Scope("https://www.googleapis.com/auth/games");
        a aVar = new a();
        aVar.b();
        aVar.c();
        f2089l = aVar.a();
        a aVar2 = new a();
        aVar2.d(scope, new Scope[0]);
        f2090m = aVar2.a();
        CREATOR = new c();
        f2096s = new b();
    }

    GoogleSignInOptions(int i10, ArrayList arrayList, @Nullable Account account, boolean z10, boolean z11, boolean z12, @Nullable String str, @Nullable String str2, ArrayList arrayList2, @Nullable String str3) {
        this(i10, arrayList, account, z10, z11, z12, str, str2, k0(arrayList2), str3);
    }

    private static Map k0(@Nullable List list) {
        HashMap map = new HashMap();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable = (GoogleSignInOptionsExtensionParcelable) it.next();
                map.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.getType()), googleSignInOptionsExtensionParcelable);
            }
        }
        return map;
    }

    @NonNull
    public ArrayList<GoogleSignInOptionsExtensionParcelable> J() {
        return this.f2105i;
    }

    @Nullable
    public String M() {
        return this.f2106j;
    }

    @NonNull
    public ArrayList<Scope> P() {
        return new ArrayList<>(this.f2098b);
    }

    @Nullable
    public String S() {
        return this.f2103g;
    }

    public boolean V() {
        return this.f2102f;
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f2098b;
        int size = arrayList2.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(((Scope) arrayList2.get(i10)).J());
        }
        Collections.sort(arrayList);
        i1.a aVar = new i1.a();
        aVar.a(arrayList);
        aVar.a(this.f2099c);
        aVar.a(this.f2103g);
        aVar.c(this.f2102f);
        aVar.c(this.f2100d);
        aVar.c(this.f2101e);
        aVar.a(this.f2106j);
        return aVar.b();
    }

    public boolean i0() {
        return this.f2100d;
    }

    public boolean j0() {
        return this.f2101e;
    }

    @Nullable
    public Account w() {
        return this.f2099c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int i11 = this.f2097a;
        int iA = n1.b.a(parcel);
        n1.b.k(parcel, 1, i11);
        n1.b.v(parcel, 2, P(), false);
        n1.b.q(parcel, 3, w(), i10, false);
        n1.b.c(parcel, 4, i0());
        n1.b.c(parcel, 5, j0());
        n1.b.c(parcel, 6, V());
        n1.b.r(parcel, 7, S(), false);
        n1.b.r(parcel, 8, this.f2104h, false);
        n1.b.v(parcel, 9, J(), false);
        n1.b.r(parcel, 10, M(), false);
        n1.b.b(parcel, iA);
    }

    private GoogleSignInOptions(int i10, ArrayList arrayList, @Nullable Account account, boolean z10, boolean z11, boolean z12, @Nullable String str, @Nullable String str2, Map map, @Nullable String str3) {
        this.f2097a = i10;
        this.f2098b = arrayList;
        this.f2099c = account;
        this.f2100d = z10;
        this.f2101e = z11;
        this.f2102f = z12;
        this.f2103g = str;
        this.f2104h = str2;
        this.f2105i = new ArrayList(map.values());
        this.f2107k = map;
        this.f2106j = str3;
    }
}
