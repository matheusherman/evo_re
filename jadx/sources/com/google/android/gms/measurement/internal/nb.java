package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class nb extends v {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ ob f3848e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    nb(ob obVar, t7 t7Var) {
        super(t7Var);
        this.f3848e = obVar;
    }

    @Override // com.google.android.gms.measurement.internal.v
    @WorkerThread
    public final void d() {
        ob.c(this.f3848e);
    }
}
