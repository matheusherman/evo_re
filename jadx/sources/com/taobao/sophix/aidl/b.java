package com.taobao.sophix.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public interface b extends IInterface {
    void onLoad(int i10, int i11, String str, int i12);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: com.taobao.sophix.aidl.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        private static class C0156a implements b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static b f8407b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f8408a;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8408a;
            }

            C0156a(IBinder iBinder) {
                this.f8408a = iBinder;
            }

            @Override // com.taobao.sophix.aidl.b
            public void onLoad(int i10, int i11, String str, int i12) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.taobao.sophix.aidl.IPatchStatusCallback");
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i12);
                    if (!this.f8408a.transact(1, parcelObtain, parcelObtain2, 0) && a.a() != null) {
                        a.a().onLoad(i10, i11, str, i12);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.taobao.sophix.aidl.IPatchStatusCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new C0156a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }

        public static b a() {
            return C0156a.f8407b;
        }
    }
}
