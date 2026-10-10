package d2;

import android.os.Parcel;
import com.google.android.gms.signin.internal.zak;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class b extends x1.b implements c {
    public b() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // x1.b
    protected final boolean W(int i10, Parcel parcel, Parcel parcel2, int i11) {
        switch (i10) {
            case 3:
                x1.c.b(parcel);
                break;
            case 4:
                x1.c.b(parcel);
                break;
            case 5:
            default:
                return false;
            case 6:
                x1.c.b(parcel);
                break;
            case 7:
                x1.c.b(parcel);
                break;
            case 8:
                zak zakVar = (zak) x1.c.a(parcel, zak.CREATOR);
                x1.c.b(parcel);
                v(zakVar);
                break;
            case 9:
                x1.c.b(parcel);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
