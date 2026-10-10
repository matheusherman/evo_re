package b2;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.measurement.internal.zzow;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class i extends com.google.android.gms.internal.measurement.x0 implements h {
    i(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.ITriggerUrisCallback");
    }

    @Override // b2.h
    public final void z(List<zzow> list) {
        Parcel parcelA = a();
        parcelA.writeTypedList(list);
        W(2, parcelA);
    }
}
