package com.live.evo.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f7180a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<String, Map<String, String>> f7181b = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends f3.a<Map<String, Map<String, String>>> {
        a() {
        }
    }

    static {
        b();
    }

    private static Map<String, Map<String, String>> b() {
        if (f7180a.compareAndSet(false, true)) {
            x1.f1.lb.util.w0.f21452a.n("app_properties_bean_key", new x1.f1.lb.util.w0.a() { // from class: com.live.evo.util.a1
                @Override // x1.f1.lb.util.w0.a
                public final void a(Object obj) {
                    b1.a((String) obj);
                }
            }, "");
        }
        return f7181b;
    }

    public static List<i5.a0> c(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            Map<String, String> map = b().get(str);
            if (map != null) {
                long j10 = 0;
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    long j11 = 1 + j10;
                    arrayList.add(new i5.a0(Long.valueOf(j10), str, entry.getKey(), entry.getValue()));
                    j10 = j11;
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public static List<i5.a0> d(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        try {
            Map<String, String> map = b().get(str);
            if (map != null) {
                arrayList.add(new i5.a0(0L, str, str2, map.get(str2)));
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public static synchronized void e(String str, String str2, String str3) {
        try {
            Map<String, String> map = b().get(str);
            if (map == null) {
                map = new HashMap<>();
                b().put(str, map);
            }
            map.put(str2, str3);
            f();
        } catch (Exception unused) {
        } catch (Throwable th) {
            throw th;
        }
    }

    public static /* synthetic */ void a(String str) {
        if (!str.isEmpty()) {
            try {
                f7181b = (Map) w.a().o(str, new a().d());
                f7180a.set(true);
            } catch (Exception unused) {
            }
        }
    }

    private static void f() {
        x1.f1.lb.util.w0.f21452a.t("app_properties_bean_key", w.a().w(f7181b));
    }
}
