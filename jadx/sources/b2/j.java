package b2;

import android.os.Parcel;
import com.google.android.gms.measurement.internal.zzow;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class j extends com.google.android.gms.internal.measurement.a1 implements h {
    @Override // com.google.android.gms.internal.measurement.a1
    protected final boolean a(int i10, Parcel parcel, Parcel parcel2, int i11) {
        if (i10 != 2) {
            return false;
        }
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(zzow.CREATOR);
        com.google.android.gms.internal.measurement.z0.f(parcel);
        z(arrayListCreateTypedArrayList);
        return true;
    }

    public j() {
        super("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
    }
}
