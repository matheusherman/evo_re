package p;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class k implements i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, List<j>> f17182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile Map<String, String> f17183d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final String f17184d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final Map<String, List<j>> f17185e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f17186a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map<String, List<j>> f17187b = f17185e;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f17188c = true;

        public k a() {
            this.f17186a = true;
            return new k(this.f17187b);
        }

        @VisibleForTesting
        static String b() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb2 = new StringBuilder(property.length());
            for (int i10 = 0; i10 < length; i10++) {
                char cCharAt = property.charAt(i10);
                if ((cCharAt > 31 || cCharAt == '\t') && cCharAt < 127) {
                    sb2.append(cCharAt);
                } else {
                    sb2.append('?');
                }
            }
            return sb2.toString();
        }

        static {
            String strB = b();
            f17184d = strB;
            HashMap map = new HashMap(2);
            if (!TextUtils.isEmpty(strB)) {
                map.put("User-Agent", Collections.singletonList(new b(strB)));
            }
            f17185e = Collections.unmodifiableMap(map);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        private final String f17189a;

        @Override // p.j
        public String a() {
            return this.f17189a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f17189a.equals(((b) obj).f17189a);
            }
            return false;
        }

        public int hashCode() {
            return this.f17189a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f17189a + "'}";
        }

        b(@NonNull String str) {
            this.f17189a = str;
        }
    }

    @NonNull
    private String a(@NonNull List<j> list) {
        StringBuilder sb2 = new StringBuilder();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            String strA = list.get(i10).a();
            if (!TextUtils.isEmpty(strA)) {
                sb2.append(strA);
                if (i10 != list.size() - 1) {
                    sb2.append(',');
                }
            }
        }
        return sb2.toString();
    }

    private Map<String, String> c() {
        HashMap map = new HashMap();
        for (Map.Entry<String, List<j>> entry : this.f17182c.entrySet()) {
            String strA = a(entry.getValue());
            if (!TextUtils.isEmpty(strA)) {
                map.put(entry.getKey(), strA);
            }
        }
        return map;
    }

    @Override // p.i
    public Map<String, String> b() {
        if (this.f17183d == null) {
            synchronized (this) {
                try {
                    if (this.f17183d == null) {
                        this.f17183d = Collections.unmodifiableMap(c());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f17183d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof k) {
            return this.f17182c.equals(((k) obj).f17182c);
        }
        return false;
    }

    public int hashCode() {
        return this.f17182c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f17182c + '}';
    }

    k(Map<String, List<j>> map) {
        this.f17182c = Collections.unmodifiableMap(map);
    }
}
