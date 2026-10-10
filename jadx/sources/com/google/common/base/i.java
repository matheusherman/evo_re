package com.google.common.base;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class i {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f4569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a f4570b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private a f4571c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f4572d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f4573e;

        /* synthetic */ b(String str, a aVar) {
            this(str);
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            String f4574a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f4575b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            a f4576c;

            a() {
            }
        }

        private b(String str) {
            a aVar = new a();
            this.f4570b = aVar;
            this.f4571c = aVar;
            this.f4572d = false;
            this.f4573e = false;
            this.f4569a = (String) m.i(str);
        }

        private a a() {
            a aVar = new a();
            this.f4571c.f4576c = aVar;
            this.f4571c = aVar;
            return aVar;
        }

        private static boolean d(Object obj) {
            if (obj instanceof CharSequence) {
                return ((CharSequence) obj).length() == 0;
            }
            if (obj instanceof Collection) {
                return ((Collection) obj).isEmpty();
            }
            if (obj instanceof Map) {
                return ((Map) obj).isEmpty();
            }
            if (obj instanceof l) {
                return !((l) obj).c();
            }
            return obj.getClass().isArray() && Array.getLength(obj) == 0;
        }

        /* JADX WARN: Code duplicated, block: B:11:0x002c  */
        /* JADX WARN: Code duplicated, block: B:13:0x0033  */
        /* JADX WARN: Code duplicated, block: B:18:0x005a  */
        public String toString() {
            String str;
            boolean z10 = this.f4572d;
            boolean z11 = this.f4573e;
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append(this.f4569a);
            sb2.append('{');
            String str2 = "";
            for (a aVar = this.f4570b.f4576c; aVar != null; aVar = aVar.f4576c) {
                Object obj = aVar.f4575b;
                if (obj == null) {
                    if (!z10) {
                        sb2.append(str2);
                        str = aVar.f4574a;
                        if (str != null) {
                            sb2.append(str);
                            sb2.append('=');
                        }
                        if (obj == null && obj.getClass().isArray()) {
                            String strDeepToString = Arrays.deepToString(new Object[]{obj});
                            sb2.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
                        } else {
                            sb2.append(obj);
                        }
                        str2 = ", ";
                    }
                } else if (!z11 || !d(obj)) {
                    sb2.append(str2);
                    str = aVar.f4574a;
                    if (str != null) {
                        sb2.append(str);
                        sb2.append('=');
                    }
                    if (obj == null) {
                        sb2.append(obj);
                    } else {
                        sb2.append(obj);
                    }
                    str2 = ", ";
                }
            }
            sb2.append('}');
            return sb2.toString();
        }

        private b b(Object obj) {
            a().f4575b = obj;
            return this;
        }

        public b c(Object obj) {
            return b(obj);
        }
    }

    public static b a(Object obj) {
        return new b(obj.getClass().getSimpleName(), null);
    }
}
