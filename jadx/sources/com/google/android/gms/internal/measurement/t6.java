package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class t6 implements q6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f3066a = new AtomicBoolean();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    @GuardedBy("this")
    private HashMap<String, String> f3067b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy("this")
    private final HashMap<String, Boolean> f3068c = new HashMap<>(16, 1.0f);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @GuardedBy("this")
    private final HashMap<String, Integer> f3069d = new HashMap<>(16, 1.0f);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @GuardedBy("this")
    private final HashMap<String, Long> f3070e = new HashMap<>(16, 1.0f);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @GuardedBy("this")
    private final HashMap<String, Float> f3071f = new HashMap<>(16, 1.0f);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    @GuardedBy("this")
    private Object f3072g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f3073h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @GuardedBy("this")
    private String[] f3074i = new String[0];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final x6 f3075j = new u6();

    @Override // com.google.android.gms.internal.measurement.q6
    @Nullable
    public final String a(@Nullable ContentResolver contentResolver, String str, @Nullable String str2) {
        if (contentResolver == null) {
            throw new IllegalStateException("ContentResolver needed with GservicesDelegateSupplier.init()");
        }
        synchronized (this) {
            try {
                if (this.f3067b == null) {
                    this.f3066a.set(false);
                    this.f3067b = new HashMap<>(16, 1.0f);
                    this.f3072g = new Object();
                    contentResolver.registerContentObserver(o6.f2911a, true, new w6(this, null));
                } else if (this.f3066a.getAndSet(false)) {
                    this.f3067b.clear();
                    this.f3068c.clear();
                    this.f3069d.clear();
                    this.f3070e.clear();
                    this.f3071f.clear();
                    this.f3072g = new Object();
                    this.f3073h = false;
                }
                Object obj = this.f3072g;
                if (this.f3067b.containsKey(str)) {
                    String str3 = this.f3067b.get(str);
                    return str3 != null ? str3 : null;
                }
                for (String str4 : this.f3074i) {
                    if (str.startsWith(str4)) {
                        if (!this.f3073h) {
                            try {
                                HashMap<String, String> map = (HashMap) this.f3075j.b(contentResolver, this.f3074i, new y6() { // from class: com.google.android.gms.internal.measurement.s6
                                    @Override // com.google.android.gms.internal.measurement.y6
                                    public final Map a(int i10) {
                                        return new HashMap(i10, 1.0f);
                                    }
                                });
                                if (!map.isEmpty()) {
                                    Set<String> setKeySet = map.keySet();
                                    setKeySet.removeAll(this.f3068c.keySet());
                                    setKeySet.removeAll(this.f3069d.keySet());
                                    setKeySet.removeAll(this.f3070e.keySet());
                                    setKeySet.removeAll(this.f3071f.keySet());
                                }
                                if (!map.isEmpty()) {
                                    if (this.f3067b.isEmpty()) {
                                        this.f3067b = map;
                                    } else {
                                        this.f3067b.putAll(map);
                                    }
                                }
                                this.f3073h = true;
                            } catch (b7 unused) {
                            }
                            if (this.f3067b.containsKey(str)) {
                                String str5 = this.f3067b.get(str);
                                return str5 != null ? str5 : null;
                            }
                        }
                        return null;
                    }
                }
                try {
                    String strA = this.f3075j.a(contentResolver, str);
                    if (strA != null && strA.equals(null)) {
                        strA = null;
                    }
                    synchronized (this) {
                        try {
                            if (obj == this.f3072g) {
                                this.f3067b.put(str, strA);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (strA != null) {
                        return strA;
                    }
                    return null;
                } catch (b7 unused2) {
                    return null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
