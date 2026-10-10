package m1;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.zzo;
import com.google.android.gms.common.zzq;
import com.google.android.gms.common.zzs;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a0 extends y1.a implements c0 {
    @Override // m1.c0
    public final boolean j() {
        Parcel parcelA = a(7, f());
        boolean zE = y1.e.e(parcelA);
        parcelA.recycle();
        return zE;
    }

    a0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // m1.c0
    public final zzq C(zzo zzoVar) {
        Parcel parcelF = f();
        y1.e.c(parcelF, zzoVar);
        Parcel parcelA = a(6, parcelF);
        zzq zzqVar = (zzq) y1.e.a(parcelA, zzq.CREATOR);
        parcelA.recycle();
        return zzqVar;
    }

    @Override // m1.c0
    public final zzq I(zzo zzoVar) {
        Parcel parcelF = f();
        y1.e.c(parcelF, zzoVar);
        Parcel parcelA = a(8, parcelF);
        zzq zzqVar = (zzq) y1.e.a(parcelA, zzq.CREATOR);
        parcelA.recycle();
        return zzqVar;
    }

    @Override // m1.c0
    public final boolean h(zzs zzsVar, u1.a aVar) {
        Parcel parcelF = f();
        y1.e.c(parcelF, zzsVar);
        y1.e.d(parcelF, aVar);
        Parcel parcelA = a(5, parcelF);
        boolean zE = y1.e.e(parcelA);
        parcelA.recycle();
        return zE;
    }
}
