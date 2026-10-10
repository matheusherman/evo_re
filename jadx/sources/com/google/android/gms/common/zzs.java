package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import m1.o0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new u();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f2496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f2497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f2498d;

    zzs(String str, n nVar, boolean z10, boolean z11) {
        this.f2495a = str;
        this.f2496b = nVar;
        this.f2497c = z10;
        this.f2498d = z11;
    }

    zzs(String str, IBinder iBinder, boolean z10, boolean z11) {
        this.f2495a = str;
        o oVar = null;
        if (iBinder != null) {
            try {
                u1.a aVarE = o0.f(iBinder).e();
                byte[] bArr = aVarE == null ? null : (byte[]) u1.b.g(aVarE);
                if (bArr != null) {
                    oVar = new o(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e10) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e10);
            }
        }
        this.f2496b = oVar;
        this.f2497c = z10;
        this.f2498d = z11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        String str = this.f2495a;
        int iA = n1.b.a(parcel);
        n1.b.r(parcel, 1, str, false);
        n nVar = this.f2496b;
        if (nVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            nVar = null;
        }
        n1.b.j(parcel, 2, nVar, false);
        n1.b.c(parcel, 3, this.f2497c);
        n1.b.c(parcel, 4, this.f2498d);
        n1.b.b(parcel, iA);
    }
}
