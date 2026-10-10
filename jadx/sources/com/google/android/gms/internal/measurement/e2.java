package com.google.android.gms.internal.measurement;

import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class e2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static e2 f2626a = new c2(null);

    public abstract URLConnection b(URL url, String str);

    public static synchronized e2 a() {
        return f2626a;
    }
}
