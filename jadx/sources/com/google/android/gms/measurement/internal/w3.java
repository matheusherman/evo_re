package com.google.android.gms.measurement.internal;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class w3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b2.g0 f4136a;

    final b2.g0 a() {
        return this.f4136a;
    }

    final String c() {
        return String.valueOf(v7.a(this.f4136a));
    }

    w3(b2.g0 g0Var) {
        this.f4136a = g0Var;
    }

    static w3 b(String str) {
        b2.g0 g0VarC;
        if (!TextUtils.isEmpty(str) && str.length() <= 1) {
            g0VarC = v7.c(str.charAt(0));
        } else {
            g0VarC = b2.g0.UNINITIALIZED;
        }
        return new w3(g0VarC);
    }
}
