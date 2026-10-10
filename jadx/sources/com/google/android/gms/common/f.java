package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.stub.StubApp;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@SuppressLint({"HandlerLeak"})
final class f extends x1.l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f2232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ a f2233c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(a aVar, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.f2233c = aVar;
        this.f2232b = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 != 1) {
            Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + i10);
            return;
        }
        a aVar = this.f2233c;
        int iG = aVar.g(this.f2232b);
        if (aVar.j(iG)) {
            this.f2233c.o(this.f2232b, iG);
        }
    }
}
