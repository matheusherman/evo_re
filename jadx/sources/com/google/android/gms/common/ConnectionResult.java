package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class ConnectionResult extends AbstractSafeParcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f2121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final PendingIntent f2123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final String f2124d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public static final ConnectionResult f2120e = new ConnectionResult(0);

    @NonNull
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new g();

    ConnectionResult(int i10, int i11, @Nullable PendingIntent pendingIntent, @Nullable String str) {
        this.f2121a = i10;
        this.f2122b = i11;
        this.f2123c = pendingIntent;
        this.f2124d = str;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.f2122b == connectionResult.f2122b && m1.f.a(this.f2123c, connectionResult.f2123c) && m1.f.a(this.f2124d, connectionResult.f2124d);
    }

    public ConnectionResult(int i10) {
        this(i10, null, null);
    }

    @NonNull
    static String i0(int i10) {
        if (i10 == 99) {
            return "UNFINISHED";
        }
        if (i10 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i10) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i10) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    case 25:
                        return "API_INSTALL_REQUIRED";
                    default:
                        return "UNKNOWN_ERROR_CODE(" + i10 + ")";
                }
        }
    }

    public int J() {
        return this.f2122b;
    }

    @Nullable
    public String M() {
        return this.f2124d;
    }

    @Nullable
    public PendingIntent P() {
        return this.f2123c;
    }

    public boolean S() {
        return (this.f2122b == 0 || this.f2123c == null) ? false : true;
    }

    public boolean V() {
        return this.f2122b == 0;
    }

    public int hashCode() {
        return m1.f.b(Integer.valueOf(this.f2122b), this.f2123c, this.f2124d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int i11 = this.f2121a;
        int iA = n1.b.a(parcel);
        n1.b.k(parcel, 1, i11);
        n1.b.k(parcel, 2, J());
        n1.b.q(parcel, 3, P(), i10, false);
        n1.b.r(parcel, 4, M(), false);
        n1.b.b(parcel, iA);
    }

    public ConnectionResult(int i10, @Nullable PendingIntent pendingIntent) {
        this(i10, pendingIntent, null);
    }

    @NonNull
    public String toString() {
        m1.f.a aVarC = m1.f.c(this);
        aVarC.a("statusCode", i0(this.f2122b));
        aVarC.a("resolution", this.f2123c);
        aVarC.a("message", this.f2124d);
        return aVarC.toString();
    }

    public ConnectionResult(int i10, @Nullable PendingIntent pendingIntent, @Nullable String str) {
        this(1, i10, pendingIntent, str);
    }
}
