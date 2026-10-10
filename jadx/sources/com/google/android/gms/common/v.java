package com.google.android.gms.common;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class v extends w {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Callable f2479f;

    /* synthetic */ v(Callable callable, j1.i iVar) {
        super(false, 1, 5, null, null, null);
        this.f2479f = callable;
    }

    @Override // com.google.android.gms.common.w
    final String a() {
        try {
            return (String) this.f2479f.call();
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }
}
