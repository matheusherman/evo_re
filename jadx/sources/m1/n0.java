package m1;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class n0 extends y1.a implements y {
    @Override // m1.y
    public final int d() {
        Parcel parcelA = a(2, f());
        int i10 = parcelA.readInt();
        parcelA.recycle();
        return i10;
    }

    @Override // m1.y
    public final u1.a e() {
        Parcel parcelA = a(1, f());
        u1.a aVarF = u1.a.AbstractBinderC0368a.f(parcelA.readStrongBinder());
        parcelA.recycle();
        return aVarF;
    }

    n0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }
}
