package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class GetServiceRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new x();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final Scope[] f2262o = new Scope[0];

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final Feature[] f2263p = new Feature[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f2264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f2265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f2266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f2267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    IBinder f2268e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Scope[] f2269f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Bundle f2270g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    Account f2271h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Feature[] f2272i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Feature[] f2273j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final boolean f2274k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final int f2275l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    boolean f2276m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private final String f2277n;

    @Nullable
    public String J() {
        return this.f2277n;
    }

    GetServiceRequest(int i10, int i11, int i12, String str, @Nullable IBinder iBinder, Scope[] scopeArr, Bundle bundle, @Nullable Account account, Feature[] featureArr, Feature[] featureArr2, boolean z10, int i13, boolean z11, @Nullable String str2) {
        Account accountG;
        scopeArr = scopeArr == null ? f2262o : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        featureArr = featureArr == null ? f2263p : featureArr;
        featureArr2 = featureArr2 == null ? f2263p : featureArr2;
        this.f2264a = i10;
        this.f2265b = i11;
        this.f2266c = i12;
        if ("com.google.android.gms".equals(str)) {
            this.f2267d = "com.google.android.gms";
        } else {
            this.f2267d = str;
        }
        if (i10 < 2) {
            if (iBinder != null) {
                accountG = a.g(e.a.f(iBinder));
            } else {
                accountG = null;
            }
            this.f2271h = accountG;
        } else {
            this.f2268e = iBinder;
            this.f2271h = account;
        }
        this.f2269f = scopeArr;
        this.f2270g = bundle;
        this.f2272i = featureArr;
        this.f2273j = featureArr2;
        this.f2274k = z10;
        this.f2275l = i13;
        this.f2276m = z11;
        this.f2277n = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        x.a(this, parcel, i10);
    }
}
