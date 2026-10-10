package m1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzk;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class z extends y1.d implements d {
    @Override // y1.d
    protected final boolean a(int i10, Parcel parcel, Parcel parcel2, int i11) {
        if (i10 == 1) {
            int i12 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) y1.e.a(parcel, Bundle.CREATOR);
            y1.e.b(parcel);
            G(i12, strongBinder, bundle);
        } else if (i10 == 2) {
            int i13 = parcel.readInt();
            Bundle bundle2 = (Bundle) y1.e.a(parcel, Bundle.CREATOR);
            y1.e.b(parcel);
            x(i13, bundle2);
        } else {
            if (i10 != 3) {
                return false;
            }
            int i14 = parcel.readInt();
            IBinder strongBinder2 = parcel.readStrongBinder();
            zzk zzkVar = (zzk) y1.e.a(parcel, zzk.CREATOR);
            y1.e.b(parcel);
            S(i14, strongBinder2, zzkVar);
        }
        parcel2.writeNoException();
        return true;
    }

    public z() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }
}
