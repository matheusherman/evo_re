package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class p extends y1.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ b f2345b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(b bVar, Looper looper) {
        super(looper);
        this.f2345b = bVar;
    }

    private static final void a(Message message) {
        q qVar = (q) message.obj;
        qVar.b();
        qVar.e();
    }

    private static final boolean b(Message message) {
        int i10 = message.what;
        return i10 == 2 || i10 == 1 || i10 == 7;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.f2345b.C.get() != message.arg1) {
            if (b(message)) {
                a(message);
                return;
            }
            return;
        }
        int i10 = message.what;
        if ((i10 == 1 || i10 == 7 || ((i10 == 4 && !this.f2345b.r()) || message.what == 5)) && !this.f2345b.d()) {
            a(message);
            return;
        }
        int i11 = message.what;
        if (i11 == 4) {
            this.f2345b.f2327z = new ConnectionResult(message.arg2);
            if (b.f0(this.f2345b)) {
                b bVar = this.f2345b;
                if (!bVar.A) {
                    bVar.g0(3, null);
                    return;
                }
            }
            b bVar2 = this.f2345b;
            ConnectionResult connectionResult = bVar2.f2327z != null ? bVar2.f2327z : new ConnectionResult(8);
            this.f2345b.f2317p.a(connectionResult);
            this.f2345b.J(connectionResult);
            return;
        }
        if (i11 == 5) {
            b bVar3 = this.f2345b;
            ConnectionResult connectionResult2 = bVar3.f2327z != null ? bVar3.f2327z : new ConnectionResult(8);
            this.f2345b.f2317p.a(connectionResult2);
            this.f2345b.J(connectionResult2);
            return;
        }
        if (i11 == 3) {
            Object obj = message.obj;
            ConnectionResult connectionResult3 = new ConnectionResult(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
            this.f2345b.f2317p.a(connectionResult3);
            this.f2345b.J(connectionResult3);
            return;
        }
        if (i11 == 6) {
            this.f2345b.g0(5, null);
            b bVar4 = this.f2345b;
            if (bVar4.f2322u != null) {
                bVar4.f2322u.a(message.arg2);
            }
            this.f2345b.K(message.arg2);
            b.e0(this.f2345b, 5, 1, null);
            return;
        }
        if (i11 == 2 && !this.f2345b.isConnected()) {
            a(message);
            return;
        }
        if (b(message)) {
            ((q) message.obj).c();
            return;
        }
        Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
    }
}
