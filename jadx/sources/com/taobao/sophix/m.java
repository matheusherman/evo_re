package com.taobao.sophix;

import android.os.Build;
import com.stub.StubApp;
import com.taobao.sophix.core.dex.SophixNative;
import com.taobao.sophix.core.dex.hot.MethodReplace;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Enumeration;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class m implements o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f8477b = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private l f8478a = new l(j.f8458b.getClassLoader());

    public static boolean a() {
        s.c("HotDexManager", "isSupport", Boolean.valueOf(f8477b));
        return f8477b;
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        boolean z10 = false;
        if (i10 >= 31) {
            f8477b = false;
            return;
        }
        f8477b = true;
        if (i10 == 21 || i10 == 22) {
            for (String str : Build.SUPPORTED_64_BIT_ABIS) {
                if (str.equals("arm64-v8a")) {
                    f8477b = false;
                }
            }
        }
        if (SophixNative.initHotNative() && f8477b) {
            z10 = true;
        }
        f8477b = z10;
        if (z10) {
            f8477b = !h.a();
        }
    }

    @Override // com.taobao.sophix.o
    public boolean a(File file) throws w {
        boolean z10;
        char c10 = 2;
        s.c("HotDexManager", "patch", "sdk", Integer.valueOf(Build.VERSION.SDK_INT));
        File file2 = new File(file.getParentFile(), "hotfix-patch.odex");
        if (!file2.exists()) {
            z10 = true;
        } else if (g0.c(file2)) {
            s.a("HotDexManager", "patch", "verifyOpt odex is legal");
            z10 = false;
        } else {
            s.e("HotDexManager", "patch", "verifyOpt fail, try to delete opt file.");
            if (!file2.delete()) {
                s.b("HotDexManager", "patch", "verifyOpt fail to delete opt file.");
                throw new w(80, "verifyOpt fail to delete opt file");
            }
            z10 = true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            file.setReadOnly();
            DexFile dexFileLoadDex = DexFile.loadDex(file.getPath(), file2.getAbsolutePath(), 0);
            this.f8478a.a(dexFileLoadDex);
            s.c("HotDexManager", "patch", "loadDex time consumed(ms)", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
            if (z10) {
                g0.b(file2);
            }
            Enumeration enumerationInterface12 = StubApp.interface12(dexFileLoadDex);
            while (enumerationInterface12.hasMoreElements()) {
                String str = (String) enumerationInterface12.nextElement();
                try {
                    Class<?> cls = Class.forName(str, true, j.f8458b.getClassLoader());
                    try {
                        Class<?> cls2 = Class.forName(str, true, this.f8478a);
                        for (Constructor<?> constructor : cls2.getDeclaredConstructors()) {
                            if (constructor.getAnnotation(MethodReplace.class) != null) {
                                try {
                                    Constructor<?> declaredConstructor = cls.getDeclaredConstructor(a(constructor.getParameterTypes()));
                                    Object[] objArr = new Object[4];
                                    objArr[0] = "oldConstructor";
                                    objArr[1] = declaredConstructor;
                                    objArr[c10] = "newConstructor";
                                    objArr[3] = constructor;
                                    s.c("HotDexManager", "patch replaceMethod", objArr);
                                    SophixNative.replaceMethod(declaredConstructor, constructor);
                                } catch (NoSuchMethodException e10) {
                                    throw new w(83, e10);
                                }
                            }
                        }
                        Method[] declaredMethods = cls2.getDeclaredMethods();
                        int length = declaredMethods.length;
                        int i10 = 0;
                        while (i10 < length) {
                            Method method = declaredMethods[i10];
                            if (method.getAnnotation(MethodReplace.class) != null) {
                                try {
                                    Method declaredMethod = cls.getDeclaredMethod(method.getName(), a(method.getParameterTypes()));
                                    s.c("HotDexManager", "patch replaceMethod", "oldMethod", declaredMethod, "newMethod", method);
                                    SophixNative.replaceMethod(declaredMethod, method);
                                } catch (NoSuchMethodException e11) {
                                    throw new w(84, e11);
                                }
                            }
                            i10++;
                            c10 = 2;
                        }
                    } catch (ClassNotFoundException e12) {
                        throw new w(82, e12);
                    }
                } catch (Throwable unused) {
                    c10 = 2;
                }
            }
            return true;
        } catch (IOException e13) {
            throw new w(81, e13);
        }
    }

    private Class<?>[] a(Class<?>[] clsArr) {
        Class<?>[] clsArr2 = new Class[clsArr.length];
        for (int i10 = 0; i10 != clsArr.length; i10++) {
            Class<?> cls = clsArr[i10];
            try {
                cls = Class.forName(cls.getName());
            } catch (ClassNotFoundException unused) {
            }
            clsArr2[i10] = cls;
        }
        return clsArr2;
    }
}
