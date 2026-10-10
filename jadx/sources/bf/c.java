package bf;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.helpers.e;
import org.slf4j.helpers.g;
import org.slf4j.helpers.h;
import org.slf4j.helpers.i;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static volatile int f1068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final h f1069b = new h();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final e f1070c = new e();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static boolean f1071d = i.c("slf4j.detectLoggerNameMismatch");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String[] f1072e = {"1.6", "1.7"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f1073f = "org/slf4j/impl/StaticLoggerBinder.class";

    static void e(Throwable th) {
        f1068a = 2;
        i.b("Failed to instantiate SLF4J LoggerFactory", th);
    }

    private static boolean l(String str) {
        if (str == null) {
            return false;
        }
        return str.contains("org/slf4j/impl/StaticLoggerBinder") || str.contains("org.slf4j.impl.StaticLoggerBinder");
    }

    private static void c(int i10) {
        i.a("A number (" + i10 + ") of logging calls during the initialization phase have been intercepted and are");
        i.a("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        i.a("See also http://www.slf4j.org/codes.html#replay");
    }

    private static void d() {
        i.a("The following set of substitute loggers may have been accessed");
        i.a("during the initialization phase. Logging calls during this");
        i.a("phase were not honored. However, subsequent logging calls to these");
        i.a("loggers will work as normally expected.");
        i.a("See also http://www.slf4j.org/codes.html#substituteLogger");
    }

    static Set<URL> f() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = c.class.getClassLoader();
            Enumeration<URL> systemResources = classLoader == null ? ClassLoader.getSystemResources(f1073f) : classLoader.getResources(f1073f);
            while (systemResources.hasMoreElements()) {
                linkedHashSet.add(systemResources.nextElement());
            }
            return linkedHashSet;
        } catch (IOException e10) {
            i.b("Error getting resources from path", e10);
            return linkedHashSet;
        }
    }

    private static void g() {
        h hVar = f1069b;
        synchronized (hVar) {
            try {
                hVar.d();
                for (g gVar : hVar.c()) {
                    gVar.h(i(gVar.getName()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static a h() {
        if (f1068a == 0) {
            synchronized (c.class) {
                try {
                    if (f1068a == 0) {
                        f1068a = 1;
                        m();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        int i10 = f1068a;
        if (i10 == 1) {
            return f1069b;
        }
        if (i10 == 2) {
            throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
        }
        if (i10 == 3) {
            return org.slf4j.impl.c.c().a();
        }
        if (i10 == 4) {
            return f1070c;
        }
        throw new IllegalStateException("Unreachable code");
    }

    private static boolean k() {
        String strD = i.d("java.vendor.url");
        if (strD == null) {
            return false;
        }
        return strD.toLowerCase().contains("android");
    }

    private static void n() {
        LinkedBlockingQueue<cf.d> linkedBlockingQueueB = f1069b.b();
        int size = linkedBlockingQueueB.size();
        ArrayList<cf.d> arrayList = new ArrayList(128);
        int i10 = 0;
        while (linkedBlockingQueueB.drainTo(arrayList, 128) != 0) {
            for (cf.d dVar : arrayList) {
                o(dVar);
                int i11 = i10 + 1;
                if (i10 == 0) {
                    b(dVar, size);
                }
                i10 = i11;
            }
            arrayList.clear();
        }
    }

    private static void o(cf.d dVar) {
        if (dVar == null) {
            return;
        }
        g gVarA = dVar.a();
        String name = gVarA.getName();
        if (gVarA.f()) {
            throw new IllegalStateException("Delegate logger cannot be null at this state.");
        }
        if (gVarA.e()) {
            return;
        }
        if (gVarA.d()) {
            gVarA.g(dVar);
        } else {
            i.a(name);
        }
    }

    private static void p(Set<URL> set) {
        if (set == null || !j(set)) {
            return;
        }
        i.a("Actual binding is of type [" + org.slf4j.impl.c.c().b() + "]");
    }

    private static final void r() {
        try {
            String str = org.slf4j.impl.c.f17138c;
            boolean z10 = false;
            for (String str2 : f1072e) {
                if (str.startsWith(str2)) {
                    z10 = true;
                }
            }
            if (z10) {
                return;
            }
            i.a("The requested version " + str + " by your slf4j binding is not compatible with " + Arrays.asList(f1072e).toString());
            i.a("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
        } catch (NoSuchFieldError unused) {
        } catch (Throwable th) {
            i.b("Unexpected problem occured during version sanity check", th);
        }
    }

    private c() {
    }

    private static final void a() {
        Set<URL> setF;
        try {
            if (!k()) {
                setF = f();
                q(setF);
            } else {
                setF = null;
            }
            org.slf4j.impl.c.c();
            f1068a = 3;
            p(setF);
            g();
            n();
            f1069b.a();
        } catch (Exception e10) {
            e(e10);
            throw new IllegalStateException("Unexpected initialization failure", e10);
        } catch (NoClassDefFoundError e11) {
            if (l(e11.getMessage())) {
                f1068a = 4;
                i.a("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
                i.a("Defaulting to no-operation (NOP) logger implementation");
                i.a("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
                return;
            }
            e(e11);
            throw e11;
        } catch (NoSuchMethodError e12) {
            String message = e12.getMessage();
            if (message != null && message.contains("org.slf4j.impl.StaticLoggerBinder.getSingleton()")) {
                f1068a = 2;
                i.a("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                i.a("Your binding is version 1.5.5 or earlier.");
                i.a("Upgrade your binding to version 1.6.x.");
            }
            throw e12;
        }
    }

    private static void b(cf.d dVar, int i10) {
        if (dVar.a().d()) {
            c(i10);
        } else {
            if (dVar.a().e()) {
                return;
            }
            d();
        }
    }

    public static b i(String str) {
        return h().getLogger(str);
    }

    private static boolean j(Set<URL> set) {
        if (set.size() > 1) {
            return true;
        }
        return false;
    }

    private static final void m() {
        a();
        if (f1068a == 3) {
            r();
        }
    }

    private static void q(Set<URL> set) {
        if (j(set)) {
            i.a("Class path contains multiple SLF4J bindings.");
            Iterator<URL> it = set.iterator();
            while (it.hasNext()) {
                i.a("Found binding in [" + it.next() + "]");
            }
            i.a("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }
}
