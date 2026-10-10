package w1;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d extends a implements f {
    @Override // w1.f
    public final String d() {
        Parcel parcelF = f(1, a());
        String string = parcelF.readString();
        parcelF.recycle();
        return string;
    }

    d(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    @Override // w1.f
    public final boolean s(boolean z10) {
        Parcel parcelA = a();
        c.a(parcelA, true);
        Parcel parcelF = f(2, parcelA);
        boolean zB = c.b(parcelF);
        parcelF.recycle();
        return zB;
    }
}
