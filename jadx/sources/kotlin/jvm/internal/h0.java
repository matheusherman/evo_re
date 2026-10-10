package kotlin.jvm.internal;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.spi.Configurator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class h0 {
    public static Collection a(Object obj) {
        if ((obj instanceof d9.a) && !(obj instanceof d9.b)) {
            r(obj, "kotlin.collections.MutableCollection");
        }
        return g(obj);
    }

    public static Iterable b(Object obj) {
        if ((obj instanceof d9.a) && !(obj instanceof d9.c)) {
            r(obj, "kotlin.collections.MutableIterable");
        }
        return h(obj);
    }

    public static List c(Object obj) {
        if ((obj instanceof d9.a) && !(obj instanceof d9.d)) {
            r(obj, "kotlin.collections.MutableList");
        }
        return i(obj);
    }

    public static Map d(Object obj) {
        if ((obj instanceof d9.a) && !(obj instanceof d9.e)) {
            r(obj, "kotlin.collections.MutableMap");
        }
        return j(obj);
    }

    public static Set e(Object obj) {
        if ((obj instanceof d9.a) && !(obj instanceof d9.f)) {
            r(obj, "kotlin.collections.MutableSet");
        }
        return k(obj);
    }

    public static Object f(Object obj, int i10) {
        if (obj != null && !m(obj, i10)) {
            r(obj, "kotlin.jvm.functions.Function" + i10);
        }
        return obj;
    }

    public static Collection g(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e10) {
            throw q(e10);
        }
    }

    public static Iterable h(Object obj) {
        try {
            return (Iterable) obj;
        } catch (ClassCastException e10) {
            throw q(e10);
        }
    }

    public static List i(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e10) {
            throw q(e10);
        }
    }

    public static Map j(Object obj) {
        try {
            return (Map) obj;
        } catch (ClassCastException e10) {
            throw q(e10);
        }
    }

    public static Set k(Object obj) {
        try {
            return (Set) obj;
        } catch (ClassCastException e10) {
            throw q(e10);
        }
    }

    public static int l(Object obj) {
        if (obj instanceof i) {
            return ((i) obj).getArity();
        }
        if (obj instanceof c9.a) {
            return 0;
        }
        if (obj instanceof c9.l) {
            return 1;
        }
        if (obj instanceof c9.p) {
            return 2;
        }
        if (obj instanceof c9.q) {
            return 3;
        }
        if (obj instanceof c9.r) {
            return 4;
        }
        if (obj instanceof c9.s) {
            return 5;
        }
        if (obj instanceof c9.t) {
            return 6;
        }
        if (obj instanceof c9.u) {
            return 7;
        }
        if (obj instanceof c9.v) {
            return 8;
        }
        if (obj instanceof c9.w) {
            return 9;
        }
        if (obj instanceof c9.b) {
            return 10;
        }
        if (obj instanceof c9.c) {
            return 11;
        }
        if (obj instanceof c9.d) {
            return 12;
        }
        if (obj instanceof c9.e) {
            return 13;
        }
        if (obj instanceof c9.f) {
            return 14;
        }
        if (obj instanceof c9.g) {
            return 15;
        }
        if (obj instanceof c9.h) {
            return 16;
        }
        if (obj instanceof c9.i) {
            return 17;
        }
        if (obj instanceof c9.j) {
            return 18;
        }
        if (obj instanceof c9.k) {
            return 19;
        }
        if (obj instanceof c9.m) {
            return 20;
        }
        if (obj instanceof c9.n) {
            return 21;
        }
        return obj instanceof c9.o ? 22 : -1;
    }

    public static boolean m(Object obj, int i10) {
        return (obj instanceof r8.c) && l(obj) == i10;
    }

    public static boolean n(Object obj) {
        if (obj instanceof List) {
            return !(obj instanceof d9.a) || (obj instanceof d9.d);
        }
        return false;
    }

    public static boolean o(Object obj) {
        if (obj instanceof Map.Entry) {
            return !(obj instanceof d9.a) || (obj instanceof d9.e.a);
        }
        return false;
    }

    private static <T extends Throwable> T p(T t10) {
        return (T) m.l(t10, h0.class.getName());
    }

    public static void r(Object obj, String str) {
        s((obj == null ? Configurator.NULL : obj.getClass().getName()) + " cannot be cast to " + str);
    }

    public static void s(String str) {
        throw q(new ClassCastException(str));
    }

    public static ClassCastException q(ClassCastException classCastException) {
        throw ((ClassCastException) p(classCastException));
    }
}
