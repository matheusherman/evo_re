package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class e7 extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ c7 f2631a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    e7(c7 c7Var, Handler handler) {
        super(null);
        this.f2631a = c7Var;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z10) {
        this.f2631a.e();
    }
}
