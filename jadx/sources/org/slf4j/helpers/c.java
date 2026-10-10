package org.slf4j.helpers;

import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.spi.Configurator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class c {
    public static final a i(String str, Object obj) {
        return a(str, new Object[]{obj});
    }

    public static final a j(String str, Object obj, Object obj2) {
        return a(str, new Object[]{obj, obj2});
    }

    static final Throwable k(Object[] objArr) {
        if (objArr != null && objArr.length != 0) {
            Object obj = objArr[objArr.length - 1];
            if (obj instanceof Throwable) {
                return (Throwable) obj;
            }
        }
        return null;
    }

    static final boolean m(String str, int i10) {
        return i10 >= 2 && str.charAt(i10 - 2) == '\\';
    }

    static final boolean n(String str, int i10) {
        return i10 != 0 && str.charAt(i10 - 1) == '\\';
    }

    public static final a b(String str, Object[] objArr, Throwable th) {
        int i10;
        if (str == null) {
            return new a(null, objArr, th);
        }
        if (objArr == null) {
            return new a(str);
        }
        StringBuilder sb2 = new StringBuilder(str.length() + 50);
        int i11 = 0;
        int i12 = 0;
        while (i11 < objArr.length) {
            int iIndexOf = str.indexOf("{}", i12);
            if (iIndexOf == -1) {
                if (i12 == 0) {
                    return new a(str, objArr, th);
                }
                sb2.append((CharSequence) str, i12, str.length());
                return new a(sb2.toString(), objArr, th);
            }
            if (n(str, iIndexOf)) {
                if (m(str, iIndexOf)) {
                    sb2.append((CharSequence) str, i12, iIndexOf - 1);
                    f(sb2, objArr[i11], new HashMap());
                } else {
                    i11--;
                    sb2.append((CharSequence) str, i12, iIndexOf - 1);
                    sb2.append('{');
                    i10 = iIndexOf + 1;
                }
                i12 = i10;
                i11++;
            } else {
                sb2.append((CharSequence) str, i12, iIndexOf);
                f(sb2, objArr[i11], new HashMap());
            }
            i10 = iIndexOf + 2;
            i12 = i10;
            i11++;
        }
        sb2.append((CharSequence) str, i12, str.length());
        return new a(sb2.toString(), objArr, th);
    }

    private static void c(StringBuilder sb2, boolean[] zArr) {
        sb2.append('[');
        int length = zArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            sb2.append(zArr[i10]);
            if (i10 != length - 1) {
                sb2.append(", ");
            }
        }
        sb2.append(']');
    }

    private static void d(StringBuilder sb2, byte[] bArr) {
        sb2.append('[');
        int length = bArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            sb2.append((int) bArr[i10]);
            if (i10 != length - 1) {
                sb2.append(", ");
            }
        }
        sb2.append(']');
    }

    private static void e(StringBuilder sb2, char[] cArr) {
        sb2.append('[');
        int length = cArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            sb2.append(cArr[i10]);
            if (i10 != length - 1) {
                sb2.append(", ");
            }
        }
        sb2.append(']');
    }

    private static void f(StringBuilder sb2, Object obj, Map<Object[], Object> map) {
        if (obj == null) {
            sb2.append(Configurator.NULL);
            return;
        }
        if (!obj.getClass().isArray()) {
            q(sb2, obj);
            return;
        }
        if (obj instanceof boolean[]) {
            c(sb2, (boolean[]) obj);
            return;
        }
        if (obj instanceof byte[]) {
            d(sb2, (byte[]) obj);
            return;
        }
        if (obj instanceof char[]) {
            e(sb2, (char[]) obj);
            return;
        }
        if (obj instanceof short[]) {
            r(sb2, (short[]) obj);
            return;
        }
        if (obj instanceof int[]) {
            l(sb2, (int[]) obj);
            return;
        }
        if (obj instanceof long[]) {
            o(sb2, (long[]) obj);
            return;
        }
        if (obj instanceof float[]) {
            h(sb2, (float[]) obj);
        } else if (obj instanceof double[]) {
            g(sb2, (double[]) obj);
        } else {
            p(sb2, (Object[]) obj, map);
        }
    }

    private static void g(StringBuilder sb2, double[] dArr) {
        sb2.append('[');
        int length = dArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            sb2.append(dArr[i10]);
            if (i10 != length - 1) {
                sb2.append(", ");
            }
        }
        sb2.append(']');
    }

    private static void h(StringBuilder sb2, float[] fArr) {
        sb2.append('[');
        int length = fArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            sb2.append(fArr[i10]);
            if (i10 != length - 1) {
                sb2.append(", ");
            }
        }
        sb2.append(']');
    }

    private static void l(StringBuilder sb2, int[] iArr) {
        sb2.append('[');
        int length = iArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            sb2.append(iArr[i10]);
            if (i10 != length - 1) {
                sb2.append(", ");
            }
        }
        sb2.append(']');
    }

    private static void o(StringBuilder sb2, long[] jArr) {
        sb2.append('[');
        int length = jArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            sb2.append(jArr[i10]);
            if (i10 != length - 1) {
                sb2.append(", ");
            }
        }
        sb2.append(']');
    }

    private static void p(StringBuilder sb2, Object[] objArr, Map<Object[], Object> map) {
        sb2.append('[');
        if (map.containsKey(objArr)) {
            sb2.append("...");
        } else {
            map.put(objArr, null);
            int length = objArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                f(sb2, objArr[i10], map);
                if (i10 != length - 1) {
                    sb2.append(", ");
                }
            }
            map.remove(objArr);
        }
        sb2.append(']');
    }

    private static void r(StringBuilder sb2, short[] sArr) {
        sb2.append('[');
        int length = sArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            sb2.append((int) sArr[i10]);
            if (i10 != length - 1) {
                sb2.append(", ");
            }
        }
        sb2.append(']');
    }

    private static Object[] s(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            throw new IllegalStateException("non-sensical empty or null argument array");
        }
        int length = objArr.length - 1;
        Object[] objArr2 = new Object[length];
        System.arraycopy(objArr, 0, objArr2, 0, length);
        return objArr2;
    }

    public static final a a(String str, Object[] objArr) {
        Throwable thK = k(objArr);
        if (thK != null) {
            objArr = s(objArr);
        }
        return b(str, objArr, thK);
    }

    private static void q(StringBuilder sb2, Object obj) {
        try {
            sb2.append(obj.toString());
        } catch (Throwable th) {
            i.b("SLF4J: Failed toString() invocation on an object of type [" + obj.getClass().getName() + "]", th);
            sb2.append("[FAILED toString()]");
        }
    }
}
