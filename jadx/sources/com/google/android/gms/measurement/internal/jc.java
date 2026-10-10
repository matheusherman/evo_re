package com.google.android.gms.measurement.internal;

import android.content.Intent;
import androidx.annotation.WorkerThread;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class jc extends v {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ gc f3749e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    jc(gc gcVar, t7 t7Var) {
        super(t7Var);
        this.f3749e = gcVar;
    }

    @Override // com.google.android.gms.measurement.internal.v
    @WorkerThread
    public final void d() {
        this.f3749e.O0();
        String str = (String) this.f3749e.f3648q.pollFirst();
        if (str != null) {
            gc gcVar = this.f3749e;
            gcVar.I = gcVar.c().b();
            this.f3749e.l().L().b("Sending trigger URI notification to app", str);
            Intent intent = new Intent();
            intent.setAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
            intent.setPackage(str);
            gc.i0(this.f3749e.b(), intent);
        }
        this.f3749e.b0();
    }
}
