package m1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class i0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new ConnectionTelemetryConfiguration[i10];
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iJ = n1.a.J(parcel);
        RootTelemetryConfiguration rootTelemetryConfiguration = null;
        int[] iArrJ = null;
        int[] iArrJ2 = null;
        boolean zW = false;
        boolean zW2 = false;
        int iE = 0;
        while (parcel.dataPosition() < iJ) {
            int iC = n1.a.C(parcel);
            switch (n1.a.v(iC)) {
                case 1:
                    rootTelemetryConfiguration = (RootTelemetryConfiguration) n1.a.o(parcel, iC, RootTelemetryConfiguration.CREATOR);
                    break;
                case 2:
                    zW = n1.a.w(parcel, iC);
                    break;
                case 3:
                    zW2 = n1.a.w(parcel, iC);
                    break;
                case 4:
                    iArrJ = n1.a.j(parcel, iC);
                    break;
                case 5:
                    iE = n1.a.E(parcel, iC);
                    break;
                case 6:
                    iArrJ2 = n1.a.j(parcel, iC);
                    break;
                default:
                    n1.a.I(parcel, iC);
                    break;
            }
        }
        n1.a.u(parcel, iJ);
        return new ConnectionTelemetryConfiguration(rootTelemetryConfiguration, zW, zW2, iArrJ, iE, iArrJ2);
    }
}
