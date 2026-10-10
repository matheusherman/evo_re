package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class n implements m1.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IBinder f2344a;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f2344a;
    }

    n(IBinder iBinder) {
        this.f2344a = iBinder;
    }

    @Override // m1.e
    public final void L(m1.d dVar, @Nullable GetServiceRequest getServiceRequest) {
        IBinder iBinderAsBinder;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (dVar != null) {
                iBinderAsBinder = dVar.asBinder();
            } else {
                iBinderAsBinder = null;
            }
            parcelObtain.writeStrongBinder(iBinderAsBinder);
            if (getServiceRequest != null) {
                parcelObtain.writeInt(1);
                x.a(getServiceRequest, parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            this.f2344a.transact(46, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
