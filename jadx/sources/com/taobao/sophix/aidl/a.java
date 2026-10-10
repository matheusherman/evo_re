package com.taobao.sophix.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.taobao.sophix.aidl.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static abstract class AbstractBinderC0155a extends Binder implements a {
        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1) {
                parcel.enforceInterface("com.taobao.sophix.aidl.IDownloadService");
                a(parcel.readString(), b.a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i10 != 2) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString("com.taobao.sophix.aidl.IDownloadService");
                return true;
            }
            parcel.enforceInterface("com.taobao.sophix.aidl.IDownloadService");
            b(parcel.readString(), b.a.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        public AbstractBinderC0155a() {
            attachInterface(this, "com.taobao.sophix.aidl.IDownloadService");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    void a(String str, b bVar);

    void b(String str, b bVar);
}
