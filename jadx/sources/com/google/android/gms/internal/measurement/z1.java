package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<Boolean> f3311a = new y1();

    public static SharedPreferences a(Context context, String str, int i10, r1 r1Var) {
        u1 u1Var;
        if (j1.a().d(str, r1Var, p1.SHARED_PREFS_TYPE).equals("")) {
            u1Var = new u1();
        } else {
            u1Var = null;
        }
        if (u1Var != null) {
            return u1Var;
        }
        ThreadLocal<Boolean> threadLocal = f3311a;
        com.google.common.base.m.d(threadLocal.get().booleanValue());
        threadLocal.set(Boolean.FALSE);
        try {
            return context.getSharedPreferences(str, 0);
        } finally {
            f3311a.set(Boolean.TRUE);
        }
    }
}
