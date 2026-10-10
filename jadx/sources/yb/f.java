package yb;

import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f22565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f22566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f22567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f22568d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Method f22569e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Method f22570f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Method f22571g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Method f22572h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Object f22573i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Object f22574j;

    static {
        boolean z10 = false;
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            Class<?> clsLoadClass = contextClassLoader.loadClass("java.nio.file.Files");
            Class<?> clsLoadClass2 = contextClassLoader.loadClass("java.nio.file.Path");
            Class<?> clsLoadClass3 = contextClassLoader.loadClass("java.nio.file.attribute.FileAttribute");
            Class<?> clsLoadClass4 = contextClassLoader.loadClass("java.nio.file.LinkOption");
            f22566b = clsLoadClass.getMethod("isSymbolicLink", clsLoadClass2);
            f22567c = clsLoadClass.getMethod("delete", clsLoadClass2);
            f22571g = clsLoadClass.getMethod("readSymbolicLink", clsLoadClass2);
            Object objNewInstance = Array.newInstance(clsLoadClass3, 0);
            f22574j = objNewInstance;
            f22572h = clsLoadClass.getMethod("createSymbolicLink", clsLoadClass2, clsLoadClass2, objNewInstance.getClass());
            Object objNewInstance2 = Array.newInstance(clsLoadClass4, 0);
            f22573i = objNewInstance2;
            f22569e = clsLoadClass.getMethod("exists", clsLoadClass2, objNewInstance2.getClass());
            f22568d = File.class.getMethod("toPath", null);
            f22570f = clsLoadClass2.getMethod("toFile", null);
            z10 = true;
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
        }
        f22565a = z10;
    }

    public static boolean a() {
        return f22565a;
    }

    public static boolean b(File file) {
        try {
            return ((Boolean) f22566b.invoke(null, f22568d.invoke(file, null))).booleanValue();
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        } catch (InvocationTargetException e11) {
            throw new RuntimeException(e11);
        }
    }
}
