package com.google.common.collect;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class z {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static abstract class a implements com.google.common.base.f<Map.Entry<?, ?>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f4691a = new C0052a("KEY", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f4692b = new b("VALUE", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ a[] f4693c = a();

        private a(String str, int i10) {
            super(str, i10);
        }

        private static /* synthetic */ a[] a() {
            return new a[]{f4691a, f4692b};
        }

        /* JADX INFO: renamed from: com.google.common.collect.z$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        final enum C0052a extends a {
            C0052a(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.base.f
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        final enum b extends a {
            b(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.base.f
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        }

        /* synthetic */ a(String str, int i10, y yVar) {
            this(str, i10);
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f4693c.clone();
        }
    }

    static boolean a(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    static <K> com.google.common.base.f<Map.Entry<K, ?>, K> b() {
        return a.f4691a;
    }

    static <V> com.google.common.base.f<Map.Entry<?, V>, V> d() {
        return a.f4692b;
    }

    static String c(Map<?, ?> map) {
        StringBuilder sbA = h.a(map.size());
        sbA.append('{');
        boolean z10 = true;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (!z10) {
                sbA.append(", ");
            }
            sbA.append(entry.getKey());
            sbA.append('=');
            sbA.append(entry.getValue());
            z10 = false;
        }
        sbA.append('}');
        return sbA.toString();
    }
}
