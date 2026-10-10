package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import m1.j0;
import m1.k0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class z implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ a0 f2363a;

    /* synthetic */ z(a0 a0Var, k0 k0Var) {
        this.f2363a = a0Var;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 0) {
            synchronized (this.f2363a.f2294g) {
                try {
                    j0 j0Var = (j0) message.obj;
                    y yVar = (y) this.f2363a.f2294g.get(j0Var);
                    if (yVar != null && yVar.i()) {
                        if (yVar.j()) {
                            yVar.g("GmsClientSupervisor");
                        }
                        this.f2363a.f2294g.remove(j0Var);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        }
        if (i10 != 1) {
            return false;
        }
        synchronized (this.f2363a.f2294g) {
            try {
                j0 j0Var2 = (j0) message.obj;
                y yVar2 = (y) this.f2363a.f2294g.get(j0Var2);
                if (yVar2 != null && yVar2.a() == 3) {
                    Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback " + String.valueOf(j0Var2), new Exception());
                    ComponentName componentNameB = yVar2.b();
                    if (componentNameB == null) {
                        componentNameB = j0Var2.a();
                    }
                    if (componentNameB == null) {
                        String strC = j0Var2.c();
                        m1.g.k(strC);
                        componentNameB = new ComponentName(strC, "unknown");
                    }
                    yVar2.onServiceDisconnected(componentNameB);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return true;
    }
}
