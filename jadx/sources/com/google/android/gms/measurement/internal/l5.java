package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class l5 extends com.google.android.gms.common.internal.b<b2.g> {
    public l5(Context context, Looper looper, com.google.android.gms.common.internal.b.a aVar, com.google.android.gms.common.internal.b.InterfaceC0045b interfaceC0045b) {
        super(context, looper, 93, aVar, interfaceC0045b, null);
    }

    @Override // com.google.android.gms.common.internal.b
    @NonNull
    protected final String C() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }

    @Override // com.google.android.gms.common.internal.b
    @NonNull
    protected final String D() {
        return "com.google.android.gms.measurement.START";
    }

    @Override // com.google.android.gms.common.internal.b
    public final /* synthetic */ IInterface q(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        return iInterfaceQueryLocalInterface instanceof b2.g ? (b2.g) iInterfaceQueryLocalInterface : new g5(iBinder);
    }

    @Override // com.google.android.gms.common.internal.b
    public final int j() {
        return 12451000;
    }
}
