package ba;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.m;
import ua.n;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class e {
    private static final boolean d(String str, String str2) {
        return n.I(str, str2, false, 2, null) && str.charAt(str2.length()) == '.';
    }

    public static final boolean e(String str) {
        if (str == null) {
            return false;
        }
        k kVar = k.BEGINNING;
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            int i11 = a.f937a[kVar.ordinal()];
            if (i11 == 1 || i11 == 2) {
                if (!Character.isJavaIdentifierStart(cCharAt)) {
                    return false;
                }
                kVar = k.MIDDLE;
            } else if (i11 != 3) {
                continue;
            } else if (cCharAt == '.') {
                kVar = k.AFTER_DOT;
            } else if (!Character.isJavaIdentifierPart(cCharAt)) {
                return false;
            }
        }
        return kVar != k.AFTER_DOT;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f937a;

        static {
            int[] iArr = new int[k.values().length];
            try {
                iArr[k.BEGINNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[k.AFTER_DOT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[k.MIDDLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f937a = iArr;
        }
    }

    public static final <V> V a(c cVar, Map<c, ? extends V> values) {
        Object next;
        m.f(cVar, "<this>");
        m.f(values, "values");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<c, ? extends V> entry : values.entrySet()) {
            c key = entry.getKey();
            if (m.a(cVar, key) || b(cVar, key)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        if (linkedHashMap.isEmpty()) {
            linkedHashMap = null;
        }
        if (linkedHashMap == null) {
            return null;
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                int length = g((c) ((Map.Entry) next).getKey(), cVar).b().length();
                do {
                    Object next2 = it.next();
                    int length2 = g((c) ((Map.Entry) next2).getKey(), cVar).b().length();
                    if (length > length2) {
                        next = next2;
                        length = length2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        Map.Entry entry2 = (Map.Entry) next;
        if (entry2 != null) {
            return (V) entry2.getValue();
        }
        return null;
    }

    public static final boolean b(c cVar, c packageName) {
        m.f(cVar, "<this>");
        m.f(packageName, "packageName");
        return m.a(f(cVar), packageName);
    }

    public static final boolean c(c cVar, c packageName) {
        m.f(cVar, "<this>");
        m.f(packageName, "packageName");
        if (m.a(cVar, packageName) || packageName.d()) {
            return true;
        }
        String strB = cVar.b();
        m.e(strB, "this.asString()");
        String strB2 = packageName.b();
        m.e(strB2, "packageName.asString()");
        return d(strB, strB2);
    }

    public static final c f(c cVar) {
        m.f(cVar, "<this>");
        if (cVar.d()) {
            return null;
        }
        return cVar.e();
    }

    public static final c g(c cVar, c prefix) {
        m.f(cVar, "<this>");
        m.f(prefix, "prefix");
        if (!c(cVar, prefix) || prefix.d()) {
            return cVar;
        }
        if (m.a(cVar, prefix)) {
            c ROOT = c.f927c;
            m.e(ROOT, "ROOT");
            return ROOT;
        }
        String strB = cVar.b();
        m.e(strB, "asString()");
        String strSubstring = strB.substring(prefix.b().length() + 1);
        m.e(strSubstring, "this as java.lang.String).substring(startIndex)");
        return new c(strSubstring);
    }
}
