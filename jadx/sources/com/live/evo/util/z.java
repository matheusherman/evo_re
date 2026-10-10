package com.live.evo.util;

import android.view.inputmethod.InputMethodManager;
import com.live.evo.MyApplication;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static InputMethodManager f7390a = (InputMethodManager) MyApplication.a().getSystemService("input_method");

    public static InputMethodManager a() {
        return f7390a;
    }
}
