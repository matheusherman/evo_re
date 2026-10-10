package com.taobao.sophix;

import android.os.RemoteException;
import com.taobao.sophix.listener.PatchLoadStatusListener;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class x implements PatchLoadStatusListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.taobao.sophix.aidl.b f8506a;

    @Override // com.taobao.sophix.listener.PatchLoadStatusListener
    public void onLoad(int i10, int i11, String str, int i12) {
        com.taobao.sophix.aidl.b bVar = this.f8506a;
        if (bVar != null) {
            try {
                bVar.onLoad(i10, i11, str, i12);
            } catch (RemoteException unused) {
            }
        }
    }

    public x(com.taobao.sophix.aidl.b bVar) {
        this.f8506a = bVar;
    }
}
