package com.blankj.utilcode.util;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@SuppressLint({"ApplySharedPref"})
public final class p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, p> f1242b = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f1243a;

    public static p a(String str) {
        return b(str, 0);
    }

    private static boolean e(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!Character.isWhitespace(str.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public void f(@NonNull String str) {
        g(str, false);
    }

    public String c(@NonNull String str) {
        return d(str, "");
    }

    public String d(@NonNull String str, String str2) {
        return this.f1243a.getString(str, str2);
    }

    public void g(@NonNull String str, boolean z10) {
        if (z10) {
            this.f1243a.edit().remove(str).commit();
        } else {
            this.f1243a.edit().remove(str).apply();
        }
    }

    private p(String str, int i10) {
        this.f1243a = u.a().getSharedPreferences(str, i10);
    }

    public static p b(String str, int i10) {
        p pVar;
        if (e(str)) {
            str = "spUtils";
        }
        Map<String, p> map = f1242b;
        p pVar2 = map.get(str);
        if (pVar2 == null) {
            synchronized (p.class) {
                try {
                    pVar = map.get(str);
                    if (pVar == null) {
                        pVar = new p(str, i10);
                        map.put(str, pVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return pVar;
        }
        return pVar2;
    }
}
